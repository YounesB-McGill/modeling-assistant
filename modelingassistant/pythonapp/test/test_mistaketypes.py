#!/usr/bin/env python3

# pylint: disable=wrong-import-position
"""
Module to test mistake types and categories.
"""

import os
import sys
from textwrap import dedent

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from learningcorpus import MistakeTypeCategory, MistakeType
from mistaketypes import MISSING_CLASS, SOFTWARE_ENGINEERING_TERM, CLASS_MISTAKES, CLASS_NAME_MISTAKES
from metatypes import CDM_METATYPES
from corpus import corpus, mts_by_priority
from corpus_definition import mts_by_priority as mts_by_priority_with_labels
from utils import COLOR, MistakeDetectionFormat, color_str

import mistaketypes

def test_get_mistake_type_and_mistake_type_category_by_names():
    """
    Test get mistake type and mistake type category by names.
    """
    class_mistakes_mtc_name = "Class mistakes"
    missing_class_mt_name = "Missing class"

    expected_wrong_class_mtc = MistakeTypeCategory(name=class_mistakes_mtc_name)

    expected_missing_class_mt = MistakeType(
        name=missing_class_mt_name,
        atomic=False,
        mistakeTypeCategory=expected_wrong_class_mtc,
        numStepsBeforeNotification=3,
        timeToAddress=None)

    actual_wrong_class_mtc: MistakeTypeCategory = mistaketypes.CLASS_MISTAKES
    actual_missing_class_mt: MistakeType = mistaketypes.MISSING_CLASS

    assert expected_wrong_class_mtc.name == actual_wrong_class_mtc.name

    assert expected_missing_class_mt.name == actual_missing_class_mt.name
    assert expected_missing_class_mt.atomic == actual_missing_class_mt.atomic
    assert (expected_missing_class_mt.mistakeTypeCategory.name ==
        actual_missing_class_mt.mistakeTypeCategory.name)

    assert actual_wrong_class_mtc.learningCorpus
    assert (actual_wrong_class_mtc.learningCorpus ==
        actual_missing_class_mt.mistakeTypeCategory.learningCorpus)



def test_learning_corpus_mistake_types_and_categories_hierarchy():
    """
    Verify mistake types and categories hierarchy in the default learning corpus instance used in mistaketypes.py.
    """
    learning_corpus = CLASS_MISTAKES.learningCorpus

    assert "Class mistakes" == CLASS_MISTAKES.name
    assert "Class name mistakes" == CLASS_NAME_MISTAKES.name
    assert "Missing class" == MISSING_CLASS.name
    assert "Software engineering term" == SOFTWARE_ENGINEERING_TERM.name

    """
    Verify all of these relationships:

                          Class mistakes: MistakeTypeCategory
                        /                                  \
        Class name mistakes: MistakeTypeCategory       Missing class: MistakeType
                       |
         Software engineering term: MistakeType
    """
    assert CLASS_NAME_MISTAKES in CLASS_MISTAKES.subcategories
    assert CLASS_NAME_MISTAKES.supercategory is CLASS_MISTAKES
    assert MISSING_CLASS in CLASS_MISTAKES.mistakeTypes
    assert MISSING_CLASS.mistakeTypeCategory is CLASS_MISTAKES
    assert SOFTWARE_ENGINEERING_TERM in CLASS_NAME_MISTAKES.mistakeTypes
    assert SOFTWARE_ENGINEERING_TERM.mistakeTypeCategory is CLASS_NAME_MISTAKES
    for mtc in [CLASS_MISTAKES, CLASS_NAME_MISTAKES]:
        assert mtc.learningCorpus is learning_corpus
    for mt in [MISSING_CLASS, SOFTWARE_ENGINEERING_TERM]:
        assert mt.mistakeTypeCategory.learningCorpus is learning_corpus


def test_mistake_type_priorities():
    """
    Verify that all mistake types are assigned a priority.
    """
    assert len(mts_by_priority) == len(set(mts_by_priority)) == len(CLASS_MISTAKES.learningCorpus.mistakeTypes())
    for mt in mts_by_priority:
        if mt:
            assert isinstance(mt, MistakeType)
            assert mt.priority


def test_mistake_type_formats():
    """
    Verify the validity of all mistake type formats.

    - There must be at least one student element or instructor element
    - Each element may have a descriptive prefix and must end with a valid CdmMetatype short name, eg, cls*
    - Each element is already in the `stud` or `inst` list, so it must not have another prefix with that name,
      since it will be added later
    - Within each of the student element and instructor element lists, there must be no duplicates
    - There is at most one variable argument (vararg) for each of the student element and instructor element lists,
      and it must be the last item
    - Mistakes types that start with "Extra" must have student elements and may have instructor elements
    - Mistakes types that start with "Missing" may have student elements (eg, Missing role name) and must have
      instructor elements
    - "sub_cls" cannot exist without "super_cls" and vice versa
    - "whole" cannot exist without "part" and vice versa
    - "source" cannot exist without "target" and vice versa
    """
    for mt in corpus.mistakeTypes():
        name: str = mt.name
        assert getattr(mt, "md_format", None), f"{name} has no MistakeDetectionFormat"
        mdf: MistakeDetectionFormat = mt.md_format
        assert mdf.stud or mdf.inst, f"{name} has no student or instructor elements"
        for e in (*mdf.stud, *mdf.inst):
            for prefix in ("stud", "inst"):
                assert not e.startswith(prefix), f'{name} MDF: {e} must not contain duplicate "{prefix}" prefix'
            assert e.split("_")[-1] in CDM_METATYPES, f"{name} MDF: {e} must be of a valid type"
        assert len(mdf.stud) == len(set(mdf.stud)), f"{name} has duplicate student elements"
        assert len(mdf.inst) == len(set(mdf.inst)), f"{name} has duplicate instructor elements"
        assert not any(s.endswith("*") for s in (mdf.stud[:-1] + mdf.inst[:-1])), f"{name} has an invalid vararg"
        if name.lower().startswith("extra"):
            assert mdf.stud, f"{name} has no student elements"
        if name.lower().startswith("missing"):
            assert mdf.inst, f"{name} has no instructor elements"
        for lst in (mdf.stud, mdf.inst):
            for e1, e2 in (("sub_cls", "super_cls"), ("whole", "part"), ("source", "target")):
                if e1 in lst:
                    assert e2 in lst, f'{name} has "{e1}" but no "{e2}"'
                if e2 in lst:
                    assert e1 in lst, f'{name} has "{e2}" but no "{e1}"'


