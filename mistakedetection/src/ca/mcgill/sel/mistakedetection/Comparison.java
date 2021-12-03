package ca.mcgill.sel.mistakedetection;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
  public Map<Classifier, Classifier> mappedClassifier = new HashMap<Classifier, Classifier>();

  /** Maps an instructor solution classifier attribute to student solution classifier attribute. */
  public Map<Attribute, Attribute> mappedAttribute = new HashMap<Attribute, Attribute>();

  /** Maps an instructor solution classifier relation to student solution classifier relation. */
  public Map<Association, Association> mappedAssociation = new HashMap<Association, Association>();

  /** Maps an instructor solution enumeration relation to student solution enumeration. */
  public Map<CDEnum, CDEnum> mappedEnumeration = new HashMap<CDEnum, CDEnum>();

  /** Maps an instructor solution enumeration item relation to student solution enumeration item. */
  public Map<CDEnumLiteral, CDEnumLiteral> mappedEnumerationItems = new HashMap<CDEnumLiteral, CDEnumLiteral>();

  public EList<Classifier> notMappedInstructorClassifier = new BasicEList<Classifier>();
  public EList<Classifier> extraStudentClassifier = new BasicEList<Classifier>();

  public EList<Attribute> notMappedInstructorAttribute = new BasicEList<Attribute>();
  public EList<Attribute> extraStudentAttribute = new BasicEList<Attribute>();
  public EList<Attribute> duplicateStudentAttribute = new BasicEList<Attribute>();

  public EList<Association> notMappedInstructorAssociation = new BasicEList<Association>();
  public EList<Association> extraStudentAssociation = new BasicEList<Association>();

  public EList<CDEnum> notMappedInstructorEnum= new BasicEList<CDEnum>();
  public EList<CDEnum> extraStudentEnum = new BasicEList<CDEnum>();

  public EList<CDEnumLiteral> notMappedInstructorEnumLiterals = new BasicEList<CDEnumLiteral>();
  public EList<CDEnumLiteral> extraStudentEnumLiterals = new BasicEList<CDEnumLiteral>();

  public EList<Mistake> newMistakes = new BasicEList<Mistake>();

  /** List to store association classes to remove from mapped classes. */
  public EList<Classifier> assocClassifiersToRemove = new BasicEList<Classifier>();

  /** Map stores possible instructor student Association Class pair that are detected after initial class mapping. */
  public Map<Classifier, Classifier> assocClassMappingToAdd = new HashMap<Classifier, Classifier>();

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
