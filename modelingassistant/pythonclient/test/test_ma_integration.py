#!/usr/bin/env python3

# None of these apply to pytests
# pylint: disable=wrong-import-position, redefined-outer-name, unused-argument

"""
Module for Modeling Assistant integration tests.

Design-wise, this is considered to be logically separate from the Modeling Assistant backends
since it involves not only them but mocks the frontend as well.

These tests assume that WebCORE and the Mistake Detection System servers are running correctly.

The Python backend must not import anything from this module.
"""

from __future__ import annotations

from threading import Thread
import os
import sys

import pytest
import requests

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from classdiagram import Class, ClassDiagram
from constants import WEBCORE_ENDPOINT
from envvars import TOUCHCORE_PATH
from flaskapp import app, DEBUG_MODE, PORT
from fileserdes import load_cdm, save_to_file
from modelingassistant_app import MODELING_ASSISTANT
from stringserdes import SRSET, str_to_modelingassistant
from user import MockStudent, User, users
from modelingassistant import ModelingAssistant, ProblemStatement, Solution


CDM_NAME = "MULTIPLE_CLASSES"
INSTRUCTOR_CDM = f"modelingassistant/testmodels/{CDM_NAME}_instructor.cdm"
MA_REST_ENDPOINT = f"http://localhost:{PORT}/modelingassistant"


@pytest.fixture(scope="module")
def ma_rest_app():
    """
    Setup the Modeling Assistant Feedback flask app if it is not already running.
    """
    if not requests.get(f"http://localhost:{PORT}/helloworld/name").ok:
        Thread(target=lambda: app.run(debug=DEBUG_MODE, port=PORT, use_reloader=False), daemon=True).start()


@pytest.fixture(scope="module")
def webcore():
    """
    Start WebCORE if it is not already running.
    """
    if not requests.get(WEBCORE_ENDPOINT).ok:
        Thread(target=lambda: os.system(f"cd {TOUCHCORE_PATH}/.. && ./start-webcore.sh"), daemon=True).start()


