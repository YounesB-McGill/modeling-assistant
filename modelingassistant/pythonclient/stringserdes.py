"""
Module for custom, string-friendly pyecore items.
"""

from lxml.etree import Element, ElementTree, QName, fromstring, tostring
from pyecore.ecore import EProxy
from pyecore.resources.resource import  ResourceSet
from pyecore.resources.xmi import XMI, XMIOptions, XMIResource, XMI_URL, XSI

MA_USE_STRING_SERDES = "MA_USE_STRING_SERDES"


class StringEnabledResourceSet(ResourceSet):
    """
    Extension of a ResourceSet that allows the use of in-memory string resources to reduce disk I/O.
    """
    def create_string_resource(self):
        "Create a resource that can be used to store a string in-memory."
        resource = StringEnabledXMIResource()
        self.resources["dummy.modelingassistant"] = resource
        resource.resource_set = self
        resource.decoders.insert(0, self)
        return resource

    def get_string_resource(self, string: str, options=None):
        options = options or {}
        options[MA_USE_STRING_SERDES] = True

        resource = self.create_string_resource()
        try:
            resource.load_string(string, options=options)
        except Exception:
            self.remove_resource(resource)
            raise
        return resource


class StringEnabledXMIResource(XMIResource):
    """
    XMIResource used to load/save a model instance from/to a string instead of a file.
    The code is mostly copied from the pyecore library, but with modifications to
    use strings instead a file. 
    """
    def load_string(self, string: str, options=None):
        self.options = options or {}
        self.cache_enabled = True
        tree = fromstring(string, base_url="")  # TODO Setup URL
        xmlroot = tree #.getroot()
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

    def save_to_string(self, options=None) -> bytes:
        """
        Save resource to binary string.
        """
        self.options = options or {}
        self.prefixes.clear()
        self.reverse_nsmap.clear()

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
        # TODO Set pretty_print=False in production 
        return tostring(tree, pretty_print=True, xml_declaration=True, encoding=tree.docinfo.encoding)
