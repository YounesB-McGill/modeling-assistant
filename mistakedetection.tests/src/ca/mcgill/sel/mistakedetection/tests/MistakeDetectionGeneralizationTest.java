package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentMistakeFor;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_GENERALIZATION;
import static learningcorpus.mistaketypes.MistakeTypes.NON_DIFFERENTIATED_SUBCLASS;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_SUPERCLASS;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.mistakedetection.MistakeDetection;

public class MistakeDetectionGeneralizationTest {

  String instructorCDMPath = "../mistakedetection/testModels/InstructorSolution/ModelToTestGeneralization/";
  String studentCDMPath = "../mistakedetection/testModels/StudentSolution/ModelToTestGeneralization/";

  /**
   * Test to check generalization structure .
   */
  @Test
  public void testToCheckGeneralizationTree() {
    var instructorClassDiagram =
        cdmFromFile(instructorCDMPath + "instructor_two_subClasses/Class Diagram/Two_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(studentCDMPath + "student_two_subClasses/Class Diagram/Two_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instCar = getClassFromClassDiagram("Car", instructorClassDiagram);
    var instTATAManza = getClassFromClassDiagram("TATAManza", instructorClassDiagram);
    var instHondaCity = getClassFromClassDiagram("HondaCity", instructorClassDiagram);

    var studCar = getClassFromClassDiagram("Car", studentClassDiagram);
    var studTATAManza = getClassFromClassDiagram("TATAManza", studentClassDiagram);
    var studHondaCity = getClassFromClassDiagram("HondaCity", studentClassDiagram);

    var instClasses = List.of(instTATAManza, instHondaCity);
    var studClasses = List.of(studTATAManza, studHondaCity);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertTrue(comparison.instructorGeneraltionTree.containsKey(instCar));
    assertTrue(comparison.studentGeneraltionTree.containsKey(studCar));

    for (Classifier Class : comparison.instructorGeneraltionTree.get(instCar)) {
      assertTrue(instClasses.contains(Class));
    }
    for (Classifier Class : comparison.studentGeneraltionTree.get(studCar)) {
      assertTrue(studClasses.contains(Class));
    }
  }

  /**
   * Test to check generalization structure .
   */
  @Test
  public void testToCheckGeneralizationTreeWithDiffInput() {
    var instructorClassDiagram =
        cdmFromFile(instructorCDMPath + "instructor_multiSubClasses/Class Diagram/MultiSubClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(instructorCDMPath + "instructor_multiSubClasses/Class Diagram/MultiSubClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    var instClasses = List.of("Car", "TATAManza", "TATAManzaModel2", "TATAManzaModel3").stream()
        .map(s -> getClassFromClassDiagram(s, instructorClassDiagram)).collect(Collectors.toUnmodifiableList());
    assertTrue(comparison.instructorGeneraltionTree.keySet().containsAll(instClasses));

  }

  /**
   * Test to check Non Diff SubClasses Mistake.
   */
  @Test
  public void testToCheckNonDiffSubClassesWith2SameSubClasses() {
    var instructorClassDiagram =
        cdmFromFile(studentCDMPath + "student_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(studentCDMPath + "student_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    var studLeftCarClass = getClassFromClassDiagram("LeftCar", studentClassDiagram);
    var studRightCarClass = getClassFromClassDiagram("RightCar", studentClassDiagram);

    var studCarClassMistake = studentMistakeFor(studLeftCarClass);
    assertMistake(studCarClassMistake, NON_DIFFERENTIATED_SUBCLASS, studLeftCarClass, 0, 1, false);

    var studNewCarClassMistake = studentMistakeFor(studRightCarClass);
    assertMistake(studNewCarClassMistake, NON_DIFFERENTIATED_SUBCLASS, studRightCarClass, 0, 1, false);

  }

  /**
   * Test to check Non Diff SubClasses Mistake when non-differentiated classes are associated with same classes.
   */
  @Test
  public void testToCheckNonDiffSubClassesWith2SameSubClassesSameAssoc() {
    var instructorClassDiagram = cdmFromFile(
        studentCDMPath + "student_same_Assoc_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        studentCDMPath + "student_same_Assoc_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    var studLeftCarClass = getClassFromClassDiagram("LeftCar", studentClassDiagram);
    var studRightCarClass = getClassFromClassDiagram("RightCar", studentClassDiagram);

    var studCarClassMistake = studentMistakeFor(studLeftCarClass);
    assertMistake(studCarClassMistake, NON_DIFFERENTIATED_SUBCLASS, studLeftCarClass, 0, 1, false);

    var studNewCarClassMistake = studentMistakeFor(studRightCarClass);
    assertMistake(studNewCarClassMistake, NON_DIFFERENTIATED_SUBCLASS, studRightCarClass, 0, 1, false);

  }

  /**
   * Test to check Non Diff SubClasses Mistake when non-differentiated classes are associated with diff classes.
   */
  @Test
  public void testToCheckNonDiffSubClassesWith2SameSubClassesDiffAssoc() {
    var instructorClassDiagram =
        cdmFromFile(instructorCDMPath + "instructor_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        studentCDMPath + "student_diff_Assoc_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertTrue(comparison.newMistakes.stream().noneMatch(m -> m.getMistakeType().equals(NON_DIFFERENTIATED_SUBCLASS)));
  }

  /**
   * Test to check Non Diff SubClasses Mistake when non-differentiated classes have diff assoc ends.
   */
  @Test
  public void testToCheckNonDiffSubClassesWith2SameSubClassesDiffAssocEnds() {
    var instructorClassDiagram =
        cdmFromFile(instructorCDMPath + "instructor_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        studentCDMPath + "student_diff_AssocEnds_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertTrue(comparison.newMistakes.stream().noneMatch(m -> m.getMistakeType().equals(NON_DIFFERENTIATED_SUBCLASS)));
  }

  /**
   * Test to check wrong superclass.
   */
  @Test
  public void testToCheckWrongSuperclass() {
    var instructorClassDiagram =
        cdmFromFile(instructorCDMPath + "instructor_wrong_superclass/Class Diagram/Wrong_superclass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(studentCDMPath + "student_wrong_superclass/Class Diagram/Wrong_superclass.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    var instExtraAccountClass = getClassFromClassDiagram("ExtraAccount", instructorClassDiagram);
    var studExtraAccountClass = getClassFromClassDiagram("ExtraAccount", studentClassDiagram);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());// TODO Update Incomplete Containment Tree

    assertMistake(studentSolution.getMistakes().get(0), WRONG_SUPERCLASS, studExtraAccountClass, instExtraAccountClass,
        0, 1, false);

  }

  /**
   * Test to check multiple Missing Generalization.
   */
  @Test
  public void testToCheckMultipleMissingGeneralization() {
    var instructorClassDiagram =
        cdmFromFile(instructorCDMPath + "instructor_multiSubClasses/Class Diagram/MultiSubClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        studentCDMPath + "student_Missing_multi_Generalization/Class Diagram/MultiSubClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(8, comparison.newMistakes.size());
    assertEquals(8, studentSolution.getMistakes().size());

  }

  /**
   * Test to check one Missing Generalization.
   */
  @Test
  public void testToCheckMissingGeneralization() {
    var instructorClassDiagram =
        cdmFromFile(instructorCDMPath + "instructor_two_subClasses/Class Diagram/Two_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(studentCDMPath + "student_Missing_1_Genralization/Class Diagram/Two_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instClass1 = getClassFromClassDiagram("TATAManza", instructorClassDiagram);
    var studClass1 = getClassFromClassDiagram("TATAManza", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(3, comparison.newMistakes.size());
    assertEquals(3, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), MISSING_GENERALIZATION, studClass1, instClass1, 0, 1, false);
  }
}
