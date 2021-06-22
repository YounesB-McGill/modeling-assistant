package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.cdmFromFile;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAssociationEndFromClass;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getClassFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ROLE_NAME_SPELLING;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import modelingassistant.Mistake;

public class MistakeDetectionWrongRelationshipsTest {

  /**
   * Test to check mapping of relationships (No Mistakes).
   */
  @Test
  public void testToCheckRelationshipMapping() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/Class Diagram/Two(withAttributes).domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/two(withAttribute)/Class Diagram/Two(withAttribute).domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 0);
    assertEquals(studentSolution.getMistakes().size(), 0);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeIncorrectRoleName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/One/Class Diagram/InstructorSolution.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution-b.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);

    Classifier studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);

    AssociationEnd instructorMyDriverAssociationEnd = getAssociationEndFromClass("myDriver", instructorBusClass);

    AssociationEnd studentMyDrivrAssociationEnd = getAssociationEndFromClass("myDrivr", studentBusClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(comparison.newMistakes.size(), 1);
    assertEquals(studentSolution.getMistakes().size(), 1);

    for (Mistake m : studentSolution.getMistakes()) {
      assertTrue(assertMistake(m, BAD_ROLE_NAME_SPELLING, studentMyDrivrAssociationEnd,
          instructorMyDriverAssociationEnd, 0, 1, false));
    }
  }

}
