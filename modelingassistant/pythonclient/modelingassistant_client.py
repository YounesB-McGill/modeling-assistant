#!/usr/bin/env python3

import sys

from pyecore.ecore import EClass, EPackage
from pyecore.resources import ResourceSet, URI

from modelingassistant.modelingassistant import Solution


MM_PATH = "modelingassistant/model"
CLASS_DIAGRAM_MM = "ca.mcgill.sel.classdiagram/model/classdiagram.ecore"
LEARNING_CORPUS_MM = f"{MM_PATH}/learningcorpus.ecore"
MODELING_ASSISTANT_MM = f"{MM_PATH}/modelingassistant.ecore"


if sys.version_info[:2] < (3, 9):
    print("Python 3.9 or higher required to run this app.")
    sys.exit(1)


def give_feedback(solution: Solution):
    """
    Decide which mistake to address based on student state and how to address the mistake.
    """
    return "Feedback"


def load_metamodels(*ecore_files: str) -> ResourceSet:
    """
    Return a ResourceSet loaded with the given metamodels from the ecore file paths.
    """
    rset = ResourceSet()
    for ecore_file in ecore_files:
        mm_root = rset.get_resource(URI(ecore_file)).contents[0]
        rset.metamodel_registry[mm_root.nsURI] = mm_root  # ecore loaded in rset as a metamodel here
    return rset


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
