package ca.mcgill.sel.mistakedetection.tests.utils;

import static ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeDetectionFormat.mdf;
import static java.util.Map.entry;
// Always keep this comment here to allow easy auto-importing of new mistake types in IDEs
//import static learningcorpus.mistaketypes.MistakeTypes.*;
import static learningcorpus.mistaketypes.MistakeTypes.INFINITE_RECURSIVE_DEPENDENCY;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_AO_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_GENERALIZATION;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_GENERALIZATION_DIRECTION;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_SUPERCLASS;
import java.util.List;
import java.util.Map;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeDetectionFormat;
import learningcorpus.MistakeType;

public class HumanValidatedMistakeDetectionFormats {

  public static final Map<MistakeType, MistakeDetectionFormat> mappings = Map.ofEntries(
      // paste entries from MDIS4LC here (studentElemsDescriptions, instructorElemsDescriptions)
      // already done
      /*entry(ASSOC_CLASS_SHOULD_BE_CLASS, mdf(List.of("cls"), List.of("cls"))),
      entry(ATTRIBUTE_DUPLICATED, mdf(List.of("attr"), List.of())),
      entry(ATTRIBUTE_MISPLACED, mdf(List.of("attr"), List.of("attr"))),
      entry(ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY, mdf(List.of("attr"), List.of("attr"))),
      entry(ATTRIBUTE_SHOULD_BE_STATIC, mdf(List.of("attr"), List.of("attr"))),
      entry(ATTRIBUTE_SHOULD_NOT_BE_STATIC, mdf(List.of("attr"), List.of("attr"))),
      entry(BAD_ASSOC_CLASS_NAME_SPELLING, mdf(List.of("cls"), List.of("cls"))),
      entry(BAD_ATTRIBUTE_NAME_SPELLING, mdf(List.of("attr"), List.of("attr"))),
      entry(BAD_CLASS_NAME_SPELLING, mdf(List.of("cls"), List.of("cls"))),
      entry(BAD_ENUM_ITEM_SPELLING, mdf(List.of("enumitem"), List.of("enumitem"))),
      entry(BAD_ENUM_NAME_SPELLING, mdf(List.of("enum"), List.of("enum"))),
      entry(BAD_ROLE_NAME_SPELLING, mdf(List.of("assocend"), List.of("assocend"))),
      entry(CLASS_SHOULD_BE_ASSOC_CLASS, mdf(List.of("cls"), List.of("cls"))),
      entry(CLASS_SHOULD_BE_ENUM, mdf(List.of("cls"), List.of("enum"))),
      entry(ENUM_SHOULD_BE_CLASS, mdf(List.of("enum"), List.of("cls"))),
      entry(EXTRA_AGGREGATION, mdf(List.of("rel"), List.of())),
      entry(EXTRA_ASSOC_CLASS, mdf(List.of("cls"), List.of())),
      entry(EXTRA_ASSOCIATION, mdf(List.of("rel"), List.of())),
      entry(EXTRA_ATTRIBUTE, mdf(List.of("attr"), List.of())),
      entry(EXTRA_CLASS, mdf(List.of("cls"), List.of())),
      entry(EXTRA_COMPOSITION, mdf(List.of("rel"), List.of())),
      entry(EXTRA_ENUM, mdf(List.of("enum"), List.of())),
      entry(EXTRA_ENUM_ITEM, mdf(List.of("enumitem"), List.of())),
      entry(EXTRA_GENERALIZATION, mdf(List.of("sub_cls", "super_cls"), List.of("sub_cls", "super_cls"))),
      entry(GENERALIZATION_SHOULD_BE_ASSOC_AO_PATTERN, mdf(List.of("sub_cls", "super_cls"), List.of("abs_cls", "occ_cls"))),
      entry(INFINITE_RECURSIVE_DEPENDENCY, mdf(List.of("minlowerbound_assocend", "other_assocend"), List.of())),
      entry(LOWERCASE_CLASS_NAME, mdf(List.of("cls"), List.of("cls"))),
      entry(MISSING_AGGREGATION, mdf(List.of(), List.of("rel"))),
      entry(MISSING_AO_PATTERN, mdf(List.of(), List.of("abs_cls", "occ_cls"))),
      entry(MISSING_ASSOC_CLASS, mdf(List.of(), List.of("cls"))),
      entry(MISSING_ASSOCIATION, mdf(List.of(), List.of("rel"))),
      entry(MISSING_ATTRIBUTE, mdf(List.of(), List.of("attr"))),
      entry(MISSING_CLASS, mdf(List.of(), List.of("cls"))),
      entry(MISSING_COMPOSITION, mdf(List.of(), List.of("rel"))),
      entry(MISSING_ENUM, mdf(List.of(), List.of("enum"))),
      entry(MISSING_ENUM_ITEM, mdf(List.of(), List.of("enumitem"))),
      entry(MISSING_GENERALIZATION, mdf(List.of("sub_cls", "super_cls"), List.of("sub_cls", "super_cls"))),
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
      entry(USING_COMPOSITION_INSTEAD_OF_ASSOC, mdf(List.of("assocend"), List.of("assocend"))),
      entry(USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED, mdf(List.of("assocend"), List.of("assocend"))),
      entry(USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED, mdf(List.of("assocend"), List.of("assocend"))),
      entry(WRONG_ATTRIBUTE_TYPE, mdf(List.of("attr"), List.of("attr"))),
      entry(WRONG_CLASS_NAME, mdf(List.of("cls"), List.of("cls"))),
      entry(WRONG_GENERALIZATION_DIRECTION, mdf(List.of("super_cls", "sub_cls"), List.of("sub_cls", "super_cls"))),
      entry(WRONG_MULTIPLICITY, mdf(List.of("assocend"), List.of("assocend"))),
      entry(WRONG_ROLE_NAME, mdf(List.of("assocend"), List.of("assocend"))),
      entry(WRONG_SUPERCLASS, mdf(List.of("sub_cls", "super_cls"), List.of("sub_cls", "super_cls"))),*/

      // in progress
      entry(EXTRA_GENERALIZATION, mdf(List.of("sub_cls", "super_cls"), List.of("sub_cls", "super_cls"))),
      entry(GENERALIZATION_SHOULD_BE_ASSOC_AO_PATTERN, mdf(List.of("sub_cls", "super_cls"), List.of("abs_cls", "occ_cls"))),
      entry(INFINITE_RECURSIVE_DEPENDENCY, mdf(List.of("minlowerbound_assocend", "other_assocend"), List.of())),
      entry(MISSING_AO_PATTERN, mdf(List.of(), List.of("abs_cls", "occ_cls"))),
      entry(MISSING_GENERALIZATION, mdf(List.of("sub_cls", "super_cls"), List.of("sub_cls", "super_cls"))),
      entry(WRONG_GENERALIZATION_DIRECTION, mdf(List.of("super_cls", "sub_cls"), List.of("sub_cls", "super_cls"))),
      entry(WRONG_ROLE_NAME, mdf(List.of("assocend"), List.of("assocend"))),
      entry(WRONG_SUPERCLASS, mdf(List.of("sub_cls", "super_cls"), List.of("sub_cls", "super_cls")))

      // to be done later
      //:entry(ASSOC_SHOULD_BE_ENUM_PR_PATTERN, mdf(List.of("0_compos", "1_assocend", "2_assocend", "3_cls"), List.of("0_cls", "1_attr"))),
      //:entry(ASSOC_SHOULD_BE_FULL_PR_PATTERN, mdf(List.of("0_compos", "1_assocend", "2_assocend", "3_cls"), List.of("0_cls", "1_cls", "2_cls"))),
      //:entry(ASSOC_SHOULD_BE_SUBCLASS_PR_PATTERN, mdf(List.of("0_compos", "1_assocend", "2_assocend", "3_cls"), List.of("0_cls", "1_cls", "2_cls"))),
      //:entry(COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT, mdf(List.of("0_cls", "1_cls"), List.of())),
      //:entry(ENUM_SHOULD_BE_ASSOC_PR_PATTERN, mdf(List.of("0_enumitem", "1_enumitem", "2_cls"), List.of("0_cls", "1_assocend", "2_assocend"))),
      //:entry(ENUM_SHOULD_BE_FULL_PR_PATTERN, mdf(List.of("0_enumitem", "1_enumitem", "2_cls"), List.of("0_cls", "1_cls", "2_cls"))),
      //:entry(ENUM_SHOULD_BE_SUBCLASS_PR_PATTERN, mdf(List.of("0_enumitem", "1_enumitem", "2_cls"), List.of("0_cls", "1_cls", "2_cls"))),
      //:entry(FULL_PR_PATTERN_SHOULD_BE_ASSOC, mdf(List.of("0_cls", "1_cls", "2_cls"), List.of("0_cls", "1_assocend", "2_assocend"))),
      //:entry(FULL_PR_PATTERN_SHOULD_BE_ENUM, mdf(List.of("0_cls", "1_cls", "2_cls"), List.of("0_cls", "1_attr"))),
      //:entry(FULL_PR_PATTERN_SHOULD_BE_SUBCLASS, mdf(List.of("0_cls", "1_cls", "2_cls"), List.of("0_cls", "1_cls", "2_cls"))),
      //:entry(INCOMPLETE_AO_PATTERN, mdf(List.of("0_cls", "1_cls"), List.of("0_cls", "1_cls"))),
      //:entry(INCOMPLETE_PR_PATTERN, mdf(List.of("0_cls", "1_cls"), List.of("0_cls", "1_cls", "2_cls"))),
      //:entry(INCOMPLETE_CONTAINMENT_TREE, mdf(List.of("0_cls", "1_cls", "2_cls", "3_cls", "4_cls", "5_cls", "6_cls", "7_cls", "8_cls", "9_cls", "10_cls"), List.of())),
      //:entry(SUBCLASS_SHOULD_BE_ASSOC_PR_PATTERN, mdf(List.of("0_cls", "1_cls", "2_cls"), List.of("0_cls", "1_assocend", "2_assocend"))),
      //:entry(SUBCLASS_SHOULD_BE_ENUM_PR_PATTERN, mdf(List.of("0_cls", "1_cls", "2_cls"), List.of("0_cls", "1_attr"))),
      //:entry(SUBCLASS_SHOULD_BE_FULL_PR_PATTERN, mdf(List.of("0_cls", "1_cls", "2_cls"), List.of("0_cls", "1_cls", "2_cls"))),
  );

}
