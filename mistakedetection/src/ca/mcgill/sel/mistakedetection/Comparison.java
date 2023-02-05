package ca.mcgill.sel.mistakedetection;

import static ca.mcgill.sel.mistakedetection.MistakeDetectionConfig.trackComparisonInstances;
import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.CDEnum;
import ca.mcgill.sel.classdiagram.CDEnumLiteral;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.classdiagram.NamedElement;
import modelingassistant.Mistake;
import modelingassistant.Solution;

/**
 * Helper class to represent information about a mistake detection comparison.
 */
public class Comparison {

  /** Variable to store instructor class diagram. */
  public ClassDiagram instructorCdm;

  /** Variable to store student class diagram. */
  public ClassDiagram studentCdm;

  /** Variable to store abstract class for full PR pattern. */
  public Classifier fullPlayerRoleAbstractClass;

  /** Variable to store association between abstract class and player class for full PR pattern. */
  public Association fullPlayerRoleAbstractPlayerAssoc;

  /** Variable to store association between abstraction and occurrence classes in AO pattern. */
  public Association abstractionOccurrenceAssoc;

  /** Maps an instructor solution classifier to student solution classifier. */
  public Map<Classifier, Classifier> mappedClassifiers = new HashMap<>();

  /** Maps an instructor solution classifier attribute to student solution classifier attribute. */
  public Map<Attribute, Attribute> mappedAttributes = new HashMap<>();

  /** Maps an instructor solution classifier relation to student solution classifier relation. */
  public Map<Association, Association> mappedAssociations = new HashMap<>();

  /** Maps an instructor solution enumeration relation to student solution enumeration. */
  public Map<CDEnum, CDEnum> mappedEnumerations = new HashMap<>();

  /** Maps an instructor solution enumeration item relation to student solution enumeration item. */
  public Map<CDEnumLiteral, CDEnumLiteral> mappedEnumerationItems = new HashMap<>();

  /** Maps each instructor superclass to its subclasses, forming a generalization tree. */
  public Map<Classifier, List<Classifier>> instructorSuperclassesToSubclasses = new HashMap<>();

  /** Maps each instructor superclass to its subclasses, forming a generalization tree. */
  public Map<Classifier, List<Classifier>> studentSuperclassesToSubclasses = new HashMap<>();

  public List<Classifier> notMappedInstructorClassifiers = new ArrayList<>();
  public List<Classifier> extraStudentClassifiers = new ArrayList<>();

  public List<Attribute> notMappedInstructorAttributes = new ArrayList<>();
  public List<Attribute> extraStudentAttributes = new ArrayList<>();
  public List<Attribute> duplicateStudentAttributes = new ArrayList<>();

  public List<Association> notMappedInstructorAssociations = new ArrayList<>();
  public List<Association> extraStudentAssociations = new ArrayList<>();

  public List<CDEnum> notMappedInstructorEnums = new ArrayList<>();
  public List<CDEnum> extraStudentEnums = new ArrayList<>();

  public List<CDEnumLiteral> notMappedInstructorEnumLiterals = new ArrayList<>();
  public List<CDEnumLiteral> extraStudentEnumLiterals = new ArrayList<>();

  public List<Mistake> newMistakes = new ArrayList<>();

  /** List to store association classes to remove from mapped classes. */
  public List<Classifier> assocClassifiersToRemove = new ArrayList<>();

  /** List to store instructor classes which have super classes. */
  public List<Classifier> instructorGeneralizationClassifiers = new ArrayList<>();

  /** List to store student classes which have super classes. */
  public List<Classifier> studentGeneralizationClassifiers = new ArrayList<>();

  /** Map stores possible instructor student Association Class pair that are detected after initial class mapping. */
  public Map<Classifier, Classifier> assocClassMappingToAdd = new HashMap<>();

  /**
   * Represents the class and method that caused the Comparison to be created, usually via the
   * {@code MistakeDetection.compare()} method, in the format {@code ClassName.methodName()}.
   * It is only populated if trackComparisonsInstances is true.
   */
  public String caller = "";

  /** List of Comparison instances. It is only populated if trackComparisonsInstances is true. */
  public static transient final List<Comparison> instances = new ArrayList<>();

  /** The number of stack trace frames to skip when recording the comparison's caller method, useful for debugging. */
  private static final int NUM_SKIPPED_FRAMES = 2;

