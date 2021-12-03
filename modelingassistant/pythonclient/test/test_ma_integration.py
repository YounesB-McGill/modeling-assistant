#!/usr/bin/env python3
# pylint: disable=wrong-import-position

"""
Module for Modeling Assistant integration tests.

Design-wise, this is considered to be logically separate from the Modeling Assistant backends
since it involves not only them but mocks the frontend as well.

These tests assume that WebCORE and the Mistake Detection System servers are running correctly.

The Python backend must not import anything from this module.
"""

from collections import namedtuple
from collections.abc import Iterable
from random import randint
from threading import Thread
from typing import Tuple
import json
import os
import pytest
import sys

import requests

from modelingassistant_app import MODELING_ASSISTANT

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from classdiagram import Class, ClassDiagram
from constants import WEBCORE_ENDPOINT
from envvars import CORES_PATH
from feedback import FeedbackTO
from flaskapp import app, DEBUG_MODE, PORT
from fileserdes import load_cdm, save_to_file
from modelingassistant import ModelingAssistant, ProblemStatement, Solution, Student


INSTRUCTOR_CDM = "modelingassistant/testmodels/MULTIPLE_CLASSES_instructor.cdm"


@pytest.fixture(scope="module")
def ma_rest_app():
    Thread(target=lambda: app.run(debug=DEBUG_MODE, port=PORT, use_reloader=False), daemon=True).start()


@pytest.mark.skip(reason="Not yet implemented")
def test_ma_one_class_student_mistake(ma_rest_app):
    """
    Simplest possible test for the entire system.

    Scenario:

    0. Instructor sets up Learning Corpus and Modeling Assistant with one problem statement
    1. Student (with id "Student1") logs in and starts a new class diagram for that problem (Unity frontend)
    2. Student creates a class with a wrong name and requests feedback
    3. WebCORE calls the Modeling Assistant to get feedback (new cdm -> created new student solution)
    4. Modeling Assistant calls the Mistake Detection System to get mistakes
    5. Feedback algorithm calculates the feedback item (& SK) and returns it to WebCORE (highlight class name)
    6. Student sees feedback: Bad class name
    7. Student fixes mistake and requests feedback again
    8. WebCORE calls the Modeling Assistant to get feedback (for existing student solution)
    9. Modeling Assistant calls the Mistake Detection System to get mistakes
    10. Feedback algorithm calculates the feedback item (none) and returns it to WebCORE
    11. Student sees feedback: No mistakes!
    """
    # Step 0
    # use this until TC is updated to allow initializing with a cdm
    ma = get_ma_with_ps(load_cdm(INSTRUCTOR_CDM))

    # Step 1
    student = MockStudent(student_id="Student1", modelingAssistant=ma)
    student.create_cdm()

    # Steps 2-5
    bad_cls_id = student.create_class("badClsName")
    assert bad_cls_id
    feedback = student.request_feedback()

    assert ma.problemStatements[0].name
    assert ma.solutions[1].classDiagram.name
    assert len(ma.solutions) >= 2

    # Step 6
    assert feedback.highlight
    # more strict checks possible after WebCORE is completed
    print(feedback)
    assert bad_cls_id in feedback.solutionElements

    # Steps 7-10
    student.create_class("Airplane")
    feedback = student.request_feedback()

    # Step 11
    assert not feedback.highlight
    assert not feedback.solutionElements
    assert "no mistakes" in feedback.writtenFeedback.lower()


def test_communication_between_mock_frontend_and_webcore():
    """
    Test the communication between this mock frontend and WebCORE.
    """


def get_ma_with_ps(instructor_cdm: ClassDiagram) -> ModelingAssistant:
    """
    Create a Modeling Assistant instance with the provided parameters.
    """
    ps = ProblemStatement(name=instructor_cdm.name)
    sol = Solution(classDiagram=instructor_cdm, problemStatement=ps)
    ma = MODELING_ASSISTANT
    ma.problemStatements.append(ps)
    ma.solutions.append(sol)
    assert ma.problemStatements[0].name
    assert ma.solutions[0].classDiagram.name
    return ma


