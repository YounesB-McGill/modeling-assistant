package ca.mcgill.sel.mistakedetection.tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

public class MistakeDetectionRunAllTest {
  
  @RunWith(JUnitPlatform.class)
  @SelectClasses({MistakeDetectionFunctionLogicTest.class, MistakeDetectionPatternTest.class, MistakeDetectionTest.class, MistakeDetectionWrongAttributeTest.class, MistakeDetectionWrongClassTest.class, MistakeDetectionWrongRelationshipsTest.class})
  public class AllUnitTest {}
  
}
