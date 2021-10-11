"""
This file contains all mistake types and categories.
"""

from constants import LEARNING_CORPUS_PATH
from fileserdes import load_lc
from learningcorpus import MistakeTypeCategory, MistakeType

corpus = load_lc(LEARNING_CORPUS_PATH)

# Populate dictionaries
MISTAKE_TYPE_CATEGORIES_BY_NAME: dict[str, MistakeTypeCategory] = {c.name: c for c in corpus.mistakeTypeCategories}
MISTAKE_TYPES_BY_NAME: dict[str, MistakeType] = {mt.name: mt for mt in corpus.mistakeTypes()}

# Short-name references to the above maps for greater code legibility
_MTCS = MISTAKE_TYPE_CATEGORIES_BY_NAME
_MTS = MISTAKE_TYPES_BY_NAME

# Mistake type categories
CLASS_MISTAKES: MistakeTypeCategory = _MTCS["Class mistakes"]
ATTRIBUTE_MISTAKES: MistakeTypeCategory = _MTCS["Attribute mistakes"]
RELATIONSHIP_MISTAKES: MistakeTypeCategory = _MTCS["Relationship mistakes"]
DESIGN_PATTERN_MISTAKES: MistakeTypeCategory = _MTCS["Design pattern mistakes"]
CLASS_NAME_MISTAKES: MistakeTypeCategory = _MTCS["Class name mistakes"]
ENUMERATION_MISTAKES: MistakeTypeCategory = _MTCS["Enumeration mistakes"]
EXTRA_ATTRIBUTE_MISTAKES: MistakeTypeCategory = _MTCS["Extra attribute mistakes"]
WRONG_ATTRIBUTE_NAME_MISTAKES: MistakeTypeCategory = _MTCS["Wrong attribute name mistakes"]
ATTRIBUTE_IN_WRONG_CLASS_MISTAKES: MistakeTypeCategory = _MTCS["Attribute in wrong class mistakes"]
MISSING_ASSOCIATION_MISTAKES: MistakeTypeCategory = _MTCS["Missing association mistakes"]
EXTRA_ASSOCIATION_MISTAKES: MistakeTypeCategory = _MTCS["Extra association mistakes"]
ASSOCIATION_TYPE_MISTAKES: MistakeTypeCategory = _MTCS["Association type mistakes"]
ASSOCIATION_NAME_MISTAKES: MistakeTypeCategory = _MTCS["Association name mistakes"]
MULTIPLICITY_MISTAKES: MistakeTypeCategory = _MTCS["Multiplicity mistakes"]
ROLE_NAME_MISTAKES: MistakeTypeCategory = _MTCS["Role name mistakes"]
ASSOCIATION_CLASS_MISTAKES: MistakeTypeCategory = _MTCS["Association class mistakes"]
ASSOCIATION_MISTAKES: MistakeTypeCategory = _MTCS["Association mistakes"]
COMPOSITION_MISTAKES: MistakeTypeCategory = _MTCS["Composition mistakes"]
GENERALIZATION_MISTAKES: MistakeTypeCategory = _MTCS["Generalization mistakes"]
USING_DIFFERENT_PLAYER_ROLE_PATTERN: MistakeTypeCategory = _MTCS["Using different Player-Role pattern"]
PLAYER_ROLE_PATTERN_MISTAKES: MistakeTypeCategory = _MTCS["Player-Role Pattern mistakes"]
ABSTRACTION_OCCURRENCE_PATTERN_MISTAKES: MistakeTypeCategory = _MTCS["Abstraction-Occurrence pattern mistakes"]

