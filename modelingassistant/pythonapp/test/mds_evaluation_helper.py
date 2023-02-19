#!/usr/bin/env python3
"""
Module to help evaluate the Mistake Detection System by parsing the spreadsheets its tests generate and combining the
results in a common spreadsheet.

Author: Younes Boubekeur
"""

from openpyxl import load_workbook

from envvars import env_vars

SPREADSHEET_LOCATIONS: str = env_vars["mds-evaluation-spreadsheet-location"]
