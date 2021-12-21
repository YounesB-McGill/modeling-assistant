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

from pyecore.ecore import EPackage, EClassifier, EString, EProxy
from pyecore.valuecontainer import BadValueError


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

    # Add the following items to the generated ModelingAssistant class
    cdm2sols_def = "classDiagramsToSolutions: dict = {}"

    def override_pyecorevalue_check(self, value, _isinstance=isinstance):
        """
        Overriden version of PyEcoreValue.check() to accept both static and dynamic classes.
        """
        import inspect
        import classdiagram
        import learningcorpus
        feature = self.feature
        etype = self.generic_type or feature._eType  # pylint: disable=protected-access
        if not etype:
            try:
                etype = feature.eGenericType.eRawType
                self.generic_type = etype
            except Exception as root_cause:
                raise AttributeError(f'Feature {feature} has no type nor generic') from root_cause
        if not _isinstance(value, etype):
            if (etype in (EPackage, EClassifier, EString)  # everything can be represented as one of them, so accept all
                or isinstance(value, EProxy)  # proxy should be resolved to actual value, so don't crash here
                or value.eClass.name == etype.name):  # allow static/dynamic classes to be used interchangeably
                return True
            # if value instance of etype, return True
            for _module in [classdiagram, learningcorpus, __import__(__name__)]:  # import modelingassistant
                for name, cls in inspect.getmembers(_module, inspect.isclass):
                    if name == value.eClass.name and etype.name in (c.__name__ for c in cls.__bases__):
                        return True
            raise BadValueError(got=value, expected=etype, feature=feature)

    lc_py = "modelingassistant/pythonclient/learningcorpus/learningcorpus.py"
    ma_py = "modelingassistant/pythonclient/modelingassistant/modelingassistant.py"

    customize_class(lc_py, "LearningCorpus", [ast_for(mistakeTypes), ast_for(topLevelMistakeTypeCategories)])
    customize_class(ma_py, "ModelingAssistant", [ast.parse(cdm2sols_def)])

    ma_footer = dedent("""

        from pyecore.valuecontainer import PyEcoreValue
        PyEcoreValue.check = override_pyecorevalue_check
        """)
    customize_module(ma_py, [ast_for(override_pyecorevalue_check)], ma_footer)


def customize_class(filename: str, classname: str, members: list[AST]):
    "Add custom functionality to a class, similar to `@generated NOT` in the Java ecore implementation."
    file_ast = read_ast(filename)
    for e in file_ast.body:
        # Find the class
        if "name" in dir(e) and e.name == classname:
            # Add the custom members to it
            e.body.extend(members)
    save_ast_to_file(file_ast, filename)


def customize_module(filename: str, members: list[AST], footer: str):
    "Add custom functionality to a module."
    file_ast = read_ast(filename)
    file_ast.body.extend(members)
    save_ast_to_file(file_ast, filename, footer)


def read_ast(filename: str) -> AST:
    "Read the AST (Abstract Syntax Tree) from a file."
    with open(filename, encoding="utf-8") as f:
        return ast.parse(f.read())


def save_ast_to_file(ast_: AST, filename: str, footer: str = ""):
    "Save the given AST to a file by unparsing it to a string."
    with open(filename, "w", encoding="utf-8") as f:
        f.write(f"{ast.unparse(ast_)}{footer}")


if __name__ == "__main__":
    "Main entry point."
    generate_pyecore()
    customize_generated_code()
