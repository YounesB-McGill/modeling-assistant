package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.MistakeDetection.ASSOC_PR_PATTERN;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.ENUM_PR_PATTERN;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.FULL_PR_PATTERN;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.SUB_CLASS_PR_PATTERN;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.checkPattern;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentMistakeFor;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOCIATION_SHOULD_BE_ENUM_PLAYER_ROLE_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOCIATION_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOCIATION_SHOULD_BE_SUBCLASS_PLAYER_ROLE_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_ASSOCIATION_PLAYER_ROLE_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_SUBCLASS_PLAYER_ROLE_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_SUBCLASS;
import static learningcorpus.mistaketypes.MistakeTypes.INCOMPLETE_ABSTRACTION_OCCURRENCE_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.INCOMPLETE_PLAYER_ROLE_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ABSTRACTION_OCCURRENCE_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_ASSOCIATION_PLAYER_ROLE_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_ENUM_PLAYER_ROLE_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN;
import static modelingassistant.TagType.PLAYER;
import static modelingassistant.TagType.ROLE;
import static modelingassistant.util.ClassDiagramUtils.getAssociationEndFromClass;
import static modelingassistant.util.ClassDiagramUtils.getAttributeFromClass;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getElementsFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getEnumFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static modelingassistant.util.TagUtils.setPlayerTagToClassInClassDiag;
import static modelingassistant.util.TagUtils.setRoleTagToAssocEndInClass;
import static modelingassistant.util.TagUtils.setRoleTagToAttribInClass;
import static modelingassistant.util.TagUtils.setRoleTagToClassInClassDiag;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.eclipse.emf.common.util.BasicEList;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.CDEnum;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.classdiagram.NamedElement;
import ca.mcgill.sel.mistakedetection.MistakeDetection;


/**
 * This class will be used to test Modeling AntiPatterns or misuse of design patterns.
 *
 * @author Prabhsimran Singh
 */
public class MistakeDetectionPatternTest {