class MockStudent:
    """
    Mock student wrapper used for testing.
    """
    def __init__(self, student_id: str, modelingAssistant: ModelingAssistant):
        self.student = Student(id=student_id, modelingAssistant=modelingAssistant)
        self.file_name: str = ""  # assume one file name for now
        #self.eClass.ePackage.nsURI = Student.eClass.ePackage.nsURI  # pylint: disable=no-member

    def create_cdm(self):
        "Create a student class diagram."
        problem_statement = self.student.modelingAssistant.problemStatements[0]  # assume only one for now
        problem_name = problem_statement.name
        self.file_name = f"{problem_name}_{self.student.id}.cdm"
        self.file_name = "MULTIPLE_CLASSES"  # temporary workaround: tell TouchCORE about this cdm file later
        cdm = load_cdm(f"{CORES_PATH}/MULTIPLE_CLASSES/Class Diagram/MULTIPLE_CLASSES.design_class_model.cdm")  # ...
        Solution(modelingAssistant=self.student.modelingAssistant, student=self.student, classDiagram=cdm,
                 problemStatement=problem_statement)

    def create_class(self, name: str) -> str:
        "Create a class with the given name."
        old_cdm = self.get_cdm()
        resp = requests.post(f"{self.cdm_endpoint()}/class",
                             json={"className": name, "dataType": False, "isInterface": False,
                                   "x": randint(0, 600), "y": randint(0, 600)})
        resp.raise_for_status()
        new_cdm = self.get_cdm()
        print(_diff(old_cdm, new_cdm))
        cls_id = _diff(old_cdm, new_cdm).additions[0]
        print(f"Returning {cls_id}")
        return cls_id

    def request_feedback(self) -> FeedbackTO:
        "Request feedback from the Modeling Assistant via WebCORE."
        resp = requests.get(f"{self.cdm_endpoint()}/feedback")
        feedback_json = resp.json()
        print(feedback_json)
        return FeedbackTO(**feedback_json)

    def get_cdm(self) -> dict:
        "Get the class diagram from WebCORE in json format."
        resp = requests.get(self.cdm_endpoint())
        return resp.json()

    def cdm_endpoint(self) -> str:
        "Return the class diagram endpoint for the student, assuming there is only one (for now)."
        return f"{WEBCORE_ENDPOINT}/classdiagram/{self.file_name.removesuffix('.cdm')}"

    def __call__(self):
        return self.student


def _diff(old_cdm: dict, new_cdm: dict) -> Tuple[list[str], list[str]]:
    "Return the difference between the old and new cdms in the format (additions, removals)."
    def get_ids(iterable: Iterable, result: list[str] = None) -> list[str]:
        "Recursively get the _ids of the given input."
        if result is None:
            result = []
        if isinstance(iterable, list):
            for item in iterable:
                for _id in get_ids(item):
                    if _id not in result:
                        result.append(_id)
        elif isinstance(iterable, dict):
            for key, value in iterable.items():
                if key == "_id" and value not in result:
                    result.append(value)
                else:
                    for _id in get_ids(value, result):
                        if _id not in result:
                            result.append(_id)
        return result

    old_ids, new_ids = get_ids(old_cdm), get_ids(new_cdm)
    result_template = namedtuple("result", "additions, removals")
    additions = [_id for _id in new_ids if _id not in old_ids]
    removals = [_id for _id in old_ids if _id not in new_ids]
    return result_template(additions, removals)


def _get_by_id(_id: str, iterable: Iterable) -> str:
    "Get the item with the given _id by recursing into the iterable."
    if isinstance(iterable, list):
        for item in iterable:
            if hasattr(item, "get") and _id == item.get("_id", None):
                return item
            if result := _get_by_id(_id, item):
                return result
    elif isinstance(iterable, dict):
        for key, value in iterable.items():
            if (key, value) == ("_id", _id):
                return iterable
            if result := _get_by_id(_id, value):
                return result
    return None


def _setup_instructor_solution():
    """
    Setup the instructor solution by modifying the instructor cdm file.
    It is only meant to be called when the cdm needs to be modified.
    """
    instructor_cdm = load_cdm(INSTRUCTOR_CDM, use_static_classes=False)
    instructor_cdm.name = "MULTIPLE_CLASSES_instructor"
    airplane_cls = Class(name="Airplane")
    airplane_cls.__class__ = instructor_cdm.classes[0].__class__  # do this hack for now
    instructor_cdm.classes.append(airplane_cls)
    save_to_file(INSTRUCTOR_CDM, instructor_cdm)


if __name__ == '__main__':
    "Main entry point."
