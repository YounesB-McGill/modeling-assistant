package ca.mcgill.sel.mistakedetection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.CDEnum;
import ca.mcgill.sel.classdiagram.CDEnumLiteral;
import ca.mcgill.sel.classdiagram.Classifier;
import modelingassistant.Mistake;

/**
 * Helper class to represent information about a mistake detection comparison.
 */
public class Comparison {

  // TODO Refactor lists and hashmaps

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

  /** Map stores possible instructor student Association Class pair that are detected after initial class mapping. */
  public Map<Classifier, Classifier> assocClassMappingToAdd = new HashMap<>();

  /**
   * Function to print the mapped, unmapped classifier or attributes.
   */
  public void log() {
    System.out.println();
    System.out.println("----Test Logger-----");
    System.out.print("Not Mapped InstructorClassifier List : ");
    for (Classifier c : notMappedInstructorClassifiers) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Not Mapped extraStudentClassifier : ");
    for (Classifier c : extraStudentClassifiers) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.println("Mapped Classifiers : ");
    mappedClassifiers.forEach((key, value) -> System.out.println(key.getName() + " = " + value.getName()));
    System.out.println();
    System.out.print("Not Mapped InstructorAttribute List : ");
    for (Attribute c : notMappedInstructorAttributes) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Not Mapped extraStudentAttribute : ");
    for (Attribute c : extraStudentAttributes) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("duplicate Attribute : ");
    for (Attribute c : duplicateStudentAttributes) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.println("Mapped Attributes : ");
    mappedAttributes.forEach((key, value) -> System.out.println(
        key.getType().getClass() + " " + key.getName() + " = " + value.getType().getClass() + " " + value.getName()));

    System.out.println();
    System.out.print("Not Mapped Association : ");
    for (Association assoc : notMappedInstructorAssociations) {
      System.out.print(assoc.getName() + " ");
    }

    System.out.println();
    System.out.print("Extra Association : ");
    for (Association assoc : extraStudentAssociations) {
      System.out.print(assoc.getName() + " ");
    }
    System.out.println();
    System.out.println("Mapped Association : ");
    mappedAssociations.forEach((key, value) -> System.out.println(key.getName() + " " + value.getName()));

    System.out.println();
    System.out.println("Mapped Enumerations : ");
    mappedEnumerations.forEach((key, value) -> System.out.println(key.getName() + " " + value.getName()));

    System.out.println();
    System.out.print("Not Mapped Enumerations : ");
    for (CDEnum c : notMappedInstructorEnums) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Extra Enumeration : ");
    for (CDEnum c : extraStudentEnums) {
      System.out.print(c.getName() + " ");
    }

    System.out.println();
    System.out.println("Mapped Enumerations items: ");
    mappedEnumerationItems
        .forEach((key, value) -> System.out.println(key.getName() + " " + value.getName()));

    System.out.println();
    System.out.print("Not Mapped Enumerations items : ");
    for (CDEnumLiteral c : notMappedInstructorEnumLiterals) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Extra Enumeration items: ");
    for (CDEnumLiteral c : extraStudentEnumLiterals) {
      System.out.print(c.getName() + " ");
    }

    System.out.println();
    System.out.println("Mistakes : ");
    newMistakes.forEach(m -> {
      if (!m.getInstructorElements().isEmpty() && !m.getStudentElements().isEmpty()) {
        System.out.print(" ' " + m.getMistakeType().getName() + " ' " + " Inst Elements : ");
        m.getInstructorElements().forEach(ie -> System.out.print(ie.getElement().getName() + " "));
        System.out.print(" student Elements :");
        m.getStudentElements().forEach(se -> System.out.print(se.getElement().getName() + " "));
        System.out.println();
      } else if (!m.getInstructorElements().isEmpty()) {
        System.out.print(" ' " + m.getMistakeType().getName() + " ' " + " Inst Elements : ");
        m.getInstructorElements().forEach(ie -> System.out.print(ie.getElement().getName() + " "));
        System.out.println();
      } else if (!m.getStudentElements().isEmpty()) {
        System.out.print(" ' " + m.getMistakeType().getName() + " ' " + " Stud Elements : ");
        m.getStudentElements().forEach(se -> System.out.print(se.getElement().getName() + " "));
        System.out.println();
      } else {
        System.out.println(" ' " + m.getMistakeType().getName() + " ' ");
      }
    });
  }

