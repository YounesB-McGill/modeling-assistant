package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.emf.ecore.EClass;
import learningcorpus.MistakeType;
import modelingassistant.Mistake;
import modelingassistant.SolutionElement;

public class MappingToCdmMetatypes extends MistakeDetectionInformationService {

  private MappingToCdmMetatypes() {
    super("Mistake type mapping to instructor/student CDM elements");
  }

  @Override public String getOutput() {
    return title(name) + "\n" + getCdmMetatypeMappingAsCsv(mapMistakesToCdmMetatypes(instructorAndStudentElems));
  }

  public static MappingToCdmMetatypes get() {
    return new MappingToCdmMetatypes();
  }

  /** Maps comparison mistakes to CDM metatypes. */
  public static Map<MistakeType, Set<SimpleImmutableEntry<EClass, Boolean>>> mapMistakesToCdmMetatypes(
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer) {
    return mapAllMistakesTo(mistakeSolutionElementsStreamer, e ->
        new SimpleImmutableEntry<>(e.getElement().eClass(), hasStudent(e)));
  }

  /**
   * Returns the mapping of comparison mistakes to CDM metatypes in a CSV-compatible format.
   * The format of each row is as follows:<br>
   *
   * {@code mistakeType.name: type1, type2, ...}
   */
  public static String getCdmMetatypeMappingAsCsv(
      Map<MistakeType, ? extends Collection<SimpleImmutableEntry<EClass, Boolean>>> mapping) {
    return mapping.entrySet().stream().map(e ->
        e.getKey().getName() + ": " + String.join(", ", e.getValue().stream()
            .map(p -> (p.getValue() ? "Student" : "Instructor") + " " + p.getKey().getName())
            .collect(Collectors.toUnmodifiableList()))).collect(Collectors.joining("\n"));
  }

}
