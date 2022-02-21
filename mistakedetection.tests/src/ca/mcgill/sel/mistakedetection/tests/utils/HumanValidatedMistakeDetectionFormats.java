package ca.mcgill.sel.mistakedetection.tests.utils;

import static ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeDetectionFormat.mdf;
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
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ENUM;
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
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ROLE_NAMES;
import static learningcorpus.mistaketypes.MistakeTypes.NON_DIFFERENTIATED_SUBCLASS;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.REPRESENTING_ACTION_WITH_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.SOFTWARE_ENGINEERING_TERM;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_IS_AN_INSTANCE_OF_SUPERCLASS;
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
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_GENERALIZATION_DIRECTION;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_RELATIONSHIP_DIRECTION;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_SUPERCLASS;
import java.util.List;
import java.util.Map;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeDetectionFormat;
import learningcorpus.MistakeType;

public class HumanValidatedMistakeDetectionFormats {

  public static final Map<MistakeType, MistakeDetectionFormat> mappings = Map.ofEntries(
      // paste entries from MDIS4LC here (studentElemsDescriptions, instructorElemsDescriptions)
      // Completed entries (derived from MDS)
      entry(ASSOC_CLASS_SHOULD_BE_CLASS, mdf(List.of("assoc", "cls"), List.of("cls"))),
      entry(ATTRIBUTE_DUPLICATED, mdf(List.of("attr"), List.of())),
      entry(ATTRIBUTE_MISPLACED, mdf(List.of("attr"), List.of("attr"))),
      entry(ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY, mdf(List.of("attr"), List.of("attr"))),
      entry(ATTRIBUTE_SHOULD_BE_STATIC, mdf(List.of("attr"), List.of("attr"))),
      entry(ATTRIBUTE_SHOULD_NOT_BE_STATIC, mdf(List.of("attr"), List.of("attr"))),
      entry(BAD_ASSOC_CLASS_NAME_SPELLING, mdf(List.of("assoc", "cls"), List.of("assoc", "cls"))),
      entry(BAD_ATTRIBUTE_NAME_SPELLING, mdf(List.of("attr"), List.of("attr"))),
      entry(BAD_CLASS_NAME_SPELLING, mdf(List.of("cls"), List.of("cls"))),
      entry(BAD_ENUM_ITEM_SPELLING, mdf(List.of("enumitem"), List.of("enumitem"))),
      entry(BAD_ENUM_NAME_SPELLING, mdf(List.of("enum"), List.of("enum"))),
      entry(BAD_ROLE_NAME_SPELLING, mdf(List.of("assocend"), List.of("assocend"))),
      entry(CLASS_SHOULD_BE_ASSOC_CLASS, mdf(List.of("cls"), List.of("assoc", "cls"))),
      entry(CLASS_SHOULD_BE_ENUM, mdf(List.of("cls"), List.of("enum"))),
      entry(ENUM_SHOULD_BE_CLASS, mdf(List.of("enum"), List.of("cls"))),
      entry(EXTRA_AGGREGATION, mdf(List.of("aggr"), List.of())),
      entry(EXTRA_ASSOC_CLASS, mdf(List.of("assoc", "cls"), List.of())),
      entry(EXTRA_ASSOCIATION, mdf(List.of("assoc"), List.of())),
      entry(EXTRA_ATTRIBUTE, mdf(List.of("attr"), List.of())),
      entry(EXTRA_CLASS, mdf(List.of("cls"), List.of())),
      entry(EXTRA_COMPOSITION, mdf(List.of("compos"), List.of())),
      entry(EXTRA_ENUM, mdf(List.of("enum"), List.of())),
      entry(EXTRA_ENUM_ITEM, mdf(List.of("enumitem"), List.of())),
      entry(EXTRA_GENERALIZATION, mdf(List.of("sub_cls", "super_cls"), List.of("sub_cls", "super_cls"))),
      entry(GENERALIZATION_SHOULD_BE_ASSOC_AO_PATTERN, mdf(List.of("sub_cls", "super_cls"), List.of("abs_cls", "occ_cls"))),
      entry(INCOMPLETE_AO_PATTERN, mdf(List.of("abs_cls", "occ_cls"), List.of("abs_cls", "occ_cls"))),
      entry(INFINITE_RECURSIVE_DEPENDENCY, mdf(List.of("minlowerbound_assocend", "other_assocend"), List.of())),
      entry(LOWERCASE_CLASS_NAME, mdf(List.of("cls"), List.of("cls"))),
      entry(MISSING_AGGREGATION, mdf(List.of(), List.of("part_assocend", "whole_assocend"))), // TODO update MDS
      entry(MISSING_AO_PATTERN, mdf(List.of(), List.of("abs_cls", "occ_cls"))),
      entry(MISSING_ASSOC_CLASS, mdf(List.of(), List.of("assoc", "cls"))),
      entry(MISSING_ASSOCIATION, mdf(List.of(), List.of("assoc"))),
      entry(MISSING_ATTRIBUTE, mdf(List.of(), List.of("attr"))),
      entry(MISSING_CLASS, mdf(List.of(), List.of("cls"))),
      entry(MISSING_COMPOSITION, mdf(List.of(), List.of("part_assocend", "whole_assocend"))), // TODO update MDS
      entry(MISSING_ENUM, mdf(List.of(), List.of("enum"))),
      entry(MISSING_ENUM_ITEM, mdf(List.of(), List.of("enumitem"))),
      entry(MISSING_GENERALIZATION, mdf(List.of("sub_cls", "super_cls"), List.of())),
      entry(MISSING_ROLE_NAMES, mdf(List.of("assocend"), List.of("assocend"))),
      entry(NON_DIFFERENTIATED_SUBCLASS, mdf(List.of("cls"), List.of())),
      entry(PLURAL_ATTRIBUTE, mdf(List.of("attr"), List.of("attr"))),
      entry(PLURAL_CLASS_NAME, mdf(List.of("cls"), List.of("cls"))),
      entry(REPRESENTING_ACTION_WITH_ASSOC, mdf(List.of("assocend"), List.of("assocend"))),
      entry(ROLE_SHOULD_BE_STATIC, mdf(List.of("assocend"), List.of("assocend"))),
      entry(ROLE_SHOULD_NOT_BE_STATIC, mdf(List.of("assocend"), List.of("assocend"))),
      entry(SOFTWARE_ENGINEERING_TERM, mdf(List.of("cls"), List.of("cls"))),
      entry(UPPERCASE_ATTRIBUTE_NAME, mdf(List.of("attr"), List.of("attr"))),
      entry(USING_AGGREGATION_INSTEAD_OF_COMPOSITION, mdf(List.of("assocend"), List.of("assocend"))),
      entry(USING_ASSOC_INSTEAD_OF_AGGREGATION, mdf(List.of("assocend"), List.of("assocend"))),
      entry(USING_ASSOC_INSTEAD_OF_COMPOSITION, mdf(List.of("assocend"), List.of("assocend"))),
      entry(USING_ATTRIBUTE_INSTEAD_OF_ASSOC, mdf(List.of("attr"), List.of("assocend"))),
      entry(USING_COMPOSITION_INSTEAD_OF_AGGREGATION, mdf(List.of("assocend"), List.of("assocend"))),
      entry(USING_COMPOSITION_INSTEAD_OF_ASSOC, mdf(List.of("part_assocend", "whole_assocend"), List.of("assoc"))), // TODO double check then update MDS
      entry(USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED, mdf(List.of("assocend"), List.of("assocend"))),
      entry(USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED, mdf(List.of("source_assocend", "target_assocend"), List.of("source_assocend", "target_assocend"))), // to be discussed
      entry(WRONG_ATTRIBUTE_TYPE, mdf(List.of("attr"), List.of("attr"))),
      entry(WRONG_CLASS_NAME, mdf(List.of("cls"), List.of("cls"))),
      entry(WRONG_GENERALIZATION_DIRECTION, mdf(List.of("super_cls", "sub_cls"), List.of("sub_cls", "super_cls"))),
      entry(WRONG_MULTIPLICITY, mdf(List.of("assocend"), List.of("assocend"))),
      entry(WRONG_ROLE_NAME, mdf(List.of("assocend"), List.of("assocend"))),
      entry(WRONG_SUPERCLASS, mdf(List.of("sub_cls", "super_cls"), List.of("sub_cls", "super_cls"))),

      // In progress: MDS logic and tests implemented
      // TODO Prabhsimran: Ensure the MDS returns these results by unit testing or other means

      entry(ASSOC_SHOULD_BE_ENUM_PR_PATTERN, mdf(List.of("player_cls", "role_assocend*"), List.of("player_cls", "role_attr"))),
      entry(ASSOC_SHOULD_BE_FULL_PR_PATTERN, mdf(List.of("player_cls", "role_assocend*"), List.of("player_cls", "role_cls*"))),
      entry(ASSOC_SHOULD_BE_SUBCLASS_PR_PATTERN, mdf(List.of("player_cls", "role_assocend*"), List.of("player_cls", "role_cls*"))),
      entry(COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT, mdf(List.of("cls*"), List.of())),
      entry(ENUM_SHOULD_BE_ASSOC_PR_PATTERN, mdf(List.of("player_cls", "role_enumitem*"), List.of("player_cls", "role_assocend*"))),
      entry(ENUM_SHOULD_BE_FULL_PR_PATTERN, mdf(List.of("player_cls", "role_enumitem*"), List.of("player_cls", "role_cls*"))),
      entry(ENUM_SHOULD_BE_SUBCLASS_PR_PATTERN, mdf(List.of("player_cls", "role_enumitem*"), List.of("player_cls", "role_cls*"))),
      entry(FULL_PR_PATTERN_SHOULD_BE_ASSOC, mdf(List.of("player_cls", "role_cls*"), List.of("player_cls", "role_assocend*"))),
      entry(FULL_PR_PATTERN_SHOULD_BE_ENUM, mdf(List.of("player_cls", "role_cls*"), List.of("player_cls", "role_attr"))),
      entry(FULL_PR_PATTERN_SHOULD_BE_SUBCLASS, mdf(List.of("player_cls", "role_cls*"), List.of("player_cls", "role_cls*"))),
      entry(INCOMPLETE_PR_PATTERN, mdf(List.of("cls*"), List.of("cls*"))), // TODO Update this based on MDS
      entry(INCOMPLETE_CONTAINMENT_TREE, mdf(List.of("cls*"), List.of())),
      entry(SUBCLASS_SHOULD_BE_ASSOC_PR_PATTERN, mdf(List.of("player_cls", "role_cls*"), List.of("player_cls", "role_assocend*"))),
      entry(SUBCLASS_SHOULD_BE_ENUM_PR_PATTERN, mdf(List.of("player_cls", "role_cls*"), List.of("player_cls", "role_attr"))),
      entry(SUBCLASS_SHOULD_BE_FULL_PR_PATTERN, mdf(List.of("player_cls", "role_cls*"), List.of("player_cls", "role_cls*"))),

      // In progress: MDS logic implemented (or will be implemented soon) but no tests
      entry(LIST_ATTRIBUTE, mdf(List.of("attr"), List.of("attr"))),
      entry(MISSING_PR_PATTERN, mdf(List.of(), List.of(""))), // TODO [], [missingElements]
      entry(USING_AGGREGATION_INSTEAD_OF_ASSOC, mdf(List.of("assocend"), List.of("assocend"))),
      entry(WRONG_RELATIONSHIP_DIRECTION, mdf(List.of(""), List.of(""))), // TODO

      // Future work: mistake detection not implemented for these mistake types
      // TODO complete student/instructor descriptions
      entry(BAD_ASSOCIATION_NAME_SPELLING, mdf(List.of("assoc"), List.of("assoc"))),
      entry(EXTRA_N_ARY_ASSOCIATION, mdf(List.of("assoc"), List.of())),
      entry(GENERALIZATION_INAPPLICABLE, mdf(List.of("sub_cls", "super_cls"), List.of())),
      entry(INHERITED_FEATURE_DOES_NOT_MAKE_SENSE_FOR_SUBCLASS, mdf(List.of("attr", "sub_cls", "super_cls"), List.of())),
      entry(MISSING_ASSOCIATION_NAME, mdf(List.of("assoc"), List.of("assoc"))),
      entry(MISSING_ATTRIBUTE_TYPE, mdf(List.of("attr"), List.of("attr"))),
      entry(MISSING_MULTIPLICITY, mdf(List.of("assocend"), List.of("assocend"))),
      entry(MISSING_N_ARY_ASSOCIATION, mdf(List.of(), List.of("assoc"))),
      entry(SUBCLASS_IS_AN_INSTANCE_OF_SUPERCLASS, mdf(List.of("sub_cls", "super_cls"), List.of())),
      entry(SUBCLASS_NOT_DISTINCT_ACROSS_LIFETIME, mdf(List.of("sub_cls", "super_cls"), List.of())),
      entry(USING_BINARY_ASSOC_INSTEAD_OF_N_ARY_ASSOC, mdf(List.of("assoc"), List.of("assoc"))),
      entry(USING_INTERMEDIATE_CLASS_INSTEAD_OF_N_ARY_ASSOC, mdf(List.of("cls"), List.of("assoc"))),
      entry(USING_N_ARY_ASSOC_INSTEAD_OF_BINARY_ASSOC, mdf(List.of("assoc"), List.of("assoc"))),
      entry(USING_N_ARY_ASSOC_INSTEAD_OF_INTERMEDIATE_CLASS, mdf(List.of("assoc"), List.of("cls")))
  );

}