# Mistake types
MISSING_CLASS: MistakeType = _MTS["Missing class"]
EXTRA_CLASS: MistakeType = _MTS["Extra (redundant) class"]
USING_N_ARY_ASSOC_INSTEAD_OF_INTERMEDIATE_CLASS: MistakeType = _MTS["Using n-ary assoc instead of intermediate class"]
MISSING_ATTRIBUTE: MistakeType = _MTS["Missing attribute"]
WRONG_ATTRIBUTE_TYPE: MistakeType = _MTS["Wrong attribute type"]
MISSING_ATTRIBUTE_TYPE: MistakeType = _MTS["Missing attribute type"]
ATTRIBUTE_SHOULD_BE_STATIC: MistakeType = _MTS["Attribute should be static"]
ATTRIBUTE_SHOULD_NOT_BE_STATIC: MistakeType = _MTS["Attribute should not be static"]
PLURAL_CLASS_NAME: MistakeType = _MTS["Plural class name"]
LOWERCASE_CLASS_NAME: MistakeType = _MTS["Lowercase class name"]
SOFTWARE_ENGINEERING_TERM: MistakeType = _MTS["Software engineering term"]
BAD_CLASS_NAME_SPELLING: MistakeType = _MTS["Bad class name spelling"]
SIMILAR_CLASS_NAME: MistakeType = _MTS["Similar (yet incorrect) class name"]
WRONG_CLASS_NAME: MistakeType = _MTS["Wrong class name"]
CLASS_SHOULD_BE_ENUM: MistakeType = _MTS["Class should be enum"]
ENUM_SHOULD_BE_CLASS: MistakeType = _MTS["Enum should be class"]
MISSING_ENUM: MistakeType = _MTS["Missing enum"]
EXTRA_ENUM: MistakeType = _MTS["Extra enum"]
BAD_ENUM_NAME_SPELLING: MistakeType = _MTS["Bad enum name spelling"]
SIMILAR_ENUM_NAME: MistakeType = _MTS["Similar enum name"]
MISSING_ENUM_ITEM: MistakeType = _MTS["Missing enum item"]
EXTRA_ENUM_ITEM: MistakeType = _MTS["Extra enum item"]
BAD_ENUM_ITEM_SPELLING: MistakeType = _MTS["Bad enum item spelling"]
SIMILAR_ENUM_ITEM: MistakeType = _MTS["Similar enum item"]
PLURAL_ATTRIBUTE: MistakeType = _MTS["Plural attribute"]
LIST_ATTRIBUTE: MistakeType = _MTS["List attribute"]
EXTRA_ATTRIBUTE: MistakeType = _MTS["Extra attribute"]
BAD_ATTRIBUTE_NAME_SPELLING: MistakeType = _MTS["Bad attribute name spelling"]
UPPERCASE_ATTRIBUTE_NAME: MistakeType = _MTS["Uppercase attribute name"]
SIMILAR_ATTRIBUTE_NAME: MistakeType = _MTS["Similar (yet incorrect) attribute name"]
ATTRIBUTE_MISPLACED: MistakeType = _MTS["Attribute misplaced"]
ATTRIBUTE_DUPLICATED: MistakeType = _MTS["Attribute duplicated"]
ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY: MistakeType = _MTS["Attribute misplaced in generalization hierarchy"]
MISSING_ASSOCIATION: MistakeType = _MTS["Missing association"]
MISSING_AGGREGATION: MistakeType = _MTS["Missing aggregation"]
MISSING_N_ARY_ASSOCIATION: MistakeType = _MTS["Missing n-ary association"]
USING_ATTRIBUTE_INSTEAD_OF_ASSOC: MistakeType = _MTS["Using attribute instead of assoc"]
REPRESENTING_ACTION_WITH_ASSOC: MistakeType = _MTS["Representing action with assoc"]
EXTRA_ASSOCIATION: MistakeType = _MTS["Extra association"]
EXTRA_AGGREGATION: MistakeType = _MTS["Extra aggregation"]
EXTRA_N_ARY_ASSOCIATION: MistakeType = _MTS["Extra n-ary association"]
USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOC: MistakeType = _MTS["Using aggregation/composition instead of assoc"]
USING_DIRECTED_ASSOC_INSTEAD_OF_UNDIRECTED: MistakeType = _MTS["Using directed assoc instead of undirected"]
USING_UNDIRECTED_ASSOC_INSTEAD_OF_DIRECTED: MistakeType = _MTS["Using undirected assoc instead of directed"]
USING_COMPOSITION_INSTEAD_OF_AGGREGATION: MistakeType = _MTS["Using composition instead of aggregation"]
USING_BINARY_ASSOC_INSTEAD_OF_N_ARY_ASSOC: MistakeType = _MTS["Using binary assoc instead of n-ary assoc"]
USING_N_ARY_ASSOC_INSTEAD_OF_BINARY_ASSOC: MistakeType = _MTS["Using n-ary assoc instead of binary assoc"]
USING_INTERMEDIATE_CLASS_INSTEAD_OF_N_ARY_ASSOC: MistakeType = _MTS["Using intermediate class instead of n-ary assoc"]
MISSING_ASSOCIATION_NAME: MistakeType = _MTS["Missing association name"]
BAD_ASSOCIATION_NAME_SPELLING: MistakeType = _MTS["Bad association name spelling"]
SIMILAR_ASSOCIATION_NAME: MistakeType = _MTS["Similar (yet incorrect) association name"]
INFINITE_RECURSIVE_DEPENDENCY: MistakeType = _MTS["Infinite recursive dependency"]
WRONG_MULTIPLICITY: MistakeType = _MTS["Wrong multiplicity"]
MISSING_MULTIPLICITY: MistakeType = _MTS["Missing multiplicity"]
MISSING_ROLE_NAMES: MistakeType = _MTS["Missing role names"]
ROLE_SHOULD_BE_STATIC: MistakeType = _MTS["Role should be static"]
ROLE_SHOULD_NOT_BE_STATIC: MistakeType = _MTS["Role should not be static"]
BAD_ROLE_NAME_SPELLING: MistakeType = _MTS["Bad role name spelling"]
SIMILAR_ROLE_NAME: MistakeType = _MTS["Similar (yet incorrect) role name"]
WRONG_ROLE_NAME: MistakeType = _MTS["Wrong role name"]
MISSING_ASSOC_CLASS: MistakeType = _MTS["Missing assoc class"]
EXTRA_ASSOC_CLASS: MistakeType = _MTS["Extra assoc class"]
BAD_ASSOC_CLASS_NAME_SPELLING: MistakeType = _MTS["Bad assoc class name spelling"]
ASSOC_CLASS_SHOULD_BE_CLASS: MistakeType = _MTS["Assoc class should be class"]
CLASS_SHOULD_BE_ASSOC_CLASS: MistakeType = _MTS["Class should be assoc class"]
SIMILAR_ASSOC_CLASS_NAME: MistakeType = _MTS["Similar assoc class name"]
MISSING_COMPOSITION: MistakeType = _MTS["Missing composition"]
EXTRA_COMPOSITION: MistakeType = _MTS["Extra composition"]
USING_ASSOCIATION_INSTEAD_OF_AGGREGATION_COMPOSITION: MistakeType = \
    _MTS["Using association instead of aggregation/composition"]
