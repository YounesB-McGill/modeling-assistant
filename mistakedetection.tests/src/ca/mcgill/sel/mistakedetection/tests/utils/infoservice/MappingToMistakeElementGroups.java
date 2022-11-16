package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import java.util.Map;
import java.util.stream.Collectors;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeElementGroup;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeTypeInfo;

public class MappingToMistakeElementGroups extends MistakeDetectionInformationService {

  private MappingToMistakeElementGroups() {
    super("MistakeElementGroups for human verification (use to update HumanValidatedMistakeElementGroups)");
  }

  @Override public String getOutput() {
    return title(name) + "\n" + formatMistakeElementGroupsForJava(suggestMistakeElementGroups(), false);
  }

  public static MappingToMistakeElementGroups get() {
    return new MappingToMistakeElementGroups();
  }

  /** Format the MistakeElementGroups to be used in the HumanValidatedMistakeElementGroups class. */
  private static String formatMistakeElementGroupsForJava(Map<MistakeTypeInfo, MistakeElementGroup> mapping,
      boolean filterNumberedMegs) {
    // eg, entry(ATTRIBUTE_DUPLICATED, meg(List.of("attr"), List.of()))
    return mapping.entrySet().stream()
        .map(e -> "entry(" + underscorify(e.getKey().mistakeType.getName()).toUpperCase() + ", meg"
            + e.getValue().toString().replace("[", "List.of(").replace("]", ")") + ")")
        .filter(s -> !(filterNumberedMegs && s.matches(".*\\d.*"))).collect(Collectors.joining(",\n"));
  }

}