@pytest.mark.skip(reason="Temporarily disabled")
def test_ma_one_class_student_mistake(ma_rest_app, webcore):
    """
    Simplest possible test for the entire system.

    Scenario (this needs to be more precise):

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
    set_modeling_assistant(get_ma_with_ps(load_cdm(INSTRUCTOR_CDM)))

    # Step 1
    student = MockStudent("", "", file_name=CDM_NAME)  # TODO
    student.create_cdm()

    # Steps 2-5
    bad_cls_id = student.create_class("badClsName")
    assert bad_cls_id
    feedback = student.request_feedback()

    ma = get_modeling_assistant()
    assert ma.problemStatements[0].name
    print(ma.solutions)
    assert ma.solutions[1].classDiagram.name
    assert len(ma.solutions) >= 2

    # Step 6
    assert feedback.highlightSolutionElements
    # more strict checks possible after WebCORE is completed
    print(feedback)
    assert bad_cls_id in feedback.solutionElements

    # Steps 7-10
    airplane_id = student.create_class("Airplane")
    feedback = student.request_feedback()

    assert feedback.highlightSolutionElements  # Airplane not contained in Root class
    assert set(feedback.solutionElements) == {bad_cls_id, airplane_id}  # both should be highlighted

    # Step 11
    # TODO Enable these assertions after the necessary updates to WebCORE and the Modeling Assistant are made
    # It should be possible to delete bad_cls_id without any errors,
    # and it should be possible to make Airplane contained in the Root class once WebCORE supports this feature

    # assert not feedback.highlightSolutionElements
    # assert not feedback.solutionElements
    # assert "no mistakes" in feedback.writtenFeedback.lower()


@pytest.mark.skip(reason="Fails due to invalid WebCORE state. This test can pass only if WebCORE hasn't been called "
                         "before, but it is in fact called in the more important integration test above.")
def test_communication_between_mock_frontend_and_webcore(webcore):
    """
    Test the communication between this mock frontend and WebCORE.
    """
    student = MockStudent("", "", file_name=CDM_NAME)  # TODO
    student.create_cdm()  # no-op for now

    cdm = student.get_cdm()
    assert cdm

    # Make a new class and ensure it is added to the cdm
    airplane = student.create_class("Airplane")
    assert airplane
    assert not cdm[airplane]  # class should not be in the old cdm
    cdm = student.get_cdm()
    assert cdm[airplane]  # class should be in the new cdm
    assert cdm[airplane].name == "Airplane"

    # Repeat for multiple classes
    class_ids: list[str] = []
    for i in range(5):
        cls_name = f"Class{i}"
        cls = student.create_class(cls_name)
        class_ids.append(cls)
        assert cls
        assert not cdm[cls]  # class should not be added yet
        cdm = student.get_cdm()
        assert cdm[cls]  # class should be in the cdm now
        assert cdm[cls].name == cls_name

    # Delete the classes made in the previous loop
    for c in class_ids:
        student.delete_class(c)
        assert not student.get_cdm()[c]

    # Add attributes to the Airplane class
    for name, attr_type in (("serialNumber", "CDString"), ("numberOfSeats", "CDInt"), ("isUltrasonic", "CDBoolean")):
        attr = student.create_attribute(airplane, name, attr_type)
        assert attr
        assert not cdm[attr]
        cdm = student.get_cdm()
        assert cdm[attr]
        assert cdm[attr].name == name
        assert cdm[attr].type == cdm.type_id_for(attr_type)


@pytest.mark.skip(reason="Not yet implemented")
def test_communication_between_modeling_assistant_python_app_and_webcore(webcore):
    """
    Test the communication between the Modeling Assistant Python app and WebCORE.

    A Modeling Assistant instance has solutions with solution elements, respectively
    linked to class diagrams (accessed via WebCORE) with cdm elements.
    """


def test_webcore_user_register():
    "Test whether a new user can register with WebCORE."
    user = User.create_random_user()
    assert user
    assert user.name
    assert user.token
    assert not user.logged_in
    assert user.name in users


def test_webcore_user_login():
    "Test whether a user can login to WebCORE."
    user = User.create_random_user()
    assert user.login()
    assert user.logged_in
    assert user.token
    assert user.name in users


def test_webcore_user_logout():
    "Test whether a user can logout of WebCORE."
    user = User.create_random_user()
    assert user.login()
    assert user.logged_in
    assert user.logout()
    assert not user.logged_in
    assert not hasattr(user, "token")
    assert user.name in users  # a logged out user should still be in the users list


def get_modeling_assistant() -> ModelingAssistant:
    "Get the ModelingAssistant instance from the Flask app."
    return str_to_modelingassistant(requests.get(MA_REST_ENDPOINT).json()["modelingAssistantXmi"])


def set_modeling_assistant(ma: ModelingAssistant):
    "Set the Flask app ModelingAssistant instance."
    ma_str = SRSET.create_ma_str(ma)
    print(f">>> Setting ma_str to:\n\n{ma_str}\n\n")
    requests.post(MA_REST_ENDPOINT, json={"modelingAssistantXmi": ma_str})


def get_ma_with_ps(instructor_cdm: ClassDiagram) -> ModelingAssistant:
    """
    Create a Modeling Assistant instance with the provided parameters.
    """
    ps = ProblemStatement(name=instructor_cdm.name)
    sol = Solution(classDiagram=instructor_cdm, problemStatement=ps)
    ma = MODELING_ASSISTANT.instance
    ma.problemStatements.append(ps)
    ma.solutions.append(sol)
    assert ma.problemStatements[0].name
    assert ma.solutions[0].classDiagram.name
    return ma


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
    test_webcore_user_register()
    test_webcore_user_login()
    test_webcore_user_logout()
