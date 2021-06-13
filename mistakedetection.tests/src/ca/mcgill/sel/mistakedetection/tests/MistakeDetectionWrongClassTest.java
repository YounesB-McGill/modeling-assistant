package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import learningcorpus.mistaketypes.MistakeTypes;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.util.ResourceHelper;

public class MistakeDetectionWrongClassTest {

  /**
   * Test to check for plural class names in student solution
   */
  @Test
  public void testStudentSolution_1_PluralClassName() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution-a.domain_model.cdm";
    // Contains Class Buses and Drivers
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);

    for (var c : classDiagram.getClasses()) {
      assertTrue(MistakeDetection.isPlural(c.getName()));
    }

    ClassdiagramPackage.eINSTANCE.eClass();
    cdmFile =
        "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
    // Contains Class Buses and Driver
    resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    classDiagram = (ClassDiagram) resource.getContents().get(0);

    for (var c : classDiagram.getClasses()) {
      assertFalse(MistakeDetection.isPlural(c.getName()));
    }
  }

  /**
   * Test to check mapping function(checkCorrect) that will be called with .compare. For testing
   * checkCorrectTest is created and called. It has same functionality as checkCorrect. This test
   * check for mapping b/w Bus = Bus and Driver != Bus.
   */
  @Test
  public void checkCorrectTest() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    Classifier studentBusClass = solution.getClassDiagram().getClasses().get(0);
    Classifier studentDriverClass = solution.getClassDiagram().getClasses().get(1);

    assertTrue(MistakeDetection.checkCorrectTest(studentBusClass, studentBusClass));
    assertFalse(MistakeDetection.checkCorrectTest(studentBusClass, studentDriverClass));
  }

  /**
   * Test for checking mapping between instructor classifier(Bus, Driver) and Student
   * classifier(Bus, Driver)
   */
  @Test
  public void checkCorrectTestWithSolution1() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
    var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
    var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
    var maf1 = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant1 = maf1.createModelingAssistant();
    var solution1 = maf1.createSolution();
    solution1.setModelingAssistant(modelingAssistant1);
    solution1.setClassDiagram(classDiagram1);
    var student = maf1.createStudent();
    solution1.setStudent(student);

    Classifier instructorBusClass = null;
    Classifier instructorDriverClass = null;

    for (var c : classDiagram.getClasses()) {
      if ("Bus".equals(c.getName()))
        instructorBusClass = c;
      else if ("Driver".equals(c.getName()))
        instructorDriverClass = c;
    }

    Classifier studentBusClass = null;
    Classifier studentDriverClass = null;

    for (var c : classDiagram1.getClasses()) {
      if ("Bus".equals(c.getName()))
        studentBusClass = c;
      else if ("Driver".equals(c.getName()))
        studentDriverClass = c;
    }

    assertTrue(MistakeDetection.checkCorrectTest(instructorBusClass, studentBusClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorDriverClass, studentDriverClass));

    var comparison = MistakeDetection.compare(solution, solution1);
    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 2);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertEquals(comparison.newMistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);
  }

  /**
   * Test for checking mapping between instructor classifier(Bus, Driver) and Student
   * classifier(Buses, Drivers)
   */
  @Test
  public void checkCorrectTestWithSolution2() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution-a.domain_model.cdm";
    var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
    var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
    var maf1 = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant1 = maf1.createModelingAssistant();
    var solution1 = maf1.createSolution();
    solution1.setModelingAssistant(modelingAssistant1);
    solution1.setClassDiagram(classDiagram1);
    var student = maf1.createStudent();
    solution1.setStudent(student);

    Classifier instructorBusClass = null;
    Classifier instructorDriverClass = null;

    for (var c : classDiagram.getClasses()) {
      if ("Bus".equals(c.getName()))
        instructorBusClass = c;
      else if ("Driver".equals(c.getName()))
        instructorDriverClass = c;
    }

    Classifier studentBusesClass = null;
    Classifier studentDriversClass = null;

    for (var c : classDiagram1.getClasses()) {
      if ("Buses".equals(c.getName()))
        studentBusesClass = c;
      else if ("Drivers".equals(c.getName()))
        studentDriversClass = c;
    }

    assertTrue(MistakeDetection.checkCorrectTest(instructorBusClass, studentBusesClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorDriverClass, studentDriversClass));

    var comparison = MistakeDetection.compare(solution, solution1);
    // var comparison = MistakeDetection.compare(solution, solution1);
    // assertEquals(comparison.mappedClassifier.size(), 2);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 2);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusesClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriversClass);

    assertEquals(comparison.newMistakes.size(), 4);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.PLURAL_CLASS_NAME
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.PLURAL_CLASS_NAME
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
    }
  }

  @Test
  void testCheckMistakePluralClassName() {
    // no mistake
    var studentClass = MistakeDetection.CDF.createClass();
    studentClass.setName("Woman");

    var instructorClass = MistakeDetection.CDF.createClass();
    instructorClass.setName("Woman");

    assertTrue(MistakeDetection.checkMistakePluralClassName(studentClass,instructorClass).isEmpty());

    // mistake
    var expected = MistakeDetection.MAF.createMistake();
    expected.setMistakeType(MistakeTypes.PLURAL_CLASS_NAME);
    studentClass = MistakeDetection.CDF.createClass();
    studentClass.setName("Women");

    instructorClass = MistakeDetection.CDF.createClass();
    instructorClass.setName("Woman");

    var actual = MistakeDetection.checkMistakePluralClassName(studentClass,instructorClass).get();
    assertEquals(expected.getMistakeType(), actual.getMistakeType());
  }

}
