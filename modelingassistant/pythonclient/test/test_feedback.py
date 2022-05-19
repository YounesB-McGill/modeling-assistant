#!/usr/bin/env python3
# pylint: disable=wrong-import-position

"""
Tests for feedback algorithm.
"""

from threading import Thread
from time import sleep
import os
import json
import sys

from requests.models import Response
import requests
import pytest  # (to allow tests to be skipped) pylint: disable=unused-import

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from classdiagram import Association, Class, ClassDiagram
from constants import MANY
from feedback import give_feedback, give_feedback_for_student_cdm
from fileserdes import load_cdm
from learningcorpus import Feedback, ParametrizedResponse, Reference, ResourceResponse, TextResponse, Quiz
from mistaketypes import (BAD_CLASS_NAME_SPELLING, INCOMPLETE_CONTAINMENT_TREE, MISSING_CLASS,
    SOFTWARE_ENGINEERING_TERM, WRONG_MULTIPLICITY)
from stringserdes import SRSET, str_to_modelingassistant
from utils import ae
from modelingassistant import (FeedbackItem, Mistake, ModelingAssistant, ProblemStatement, Solution, SolutionElement,
    Student, StudentKnowledge)


HOST = "localhost"
PORT = 8539

DELAY = 20  # seconds


def make_ma_without_mistakes() -> ModelingAssistant:
    "Make a simple Modeling Assistant instance with no mistakes."
    ma = ModelingAssistant()
    bus_ps = ProblemStatement(name="Bus Management System", modelingAssistant=ma)
    alice = Student(name="Alice", modelingAssistant=ma)
    StudentKnowledge(mistakeType=SOFTWARE_ENGINEERING_TERM, student=alice, modelingAssistant=ma)
    # Need to set both ends of ProblemStatement-Solution relationship manually since is actually 3 one-way relationships
    inst_sol = Solution(problemStatement=bus_ps, modelingAssistant=ma)
    bus_ps.instructorSolution = inst_sol
    alice_bus_sol = Solution(student=alice, problemStatement=bus_ps, modelingAssistant=ma)
    bus_ps.studentSolutions.append(alice_bus_sol)
    alice.currentSolution = alice_bus_sol
    return ma


def make_ma_with_1_sw_eng_term_mistake(num_detection: int=1) -> ModelingAssistant:
    """
    Make a simple Modeling Assistant instance with one Software engineering term mistake, detected `num_detection`
    times.
    """
    ma = make_ma_without_mistakes()
    inst_sol = ma.problemStatements[0].instructorSolution
    alice_bus_sol = ma.problemStatements[0].studentSolutions[0]
    bus_cls = SolutionElement(solution=inst_sol, element=Class(name="Bus"))
    bus_data_cls = SolutionElement(solution=alice_bus_sol, element=Class(name="BusData"))
    set_mistake = Mistake(solution=alice_bus_sol, mistakeType=SOFTWARE_ENGINEERING_TERM, numDetections=num_detection,
                          studentElements=[bus_data_cls], instructorElements=[bus_cls])
    if num_detection > 1:
        set_mistake.lastFeedback = FeedbackItem(feedback=Feedback(level=num_detection - 1))
    return ma


