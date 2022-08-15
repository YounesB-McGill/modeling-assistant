#!/usr/bin/env python3

from threading import Thread
from time import sleep
import logging
import json
import os
import sys

from pyecore.ecore import EClass, EPackage
from requests.models import Response
import requests

from fileserdes import load_default_ma
from stringserdes import SRSET, str_to_modelingassistant
from utils import ModelingAssistantContainer, warn
from classdiagram import ClassDiagram
from modelingassistant import ModelingAssistant

LOGGING_LEVEL = logging.INFO

logging.basicConfig(level=LOGGING_LEVEL, format="%(asctime)s - %(name)s - %(levelname)s - %(message)s")
logger = logging.getLogger(__name__)

MODELING_ASSISTANT = ModelingAssistantContainer(load_default_ma())

MISTAKE_DETECTION_HOST = "localhost"
MISTAKE_DETECTION_PORT = 8539

MISTAKE_DETECTION_STARTUP_DELAY = 20  # seconds


if sys.version_info[:2] < (3, 10):
    logger.error("Python 3.10 or higher required to run this app.")
    sys.exit(1)


def get_mistakes(ma: ModelingAssistant, instructor_cdm: ClassDiagram, student_cdm: ClassDiagram) -> ModelingAssistant:
    """
    Return the mistakes of the given student solution given the instructor solution and a modeling assistant context
    by calling the Mistake Detection System. If the latter is not running, it will be started.
    """
    def call_mistake_detection_system(ma_str: str) -> Response:
        return requests.get(f"http://{MISTAKE_DETECTION_HOST}:{MISTAKE_DETECTION_PORT}/detectmistakes",
                            {"modelingassistant": ma_str})

    # resource = SRSET.create_string_resource()
    # resource.extend([ma, instructor_cdm, student_cdm])
    ma_str = SRSET.create_ma_str(ma)
    print("Called get_mistakes() with ", ma_str)

    try:
        req = call_mistake_detection_system(ma_str)
    except Exception:  # pylint: disable=broad-except
        # Turn on Modeling Assistant REST API server if not already running
        Thread(target=lambda: os.system("cd modelingassistant.restapi && mvn spring-boot:run"), daemon=True).start()
        sleep(MISTAKE_DETECTION_STARTUP_DELAY)
        req = call_mistake_detection_system(ma_str)

    req_content = json.loads(req.content)

    ma_str = bytes(req_content["modelingAssistantXmi"], "utf-8")
    return str_to_modelingassistant(ma_str)


def get_classifier_by_name(metamodel_root: EPackage, name: str) -> EClass:
    "Return the classifier with the given name."
    return next((classifier for classifier in metamodel_root.eClassifiers if classifier.name == name),
                warn(f"Classifier {name} not found in metamodel."))


if __name__ == '__main__':
    "Main entry point."
    print(f"Starting Modeling Assistant with Python {sys.version.split()[0]}")
