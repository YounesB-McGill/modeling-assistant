#!/usr/bin/env python3

"""
Convert Ecore file(s) to TouchCORE class diagram (cdm) format.

Author: Younes Boubekeur
"""

import re
import os
import string
import sys

from pyecore.ecore import EAttribute, EClass, EDataType, EObject, EPackage, EReference
from pyecore.resources import ResourceSet, URI

from classdiagram import Association, AssociationEnd, Attribute, CDEnum, Class, ClassDiagram, Classifier
from fileserdes import save_to_file
from utils import warn


def load_ecore_model(ecore_file: str) -> EPackage:
    "Load the given ecore file into memory."
    rset = ResourceSet()
    resource = rset.get_resource(URI(ecore_file))
    mm_root = resource.contents[0]
    rset.metamodel_registry[mm_root.nsURI] = mm_root
    return mm_root


def convert(ecore_file: str) -> ClassDiagram:
    "Create a TouchCORE cdm file obtained by applying a model transformation on the input Ecore file."
    print(f"Converting {ecore_file}")
    ecore_model = load_ecore_model(ecore_file)
    cdm = ClassDiagram(name=ecore_model.name)
    cdm_items: dict[str, EObject] = {ecore_model.name: cdm}  # track cdm items by name (assocend names not unique)
    for class_ in ecore_model.eClassifiers:
        match class_:
            case EDataType(name=enum_name):  # enum class
                enum = CDEnum(name=enum_name)
                cdm.types.append(enum)  # no classDiagram reference in its parts
                cdm_items[enum_name] = enum
            case EClass(name=cls_name):
                cls = Class(name=cls_name)
                cdm.classes.append(cls)
                cdm_items[cls_name] = cls
                for sf in class_.eStructuralFeatures:
                    match sf:
                        case EAttribute(name=attr_name):
                            attr = Attribute(name=attr_name)
                            cls.attributes.append(attr)
                            cdm_items[attr_name] = attr
                        # when first added, all relationships are associations
                        case EReference(name=assocend_name, lowerBound=lb, upperBound=ub) as eref:
                            #print(f"Creating AE for {cls_name}.{assocend_name}")
                            assocend = AssociationEnd(name=assocend_name, classifier=cls, lowerBound=lb, upperBound=ub,
                                                      assoc=assoc_for(eref, cdm, cdm_items))
                            cdm_items[assocend_name] = assocend
    ecore_file_base_name = ecore_file.removesuffix('.ecore')
    cdm = enhance_with_umple_file_info(cdm, f"{ecore_file_base_name}.ump", cdm_items)
    save_to_file(f"{ecore_file_base_name}.cdm", cdm)
    return cdm


def assoc_for(eref: EReference, cdm: ClassDiagram, cdm_items: dict[str, EObject]) -> Association:
    """
    Return the correct TouchCORE class diagram association for the given EReference, creating it and adding it to the
    class diagram if necessary.
    """
    def unique_name(eref):
        """
        Return a unique name (enforced by case-sensitive alphabetical order) for the given EReference in the form
        "A,B,a,b". For example, the reference (in Umple syntax)

        1 Car car -- * Wheel wheels;

        becomes "Car,Wheel,car,wheel", since "Car" < "Wheel"
        """
        cls1, cls2 = sorted((eref.eContainingClass.name, eref.eType.name))
        # ensure that the order of the association ends is never flipped
        opposite_name = getattr(eref.eOpposite, "name", "")  # to support unidirectional associations
        if eref.eContainingClass.name < eref.eType.name:
            ae1, ae2 = opposite_name, eref.name
        elif eref.eContainingClass.name > eref.eType.name:
            ae1, ae2 = eref.name, opposite_name
        else:  # both class names are equal, so it's a reflexive association
            ae1, ae2 = sorted((eref.name, opposite_name))
        return ",".join((cls1, cls2, ae1, ae2))

    name = unique_name(eref)
    print(f"unique name: {name}")
    if name not in cdm_items:
        tc_name = "_".join(name.split(",")[:2])  # cls1_cls2, to match TouchCORE conventions
        assoc = Association(name=tc_name)
        cdm_items[name] = assoc
        cdm_items[tc_name] = assoc
        cdm.associations.append(assoc)
    return cdm_items[name]


