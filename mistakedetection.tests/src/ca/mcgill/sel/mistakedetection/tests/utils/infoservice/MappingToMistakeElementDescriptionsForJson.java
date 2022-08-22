package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedMistakeDetectionFormats;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeDetectionFormat;
import learningcorpus.MistakeType;

public class MappingToMistakeElementDescriptionsForJson extends MistakeDetectionInformationService {

  public MappingToMistakeElementDescriptionsForJson() {
    super("Suggested mistake element descriptions (use in mistakeelems.json file)");
  }

  @Override public String getOutput() {
    return title(name) + "\n" + formatMistakeElementDescriptionsForJson(
        new TreeMap<>(HumanValidatedMistakeDetectionFormats.mappings), true);
  }

  public static MappingToMistakeElementDescriptionsForJson get() {
    return new MappingToMistakeElementDescriptionsForJson();
  }

  /** Format the MistakeDetectionFormats to be used in the mistake element JSON file. */
  private static String formatMistakeElementDescriptionsForJson(Map<MistakeType, MistakeDetectionFormat> mapping,
      boolean filterNumberedMdfs) {
    // eg, "missing_class": [[], ["cls"]],
    return mapping.entrySet().stream().map(e -> {
      var mdf = e.getValue();
      var name = underscorify(e.getKey().getName());
      return ("\"" + name + "\": [" + mdf + "],").replaceAll("[\\(\\)]", "");
//      if (decl.length() <= MAX_LINE_LENGTH) {
//        return decl;
//      }
//      return name + ".md_format = mdf(\n    " + mdf.studAsString() + ",\n    " + mdf.instAsString() + ")";
    }).filter(s -> !(filterNumberedMdfs && s.matches(".*\\d.*"))).collect(Collectors.joining("\n"));
  }

}
