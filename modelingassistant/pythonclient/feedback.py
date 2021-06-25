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

    # sort mistakes by priority and filter out mistakes which are already resolved
    mistakes: list[Mistake] = [m for m in sorted(student_solution.mistakes, key=lambda m: m.mistakeType.priority)
                               if not m.resolved]
    highest_priority = mistakes[0].mistakeType.priority
    # sort highest priority mistakes based on number of detections (start with those detected the most times)
    highest_priority_mistakes = sorted([m for m in mistakes if m.mistakeType.priority == highest_priority],
                                       key=lambda m: m.numDetection, reverse=True)

    for m in highest_priority_mistakes:
        curr_feedback_level = m.lastFeedback.feedback.level + 1 if m.lastFeedback else 1
        curr_feedbacks = [f for f in m.mistakeType.feedbacks if f.level == curr_feedback_level]
        if curr_feedbacks:
            return curr_feedbacks[0]

    return FeedbackItem(feedback=TextResponse(
        text=f"Found mistake of type {highest_priority_mistakes[0].mistakeType.name}"))


if __name__ == '__main__':
    "Main entry point (used for debugging)."
