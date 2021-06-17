#!/usr/bin/env python3

import sys

from modelingassistant.modelingassistant import Solution

from pyecore.ecore import EClass, EAttribute, EString, EObject, EPackage
from pyecore.resources import ResourceSet, URI
from pyecore.utils import DynamicEPackage


MM_PATH = "modelingassistant/model"
CLASS_DIAGRAM_ECORE_MM = f"{MM_PATH}/classdiagram.ecore"
MODELING_ASSISTANT_ECORE_MM = f"{MM_PATH}/modelingassistant.ecore"


if sys.version_info[:2] < (3, 9):
    print("Python 3.9 or higher required to run this app.")
    exit(1)


def give_feedback(solution):
    # Decide which mistake to address based on student state
    # How to address the mistake
    return "Feedback"


def load_metamodels(ecore_files: list[str]) -> list[EPackage]:
    """
    Open metamodels from the given ecore file paths.
    """
    metamodels = []
    for ecore_file in ecore_files:
        rset = ResourceSet()
        resource = rset.get_resource(URI(ecore_file)) 
        mm_root = resource.contents[0]
        rset.metamodel_registry[mm_root.nsURI] = mm_root  # ecore is loaded in the 'rset' as a metamodel here
        metamodels.append(mm_root)
    return metamodels


def get_classifier_by_name(metamodel_root: EPackage, name: str) -> EClass:
    for classifier in metamodel_root.eClassifiers:
        if classifier.name == name:
            return classifier
    print(f"Warning: classfier {name} not found in metamodel.")


if __name__ == '__main__':
    "Main entry point."
    
    print(f"Starting Modeling Assistant with Python {sys.version.split()[0]}")
    metamodels = load_metamodels(["modelingassistant/model/classdiagram.ecore",
                                  "modelingassistant/model/modelingassistant.ecore"])
    print(metamodels)
