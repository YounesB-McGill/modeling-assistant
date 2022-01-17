package ca.mcgill.sel.mistakedetection.tests.utils;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import ca.mcgill.sel.mistakedetection.Comparison;
import ca.mcgill.sel.mistakedetection.MistakeDetectionConfig;
import modelingassistant.Mistake;

/**
 *
 * @author Younes Boubekeur
 */
public class MistakeTypesToLearningItemsMapper {

  public static void main(String[] args) {
    MistakeDetectionConfig.trackComparisonsInstances = true;
    runAllMistakeDetectionTests();
    handleComparisonInstances().forEach(System.out::println);
  }

  public static void runAllMistakeDetectionTests() {
    LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
        .selectors(selectPackage("ca.mcgill.sel.mistakedetection.tests")).build();
    Launcher launcher = LauncherFactory.create();
    launcher.discover(request);
    SummaryGeneratingListener listener = new SummaryGeneratingListener();
    launcher.registerTestExecutionListeners(listener);
    launcher.execute(request);

    TestExecutionSummary summary = listener.getSummary();
    summary.printTo(new PrintWriter(System.out));
  }

  public static List<Object> handleComparisonInstances() {
    return Comparison.instances.stream().map(comp -> comp.newMistakes).map(mistakes -> mistakes.stream()
        .collect(Collectors.toMap(Mistake::getMistakeType,
            m -> Stream.concat(m.getInstructorElements().stream(), m.getStudentElements().stream())
                .map(e -> e.getElement().eClass())
                .collect(toList()),
            (k1, k2) -> k2))).collect(toList()); // TODO Make more concise after migrating to Java 17+
  }

  private static Collector<Object, ?, List<Object>> toList() {
    return Collectors.toUnmodifiableList();
  }

}
