package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.Comparison;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import classdiagram.Association;
import classdiagram.Attribute;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import modelingassistant.Mistake;
import modelingassistant.MistakeType;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.mistaketypes.MistakeTypes;
import modelingassistant.util.ResourceHelper;

public class MistakeDetectionTest {


  /**
   * Test to check if all the classes exist in Instructor solution are loaded in cdmFile
   * */
  @Test public void testLoadingInstructorSolution() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);

    Classifier busClass = null;
    Classifier driverClass = null;

    for (var c : classDiagram.getClasses()) {
      if ("Bus".equals(c.getName()))
        busClass = c;
      else if ("Driver".equals(c.getName()))
        driverClass = c;
    }

    assertEquals(busClass, classDiagram.getClasses().get(0));
    assertEquals("Bus", busClass.getName());
    assertEquals(driverClass, classDiagram.getClasses().get(1));
    assertEquals("Driver", driverClass.getName());

    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    List.of(busClass, driverClass).forEach(c -> assertTrue(solution.getClassDiagram().getClasses().contains(c)));
  }

  /**
   * Test to check if all the classes exist in Student solution are loaded in cdmFile
   */
  @Test public void testLoadingStudentSolution1() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);

    Classifier busClass = null;
    Classifier driverClass = null;

    for (var c : classDiagram.getClasses()) {
      if ("Bus".equals(c.getName()))
        busClass = c;
      else if ("Driver".equals(c.getName()))
        driverClass = c;
    }

    assertEquals(busClass, classDiagram.getClasses().get(0));
    assertEquals("Bus", busClass.getName());
    assertEquals(driverClass, classDiagram.getClasses().get(1));
    assertEquals("Driver", driverClass.getName());

    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    List.of(busClass, driverClass).forEach(c -> assertTrue(solution.getClassDiagram().getClasses().contains(c)));
  }

  /**
   * Test to check if cdm file with attributes is loaded correctly.
   */
  @Test public void checkSolution_withAttributes() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);

    Classifier busClass = null;
    Classifier driverClass = null;
    Classifier passangerClass = null;

    for (var c : classDiagram.getClasses()) {
      if ("Bus".equals(c.getName()))
        busClass = c;
      else if ("Driver".equals(c.getName()))
        driverClass = c;
      else if ("Passanger".equals(c.getName()))
         passangerClass = c;
    }

    assertEquals(busClass, classDiagram.getClasses().get(0));
    assertEquals("Bus", busClass.getName());
    assertEquals(driverClass, classDiagram.getClasses().get(1));
    assertEquals("Driver", driverClass.getName());
    assertEquals(passangerClass, classDiagram.getClasses().get(2));
    assertEquals("Passanger", passangerClass.getName());

    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    List.of(busClass, driverClass, passangerClass).forEach(c -> assertTrue(solution.getClassDiagram().getClasses().contains(c)));
  }



  /**
   * Test to check Mistakes in Metamodel
   */
  @Test public void checkCompareWithSolution1_Metamodel() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
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
    assertEquals(comparison.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(comparison.newMistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);

    // Loading 2nd Solution to check Mistakes Update in Metamodel
    cdmFile1 = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution-a.domain_model.cdm";
    resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
    classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
    solution1 = maf1.createSolution();
    solution1.setModelingAssistant(modelingAssistant1);
    solution1.setClassDiagram(classDiagram1);
    solution1.setStudent(student);

    instructorBusClass = null;
    instructorDriverClass = null;

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

    comparison = MistakeDetection.compare(solution,solution1);
    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 2);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass),studentBusesClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass),studentDriversClass);
    assertEquals(comparison.newMistakes.size(), 4);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
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
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
    }

    // Running the second Solution again to check updated attribute values in Mistake in Metamodel
    assertEquals(solution1.getMistakes().size(), 4);

    comparison = MistakeDetection.compare(solution,solution1);
    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 2);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass),studentBusesClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass),studentDriversClass);

    assertEquals(comparison.newMistakes.size(), 4);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
    }

    comparison = MistakeDetection.compare(solution,solution1);
    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 2);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass),studentBusesClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass),studentDriversClass);

    assertEquals(comparison.newMistakes.size(), 4);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 3);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 3);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 3);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 3);
        assertFalse(m.isResolved());
      }
    }

    // checking with perfect solution
    cdmFile1 = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
    resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
    classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
    modelingAssistant1 = maf1.createModelingAssistant();
    solution1.setModelingAssistant(modelingAssistant1);
    solution1.setClassDiagram(classDiagram1);
    solution1.setStudent(student);

    instructorBusClass = null;
    instructorDriverClass = null;

    for (var c : classDiagram.getClasses()) {
      if ("Bus".equals(c.getName()))
        instructorBusClass = c;
      else if ("Driver".equals(c.getName()))
        instructorDriverClass = c;
    }

    studentBusClass = null;
    studentDriverClass = null;

    for (var c : classDiagram1.getClasses()) {
      if ("Bus".equals(c.getName()))
        studentBusClass = c;
      else if ("Driver".equals(c.getName()))
        studentDriverClass = c;
    }

    comparison = MistakeDetection.compare(solution, solution1);
    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 2);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(comparison.newMistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClass);
        assertEquals(m.getNumDetectionSinceResolved(), 1);
        assertEquals(m.getNumDetection(), 3);
        assertTrue(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverClass);
        assertEquals(m.getNumDetectionSinceResolved(), 1);
        assertEquals(m.getNumDetection(), 3);
        assertTrue(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClass);
        assertEquals(m.getNumDetectionSinceResolved(), 1);
        assertEquals(m.getNumDetection(), 3);
        assertTrue(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverClass);
        assertEquals(m.getNumDetectionSinceResolved(), 1);
        assertEquals(m.getNumDetection(), 3);
        assertTrue(m.isResolved());
      }
    }
  }

  /**
   * Test to check for mapped classifiers(Passanger,Bus,Driver) and attributes Spelling Mistakes (nam,capacty,nme,noPlate)
   */
  @Test public void checkCorrectTestWithSolutionThree_withAttributes() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/three(withAttributes)/ClassDiagram/Three(withAttributes).domain_model.cdm";
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
    Classifier instructorPassangerClass = null;

    Attribute instructorBusClassAttributeCapacity = null;
    Attribute instructorBusClassAttributeNumberPlate = null;
    Attribute instructorDriverClassAttributeName = null;
    Attribute instructorPassengerClassAttributeName = null;

    for (var c : classDiagram.getClasses()) {
      if ("Bus".equals(c.getName())) {
        instructorBusClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("capacity".equals(a.getName())) {
            instructorBusClassAttributeCapacity = a;
          }
          if ("numberPlate".equals(a.getName())) {
            instructorBusClassAttributeNumberPlate = a;
          }
        }
      } else if ("Driver".equals(c.getName())) {
        instructorDriverClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            instructorDriverClassAttributeName = a;
          }
        }
      } else if ("Passanger".equals(c.getName())) {
        instructorPassangerClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            instructorPassengerClassAttributeName = a;
          }
        }
      }
    }

    Classifier studentBusClass = null;
    Classifier studentDriverClass = null;
    Classifier studentPassangerClass = null;

    Attribute studentBusClassAttributeCapacty = null;
    Attribute studentBusClassAttributeNamberPlate = null;
    Attribute studentDriverClassAttributeNme = null;
    Attribute studentPassengerClassAttributeNam = null;

    for (var c : classDiagram1.getClasses()) {
      if ("Bus".equals(c.getName())) {
        studentBusClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("capacty".equals(a.getName())) {
            studentBusClassAttributeCapacty = a;
          }
          if ("namberPlate".equals(a.getName())) {
            studentBusClassAttributeNamberPlate = a;
          }
        }
      } else if ("Driver".equals(c.getName())) {
        studentDriverClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("nme".equals(a.getName())) {
            studentDriverClassAttributeNme = a;
          }

        }
      } else if ("Passanger".equals(c.getName())) {
        studentPassangerClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("nam".equals(a.getName())) {
            studentPassengerClassAttributeNam = a;
          }
        }
      }
    }

    assertTrue(MistakeDetection.checkCorrectTest(instructorBusClass, studentBusClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorDriverClass, studentDriverClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorPassangerClass,studentPassangerClass));

    var comparison = MistakeDetection.compare(solution,solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 3);

    assertEquals(comparison.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassangerClass),studentPassangerClass);

    assertEquals(comparison.notMappedInstructorAttribute.size(), 0);
    assertEquals(comparison.extraStudentAttribute.size(), 0);
    assertEquals(comparison.duplicateStudentAttribute.size(), 0);
    assertEquals(comparison.mappedAttribute.size(), 4);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeCapacity),studentBusClassAttributeCapacty);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeNumberPlate),studentBusClassAttributeNamberPlate);
    assertEquals(comparison.mappedAttribute.get(instructorDriverClassAttributeName),studentDriverClassAttributeNme);
    assertEquals(comparison.mappedAttribute.get(instructorPassengerClassAttributeName),studentPassengerClassAttributeNam);
    assertEquals(comparison.newMistakes.size(), 4);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_NAME
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeCapacty) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusClassAttributeCapacty);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClassAttributeCapacity);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_NAME
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeNamberPlate) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusClassAttributeNamberPlate);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClassAttributeNumberPlate);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_NAME
          && m.getStudentElements().get(0).getElement() == studentDriverClassAttributeNme) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriverClassAttributeNme);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_NAME
          && m.getStudentElements().get(0).getElement() == studentPassengerClassAttributeNam) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentPassengerClassAttributeNam);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorPassengerClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
    }
  }

  /**
   * Test to check for mapped classifiers(Passanger,Bus,Driver) and attributes(name,capacity,name,numberPlate) with Wrong Attribute Types
   */
  @Test public void checkCorrectTestWithSolution4_withWrongAttributesTypes() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/four(WrongAttibuteType)/ClassDiagram/Four(WrongAttibuteType).domain_model.cdm";
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
    Classifier instructorPassangerClass = null;

    Attribute instructorBusClassAttributeCapacity = null;
    Attribute instructorBusClassAttributeNumberPlate = null;
    Attribute instructorDriverClassAttributeName = null;
    Attribute instructorPassengerClassAttributeName = null;

    for (var c : classDiagram.getClasses()) {
      if ("Bus".equals(c.getName())) {
        instructorBusClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("capacity".equals(a.getName())) {
            instructorBusClassAttributeCapacity = a;
          }
          if ("numberPlate".equals(a.getName())) {
            instructorBusClassAttributeNumberPlate = a;
          }
        }
      } else if ("Driver".equals(c.getName())) {
        instructorDriverClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            instructorDriverClassAttributeName = a;
          }
        }
      } else if ("Passanger".equals(c.getName())) {
        instructorPassangerClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            instructorPassengerClassAttributeName = a;
          }
        }
      }
    }

    Classifier studentBusClass = null;
    Classifier studentDriverClass = null;
    Classifier studentPassangerClass = null;

    Attribute studentBusClassAttributeCapacity = null;
    Attribute studentBusClassAttributeNumberPlate = null;
    Attribute studentDriverClassAttributeName = null;
    Attribute studentPassengerClassAttributeName = null;

    for (var c : classDiagram1.getClasses()) {
      if ("Bus".equals(c.getName())) {
        studentBusClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("capacity".equals(a.getName())) {
            studentBusClassAttributeCapacity = a;
          }
          if ("numberPlate".equals(a.getName())) {
            studentBusClassAttributeNumberPlate = a;
          }
        }
      } else if ("Driver".equals(c.getName())) {
        studentDriverClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            studentDriverClassAttributeName = a;
          }
        }
      } else if ("Passanger".equals(c.getName())) {
        studentPassangerClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            studentPassengerClassAttributeName = a;
          }
        }
      }
    }

    assertTrue(MistakeDetection.checkCorrectTest(instructorBusClass, studentBusClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorDriverClass, studentDriverClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorPassangerClass,studentPassangerClass));

    var comparison = MistakeDetection.compare(solution,solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 3);

    assertEquals(comparison.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassangerClass),studentPassangerClass);

    assertEquals(comparison.notMappedInstructorAttribute.size(), 0);
    assertEquals(comparison.extraStudentAttribute.size(), 0);
    assertEquals(comparison.duplicateStudentAttribute.size(), 0);
    assertEquals(comparison.mappedAttribute.size(), 4);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeCapacity),studentBusClassAttributeCapacity);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeNumberPlate),studentBusClassAttributeNumberPlate);
    assertEquals(comparison.mappedAttribute.get(instructorDriverClassAttributeName),studentDriverClassAttributeName);
    assertEquals(comparison.mappedAttribute.get(instructorPassengerClassAttributeName),studentPassengerClassAttributeName);

    assertEquals(comparison.newMistakes.size(), 4);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeCapacity) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusClassAttributeCapacity);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClassAttributeCapacity);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeNumberPlate) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusClassAttributeNumberPlate);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClassAttributeNumberPlate);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentDriverClassAttributeName) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriverClassAttributeName);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());

      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentPassengerClassAttributeName) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentPassengerClassAttributeName);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorPassengerClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
    }

    // ---------Second iteration to test update of mistake Properties---
    comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 3);

    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassangerClass), studentPassangerClass);

    assertEquals(comparison.notMappedInstructorAttribute.size(), 0);
    assertEquals(comparison.extraStudentAttribute.size(), 0);
    assertEquals(comparison.duplicateStudentAttribute.size(), 0);
    assertEquals(comparison.mappedAttribute.size(), 4);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeCapacity),
        studentBusClassAttributeCapacity);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeNumberPlate),
        studentBusClassAttributeNumberPlate);
    assertEquals(comparison.mappedAttribute.get(instructorDriverClassAttributeName),
        studentDriverClassAttributeName);
    assertEquals(comparison.mappedAttribute.get(instructorPassengerClassAttributeName),
        studentPassengerClassAttributeName);

    assertEquals(comparison.newMistakes.size(), 4);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeCapacity) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusClassAttributeCapacity);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClassAttributeCapacity);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeNumberPlate) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusClassAttributeNumberPlate);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClassAttributeNumberPlate);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentDriverClassAttributeName) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriverClassAttributeName);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentPassengerClassAttributeName) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentPassengerClassAttributeName);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorPassengerClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
    }
  }

  /**
   * Function to print the mapped, unmapped classifier or attributes.
   */
  public static void log(Comparison comparison) {
    System.out.println();
    System.out.println("----Test Logger-----");
    System.out.print("Not Mapped InstructorClassifier List : ");
    for (Classifier c : comparison.notMappedInstructorClassifier) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Not Mapped extraStudentClassifier : ");
    for (Classifier c : comparison.extraStudentClassifier) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.println("Mapped Classifiers : ");
    comparison.mappedClassifier
        .forEach((key, value) -> System.out.println(key.getName() + " = " + value.getName()));
    System.out.println();
    System.out.print("Not Mapped InstructorAttribute List : ");
    for (Attribute c : comparison.notMappedInstructorAttribute) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Not Mapped extraStudentAttribute : ");
    for (Attribute c : comparison.extraStudentAttribute) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("duplicate Attribute : ");
    for (Attribute c : comparison.duplicateStudentAttribute) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.println("Mapped Attributes : ");
    comparison.mappedAttribute.forEach((key, value) -> System.out
        .println(key.getType() + " " + key.getName() + " = " + value.getType() + " " + value.getName()));

    System.out.println();
    System.out.print("Not Mapped Association : ");
    for (Association assoc : comparison.notMappedInstructorAssociation) {
      System.out.print(assoc.getName() + " ");
    }

    System.out.println();
    System.out.print("Extra Association : ");
    for (Association assoc : comparison.extraStudentAssociation) {
      System.out.print(assoc.getName() + " ");
    }
    System.out.println();
    System.out.println("Mapped Association : ");
    comparison.mappedAssociation.forEach((key, value) -> System.out
        .println(key.getName() + " " + value.getName()));

    System.out.println();
    System.out.println("Mistakes : ");
    comparison.newMistakes.forEach((m) -> System.out
        .println(m.getMistakeType()));
  }

  public static boolean mistakesContainMistakeType(List<Mistake> mistakes, MistakeType mistakeType) {
    return mistakes.stream().anyMatch(mistake -> mistake.getMistakeType().equals(mistakeType));
  }

}
