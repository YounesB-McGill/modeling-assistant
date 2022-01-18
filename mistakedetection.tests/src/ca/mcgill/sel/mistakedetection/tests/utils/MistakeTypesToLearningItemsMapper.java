package ca.mcgill.sel.mistakedetection.tests.utils;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.emf.ecore.EClass;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import ca.mcgill.sel.mistakedetection.Comparison;
import ca.mcgill.sel.mistakedetection.MistakeDetectionConfig;
import learningcorpus.MistakeType;
import modelingassistant.Mistake;
import modelingassistant.SolutionElement;

/**
 * Class to map learning corpus mistake types to learning items.
 *
 * @author Younes Boubekeur
 */
public class MistakeTypesToLearningItemsMapper {

  // Helper Functions to map each mistake to specific solution elements
  static Function<Mistake, Stream<SolutionElement>> instructorElems = m -> m.getInstructorElements().stream();
  static Function<Mistake, Stream<SolutionElement>> studentElems = m -> m.getStudentElements().stream();
  static Function<Mistake, Stream<SolutionElement>> instructorAndStudentElems = m ->
      Stream.concat(instructorElems.apply(m), studentElems.apply(m));

  public static void main(String[] args) {
    MistakeDetectionConfig.trackComparisonsInstances = true;
    runAllMistakeDetectionTests();

    System.out.println(getMappingAsCsv(mapComparisonMistakesToCdmMetatypes(instructorAndStudentElems)));
  }

  /** Runs all the mistake detection tests. */
  public static void runAllMistakeDetectionTests() {
    var request = LauncherDiscoveryRequestBuilder.request()
        .selectors(selectPackage("ca.mcgill.sel.mistakedetection.tests")).build();
    var launcher = LauncherFactory.create();
    launcher.discover(request);
    var listener = new SummaryGeneratingListener();
    launcher.registerTestExecutionListeners(listener);
    launcher.execute(request);
    var summary = listener.getSummary();
    summary.printTo(new PrintWriter(System.out));
    if (summary.getTotalFailureCount() > 0) {
      throw new RuntimeException("Cannot map mistake types because one or more Mistake Detection tests failed.");
    }
  }

  /** Maps comparison mistakes to CDM metatypes. */
  public static Map<MistakeType, Set<EClass>> mapComparisonMistakesToCdmMetatypes(
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer) {
    return Comparison.instances.stream().map(comp -> comp.newMistakes).flatMap(List::stream)
        .collect(Collectors.toMap(Mistake::getMistakeType,
            m -> mistakeSolutionElementsStreamer.apply(m).map(e -> e.getElement().eClass())
                .collect(Collectors.toUnmodifiableSet()), // TODO Update on Java 17+
            (v1, v2) -> Stream.of(v1, v2).flatMap(Set::stream).collect(Collectors.toUnmodifiableSet()),
            TreeMap::new)); // use TreeMap to sort output by mistake type
  }

  /**
   * Returns the mapping of comparison mistakes to CDM metatypes in a CSV-compatible format.
   * The format of each row is as follows:<br>
   *
   * {@code mistakeType.name: type1, type2, ...}
   */
  public static String getMappingAsCsv(Map<MistakeType, Set<EClass>> mapping) {
    return mapping.entrySet().stream().map(e ->
        e.getKey().getName() + ": " + String.join(", ", e.getValue().stream().map(EClass::getName)
            .collect(Collectors.toUnmodifiableList()))).collect(Collectors.joining("\n"));
  }

}
