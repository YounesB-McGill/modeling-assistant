#!/usr/bin/env python3

from classdiagram.classdiagram import ClassDiagram
from modelingassistant.modelingassistant import ModelingAssistant, Solution


def test_pytest_is_working():
    assert True


def test_creating_empty_solution():
    modeling_assistant = ModelingAssistant()
    solution = Solution()
    class_diagram = ClassDiagram(name="Student1_solution")
    solution.classDiagram = class_diagram
    modeling_assistant.solutions.append(solution)
    assert "Student1_solution" == modeling_assistant.solutions[0].classDiagram.name


if __name__ == "__main__":
    "Main entry point."
    test_creating_empty_solution()
