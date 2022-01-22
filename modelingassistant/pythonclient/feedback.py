#!/usr/bin/env python3

"""
Module containing feedback algorithm for modeling assistant.
"""

from dataclasses import dataclass, field
from functools import cache
from typing import Tuple
from uuid import uuid4 as uuid
import logging

from modelingassistant_app import LOGGING_LEVEL, MODELING_ASSISTANT, get_mistakes
from classdiagram import ClassDiagram
from envvars import CORES_PATH
from fileserdes import load_cdm
from learningcorpus import TextResponse
from stringserdes import str_to_cdm
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
    If not found, create a new one.
    """
    # TODO Cache studentknowledges or redesign metamodel to access them in O(1) time instead of O(n)
    student = mistake.solution.student
    return next((sk for sk in student.studentKnowledges if sk.mistakeType == mistake.mistakeType),
                StudentKnowledge(student=student, mistakeType=mistake.mistakeType, levelOfKnowledge=5.0,
                                 modelingAssistant=mistake.solution.modelingAssistant))


def give_feedback_for_student_cdm(
        student_cdm_name: str, student_cdm: ClassDiagram | str = "", ma: ModelingAssistant = None
    ) -> FeedbackTO | Tuple[FeedbackTO, ModelingAssistant]:
    "Give feedback given a student class diagram."
    # pylint: disable=protected-access, global-statement, too-many-branches
    global MODELING_ASSISTANT
    print(f"give_feedback_for_student_cdm({student_cdm_name}, {student_cdm}, {ma})")
    use_local_ma = bool(ma)
    if not use_local_ma:
        ma = MODELING_ASSISTANT.instance

    instructor_cdm = instructor_cdm_for(student_cdm_name)
    if ma.eResource and instructor_cdm._internal_id in ma.classDiagramsToSolutions:
        print(f"Getting ins sol at {id(ma) = }, {ma.classDiagramsToSolutions = }")
        sol_id = ma.classDiagramsToSolutions[instructor_cdm._internal_id]
        print(ma.eResource, ma.eResource.uuid_dict)
        instructor_solution = ma.eResource.uuid_dict[sol_id]
    else:
        print(f"Creating new ins sol at {id(ma) = }")
        instructor_solution = Solution(classDiagram=instructor_cdm, modelingAssistant=ma)
        ma.classDiagramsToSolutions[instructor_cdm._internal_id] = instructor_solution._internal_id

    if not isinstance(student_cdm, ClassDiagram):
        if student_cdm and isinstance(student_cdm, str):
            student_cdm = str_to_cdm(student_cdm)
        else:
            student_cdm = student_cdm_for(student_cdm_name)

    print(f"give_fb: {student_cdm._internal_id = }")
    if ma.eResource and student_cdm._internal_id in ma.classDiagramsToSolutions:
        sol_id = ma.classDiagramsToSolutions[student_cdm._internal_id]
        student_solution = ma.eResource.uuid_dict[sol_id]
        student_solution.classDiagram = student_cdm
        ma = student_solution.modelingAssistant
    else:
        # TODO Complete initialization of solution later
        #if modeling_assistant._eresource.uuid_dict
        print("Could not find solution for student cdm, so creating new one")
        student = ma.students[0] if ma.students else Student(
            id=str(uuid()), name=student_cdm_name, modelingAssistant=ma)
        student_solution = Solution(modelingAssistant=ma, student=student, classDiagram=student_cdm)
        student.currentSolution = student_solution
        print(f"give_fb: {student_solution._internal_id = }")
        ma.classDiagramsToSolutions[student_cdm._internal_id] = student_solution._internal_id
    if ma.problemStatements:
        ps = ma.problemStatements[0]
        ps.instructorSolution = instructor_solution
        if not ps.studentSolutions:  # Only one student solution for now
            ps.studentSolutions.append(student_solution)
    else:
        ma.problemStatements.append(ProblemStatement(modelingAssistant=ma, instructorSolution=instructor_solution,
                                                     studentSolutions=[student_solution]))
    cdms2sols = ma.classDiagramsToSolutions
    if not use_local_ma:
        MODELING_ASSISTANT.instance = ma
    print(f"give_fb: {'Airplane' in (c.name for c in student_cdm.classes) = }")
    print(ma)
    ma = get_mistakes(ma, instructor_cdm, student_cdm)
    print(ma)
    if not ma.classDiagramsToSolutions:
        ma.classDiagramsToSolutions = cdms2sols
    if not use_local_ma:
        MODELING_ASSISTANT.instance = ma
    student_solution = next(sol for sol in ma.solutions if sol.student)
    fb_s = give_feedback(student_solution)
    fb = fb_s if isinstance(fb_s, FeedbackItem) else fb_s[0]  # only one feedback item for now

    if not fb.mistake:
        return FeedbackTO()

    feedback = FeedbackTO(
        solutionElements=[e.element._internal_id for e in fb.mistake.studentElements],
        instructorElements=[e.element._internal_id for e in fb.mistake.instructorElements],
        problemStatementElements=[], #[pse._internal_id for e in fb.mistake.instructorElements for pse in e],
        highlightProblemStatementElements=fb.feedback.highlightProblem,
        highlightSolutionElements=fb.feedback.highlightSolution,
        grade=0.0,  # for now
        writtenFeedback=fb.text or fb.feedback.text or "")

    return (feedback, ma) if use_local_ma else feedback


@cache
def instructor_cdm_for(student_cdm_name: str) -> ClassDiagram:
    "Return the instructor class diagram for the given student class diagram name."
    # return next((ps.instructorSolution.classDiagram for ps in MODELING_ASSISTANT.instance.problemStatements
    #              if ps.name.lower() in student_cdm_name.lower()), None)
    return load_cdm(f"modelingassistant/testmodels/{student_cdm_name}_instructor.cdm")  # do this for now


@cache
def student_cdm_for(student_cdm_name: str) -> ClassDiagram:
    "Return the student class diagram for the given student class diagram name."
    # Use file system for now
    cdm_file = f"{CORES_PATH}/{student_cdm_name}/Class Diagram/{student_cdm_name}.design_class_model.cdm"
    return load_cdm(cdm_file)


if __name__ == '__main__':
    "Main entry point (used for debugging)."
