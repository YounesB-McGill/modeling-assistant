#!/usr/bin/env python3

"""
Script to create these Learning Corpus artifacts from corpus.py:

- default.learningcorpus: The default Learning Corpus instance in XMI format.
- mistaketypes.py: A Python file with all mistake types and categories in the default corpus.
- MistakeTypes.java: A Java class with all mistake types and categories in the default corpus.
- README_TOC.md: A Markdown table-of-contents file for the default Learning Corpus.
  A full learning corpus will be provided later.
"""

import re
from os import linesep as nl
from corpus import corpus
from fileserdes import save_to_files
from learningcorpus import MistakeTypeCategory

MAX_NUM_OF_HASHES_IN_HEADING = 6  # See https://github.github.com/gfm/#atx-heading
MAX_COLUMN_WIDTH = 120

PYTHON_MISTAKE_TYPES_FILE = "modelingassistant/pythonclient/mistaketypes.py"
JAVA_MISTAKE_TYPES_FILE = "modelingassistant/src/learningcorpus/mistaketypes/MistakeTypes.java"
LEARNING_CORPUS_MARKDOWN_FILE = "modelingassistant/corpus_descriptions/README_TOC.md"

PYTHON_HEADER = '''\
"""
This file contains all mistake types and categories.
"""

from constants import LEARNING_CORPUS_PATH
from fileserdes import load_lc
from learningcorpus import MistakeTypeCategory, MistakeType

corpus = load_lc(LEARNING_CORPUS_PATH)

# Populate dictionaries
MISTAKE_TYPE_CATEGORIES_BY_NAME: dict[str, MistakeTypeCategory] = {c.name: c for c in corpus.mistakeTypeCategories}
MISTAKE_TYPES_BY_NAME: dict[str, MistakeType] = {mt.name: mt for mt in corpus.mistakeTypes()}

# Short-name references to the above maps for greater code legibility
_MTCS = MISTAKE_TYPE_CATEGORIES_BY_NAME
_MTS = MISTAKE_TYPES_BY_NAME

# Mistake type categories
'''

JAVA_HEADER = """\
package learningcorpus.mistaketypes;

import java.util.HashMap;
import java.util.Map;
import learningcorpus.LearningCorpus;
import learningcorpus.MistakeType;
import learningcorpus.MistakeTypeCategory;

/**
 * This class contains all mistake types and categories.
 */
public class MistakeTypes {

  /** The path of the learning corpus instance with mistake types. */
  public static final String LEARNING_CORPUS_PATH =
      "../modelingassistant.learningcorpus.dsl.instances/default.learningcorpus";

  /** Map of mistake type categories by name. */
  public static final Map<String, MistakeTypeCategory> MISTAKE_TYPE_CATEGORIES_BY_NAME =
      new HashMap<String, MistakeTypeCategory>();

  /** Map of mistake types by name. */
  public static final Map<String, MistakeType> MISTAKE_TYPES_BY_NAME = new HashMap<String, MistakeType>();

  // Short-name references to the above maps for greater code legibility
  private static final Map<String, MistakeTypeCategory> MTCS = MISTAKE_TYPE_CATEGORIES_BY_NAME;
  private static final Map<String, MistakeType> MTS = MISTAKE_TYPES_BY_NAME;

  static {
    var learningCorpus = LearningCorpus.fromFile(LEARNING_CORPUS_PATH);

    learningCorpus.getMistakeTypeCategories().forEach(mtc ->
        MISTAKE_TYPE_CATEGORIES_BY_NAME.put(mtc.getName(), mtc));

    learningCorpus.getMistakeTypes().forEach(mt ->
        MISTAKE_TYPES_BY_NAME.put(mt.getName(), mt));
  }


  // Mistake type categories

"""


def generate_python():
    """
    Generate Python file with all mistake types and categories.
    """
    result = PYTHON_HEADER

    for mtc in corpus.mistakeTypeCategories:
        lhs = f"{underscorify(mtc.name)}: MistakeTypeCategory"
        rhs = f'_MTCS["{mtc.name}"]'
        mtc_decl = f"{lhs} = {rhs}"
        if len(mtc_decl) < MAX_COLUMN_WIDTH:
            result += f"{mtc_decl}\n"
        else:
            result += f"{lhs} = \\\n    {rhs}\n"

    result += "\n# Mistake types\n"

    for mt in corpus.mistakeTypes():
        lhs = f"{underscorify(mt.name)}: MistakeType"
        rhs = f'_MTS["{mt.name}"]'
        mt_decl = f"{lhs} = {rhs}"
        if len(mt_decl) < MAX_COLUMN_WIDTH:
            result += f"{mt_decl}\n"
        else:
            result += f"{lhs} = \\\n    {rhs}\n"

    with open(PYTHON_MISTAKE_TYPES_FILE, "w") as f:
        f.write(result)


