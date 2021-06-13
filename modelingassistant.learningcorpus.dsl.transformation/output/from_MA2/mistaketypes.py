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
for mtc in modeling_assistant.mistaketypecategory: MISTAKE_TYPE_CATEGORIES_BY_NAME[mtc.name] = mtc
for mt in modeling_assistant.mistakeTypes: MISTAKE_TYPES_BY_NAME[mt.name] = mt

# Mistake type categories
WRONG_RELATIONSHIPS: MistakeTypeCategory = _MTCS["Wrong relationships"]
WRONG_MULTIPLICITIES: MistakeTypeCategory = _MTCS["Wrong multiplicities"]
WRONG_ROLE_NAMES: MistakeTypeCategory = _MTCS["Wrong role names"]

# Mistake types
OTHER_WRONG_MULTIPLICITY: MistakeType = _MTS["Other wrong multiplicity"]
INFINITE_RECURSIVE_DEPENDENCY: MistakeType = _MTS["Infinite recursive dependency"]
MISSING_ROLE_NAMES: MistakeType = _MTS["Missing role names"]
ROLE_NAMES_PRESENT_BUT_INCORRECT: MistakeType = _MTS["Role names present but incorrect"]
ROLE_EXPECTED_TO_BE_STATIC_BUT_IS_NOT_OR_VICE_VERSA: MistakeType = \
    _MTS["Role expected to be static but is not or vice versa"]
BAD_ROLE_NAME_SPELLING: MistakeType = _MTS["Bad role name spelling"]
SIMILAR_ROLE_NAME: MistakeType = _MTS["Similar (yet incorrect) role name"]
