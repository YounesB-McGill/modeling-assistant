#!/usr/bin/env python3

"""
Module containing feedback algorithm for modeling assistant.
"""

from dataclasses import dataclass, field
from functools import cache
from typing import Tuple
import logging

from classdiagram import ClassDiagram
from modelingassistant_app import MODELING_ASSISTANT, get_mistakes
from parametrizedresponse import parametrize_response
from stringserdes import str_to_cdm
from learningcorpus import Feedback, ParametrizedResponse, TextResponse
from modelingassistant import (ModelingAssistant, Student, ProblemStatement, FeedbackItem, Mistake, Solution,
                               StudentKnowledge)


logger = logging.getLogger(__name__)
logger.setLevel(logging.DEBUG)

MAX_STUDENT_LEVEL_OF_KNOWLEDGE = 10.0
BEGINNER_LEVEL_OF_KNOWLEDGE = 7.0


@dataclass
class FeedbackTO:
    "Feedback transfer object class. An explicit class is used to allow for compile-time type checking."
    # pylint: disable=invalid-name
    solutionElements: list[str] = field(default_factory=list)  # to avoid mutable default value
    # TODO add this (or similar)
    #wrongGeneralizations: list[tuple[str, str]] = field(default_factory=list)
    instructorElements: list[str] = field(default_factory=list)
    problemStatementElements: list[str] = field(default_factory=list)
    highlightProblemStatementElements: bool = False
    highlightSolutionElements: bool = False
    grade: float = 0.0
    writtenFeedback: str = ""


def give_feedback(student_solution: Solution) -> FeedbackItem | list[FeedbackItem]:
    "Give feedback on the given student solution."
    if student_solution is not student_solution.student.currentSolution:
        pass  # return None  # do not give feedback for other unrelated solutions
    if not student_solution.mistakes:
        # emoji to test serdes
        return FeedbackItem(feedback=TextResponse(text="All good, no mistakes found! 🎉"), solution=student_solution)

    # sort mistakes by priority and filter out mistakes which are already resolved
    mistake_priority = lambda m: m.mistakeType.priority
    unresolved_mistakes: list[Mistake] = [m for m in sorted(student_solution.mistakes, key=mistake_priority)
                                          if not m.resolvedByStudent]

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
        result.append(fb := next_feedback(m))
        # decide whether student is beginner overall
        if student_knowledge_for(m).levelOfKnowledge < BEGINNER_LEVEL_OF_KNOWLEDGE:
            break

    resolved_mistakes: list[Mistake] = [m for m in student_solution.mistakes if m.resolvedByStudent]
    for m in resolved_mistakes:
        if sk := student_knowledge_for(m):
            if m.lastFeedback: # ignore mistakes which have been resolved before feedback was given on them
                sk.levelOfKnowledge += m.lastFeedback.feedback.level / 2

    return result[0] if len(result) == 1 else result


def next_feedback(mistake: Mistake) -> FeedbackItem:
    """
    Return the feedback item at the next level for the given mistake, eg,

        next_feedback(mistake with lastFeedback.level = 2) = feedback at level 3
    """
    target_level = mistake.lastFeedback.feedback.level + 1 if mistake.lastFeedback else 1
    next_fb: Feedback = next(fb for fb in mistake.mistakeType.feedbacks if fb.level == target_level)
    fb_text = next_fb.text
    if isinstance(next_fb, ParametrizedResponse):
        fb_text = parametrize_response(next_fb, mistake)
    return FeedbackItem(text=fb_text, feedback=next_fb, solution=mistake.solution, mistake=mistake)


