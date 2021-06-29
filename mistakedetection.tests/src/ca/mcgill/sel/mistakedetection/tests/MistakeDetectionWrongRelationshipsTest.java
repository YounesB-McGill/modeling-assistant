package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAssociationEndFromClass;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAssociationFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getClassFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ROLE_NAME_SPELLING;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
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
  public void testToCheckRelationshipMappings() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_bus_driver_associ/Class Diagram/Instructor_bus_driver_associ.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_bus_driver_associ/Class Diagram/Instructor_bus_driver_associ.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);
    var instructorAssociations = getAssociationFromClassDiagram(instructorBusClass, instructorDriverClass, instructorClassDiagram);
    var instructorAssociation_1 = instructorAssociations.get(0);
    var instructorAssociation_2 = instructorAssociations.get(1);

    var studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    var studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);
    var studentAssociations = getAssociationFromClassDiagram(studentBusClass, studentDriverClass, studentClassDiagram);
    var studentAssociation_1 = instructorAssociations.get(0);
    var studentAssociation_2 = instructorAssociations.get(1);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
    assertEquals(instructorAssociation_1, studentAssociation_1);
    assertEquals(instructorAssociation_2, studentAssociation_2);
  }

  /**
   * Test to check mapping of relationships .
   */
  @Test
  public void testToCheckRelationshipMapping() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_bus_driver_associ/Class Diagram/Instructor_bus_driver_associ.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_bus_driver_assoc/Class Diagram/Student_bus_driver_assoc.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);
    var instructorAssociations = getAssociationFromClassDiagram(instructorBusClass, instructorDriverClass, instructorClassDiagram);
    var instructorAssociation_1 = instructorAssociations.get(0);
    var instructorAssociation_2 = instructorAssociations.get(1);

    var studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    var studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);
    var studentAssociations = getAssociationFromClassDiagram(studentBusClass, studentDriverClass, studentClassDiagram);
    var studentAssociation_1 = instructorAssociations.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(3, comparison.newMistakes.size()); // Missing association, 2 X Wrong Role Names
    assertEquals(3, studentSolution.getMistakes().size());
    assertEquals(instructorAssociation_1, studentAssociation_1);

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
      assertMistake(m, BAD_ROLE_NAME_SPELLING, studentMyDrivrAssociationEnd, instructorMyDriverAssociationEnd, 0, 1,
          false);
    }
  }

}
