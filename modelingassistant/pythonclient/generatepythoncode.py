#!/usr/bin/env python3

"""
Module to generate the pyecore Python code from the modeling assistant ecore metamodel.
"""

# pylint: disable=invalid-name, import-outside-toplevel

from ast import AST
from inspect import getsource
from textwrap import dedent
import ast
import os


def generate_pyecore():
    "Generate the pyecore Python code from the modeling assistant and learning corpus metamodels."
    # TODO Add automatic code generation for the now external "classdiagram.ecore" metamodel
    pyecoregen_cmd = lambda mdl: f"""pyecoregen -e {mdl
                                  } -o modelingassistant/pythonclient --with-dependencies"""
    metamodel_names = ["learningcorpus", "modelingassistant"]
    for mm in metamodel_names:
        os.system(pyecoregen_cmd(f"modelingassistant/model/{mm}.ecore"))


def customize_generated_code():
    "Add custom functionality to the generated code, similar to `@generated NOT` in the Java ecore implementation."
    ast_for = lambda item: ast.parse(dedent(getsource(item)))

    # Add the following functions to the generated LearningCorpus class
    def mistakeTypes(self) -> list:
        "Custom function to return all the mistake types from their categories."
        import itertools
        return list(itertools.chain(*[mtc.mistakeTypes for mtc in self.mistakeTypeCategories]))

    # docstring indentation is intentional, to appear correctly in the generated code
    def topLevelMistakeTypeCategories(self) -> list:
        """
            Custom function to return all the top-level mistake type categories,
            ie, those that do not have a supercategory.
            """
        return [mtc for mtc in self.mistakeTypeCategories if not mtc.supercategory]

    # Add the following item to the generated ModelingAssistant class
    cdm2sols_def = "classDiagramsToSolutions: dict = {}"

    lc_py = "modelingassistant/pythonclient/learningcorpus/learningcorpus.py"
    ma_py = "modelingassistant/pythonclient/modelingassistant/modelingassistant.py"

    customize_class(lc_py, "LearningCorpus", [ast_for(mistakeTypes), ast_for(topLevelMistakeTypeCategories)])
    customize_class(ma_py, "ModelingAssistant", [ast.parse(cdm2sols_def)])


def customize_class(filename: str, classname: str, members: list[AST]):
    "Add custom functionality to a class, similar to `@generated NOT` in the Java ecore implementation."
    # Open and parse file
    with open(filename, encoding="utf-8") as f:
        file_ast = ast.parse(f.read())
        for e in file_ast.body:
            # Find the class
            if "name" in dir(e) and e.name == classname:
                # Add the custom members to it
                e.body.extend(members)
    # Unparse the file back to a string and save it to file
    with open(filename, "w", encoding="utf-8") as f:
        f.write(ast.unparse(file_ast))


if __name__ == "__main__":
    "Main entry point."
    generate_pyecore()
    customize_generated_code()
