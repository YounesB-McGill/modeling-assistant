"""
Run this file to generate modeling assistant instance with problem statement, problem statement elements and solution elements.

Before running make sure you have correct .tsv file path.

Paramenter: input file(.tsv) and output file path

# Author : Prabhsimran Singh
"""

#!/usr/bin/env python

from collections import defaultdict
import csv
import sys
from classdiagram import CDEnum
from fileserdes import load_cdm, save_to_files
from modelingassistant import (ModelingAssistant, ProblemStatement,
                               ProblemStatementElement, Solution,
                               SolutionElement)

input_file = "modelingassistant/pythonclient/ProblemStatementElements.tsv"
output_file = "/instructorSolution/instructorSolution2/Class Diagram/InstructorSolution2.domain_model.cdm"


def populate_dict(value, pse_name, name_to_pse, string_to_pse):
    value = value.replace(" ", "")
    if "," in value:
        values = value.split(",")
        for val in values:
            name_to_pse[val].append(string_to_pse[pse_name])
    else:
        name_to_pse[value].append(string_to_pse[pse_name])

def solution_elem_to_problem_statement_elem():
    CDM_PATH = "mistakedetection/realModels" + output_file

    try:
        file_data = open(input_file)
        cdm_file = f"{CDM_PATH}"
        class_diagram = load_cdm(cdm_file)

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
    className_to_pses = defaultdict(list) # Dict to map class name to problem statement elements
    attribName_to_pses = defaultdict(list) # Dict to map attribute name to problem statement elements
    assocName_to_pses = defaultdict(list) # Dict to map association name to problem statement elements
    assocEndName_to_pses = defaultdict(list) # Dict to map association end name to problem statement elements
    enumName_to_pses = defaultdict(list) # Dict to map enum name to problem statement elements
    enumLiteralName_to_pses = defaultdict(list) # Dict to enum literal attribute name to problem statement elements

    # Creates problem statement elements for given strings.
    for row in read_file:
        pse_name = row['Problem Statement Element']
        if pse_name not in string_to_pses:
            pse = ProblemStatementElement(problemStatement=problem_statement)
            string_to_pses[pse_name] = pse

        # Map class name to problem statement elements
        if row['Class Element']:
            populate_dict(row['Class Element'], pse_name, className_to_pses, string_to_pses)

        # Map assoc class names to problem statement elements
        if row['Association class']:
            populate_dict(row['Association class'], pse_name, className_to_pses, string_to_pses)

        # Map attribute names to problem statement elements
        if row['Attribute']:
            populate_dict(row['Attribute'], pse_name, attribName_to_pses, string_to_pses)

        # Map association names to problem statement elements
        if row['Association']:
            populate_dict(row['Association'], pse_name, assocName_to_pses, string_to_pses)

        # Map association names to problem statement elements
        if row['Association End']:
            populate_dict(row['Association End'], pse_name, assocEndName_to_pses, string_to_pses)

        # Map Generalization to problem statement elements
        if row['Generalization']:
            populate_dict(row['Generalization'], pse_name, className_to_pses, string_to_pses)

        # Map Enummeration to problem statement elements
        if row['Enummeration']:
            populate_dict(row['Enummeration'], pse_name, enumName_to_pses, string_to_pses)

        # Map Enummeration Literal to problem statement elements
        if row['Enummeration Literal']:
            populate_dict(row['Enummeration Literal'], pse_name, enumLiteralName_to_pses, string_to_pses)

    se_to_pse = {} # solution element to problem statement elements

    # Mapping solution elements (classes, assoc class, gen classes) to problem statement elements.
    for key, values in className_to_pses.items():
        element = getClassElement(key, class_diagram)
        createSolutionElement(solution, element, values)

    # Mapping solution elements (attributes) to problem statement elements.
    for key, values in attribName_to_pses.items():
        element = getAttributeElement(key, class_diagram)
        createSolutionElement(solution, element, values)

    # Mapping solution elements (associations) to problem statement elements.
    for key, values in assocName_to_pses.items():
        element = getAssociationElement(key, class_diagram)
        createSolutionElement(solution, element, values)

     # Mapping solution elements (association ends) to problem statement elements.
    for key, values in assocEndName_to_pses.items():
        element = getAssociationEndElement(key, class_diagram)
        createSolutionElement(solution, element, values)

    # Mapping solution elements (enumerations) to problem statement elements.
    for key, values in enumName_to_pses.items():
        element = getEnumerationElement(key, class_diagram)
        createSolutionElement(solution, element, values)

    # Mapping solution elements (enumeration literals) to problem statement elements.
    for key, values in enumLiteralName_to_pses.items():
        element = getEnumerationLiteralElement(key, class_diagram)
        createSolutionElement(solution, element, values)

    # Save modelling assistant
    saveModelingAssitant(modeling_assistant=modeling_assistant)

def saveModelingAssitant(modeling_assistant):
    MA_PATH = "modelingassistant/ProblemStatementInstance"
    ma_path = f"{MA_PATH}/problem_statement_instance.modelingassistant"
    save_to_files({ma_path: modeling_assistant})

def createSolutionElement(solution, element, values):
    se = SolutionElement(solution=solution, element= element)
    for value in values:
        #value.solutionElements.add(se)
        se.problemStatementElements.add(value)

def getClassElement(class_name, cdm):
    for cls in cdm.classes:
        if cls.name == class_name:
            return cls
    raise Exception(class_name, "class not found, check spelling of class in .tsv")

def getAttributeElement(attrib_name, cdm):
    for cls in cdm.classes:
        for attrib in cls.attributes:
            if attrib.name == attrib_name:
                return attrib
    raise Exception(attrib_name, "attribute not found, check spelling of class in .tsv")

def getAssociationElement(assoc_name, cdm):
    assoc_cls_names = assoc_name.split("_")
    for assoc in cdm.associations:
        if(assoc_cls_names[0] in assoc.name and assoc_cls_names[1] in assoc.name):
            return assoc
    raise Exception(assoc_name, "association not found, check spelling of class in .tsv")

def getAssociationEndElement(assocEnd_name, cdm):
    assocEnd_names = assocEnd_name.split(".")
    cls_name = assocEnd_names[0]
    assocEnd_name = assocEnd_names[1]
    for cls in cdm.classes:
        if cls.name == cls_name:
            for ae in cls.associationEnds:
                if(ae.name == assocEnd_name):
                    return ae
    raise Exception(cls_name, "class has no ", assocEnd_name, "association end not found, check spelling of class in .tsv")

def getEnumerationElement(enum_name, cdm):
    for type in cdm.types:
        if isinstance(type, CDEnum) and type.name == enum_name:
            return type
    raise Exception(enum_name, "enum not found, check spelling of class in .tsv")

def getEnumerationLiteralElement(enum_literal_name, cdm):
    for type in cdm.types:
        if isinstance(type, CDEnum):
            for literal in type.literals:
                if(literal.name == enum_literal_name):
                    return literal
    raise Exception(enum_literal_name, "enum not found, check spelling of class in .tsv")

if __name__ == "__main__":
    solution_elem_to_problem_statement_elem()



