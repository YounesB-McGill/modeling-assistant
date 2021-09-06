"""
Utility functions for the Modeling Assistant Python app.
This module must not depend on any other to avoid circular dependencies.
"""

from learningcorpus import MistakeTypeCategory, MistakeType


def mtc(n, s=None, **kwargs) -> MistakeTypeCategory:
    "Shorthand for MistakeTypeCategory initializer."
    return MistakeTypeCategory(name=n, supercategory=s, **kwargs)


def mt(n, d="", **kwargs) -> MistakeType:
    "Shorthand for MistakeType initializer."
    if not d:
        d = n
    return MistakeType(name=n, description=d, **kwargs)
