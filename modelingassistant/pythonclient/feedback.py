#!/usr/bin/env python3

from learningcorpus.learningcorpus import TextResponse
from modelingassistant.modelingassistant import FeedbackItem, Mistake, Solution

def give_feedback(student_solution: Solution) -> FeedbackItem:
    "Give feedback on the given student solution."
    if student_solution is not student_solution.student.currentSolution:
        return None  # do not give feedback for other unrelated solutions
    if not student_solution.mistakes:
        # emoji to test serdes
        return FeedbackItem(feedback=TextResponse(text="All good, no mistakes found! 🎉"))

    mistakes = sorted(student_solution.mistakes, key=lambda m: m.mistakeType.priority)
    highest_priority_mistake = mistakes[0]

    return FeedbackItem(feedback=TextResponse(text=f"Found mistake of type {highest_priority_mistake.mistakeType.name}"))


if __name__ == '__main__':
    "Main entry point (used for debugging)."
