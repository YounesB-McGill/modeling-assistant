#!/usr/bin/env python3

"""
REST API for modeling assistant.
"""

# pylint: disable=invalid-name

import json

from feedback import give_feedback_for_student_cdm
from flask import abort, Flask, Response, jsonify, request
from flask_cors import CORS


DEBUG_MODE = True
PORT = 8538

app = Flask(__name__)
CORS(app)  # TODO Make this more secure later


@app.route("/")
def root():
    "Root endpoint."
    return abort(403)  # return 403 Forbidden for now


@app.route("/helloworld/<name>")
def hello_world(name) -> Response:
    "Simple route used for testing the app."
    return jsonify({"hello": name})


@app.route("/feedback/<cdmName>", methods = ["POST"])
def feedback(cdmName: str) -> Response:
    "Return feedback for the class diagram given its name."
    print("Got POST REST call for feedback on this class diagram")
    return jsonify(give_feedback_for_student_cdm(cdmName, json.loads(request.get_data())["classDiagram"]))


if __name__ == "__main__":
    app.run(debug=DEBUG_MODE, port=PORT)
