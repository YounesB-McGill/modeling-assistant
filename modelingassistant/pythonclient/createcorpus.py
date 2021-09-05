#!/usr/bin/env python3

from os import linesep as nl
from fileserdes import save_to_files
from corpus_definition import corpus
from learningcorpus import LearningCorpus, MistakeTypeCategory

MAX_NUM_OF_HASHES_IN_HEADING = 6  # See https://github.github.com/gfm/#atx-heading


def generate_python_mts(mtc: MistakeTypeCategory) -> str:
    """
    Generate mistake types from input mistake type category.
    """


def generate_markdown(lc: LearningCorpus) -> str:
    """
    Generate Markdown table-of-contents from input learning corpus.
    """
    def _nested_toc_output_for(mtc: MistakeTypeCategory, indentation: int) -> str:
        "Return the nested table of contents output for the input in a recursive way."
        return f'''{_make_toc_title(mtc.name, indentation)}{
            "".join([_nested_toc_output_for(sc, indentation + 3) for sc in mtc.subcategories])}{
            "".join([_make_toc_title(mt.name, indentation + 3) for mt in mtc.mistakeTypes])}'''

    def _nested_body_output_for(mtc: MistakeTypeCategory, indentation: int) -> str:
        "Return the nested body output for the input in a recursive way."
        return f'''{_make_body_title(mtc.name, indentation)}{
            "".join([_nested_body_output_for(sc, indentation + 1) for sc in mtc.subcategories])}{
            "".join([_make_body_title(mt.name, indentation + 1) for mt in mtc.mistakeTypes])}'''

    def _make_toc_title(name: str, indentation: int) -> str:
        return f'{indentation * " "}1. [{name}](#{dashify(name)})\n'

    def _make_body_title(name: str, indentation: int) -> str:
        hashes = indentation + 2
        cn = clean(name)
        return (f'{hashes * "#"} {cn}' if hashes <= MAX_NUM_OF_HASHES_IN_HEADING else f'**{cn}**') + "\n\n"

    return f'''{
        nl.join([_nested_toc_output_for(mtc, 0) for mtc in lc.topLevelMistakeTypeCategories()])
    }\n{nl.join([_nested_body_output_for(mtc, 0) for mtc in lc.topLevelMistakeTypeCategories()])}'''


def dashify(s: str) -> str:
    "Dashify the input string."
    return clean(s).replace(" ", "-").replace("/", "-").replace("--", "-").lower()


def clean(s: str) -> str:
    "Clean the input string."
    return s.replace("(", "").replace(")", "").replace(",", "").replace("yet incorrect", "")


def underscorify(s: str) -> str:
    """
    Underscorifies and capitalizes the given input string, omitting any information in parentheses.
    Example: "Extra (redundant) class" -> "EXTRA_CLASS"
    """


if __name__ == "__main__":
    "Main entry point."
    save_to_files({"modelingassistant.learningcorpus.dsl.instances/default.learningcorpus": corpus})
    print(f"Created learning corpus with {len(corpus.mistakeTypes())} mistake types.")
