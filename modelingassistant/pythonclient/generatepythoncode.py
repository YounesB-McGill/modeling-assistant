#!/usr/bin/env python3

import ast
import os

def generate_pyecore():
    metamodel_names = ["classdiagram", "learningcorpus", "modelingassistant"]
    for mm in metamodel_names:
        os.system(f"pyecoregen -e modelingassistant/model/{mm}.ecore "
                   "-o modelingassistant/pythonclient --with-dependencies")


def customize_generated_code():
    with open("modelingassistant/pythonclient/learningcorpus/learningcorpus.py") as lc:
        lc_ast = ast.parse(lc.read())
        for e in lc_ast.body:
            if "name" in dir(e) and e.name == "MistakeTypeCategory":

                print(ast.dump(e))
                print()
        print(dir(e))


if __name__ == "__main__":
    "Main entry point."
    #generate_pyecore()
    customize_generated_code()
