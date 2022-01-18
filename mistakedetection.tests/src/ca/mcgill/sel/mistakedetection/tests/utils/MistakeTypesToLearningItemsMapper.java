package ca.mcgill.sel.mistakedetection.tests.utils;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import java.io.PrintWriter;
import java.util.HashSet;
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
import ca.mcgill.sel.classdiagram.CdmFactory;
import ca.mcgill.sel.mistakedetection.Comparison;
import ca.mcgill.sel.mistakedetection.MistakeDetectionConfig;
import learningcorpus.ElementType;
import learningcorpus.MistakeType;
import modelingassistant.Mistake;
import modelingassistant.SolutionElement;

/**
 * Class to map learning corpus mistake types to learning items.
 *
 * @author Younes Boubekeur
 */
public class MistakeTypesToLearningItemsMapper {

  /** Shorthand for CdmFactory.eINSTANCE. */
  private static final CdmFactory CDF = CdmFactory.eINSTANCE;

  /** Map of CDM metatypes to learning corpus ElementTypes. */
  public static final Map<EClass, ElementType> cdmMetatypesToLearningCorpusElementTypes = Map.of(
      CDF.createAssociation().eClass(), ElementType.ASSOCIATION, // includes all relationships
      CDF.createAssociationEnd().eClass(), ElementType.ASSOCIATION_END,
      CDF.createAttribute().eClass(), ElementType.ATTRIBUTE,
      CDF.createCDEnum().eClass(), ElementType.CLASS,
      CDF.createCDEnumLiteral().eClass(), ElementType.CLASS,
      CDF.createClass().eClass(), ElementType.CLASS);

  // Helper Functions to map each mistake to specific solution elements
  static Function<Mistake, Stream<SolutionElement>> instructorElems = m -> m.getInstructorElements().stream();
  static Function<Mistake, Stream<SolutionElement>> studentElems = m -> m.getStudentElements().stream();
  static Function<Mistake, Stream<SolutionElement>> instructorAndStudentElems = m ->
      Stream.concat(instructorElems.apply(m), studentElems.apply(m));

  /** The maximum allowed line length in generated source code. */
  private static final int MAX_LINE_LENGTH = 120;

  public static void main(String[] args) {
    MistakeDetectionConfig.trackComparisonsInstances = true;
    runAllMistakeDetectionTests();

    System.out.println(getCdmMetatypeMappingAsCsv(mapComparisonMistakesToCdmMetatypes(instructorAndStudentElems))
        + "\n\n" + getLearningCorpusElementTypeMappingAsCsv(
            mapComparisonMistakesToLearningCorpusElementTypes(instructorAndStudentElems)));

    System.out.println(generatePythonLearningCorpusInitializationCode());
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

  /** Maps comparison mistakes to CDM metatypes. */
  public static Map<MistakeType, Set<ElementType>> mapComparisonMistakesToLearningCorpusElementTypes(
      Function<Mistake, Stream<SolutionElement>> mistakeSolutionElementsStreamer) {
    return mapComparisonMistakesToCdmMetatypes(mistakeSolutionElementsStreamer).entrySet().stream()
        .map(e -> Map.entry(e.getKey(), e.getValue().stream().map(cdmMetatypesToLearningCorpusElementTypes::get)
            .collect(Collectors.toUnmodifiableSet())))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  /** Generates Pyecore-compatible code to generate the learning corpus. This can be improved. */
  public static List<String> generatePythonLearningCorpusInitializationCode() {
    var mistakesToTypes = mapComparisonMistakesToLearningCorpusElementTypes(instructorAndStudentElems);
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
          learningItems.append(m + ", ");
        } else {
          learningItems.deleteCharAt(learningItems.lastIndexOf(" ")).append("\n    " + m + ", ");
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
    return List.of(imports.toString(), learningItems.toString());
  }

  /**
   * Returns the mapping of comparison mistakes to CDM metatypes in a CSV-compatible format.
   * The format of each row is as follows:<br>
   *
   * {@code mistakeType.name: type1, type2, ...}
   */
  public static String getCdmMetatypeMappingAsCsv(Map<MistakeType, Set<EClass>> mapping) {
    return mapping.entrySet().stream().map(e ->
        e.getKey().getName() + ": " + String.join(", ", e.getValue().stream().map(EClass::getName)
            .collect(Collectors.toUnmodifiableList()))).collect(Collectors.joining("\n"));
  }

  /**
   * Returns the mapping of comparison mistakes to learning corpus ElementTypes in a CSV-compatible format.
   * The format of each row is as follows:<br>
   *
   * {@code mistakeType.name: type1, type2, ...}
   */
  public static String getLearningCorpusElementTypeMappingAsCsv(Map<MistakeType, Set<ElementType>> mapping) {
    return mapping.entrySet().stream().map(e ->
    e.getKey().getName() + ": " + String.join(", ", e.getValue().stream().map(ElementType::getName)
        .collect(Collectors.toUnmodifiableList()))).collect(Collectors.joining("\n"));
  }

  /** Cleans and underscorifies the given string. */
  private static String underscorify(String s) {
    return s.replaceAll("\\((.+?)\\)", "").trim().replaceAll("/", "_").replaceAll("-", "_")
        .replaceAll("\\s+", "_").replaceAll("_+", "_").toLowerCase();
  }

}
