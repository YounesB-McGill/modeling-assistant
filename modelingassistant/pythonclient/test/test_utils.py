"""
Tests for utils module.
"""

from textwrap import dedent
import pytest

from constants import T
from learningcorpus import MistakeType, MistakeTypeCategory, Feedback, TextResponse, ParametrizedResponse
from learningcorpusquiz import (Blank, FillInTheBlanksQuiz, FillInTheBlanksQuizStatement, ListMultipleChoiceQuiz,
                                NonBlank)
import utils

def test_mtc():
    "Test the mtc() helper function."
    mtc_name = "Using Java instead of Python"
    super_category = MistakeTypeCategory(name="Programming mistakes")
    mtc1 = MistakeTypeCategory(name=mtc_name, supercategory=super_category)
    mtc2 = utils.mtc(n=mtc_name, s=super_category)
    assert mtc1.name == mtc2.name == mtc_name
    assert mtc1.supercategory is mtc2.supercategory


def test_mt():
    "Test the mt() helper function."
    mt_name = "Redundant getters and setters"
    mt_desc = "Using redundant getters and setters is un-Pythonic."
    mt1 = MistakeType(name=mt_name, description=mt_desc)
    mt2 = utils.mt(n=mt_name, d=mt_desc, stud_inst="cls")
    mt3 = utils.mt(n=mt_name, stud_inst="cls")
    assert mt1.name == mt2.name == mt3.name == mt_name
    assert mt1.description == mt2.description == mt_desc
    assert mt3.name == mt3.description == mt_name


def test_fbs():
    "Test the fbs() helper function."
    expected: list[Feedback] = [
        Feedback(level=1, highlightSolution=True),
        TextResponse(level=2, text="Make sure you only model the concepts mentioned in the problem description."),
        TextResponse(level=3, text="You have an extra class. Can you find it?"),
        ParametrizedResponse(level=4, text="The ${className} class is not part of the domain, so please remove it."),
        ParametrizedResponse(level=4, text="Remember that a domain model should not contain concepts from the user "
            "interfaces or databases, like Window, Database, etc.")  # se term
    ]
    actual = utils.fbs({
        1: utils.HighlightSolution(),
        2: TextResponse(text="Make sure you only model the concepts mentioned in the problem description."),
        3: TextResponse(text="You have an extra class. Can you find it?"),
        4: [ParametrizedResponse(text="The ${className} class is not part of the domain, so please remove it."),
            ParametrizedResponse(text="Remember that a domain model should not contain concepts from the user "
                "interfaces or databases, like Window, Database, etc.")]
    })
    for a, e in zip(actual, expected):
        assert a.level == e.level
        assert a.highlightSolution == e.highlightSolution
        assert a.text == e.text


def test_mcq():
    "Test the McqFactory MCQ creation logic."
    # invalid inputs
    with pytest.raises(ValueError):
        assert utils.mcq["Prompt", "Only 1 choice"]
    with pytest.raises(ValueError):
        assert utils.mcq[T: "Choice 1", "Choice 2", "Choice 3"]  # missing prompt

    # valid input
    quiz = utils.mcq[
        "Pick the classes which are modeled correctly with Umple.",
           "class Student { courses; }",
           "class Folder { List<File> files; }",
        T: "class Restaurant { 1 -- * Employee; }",
    ]
    assert isinstance(quiz, ListMultipleChoiceQuiz)
    assert quiz.content == "Pick the classes which are modeled correctly with Umple."
    assert len(quiz.choices) == 3
    assert quiz.choices[0].text == "class Student { courses; }"
    assert len(quiz.correctChoices) == 1
    assert quiz.choices[2] in quiz.correctChoices


def test_fitb():
    "Test the Fill-in-the-blank quiz creation logic."
    # invalid inputs
    with pytest.raises(ValueError):
        assert utils.fitb("")  # missing prompt
    with pytest.raises(ValueError):
        assert utils.fitb("Prompt")  # missing statements

    # valid input
    prompt = dedent("""\
        Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material
        and complete the following:

        The five checks for generalization are:""")
    quiz = utils.fitb(prompt,
        "Obeys the {isA rule}.",
        "Subclass must retain its {distinctiveness}.",
        "All {inherited features} must make sense in each subclass.",
        "Subclass differs from superclass and other subclasses in {behavior} or {structure}.",
        "Subclass must not be {an instance}.")

    assert isinstance(quiz, FillInTheBlanksQuiz)
    assert quiz.content == prompt
    assert len(quiz.statements) == 5
    assert isinstance(st0 := quiz.statements[0], FillInTheBlanksQuizStatement)
    assert len(st0.components) == 3
    assert isinstance(obeys_the := st0.components[0], NonBlank)
    assert obeys_the.text == "Obeys the "
    assert isinstance(isa_rule := st0.components[1], Blank)
    assert isa_rule.correctAnswer == "isA rule"
    assert isinstance(period := st0.components[2], NonBlank)
    assert period.text == "."
    assert len(quiz.statements[3].components) == 5
