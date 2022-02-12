package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;
import static ca.mcgill.sel.mistakedetection.tests.utils.MistakeDetectionInformationServicesForLearningCorpus.MAX_LINE_LENGTH;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import ca.mcgill.sel.mistakedetection.Comparison;
import learningcorpus.MistakeType;
import modelingassistant.Mistake;

public abstract class MistakeDetectionInformationService {

  private static final String ERROR = "This method must be treated as abstract and can only be invoked on a subclass! "
      + "If a subclass is defined, ensure it overrides this method.";

  public final String name;

  public MistakeDetectionInformationService(String name) {
    this.name = name;
  }

  public abstract String getOutput();

  /**
   * Returns an instance of this class. Subclasses must override this method without the annotation since it is static.
   */
  public static /*abstract*/ MistakeDetectionInformationService get() {
    uoe();
    return null;
  }

  /** Return the string surrounded with hashes as a title for logging purposes. */
  public static String title(String s) {
    if (s.length() + 2 > MAX_LINE_LENGTH) {
      return "\n# " + s + "\n";
    } else {
      var hashes = "#".repeat(((MAX_LINE_LENGTH - s.length() - 2) / 2));
      var extraHash = "#".repeat(s.length() % 2); // for inputs of odd length
      return "\n" + hashes + " " + s + " " + hashes + extraHash + "\n";
    }
  }

  /**
   * Returns all the mistakes from all comparison objects created during the mistake detection tests as a flat stream,
   * useful for iteration.
   */
  public static Stream<Mistake> allMistakes() {
    return Comparison.instances.stream().map(comp -> comp.newMistakes).flatMap(List::stream);
  }

  /**
   * Returns all the mistakes from all comparison objects created during the mistake detection tests as a flat stream,
   * useful for iteration.
   */
  public static Stream<Mistake> allMistakesLimitOneOfEachType() {
    final Set<MistakeType> seen = new HashSet<>();
    return Comparison.instances.stream().map(comp -> comp.newMistakes).flatMap(List::stream)
        .filter(m -> seen.add(m.getMistakeType()));
  }

  /** Needed to get around Java compiler limitations. */
  private static void uoe() {
    throw new UnsupportedOperationException(ERROR);
  }

}
