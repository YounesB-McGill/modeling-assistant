package learningcorpus.mistaketypes;

import java.util.HashMap;
import java.util.Map;
import learningcorpus.LearningCorpus;
import learningcorpus.MistakeType;
import learningcorpus.MistakeTypeCategory;

/**
 * This class contains all mistake types and categories.
 */
public class MistakeTypes {

  /** The path of the learning corpus instance with mistake types. */
  public static final String LEARNING_CORPUS_PATH =
      "../modelingassistant/learningcorpusinstances/default.learningcorpus";

  /** Map of mistake type categories by name. */
  public static final Map<String, MistakeTypeCategory> MISTAKE_TYPE_CATEGORIES_BY_NAME = new HashMap<>();

  /** Map of mistake types by name. */
  public static final Map<String, MistakeType> MISTAKE_TYPES_BY_NAME = new HashMap<>();

  // Short-name references to the above maps for greater code legibility
  private static final Map<String, MistakeTypeCategory> MTCS = MISTAKE_TYPE_CATEGORIES_BY_NAME;
  private static final Map<String, MistakeType> MTS = MISTAKE_TYPES_BY_NAME;

  static {
    var learningCorpus = LearningCorpus.fromFile(LEARNING_CORPUS_PATH);
    learningCorpus.getMistakeTypeCategories().forEach(mtc -> MISTAKE_TYPE_CATEGORIES_BY_NAME.put(mtc.getName(), mtc));
    learningCorpus.getMistakeTypes().forEach(mt -> MISTAKE_TYPES_BY_NAME.put(mt.getName(), mt));
  }

  // Mistake type categories

  /** The category for class mistakes. */
  public static final MistakeTypeCategory CLASS_MISTAKES = MTCS.get("Class mistakes");

  /** The category for attribute mistakes. */
  public static final MistakeTypeCategory ATTRIBUTE_MISTAKES = MTCS.get("Attribute mistakes");

  /** The category for relationship mistakes. */
  public static final MistakeTypeCategory RELATIONSHIP_MISTAKES = MTCS.get("Relationship mistakes");

  /** The category for design pattern mistakes. */
  public static final MistakeTypeCategory DESIGN_PATTERN_MISTAKES = MTCS.get("Design pattern mistakes");

  /** The category for class name mistakes. */
  public static final MistakeTypeCategory CLASS_NAME_MISTAKES = MTCS.get("Class name mistakes");

  /** The category for enumeration mistakes. */
  public static final MistakeTypeCategory ENUMERATION_MISTAKES = MTCS.get("Enumeration mistakes");

  /** The category for extra attribute mistakes. */
  public static final MistakeTypeCategory EXTRA_ATTRIBUTE_MISTAKES = MTCS.get("Extra attribute mistakes");

  /** The category for attribute name mistakes. */
  public static final MistakeTypeCategory ATTRIBUTE_NAME_MISTAKES = MTCS.get("Attribute name mistakes");

  /** The category for attribute in wrong class mistakes. */
  public static final MistakeTypeCategory ATTRIBUTE_IN_WRONG_CLASS_MISTAKES =
      MTCS.get("Attribute in wrong class mistakes");

  /** The category for missing association mistakes. */
  public static final MistakeTypeCategory MISSING_ASSOCIATION_MISTAKES = MTCS.get("Missing association mistakes");

  /** The category for extra association mistakes. */
  public static final MistakeTypeCategory EXTRA_ASSOCIATION_MISTAKES = MTCS.get("Extra association mistakes");

  /** The category for association type mistakes. */
  public static final MistakeTypeCategory ASSOCIATION_TYPE_MISTAKES = MTCS.get("Association type mistakes");

  /** The category for association name mistakes. */
  public static final MistakeTypeCategory ASSOCIATION_NAME_MISTAKES = MTCS.get("Association name mistakes");

  /** The category for multiplicity mistakes. */
  public static final MistakeTypeCategory MULTIPLICITY_MISTAKES = MTCS.get("Multiplicity mistakes");

  /** The category for role name mistakes. */
  public static final MistakeTypeCategory ROLE_NAME_MISTAKES = MTCS.get("Role name mistakes");

