package ca.mcgill.sel.mistakedetection.tests.utils;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import ca.mcgill.sel.mistakedetection.MistakeDetectionConfig;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.ColorDemo;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.MappingToCdmMetatypes;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.MappingToElementDescriptions;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.MappingToLearningCorpusElementTypes;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.MappingToMistakeDetectionFormats;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.MappingToMistakeDetectionFormatsForPython;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.MappingToMistakeInfos;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.MistakeDetectionFormatComparison;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.MistakeDetectionInformationService;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.SourceTargetVerifier;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.SuggestedParametrizedResponses;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.SuggestedParametrizedResponsesForJava;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.TestCompletion;

/**
 * Leverages the Mistake Detection tests to extract and log useful information about learning corpus items such as
 * mistake types. Running this file will output useful statistics about the mistake detection system, its tests, and how
 * mistake types map to various solution elements.<br><br>
 *
 * Design principles used for these classes:
 *
 * <ul>
 *   <li>Use the (functional) pipeline design pattern to transform items in a collection</li>
 *   <li>Use short helper functions that can be composed to perform something useful</li>
 *   <li>Separation of logic (eg, mapMistakesToLearningCorpusElementTypes) and presentation (eg, get...AsCsv)</li>
 *   <li>Only one print statement in entire program (excluding debug prints), everywhere else strings should be
 *       accumulated instead</li>
 * </ul>
 *
 * @author Younes Boubekeur
 */
public class MistakeDetectionInformationServicesForLearningCorpus {

  /** The maximum allowed line length in generated source code. */
  public static final int MAX_LINE_LENGTH = 120;

  static final boolean USE_COLOR_OUTPUT = true;

  // Run the mistake detection tests in a static block to allow other classes to get data from this one
  static {
    MistakeDetectionConfig.trackComparisonInstances = true;
    runAllMistakeDetectionTests();
  }


  public static void main(String[] args) {
    // Uncomment the items that you want to be output
    var outputs = Stream.of(
        ColorDemo.get(),
        TestCompletion.get(),
        MappingToCdmMetatypes.get(),
        MappingToElementDescriptions.get(),
        MappingToMistakeInfos.get(),
        SourceTargetVerifier.get(),
        MappingToMistakeDetectionFormats.get(),
        SuggestedParametrizedResponsesForJava.get(),
        SuggestedParametrizedResponses.get(),
        MappingToMistakeDetectionFormatsForPython.get(),
        PythonLearningCorpusInitializationCode.get()
        ).map(MistakeDetectionInformationService::getOutput);

    System.out.println(outputs.collect(Collectors.joining("\n\n")));
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
      throw new RuntimeException("Cannot perform operation because one or more Mistake Detection tests failed. "
          + "Fix or disable test(s) and try again.");
    }
  }

  /** Debug print function. It can be added to a Stream with {@code .map(MDIS4LC::debugPrint)}. */
  static <T> T debugPrint(T t) {
    System.out.println(t);
    return t;
  }

  /** Prints non-fatal warning to console in orange. */
  public static <T> T warn(T t) {
    System.out.println(Color.warn(t));
    return t;
  }

}
