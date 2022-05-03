package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static modelingassistant.util.SynonymUtils.setSynonymToClassInClassDiag;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MistakeDetectionSynonymsTest {

  static final String INSTRUCTOR_CDM_PATH =
      "../mistakedetection/testModels/InstructorSolution/ModelToTestSynonyms/";
  static final String STUDENT_CDM_PATH = "../mistakedetection/testModels/StudentSolution/ModelToTestSynonyms/";


  /**
   * Test to check class mapping based on synonyms.
   */
  @Test
  public void testToCheckRelationshipMappings() {
    var instructorClassDiagram = cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_classPilot/Class Diagram/Instructor_classPilot.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);
    /*
    var studentClassDiagram =  cdmFromFile(STUDENT_CDM_PATH + "student_two_subClasses/Class Diagram/Two_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    */

    setSynonymToClassInClassDiag("Pilot", List.of("flier, captain, aviator"), instructorClassDiagram, instructorSolution);
  }
}
