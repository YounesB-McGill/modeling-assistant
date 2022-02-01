package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistakeTypesContain;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistakeTypesDoNotContain;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentMistakeFor;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_GENERALIZATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_GENERALIZATION;
import static learningcorpus.mistaketypes.MistakeTypes.NON_DIFFERENTIATED_SUBCLASS;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_GENERALIZATION_DIRECTION;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_SUPERCLASS;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.getMistakeForElement;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;

public class MistakeDetectionGeneralizationTest {

  static final String INSTRUCTOR_CDM_PATH =
      "../mistakedetection/testModels/InstructorSolution/ModelToTestGeneralization/";
  static final String STUDENT_CDM_PATH = "../mistakedetection/testModels/StudentSolution/ModelToTestGeneralization/";

  /**
   * Test to check generalization structure.
   */
  @Test
  public void testToCheckGeneralizationTree() {
  
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_two_subClasses/Class Diagram/Two_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(STUDENT_CDM_PATH + "student_two_subClasses/Class Diagram/Two_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instCar = getClassFromClassDiagram("Car", instructorClassDiagram);
    var instTATAManza = getClassFromClassDiagram("TATAManza", instructorClassDiagram);
    var instHondaCity = getClassFromClassDiagram("HondaCity", instructorClassDiagram);

    var studCar = getClassFromClassDiagram("Car", studentClassDiagram);
    var studTATAManza = getClassFromClassDiagram("TATAManza", studentClassDiagram);
    var studHondaCity = getClassFromClassDiagram("HondaCity", studentClassDiagram);

    var expectedInstClasses = Set.of(instTATAManza, instHondaCity);
    var expectedStudClasses = Set.of(studTATAManza, studHondaCity);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertTrue(comparison.instructorSuperclassesToSubclasses.containsKey(instCar));
    assertTrue(comparison.studentSuperclassesToSubclasses.containsKey(studCar));

    var actualInstClasses = new HashSet<>(comparison.instructorSuperclassesToSubclasses.get(instCar));
    var actualStudClasses = new HashSet<>(comparison.studentSuperclassesToSubclasses.get(studCar));

    assertEquals(expectedInstClasses, actualInstClasses);
    assertEquals(expectedStudClasses, actualStudClasses);
  }

  /**
   * Test to check generalization structure .
   */
  @Test
  public void testToCheckGeneralizationTreeWithDiffInput() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_multiSubClasses/Class Diagram/MultiSubClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_multiSubClasses/Class Diagram/MultiSubClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    var instClasses = List.of("Car", "TATAManza", "TATAManzaModel2", "TATAManzaModel3").stream()
        .map(s -> getClassFromClassDiagram(s, instructorClassDiagram)).collect(Collectors.toUnmodifiableList());
    assertTrue(comparison.instructorSuperclassesToSubclasses.keySet().containsAll(instClasses));
  }