def make_ma_with_1_wrong_mult_mistake(num_detection: int=1) -> ModelingAssistant:
    """
    Make a simple Modeling Assistant instance with one Wrong multiplicity mistake, detected `num_detection` times.
    """
    ma = make_ma_without_mistakes()
    inst_sol = ma.problemStatements[0].instructorSolution
    stud_sol = ma.problemStatements[0].studentSolutions[0]
    # a bus has only one garage, but a garage has multiple buses
    inst_bus_cls = SolutionElement(solution=inst_sol, element=Class(name="Bus"))
    inst_garage_cls = SolutionElement(solution=inst_sol, element=Class(name="Garage"))
    SolutionElement(solution=inst_sol, element=Association(ends=[
        inst_bus_garage := ae(inst_bus_cls.element, n="garage"),
        ae(inst_garage_cls.element, 0, MANY, n="bus")]))
    stud_bus_cls = SolutionElement(solution=stud_sol, element=Class(name="Bus"))
    stud_garage_cls = SolutionElement(solution=stud_sol, element=Class(name="Garage"))
    SolutionElement(solution=stud_sol, element=Association(ends=[
        stud_bus_garage := ae(stud_bus_cls.element, ub=MANY, n="garage"),  # mistake is here: bus only has one garage
        ae(stud_garage_cls.element, 0, MANY, n="bus")]))
    wm_mistake = Mistake(solution=stud_sol, mistakeType=WRONG_MULTIPLICITY, numDetections=num_detection,
                         studentElements=[SolutionElement(solution=stud_sol, element=stud_bus_garage)],
                         instructorElements=[SolutionElement(solution=inst_sol, element=inst_bus_garage)])
    if num_detection > 1:
        wm_mistake.lastFeedback = FeedbackItem(feedback=Feedback(level=num_detection - 1))
    return ma


def make_ma_with_airline_system() -> ModelingAssistant:
    "Create a Modeling Assistant instance with instructor and student solutions for an airline system."
    inst_cdm = load_cdm("modelingassistant/testmodels/AirlineSystem_instructor.cdm")
    stud_cdm = load_cdm("modelingassistant/testmodels/AirlineSystem_student.cdm")
    ma = ModelingAssistant()
    airline_system_ps = ProblemStatement(name="Airline System", modelingAssistant=ma)
    alice = Student(name="Alice", modelingAssistant=ma)
    inst_sol = Solution(modelingAssistant=ma, classDiagram=inst_cdm, problemStatement=airline_system_ps)
    stud_sol = Solution(modelingAssistant=ma, classDiagram=stud_cdm, problemStatement=airline_system_ps, student=alice)
    airline_system_ps.instructorSolution = inst_sol
    airline_system_ps.studentSolutions.append(stud_sol)
    return ma


def test_feedback_without_mistakes():
    "Test feedback for a solution without any mistakes."
    solution = make_ma_without_mistakes().problemStatements[0].studentSolutions[0]
    feedback_item = give_feedback(solution)
    assert "no mistakes found" in feedback_item.feedback.text.lower()


def test_feedback_with_1_sw_eng_term_mistake_level_1():
    """
    Test feedback for a solution with one mistake made a first time.

    BusData detected for first time -> highlight BusData
    """
    ma = make_ma_with_1_sw_eng_term_mistake(1)
    solution = ma.problemStatements[0].studentSolutions[0]
    feedback_item = give_feedback(solution)
    curr_mistake = feedback_item.mistake

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, Feedback)
    assert 1 == feedback.level
    assert feedback.highlightSolution
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 9 == ma.studentKnowledges[0].levelOfKnowledge


def test_feedback_with_1_sw_eng_term_mistake_level_2():
    """
    Test feedback for a solution with one mistake made a second time.

    BusData (or similar) detected for second time -> text response
    """
    ma = make_ma_with_1_sw_eng_term_mistake(2)
    solution = ma.problemStatements[0].studentSolutions[0]
    feedback_item = give_feedback(solution)
    curr_mistake = feedback_item.mistake

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, TextResponse)
    assert 2 == feedback.level
    assert not feedback.highlightSolution
    assert "software engineering term" in feedback.text
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 8 == ma.studentKnowledges[0].levelOfKnowledge


def test_feedback_with_1_sw_eng_term_mistake_level_3():
    """
    Test feedback for a solution with one mistake made a third time.

    BusData (or similar) detected for third time -> parameterized response
    """
    ma = make_ma_with_1_sw_eng_term_mistake(3)
    solution = ma.problemStatements[0].studentSolutions[0]
    feedback_item = give_feedback(solution)
    curr_mistake = feedback_item.mistake

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, ParametrizedResponse)
    assert 3 == feedback.level
    assert not feedback.highlightSolution
    assert "software engineering term" in feedback.text
    assert "BusData" in feedback_item.text
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 7 == ma.studentKnowledges[0].levelOfKnowledge


