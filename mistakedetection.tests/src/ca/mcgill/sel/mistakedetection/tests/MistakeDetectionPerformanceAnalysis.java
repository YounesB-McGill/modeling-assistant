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
public class MistakeDetectionPerformanceAnalysis extends MistakeDetectionBaseTest {

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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);

  }

  @Test
  public void testStudentSolution2() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G12_5/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
//    System.out.println(studentSolution.getMistakes().size());
//    System.out.println(comparison.newMistakes.size());
//  MistakeDetectionTest.log(comparison);

  }

  @Test
  public void testStudentSolution3() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G12_9/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
//    System.out.println(studentSolution.getMistakes().size());
//    System.out.println(comparison.newMistakes.size());
//    MistakeDetectionTest.log(comparison);

  }

  @Test
  public void testStudentSolution4() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G12_11/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution5() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G13_3/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution6() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G13_7/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution7() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G13_10/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);

  }

  @Test
  public void testStudentSolution8() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G14_4/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution9() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G14_8/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution10() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G14_15/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution11() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G15_3/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution12() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G15_7/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution13() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G15_16/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution14() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G16_9/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution15() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G16_11/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution16() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G16_12/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution17() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G17_5/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution18() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G17_8/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution19() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G17_12/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution20() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/studentSolution/studentDomainModel_G17_25/Class Diagram/StudentDomainModel.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

}
