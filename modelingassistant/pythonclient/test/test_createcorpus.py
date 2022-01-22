#!/usr/bin/env python3

# pylint: disable=wrong-import-position, unused-import, missing-function-docstring
"""
Tests for the createcorpus module.
"""
# Some of the "unused import" warnings below are false positives
import ast
import inspect
import os
import re
import sys
from re import Match
from os import linesep as nl
from textwrap import dedent
from types import SimpleNamespace

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from createcorpus import generate_tex, clean
from corpus import corpus, effectuate_contextual_capitalization
from corpus_definition import lowercase_class_name, uppercase_attribute_name
from learningcorpus import MistakeType, MistakeTypeCategory


# Extract inner functions from createcorpus.generate_tex() and store them in gen_tex to test them below
# This needs to be done at the global level
# extract top-level CONSTANTS
for child in next(ast.iter_child_nodes((ast.parse(inspect.getsource(generate_tex))))).body:
    if isinstance(child, ast.Assign):
        exec(ast.unparse(child))  # pylint: disable=exec-used
    if isinstance(child, ast.FunctionDef):
        break

# store functions in gen_tex
gen_tex = {}
for ast_node in ast.walk(ast.parse(inspect.getsource(generate_tex))):
    if isinstance(ast_node, ast.FunctionDef):
        exec(ast.unparse(ast_node))  # pylint: disable=exec-used
        gen_tex[ast_node.name] = globals()[ast_node.name]

# convert to SimpleNamespace to allow using dot notation (e.g. gen_tex.process_row instead of gen_tex["process_row"])
gen_tex = SimpleNamespace(**gen_tex)


def test_inner_functions_extracted():
    assert gen_tex
    assert isinstance(gen_tex.process_row("row_data"), str)


def test_make_body_title():
    assert gen_tex.make_body_title("Class mistakes") == "\\section{Class mistakes}\n\n"
    assert gen_tex.make_body_title("Class name mistakes", 1) == "\\subsection{Class name mistakes}\n\n"
    assert gen_tex.make_body_title("Plural class name", 2) == "\\subsubsection{Plural class name}\n\n"


def test_blockquote():
    assert gen_tex.blockquote("Please note these examples of correct vs incorrect class naming:") == dedent("""\
        \\begin{tabular}{|p{0.9\\linewidth}}
        Please note these examples of correct vs incorrect class naming:
        \\end{tabular} \\medskip

        """)


def test_sanitize():
    assert gen_tex.sanitize(
        "Please review the [Association](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture."
        ) == "Please review the \\textit{Association} part of the Class Diagram lecture."


def test_make_tex_table():
    assert gen_tex.make_tex_table(dedent("""\
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


def test_use_contextual_capitalization():
    # access corpus items dynamically to avoid overwriting the file
    for mt in (lowercase_class_name, uppercase_attribute_name):
        effectuate_contextual_capitalization(use_caps=True)
        assert any("Letter" in fb.text for fb in mt.feedbacks if getattr(fb, "text", None))
        effectuate_contextual_capitalization(use_caps=False)
        assert not any("Letter" in fb.text for fb in mt.feedbacks if getattr(fb, "text", None))


if __name__ == "__main__":
    "Main entry point."
