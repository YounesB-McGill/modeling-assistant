#!/usr/bin/env python3

"""
Module containing feedback algorithm for modeling assistant.
"""

from dataclasses import dataclass, field
from functools import cache
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
    highlight: bool = False
    grade: float = 0.0
    writtenFeedback: str = ""


def give_feedback(student_solution: Solution) -> FeedbackItem | list[FeedbackItem]:
    "Give feedback on the given student solution."
    print(f"Giving feedback for solution with id {id(student_solution)}")
    if student_solution is not student_solution.student.currentSolution:
        pass  # return None  # do not give feedback for other unrelated solutions
    if not student_solution.mistakes:
        # emoji to test serdes
        return FeedbackItem(feedback=TextResponse(text="All good, no mistakes found! 🎉"), solution=student_solution)

    print("Student solution has mistakes, running FB alg")

    # sort mistakes by priority and filter out mistakes which are already resolved
    mistake_priority = lambda m: m.mistakeType.priority
    unresolved_mistakes: list[Mistake] = [m for m in sorted(student_solution.mistakes, key=mistake_priority)
                                          if not m.resolved]

    print(f"Found {len(unresolved_mistakes)} unresolved mistakes:")
    for m in unresolved_mistakes:
        print(f"\t{m.mistakeType.name}")

    # update student knowledge for each unresolved mistake type
    for m in unresolved_mistakes:
        student_knowledge_for(m).levelOfKnowledge = MAX_STUDENT_LEVEL_OF_KNOWLEDGE - m.numDetections

    print("Updated student knowledge for each unresolved mistake type")

    # sort highest priority mistakes based on number of detections (start with those detected the most times)
    highest_priority = unresolved_mistakes[0].mistakeType.priority



    # Return all feedbacks for now since WebCORE is not ready
    highest_priority_mistakes = unresolved_mistakes

    # highest_priority_mistakes = sorted([m for m in unresolved_mistakes if m.mistakeType.priority == highest_priority],
    #                                    key=lambda m: m.numDetections, reverse=True)

    print(f"Highest priority mistakes: {highest_priority_mistakes}")

    result: list[FeedbackItem] = []

    for m in highest_priority_mistakes:
        #student_solution.currentMistake = m  # TODO
        result.append(fb := next_feedback(m))
        print("1 >", m, fb, fb.mistake, fb.text)
        # decide whether student is beginner overall
        if student_knowledge_for(m).levelOfKnowledge < BEGINNER_LEVEL_OF_KNOWLEDGE:
            break

    resolved_mistakes: list[Mistake] = [m for m in student_solution.mistakes if m.resolved]
    for m in resolved_mistakes:
        if sk := student_knowledge_for(m):
            sk.levelOfKnowledge += m.lastFeedback.level / 2

    print(f"Returning {result}")

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
    print(type(student), Student, type(student) == Student, type(student) is Student)
    if hasattr(student, "feature"):
        print("student has feature: ", student.feature)
        if hasattr(student.feature, "eContainingClass"):
            print("student.feature has eContainingClass: ", student.feature.eContainingClass)
    # print(student.feature.eContainingClass, student.feature.eContainingClass == StudentKnowledge)
    sk = StudentKnowledge()
    print(type(sk), StudentKnowledge, type(sk) == StudentKnowledge, type(sk) is StudentKnowledge)
    sk.student = student
    sk.mistakeType=mistake.mistakeType
    sk.levelOfKnowledge=5.0
    sk.modelingAssistant=mistake.solution.modelingAssistant
    return next((sk for sk in student.studentKnowledges if sk.mistakeType == mistake.mistakeType),
                sk
                # StudentKnowledge(student=student, mistakeType=mistake.mistakeType, levelOfKnowledge=5.0,
                #                  modelingAssistant=mistake.solution.modelingAssistant)
                )


