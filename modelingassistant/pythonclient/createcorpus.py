#!/usr/bin/env python3

"""
Script to create these Learning Corpus artifacts from corpus.py:

- default.learningcorpus: The default Learning Corpus instance in XMI format.
- mistaketypes.py: A Python module with all mistake types and categories in the default corpus.
- MistakeTypes.java: A Java class with all mistake types and categories in the default corpus.
- README.md: A Markdown table-of-contents file for the default Learning Corpus.
"""

import os
import re
from abc import ABC, abstractmethod
from os import linesep as nl
from re import Match
from datetime import datetime

import cv2

from constants import LEARNING_CORPUS_PATH, MULTIPLE_FEEDBACKS_PER_LEVEL
from corpus import corpus
from fileserdes import save_to_file
from learningcorpus import (MistakeTypeCategory, MistakeType, Feedback, TextResponse, ParametrizedResponse,
                            ResourceResponse, Quiz)
from learningcorpusquiz import Blank, FillInTheBlanksQuiz, ListMultipleChoiceQuiz, NonBlank, TableMultipleChoiceQuiz
from utils import NonNoneDict


MAX_NUM_OF_HASHES_IN_HEADING = 6  # See https://github.github.com/gfm/#atx-heading
MAX_COLUMN_WIDTH = 120

PYTHON_MISTAKE_TYPES_FILE = "modelingassistant/pythonclient/mistaketypes.py"
JAVA_MISTAKE_TYPES_FILE = "modelingassistant/src/learningcorpus/mistaketypes/MistakeTypes.java"
CORPUS_DESCRIPTION_DIR = "modelingassistant/corpus_descriptions"
LEARNING_CORPUS_MARKDOWN_FILE = f"{CORPUS_DESCRIPTION_DIR}/README.md"
LEARNING_CORPUS_TEX_FILE = f"{CORPUS_DESCRIPTION_DIR}/learningcorpusdefs.tex"

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

JAVA_HEADER = f"""\
package learningcorpus.mistaketypes;

import java.util.HashMap;
import java.util.Map;
import learningcorpus.LearningCorpus;
import learningcorpus.MistakeType;
import learningcorpus.MistakeTypeCategory;

/**
 * This class contains all mistake types and categories.
 */
public class MistakeTypes {{

  /** The path of the learning corpus instance with mistake types. */
  public static final String LEARNING_CORPUS_PATH =
      "../{LEARNING_CORPUS_PATH}";

  /** Map of mistake type categories by name. */
  public static final Map<String, MistakeTypeCategory> MISTAKE_TYPE_CATEGORIES_BY_NAME = new HashMap<>();

  /** Map of mistake types by name. */
  public static final Map<String, MistakeType> MISTAKE_TYPES_BY_NAME = new HashMap<>();

  // Short-name references to the above maps for greater code legibility
  private static final Map<String, MistakeTypeCategory> MTCS = MISTAKE_TYPE_CATEGORIES_BY_NAME;
  private static final Map<String, MistakeType> MTS = MISTAKE_TYPES_BY_NAME;

  static {{
    var learningCorpus = LearningCorpus.fromFile(LEARNING_CORPUS_PATH);
    learningCorpus.getMistakeTypeCategories().forEach(mtc -> MISTAKE_TYPE_CATEGORIES_BY_NAME.put(mtc.getName(), mtc));
    learningCorpus.getMistakeTypes().forEach(mt -> MISTAKE_TYPES_BY_NAME.put(mt.getName(), mt));
  }}

  // Mistake type categories

"""

TEX_HEADER = f"""\
% Modeling Assistant Learning Corpus

% This tex file was generated automatically by the createcorpus script.
% Generation time: {datetime.now().strftime("%Y-%m-%d %H:%M:%S")}

\\textbf{{Legend:}}
In the textual responses, items in \\verb|${{this format}}| represent the parameters of
a parametrized response, which are computed and substituted at runtime from the general
template based on the specific mistake. Items [in square brackets] refer to optional
text which may or may not be included, depending on the student's knowledge.

"""

