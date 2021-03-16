"""
Modeling Assistant Imports

Use this file to import Modeling Assistant and TouchCore Python code from the modelingassistant
folder like this:

    import modelingassistant_imports
"""

import os
import sys

PROJECT_ROOT_RELATIVE_PATH = "../.."  #  the project root is 2 levels up

sys.path.append(os.path.join(os.path.dirname(os.path.abspath(__file__)),
                             PROJECT_ROOT_RELATIVE_PATH))


