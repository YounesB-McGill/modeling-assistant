#!/usr/bin/env python3

import os
import sys
from feedback import give_feedback
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from learningcorpus.learningcorpus import Feedback, TextResponse
from mistaketypes import SOFTWARE_ENGINEERING_TERM
from modelingassistant.modelingassistant import ModelingAssistant, ProblemStatement, Solution, Student, StudentKnowledge


def make_ma_wo_mistakes() -> ModelingAssistant:
    "Make a simple Modeling Assistant instance with no mistakes."
    ma = ModelingAssistant()
    bus_ps = ProblemStatement(name="Bus Management System", modelingAssistant=ma)
    alice = Student(name="Alice", modelingAssistant=ma)
    StudentKnowledge(mistakeType=SOFTWARE_ENGINEERING_TERM, student=alice, modelingAssistant=ma)
    alice_bus_sol = Solution(student=alice, problemStatement=bus_ps, modelingAssistant=ma)
    alice.currentSolution = alice_bus_sol
    return ma


def test_feedback_wo_mistakes():
    solution = make_ma_wo_mistakes().solutions[0]
    feedback_item = give_feedback(solution)
    assert "no mistakes found" in feedback_item.feedback.text


if __name__ == '__main__':
    "Main entry point (used for debugging)."
    make_ma_wo_mistakes()