def test_feedback_with_1_sw_eng_term_mistake_level_4():
    """
    Test feedback for a solution with one mistake made a fourth time.

    BusData (or similar) detected for fourth time -> resource response with example
    """
    ma = make_ma_with_1_sw_eng_term_mistake(4)
    solution = ma.problemStatements[0].studentSolutions[0]
    feedback_item = give_feedback(solution)
    curr_mistake = feedback_item.mistake

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, ResourceResponse)
    assert 4 == feedback.level
    assert not feedback.highlightSolution
    resource_content = feedback.learningResources[0].content
    assert "incorrect class naming" in resource_content
    assert ":x: Examples to avoid | :heavy_check_mark: Good class names" in resource_content
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 6 == ma.studentKnowledges[0].levelOfKnowledge


def test_feedback_with_1_sw_eng_term_mistake_levels_1_4():
    """
    Test feedback for a solution with one mistake made four times in a row.

    BusData detected 4 times -> 4 levels of feedback, given one at a time.
    """
    ma = make_ma_with_1_sw_eng_term_mistake(1)
    solution = ma.problemStatements[0].studentSolutions[0]
    feedback_item = give_feedback(solution)
    curr_mistake = feedback_item.mistake

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, Feedback)
    assert 1 == feedback.level
    assert feedback.highlightSolution
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 9 == ma.studentKnowledges[0].levelOfKnowledge

    ma.problemStatements[0].studentSolutions[0].mistakes[0].numDetections += 1
    feedback_item = give_feedback(solution)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, TextResponse)
    assert 2 == feedback.level
    assert not feedback.highlightSolution
    assert "software engineering term" in feedback.text
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 8 == ma.studentKnowledges[0].levelOfKnowledge

    ma.problemStatements[0].studentSolutions[0].mistakes[0].numDetections += 1
    feedback_item = give_feedback(solution)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, ParametrizedResponse)
    assert 3 == feedback.level
    assert not feedback.highlightSolution
    assert "software engineering term" in feedback.text
    assert "BusData" in feedback_item.text
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 7 == ma.studentKnowledges[0].levelOfKnowledge

    ma.problemStatements[0].studentSolutions[0].mistakes[0].numDetections += 1
    feedback_item = give_feedback(solution)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, ResourceResponse)
    assert 4 == feedback.level
    assert not feedback.highlightSolution
    resource_content = feedback.learningResources[0].content
    assert "incorrect class naming" in resource_content
    assert ":x: Examples to avoid | :heavy_check_mark: Good class names" in resource_content
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 6 == ma.studentKnowledges[0].levelOfKnowledge


def test_feedback_with_1_wrong_mult_mistake_level_1():
    """
    Test feedback for a solution with one mistake made a first time.

    Wrong multiplicity detected 1 time -> highlight solution
    """
    ma = make_ma_with_1_wrong_mult_mistake(1)
    solution = ma.problemStatements[0].studentSolutions[0]
    feedback_item = give_feedback(solution)
    curr_mistake = feedback_item.mistake
    wrong_mult_sk = next(sk for sk in ma.studentKnowledges if sk.mistakeType is curr_mistake.mistakeType)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, Feedback)
    assert 1 == feedback.level
    assert feedback.highlightSolution
    assert curr_mistake.mistakeType is feedback.mistakeType
    wrong_mult_sk = next(sk for sk in ma.studentKnowledges if sk.mistakeType is curr_mistake.mistakeType)
    assert 9 == wrong_mult_sk.levelOfKnowledge


