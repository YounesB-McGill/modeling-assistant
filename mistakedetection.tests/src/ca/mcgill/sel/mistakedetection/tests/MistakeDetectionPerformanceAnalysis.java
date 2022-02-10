package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static modelingassistant.util.TagUtils.setAbstractionTagToClassInClassDiag;
import static modelingassistant.util.TagUtils.setOccurrenceTagToClassInClassDiag;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import modelingassistant.Solution;
import modelingassistant.TagGroup;

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
  ClassDiagram instructorClassDiagram;
  Solution instructorSolution;

  MistakeDetectionPerformanceAnalysis(){
    instructorClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/instructorSolution/instructorSolution2/Class Diagram/InstructorSolution2.domain_model.cdm");
    instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);
    TagGroup tagGroup = setAbstractionTagToClassInClassDiag("RoomType", instructorClassDiagram, instructorSolution);
    setOccurrenceTagToClassInClassDiag("Room", tagGroup, instructorClassDiagram);
  }
  @Test
  public void testStudentSolution1() {

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G12_1/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
 //   System.out.println(studentSolution.getMistakes().size());
  //  System.out.println(comparison.newMistakes.size());
   // MistakeDetectionTest.log(comparison);
  }

  @Test
  public void testStudentSolution2() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G12_5/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
//    System.out.println(studentSolution.getMistakes().size());
//    System.out.println(comparison.newMistakes.size());
//  MistakeDetectionTest.log(comparison);

  }
}
