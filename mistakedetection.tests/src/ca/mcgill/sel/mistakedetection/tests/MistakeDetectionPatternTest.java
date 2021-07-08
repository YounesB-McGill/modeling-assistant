package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.MistakeDetection.ASSOC_PR_PATTERN;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.ENUM_PR_PATTERN;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.FULL_PR_PATTERN;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.SUB_CLASS_PR_PATTERN;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.checkPattern;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
// TODO Remove the below deprecated imports (and this comment) and replace with the commented line.
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.setPlayerTagToClassInClassDiag;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.setRoleTagToAssocEndInClass;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.setRoleTagToAttribInClass;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.setRoleTagToClassInClassDiag;
//import static modelingassistant.util.TagUtils.*;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static modelingassistant.TagType.PLAYER;
import static modelingassistant.TagType.ROLE;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;


/**
 * This class will be used to test Modeling AntiPatterns or misuse of design patterns.
 *
 * @author Prabhsimran Singh
 */
public class MistakeDetectionPatternTest {

  /**
   * Test to check assigning of Tag and TagGroup
   */
  @Test
  public void testPluralClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_Pattern/Class Diagram/Instructor_subClassPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeStudent", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeStudent", tagGroup, instructorClassDiagram);

    assertEquals(PLAYER, instructorSolution.getSolutionElementByName("Student").getTags().get(0).getTagType());
    assertEquals(ROLE, instructorSolution.getSolutionElementByName("FullTimeStudent").getTags().get(0).getTagType());
    assertEquals(ROLE, instructorSolution.getSolutionElementByName("PartTimeStudent").getTags().get(0).getTagType());
  }

  /**
   * Test to detect subClass player role pattern
   */
  @Test
  public void testSubclassPRPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_Pattern/Class Diagram/Instructor_subClassPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeStudent", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeStudent", tagGroup, instructorClassDiagram);

    assertEquals(SUB_CLASS_PR_PATTERN, checkPattern(tagGroup));
  }

  /**
   * Test to detect full player role pattern
   */
  @Test
  public void testFullPRPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_FullPR_Pattern/Class Diagram/Instructor_FullPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeStudent", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeStudent", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));
  }

  /**
   * Test to detect Association role pattern
   */
  @Test
  public void testAssocPRPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_Pattern/Class Diagram/Instructor_assocPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    var projectClass = getClassFromClassDiagram("Project", instructorClassDiagram);
    setRoleTagToAssocEndInClass("fullTimeStudent", tagGroup, projectClass);
    setRoleTagToAssocEndInClass("partTimeStudent", tagGroup, projectClass);

    assertEquals(ASSOC_PR_PATTERN, checkPattern(tagGroup));
  }

  /**
   * Test to detect Enumeration role pattern
   */
  @Test
  public void testEnumPRPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_pattern/Class Diagram/Instructor_enumPR_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    var studentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    setRoleTagToAttribInClass("level", tagGroup, studentClass);

    assertEquals(ENUM_PR_PATTERN, checkPattern(tagGroup));
  }

  /**
   * Test to check subClass player role pattern in studentSolution
   */
  @Test
  public void testStudentSubclassPRPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_Pattern/Class Diagram/Instructor_subClassPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeStudent", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeStudent", tagGroup, instructorClassDiagram);

    assertEquals(SUB_CLASS_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_Pattern/Class Diagram/Instructor_subClassPR_Pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to inst subClass - student subClass pattern --");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("-----");
    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
  }

  /**
   * Test to check Full player role pattern in studentSolution
   */
  @Test
  public void testStudentFullPRPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_FullPR_Pattern/Class Diagram/Instructor_FullPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeStudent", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeStudent", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_FullPR_Pattern/Class Diagram/Instructor_FullPR_Pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to inst Full - student Full pattern --");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("-----");
    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
  }

  /**
   * Test to check association player role pattern in studentSolution
   */
  @Test
  public void testStudentAssocPRPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_Pattern/Class Diagram/Instructor_assocPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    var projectClass = getClassFromClassDiagram("Project", instructorClassDiagram);
    setRoleTagToAssocEndInClass("fullTimeStudent", tagGroup, projectClass);
    setRoleTagToAssocEndInClass("partTimeStudent", tagGroup, projectClass);

    assertEquals(ASSOC_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_Pattern/Class Diagram/Instructor_assocPR_Pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to inst Assoc - student Assoc pattern --");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("-----");
    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
  }

  /**
   * Test to check enumeration player role pattern in studentSolution
   */
  @Test
  public void testStudentEnumPRPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_pattern/Class Diagram/Instructor_enumPR_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    var studentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    setRoleTagToAttribInClass("level", tagGroup, studentClass);

    assertEquals(ENUM_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_pattern/Class Diagram/Instructor_enumPR_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to inst enum- student enum pattern --");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("-----");
    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
  }

  /**
   * Test to check Full player role pattern instead of Subclass in studentSolution
   */
  @Test
  public void testFullPRInsteadOfSubclassPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_Pattern/Class Diagram/Instructor_subClassPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeStudent", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeStudent", tagGroup, instructorClassDiagram);

    assertEquals(SUB_CLASS_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_FullPR_Pattern/Class Diagram/Instructor_FullPR_Pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to check Full PR insted of Subclass --");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("---------------");
    assertEquals(3, comparison.newMistakes.size());
    assertEquals(3, studentSolution.getMistakes().size());
  }

  /**
   * Test to check Enum player role pattern instead of Subclass in studentSolution
   */
  @Test
  public void testEnumPRInsteadOfSubclassPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_Pattern/Class Diagram/Instructor_subClassPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeStudent", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeStudent", tagGroup, instructorClassDiagram);

    assertEquals(SUB_CLASS_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_pattern/Class Diagram/Instructor_enumPR_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to check Enum PR insted of Subclass --");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("---------------");
    assertEquals(5, comparison.newMistakes.size());
    assertEquals(5, studentSolution.getMistakes().size());
  }

  /**
   * Test to check Assoc player role pattern instead of Subclass in studentSolution
   */
  @Test
  public void testAssocPRInsteadOfSubclassPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_Pattern/Class Diagram/Instructor_subClassPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeStudent", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeStudent", tagGroup, instructorClassDiagram);

    assertEquals(SUB_CLASS_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_Pattern/Class Diagram/Instructor_assocPR_Pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to check Assoc PR insted of Subclass --");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("---------------");
    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());
  }

  /**
   * Test to check subClass player role pattern instead of Full in studentSolution
   */
  @Test
  public void testSubPRInsteadOfFullClassPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_FullPR_Pattern/Class Diagram/Instructor_FullPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeStudent", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeStudent", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_Pattern/Class Diagram/Instructor_subClassPR_Pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to check Sub Class PR insted of Full PR--");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("---------------");
    assertEquals(3, comparison.newMistakes.size());
    assertEquals(3, studentSolution.getMistakes().size());
  }

  /**
   * Test to check Assoc player role pattern instead of Full in studentSolution
   */
  @Test
  public void testAssocPRInsteadOfFullClassPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_FullPR_Pattern/Class Diagram/Instructor_FullPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeStudent", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeStudent", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_Pattern/Class Diagram/Instructor_assocPR_Pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to check Assoc PR insted of Full PR--");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("---------------");
    assertEquals(8, comparison.newMistakes.size());
    assertEquals(8, studentSolution.getMistakes().size());
  }

  /**
   * Test to check Enum player role pattern instead of Full in studentSolution
   */
  @Test
  public void testEnumPRInsteadOfFullClassPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_FullPR_Pattern/Class Diagram/Instructor_FullPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeStudent", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeStudent", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_pattern/Class Diagram/Instructor_enumPR_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to check Enum PR insted of Full PR--");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("---------------");
    assertEquals(8, comparison.newMistakes.size());
    assertEquals(8, studentSolution.getMistakes().size());
  }

  /**
   * Test to check subClass player role pattern instead of Assoc in studentSolution
   */
  @Test
  public void testSubPRInsteadOfAssocClassPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_Pattern/Class Diagram/Instructor_assocPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    var projectClass = getClassFromClassDiagram("Project", instructorClassDiagram);
    setRoleTagToAssocEndInClass("fullTimeStudent", tagGroup, projectClass);
    setRoleTagToAssocEndInClass("partTimeStudent", tagGroup, projectClass);

    assertEquals(ASSOC_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_Pattern/Class Diagram/Instructor_subClassPR_Pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to check Sub Class PR insted of Assoc PR--");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("---------------");
    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());
  }

  /**
   * Test to check Full player role pattern instead of Assoc in studentSolution
   */
  @Test
  public void testFullPRInsteadOfAssocClassPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_Pattern/Class Diagram/Instructor_assocPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    var projectClass = getClassFromClassDiagram("Project", instructorClassDiagram);
    setRoleTagToAssocEndInClass("fullTimeStudent", tagGroup, projectClass);
    setRoleTagToAssocEndInClass("partTimeStudent", tagGroup, projectClass);

    assertEquals(ASSOC_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_FullPR_Pattern/Class Diagram/Instructor_FullPR_Pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to check Full PR insted of Assoc PR--");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("---------------");
    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());
  }

  /**
   * Test to check Enum player role pattern instead of Assoc in studentSolution
   */
  @Test
  public void testEnumPRInsteadOfAssocClassPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_Pattern/Class Diagram/Instructor_assocPR_Pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    var projectClass = getClassFromClassDiagram("Project", instructorClassDiagram);
    setRoleTagToAssocEndInClass("fullTimeStudent", tagGroup, projectClass);
    setRoleTagToAssocEndInClass("partTimeStudent", tagGroup, projectClass);

    assertEquals(ASSOC_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_pattern/Class Diagram/Instructor_enumPR_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to check Enum PR insted of Assoc PR--");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("---------------");
    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());
  }

  /**
   * Test to check sub class player role pattern instead of Enum in studentSolution
   */
  @Test
  public void testSubclassPRInsteadOfEnumClassPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_pattern/Class Diagram/Instructor_enumPR_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    var studentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    setRoleTagToAttribInClass("level", tagGroup, studentClass);

    assertEquals(ENUM_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_Pattern/Class Diagram/Instructor_subClassPR_Pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to check Sub Class PR insted of Enum PR--");

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("---------------");
    assertEquals(5, comparison.newMistakes.size());
    assertEquals(5, studentSolution.getMistakes().size());
  }

  /**
   * Test to check Full player role pattern instead of Enum in studentSolution
   */
  @Test
  public void testFullPRInsteadOfEnumClassPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_pattern/Class Diagram/Instructor_enumPR_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    var studentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    setRoleTagToAttribInClass("level", tagGroup, studentClass);

    assertEquals(ENUM_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_FullPR_Pattern/Class Diagram/Instructor_FullPR_Pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to check Full PR insted of Enum PR--");

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("---------------");
    assertEquals(8, comparison.newMistakes.size());
    assertEquals(8, studentSolution.getMistakes().size());
  }

  /**
   * Test to check Assoc player role pattern instead of Enum in studentSolution
   */
  @Test
  public void testAssocPRInsteadOfEnumClassPattern() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_pattern/Class Diagram/Instructor_enumPR_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Student", instructorClassDiagram, instructorSolution);
    var studentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    setRoleTagToAttribInClass("level", tagGroup, studentClass);

    assertEquals(ENUM_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_Pattern/Class Diagram/Instructor_assocPR_Pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    System.out.println("---Test to check Assoc PR insted of Enum PR--");
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    System.out.println("--------");
    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());
  }
}