def enhance_with_umple_file_info(cdm: ClassDiagram, umple_file: str, cdm_items: dict[str, EObject]) -> ClassDiagram:
    """
    Enhance the given TouchCORE diagram obtained from an Ecore file with additional information based on its source
    Umple file, if it exists.

    The following features are not converted automatically by Umple or not recognized by PyEcore and so must be scraped
    manually:

    - Composition
    - Class is abstract
    - Class is an interface, which also implies that superclasses need to be handled here
    - Enumeration items (Enumerations themselves are supported)
    """
    def get_class_name(umple_lines: list[str], search_from_line: int) -> str:
        "Helper function to extract the class name immediately above the given line"
        curr_line = search_from_line
        while curr_line:
            if umple_lines[curr_line].lstrip().startswith("class "):
                return umple_lines[curr_line].replace("class ", "").split("{")[0].replace("}", "").strip()
            curr_line -= 1
        warn(f"Unable to return class name starting from line {search_from_line}")
        return ""

    if not os.path.isfile(umple_file):
        warn(f'The file "{umple_file}" does not exist, so its CDM remains unchanged')
        return cdm
    with open(umple_file, "r", encoding="utf-8") as f:
        umple_code = remove_umple_comments(f.read().split("//$?[End_of_model]$?")[0])
    umple_lines = ["", *umple_code.splitlines()]  # Add a dummy "line" at the beginning to have 1-indexed lines
    if umple_lines[-1]:
        umple_lines.append("")  # always end with a newline
    num_lines = len(umple_lines) - 1

    # detect compositions
    for i in range(1, num_lines + 1):
        if "<@>" in umple_lines[i]:
            # replace "-" with " " and remove special characters
            compos_line = umple_lines[i].translate(str.maketrans("-", " ", f"{string.digits}*.<@>;{{}}")).strip()
            """
            Example:

            class Car {
              1 car <@>- * Wheel wheels;
            }

            whole = Car, whole_refcls = Wheel.car, part = Wheel, part_refcls = Car.wheels
            """
            #print(f"{compos_line = }")
            whole = get_class_name(umple_lines, search_from_line=i)
            compos_line_components = compos_line.split()
            part, part_refcls = compos_line_components[-2:]
            whole_refcls = (compos_line_components[0] if len(compos_line_components) == 3
                            else f"{whole[0].lower()}{whole[1:]}")
            if whole < part:
                assoc_name = ",".join((whole, part, whole_refcls, part_refcls))
            elif whole > part:
                assoc_name = ",".join((part, whole, part_refcls, whole_refcls))
            else:
                warn(f"Found reflexive association in {umple_file}: {whole} <@>- {part}")
            if assoc_name in cdm_items:
                assoc: Association = cdm_items[assoc_name]
                # assume that each composition has exactly 2 ends
                composend: AssociationEnd = assoc.ends[0] if assoc.ends[0].classifier.name == whole else assoc.ends[1]
                composend.referenceType = "Composition"
            else:
                warn(f'Could not find the "{assoc_name}" association in cdm_items dictionary')

    # set abstract classes and interfaces
    interfaces: set[Classifier] = set()
    for i in range(1, num_lines + 1):
        if "abstract;" in umple_lines[i]:
            class_name = get_class_name(umple_lines, search_from_line=i)
            if class_name in cdm_items:
                cls: Classifier = cdm_items[class_name]
                cls.abstract = True
        if "interface;" in umple_lines[i]:
            class_name = get_class_name(umple_lines, search_from_line=i)
            if class_name in cdm_items:
                cls: Classifier = cdm_items[class_name]
                cls.abstract = True
                interfaces.add(cls)


    return cdm


def remove_umple_comments(umple_code: str):
    """
    Remove Umple // and /**/ comments from the given Umple source code string.
    Adapted from stackoverflow.com/a/18234680.
    """
    def replacer(match) :
        s = match.group(0)
        if s.startswith('/'):  # s matches //... or /*...*/ so remove comment but preserving the number of newlines
            return "" + ("\n" * s.count('\n'))
        else:  # Keep quoted string unchanged
            return s
    pattern = re.compile(r'//.*?$|/\*.*?\*/|\'(?:\\.|[^\\\'])*\'|"(?:\\.|[^\\"])*"', re.DOTALL | re.MULTILINE)
    return re.sub(pattern, replacer, umple_code)


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
