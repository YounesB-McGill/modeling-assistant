"""
Tests for utils module.
"""

from learningcorpus.learningcorpus import MistakeType, MistakeTypeCategory
import utils

def test_mtc():
    "Test the mtc() helper function."
    mtc_name = "Using Java instead of Python"
    super_category = MistakeTypeCategory(name="Programming mistakes")
    mtc1 = MistakeTypeCategory(name=mtc_name, supercategory=super_category)
    mtc2 = utils.mtc(n=mtc_name, s=super_category)
    assert mtc1.name == mtc2.name == mtc_name
    assert mtc1.supercategory is mtc2.supercategory


def test_mt():
    "Test the mt() helper function."
    mt_name = "Redundant getters and setters"
    mt_desc = "Using redundant getters and setters is un-Pythonic."
    mt1 = MistakeType(name=mt_name, description=mt_desc)
    mt2 = utils.mt(n=mt_name, d=mt_desc)
    mt3 = utils.mt(n=mt_name)
    assert mt1.name == mt2.name == mt3.name == mt_name
    assert mt1.description == mt2.description == mt_desc
    assert mt3.name == mt3.description == mt_name
