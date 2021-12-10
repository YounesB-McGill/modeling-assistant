# pylint: disable=attribute-defined-outside-init,too-many-instance-attributes

"""
Module for custom, string-friendly pyecore items.
"""

from __future__ import annotations

import re
import os

from lxml.etree import Element, ElementTree, QName, fromstring, tostring  # pylint: disable=no-name-in-module
from pyecore.ecore import EProxy
from pyecore.resources.resource import  Resource, ResourceSet, URI
from pyecore.resources.xmi import XMI, XMIOptions, XMIResource, XMI_URL, XSI

from serdes import set_static_class_for
from classdiagram import ClassDiagram
from constants import CLASS_DIAGRAM_MM, LEARNING_CORPUS_MM, MODELING_ASSISTANT_MM, LEARNING_CORPUS_PATH
from modelingassistant import ModelingAssistant

MA_USE_STRING_SERDES = "MA_USE_STRING_SERDES"

LC_FILENAME = os.path.basename(LEARNING_CORPUS_PATH)
LC_ABS_PATH = os.path.abspath(LEARNING_CORPUS_PATH)


class StringEnabledResourceSet(ResourceSet):
    """
    Extension of a ResourceSet that allows the use of in-memory string resources to reduce disk I/O.
    """
    def __init__(self):
        super().__init__()
        self.ma_ids_to_string_resources: dict[str, StringEnabledXMIResource] = {}
        for mm in [CLASS_DIAGRAM_MM, LEARNING_CORPUS_MM, MODELING_ASSISTANT_MM]:
            resource: Resource = self.get_resource(URI(mm))
            mm_root = resource.contents[0]
            self.metamodel_registry[mm_root.nsURI] = mm_root

    def create_string_resource(self) -> StringEnabledXMIResource:
        "Create a resource that can be used to store a string in-memory."
        resource = StringEnabledXMIResource()
        self.resources["dummy.modelingassistant"] = self.resources["dummy.cdm"] = resource
        resource.resource_set = self
        resource.decoders.insert(0, self)
        resource.use_uuid = True
        return resource

    def create_ma_str(self, ma: ModelingAssistant) -> str:
        "Create a string representation of a modeling assistant model."
        cdms = (sol.classDiagram for sol in ma.solutions)
        ma_id = ma._internal_id  # pylint: disable=protected-access
        if ma_id in self.ma_ids_to_string_resources:
            resource = self.ma_ids_to_string_resources[ma_id]
            resource.contents.clear()
        else:
            resource = self.create_string_resource()
            self.ma_ids_to_string_resources[ma_id] = resource
        resource.extend((ma, *cdms))
        return resource.save_to_string().decode()

    def get_string_resource(self, string: str | bytes, options=None) -> StringEnabledXMIResource:
        "Return a resource from the given string."
        options = options or {}
        options[MA_USE_STRING_SERDES] = True

        if isinstance(string, bytes):
            string = string.decode()
        ma_id = re.sub(r"""[\s\S]*<[Mm]odeling[Aa]ssistant[\s\S]*xmi:id=["'](?P<ma_id>.*?)["'][\s\S]*>[\s\S]*""",
                       r"\g<ma_id>", string)
        if ma_id in self.ma_ids_to_string_resources:
            resource = self.ma_ids_to_string_resources[ma_id]
            resource.contents.clear()
        else:
            resource = self.create_string_resource()
            self.ma_ids_to_string_resources[ma_id] = resource

        try:
            resource.load_string(string, options=options)

            # Set relative path as URI if not already set
            here_uri = URI(".")
            self.resources[here_uri.normalize()] = None
            resource._uri = resource._uri or here_uri  # pylint: disable=protected-access
            resource.uri = resource.uri or here_uri
        except Exception:
            self.remove_resource(resource)
            raise
        return resource

    def get_resource(self, uri, options=None):
        if uri and LC_FILENAME in uri.normalize() and LC_ABS_PATH in self.resources:
            return self.resources[LC_ABS_PATH]
        return super().get_resource(uri, options)

    def resolve(self, uri, from_resource=None):
        if isinstance(uri, str):
            uri = uri.removeprefix("file:")
        return super().resolve(uri, from_resource)


