#!/usr/bin/env python3

from learningcorpus.learningcorpus import Feedback, TextResponse
from modelingassistant.modelingassistant import FeedbackItem, Solution

def give_feedback(student_solution: Solution) -> FeedbackItem:
    "Give feedback on the given student solution."
    if student_solution is not student_solution.student.currentSolution:
        return None  # do not give feedback for other unrelated solutions
    if not student_solution.mistakes:
        # emoji to test serdes
        return FeedbackItem(feedback=TextResponse(text="All good, no mistakes found! 🎉"))
    return None



if __name__ == '__main__':
    "Main entry point (used for debugging)."
