#!/usr/bin/env python
# Author : Prabhsimran Singh

from asyncio.windows_events import NULL
import csv
import re
import json
import sys
from typing import Iterable
from xml.etree.ElementTree import Element
from modelingassistant import ModelingAssistant, ProblemStatement, ProblemStatementElement, SolutionElement, Solution
from classdiagram import CDEnum, ClassDiagram, Class, Attribute, CDInt, CDString, AssociationEnd, Association
from fileserdes import load_cdm, load_lc, load_ma, save_to_files
import collections 


def popDict(value, psen, name_to_pse, string_to_pse):
    value = value.replace(" ", "")
    if "," in value:
        values = value.split(",")
        for val in values:
            name_to_pse[val].append(string_to_pse [psen])
    else:
        name_to_pse[value].append(string_to_pse [psen])

def solutionElemToProblemStatementElem():
    CDM_PATH = "mistakedetection/realModels"   

    try:        
        file_url = "modelingassistant\pythonclient\ProblemStatementElements.tsv"
        file_data = open(file_url)   
        cdm_file = f"{CDM_PATH}/instructorSolution/instructorSolution2/Class Diagram/InstructorSolution2.domain_model.cdm"
        class_diagram = load_cdm(cdm_file)
        
    except:
        print("Files Not found, check the address of .tsv, .cdm files")   
        exit()

    # Modeling assistant instance
    modeling_assistant = ModelingAssistant()
    solution = Solution(modelingAssistant=modeling_assistant, classDiagram=class_diagram)
    problem_statement = ProblemStatement(modelingAssistant=modeling_assistant, instructorSolution=solution)
    solution.problemStatement = problem_statement

    read_file = csv.DictReader(file_data, delimiter="\t")

    string_to_pse = collections.defaultdict(list) # Dic to map string to probelm statement element
    className_to_pse = collections.defaultdict(list) # Dict to map class name to problem statement elements
    attribName_to_pse = collections.defaultdict(list) # Dict to map attribute name to problem statement elements
    assocName_to_pse = collections.defaultdict(list) # Dict to map association name to problem statement elements
    assocEndName_to_pse = collections.defaultdict(list) # Dict to map association end name to problem statement elements
    enumName_to_pse = collections.defaultdict(list) # Dict to map enum name to problem statement elements
    enumLiteralName_to_pse = collections.defaultdict(list) # Dict to enum literal attribute name to problem statement elements

    # Creates probelm statement elements for given strings.
    for row in read_file:  
        psen = row['Problem Statement Element']
        if  psen not in  string_to_pse:      
            pse = ProblemStatementElement(problemStatement=problem_statement)            
            string_to_pse [psen] = pse
        
        # Map class name to problem statement elements
        if row['Class Element']:
            popDict(row['Class Element'], psen, className_to_pse, string_to_pse)

        # Map assoc class names to problem statement elements
        if row['Association class']:
            popDict(row['Association class'], psen, className_to_pse, string_to_pse)

        # Map attribute names to problem statement elements
        if row['Attribute']:
            popDict(row['Attribute'], psen, attribName_to_pse, string_to_pse)

        # Map association names to problem statement elements
        if row['Association']:
            popDict(row['Association'], psen, assocName_to_pse, string_to_pse)

        # Map association names to problem statement elements
        if row['Association End']:
            popDict(row['Association End'], psen, assocEndName_to_pse, string_to_pse)

        # Map Generalization to problem statement elements
        if row['Generalization']:
            popDict(row['Generalization'], psen, className_to_pse, string_to_pse)

        # Map Enummeration to problem statement elements
        if row['Enummeration']:
            popDict(row['Enummeration'], psen, enumName_to_pse, string_to_pse)

        # Map Enummeration Literal to problem statement elements
        if row['Enummeration Literal']:
            popDict(row['Enummeration Literal'], psen, enumLiteralName_to_pse, string_to_pse)
            
    se_to_pse = {} # solution element to problem statement elements

    # Mapping solution elements (classes, assoc class, gen classes) to problem statement elements.
    for key, values in className_to_pse.items():
        element = getClassElement(key, class_diagram)
        createSolutionElement(solution, element, values)
    print("[1/6] ... Classes, Association classes, Generalization classes done")

    # Mapping solution elements (attributes) to problem statement elements.
    for key, values in attribName_to_pse.items():
        element = getAttributeElement(key, class_diagram)
        createSolutionElement(solution, element, values)
    print("[2/6] ... Attributes done")

    # Mapping solution elements (associations) to problem statement elements.
    for key, values in assocName_to_pse.items():
        element = getAssociationElement(key, class_diagram)
        createSolutionElement(solution, element, values)
    print("[3/6] ... Associations done")

     # Mapping solution elements (association ends) to problem statement elements.
    for key, values in assocEndName_to_pse.items():
        element = getAssociationEndElement(key, class_diagram)
        createSolutionElement(solution, element, values)
    print("[4/6] ... Association ends done")

    # Mapping solution elements (enumerations) to problem statement elements.
    for key, values in enumName_to_pse.items():
        element = getEnumerationElement(key, class_diagram)
        createSolutionElement(solution, element, values)
    print("[5/6] ... Enumerations done")

    # Mapping solution elements (enumeration literals) to problem statement elements.
    for key, values in enumLiteralName_to_pse.items():
        element = getEnumerationLiteralElement(key, class_diagram)
        createSolutionElement(solution, element, values)
    print("[6/6] ... Enumerations literals done")

    # Save modelling assistant
    saveModelingAssitant(modeling_assistant=modeling_assistant)

def saveModelingAssitant(modeling_assistant): 
    MA_PATH = "modelingassistant/ProblemStatementInstance"
    ma_path = f"{MA_PATH}/problem_statement_instance.modelingassistant"       
    save_to_files({ma_path: modeling_assistant})
    print("Modeling assistant saved to disk at ", ma_path)

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
    solutionElemToProblemStatementElem()



