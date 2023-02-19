#!/usr/bin/env python3
"""
Module to help evaluate the Mistake Detection System by parsing the spreadsheets its tests generate and combining the
results in a common spreadsheet.

Author: Younes Boubekeur
"""
# pylint: disable=wrong-import-position

import sys
import os

from openpyxl import load_workbook, Workbook
from openpyxl.worksheet.worksheet import Worksheet

# this line is needed to be able to call this script directly
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from envvars import env_vars


SPREADSHEET_LOCATIONS: str = env_vars["mds-evaluation-spreadsheet-location"]
COMMON_SPREADSHEET_PATH = f"{SPREADSHEET_LOCATIONS}/common-spreadsheet.xlsx"

INSTRUCTOR_SOLUTION_IDS = (201, 202, 203, 204)
EVALUATED_STUDENT_SOLUTION_IDS = [14, 36, 58, 80, 97]

TN_TP_FP_FN_R_P_F1_F2 = tuple[int, int, int, int, float, float, float, float]  # pylint: disable=invalid-name


def produce_common_spreadsheet():
    "Produce the common results spreadsheet from the individual ones used for the evaluation."
    results = [[(
        "True Negative",
        "True Positive",
        "False Positive",
        "False Negative",
        "Recall (TP / (TP + FN))",
        "Precision (TP / (TP + FP))",
        "F1 (2PR / (P + R))",
        "F2 (5PR / (4P + R)",
    )] for _ in range(len(INSTRUCTOR_SOLUTION_IDS))]
    for i, instructor_solution_id in enumerate(INSTRUCTOR_SOLUTION_IDS):
        for student_solution_id in EVALUATED_STUDENT_SOLUTION_IDS:
            results[i].append(get_spreadsheet_results(student_solution_id, instructor_solution_id))
    print_results(results)
    save_to_spreadsheet(results, COMMON_SPREADSHEET_PATH)


def save_to_spreadsheet(results: list[list[tuple]], path):
    "Saves the given results to the given file path."
    wb = Workbook()
    ws: Worksheet = wb.active
    for i, instructor_solution_id in enumerate(INSTRUCTOR_SOLUTION_IDS):
        ws.append((f"Instructor solution {instructor_solution_id}",))
        rows = []
        for j in range(len(results[i][0])):
            rows.append([results[i][k][j] for k in range(len(results[i]))])
        for row in rows:
            # print(row)
            ws.append(row)
        ws.append(("",))
    wb.save(path)



def print_results(results: list[list[tuple]]):
    "Print the results to console, useful for debugging."
    for i, instructor_solution_id in enumerate(INSTRUCTOR_SOLUTION_IDS):
        print(f"Instructor solution {instructor_solution_id}")
        for j in range(len(results[i][0])):
            for k in range(len(results[i])):  # pylint: disable=consider-using-enumerate
                print(f"{results[i][k][j]}", end=" ")
            print()
        print()


def get_spreadsheet_results(student_solution_id, instructor_solution_id) -> TN_TP_FP_FN_R_P_F1_F2:
    """
    Return the 8-tuple with the following elements for the given submission_id:

    - True Negatives
    - True Positives
    - False Positives
    - False Negatives
    - Recall (TP / (TP + FN))
    - Precision (TP / (TP + FP))
    - F1 (2 * Precision * Recall / (Precision + Recall))
    - F2 (5 * Precision * Recall) / (4 * Precision + Recall)
    """
    result = []
    ws = load_workbook(f"{SPREADSHEET_LOCATIONS}/{student_solution_id}/"
                       f"GroundTruth_{student_solution_id}_{instructor_solution_id}.xlsx",
                       read_only=True, data_only=True).active
    reached_tn = False
    for row in ws.values:
        if not reached_tn and row[0] and row[0].startswith("True Negative"):
            reached_tn = True
        if reached_tn:
            result.append(row[2] if row[2] is not None else 1)  # 1 is a default value if actual value is unavailable
    return tuple(result)


if __name__ == "__main__":
    produce_common_spreadsheet()
