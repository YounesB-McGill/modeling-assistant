package ca.mcgill.sel.mistakedetection.tests.utils;

import static java.util.Map.entry;
// Always keep this comment here to allow easy auto-importing of new mistake types in IDEs
//import static learningcorpus.mistaketypes.MistakeTypes.*;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_CLASS_SHOULD_BE_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_SHOULD_BE_ENUM_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_SHOULD_BE_FULL_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_SHOULD_BE_SUBCLASS_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_DUPLICATED;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_MISPLACED;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ASSOCIATION_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ASSOC_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ENUM_ITEM_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ENUM_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ROLE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ABSTRACT;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_NOT_BE_ABSTRACT;
import static learningcorpus.mistaketypes.MistakeTypes.COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_ASSOC_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_FULL_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_SUBCLASS_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ENUM_ITEM;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_GENERALIZATION;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_N_ARY_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.FULL_PR_PATTERN_SHOULD_BE_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.FULL_PR_PATTERN_SHOULD_BE_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.FULL_PR_PATTERN_SHOULD_BE_SUBCLASS;
import static learningcorpus.mistaketypes.MistakeTypes.GENERALIZATION_INAPPLICABLE;
import static learningcorpus.mistaketypes.MistakeTypes.GENERALIZATION_SHOULD_BE_ASSOC_AO_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.INCOMPLETE_AO_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.INCOMPLETE_CONTAINMENT_TREE;
import static learningcorpus.mistaketypes.MistakeTypes.INCOMPLETE_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.INFINITE_RECURSIVE_DEPENDENCY;
import static learningcorpus.mistaketypes.MistakeTypes.INHERITED_FEATURE_DOES_NOT_MAKE_SENSE_FOR_SUBCLASS;
import static learningcorpus.mistaketypes.MistakeTypes.LIST_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.LOWERCASE_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_AO_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION_IN_AO_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE_TYPE;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ENUM_ITEM;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_GENERALIZATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_N_ARY_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.NON_DIFFERENTIATED_SUBCLASS;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.REPRESENTING_ACTION_WITH_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.REVERSED_GENERALIZATION_DIRECTION;
import static learningcorpus.mistaketypes.MistakeTypes.REVERSED_RELATIONSHIP_DIRECTION;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.SOFTWARE_ENGINEERING_TERM;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_NOT_DISTINCT_ACROSS_LIFETIME;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_ASSOC_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_ENUM_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_FULL_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.UPPERCASE_ATTRIBUTE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_INSTEAD_OF_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ASSOC_INSTEAD_OF_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ASSOC_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ATTRIBUTE_INSTEAD_OF_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_BINARY_ASSOC_INSTEAD_OF_N_ARY_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED;
import static learningcorpus.mistaketypes.MistakeTypes.USING_INTERMEDIATE_CLASS_INSTEAD_OF_N_ARY_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_N_ARY_ASSOC_INSTEAD_OF_BINARY_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_N_ARY_ASSOC_INSTEAD_OF_INTERMEDIATE_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_SUPERCLASS;
import java.util.Map;
import java.util.Set;
import learningcorpus.MistakeType;

public class HumanValidatedParametrizedResponses {

