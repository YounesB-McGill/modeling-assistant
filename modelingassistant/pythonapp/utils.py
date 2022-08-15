"""
Utility functions for the Modeling Assistant Python app.
This module must not depend on any other to avoid circular dependencies.
"""
# pylint: disable=no-member

# Ok to import items from standard library, constants, envvars, and pyecore model code only
import json
import re
from collections import namedtuple
from collections.abc import Iterable
from string import Formatter
from types import SimpleNamespace
from typing import NamedTuple, Tuple

from pyecore.ecore import EObject

from classdiagram import AssociationEnd, Classifier, ReferenceType
from constants import CORRECT_QUIZ_ITEM_NOTATIONS, MULTIPLE_FEEDBACKS_PER_LEVEL
from learningcorpus import MistakeElement, MistakeTypeCategory, MistakeType, Feedback
from learningcorpusquiz import (Blank, Choice, FillInTheBlanksQuiz, FillInTheBlanksQuizStatement,
                                ListMultipleChoiceQuiz, NonBlank)
from modelingassistant import ModelingAssistant


COLOR = SimpleNamespace(VIOLET="\033[95m", BLUE="\033[94m", CYAN="\033[96m", GREEN="\033[92m", YELLOW="\033[93m",
                        ORANGE="\u001b[31;1m", RED="\033[91m", ENDC="\033[0m")

_mtc_subcats: dict[MistakeTypeCategory, list[MistakeTypeCategory]] = {}


def color_str(color: str, text: str) -> str:
    "Return the given text in the given color, useful for printing to console."
    return f"{color}{text}{COLOR.ENDC}"


def warn(text: str):
    "Print a warning message to the console."
    print(color_str(COLOR.ORANGE, f"Warning: {text}"))


def to_simplenamespace(d: dict) -> SimpleNamespace:
    """
    Convert a dictionary to a SimpleNamespace, to make it easier to access its keys using dot notation, eg,
    d.p instead of d["p"].
    """
    return SimpleNamespace(**d)


def ae(cls_: Classifier, lb: int = 1, ub: int = 1, ref_type: ReferenceType = ReferenceType.Regular, n: str = ""
       ) -> AssociationEnd:
    "Shorthand to create a CDM association end."
    return AssociationEnd(classifier=cls_, lowerBound=lb, upperBound=ub, referenceType=ref_type, name=n)


def mtc(n, s=None, **kwargs) -> MistakeTypeCategory:
    "Shorthand for MistakeTypeCategory initializer."
    _mtc = MistakeTypeCategory(name=n, supercategory=s, **kwargs)
    if "subcategories" in kwargs:
        _mtc_subcats[_mtc] = kwargs["subcategories"]
    return _mtc


def mt(n, d="", stud: str | list[str] = None, inst: str | list[str] = None, stud_inst: str | list[str] = None,
       **kwargs) -> MistakeType:
    """
    Shorthand for MistakeType initializer.

    n: name of the mistake type
    d: description of the mistake type
    """
    # change the line below to use other languages
    from metatypes import CDM_METATYPES as types  # pylint: disable=import-outside-toplevel
    def elems(me_s: str | list[str]) -> list[MistakeElement]:
        "Helper function to create the list of MistakeElements for the given input string(s)."
        strs = tmp if isinstance(tmp := (stud_inst or me_s), list) else [tmp]
        result = []
        for s in strs:
            desired_type_name = re.sub(r"[*\d]+", "", s.split("_")[-1])
            if desired_type_name not in types:
                raise ValueError(f"{desired_type_name} is not a valid metatype name.")
            t = types[re.sub(r"[*\d]+", "", s.split("_")[-1])].eClass.__name__
            result.append(MistakeElement(name=s, many=s.endswith("*"), type=t))
        return result
    if n == d:
        warn(f"Name and description are identical for mistake type {n}")
    if not d:
        d = n
    if not any((stud, inst, stud_inst)):
        raise ValueError("At least one of stud, inst, stud_inst must be provided")
    if (stud and stud_inst) or (inst and stud_inst):
        raise ValueError("stud_inst cannot be used in conjunction with stud or inst")
    if stud and stud == inst:
        warn(f"stud and inst are identical for mistake type {n}, so prefer stud_inst to specify mistake elements")
    return MistakeType(name=n, description=d, studentElements=elems(stud), instructorElements=elems(inst), **kwargs)


