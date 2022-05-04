package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static modelingassistant.util.SynonymUtils.setSynonymToClassInClassDiag;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;

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

    var studentClassDiagram =  cdmFromFile(STUDENT_CDM_PATH + "student_classCaptain/Class Diagram/student_classCaptain.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    setSynonymToClassInClassDiag("Pilot", List.of("flier", "captain", "aviator"), instructorClassDiagram, instructorSolution);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false).log();

    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
  }
}
