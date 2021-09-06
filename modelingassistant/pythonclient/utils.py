"""
Utility functions for the Modeling Assistant Python app.
This module must not depend on any other to avoid circular dependencies.
"""

from learningcorpus import MistakeTypeCategory, MistakeType

_mtc_subcats: dict[MistakeTypeCategory, list[MistakeTypeCategory]] = {}


def mtc(n, s=None, **kwargs) -> MistakeTypeCategory:
    "Shorthand for MistakeTypeCategory initializer."
    _mtc = MistakeTypeCategory(name=n, supercategory=s, **kwargs)
    if "subcategories" in kwargs:
        _mtc_subcats[_mtc] = kwargs["subcategories"]
    return _mtc


def mt(n, d="", **kwargs) -> MistakeType:
    "Shorthand for MistakeType initializer."
    if not d:
        d = n
    return MistakeType(name=n, description=d, **kwargs)
