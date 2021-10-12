from learningcorpus.learningcorpus import MistakeTypeCategory, MistakeType
from mistaketypes import MISSING_CLASS, SOFTWARE_ENGINEERING_TERM, CLASS_MISTAKES, CLASS_NAME_MISTAKES
from corpus import mts_by_priority

import mistaketypes

def test_get_mistake_type_and_mistake_type_category_by_names():
    class_mistakes_mtc_name = "Class mistakes"
    missing_class_mt_name = "Missing class"

    expected_wrong_class_mtc = MistakeTypeCategory(name=class_mistakes_mtc_name)

    expected_missing_class_mt = MistakeType(
        name=missing_class_mt_name,
        atomic=False,
        mistakeTypeCategory=expected_wrong_class_mtc,
        numStepsBeforeNotification=3,
        timeToAddress=None)

    actual_wrong_class_mtc: MistakeTypeCategory = mistaketypes.CLASS_MISTAKES
    actual_missing_class_mt: MistakeType = mistaketypes.MISSING_CLASS

    assert expected_wrong_class_mtc.name == actual_wrong_class_mtc.name

    assert expected_missing_class_mt.name == actual_missing_class_mt.name
    assert expected_missing_class_mt.atomic == actual_missing_class_mt.atomic
    assert (expected_missing_class_mt.mistakeTypeCategory.name ==
        actual_missing_class_mt.mistakeTypeCategory.name)

    assert actual_wrong_class_mtc.learningCorpus
    assert (actual_wrong_class_mtc.learningCorpus ==
        actual_missing_class_mt.mistakeTypeCategory.learningCorpus)



def test_learning_corpus_mistake_types_and_categories_hierarchy():
    """
    Verify mistake types and categories hierarchy in the default learning corpus instance used in mistaketypes.py.
    """
    learning_corpus = CLASS_MISTAKES.learningCorpus

    assert "Class mistakes" == CLASS_MISTAKES.name
    assert "Class name mistakes" == CLASS_NAME_MISTAKES.name
    assert "Missing class" == MISSING_CLASS.name
    assert "Software engineering term" == SOFTWARE_ENGINEERING_TERM.name

    """
    Verify all of these relationships:

                          Class mistakes: MistakeTypeCategory
                        /                                  \
        Class name mistakes: MistakeTypeCategory       Missing class: MistakeType
                       |
         Software engineering term: MistakeType
    """
    assert CLASS_NAME_MISTAKES in CLASS_MISTAKES.subcategories
    assert CLASS_NAME_MISTAKES.supercategory is CLASS_MISTAKES
    assert MISSING_CLASS in CLASS_MISTAKES.mistakeTypes
    assert MISSING_CLASS.mistakeTypeCategory is CLASS_MISTAKES
    assert SOFTWARE_ENGINEERING_TERM in CLASS_NAME_MISTAKES.mistakeTypes
    assert SOFTWARE_ENGINEERING_TERM.mistakeTypeCategory is CLASS_NAME_MISTAKES
    for mtc in [CLASS_MISTAKES, CLASS_NAME_MISTAKES]:
        assert mtc.learningCorpus is learning_corpus
    for mt in [MISSING_CLASS, SOFTWARE_ENGINEERING_TERM]:
        assert mt.mistakeTypeCategory.learningCorpus is learning_corpus


def test_mistake_type_priorities():
    """
    Verify that all mistake types are assigned a priority.
    """
    assert len(mts_by_priority) == len(set(mts_by_priority)) == len(CLASS_MISTAKES.learningCorpus.mistakeTypes())
    for mt in mts_by_priority:
        if mt:
            assert isinstance(mt, MistakeType)
            assert mt.priority
