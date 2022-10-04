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

from constants import LEARNING_CORPUS_PATH
from fileserdes import load_cdm, load_default_ma, load_lc
from stringserdes import SRSET, str_to_modelingassistant
from utils import ModelingAssistantContainer, warn
from classdiagram import ClassDiagram
from modelingassistant import ModelingAssistant, ProblemStatement, Solution


DEBUG_MODE = True

LOGGING_LEVEL = logging.DEBUG if DEBUG_MODE else logging.INFO
LOGGING_FORMAT = "{asctime} - {name} - {levelname} - {message}"

logging.basicConfig(level=LOGGING_LEVEL, format=LOGGING_FORMAT, style="{")
logger = logging.getLogger(__name__)

# suppress useless debug messages
logging.getLogger("urllib3.connectionpool").addFilter(lambda record: "Starting new HTTP connection" not in record.msg)

# Set this to True to use a preexisting problem statement, useful for testing the frontend
USE_EXAMPLE_PROBLEM_STATEMENT = True

EXAMPLE_CDM_NAME = "AirlineSystem"
EXAMPLE_INSTRUCTOR_CDM = f"modelingassistant/testmodels/{EXAMPLE_CDM_NAME}_instructor.cdm"

MODELING_ASSISTANT = ModelingAssistantContainer(load_default_ma())

MISTAKE_DETECTION_HOST = "localhost"
MISTAKE_DETECTION_PORT = 8539

MISTAKE_DETECTION_STARTUP_DELAY = 20  # seconds


if sys.version_info[:2] < (3, 10):
    logger.error("Python 3.10 or higher required to run this app.")
    sys.exit(1)


load_lc(LEARNING_CORPUS_PATH)


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


def get_ma_with_ps(instructor_cdm: ClassDiagram) -> ModelingAssistant:
    """
    Create a Modeling Assistant instance with the provided parameters.
    """
    ma = MODELING_ASSISTANT.instance
    # assume 1 problem statement for now
    if not ma.problemStatements:
        ps = ProblemStatement(name=instructor_cdm.name.removesuffix("_instructor"), modelingAssistant=ma)
        sol = Solution(classDiagram=instructor_cdm, problemStatement=ps, modelingAssistant=ma)
        ps.instructorSolution = sol
        ma.problemStatements.append(ps)
        ma.solutions.append(sol)
    assert ma.problemStatements[0].name
    assert ma.solutions[0].classDiagram.name
    return ma


if USE_EXAMPLE_PROBLEM_STATEMENT:
    MODELING_ASSISTANT.instance = get_ma_with_ps(load_cdm(EXAMPLE_INSTRUCTOR_CDM))


if __name__ == '__main__':
    "Main entry point."
    print(f"Starting Modeling Assistant with Python {sys.version.split()[0]}")
