package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import learningcorpus.MistakeType;

public class SuggestedParametrizedResponses extends MistakeDetectionInformationService {

  public SuggestedParametrizedResponses() {
    super("Suggested Parametrized Responses");
  }

  @Override public String getOutput() {
    return title(name) + "\n" + formatSuggestedParametrizedResponses(suggestedParametrizedResponses);
  }

  public static SuggestedParametrizedResponses get() {
    return new SuggestedParametrizedResponses();
  }

  private static String formatSuggestedParametrizedResponses(Map<MistakeType, Set<String>> mapping) {
    return mapping.entrySet().stream().map(e -> e.getKey().getName() + ":\n" + String.join("\n", e.getValue()))
        .collect(Collectors.joining("\n\n"));
  }

}
