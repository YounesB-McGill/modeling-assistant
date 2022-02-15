package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedParametrizedResponses;
import learningcorpus.MistakeType;

public class SuggestedParametrizedResponsesForJava extends MistakeDetectionInformationService {

  public SuggestedParametrizedResponsesForJava() {
    super("Parametrized Responses for human verification (use to update HumanValidatedParametrizedResponses)");
  }

  @Override public String getOutput() {
    return title(name) + "\n" + formatParametrizedResponsesForJava(suggestedParametrizedResponses);
  }

  public static SuggestedParametrizedResponsesForJava get() {
    return new SuggestedParametrizedResponsesForJava();
  }

  private static String formatParametrizedResponsesForJava(Map<MistakeType, Set<String>> mapping) {
    // eg, entry(PLURAL_ATTRIBUTE, Set.of("The ${inst_attr} attribute should be singular."))
    return mapping.entrySet().stream()
        .filter(e -> !HumanValidatedParametrizedResponses.mappings.containsKey(e.getKey()))
        .map(e -> "entry(" + underscorify(e.getKey().getName()).toUpperCase() + ", Set.of(\""
            + String.join("\",\n    \"", e.getValue()) + "\"))")
        .collect(Collectors.joining(",\n"));
  }

}
