package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.MistakeDetection.ASSOC_PR_PATTERN;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.ENUM_PR_PATTERN;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.FULL_PR_PATTERN;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.SUB_CLASS_PR_PATTERN;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.checkPattern;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistakeConditional;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
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
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_ASSOCIATION_PLAYER_ROLE_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_ENUM_PLAYER_ROLE_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN;
import static modelingassistant.TagType.PLAYER;
import static modelingassistant.TagType.ROLE;
import static modelingassistant.util.ClassDiagramUtils.getAssociationEndFromClass;
import static modelingassistant.util.ClassDiagramUtils.getAttributeFromClass;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static modelingassistant.util.TagUtils.setPlayerTagToClassInClassDiag;
import static modelingassistant.util.TagUtils.setRoleTagToAssocEndInClass;
import static modelingassistant.util.TagUtils.setRoleTagToAttribInClass;
import static modelingassistant.util.TagUtils.setRoleTagToClassInClassDiag;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.CDEnum;
import ca.mcgill.sel.classdiagram.NamedElement;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import modelingassistant.Mistake;


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
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
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
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
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
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
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
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instFullTimeStudentClass = getClassFromClassDiagram("FullTimeStudent", instructorClassDiagram);
    var instPartTimeStudentClass = getClassFromClassDiagram("PartTimeStudent", instructorClassDiagram);

    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instFullTimeStudentClass);
    instElements.add(instPartTimeStudentClass);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);
    var studFullTimeStudentClass = getClassFromClassDiagram("FullTimeStudent", studentClassDiagram);
    var studPartTimeStudentClass = getClassFromClassDiagram("PartTimeStudent", studentClassDiagram);

    EList<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    studElements.add(studFullTimeStudentClass);
    studElements.add(studPartTimeStudentClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_SUBCLASS, studElements,
        instElements, 0, 1, false);
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
    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instFullTimeStudentClass = getClassFromClassDiagram("FullTimeStudent", instructorClassDiagram);
    var instPartTimeStudentClass = getClassFromClassDiagram("PartTimeStudent", instructorClassDiagram);

    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instFullTimeStudentClass);
    instElements.add(instPartTimeStudentClass);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);

    EList<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    CDEnum studEnum = MistakeDetection.getEnumFromClassDiagram("StudentLevel", studentClassDiagram);
    studElements.addAll(studEnum.getLiterals());
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), ENUM_SHOULD_BE_SUBCLASS_PLAYER_ROLE_PATTERN, studElements,
        instElements, 0, 1, false);
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instFullTimeStudentClass = getClassFromClassDiagram("FullTimeStudent", instructorClassDiagram);
    var instPartTimeStudentClass = getClassFromClassDiagram("PartTimeStudent", instructorClassDiagram);

    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instFullTimeStudentClass);
    instElements.add(instPartTimeStudentClass);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);
    var studProjectClass = getClassFromClassDiagram("Project", studentClassDiagram);
    var studFullTimeStudentAssocEnd = getAssociationEndFromClass("fullTimeStudent", studProjectClass);
    var studPartTimeStudentAssocEnd = getAssociationEndFromClass("partTimeStudent", studProjectClass);

    EList<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    studElements.add(studFullTimeStudentAssocEnd);
    studElements.add(studPartTimeStudentAssocEnd);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(1), ASSOCIATION_SHOULD_BE_SUBCLASS_PLAYER_ROLE_PATTERN,
        studElements, instElements, 0, 1, false);
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instFullTimeStudentClass = getClassFromClassDiagram("FullTimeStudent", instructorClassDiagram);
    var instPartTimeStudentClass = getClassFromClassDiagram("PartTimeStudent", instructorClassDiagram);

    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instFullTimeStudentClass);
    instElements.add(instPartTimeStudentClass);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);
    var studFullTimeStudentClass = getClassFromClassDiagram("FullTimeStudent", studentClassDiagram);
    var studPartTimeStudentClass = getClassFromClassDiagram("PartTimeStudent", studentClassDiagram);

    EList<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    studElements.add(studFullTimeStudentClass);
    studElements.add(studPartTimeStudentClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), SUBCLASS_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN, studElements,
        instElements, 0, 1, false);
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instFullTimeStudentClass = getClassFromClassDiagram("FullTimeStudent", instructorClassDiagram);
    var instPartTimeStudentClass = getClassFromClassDiagram("PartTimeStudent", instructorClassDiagram);

    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instFullTimeStudentClass);
    instElements.add(instPartTimeStudentClass);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);
    var studProjectClass = getClassFromClassDiagram("Project", studentClassDiagram);
    var studFullTimeStudentAssocEnd = getAssociationEndFromClass("fullTimeStudent", studProjectClass);
    var studPartTimeStudentAssocEnd = getAssociationEndFromClass("partTimeStudent", studProjectClass);

    EList<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    studElements.add(studFullTimeStudentAssocEnd);
    studElements.add(studPartTimeStudentAssocEnd);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(8, comparison.newMistakes.size());
    assertEquals(8, studentSolution.getMistakes().size());
    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, ASSOCIATION_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1,
          false);
    }
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instFullTimeStudentClass = getClassFromClassDiagram("FullTimeStudent", instructorClassDiagram);
    var instPartTimeStudentClass = getClassFromClassDiagram("PartTimeStudent", instructorClassDiagram);

    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instFullTimeStudentClass);
    instElements.add(instPartTimeStudentClass);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);

    EList<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    CDEnum studEnum = MistakeDetection.getEnumFromClassDiagram("StudentLevel", studentClassDiagram);
    studElements.addAll(studEnum.getLiterals());
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, ENUM_SHOULD_BE_FULL_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
    }
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instProjectClass = getClassFromClassDiagram("Project", instructorClassDiagram);
    var instFullTimeStudentAssocEnd = getAssociationEndFromClass("fullTimeStudent", instProjectClass);
    var instPartTimeStudentAssocEnd = getAssociationEndFromClass("partTimeStudent", instProjectClass);

    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instFullTimeStudentAssocEnd);
    instElements.add(instPartTimeStudentAssocEnd);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);
    var studPartTimeStudentClass = getClassFromClassDiagram("PartTimeStudent", studentClassDiagram);
    var studFullTimeStudentClass = getClassFromClassDiagram("FullTimeStudent", studentClassDiagram);

    EList<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    studElements.add(studPartTimeStudentClass);
    studElements.add(studFullTimeStudentClass);
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(5, comparison.newMistakes.size());
    assertEquals(5, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, SUBCLASS_SHOULD_BE_ASSOCIATION_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1,
          false);
    }
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instProjectClass = getClassFromClassDiagram("Project", instructorClassDiagram);
    var instFullTimeStudentAssocEnd = getAssociationEndFromClass("fullTimeStudent", instProjectClass);
    var instPartTimeStudentAssocEnd = getAssociationEndFromClass("partTimeStudent", instProjectClass);

    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instFullTimeStudentAssocEnd);
    instElements.add(instPartTimeStudentAssocEnd);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);
    var studPartTimeStudentClass = getClassFromClassDiagram("PartTimeStudent", studentClassDiagram);
    var studFullTimeStudentClass = getClassFromClassDiagram("FullTimeStudent", studentClassDiagram);

    EList<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    studElements.add(studPartTimeStudentClass);
    studElements.add(studFullTimeStudentClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(8, comparison.newMistakes.size());
    assertEquals(8, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_ASSOCIATION, studElements, instElements, 0, 1,
          false);
    }
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instProjectClass = getClassFromClassDiagram("Project", instructorClassDiagram);
    var instFullTimeStudentAssocEnd = getAssociationEndFromClass("fullTimeStudent", instProjectClass);
    var instPartTimeStudentAssocEnd = getAssociationEndFromClass("partTimeStudent", instProjectClass);

    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instFullTimeStudentAssocEnd);
    instElements.add(instPartTimeStudentAssocEnd);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);

    EList<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    CDEnum studEnum = MistakeDetection.getEnumFromClassDiagram("StudentLevel", studentClassDiagram);
    studElements.addAll(studEnum.getLiterals());
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, ENUM_SHOULD_BE_ASSOCIATION_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1,
          false);
    }
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instStudentClassLevelAttrib = getAttributeFromClass("level", instStudentClass);

    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instStudentClassLevelAttrib);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);
    var studPartTimeStudentClass = getClassFromClassDiagram("PartTimeStudent", studentClassDiagram);
    var studFullTimeStudentClass = getClassFromClassDiagram("FullTimeStudent", studentClassDiagram);

    EList<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    studElements.add(studPartTimeStudentClass);
    studElements.add(studFullTimeStudentClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, SUBCLASS_SHOULD_BE_ENUM_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1, false);
    }
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instStudentClassLevelAttrib = getAttributeFromClass("level", instStudentClass);

    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instStudentClassLevelAttrib);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);
    var studPartTimeStudentClass = getClassFromClassDiagram("PartTimeStudent", studentClassDiagram);
    var studFullTimeStudentClass = getClassFromClassDiagram("FullTimeStudent", studentClassDiagram);

    EList<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    studElements.add(studPartTimeStudentClass);
    studElements.add(studFullTimeStudentClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, FULL_PLAYER_ROLE_PATTERN_SHOULD_BE_ENUM, studElements, instElements, 0, 1, false);
    }
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

    var instStudentClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var instStudentClassLevelAttrib = getAttributeFromClass("level", instStudentClass);

    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    instElements.add(instStudentClass);
    instElements.add(instStudentClassLevelAttrib);

    var studStudentClass = getClassFromClassDiagram("Student", studentClassDiagram);
    var studProjectClass = getClassFromClassDiagram("Project", studentClassDiagram);
    var studFullTimeStudentAssocEnd = getAssociationEndFromClass("fullTimeStudent", studProjectClass);
    var studPartTimeStudentAssocEnd = getAssociationEndFromClass("partTimeStudent", studProjectClass);

    EList<NamedElement> studElements = new BasicEList<NamedElement>();
    studElements.add(studStudentClass);
    studElements.add(studFullTimeStudentAssocEnd);
    studElements.add(studPartTimeStudentAssocEnd);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(9, comparison.newMistakes.size());
    assertEquals(9, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, ASSOCIATION_SHOULD_BE_ENUM_PLAYER_ROLE_PATTERN, studElements, instElements, 0, 1,
          false);
    }
  }
}