def test_feedback_with_1_wrong_mult_mistake_level_2():
    """
    Test feedback for a solution with one mistake made a second time.

    Wrong multiplicity detected 2 times -> text response
    """
    ma = make_ma_with_1_wrong_mult_mistake(2)
    solution = ma.problemStatements[0].studentSolutions[0]
    feedback_item = give_feedback(solution)
    curr_mistake = feedback_item.mistake
    wrong_mult_sk = next(sk for sk in ma.studentKnowledges if sk.mistakeType is curr_mistake.mistakeType)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, TextResponse)
    assert 2 == feedback.level
    assert not feedback.highlightSolution
    assert "Double check this association" in feedback.text
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 8 == wrong_mult_sk.levelOfKnowledge


def test_feedback_with_1_wrong_mult_mistake_level_3():
    """
    Test feedback for a solution with one mistake made a third time.

    Wrong multiplicity detected 3 times -> more detailed text response
    """
    ma = make_ma_with_1_wrong_mult_mistake(3)
    solution = ma.problemStatements[0].studentSolutions[0]
    feedback_item = give_feedback(solution)
    curr_mistake = feedback_item.mistake
    wrong_mult_sk = next(sk for sk in ma.studentKnowledges if sk.mistakeType is curr_mistake.mistakeType)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, TextResponse)
    assert 3 == feedback.level
    assert not feedback.highlightSolution
    assert "multiplicity" in feedback.text
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 7 == wrong_mult_sk.levelOfKnowledge


def test_feedback_with_1_wrong_mult_mistake_level_4():
    """
    Test feedback for a solution with one mistake made a fourth time.

    Wrong multiplicity detected 4 times -> parametrized response
    """
    ma = make_ma_with_1_wrong_mult_mistake(4)
    solution = ma.problemStatements[0].studentSolutions[0]
    feedback_item = give_feedback(solution)
    curr_mistake = feedback_item.mistake
    wrong_mult_sk = next(sk for sk in ma.studentKnowledges if sk.mistakeType is curr_mistake.mistakeType)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, ParametrizedResponse)
    assert 4 == feedback.level
    assert not feedback.highlightSolution
    assert "instances" in feedback.text
    assert "Garage" in feedback_item.text
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 6 == wrong_mult_sk.levelOfKnowledge


def test_feedback_with_1_wrong_mult_mistake_level_5():
    """
    Test feedback for a solution with one mistake made a fifth time.

    Wrong multiplicity detected 5 times -> resource response with quiz
    """
    ma = make_ma_with_1_wrong_mult_mistake(5)
    solution = ma.problemStatements[0].studentSolutions[0]
    feedback_item = give_feedback(solution)
    curr_mistake = feedback_item.mistake
    wrong_mult_sk = next(sk for sk in ma.studentKnowledges if sk.mistakeType is curr_mistake.mistakeType)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, ResourceResponse)
    assert isinstance(feedback.learningResources[0], Quiz)
    assert 5 == feedback.level
    assert not feedback.highlightSolution
    resource_content = feedback.learningResources[0].content
    assert "Pick the association" in resource_content
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 5 == wrong_mult_sk.levelOfKnowledge


def test_feedback_with_1_wrong_mult_mistake_level_6():
    """
    Test feedback for a solution with one mistake made a sixth time.

    Wrong multiplicity detected 6 times -> resource response with reference
    """
    ma = make_ma_with_1_wrong_mult_mistake(6)
    solution = ma.problemStatements[0].studentSolutions[0]
    feedback_item = give_feedback(solution)
    curr_mistake = feedback_item.mistake
    wrong_mult_sk = next(sk for sk in ma.studentKnowledges if sk.mistakeType is curr_mistake.mistakeType)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, ResourceResponse)
    assert isinstance(feedback.learningResources[0], Reference)
    assert 6 == feedback.level
    assert not feedback.highlightSolution
    resource_content = feedback.learningResources[0].content
    assert "multiplicities" in resource_content
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 4 == wrong_mult_sk.levelOfKnowledge