def fbs(fbs_by_level: dict[int, Feedback | list[Feedback]]) -> list[Feedback]:
    """
    Shorthand for Feedback initializer.

    fbs_by_level: dictionary of feedbacks, keyed by the feedback level
    """
    feedbacks = []
    for level, fb_s in fbs_by_level.items():
        if isinstance(fb_s, list):
            for fb in fb_s:
                fb.level = level
                feedbacks.append(fb)
                if not MULTIPLE_FEEDBACKS_PER_LEVEL:
                    break
        else:
            fb: Feedback = fb_s
            fb.level = level
            feedbacks.append(fb)
    return feedbacks


def fitb(prompt: str, *statements) -> FillInTheBlanksQuiz:
    """
    Shorthand for FillInTheBlanksQuiz initializer.

    prompt: introductory text for the quiz
    statements: quiz statements with blanks to be filled in, with the following format:
        "Python formatted string with {blanks} in {curly braces}."
     -> "Python formatted string with ________ in ______________."

    Example usage:
    ```
    fitb("Fill in the blanks to complete the sentence:",
         "The capital of Canada is {Ottawa} and its largest city is {Toronto}.",
         "The capital and largest city of France is {Paris}.",
         "The capital of {Australia} is Canberra.")
    ```
    """
    if not prompt or not isinstance(prompt, str):
        raise ValueError(f"Prompt must be a non-empty string, got {prompt}")
    if not statements:
        raise ValueError("No statements provided for FillInTheBlanksQuiz")

    quiz = FillInTheBlanksQuiz(content=prompt)

    """
    Use the Python string formatter to parse the statements as in this example:

    >>> list(Formatter().parse("A{B}C{D}{E}F"))
    [('A', 'B', '', None), ('C', 'D', '', None), ('', 'E', '', None), ('F', None, None, None)]
    """
    fmt = Formatter()
    for statement_str in statements:
        if not statement_str:
            continue
        statement = FillInTheBlanksQuizStatement()
        for non_blank, blank, _, _ in fmt.parse(statement_str):
            if non_blank:
                statement.components.append(NonBlank(text=non_blank))
            if blank:
                statement.components.append(Blank(correctAnswer=blank))
        quiz.statements.append(statement)
    return quiz


class HighlightProblem(Feedback):
    "Shorthand for Feedback initializer with highlightProblem=True."
    # Use __new__ here to create a Feedback instance instead of a subclass not found in the metamodel
    def __new__(cls, *args, **kwargs):
        return Feedback(*args, highlightProblem=True, **kwargs)


class HighlightSolution(Feedback):
    "Shorthand for Feedback initializer with highlightSolution=True."
    def __new__(cls, *args, **kwargs):
        return Feedback(*args, highlightSolution=True, **kwargs)


class MistakeDetectionFormat(NamedTuple):
    """
    Internal representation of the current mistake detection format for a mistake type.

    stud: ordered list of student solution element descriptions for a particular mistake type
    inst: ordered list of instructor solution element descriptions

    Note that in both cases, not all slots are occupied. For example, for incomplete containment tree, there may be
    a variable number of student solution elements.
    """
    stud: list[str]
    inst: list[str]

    def __repr__(self) -> str:
        return f"({self.stud}, {self.inst})"


class McqFactory:
    """
    Factory to create a list multiple choice quiz.
    """
    def __getitem__(self, items: tuple[str | slice]) -> ListMultipleChoiceQuiz:
        """
        Get the list multiple choice quiz defined according to the following input format:

        The first item is the prompt for the quiz, which must be a string.
        The remaining items are the choices for the quiz, and can be either strings or slices. If a slice is given and
        the start item is a correct choice notation, the choice will be considered correct. There must be at least two
        choices.

        Example usage:
        ```
        mcq = McqFactory()
        quiz = mcq[
            "What cities are located in Canada?",
                  "Chicago",
            True: "Montréal",
                  "Delhi",
            True: "Toronto",
        ]
        ```
        """
        if not isinstance(items, tuple) or len(items) < 3:
            raise ValueError("Multiple choice quiz must have a prompt and at least two choices")
        if not isinstance(items[0], str):
            raise ValueError("Multiple choice quiz must start with a prompt")

        mc_quiz = ListMultipleChoiceQuiz(content=items[0])

        for item in items[1:]:
            if isinstance(item, str):
                mc_quiz.choices.append(Choice(text=item, quiz=mc_quiz))
            if isinstance(item, slice):
                # slice will have 3 parts in the order (start : stop [: step])
                choice = Choice(text=item.stop, quiz=mc_quiz)
                mc_quiz.choices.append(choice)
                if str(item.start).lower() in CORRECT_QUIZ_ITEM_NOTATIONS:
                    mc_quiz.correctChoices.append(choice)
        if not mc_quiz.correctChoices:
            warn(f'Multiple choice quiz with prompt "{mc_quiz.content}"" has no correct choices')

        return mc_quiz