  /** The category for association class mistakes. */
  public static final MistakeTypeCategory ASSOCIATION_CLASS_MISTAKES = MTCS.get("Association class mistakes");

  /** The category for association mistakes. */
  public static final MistakeTypeCategory ASSOCIATION_MISTAKES = MTCS.get("Association mistakes");

  /** The category for composition mistakes. */
  public static final MistakeTypeCategory COMPOSITION_MISTAKES = MTCS.get("Composition mistakes");

  /** The category for generalization mistakes. */
  public static final MistakeTypeCategory GENERALIZATION_MISTAKES = MTCS.get("Generalization mistakes");

  /** The category for using different player-role pattern. */
  public static final MistakeTypeCategory USING_DIFFERENT_PLAYER_ROLE_PATTERN =
      MTCS.get("Using different Player-Role pattern");

  /** The category for player-role pattern mistakes. */
  public static final MistakeTypeCategory PLAYER_ROLE_PATTERN_MISTAKES = MTCS.get("Player-Role Pattern mistakes");

  /** The category for abstraction-occurrence pattern mistakes. */
  public static final MistakeTypeCategory ABSTRACTION_OCCURRENCE_PATTERN_MISTAKES =
      MTCS.get("Abstraction-Occurrence pattern mistakes");


  // Mistake types

  /** The missing class mistake type. */
  public static final MistakeType MISSING_CLASS = MTS.get("Missing class");

  /** The extra class mistake type. */
  public static final MistakeType EXTRA_CLASS = MTS.get("Extra class");

  /** The using n-ary association instead of intermediate class mistake type. */
  public static final MistakeType USING_N_ARY_ASSOC_INSTEAD_OF_INTERMEDIATE_CLASS =
      MTS.get("Using n-ary assoc instead of intermediate class");

  /** The missing attribute mistake type. */
  public static final MistakeType MISSING_ATTRIBUTE = MTS.get("Missing attribute");

  /** The wrong attribute type mistake type. */
  public static final MistakeType WRONG_ATTRIBUTE_TYPE = MTS.get("Wrong attribute type");

  /** The missing attribute type mistake type. */
  public static final MistakeType MISSING_ATTRIBUTE_TYPE = MTS.get("Missing attribute type");

  /** The attribute should be static mistake type. */
  public static final MistakeType ATTRIBUTE_SHOULD_BE_STATIC = MTS.get("Attribute should be static");

  /** The attribute should not be static mistake type. */
  public static final MistakeType ATTRIBUTE_SHOULD_NOT_BE_STATIC = MTS.get("Attribute should not be static");

  /** The plural class name mistake type. */
  public static final MistakeType PLURAL_CLASS_NAME = MTS.get("Plural class name");

  /** The lowercase class name mistake type. */
  public static final MistakeType LOWERCASE_CLASS_NAME = MTS.get("Lowercase class name");

  /** The software engineering term mistake type. */
  public static final MistakeType SOFTWARE_ENGINEERING_TERM = MTS.get("Software engineering term");

  /** The bad class name spelling mistake type. */
  public static final MistakeType BAD_CLASS_NAME_SPELLING = MTS.get("Bad class name spelling");

  /** The wrong class name mistake type. */
  public static final MistakeType WRONG_CLASS_NAME = MTS.get("Wrong class name");

  /** The regular class should be enumeration mistake type. */
  public static final MistakeType CLASS_SHOULD_BE_ENUM = MTS.get("Class should be enum");

  /** The enumeration should be regular class mistake type. */
  public static final MistakeType ENUM_SHOULD_BE_CLASS = MTS.get("Enum should be class");

  /** The missing enumeration mistake type. */
  public static final MistakeType MISSING_ENUM = MTS.get("Missing enum");

  /** The extra enumeration mistake type. */
  public static final MistakeType EXTRA_ENUM = MTS.get("Extra enum");

  /** The bad enumeration name spelling mistake type. */
  public static final MistakeType BAD_ENUM_NAME_SPELLING = MTS.get("Bad enum name spelling");

  /** The missing enumeration item mistake type. */
  public static final MistakeType MISSING_ENUM_ITEM = MTS.get("Missing enum item");

  /** The extra enumeration item mistake type. */
  public static final MistakeType EXTRA_ENUM_ITEM = MTS.get("Extra enum item");

