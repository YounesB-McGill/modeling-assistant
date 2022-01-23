"""
Tests for utils module.
"""

from learningcorpus import MistakeType, MistakeTypeCategory, Feedback, TextResponse, ParametrizedResponse
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
    mt2 = utils.mt(n=mt_name, d=mt_desc)
    mt3 = utils.mt(n=mt_name)
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
        1: Feedback(highlightSolution=True),
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
    "Test the mcq() helper function."
    # TODO
