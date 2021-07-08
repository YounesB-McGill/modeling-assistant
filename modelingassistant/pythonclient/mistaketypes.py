"""
This file contains all mistake types and categories.
"""

from fileserdes import load_lc
from learningcorpus.learningcorpus import MistakeTypeCategory, MistakeType

LEARNING_CORPUS_PATH = "modelingassistant.learningcorpus.dsl.instances/default.learningcorpus"
corpus = load_lc(LEARNING_CORPUS_PATH)

# Populate dictionaries
MISTAKE_TYPE_CATEGORIES_BY_NAME: dict[str, MistakeTypeCategory] = {c.name: c for c in corpus.mistakeTypeCategories}
MISTAKE_TYPES_BY_NAME: dict[str, MistakeType] = {mt.name: mt for mt in corpus.mistakeTypes()}

# Short-name references to the above maps for greater code legibility
_MTCS = MISTAKE_TYPE_CATEGORIES_BY_NAME
_MTS = MISTAKE_TYPES_BY_NAME

_dynamic_mtc_type = type(list(_MTCS.values())[0])
_dynamic_mt_type = type(list(_MTS.values())[0])

# Mistake type categories
WRONG_CLASS: MistakeTypeCategory = _MTCS["Wrong class"]
WRONG_CLASS_NAME: MistakeTypeCategory = _MTCS["Wrong class name"]
WRONG_ENUMERATION: MistakeTypeCategory = _MTCS["Wrong enumeration"]
WRONG_ATTRIBUTE: MistakeTypeCategory = _MTCS["Wrong attribute"]
EXTRA_ATTRIBUTE: MistakeTypeCategory = _MTCS["Extra (redundant) attribute"]
WRONG_ATTRIBUTE_NAME: MistakeTypeCategory = _MTCS["Wrong attribute name"]
ATTRIBUTE_IN_WRONG_CLASS: MistakeTypeCategory = _MTCS["Attribute in wrong class"]
WRONG_RELATIONSHIP: MistakeTypeCategory = _MTCS["Wrong relationship"]
MISSING_RELATIONSHIP: MistakeTypeCategory = _MTCS["Missing relationship"]
EXTRA_ASSOCIATION: MistakeTypeCategory = _MTCS["Extra (redundant) association"]
USING_WRONG_RELATIONSHIP_TYPE: MistakeTypeCategory = _MTCS["Using wrong relationship type"]
WRONG_ASSOCIATION_NAME: MistakeTypeCategory = _MTCS["Wrong association name"]
WRONG_MULTIPLICITIES: MistakeTypeCategory = _MTCS["Wrong multiplicities"]
WRONG_ROLE_NAMES: MistakeTypeCategory = _MTCS["Wrong role names"]
WRONG_ASSOCIATION_CLASS: MistakeTypeCategory = _MTCS["Wrong association class"]
WRONG_GENERALIZATION: MistakeTypeCategory = _MTCS["Wrong generalization"]
MISUSE_OF_DESIGN_PATTERNS: MistakeTypeCategory = _MTCS["Misuse of design patterns"]
WRONG_PLAYER_ROLE_PATTERN: MistakeTypeCategory = _MTCS["Wrong Player-Role Pattern"]
MISUSE_OF_ABSTRACTION_OCCURRENCE: MistakeTypeCategory = _MTCS["Misuse of Abstraction-Occurrence"]

# Mistake types
MISSING_CLASS: MistakeType = _MTS["Missing class"]
EXTRA_CLASS: MistakeType = _MTS["Extra (redundant) class"]
PLURAL_CLASS_NAME: MistakeType = _MTS["Plural class name"]
LOWERCASE_CLASS_NAME: MistakeType = _MTS["Lowercase class name"]
SOFTWARE_ENGINEERING_TERM: MistakeType = _MTS["Software engineering term"]
BAD_CLASS_NAME_SPELLING: MistakeType = _MTS["Bad class name spelling"]
SIMILAR_CLASS_NAME: MistakeType = _MTS["Similar (yet incorrect) class name"]
REGULAR_CLASS_SHOULD_BE_ENUM: MistakeType = _MTS["Regular class should be enum"]
ENUM_SHOULD_BE_REGULAR_CLASS: MistakeType = _MTS["Enum should be regular class"]
MISSING_ENUM: MistakeType = _MTS["Missing enum"]
EXTRA_ENUM: MistakeType = _MTS["Extra enum"]
BAD_ENUM_NAME_SPELLING: MistakeType = _MTS["Bad enum name spelling"]
SIMILAR_ENUM_NAME: MistakeType = _MTS["Similar enum name"]
MISSING_ENUM_ITEM: MistakeType = _MTS["Missing enum item"]
EXTRA_ENUM_ITEM: MistakeType = _MTS["Extra enum item"]
BAD_ENUM_ITEM_SPELLING: MistakeType = _MTS["Bad enum item spelling"]
SIMILAR_ENUM_ITEM: MistakeType = _MTS["Similar enum item"]
MISSING_ATTRIBUTE: MistakeType = _MTS["Missing attribute"]
WRONG_ATTRIBUTE_TYPE: MistakeType = _MTS["Wrong attribute type"]
ATTRIBUTE_SHOULD_BE_STATIC: MistakeType = _MTS["Attribute should be static"]
ATTRIBUTE_SHOULD_NOT_BE_STATIC: MistakeType = _MTS["Attribute should not be static"]
PLURAL_ATTRIBUTE: MistakeType = _MTS["Plural attribute"]
LIST_ATTRIBUTE: MistakeType = _MTS["List attribute"]
OTHER_EXTRA_ATTRIBUTE: MistakeType = _MTS["Other extra attribute"]
BAD_ATTRIBUTE_NAME_SPELLING: MistakeType = _MTS["Bad attribute name spelling"]
SIMILAR_ATTRIBUTE_NAME: MistakeType = _MTS["Similar (yet incorrect) attribute name"]
ATTRIBUTE_MISPLACED: MistakeType = _MTS["Attribute misplaced"]
ATTRIBUTE_DUPLICATED: MistakeType = _MTS["Attribute duplicated"]
INCOMPLETE_CONTAINMENT_TREE: MistakeType = _MTS["Incomplete containment tree"]
MISSING_ASSOCIATION: MistakeType = _MTS["Missing association"]
MISSING_COMPOSITION: MistakeType = _MTS["Missing composition"]
MISSING_AGGREGATION: MistakeType = _MTS["Missing aggregation"]
USING_AN_ATTRIBUTE_INSTEAD_OF_AN_ASSOCIATION: MistakeType = _MTS["Using an attribute instead of an association"]
REPRESENTING_AN_ACTION_WITH_AN_ASSOCIATION: MistakeType = _MTS["Representing an action with an association"]
COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT: MistakeType = _MTS["Composed part contained in more than one parent"]
OTHER_EXTRA_ASSOCIATION: MistakeType = _MTS["Other extra association"]
USING_ASSOCIATION_INSTEAD_OF_AGGREGATION_COMPOSITION: MistakeType = \
    _MTS["Using association instead of aggregation/composition"]
USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION: MistakeType = \
    _MTS["Using aggregation/composition instead of association"]
USING_DIRECTED_ASSOCIATION_INSTEAD_OF_UNDIRECTED: MistakeType = _MTS["Using directed association instead of undirected"]
USING_UNDIRECTED_ASSOCIATION_INSTEAD_OF_DIRECTED: MistakeType = _MTS["Using undirected association instead of directed"]
USING_AGGREGATION_INSTEAD_OF_COMPOSITION: MistakeType = _MTS["Using aggregation instead of composition"]
USING_COMPOSITION_INSTEAD_OF_AGGREGATION: MistakeType = _MTS["Using composition instead of aggregation"]
MISSING_ASSOCIATION_NAME_WHEN_ONE_WAS_EXPECTED: MistakeType = _MTS["Missing association name when one was expected"]
BAD_ASSOCIATION_NAME_SPELLING: MistakeType = _MTS["Bad association name spelling"]
SIMILAR_ASSOCIATION_NAME: MistakeType = _MTS["Similar (yet incorrect) association name"]
INFINITE_RECURSIVE_DEPENDENCY: MistakeType = _MTS["Infinite recursive dependency"]
OTHER_WRONG_MULTIPLICITY: MistakeType = _MTS["Other wrong multiplicity"]
MISSING_ROLE_NAMES: MistakeType = _MTS["Missing role names"]
ROLE_SHOULD_BE_STATIC: MistakeType = _MTS["Role should be static"]
ROLE_SHOULD_NOT_BE_STATIC: MistakeType = _MTS["Role should not be static"]
BAD_ROLE_NAME_SPELLING: MistakeType = _MTS["Bad role name spelling"]
SIMILAR_ROLE_NAME: MistakeType = _MTS["Similar (yet incorrect) role name"]
OTHER_WRONG_ROLE_NAME: MistakeType = _MTS["Other wrong role name"]
MISSING_ASSOCIATION_CLASS: MistakeType = _MTS["Missing association class"]
EXTRA_ASSOCIATION_CLASS: MistakeType = _MTS["Extra (redundant) association class"]
BAD_ASSOCIATION_CLASS_NAME_SPELLING: MistakeType = _MTS["Bad association class name spelling"]
SIMILAR_ASSOCIATION_CLASS_NAME: MistakeType = _MTS["Similar (yet incorrect) association class name"]
MISSING_GENERALIZATION: MistakeType = _MTS["Missing generalization"]
GENERALIZATION_INAPPLICABLE: MistakeType = _MTS["Generalization inapplicable"]
SUBCLASS_NOT_DISTINCT_ACROSS_LIFETIME: MistakeType = _MTS["Subclass not distinct across lifetime"]
INHERITED_FEATURE_DOES_NOT_MAKE_SENSE_FOR_SUBCLASS: MistakeType = \
    _MTS["Inherited feature does not make sense for subclass"]
SUBCLASS_IS_AN_INSTANCE_OF_SUPERCLASS: MistakeType = _MTS["Subclass is an instance of superclass"]
NON_DIFFERENTIATED_SUBCLASS: MistakeType = _MTS["Non-differentiated subclass"]
WRONG_GENERALIZATION_DIRECTION: MistakeType = _MTS["Wrong generalization direction"]
WRONG_SUPERCLASS: MistakeType = _MTS["Wrong superclass"]


# deprecated: this function will be removed soon
def _make_static():
    """
    Make the mistake types and categories have static types from the generated code instead of
    dynamic pyecore types.
    """
    global _MTCS, _MTS
    for mtc in _MTCS.values(): mtc.__class__ = MistakeTypeCategory
    for mt in _MTS.values(): mt.__class__ = MistakeType


# deprecated: this function will be removed soon
def _make_dynamic():
    """
    Make the mistake types and categories have dynamic pyecore types, the default if
    `_make_static()` is not called.
    """
    global _MTCS, _MTS, _dynamic_mtc_type, _dynamic_mt_type
    for mtc in _MTCS.values(): mtc.__class__ = _dynamic_mtc_type
    for mt in _MTS.values(): mt.__class__ = _dynamic_mt_type


#_make_static()
