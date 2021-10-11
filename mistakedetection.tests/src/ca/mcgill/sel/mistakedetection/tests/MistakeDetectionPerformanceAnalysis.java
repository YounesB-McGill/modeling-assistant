package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;

/**
 *
 * @author Prabhsimran Singh
 *
 * This class is used to collect the performance data (e.g time of execution, number and types of mistakes detected)
 *  of the mistake detection algorithm run on the domain models created by students.
 *
 */

public class MistakeDetectionPerformanceAnalysis {

  @Test
  public void testStudentSoltion1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/instructorSolution/instructorSolution/Class Diagram/InstructorSolution.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel - 1/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println(studentSolution.getMistakes().size());
   // MistakeDetectionTest.log(comparison);
  }

  @Test
  public void testStudentSoltion2() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/instructorSolution/instructorSolution/Class Diagram/InstructorSolution.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel - 2/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

   // MistakeDetectionTest.log(comparison);

  }
}
