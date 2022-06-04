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
from classdiagram import ClassDiagram, Class, Attribute, CDInt, CDString, AssociationEnd, Association
from fileserdes import load_cdm, load_lc, load_ma, save_to_files
import collections 


def popDict(value, psen, name_to_pse, string_to_pse):
    if "," in value:
        associations = value.split(", ")
        for assoc in associations:
            name_to_pse[assoc].append(string_to_pse [psen])
    else:
        name_to_pse[value].append(string_to_pse [psen])

def solutionElemToProblemStatementElem():
    CDM_PATH = "mistakedetection/realModels"
    try:        
        file_url = "modelingassistant\pythonclient\ProblemStatementElements.txt"
        file_data = open(file_url)   
        cdm_file = f"{CDM_PATH}/instructorSolution/instructorSolution2/Class Diagram/InstructorSolution2.domain_model.cdm"
        class_diagram = load_cdm(cdm_file)
        
    except:
        print("Files Not found, check the address of .tsv, .cdm files")   
        exit()

    # Modeling assistant instance
    modeling_assistant = ModelingAssistant()
    problem_statement = ProblemStatement(modelingAssistant= modeling_assistant)
    solution = Solution(modelingAssistant=modeling_assistant, classDiagram=class_diagram)

    read_file = csv.DictReader(file_data, delimiter="\t")

    string_to_pse = collections.defaultdict(list) # Dic to map string to probelm statement element
    className_to_pse = collections.defaultdict(list) # Dict to map class name to problem statement elements
    attribName_to_pse = collections.defaultdict(list) # Dict to map attribute name to problem statement elements
    assocName_to_pse = collections.defaultdict(list) # Dict to map association name to problem statement elements
    genName_to_pse = collections.defaultdict(list) # Dict to map generalization class to problem statement elements
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

        # Map Generalization to problem statement elements
        if row['Generalization']:
            popDict(row['Generalization'], psen, genName_to_pse, string_to_pse)

        # Map Enummeration to problem statement elements
        if row['Enummeration']:
            popDict(row['Enummeration'], psen, enumName_to_pse, string_to_pse)

        # Map Enummeration Literal to problem statement elements
        if row['Enummeration Literal']:
            popDict(row['Enummeration Literal'], psen, enumLiteralName_to_pse, string_to_pse)
            
    se_to_pse = {} # solution element to problem statement elements

    for key, values in attribName_to_pse.items():
        print(key, '->', values)
        
       

if __name__ == "__main__":
    solutionElemToProblemStatementElem()

#element = getClassElement(row['Class Element'], class_diagram)
#se = SolutionElement(solution=solution, element= element)


