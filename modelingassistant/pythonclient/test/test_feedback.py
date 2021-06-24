#!/usr/bin/env python3

import os
import sys

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from feedback import give_feedback
from classdiagram.classdiagram import Class
from learningcorpus.learningcorpus import Feedback, TextResponse
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


def make_ma_with_1_mistake() -> ModelingAssistant:
    "Make a simple Modeling Assistant instance with one mistake."
    ma = ModelingAssistant()
    bus_ps = ProblemStatement(name="Bus Management System", modelingAssistant=ma)
    alice = Student(name="Alice", modelingAssistant=ma)
    StudentKnowledge(mistakeType=SOFTWARE_ENGINEERING_TERM, student=alice, modelingAssistant=ma)
    alice_bus_sol = Solution(student=alice, problemStatement=bus_ps, modelingAssistant=ma)
    alice.currentSolution = alice_bus_sol
    SolutionElement(solution=alice_bus_sol, element=Class(name="BusData"))
    Mistake(studentSolution=alice_bus_sol, mistakeType=SOFTWARE_ENGINEERING_TERM)
    return ma


def test_feedback_without_mistakes():
    solution = make_ma_without_mistakes().solutions[0]
    feedback_item = give_feedback(solution)
    assert "no mistakes found" in feedback_item.feedback.text.lower()


def test_feedback_with_1_mistake():
    solution = make_ma_with_1_mistake().solutions[0]
    feedback_item = give_feedback(solution)
    assert "software engineering term" in feedback_item.feedback.text.lower()


if __name__ == '__main__':
    "Main entry point (used for debugging)."
    test_feedback_with_1_mistake()
