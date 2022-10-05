package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedMistakeElementGroups;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeElementGroup;
import learningcorpus.MistakeType;

public class MappingToMistakeElementDescriptionsForJson extends MistakeDetectionInformationService {

  public MappingToMistakeElementDescriptionsForJson() {
    super("Suggested mistake element descriptions (use in mistakeelems.json file)");
  }

  @Override public String getOutput() {
    return title(name) + "\n" + formatMistakeElementDescriptionsForJson(
        new TreeMap<>(HumanValidatedMistakeElementGroups.mappings), true);
  }

  public static MappingToMistakeElementDescriptionsForJson get() {
    return new MappingToMistakeElementDescriptionsForJson();
  }

  /** Formats the MistakeElementGroups to be used in the mistake element JSON file. */
  private static String formatMistakeElementDescriptionsForJson(Map<MistakeType, MistakeElementGroup> mapping,
      boolean filterNumberedMegs) {
    // eg, "missing_class": [[], ["cls"]],
    return mapping.entrySet().stream().map(e -> {
      var meg = e.getValue();
      var name = underscorify(e.getKey().getName());
      return ("\"" + name + "\": [" + meg + "],").replaceAll("[\\(\\)]", "");
//      if (decl.length() <= MAX_LINE_LENGTH) {
//        return decl;
//      }
//      return name + ".md_format = meg(\n    " + meg.studAsString() + ",\n    " + meg.instAsString() + ")";
    }).filter(s -> !(filterNumberedMegs && s.matches(".*\\d.*"))).collect(Collectors.joining("\n"));
  }

}
