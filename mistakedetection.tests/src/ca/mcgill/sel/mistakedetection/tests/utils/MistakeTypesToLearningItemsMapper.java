package ca.mcgill.sel.mistakedetection.tests.utils;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
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

/**
 * Class to map learning corpus mistake types to learning items.
 *
 * @author Younes Boubekeur
 */
public class MistakeTypesToLearningItemsMapper {

  public static void main(String[] args) {
    MistakeDetectionConfig.trackComparisonsInstances = true;
    runAllMistakeDetectionTests();
    handleComparisonInstances().forEach(map -> {
      map.forEach((mistake, elems) -> {
        System.out.print(mistake.getName() + ": ");
        elems.forEach(e -> System.out.print(e.getName() + ", "));
        System.out.println();
      });
    });

  }

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

  public static List<Map<MistakeType, List<EClass>>> handleComparisonInstances() {
    return Comparison.instances.stream().map(comp -> comp.newMistakes).map(mistakes -> mistakes.stream()
        .collect(Collectors.toMap(Mistake::getMistakeType,
            m -> Stream.concat(m.getInstructorElements().stream(), m.getStudentElements().stream())
                .map(e -> e.getElement().eClass())
                .collect(Collectors.toUnmodifiableList()),
            (k1, k2) -> k2))).collect(Collectors.toUnmodifiableList()); // TODO Make more concise after move to Java 17+
  }

}
