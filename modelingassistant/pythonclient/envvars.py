"""
Environment variables for the modeling assistant defined at runtime via the .env file in the repository root.
"""

import json

ENV_FILE = ".env"

env_vars: dict[str, str] = {}

with open(ENV_FILE, encoding="utf-8") as env_file:
    env_vars = json.load(env_file)

TOUCHCORE_PATH = env_vars["touchcore-sources"]
WEBCORE_PATH = f"{TOUCHCORE_PATH}/../touchcore-web"
CORES_PATH = f"{WEBCORE_PATH}/webcore-server/cores"
