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
      "../modelingassistant.learningcorpus.dsl.instances/default.learningcorpus";

  /** Map of mistake type categories by name. */
  public static final Map<String, MistakeTypeCategory> MISTAKE_TYPE_CATEGORIES_BY_NAME =
      new HashMap<String, MistakeTypeCategory>();

  /** Map of mistake types by name. */
  public static final Map<String, MistakeType> MISTAKE_TYPES_BY_NAME = new HashMap<String, MistakeType>();

  // Short-name references to the above maps for greater code legibility
  private static final Map<String, MistakeTypeCategory> MTCS = MISTAKE_TYPE_CATEGORIES_BY_NAME;
  private static final Map<String, MistakeType> MTS = MISTAKE_TYPES_BY_NAME;

  static {
    var learningCorpus = LearningCorpus.fromFile(LEARNING_CORPUS_PATH);

    learningCorpus.getMistakeTypeCategories().forEach(mtc ->
        MISTAKE_TYPE_CATEGORIES_BY_NAME.put(mtc.getName(), mtc));

    learningCorpus.getMistakeTypes().forEach(mt ->
        MISTAKE_TYPES_BY_NAME.put(mt.getName(), mt));
  }


  // Mistake type categories

  /** The category for class mistakes. */
  public static final MistakeTypeCategory CLASS_MISTAKES = MTCS.get("Class mistakes");

  /** The category for attribute mistakes. */
  public static final MistakeTypeCategory ATTRIBUTE_MISTAKES = MTCS.get("Attribute mistakes");

  /** The category for relationship mistakes. */
  public static final MistakeTypeCategory RELATIONSHIP_MISTAKES = MTCS.get("Relationship mistakes");

  /** The category for missing relationship. */
  public static final MistakeTypeCategory MISSING_RELATIONSHIP = MTCS.get("Missing relationship");

  /** The category for using wrong relationship type. */
  public static final MistakeTypeCategory USING_WRONG_RELATIONSHIP_TYPE = MTCS.get("Using wrong relationship type");

  /** The category for wrong association name. */
  public static final MistakeTypeCategory WRONG_ASSOCIATION_NAME = MTCS.get("Wrong association name");

  /** The category for wrong multiplicities. */
  public static final MistakeTypeCategory WRONG_MULTIPLICITIES = MTCS.get("Wrong multiplicities");

  /** The category for wrong role names. */
  public static final MistakeTypeCategory WRONG_ROLE_NAMES = MTCS.get("Wrong role names");

  /** The category for wrong association class. */
  public static final MistakeTypeCategory WRONG_ASSOCIATION_CLASS = MTCS.get("Wrong association class");

  /** The category for wrong generalization. */
  public static final MistakeTypeCategory WRONG_GENERALIZATION = MTCS.get("Wrong generalization");

  /** The category for misuse of design patterns. */
  public static final MistakeTypeCategory MISUSE_OF_DESIGN_PATTERNS = MTCS.get("Misuse of design patterns");

  /** The category for wrong player-role pattern. */
  public static final MistakeTypeCategory WRONG_PLAYER_ROLE_PATTERN = MTCS.get("Wrong Player-Role Pattern");

  /** The category for using different player-role pattern. */
  public static final MistakeTypeCategory USING_DIFFERENT_PLAYER_ROLE_PATTERN =
      MTCS.get("Using different Player-Role pattern");

  /** The category for wrong abstraction-occurrence pattern. */
  public static final MistakeTypeCategory WRONG_ABSTRACTION_OCCURRENCE_PATTERN =
      MTCS.get("Wrong Abstraction-Occurrence pattern");

  /** The category for class name mistakes. */
  public static final MistakeTypeCategory CLASS_NAME_MISTAKES = MTCS.get("Class name mistakes");

  /** The category for enumeration mistakes. */
  public static final MistakeTypeCategory ENUMERATION_MISTAKES = MTCS.get("Enumeration mistakes");

  /** The category for extra (redundant) attribute mistakes. */
  public static final MistakeTypeCategory EXTRA_ATTRIBUTE_MISTAKES = MTCS.get("Extra (redundant) attribute mistakes");

  /** The category for wrong attribute name mistakes. */
  public static final MistakeTypeCategory WRONG_ATTRIBUTE_NAME_MISTAKES = MTCS.get("Wrong attribute name mistakes");

  /** The category for attribute in wrong class mistakes. */
  public static final MistakeTypeCategory ATTRIBUTE_IN_WRONG_CLASS_MISTAKES =
      MTCS.get("Attribute in wrong class mistakes");

  /** The category for missing association mistakes. */
  public static final MistakeTypeCategory MISSING_ASSOCIATION_MISTAKES = MTCS.get("Missing association mistakes");

  /** The category for extra (redundant) association mistakes. */
  public static final MistakeTypeCategory EXTRA_ASSOCIATION_MISTAKES =
      MTCS.get("Extra (redundant) association mistakes");

  /** The category for wrong association type mistakes. */
  public static final MistakeTypeCategory WRONG_ASSOCIATION_TYPE_MISTAKES = MTCS.get("Wrong association type mistakes");

  /** The category for association mistakes. */
  public static final MistakeTypeCategory ASSOCIATION_MISTAKES = MTCS.get("Association mistakes");


  // Mistake types

  /** The missing class mistake type. */
  public static final MistakeType MISSING_CLASS = MTS.get("Missing class");

  /** The extra (redundant) class mistake type. */
  public static final MistakeType EXTRA_CLASS = MTS.get("Extra (redundant) class");

  /** The using n-ary assoc instead of intermediate class mistake type. */
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

  /** The incomplete containment tree mistake type. */
  public static final MistakeType INCOMPLETE_CONTAINMENT_TREE = MTS.get("Incomplete containment tree");

  /** The missing composition mistake type. */
  public static final MistakeType MISSING_COMPOSITION = MTS.get("Missing composition");

  /** The using association instead of aggregation/composition mistake type. */
  public static final MistakeType USING_ASSOCIATION_INSTEAD_OF_AGGREGATION_COMPOSITION =
      MTS.get("Using association instead of aggregation/composition");

  /** The using aggregation instead of composition mistake type. */
  public static final MistakeType USING_AGGREGATION_INSTEAD_OF_COMPOSITION =
      MTS.get("Using aggregation instead of composition");

  /** The missing association name when one was expected mistake type. */
  public static final MistakeType MISSING_ASSOCIATION_NAME_WHEN_ONE_WAS_EXPECTED =
      MTS.get("Missing association name when one was expected");

  /** The bad association name spelling mistake type. */
  public static final MistakeType BAD_ASSOCIATION_NAME_SPELLING = MTS.get("Bad association name spelling");

  /** The similar (yet incorrect) association name mistake type. */
  public static final MistakeType SIMILAR_ASSOCIATION_NAME = MTS.get("Similar (yet incorrect) association name");

  /** The infinite recursive dependency mistake type. */
  public static final MistakeType INFINITE_RECURSIVE_DEPENDENCY = MTS.get("Infinite recursive dependency");

  /** The other wrong multiplicity mistake type. */
  public static final MistakeType OTHER_WRONG_MULTIPLICITY = MTS.get("Other wrong multiplicity");

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

  /** The similar (yet incorrect) role name mistake type. */
  public static final MistakeType SIMILAR_ROLE_NAME = MTS.get("Similar (yet incorrect) role name");

  /** The other wrong role name mistake type. */
  public static final MistakeType OTHER_WRONG_ROLE_NAME = MTS.get("Other wrong role name");

  /** The missing association class mistake type. */
  public static final MistakeType MISSING_ASSOCIATION_CLASS = MTS.get("Missing association class");

  /** The extra (redundant) association class mistake type. */
  public static final MistakeType EXTRA_ASSOCIATION_CLASS = MTS.get("Extra (redundant) association class");

  /** The bad association class name spelling mistake type. */
  public static final MistakeType BAD_ASSOCIATION_CLASS_NAME_SPELLING = MTS.get("Bad association class name spelling");

  /** The association class should be regular class mistake type. */
  public static final MistakeType ASSOCIATION_CLASS_SHOULD_BE_REGULAR_CLASS =
      MTS.get("Association class should be regular class");

  /** The regular class should be association class mistake type. */
  public static final MistakeType REGULAR_CLASS_SHOULD_BE_ASSOCIATION_CLASS =
      MTS.get("Regular class should be association class");

  /** The similar (yet incorrect) association class name mistake type. */
  public static final MistakeType SIMILAR_ASSOCIATION_CLASS_NAME =
      MTS.get("Similar (yet incorrect) association class name");

  /** The missing generalization mistake type. */
  public static final MistakeType MISSING_GENERALIZATION = MTS.get("Missing generalization");

  /** The extra generalization mistake type. */
  public static final MistakeType EXTRA_GENERALIZATION = MTS.get("Extra generalization");

  /** The generalization inapplicable mistake type. */
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

  /** The missing player-role pattern mistake type. */
  public static final MistakeType MISSING_PLAYER_ROLE_PATTERN = MTS.get("Missing Player-Role pattern");

  /** The incomplete player-role pattern mistake type. */
  public static final MistakeType INCOMPLETE_PLAYER_ROLE_PATTERN = MTS.get("Incomplete Player-Role pattern");

  /** The subclass should be full player-role pattern mistake type. */
  public static final MistakeType SUBCLASS_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN =
      MTS.get("Subclass should be full Player-Role pattern");

  /** The subclass should be association player-role pattern mistake type. */
  public static final MistakeType SUBCLASS_SHOULD_BE_ASSOCIATION_PLAYER_ROLE_PATTERN =
      MTS.get("Subclass should be association Player-Role pattern");

  /** The subclass should be enum player-role pattern mistake type. */
  public static final MistakeType SUBCLASS_SHOULD_BE_ENUM_PLAYER_ROLE_PATTERN =
      MTS.get("Subclass should be enum Player-Role pattern");

  /** The association should be full player-role pattern mistake type. */
  public static final MistakeType ASSOCIATION_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN =
      MTS.get("Association should be full Player-Role pattern");

  /** The association should be subclass player-role pattern mistake type. */
  public static final MistakeType ASSOCIATION_SHOULD_BE_SUBCLASS_PLAYER_ROLE_PATTERN =
      MTS.get("Association should be subclass Player-Role pattern");

  /** The association should be enum player-role pattern mistake type. */
  public static final MistakeType ASSOCIATION_SHOULD_BE_ENUM_PLAYER_ROLE_PATTERN =
      MTS.get("Association should be enum Player-Role pattern");

  /** The enum should be full player-role pattern mistake type. */
  public static final MistakeType ENUM_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN =
      MTS.get("Enum should be full Player-Role pattern");

  /** The enum should be subclass player-role pattern mistake type. */
  public static final MistakeType ENUM_SHOULD_BE_SUBCLASS_PLAYER_ROLE_PATTERN =
      MTS.get("Enum should be subclass Player-Role pattern");

  /** The enum should be association player-role pattern mistake type. */
  public static final MistakeType ENUM_SHOULD_BE_ASSOCIATION_PLAYER_ROLE_PATTERN =
      MTS.get("Enum should be association Player-Role pattern");

  /** The full player-role pattern should be subclass mistake type. */
  public static final MistakeType FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_SUBCLASS =
      MTS.get("Full Player-Role pattern should be subclass");

  /** The full player-role pattern should be association mistake type. */
  public static final MistakeType FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_ASSOCIATION =
      MTS.get("Full Player-Role pattern should be association");

  /** The full player-role pattern should be enum mistake type. */
  public static final MistakeType FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_ENUM =
      MTS.get("Full Player-Role pattern should be enum");

  /** The missing abstraction-occurrence pattern mistake type. */
  public static final MistakeType MISSING_ABSTRACTION_OCCURRENCE_PATTERN =
      MTS.get("Missing Abstraction-Occurrence pattern");

  /** The incomplete abstraction-occurrence pattern mistake type. */
  public static final MistakeType INCOMPLETE_ABSTRACTION_OCCURRENCE_PATTERN =
      MTS.get("Incomplete Abstraction-Occurrence pattern");

  /** The plural class name mistake type. */
  public static final MistakeType PLURAL_CLASS_NAME = MTS.get("Plural class name");

  /** The lowercase class name mistake type. */
  public static final MistakeType LOWERCASE_CLASS_NAME = MTS.get("Lowercase class name");

  /** The software engineering term mistake type. */
  public static final MistakeType SOFTWARE_ENGINEERING_TERM = MTS.get("Software engineering term");

  /** The bad class name spelling mistake type. */
  public static final MistakeType BAD_CLASS_NAME_SPELLING = MTS.get("Bad class name spelling");

  /** The similar (yet incorrect) class name mistake type. */
  public static final MistakeType SIMILAR_CLASS_NAME = MTS.get("Similar (yet incorrect) class name");

  /** The wrong class name mistake type. */
  public static final MistakeType WRONG_CLASS_NAME = MTS.get("Wrong class name");

  /** The class should be enum mistake type. */
  public static final MistakeType CLASS_SHOULD_BE_ENUM = MTS.get("Class should be enum");

  /** The enum should be class mistake type. */
  public static final MistakeType ENUM_SHOULD_BE_CLASS = MTS.get("Enum should be class");

  /** The missing enum mistake type. */
  public static final MistakeType MISSING_ENUM = MTS.get("Missing enum");

  /** The extra enum mistake type. */
  public static final MistakeType EXTRA_ENUM = MTS.get("Extra enum");

  /** The bad enum name spelling mistake type. */
  public static final MistakeType BAD_ENUM_NAME_SPELLING = MTS.get("Bad enum name spelling");

  /** The similar enum name mistake type. */
  public static final MistakeType SIMILAR_ENUM_NAME = MTS.get("Similar enum name");

  /** The missing enum item mistake type. */
  public static final MistakeType MISSING_ENUM_ITEM = MTS.get("Missing enum item");

  /** The extra enum item mistake type. */
  public static final MistakeType EXTRA_ENUM_ITEM = MTS.get("Extra enum item");

  /** The bad enum item spelling mistake type. */
  public static final MistakeType BAD_ENUM_ITEM_SPELLING = MTS.get("Bad enum item spelling");

  /** The similar enum item mistake type. */
  public static final MistakeType SIMILAR_ENUM_ITEM = MTS.get("Similar enum item");

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

  /** The similar (yet incorrect) attribute name mistake type. */
  public static final MistakeType SIMILAR_ATTRIBUTE_NAME = MTS.get("Similar (yet incorrect) attribute name");

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

  /** The using an attribute instead of an association mistake type. */
  public static final MistakeType USING_AN_ATTRIBUTE_INSTEAD_OF_AN_ASSOCIATION =
      MTS.get("Using an attribute instead of an association");

  /** The representing an action with an association mistake type. */
  public static final MistakeType REPRESENTING_AN_ACTION_WITH_AN_ASSOCIATION =
      MTS.get("Representing an action with an association");

  /** The composed part contained in more than one parent mistake type. */
  public static final MistakeType COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT =
      MTS.get("Composed part contained in more than one parent");

  /** The other extra association mistake type. */
  public static final MistakeType OTHER_EXTRA_ASSOCIATION = MTS.get("Other extra association");

  /** The extra composition mistake type. */
  public static final MistakeType EXTRA_COMPOSITION = MTS.get("Extra composition");

  /** The extra aggregation mistake type. */
  public static final MistakeType EXTRA_AGGREGATION = MTS.get("Extra aggregation");

  /** The extra n-ary association mistake type. */
  public static final MistakeType EXTRA_N_ARY_ASSOCIATION = MTS.get("Extra n-ary association");

  /** The using aggregation/composition instead of assoc mistake type. */
  public static final MistakeType USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOC =
      MTS.get("Using aggregation/composition instead of assoc");

  /** The using directed assoc instead of undirected mistake type. */
  public static final MistakeType USING_DIRECTED_ASSOC_INSTEAD_OF_UNDIRECTED =
      MTS.get("Using directed assoc instead of undirected");

  /** The using undirected assoc instead of directed mistake type. */
  public static final MistakeType USING_UNDIRECTED_ASSOC_INSTEAD_OF_DIRECTED =
      MTS.get("Using undirected assoc instead of directed");

  /** The using composition instead of aggregation mistake type. */
  public static final MistakeType USING_COMPOSITION_INSTEAD_OF_AGGREGATION =
      MTS.get("Using composition instead of aggregation");

  /** The using binary assoc instead of n-ary assoc mistake type. */
  public static final MistakeType USING_BINARY_ASSOC_INSTEAD_OF_N_ARY_ASSOC =
      MTS.get("Using binary assoc instead of n-ary assoc");

  /** The using n-ary assoc instead of binary assoc mistake type. */
  public static final MistakeType USING_N_ARY_ASSOC_INSTEAD_OF_BINARY_ASSOC =
      MTS.get("Using n-ary assoc instead of binary assoc");

  /** The using intermediate class instead of n-ary assoc mistake type. */
  public static final MistakeType USING_INTERMEDIATE_CLASS_INSTEAD_OF_N_ARY_ASSOC =
      MTS.get("Using intermediate class instead of n-ary assoc");

}