TEX_PR_TABLE = R"""
\begin{tabular}{lcccc}
\hline
\textbf{Solution} &
  \textbf{\begin{tabular}[c]{@{}c@{}}Roles\\ have\\ different\\ features\end{tabular}} &
  \textbf{\begin{tabular}[c]{@{}c@{}}Only one\\ role at\\ a time\end{tabular}} &
  \textbf{\begin{tabular}[c]{@{}c@{}}Different\\ roles\\ over time\end{tabular}} &
  \textbf{\begin{tabular}[c]{@{}c@{}}More than\\ one role\\ at the\\ same time\end{tabular}} \\ \hline
Enumeration         & $\square$   & $\boxtimes$ & $\boxtimes$ & $\square$   \\
Subclasses          & $\boxtimes$ & $\boxtimes$ & $\square$   & $\square$   \\
Associations        & $\square$   & $\boxtimes$ & $\boxtimes$ & $\boxtimes$ \\
Player-Role Pattern & $\boxtimes$ & $\boxtimes$ & $\boxtimes$ & $\boxtimes$ \\ \hline
\end{tabular} \bigskip


"""

QUIZ_DISPLAY_NAMES: dict[type, str] = {
    FillInTheBlanksQuiz: "Fill-in-the-blanks quiz",
    ListMultipleChoiceQuiz: "List multiple-choice quiz",
    TableMultipleChoiceQuiz: "Table multiple-choice quiz",
    Quiz: "Quiz",  # TODO: Remove this once we have a better way of handling Quiz subclasses
}

_quizzes_to_md: dict[Quiz, str] = NonNoneDict()


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

    with open(PYTHON_MISTAKE_TYPES_FILE, "w", encoding="utf-8") as f:
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
        result += f'  /** The category for {mtc.name.lower()}. */\n'
        lhs = f'  public static final MistakeTypeCategory {underscorify(mtc.name)}'
        rhs = f'MTCS.get("{mtc.name}");'
        mtc_decl = f'{lhs} = {rhs}'
        if len(mtc_decl) <= MAX_COLUMN_WIDTH:
            result += f'{mtc_decl}\n\n'
        else:
            result += f'{lhs} =\n      {rhs}\n\n'

    result += "\n  // Mistake types\n\n"

    for mt in corpus.mistakeTypes():
        result += f'  /** The {mt.description.lower()} mistake type. */\n'.replace(" isa ", " isA ")
        lhs = f'  public static final MistakeType {underscorify(mt.name)}'
        rhs = f'MTS.get("{mt.name}");'
        mt_decl = f'{lhs} = {rhs}'
        if len(mt_decl) <= MAX_COLUMN_WIDTH:
            result += f'{mt_decl}\n\n'
        else:
            result += f'{lhs} =\n      {rhs}\n\n'

    result += "}\n"

    with open(JAVA_MISTAKE_TYPES_FILE, "w", encoding="utf-8") as f:
        f.write(result)


def is_table(s: str) -> bool:
    "Return True if the input markdown string is a table."
    return "|" in s and all("|" in line for line in s.splitlines()[2:-2])


class TextualGenerator(ABC):
    "Abstract base class for textual generators."
    @classmethod
    def nested_body_output_for(cls, mtc: MistakeTypeCategory, indentation: int = 0) -> str:
        "Return the nested body output for the input in a recursive way."
        return f'''{cls.make_body_title(mtc.name, indentation)}{
            "".join([cls.nested_body_output_for(sc, indentation + 1) for sc in mtc.subcategories])}{
            nl.join([cls.make_mt_body(mt, indentation + 1) for mt in mtc.mistakeTypes])}\n'''

    @classmethod
    @abstractmethod
    def make_body_title(cls, name: str, indentation: int = 0) -> str:
        "Return the title of the body for the input, indented by the given amount."

    @classmethod
    @abstractmethod
    def make_mt_body(cls, mt: MistakeType, indentation: int = 0) -> str:
        "Return the body for the mistake type, indented by the given amount."

    @classmethod
    @abstractmethod
    def generate(cls) -> str:
        "Generate and return the output."

    @classmethod
    @abstractmethod
    def save_to_file(cls, filename: str = None):
        "Save the output to a file. Use the default location if no filename is given."


