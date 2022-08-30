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

from time import sleep
from threading import Thread
import os
import sys

from pyecore.ecore import EClass
import pytest
import requests

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from classdiagram import CDBoolean, CDInt, CDString, Class, ClassDiagram
from constants import MANY, WEBCORE_ENDPOINT
from envvars import TOUCHCORE_PATH
from flaskapp import app, DEBUG_MODE, PORT
from fileserdes import load_cdm, save_to_file
from modelingassistant_app import MODELING_ASSISTANT
from stringserdes import SRSET, str_to_modelingassistant
from user import MockStudent, User, users
from modelingassistant import ModelingAssistant, ProblemStatement, Solution


CDM_NAME = "AirlineSystem"
INSTRUCTOR_CDM = f"modelingassistant/testmodels/{CDM_NAME}_instructor.cdm"
MA_REST_ENDPOINT = f"http://localhost:{PORT}/modelingassistant"

SLEEP_TIME_S = 0.2  # 1/5 second

# Skip all pytest tests in this module by setting the pytestmark global variable
pytestmark = pytest.mark.skip("Skipping all integrations tests since they depend on the WebCORE server")


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
    try:
        requests.get(WEBCORE_ENDPOINT)
    except (ConnectionError, requests.exceptions.RequestException):
        Thread(target=lambda: os.system(f"cd {TOUCHCORE_PATH}/.. && ./start-webcore.sh"), daemon=True).start()