def test_feedback_with_1_mistake_levels_1_6():
    """
    Test feedback for a solution with one mistake made six times in a row.

    Wrong multiplicity detected 6 times -> 6 levels of feedback, given one at a time.
    """
    ma = make_ma_with_1_wrong_mult_mistake(1)
    solution = ma.problemStatements[0].studentSolutions[0]
    feedback_item = give_feedback(solution)
    curr_mistake = feedback_item.mistake

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, Feedback)
    assert 1 == feedback.level
    assert feedback.highlightSolution
    assert curr_mistake.mistakeType is feedback.mistakeType
    wrong_mult_sk = next(sk for sk in ma.studentKnowledges if sk.mistakeType is curr_mistake.mistakeType)
    assert 9 == wrong_mult_sk.levelOfKnowledge

    ma.problemStatements[0].studentSolutions[0].mistakes[0].numDetections += 1
    feedback_item = give_feedback(solution)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, TextResponse)
    assert 2 == feedback.level
    assert not feedback.highlightSolution
    assert "Double check this association" in feedback.text
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 8 == wrong_mult_sk.levelOfKnowledge

    ma.problemStatements[0].studentSolutions[0].mistakes[0].numDetections += 1
    feedback_item = give_feedback(solution)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, TextResponse)
    assert 3 == feedback.level
    assert not feedback.highlightSolution
    assert "multiplicity" in feedback.text
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 7 == wrong_mult_sk.levelOfKnowledge

    ma.problemStatements[0].studentSolutions[0].mistakes[0].numDetections += 1
    feedback_item = give_feedback(solution)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, ParametrizedResponse)
    assert 4 == feedback.level
    assert not feedback.highlightSolution
    assert "instances" in feedback.text
    assert "Garage" in feedback_item.text
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 6 == wrong_mult_sk.levelOfKnowledge

    ma.problemStatements[0].studentSolutions[0].mistakes[0].numDetections += 1
    feedback_item = give_feedback(solution)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, ResourceResponse)
    assert isinstance(feedback.learningResources[0], Quiz)
    assert 5 == feedback.level
    assert not feedback.highlightSolution
    resource_content = feedback.learningResources[0].content
    assert "Pick the association" in resource_content
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 5 == wrong_mult_sk.levelOfKnowledge

    ma.problemStatements[0].studentSolutions[0].mistakes[0].numDetections += 1
    feedback_item = give_feedback(solution)

    assert feedback_item.solution is solution
    assert curr_mistake.lastFeedback is feedback_item
    feedback = feedback_item.feedback
    assert isinstance(feedback, ResourceResponse)
    assert isinstance(feedback.learningResources[0], Reference)
    assert 6 == feedback.level
    assert not feedback.highlightSolution
    resource_content = feedback.learningResources[0].content
    assert "multiplicities" in resource_content
    assert curr_mistake.mistakeType is feedback.mistakeType
    assert 4 == wrong_mult_sk.levelOfKnowledge


def get_mistakes(ma: ModelingAssistant, instructor_cdm: ClassDiagram, student_cdm: ClassDiagram) -> ModelingAssistant:
    """
    Return the mistakes of the given student solution given the instructor solution and a modeling assistant context
    by calling the Mistake Detection System. If the latter is not running, it will be started.

    This function is similar to the one in the modeling assistant, but it includes additional assertions.
    """
    def call_mistake_detection_system(ma_str: str) -> Response:
        return requests.get(f"http://{HOST}:{PORT}/detectmistakes", {"modelingassistant": ma_str})

    ma_str = SRSET.create_ma_str(ma)
    assert ma_str

    try:
        req = call_mistake_detection_system(ma_str)
    except Exception:  # pylint: disable=broad-except
        # Turn on Modeling Assistant REST API server if not already running
        Thread(target=lambda: os.system("cd modelingassistant.restapi && mvn spring-boot:run"), daemon=True).start()
        sleep(DELAY)
        req = call_mistake_detection_system(ma_str)

    req_content = json.loads(req.content)
    assert 200 == req.status_code
    assert "modelingAssistantXmi" in req_content

    ma_str = bytes(req_content["modelingAssistantXmi"], "utf-8")
    ma = str_to_modelingassistant(ma_str)
    assert ma
    return ma


