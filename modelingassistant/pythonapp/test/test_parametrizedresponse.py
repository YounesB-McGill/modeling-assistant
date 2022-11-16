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
from collections.abc import Iterable
from string import digits
from textwrap import dedent

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from metatypes import Metatype, aggr, assoc, assocend, assocends, attr, attrs, cls
from classdiagram import Association, AssociationEnd, Class, NamedElement
from createcorpus import LatexGenerator, underscorify
from corpus import corpus
from corpusdefinition import attribute_misplaced, missing_association_name, missing_class, wrong_role_name
from parametrizedresponse import (comma_seperated_with_and, extract_params, parametrize_response,
                                  param_parts_before_dot, param_start_elem_type, param_valid,
                                  get_mapping_from_mistake_elem_descriptions_to_actual_mistake_elems, parse)
from utils import mt
from learningcorpus import MistakeElement, MistakeType, ParametrizedResponse
from modelingassistant import Mistake, SolutionElement


_PR_PARAM_PARSED_OUTPUT_FILE = "modelingassistant/pythonapp/test/pr_param_parsed_output.md"


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
    - `*` indicates a sequence of items. Only one sequence is allowed in each element list.

    Programmatic attributes are a metamodel property or a shorthand for it defined in parametrizedresponse.py.
    """
    # assert syntactic correctness
    for param, mt_ in get_pr_parameters_to_mistake_types().items():
        assert param_valid(param, mt_)
    # assert parameters in parametrized response text are actually contained in the mistake type's elements
    for mt_ in corpus.mistakeTypes():
        for pr in mt_.parametrized_responses():
            for param in extract_params(pr.text):
                for person in ("stud", "inst"):
                    if param.startswith(pers_ := f"{person}_"):
                        p = "student" if person == "stud" else "instructor"
                        assert (re.sub(r"\d+", "*", param.removeprefix(pers_).split(".")[0]) in
                                [str(e) for e in getattr(mt_, f"{p}Elements")]
                        ), f"Param {param} for {mt_.name} does not match mistake type element descriptions."


def test_pr_aggr():
    "Test parametrized response for a single aggregation."
    # Dummy mistake type used for testing
    wrong_aggr_name = mt("Wrong aggregation name", stud_inst="aggr", feedbacks=[wrong_aggr_name_pr :=
        ParametrizedResponse(text="The ${stud_aggr} aggregation should be renamed to ${inst_aggr}.")])
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
        f"The {attr.example.name} attribute does not belong in the {attr.example.eContainer().name} class.")


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


def test_all_pr_params_can_be_parsed():
    """
    Test that all possible PR parameters can logically be parsed and save them to file for manual verification of
    correctness.
    """
    # TODO Remove this debugging code once logic is more stable
    # param = "stud_assocend0.cls"
    # start_elem = param_start_elem_type(param, as_type=CdmMetatype).example
    # output = parse(param, start_elem)
    # print(f"{param = }")
    # print(f"cdm metatype = {param_start_elem_type(param, as_type=CdmMetatype).short_name}")
    # print(f"{start_elem = }")
    # print(f"{output = }")
    # assert False

    params_to_start_elem_and_parsed_output: dict[str, tuple[str, str]] = {}
    for param in get_pr_parameters_to_mistake_types():
        assert (start_elem := param_start_elem_type(param, as_type=Metatype).example), f"Invalid {start_elem = }"
        assert (parsed_output := parse(param, start_elem)), f"Invalid {parsed_output = }"
        assert isinstance(parsed_output, str) and "${" not in parsed_output
        if any((c in param) for c in digits[1:]):
            continue  # skip items with digits other than 0
        params_to_start_elem_and_parsed_output[param.split("_")[-1]] = (start_elem, parsed_output)

    pr_md = dedent("""\
        # Parametrized Response Parameters and Parsed Outputs

        This file contains the parsed output of all possible parametrized response parameters.
        It is used to verify correctness of the learning corpus parametrized responses as well as the parsing logic and
        is generated by the `test_all_pr_params_can_be_parsed()` test.
        The example domain model used in the test is defined in the `metatypes.py` file.
        To avoid repetition, parameter prefixes such as "stud_" have been omitted from this document.

        Parameter | Start Element(s) | Parsed Output
        --------- | ---------------- | -------------
        """)
    for param, start_elem_and_output in sorted(params_to_start_elem_and_parsed_output.items()):
        start_elem, parsed_output = start_elem_and_output
        if isinstance(start_elem, NamedElement):
            start_elem = start_elem.name
        elif isinstance(start_elem, Iterable):
            if start_elem and isinstance(start_elem[0], NamedElement):
                start_elem = comma_seperated_with_and(start_elem)
            else:  # these last 2 cases should not happen, but are useful for debugging
                start_elem = "[]"
        else:
            start_elem = getattr(start_elem, "name", str(start_elem))
        pr_md += f"{param} | {start_elem} | {parsed_output}\n"

    with open(_PR_PARAM_PARSED_OUTPUT_FILE, "w", encoding="utf-8") as f:
        f.write(pr_md)

    return pr_md


def test_get_mapping_from_mistake_elem_descriptions_to_actual_mistake_elems():
    "Test get_mapping_from_mistake_elem_descriptions_to_actual_mistake_elems() helper function."
    simple_mt = MistakeType(name="Simple mistake", studentElements=[MistakeElement(type=n) for n in "ab"])
    varargs_mt = MistakeType(
        name="Varargs mistake",
        studentElements=[MistakeElement(type=n.removesuffix("*"), many=n.endswith("*")) for n in ["a", "b", "c*"]])
    simple_mistake = Mistake(studentElements=[SolutionElement(element=Class(name=c)) for c in "ab"],
                             mistakeType=simple_mt)
    varargs_mistake = Mistake(studentElements=[SolutionElement(element=Class(name=c)) for c in "abxyz"],
                              mistakeType=varargs_mt)

    assert get_mapping_from_mistake_elem_descriptions_to_actual_mistake_elems(simple_mistake) == {
        "stud_a": simple_mistake.studentElements[0].element,
        "stud_b": simple_mistake.studentElements[1].element,
    }
    assert get_mapping_from_mistake_elem_descriptions_to_actual_mistake_elems(varargs_mistake) == {
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


def get_pr_parameters_to_mistake_types() -> dict[str, MistakeType]:
    "Return a dict of ParametrizedResponse parameters mapped to mistake types with mistake detection formats."
    return {param: mt_ for param, mt_ in get_all_pr_parameters().items()}


def get_number_of_mistake_types_with_parametrized_responses() -> int:
    "Return the number of mistake types with parametrized responses."
    result = 0
    for mt_ in corpus.mistakeTypes():
        for fb in mt_.feedbacks:
            if isinstance(fb, ParametrizedResponse):
                result += 1
                break
    return result


def get_latex_pr_param_parsed_output() -> str:
    "Return the latex code for the parsed output of all parametrized response parameters."
    tex = LatexGenerator.make_tex_table(test_all_pr_params_can_be_parsed())
    print(tex)
    return tex


def get_mdis4lc_human_validated_parametrized_responses_java_mapping_entries() -> str:
    """
    Return the mapping entries for the HumanValidatedParametrizedResponses.java file.

    Example entry:

    ```java
    entry(MISSING_ATTRIBUTE_TYPE, Set.of("The ${stud_attr.cls}.${stud_attr} attribute is missing something.",
        "The type of the ${stud_attr.cls}.${stud_attr} attribute should be ${inst_attr.type}.")),
    ```
    """
    entries = ""
    mts_to_prs: dict[MistakeType, str | list[str]] = {}
    for mt_ in corpus.mistakeTypes():
        for fb in mt_.feedbacks:
            if isinstance(fb, ParametrizedResponse):
                if mt_ not in mts_to_prs:
                    mts_to_prs[mt_] = fb.text
                else:
                    if isinstance(mts_to_prs[mt_], str):
                        mts_to_prs[mt_] = [mts_to_prs[mt_], fb.text]
                    else:
                        mts_to_prs[mt_].append(fb.text)

    for mt_, pr_text in sorted(mts_to_prs.items(), key=lambda pair: pair[0].name):
        name = underscorify(mt_.name)
        nl = "\n"
        if isinstance(pr_text, str):
            entries += f'      entry({name}, Set.of("{pr_text}")),\n'
        else:
            entries += f"""      entry({name}, Set.of("{f'",{nl}          "'.join(pr_text)}")),\n"""

    return entries.removesuffix(",\n")


if __name__ == "__main__":
    "Main entry point (used for debugging)."
    test_get_mapping_from_mistake_elem_descriptions_to_actual_mistake_elems()
