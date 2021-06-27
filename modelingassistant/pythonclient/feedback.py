#!/usr/bin/env python3

from typing import Union
from learningcorpus.learningcorpus import TextResponse
from modelingassistant.modelingassistant import FeedbackItem, Mistake, Solution


MAX_STUDENT_LEVEL_OF_KNOWLEDGE = 10


def give_feedback(student_solution: Solution) -> Union[FeedbackItem, list[FeedbackItem]]:
    "Give feedback on the given student solution."
    if student_solution is not student_solution.student.currentSolution:
        return None  # do not give feedback for other unrelated solutions
    if not student_solution.mistakes:
        # emoji to test serdes
        return FeedbackItem(feedback=TextResponse(text="All good, no mistakes found! 🎉"), solution=student_solution)

    if student_solution.currentMistake:
        return next_feedback(student_solution.currentMistake)

    # sort mistakes by priority and filter out mistakes which are already resolved
    mistakes: list[Mistake] = [m for m in sorted(student_solution.mistakes, key=lambda m: m.mistakeType.priority)
                               if not m.resolved]
    highest_priority = mistakes[0].mistakeType.priority
    # sort highest priority mistakes based on number of detections (start with those detected the most times)
    highest_priority_mistakes = sorted([m for m in mistakes if m.mistakeType.priority == highest_priority],
                                       key=lambda m: m.numDetection, reverse=True)

    result = FeedbackItem(feedback=TextResponse(
        text=f"Found mistake of type {highest_priority_mistakes[0].mistakeType.name}"),
        solution=student_solution)
    for m in highest_priority_mistakes:
        curr_feedback_level = m.lastFeedback.feedback.level + 1 if m.lastFeedback else 1
        curr_feedbacks = [f for f in m.mistakeType.feedbacks if f.level == curr_feedback_level]
        if curr_feedbacks:
            result = curr_feedbacks[0]

    resolved_mistakes: list[Mistake] = [m for m in student_solution.mistakes if m.resolved]
    for m in resolved_mistakes:
        sks = student_solution.student.studentKnowledges
        sk = [sk for sk in sks if sk.mistakeType == m.mistakeType]
        if sk:
            sk = sk[0]
            sk.levelOfKnowledge = MAX_STUDENT_LEVEL_OF_KNOWLEDGE - m.lastFeedback.level

    return result


def next_feedback(mistake: Mistake) -> FeedbackItem:
    """
    Return the feedback item at the next level for the given mistake, eg,

        next_feedback(mistake with lastFeedback.level = 2) = feedback at level 3
    """
    target_level = mistake.lastFeedback.feedback.level + 1 if mistake.lastFeedback else 1
    next_fb = next(fb for fb in mistake.mistakeType.feedbacks if fb.level == target_level)
    return FeedbackItem(feedback=next_fb, solution=mistake.studentSolution)


if __name__ == '__main__':
    "Main entry point (used for debugging)."