def generate_python_mts(mtc: MistakeTypeCategory) -> str:
    """
    Generate mistake types from input mistake type category, eg, "missing_class := mt(n="Missing class"),"
    """
    if not mtc.mistakeTypes:
        return ""
    return f''', mistakeTypes=[\n{[
        nl.join(f'{8 * " "}{underscorify(mt.name)} := mt(n={nl}{mt.name}{nl}),')
        for mt in mtc.mistakeTypes]}\n    ]'''


def generate_java():
    """
    Generate Java class with all mistake types and categories.
    """
    result = JAVA_HEADER

    for mtc in corpus.mistakeTypeCategories:
        result += f'  /** The {mtc.name.lower()} mistake type category. */\n'
        lhs = f'  public static final MistakeTypeCategory {underscorify(mtc.name)}'
        rhs = f'MTCS.get("{mtc.name}");'
        mtc_decl = f'{lhs} = {rhs}'
        if len(mtc_decl) <= MAX_COLUMN_WIDTH:
            result += f'{mtc_decl}\n\n'
        else:
            result += f'{lhs} =\n      {rhs}\n\n'

    result += "\n  // Mistake types\n\n"

    for mt in corpus.mistakeTypes():
        result += f'  /** The {mt.name.lower()} mistake type. */\n'
        lhs = f'  public static final MistakeType {underscorify(mt.name)}'
        rhs = f'MTS.get("{mt.name}");'
        mt_decl = f'{lhs} = {rhs}'
        if len(mt_decl) <= MAX_COLUMN_WIDTH:
            result += f'{mt_decl}\n\n'
        else:
            result += f'{lhs} =\n      {rhs}\n\n'

    result += "}\n"

    with open(JAVA_MISTAKE_TYPES_FILE, "w") as f:
        f.write(result)


def generate_markdown():
    """
    Generate Markdown table-of-contents from input learning corpus.
    """
    def nested_toc_output_for(mtc: MistakeTypeCategory, indentation: int) -> str:
        "Return the nested table of contents output for the input in a recursive way."
        return f'''{make_toc_title(mtc.name, indentation)}{
            "".join([nested_toc_output_for(sc, indentation + 3) for sc in mtc.subcategories])}{
            "".join([make_toc_title(mt.name, indentation + 3) for mt in mtc.mistakeTypes])}'''

    def nested_body_output_for(mtc: MistakeTypeCategory, indentation: int) -> str:
        "Return the nested body output for the input in a recursive way."
        return f'''{make_body_title(mtc.name, indentation)}{
            "".join([nested_body_output_for(sc, indentation + 1) for sc in mtc.subcategories])}{
            nl.join([make_body_title(mt.name, indentation + 1) for mt in mtc.mistakeTypes])}\n'''

    def make_toc_title(name: str, indentation: int) -> str:
        return f'{indentation * " "}1. [{name}](#{dashify(name)})\n'

    def make_body_title(name: str, indentation: int) -> str:
        hashes = indentation + 2
        cn = clean(name)
        return (f'{hashes * "#"} {cn}' if hashes <= MAX_NUM_OF_HASHES_IN_HEADING else f'**{cn}**') + "\n\n"

    md = f'''{
        nl.join([nested_toc_output_for(mtc, 0) for mtc in corpus.topLevelMistakeTypeCategories()])
    }\n{nl.join([nested_body_output_for(mtc, 0) for mtc in corpus.topLevelMistakeTypeCategories()])}'''

    with open(LEARNING_CORPUS_MARKDOWN_FILE, "w") as f:
        f.write(md)


def dashify(s: str) -> str:
    "Dashify the input string."
    return clean(s).replace(" ", "-").replace("/", "-").replace("--", "-").lower()


def clean(s: str) -> str:
    "Clean the input string."
    s = s.replace("(", "").replace(")", "").replace(",", "").replace("yet incorrect", "")
    return re.sub(r"\s+", " ", s).strip()


def underscorify(s: str) -> str:
    """
    Underscorifies and capitalizes the given input string, omitting any information in parentheses.
    Example: "Extra (redundant) class" -> "EXTRA_CLASS"
    """
    s = re.sub(r"\((.+?)\)", "", s).strip().replace("/", "_").replace("-", "_")
    s = re.sub(r"\s+", "_", s)
    return re.sub(r"_+", "_", s).upper()


if __name__ == "__main__":
    "Main entry point."
    save_to_files({"modelingassistant.learningcorpus.dsl.instances/default.learningcorpus": corpus})
    print(f"Created learning corpus with {len(corpus.mistakeTypes())} mistake types.")
    generate_python()
    generate_java()
    generate_markdown()
