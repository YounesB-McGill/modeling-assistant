#!/usr/bin/env python3

"""
REST API for modeling assistant.
"""

# pylint: disable=invalid-name

import json
import logging
import os

from feedback import give_feedback_for_student_cdm
from flask import abort, Flask, Response, jsonify, request
from flask_cors import CORS
from modelingassistantapp import LOGGING_FORMAT, LOGGING_LEVEL, MODELING_ASSISTANT, SRSET
from stringserdes import str_to_modelingassistant


DEBUG_MODE = True
PORT = 8538

app = Flask(__name__)
CORS(app)  # TODO Make this more secure later


logging.basicConfig(level=LOGGING_LEVEL, format=LOGGING_FORMAT)
logger = logging.getLogger(os.path.basename(__file__).removesuffix(".py"))  # avoid using default name __main__  


@app.route("/")
def root():
    "Root endpoint."
    return abort(403)  # return 403 Forbidden for now


@app.route("/helloworld/<name>")
def hello_world(name) -> Response:
    "Simple route used for testing the app."
    return jsonify({"hello": name})


@app.route("/feedback/<userName>", methods=["POST"])
def feedback(userName: str) -> Response:
    """
    Return feedback for the user's class diagram given its name.

    Body: {"classDiagram": <ClassDiagram in XMI format>}
    """
    logger.debug("Got POST REST call for feedback on this class diagram")
    cdm_xmi: str = json.loads(request.get_data())["classDiagram"]
    feedback_to = give_feedback_for_student_cdm(userName, cdm_xmi)
    resp = jsonify(feedback_to)
    logger.debug(f"/feedback/{userName}: Returning this response: {resp.data.decode('utf-8')}")
    return resp


@app.route("/modelingassistant", methods=["GET", "POST"])
def modeling_assistant() -> Response:
    "Get or set the modeling assistant as an XMI string. This endpoint should be considered provisional."
    #global MODELING_ASSISTANT  # pylint: disable=global-statement
    logger.debug(f"Received a /modelingassistant {request.method} request")
    if request.method == "GET":
        ma_str = SRSET.create_ma_str(MODELING_ASSISTANT.instance)
        resp = jsonify({"modelingAssistantXmi": ma_str})
        logger.debug(f"GET /modelingassistant: Returning this response: \n{ma_str}")
        return resp
    if request.method == "POST":
        logger.debug(f"Old MA id: {id(MODELING_ASSISTANT.instance)}")
        MODELING_ASSISTANT.instance = str_to_modelingassistant(json.loads(request.get_data())["modelingAssistantXmi"])
        logger.debug(f"New MA id: {id(MODELING_ASSISTANT.instance)}")
        resp = jsonify({"success": True})
        logger.debug(f"/modelingassistant: Returning this response: {resp.data.decode('utf-8')}")
        return resp
    return abort(405)  # invalid method


if __name__ == "__main__":
    app.run(debug=DEBUG_MODE, port=PORT)