def give_feedback_for_student_cdm(student_cdm_name: str, cdm_str: str, ma: ModelingAssistant = None) -> FeedbackTO:
    "Give feedback given a student class diagram."
    # pylint: disable=protected-access
    global MODELING_ASSISTANT  # pylint: disable=global-statement
    modeling_assistant = ma or MODELING_ASSISTANT
    instructor_cdm = instructor_cdm_for(student_cdm_name)
    if instructor_cdm in modeling_assistant.classDiagramsToSolutions:
        instructor_solution = modeling_assistant.classDiagramsToSolutions[instructor_cdm]
    else:
        instructor_solution = Solution(classDiagram=instructor_cdm, modelingAssistant=modeling_assistant)
        modeling_assistant.classDiagramsToSolutions[instructor_cdm] = instructor_solution
    if cdm_str:
        student_cdm = str_to_cdm(cdm_str)
    else:
        student_cdm = student_cdm_for(student_cdm_name)
    if student_cdm in modeling_assistant.classDiagramsToSolutions:
        student_solution = modeling_assistant.classDiagramsToSolutions[student_cdm]
    else:
        # TODO Complete initialization of solution later
        #if modeling_assistant._eresource.uuid_dict
        student = modeling_assistant.students[0] or Student(
            id=str(uuid()), name=student_cdm_name, modelingAssistant=modeling_assistant)
        student_solution = Solution(modelingAssistant=modeling_assistant, student=student, classDiagram=student_cdm)
        student.currentSolution = student_solution
        modeling_assistant.classDiagramsToSolutions[student_cdm] = student_solution
    if modeling_assistant.problemStatements:
        ps = modeling_assistant.problemStatements[0]
        ps.instructorSolution = instructor_solution
        if not ps.studentSolutions:  # Only one student solution for now
            ps.studentSolutions.append(student_solution)
    else:
        modeling_assistant.problemStatements.append(
            ProblemStatement(modelingAssistant=modeling_assistant, instructorSolution=instructor_solution,
                             studentSolutions=[student_solution]))
    print(student_solution.mistakes, id(modeling_assistant))
    modeling_assistant = get_mistakes(modeling_assistant, instructor_cdm, student_cdm)
    print(student_solution.mistakes, id(modeling_assistant))
    fb_s = give_feedback(modeling_assistant.students[0].solutions[0])
    #fb = fb_s if isinstance(fb_s, FeedbackItem) else fb_s[0]  # only one feedback item for now

    if isinstance(fb_s, FeedbackItem):
        fb = fb_s
    else:
        for f in fb_s:
            print(f.mistake.mistakeType.name)
            if "class" in f.mistake.mistakeType.name.lower():
                fb = f
                break
        else:
            print("No feedback with class mistake")
            fb = None

    print("2 >",fb, fb.mistake, fb.text, fb.feedback, fb.feedback.level, fb.feedback.text)

    # if not fb.mistake:
    #     return FeedbackTO()

    print(FeedbackTO(
        solutionElements=[e.element._internal_id for e in fb.mistake.studentElements],
        instructorElements=[e.element._internal_id for e in fb.mistake.instructorElements],
        problemStatementElements=[], #[pse._internal_id for e in fb.mistake.instructorElements for pse in e],
        highlight=fb.feedback.highlightProblem or fb.feedback.highlightSolution,
        grade=0.0,  # for now
        writtenFeedback=fb.text or fb.feedback.text or "",
    ))

    return FeedbackTO(
        solutionElements=[e.element._internal_id for e in fb.mistake.studentElements],
        instructorElements=[e.element._internal_id for e in fb.mistake.instructorElements],
        problemStatementElements=[], #[pse._internal_id for e in fb.mistake.instructorElements for pse in e],
        highlight=fb.feedback.highlightProblem or fb.feedback.highlightSolution,
        grade=0.0,  # for now
        writtenFeedback=fb.text or fb.feedback.text or "",
    )


@cache
def instructor_cdm_for(student_cdm_name: str) -> ClassDiagram:
    "Return the instructor class diagram for the given student class diagram name."
    # return next((ps.instructorSolution.classDiagram for ps in MODELING_ASSISTANT.problemStatements
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