  /** The bad enumeration item spelling mistake type. */
  public static final MistakeType BAD_ENUM_ITEM_SPELLING = MTS.get("Bad enum item spelling");

  /** The plural attribute mistake type. */
  public static final MistakeType PLURAL_ATTRIBUTE = MTS.get("Plural attribute");

  /** The list attribute mistake type. */
  public static final MistakeType LIST_ATTRIBUTE = MTS.get("List attribute");

  /** The extra attribute mistake type. */
  public static final MistakeType EXTRA_ATTRIBUTE = MTS.get("Extra attribute");

  /** The bad attribute name spelling mistake type. */
  public static final MistakeType BAD_ATTRIBUTE_NAME_SPELLING = MTS.get("Bad attribute name spelling");

  /** The uppercase attribute name mistake type. */
  public static final MistakeType UPPERCASE_ATTRIBUTE_NAME = MTS.get("Uppercase attribute name");

  /** The attribute misplaced mistake type. */
  public static final MistakeType ATTRIBUTE_MISPLACED = MTS.get("Attribute misplaced");

  /** The attribute duplicated mistake type. */
  public static final MistakeType ATTRIBUTE_DUPLICATED = MTS.get("Attribute duplicated");

  /** The attribute misplaced in generalization hierarchy mistake type. */
  public static final MistakeType ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY =
      MTS.get("Attribute misplaced in generalization hierarchy");

  /** The missing association mistake type. */
  public static final MistakeType MISSING_ASSOCIATION = MTS.get("Missing association");

  /** The missing aggregation mistake type. */
  public static final MistakeType MISSING_AGGREGATION = MTS.get("Missing aggregation");

  /** The missing n-ary association mistake type. */
  public static final MistakeType MISSING_N_ARY_ASSOCIATION = MTS.get("Missing n-ary association");

  /** The using attribute instead of association mistake type. */
  public static final MistakeType USING_ATTRIBUTE_INSTEAD_OF_ASSOC = MTS.get("Using attribute instead of assoc");

  /** The representing an action with an association mistake type. */
  public static final MistakeType REPRESENTING_ACTION_WITH_ASSOC = MTS.get("Representing action with assoc");

  /** The extra association mistake type. */
  public static final MistakeType EXTRA_ASSOCIATION = MTS.get("Extra association");

  /** The extra aggregation mistake type. */
  public static final MistakeType EXTRA_AGGREGATION = MTS.get("Extra aggregation");

  /** The extra n-ary association mistake type. */
  public static final MistakeType EXTRA_N_ARY_ASSOCIATION = MTS.get("Extra n-ary association");

  /** The using aggregation instead of association mistake type. */
  public static final MistakeType USING_AGGREGATION_INSTEAD_OF_ASSOC = MTS.get("Using aggregation instead of assoc");

  /** The using composition instead of association mistake type. */
  public static final MistakeType USING_COMPOSITION_INSTEAD_OF_ASSOC = MTS.get("Using composition instead of assoc");

  /** The using directed relationship instead of undirected relationship mistake type. */
  public static final MistakeType USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED =
      MTS.get("Using directed relationship instead of undirected");

  /** The using undirected relationship instead of directed relationship mistake type. */
  public static final MistakeType USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED =
      MTS.get("Using undirected relationship instead of directed");

  /** The using composition instead of aggregation mistake type. */
  public static final MistakeType USING_COMPOSITION_INSTEAD_OF_AGGREGATION =
      MTS.get("Using composition instead of aggregation");

  /** The using binary association instead of n-ary association mistake type. */
  public static final MistakeType USING_BINARY_ASSOC_INSTEAD_OF_N_ARY_ASSOC =
      MTS.get("Using binary assoc instead of n-ary assoc");

  /** The using n-ary association instead of binary association mistake type. */
  public static final MistakeType USING_N_ARY_ASSOC_INSTEAD_OF_BINARY_ASSOC =
      MTS.get("Using n-ary assoc instead of binary assoc");

  /** The using intermediate class instead of n-ary association mistake type. */
  public static final MistakeType USING_INTERMEDIATE_CLASS_INSTEAD_OF_N_ARY_ASSOC =
      MTS.get("Using intermediate class instead of n-ary assoc");

