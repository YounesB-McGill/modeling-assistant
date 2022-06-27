#!/usr/bin/env python3

"""
Utility to get all the XMI IDs of an Ecore-encoded file.
"""

import re
import sys

from utils import warn


def get_xmi_ids(ecore_str: str) -> set[str]:
    """
    Get all the XMI IDs of an Ecore-encoded file.
    """
    return sorted(set(re.findall(r"xmi:id\s*=\s*\"(\w+)\"", ecore_str)))


def print_xmi_ids_for_files(*ecore_files):
    """
    Print all the XMI IDs of the given Ecore-encoded files and warn if any are duplicated.
    """
    if not ecore_files:
        print("Usage: python xmiidgetter.py <ecore_file> [<ecore_file> ...]")
        sys.exit(1)

    print("XMI IDs for files:\n")
    xmi_ids_to_files: dict[str, str] = {}
    for ecore_file in ecore_files:
        print(f"{ecore_file}:")
        with open(ecore_file, "r", encoding="utf-8") as f:
            xmi_ids = get_xmi_ids(f.read())
            for xmi_id in xmi_ids:
                print(f"    {xmi_id}")
                if xmi_id in xmi_ids_to_files:
                    warn(f"\n{xmi_id} is duplicated in {ecore_file} and {xmi_ids_to_files[xmi_id]}\n")
                else:
                    xmi_ids_to_files[xmi_id] = ecore_file
        print()


if __name__ == "__main__":
    print_xmi_ids_for_files(*sys.argv[1:])
