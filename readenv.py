"""
Simple module to read values from .env file
"""

import json
import sys

if len(sys.argv) > 1:
    with open(".env") as f:
        env = json.load(f)
        if (param := sys.argv[1]) in env:  # pylint: disable=superfluous-parens
            print(env[sys.argv[1]])
        else:
            print(f"{param} not found in .env.")
