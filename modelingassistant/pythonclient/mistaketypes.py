"""
This file contains all mistake types and categories.
"""

from modelingassistant.modelingassistant import ModelingAssistant, MistakeTypeCategory, MistakeType
from pyecore.resources import ResourceSet, URI

MODELING_ASSISTANT_WITH_MISTAKE_TYPES_PATH = "modelingassistant.visualization.instances/MA1.modelingassistant"

MISTAKE_TYPE_CATEGORIES_BY_NAME: dict[str, MistakeTypeCategory] = {}
MISTAKE_TYPES_BY_NAME: dict[str, MistakeType] = {}

# Short-name references to the above maps for greater code legibility
_MTCS = MISTAKE_TYPE_CATEGORIES_BY_NAME
_MTS = MISTAKE_TYPES_BY_NAME

# Open Modeling Assistant metamodel and instance
ma_mm_file = "modelingassistant/model/modelingassistant.ecore"
rset = ResourceSet()
resource = rset.get_resource(URI(ma_mm_file))
ma_mm_root = resource.contents[0]
rset.metamodel_registry[ma_mm_root.nsURI] = ma_mm_root
resource = rset.get_resource(URI(MODELING_ASSISTANT_WITH_MISTAKE_TYPES_PATH))
modeling_assistant: ModelingAssistant = resource.contents[0]
modeling_assistant.__class__ = ModelingAssistant

# Populate dictionaries
for mtc in modeling_assistant.mistakeTypeCategories: MISTAKE_TYPE_CATEGORIES_BY_NAME[mtc.name] = mtc
for mt in modeling_assistant.mistakeTypes: MISTAKE_TYPES_BY_NAME[mt.name] = mt

# Mistake type categories
WRONG_CLASS: MistakeTypeCategory = _MTCS["Wrong class"]
WRONG_ENUMERATION: MistakeTypeCategory = _MTCS["Wrong enumeration"]
WRONG_CLASS_NAME: MistakeTypeCategory = _MTCS["Wrong class name"]
WRONG_ATTRIBUTE: MistakeTypeCategory = _MTCS["Wrong attribute"]
EXTRA_ATTRIBUTE: MistakeTypeCategory = _MTCS["Extra (redundant) attribute"]
WRONG_ATTRIBUTE_NAME: MistakeTypeCategory = _MTCS["Wrong attribute name"]
ATTRIBUTE_IN_WRONG_CLASS: MistakeTypeCategory = _MTCS["Attribute in wrong class"]
WRONG_RELATIONSHIPS: MistakeTypeCategory = _MTCS["Wrong relationships"]
MISSING_RELATIONSHIP_OF_ANY_TYPE: MistakeTypeCategory = _MTCS["Missing relationship of any type"]
EXTRA_ASSOCIATION: MistakeTypeCategory = _MTCS["Extra (redundant) association"]
USING_WRONG_RELATIONSHIP_TYPE: MistakeTypeCategory = _MTCS["Using wrong relationship type"]
WRONG_ASSOCIATION_NAME: MistakeTypeCategory = _MTCS["Wrong association name"]

# Mistake types
MISSING_CLASS: MistakeType = _MTS["Missing class"]
EXTRA_CLASS: MistakeType = _MTS["Extra (redundant) class"]
USING_PLURAL_OR_LOWERCASE: MistakeType = _MTS["Using plural or lowercase"]
SOFTWARE_ENGINEERING_TERM: MistakeType = _MTS["Software engineering term"]
BAD_CLASS_NAME_SPELLING: MistakeType = _MTS["Bad class name spelling"]
SIMILAR_CLASS_NAME: MistakeType = _MTS["Similar (yet incorrect) class name"]
REGULAR_CLASS_SHOULD_BE_AN_ENUMERATION_OR_VICE_VERSA: MistakeType = \
    _MTS["Regular class should be an enumeration or vice versa"]
WRONG_ENUMERATION_ITEMS: MistakeType = _MTS["Wrong enumeration items"]
MISSING_ATTRIBUTE: MistakeType = _MTS["Missing attribute"]
PLURAL_ATTRIBUTE_OR_ATTRIBUTE_LIST: MistakeType = _MTS["Plural attribute or attribute list"]
OTHER_EXTRA_ATTRIBUTE: MistakeType = _MTS["Other extra attribute"]
BAD_ATTRIBUTE_NAME_SPELLING: MistakeType = _MTS["Bad attribute name spelling"]
SIMILAR_ATTRIBUTE_NAME: MistakeType = _MTS["Similar (yet incorrect) attribute name"]
WRONG_ATTRIBUTE_TYPE: MistakeType = _MTS["Wrong attribute type"]
ATTRIBUTE_MISPLACED: MistakeType = _MTS["Attribute misplaced"]
ATTRIBUTE_DUPLICATED_: MistakeType = _MTS["Attribute duplicated (eg, in a subclass)"]
ATTRIBUTE_EXPECTED_TO_BE_STATIC_BUT_IS_NOT_OR_VICE_VERSA: MistakeType = \
    _MTS["Attribute expected to be static but is not or vice versa"]
USING_AN_ATTRIBUTE_INSTEAD_OF_AN_ASSOCIATION: MistakeType = _MTS["Using an attribute instead of an association"]
MISSING_COMPOSITION: MistakeType = _MTS["Missing composition"]
MISSING_AGGREGATION: MistakeType = _MTS["Missing aggregation"]
MISSING_ASSOCIATION: MistakeType = _MTS["Missing association"]
INCOMPLETE_CONTAINMENT_TREE: MistakeType = _MTS["Incomplete containment tree"]
REPRESENTING_AN_ACTION_WITH_AN_ASSOCIATION: MistakeType = _MTS["Representing an action with an association"]
COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT: MistakeType = _MTS["Composed part contained in more than one parent"]
OTHER_EXTRA_ASSOCIATION: MistakeType = _MTS["Other extra association"]
USING_AN_ASSOCIATION_INSTEAD_OF_AN_AGGREGATION_COMPOSITION_OR_VICE_VERSA: MistakeType = \
    _MTS["Using an association instead of an aggregation/composition or vice versa"]
USING_A_DIRECTED_ASSOCIATION_INSTEAD_OF_AN_UNDIRECTED_ONE_OR_VICE_VERSA: MistakeType = \
    _MTS["Using a directed association instead of an undirected one or vice versa"]
USING_AGGREGATION_INSTEAD_OF_COMPOSITION_OR_VICE_VERSA: MistakeType = \
    _MTS["Using aggregation instead of composition or vice versa"]
MISSING_ASSOCIATION_NAME_WHEN_ONE_WAS_EXPECTED: MistakeType = _MTS["Missing association name when one was expected"]
BAD_ASSOCIATION_NAME_SPELLING: MistakeType = _MTS["Bad association name spelling"]
SIMILAR_ASSOCIATION_NAME: MistakeType = _MTS["Similar (yet incorrect) association name"]
