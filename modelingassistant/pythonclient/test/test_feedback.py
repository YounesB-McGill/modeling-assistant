#!/usr/bin/env python3

import os
import sys

from learningcorpus.learningcorpus import Feedback, TextResponse

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from feedback import give_feedback
from classdiagram.classdiagram import Class
from mistaketypes import SOFTWARE_ENGINEERING_TERM
from modelingassistant.modelingassistant import Mistake, ModelingAssistant, ProblemStatement, Solution, SolutionElement, Student, StudentKnowledge


def make_ma_without_mistakes() -> ModelingAssistant:
    "Make a simple Modeling Assistant instance with no mistakes."
    ma = ModelingAssistant()
    bus_ps = ProblemStatement(name="Bus Management System", modelingAssistant=ma)
    alice = Student(name="Alice", modelingAssistant=ma)
    StudentKnowledge(mistakeType=SOFTWARE_ENGINEERING_TERM, student=alice, modelingAssistant=ma)
    alice_bus_sol = Solution(student=alice, problemStatement=bus_ps, modelingAssistant=ma)
    alice.currentSolution = alice_bus_sol
    return ma


def make_ma_with_1_new_mistake(num_detection: int=1) -> ModelingAssistant:
    "Make a simple Modeling Assistant instance with one mistake."
    ma = make_ma_without_mistakes()
    alice_bus_sol = ma.solutions[0]
    bus_data_cls = SolutionElement(solution=alice_bus_sol, element=Class(name="BusData"))
    set_mistake = Mistake(studentSolution=alice_bus_sol, mistakeType=SOFTWARE_ENGINEERING_TERM,
                          numDetection=num_detection, studentElements=[bus_data_cls])
    alice_bus_sol.currentMistake = set_mistake
    return ma


def test_feedback_without_mistakes():
    "Test feedback for a solution without any mistakes."
    solution = make_ma_without_mistakes().solutions[0]
    feedback_item = give_feedback(solution)
    assert "no mistakes found" in feedback_item.feedback.text.lower()


def test_feedback_with_1_mistake_level_1():
    """
    Test feedback for a solution with one mistake made a first time.

    BusData detected for first time -> highlight BusData
    """
    ma = make_ma_with_1_new_mistake(1)
    solution = ma.solutions[0]
    curr_mistake = solution.currentMistake
    assert curr_mistake is solution.mistakes[0]

    feedback_item = give_feedback(solution)
    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, Feedback)
    assert 1 == feedback.level
    assert feedback.highlightSolution
    assert curr_mistake.mistakeType is feedback.mistakeType


def tst_feedback_with_1_mistake_level_2():
    """
    Test feedback for a solution with one mistake made a second time.

    BusData detected for first time -> text response
    """
    ma = make_ma_with_1_new_mistake(2)
    solution = ma.solutions[0]
    curr_mistake = solution.currentMistake

    feedback_item = give_feedback(solution)
    assert feedback_item.solution is solution
    feedback = feedback_item.feedback
    assert isinstance(feedback, TextResponse)
    assert 2 == feedback.level
    assert not feedback.highlightSolution
    assert "software engineering term" in feedback.text
    assert curr_mistake.mistakeType is feedback.mistakeType


if __name__ == '__main__':
    "Main entry point (used for debugging)."
    test_feedback_with_1_mistake_level_1()