  public static final Map<MistakeType, Set<String>> mappings = Map.ofEntries(
      // paste entries from MDIS4LC here
      // Validation for all parametrized responses in progress
      entry(ASSOC_CLASS_SHOULD_BE_CLASS, Set.of("The ${stud_cls} class should be a regular class.")),
      entry(ASSOC_SHOULD_BE_ENUM_PR_PATTERN, Set.of("Will the roles ${stud_role_assocend*} ever be played by an instance of ${stud_player_cls} at the same time?")),
      entry(ASSOC_SHOULD_BE_FULL_PR_PATTERN, Set.of("The roles ${stud_role_assocend*} have different features that need to be modeled.")),
      entry(ASSOC_SHOULD_BE_SUBCLASS_PR_PATTERN, Set.of("The roles ${stud_role_assocend*} have different features that need to be modeled, but an instance of ${stud_player_cls} does not change its role over its lifetime.")),
      entry(ATTRIBUTE_DUPLICATED, Set.of("The ${stud_attr} already exists in the same class or another class in the generalization hierarchy, so there is no need to include it again.")),
      entry(ATTRIBUTE_MISPLACED, Set.of("The ${stud_attr} attribute does not belong in the ${stud_attr.cls} class. Where else can we place it?",
          "The ${stud_attr} attribute belongs in the ${inst_attr.cls} class.")),
      entry(ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY, Set.of("The ${stud_attr} belongs in the ${inst_attr.cls} class, i.e., a different class in the inheritance hierarchy.")),
      entry(ATTRIBUTE_SHOULD_BE_STATIC, Set.of("${stud_attr} should be static, because its value is the same for all instances of ${stud_attr.cls}.")),
      entry(ATTRIBUTE_SHOULD_NOT_BE_STATIC, Set.of("${stud_attr} should not be static, because its value may be different for instances of ${stud_attr.cls}.")),
      entry(BAD_ASSOC_CLASS_NAME_SPELLING, Set.of("The ${stud_cls} class has a misspelled name.",
          "The ${stud_cls} class should be changed to ${inst_cls}.")),
      entry(BAD_ASSOCIATION_NAME_SPELLING, Set.of("${stud_assoc} is misspelled.[ Use the same spelling as the problem description.]")),
      entry(BAD_ATTRIBUTE_NAME_SPELLING, Set.of("The ${stud_attr.cls}.${stud_attr} attribute is misspelled.[ Use the same spelling as the problem description.]")),
      entry(BAD_CLASS_NAME_SPELLING, Set.of("The ${stud_cls} class has a misspelled name.",
          "The ${stud_cls} class should be changed to ${inst_cls}.")),
      entry(BAD_ENUM_ITEM_SPELLING, Set.of("${stud_enumitem} in the ${stud_enumitem.enum} should be changed to ${inst_enumitem}.")),
      entry(BAD_ENUM_NAME_SPELLING, Set.of("The ${stud_enum} should be changed to ${inst_enum}.")),
      entry(BAD_ROLE_NAME_SPELLING, Set.of("${stud_assocend} is misspelled.[ Use the same spelling as the problem description.]")),
      entry(CLASS_SHOULD_BE_ABSTRACT, Set.of("${stud_cls} should be abstract.")),
      entry(CLASS_SHOULD_BE_ASSOC_CLASS, Set.of("The ${stud_cls} class should be an association class.")),
      entry(CLASS_SHOULD_BE_ENUM, Set.of("The ${stud_cls} can only be one of ${inst_enum.literals.length} options, so what is the best way to model this?")),
      entry(CLASS_SHOULD_NOT_BE_ABSTRACT, Set.of("${stud_cls} should not be abstract.")),
      entry(COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT, Set.of("${stud_cls*} cannot be contained in more than one class.")),
      entry(ENUM_SHOULD_BE_ASSOC_PR_PATTERN, Set.of("Will the roles of ${stud_role_enumitem*} ever be occupied at the same time?")),
      entry(ENUM_SHOULD_BE_CLASS, Set.of("Is ${stud_enum} limited to a fixed set of options? Can this be modeled differently?")),
      entry(ENUM_SHOULD_BE_FULL_PR_PATTERN, Set.of("A ${stud_role_enumitem0} can also play the role of one of the other roles at the same time and different features need to be captured for the roles.")),
      entry(ENUM_SHOULD_BE_SUBCLASS_PR_PATTERN, Set.of("A ${stud_role_enumitem0} has different features from one of the other roles and this role never changes to another role.")),
      entry(EXTRA_AGGREGATION, Set.of("There should not be an aggregation between ${stud_aggr.end0.cls} and ${stud_aggr.end1.cls}.")),
      entry(EXTRA_ASSOC_CLASS, Set.of("Does it make sense to disallow multiple instances of ${stud_cls} with the same pair of ${stud_assoc.end0.cls} and ${stud_assoc.end1.cls} instances?",
          "Further details of the association between ${stud_assoc.end0.cls} and ${stud_assoc.end1.cls} should not be modeled with an association class.")),
      entry(EXTRA_ASSOCIATION, Set.of("There should not be an association between ${stud_assoc.end0.cls} and ${stud_assoc.end1.cls}.")),
      entry(EXTRA_ATTRIBUTE, Set.of("The ${stud_attr} in the ${stud_attr.cls} class is not needed.")),
      entry(EXTRA_CLASS, Set.of("The ${stud_cls} class is not part of the problem domain, so please remove it.")),
      entry(EXTRA_COMPOSITION, Set.of("The relationship between ${stud_compos.end0.cls} and ${stud_compos.end1.cls} is not expressed in the problem description.")),
      entry(EXTRA_ENUM, Set.of("Remove the ${stud_enum} enumeration. It is not needed.")),
      entry(EXTRA_ENUM_ITEM, Set.of("${stud_enumitem} does not belong in the ${stud_enumitem.enum} enumeration.")),
      entry(EXTRA_GENERALIZATION, Set.of("When creating a generalization between ${stud_sub_cls} and ${stud_super_cls}, make sure to follow the [checks for proper generalization](https://mycourses2.mcgill.ca/).")),
      entry(EXTRA_N_ARY_ASSOCIATION, Set.of("The relationship between the ${stud_assoc.cls*} classes is redundant.")),
      entry(FULL_PR_PATTERN_SHOULD_BE_ASSOC, Set.of("Do the roles ${stud_role_cls*} need to have different features?")),
      entry(FULL_PR_PATTERN_SHOULD_BE_ENUM, Set.of("Do the roles ${stud_role_cls*} need to have different features and is it possible that more than one role is played by an instance of ${stud_player_cls} at the same time?")),
      entry(FULL_PR_PATTERN_SHOULD_BE_SUBCLASS, Set.of("an instance of ${stud_player_cls} play more than one role out of ${stud_role_cls*} at different times or at the same time?")),
      entry(GENERALIZATION_INAPPLICABLE, Set.of("When creating a generalization between ${stud_sub_cls} and ${stud_super_cls}, make sure to follow the [checks for proper generalization](https://mycourses2.mcgill.ca/).")),
      entry(GENERALIZATION_SHOULD_BE_ASSOC_AO_PATTERN, Set.of("The relationship between ${stud_sub_cls} and ${stud_super_cls} should be modeled using the Abstraction-Occurrence pattern[, where ${inst_abs_cls} is the abstraction and ${inst_occ_cls} is the occurrence].")),
      entry(INCOMPLETE_AO_PATTERN, Set.of("The ${stud_existing_cls} should be part of an Abstraction-Occurrence relationship.",
          "The concepts of ${inst_abs_cls} and ${inst_occ_cls} and the relationship between them should be modeled with the Abstraction-Occurrence pattern.")),
      entry(INCOMPLETE_PR_PATTERN, Set.of("The concepts of ${inst_player_cls} and its roles ${inst_role*} and the relationship between them should be modeled with one of the forms of the Player-Role pattern.")),
      entry(INCOMPLETE_CONTAINMENT_TREE, Set.of("${stud_cls*} should be contained in the containment tree.[ Use composition for this.]")),
      entry(INFINITE_RECURSIVE_DEPENDENCY, Set.of("Is it a good idea to specify that every ${stud_assocend0.cls} has a minimum of ${stud_assocend0.lowerBound} ${stud_assocend0}?")),
      entry(INHERITED_FEATURE_DOES_NOT_MAKE_SENSE_FOR_SUBCLASS, Set.of("A feature of the ${stud_super_cls} class does not make sense for its ${stud_sub_cls} subclass.")),
      entry(LIST_ATTRIBUTE, Set.of("${stud_attr} should be modeled as an association instead.")),
      entry(LOWERCASE_CLASS_NAME, Set.of("${stud_cls} should be ${inst_cls}, with a capital letter.")),
      entry(MISSING_AO_PATTERN, Set.of("The concepts of ${inst_abs_cls} and ${inst_occ_cls} and the relationship between them should be modeled with the Abstraction-Occurrence pattern.")),
      entry(MISSING_PR_PATTERN, Set.of("The concepts of ${inst_player_cls} and its roles ${inst_role*} and the relationship between them should be modeled with one of the forms of the Player-Role pattern.")),
      entry(MISSING_AGGREGATION, Set.of("How would you capture that a ${inst_whole_assocend.refcls} has a ${inst_part_assocend.refcls}?",
          "Use aggregation to model the relationship between ${inst_part_assocend.cls} and ${inst_whole_assocend.cls}.")),
      entry(MISSING_ASSOC_CLASS, Set.of("Further details of the association between ${inst_assoc.end0.cls} and ${inst_assoc.end1.cls} should be modeled with an association class.")),
      entry(MISSING_ASSOCIATION, Set.of("How would you capture the relationship between ${inst_assoc.end0.cls} and ${inst_assoc.end1.cls}?")),
      entry(MISSING_ASSOCIATION_IN_AO_PATTERN, Set.of("The ${stud_abs_cls} and ${stud_occ_cls} should be in an Abstraction-Occurrence relationship.",
          "The relationship between ${stud_abs_cls} and ${stud_occ_cls} should be modeled with an association as part of the Abstraction-Occurrence pattern.")),
      entry(MISSING_ASSOCIATION_NAME, Set.of("This association should be named ${inst_assoc}.")),
      entry(MISSING_ATTRIBUTE, Set.of("A ${inst_attr.cls} has a ${inst_attr}.")),
      entry(MISSING_ATTRIBUTE_TYPE, Set.of("The ${stud_attr.cls}.${stud_attr} attribute is missing something.",
          "The type of the ${stud_attr.cls}.${stud_attr} attribute should be ${inst_attr.type}.")),
      entry(MISSING_CLASS, Set.of("Remember to add the ${inst_cls} class.")),
      entry(MISSING_COMPOSITION, Set.of("How would you capture that a ${inst_whole_assocend.refcls} has a ${inst_part_assocend.refcls}?",
          "Use composition to show that the ${inst_part_assocend.refcls} class is contained in the ${inst_whole_assocend.refcls} class.")),
      entry(MISSING_ENUM, Set.of("Add a ${inst_enum} enumeration.")),
      entry(MISSING_ENUM_ITEM, Set.of("The ${stud_enum} enumeration is missing an item.",
          "Add ${inst_enumitem} to the ${stud_enum} enumeration.")),
      entry(MISSING_GENERALIZATION, Set.of("A ${inst_sub_cls} is a ${inst_super_cls}. How should we model this?")),
      entry(MISSING_MULTIPLICITY, Set.of("How many ${stud_assocend.opposite.cls} instances does a ${stud_assocend.cls} have?")),
      entry(MISSING_N_ARY_ASSOCIATION, Set.of("How would you capture the relationship between ${inst_assoc.cls*}?")),
      entry(MISSING_ROLE_NAME, Set.of("The relationship between ${stud_assocend.cls} and ${stud_assocend.opposite.cls} is missing a role name.")),
      entry(NON_DIFFERENTIATED_SUBCLASS, Set.of("${stud_cls} needs to be different from its superclass, and all sibling subclasses, in terms of behavior or structure.")),
      entry(PLURAL_ATTRIBUTE, Set.of("The ${stud_attr.cls}.${stud_attr} attribute should be singular.")),
      entry(PLURAL_CLASS_NAME, Set.of("${stud_cls} should be ${inst_cls}, using the singular.")),
      entry(REPRESENTING_ACTION_WITH_ASSOC, Set.of("The ${stud_assocend} role name represents an action, which is not correct.[ Use ${inst_assocend} instead.]")),
      entry(REVERSED_GENERALIZATION_DIRECTION, Set.of("Is ${inst_super_cls} really a ${inst_sub_cls}?[ It should be the other way around.]")),
      entry(REVERSED_RELATIONSHIP_DIRECTION, Set.of("The direction of the relationship between ${stud_part_or_source_assocend.cls} and ${stud_whole_or_target_assocend.cls} should be reversed.")),
      entry(ROLE_SHOULD_BE_STATIC, Set.of("${stud_assocend} should be static, because its value is the same for all instances of the relationship between ${stud_assocend.opposite.cls} and ${stud_assocend.cls}.")),
      entry(ROLE_SHOULD_NOT_BE_STATIC, Set.of("${stud_assocend} should not be static, because its value may be different for the instances of the relationship between ${stud_assocend.opposite.cls} and ${stud_assocend.cls}.")),
      entry(SOFTWARE_ENGINEERING_TERM, Set.of("${stud_cls} contains a software engineering term (e.g., data, database, table), which does not belong in a domain model.")),
      entry(SUBCLASS_NOT_DISTINCT_ACROSS_LIFETIME, Set.of("Is it possible for an instance of ${stud_sub_cls} to turn into an instance of another subclass of ${stud_super_cls} over its lifetime?")),
      entry(SUBCLASS_SHOULD_BE_ASSOC_PR_PATTERN, Set.of("An instance of ${stud_player_cls} can play more than one role out of ${inst_role_assocend*} and different features do not need to be captured for the roles.")),
      entry(SUBCLASS_SHOULD_BE_ENUM_PR_PATTERN, Set.of("An instance of ${stud_player_cls} does not need to play more than one role out of ${stud_role_cls*} at the same time and different features do not need to be captured for the roles.")),
      entry(SUBCLASS_SHOULD_BE_FULL_PR_PATTERN, Set.of("An instance of ${stud_player_cls} can play more than one role out of ${stud_role_cls*}.")),
      entry(UPPERCASE_ATTRIBUTE_NAME, Set.of("The ${stud_attr.cls}.${stud_attr} attribute incorrectly starts with an uppercase letter. Attributes should start with a lowercase letter.")),
      entry(USING_AGGREGATION_INSTEAD_OF_ASSOC, Set.of("The relationship between ${stud_part_assocend.cls} and ${stud_whole_assocend.cls} can be modeled with a simple association.")),
      entry(USING_AGGREGATION_INSTEAD_OF_COMPOSITION, Set.of("The relationship between ${stud_part_assocend.cls} and ${stud_whole_assocend.cls} is stronger than an aggregation.",
          "The relationship between ${stud_part_assocend.cls} and ${stud_whole_assocend.cls} should be modeled with a composition.")),
      entry(USING_ASSOC_INSTEAD_OF_AGGREGATION, Set.of("The relationship between ${stud_assocend.cls} and ${stud_other_assocend.cls} can be modeled more precisely than with a simple association.",
          "The relationship between ${stud_assocend.cls} and ${stud_other_assocend.cls} should be modeled with an aggregation.")),
      entry(USING_ASSOC_INSTEAD_OF_COMPOSITION, Set.of("The relationship between ${stud_assocend.cls} and ${stud_other_assocend.cls} is more than a simple association.",
          "The relationship between ${stud_assocend.cls} and ${stud_other_assocend.cls} should be modeled with a composition.")),
      entry(USING_ATTRIBUTE_INSTEAD_OF_ASSOC, Set.of("${stud_attr} should be its own class.")),
      entry(USING_BINARY_ASSOC_INSTEAD_OF_N_ARY_ASSOC, Set.of("Use an n-ary association to represent the relationship between the ${inst_assoc.cls*} classes.")),
      entry(USING_COMPOSITION_INSTEAD_OF_AGGREGATION, Set.of("The composition between ${stud_part_assocend.cls} and ${stud_whole_assocend.cls} is better modeled using aggregation.")),
      entry(USING_COMPOSITION_INSTEAD_OF_ASSOC, Set.of("Why is ${stud_part_assocend.refcls} contained in ${stud_whole_assocend.refcls}?",
          "The relationship between ${stud_part_assocend.cls} and ${stud_whole_assocend.cls} should be modeled with a simple association.")),
      entry(USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED, Set.of("The relationship between ${stud_source_assocend.cls} and ${stud_target_assocend.cls} should be undirected.")),
      entry(USING_INTERMEDIATE_CLASS_INSTEAD_OF_N_ARY_ASSOC, Set.of("Use an n-ary association to represent the relationship between the ${inst_assoc.cls*} classes.")),
      entry(USING_N_ARY_ASSOC_INSTEAD_OF_BINARY_ASSOC, Set.of("Use a binary association to represent the relationship between the ${inst_assoc.cls*} classes.")),
      entry(USING_N_ARY_ASSOC_INSTEAD_OF_INTERMEDIATE_CLASS, Set.of("Use an intermediate ${inst_cls} class instead of an n-ary association.")),
      entry(USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED, Set.of("Does ${inst_target_assocend.refcls} need to know about ${inst_source_assocend.refcls}?",
          "The relationship between ${inst_source_assocend.refcls} and ${inst_target_assocend.refcls} should be directed[ from ${inst_source_assocend.refcls} to ${inst_target_assocend.refcls}].")),
      entry(WRONG_ATTRIBUTE_TYPE, Set.of("Can you think of a better type for ${stud_attr}?",
          "The ${stud_attr.cls}.${stud_attr} attribute should be of type ${inst_attr.type}.")),
      entry(WRONG_CLASS_NAME, Set.of("The ${stud_cls} class has a name that is not quite right but the attributes and/or associations are correct.",
          "The ${stud_cls} class should be changed to ${inst_cls}.")),
      entry(WRONG_MULTIPLICITY, Set.of("How many ${stud_assocend.opposite.cls} instances does a ${stud_assocend.cls} have?")),
      entry(WRONG_ROLE_NAME, Set.of("The ${stud_assocend} role name is not correct.",
          "The ${stud_assocend} role name should be changed to ${inst_assocend}.")),
      entry(WRONG_SUPERCLASS, Set.of("${stud_sub_cls} has an incorrect superclass.",
          "The superclass for ${stud_sub_cls} should be ${inst_super_cls}."))
  );

}
