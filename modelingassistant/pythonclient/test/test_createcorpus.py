#!/usr/bin/env python3

# pylint: disable=wrong-import-position, missing-function-docstring
"""
Tests for the createcorpus module.
"""

from cgi import print_environ
import os
import sys
from textwrap import dedent

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from createcorpus import MarkdownGenerator, LatexGenerator
from constants import T
from corpus import effectuate_contextual_capitalization
from corpus_definition import lowercase_class_name, uppercase_attribute_name
from learningcorpus import ResourceResponse
from utils import fbs, mcq, mt


plural_attribute_copy_mt = mt(n="Plural attribute copy", feedbacks=fbs({
    4: ResourceResponse(learningResources=[mcq[
            "Pick the classes which are modeled correctly with Umple.",
            "class Student { courses; }",
            "class Folder { List<File> files; }",
        T: "class Restaurant { 1 -- * Employee; }",
    ]]),
}))


# Test Markdown generation

def test_md_make_quiz():
    expected_mt_with_quiz_md = dedent("""\
        ## Plural attribute copy
        
        Level 4: Resource response with List multiple-choice quiz:

        Pick the classes which are modeled correctly with Umple.
    
        - [ ] class Student { courses; }
        - [ ] class Folder { List<File> files; }
        - [x] class Restaurant { 1 -- * Employee; }""")
    actual_mt_with_quiz_md = MarkdownGenerator.make_mt_body(plural_attribute_copy_mt)
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


def test_tex_make_quiz():
    test_md_make_quiz()
    expected_mt_with_quiz_tex = dedent(R"""
        \section{Plural attribute copy}

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


if __name__ == "__main__":
    "Main entry point."
    test_tex_make_quiz()
