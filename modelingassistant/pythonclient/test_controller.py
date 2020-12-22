#!/usr/bin/env python3

from classdiagram.classdiagram import ClassDiagram, Class, Attribute, ImplementationClass
from modelingassistant.modelingassistant import ModelingAssistant, Solution
from pyecore.ecore import EInteger, EString


def test_pytest_is_working():
    assert True


def test_creating_empty_solution():
    modeling_assistant = ModelingAssistant()
    solution = Solution()
    class_diagram = ClassDiagram(name="Student1_solution")
    solution.classDiagram = class_diagram
    modeling_assistant.solutions.append(solution)
    assert "Student1_solution" == modeling_assistant.solutions[0].classDiagram.name


def test_creating_one_class_solution():
    modeling_assistant = ModelingAssistant()
    solution = Solution()
    class_diagram = ClassDiagram(name="Student1_solution")
    solution.classDiagram = class_diagram
    modeling_assistant.solutions.append(solution)

    car_class = Class(name="Car", attributes=[
        Attribute(name="id", type=ImplementationClass(dataType=EInteger)),
        Attribute(name="make", type=ImplementationClass(dataType=EString))
    ])
    class_diagram.classes.append(car_class)

    assert "Student1_solution" == modeling_assistant.solutions[0].classDiagram.name
    assert "Car" == class_diagram.classes[0].name
    assert "id" == class_diagram.classes[0].attributes[0].name
    assert EInteger == class_diagram.classes[0].attributes[0].type.dataType
    assert "make" == class_diagram.classes[0].attributes[1].name
    assert EString == class_diagram.classes[0].attributes[1].type.dataType


if __name__ == "__main__":
    "Main entry point."
    test_creating_empty_solution()
