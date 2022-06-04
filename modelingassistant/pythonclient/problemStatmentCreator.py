#!/usr/bin/env python

import csv
import re
import json
import sys

try:    
    littlePony_data = pd.read_csv(sys.argv[3])
except:
    print("File Not found, check the address of .csv file")
    print("Hint: try entering ..\ for relative path, e.g ..\data\clean_dialog.csv")
    exit()

with open(sys.argv[3], 'r') as read_obj:
    csv_dict_reader = DictReader(read_obj)
    for row in csv_dict_reader:             
        pass
