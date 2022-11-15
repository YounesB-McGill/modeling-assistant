#!/usr/bin/env python

"""
Run to generate modeling assistant instance with problem statement,
problem statement elements and solution elements.

Before running make sure you have correct .tsv file path.

Paramenter: input file(.tsv), input model and output file path

Author: Prabhsimran Singh
"""

from collections import defaultdict
import csv
import sys
from classdiagram import CDEnum
from fileserdes import load_cdm, save_to_files
from modelingassistant import ModelingAssistant, ProblemStatement, ProblemStatementElement, Solution, SolutionElement

INPUT_FILE_TSV = "modelingassistant/pythonapp/ProblemStatementElements.tsv"
INPUT_MODEL_FILE = "mistakedetection/realModels/instructorSolution/instructorSolution2/Class Diagram/InstructorSolution2.domain_model.cdm"
OUTPUT_FILE_MA = "modelingassistant/ProblemStatementInstance/problem_statement_instance.modelingassistant"


def populate_dict(value, pse_name, name_to_pse, string_to_pse):
    value = value.replace(" ", "")
    if "," in value:
        values = value.split(",")
        for val in values:
            name_to_pse[val].append(string_to_pse[pse_name])
    else:
        name_to_pse[value].append(string_to_pse[pse_name])


def solution_elem_to_problem_statement_elem():
    try:
        file_data = open(INPUT_FILE_TSV, encoding="utf-8")
        class_diagram = load_cdm(INPUT_MODEL_FILE)

    except:
        print("Files Not found, check the address of .tsv, .cdm files")
        sys.exit()

    # Modeling assistant instance
    modeling_assistant = ModelingAssistant()
    solution = Solution(modelingAssistant=modeling_assistant, classDiagram=class_diagram)
    problem_statement = ProblemStatement(modelingAssistant=modeling_assistant, instructorSolution=solution)
    solution.problemStatement = problem_statement

    read_file = csv.DictReader(file_data, delimiter="\t")

    string_to_pses = defaultdict(list) # Dict to map string to problem statement elements
    class_name_to_pses = defaultdict(list) # Dict to map class name to problem statement elements
    attrib_name_to_pses = defaultdict(list) # Dict to map attribute name to problem statement elements
    assoc_name_to_pses = defaultdict(list) # Dict to map association name to problem statement elements
    assoc_end_name_to_pses = defaultdict(list) # Dict to map association end name to problem statement elements
    enum_name_to_pses = defaultdict(list) # Dict to map enum name to problem statement elements
    enum_literal_name_to_pses = defaultdict(list) # Dict to enum literal attribute name to problem statement elements

    # Creates problem statement elements for given strings.
    for row in read_file:
        pse_name = row['Problem Statement Element']
        if pse_name not in string_to_pses:
            pse = ProblemStatementElement(problemStatement=problem_statement)
            string_to_pses[pse_name] = pse

        # Map class name to problem statement elements
        if row['Class Element']:
            populate_dict(row['Class Element'], pse_name, class_name_to_pses, string_to_pses)

        # Map assoc class names to problem statement elements
        if row['Association class']:
            populate_dict(row['Association class'], pse_name, class_name_to_pses, string_to_pses)

        # Map attribute names to problem statement elements
        if row['Attribute']:
            populate_dict(row['Attribute'], pse_name, attrib_name_to_pses, string_to_pses)

        # Map association names to problem statement elements
        if row['Association']:
            populate_dict(row['Association'], pse_name, assoc_name_to_pses, string_to_pses)

        # Map association names to problem statement elements
        if row['Association End']:
            populate_dict(row['Association End'], pse_name, assoc_end_name_to_pses, string_to_pses)

        # Map Generalization to problem statement elements
        if row['Generalization']:
            populate_dict(row['Generalization'], pse_name, class_name_to_pses, string_to_pses)

        # Map Enumeration to problem statement elements
        if row['Enumeration']:
            populate_dict(row['Enumeration'], pse_name, enum_name_to_pses, string_to_pses)

        # Map Enumeration Literal to problem statement elements
        if row['Enumeration Literal']:
            populate_dict(row['Enumeration Literal'], pse_name, enum_literal_name_to_pses, string_to_pses)

    se_to_pse = {} # solution element to problem statement elements

    # Mapping solution elements (classes, assoc class, gen classes) to problem statement elements.
    for key, values in class_name_to_pses.items():
        element = get_class_element(key, class_diagram)
        create_solution_element(solution, element, values)

    # Mapping solution elements (attributes) to problem statement elements.
    for key, values in attrib_name_to_pses.items():
        element = get_attribute_element(key, class_diagram)
        create_solution_element(solution, element, values)

    # Mapping solution elements (associations) to problem statement elements.
    for key, values in assoc_name_to_pses.items():
        element = get_association_element(key, class_diagram)
        create_solution_element(solution, element, values)

     # Mapping solution elements (association ends) to problem statement elements.
    for key, values in assoc_end_name_to_pses.items():
        element = get_association_end_element(key, class_diagram)
        create_solution_element(solution, element, values)

    # Mapping solution elements (enumerations) to problem statement elements.
    for key, values in enum_name_to_pses.items():
        element = get_enumeration_element(key, class_diagram)
        create_solution_element(solution, element, values)

    # Mapping solution elements (enumeration literals) to problem statement elements.
    for key, values in enum_literal_name_to_pses.items():
        element = get_enumeration_literal_element(key, class_diagram)
        create_solution_element(solution, element, values)

    # Save modeling assistant
    save_to_files({OUTPUT_FILE_MA : modeling_assistant})


def create_solution_element(solution, element, values):
    se = SolutionElement(solution=solution, element=element)
    for value in values:
        se.problemStatementElements.add(value)


def get_class_element(class_name, cdm):
    for cls in cdm.classes:
        if cls.name == class_name:
            return cls
    raise Exception(f"{class_name} class not found, check spelling of class in .tsv")


def get_attribute_element(attrib_name, cdm):
    for cls in cdm.classes:
        for attrib in cls.attributes:
            if attrib.name == attrib_name:
                return attrib
    raise Exception(f"{attrib_name} attribute not found, check spelling of class in .tsv")


def get_association_element(assoc_name, cdm):
    assoc_cls_names = assoc_name.split("_")
    for assoc in cdm.associations:
        if(assoc_cls_names[0] in assoc.name and assoc_cls_names[1] in assoc.name):
            return assoc
    raise Exception(f"{assoc_name} association not found, check spelling of class in .tsv")


def get_association_end_element(assocEnd_name, cdm):
    assocEnd_names = assocEnd_name.split(".")
    cls_name = assocEnd_names[0]
    assocEnd_name = assocEnd_names[1]
    for cls in cdm.classes:
        if cls.name == cls_name:
            for ae in cls.associationEnds:
                if ae.name == assocEnd_name:
                    return ae
    raise Exception(
        f"{cls_name} class has no {assocEnd_name} association end not found, check spelling of class in .tsv")


def get_enumeration_element(enum_name, cdm):
    for type_ in cdm.types:
        if isinstance(type_, CDEnum) and type_.name == enum_name:
            return type_
    raise Exception(f"{enum_name} enum not found, check spelling of class in .tsv")


def get_enumeration_literal_element(enum_literal_name, cdm):
    for type_ in cdm.types:
        if isinstance(type_, CDEnum):
            for literal in type_.literals:
                if literal.name == enum_literal_name:
                    return literal
    raise Exception(f"{enum_literal_name} enum not found, check spelling of class in .tsv")


if __name__ == "__main__":
    solution_elem_to_problem_statement_elem()