  /**
   * Function to print the mapped, unmapped classifier or attributes.
   */
  public void log() {
    var comparison = this;
    System.out.println();
    System.out.println("----Test Logger-----");
    System.out.print("Not Mapped InstructorClassifier List : ");
    for (Classifier c : comparison.notMappedInstructorClassifier) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Not Mapped extraStudentClassifier : ");
    for (Classifier c : comparison.extraStudentClassifier) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.println("Mapped Classifiers : ");
    comparison.mappedClassifier.forEach((key, value) -> System.out.println(key.getName() + " = " + value.getName()));
    System.out.println();
    System.out.print("Not Mapped InstructorAttribute List : ");
    for (Attribute c : comparison.notMappedInstructorAttribute) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Not Mapped extraStudentAttribute : ");
    for (Attribute c : comparison.extraStudentAttribute) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("duplicate Attribute : ");
    for (Attribute c : comparison.duplicateStudentAttribute) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.println("Mapped Attributes : ");
    comparison.mappedAttribute.forEach((key, value) -> System.out.println(
        key.getType().getClass() + " " + key.getName() + " = " + value.getType().getClass() + " " + value.getName()));

    System.out.println();
    System.out.print("Not Mapped Association : ");
    for (Association assoc : comparison.notMappedInstructorAssociation) {
      System.out.print(assoc.getName() + " ");
    }

    System.out.println();
    System.out.print("Extra Association : ");
    for (Association assoc : comparison.extraStudentAssociation) {
      System.out.print(assoc.getName() + " ");
    }
    System.out.println();
    System.out.println("Mapped Association : ");
    comparison.mappedAssociation.forEach((key, value) -> System.out.println(key.getName() + " " + value.getName()));

    System.out.println();
    System.out.println("Mapped Enumerations : ");
    comparison.mappedEnumeration.forEach((key, value) -> System.out.println(key.getName() + " " + value.getName()));

    System.out.println();
    System.out.print("Not Mapped Enumerations : ");
    for (CDEnum c : comparison.notMappedInstructorEnum) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Extra Enumeration : ");
    for (CDEnum c : comparison.extraStudentEnum) {
      System.out.print(c.getName() + " ");
    }

    System.out.println();
    System.out.println("Mapped Enumerations items: ");
    comparison.mappedEnumerationItems
        .forEach((key, value) -> System.out.println(key.getName() + " " + value.getName()));

    System.out.println();
    System.out.print("Not Mapped Enumerations items : ");
    for (CDEnumLiteral c : comparison.notMappedInstructorEnumLiterals) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Extra Enumeration items: ");
    for (CDEnumLiteral c : comparison.extraStudentEnumLiterals) {
      System.out.print(c.getName() + " ");
    }

    System.out.println();
    System.out.println("Mistakes : ");
    comparison.newMistakes.forEach(m -> {
      if (!m.getInstructorElements().isEmpty() && !m.getStudentElements().isEmpty()) {
        System.out.print(" ' " + m.getMistakeType().getName() + " ' " + " Inst Elements : ");
        m.getInstructorElements().forEach(ie -> System.out.print(ie.getElement().getName() + " "));
        System.out.print(" student Elements :");
        m.getStudentElements().forEach(se -> System.out.print(se.getElement().getName() + " "));
        System.out.println();
      } else if (!m.getInstructorElements().isEmpty()) {
        System.out.print(" ' " + m.getMistakeType().getName() + " ' " + " Inst Elements : ");
        m.getInstructorElements().forEach(ie -> System.out.print(ie.getElement().getName() + " "));
        System.out.println();
      } else if (!m.getStudentElements().isEmpty()) {
        System.out.print(" ' " + m.getMistakeType().getName() + " ' " + " Stud Elements : ");
        m.getStudentElements().forEach(se -> System.out.print(se.getElement().getName() + " "));
        System.out.println();
      } else {
        System.out.println(" ' " + m.getMistakeType().getName() + " ' ");
      }
    });
  }

}
