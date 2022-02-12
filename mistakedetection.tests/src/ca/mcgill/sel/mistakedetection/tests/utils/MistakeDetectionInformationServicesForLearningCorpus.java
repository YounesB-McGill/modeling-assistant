package ca.mcgill.sel.mistakedetection.tests.utils;

import static ca.mcgill.sel.mistakedetection.tests.utils.Color.colorString;
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
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import java.io.PrintWriter;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.emf.ecore.EClass;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.CdmFactory;
import ca.mcgill.sel.classdiagram.ReferenceType;
import ca.mcgill.sel.mistakedetection.Comparison;
import ca.mcgill.sel.mistakedetection.MistakeDetectionConfig;
import learningcorpus.ElementType;
import learningcorpus.MistakeType;
import learningcorpus.ParametrizedResponse;
import learningcorpus.mistaketypes.MistakeTypes;
import modelingassistant.Mistake;
import modelingassistant.SolutionElement;

/**
 * Leverages the Mistake Detection tests to extract and log useful information about learning corpus items such as
 * mistake types. Running this file will output useful statistics about the mistake detection system, its tests, and how
 * mistake types map to various solution elements.<br><br>
 *
 * Design principles used for this class:
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

  /** Shorthand for CdmFactory.eINSTANCE. */
  private static final CdmFactory CDF = CdmFactory.eINSTANCE;

  /** Map of CDM metatypes to learning corpus ElementTypes. */
  public static final Map<EClass, ElementType> cdmMetatypesToLearningCorpusElementTypes = Map.of(
      CDF.createAssociationEnd().eClass(), ElementType.ASSOCIATION_END,
      CDF.createAttribute().eClass(), ElementType.ATTRIBUTE,
      CDF.createCDEnum().eClass(), ElementType.CLASS,
      CDF.createCDEnumLiteral().eClass(), ElementType.CLASS,
      CDF.createClass().eClass(), ElementType.CLASS);

  // Helper Functions to map each mistake to specific solution elements
  static final Function<Mistake, Stream<SolutionElement>> instructorElems = m -> m.getInstructorElements().stream();
  static final Function<Mistake, Stream<SolutionElement>> studentElems = m -> m.getStudentElements().stream();
  static final Function<Mistake, Stream<SolutionElement>> instructorAndStudentElems = m ->
      Stream.concat(instructorElems.apply(m), studentElems.apply(m));

  /** The maximum allowed line length in generated source code. */
  private static final int MAX_LINE_LENGTH = 120;

  static final boolean USE_COLOR_OUTPUT = true;

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


  // Run the mistake detection tests in a static block to allow other classes to get data from this one
  static {
    MistakeDetectionConfig.trackComparisonInstances = true;
    runAllMistakeDetectionTests();
  }


  public static void main(String[] args) {
    var testCompletionStatusByMistakeType = getTestCompletionStatusByMistakeType();
    var pythonLearningCorpusInitializationCode = generatePythonLearningCorpusInitializationCode();
    var suggestedMistakeDetectionFormats = suggestMistakeDetectionFormats();

    // Uncomment the lines that you want to be output
    String[] outputs = {
      title("Color output demo (requires ANSI escaping)"),
      Color.demo(),

      title("Mistake Detection test completion status"),
      formattedTestCompletionStatusLegend(),
      getFormattedTestCompletionStatus(testCompletionStatusByMistakeType),
      overallTestCompletionStatistics(testCompletionStatusByMistakeType),

      // title("Mistake type mapping to instructor/student CDM elements"),
      // getCdmMetatypeMappingAsCsv(mapMistakesToCdmMetatypes(instructorElems)),
      // getCdmMetatypeMappingAsCsv(mapMistakesToCdmMetatypes(studentElems)),
      // getCdmMetatypeMappingAsCsv(mapMistakesToCdmMetatypes(instructorAndStudentElems)),

      // title("Mistake type mapping to instructor/student solution element descriptions"),
      // getLearningCorpusElementDescriptionMappingAsCsv(mapMistakesToElementDescriptions(instructorAndStudentElems)),

      title("MistakeInfo statistics for each detected mistake"),
      mistakeTypeElementVsParametrizedStringStatistics(mapToMistakeInfos()),

      // title("Mistake type mapping to learning corpus ElementTypes"),
      // getLearningCorpusElementTypeMappingAsCsv(mapMistakesToLearningCorpusElementTypes(instructorElems)),
      // getLearningCorpusElementTypeMappingAsCsv(mapMistakesToLearningCorpusElementTypes(studentElems)),
      // getLearningCorpusElementTypeMappingAsCsv(mapMistakesToLearningCorpusElementTypes(instructorAndStudentElems)),

      title("MistakeDetectionFormats for human verification (use to update HumanValidatedMistakeDetectionFormats)"),
      formatMistakeDetectionFormatsForJava(suggestedMistakeDetectionFormats, true),

      title("Parametrized Responses for human verification (use to update HumanValidatedParametrizedResponses)"),
      formatParametrizedResponsesForJava(suggestParametrizedResponses(suggestedMistakeDetectionFormats, true)),

      title("Suggested Parametrized Responses"),
      formatSuggestedParametrizedResponses(suggestParametrizedResponses(suggestedMistakeDetectionFormats, true)),

      title("Suggested MistakeDetectionFormats (use in Python corpus definition)"),
      formatMistakeDetectionFormatsForPython(suggestedMistakeDetectionFormats, true),

      // title("Python learning corpus initialization code (imports/learning items)"),
      // pythonLearningCorpusInitializationCode.imports,
      // pythonLearningCorpusInitializationCode.learningItems,
    };

    System.out.println(String.join("\n\n", outputs));
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

  /** Returns a mapping from mistake types to their test completion status. */
  public static Map<MistakeType, TestCompletionStatus> getTestCompletionStatusByMistakeType() {
    var doneMistakeTypes = allMistakes().map(Mistake::getMistakeType).collect(Collectors.toUnmodifiableSet());
    return MistakeTypes.MISTAKE_TYPES_BY_NAME.values().stream().collect(Collectors.toMap(
        // Collectors.toMap() can take these 4 inputs when invoked on a stream of items (in this case, mistake types):
        // 1. Function to map the items to the keys of the output map. Here we map each mistake type to itself.
        Function.identity(), // mistakeType -> mistakeType
        // 2. Function to map the items to the values of the output map. Here we map each MT to a TestCompletionStatus.
        mt -> doneMistakeTypes.contains(mt) ? TestCompletionStatus.DONE : (FUTURE_WORK_MISTAKE_TYPES.contains(mt) ?
            TestCompletionStatus.FUTURE_WORK : TestCompletionStatus.IN_PROGRESS),
        // 3. Merge function, handles collisions between values with the same key. Here, use older status if in doubt.
        (v1, v2) -> TestCompletionStatus.values()[Math.min(v1.ordinal(), v2.ordinal())],
        // 4. The output map of Collectors.toMap(). Use TreeMap to sort output by mistake type.
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

  /** Maps comparison mistakes to CDM metatypes. */
  public static Map<MistakeType, Set<SimpleImmutableEntry<EClass, Boolean>>> mapMistakesToCdmMetatypes(
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer) {
    return mapAllMistakesTo(mistakeSolutionElementsStreamer, e ->
        new SimpleImmutableEntry<>(e.getElement().eClass(), hasStudent(e)));
  }

  /** Maps comparison mistakes to element descriptions. */
  public static Map<MistakeType, Set<ElementDescription>> mapMistakesToElementDescriptions(
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer) {
    return mapMistakesTo(allMistakesLimitOneOfEachType(), mistakeSolutionElementsStreamer,
        ElementDescription::fromElement);
  }

  /** Maps comparison mistakes to MistakeInfo instances. */
  public static Map<MistakeType, Set<MistakeInfo>> mapToMistakeInfos() {
    return allMistakes().collect(Collectors.toMap(
        m -> m.getMistakeType(),
        m -> Set.of(new MistakeInfo(m)),
        MDIS4LC::setUnion,
        TreeMap::new));
  }

  /** Maps comparison mistakes to learning corpus ElementTypes. */
  public static Map<MistakeType, Set<ElementType>> mapMistakesToLearningCorpusElementTypes(
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer) {
    return mapAllMistakesTo(mistakeSolutionElementsStreamer, e ->
        cdmMetatypesToLearningCorpusElementTypes.getOrDefault(e.getElement().eClass(),
            // assume for now that all input metatypes are either in map or association instances
            e.getElement() instanceof Association ?
                (cdmAssociationIs((Association) e.getElement(), ReferenceType.COMPOSITION) ?
                    ElementType.COMPOSITION : ElementType.ASSOCIATION) : null)); // can't easily detect inheritance here
  }

  /** Generates Pyecore-compatible code to generate the learning corpus. This can be improved. */
  public static PythonLearningCorpusInitializationCode generatePythonLearningCorpusInitializationCode() {
    var mistakesToTypes = mapMistakesToLearningCorpusElementTypes(instructorAndStudentElems);
    var typesToMistakes = new TreeMap<ElementType, Set<MistakeType>>();
    mistakesToTypes.forEach((m, types) -> types.forEach(t -> {
      if (typesToMistakes.containsKey(t)) {
        typesToMistakes.get(t).add(m);
      } else {
        typesToMistakes.put(t, new HashSet<>(List.of(m)));
      }
    }));
    var imports = new StringBuilder(
        "from corpus_definition import (corpus as corpus_def, mts_by_priority as mts_by_priority_def, ");
    var learningItems = new StringBuilder();
    typesToMistakes.forEach((t, mistakes) -> {
      learningItems.append(underscorify(t.getName()).replace("class", "class_") + " = LearningItem(name=\""
          + t.getName().replaceAll("\\s+", "") + "\", learningCorpus=corpus, mistakeTypes=[\n    ");
      mistakes.forEach(mistake -> {
        var m = underscorify(mistake.getName());
        if (learningItems.length() - learningItems.lastIndexOf("\n") + m.length() + 2 <= MAX_LINE_LENGTH) {
          learningItems.append(m + ", "); // MAX_LINE_LENGTH not exceeded, so append to same line
        } else {
          learningItems.deleteCharAt(learningItems.lastIndexOf(" ")).append("\n    " + m + ", "); // append to next line
        }
        if (imports.indexOf(m + ",") == -1) { // not found according to StringBuilder API
          if (imports.length() - imports.lastIndexOf("\n") + m.length() + 2 <= MAX_LINE_LENGTH) {
            imports.append(m + ", ");
          } else {
            imports.deleteCharAt(imports.lastIndexOf(" ")).append("\n    " + m + ", ");
          }
        }
      });
      learningItems.deleteCharAt(learningItems.lastIndexOf(",")).deleteCharAt(learningItems.lastIndexOf(" "))
          .append("])\n");
    });
    imports.deleteCharAt(imports.lastIndexOf(",")).deleteCharAt(imports.lastIndexOf(" ")).append(")\n");
    return new PythonLearningCorpusInitializationCode(imports.toString(), learningItems.toString());
  }

  /** Suggests mistake detection formats based on the output of the mistake detection tests. */
  static Map<MistakeType, MistakeDetectionFormat> suggestMistakeDetectionFormats() {
    return suggestAllMistakeDetectionFormats().entrySet().stream().collect(Collectors.toMap(
        e -> e.getKey().getMistakeType(),
        Map.Entry::getValue,
        (mdf1, mdf2) -> {
          if (mdf1.inst.size() <= mdf2.inst.size() && mdf1.stud.size() <= mdf2.stud.size()) {
            return mdf2;
          } else if (mdf1.inst.size() >= mdf2.inst.size() && mdf1.stud.size() >= mdf2.stud.size()) {
            return mdf1;
          }
          warn("Encountered 2 MistakeDetectionFormats with incompatible numbers of instructor and student elements, "
              + "returning most recent: " + mdf2);
          return mdf2;
        },
        TreeMap::new));
  }

  private static Map<Mistake, MistakeDetectionFormat> suggestAllMistakeDetectionFormats() {
    return allMistakes().collect(Collectors.toMap(Function.identity(), MistakeDetectionFormat::forMistake));
  }

  static Map<MistakeType, Set<String>> suggestParametrizedResponses(
      Map<MistakeType, MistakeDetectionFormat> mapping, boolean filterNumberedMdfs) {
    return mapping.entrySet().stream()
        .filter(e -> !filterNumberedMdfs || (e.getValue().stud.size() <= 1 && e.getValue().inst.size() <= 1))
        .collect(Collectors.toMap(Map.Entry::getKey,
            MDIS4LC::parametrizeResponses,
            MDIS4LC::setUnion,
            TreeMap::new));
  }

  /** Parametrize all responses for the entry's mistake type. */
  static Set<String> parametrizeResponses(Map.Entry<MistakeType, MistakeDetectionFormat> entry) {
    if (HumanValidatedParametrizedResponses.mappings.containsKey(entry.getKey())) {
      return HumanValidatedParametrizedResponses.mappings.get(entry.getKey());
    }
    return entry.getKey().getFeedbacks().stream().filter(fb -> fb instanceof ParametrizedResponse)
        .map(fb -> parametrizeResponse((ParametrizedResponse) fb, entry.getValue()))
        .collect(Collectors.toUnmodifiableSet());
  }

  private static String parametrizeResponse(ParametrizedResponse pr, MistakeDetectionFormat mdf) {
    var result = pr.getText();
    final var matcher = Pattern.compile("\\$\\{(?<param>.*?)\\}").matcher(result);
    if (mdf.stud.size() == 1 && mdf.inst.isEmpty()) {
      result = matcher.replaceFirst(Matcher.quoteReplacement("${stud_" + mdf.stud.get(0) + "}"));
    } else if (mdf.stud.isEmpty() && mdf.inst.size() == 1) {
      result = matcher.replaceFirst(Matcher.quoteReplacement("${inst_" + mdf.inst.get(0) + "}"));
    } else if (mdf.stud.size() == 1 && mdf.inst.size() == 1) {
      result = matcher.replaceFirst(Matcher.quoteReplacement("${stud_" + mdf.stud.get(0) + "}"));
      result = matcher.replaceFirst(Matcher.quoteReplacement("${inst_" + mdf.inst.get(0) + "}"));
    }
    return result;
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

  /** Return the string surrounded with hashes as a title for logging purposes. */
  private static String title(String s) {
    if (s.length() + 2 > MAX_LINE_LENGTH) {
      return "\n# " + s + "\n";
    } else {
      var hashes = "#".repeat(((MAX_LINE_LENGTH - s.length() - 2) / 2));
      var extraHash = "#".repeat(s.length() % 2); // for inputs of odd length
      return "\n" + hashes + " " + s + " " + hashes + extraHash + "\n";
    }
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

  private static String mistakeTypeElementVsParametrizedStringStatistics(
      Map<MistakeType, ? extends Collection<MistakeInfo>> mapping) {
    return MistakeInfo.TABLE_HEADER + mapping.entrySet().stream().map(e -> e.getValue().stream()
        .map(MDIS4LC::randomColorString).collect(Collectors.joining("\n"))).collect(Collectors.joining("\n"));
  }

  /** Format the MistakeDetectionFormats to be used in the HumanValidatedMistakeDetectionFormats class. */
  private static String formatMistakeDetectionFormatsForJava(Map<MistakeType, MistakeDetectionFormat> mapping,
      boolean filterNumberedMdfs) {
    // eg, entry(ATTRIBUTE_DUPLICATED, mdf(List.of("attr"), List.of()))
    return mapping.entrySet().stream()
        .map(e -> "entry(" + underscorify(e.getKey().getName()).toUpperCase() + ", mdf"
            + e.getValue().toString().replace("[", "List.of(").replace("]", ")") + ")")
        .filter(s -> !(filterNumberedMdfs && s.matches(".*\\d.*"))).collect(Collectors.joining(",\n"));
  }

  /** Format the MistakeDetectionFormats to be used in the Python corpus definition. */
  private static String formatMistakeDetectionFormatsForPython(Map<MistakeType, MistakeDetectionFormat> mapping,
      boolean filterNumberedMdfs) {
    // eg, missing_class.md_format = mdf([], ["cls"])
    return mapping.entrySet().stream().map(e -> underscorify(e.getKey().getName()) + ".md_format = mdf" + e.getValue())
        .filter(s -> !(filterNumberedMdfs && s.matches(".*\\d.*"))).collect(Collectors.joining("\n"));
  }

  private static String formatSuggestedParametrizedResponses(Map<MistakeType, Set<String>> mapping) {
    return mapping.entrySet().stream().map(e -> e.getKey().getName() + ":\n" + String.join("\n", e.getValue()))
        .collect(Collectors.joining("\n\n"));
  }

  private static String formatParametrizedResponsesForJava(Map<MistakeType, Set<String>> mapping) {
    // eg, entry(PLURAL_ATTRIBUTE, Set.of("The ${inst_attr} attribute should be singular."))
    return mapping.entrySet().stream()
        .filter(e -> !HumanValidatedParametrizedResponses.mappings.containsKey(e.getKey()))
        .map(e -> "entry(" + underscorify(e.getKey().getName()).toUpperCase() + ", Set.of(\""
            + String.join("\",\n    \"", e.getValue()) + "\"))")
        .collect(Collectors.joining(",\n"));
  }

  /**
   * Returns all the mistakes from all comparison objects created during the mistake detection tests as a flat stream,
   * useful for iteration.
   */
  private static Stream<Mistake> allMistakes() {
    return Comparison.instances.stream().map(comp -> comp.newMistakes).flatMap(List::stream);
  }

  /**
   * Returns all the mistakes from all comparison objects created during the mistake detection tests as a flat stream,
   * useful for iteration.
   */
  private static Stream<Mistake> allMistakesLimitOneOfEachType() {
    final Set<MistakeType> seen = new HashSet<>();
    return Comparison.instances.stream().map(comp -> comp.newMistakes).flatMap(List::stream)
        .filter(m -> seen.add(m.getMistakeType()));
  }

  /** Returns true if the association has an end with the given type. */
  private static boolean cdmAssociationIs(Association assoc, ReferenceType type) {
    return assoc.getEnds().stream().map(AssociationEnd::getReferenceType).anyMatch(t -> t == type);
  }

  /** Returns true if the association has an end with the given type. */
  private static boolean hasStudent(SolutionElement e) {
    return e.getSolution().getStudent() != null;
  }

  /** Maps all comparison mistakes based on the input mistakeStudentElementTransformation. */
  private static <T> Map<MistakeType, Set<T>> mapAllMistakesTo(
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer,
      Function<? super SolutionElement, T> mistakeStudentElementTransformation) {
    return mapMistakesTo(allMistakes(), mistakeSolutionElementsStreamer, mistakeStudentElementTransformation);
  }

  /** Maps comparison mistakes based on the input mistakeStudentElementTransformation. */
  private static <T> Map<MistakeType, Set<T>> mapMistakesTo(Stream<Mistake> mistakes,
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer,
      Function<? super SolutionElement, T> mistakeStudentElementTransformation) {
    return mistakes.collect(Collectors.toMap(Mistake::getMistakeType,
        m -> mistakeSolutionElementsStreamer.apply(m).map(mistakeStudentElementTransformation)
            .collect(Collectors.toUnmodifiableSet()), // TODO Update on Java 17+
        MDIS4LC::setUnion,
        TreeMap::new));
  }

  static <T> Set<T> setUnion(Set<T> set1, Set<T> set2) {
    return Stream.of(set1, set2).flatMap(Set::stream).collect(Collectors.toUnmodifiableSet());
  }

  /** Cleans and underscorifies the given string. */
  private static String underscorify(String s) {
    return s.replaceAll("\\((.+?)\\)", "").trim().replaceAll("/", "_").replaceAll("-", "_")
        .replaceAll("\\s+", "_").replaceAll("_+", "_").toLowerCase();
  }

  /** Returns the given item.toString() in a random color if USE_COLOR_OUTPUT is true. */
  static <T> String randomColorString(T item) {
    var maxPossibleColorIndex = Color.values().length - 1; // do not use Color.ENDC as a possible color
    var itemStr = item.toString();
    var code = item.hashCode();
    if (itemStr.contains(",")) {
      var beforeComma = itemStr.split(",")[0]; // only take initial part of csv string
      code = beforeComma.hashCode() + 0 * beforeComma.length(); // work in progress
    }
    return colorString(Color.values()[Math.floorMod(code, maxPossibleColorIndex)], itemStr);
  }


  /** Debug print function. It can be added to a Stream with {@code .map(MDIS4LC::debugPrint)}. */
  static <T> T debugPrint(T t) {
    System.out.println(t);
    return t;
  }

  /** Prints non-fatal warning to console in orange. */
  static <T> T warn(T t) {
    System.out.println(colorString(Color.ORANGE, "Warning: " + t));
    return t;
  }

  /** Container class for Python Learning Corpus initialization code. */
  static class PythonLearningCorpusInitializationCode {
    String imports;
    String learningItems;

    PythonLearningCorpusInitializationCode(String imports, String learningItems) {
      this.imports = imports;
      this.learningItems = learningItems;
    }
  }

  /** Convenience container class for mistake information not in metamodel. To be refactored in the future. */
  static class MistakeInfo {
    static final String TABLE_HEADER =
        "MistakeType,StudentElems,InstructorElems,TotalElems,MaxParamRespNumParams,SolElemDescriptions\n";

    Mistake mistake;
    int instructorElems;
    int studentElems;
    int totalElems;
    List<Integer> paramRespParamNums;
    int maxParamRespNumParams;

    public MistakeInfo(Mistake mistake) {
      this.mistake = mistake;
      instructorElems = mistake.getInstructorElements().size();
      studentElems = mistake.getStudentElements().size();
      totalElems = instructorElems + studentElems;
      paramRespParamNums = calculateParamRespParamNums();
      maxParamRespNumParams = Collections.max(paramRespParamNums);
    }

    private List<Integer> calculateParamRespParamNums() {
      var counts = mistake.getMistakeType().getFeedbacks().stream().filter(fb -> fb instanceof ParametrizedResponse)
          .map(pr -> Pattern.compile("\\$\\{.*?\\}").matcher(((ParametrizedResponse) pr).getText()).results().count())
          .map(Math::toIntExact).collect(Collectors.toList()); // use mutable list to allow sorting in next step
      if (counts.isEmpty()) {
        return List.of(0);
      }
      Collections.sort(counts);
      return Collections.unmodifiableList(counts);
    }

    private String firstColumnEntries() {
      return mistake.getMistakeType().getName() + "," + studentElems + "," + instructorElems + "," + totalElems + ","
          + maxParamRespNumParams;
    }

    @Override public String toString() {
      return firstColumnEntries() + ","
          + mistake.getStudentElements().stream().map(e -> ElementDescription.fromElement(e).toString())
              .collect(Collectors.joining(",")) + ","
          + mistake.getInstructorElements().stream().map(e -> ElementDescription.fromElement(e).toString())
              .collect(Collectors.joining(","));
    }

    // value-based equality based on some fields only, to avoid set duplicates
    @Override public boolean equals(Object o) {
      if (o instanceof MistakeInfo) {
        return firstColumnEntries().equals(((MistakeInfo) o).firstColumnEntries());
      }
      return false;
    }

    @Override public int hashCode() {
      return firstColumnEntries().hashCode();
    }
  }

  // TODO Under construction
  static class MistakeTypeInfo {
    private static final Map<MistakeType, MistakeTypeInfo> instancesByMistakeType = new TreeMap<>(); // ordered map

    public MistakeTypeInfo(Mistake mistake) {}

    public static MistakeTypeInfo get(Mistake mistake) {
      var mt = mistake.getMistakeType();
      if (!instancesByMistakeType.containsKey(mt)) {
        instancesByMistakeType.put(mt, new MistakeTypeInfo(mistake));
      }
      return get(mt);
    }

    public static MistakeTypeInfo get(MistakeType mistakeType) {
      if (!instancesByMistakeType.containsKey(mistakeType)) {
        throw new IllegalArgumentException("Cannot get MistakeTypeInfo instance for mistake type "
            + mistakeType.getName() + " because no mistakes of that type have been processed yet.");
      }
      return instancesByMistakeType.get(mistakeType);
    }
  }

  /** Container class for an element description. */
  static class ElementDescription {
    String name;
    EClass eClass;
    boolean hasStudent;
    String description = "";

    static final Map<EClass, String> eClassesToShortDisplayNames = Map.of(
        CDF.createAssociationEnd().eClass(), "assocend",
        CDF.createAssociation().eClass(), "rel", // includes composition and aggregation
        CDF.createAttribute().eClass(), "attr",
        CDF.createCDEnum().eClass(), "enum",
        CDF.createCDEnumLiteral().eClass(), "enumitem",
        CDF.createClass().eClass(), "cls");

    public ElementDescription(String name, EClass eClass, boolean hasStudent) {
      this.name = name;
      this.eClass = eClass;
      this.hasStudent = hasStudent;
    }

    public ElementDescription(String name, EClass eClass, boolean hasStudent, String description) {
      this(name, eClass, hasStudent);
      this.description = description;
    }

    public ElementDescription(SolutionElement element) {
      this(element.getElement().getName(), element.getElement().eClass(), hasStudent(element));
    }

    public static ElementDescription fromElement(SolutionElement element) {
      return new ElementDescription(element);
    }

    // eg, "Student Container Class (name: Airplane)"
    @Override public String toString() {
      return (hasStudent ? "Student" : "Instructor") + " " + (description.isEmpty() ? "" : description + " ")
          + eClass.getName() + " (name: " + name + ")";
    }

    // eg, "container_class"
    public String toShortString(int count) {
      return ((description.isEmpty() ? count : description) + "_"
          + eClassesToShortDisplayNames.get(eClass).toString()).toLowerCase(); // trigger NPE for missing eClass
    }

    public String toShortString() {
      return toShortString(0);
    }
  }

  static class MistakeDetectionFormat {
    List<String> stud = new ArrayList<>();
    List<String> inst = new ArrayList<>();

    private MistakeDetectionFormat(Mistake mistake) {
      int[] cnt = {0, 0};
      mistake.getStudentElements().forEach(e -> stud.add(ElementDescription.fromElement(e).toShortString(cnt[0]++)));
      mistake.getInstructorElements().forEach(e -> inst.add(ElementDescription.fromElement(e).toShortString(cnt[1]++)));
      if (stud.size() == 1) {
        stud.set(0, stud.get(0).replace("0_", ""));
      }
      if (inst.size() == 1) {
        inst.set(0, inst.get(0).replace("0_", ""));
      }
    }

    private MistakeDetectionFormat(List<String> studentElemsDescriptions, List<String> instructorElemsDescriptions) {
      stud = studentElemsDescriptions;
      inst = instructorElemsDescriptions;
    }

    public static MistakeDetectionFormat forMistake(Mistake mistake) {
      if (HumanValidatedMistakeDetectionFormats.mappings.containsKey(mistake.getMistakeType())) {
        return HumanValidatedMistakeDetectionFormats.mappings.get(mistake.getMistakeType());
      }
      return new MistakeDetectionFormat(mistake);
    }

    public static MistakeDetectionFormat mdf(List<String> studentElemsDescriptions,
        List<String> instructorElemsDescriptions) {
      return new MistakeDetectionFormat(studentElemsDescriptions, instructorElemsDescriptions);
    }

    // eg, ([], ["cls"])
    @Override public String toString() {
      var studTag = stud.isEmpty() ? "" : "\"";
      var instTag = inst.isEmpty() ? "" : "\"";
      return "([" + studTag + String.join("\", \"", stud) + studTag + "], ["
          + instTag + String.join("\", \"", inst) + instTag + "])";
    }
  }

  /** Short-name alias for this class. */
  static class MDIS4LC extends MistakeDetectionInformationServicesForLearningCorpus {}

}
