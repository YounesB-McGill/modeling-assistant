package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;
import static ca.mcgill.sel.mistakedetection.tests.utils.MistakeDetectionInformationServicesForLearningCorpus.MAX_LINE_LENGTH;
import static ca.mcgill.sel.mistakedetection.tests.utils.MistakeDetectionInformationServicesForLearningCorpus.warn;
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
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.CdmFactory;
import ca.mcgill.sel.classdiagram.ReferenceType;
import ca.mcgill.sel.mistakedetection.Comparison;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedParametrizedResponses;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeDetectionFormat;
import learningcorpus.ElementType;
import learningcorpus.MistakeType;
import learningcorpus.ParametrizedResponse;
import modelingassistant.Mistake;
import modelingassistant.SolutionElement;

public abstract class MistakeDetectionInformationService {

  private static final String ERROR = "This method must be treated as abstract and can only be invoked on a subclass! "
      + "If a subclass is defined, ensure it overrides this method.";

  /** Shorthand for CdmFactory.eINSTANCE. */
  static final CdmFactory CDF = CdmFactory.eINSTANCE;

  /** Map of CDM metatypes to learning corpus ElementTypes. */
  public static final Map<EClass, ElementType> cdmMetatypesToLearningCorpusElementTypes = Map.of(
      CDF.createAssociationEnd().eClass(), ElementType.ASSOCIATION_END,
      CDF.createAttribute().eClass(), ElementType.ATTRIBUTE,
      CDF.createCDEnum().eClass(), ElementType.CLASS,
      CDF.createCDEnumLiteral().eClass(), ElementType.CLASS,
      CDF.createClass().eClass(), ElementType.CLASS);

  //Helper Functions to map each mistake to specific solution elements
  public static final Function<Mistake, Stream<SolutionElement>> instructorElems =
      m -> m.getInstructorElements().stream();
  public static final Function<Mistake, Stream<SolutionElement>> studentElems = m -> m.getStudentElements().stream();
  public static final Function<Mistake, Stream<SolutionElement>> instructorAndStudentElems =
      m -> Stream.concat(instructorElems.apply(m), studentElems.apply(m));

  static final Map<MistakeType, MistakeDetectionFormat> suggestedMistakeDetectionFormats =
      suggestMistakeDetectionFormats();

  static final Map<MistakeType, Set<String>> suggestedParametrizedResponses =
      suggestParametrizedResponses(suggestedMistakeDetectionFormats, true);

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

  /** Maps all comparison mistakes based on the input mistakeStudentElementTransformation. */
  static <T> Map<MistakeType, Set<T>> mapAllMistakesTo(
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer,
      Function<? super SolutionElement, T> mistakeStudentElementTransformation) {
    return mapMistakesTo(allMistakes(), mistakeSolutionElementsStreamer, mistakeStudentElementTransformation);
  }

  /** Maps comparison mistakes based on the input mistakeStudentElementTransformation. */
  static <T> Map<MistakeType, Set<T>> mapMistakesTo(Stream<Mistake> mistakes,
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer,
      Function<? super SolutionElement, T> mistakeStudentElementTransformation) {
    // Collectors.toMap() can take these 4 inputs when invoked on a stream of items (in this case, mistakes):
    return mistakes.collect(Collectors.toMap(
        // 1. Function to map the items to the keys of the output map. Here we map each mistake to its mistake type.
        Mistake::getMistakeType,
        // 2. Function to map the items to the values of the output map. Here we map each mistake to a set.
        m -> mistakeSolutionElementsStreamer.apply(m).map(mistakeStudentElementTransformation)
            .collect(Collectors.toUnmodifiableSet()), // TODO Update on Java 17+
        // 3. Merge function, handles collisions between values with the same key. Here, use merge the 2 sets.
        MistakeDetectionInformationService::setUnion,
        // 4. The output map of Collectors.toMap(). Use TreeMap to sort output by mistake type.
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

  /** Returns true if the association has an end with the given type. */
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

  /** Needed to get around Java compiler limitations. */
  private static void uoe() {
    throw new UnsupportedOperationException(ERROR);
  }

}
