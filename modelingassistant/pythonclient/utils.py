"""
Utility functions for the Modeling Assistant Python app.
This module must not depend on any other to avoid circular dependencies.
"""

# Ok to import items from standard library, constants, envvars, and pyecore model code only

from string import Formatter
from types import SimpleNamespace

from constants import CORRECT_QUIZ_ITEM_NOTATIONS,  MULTIPLE_FEEDBACKS_PER_LEVEL
from learningcorpus import MistakeTypeCategory, MistakeType, Feedback
from learningcorpusquiz import (Blank, Choice, FillInTheBlanksQuiz, FillInTheBlanksQuizStatement,
                                ListMultipleChoiceQuiz, NonBlank, TableMultipleChoiceQuiz)
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


def mtc(n, s=None, **kwargs) -> MistakeTypeCategory:
    "Shorthand for MistakeTypeCategory initializer."
    _mtc = MistakeTypeCategory(name=n, supercategory=s, **kwargs)
    if "subcategories" in kwargs:
        _mtc_subcats[_mtc] = kwargs["subcategories"]
    return _mtc


def mt(n, d="", **kwargs) -> MistakeType:
    """
    Shorthand for MistakeType initializer.

    n: name of the mistake type
    d: description of the mistake type
    """
    if n == d:
        warn(f"Name and description are identical for mistake type {n}")
    if not d:
        d = n
    return MistakeType(name=n, description=d, **kwargs)


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
