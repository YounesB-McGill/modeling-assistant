package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import org.junit.jupiter.api.Test;

public class MistakeDetectionTest {

  /**
   * Tests for checking Software Engineering terms, eg, CarData.
   */
  @Test public void testCheckingSoftwareEngineeringTerm() {
    List.of("Car", "Driver", "Part").forEach(s -> assertFalse(MistakeDetection.isSoftwareEngineeringTerm(s)));
    List.of("CarData", "DriverRecord", "PartInfo").forEach(s ->
        assertTrue(MistakeDetection.isSoftwareEngineeringTerm(s)));
  }
  
  /**
   * Tests for checking Plural in Class Name, eg Cars.
   */
  @Test public void testIsPlural() {
    // check that singulars are not plural. The above method will fail for cases like Bus
    List.of("Car", "Driver", "Part").forEach(s -> assertFalse(MistakeDetection.isPlural(s)));
    
    // check that plurals are plural. The above method will fail for cases like Men
    List.of("Cars", "Drivers", "Parts").forEach(s -> assertTrue(MistakeDetection.isPlural(s)));
  }

}
