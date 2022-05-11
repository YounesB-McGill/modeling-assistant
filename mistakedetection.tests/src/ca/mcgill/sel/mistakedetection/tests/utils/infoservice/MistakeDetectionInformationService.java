package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import static ca.mcgill.sel.mistakedetection.tests.utils.MistakeDetectionInformationServicesForLearningCorpus.MAX_LINE_LENGTH;
import static ca.mcgill.sel.mistakedetection.tests.utils.MistakeDetectionInformationServicesForLearningCorpus.warn;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.CdmFactory;
import ca.mcgill.sel.classdiagram.ReferenceType;
import ca.mcgill.sel.mistakedetection.Comparison;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedMistakeDetectionFormats;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedParametrizedResponses;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.CdmMetatype;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeDetectionFormat;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeInfo;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeTypeInfo;
import learningcorpus.ElementType;
import learningcorpus.MistakeType;
import learningcorpus.ParametrizedResponse;
import modelingassistant.Mistake;
import modelingassistant.SolutionElement;

/**
 * Class to represent an abstract Mistake Detection Information Service. A service returns formatted output based on its
 * input, which ultimately comes from the result of running the Mistake Detection tests.
 *
 * @author Younes Boubekeur
 */
public abstract class MistakeDetectionInformationService {

  private static final String ERROR = "This method must be treated as abstract and can only be invoked on a subclass! "
      + "If a subclass is defined, ensure it overrides this method.";

  /** Shorthand for CdmFactory.eINSTANCE. */
  static final CdmFactory CDF = CdmFactory.eINSTANCE;

  /** Map of CDM metatypes to learning corpus ElementTypes. */
  public static final Map<CdmMetatype, ElementType> cdmMetatypesToLearningCorpusElementTypes = Map.of(
      CdmMetatype.ASSOCEND, ElementType.ASSOCIATION_END,
      CdmMetatype.ATTR, ElementType.ATTRIBUTE,
      CdmMetatype.CLS, ElementType.CLASS,
      CdmMetatype.ENUM, ElementType.CLASS,
      CdmMetatype.ENUMITEM, ElementType.CLASS);

  // Helper Functions to map each mistake to specific solution elements
  public static final Function<Mistake, Stream<SolutionElement>> instructorElems =
      m -> m.getInstructorElements().stream();
  public static final Function<Mistake, Stream<SolutionElement>> studentElems = m -> m.getStudentElements().stream();
  public static final Function<Mistake, Stream<SolutionElement>> instructorAndStudentElems =
      m -> Stream.concat(instructorElems.apply(m), studentElems.apply(m));

  static final BinaryOperator<MistakeDetectionFormat> mdfCollisionFunction = (mdf1, mdf2) -> {
    if (mdf1.inst.size() <= mdf2.inst.size() && mdf1.stud.size() <= mdf2.stud.size()) {
      return mdf2;
    } else if (mdf1.inst.size() >= mdf2.inst.size() && mdf1.stud.size() >= mdf2.stud.size()) {
      return mdf1;
    }
    warn("Encountered 2 MistakeDetectionFormats with incompatible numbers of instructor and student elements, "
        + "returning most recent: " + mdf2);
    return mdf2;
  };

  static final Map<MistakeType, Set<String>> suggestedParametrizedResponses =
      suggestParametrizedResponses(
          //suggestedMistakeDetectionFormats,
          HumanValidatedMistakeDetectionFormats.mappings,
          false);

  public final String name;

  public MistakeDetectionInformationService(String name) {
    this.name = name;
  }

  /**
   * Returns the formatted output for this service. By convention, implementing subclasses should prepend
   * {@code title(name) + "\n"} to the returned output.
   */
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
  public static Stream<MistakeInfo> allMistakeInfos() {
    return Comparison.instances.stream().flatMap(comp -> comparisonMistakeInfoPairs(comp)).map(Map.Entry::getValue);
  }

  /**
   * Returns one mistake of each mistake type from all comparison objects created during the mistake detection tests as
   * a flat stream, useful for iteration.
   */
  public static Stream<MistakeInfo> allMistakesLimitOneOfEachType() {
    final Set<MistakeType> seen = new HashSet<>();
    return allMistakeInfos().filter(mi -> seen.add(mi.mistakeType));
  }

