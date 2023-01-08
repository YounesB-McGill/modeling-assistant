#!/usr/bin/env python3

"""
Convert Ecore file(s) to TouchCORE class diagram (cdm) format.

Author: Younes Boubekeur
"""

import os
import sys

from pyecore.ecore import EClass, EDataType, EObject, EPackage
from pyecore.resources import ResourceSet, URI

from classdiagram import CDEnum, Class, ClassDiagram
from fileserdes import save_to_file


def load_ecore_model(ecore_file: str) -> EPackage:
    "Load the given ecore file into memory."
    rset = ResourceSet()
    resource = rset.get_resource(URI(ecore_file))
    mm_root = resource.contents[0]
    rset.metamodel_registry[mm_root.nsURI] = mm_root
    return mm_root


def convert(ecore_file: str):
    "Create a TouchCORE cdm file obtained by applying a model transformation on the input Ecore file."
    print(f"Converting {ecore_file}")
    ecore_model = load_ecore_model(ecore_file)
    cdm = ClassDiagram(name=ecore_model.name)
    cdm_items: dict[str, EObject] = {ecore_model.name: cdm}  # keep track of cdm items by name
    for class_ in ecore_model.eClassifiers:
        cls_name = class_.name
        match class_:
            case EDataType():  # enum class
                e = CDEnum(name=cls_name)
                cdm.types.append(e)
                cdm_items[cls_name] = e
            case EClass():
                c = Class(name=cls_name)
                cdm.classes.append(c)
                cdm_items[cls_name] = c
    save_to_file(f"{ecore_file.removesuffix('.ecore')}.cdm", cdm)


def enhance_with_umple_file_info(ecore_file: str, cdm_items: dict[str, EObject]):
    """
    Enhance the given TouchCORE diagram obtained from an Ecore file with additional information based on its source
    Umple file, if it exists.

    The following features are not converted automatically by Umple and so must be scraped manually:

    - Composition
    - Enumeration items (Enumerations themselves are supported)
    """
    # to be completed in the future


def main():
    "Main entry point."
    if len(sys.argv) != 2:
        print("Usage: python ecore2cdm.py ecore_file_or_folder")
        sys.exit(1)
    arg = sys.argv[1]
    if arg.lower().endswith(".ecore"):
        convert(arg)
    elif os.path.isdir(arg):
        for file_ in os.listdir(arg):
            if file_.lower().endswith(".ecore"):
                convert(os.path.join(arg, file_))
    else:
        print("Error: argument is not an ecore or a valid directory")
        sys.exit(1)


if __name__ == "__main__":
    main()