class MarkdownGenerator(TextualGenerator):
    """
    Generator for Markdown version of the learning corpus.
    """
    @classmethod
    def nested_toc_output_for(cls, mtc: MistakeTypeCategory, indentation: int = 0) -> str:
        "Return the nested table of contents output for the input in a recursive way."
        return f'''{cls.make_toc_title(mtc.name, indentation)}{
            "".join([cls.nested_toc_output_for(sc, indentation + 3) for sc in mtc.subcategories])}{
            "".join([cls.make_toc_title(mt.description, indentation + 3) for mt in mtc.mistakeTypes])}'''

    @classmethod
    def make_toc_title(cls, name: str, indentation: int = 0) -> str:
        "Return the title of the table of contents for the input, indented by the given amount."
        return f'{indentation * " "}1. [{name}](#{dashify(name)})\n'

    @classmethod
    def make_body_title(cls, name: str, indentation: int = 0) -> str:
        hashes = indentation + 2
        cn = clean(name)
        return (f'{hashes * "#"} {cn}' if hashes <= MAX_NUM_OF_HASHES_IN_HEADING else f'**{cn}**') + "\n\n"

    @classmethod
    def make_mt_body(cls, mt: MistakeType, indentation: int = 0) -> str:
        "Return the Markdown body of the output."
        result = cls.make_body_title(mt.description, indentation)
        levels = sorted(fb.level for fb in mt.feedbacks)
        for level in levels:
            if (level_header := f"Level {level}: ") not in result:
                result += level_header
            prev_fb = None
            for fb in mt.feedbacks:
                if fb.level != level:
                    continue
                match fb:
                    case Feedback(highlightProblem=True):
                        sp = "specific" if fb.level > 1 else "sentence in"
                        # use elem type here in the future if it can be made more specific, eg, enum instead of class
                        elem = "elements" if fb.level > 1 else "referring to item"
                        result += f"Highlight {sp} problem statement {elem}\n\n"
                    case Feedback(highlightSolution=True):
                        result += "Highlight solution\n\n"
                    case TextResponse() as resp:
                        if resp.text not in result:
                            result += f"Text response:\n\n> {resp.text}\n\n"
                    case ParametrizedResponse() as resp:
                        if resp.text not in result:
                            result += f"""{
                                '' if isinstance(prev_fb, ParametrizedResponse) else f'Parametrized response:{nl}'
                                }\n> {resp.text}\n\n"""
                    case ResourceResponse() as resp if resp.learningResources:
                        primary_rsc = resp.learningResources[0]
                        rsc_type = type(primary_rsc)
                        rsc_type_name = type(primary_rsc).__name__
                        if issubclass(rsc_type, Quiz) and rsc_type != Quiz:  # Quiz subclasses but not Quiz itself
                            content = f"""Resource response with {QUIZ_DISPLAY_NAMES[type(primary_rsc)]}:\n\n{
                                          primary_rsc.content}\n\n"""
                            if isinstance(primary_rsc, FillInTheBlanksQuiz):
                                for statement in primary_rsc.statements:
                                    content += "* "
                                    for component in statement.components:
                                        if isinstance(component, NonBlank):
                                            content += f"{component.text}"
                                        if isinstance(component, Blank):
                                            content += f"<ins>{component.correctAnswer}</ins>"
                                    content += "\n"
                            elif isinstance(primary_rsc, ListMultipleChoiceQuiz):
                                for choice in primary_rsc.choices:
                                    sel = "x" if choice in primary_rsc.correctChoices else " "
                                    content += f"- [{sel}] {choice.text}\n"
                            elif isinstance(primary_rsc, TableMultipleChoiceQuiz):
                                ...
                            content = content.strip()
                            result += (content + "\n\n") if content not in result else ""
                            _quizzes_to_md[primary_rsc] = content
                        elif is_table(primary_rsc.content):
                            content = f"""Resource response with {rsc_type_name}:\n\n{(2 * nl).join(
                                [f"> {f.learningResources[0].content.replace(nl, f'{nl}> ')}"
                                 for f in mt.feedbacks if f.level == level])}\n\n"""
                            result += content if content not in result else ""
                        else:
                            content = f"""Resource response with {rsc_type_name}:\n\n{(2 * nl).join(
                                [f"> {f.learningResources[0].content}" for f in mt.feedbacks if f.level == level])
                                }\n\n"""
                            result += content if content not in result else ""
                prev_fb = fb
                if not MULTIPLE_FEEDBACKS_PER_LEVEL:
                    break
        return result

    @classmethod
    def generate(cls):
        mtcs = corpus.topLevelMistakeTypeCategories()
        return f"""{nl.join(cls.nested_toc_output_for(c) for c in mtcs)}\n{
            nl.join(cls.nested_body_output_for(c) for c in mtcs)}"""

    @classmethod
    def save_to_file(cls, filename: str = None):
        if not filename:
            filename = LEARNING_CORPUS_MARKDOWN_FILE
        md = cls.generate()
        with open(filename, "w", encoding="utf-8") as f:
            f.write(md)