#@pytest.mark.skip(reason="Longer test time")
def test_feedback_for_modeling_assistant_instance_with_mistakes_from_mistake_detection_system():
    """
    Test feedback for a modeling assistant instance with mistakes detected from the actual mistake detection system.
    """
    # TODO Extract common functionality into helper functions
    instructor_cdm = load_cdm("mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classBus/"
                              "Class Diagram/Instructor_classBus.domain_model.cdm")
    student_cdm = load_cdm("mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_wrongClassName/"
                           "Class Diagram/Student_wrongClassName.domain_model.cdm")
    ma = ModelingAssistant()
    bob = Student(name="Bob", modelingAssistant=ma)
    StudentKnowledge(mistakeType=BAD_CLASS_NAME_SPELLING, student=bob, modelingAssistant=ma)
    instructor_sol = Solution(modelingAssistant=ma, classDiagram=instructor_cdm)
    bob_sol = Solution(modelingAssistant=ma, classDiagram=student_cdm, student=bob)
    bus_ps = ProblemStatement(name="Bus Management System", modelingAssistant=ma,
                              instructorSolution=instructor_sol,
                              studentSolutions=[bob_sol])
    instructor_sol.problemStatement = bus_ps
    bob_sol.problemStatement = bus_ps
    bob.currentSolution = bob_sol

    ma = get_mistakes(ma, instructor_cdm, student_cdm)

    assert bus_ps.name == ma.problemStatements[0].name

    bus_ps = ma.problemStatements[0]
    bob_sol = bus_ps.studentSolutions[0]
    assert bob.name == bob_sol.student.name
    assert bob_sol.mistakes

    bob = bob_sol.student
    buse_mistake = bob_sol.mistakes[0]
    assert BAD_CLASS_NAME_SPELLING == buse_mistake.mistakeType

    feedback_item = give_feedback(bob_sol)
    feedback = feedback_item.feedback
    assert isinstance(feedback, Feedback)
    assert 1 == feedback.level
    assert feedback.highlightSolution
    assert 9 == ma.studentKnowledges[0].levelOfKnowledge


#@pytest.mark.skip(reason="Test needs to be updated")
def test_feedback_for_serialized_modeling_assistant_instance_with_mistakes_from_mistake_detection_system():
    """
    Test feedback for a serialized modeling assistant instance with mistakes detected from the mistake detection system.
    """
    # pylint: disable=protected-access
    ma = make_ma_with_airline_system()
    fb, ma = give_feedback_for_student_cdm(ma.students[0].solutions[0].classDiagram, ma=ma)

    solution: Solution = ma.students[0].solutions[0]
    mistakes: list[Mistake] = solution.mistakes
    missing_class_mistake = mistakes[0]

    assert missing_class_mistake.mistakeType == MISSING_CLASS
    assert fb.highlightProblemStatementElements
    assert fb.instructorElements[0] == missing_class_mistake.instructorElements[0].element._internal_id

    cdm: ClassDiagram = solution.classDiagram
    cdm.__class__ = ClassDiagram
    airplane_class = Class(name="Airplane")
    cdm.classes.append(airplane_class)

    with open("modelingassistant/testinstances/ma_test2.modelingassistant", "w", encoding="utf-8") as f:
        f.write(SRSET.create_ma_str(ma))

    fb, ma = give_feedback_for_student_cdm(cdm, ma=ma)
    solution = next(sol for sol in ma.solutions if sol.student)  # false positive: pylint: disable=no-member
    mistakes: list[Mistake] = solution.mistakes

    assert fb.highlightSolutionElements
    assert solution.mistakes[0].mistakeType == INCOMPLETE_CONTAINMENT_TREE


if __name__ == '__main__':
    "Main entry point (used for debugging)."
    test_feedback_for_serialized_modeling_assistant_instance_with_mistakes_from_mistake_detection_system()
