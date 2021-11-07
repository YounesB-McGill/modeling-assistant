#!/usr/bin/env python3

"""
Module for Modeling Assistant integration tests.

Design-wise, this is considered to be logically separate from the Modeling Assistant backends
since it involves not only them but mocks the frontend as well.

These tests assume that WebCORE and the Mistake Detection System servers are running correctly.

The Python backend must not import anything from this module.
"""

import json
import pytest

from classdiagram import ClassDiagram
from feedback import FeedbackTO
from fileserdes import load_cdm
from modelingassistant import ModelingAssistant, ProblemStatement, Solution, Student


@pytest.mark.skip(reason="Not yet implemented")
def test_ma_one_class_student_mistake():
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
    ma = create_ma_with_ps(load_cdm("modelingassistant/testmodels/car.domain_model.cdm"))  # actual cdm tbd

    # Step 1
    student = MockStudent(_id="Student1", modelingAssistant=ma)
    student.create_cdm()

    # Steps 2-5
    student.create_class("badClsName")
    feedback = student.request_feedback()

    # 6. Student sees feedback: Bad class name
    assert feedback  # assertion tbd

    # 7. Student fixes mistake and requests feedback again


    # 8. WebCORE calls the Modeling Assistant to get feedback (for existing student solution)


    # 9. Modeling Assistant calls the Mistake Detection System to get mistakes


    # 10. Feedback algorithm calculates the feedback item (none) and returns it to WebCORE


    # 11. Student sees feedback: No mistakes!



def create_ma_with_ps(instructor_cdm: ClassDiagram) -> ModelingAssistant:
    """
    Create a Modeling Assistant instance with the provided parameters.
    """
    ps = ProblemStatement(name="TODO")  # based on cdm
    sol = Solution(classDiagram=instructor_cdm, problemStatement=ps)
    ma = ModelingAssistant(problemStatements=[ps], solutions=[sol])
    return ma


class MockStudent(Student):
    """
    Mock student used for testing.
    """
    def __init__(self, _id: str, modelingAssistant: ModelingAssistant):
        super().__init__(id=_id, modelingAssistant=modelingAssistant)
        self.file_name: str = ""  # assume one file name for now

    def create_cdm(self):
        """
        Create a student class diagram.
        """
        problem_statement = self.modelingAssistant.problemStatements[0]  # assume only one problem statement for now
        problem_name = problem_statement.name
        self.file_name = f"{problem_name}_{self.id}.cdm"
        # Tell TouchCORE about this cdm file
        cdm = ClassDiagram()  # ...
        Solution(modelingAssistant=self.modelingAssistant, student=self, classDiagram=cdm,
                 problemStatement=problem_statement)

    def create_class(self, name: str):
        """
        Create a class with the given name.
        """
        ...

    def request_feedback(self) -> FeedbackTO:
        """
        Request feedback from the Modeling Assistant.
        """
        feedback_json = "{}"
        return FeedbackTO(**json.loads(str(feedback_json)))  # double-check if str() is needed


if __name__ == '__main__':
    "Main entry point."
