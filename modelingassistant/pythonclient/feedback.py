#!/usr/bin/env python3

"""
Module containing feedback algorithm for modeling assistant.
"""

from dataclasses import dataclass
from functools import cache
import modelingassistant
from modelingassistant import ModelingAssistant

from modelingassistant_app import MODELING_ASSISTANT, get_mistakes
from classdiagram import ClassDiagram
from learningcorpus import TextResponse
from modelingassistant import FeedbackItem, Mistake, Solution, StudentKnowledge


MAX_STUDENT_LEVEL_OF_KNOWLEDGE = 10.0
BEGINNER_LEVEL_OF_KNOWLEDGE = 7.0


@dataclass
class FeedbackTO:
    "Feedback transfer object class. An explicit class is used to allow for compile-time type checking."
    # pylint: disable=invalid-name
    solutionElements: list[str]
    instructorElements: list[str]
    problemStatementElements: list[str]
    highlight: bool
    grade: float
    writtenFeedback: str


def give_feedback(student_solution: Solution) -> FeedbackItem | list[FeedbackItem]:
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
        # decide whether student is beginner overall
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


def give_feedback_for_student_cdm(student_cdm_name: str, ma: ModelingAssistant = None) -> FeedbackTO:
    "Give feedback given a student class diagram."
    global MODELING_ASSISTANT  # pylint: disable=global-statement
    modeling_assistant = ma or MODELING_ASSISTANT
    instructor_cdm = instructor_cdm_for(student_cdm_name)
    student_cdm = student_cdm_for(student_cdm_name)
    if student_cdm in modeling_assistant.classDiagramsToSolutions:
        student_solution = modeling_assistant.classDiagramsToSolutions[student_cdm]
    else:
        student_solution = ... # create_solution()  # do initialization setup here
    modeling_assistant = get_mistakes(modeling_assistant, instructor_cdm, student_cdm)
    fb_s = give_feedback(student_solution)
    fb = fb_s if isinstance(fb_s, FeedbackItem) else fb_s[0]  # only one feedback item for now

    ...

    return FeedbackTO(
        solutionElements=[],
        instructorElements=[],
        problemStatementElements=[],
        highlight=False,
        grade=0.0,
        writtenFeedback="",
    )


@cache
def instructor_cdm_for(student_cdm_name: str) -> ClassDiagram:
    "Return the instructor class diagram for the given student class diagram name."
    return next((ps.instructorSolution.classDiagram for ps in MODELING_ASSISTANT.problemStatements
                 if ps.name.lower() in student_cdm_name.lower()), None)


@cache
def student_cdm_for(student_cdm_name: str) -> ClassDiagram:
    "Return the student class diagram for the given student class diagram name."
    # TODO: return student class diagram from name using file system for now


if __name__ == '__main__':
    "Main entry point (used for debugging)."
