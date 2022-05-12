package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ENUM_ITEM_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ENUM_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ENUM_ITEM;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ENUM_ITEM;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getEnumFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getEnumLiteralFromEnum;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;

public class MistakeDetectionEnumTest extends MistakeDetectionBaseTest {

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

    assertMistake(studentSolution.getMistakes().get(0), ENUM_SHOULD_BE_CLASS, studentEnumClass, instructorClass, 0, 1,
        false);
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

    assertMistake(studentSolution.getMistakes().get(0), CLASS_SHOULD_BE_ENUM, studentClass, instructorEnrollmentEnum, 0,
        1, false);
  }

  /**
   * Test to check extra enum.
   */
  @Test
  public void testExtraEnum() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestEnum/instructor_enum/Class Diagram/Enum.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/student_extra_enum/Class Diagram/Enum.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentRoleEnum = getEnumFromClassDiagram("NewRole", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), EXTRA_ENUM, studentRoleEnum, 0, 1, false);
  }

  /**
   * Test to check extra enum literal.
   */
  @Test
  public void testExtraEnumLiteral() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestEnum/instructor_enum/Class Diagram/Enum.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/student_extra_enumLiteral/Class Diagram/Enum.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentRoleEnum = getEnumFromClassDiagram("Role", studentClassDiagram);
    var studentEnumLiteral = getEnumLiteralFromEnum("NewStudent", studentRoleEnum);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), EXTRA_ENUM_ITEM, studentEnumLiteral, 0, 1, false);
  }

  /**
   * Test to check missing enum.
   */
  @Test
  public void testMissingEnum() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestEnum/instructor_enum/Class Diagram/Enum.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/student_missing_enum/Class Diagram/Enum.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRoleEnum = getEnumFromClassDiagram("Role", instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(1), MISSING_ENUM, instructorRoleEnum, 0, 1, false);
  }

  /**
   * Test to check missing enum literal.
   */
  @Test
  public void testMissingEnumLiteral() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestEnum/instructor_enum/Class Diagram/Enum.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/student_missing_enumLiteeral/Class Diagram/Enum.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRoleEnum = getEnumFromClassDiagram("Role", instructorClassDiagram);
    var instructorEnumLiteral = getEnumLiteralFromEnum("PartTimeStudent", instructorRoleEnum);

    var studentRoleEnum = getEnumFromClassDiagram("Role", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), MISSING_ENUM_ITEM, studentRoleEnum, instructorEnumLiteral, 0, 1, false);
  }

  /**
   * Test to check enumeration vs boolean using enum name.
   */
  @Test
  public void testClassEnumIsBoolean() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestEnum/instructor_enumBoolean/Class Diagram/EnumBoolean.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/student_enumBoolean/Class Diagram/EnumBoolean.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertTrue(comparison.newMistakes.isEmpty());
    assertTrue(studentSolution.getMistakes().isEmpty());
  }

  /**
   * Test to check enumeration vs boolean using attribute name.
   */
  @Test
  public void testClassEnumIsBoolean2() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestEnum/instructor_enumBoolean/Class Diagram/EnumBoolean.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestEnum/student_enumBoolean2/Class Diagram/EnumBoolean.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertTrue(comparison.newMistakes.isEmpty());
    assertTrue(studentSolution.getMistakes().isEmpty());
  }

}