USING_AGGREGATION_INSTEAD_OF_COMPOSITION: MistakeType = _MTS["Using aggregation instead of composition"]
COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT: MistakeType = _MTS["Composed part contained in more than one parent"]
INCOMPLETE_CONTAINMENT_TREE: MistakeType = _MTS["Incomplete containment tree"]
MISSING_GENERALIZATION: MistakeType = _MTS["Missing generalization"]
EXTRA_GENERALIZATION: MistakeType = _MTS["Extra generalization"]
GENERALIZATION_INAPPLICABLE: MistakeType = _MTS["Generalization inapplicable"]
SUBCLASS_NOT_DISTINCT_ACROSS_LIFETIME: MistakeType = _MTS["Subclass not distinct across lifetime"]
INHERITED_FEATURE_DOES_NOT_MAKE_SENSE_FOR_SUBCLASS: MistakeType = \
    _MTS["Inherited feature does not make sense for subclass"]
SUBCLASS_IS_AN_INSTANCE_OF_SUPERCLASS: MistakeType = _MTS["Subclass is an instance of superclass"]
NON_DIFFERENTIATED_SUBCLASS: MistakeType = _MTS["Non-differentiated subclass"]
WRONG_GENERALIZATION_DIRECTION: MistakeType = _MTS["Wrong generalization direction"]
WRONG_SUPERCLASS: MistakeType = _MTS["Wrong superclass"]
SUBCLASS_SHOULD_BE_FULL_PR_PATTERN: MistakeType = _MTS["Subclass should be full PR pattern"]
SUBCLASS_SHOULD_BE_ASSOC_PR_PATTERN: MistakeType = _MTS["Subclass should be assoc PR pattern"]
SUBCLASS_SHOULD_BE_ENUM_PR_PATTERN: MistakeType = _MTS["Subclass should be enum PR pattern"]
ASSOC_SHOULD_BE_FULL_PR_PATTERN: MistakeType = _MTS["Assoc should be full PR pattern"]
ASSOC_SHOULD_BE_SUBCLASS_PR_PATTERN: MistakeType = _MTS["Assoc should be subclass PR pattern"]
ASSOC_SHOULD_BE_ENUM_PR_PATTERN: MistakeType = _MTS["Assoc should be enum PR pattern"]
ENUM_SHOULD_BE_FULL_PR_PATTERN: MistakeType = _MTS["Enum should be full PR pattern"]
ENUM_SHOULD_BE_SUBCLASS_PR_PATTERN: MistakeType = _MTS["Enum should be subclass PR pattern"]
ENUM_SHOULD_BE_ASSOC_PR_PATTERN: MistakeType = _MTS["Enum should be assoc PR pattern"]
FULL_PR_PATTERN_SHOULD_BE_SUBCLASS: MistakeType = _MTS["Full PR pattern should be subclass"]
FULL_PR_PATTERN_SHOULD_BE_ASSOC: MistakeType = _MTS["Full PR pattern should be assoc"]
FULL_PR_PATTERN_SHOULD_BE_ENUM: MistakeType = _MTS["Full PR pattern should be enum"]
MISSING_PR_PATTERN: MistakeType = _MTS["Missing PR pattern"]
INCOMPLETE_PR_PATTERN: MistakeType = _MTS["Incomplete PR pattern"]
MISSING_AO_PATTERN: MistakeType = _MTS["Missing AO pattern"]
INCOMPLETE_AO_PATTERN: MistakeType = _MTS["Incomplete AO pattern"]
