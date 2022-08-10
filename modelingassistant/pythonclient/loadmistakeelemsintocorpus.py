#!/usr/bin/env python3
"""
Module to load mistake elements generated from the MDS into the learning corpus.

To use this file, first ensure that the modelingassistant/corpus_descriptions/mistakeelems.json file is up to date,
then run this file to update corpus_definition.py
"""
import json
from itertools import tee, islice, zip_longest

MISTAKE_ELEMS_FILE = "modelingassistant/corpus_descriptions/mistakeelems.json"
CORPUS_DEF_FILE = "modelingassistant/pythonclient/corpus_definition.py"

FBS = "feedbacks=fbs({"


def insert_padded_newline_after_feedbacks_equals_fbs() -> str:
    "Insert a padded newline before `feedbacks=fbs({` in corpus_definition.py."
    with open(CORPUS_DEF_FILE, "r", encoding="utf-8") as f:
        corpus_def = f.read()
    result = ""
    for line, next_line in get_next(corpus_def.splitlines()):
        if FBS in line.strip():
            n_spaces = len(next_line) - len(next_line.lstrip())
            if line.strip().startswith(FBS):  # there are no other characters before FBS
                n_spaces -= 4  # PEP8 tab width
            spaces = " " * n_spaces
            result += f"{line.replace(FBS, '').rstrip()}\n{spaces}\n{spaces}{FBS}\n"
        else:
            result += line + "\n"
    #print(result)

    # with open(CORPUS_DEF_FILE, "w", encoding="utf-8") as f:
    #     f.write(result)
    return result


def populate_mistake_elements(corpus_def: str) -> str:
    "Extract the mistake elements from the JSON file and insert them in the padded corpus description."
    with open(MISTAKE_ELEMS_FILE, "r", encoding="utf-8") as f:
        mistake_elements: dict[str, list[list[str]]] = json.load(f)
    lines = corpus_def.splitlines()
    result = lines[0]
    for i in range(1, len(lines) - 3):
        line, next_line, next_next_line = lines[i:i + 3]
        if ":=" in line:
            identifier = line.split(":=")[0].strip()
            if identifier in mistake_elements:
                pair = mistake_elements[identifier]
                if pair[0] == pair[1]:
                    mes = f"stud_inst={pair[0]},"
                else:
                    mes = f"stud={pair[0]}, inst={pair[1]},"
                if line.rstrip().endswith("mt("):
                    result += f"\n{next_next_line}{mes}"
                else:
                    result += f"\n{next_line}{mes}"
            else:
                result += f"\n{next_line}"
        else:
            result += f"\n{next_line}"
    result += "\n".join(lines[-3:]) + "\n"
    print(result)
    return result



# Based on stackoverflow.com/a/4197869
def get_next(some_iterable, window=1):
    "Get the next n items in an iterable."
    items, nexts = tee(some_iterable, 2)
    nexts = islice(nexts, window, None)
    return zip_longest(items, nexts)


if __name__ == "__main__":
    "Main entry point"
    populate_mistake_elements(insert_padded_newline_after_feedbacks_equals_fbs())
