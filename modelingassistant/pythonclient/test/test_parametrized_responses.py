#!/usr/bin/env python3

"""
Tests for parametrized responses.
"""

from classdiagram import Class
from corpus import missing_class
from feedback import parametrize_response
from modelingassistant import Mistake, SolutionElement

def test_prs_correctly_specified():
    """
    Ensure that parametrized responses are correctly specified.

    Each parameter must be parsable to a value that can be converted to a string and substituted into the response.

    Each parameter must start with `stud` or `inst`.
    numbers, `_`, `.`, and `*` have special meanings.

    programmatic attributes:
    rolename: name
    cls: classifier when invoked on an AssociationEnd
    """


def test_pr_missing_class():
    "Test parametrized response for missing class mistake."
    missing_class_name = "Airplane"
    # Assume this is returned from the Mistake Detection System
    missing_class_mistake = Mistake(instructorElements=[SolutionElement(element=Class(name=missing_class_name))],
                                    mistakeType=missing_class)
    missing_class_pr = missing_class.parametrized_responses()[0]
    pr_result = parametrize_response(missing_class_pr, missing_class_mistake)
    assert pr_result
    assert "${" not in pr_result
    assert pr_result == f"Remember to add the {missing_class_name} class."


if __name__ == "__main__":
    "Main entry point (used for debugging)."
