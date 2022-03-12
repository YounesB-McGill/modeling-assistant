#!/usr/bin/env python3
# pylint: disable=wrong-import-position

"""
Tests for parametrized responses.

Note that some of the examples are somewhat contrived, since the focus of the tests is on the correctness of the
parametrized responses and not the correctness of the example domain models.
"""

import os
import re
import sys

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from cdmmetatypes import aggr, assoc, assocend, assocends, attr, attrs, cls, compos, enum, enumitem
from classdiagram import Association, AssociationEnd, Class
from corpus import corpus
from corpus_definition import attribute_misplaced, missing_association_name, missing_class, wrong_role_name
from parametrizedresponse import (extract_params, get_mdf_items_to_mistake_elem_dict, parametrize_response,
                                  param_parts_before_dot, param_valid)
from utils import mdf, mt
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
    for param, mt_ in get_pr_parameters_for_mistake_types_with_md_formats().items():
        assert param_valid(param, mt_)


def test_pr_aggr():
    "Test parametrized response for a single aggregation."
    # Dummy mistake type used for testing
    wrong_aggr_name = mt("Wrong aggregation name", feedbacks=[wrong_aggr_name_pr := ParametrizedResponse(
        text="The ${stud_aggr} aggregation should be renamed to ${inst_aggr}.")])
    wrong_aggr_name.md_format = mdf(["aggr"], ["aggr"])
    # Assume this mistake is returned from the Mistake Detection System
    wrong_aggr_name_mistake = Mistake(instructorElements=[SolutionElement(element=aggr.example)],
                                      studentElements=[SolutionElement(element=Association(ends=(stud_aes := [
                                          AssociationEnd(classifier=Class(name=n)) for n in ("Bad", "Name")])))],
                                      mistakeType=wrong_aggr_name)
    pr_result = parametrize_response(wrong_aggr_name_pr, wrong_aggr_name_mistake)
    assert pr_result
    assert "${" not in pr_result
    inst_cls0, inst_cls1 = (ae.classifier.name for ae in aggr.example.ends)
    stud_cls0, stud_cls1 = (ae.classifier.name for ae in stud_aes)
    assert pr_result == f"The {stud_cls0}_{stud_cls1} aggregation should be renamed to {inst_cls0}_{inst_cls1}."


def test_pr_assoc():
    "Test parametrized response for a single association."
    missing_assoc_name_mistake = Mistake(instructorElements=[SolutionElement(element=assoc.example)],
                                         studentElements=[SolutionElement(element=Association())],
                                         mistakeType=missing_association_name)
    missing_assoc_name_pr = missing_association_name.parametrized_responses()[0]
    pr_result = parametrize_response(missing_assoc_name_pr, missing_assoc_name_mistake)
    assert pr_result
    assert "${" not in pr_result
    cls0, cls1 = (ae.classifier.name for ae in assoc.example.ends)
    assert pr_result == f"This association should be named {cls0}_{cls1}."


def test_pr_assoc_end():
    "Test parametrized response for a single association end."
    wrong_role_name_mistake = Mistake(instructorElements=[SolutionElement(element=assocends.example[1])],
                                      studentElements=[SolutionElement(element=assocend.example)],
                                      mistakeType=wrong_role_name)
    wrong_role_name_pr = wrong_role_name.parametrized_responses()[0]
    pr_result = parametrize_response(wrong_role_name_pr, wrong_role_name_mistake)
    assert pr_result
    assert "${" not in pr_result
    assert pr_result == f"The {assocend.example.name} role name is not correct."


def test_pr_attr():
    "Test parametrized response for a single attribute."
    attribute_misplaced_mistake = Mistake(studentElements=[SolutionElement(element=attr.example)],
                                          instructorElements=[SolutionElement(element=attrs.example[1])],
                                          mistakeType=attribute_misplaced)
    attribute_misplaced_pr = attribute_misplaced.parametrized_responses()[0]
    pr_result = parametrize_response(attribute_misplaced_pr, attribute_misplaced_mistake)
    assert pr_result
    assert "${" not in pr_result
    assert pr_result.startswith(
        f"The {attr.example.name} does not belong in the {attr.example.eContainer().name} class.")


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

