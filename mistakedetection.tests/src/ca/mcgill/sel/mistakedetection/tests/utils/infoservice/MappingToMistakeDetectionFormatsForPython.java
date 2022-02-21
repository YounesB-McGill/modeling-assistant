package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import static ca.mcgill.sel.mistakedetection.tests.utils.MistakeDetectionInformationServicesForLearningCorpus.MAX_LINE_LENGTH;
import java.util.Map;
import java.util.stream.Collectors;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeDetectionFormat;
import learningcorpus.MistakeType;

public class MappingToMistakeDetectionFormatsForPython extends MistakeDetectionInformationService {

  public MappingToMistakeDetectionFormatsForPython() {
    super("Suggested MistakeDetectionFormats (use in Python corpus definition)");
  }

  @Override public String getOutput() {
    return title(name) + "\n" + formatMistakeDetectionFormatsForPython(suggestedMistakeDetectionFormats, true);
  }

  public static MappingToMistakeDetectionFormatsForPython get() {
    return new MappingToMistakeDetectionFormatsForPython();
  }

  /** Format the MistakeDetectionFormats to be used in the Python corpus definition. */
  private static String formatMistakeDetectionFormatsForPython(Map<MistakeType, MistakeDetectionFormat> mapping,
      boolean filterNumberedMdfs) {
    // eg, missing_class.md_format = mdf([], ["cls"])
    return mapping.entrySet().stream().map(e -> {
      var name = underscorify(e.getKey().getName());
      var decl = name + ".md_format = mdf" + e.getValue();
      if (decl.length() <= MAX_LINE_LENGTH) {
        return decl;
      }
      return name + ".md_format = mdf(\n    " + e.getValue().toString().replaceFirst("\\(", "");
    }).filter(s -> !(filterNumberedMdfs && s.matches(".*\\d.*"))).collect(Collectors.joining("\n"));
  }

}
