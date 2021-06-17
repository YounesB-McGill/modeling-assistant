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
      "../modelingassistant.learningcorpus.dsl.instances/test.learningcorpus";

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

  /** The wrong class mistake type category. */
  public static final MistakeTypeCategory WRONG_CLASS = MTCS.get("Wrong class");

  /** The wrong class name mistake type category. */
  public static final MistakeTypeCategory WRONG_CLASS_NAME = MTCS.get("Wrong class name");

  /** The wrong enumeration mistake type category. */
  public static final MistakeTypeCategory WRONG_ENUMERATION = MTCS.get("Wrong enumeration");

  /** The wrong attribute mistake type category. */
  public static final MistakeTypeCategory WRONG_ATTRIBUTE = MTCS.get("Wrong attribute");

  /** The extra (redundant) attribute mistake type category. */
  public static final MistakeTypeCategory EXTRA_ATTRIBUTE = MTCS.get("Extra (redundant) attribute");

  /** The wrong attribute name mistake type category. */
  public static final MistakeTypeCategory WRONG_ATTRIBUTE_NAME = MTCS.get("Wrong attribute name");

  /** The attribute in wrong class mistake type category. */
  public static final MistakeTypeCategory ATTRIBUTE_IN_WRONG_CLASS = MTCS.get("Attribute in wrong class");

  /** The wrong relationship mistake type category. */
  public static final MistakeTypeCategory WRONG_RELATIONSHIP = MTCS.get("Wrong relationship");

  /** The missing relationship mistake type category. */
  public static final MistakeTypeCategory MISSING_RELATIONSHIP = MTCS.get("Missing relationship");

  /** The extra (redundant) association mistake type category. */
  public static final MistakeTypeCategory EXTRA_ASSOCIATION = MTCS.get("Extra (redundant) association");

  /** The using wrong relationship type mistake type category. */
  public static final MistakeTypeCategory USING_WRONG_RELATIONSHIP_TYPE = MTCS.get("Using wrong relationship type");

  /** The wrong association name mistake type category. */
  public static final MistakeTypeCategory WRONG_ASSOCIATION_NAME = MTCS.get("Wrong association name");

  /** The wrong multiplicities mistake type category. */
  public static final MistakeTypeCategory WRONG_MULTIPLICITIES = MTCS.get("Wrong multiplicities");

  /** The wrong role names mistake type category. */
  public static final MistakeTypeCategory WRONG_ROLE_NAMES = MTCS.get("Wrong role names");

  /** The wrong association class mistake type category. */
  public static final MistakeTypeCategory WRONG_ASSOCIATION_CLASS = MTCS.get("Wrong association class");

  /** The wrong generalization mistake type category. */
  public static final MistakeTypeCategory WRONG_GENERALIZATION = MTCS.get("Wrong generalization");

  /** The misuse of design patterns mistake type category. */
  public static final MistakeTypeCategory MISUSE_OF_DESIGN_PATTERNS = MTCS.get("Misuse of design patterns");

  /** The misuse of player-role pattern mistake type category. */
  public static final MistakeTypeCategory MISUSE_OF_PLAYER_ROLE_PATTERN = MTCS.get("Misuse of Player-Role Pattern");

  /** The misuse of abstraction-occurrence mistake type category. */
  public static final MistakeTypeCategory MISUSE_OF_ABSTRACTION_OCCURRENCE =
      MTCS.get("Misuse of Abstraction-Occurrence");


  // Mistake types

  /** The missing class mistake type. */
  public static final MistakeType MISSING_CLASS = MTS.get("Missing class");

  /** The extra (redundant) class mistake type. */
  public static final MistakeType EXTRA_CLASS = MTS.get("Extra (redundant) class");

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

  /** The regular class should be enum mistake type. */
  public static final MistakeType REGULAR_CLASS_SHOULD_BE_ENUM = MTS.get("Regular class should be enum");

  /** The enum should be regular class mistake type. */
  public static final MistakeType ENUM_SHOULD_BE_REGULAR_CLASS = MTS.get("Enum should be regular class");

  /** The wrong enum items mistake type. */
  public static final MistakeType WRONG_ENUM_ITEMS = MTS.get("Wrong enum items");

  /** The missing attribute mistake type. */
  public static final MistakeType MISSING_ATTRIBUTE = MTS.get("Missing attribute");

  /** The wrong attribute type mistake type. */
  public static final MistakeType WRONG_ATTRIBUTE_TYPE = MTS.get("Wrong attribute type");

  /** The attribute should be static mistake type. */
  public static final MistakeType ATTRIBUTE_SHOULD_BE_STATIC = MTS.get("Attribute should be static");

  /** The attribute should not be static mistake type. */
  public static final MistakeType ATTRIBUTE_SHOULD_NOT_BE_STATIC = MTS.get("Attribute should not be static");

  /** The plural attribute mistake type. */
  public static final MistakeType PLURAL_ATTRIBUTE = MTS.get("Plural attribute");

  /** The list attribute mistake type. */
  public static final MistakeType LIST_ATTRIBUTE = MTS.get("List attribute");

  /** The other extra attribute mistake type. */
  public static final MistakeType OTHER_EXTRA_ATTRIBUTE = MTS.get("Other extra attribute");

  /** The bad attribute name spelling mistake type. */
  public static final MistakeType BAD_ATTRIBUTE_NAME_SPELLING = MTS.get("Bad attribute name spelling");

  /** The similar (yet incorrect) attribute name mistake type. */
  public static final MistakeType SIMILAR_ATTRIBUTE_NAME = MTS.get("Similar (yet incorrect) attribute name");

  /** The incomplete containment tree mistake type. */
  public static final MistakeType INCOMPLETE_CONTAINMENT_TREE = MTS.get("Incomplete containment tree");

  /** The missing association mistake type. */
  public static final MistakeType MISSING_ASSOCIATION = MTS.get("Missing association");

  /** The missing composition mistake type. */
  public static final MistakeType MISSING_COMPOSITION = MTS.get("Missing composition");

  /** The missing aggregation mistake type. */
  public static final MistakeType MISSING_AGGREGATION = MTS.get("Missing aggregation");

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

  /** The using association instead of aggregation/composition mistake type. */
  public static final MistakeType USING_ASSOCIATION_INSTEAD_OF_AGGREGATION_COMPOSITION =
      MTS.get("Using association instead of aggregation/composition");

  /** The using aggregation/composition instead of association mistake type. */
  public static final MistakeType USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION =
      MTS.get("Using aggregation/composition instead of association");

  /** The using directed association instead of undirected mistake type. */
  public static final MistakeType USING_DIRECTED_ASSOCIATION_INSTEAD_OF_UNDIRECTED =
      MTS.get("Using directed association instead of undirected");

  /** The using undirected association instead of directed mistake type. */
  public static final MistakeType USING_UNDIRECTED_ASSOCIATION_INSTEAD_OF_DIRECTED =
      MTS.get("Using undirected association instead of directed");

  /** The using aggregation instead of composition mistake type. */
  public static final MistakeType USING_AGGREGATION_INSTEAD_OF_COMPOSITION =
      MTS.get("Using aggregation instead of composition");

  /** The using composition instead of aggregation mistake type. */
  public static final MistakeType USING_COMPOSITION_INSTEAD_OF_AGGREGATION =
      MTS.get("Using composition instead of aggregation");

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

  /** The similar (yet incorrect) association class name mistake type. */
  public static final MistakeType SIMILAR_ASSOCIATION_CLASS_NAME =
      MTS.get("Similar (yet incorrect) association class name");

  /** The missing generalization mistake type. */
  public static final MistakeType MISSING_GENERALIZATION = MTS.get("Missing generalization");

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

}
