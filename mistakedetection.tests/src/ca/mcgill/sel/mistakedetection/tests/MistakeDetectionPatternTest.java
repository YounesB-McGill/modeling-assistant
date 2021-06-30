package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getSEelementfromSolution;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.setPlayerTagToClassInClassDiag;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.setRoleTagToClassInClassDiag;
import static modelingassistant.TagType.PLAYER;
import static modelingassistant.TagType.ROLE;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * This class will be used to test Modeling AntiPatterns or misuse of design patterns.
 *
 * @author Prabhsimran Singh
 */
public class MistakeDetectionPatternTest {

  /**
   * Test to check assigning of Tag and TagGroup
   */
  @Test
  public void testPluralClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_Pattern/Class Diagram/Instructor_subClassPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeStudent", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeStudent", tagGroup, instructorClassDiagram);

    assertEquals(PLAYER, getSEelementfromSolution("Student", instructorSolution).getTags().get(0).getTagType());
    assertEquals(ROLE, getSEelementfromSolution("FullTimeStudent", instructorSolution).getTags().get(0).getTagType());
    assertEquals(ROLE, getSEelementfromSolution("PartTimeStudent", instructorSolution).getTags().get(0).getTagType());
  }

}