  /**
   * Test to check Non Diff SubClasses Mistake.
   */
  @Test
  public void testToCheckNonDiffSubClassesWith2SameSubClasses() {
    var instructorClassDiagram =
        cdmFromFile(STUDENT_CDM_PATH + "student_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(STUDENT_CDM_PATH + "student_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    MistakeDetection.compare(instructorSolution, studentSolution, false);

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
        STUDENT_CDM_PATH + "student_same_Assoc_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        STUDENT_CDM_PATH + "student_same_Assoc_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    MistakeDetection.compare(instructorSolution, studentSolution, false);

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
    var instructorClassDiagram = cdmFromFile(
        INSTRUCTOR_CDM_PATH + "instructor_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        STUDENT_CDM_PATH + "student_diff_Assoc_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertMistakeTypesDoNotContain(comparison.newMistakes, NON_DIFFERENTIATED_SUBCLASS);
  }

  /**
   * Test to check Non Diff SubClasses Mistake when non-differentiated classes have diff assoc ends.
   */
  @Test
  public void testToCheckNonDiffSubClassesWith2SameSubClassesDiffAssocEnds() {
    var instructorClassDiagram = cdmFromFile(
        INSTRUCTOR_CDM_PATH + "instructor_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        STUDENT_CDM_PATH + "student_diff_AssocEnds_three_subClasses/Class Diagram/Three_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertMistakeTypesDoNotContain(comparison.newMistakes, NON_DIFFERENTIATED_SUBCLASS);
  }

  /**
   * Test to check absence of wrong superclass.
   */
  @Test
  public void testToCheckNoWrongSuperclass() {
    var instructorClassDiagram = cdmFromFile(
        INSTRUCTOR_CDM_PATH + "instructor_wrong_superclass/Class Diagram/Wrong_superclass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(STUDENT_CDM_PATH + "student_wrong_superclass/Class Diagram/Wrong_superclass.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());

    assertMistakeTypesDoNotContain(comparison.newMistakes, WRONG_SUPERCLASS);
  }

  /**
   * Test to check multiple Missing Generalization.
   */
  @Test
  public void testToCheckMultipleMissingGeneralization() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_multiSubClasses/Class Diagram/MultiSubClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        STUDENT_CDM_PATH + "student_Missing_multi_Generalization/Class Diagram/MultiSubClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(8, comparison.newMistakes.size());
    assertEquals(8, studentSolution.getMistakes().size());
    assertMistakeTypesContain(comparison.newMistakes, MISSING_GENERALIZATION);
  }

  /**
   * Test to check one Missing Generalization.
   */
  @Test
  public void testToCheckMissingGeneralization() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_two_subClasses/Class Diagram/Two_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(STUDENT_CDM_PATH + "student_Missing_1_Genralization/Class Diagram/Two_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instClass1 = getClassFromClassDiagram("TATAManza", instructorClassDiagram);
    var instClass2 = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studClass1 = getClassFromClassDiagram("TATAManza", studentClassDiagram);
    var studClass2 = getClassFromClassDiagram("Car", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(3, comparison.newMistakes.size());
    assertEquals(3, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), MISSING_GENERALIZATION, List.of(studClass1, studClass2),
        List.of(instClass1, instClass2), 0, 1, false);
  }

  /**
   * Test to check correctness of Missing Generalization.
   */
  @Test
  public void testToCheckMissingGeneralizationTwoClasses() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_three_classes/Class Diagram/Three_classes.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(STUDENT_CDM_PATH + "student_two_classes/Class Diagram/Three_classes.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instClassB = getClassFromClassDiagram("B", instructorClassDiagram);
    var instClassA = getClassFromClassDiagram("A", instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(2), MISSING_GENERALIZATION, List.of(instClassB, instClassA), 0, 1,
        false);
  }

  /**
   * Test to check correctness of Missing Generalization and one Missing Generalization.
   */
  @Test
  public void testToCheckOneMissingGeneralizationThreeClasses() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_three_classes/Class Diagram/Three_classes.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(STUDENT_CDM_PATH + "student_three_classes/Class Diagram/Three_classes.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());
    assertMistakeTypesContain(comparison.newMistakes, MISSING_GENERALIZATION);
  }

  /**
   * Test to check one Extra Generalization.
   */
  @Test
  public void testToCheckExtraGeneralization() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_two_subClasses/Class Diagram/Two_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        STUDENT_CDM_PATH + "student_one_extra_Generalization/Class Diagram/Two_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studClass = getClassFromClassDiagram("NewClass", studentClassDiagram);
    var studCarClass = getClassFromClassDiagram("Car", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(3, comparison.newMistakes.size());
    assertEquals(3, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(1), EXTRA_GENERALIZATION, List.of(studClass, studCarClass), 0, 1,
        false);
  }

  /**
   * Test to check Extra Generalization. (Generalization instead of association)
   */
  @Test
  public void testToCheckExtraGeneralizationAssoc() {
    var instructorClassDiagram =
        cdmFromFile(STUDENT_CDM_PATH + "student_Missing_1_Genralization/Class Diagram/Two_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_two_subClasses/Class Diagram/Two_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instClass1 = getClassFromClassDiagram("TATAManza", instructorClassDiagram);
    var instClass2 = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studClass1 = getClassFromClassDiagram("TATAManza", studentClassDiagram);
    var studClass2 = getClassFromClassDiagram("Car", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), EXTRA_GENERALIZATION, List.of(studClass1, studClass2),
        List.of(instClass1, instClass2), 0, 1, false);
  }

  /**
   * Test to check Two Extra Generalization.
   */
  @Test
  public void testToCheckExtraGeneralization2Classes() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_two_subClasses/Class Diagram/Two_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        STUDENT_CDM_PATH + "student_two_extra_Generalization/Class Diagram/Two_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());
    assertMistakeTypesContain(comparison.newMistakes, EXTRA_GENERALIZATION);
  }

  /**
   * Test to Wrong Generalization direction. 
   * IS : A <- B <- C <- D 
   * SS : A <- D <- B <- C
   */
  @Test
  public void testToCheckWrongGenDirection() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_four_classes/Class Diagram/Four_classes.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(STUDENT_CDM_PATH + "student_four_classes/Class Diagram/Four_classes.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    var instClass1 = getClassFromClassDiagram("D", instructorClassDiagram);
    var instClass2 = getClassFromClassDiagram("C", instructorClassDiagram);
    var studClass1 = getClassFromClassDiagram("D", studentClassDiagram);
    var studClass2 = getClassFromClassDiagram("C", studentClassDiagram);

    assertEquals(5, comparison.newMistakes.size());
    assertEquals(5, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(3), WRONG_GENERALIZATION_DIRECTION, List.of(studClass1, studClass2),
        List.of(instClass1, instClass2), 0, 1, false);
  }

  /**
   * Test to Wrong Generalization direction with one less class 
   * IS : A <- B <- C <- D 
   * SS : A <- D <- C
   */
  @Test
  public void testToCheckWrongGenDirectionAn1LessClass() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_four_classes/Class Diagram/Four_classes.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(STUDENT_CDM_PATH + "student_four_classes_1Missing/Class Diagram/Three_classes.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());
    assertMistakeTypesContain(comparison.newMistakes, WRONG_GENERALIZATION_DIRECTION);
  }

  /**
   * Test to Wrong Generalization direction and Extra generalization.
   *  IS : A <- B <- C <- D E
   *  SS : A <- D <- B <- C <- E (E and D are subclasses of D)
   */
  @Test
  public void testToCheckWrongGenDirectionAndExtraGen() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_five_classes/Class Diagram/Five_classes.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram =
        cdmFromFile(STUDENT_CDM_PATH + "student_five_classes/Class Diagram/Five_classes.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    
    var instClass1 = getClassFromClassDiagram("E", instructorClassDiagram);
    var instClass2 = getClassFromClassDiagram("D", instructorClassDiagram);
    var studClass1 = getClassFromClassDiagram("E", studentClassDiagram);
    var studClass2 = getClassFromClassDiagram("D", studentClassDiagram);  
   
    var instClass3 = getClassFromClassDiagram("C", instructorClassDiagram);    
    var studClass3 = getClassFromClassDiagram("C", studentClassDiagram);
    
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
   
    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(5), WRONG_GENERALIZATION_DIRECTION, List.of(studClass2, studClass3),
        List.of(instClass2, instClass3), 0, 1, false);
    assertMistake(studentSolution.getMistakes().get(4), EXTRA_GENERALIZATION, List.of(studClass1, studClass2),
        List.of(instClass1, instClass2), 0, 1, false);
    
  }