  /** Maps all comparison mistakes based on the input mistakeStudentElementTransformation. */
  static <T> Map<MistakeType, Set<T>> mapAllMistakesTo(
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer,
      Function<? super SolutionElement, T> mistakeStudentElementTransformation) {
    return mapMistakesTo(allMistakeInfos(), mistakeSolutionElementsStreamer, mistakeStudentElementTransformation);
  }

  /** Maps comparison mistakes based on the input mistakeStudentElementTransformation. */
  static <T> Map<MistakeType, Set<T>> mapMistakesTo(Stream<MistakeInfo> mistakeInfos,
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer,
      Function<? super SolutionElement, T> mistakeStudentElementTransformation) {
    // Collectors.toMap() can take these 4 inputs when invoked on a stream of items (in this case, mistakes):
    return mistakeInfos.collect(Collectors.toMap(
        // 1. Function to map the items to the keys of the output map. Here we map each MistakeInfo to its mistake type.
        mi -> mi.mistakeType,
        // 2. Function to map the items to the values of the output map. Here we map each MistakeInfo to a set.
        mi -> mistakeSolutionElementsStreamer.apply(mi.mistake).map(mistakeStudentElementTransformation)
            .collect(Collectors.toUnmodifiableSet()), // TODO Update on Java 17+
        // 3. Merge function, handles collisions between values with the same key. Here, we merge the 2 sets.
        MistakeDetectionInformationService::setUnion,
        // 4. The output map of Collectors.toMap(). Use TreeMap to sort output by mistake type.
        TreeMap::new));
  }

  /** Maps comparison mistakes to learning corpus ElementTypes. */
  public static Map<MistakeType, Set<ElementType>> mapMistakesToLearningCorpusElementTypes(
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer) {
    return mapAllMistakesTo(mistakeSolutionElementsStreamer, e ->
        cdmMetatypesToLearningCorpusElementTypes.getOrDefault(CdmMetatype.withEClass(e.getElement().eClass()),
            // assume for now that all input metatypes are either in map or association instances
            e.getElement() instanceof Association ?
                (cdmAssociationIs((Association) e.getElement(), ReferenceType.COMPOSITION) ?
                    ElementType.COMPOSITION : ElementType.ASSOCIATION) : null)); // can't easily detect inheritance here
  }

  /** Filtered MDFs which not already validated. */
  static final Map<MistakeTypeInfo, MistakeDetectionFormat> filteredSuggestedMistakeDetectionFormats() {
      return suggestMistakeDetectionFormats(e ->
          !e.getValue().equals(HumanValidatedMistakeDetectionFormats.mappings.get(e.getKey().mistakeType)));
  }

  /** Suggests mistake detection formats based on the output of the mistake detection tests. */
  static Map<MistakeTypeInfo, MistakeDetectionFormat> suggestMistakeDetectionFormats() {
    return suggestAllMistakeDetectionFormats().entrySet().stream().collect(Collectors.toMap(
        e -> new MistakeTypeInfo(e.getKey()),
        Map.Entry::getValue,
        mdfCollisionFunction,
        TreeMap::new));
  }

