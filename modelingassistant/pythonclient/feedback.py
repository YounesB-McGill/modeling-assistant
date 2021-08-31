#!/usr/bin/env python3

"""
Module containing feedback algorithm for modeling assistant.
"""

from typing import Union
from learningcorpus.learningcorpus import TextResponse
from modelingassistant.modelingassistant import FeedbackItem, Mistake, Solution, StudentKnowledge


MAX_STUDENT_LEVEL_OF_KNOWLEDGE = 10.0
BEGINNER_LEVEL_OF_KNOWLEDGE = 7.0


def give_feedback(student_solution: Solution) -> Union[FeedbackItem, list[FeedbackItem]]:
    "Give feedback on the given student solution."
    if student_solution is not student_solution.student.currentSolution:
        return None  # do not give feedback for other unrelated solutions
    if not student_solution.mistakes:
        # emoji to test serdes
        return FeedbackItem(feedback=TextResponse(text="All good, no mistakes found! 🎉"), solution=student_solution)

    # sort mistakes by priority and filter out mistakes which are already resolved
    mistake_priority = lambda m: m.mistakeType.priority
    unresolved_mistakes: list[Mistake] = [m for m in sorted(student_solution.mistakes, key=mistake_priority)
                                          if not m.resolved]

    # update student knowledge for each unresolved mistake type
    for m in unresolved_mistakes:
        student_knowledge_for(m).levelOfKnowledge = MAX_STUDENT_LEVEL_OF_KNOWLEDGE - m.numDetections

    # sort highest priority mistakes based on number of detections (start with those detected the most times)
    highest_priority = unresolved_mistakes[0].mistakeType.priority
    highest_priority_mistakes = sorted([m for m in unresolved_mistakes if m.mistakeType.priority == highest_priority],
                                       key=lambda m: m.numDetections, reverse=True)

    result: list[FeedbackItem] = []

    for m in highest_priority_mistakes:
        #student_solution.currentMistake = m  # TODO
        result.append(next_feedback(m))
        if student_knowledge_for(m).levelOfKnowledge < BEGINNER_LEVEL_OF_KNOWLEDGE:
            break

    resolved_mistakes: list[Mistake] = [m for m in student_solution.mistakes if m.resolved]
    for m in resolved_mistakes:
        if sk := student_knowledge_for(m):
            sk.levelOfKnowledge += m.lastFeedback.level / 2

    return result[0] if len(result) == 1 else result


def next_feedback(mistake: Mistake) -> FeedbackItem:
    """
    Return the feedback item at the next level for the given mistake, eg,

        next_feedback(mistake with lastFeedback.level = 2) = feedback at level 3
    """
    target_level = mistake.lastFeedback.feedback.level + 1 if mistake.lastFeedback else 1
    next_fb = next(fb for fb in mistake.mistakeType.feedbacks if fb.level == target_level)
    return FeedbackItem(feedback=next_fb, solution=mistake.solution, mistake=mistake)


def student_knowledge_for(mistake: Mistake) -> StudentKnowledge:
    """
    Return the student knowledge object for the given mistake (a mistake is made by a specific student).
    """
    # TODO Cache studentknowledges or redesign metamodel to access them in O(1) time instead of O(n) 
    student = mistake.solution.student
    return next(sk for sk in student.studentKnowledges if sk.mistakeType == mistake.mistakeType)


if __name__ == '__main__':
    "Main entry point (used for debugging)."
