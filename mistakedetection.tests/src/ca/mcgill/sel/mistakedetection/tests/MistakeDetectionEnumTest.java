package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ENUM_ITEM_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ENUM_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ENUM;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getEnumFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getEnumLiteralFromEnum;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;

public class MistakeDetectionEnumTest {

  /**
   * Test to check wrong enumeration name spelling.
   */
  @Test
  public void testWrongEnrollmentEnumSpelling() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestEnum/instructor_fullTimeStudent/Class Diagram/Instructor_fullTimeStudent.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/student_enrollmentWrongEnrollmentSpell/Class Diagram/Student_enrollmentStudent.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorEnrollmentEnum = getEnumFromClassDiagram("Enrollment", instructorClassDiagram);
    var studentEnrollmentEnum = getEnumFromClassDiagram("Enrollmnt", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), BAD_ENUM_NAME_SPELLING, studentEnrollmentEnum,
        instructorEnrollmentEnum, 0, 1, false);
  }

  /**
   * Test to check wrong enumeration name spelling.
   */
  @Test
  public void testWrongEnrollmentSpellingEnum() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestEnum/instructor_fullTimeStudent/Class Diagram/Instructor_fullTimeStudent.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/student_enrollmentWrongEnumSpell/Class Diagram/Student_enrollmentStudent.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorEnrollmentEnum = getEnumFromClassDiagram("Enrollment", instructorClassDiagram);
    var studentEnrollmentEnum = getEnumFromClassDiagram("Enrollmant", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), BAD_ENUM_NAME_SPELLING, studentEnrollmentEnum,
        instructorEnrollmentEnum, 0, 1, false);
  }

  /**
   * Test to check wrong enumeration literal spelling.
   */
  @Test
  public void testWrongEnumLiteralFullTimeSpelling() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestEnum/instructor_fullTimeStudent/Class Diagram/Instructor_fullTimeStudent.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/student_wrongFullTimeSpelling/Class Diagram/Student_enrollmentStudent.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorEnrollmentEnum = getEnumFromClassDiagram("Enrollment", instructorClassDiagram);
    var studentEnrollmentEnum = getEnumFromClassDiagram("Enrollment", studentClassDiagram);

    var instructorEnrollmentLiteral = getEnumLiteralFromEnum("FullTimeStudent", instructorEnrollmentEnum);
    var studentEnrollmentLiteral = getEnumLiteralFromEnum("FulTimeStudent", studentEnrollmentEnum);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), BAD_ENUM_ITEM_SPELLING, studentEnrollmentLiteral,
        instructorEnrollmentLiteral, 0, 1, false);
  }

  /**
   * Test to check wrong enumeration literal spelling.
   */
  @Test
  public void testWrongEnumLiteralPartTimeSpelling() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestEnum/instructor_fullTimeStudent/Class Diagram/Instructor_fullTimeStudent.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/student_wrongPartTimeSpelling/Class Diagram/Student_enrollmentStudent.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorEnrollmentEnum = getEnumFromClassDiagram("Enrollment", instructorClassDiagram);
    var studentEnrollmentEnum = getEnumFromClassDiagram("Enrollment", studentClassDiagram);

    var instructorEnrollmentLiteral = getEnumLiteralFromEnum("PartTimeStudent", instructorEnrollmentEnum);
    var studentEnrollmentLiteral = getEnumLiteralFromEnum("PartTimeStudant", studentEnrollmentEnum);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), BAD_ENUM_ITEM_SPELLING, studentEnrollmentLiteral,
        instructorEnrollmentLiteral, 0, 1, false);
  }

  /**
   * Test to check wrong enumeration literal spelling.
   */
  @Test
  public void testWrongEnumLiteralGuestSpelling() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestEnum/instructor_fullTimeStudent/Class Diagram/Instructor_fullTimeStudent.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/student_wrongGuestSpelling/Class Diagram/Student_enrollmentStudent.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorEnrollmentEnum = getEnumFromClassDiagram("Enrollment", instructorClassDiagram);
    var studentEnrollmentEnum = getEnumFromClassDiagram("Enrollment", studentClassDiagram);

    var instructorEnrollmentLiteral = getEnumLiteralFromEnum("GuestStudent", instructorEnrollmentEnum);
    var studentEnrollmentLiteral = getEnumLiteralFromEnum("GustStudent", studentEnrollmentEnum);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), BAD_ENUM_ITEM_SPELLING, studentEnrollmentLiteral,
        instructorEnrollmentLiteral, 0, 1, false);
  }

  /**
   * Test to check wrong enumeration literal spelling.
   */
  @Test
  public void testWrongEnumLiteralExchangeSpelling() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestEnum/instructor_fullTimeStudent/Class Diagram/Instructor_fullTimeStudent.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/student_wrongExchangeSpelling/Class Diagram/Student_enrollmentStudent.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorEnrollmentEnum = getEnumFromClassDiagram("Enrollment", instructorClassDiagram);
    var studentEnrollmentEnum = getEnumFromClassDiagram("Enrollment", studentClassDiagram);

    var instructorEnrollmentLiteral = getEnumLiteralFromEnum("ExchangeStudent", instructorEnrollmentEnum);
    var studentEnrollmentLiteral = getEnumLiteralFromEnum("EchangeStudent", studentEnrollmentEnum);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), BAD_ENUM_ITEM_SPELLING, studentEnrollmentLiteral,
        instructorEnrollmentLiteral, 0, 1, false);
  }
  
  /**
   * Test to check enumeration class should be regular class.
   */
  @Test
  public void testEnumClassShouldBeRegClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/reg_class/Class Diagram/Reg_class.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/enum_Class/Class Diagram/Enum_Class.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var studentEnumClass = getEnumFromClassDiagram("Bus", studentClassDiagram); 

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    
    assertMistake(studentSolution.getMistakes().get(0), ENUM_SHOULD_BE_CLASS, studentEnumClass,
    		instructorClass, 0, 1, false);    
  }
  
  /**
   * Test to check regular class should be enumeration.
   */
  @Test
  public void testClassShouldBeEnum() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/enum_Class/Class Diagram/Enum_Class.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/reg_class/Class Diagram/Reg_class.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorEnrollmentEnum = getEnumFromClassDiagram("Bus", instructorClassDiagram); 
    var studentClass = getClassFromClassDiagram("Bus", studentClassDiagram);
   
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    
    assertMistake(studentSolution.getMistakes().get(0), CLASS_SHOULD_BE_ENUM, studentClass,
    		instructorEnrollmentEnum, 0, 1, false);
    
  }
  
}
