#!/usr/bin/env python3

"""
Rename items that match certain conditions.
"""

import glob
import os


def rename_items():
    "Rename items that match certain conditions."
    # recurse into files with glob
    print(os.getcwd())
    for file in glob.glob("**/*.cdm", recursive=True):
        print(file)
        with open(file, "r", encoding="utf-8") as f:
            lines = f.readlines()
            for i, line in enumerate(lines):
                if "<value" in line and "key" in line:
                    lines[i] = line.replace("<value", "<values")
                elif "</value>" in line:
                    lines[i] = line.replace("</value>", "</values>")
                else:
                    lines[i] = line
            with open(file, "w", encoding="utf-8") as f:
                f.writelines(lines)


if __name__ == "__main__":
    rename_items()
