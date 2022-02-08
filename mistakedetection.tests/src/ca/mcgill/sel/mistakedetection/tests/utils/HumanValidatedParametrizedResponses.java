package ca.mcgill.sel.mistakedetection.tests.utils;

import static java.util.Map.entry;
// Always keep this comment here to allow easy auto-importing of new mistake types in IDEs
//import static learningcorpus.mistaketypes.MistakeTypes.*;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_CLASS_SHOULD_BE_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_DUPLICATED;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ASSOC_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_CLASS_NAME_SPELLING;
import java.util.Map;
import java.util.Set;
import learningcorpus.MistakeType;

public class HumanValidatedParametrizedResponses {

  public static final Map<MistakeType, Set<String>> mappings = Map.ofEntries(
      // paste entries from MDIS4LC here
      entry(ASSOC_CLASS_SHOULD_BE_CLASS, Set.of("The ${inst_cls} class should be a regular class.")),
      entry(ATTRIBUTE_DUPLICATED, Set.of("The ${stud_attr} already exists in another class, so there is no need to include it again.")),
      entry(BAD_ASSOC_CLASS_NAME_SPELLING, Set.of("The ${stud_cls} class has a misspelled name.",
          "The ${stud_cls} class should be changed to ${inst_cls}.")),
      entry(BAD_ATTRIBUTE_NAME_SPELLING, Set.of("${stud_attr} is misspelled. [Use the same spelling as the problem description.]")),
      entry(BAD_CLASS_NAME_SPELLING, Set.of("The ${stud_cls} class has a misspelled name.",
          "The ${stud_cls} class should be changed to ${inst_cls}."))
  );
}
