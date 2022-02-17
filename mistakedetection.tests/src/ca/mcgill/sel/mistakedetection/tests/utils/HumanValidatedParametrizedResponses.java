package ca.mcgill.sel.mistakedetection.tests.utils;

import static java.util.Map.entry;
// Always keep this comment here to allow easy auto-importing of new mistake types in IDEs
//import static learningcorpus.mistaketypes.MistakeTypes.*;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_CLASS_SHOULD_BE_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_DUPLICATED;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_MISPLACED;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ASSOC_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ENUM_ITEM_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ENUM_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ROLE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ENUM_ITEM;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_GENERALIZATION;
import static learningcorpus.mistaketypes.MistakeTypes.GENERALIZATION_SHOULD_BE_ASSOC_AO_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.INFINITE_RECURSIVE_DEPENDENCY;
import static learningcorpus.mistaketypes.MistakeTypes.LOWERCASE_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_AO_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ENUM_ITEM;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_GENERALIZATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ROLE_NAMES;
import static learningcorpus.mistaketypes.MistakeTypes.NON_DIFFERENTIATED_SUBCLASS;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.REPRESENTING_ACTION_WITH_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.SOFTWARE_ENGINEERING_TERM;
import static learningcorpus.mistaketypes.MistakeTypes.UPPERCASE_ATTRIBUTE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ASSOC_INSTEAD_OF_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ASSOC_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ATTRIBUTE_INSTEAD_OF_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_GENERALIZATION_DIRECTION;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_SUPERCLASS;
import java.util.Map;
import java.util.Set;
import learningcorpus.MistakeType;

public class HumanValidatedParametrizedResponses {