  /** The missing association name mistake type. */
  public static final MistakeType MISSING_ASSOCIATION_NAME = MTS.get("Missing association name");

  /** The bad association name spelling mistake type. */
  public static final MistakeType BAD_ASSOCIATION_NAME_SPELLING = MTS.get("Bad association name spelling");

  /** The infinite recursive dependency mistake type. */
  public static final MistakeType INFINITE_RECURSIVE_DEPENDENCY = MTS.get("Infinite recursive dependency");

  /** The wrong multiplicity mistake type. */
  public static final MistakeType WRONG_MULTIPLICITY = MTS.get("Wrong multiplicity");

  /** The missing multiplicity mistake type. */
  public static final MistakeType MISSING_MULTIPLICITY = MTS.get("Missing multiplicity");

  /** The missing role names mistake type. */
  public static final MistakeType MISSING_ROLE_NAMES = MTS.get("Missing role names");

  /** The role should be static mistake type. */
  public static final MistakeType ROLE_SHOULD_BE_STATIC = MTS.get("Role should be static");

  /** The role should not be static mistake type. */
  public static final MistakeType ROLE_SHOULD_NOT_BE_STATIC = MTS.get("Role should not be static");

  /** The bad role name spelling mistake type. */
  public static final MistakeType BAD_ROLE_NAME_SPELLING = MTS.get("Bad role name spelling");

  /** The wrong role name but correct association mistake type. */
  public static final MistakeType WRONG_ROLE_NAME = MTS.get("Wrong role name");

  /** The missing association class mistake type. */
  public static final MistakeType MISSING_ASSOC_CLASS = MTS.get("Missing assoc class");

  /** The extra association class mistake type. */
  public static final MistakeType EXTRA_ASSOC_CLASS = MTS.get("Extra assoc class");

  /** The bad association class name spelling mistake type. */
  public static final MistakeType BAD_ASSOC_CLASS_NAME_SPELLING = MTS.get("Bad assoc class name spelling");

  /** The association class should be regular class mistake type. */
  public static final MistakeType ASSOC_CLASS_SHOULD_BE_CLASS = MTS.get("Assoc class should be class");

  /** The regular class should be association class mistake type. */
  public static final MistakeType CLASS_SHOULD_BE_ASSOC_CLASS = MTS.get("Class should be assoc class");

  /** The missing composition mistake type. */
  public static final MistakeType MISSING_COMPOSITION = MTS.get("Missing composition");

  /** The extra composition mistake type. */
  public static final MistakeType EXTRA_COMPOSITION = MTS.get("Extra composition");

  /** The using association instead of aggregation mistake type. */
  public static final MistakeType USING_ASSOC_INSTEAD_OF_AGGREGATION = MTS.get("Using assoc instead of aggregation");

  /** The using association instead of composition mistake type. */
  public static final MistakeType USING_ASSOC_INSTEAD_OF_COMPOSITION = MTS.get("Using assoc instead of composition");

  /** The using aggregation instead of composition mistake type. */
  public static final MistakeType USING_AGGREGATION_INSTEAD_OF_COMPOSITION =
      MTS.get("Using aggregation instead of composition");

  /** The composed part contained in more than one parent mistake type. */
  public static final MistakeType COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT =
      MTS.get("Composed part contained in more than one parent");

  /** The incomplete containment tree mistake type. */
  public static final MistakeType INCOMPLETE_CONTAINMENT_TREE = MTS.get("Incomplete containment tree");

  /** The missing generalization mistake type. */
  public static final MistakeType MISSING_GENERALIZATION = MTS.get("Missing generalization");

  /** The extra generalization mistake type. */
  public static final MistakeType EXTRA_GENERALIZATION = MTS.get("Extra generalization");

  /** The generalization does not follow isA rule mistake type. */
  public static final MistakeType GENERALIZATION_INAPPLICABLE = MTS.get("Generalization inapplicable");

  /** The subclass not distinct across lifetime mistake type. */
  public static final MistakeType SUBCLASS_NOT_DISTINCT_ACROSS_LIFETIME =
      MTS.get("Subclass not distinct across lifetime");

