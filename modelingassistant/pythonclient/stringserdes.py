# pylint: disable=attribute-defined-outside-init,too-many-instance-attributes

"""
Module for custom, string-friendly pyecore items.
"""

import os
from lxml.etree import Element, ElementTree, QName, fromstring, tostring  # pylint: disable=no-name-in-module
from pyecore.ecore import EProxy
from pyecore.resources.resource import  Resource, ResourceSet, URI
from pyecore.resources.xmi import XMI, XMIOptions, XMIResource, XMI_URL, XSI

from constants import CLASS_DIAGRAM_MM, LEARNING_CORPUS_MM, MODELING_ASSISTANT_MM, LEARNING_CORPUS_PATH
from serdes import set_static_class_for

MA_USE_STRING_SERDES = "MA_USE_STRING_SERDES"

LC_FILENAME = os.path.basename(LEARNING_CORPUS_PATH)
LC_ABS_PATH = os.path.abspath(LEARNING_CORPUS_PATH)


class StringEnabledResourceSet(ResourceSet):
    """
    Extension of a ResourceSet that allows the use of in-memory string resources to reduce disk I/O.
    """
    def __init__(self):
        super().__init__()
        for mm in [CLASS_DIAGRAM_MM, LEARNING_CORPUS_MM, MODELING_ASSISTANT_MM]:
            resource: Resource = self.get_resource(URI(mm))
            mm_root = resource.contents[0]
            self.metamodel_registry[mm_root.nsURI] = mm_root

    def create_string_resource(self):
        "Create a resource that can be used to store a string in-memory."
        resource = StringEnabledXMIResource()
        self.resources["dummy.modelingassistant"] = resource
        resource.resource_set = self
        resource.decoders.insert(0, self)
        resource.use_uuid = True
        return resource

    def get_string_resource(self, string: str, options=None):
        "Return a resource from the given string."
        options = options or {}
        options[MA_USE_STRING_SERDES] = True

        resource = self.create_string_resource()
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
        """
        Loads the given XMI string to this StringEnabledXMIResource.
        """
        self.options = options or {}
        self.cache_enabled = True
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
