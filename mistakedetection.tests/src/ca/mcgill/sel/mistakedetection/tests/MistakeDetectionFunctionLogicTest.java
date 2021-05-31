package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.Comparison;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import classdiagram.Attribute;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import modelingassistant.Mistake;
import modelingassistant.MistakeType;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.mistaketypes.MistakeTypes;
import modelingassistant.util.ResourceHelper;

public class MistakeDetectionFunctionLogicTest {

  /**
   * Tests for checking Software Engineering terms, eg, CarData.
   */
  @Test
  public void testCheckingSoftwareEngineeringTerm() {
    List.of("Car", "Driver", "Part")
        .forEach(s -> assertFalse(MistakeDetection.isSoftwareEngineeringTerm(s)));
    List.of("CarData", "DriverRecord", "PartInfo")
        .forEach(s -> assertTrue(MistakeDetection.isSoftwareEngineeringTerm(s)));
  }

  /**
   * Tests for checking Plural in Class Name, eg Cars.
   */
  @Test
  public void testIsPlural() {
    List.of("Car", "Driver").forEach(s -> assertFalse(MistakeDetection.isPlural(s)));
    List.of("Cars", "People", "Men").forEach(s -> assertTrue(MistakeDetection.isPlural(s)));
    List.of("Car", "Driver").forEach(s -> assertFalse(MistakeDetection.isPlural(s)));
    List.of("Cars", "People", "Men").forEach(s -> assertTrue(MistakeDetection.isPlural(s)));
  }

  /**
   * Tests for checking Spelling Mistake in Class Name, eg Cars.
   */
  @Test
  public void testIsSpelledWrong() {
    String class1 = "Car";
    String class2 = "Car";
    assertEquals(0, MistakeDetection.levenshteinDistance(class1, class2));
    class2 = "Cer";
    assertEquals(1, MistakeDetection.levenshteinDistance(class1, class2));
  }

  /**
   * Test to check if isLowerName working correctly.
   */
  @Test
  public void testCheckLowerCase() {
    assertTrue(MistakeDetection.isLowerName("class1"));
    assertFalse(MistakeDetection.isLowerName("Class1"));
  }

  /**
   * Function to print the mapped, unmapped classifier or attributes.
   */
  public void log(Comparison comparison) {
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
    comparison.mappedClassifier
        .forEach((key, value) -> System.out.println(key.getName() + " = " + value.getName()));
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
        key.getType() + " " + key.getName() + " = " + value.getType() + " " + value.getName()));
  }

  private boolean mistakesContainMistakeType(List<Mistake> mistakes, MistakeType mistakeType) {
    return mistakes.stream().anyMatch(mistake -> mistake.getMistakeType().equals(mistakeType));
  }
}
