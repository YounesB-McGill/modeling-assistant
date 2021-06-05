"""
Module for custom, string-friendly pyecore items.
"""

from lxml.etree import fromstring, parse
from pyecore.ecore import EProxy
from pyecore.resources import resource
from pyecore.resources.resource import  ResourceSet, URI, URIConverter
from pyecore.resources.xmi import XMI, XMIResource, XSI

MA_USE_STRING_SERDES = "MA_USE_STRING_SERDES"


class StringEnabledResourceSet(ResourceSet):
    """
    Extension of a ResourceSet that allows the use of in-memory string resources to reduce disk I/O.
    """
    def create_string_resource(self):
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
