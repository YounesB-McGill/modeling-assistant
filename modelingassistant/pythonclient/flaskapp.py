#!/usr/bin/env python3

from flask import Flask, jsonify

DEBUG_MODE = True
PORT = 8538

app = Flask(__name__)


@app.route('/helloworld')
def hello_world():
    "Simple route used for testing the app."
    return jsonify({'hello': 'world'})


if __name__ == '__main__':
    app.run(debug=DEBUG_MODE, port=PORT)
