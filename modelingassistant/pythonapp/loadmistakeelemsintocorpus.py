#!/usr/bin/env python3
"""
Module to load mistake elements generated from the MDS into the learning corpus.

To use this file, first ensure that the modelingassistant/corpus_descriptions/mistakeelems.json file is up to date,
then run this file to update corpus_definition.py
"""
import json

from constants import MISTAKE_ELEMS_JSON_FILE

CORPUS_DEF_FILE = "modelingassistant/pythonapp/corpus_definition.py"

FBS = "feedbacks=fbs({"
PLACEHOLDER = '"@@PLACEHOLDER@@"'


def insert_mistake_elements():
    "Extract the mistake elements from the JSON file and insert them in the corpus description."
    with open(MISTAKE_ELEMS_JSON_FILE, "r", encoding="utf-8") as f:
        mistake_elements: dict[str, list[list[str]]] = json.load(f)
    with open(CORPUS_DEF_FILE, "r", encoding="utf-8") as f:
        corpus_def: str = f.read().replace(FBS, f"{PLACEHOLDER}, {FBS}")
    for mistake_element, stud_inst_pairs in mistake_elements.items():
        before, after = corpus_def.split(mistake_element, 1)
        after = after.replace(PLACEHOLDER, create_arguments(stud_inst_pairs), 1)
        corpus_def = f"{before}{mistake_element}{after}"
    print(corpus_def)
    # this is commented out to avoid accidentally overwriting the file
    # with open(CORPUS_DEF_FILE, "w", encoding="utf-8") as f:
    #     f.write(corpus_def)


def create_arguments(stud_inst_pair: list[list[str]]) -> str:
    "Create the arguments for the mistake element stud-inst pair."
    def str_or_list(x):
        return f'"{x[0]}"' if len(x) == 1 else x
    stud, inst = stud_inst_pair
    if stud == inst:
        return f"stud_inst={str_or_list(stud)}".replace("'", '"')
    return f"stud={str_or_list(stud)}, inst={str_or_list(inst)}".replace("'", '"')


if __name__ == "__main__":
    "Main entry point"
    insert_mistake_elements()
