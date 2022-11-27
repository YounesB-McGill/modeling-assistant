#!/usr/bin/env python3

# pylint: disable=wrong-import-position, missing-function-docstring
"""
Tests for the createcorpus module.
"""

import json
import os
import sys
from textwrap import dedent

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from createcorpus import MarkdownGenerator, LatexGenerator, underscorify
from constants import MISTAKE_ELEMS_JSON_FILE, T
from corpus import corpus, effectuate_contextual_capitalization
from corpusdefinition import lowercase_class_name, uppercase_attribute_name
from learningcorpus import MistakeElement, MistakeType, ResourceResponse
from utils import fbs, fitb, mcq, mt


plural_attribute_copy_mt = mt(n="Plural attribute copy", stud_inst="attr", feedbacks=fbs({
    4: ResourceResponse(learningResources=[mcq[
           "Pick the classes which are modeled correctly with Umple.",
           "class Student { courses; }",
           "class Folder { List<File> files; }",
        T: "class Restaurant { 1 -- * Employee; }",
    ]]),
}))

extra_generalization_copy_mt = mt(n="Extra generalization copy", stud=["sub_cls", "super_cls"], inst=[], feedbacks=fbs({
    5: ResourceResponse(learningResources=[inherit_checks_quiz := fitb(dedent("""\
        Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material
        and complete the following:

        The five checks for generalization are:"""),
        "Obeys the {isA rule}.",
        "Subclass must retain its {distinctiveness}.",
        "All {inherited features} must make sense in each subclass.",
        "Subclass differs from superclass and other subclasses in {behavior} or {structure}.",
        "Subclass must not be {an instance}.")]),
}))


# Test Markdown generation

def test_md_make_multiple_choice_quiz():
    expected_mt_with_quiz_md = dedent("""\
        ## Plural attribute copy

        Student element: Attribute. Instructor element: Attribute.

        Level 4: Resource response with List multiple-choice quiz:

        Pick the classes which are modeled correctly with Umple.
    
        - [ ] class Student { courses; }
        - [ ] class Folder { List<File> files; }
        - [x] class Restaurant { 1 -- * Employee; }""")
    actual_mt_with_quiz_md = MarkdownGenerator.make_mt_body(plural_attribute_copy_mt).strip()  # ignore trailing \n
    assert actual_mt_with_quiz_md == expected_mt_with_quiz_md


def test_md_make_fill_in_the_blanks_quiz():
    expected_mt_with_quiz_md = dedent("""\
        ## Extra generalization copy

        Student elements: Subclass, Superclass.

        Level 5: Resource response with Fill-in-the-blanks quiz:
        
        Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material
        and complete the following:

        The five checks for generalization are:

        * Obeys the <ins>isA rule</ins>.
        * Subclass must retain its <ins>distinctiveness</ins>.
        * All <ins>inherited features</ins> must make sense in each subclass.
        * Subclass differs from superclass and other subclasses in <ins>behavior</ins> or <ins>structure</ins>.
        * Subclass must not be <ins>an instance</ins>.""")
    actual_mt_with_quiz_md = MarkdownGenerator.make_mt_body(extra_generalization_copy_mt).strip()
    assert actual_mt_with_quiz_md == expected_mt_with_quiz_md


# Test LaTeX generation

def test_make_tex_body_title():
    assert LatexGenerator.make_body_title("Class mistakes") == "\\section{Class mistakes}\n\n"
    assert LatexGenerator.make_body_title("Class name mistakes", 1) == "\\subsection{Class name mistakes}\n\n"
    assert LatexGenerator.make_body_title("Plural class name", 2) == "\\subsubsection{Plural class name}\n\n"


def test_tex_blockquote():
    assert LatexGenerator.blockquote("Please note these examples of correct vs incorrect class naming:") == dedent("""\
        \\begin{tabular}{|p{0.9\\linewidth}}
        Please note these examples of correct vs incorrect class naming:
        \\end{tabular} \\medskip

        """)


def test_tex_sanitize():
    assert LatexGenerator.sanitize(
        "Please review the [Association](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture."
        ) == "Please review the \\textit{Association} part of the Class Diagram lecture."


def test_tex_make_multiple_choice_quiz():
    test_md_make_multiple_choice_quiz()
    expected_mt_with_quiz_tex = dedent(R"""
        \section{Plural attribute copy}

        Student element: Attribute. Instructor element: Attribute. \medskip

        \noindent Level 4: Resource response with List multiple-choice quiz: \medskip

        \begin{tabular}{|p{0.9\linewidth}}

        Pick the classes which are modeled correctly with Umple.

        \begin{itemize}
            \item[$\square$] class Student \{ courses; \}
            \item[$\square$] class Folder \{ List$<$File$>$ files; \}
            \item[$\boxtimes$] class Restaurant \{ 1 -- * Employee; \}
        \end{itemize}

        \end{tabular} \medskip

        """).replace("\n", "", 1)  # remove first newline from raw string
    actual_mt_with_quiz_tex = LatexGenerator.make_mt_body(plural_attribute_copy_mt)
    assert actual_mt_with_quiz_tex == expected_mt_with_quiz_tex


