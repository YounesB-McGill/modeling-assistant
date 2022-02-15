package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.ElementDescription;
import learningcorpus.MistakeType;
import modelingassistant.Mistake;
import modelingassistant.SolutionElement;

public class MappingToElementDescriptions extends MistakeDetectionInformationService {

  private MappingToElementDescriptions() {
    super("Mistake type mapping to instructor/student solution element descriptions");
  }

  @Override public String getOutput() {
    return title(name) + "\n"
        + getLearningCorpusElementDescriptionMappingAsCsv(mapMistakesToElementDescriptions(instructorAndStudentElems));
  }

  public static MappingToElementDescriptions get() {
    return new MappingToElementDescriptions();
  }

  /** Maps comparison mistakes to element descriptions. */
  public static Map<MistakeType, Set<ElementDescription>> mapMistakesToElementDescriptions(
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer) {
    return mapMistakesTo(allMistakesLimitOneOfEachType(), mistakeSolutionElementsStreamer,
        ElementDescription::fromElement);
  }

  /**
   * Returns the mapping of comparison mistakes to learning corpus ElementTypes in a CSV-compatible format.
   * The format of each row is as follows:<br>
   *
   * {@code mistakeType.name: type1, type2, ...}
   */
  public static String getLearningCorpusElementDescriptionMappingAsCsv(
      Map<MistakeType, ? extends Collection<ElementDescription>> mapping) {
    return mapping.entrySet().stream().map(e ->
        e.getKey().getName() + ": " + String.join(", ", e.getValue().stream().map(ElementDescription::toString)
            .collect(Collectors.toUnmodifiableList()))).collect(Collectors.joining("\n"));
  }

}