  // use instance initializer to avoid explicit custom constructor
  {
    if (trackComparisonInstances) {
      instances.add(this);
      caller = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE)
          .walk(frames -> frames.skip(NUM_SKIPPED_FRAMES).findFirst()
              .map(fr -> fr.getDeclaringClass().getSimpleName() + "." + fr.getMethodName() + "()")).orElse("");
    }
  }

  /** Prints the mapped, unmapped classifier or attributes in ascending order of mistake types. */
  public Comparison sortedLog() {
    System.out.println(getSortedLog());
    return this;
  }

  /** Prints the mapped, unmapped classifier or attributes. */
  public Comparison log() {
    System.out.println(getLog());
    return this;
  }

  /** Prints the comparison log with only unmapped items, useful for synonym generation. */
  public Comparison logUnmappedItemsOnly() {
    System.out.println(getLogWithUnmappedItemsOnly());
    return this;
  }

  /** Returns the comparison sorted log as a string. */
  public String getSortedLog() {
    return getLog(true, false);
  }

  /** Returns the comparison log as a string. */
  public String getLog() {
    return getLog(false, false);
  }

  /** Returns the comparison log as a string. */
  public String getLogWithUnmappedItemsOnly() {
    return getLog(false, true);
  }

  /** Returns the comparison log as a string. */
  private String getLog(boolean sortMistakes, boolean unmappedNamesOnly) {
    var sb = new StringBuilder();
    sb.append(getMappingsDescription(unmappedNamesOnly));
    sb.append("\nTotal Mistakes: " + numTotalMistakes() + "\nNew mistakes: " + newMistakes.size());
    if (!unmappedNamesOnly) {
      if (!newMistakes.isEmpty()) {
        sb.append(":\n");
      }
      var mistakes = newMistakes;
      if (sortMistakes) {
        mistakes = getSortedMistakeList();
      }
      mistakes.forEach(m -> sb.append(" - " + m.getMistakeType().getName() + ": ")
          .append("Student Elements: " + m.getStudentElementNames() + ", ")
          .append("Instructor Elements: " + m.getInstructorElementNames() + "\n"));
    }
    return sb.toString();
  }

  /**
   * Returns a human-readable description of the mappings made between a student solution and an instructor solution,
   * useful for logging and debugging.
   */
  public String getMappingsDescription() {
    return getMappingsDescription(false);
  }

  /**
   * Returns a human-readable description of the mappings made between a student solution and an instructor solution,
   * useful for logging and debugging.
   */
  public String getMappingsDescription(boolean unmappedNamesOnly) {
    final var sb = new StringBuilder();

    final Consumer<? super NamedElement> appendName = e -> sb.append(e.getName() + " ");
    BiConsumer<? super NamedElement, ? super NamedElement> appendKeyValueNames =
        (key, value) -> sb.append(key.getName() + " = " + value.getName() + "\n");
    BiConsumer<? super Classifier, ? super List<Classifier>> appendGeneralizations = (key, value) -> {
      sb.append(key.getName() + " <- ");
      value.forEach(appendName);
      sb.append("\n");
    };

    sb.append("\n-----Comparison Log-----\n");

    // classes
    sb.append("Not Mapped InstructorClassifier List: ");
    notMappedInstructorClassifiers.forEach(appendName);
    sb.append("\nNot Mapped extraStudentClassifier: ");
    extraStudentClassifiers.forEach(c -> sb.append(c.getName() + " "));
    if (!unmappedNamesOnly) {
      sb.append("\nMapped Classifiers: \n");
      mappedClassifiers.forEach(appendKeyValueNames);
    }

    // attributes
    sb.append("\nNot Mapped InstructorAttribute List: ");
    notMappedInstructorAttributes.forEach(appendName);
    sb.append("\nNot Mapped extraStudentAttribute: ");
    extraStudentAttributes.forEach(appendName);
    if (!unmappedNamesOnly) {
      sb.append("\nDuplicate Attribute: ");
      duplicateStudentAttributes.forEach(appendName);
      sb.append("\nMapped Attributes: \n");
      mappedAttributes.forEach((key, value) -> sb.append(attrType(key) + " " + key.getName() + " = " + attrType(value)
          + " " + value.getName() + "\n"));

      // associations
      sb.append("\nNot Mapped Association: ");
      notMappedInstructorAssociations.forEach(appendName);
      sb.append("\nExtra Association: ");
      extraStudentAssociations.forEach(appendName);
      sb.append("\nMapped Association: \n");
      mappedAssociations.forEach(appendKeyValueNames);

      // enumerations
      sb.append("\nMapped Enumerations: \n");
      mappedEnumerations.forEach(appendKeyValueNames);
    }
    sb.append("\nNot Mapped Enumerations: ");
    notMappedInstructorEnums.forEach(appendName);
    sb.append("\nExtra Enumerations: ");
    extraStudentEnums.forEach(appendName);

    // enumeration items
    if (!unmappedNamesOnly) {
      sb.append("\nMapped Enumerations items: \n");
      mappedEnumerationItems.forEach(appendKeyValueNames);
    }
    sb.append("\nNot Mapped Enumerations items: ");
    notMappedInstructorEnumLiterals.forEach(appendName);
    sb.append("\nExtra Enumeration items: ");
    extraStudentEnumLiterals.forEach(appendName);

    // generalizations
    if (!unmappedNamesOnly) {
      sb.append("\nInstructor Generalizations: \n");
      instructorSuperclassesToSubclasses.forEach(appendGeneralizations);
      sb.append("\nStudent Generalizations: \n");
      studentSuperclassesToSubclasses.forEach(appendGeneralizations);
      sb.append("\nInstructor Generalization classes: ");
      instructorGeneralizationClassifiers.forEach(appendName);
      sb.append("\nStudent Generalization classes: ");
      studentGeneralizationClassifiers.forEach(appendName);
    }

    return sb.toString();
  }

  public List<Mistake> getSortedMistakeList(){
    Collections.sort(newMistakes, Comparator.comparing(Mistake::getMistakeType));
    return newMistakes;
  }

  private int numTotalMistakes() {
    if (!Solution.classDiagramsToSolutions.containsKey(studentCdm)) {
      return 0;
    }
    return Solution.forClassDiagram(studentCdm).getMistakes().size();
  }

  /** Returns the type name of an attribute */
  private static String attrType(Attribute attribute) {
    return attribute.getType().getClass().getSimpleName().replace("CD", "").replace("Impl", "");
  }

}
