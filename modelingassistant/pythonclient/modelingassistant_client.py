#!/usr/bin/env python3

from threading import Thread
from time import sleep
import json
import os
import sys

from pyecore.ecore import EClass, EPackage
from requests.models import Response
import requests

from stringserdes import SRSET, StringEnabledResourceSet
from classdiagram import ClassDiagram
from modelingassistant import ModelingAssistant


MODELING_ASSISTANT = ModelingAssistant()

MISTAKE_DETECTION_HOST = "localhost"
MISTAKE_DETECTION_PORT = 8539

MISTAKE_DETECTION_STARTUP_DELAY = 20  # seconds


if sys.version_info[:2] < (3, 10):
    print("Python 3.10 or higher required to run this app.")
    sys.exit(1)


def get_mistakes(ma: ModelingAssistant, instructor_cdm: ClassDiagram, student_cdm: ClassDiagram) -> ModelingAssistant:
    """
    Return the mistakes of the given student solution given the instructor solution and a modeling assistant context
    by calling the Mistake Detection System. If the latter is not running, it will be started.
    """
    def call_mistake_detection_system(ma_str: str) -> Response:
        return requests.get(f"http://{MISTAKE_DETECTION_HOST}:{MISTAKE_DETECTION_PORT}/detectmistakes",
                            {"modelingassistant": ma_str})

    resource = StringEnabledResourceSet().create_string_resource()
    resource.extend([ma, instructor_cdm, student_cdm])
    ma_str = resource.save_to_string().decode()

    try:
        req = call_mistake_detection_system(ma_str)
    except Exception:  # pylint: disable=broad-except
        # Turn on Modeling Assistant REST API server if not already running
        Thread(target=lambda: os.system("cd modelingassistant.restapi && mvn spring-boot:run"), daemon=True).start()
        sleep(MISTAKE_DETECTION_STARTUP_DELAY)
        req = call_mistake_detection_system(ma_str)

    req_content = json.loads(req.content)

    ma_str = bytes(req_content["modelingAssistantXmi"], "utf-8")
    resource = SRSET.get_string_resource(ma_str)
    ma: ModelingAssistant = resource.contents[0]
    ma.__class__ = ModelingAssistant
    return ma


def get_classifier_by_name(metamodel_root: EPackage, name: str) -> EClass:
    "Return the classifier with the given name"
    return next((classifier for classifier in metamodel_root.eClassifiers if classifier.name == name),
                print(f"Warning: classfier {name} not found in metamodel."))


if __name__ == '__main__':
    "Main entry point."
    print(f"Starting Modeling Assistant with Python {sys.version.split()[0]}")