class StringEnabledXMIResource(XMIResource):
    """
    XMIResource used to load/save a model instance from/to a string instead of a file.
    The code is mostly copied from the pyecore library, but with modifications to
    use strings instead a file.
    """
    def load_string(self, string: str, options=None):
        "Load the given XMI string to this StringEnabledXMIResource."
        self.options = options or {}
        self.cache_enabled = True
        if not isinstance(string, bytes):
            string = string.encode("utf-8")
        tree = fromstring(string, base_url=".")
        xmlroot = tree
        self.prefixes.update(xmlroot.nsmap)
        self.reverse_nsmap = {v: k for k, v in self.prefixes.items()}

        self.xsitype = '{{{0}}}type'.format(self.prefixes.get(XSI))
        self.xmiid = '{{{0}}}id'.format(self.prefixes.get(XMI))
        self.schema_tag = '{{{0}}}schemaLocation'.format(
                            self.prefixes.get(XSI))

        # Decode the XMI
        if '{{{0}}}XMI'.format(self.prefixes.get(XMI)) == xmlroot.tag:
            real_roots = xmlroot
        else:
            real_roots = [xmlroot]

        def grouper(iterable):
            args = [iter(iterable)] * 2
            return zip(*args)

        self.schema_locations = {}
        schema_tag_list = xmlroot.attrib.get(self.schema_tag, '')
        for prefix, path in grouper(schema_tag_list.split()):
            if '#' not in path:
                path = path + '#'
            self.schema_locations[prefix] = EProxy(path, self)

        for root in real_roots:
            modelroot = self._init_modelroot(root)
            for child in root:
                self._decode_eobject(child, modelroot)

        if self.contents:
            self._decode_ereferences()

            content = self.contents[0]
            if options.get("use_static_classes", True):
                set_static_class_for(content)
                for e in content.eAllContents():
                    set_static_class_for(e)

    def save_to_string(self, options=None) -> bytes:
        """
        Save resource to binary string.
        """
        self.options = options or {}
        self.prefixes.clear()
        self.reverse_nsmap.clear()

        # Set relative path as URI if not already set
        self_rset = self.resource_set
        self.resource_set = None  # temporarily disable rset to avoid dereferencing nonexistant old URI
        self.uri = self.uri or URI(".")
        self.resource_set = self_rset

        serialize_default = self.options.get(XMIOptions.SERIALIZE_DEFAULT_VALUES, False)
        nsmap = {XMI: XMI_URL}

        if len(self.contents) == 1:
            root = self.contents[0]
            self.register_eobject_epackage(root)
            tmp_xmi_root = self._go_across(root, serialize_default)
        else:
            tag = QName(XMI_URL, 'XMI')
            tmp_xmi_root = Element(tag)
            for root in self.contents:
                root_node = self._go_across(root, serialize_default)
                tmp_xmi_root.append(root_node)

        # update nsmap with prefixes register during the nodes creation
        nsmap.update(self.prefixes)
        xmi_root = Element(tmp_xmi_root.tag, nsmap=nsmap)
        xmi_root[:] = tmp_xmi_root[:]
        xmi_root.attrib.update(tmp_xmi_root.attrib)
        xmi_version = QName(XMI_URL, 'version')
        xmi_root.attrib[xmi_version] = '2.0'
        tree = ElementTree(xmi_root)
        # TODO Set pretty_print=False in production  # pylint: disable=fixme
        return tostring(tree, pretty_print=True, xml_declaration=True, encoding=tree.docinfo.encoding)


# The StringEnabledResourceSet singleton instance
SRSET = StringEnabledResourceSet()


def str_to_cdm(cdm_str: str, use_static_classes: bool = True) -> ClassDiagram:
    "Load a class diagram from a string."
    resource = SRSET.get_string_resource(cdm_str)
    class_diagram: ClassDiagram = resource.contents[0]
    if use_static_classes:
        class_diagram.__class__ = ClassDiagram
        for e in class_diagram.eAllContents():
            set_static_class_for(e)
    return class_diagram


def str_to_modelingassistant(ma_str: str, use_static_classes: bool = True) -> ModelingAssistant:
    "Load a modeling assistant from a string."
    resource = SRSET.get_string_resource(ma_str)
    modeling_assistant: ModelingAssistant = resource.contents[0]
    if use_static_classes:
        modeling_assistant.__class__ = ModelingAssistant
        for e in modeling_assistant.eAllContents():
            set_static_class_for(e)
    return modeling_assistant