  /**
   * Test to extra generalization and missing generalization. 
   * IS : A <- B <- C <- D E
   * SS : A <- E <- B <- C
   */
  @Test
  public void testToCheckExtraGenAndMissingGen() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_five_classes/Class Diagram/Five_classes.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        STUDENT_CDM_PATH + "student_five_classes_1Missing/Class Diagram/Five_classes_1Missing.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    
    var instClass1 = getClassFromClassDiagram("E", instructorClassDiagram);
    var instClass2 = getClassFromClassDiagram("A", instructorClassDiagram);
    var studClass1 = getClassFromClassDiagram("E", studentClassDiagram);
    var studClass2 = getClassFromClassDiagram("A", studentClassDiagram);

    var instClass3 = getClassFromClassDiagram("D", instructorClassDiagram);
    var instClass4 = getClassFromClassDiagram("C", instructorClassDiagram);
    
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    
    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(4), MISSING_GENERALIZATION,List.of(instClass3, instClass4),
        0, 1, false);
    assertMistake(studentSolution.getMistakes().get(5), EXTRA_GENERALIZATION, List.of(studClass1, studClass2),
        List.of(instClass1, instClass2), 0, 1, false);
  }

  /**
   * Test to wrong superclass and missing generalization. 
   * IS : A <- B <- C <- D E 
   * SS : A E <- B <- C
   */
  @Test
  public void testToCheckWrongSuperClassAndMissingGen() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_five_classes/Class Diagram/Five_classes.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(STUDENT_CDM_PATH
        + "student_five_classes_1MissingWrongSuperClass/Class Diagram/Five_classes_1Missing.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instClass1 = getClassFromClassDiagram("B", instructorClassDiagram);
    var instClass2 = getClassFromClassDiagram("A", instructorClassDiagram);
    var studClass1 = getClassFromClassDiagram("B", studentClassDiagram);
    var studClass2 = getClassFromClassDiagram("E", studentClassDiagram);

    var instClass3 = getClassFromClassDiagram("D", instructorClassDiagram);
    var instClass4 = getClassFromClassDiagram("C", instructorClassDiagram);
    
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
   
    assertEquals(6, comparison.newMistakes.size());
    assertEquals(6, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(3), MISSING_GENERALIZATION,List.of(instClass3, instClass4),
        0, 1, false);
    assertMistake(studentSolution.getMistakes().get(4), WRONG_SUPERCLASS, List.of(studClass1, studClass2),
        List.of(instClass1, instClass2), 0, 1, false);

  }

  /**
   * Test to wrong Super class and generalization direction. 
   * IS : A <- B <- C <- D E 
   * SS : E <- D <- B <- C
   */
  @Test
  public void testToCheckWrongSuperclassAndDirection() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instructor_five_classes/Class Diagram/Five_classes.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        STUDENT_CDM_PATH + "student_five_classes_WrongA/Class Diagram/Five_classes_WrongA.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    
    var instClass1 = getClassFromClassDiagram("B", instructorClassDiagram);
    var instClass2 = getClassFromClassDiagram("A", instructorClassDiagram);
    var studClass1 = getClassFromClassDiagram("B", studentClassDiagram);
    var studClass2 = getClassFromClassDiagram("E", studentClassDiagram);
    
    var instClass3 = getClassFromClassDiagram("D", instructorClassDiagram);
    var instClass4 = getClassFromClassDiagram("C", instructorClassDiagram);
    var studClass3 = getClassFromClassDiagram("D", studentClassDiagram);
    var studClass4 = getClassFromClassDiagram("C", studentClassDiagram);
    
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    
    assertEquals(7, comparison.newMistakes.size());
    assertEquals(7, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(5), WRONG_SUPERCLASS, List.of(studClass1, studClass2),
        List.of(instClass1, instClass2), 0, 1, false);
    assertMistake(studentSolution.getMistakes().get(4), WRONG_GENERALIZATION_DIRECTION, List.of(studClass3, studClass4),
        List.of(instClass3, instClass4), 0, 1, false);
  }
  
  /**
   * Test to wrong Super class 
   * IS : A <- B <- C <- D ; E <- F <- G <- H
   * SS : A <- B <- F <- D ; E <- C <- G <- H
   */
  @Test
  public void testToCheckWrongSuperclass() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instuctor_two_generalization_heirarchy/Class Diagram/Two_generalization_heirarchy.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        STUDENT_CDM_PATH + "student_two_generalization_heirarchy_wrong_superclass_1/Class Diagram/Two_generalization_heirarchy.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    
    var instClass1 = getClassFromClassDiagram("D", instructorClassDiagram);
    var instClass2 = getClassFromClassDiagram("C", instructorClassDiagram);
    var studClass1 = getClassFromClassDiagram("D", studentClassDiagram);
    var studClass2 = getClassFromClassDiagram("F", studentClassDiagram);
    
    var instClass3 = getClassFromClassDiagram("C", instructorClassDiagram);
    var instClass4 = getClassFromClassDiagram("B", instructorClassDiagram);
    var studClass3 = getClassFromClassDiagram("C", studentClassDiagram);
    var studClass4 = getClassFromClassDiagram("E", studentClassDiagram);
    
    var instClass5 = getClassFromClassDiagram("F", instructorClassDiagram);
    var instClass6 = getClassFromClassDiagram("E", instructorClassDiagram);
    var studClass5 = getClassFromClassDiagram("F", studentClassDiagram);
    var studClass6 = getClassFromClassDiagram("B", studentClassDiagram);
    
    var instClass7 = getClassFromClassDiagram("G", instructorClassDiagram);
    var instClass8 = getClassFromClassDiagram("F", instructorClassDiagram);
    var studClass7 = getClassFromClassDiagram("G", studentClassDiagram);
    var studClass8 = getClassFromClassDiagram("C", studentClassDiagram);
    
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    
    assertMistake(getMistakeForElement(studClass1, WRONG_SUPERCLASS, comparison), WRONG_SUPERCLASS, List.of(studClass1, studClass2),
        List.of(instClass1, instClass2), 0, 1, false);  
    assertMistake(getMistakeForElement(studClass3, WRONG_SUPERCLASS, comparison), WRONG_SUPERCLASS, List.of(studClass3, studClass4),
        List.of(instClass3, instClass4), 0, 1, false);
    assertMistake(getMistakeForElement(studClass5, WRONG_SUPERCLASS, comparison), WRONG_SUPERCLASS, List.of(studClass5, studClass6),
        List.of(instClass5, instClass6), 0, 1, false);
    assertMistake(getMistakeForElement(studClass7, WRONG_SUPERCLASS, comparison), WRONG_SUPERCLASS, List.of(studClass7, studClass8),
        List.of(instClass7, instClass8), 0, 1, false);
  }
  
  /**
   * Test to wrong Super class 
   * IS : A <- B <- C <- D ; E <- F <- G <- H
   * SS : E <- B <- F <- D ; A <- C <- G <- H
   */
  @Test
  public void testToCheckWrongSuperclass2() {
    var instructorClassDiagram =
        cdmFromFile(INSTRUCTOR_CDM_PATH + "instuctor_two_generalization_heirarchy/Class Diagram/Two_generalization_heirarchy.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        STUDENT_CDM_PATH + "student_two_generalization_heirarchy_wrong_superclass_2/Class Diagram/Two_generalization_heirarchy.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
    
    var instClass1 = getClassFromClassDiagram("B", instructorClassDiagram);
    var instClass2 = getClassFromClassDiagram("A", instructorClassDiagram);
    var studClass1 = getClassFromClassDiagram("B", studentClassDiagram);
    var studClass2 = getClassFromClassDiagram("E", studentClassDiagram);
    
    var instClass3 = getClassFromClassDiagram("C", instructorClassDiagram);
    var instClass4 = getClassFromClassDiagram("B", instructorClassDiagram);
    var studClass3 = getClassFromClassDiagram("C", studentClassDiagram);
    var studClass4 = getClassFromClassDiagram("A", studentClassDiagram);
    
    var instClass5 = getClassFromClassDiagram("G", instructorClassDiagram);
    var instClass6 = getClassFromClassDiagram("F", instructorClassDiagram);
    var studClass5 = getClassFromClassDiagram("G", studentClassDiagram);
    var studClass6 = getClassFromClassDiagram("C", studentClassDiagram);
    
    var instClass7 = getClassFromClassDiagram("D", instructorClassDiagram);
    var instClass8 = getClassFromClassDiagram("C", instructorClassDiagram);
    var studClass7 = getClassFromClassDiagram("D", studentClassDiagram);
    var studClass8 = getClassFromClassDiagram("F", studentClassDiagram);
    
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
   
    assertMistake(getMistakeForElement(studClass1, WRONG_SUPERCLASS, comparison), WRONG_SUPERCLASS, List.of(studClass1, studClass2),
        List.of(instClass1, instClass2), 0, 1, false);  
    assertMistake(getMistakeForElement(studClass3, WRONG_SUPERCLASS, comparison), WRONG_SUPERCLASS, List.of(studClass3, studClass4),
        List.of(instClass3, instClass4), 0, 1, false);
    assertMistake(getMistakeForElement(studClass5, WRONG_SUPERCLASS, comparison), WRONG_SUPERCLASS, List.of(studClass5, studClass6),
        List.of(instClass5, instClass6), 0, 1, false);
    assertMistake(getMistakeForElement(studClass7, WRONG_SUPERCLASS, comparison), WRONG_SUPERCLASS, List.of(studClass7, studClass8),
        List.of(instClass7, instClass8), 0, 1, false);
  }
}
