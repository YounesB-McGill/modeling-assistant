package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import org.junit.jupiter.api.Test;
import org.apache.commons.text.similarity.LevenshteinDistance;

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

  /**
   * Tests for checking Spelling Mistake in Class Name, eg Cars.
   */
  @Test public void testIsSpelledWrong() {
	
    String class1= "Car";
    String class2= "Car";
    LevenshteinDistance ld =new LevenshteinDistance();
    assertEquals(0, ld.apply(class1, class2));
    
    class1= "Car";
    class2= "Cer";
    assertEquals(1, ld.apply(class1, class2));
    
    class1= "Car";
    class2= "Carss";
    assertEquals(2, ld.apply(class1, class2));
  }
}