  /**
   * Test to check assigning of Tag and TagGroup.
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
   * Test to detect subClass player role pattern.
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
   * Test to detect full player role pattern.
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
   * Test to detect Association role pattern.
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
   * Test to detect Enumeration role pattern.
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
   * Test to check subClass player role pattern in studentSolution.
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
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
  }

  /**
   * Test to check Full player role pattern in studentSolution.
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
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
  }

  /**
   * Test to check association player role pattern in studentSolution.
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
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
  }

  /**
   * Test to check enumeration player role pattern in studentSolution.
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
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
  }

  /**
   * Test to check Full player role pattern instead of Subclass in studentSolution.
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

    var instElements = studentDomainElements(instructorClassDiagram);
    var studElements = studentDomainElements(studentClassDiagram);
    var studStudentClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studStudentClass);
    assertMistake(studStudentClassMistake, FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_SUBCLASS, studElements, instElements, 0,
        1, false);
  }

  /**
   * Test to check Enum player role pattern instead of Subclass in studentSolution.
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

    var instElements = studentDomainElements(instructorClassDiagram);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);

    var studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    studElements.addAll(getEnumFromClassDiagram("StudentLevel", studentClassDiagram).getLiterals());

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());
    var studStudentClassMistake = studentMistakeFor(studStudentClass);
    assertMistake(studStudentClassMistake, ENUM_SHOULD_BE_SUBCLASS_PLAYER_ROLE_PATTERN, studElements, instElements, 0,
        1, false);
  }

  /**
   * Test to check Assoc player role pattern instead of Subclass in studentSolution.
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

    var instElements = studentDomainElements(instructorClassDiagram);

    var studElements = getElementsFromClassDiagram(studentClassDiagram, "Student", "fullTimeStudent",
        "partTimeStudent");
    var studStudentClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studStudentClass);
    assertMistake(studStudentClassMistake, ASSOCIATION_SHOULD_BE_SUBCLASS_PLAYER_ROLE_PATTERN, studElements,
        instElements, 0, 1, false);
  }

  /**
   * Test to check subClass player role pattern instead of Full in studentSolution.
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

    var instElements = studentDomainElements(instructorClassDiagram);

    var studElements = studentDomainElements(studentClassDiagram);
    var studStudentClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());
    var studStudentClassMistake = studentMistakeFor(studStudentClass);
    assertMistake(studStudentClassMistake, SUBCLASS_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN, studElements, instElements, 0,
        1, false);
  }

  /**
   * Test to check Assoc player role pattern instead of Full in studentSolution.
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

    var instElements = studentDomainElements(instructorClassDiagram);

    var studElements = studentProjectDomainElements(studentClassDiagram);
    var studStudentClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(8, comparison.newMistakes.size());
    assertEquals(8, studentSolution.getMistakes().size());
    var studStudentClassMistake = studentMistakeFor(studStudentClass);

    assertMistake(studStudentClassMistake, ASSOCIATION_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN, studElements,
        instElements, 0, 1, false);
  }

  /**
   * Test to check Enum player role pattern instead of Full in studentSolution.
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

    var instElements = studentDomainElements(instructorClassDiagram);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);

    List<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    studElements.addAll(getEnumFromClassDiagram("StudentLevel", studentClassDiagram).getLiterals());
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studStudentClass);
    assertMistake(studStudentClassMistake, ENUM_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1,
        false);
  }

  /**
   * Test to check subClass player role pattern instead of Assoc in studentSolution.
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

    var instElements = studentDomainElements(instructorClassDiagram);

    var studElements = studentDomainElements(studentClassDiagram);
    var studStudentClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(5, comparison.newMistakes.size());
    assertEquals(5, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studStudentClass);
    assertMistake(studStudentClassMistake, SUBCLASS_SHOULD_BE_ASSOCIATION_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1,
          false);
  }

  /**
   * Test to check Full player role pattern instead of Assoc in studentSolution.
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

    var instElements = studentProjectDomainElements(instructorClassDiagram);

    var studElements = studentDomainElements(studentClassDiagram);
    var studStudentClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(9, comparison.newMistakes.size());
    assertEquals(9, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studStudentClass);
    assertMistake(studStudentClassMistake, FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_ASSOCIATION, studElements, instElements, 0, 1,
          false);
  }

  /**
   * Test to check Enum player role pattern instead of Assoc in studentSolution.
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

    var instElements = studentProjectDomainElements(instructorClassDiagram);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);

    List<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    studElements.addAll(getEnumFromClassDiagram("StudentLevel", studentClassDiagram).getLiterals());
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studStudentClass);
    assertMistake(studStudentClassMistake, ENUM_SHOULD_BE_ASSOCIATION_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check sub class player role pattern instead of enum in studentSolution.
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instStudentClassLevelAttrib = getAttributeFromClass("level", instStudentClass);

    var instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instStudentClassLevelAttrib);

    var studElements = studentDomainElements(studentClassDiagram);
    var studStudentClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studStudentClass);
    assertMistake(studStudentClassMistake, SUBCLASS_SHOULD_BE_ENUM_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check full player role pattern instead of enum in studentSolution.
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instStudentClassLevelAttrib = getAttributeFromClass("level", instStudentClass);

    var instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instStudentClassLevelAttrib);

    var studElements = studentDomainElements(studentClassDiagram);
    var studStudentClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studStudentClass);
    assertMistake(studStudentClassMistake, FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_ENUM, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check assoc player role pattern instead of enum in studentSolution.
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instStudentClassLevelAttrib = getAttributeFromClass("level", instStudentClass);

    var instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instStudentClassLevelAttrib);

    var studElements = studentProjectDomainElements(studentClassDiagram);
    var studStudentClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(9, comparison.newMistakes.size());
    assertEquals(9, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studStudentClass);
    assertMistake(studStudentClassMistake, ASSOCIATION_SHOULD_BE_ENUM_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check full player role pattern instead of subclass in studentSolution.
   */
  @Test
  public void testFullPRInsteadOfSubclassPatternEmployeeExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_employeeExample_pattern/Class Diagram/Instructor_subClassPR_employeeExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Employee", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeEmployee", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeEmployee", tagGroup, instructorClassDiagram);

