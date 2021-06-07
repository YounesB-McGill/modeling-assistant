package ca.mcgill.sel.mistakedetection.tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * 
 * 
 * @author Simran's PC
 * To run all the tests Run this file : Run As-> Run Configurations -> Run all tests in selected project .. -> Run
 */
public class MistakeDetectionRunAllTest {
  
  @RunWith(JUnitPlatform.class)
  @SelectClasses({MistakeDetectionFunctionLogicTest.class, MistakeDetectionPatternTest.class, MistakeDetectionTest.class, MistakeDetectionWrongAttributeTest.class, MistakeDetectionWrongClassTest.class, MistakeDetectionWrongRelationshipsTest.class})
  public class AllUnitTest {}
  
}