class LatexGenerator(TextualGenerator):
    """
    Generate LaTeX version of the learning corpus.
    """
    # pylint: disable=too-many-statements, invalid-name
    # function-level constants must be defined here, before any inner functions
    NO_INDENT = "\\noindent "
    NLS = " \\medskip\n\n"
    MAX_WIDTH = 0.9  # relative to line width
    NESTING_KEYWORDS = ["section", "subsection", "subsubsection"]

    MarkdownGenerator.generate()  # save generated markdown as intermediate output

    @classmethod
    def make_body_title(cls, name: str, indentation: int = 0) -> str:
        cn = clean(name)
        # "paragraph" and lower levels don't render properly, so simply boldface them
        return (f'\\{cls.NESTING_KEYWORDS[indentation]}{{{cn}}}\n\n' if indentation < len(cls.NESTING_KEYWORDS)
                else f'{cls.NO_INDENT}\\textbf{{{cn}}}{cls.NLS}')

    @classmethod
    def blockquote(cls, s: str) -> str:
        'Return a block quote of the input string, eg, "> Hello", which appears as "| Hello".'
        return f"\\begin{{tabular}}{{|p{{{cls.MAX_WIDTH}\\linewidth}}}}\n{cls.sanitize(s)}\n\\end{{tabular}}{cls.NLS}"

    @classmethod
    def sanitize(cls, s: str) -> str:
        "Return the string with any params surrounded by `verb|...|` and with links removed and images rendered."
        def find_and_replace_image_link(match: Match[str]) -> str:
            "Find the image link and replace it with actual image with appropriate dimensions."
            img_name = match.group(1).replace("\\", "")
            img_path = os.path.join(CORPUS_DESCRIPTION_DIR, img_name)
            img = cv2.imread(img_path)  # pylint: disable=no-member
            height, width, _ = img.shape
            img_width = cls.MAX_WIDTH if height / width < 0.33 else 0.6
            return f"\\\\\n\\includegraphics[width={img_width}\\textwidth]{{{img_name}}}"

        def handle_list(s: str, old_bullets: tuple[str], new_bullets: tuple[str]) -> str:
            if not any(bullet in s for bullet in old_bullets) or "\n" not in s:
                return s  # short-circuit: no list to handle
            begin_itemize, end_itemize = "\\begin{itemize}", "\\end{itemize}\n"
            lines = s.splitlines()
            new_lines = []
            for line in lines:
                new_line = line
                for c in "{}_":
                    new_line = new_line.replace(c, f"\\{c}")
                for old, new in zip(old_bullets, new_bullets):
                    if new_line.strip().startswith(old):
                        new_line = f'    {new_line.replace("`", "").replace(old, new, 1)}'
                new_lines.append(new_line)
            lines = new_lines
            first_bullet_line = last_bullet_line = None
            for i, line in enumerate(lines):
                for bullet in new_bullets:
                    if bullet in line:
                        if not first_bullet_line:
                            first_bullet_line = i
                        last_bullet_line = i
            lines.insert(first_bullet_line, begin_itemize)
            lines.insert(last_bullet_line + 2, end_itemize)
            return "\n".join(lines)

        # use math notation for certain items so they render as intended
        s = handle_list(s, ("- [ ]","- [x]", "* "), ("\\item[$\\square$]", "\\item[$\\boxtimes$]", "\\item "))
        # replace <ins>text</ins> with \underline{text}
        s = re.sub(r"<ins>(.*?)</ins>", r"\\underline{\1}", s)
        for c in "|<>":
            s = s.replace(c, f"${c}$")
        # replace image links with actual images
        s = re.sub(r"!\[.*?\]\((?P<img>.*?)\)", find_and_replace_image_link, s)
        # replace regular links with italics
        s = re.sub(r"\[(?P<text>.*?)\]\(.*?\)" , r"\\textit{\g<text>}", s)  # regex101.com/r/m58sNO/1
        if "verb|" in s:
            return s  # already verbized
        return re.sub(r"\${(?P<text>.*?)}", r"\\verb|${\g<text>}|", s)

    @classmethod
    def make_tex_table(cls, s: str) -> str:
        "Return the markdown string as a LaTeX table. The table must not contain duplicate rows at the end."
        def processed(s: str) -> str:
            "Render markdown emojis ✔ and ❌ in LaTeX."
            return s.replace(":heavy_check_mark:", "\\textcolor{ForestGreen}{\\checkmark}").replace(
                ":x:", "\\textcolor{red}{$\\times$}")

        def process_row(s: str) -> str:
            "Return the string as a LaTeX table row."
            return "&".join(processed(s).split("|")) + " \\\\\n"

        if "Player-Role Pattern" in s:
            return TEX_PR_TABLE
        lines = s.strip().split(nl)
        result = ""
        prev_in_table = in_table = False
        for line in lines:
            if "---" in line:
                continue  # headers are handled separately below
            in_table = "|" in line
            n_cols = line.count("|") + 1
            if not prev_in_table and not in_table:
                result += cls.blockquote(line)
            elif not prev_in_table and in_table:  # just entered table, so add the header
                result += f"""\\begin{{tabular}}{{{n_cols * "l"}}}\n\\hline\n{process_row(line)}\\hline\n"""
            elif prev_in_table and in_table and line != lines[-1]:  # in table, so add a row
                result += process_row(line)
            elif (prev_in_table and not in_table) or line == lines[-1]:  # just left table, so add the footer
                result += process_row(line) + f"\\hline\n\\end{{tabular}}{cls.NLS}"
            prev_in_table = in_table
        return result

    @classmethod
    def make_mt_body(cls, mt: MistakeType, indentation: int = 0) -> str:
        "Return the LaTeX body of the output."
        result = cls.make_body_title(mt.description, indentation)
        levels = sorted(fb.level for fb in mt.feedbacks)
        for level in levels:
            if (level_header := f"{cls.NO_INDENT}Level {level}: ") not in result:
                result += level_header
            prev_fb = None
            for fb in mt.feedbacks:
                if fb.level != level:
                    continue
                elem_type = (f"{mt.learningItem.name.replace('End', '').replace('Association', 'Relationship')}"
                             if mt.learningItem else "")
                match fb:
                    case Feedback(highlightProblem=True):
                        sp = "specific" if fb.level > 1 else "sentence in"
                        # use elem_type here in the future if it can be made more specific, eg, enum instead of class
                        elem = "elements" if fb.level > 1 else "referring to item"
                        result += f"Highlight {sp} problem statement {elem}{cls.NLS}"
                    case Feedback(highlightSolution=True):
                        result += f"Highlight solution {f'({elem_type})' if elem_type else ''}{cls.NLS}"
                    case TextResponse() as resp:
                        if (content := cls.blockquote(resp.text)) not in result:
                            result += f"Text response:{cls.NLS}{content}"
                    case ParametrizedResponse() as resp:
                        if (content := cls.blockquote(resp.text)) not in result:
                            result += f"""{'' if isinstance(prev_fb, ParametrizedResponse)
                                else f'Parametrized response:{cls.NLS}'}{content}"""
                    case ResourceResponse() as resp if resp.learningResources:
                        primary_rsc = resp.learningResources[0]
                        rsc_type = type(primary_rsc)
                        rsc_type_name = rsc_type.__name__
                        if issubclass(rsc_type, Quiz) and rsc_type != Quiz:  # Quiz subclasses but not Quiz itself
                            if isinstance(primary_rsc, FillInTheBlanksQuiz | ListMultipleChoiceQuiz):
                                quiz_md_lines = _quizzes_to_md[primary_rsc].split(nl)
                                title, body = quiz_md_lines[0], nl.join(quiz_md_lines[1:])
                            elif isinstance(primary_rsc, TableMultipleChoiceQuiz):
                                ...
                            content = f"{title}{cls.NLS}{cls.blockquote(body)}"
                            result += content if content not in result else ""
                        elif is_table(primary_rsc.content):
                            content = f"""Resource response with {rsc_type_name}:{cls.NLS}{(2 * nl).join(
                                [cls.make_tex_table(f.learningResources[0].content)
                                 for f in mt.feedbacks if f.level == level])}"""
                            result += content if content not in result else ""
                        else:
                            content = f"""Resource response with {rsc_type_name}:{cls.NLS}{(2 * nl).join(
                                [f"{cls.blockquote(f.learningResources[0].content)}"
                                 for f in mt.feedbacks if f.level == level])}"""
                            result += content if content not in result else ""
                prev_fb = fb
                if not MULTIPLE_FEEDBACKS_PER_LEVEL:
                    break
        return result

    @classmethod
    def generate(cls):
        return TEX_HEADER + nl.join(cls.nested_body_output_for(c) for c in corpus.topLevelMistakeTypeCategories())

    @classmethod
    def save_to_file(cls, filename: str = None):
        if not filename:
            filename = LEARNING_CORPUS_TEX_FILE
        tex = cls.generate()
        with open(filename, "w", encoding="utf-8") as f:
            f.write(tex)


def create_corpus():
    "Create the learning corpus."
    save_to_file(LEARNING_CORPUS_PATH, corpus)
    print(f"Created learning corpus with {len(corpus.mistakeTypes())} mistake types.")
    generate_python()
    generate_java()
    MarkdownGenerator.save_to_file()
    LatexGenerator.save_to_file()


if __name__ == "__main__":
    "Main entry point."
    create_corpus()