  /** The inherited feature does not make sense for subclass mistake type. */
  public static final MistakeType INHERITED_FEATURE_DOES_NOT_MAKE_SENSE_FOR_SUBCLASS =
      MTS.get("Inherited feature does not make sense for subclass");

  /** The subclass is an instance of superclass mistake type. */
  public static final MistakeType SUBCLASS_IS_AN_INSTANCE_OF_SUPERCLASS =
      MTS.get("Subclass is an instance of superclass");

  /** The non-differentiated subclass mistake type. */
  public static final MistakeType NON_DIFFERENTIATED_SUBCLASS = MTS.get("Non-differentiated subclass");

  /** The wrong generalization direction mistake type. */
  public static final MistakeType WRONG_GENERALIZATION_DIRECTION = MTS.get("Wrong generalization direction");

  /** The wrong superclass mistake type. */
  public static final MistakeType WRONG_SUPERCLASS = MTS.get("Wrong superclass");

  /** The subclass should be full player-role pattern mistake type. */
  public static final MistakeType SUBCLASS_SHOULD_BE_FULL_PR_PATTERN = MTS.get("Subclass should be full PR pattern");

  /** The subclass should be association player-role pattern mistake type. */
  public static final MistakeType SUBCLASS_SHOULD_BE_ASSOC_PR_PATTERN = MTS.get("Subclass should be assoc PR pattern");

  /** The subclass should be enumeration player-role pattern mistake type. */
  public static final MistakeType SUBCLASS_SHOULD_BE_ENUM_PR_PATTERN = MTS.get("Subclass should be enum PR pattern");

  /** The association should be full player-role pattern mistake type. */
  public static final MistakeType ASSOC_SHOULD_BE_FULL_PR_PATTERN = MTS.get("Assoc should be full PR pattern");

  /** The association should be subclass player-role pattern mistake type. */
  public static final MistakeType ASSOC_SHOULD_BE_SUBCLASS_PR_PATTERN = MTS.get("Assoc should be subclass PR pattern");

  /** The association should be enumeration player-role pattern mistake type. */
  public static final MistakeType ASSOC_SHOULD_BE_ENUM_PR_PATTERN = MTS.get("Assoc should be enum PR pattern");

  /** The enumeration should be full player-role pattern mistake type. */
  public static final MistakeType ENUM_SHOULD_BE_FULL_PR_PATTERN = MTS.get("Enum should be full PR pattern");

  /** The enumeration should be subclass player-role pattern mistake type. */
  public static final MistakeType ENUM_SHOULD_BE_SUBCLASS_PR_PATTERN = MTS.get("Enum should be subclass PR pattern");

  /** The enumeration should be association player-role pattern mistake type. */
  public static final MistakeType ENUM_SHOULD_BE_ASSOC_PR_PATTERN = MTS.get("Enum should be assoc PR pattern");

  /** The full player-role pattern should be subclass mistake type. */
  public static final MistakeType FULL_PR_PATTERN_SHOULD_BE_SUBCLASS = MTS.get("Full PR pattern should be subclass");

  /** The full player-role pattern should be association mistake type. */
  public static final MistakeType FULL_PR_PATTERN_SHOULD_BE_ASSOC = MTS.get("Full PR pattern should be assoc");

  /** The full player-role pattern should be enumeration mistake type. */
  public static final MistakeType FULL_PR_PATTERN_SHOULD_BE_ENUM = MTS.get("Full PR pattern should be enum");

  /** The missing player-role pattern mistake type. */
  public static final MistakeType MISSING_PR_PATTERN = MTS.get("Missing PR pattern");

  /** The incomplete player-role pattern mistake type. */
  public static final MistakeType INCOMPLETE_PR_PATTERN = MTS.get("Incomplete PR pattern");

  /** The missing abstraction-occurrence pattern mistake type. */
  public static final MistakeType MISSING_AO_PATTERN = MTS.get("Missing AO pattern");

  /** The incomplete abstraction-occurrence pattern mistake type. */
  public static final MistakeType INCOMPLETE_AO_PATTERN = MTS.get("Incomplete AO pattern");

  /** The generalization should be association in abstraction-occurrence pattern mistake type. */
  public static final MistakeType GENERALIZATION_SHOULD_BE_ASSOC_AO_PATTERN =
      MTS.get("Generalization should be assoc AO pattern");

}
