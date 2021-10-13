"""
Utility functions for the Modeling Assistant Python app.
This module must not depend on any other to avoid circular dependencies.
"""

from __future__ import annotations
from types import SimpleNamespace
from learningcorpus import MistakeTypeCategory, MistakeType, Feedback


COLOR = SimpleNamespace(VIOLET="\033[95m", BLUE="\033[94m", CYAN="\033[96m", GREEN="\033[92m", YELLOW="\033[93m",
                        ORANGE="\u001b[31;1m", RED="\033[91m", ENDC="\033[0m")

_mtc_subcats: dict[MistakeTypeCategory, list[MistakeTypeCategory]] = {}


def color_str(color: str, text: str) -> str:
    "Return the given text in the given color, useful for printing to console."
    return f"{color}{text}{COLOR.ENDC}"


def mtc(n, s=None, **kwargs) -> MistakeTypeCategory:
    "Shorthand for MistakeTypeCategory initializer."
    _mtc = MistakeTypeCategory(name=n, supercategory=s, **kwargs)
    if "subcategories" in kwargs:
        _mtc_subcats[_mtc] = kwargs["subcategories"]
    return _mtc


def mt(n, d="", **kwargs) -> MistakeType:
    """
    Shorthand for MistakeType initializer.

    n: name of the mistake type
    d: description of the mistake type
    """
    if n == d:
        print(f"Warning: name and description are identical for mistake type {n}")
    if not d:
        d = n
    return MistakeType(name=n, description=d, **kwargs)


def fbs(fbs_by_level: dict[int, Feedback | list[Feedback]]) -> list[Feedback]:
    """
    Shorthand for Feedback initializer.

    fbs_by_level: dictionary of feedbacks, keyed by the feedback level
    """
    feedbacks = []
    for level, fb_s in fbs_by_level.items():
        if isinstance(fb_s, list):
            for fb in fb_s:
                fb.level = level
                feedbacks.append(fb)
        else:
            fb: Feedback = fb_s
            fb.level = level
            feedbacks.append(fb)
    return feedbacks
