#!/usr/bin/env python3

from textwrap import dedent
import ast
import json
import os

from learningcorpus.learningcorpus import LearningCorpus

def generate_pyecore():
    # TODO Add automatic code generation for the now external "classdiagram.ecore" metamodel
    pyecoregen_cmd = lambda mdl: f"""pyecoregen -e {mdl
                                  } -o modelingassistant/pythonclient --with-dependencies"""    
    metamodel_names = ["learningcorpus", "modelingassistant"]
    for mm in metamodel_names:
        os.system(pyecoregen_cmd(f"modelingassistant/model/{mm}.ecore"))


def customize_generated_code():
    # TODO Generalize this as needed
    # Add the following function to the generated LearningCorpus class
    lc_mistaketypes_func = ast.parse(dedent("""\
    def mistakeTypes(self) -> list:
        "Custom function to return all the mistake types from their categories."
        import itertools
        return list(itertools.chain(*[mtc.mistakeTypes for mtc in self.mistakeTypeCategories]))
    """))
    lc_toplevelmtcs_func = ast.parse(dedent('''\
    def topLevelMistakeTypeCategories(self) -> list:
        """
            Custom function to return all the top-level mistake type categories,
            ie, those that do not have a supercategory.
            """
        return [mtc for mtc in self.mistakeTypeCategories if not mtc.supercategory]
    '''))

    lc_py = "modelingassistant/pythonclient/learningcorpus/learningcorpus.py"

    # Open and parse file
    with open(lc_py) as lc:
        lc_ast = ast.parse(lc.read())
        for e in lc_ast.body:
            # Find the LearningCorpus class
            if "name" in dir(e) and e.name == "LearningCorpus":
                # Add the custom functions to it
                e.body.extend([lc_toplevelmtcs_func, lc_mistaketypes_func])
    # Unparse the file back to a string and save it to file
    with open(lc_py, "w") as lc:
        lc.write(ast.unparse(lc_ast))


if __name__ == "__main__":
    "Main entry point."
    generate_pyecore()
    customize_generated_code()