def student_knowledge_for(mistake: Mistake) -> StudentKnowledge:
    """
    Return the student knowledge object for the given mistake (a mistake is made by a specific student).
    If not found, create a new one.
    """
    # pylint: disable=protected-access
    # TODO Cache studentknowledges or redesign metamodel to access them in O(1) time instead of O(n)
    student = mistake.solution.student
    # print statements for debugging, will be cleaned up later
    #print("Student knowledges for", student.name, "Mistake", mistake.mistakeType.name,mistake.mistakeType._internal_id)
    for sk in student.studentKnowledges:
        #print(">>>", sk.mistakeType.name, sk.mistakeType._internal_id, sk.levelOfKnowledge)
        if sk.mistakeType._internal_id == mistake.mistakeType._internal_id:
            #print("--- Returning existing SK\n")
            return sk
    #print(f"** Creating new SK for mistake type {mistake.mistakeType.name} ({mistake.mistakeType._internal_id}) **\n")
    return StudentKnowledge(student=student, mistakeType=mistake.mistakeType, levelOfKnowledge=5.0,
                            modelingAssistant=mistake.solution.modelingAssistant)


def give_feedback_for_student_cdm(username: str, student_cdm: ClassDiagram | str, ma: ModelingAssistant = None
    ) -> FeedbackTO | Tuple[FeedbackTO, ModelingAssistant]:
    "Give feedback given a student class diagram."
    # pylint: disable=protected-access
    use_local_ma = bool(ma)
    ma = ma or MODELING_ASSISTANT.instance

    if isinstance(student_cdm, str):
        student_cdm = str_to_cdm(student_cdm)

    instructor_cdm = instructor_solution_for(student_cdm, ma).classDiagram
    student_solution = student_solution_for(username, student_cdm, ma)  # useful line to create solution, do not remove

    cdms2sols = ma.classDiagramsToSolutions
    ma = get_mistakes(ma, instructor_cdm, student_cdm)
    if not ma.classDiagramsToSolutions:
        ma.classDiagramsToSolutions = cdms2sols
    if not use_local_ma:
        MODELING_ASSISTANT.instance = ma
    student_solution = student_solution_for(username, student_cdm, ma)
    fb_s = give_feedback(student_solution)
    fb = fb_s if isinstance(fb_s, FeedbackItem) else fb_s[0]  # only one feedback item for now

    if not fb.mistake:
        return FeedbackTO()

    feedback = FeedbackTO(
        solutionElements=[e.element._internal_id for e in fb.mistake.studentElements],
        instructorElements=[e.element._internal_id for e in fb.mistake.instructorElements],
        problemStatementElements=[],  #[pse._internal_id for e in fb.mistake.instructorElements for pse in e],
        highlightProblemStatementElements=fb.feedback.highlightProblem,
        highlightSolutionElements=fb.feedback.highlightSolution,
        grade=0.0,  # for now
        writtenFeedback=fb.text or fb.feedback.text or "")

    return (feedback, ma) if use_local_ma else feedback


@cache
def instructor_solution_for(student_cdm: ClassDiagram, ma: ModelingAssistant = None) -> Solution:
    "Return the instructor solution for the given student class diagram."
    # TODO Assume only one problem statement for now
    ma = ma or MODELING_ASSISTANT.instance
    return next(sol for sol in ma.solutions if not sol.student)


def student_solution_for(username: str, student_cdm: ClassDiagram, ma: ModelingAssistant) -> Solution:
    "Return the student solution for the given student class diagram."
    # pylint: disable=protected-access
    student = next((s for s in ma.students if s.name == username), None) or Student(name=username, modelingAssistant=ma)
    ps: ProblemStatement = ma.problemStatements[0]  # TODO Assume only one problem statement for now
    stud_sol = (next((sol for sol in ma.solutions if sol.student and sol.student.name == username
                      and sol.classDiagram._internal_id == student_cdm._internal_id), None)
                or Solution(student=student, classDiagram=student_cdm, modelingAssistant=ma, problemStatement=ps))
    stud_sol.classDiagram = student_cdm
    old_sol = None
    for sol in ps.studentSolutions:
        if sol.student.name == username and sol.classDiagram._internal_id == student_cdm._internal_id:
            old_sol = sol
            break
    if old_sol:
        ps.studentSolutions.remove(old_sol)
    ps.studentSolutions.append(stud_sol)
    return stud_sol


if __name__ == '__main__':
    "Main entry point (used for debugging)."
