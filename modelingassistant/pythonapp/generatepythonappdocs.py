#!/usr/bin/env python3

"""
Module to generate the documentation for the Modeling Assistant Python app.
"""

import os
import sys

from pdoc import Context, Module

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

DOC_LOCATION = "modelingassistant/pythonapp/docs"

context = Context()


def get_modules() -> list[Module]:
    "Return the modules to document based on the Python files in the current directory."
    return [Module(_file, context=context) for _file in get_python_files(".")]


def get_python_files(root: str) -> list[str]:
    "Return all Python files in the given directory and its subdirectories."
    for path, _, files in os.walk(root):
        for file in files:
            if file.endswith(".py"):
                yield os.path.join(path, file)


def save_module(module: Module, path: str) -> None:
    "Save the given module to the given path."
    with open(path, "w") as file:
        file.write(module.html())


def main():
    "Generate the documentation for the Modeling Assistant Python app."
    for module in get_modules():
        if module.name == "__init__":
            save_module(module, f"{DOC_LOCATION}/index.html")
        else:
            save_module(module, f"{DOC_LOCATION}/{module.name}.html")


if __name__ == "__main__":
    main()
