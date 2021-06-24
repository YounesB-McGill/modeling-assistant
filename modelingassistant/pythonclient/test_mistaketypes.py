from pyecore.resources.resource import ResourceSet, URI
from learningcorpus.learningcorpus import LearningCorpus, MistakeTypeCategory, MistakeType
from mistaketypes import MISSING_CLASS, SOFTWARE_ENGINEERING_TERM, WRONG_CLASS, WRONG_CLASS_NAME
from corpus_creation import mts_by_priority

import mistaketypes

def test_get_mistake_type_and_mistake_type_category_by_names():
    wrong_class_mistake_type_category_name = "Wrong class"
    missing_class_mistake_type_name = "Missing class"

    expected_wrong_class_mistake_type_category = MistakeTypeCategory(name=wrong_class_mistake_type_category_name)

    expected_missing_class_mistake_type = MistakeType(
        name=missing_class_mistake_type_name,
        atomic=False,
        mistakeTypeCategory=expected_wrong_class_mistake_type_category,
        numStepsBeforeNotification=3,
        timeToAddress=None)

    actual_wrong_class_mistake_type_category: MistakeTypeCategory = mistaketypes.WRONG_CLASS
    actual_missing_class_mistake_type: MistakeType = mistaketypes.MISSING_CLASS

    assert expected_wrong_class_mistake_type_category.name == actual_wrong_class_mistake_type_category.name

    assert expected_missing_class_mistake_type.name == actual_missing_class_mistake_type.name
    assert expected_missing_class_mistake_type.atomic == actual_missing_class_mistake_type.atomic
    assert (expected_missing_class_mistake_type.mistakeTypeCategory.name ==
        actual_missing_class_mistake_type.mistakeTypeCategory.name)

    assert actual_wrong_class_mistake_type_category.learningCorpus
    assert (actual_wrong_class_mistake_type_category.learningCorpus ==
        actual_missing_class_mistake_type.mistakeTypeCategory.learningCorpus)



def test_learning_corpus_mistake_types_and_categories_hierarchy():
    """
    Verify mistake types and categories hierarchy in the default learning corpus instance used in mistaketypes.py.
    """
    learning_corpus = WRONG_CLASS.learningCorpus

    assert "Wrong class" == WRONG_CLASS.name
    assert "Wrong class name" == WRONG_CLASS_NAME.name
    assert "Missing class" == MISSING_CLASS.name
    assert "Software engineering term" == SOFTWARE_ENGINEERING_TERM.name

    """
    Verify all of these relationships:

                          Wrong class: MistakeTypeCategory
                        /                                  \
        Wrong class name: MistakeTypeCategory       Missing class: MistakeType
                        |
        Software engineering term: MistakeType
    """
    assert WRONG_CLASS_NAME in WRONG_CLASS.subcategories
    assert WRONG_CLASS_NAME.supercategory is WRONG_CLASS
    assert MISSING_CLASS in WRONG_CLASS.mistakeTypes
    assert MISSING_CLASS.mistakeTypeCategory is WRONG_CLASS
    assert SOFTWARE_ENGINEERING_TERM in WRONG_CLASS_NAME.mistakeTypes
    assert SOFTWARE_ENGINEERING_TERM.mistakeTypeCategory is WRONG_CLASS_NAME
    for mtc in [WRONG_CLASS, WRONG_CLASS_NAME]:
        assert mtc.learningCorpus is learning_corpus
    for mt in [MISSING_CLASS, SOFTWARE_ENGINEERING_TERM]:
        assert mt.mistakeTypeCategory.learningCorpus is learning_corpus


def test_mistake_type_priorities():
    """
    Verify that all mistake types are assigned a priority.
    """
    assert len(set(mts_by_priority)) == len(WRONG_CLASS.learningCorpus.mistakeTypes())
    for mt in mts_by_priority:
        if mt:
            assert isinstance(mt, MistakeType)
            assert mt.priority