def test_ma_two_class_student_mistake(ma_rest_app, webcore):
    """
    Simplest possible test for the entire system.

    Scenario:

    0. Instructor sets up Learning Corpus and Modeling Assistant with one problem statement
    1. Student logs in and starts a new class diagram for that problem (this mocks the frontend)
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
    # use this until WebCORE is updated to allow initializing with a problem statement
    ma = get_ma_with_ps(load_cdm(INSTRUCTOR_CDM))
    assert valid(ma)
    set_modeling_assistant(ma)

    # Step 1
    student = MockStudent.create_random()
    cdm_name = "AirlineSystem"
    assert student.create_cdm(cdm_name)

    # Steps 2-5
    bad_cls_id = student.create_class(cdm_name, "badClsName")
    assert bad_cls_id
    feedback = student.request_feedback(cdm_name)

    ma = get_modeling_assistant()
    assert valid(ma)
    assert ma.problemStatements[0].name
    print(ma.solutions)
    assert ma.solutions[1].classDiagram.name
    assert len(ma.solutions) == 2, "Must have exactly one instructor solution and one student solution"

    # Step 6
    assert feedback.highlightSolutionElements
    # more strict checks possible after WebCORE is completed
    print(feedback)
    assert bad_cls_id in feedback.solutionElements

    # Steps 7-10
    airplane_id = student.create_class(cdm_name, "Airplane")
    feedback = student.request_feedback(cdm_name)

    assert feedback.highlightSolutionElements  # Airplane not contained in Root class
    assert set(feedback.solutionElements) == {bad_cls_id, airplane_id}  # both should be highlighted

    # Step 11
    # TODO Enable these assertions after the necessary updates to WebCORE and the Modeling Assistant are made
    # It should be possible to delete bad_cls_id without any errors,
    # and it should be possible to make Airplane contained in the Root class once WebCORE supports this feature

    # assert not feedback.highlightSolutionElements
    # assert not feedback.solutionElements
    # assert "no mistakes" in feedback.writtenFeedback.lower()


def test_communication_between_mock_frontend_and_webcore(webcore):
    """
    Test the communication between this mock frontend and WebCORE.
    """
    # pylint: disable=too-many-locals, too-many-statements, protected-access
    student = MockStudent.create_random()
    cdm_name = "AirlineSystem"
    assert student.create_cdm(cdm_name)

    cdm = student.get_cdm(cdm_name)
    assert cdm

    # Make a new class and ensure it is added to the cdm
    airplane = student.create_class(cdm_name, "Airplane")
    assert airplane
    assert not cdm[airplane]  # class should not be in the old cdm
    cdm = student.get_cdm(cdm_name)
    assert cdm[airplane]  # class should be in the new cdm
    assert cdm[airplane].name == "Airplane"

    # Repeat for multiple numbered classes (Class0, ..., Class5)
    class_ids: list[str] = []
    for i in range(5):
        cls_name = f"Class{i}"
        cls = student.create_class(cdm_name, cls_name)
        class_ids.append(cls)
        assert cls
        assert not cdm[cls]  # class should not be added yet
        cdm = student.get_cdm(cdm_name)
        assert cdm[cls]  # class should be in the cdm now
        assert cdm[cls].name == cls_name

    # Delete the numbered classes made in the previous loop
    for c in class_ids:
        student.delete_class(cdm_name, c)
        assert not student.get_cdm(cdm_name)[c]

    # Add and then delete attributes of the Airplane class
    attrs: dict[str, EClass] = {"serialNumber": CDString, "numberOfSeats": CDInt, "isUltrasonic": CDBoolean}
    attr_ids: list[str] = []

    for attr_name, attr_type in attrs.items():
        attr = student.create_attribute(cdm_name, airplane, attr_name, attr_type)
        assert attr
        assert not cdm[attr]
        cdm = student.get_cdm(cdm_name)
        assert cdm[attr]
        assert cdm[attr].name == attr_name
        assert cdm[attr].type == cdm.type_id_for(attr_type)
        attr_ids.append(attr)

    for attr_id in attr_ids:
        student.delete_attribute(cdm_name, attr_id)
        cdm = student.get_cdm(cdm_name)
        assert not cdm[attr_id]

    # Add Pilot and Person classes
    pilot = student.create_class(cdm_name, "Pilot")
    person = student.create_class(cdm_name, "Person")
    assert pilot and person
    cdm = student.get_cdm(cdm_name)

    assert cdm[pilot] and cdm[person]

    # Add the following relationships
    # Pilot isA Person
    pilot, person = student.create_generalization(cdm_name, pilot, person)
    cdm = student.get_cdm(cdm_name)
    assert cdm[pilot] and cdm[person]
    assert person in cdm[pilot].superTypes
    assert pilot not in cdm[person].superTypes

    # 1..2 Pilot pilots -- * Airplane airplanes
    airplane = cdm.get_ids_by_class_names()["Airplane"]
    pilot, pilots, pilot_airplane, airplanes, airplane = student.create_association(
        cdm_name, (1, 2), pilot, "pilots", MANY, airplane, "airplanes")
    cdm = student.get_cdm(cdm_name)
    assert all((cdm[pilot], cdm[pilots], cdm[pilot_airplane], cdm[airplanes], cdm[airplane]))
    assert cdm[pilot].name == "Pilot"
    assert cdm[pilots].name == "pilots"
    assert pilots in [ae._id for ae in cdm[airplane].associationEnds]  # Airplane.pilots
    assert cdm[pilots].lowerBound == 1 and cdm[pilots].upperBound == 2
    assert set(cdm[pilot_airplane].ends) == {pilots, airplanes}
    assert cdm[airplanes].name == "airplanes"
    assert airplanes in [ae._id for ae in cdm[pilot].associationEnds]  # Pilot.airplanes
    assert cdm[airplanes].lowerBound == cdm[airplanes].upperBound == MANY
    assert cdm[airplane].name == "Airplane"
    assert person in cdm[pilot].superTypes  # make sure previous assertion still holds

    # * Person passengers -- * Airplane airplanes
    person = cdm.get_ids_by_class_names()["Person"]
    airplane = cdm.get_ids_by_class_names()["Airplane"]
    person, passengers, passenger_airplane, airplanes, airplane = student.create_association(
        cdm_name, MANY, person, "passengers", MANY, airplane, "airplanes")
    cdm = student.get_cdm(cdm_name)
    assert all((cdm[person], cdm[passengers], cdm[passenger_airplane], cdm[airplanes], cdm[airplane]))
    assert cdm[person].name == "Person"
    assert cdm[passengers].name == "passengers"
    assert passengers in [ae._id for ae in cdm[airplane].associationEnds]  # Airplane.passengers
    assert cdm[passengers].lowerBound == cdm[passengers].upperBound == MANY
    assert set(cdm[passenger_airplane].ends) == {passengers, airplanes}
    assert cdm[airplanes].name == "airplanes"
    assert airplanes in [ae._id for ae in cdm[person].associationEnds]  # Person.airplanes
    assert cdm[airplanes].lowerBound == cdm[airplanes].upperBound == MANY
    assert cdm[airplane].name == "Airplane"
    assert person in cdm[pilot].superTypes

    # 1 Airplane airplane <@>- 1..4 Engine engines
    engine = student.create_class(cdm_name, "Engine")
    airplane = cdm.get_ids_by_class_names()["Airplane"]
    airplane, airplane_ae, airplane_engine, engines, engine = student.create_composition(
        cdm_name, 1, airplane, "airplane", (1, 4), engine, "engines")
    cdm = student.get_cdm(cdm_name)
    assert all((cdm[airplane], cdm[airplane_ae], cdm[airplane_engine], cdm[engines], cdm[engine]))
    assert cdm[airplane].name == "Airplane"
    assert cdm[airplane_ae].name == "airplane"
    assert cdm[airplane_ae].lowerBound == 1 and cdm[airplane_ae].upperBound == 1
    assert set(cdm[airplane_engine].ends) == {airplane_ae, engines}
    assert cdm[engines].name == "engines"
    assert engines in [ae._id for ae in cdm[airplane].associationEnds]  # Airplane.engines
    assert cdm[engines].lowerBound == 1 and cdm[engines].upperBound == 4
    assert cdm[engine].name == "Engine"
    assert person in cdm[pilot].superTypes


def test_communication_between_mock_frontend_and_webcore_multiple_students(webcore):
    """
    Test the communication between this mock frontend and WebCORE with multiple students.
    """
    for _ in range(3):
        print(f"Creating student {_}")
        student = MockStudent.create_random()
        assert student.login() and student.logged_in
        # Logout logic is currently faulty, so uncommenting the lines below will cause the create_cdm() call to fail
        # assert student.logout() and not student.logged_in
        # assert student.login() and student.logged_in
        assert student.create_cdm(CDM_NAME)
        assert student.get_cdm(CDM_NAME)
        sleep(SLEEP_TIME_S)


@pytest.mark.skip(reason="Not yet implemented")
def test_communication_between_modeling_assistant_python_app_and_webcore(webcore):
    """
    Test the communication between the Modeling Assistant Python app and WebCORE.

    A Modeling Assistant instance has solutions with solution elements, respectively
    linked to class diagrams (accessed via WebCORE) with cdm elements.
    """


def test_webcore_user_register():
    "Test whether a new user can register with WebCORE."
    user = User.create_random()
    assert user
    assert user.name
    assert user.token
    assert not user.logged_in
    assert user.name in users


def test_webcore_user_login():
    "Test whether a user can login to WebCORE."
    user = User.create_random()
    assert user.login()
    assert user.logged_in
    assert user.token
    assert user.name in users


def test_webcore_user_logout():
    "Test whether a user can logout of WebCORE."
    user = User.create_random()
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
    ma = MODELING_ASSISTANT.instance
    ps = ProblemStatement(name=instructor_cdm.name.removesuffix("_instructor"), modelingAssistant=ma)
    sol = Solution(classDiagram=instructor_cdm, problemStatement=ps, modelingAssistant=ma)
    ps.instructorSolution = sol
    ma.problemStatements.append(ps)
    ma.solutions.append(sol)
    assert ma.problemStatements[0].name
    assert ma.solutions[0].classDiagram.name
    return ma


def valid(ma: ModelingAssistant) -> bool:
    """
    Check whether the provided Modeling Assistant instance is valid.
    """
    assert ma
    for ps in ma.problemStatements:
        assert ps.instructorSolution
    for sol in ma.solutions:
        assert sol.classDiagram
        assert sol.problemStatement
    assert ma.eResource
    assert ma.eResource.contents
    assert ma in ma.eResource.contents
    assert ma.eResource.uuid_dict
    return True


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
    test_communication_between_mock_frontend_and_webcore(webcore)
    test_ma_two_class_student_mistake(ma_rest_app, webcore)
    # run again to ensure WebCORE still works after the previous test
    test_communication_between_mock_frontend_and_webcore(webcore)
