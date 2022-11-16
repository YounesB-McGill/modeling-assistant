package ca.mcgill.sel.mistakedetection.tests.utils;

import static ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeElementGroup.meg;
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
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_SUPERCLASS;
import java.util.List;
import java.util.Map;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeElementGroup;
import learningcorpus.MistakeType;

public class HumanValidatedMistakeElementGroups {

  public static final Map<MistakeType, MistakeElementGroup> mappings = Map.ofEntries(
      // paste entries from MDIS4LC here (studentElemsDescriptions, instructorElemsDescriptions)
      // Completed entries (derived from MDS)
      entry(ASSOC_CLASS_SHOULD_BE_CLASS, meg(List.of("assoc", "cls"), List.of("cls"))),
      entry(ASSOC_SHOULD_BE_ENUM_PR_PATTERN, meg(List.of("player_cls", "role_assocend*"), List.of("player_cls", "role_attr", "role_enum", "role_enumitem*"))),
      entry(ASSOC_SHOULD_BE_FULL_PR_PATTERN, meg(List.of("player_cls", "role_assocend*"), List.of("player_cls", "role_cls*"))),
      entry(ASSOC_SHOULD_BE_SUBCLASS_PR_PATTERN, meg(List.of("player_cls", "role_assocend*"), List.of("player_cls", "role_cls*"))),
      entry(ATTRIBUTE_DUPLICATED, meg(List.of("attr"), List.of())),
      entry(ATTRIBUTE_MISPLACED, meg(List.of("attr"), List.of("attr"))),
      entry(ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY, meg(List.of("attr"), List.of("attr"))),
      entry(ATTRIBUTE_SHOULD_BE_STATIC, meg(List.of("attr"), List.of("attr"))),
      entry(ATTRIBUTE_SHOULD_NOT_BE_STATIC, meg(List.of("attr"), List.of("attr"))),
      entry(BAD_ASSOC_CLASS_NAME_SPELLING, meg(List.of("assoc", "cls"), List.of("assoc", "cls"))),
      entry(BAD_ATTRIBUTE_NAME_SPELLING, meg(List.of("attr"), List.of("attr"))),
      entry(BAD_CLASS_NAME_SPELLING, meg(List.of("cls"), List.of("cls"))),
      entry(BAD_ENUM_ITEM_SPELLING, meg(List.of("enumitem"), List.of("enumitem"))),
      entry(BAD_ENUM_NAME_SPELLING, meg(List.of("enum"), List.of("enum"))),
      entry(BAD_ROLE_NAME_SPELLING, meg(List.of("assocend"), List.of("assocend"))),
      entry(CLASS_SHOULD_BE_ABSTRACT, meg(List.of("cls"), List.of("cls"))),
      entry(CLASS_SHOULD_BE_ASSOC_CLASS, meg(List.of("cls"), List.of("assoc", "cls"))),
      entry(CLASS_SHOULD_BE_ENUM, meg(List.of("cls"), List.of("enum"))),
      entry(CLASS_SHOULD_NOT_BE_ABSTRACT, meg(List.of("cls"), List.of("cls"))),
      entry(COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT, meg(List.of("cls*"), List.of())),
      entry(ENUM_SHOULD_BE_ASSOC_PR_PATTERN, meg(List.of("player_cls", "role_attr", "role_enum", "role_enumitem*"), List.of("player_cls", "role_assocend*"))),
      entry(ENUM_SHOULD_BE_CLASS, meg(List.of("enum"), List.of("cls"))),
      entry(ENUM_SHOULD_BE_FULL_PR_PATTERN, meg(List.of("player_cls", "role_attr", "role_enum", "role_enumitem*"), List.of("player_cls", "role_cls*"))),
      entry(ENUM_SHOULD_BE_SUBCLASS_PR_PATTERN, meg(List.of("player_cls", "role_attr", "role_enum", "role_enumitem*"), List.of("player_cls", "role_cls*"))),
      entry(EXTRA_AGGREGATION, meg(List.of("aggr", "whole_assocend", "part_assocend"), List.of())),
      entry(EXTRA_ASSOC_CLASS, meg(List.of("assoc", "cls"), List.of())),
      entry(EXTRA_ASSOCIATION, meg(List.of("assoc"), List.of())),
      entry(EXTRA_ATTRIBUTE, meg(List.of("attr"), List.of())),
      entry(EXTRA_CLASS, meg(List.of("cls"), List.of())),
      entry(EXTRA_COMPOSITION, meg(List.of("compos", "whole_assocend", "part_assocend"), List.of())),
      entry(EXTRA_ENUM, meg(List.of("enum"), List.of())),
      entry(EXTRA_ENUM_ITEM, meg(List.of("enumitem"), List.of())),
      entry(EXTRA_GENERALIZATION, meg(List.of("sub_cls", "super_cls"), List.of())),
      entry(FULL_PR_PATTERN_SHOULD_BE_ASSOC, meg(List.of("player_cls", "role_cls*"), List.of("player_cls", "role_assocend*"))),
      entry(FULL_PR_PATTERN_SHOULD_BE_ENUM, meg(List.of("player_cls", "role_cls*"), List.of("player_cls", "role_attr", "role_enum", "role_enumitem*"))),
      entry(FULL_PR_PATTERN_SHOULD_BE_SUBCLASS, meg(List.of("player_cls", "role_cls*"), List.of("player_cls", "role_cls*"))),
      entry(GENERALIZATION_SHOULD_BE_ASSOC_AO_PATTERN, meg(List.of("sub_cls", "super_cls"), List.of("abs_cls", "occ_cls"))),
      entry(INCOMPLETE_AO_PATTERN, meg(List.of("existing_cls"), List.of("abs_cls", "occ_cls"))),
      entry(INCOMPLETE_CONTAINMENT_TREE, meg(List.of("cls*"), List.of())),
      entry(INFINITE_RECURSIVE_DEPENDENCY, meg(List.of("assocend*"), List.of())),
      entry(LOWERCASE_CLASS_NAME, meg(List.of("cls"), List.of("cls"))),
      entry(MISSING_AGGREGATION, meg(List.of(), List.of("aggr", "whole_assocend", "part_assocend"))),
      entry(MISSING_AO_PATTERN, meg(List.of(), List.of("abs_cls", "occ_cls"))),
      entry(MISSING_ASSOC_CLASS, meg(List.of(), List.of("assoc", "cls"))),
      entry(MISSING_ASSOCIATION, meg(List.of(), List.of("assoc"))),
      entry(MISSING_ATTRIBUTE, meg(List.of("cls"), List.of("attr"))),
      entry(MISSING_CLASS, meg(List.of(), List.of("cls"))),
      entry(MISSING_COMPOSITION, meg(List.of(), List.of("compos", "whole_assocend", "part_assocend"))),
      entry(MISSING_ENUM, meg(List.of(), List.of("enum"))),
      entry(MISSING_ENUM_ITEM, meg(List.of("enum"), List.of("enumitem"))),
      entry(MISSING_GENERALIZATION, meg(List.of(), List.of("sub_cls", "super_cls"))),
      entry(MISSING_ROLE_NAME, meg(List.of("assocend"), List.of("assocend"))),
      entry(NON_DIFFERENTIATED_SUBCLASS, meg(List.of("cls"), List.of())),
      entry(PLURAL_ATTRIBUTE, meg(List.of("attr"), List.of("attr"))),
      entry(PLURAL_CLASS_NAME, meg(List.of("cls"), List.of("cls"))),
      entry(REPRESENTING_ACTION_WITH_ASSOC, meg(List.of("assocend"), List.of("assocend"))),
      entry(REVERSED_GENERALIZATION_DIRECTION, meg(List.of("sub_cls", "super_cls"), List.of("sub_cls", "super_cls"))),
      entry(REVERSED_RELATIONSHIP_DIRECTION, meg(List.of("aggr_compos_or_assoc", "whole_or_target_assocend", "part_or_source_assocend"), List.of("aggr_compos_or_assoc", "whole_or_target_assocend", "part_or_source_assocend"))),
      entry(ROLE_SHOULD_BE_STATIC, meg(List.of("assocend"), List.of("assocend"))),
      entry(ROLE_SHOULD_NOT_BE_STATIC, meg(List.of("assocend"), List.of("assocend"))),
      entry(SOFTWARE_ENGINEERING_TERM, meg(List.of("cls"), List.of("cls"))),
      entry(SUBCLASS_SHOULD_BE_ASSOC_PR_PATTERN, meg(List.of("player_cls", "role_cls*"), List.of("player_cls", "role_assocend*"))),
      entry(SUBCLASS_SHOULD_BE_ENUM_PR_PATTERN, meg(List.of("player_cls", "role_cls*"), List.of("player_cls", "role_attr", "role_enum", "role_enumitem*"))),
      entry(SUBCLASS_SHOULD_BE_FULL_PR_PATTERN, meg(List.of("player_cls", "role_cls*"), List.of("player_cls", "role_cls*"))),
      entry(UPPERCASE_ATTRIBUTE_NAME, meg(List.of("attr"), List.of("attr"))),
      entry(USING_AGGREGATION_INSTEAD_OF_ASSOC, meg(List.of("aggr", "whole_assocend", "part_assocend"), List.of("assoc", "assocend", "other_assocend"))),
      entry(USING_AGGREGATION_INSTEAD_OF_COMPOSITION, meg(List.of("aggr", "whole_assocend", "part_assocend"), List.of("compos", "whole_assocend", "part_assocend"))),
      entry(USING_ASSOC_INSTEAD_OF_AGGREGATION, meg(List.of("assoc", "assocend", "other_assocend"), List.of("aggr", "whole_assocend", "part_assocend"))),
      entry(USING_ASSOC_INSTEAD_OF_COMPOSITION, meg(List.of("assoc", "assocend", "other_assocend"), List.of("compos", "whole_assocend", "part_assocend"))),
      entry(USING_ATTRIBUTE_INSTEAD_OF_ASSOC, meg(List.of("attr"), List.of("assocend"))),
      entry(USING_COMPOSITION_INSTEAD_OF_AGGREGATION, meg(List.of("compos", "whole_assocend", "part_assocend"), List.of("aggr", "whole_assocend", "part_assocend"))),
      entry(USING_COMPOSITION_INSTEAD_OF_ASSOC, meg(List.of("compos", "whole_assocend", "part_assocend"), List.of("assoc", "assocend", "other_assocend"))),
      entry(USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED, meg(List.of("aggr_compos_or_assoc", "target_assocend", "source_assocend"), List.of("aggr_compos_or_assoc", "assocend", "other_assocend"))),
      entry(USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED, meg(List.of("aggr_compos_or_assoc", "assocend", "other_assocend"), List.of("aggr_compos_or_assoc", "target_assocend", "source_assocend"))),
      entry(WRONG_ATTRIBUTE_TYPE, meg(List.of("attr"), List.of("attr"))),
      entry(WRONG_CLASS_NAME, meg(List.of("cls"), List.of("cls"))),
      entry(WRONG_MULTIPLICITY, meg(List.of("assocend"), List.of("assocend"))),
      entry(WRONG_ROLE_NAME, meg(List.of("assocend"), List.of("assocend"))),
      entry(WRONG_SUPERCLASS, meg(List.of("sub_cls", "super_cls"), List.of("sub_cls", "super_cls"))),

      // In progress: MDS logic implemented (or will be implemented soon) but no tests
      entry(LIST_ATTRIBUTE, meg(List.of("attr"), List.of("attr"))),

      // Future work: mistake detection not implemented for these mistake types
      // TODO complete student/instructor descriptions
      entry(BAD_ASSOCIATION_NAME_SPELLING, meg(List.of("assoc"), List.of("assoc"))),
      entry(EXTRA_N_ARY_ASSOCIATION, meg(List.of("assoc", "assocend*"), List.of())),
      entry(GENERALIZATION_INAPPLICABLE, meg(List.of("sub_cls", "super_cls"), List.of())),
      entry(INCOMPLETE_PR_PATTERN, meg(List.of("player_cls", "role*"), List.of("player_cls", "role*"))),
      entry(INHERITED_FEATURE_DOES_NOT_MAKE_SENSE_FOR_SUBCLASS, meg(List.of("sub_cls", "super_cls"), List.of())),
      entry(MISSING_ASSOCIATION_IN_AO_PATTERN, meg(List.of("abs_cls", "occ_cls"), List.of("abs_cls", "occ_cls"))),
      entry(MISSING_ASSOCIATION_NAME, meg(List.of("assoc"), List.of("assoc"))),
      entry(MISSING_ATTRIBUTE_TYPE, meg(List.of("attr"), List.of("attr"))),
      entry(MISSING_MULTIPLICITY, meg(List.of("assocend"), List.of("assocend"))),
      entry(MISSING_N_ARY_ASSOCIATION, meg(List.of(), List.of("assoc", "assocend*"))),
      entry(MISSING_PR_PATTERN, meg(List.of(), List.of("player_cls", "role*"))),
      entry(SUBCLASS_IS_AN_INSTANCE_OF_SUPERCLASS, meg(List.of("sub_cls", "super_cls"), List.of())),
      entry(SUBCLASS_NOT_DISTINCT_ACROSS_LIFETIME, meg(List.of("sub_cls", "super_cls"), List.of())),
      entry(USING_BINARY_ASSOC_INSTEAD_OF_N_ARY_ASSOC, meg(List.of("assoc", "assocend", "other_assocend"), List.of("assoc", "assocend*"))),
      entry(USING_INTERMEDIATE_CLASS_INSTEAD_OF_N_ARY_ASSOC, meg(List.of("cls"), List.of("assoc", "assocend*"))),
      entry(USING_N_ARY_ASSOC_INSTEAD_OF_BINARY_ASSOC, meg(List.of("assoc", "assocend*"), List.of("assoc", "assocend", "other_assocend"))),
      entry(USING_N_ARY_ASSOC_INSTEAD_OF_INTERMEDIATE_CLASS, meg(List.of("assoc", "assocend*"), List.of("cls")))
  );

  /**
   * List of mistake types with MEGs that are exempted from automatic validation since they are false positives
   * that have been manually verified as correct.
   */
  public static final List<MistakeType> exemptions = List.of(
      INCOMPLETE_PR_PATTERN,
      INFINITE_RECURSIVE_DEPENDENCY,
      REVERSED_RELATIONSHIP_DIRECTION,
      USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED,
      USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED
  );

}
