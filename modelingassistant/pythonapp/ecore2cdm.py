#!/usr/bin/env python3

"""
Convert Ecore file(s) to TouchCORE class diagram (cdm) format.

Author: Younes Boubekeur
"""

import os
import sys

from pyecore.ecore import EAttribute, EClass, EDataType, EObject, EPackage, EReference
from pyecore.resources import ResourceSet, URI

from classdiagram import Association, AssociationEnd, Attribute, CDEnum, Class, ClassDiagram
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
                            print(f"Creating AE for {cls_name}.{assocend_name}")
                            assocend = AssociationEnd(name=assocend_name, classifier=cls, lowerBound=lb, upperBound=ub,
                                                      assoc=assoc_for(eref, cdm, cdm_items))
                            cdm_items[assocend_name] = assocend

    save_to_file(f"{ecore_file.removesuffix('.ecore')}.cdm", cdm)


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
        if eref.eContainingClass.name < eref.eType.name:
            ae1, ae2 = eref.eOpposite.name, eref.name
        elif eref.eContainingClass.name > eref.eType.name:
            ae1, ae2 = eref.name, eref.eOpposite.name
        else:  # both class names are equal, so it's a reflexive association
            ae1, ae2 = sorted((eref.name, eref.eOpposite.name))
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


def enhance_with_umple_file_info(cdm: ClassDiagram, umple_file: str, cdm_items: dict[str, EObject]):
    """
    Enhance the given TouchCORE diagram obtained from an Ecore file with additional information based on its source
    Umple file, if it exists.

    The following features are not converted automatically by Umple or not recognized by PyEcore and so must be scraped
    manually:

    - Composition
    - Class is abstract
    - Class is an interface
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