def test_no_bad_highlighting():
    """
    Verify that a student solution element is highlighted only if there are student elements and
    that a problem statement element(s) is highlighted only if there are instructor elements.
    """
    for mt in corpus.mistakeTypes():
        mdf: MistakeDetectionFormat = mt.md_format
        if not mdf.inst:
            for fb in mt.feedbacks:
                assert not fb.highlightProblem, f"""Cannot highlight problem statement for {mt.name
                                                 } without instructor elements"""
        if not mdf.stud:
            for fb in mt.feedbacks:
                assert not fb.highlightSolution, f"Cannot highlight solution for {mt.name} without student elements"


def print_mistake_type_stats():
    "Print mistake type statistics to console."
    # pylint: disable=expression-not-assigned
    def print_mt(mt: MistakeType, indent: int = 0):
        "Print mistake type and show its priority and whether it has feedbacks."
        color = COLOR.CYAN if mt.feedbacks else COLOR.ORANGE
        print(color_str(color, f"{indent * ' '}{mt.name}") + color_str(COLOR.VIOLET, f" ({mt.priority})"))

    def print_mtc(mtc: MistakeTypeCategory, indent: int = 0):
        "Recursively print mistake type category and its subcategories."
        print(color_str(COLOR.BLUE, f"{indent * ' '}{mtc.name}"))
        [print_mt(mt, indent + 2) for mt in mtc.mistakeTypes]
        [print_mtc(c, indent + 2) for c in mtc.subcategories]

    [print_mtc(c) for c in CLASS_MISTAKES.learningCorpus.topLevelMistakeTypeCategories()]


def print_mistake_type_stats_md():
    "Print mistake type statistics for use in GitHub-Flavored Markdown."
    # pylint: disable=expression-not-assigned
    def print_mt(mt: MistakeType, indent: int = 0):
        "Print mistake type and show its priority and whether it has feedbacks."
        sign = "+" if mt.feedbacks else "-"
        print(f"{sign}{' ' * indent}{mt.name} ({mt.priority})")

    def print_mtc(mtc: MistakeTypeCategory, indent: int = 0):
        "Recursively print mistake type category and its subcategories."
        print(f" {' ' * indent}{mtc.name}")
        [print_mt(mt, indent + 2) for mt in mtc.mistakeTypes]
        [print_mtc(c, indent + 2) for c in mtc.subcategories]

    print("```diff")
    [print_mtc(c) for c in CLASS_MISTAKES.learningCorpus.topLevelMistakeTypeCategories()]
    print("```")


def print_mistake_type_stats_md_format_completion_status():
    "Print mistake detection format completion status for each mistake type."
    # pylint: disable=expression-not-assigned
    def print_mt(mt: MistakeType, indent: int = 0):
        "Print mistake type and show its priority and whether it has feedbacks."
        sign = "+" if hasattr(mt, "md_format") else "-"
        #print(f"{sign}{' ' * indent}{mt.name}")
        if not hasattr(mt, "md_format"):
            print(f"{sign}{' ' * indent}{mt.name}")

    def print_mtc(mtc: MistakeTypeCategory, indent: int = 0):
        "Recursively print mistake type category and its subcategories."
        print(f" {' ' * indent}{mtc.name}")
        [print_mt(mt, indent + 2) for mt in mtc.mistakeTypes]
        [print_mtc(c, indent + 2) for c in mtc.subcategories]

    print("```diff")
    [print_mtc(c) for c in corpus.topLevelMistakeTypeCategories()]
    print("```")


def print_mts_by_priority_with_labels_latex_table():
    "Print Mistake types by priority LaTeX table."
    tex = dedent("""\
        \\begin{table}[!h]
        %\\scriptsize
        \\caption{Mistake Types Sorted by Priority} \\medskip
        \\begin{tabular}{l}
        \\hline
        \\multicolumn{1}{c}{\\textbf{Mistake Types}} \\\\ \\hline
        """)
    processed_mt = False
    for e in mts_by_priority_with_labels:
        if isinstance(e, str):
            if processed_mt:
                tex = f"{tex.strip().removesuffix(',')}\n\\end{{tabular}} \\\\ \\hline\n"
            tex += f"\\begin{{tabular}}[c]{{@{{}}l@{{}}}}\\textbf{{{e}}} \\\\ \n"
        if isinstance(e, MistakeType):
            tex += f"{e.description}, \n"
            processed_mt = True
    tex = f"""{tex.strip().removesuffix(',')
              }\n\\end{{tabular}} \\\\ \\hline\n\\end{{tabular}}\n\\label{{tbl:mts}}\n\\end{{table}}"""
    print(tex)


if __name__ == "__main__":
    "Main entry point."
    print_mts_by_priority_with_labels_latex_table()
