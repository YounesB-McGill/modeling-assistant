package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;

/**
 *
 * This class is used to collect the performance data (e.g time of execution, number and types of mistakes detected)
 *  of the mistake detection algorithm run on the domain models created by students.
 *
 *  @author Prabhsimran Singh
 *
 */

public class MistakeDetectionPerformanceAnalysis {

  //TODO To be completed in near future. The functions below are incomplete

  @Test
  public void testStudentSolution1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/instructorSolution/instructorSolution/Class Diagram/InstructorSolution.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel - 1/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

   // MistakeDetectionTest.log(comparison);
  }

  @Test
  public void testStudentSolution2() {
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
