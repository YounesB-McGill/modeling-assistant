package ca.mcgill.sel.mistakedetection;

import static ca.mcgill.sel.mistakedetection.MistakeDetectionConfig.trackComparisonInstances;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.CDEnum;
import ca.mcgill.sel.classdiagram.CDEnumLiteral;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.classdiagram.Classifier;
import modelingassistant.Mistake;

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

  /** List of Comparison instances. It is only populated if trackComparisonsInstances is true. */
  public static transient final List<Comparison> instances = new ArrayList<>();

  // use instance initializer to avoid explicit custom constructor
  {
    if (trackComparisonInstances) {
      instances.add(this);
    }
  }

  /**
   * Function to print the mapped, unmapped classifier or attributes in ascending order of mistake types.
   */
  public Comparison sortedLog() {
    System.out.println(getSortedLog());
    return this;
  }

  /**
   * Function to print the mapped, unmapped classifier or attributes.
   */
  public Comparison log() {
    System.out.println(getLog());
    return this;
  }

  /** Returns the comparison sorted log as a string. */
  public String getSortedLog() {
    var sb = new StringBuilder();
    sb.append(getMappings());
    var sortedList = newMistakes;
    sortedList = getSortedMistakeList(newMistakes);
    sb.append("\n");
    sb.append("Total Mistakes: "+ newMistakes.size() +"\nMistakes: \n");
    sortedList.forEach(m -> {
      if (!m.getInstructorElements().isEmpty() && !m.getStudentElements().isEmpty()) {
        sb.append(" ' " + m.getMistakeType().getName() + " ' " + " Inst Elements: ");
        m.getInstructorElements().forEach(ie -> sb.append(ie.getElement().getName() + " "));
        sb.append(" student Elements:");
        m.getStudentElements().forEach(se -> sb.append(se.getElement().getName() + " "));
        sb.append("\n");
      } else if (!m.getInstructorElements().isEmpty()) {
        sb.append(" ' " + m.getMistakeType().getName() + " ' " + " Inst Elements: ");
        m.getInstructorElements().forEach(ie -> sb.append(ie.getElement().getName() + " "));
        sb.append("\n");
      } else if (!m.getStudentElements().isEmpty()) {
        sb.append(" ' " + m.getMistakeType().getName() + " ' " + " Stud Elements: ");
        m.getStudentElements().forEach(se -> sb.append(se.getElement().getName() + " "));
        sb.append("\n");
      } else {
        sb.append(" ' " + m.getMistakeType().getName() + " ' \n");
      }
    });
    return sb.toString();
  }

  /** Returns the comparison sorted log as a string. */
  public String getLog() {
    var sb = new StringBuilder();
    sb.append(getMappings());
    sb.append("\n");
    sb.append("Total Mistakes: "+ newMistakes.size() +"\nMistakes: \n");
    newMistakes.forEach(m -> {
      if (!m.getInstructorElements().isEmpty() && !m.getStudentElements().isEmpty()) {
        sb.append(" ' " + m.getMistakeType().getName() + " ' " + " Inst Elements: ");
        m.getInstructorElements().forEach(ie -> sb.append(ie.getElement().getName() + " "));
        sb.append(" Student Elements: ");
        m.getStudentElements().forEach(se -> sb.append(se.getElement().getName() + " "));
        sb.append("\n");
      } else if (!m.getInstructorElements().isEmpty()) {
        sb.append(" ' " + m.getMistakeType().getName() + " ' " + " Inst Elements: ");
        m.getInstructorElements().forEach(ie -> sb.append(ie.getElement().getName() + " "));
        sb.append("\n");
      } else if (!m.getStudentElements().isEmpty()) {
        sb.append(" ' " + m.getMistakeType().getName() + " ' " + " Stud Elements: ");
        m.getStudentElements().forEach(se -> sb.append(se.getElement().getName() + " "));
        sb.append("\n");
      } else {
        sb.append(" ' " + m.getMistakeType().getName() + " ' \n");
      }
    });
    return sb.toString();
  }

  public String getMappings() {
    var sb = new StringBuilder();
    sb.append("\n");
    sb.append("-----Comparison Log-----\n");
    sb.append("Not Mapped InstructorClassifier List: ");
    for (Classifier c: notMappedInstructorClassifiers) {
      sb.append(c.getName() + " ");
    }
    sb.append("\n");
    sb.append("Not Mapped extraStudentClassifier: ");
    for (Classifier c: extraStudentClassifiers) {
      sb.append(c.getName() + " ");
    }
    sb.append("\n");
    sb.append("Mapped Classifiers: \n");
    mappedClassifiers.forEach((key, value) -> sb.append(key.getName() + " = " + value.getName() + "\n"));
    sb.append("\n");
    sb.append("Not Mapped InstructorAttribute List: ");
    for (Attribute c: notMappedInstructorAttributes) {
      sb.append(c.getName() + " ");
    }
    sb.append("\n");
    sb.append("Not Mapped extraStudentAttribute: ");
    for (Attribute c: extraStudentAttributes) {
      sb.append(c.getName() + " ");
    }
    sb.append("\n");
    sb.append("duplicate Attribute: ");
    for (Attribute c: duplicateStudentAttributes) {
      sb.append(c.getName() + " ");
    }
    sb.append("\n");
    sb.append("Mapped Attributes: \n");
    mappedAttributes.forEach((key, value) -> sb.append(key.getType().getClass() + " " + key.getName() + " = "
        + value.getType().getClass() + " " + value.getName() + "\n"));

    sb.append("\n");
    sb.append("Not Mapped Association: ");
    for (Association assoc: notMappedInstructorAssociations) {
      sb.append(assoc.getName() + " ");
    }

    sb.append("\n");
    sb.append("Extra Association: ");
    for (Association assoc: extraStudentAssociations) {
      sb.append(assoc.getName() + " ");
    }
    sb.append("\n");
    sb.append("Mapped Association: \n");
    mappedAssociations.forEach((key, value) -> sb.append(key.getName() + " " + value.getName() + "\n"));

    sb.append("\n");
    sb.append("Mapped Enumerations: \n");
    mappedEnumerations.forEach((key, value) -> sb.append(key.getName() + " " + value.getName() + "\n"));

    sb.append("\n");
    sb.append("Not Mapped Enumerations: ");
    for (CDEnum c: notMappedInstructorEnums) {
      sb.append(c.getName() + " ");
    }
    sb.append("\n");
    sb.append("Extra Enumeration: ");
    for (CDEnum c: extraStudentEnums) {
      sb.append(c.getName() + " ");
    }

    sb.append("\n");
    sb.append("Mapped Enumerations items: \n");
    mappedEnumerationItems.forEach((key, value) -> sb.append(key.getName() + " " + value.getName() + "\n"));

    sb.append("\n");
    sb.append("Not Mapped Enumerations items: ");
    for (CDEnumLiteral c: notMappedInstructorEnumLiterals) {
      sb.append(c.getName() + " ");
    }
    sb.append("\n");
    sb.append("Extra Enumeration items: ");
    for (CDEnumLiteral c: extraStudentEnumLiterals) {
      sb.append(c.getName() + " ");
    }

    sb.append("\n");
    sb.append("Instuctor Generalizations: \n");
    instructorSuperclassesToSubclasses.forEach((key, value) -> {
      sb.append(key.getName() + "<- ");
      value.forEach(v -> {sb.append(v.getName() + " ");});
      sb.append("\n");
    });

    sb.append("\n");
    sb.append("Student Generalizations: \n");
    studentSuperclassesToSubclasses.forEach((key, value) -> {
      sb.append(key.getName() + "<- ");
      value.forEach(v -> sb.append(v.getName() + " "));
      sb.append("\n");
    });

    sb.append("\n");
    sb.append("instructor Generalization classes: ");
    for (Classifier c: instructorGeneralizationClassifiers) {
      sb.append(c.getName() + " ");
    }

    sb.append("\n");
    sb.append("student Generalization classes: ");
    for (Classifier c: studentGeneralizationClassifiers) {
      sb.append(c.getName() + " ");
    }

    return sb.toString();
  }

  public static List<Mistake> getSortedMistakeList(List<Mistake> mistakes){
    Collections.sort(mistakes, Comparator.comparing(Mistake::getMistakeType));
    return mistakes;
  }

}