# TODO Add test here to verify all possible PR parameters can be parsed (save to file), and re-enable assertions 


def test_get_mdf_items_to_mistake_elem_dict():
    "Test get_mdf_items_to_mistake_elem_dict() helper function."
    simple_mistake = Mistake(studentElements=[SolutionElement(element=Class(name=c)) for c in "ab"],
                             mistakeType=(simple_mt := MistakeType(name="Simple mistake")))
    varargs_mistake = Mistake(studentElements=[SolutionElement(element=Class(name=c)) for c in "abxyz"],
                              mistakeType=(varargs_mt := MistakeType(name="Varargs mistake")))
    simple_mt.md_format = mdf(["a", "b"], [])
    varargs_mt.md_format = mdf(["a", "b", "c*"], [])

    assert get_mdf_items_to_mistake_elem_dict(simple_mistake) == {
        "stud_a": simple_mistake.studentElements[0].element,
        "stud_b": simple_mistake.studentElements[1].element,
    }
    assert get_mdf_items_to_mistake_elem_dict(varargs_mistake) == {
        "stud_a": varargs_mistake.studentElements[0].element,
        "stud_b": varargs_mistake.studentElements[1].element,
        "stud_c*": [varargs_mistake.studentElements[i].element for i in range(2, len(varargs_mistake.studentElements))],
    }


def test_extract_params():
    "Test extract_params() helper function."
    assert extract_params("Example without params") == []
    assert extract_params("Example with one ${stud_aggr}") == ["stud_aggr"]
    assert extract_params("Example ${stud_cls} and ${stud_compos.end1.cls} and even ${inst_assoc.cls*}.") == [
        "stud_cls", "stud_compos.end1.cls", "inst_assoc.cls*"]


def test_param_parts_before_dot():
    "Test param_parts_before_dot() helper function."
    assert param_parts_before_dot([]) == []
    assert param_parts_before_dot(["stud_cls"]) == ["stud_cls"]
    assert param_parts_before_dot(
        ["stud_cls", "stud_attr.cls", "stud_compos.end1.cls"]) == ["stud_cls", "stud_attr", "stud_compos"]


def get_all_pr_parameters() -> dict[str, MistakeType]:
    """
    Return a dict of all ParametrizedResponse parameters mapped to their mistake types. Note that a parameter may be
    shared by multiple mistake types. An assertion is performed to ensure each response contains at least one parameter.
    """
    prs = {}
    pattern = re.compile(r"\$\{(?P<param>.*?)\}")
    for mt_ in corpus.mistakeTypes():
        for pr in mt_.parametrized_responses():
            matches = re.finditer(pattern, pr.text)
            assert matches, f"""The parametrized response for mistake type {pr.mistakeType} with text {pr.text
                             } does not contain any parameters."""
            for match_ in matches:
                prs[match_.group("param")] = mt_
    return prs


def get_pr_parameters_for_mistake_types_with_md_formats() -> dict[str, MistakeType]:
    "Return a dict of ParametrizedResponse parameters mapped to mistake types with mistake detection formats."
    return {param: mt_ for param, mt_ in get_all_pr_parameters().items() if hasattr(mt_, "md_format")}


def get_number_of_mistake_types_with_parametrized_responses() -> int:
    "Return the number of mistake types with parametrized responses."
    result = 0
    for mt_ in corpus.mistakeTypes():
        for fb in mt_.feedbacks:
            if isinstance(fb, ParametrizedResponse):
                result += 1
                break
    return result


if __name__ == "__main__":
    "Main entry point (used for debugging)."
    #print("\n".join(sorted([k[5:] for k in get_pr_parameters_for_mistake_types_with_md_formats().keys() if "." in k])))
    #test_get_mdf_items_to_mistake_elem_dict()
    test_pr_assoc()
