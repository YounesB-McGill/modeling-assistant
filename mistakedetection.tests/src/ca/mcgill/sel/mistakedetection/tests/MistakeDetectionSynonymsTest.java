package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getAssocAggCompFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getAttributeFromClass;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static modelingassistant.util.SynonymUtils.setSynonymToAttribInClassInClassDiag;
import static modelingassistant.util.SynonymUtils.setSynonymToClassInClassDiag;
import static modelingassistant.util.SynonymUtils.setSynonymToRoleInClassInClassDiag;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;

public class MistakeDetectionSynonymsTest {

  static final String INSTRUCTOR_CDM_PATH =
      "../mistakedetection/testModels/InstructorSolution/ModelToTestSynonyms/";
  static final String STUDENT_CDM_PATH = "../mistakedetection/testModels/StudentSolution/ModelToTestSynonyms/";


  /**
   * Test to check class mapping and assoc end detection based on synonyms.
   */
  @Test
  public void testToCheckSynonymMapping() {
    var instructorClassDiagram = cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_classPilot/Class Diagram/Instructor_classPilot.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =  cdmFromFile(STUDENT_CDM_PATH + "student_classCaptain/Class Diagram/student_classCaptain.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    setSynonymToClassInClassDiag("Pilot", List.of("flier", "captain", "aviator"), instructorClassDiagram, instructorSolution);

    setSynonymToRoleInClassInClassDiag("Root", "myPilot", List.of("myFlier", "myCaptain", "myAviator"), instructorClassDiagram, instructorSolution);

    var instructorClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    var studentClass = getClassFromClassDiagram("Captain", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());

    assertEquals(comparison.mappedClassifiers.get(instructorClass), studentClass);
  }

  /**
   * Test to check class mapping and detection based on synonyms.
   */
  @Test
  public void testToCheckClassSynonymMapping() {
    var instructorClassDiagram = cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_teacher/Class Diagram/Teacher.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =  cdmFromFile(STUDENT_CDM_PATH + "student_teacher/Class Diagram/Teacher.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    setSynonymToClassInClassDiag("Teacher", List.of("Instructor"), instructorClassDiagram, instructorSolution);

    var instructorClass = getClassFromClassDiagram("Teacher", instructorClassDiagram);
    var studentClass = getClassFromClassDiagram("Instructor", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());

    assertEquals(comparison.mappedClassifiers.get(instructorClass), studentClass);
  }

  /**
   * Test to check Attribute mapping and detection based on synonyms.
   */
  @Test
  public void testToCheckAttributeSynonymMapping() {
    var instructorClassDiagram = cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_teacher_Attrib/Class Diagram/Teacher.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =  cdmFromFile(STUDENT_CDM_PATH + "student_teacher_Attrib/Class Diagram/Teacher.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    setSynonymToAttribInClassInClassDiag("Teacher","name", List.of("fullName"), instructorClassDiagram, instructorSolution);
    setSynonymToAttribInClassInClassDiag("Teacher","ID", List.of("identification"), instructorClassDiagram, instructorSolution);

    var instructorClass = getClassFromClassDiagram("Teacher", instructorClassDiagram);
    var instructorClassAttrib1 = getAttributeFromClass("name", instructorClass);
    var instructorClassAttrib2 = getAttributeFromClass("ID", instructorClass);

    var studentClass = getClassFromClassDiagram("Teacher", studentClassDiagram);
    var studentClassAttrib1 = getAttributeFromClass("fullName", studentClass);
    var studentClassAttrib2 = getAttributeFromClass("identification", studentClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());

    assertEquals(comparison.mappedAttributes.get(instructorClassAttrib1), studentClassAttrib1);
    assertEquals(comparison.mappedAttributes.get(instructorClassAttrib2), studentClassAttrib2);
  }

  /**
   * Test to check assoc end mapping and detection based on synonyms.
   */
  @Test
  public void testToCheckAssocEndSynonymMapping() {
    var instructorClassDiagram = cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_teacherStudent_Assoc/Class Diagram/Teacher.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =  cdmFromFile(STUDENT_CDM_PATH + "student_teacherStudent_Assoc/Class Diagram/Teacher.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    setSynonymToRoleInClassInClassDiag("Student", "myTeacher", List.of("myInstructor"), instructorClassDiagram, instructorSolution);

    var instructorClass1 = getClassFromClassDiagram("Teacher", instructorClassDiagram);
    var instructorClass2 = getClassFromClassDiagram("Student", instructorClassDiagram);

    var instructorAssoc = getAssocAggCompFromClassDiagram(instructorClass1, instructorClass2, instructorClassDiagram);

    var studentClass1 = getClassFromClassDiagram("Teacher", studentClassDiagram);
    var studentClass2 = getClassFromClassDiagram("Student", studentClassDiagram);

    var studentAssoc = getAssocAggCompFromClassDiagram(studentClass1, studentClass2, studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertEquals(comparison.mappedAssociations.get(instructorAssoc.get(0)),studentAssoc.get(0));
  }
}
