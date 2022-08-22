#!/usr/bin/env python3

import modelingassistant_imports
from modelingassistant.pythonapp.classdiagram import ClassDiagram
from pyecore.resources import ResourceSet, URI


def main():
    cdm_mm_file = "../../modelingassistant/model/classdiagram.ecore"
    rset = ResourceSet()
    resource = rset.get_resource(URI(cdm_mm_file))
    mm_root = resource.contents[0]
    rset.metamodel_registry[mm_root.nsURI] = mm_root  # ecore is loaded in the 'rset' as a metamodel here

    # Open a class diagram instance
    cdm_path = "../../modelingassistant/testmodels"
    cdm_file = f"{cdm_path}/car_sportscar_part_driver.domain_model.cdm"
    resource = rset.get_resource(URI(cdm_file))
    class_diagram = resource.contents[0]
    class_diagram.__class__ = ClassDiagram

    # show_all_information(class_diagram.classes[1])
    # show_all_information(class_diagram)

    print_classes(class_diagram)


def print_classes(cd: ClassDiagram):
    for clazz in cd.classes:
        print(clazz.name)

        print_attributes(clazz)


def print_attributes(cl):
    print(tab(1), "Attr: ")
    for att in cl.attributes:

        print(tab(2), att.name)


def tab(n: int):
    return n * "  "


def show_all_information(cd: ClassDiagram):
    for val in dir(cd):
        print(val.upper())
        print(dir(val), "\n", "-----------------------------------------------------------")


if __name__ == "__main__":
    "Main entry point."
    main()
