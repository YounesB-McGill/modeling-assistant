#!/usr/bin/env python3

"""
Module to generate and customize the pyecore Python code from the modeling assistant ecore metamodel.
"""

# pylint: disable=invalid-name, import-outside-toplevel

from ast import AST
from inspect import getsource
from textwrap import dedent
import ast
import os

from pyecore.ecore import EPackage, EClassifier, EString, EProxy
from pyecore.valuecontainer import BadValueError

# import previous (bootstrap) versions of the generated code
from classdiagram import AssociationEnd
from learningcorpus import MistakeTypeCategory, MistakeType, ParametrizedResponse


def generate_pyecore():
    "Generate the pyecore Python code from the modeling assistant and learning corpus metamodels."
    # TODO Add automatic code generation for the now external "classdiagram.ecore" metamodel
    pyecoregen_cmd = lambda mdl: f"""pyecoregen -e {mdl
                                  } -o modelingassistant/pythonclient --with-dependencies"""
    metamodel_names = ["learningcorpus", "learningcorpusquiz", "modelingassistant"]
    for mm in metamodel_names:
        os.system(pyecoregen_cmd(f"modelingassistant/model/{mm}.ecore"))


def customize_generated_code():
    "Add custom functionality to the generated code, similar to `@generated NOT` in the Java ecore implementation."
    ast_for = lambda item: ast.parse(dedent(getsource(item)))

    # Add the following items to the generated ClassDiagram class
    # Override CDM AssociationEnd.getOppositeEnd() and add oppositeEnd attribute
    # docstring indentation is intentional, to appear correctly in the generated code
    def getOppositeEnd(self) -> AssociationEnd:
        """
            Return the opposite end of this association end.
            This method implements the following OCL code from the metamodel:

            ```ocl
            if (assoc.ends->size() <= 2) then
              self.assoc.ends->select(end : AssociationEnd | end <> self)->at(1)
            else
              null
            endif
            ```
            """
        if len(self.assoc.ends) <= 2:
            return self.assoc.ends[1 if self.assoc.ends[0] is self else 0]
        return None

    oppositeEnd = dedent("""\
        @property
        def oppositeEnd(self) -> AssociationEnd:
            "Return the opposite end of this association end."
            return self.getOppositeEnd()
        """)

    def getName(self) -> str:
        """
            Return the name of this named element.
            """
        return self.name or self.__class__.__name__  # fallback to class name to handle Types

    name = dedent("""\
        @property
        def name(self) -> str:
            "Return the name of this named element."
            return self.getName()
        """)

    # Add the following functions to the generated LearningCorpus class
    def mistakeTypes(self) -> list[MistakeType]:
        "Custom function to return all the mistake types from their categories."
        import itertools
        return list(itertools.chain(*[mtc.mistakeTypes for mtc in self.mistakeTypeCategories]))

    def topLevelMistakeTypeCategories(self) -> list[MistakeTypeCategory]:
        """
            Custom function to return all the top-level mistake type categories,
            ie, those that do not have a supercategory.
            """
        return [mtc for mtc in self.mistakeTypeCategories if not mtc.supercategory]

    def parametrized_responses(self) -> list[ParametrizedResponse]:
        "Custom function to return all the parametrized responses for this mistake type."
        return [fb for fb in self.feedbacks if fb.__class__.__name__ == "ParametrizedResponse"]

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
                or value.eClass.name == etype.__name__):  # allow static/dynamic classes to be used interchangeably
                return True
            # if value instance of etype, return True
            for _module in [classdiagram, learningcorpus, __import__(__name__)]:  # import modelingassistant
                for name, cls in inspect.getmembers(_module, inspect.isclass):
                    if name == value.eClass.name and etype.name in (c.__name__ for c in cls.__bases__):
                        return True
            raise BadValueError(got=value, expected=etype, feature=feature)
        return True

    cdm_py = "modelingassistant/pythonclient/classdiagram/classdiagram.py"
    lc_py = "modelingassistant/pythonclient/learningcorpus/learningcorpus.py"
    ma_py = "modelingassistant/pythonclient/modelingassistant/modelingassistant.py"

    # remove the NotImplementedError stubs for CDM getName() and replace with actual implementation
    remove_from_module(cdm_py, "getName")
    customize_class(cdm_py, "NamedElement", [ast_for(getName)])

    customize_class(cdm_py, "AssociationEnd", [ast_for(getOppositeEnd), ast.parse(oppositeEnd)])
    customize_class(lc_py, "LearningCorpus", [ast_for(mistakeTypes), ast_for(topLevelMistakeTypeCategories)])
    customize_class(lc_py, "MistakeType", [ast_for(parametrized_responses)])
    customize_class(ma_py, "ModelingAssistant", [ast.parse(cdm2sols_def)])

    ma_footer = dedent("""

        from pyecore.valuecontainer import PyEcoreValue
        PyEcoreValue.check = override_pyecorevalue_check
        """)
    customize_module(ma_py, [ast_for(override_pyecorevalue_check)], ma_footer)
    add_future_import(cdm_py)
    add_future_import(lc_py)


def customize_class(filename: str, classname: str, members: list[AST]):
    "Add custom functionality to a class, similar to `@generated NOT` in the Java ecore implementation."
    file_ast = read_ast(filename)
    for e in file_ast.body:
        # Find the class
        if hasattr(e, "name") and e.name == classname:
            # Add the custom members to it, removing the old versions of them if they exist
            for member_to_add in members:
                for e_body_member in e.body:
                    if (hasattr(e_body_member, "name") and hasattr(mb := member_to_add.body[0], "name")
                        and e_body_member.name == mb.name):
                        e.body.remove(e_body_member)
                e.body.append(member_to_add)
    save_ast_to_file(file_ast, filename)


def customize_module(filename: str, members: list[AST], footer: str = ""):
    "Add custom functionality to a module."
    file_ast = read_ast(filename)
    file_ast.body.extend(members)
    save_ast_to_file(file_ast, filename, footer)


def remove_from_module(filename: str, name: str):
    "Remove all items with the given name from the given module."
    class ItemRemover(ast.NodeTransformer):
        "Remove the matching items from the module."
        # pylint: disable=no-self-use
        def visit_FunctionDef(self, node):
            "Remove the matching function definitions from the module."
            if hasattr(node, "name") and node.name == name:
                return None
            return node

    file_ast = ItemRemover().visit(read_ast(filename))
    save_ast_to_file(file_ast, filename)


def add_future_import(filename: str):
    "Add a `from __future__ import annotations` statement to the beginning of a file."
    file_ast = read_ast(filename)
    # Insert the future import statement at position 1, after the docstring
    file_ast.body.insert(1, ast.ImportFrom(module="__future__", names=[ast.alias(name="annotations")], level=0))
    save_ast_to_file(file_ast, filename)


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
