#!/usr/bin/env python3
"""
This script is used to run the Modeling Assistant Java REST API server, which includes the
Mistake Detection System (MDS). It is written in Python to allow use on multiple platforms.
"""

import os
import subprocess
from socket import socket, AF_INET, SOCK_STREAM

DOMAIN_NAME = "localhost"
# defined in modelingassistant.restapi/src/main/java/modelingassistant/restapi/ModelingAssistantRestApi.java
MDS_PORT = 8539


def is_port_in_use(port: int) -> bool:
    "Return True if the given port is in use, False otherwise. Adapted from stackoverflow.com/a/52872579."
    with socket(AF_INET, SOCK_STREAM) as s:
        return s.connect_ex((DOMAIN_NAME, port)) == 0


def check_server_not_running():
    "Check that the MDS server is not already running."
    if not is_port_in_use(MDS_PORT):
        return  # successful early return
    error = f"The Modeling Assistant Java REST API server is already running on port {MDS_PORT}"
    if os.name == "posix":
        pid = subprocess.check_output(["lsof", "-i", f":{MDS_PORT}", "-t"]).decode("utf-8").strip()
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


def run_mistake_detection_system():
    "Run the server in the modelingassistant.restapi directory"
    print("cd modelingassistant.restapi")
    os.chdir("modelingassistant.restapi")
    mvn = "./mvnw" if os.name == "posix" else ".\\mvnw.cmd"
    print(f"{mvn} spring-boot:run")
    try:
        subprocess.run([mvn, "spring-boot:run"])
    except KeyboardInterrupt:  # Allow Ctrl+C to stop the server without printing a stack trace
        exit(0)


def main():
    "Run the Modeling Assistant Java REST API server."
    check_server_not_running()
    check_touchcore_src_environment_variable_set()
    run_mistake_detection_system()


if __name__ == "__main__":
    main()
