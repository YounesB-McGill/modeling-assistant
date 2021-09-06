"""
Tests for utils module.
"""

from learningcorpus.learningcorpus import MistakeTypeCategory
import utils

def test_mtc():
    "Test the mtc() helper function."
    mtc_name = "Using Java instead of Python"
    super_category = MistakeTypeCategory(name="Programming mistakes")
    mtc1 = MistakeTypeCategory(name=mtc_name, supercategory=super_category)
    mtc2 = utils.mtc(n=mtc_name, s=super_category)
    assert mtc1.name == mtc2.name
    assert mtc1.supercategory is mtc2.supercategory
