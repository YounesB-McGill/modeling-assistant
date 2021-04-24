from modelingassistant.modelingassistant import MistakeTypeCategory, MistakeType

import mistaketypes

def test_get_mistake_type_and_mistake_type_category_by_names():
    wrong_class_mistake_type_category_name = "Wrong class"
    missing_class_mistake_type_name = "Missing class"

    expected_wrong_class_mistake_type_category = MistakeTypeCategory(name=wrong_class_mistake_type_category_name)

    expected_missing_class_mistake_type = MistakeType(
        name=missing_class_mistake_type_name,
        atomic=False,
        mistaketypecategory=expected_wrong_class_mistake_type_category,
        numStepsBeforeNotification=3,
        timeToAddress=None)

    actual_wrong_class_mistake_type_category: MistakeTypeCategory = mistaketypes.WRONG_CLASS
    actual_missing_class_mistake_type: MistakeType = mistaketypes.MISSING_CLASS

    assert expected_wrong_class_mistake_type_category.name == actual_wrong_class_mistake_type_category.name
    
    assert expected_missing_class_mistake_type.name == actual_missing_class_mistake_type.name
    assert expected_missing_class_mistake_type.atomic == actual_missing_class_mistake_type.atomic
    assert (expected_missing_class_mistake_type.mistaketypecategory.name ==
        actual_missing_class_mistake_type.mistaketypecategory.name)
    
    assert actual_wrong_class_mistake_type_category.modelingassistant
    assert (actual_wrong_class_mistake_type_category.modelingassistant ==
        actual_missing_class_mistake_type.modelingAssistant)
