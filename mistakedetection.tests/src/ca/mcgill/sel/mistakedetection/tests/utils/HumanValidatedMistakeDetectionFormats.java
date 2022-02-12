package ca.mcgill.sel.mistakedetection.tests.utils;

import static ca.mcgill.sel.mistakedetection.tests.utils.MistakeDetectionFormat.mdf;
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
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ENUM_ITEM;
import static learningcorpus.mistaketypes.MistakeTypes.LOWERCASE_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ENUM_ITEM;
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
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED;
import static learningcorpus.mistaketypes.MistakeTypes.USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ROLE_NAME;
import java.util.List;
import java.util.Map;
import learningcorpus.MistakeType;

public class HumanValidatedMistakeDetectionFormats {

  public static final Map<MistakeType, MistakeDetectionFormat> mappings = Map.ofEntries(
      // paste entries from MDIS4LC here (studentElemsDescriptions, instructorElemsDescriptions)
      entry(ASSOC_CLASS_SHOULD_BE_CLASS, mdf(List.of("cls"), List.of("cls"))),
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
      entry(LOWERCASE_CLASS_NAME, mdf(List.of("cls"), List.of("cls"))),
      entry(MISSING_AGGREGATION, mdf(List.of(), List.of("rel"))),
      entry(MISSING_ASSOC_CLASS, mdf(List.of(), List.of("cls"))),
      entry(MISSING_ASSOCIATION, mdf(List.of(), List.of("rel"))),
      entry(MISSING_ATTRIBUTE, mdf(List.of(), List.of("attr"))),
      entry(MISSING_CLASS, mdf(List.of(), List.of("cls"))),
      entry(MISSING_COMPOSITION, mdf(List.of(), List.of("rel"))),
      entry(MISSING_ENUM, mdf(List.of(), List.of("enum"))),
      entry(MISSING_ENUM_ITEM, mdf(List.of(), List.of("enumitem"))),
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
      entry(USING_ATTRIBUTE_INSTEAD_OF_ASSOC, mdf(List.of("attr"), List.of())),
      entry(USING_COMPOSITION_INSTEAD_OF_AGGREGATION, mdf(List.of("assocend"), List.of("assocend"))),
      entry(USING_COMPOSITION_INSTEAD_OF_ASSOC, mdf(List.of("assocend"), List.of("assocend"))),
      entry(USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED, mdf(List.of("assocend"), List.of("assocend"))),
      entry(USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED, mdf(List.of("assocend"), List.of("assocend"))),
      entry(WRONG_ATTRIBUTE_TYPE, mdf(List.of("attr"), List.of("attr"))),
      entry(WRONG_CLASS_NAME, mdf(List.of("cls"), List.of("cls"))),
      entry(WRONG_MULTIPLICITY, mdf(List.of("assocend"), List.of("assocend"))),
      entry(WRONG_ROLE_NAME, mdf(List.of("assocend"), List.of("assocend")))
  );

}
