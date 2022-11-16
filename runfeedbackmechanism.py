#!/usr/bin/env python3
"""
This script is used to run the Modeling Assistant Python REST API server, which includes the
Feedback Mechanism. It is written in Python to allow use on multiple platforms.
"""

import os
import subprocess
from shutil import which
from socket import socket, AF_INET, SOCK_STREAM

DOMAIN_NAME = "localhost"
FLASK_APP = "modelingassistant/pythonapp/flaskapp.py"
FB_PORT = 8538  # defined in Flask app file above


def check_pipenv_installed():
    "Check that pipenv is installed."
    if not which("pipenv"):
        print('pipenv not found! Please install it using the instructions on the pipenv website, using the "crude" '
              'method if needed, then try again. You may need to close this terminal and open a new one.')
        exit(1)


def is_port_in_use(port: int) -> bool:
    "Return True if the given port is in use, False otherwise. Adapted from stackoverflow.com/a/52872579."
    with socket(AF_INET, SOCK_STREAM) as s:
        return s.connect_ex((DOMAIN_NAME, port)) == 0


def check_server_not_running():
    "Check that the Feedback server is not already running."
    if not is_port_in_use(FB_PORT):
        return  # successful early return
    error = f"The Modeling Assistant Python REST API server is already running on port {FB_PORT}"
    if os.name == "posix":
        pid = subprocess.check_output(["lsof", "-i", f":{FB_PORT}", "-t"]).decode("utf-8").strip()
        error += f" with PID {pid}"
    print(f"{error}. Please stop it and try again.")
    exit(1)


def check_touchcore_src_environment_variable_set():
    "Check that the TOUCHCORE_SRC environment variable is set."
    if "TOUCHCORE_SRC" in os.environ:
        return
    print("The TOUCHCORE_SRC environment variable is not set. Please set it to the path of the TouchCORE source code "
          "using the install script and try again.")
    exit(1)


def run_feedback_mechanism():
    "Run the Flask server in this directory."
    print(f"pipenv run {FLASK_APP}")
    try:
        subprocess.run(["pipenv", "run", FLASK_APP])
    except KeyboardInterrupt:  # Allow Ctrl+C to stop the server without printing a stack trace
        exit(0)


def main():
    "Run the Modeling Assistant Python REST API server."
    check_pipenv_installed()
    check_server_not_running()
    check_touchcore_src_environment_variable_set()
    run_feedback_mechanism()


if __name__ == "__main__":
    main()