  public static final Map<MistakeType, Set<String>> mappings = Map.ofEntries(
      // paste entries from MDIS4LC here
      // done
      entry(ASSOC_CLASS_SHOULD_BE_CLASS, Set.of("The ${inst_cls} class should be a regular class.")),
      entry(ATTRIBUTE_DUPLICATED, Set.of("The ${stud_attr} already exists in another class, so there is no need to include it again.")),
      entry(ATTRIBUTE_MISPLACED, Set.of("The ${stud_attr} belongs in the ${inst_attr.cls} class.",
          "The ${stud_attr} does not belong in the ${stud_attr.cls} class. Where else can we place it?")),
      entry(ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY, Set.of("The ${stud_attr} belongs in ${inst_attr.cls}.")),
      entry(ATTRIBUTE_SHOULD_BE_STATIC, Set.of("${stud_attr} should be static, because it applies to all instances of ${stud_attr.cls}.")),
      entry(ATTRIBUTE_SHOULD_NOT_BE_STATIC, Set.of("${stud_attr} should not be static, because it does not apply to all instances of ${stud_attr.cls}.")),
      entry(BAD_ASSOC_CLASS_NAME_SPELLING, Set.of("The ${stud_cls} class has a misspelled name.",
          "The ${stud_cls} class should be changed to ${inst_cls}.")),
      entry(BAD_ATTRIBUTE_NAME_SPELLING, Set.of("${stud_attr} is misspelled.[ Use the same spelling as the problem description.]")),
      entry(BAD_CLASS_NAME_SPELLING, Set.of("The ${stud_cls} class has a misspelled name.",
          "The ${stud_cls} class should be changed to ${inst_cls}.")),
      entry(BAD_ENUM_ITEM_SPELLING, Set.of("The ${stud_enumitem} should be changed[ to ${inst_enumitem}].")),
      entry(BAD_ENUM_NAME_SPELLING, Set.of("The ${stud_enum} should be changed[ to ${inst_enum}].")),
      entry(BAD_ROLE_NAME_SPELLING, Set.of("${stud_assocend} is misspelled.[ Use the same spelling as the problem description.]")),
      entry(CLASS_SHOULD_BE_ASSOC_CLASS, Set.of("The ${stud_cls} class should be an association class.")),
      entry(CLASS_SHOULD_BE_ENUM, Set.of("The ${stud_cls} can only be one of ${inst_enum.literals.length} options, so what is the best way to model this?")),
      entry(ENUM_SHOULD_BE_CLASS, Set.of("Is ${stud_enum} limited to a fixed set of options? Can this be modeled differently?")),
      entry(EXTRA_AGGREGATION, Set.of("The relationship between ${stud_aggr.end0} and ${stud_aggr.end1} is redundant.")),
      entry(EXTRA_ASSOCIATION, Set.of("The relationship between ${stud_assoc.end0} and ${stud_assoc.end1} is not expressed in the problem description.")),
      entry(EXTRA_ATTRIBUTE, Set.of("The ${stud_attr} in the ${stud_attr.cls} class is not needed.")),
      entry(EXTRA_CLASS, Set.of("The ${stud_cls} class is not part of the problem domain, so please remove it.")),
      entry(EXTRA_COMPOSITION, Set.of("The relationship between ${stud_compos.end0} and ${stud_compos.end1} is not expressed in the problem description.")),
      entry(EXTRA_ENUM, Set.of("Remove the ${stud_enum} enumeration. It is not needed.")),
      entry(EXTRA_ENUM_ITEM, Set.of("${stud_enumitem} does not belong in the ${stud_enumitem.enum} enumeration.")),
      entry(EXTRA_GENERALIZATION, Set.of("When creating a generalization between ${stud_sub_cls} and ${stud_super_cls}, make sure to follow the [checks for proper generalization](https://mycourses2.mcgill.ca/).")),
      entry(GENERALIZATION_SHOULD_BE_ASSOC_AO_PATTERN, Set.of("The generalization between ${stud_sub_cls} and ${stud_super_cls} should be modeled using the Abstraction-Occurrence pattern[, where ${inst_abs_cls} is the abstraction and ${inst_occ_cls} is the occurrence].")),
      entry(INFINITE_RECURSIVE_DEPENDENCY, Set.of("Does every ${stud_other_assocend.cls} have exactly ${stud_other_assocend.lowerBound} ${stud_other_assocend}?")),
      entry(LOWERCASE_CLASS_NAME, Set.of("${stud_cls} should be ${inst_cls}, with a capital letter.")),
      entry(MISSING_AO_PATTERN, Set.of("The concepts of ${inst_abs_cls} and ${inst_occ_cls} and the relationship between them should be modeled with the Abstraction-Occurrence pattern.")),
      entry(MISSING_ASSOCIATION, Set.of("How would you capture the relationship between ${inst_assoc.end0} and ${inst_assoc.end0}?")),
      entry(MISSING_ATTRIBUTE, Set.of("A ${inst_attr.cls} has a ${inst_attr}.")),
      entry(MISSING_CLASS, Set.of("Remember to add the ${inst_cls} class.")),
      entry(MISSING_ENUM, Set.of("Add an ${inst_enum} enumeration.")),
      entry(MISSING_ENUM_ITEM, Set.of("The ${inst_enumitem.enum} enumeration is missing an item.")),
      entry(MISSING_GENERALIZATION, Set.of("A ${inst_sub_cls} is a ${inst_super_cls}. How should we model this?")),
      entry(MISSING_ROLE_NAMES, Set.of("The multiplicities for the ${stud_assocend} association are correct, but something else is missing!")),
      entry(NON_DIFFERENTIATED_SUBCLASS, Set.of("${stud_cls} needs to be different from its superclass, and any sibling subclasses, in terms of behavior or structure.")),
      entry(PLURAL_ATTRIBUTE, Set.of("The ${stud_attr.cls}.${stud_attr} attribute should be singular.")),
      entry(PLURAL_CLASS_NAME, Set.of("${stud_cls} should be ${inst_cls}, using the singular.")),
      entry(REPRESENTING_ACTION_WITH_ASSOC, Set.of("The ${stud_assocend} role name represents an action, which is not correct.[ Use ${inst_assocend} instead.]")),
      entry(ROLE_SHOULD_BE_STATIC, Set.of("${stud_assocend} should be static, because it applies to all instances of the association between ${inst_assocend.opposite.cls} and ${inst_assocend.cls}.")),
      entry(ROLE_SHOULD_NOT_BE_STATIC, Set.of("${stud_assocend} should not be static, because it doesn't apply to all instances of the association between ${inst_assocend.opposite.cls} and ${inst_assocend.cls}.")),
      entry(SOFTWARE_ENGINEERING_TERM, Set.of("${stud_cls} contains a software engineering term, which does not belong in a domain model.")),
      entry(UPPERCASE_ATTRIBUTE_NAME, Set.of("${stud_attr.cls}.${stud_attr} incorrectly starts with an uppercase letter. Attributes should start with a lowercase letter.")),
      entry(USING_AGGREGATION_INSTEAD_OF_COMPOSITION, Set.of("The relationship between ${stud_assocend.opposite.cls} and ${stud_assocend.cls} is stronger than an aggregation.")),
      entry(USING_ASSOC_INSTEAD_OF_AGGREGATION, Set.of("The relationship between ${stud_assocend.opposite.cls} and ${stud_assocend.cls} can be modeled more precisely than with a simple association.")),
      entry(USING_ASSOC_INSTEAD_OF_COMPOSITION, Set.of("The relationship between ${stud_assocend.opposite.cls} and ${stud_assocend.cls} is more than a simple association.")),
      entry(USING_ATTRIBUTE_INSTEAD_OF_ASSOC, Set.of("${stud_attr} should be its own class.")),
      entry(USING_COMPOSITION_INSTEAD_OF_AGGREGATION, Set.of("The composition between ${stud_assocend.opposite.cls} and ${stud_assocend.cls} is better modeled using aggregation.")),
      entry(USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED, Set.of("The relationship between ${stud_assocend.opposite.cls} and ${stud_assocend.cls} should be undirected.")),
      entry(WRONG_ATTRIBUTE_TYPE, Set.of("Can you think of a better type for ${stud_attr}?",
          "The ${stud_attr.cls}.${stud_attr} should be of type ${inst_attr.type}.")),
      entry(WRONG_CLASS_NAME, Set.of("The ${stud_cls} class should be changed to ${inst_cls}.",
          "The ${stud_cls} class has a name that is not quite right but the attributes and/or associations are correct.")),
      entry(WRONG_GENERALIZATION_DIRECTION, Set.of("Is ${inst_super_cls} really a ${inst_sub_cls}?[ It should be the other way around.]")),
      entry(WRONG_MULTIPLICITY, Set.of("How many ${stud_assocend.cls}'s does a ${stud_assocend.opposite.cls} have?")),
      entry(WRONG_ROLE_NAME, Set.of("The ${stud_assocend} role name is not correct.",
          "The ${stud_assocend} role name should be changed to ${inst_assocend}.")),
      entry(WRONG_SUPERCLASS, Set.of("${stud_sub_cls} has an incorrect superclass.",
          "The superclass for ${stud_sub_cls} should be ${inst_super_cls}."))
  );
}
