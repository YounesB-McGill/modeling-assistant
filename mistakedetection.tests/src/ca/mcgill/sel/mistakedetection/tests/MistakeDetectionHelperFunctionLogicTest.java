package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import ca.mcgill.sel.mistakedetection.MistakeDetectionUtils;

public class MistakeDetectionHelperFunctionLogicTest extends MistakeDetectionBaseTest {

  /**
   * Tests for checking Software Engineering terms, eg, CarData.
   */
  @Test
  public void testCheckingSoftwareEngineeringTerm() {
    List.of("Car", "Driver", "Part").forEach(s -> assertFalse(MistakeDetection.isSoftwareEngineeringTerm(s)));
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
    assertTrue(MistakeDetectionUtils.isLowerName("class1"));
    assertFalse(MistakeDetectionUtils.isLowerName("Class1"));
  }
}
