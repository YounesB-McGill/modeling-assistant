#!/usr/bin/env python3

from flask import Flask, jsonify
from flask_cors import CORS

DEBUG_MODE = True
PORT = 8538

app = Flask(__name__)
CORS(app)  # TODO Make this more secure later


@app.route("/helloworld/<name>")
def hello_world(name):
    "Simple route used for testing the app."
    return jsonify({"hello": name})


if __name__ == "__main__":
    app.run(debug=DEBUG_MODE, port=PORT)
