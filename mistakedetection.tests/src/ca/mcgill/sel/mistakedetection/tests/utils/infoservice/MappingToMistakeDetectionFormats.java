package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import java.util.Map;
import java.util.stream.Collectors;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeDetectionFormat;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeTypeInfo;

public class MappingToMistakeDetectionFormats extends MistakeDetectionInformationService {

  private MappingToMistakeDetectionFormats() {
    super("MistakeDetectionFormats for human verification (use to update HumanValidatedMistakeDetectionFormats)");
  }

  @Override public String getOutput() {
    return title(name) + "\n" + formatMistakeDetectionFormatsForJava(suggestMistakeDetectionFormats(), false);
  }

  public static MappingToMistakeDetectionFormats get() {
    return new MappingToMistakeDetectionFormats();
  }

  /** Format the MistakeDetectionFormats to be used in the HumanValidatedMistakeDetectionFormats class. */
  private static String formatMistakeDetectionFormatsForJava(Map<MistakeTypeInfo, MistakeDetectionFormat> mapping,
      boolean filterNumberedMdfs) {
    // eg, entry(ATTRIBUTE_DUPLICATED, mdf(List.of("attr"), List.of()))
    return mapping.entrySet().stream()
        .map(e -> "entry(" + underscorify(e.getKey().mistakeType.getName()).toUpperCase() + ", mdf"
            + e.getValue().toString().replace("[", "List.of(").replace("]", ")") + ")")
        .filter(s -> !(filterNumberedMdfs && s.matches(".*\\d.*"))).collect(Collectors.joining(",\n"));
  }

}