mcq = McqFactory()


class ClassDiagramDTO(SimpleNamespace):
    """
    Class Diagram Data Transfer (JSON) Object returned by WebCORE.

    Properties: { eClass, _id, name, classes, types, layout }
    """
    def __init__(self, json_repr: dict | str | SimpleNamespace):
        if isinstance(json_repr, str):
            json_repr = json.loads(json_repr, object_hook=to_simplenamespace)
        elif isinstance(json_repr, dict):
            json_repr = to_simplenamespace(json_repr)
        self.__dict__.update(json_repr.__dict__)
        # Perhaps this can be cached in the future, if it is certain that WebCORE's type _ids will not change
        self.type_names_to_ids: dict[str, str] = {t.eClass.removeprefix("http://cs.mcgill.ca/sel/cdm/1.0#//"): t._id
                                  for t in self.classDiagram.types}  # pylint: disable=protected-access

    def get_class_names_by_ids(self) -> dict[str, str]:
        "Return a dictionary mapping class _ids to class names."
        if not hasattr(self.classDiagram, "classes"):
            return {}
        return {c._id: c.name for c in self.classDiagram.classes}  # pylint: disable=protected-access

    def type_id_for(self, type_: type | str) -> str:
        "Return the type _id for the given type."
        type_name = type_.__name__ if isinstance(type_, type) else type_
        d = self.type_names_to_ids
        return d.get(type_name, d["CDAny"])  # return the Any type if exact type not found

    def __getitem__(self, item: str) -> SimpleNamespace:
        return get_by_id(item, self)

    class CustomJSONEncoder(json.JSONEncoder):
        "Custom JSON encoder to display object in a more readable way."
        def default(self, o):
            return o.__dict__

    def __repr__(self):
        return json.dumps(self.__dict__, indent=2, cls=self.CustomJSONEncoder)


def cdm_diff(old_cdm: dict, new_cdm: dict) -> Tuple[list[str], list[str]]:
    "Return the difference between the old and new cdms in the format (additions, removals)."
    def get_ids(iterable: Iterable, result: list[str] = None) -> list[str]:
        "Recursively get the _ids of the given input."
        if result is None:
            result = []
        if isinstance(iterable, SimpleNamespace):
            iterable = iterable.__dict__
        if isinstance(iterable, list):
            for item in iterable:
                for _id in get_ids(item):
                    if _id not in result:
                        result.append(_id)
        elif isinstance(iterable, dict):
            for key, value in iterable.items():
                if key == "_id" and value not in result:
                    result.append(value)
                else:
                    for _id in get_ids(value, result):
                        if _id not in result:
                            result.append(_id)
        return result

    old_ids, new_ids = get_ids(old_cdm), get_ids(new_cdm)
    result_template = namedtuple("result", "additions, removals")
    additions = [_id for _id in new_ids if _id not in old_ids]
    removals = [_id for _id in old_ids if _id not in new_ids]
    return result_template(additions, removals)


def get_by_id(_id: str, iterable: Iterable) -> str:
    "Get the item with the given _id by recursing into the iterable."
    if isinstance(iterable, SimpleNamespace):
        iterable = iterable.__dict__
    if isinstance(iterable, list):
        for item in iterable:
            if hasattr(item, "get") and _id == item.get("_id", None):
                return item
            if result := get_by_id(_id, item):
                return result
    elif isinstance(iterable, dict):
        for key, value in iterable.items():
            if (key, value) == ("_id", _id):
                return to_simplenamespace(iterable)
            if result := get_by_id(_id, value):
                return result
    return None


class NonNoneDict(dict):
    """
    A dictionary that disallows None keys and values.
    """
    def __setitem__(self, key, value):
        if key is None:
            raise ValueError("Cannot set NonNoneDict key to None")
        if value is None:
            raise ValueError("Cannot set NonNoneDict value to None")
        super().__setitem__(key, value)


class ModelingAssistantContainer:
    "Class to contain a Modeling Assistant instance."
    def __init__(self, modeling_assistant: ModelingAssistant = None):
        self.instance: ModelingAssistant = modeling_assistant
