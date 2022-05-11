package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import static learningcorpus.mistaketypes.MistakeTypes.BAD_ASSOCIATION_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_N_ARY_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.GENERALIZATION_INAPPLICABLE;
import static learningcorpus.mistaketypes.MistakeTypes.INHERITED_FEATURE_DOES_NOT_MAKE_SENSE_FOR_SUBCLASS;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE_TYPE;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_N_ARY_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_IS_AN_INSTANCE_OF_SUPERCLASS;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_NOT_DISTINCT_ACROSS_LIFETIME;
import static learningcorpus.mistaketypes.MistakeTypes.USING_BINARY_ASSOC_INSTEAD_OF_N_ARY_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_INTERMEDIATE_CLASS_INSTEAD_OF_N_ARY_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_N_ARY_ASSOC_INSTEAD_OF_BINARY_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_N_ARY_ASSOC_INSTEAD_OF_INTERMEDIATE_CLASS;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import learningcorpus.MistakeType;
import learningcorpus.mistaketypes.MistakeTypes;

public class TestCompletion extends MistakeDetectionInformationService {

  /** Indicates the completion state for each test in the mistakedetection.tests suite. */
  private enum TestCompletionStatus {
    // In chronological order: a mistake type starts as future work, then it is in progress and finally done
    FUTURE_WORK("X"), IN_PROGRESS("►"), DONE("√"); // ASCII-compatible symbols

    String symbol;
    TestCompletionStatus(String symbol) {
      this.symbol = symbol;
    }
    String getFormattedName() {
      var name = toString();
      return name.substring(0, 1) + name.substring(1, name.length()).replace("_", " ").toLowerCase();
    }
  }

  /** Mistake types which are planned to be implemented in the future. */
  private static final Set<MistakeType> FUTURE_WORK_MISTAKE_TYPES = Set.of(
      BAD_ASSOCIATION_NAME_SPELLING,
      EXTRA_N_ARY_ASSOCIATION,
      GENERALIZATION_INAPPLICABLE,
      INHERITED_FEATURE_DOES_NOT_MAKE_SENSE_FOR_SUBCLASS,
      MISSING_ASSOCIATION_NAME,
      MISSING_ATTRIBUTE_TYPE,
      MISSING_MULTIPLICITY,
      MISSING_N_ARY_ASSOCIATION,
      SUBCLASS_IS_AN_INSTANCE_OF_SUPERCLASS,
      SUBCLASS_NOT_DISTINCT_ACROSS_LIFETIME,
      USING_BINARY_ASSOC_INSTEAD_OF_N_ARY_ASSOC,
      USING_INTERMEDIATE_CLASS_INSTEAD_OF_N_ARY_ASSOC,
      USING_N_ARY_ASSOC_INSTEAD_OF_BINARY_ASSOC,
      USING_N_ARY_ASSOC_INSTEAD_OF_INTERMEDIATE_CLASS);

  private TestCompletion() {
    super("Mistake Detection test completion status");
  }

  @Override public String getOutput() {
    var testCompletionStatusByMistakeType = getTestCompletionStatusByMistakeType();
    return title(name) + "\n" + formattedTestCompletionStatusLegend() + "\n\n"
        + getFormattedTestCompletionStatus(testCompletionStatusByMistakeType) + "\n\n"
        + overallTestCompletionStatistics(testCompletionStatusByMistakeType);
  }

  public static TestCompletion get() {
    return new TestCompletion();
  }

  private static String formattedTestCompletionStatusLegend() {
    return "Legend: " + Arrays.stream(TestCompletionStatus.values()).map(s ->
        s.symbol + " - " + s.getFormattedName()).collect(Collectors.joining(", "));
  }

  private static String overallTestCompletionStatistics(Map<MistakeType, TestCompletionStatus> mistakeTypesToStatuses) {
    return "Summary:\n" + Arrays.stream(TestCompletionStatus.values()).map(s ->
        s.symbol + " " + Collections.frequency(mistakeTypesToStatuses.values(), s) + " " + s.getFormattedName())
        .collect(Collectors.joining("\n")) + "\nTotal: " + mistakeTypesToStatuses.size();
  }

  /** Returns a mapping from mistake types to their test completion status. */
  public static Map<MistakeType, TestCompletionStatus> getTestCompletionStatusByMistakeType() {
    var doneMistakeTypes = allMistakeInfos().map(mi -> mi.mistakeType).collect(Collectors.toUnmodifiableSet());
    return MistakeTypes.MISTAKE_TYPES_BY_NAME.values().stream().collect(Collectors.toMap(
        Function.identity(), // mistakeType -> mistakeType
        mt -> doneMistakeTypes.contains(mt) ? TestCompletionStatus.DONE : (FUTURE_WORK_MISTAKE_TYPES.contains(mt) ?
            TestCompletionStatus.FUTURE_WORK : TestCompletionStatus.IN_PROGRESS),
        (v1, v2) -> TestCompletionStatus.values()[Math.min(v1.ordinal(), v2.ordinal())],
        TreeMap::new));
  }

  /** Returns the test completion status formatted for logging purposes. */
  public static String getFormattedTestCompletionStatus(Map<MistakeType, TestCompletionStatus> mistakeTypesToStatuses) {
    return mistakeTypesToStatuses.entrySet().stream().map(e -> e.getValue().symbol + " " + e.getKey().getDescription())
        .collect(Collectors.joining("\n"));
  }

  /** Returns the tests with the given completion status formatted for logging purposes. */
  public static String getFormattedTestCompletionStatus(Map<MistakeType, TestCompletionStatus> mistakeTypesToStatuses,
      TestCompletionStatus status) {
    return mistakeTypesToStatuses.entrySet().stream().filter(e -> e.getValue() == status)
        .map(e -> e.getValue().symbol + " " + e.getKey().getDescription())
        .collect(Collectors.joining("\n"));
  }

}
