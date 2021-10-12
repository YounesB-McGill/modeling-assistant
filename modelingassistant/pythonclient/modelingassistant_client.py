#!/usr/bin/env python3

import sys

from pyecore.ecore import EClass, EPackage

from modelingassistant.modelingassistant import Solution


if sys.version_info[:2] < (3, 10):
    print("Python 3.10 or higher required to run this app.")
    sys.exit(1)


def give_feedback(solution: Solution):
    """
    Decide which mistake to address based on student state and how to address the mistake.
    """
    return "Feedback"


def get_classifier_by_name(metamodel_root: EPackage, name: str) -> EClass:
    for classifier in metamodel_root.eClassifiers:
        if classifier.name == name:
            return classifier
    print(f"Warning: classfier {name} not found in metamodel.")


if __name__ == '__main__':
    "Main entry point."
    print(f"Starting Modeling Assistant with Python {sys.version.split()[0]}")