def test_tex_make_fill_in_the_blanks_quiz():
    test_md_make_fill_in_the_blanks_quiz()  # need to create Markdown first and save it to _quizzes_to_md
    expected_mt_with_quiz_tex = dedent(R"""
        \section{Extra generalization copy}

        Student elements: Subclass, Superclass. \medskip

        \noindent Level 5: Resource response with Fill-in-the-blanks quiz: \medskip

        \begin{tabular}{|p{0.9\linewidth}}

        Please review the \textit{checks for proper generalization} lecture material
        and complete the following:

        The five checks for generalization are:

        \begin{itemize}
            \item Obeys the \underline{isA rule}.
            \item Subclass must retain its \underline{distinctiveness}.
            \item All \underline{inherited features} must make sense in each subclass.
            \item Subclass differs from superclass and other subclasses in \underline{behavior} or \underline{structure}.
            \item Subclass must not be \underline{an instance}.
        \end{itemize}

        \end{tabular} \medskip

        """).replace("\n", "", 1)  # remove first newline from raw string
    actual_mt_with_quiz_tex = LatexGenerator.make_mt_body(extra_generalization_copy_mt)
    assert actual_mt_with_quiz_tex == expected_mt_with_quiz_tex


def test_make_tex_table():
    assert LatexGenerator.make_tex_table(dedent("""\
        Please note these examples of correct vs incorrect class naming:
        :x: Examples to avoid | :heavy_check_mark: Good class names
        --- | ---
        pilot | Pilot
        Airplanes | Airplane 
        AirlineData | Airline
        """)) == dedent("""\
        \\begin{tabular}{|p{0.9\\linewidth}}
        Please note these examples of correct vs incorrect class naming:
        \\end{tabular} \\medskip

        \\begin{tabular}{ll}
        \\hline
        \\textcolor{red}{$\\times$} Examples to avoid & \\textcolor{ForestGreen}{\\checkmark} Good class names \\\\
        \\hline
        pilot & Pilot \\\\
        Airplanes & Airplane  \\\\
        AirlineData & Airline \\\\
        \\hline
        \\end{tabular} \\medskip

        """)


# Other corpus generation tests

def test_use_contextual_capitalization():
    # access corpus items dynamically to avoid overwriting the file
    for _mt in (lowercase_class_name, uppercase_attribute_name):
        effectuate_contextual_capitalization(use_caps=True)
        assert any("Letter" in fb.text for fb in _mt.feedbacks if getattr(fb, "text", None))
        effectuate_contextual_capitalization(use_caps=False)
        assert not any("Letter" in fb.text for fb in _mt.feedbacks if getattr(fb, "text", None))


def test_runtime_corpus_mistake_elements_match_json():
    "Test that the runtime corpus mistake elements match those found in the mistakeelems.json file."
    # pylint: disable=too-many-locals
    with open(MISTAKE_ELEMS_JSON_FILE, "r", encoding="utf-8") as f:
        json_mistake_elements: dict[str, list[list[str]]] = json.load(f)
    mt_names_to_mts: dict[str, MistakeType] = {underscorify(mt.name).lower(): mt for mt in corpus.mistakeTypes()}
    assert (r := len(json_mistake_elements)) == (j := len(mt_names_to_mts)), (
        f"Number of mistake types in runtime corpus ({r}) does not match number in mistakeelems.json ({j})")
    for mt_name, mistake_elements in json_mistake_elements.items():
        for i, person in enumerate(["student", "instructor"]):
            mt_ = mt_names_to_mts[mt_name]
            rmes: list[MistakeElement] = getattr(mt_, f"{person}Elements")
            for j, me_str in enumerate(mistake_elements[i]):
                rme = rmes[j]
                _split = me_str.split("_")
                _type = _split[-1]
                jme = MistakeElement(name="_".join(_split[:-1]), many=_type.endswith("*"), type=_type.removesuffix("*"))
                for attr in ("name", "many", "type"):
                    assert (rme_attr := getattr(rme, attr)) == (jme_attr := getattr(jme, attr)), (
                        f'''Mistake type "{mt_.name}" {person} element {j} {attr} mismatch: rme.{attr} = {rme_attr or
                         '""'}, jme.{attr} = {jme_attr or '""'}''')


if __name__ == "__main__":
    "Main entry point."
    test_runtime_corpus_mistake_elements_match_json()
