#!/usr/bin/env python3
# pylint: disable=wrong-import-position

"""
Tests for parametrized responses.
"""

import os
import re
import sys

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from cdmmetatypes import assoc, cls
from classdiagram import Class
from corpus import corpus
from corpus_definition import missing_association_name, missing_class
from feedback import parametrize_response
from learningcorpus import MistakeType, ParametrizedResponse
from modelingassistant import Mistake, SolutionElement


VALID_TYPES = ("aggr", "assoc", "assocend", "attr", "cls", "compos", "enum", "enumitem", "qualassoc")


def test_prs_correctly_specified():
    """
    Ensure that parametrized responses are correctly specified.

    Each parameter must be parsable to a value that can be converted to a string and substituted into the response.

    Numbers, `_`, `.`, and `*` have special meanings:
    - [0-9] mean "get the nth item of the subscriptable"
    - `_` is a separator, eg, `stud_sub_cls` means "student subclass". Each parameter must start with `stud` or `inst`
      and end with a valid type
    - `.` is used to get the attribute of an object just like in Python. If no prespecified parameter is found,
      Python's `getattr` is used to get the attribute.
    - `*` indicates a sequence of items. Only one sequence is allowed in each MistakeDetectionFormat list.

    programmatic attributes:
    cls: classifier when invoked on an AssociationEnd
    """
    def validate_param(param: str, mt: MistakeType):
        part_before_dot = param.split(".")[0]
        _split = part_before_dot.split("_")
        person, type_ = _split[0], re.sub(r"[\*\d]+$", "", _split[-1])
        assert person in ("stud", "inst"), f'{param} for {mt.name} does not start with "stud" or "inst"'
        assert type_ in VALID_TYPES, f"{param} for {mt.name} does not end with a valid type"

    for param, mt in get_pr_parameters_for_mistake_types_with_md_formats().items():
        validate_param(param, mt)


def test_pr_assoc():
    "Test parametrized response for a single association."
    # Assume this is returned from the Mistake Detection System
    missing_assoc_name_mistake = Mistake(instructorElements=[SolutionElement(element=assoc.example)],
                                         mistakeType=missing_association_name)
    missing_assoc_name_pr = missing_association_name.parametrized_responses()[0]
    pr_result = parametrize_response(missing_assoc_name_pr, missing_assoc_name_mistake)
    assert pr_result
    assert "${" not in pr_result
    assert pr_result == f"This association should be named {assoc.example.name}."


def test_pr_cls():
    "Test parametrized response for a single class."
    missing_class_mistake = Mistake(instructorElements=[SolutionElement(element=cls.example)],
                                    mistakeType=missing_class)
    missing_class_pr = missing_class.parametrized_responses()[0]
    pr_result = parametrize_response(missing_class_pr, missing_class_mistake)
    assert pr_result
    assert "${" not in pr_result
    assert pr_result == f"Remember to add the {cls.example.name} class."


def test_pr_missing_class():
    """
    Test parametrized response for missing class mistake.
    Note that for the time being, this test is a duplicate of another test above. In the future, tests should cover
    all mistake types explicitly, and the assertions may be different.
    """
    missing_class_name = "Airplane"
    missing_class_mistake = Mistake(instructorElements=[SolutionElement(element=Class(name=missing_class_name))],
                                    mistakeType=missing_class)
    missing_class_pr = missing_class.parametrized_responses()[0]
    pr_result = parametrize_response(missing_class_pr, missing_class_mistake)
    assert pr_result
    assert "${" not in pr_result
    assert pr_result == f"Remember to add the {missing_class_name} class."


def get_all_pr_parameters() -> dict[str, MistakeType]:
    """
    Return a dict of all ParametrizedResponse parameters mapped to their mistake types. Note that a parameter may be
    shared by multiple mistake types. An assertion is performed to ensure each response contains at least one parameter.
    """
    prs = {}
    pattern = re.compile(r"\$\{(?P<param>.*?)\}")
    for mt in corpus.mistakeTypes():
        for pr in mt.parametrized_responses():
            matches = re.finditer(pattern, pr.text)
            assert matches, f"""The parametrized response for mistake type {pr.mistakeType} with text {pr.text
                             } does not contain any parameters."""
            for match_ in matches:
                prs[match_.group("param")] = mt
    return prs


def get_pr_parameters_for_mistake_types_with_md_formats() -> dict[str, MistakeType]:
    "Return a dict of ParametrizedResponse parameters mapped to mistake types with mistake detection formats."
    return {param: mt for param, mt in get_all_pr_parameters().items() if hasattr(mt, "md_format")}


def get_number_of_mistake_types_with_parametrized_responses() -> int:
    "Return the number of mistake types with parametrized responses."
    result = 0
    for mt in corpus.mistakeTypes():
        for fb in mt.feedbacks:
            if isinstance(fb, ParametrizedResponse):
                result += 1
                break
    return result


if __name__ == "__main__":
    "Main entry point (used for debugging)."
    print("\n".join(get_pr_parameters_for_mistake_types_with_md_formats().keys()))
