package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import learningcorpus.ElementType;
import learningcorpus.MistakeType;

public class MappingToLearningCorpusElementTypes extends MistakeDetectionInformationService {

  private MappingToLearningCorpusElementTypes() {
    super("Mistake type mapping to learning corpus ElementTypes");
  }

  @Override public String getOutput() {
    return title(name) + "\n"
        + getLearningCorpusElementTypeMappingAsCsv(mapMistakesToLearningCorpusElementTypes(instructorAndStudentElems));
  }

  public static MappingToLearningCorpusElementTypes get() {
    return new MappingToLearningCorpusElementTypes();
  }

  /**
   * Returns the mapping of comparison mistakes to learning corpus ElementTypes in a CSV-compatible format.
   * The format of each row is as follows:<br>
   *
   * {@code mistakeType.name: type1, type2, ...}
   */
  public static String getLearningCorpusElementTypeMappingAsCsv(
      Map<MistakeType, ? extends Collection<ElementType>> mapping) {
    return mapping.entrySet().stream().map(e ->
    e.getKey().getName() + ": " + String.join(", ", e.getValue().stream().map(ElementType::getName)
        .collect(Collectors.toUnmodifiableList()))).collect(Collectors.joining("\n"));
  }

}