    assertEquals(SUB_CLASS_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_fullPR_employeeExample_pattern/Class Diagram/Instructor_fullPR_employeeExample_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = employeeElements(instructorClassDiagram);

    var studElements = employeeElements(studentClassDiagram);
    var studEmployeeClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studEmployeeClass);
    assertMistake(studStudentClassMistake, FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_SUBCLASS, studElements, instElements, 0,
        1, false);
  }

  /**
   * Test to check enum player role pattern instead of subclass in studentSolution.
   */
  @Test
  public void testEnumPRInsteadOfSubclassPatternEmployeeExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_employeeExample_pattern/Class Diagram/Instructor_subClassPR_employeeExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Employee", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeEmployee", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeEmployee", tagGroup, instructorClassDiagram);

    assertEquals(SUB_CLASS_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_employeeExample_pattern/Class Diagram/Instructor_enumPR_employeeExample_pattern.domain_model.cdm");

    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = employeeElements(instructorClassDiagram);

    var studEmployeeClass = getClassFromClassDiagram("Employee", studentClassDiagram);

    var studElements = List.of(studEmployeeClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());
    var studStudentClassMistake = studentMistakeFor(studEmployeeClass);
    assertMistake(studStudentClassMistake, ENUM_SHOULD_BE_SUBCLASS_PLAYER_ROLE_PATTERN, studElements, instElements, 0,
        1, false);
  }

  /**
   * Test to check assoc player role pattern instead of subclass in studentSolution.
   */
  @Test
  public void testAssocPRInsteadOfSubclassPatternEmployeeExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_employeeExample_pattern/Class Diagram/Instructor_subClassPR_employeeExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Employee", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeEmployee", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeEmployee", tagGroup, instructorClassDiagram);

    assertEquals(SUB_CLASS_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_employeeExample_pattern/Class Diagram/Instructor_assocPR_employeeExample_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = employeeElements(instructorClassDiagram);

    var studElements = employeeProjectElements(studentClassDiagram);
    var studEmployeeClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(5, comparison.newMistakes.size());
    assertEquals(5, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studEmployeeClass);
    assertMistake(studStudentClassMistake, ASSOCIATION_SHOULD_BE_SUBCLASS_PLAYER_ROLE_PATTERN, studElements,
        instElements, 0, 1, false);
  }

  /**
   * Test to check subClass player role pattern instead of full in studentsolution.
   */
  @Test
  public void testSubPRInsteadOfFullClassPatternEmployeeExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_fullPR_employeeExample_pattern/Class Diagram/Instructor_fullPR_employeeExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Employee", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeEmployee", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeEmployee", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_employeeExample_pattern/Class Diagram/Instructor_subClassPR_employeeExample_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = employeeElements(instructorClassDiagram);

    var studElements = employeeElements(studentClassDiagram);
    var studEmployeeClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());
    var studStudentClassMistake = studentMistakeFor(studEmployeeClass);
    assertMistake(studStudentClassMistake, SUBCLASS_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN, studElements, instElements, 0,
        1, false);
  }

  /**
   * Test to check assoc player role pattern instead of full in studentSolution.
   */
  @Test
  public void testAssocPRInsteadOfFullClassPatternEmployeeExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_fullPR_employeeExample_pattern/Class Diagram/Instructor_fullPR_employeeExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Employee", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeEmployee", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeEmployee", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_employeeExample_pattern/Class Diagram/Instructor_assocPR_employeeExample_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = employeeElements(instructorClassDiagram);

    var studElements = employeeElements(studentClassDiagram);
    var studEmployeeClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());
    var studStudentClassMistake = studentMistakeFor(studEmployeeClass);
    assertMistake(studStudentClassMistake, ASSOCIATION_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN, studElements,
        instElements, 0, 1, false);
  }

  /**
   * Test to check enum player role pattern instead of full in studentSolution.
   */
  @Test
  public void testEnumPRInsteadOfFullClassPatternEmployeeExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_fullPR_employeeExample_pattern/Class Diagram/Instructor_fullPR_employeeExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Employee", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeEmployee", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeEmployee", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_employeeExample_pattern/Class Diagram/Instructor_enumPR_employeeExample_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = employeeElements(instructorClassDiagram);

    var studEmployeeClass = getClassFromClassDiagram("Employee", studentClassDiagram);

    List<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studEmployeeClass);
    CDEnum studEnum = getEnumFromClassDiagram("EmployeeStatus", studentClassDiagram);
    studElements.addAll(studEnum.getLiterals());

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studEmployeeClass);
    assertMistake(studStudentClassMistake, ENUM_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check subClass player role pattern instead of assoc in studentSolution.
   */
  @Test
  public void testSubPRInsteadOfAssocClassPatternEmployeeExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_employeeExample_pattern/Class Diagram/Instructor_assocPR_employeeExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Employee", instructorClassDiagram, instructorSolution);
    var projectClass = getClassFromClassDiagram("Project", instructorClassDiagram);
    setRoleTagToAssocEndInClass("fullTimeEmployee", tagGroup, projectClass);
    setRoleTagToAssocEndInClass("partTimeEmployee", tagGroup, projectClass);

    assertEquals(ASSOC_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_employeeExample_pattern/Class Diagram/Instructor_subClassPR_employeeExample_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = employeeProjectElements(instructorClassDiagram);

    var studElements = employeeElements(studentClassDiagram);
    var studEmployeeClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studEmployeeClass);
    assertMistake(studStudentClassMistake, SUBCLASS_SHOULD_BE_ASSOCIATION_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1,
          false);
  }

  /**
   * Test to check full player role pattern instead of assoc in studentSolution.
   */
  @Test
  public void testFullPRInsteadOfAssocClassPatternEmployeeExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_employeeExample_pattern/Class Diagram/Instructor_assocPR_employeeExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Employee", instructorClassDiagram, instructorSolution);
    var projectClass = getClassFromClassDiagram("Project", instructorClassDiagram);
    setRoleTagToAssocEndInClass("fullTimeEmployee", tagGroup, projectClass);
    setRoleTagToAssocEndInClass("partTimeEmployee", tagGroup, projectClass);

    assertEquals(ASSOC_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_fullPR_employeeExample_pattern/Class Diagram/Instructor_fullPR_employeeExample_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = employeeProjectElements(instructorClassDiagram);

    var studElements = employeeElements(studentClassDiagram);
    var studEmployeeClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studEmployeeClass);
    assertMistake(studStudentClassMistake, FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_ASSOCIATION, studElements, instElements, 0, 1,
          false);
  }

  /**
   * Test to check enum player role pattern instead of assoc in studentSolution.
   */
  @Test
  public void testEnumPRInsteadOfAssocClassPatternEmployeeExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_employeeExample_pattern/Class Diagram/Instructor_assocPR_employeeExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Employee", instructorClassDiagram, instructorSolution);
    var projectClass = getClassFromClassDiagram("Project", instructorClassDiagram);
    setRoleTagToAssocEndInClass("fullTimeEmployee", tagGroup, projectClass);
    setRoleTagToAssocEndInClass("partTimeEmployee", tagGroup, projectClass);

    assertEquals(ASSOC_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_employeeExample_pattern/Class Diagram/Instructor_enumPR_employeeExample_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = employeeProjectElements(instructorClassDiagram);

    var studEmployeeClass = getClassFromClassDiagram("Employee", studentClassDiagram);

    List<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studEmployeeClass);
    CDEnum studEnum = getEnumFromClassDiagram("EmployeeStatus", studentClassDiagram);
    studElements.addAll(studEnum.getLiterals());
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studEmployeeClass);
    assertMistake(studStudentClassMistake, ENUM_SHOULD_BE_ASSOCIATION_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check sub class player role pattern instead of enum in studentSolution.
   */
  @Test
  public void testSubclassPRInsteadOfEnumClassPatternEmployeeExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_employeeExample_pattern/Class Diagram/Instructor_enumPR_employeeExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Employee", instructorClassDiagram, instructorSolution);
    var studentClass = getClassFromClassDiagram("Employee", instructorClassDiagram);
    setRoleTagToAttribInClass("status", tagGroup, studentClass);

    assertEquals(ENUM_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_employeeExample_pattern/Class Diagram/Instructor_subClassPR_employeeExample_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instEmployeeClass = getClassFromClassDiagram("Employee", instructorClassDiagram);
    var instEmployeeClassStatusAttrib = getAttributeFromClass("status", instEmployeeClass);

    var instElements = List.of(instEmployeeClass, instEmployeeClassStatusAttrib);

    var studElements = employeeElements(studentClassDiagram);
    var studEmployeeClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studEmployeeClass);
    assertMistake(studStudentClassMistake, SUBCLASS_SHOULD_BE_ENUM_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check full player role pattern instead of enum in studentSolution.
   */
  @Test
  public void testFullPRInsteadOfEnumClassPatternEmployeeExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_employeeExample_pattern/Class Diagram/Instructor_enumPR_employeeExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Employee", instructorClassDiagram, instructorSolution);
    var studentClass = getClassFromClassDiagram("Employee", instructorClassDiagram);
    setRoleTagToAttribInClass("status", tagGroup, studentClass);

    assertEquals(ENUM_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_fullPR_employeeExample_pattern/Class Diagram/Instructor_fullPR_employeeExample_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instEmployeeClass = getClassFromClassDiagram("Employee", instructorClassDiagram);
    var instEmployeeClassStatusAttrib = getAttributeFromClass("status", instEmployeeClass);

    var instElements = List.of(instEmployeeClass, instEmployeeClassStatusAttrib);

    var studElements = employeeElements(studentClassDiagram);
    var studEmployeeClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studEmployeeClass);
    assertMistake(studStudentClassMistake, FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_ENUM, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check assoc player role pattern instead of enum in studentSolution.
   */
  @Test
  public void testAssocPRInsteadOfEnumClassPatternEmployeeExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_employeeExample_pattern/Class Diagram/Instructor_enumPR_employeeExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Employee", instructorClassDiagram, instructorSolution);
    var studentClass = getClassFromClassDiagram("Employee", instructorClassDiagram);
    setRoleTagToAttribInClass("status", tagGroup, studentClass);

    assertEquals(ENUM_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_employeeExample_pattern/Class Diagram/Instructor_assocPR_employeeExample_pattern.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instEmployeeClass = getClassFromClassDiagram("Employee", instructorClassDiagram);
    var instEmployeeClassStatusAttrib = getAttributeFromClass("status", instEmployeeClass);

    var instElements = List.of(instEmployeeClass, instEmployeeClassStatusAttrib);

    var studElements = employeeProjectElements(studentClassDiagram);
    var studEmployeeClass = studElements.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(8, comparison.newMistakes.size());
    assertEquals(8, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studEmployeeClass);
    assertMistake(studStudentClassMistake, ASSOCIATION_SHOULD_BE_ENUM_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check full player role pattern instead of subclass in studentSolution.
   */
  @Test
  public void testFullPRInsteadOfSubclassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_bankExample_pattern/Class Diagram/Instructor_subClassPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("CheckingAccount", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("SavingAccount", tagGroup, instructorClassDiagram);

    assertEquals(SUB_CLASS_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_fullPR_bankExample/Class Diagram/Student_fullPR_bankExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = bankElements(instructorClassDiagram);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);
    var studCheckingAccClass = getClassFromClassDiagram("CheckingAccount", studentClassDiagram);

    var studElements = List.of(studBankAccClass, studCheckingAccClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(3, comparison.newMistakes.size());
    assertEquals(3, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studBankAccClass);
    assertMistake(studStudentClassMistake, FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_SUBCLASS, studElements, instElements, 0,
        1, false);
  }

  /**
   * Test to check enum player role pattern instead of subclass in studentSolution.
   */
  @Test
  public void testEnumPRInsteadOfSubclassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_bankExample_pattern/Class Diagram/Instructor_subClassPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("CheckingAccount", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("SavingAccount", tagGroup, instructorClassDiagram);

    assertEquals(SUB_CLASS_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_enumPR_bankExample/Class Diagram/Student_enumPR_bankExample.domain_model.cdm");

    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = bankElements(instructorClassDiagram);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);

    List<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studBankAccClass);
    CDEnum studEnum = getEnumFromClassDiagram("AccountType", studentClassDiagram);
    studElements.addAll(studEnum.getLiterals());

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studBankAccClass);
    assertMistake(studStudentClassMistake, ENUM_SHOULD_BE_SUBCLASS_PLAYER_ROLE_PATTERN, studElements, instElements, 0,
        1, false);
  }

  /**
   * Test to check assoc player role pattern instead of subclass in studentSolution.
   */
  @Test
  public void testAssocPRInsteadOfSubclassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_bankExample_pattern/Class Diagram/Instructor_subClassPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("CheckingAccount", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("SavingAccount", tagGroup, instructorClassDiagram);

    assertEquals(SUB_CLASS_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_assocPR_bankExample/Class Diagram/Student_assocPR_bankExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = bankElements(instructorClassDiagram);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);
    var studAccountHolderClass = getClassFromClassDiagram("AccountHolder", studentClassDiagram);
    var studCheckingAccAssocEnd = getAssociationEndFromClass("checkingAccount", studAccountHolderClass);

    var studElements = List.of(studBankAccClass, studCheckingAccAssocEnd);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(5, comparison.newMistakes.size());
    assertEquals(5, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studBankAccClass);
    assertMistake(studStudentClassMistake, ASSOCIATION_SHOULD_BE_SUBCLASS_PLAYER_ROLE_PATTERN, studElements,
        instElements, 0, 1, false);
  }

  /**
   * Test to check subClass player role pattern instead of full in studentSolution.
   */
  @Test
  public void testSubPRInsteadOfFullClassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_fullPR_bankExample_pattern/Class Diagram/Instructor_fullPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("CheckingAccount", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("SavingAccount", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_subClassPR_bankExample/Class Diagram/Student_subClassPR_bankExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = bankElements(instructorClassDiagram);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);
    var studSavingAccClass = getClassFromClassDiagram("SavingAccount", studentClassDiagram);

    var studElements = List.of(studBankAccClass, studSavingAccClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studBankAccClass);
    assertMistake(studStudentClassMistake, SUBCLASS_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN, studElements, instElements, 0,
        1, false);
  }

  /**
   * Test to check assoc player role pattern instead of full in studentSolution.
   */
  @Test
  public void testAssocPRInsteadOfFullClassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_fullPR_bankExample_pattern/Class Diagram/Instructor_fullPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("CheckingAccount", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("SavingAccount", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_assocPR_bankExample/Class Diagram/Student_assocPR_bankExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = bankElements(instructorClassDiagram);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);
    var studAccountHolderClass = getClassFromClassDiagram("AccountHolder", studentClassDiagram);
    var studCheckingAccAssocEnd = getAssociationEndFromClass("checkingAccount", studAccountHolderClass);

    var studElements = List.of(studBankAccClass, studCheckingAccAssocEnd);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studBankAccClass);
    assertMistake(studStudentClassMistake, ASSOCIATION_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN, studElements,
        instElements, 0, 1, false);
  }

  /**
   * Test to check Enum player role pattern instead of full in studentSolution.
   */
  @Test
  public void testEnumPRInsteadOfFullClassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_fullPR_bankExample_pattern/Class Diagram/Instructor_fullPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("CheckingAccount", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("SavingAccount", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_enumPR_bankExample/Class Diagram/Student_enumPR_bankExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = bankElements(instructorClassDiagram);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);

    List<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studBankAccClass);
    CDEnum studEnum = getEnumFromClassDiagram("AccountType", studentClassDiagram);
    studElements.addAll(studEnum.getLiterals());

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studBankAccClass);
    assertMistake(studStudentClassMistake, ENUM_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check subClass player role pattern instead of assoc in studentSolution.
   */
  @Test
  public void testSubPRInsteadOfAssocClassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_bankExample_pattern/Class Diagram/Instructor_assocPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    var AccountHolderClass = getClassFromClassDiagram("AccountHolder", instructorClassDiagram);
    setRoleTagToAssocEndInClass("checkingAccount", tagGroup, AccountHolderClass);
    setRoleTagToAssocEndInClass("savingAccount", tagGroup, AccountHolderClass);

    assertEquals(ASSOC_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_subClassPR_bankExample/Class Diagram/Student_subClassPR_bankExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);


    var instElements = bankElements(instructorClassDiagram);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);
    var studSavingAccClass = getClassFromClassDiagram("SavingAccount", studentClassDiagram);

    var studElements = List.of(studBankAccClass, studSavingAccClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(5, comparison.newMistakes.size());
    assertEquals(5, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studBankAccClass);
    assertMistake(studStudentClassMistake, SUBCLASS_SHOULD_BE_ASSOCIATION_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1,
          false);
  }

  /**
   * Test to check full player role pattern instead of assoc in studentSolution.
   */
  @Test
  public void testFullPRInsteadOfAssocClassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_bankExample_pattern/Class Diagram/Instructor_assocPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    var AccountHolderClass = getClassFromClassDiagram("AccountHolder", instructorClassDiagram);
    setRoleTagToAssocEndInClass("checkingAccount", tagGroup, AccountHolderClass);
    setRoleTagToAssocEndInClass("savingAccount", tagGroup, AccountHolderClass);

    assertEquals(ASSOC_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_fullPR_bankExample/Class Diagram/Student_fullPR_bankExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instBankAccClass = getClassFromClassDiagram("BankAccount", instructorClassDiagram);
    var instAccountHolderClass = getClassFromClassDiagram("AccountHolder", instructorClassDiagram);
    var instCheckingAccAssocEnd = getAssociationEndFromClass("checkingAccount", instAccountHolderClass);
    var instSavingAccAssocEnd = getAssociationEndFromClass("savingAccount", instAccountHolderClass);

    var instElements = List.of(instBankAccClass, instCheckingAccAssocEnd, instSavingAccAssocEnd);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);
    var studCheckingAccClass = getClassFromClassDiagram("CheckingAccount", studentClassDiagram);

    var studElements = List.of(studBankAccClass, studCheckingAccClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studBankAccClass);
    assertMistake(studStudentClassMistake, FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_ASSOCIATION, studElements, instElements, 0, 1,
          false);
  }

  /**
   * Test to check enum player role pattern instead of assoc in studentSolution.
   */
  @Test
  public void testEnumPRInsteadOfAssocClassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_assocPR_bankExample_pattern/Class Diagram/Instructor_assocPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    var AccountHolderClass = getClassFromClassDiagram("AccountHolder", instructorClassDiagram);
    setRoleTagToAssocEndInClass("checkingAccount", tagGroup, AccountHolderClass);
    setRoleTagToAssocEndInClass("savingAccount", tagGroup, AccountHolderClass);

    assertEquals(ASSOC_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_enumPR_bankExample/Class Diagram/Student_enumPR_bankExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = bankProjectElements(instructorClassDiagram);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);

    List<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studBankAccClass);
    CDEnum studEnum = getEnumFromClassDiagram("AccountType", studentClassDiagram);
    studElements.addAll(studEnum.getLiterals());

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studBankAccClass);
    assertMistake(studStudentClassMistake, ENUM_SHOULD_BE_ASSOCIATION_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check sub class player role pattern instead of enum in studentSolution.
   */
  @Test
  public void testSubclassPRInsteadOfEnumClassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_bankExample_pattern/Class Diagram/Instructor_enumPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    var studentClass = getClassFromClassDiagram("BankAccount", instructorClassDiagram);
    setRoleTagToAttribInClass("type", tagGroup, studentClass);

    assertEquals(ENUM_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_subClassPR_bankExample/Class Diagram/Student_subClassPR_bankExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instBankAccClass = getClassFromClassDiagram("BankAccount", instructorClassDiagram);
    var instAccountTypeAttrib = getAttributeFromClass("type", instBankAccClass);

    var instElements = List.of(instBankAccClass, instAccountTypeAttrib);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);
    var studSavingAccClass = getClassFromClassDiagram("SavingAccount", studentClassDiagram);

    var studElements = List.of(studBankAccClass, studSavingAccClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studBankAccClass);
    assertMistake(studStudentClassMistake, SUBCLASS_SHOULD_BE_ENUM_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check full player role pattern instead of enum in studentSolution.
   */
  @Test
  public void testFullPRInsteadOfEnumClassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_bankExample_pattern/Class Diagram/Instructor_enumPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    var studentClass = getClassFromClassDiagram("BankAccount", instructorClassDiagram);
    setRoleTagToAttribInClass("type", tagGroup, studentClass);

    assertEquals(ENUM_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_fullPR_bankExample/Class Diagram/Student_fullPR_bankExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instBankAccClass = getClassFromClassDiagram("BankAccount", instructorClassDiagram);
    var instAccountTypeAttrib = getAttributeFromClass("type", instBankAccClass);

    var instElements = List.of(instBankAccClass, instAccountTypeAttrib);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);
    var studCheckingAccClass = getClassFromClassDiagram("CheckingAccount", studentClassDiagram);

    var studElements = List.of(studBankAccClass, studCheckingAccClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studBankAccClass);
    assertMistake(studStudentClassMistake, FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_ENUM, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check assoc player role pattern instead of enum in studentSolution.
   */
  @Test
  public void testAssocPRInsteadOfEnumClassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_enumPR_bankExample_pattern/Class Diagram/Instructor_enumPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    var studentClass = getClassFromClassDiagram("BankAccount", instructorClassDiagram);
    setRoleTagToAttribInClass("type", tagGroup, studentClass);

    assertEquals(ENUM_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_assocPR_bankExample/Class Diagram/Student_assocPR_bankExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instBankAccClass = getClassFromClassDiagram("BankAccount", instructorClassDiagram);
    var instAccountTypeAttrib = getAttributeFromClass("type", instBankAccClass);

    var instElements = List.of(instBankAccClass, instAccountTypeAttrib);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);
    var studAccountHolderClass = getClassFromClassDiagram("AccountHolder", studentClassDiagram);
    var studCheckingAccAssocEnd = getAssociationEndFromClass("checkingAccount", studAccountHolderClass);

    var studElements = List.of(studBankAccClass, studCheckingAccAssocEnd);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(8, comparison.newMistakes.size());
    assertEquals(8, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studBankAccClass);
    assertMistake(studStudentClassMistake, ASSOCIATION_SHOULD_BE_ENUM_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check incomplete player role pattern sub class in studentSolution.
   */
  @Test
  public void testIncompletePlayerRoleSubClassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_subClassPR_bankExample_pattern/Class Diagram/Instructor_subClassPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("CheckingAccount", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("SavingAccount", tagGroup, instructorClassDiagram);

    assertEquals(SUB_CLASS_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_incompletePattern_bankExample/Class Diagram/Student_incompletePattern_bankExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = bankElements(instructorClassDiagram);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);
    var studSavingAccClass = getClassFromClassDiagram("SavingAccount", studentClassDiagram);

    var studElements = List.of(studBankAccClass, studSavingAccClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), INCOMPLETE_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
  }

  /**
   * Test to check incomplete player role pattern sub class in studentSolution.
   */
  @Test
  public void testIncompletePlayerRoleFullClassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_fullPR_bankExample_pattern/Class Diagram/Instructor_fullPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("CheckingAccount", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("SavingAccount", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_fullPR_bankExample/Class Diagram/Student_fullPR_bankExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = bankElements(instructorClassDiagram);

    var studBankAccClass = getClassFromClassDiagram("BankAccount", studentClassDiagram);
    var studCheckingAccClass = getClassFromClassDiagram("CheckingAccount", studentClassDiagram);

    var studElements = List.of(studBankAccClass, studCheckingAccClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), INCOMPLETE_PLAYER_ROLE_PATTERN, studElements, instElements, 0,
        1, false);
  }

  /**
   * Test to check incomplete abstraction occurrence class in studentSolution.
   */
  @Disabled ("Not implemented yet. ")
  @Test
  public void testIncompleteAbstractionOccurrenceFullClassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_fullPR_bankExample_pattern/Class Diagram/Instructor_fullPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("CheckingAccount", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("SavingAccount", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_incompleteAbstractionOcurance/Class Diagram/Student_incompleteAbstractionOcurance.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = bankElements(instructorClassDiagram);

    var studAccTypeClass = getClassFromClassDiagram("AccountType", studentClassDiagram);
    var studCheckingAccClass = getClassFromClassDiagram("CheckingAccount", studentClassDiagram);

    var studElements = List.of(studAccTypeClass, studCheckingAccClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studAccTypeClass);
    assertMistake(studStudentClassMistake, INCOMPLETE_ABSTRACTION_OCCURRENCE_PATTERN, studElements, instElements, 0,
        1, false);
  }

  /**
   * Test to check incomplete abstraction occurrence class in studentSolution.
   */
  @Disabled ("Not implemented yet. ")
  @Test
  public void testIncompleteAbstractionOccurrenceFullClassPatternEmployeeExample()  {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_fullPR_employeeExample_pattern/Class Diagram/Instructor_fullPR_employeeExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("Employee", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("FullTimeEmployee", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("PartTimeEmployee", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_missingAbstractOccurence_employeeExample/Class Diagram/Student_missingAbstractOccurence_employeeExample.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = employeeElements(instructorClassDiagram);

    var studEmployeeStatusClass = getClassFromClassDiagram("EmployeeStatus", studentClassDiagram);
    var studFullTimeEmployeeClass = getClassFromClassDiagram("FullTimeEmployee", studentClassDiagram);
    var studPartTimeEmployeeClass = getClassFromClassDiagram("PartTimeEmployee", studentClassDiagram);

    var studElements = List.of(studEmployeeStatusClass, studFullTimeEmployeeClass, studPartTimeEmployeeClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studEmployeeStatusClass);
    assertMistake(studStudentClassMistake, INCOMPLETE_ABSTRACTION_OCCURRENCE_PATTERN, studElements, instElements, 0,
        1, false);
  }

  /**
   * Test to check missing abstraction occurrence class in studentSolution.
   */
  @Disabled ("Not implemented yet. ")
  @Test
  public void testMissingAbstractionOccurrenceFullClassPatternBankExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestPattern/instructor_fullPR_bankExample_pattern/Class Diagram/Instructor_fullPR_bankExample_pattern.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var tagGroup = setPlayerTagToClassInClassDiag("BankAccount", instructorClassDiagram, instructorSolution);
    setRoleTagToClassInClassDiag("CheckingAccount", tagGroup, instructorClassDiagram);
    setRoleTagToClassInClassDiag("SavingAccount", tagGroup, instructorClassDiagram);

    assertEquals(FULL_PR_PATTERN, checkPattern(tagGroup));

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestPattern/student_missingAbstractionOccurence/Class Diagram/Student_missingAbstractionOccurence.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instElements = bankElements(instructorClassDiagram);

    var studAccTypeClass = getClassFromClassDiagram("AccountType", studentClassDiagram);
    var studCheckingAccClass = getClassFromClassDiagram("CheckingAccount", studentClassDiagram);

    var studElements = List.of(studAccTypeClass, studCheckingAccClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());

    var studStudentClassMistake = studentMistakeFor(studAccTypeClass);
    assertMistake(studStudentClassMistake, MISSING_ABSTRACTION_OCCURRENCE_PATTERN, studElements, instElements, 0,
        1, false);
  }

  /** Returns a list of Employee, FullTimeEmployee and PartTimeEmployee classes from the given class diagram. */
  private static List<NamedElement> employeeElements(ClassDiagram classDiagram) {
    return getElementsFromClassDiagram(classDiagram, "Employee", "FullTimeEmployee", "PartTimeEmployee");
  }

  /** Returns a list of Employee, fullTimeEmployee and partTimeEmployee classes from the given class diagram. */
  private static List<NamedElement> employeeProjectElements(ClassDiagram classDiagram) {
    return getElementsFromClassDiagram(classDiagram, "Employee", "fullTimeEmployee", "partTimeEmployee");
  }

  /** Returns a list of BankAccount, CheckingAccount and SavingAccount classes from the given class diagram. */
  private static List<NamedElement> bankElements(ClassDiagram classDiagram) {
    return getElementsFromClassDiagram(classDiagram, "BankAccount", "CheckingAccount", "SavingAccount");
  }

  /** Returns a list of BankAccount, checkingAccount and savingAccount classes from the given class diagram. */
  private static List<NamedElement> bankProjectElements(ClassDiagram classDiagram) {
    return getElementsFromClassDiagram(classDiagram, "BankAccount", "checkingAccount", "savingAccount");
  }

  /** Returns a list of Student, FullTimeStudent, PartTimeStudent domain model classes from the given class diagram. */
  private static List<NamedElement> studentDomainElements(ClassDiagram classDiagram) {
    return getElementsFromClassDiagram(classDiagram, "Student", "FullTimeStudent", "PartTimeStudent");
  }

  /** Returns a list of Student, fullTimeStudent, partTimeStudent domain model elements from the given class diagram. */
  private static List<NamedElement> studentProjectDomainElements(ClassDiagram classDiagram) {
    return getElementsFromClassDiagram(classDiagram, "Student", "fullTimeStudent", "partTimeStudent");
  }

}