  static Map<MistakeTypeInfo, MistakeDetectionFormat> suggestMistakeDetectionFormats(
      Predicate<Map.Entry<MistakeTypeInfo, MistakeDetectionFormat>> filteringFunction) {
    return suggestMistakeDetectionFormats().entrySet().stream().filter(filteringFunction)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  /** Returns the MDFs as implemented in the Mistake Detection System, regardless of validation status. */
  public static Map<MistakeTypeInfo, MistakeDetectionFormat> getMistakeDetectionFormatsAsIsFromMistakeDetectionSystem() {
    return getAllMistakeDetectionFormatsAsIsFromMistakeDetectionSystem().entrySet().stream().collect(Collectors.toMap(
        e -> new MistakeTypeInfo(e.getKey()),
        Map.Entry::getValue,
        mdfCollisionFunction,
        TreeMap::new));
  }

  /** Returns the MDFs as implemented in the Mistake Detection System, regardless of validation status. */
  static Map<MistakeTypeInfo, MistakeDetectionFormat> getMistakeDetectionFormatsAsIsFromMistakeDetectionSystem(
      Predicate<Map.Entry<MistakeTypeInfo, MistakeDetectionFormat>> filteringFunction) {
    return getMistakeDetectionFormatsAsIsFromMistakeDetectionSystem().entrySet().stream().filter(filteringFunction)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  private static Map<MistakeInfo, MistakeDetectionFormat> suggestAllMistakeDetectionFormats() {
    return allMistakeInfos().collect(Collectors.toMap(Function.identity(), MistakeDetectionFormat::forMistakeInfo));
  }

  private static Map<MistakeInfo, MistakeDetectionFormat> getAllMistakeDetectionFormatsAsIsFromMistakeDetectionSystem()
  {
    return allMistakeInfos().collect(Collectors.toMap(
        Function.identity(),
        MistakeDetectionFormat::new,
        (mdf1, mdf2) -> mdf2,
        TreeMap::new));
  }

  private static Map<MistakeType, Set<String>> suggestParametrizedResponses(
      Map<MistakeType, MistakeDetectionFormat> mapping, boolean filterNumberedMdfs) {
    return mapping.entrySet().stream()
        .filter(e -> !filterNumberedMdfs || (e.getValue().stud.size() <= 1 && e.getValue().inst.size() <= 1))
        .collect(Collectors.toMap(Map.Entry::getKey,
            MistakeDetectionInformationService::parametrizeResponses,
            MistakeDetectionInformationService::setUnion,
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
    // TODO Work in progress
    var result = pr.getText();
    final var pattern = Pattern.compile("\\$\\{(?<param>.*?)\\}");
    var matcher = pattern.matcher(result);
    if (mdf.stud.size() == 1 && mdf.inst.isEmpty()) {
      result = matcher.replaceFirst(Matcher.quoteReplacement("${stud_" + mdf.stud.get(0) + "}"));
    } else if (mdf.stud.isEmpty() && mdf.inst.size() == 1) {
      result = matcher.replaceFirst(Matcher.quoteReplacement("${inst_" + mdf.inst.get(0) + "}"));
    } else if (mdf.stud.size() == 1 && mdf.inst.size() == 1) {
      final var studRepl = "@@STUD_REPL@@";
      result = matcher.replaceFirst(Matcher.quoteReplacement(studRepl));
      matcher = pattern.matcher(result);
      result = matcher.replaceFirst(Matcher.quoteReplacement("${inst_" + mdf.inst.get(0) + "}"));
      result = result.replace(studRepl, "${stud_" + mdf.stud.get(0) + "}");
    }
    return result;
  }

  /** Returns true if the solution element is part of a student solution. */
  public static boolean hasStudent(SolutionElement e) {
    return e.getSolution().getStudent() != null;
  }

  /** Returns true if the association has an end with the given type. */
  private static boolean cdmAssociationIs(Association assoc, ReferenceType type) {
    return assoc.getEnds().stream().map(AssociationEnd::getReferenceType).anyMatch(t -> t == type);
  }

  static <T> Set<T> setUnion(Set<T> set1, Set<T> set2) {
    return Stream.of(set1, set2).flatMap(Set::stream).collect(Collectors.toUnmodifiableSet());
  }

  /** Cleans and underscorifies the given string. */
  static String underscorify(String s) {
    return s.replaceAll("\\((.+?)\\)", "").trim().replaceAll("/", "_").replaceAll("-", "_")
        .replaceAll("\\s+", "_").replaceAll("_+", "_").toLowerCase();
  }

  private static Stream<Map.Entry<Comparison, MistakeInfo>> comparisonMistakeInfoPairs(Comparison comparison) {
    return comparison.newMistakes.stream()
        .map(m -> new SimpleImmutableEntry<>(comparison, new MistakeInfo(m, comparison)));
  }

  /** Needed to get around Java compiler limitations. */
  private static void uoe() {
    throw new UnsupportedOperationException(ERROR);
  }

}
