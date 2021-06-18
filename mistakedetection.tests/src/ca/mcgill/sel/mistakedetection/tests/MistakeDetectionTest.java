package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.CdmPackage;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.classdiagram.util.CdmResourceFactoryImpl;
import ca.mcgill.sel.mistakedetection.Comparison;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import learningcorpus.MistakeType;
import learningcorpus.mistaketypes.MistakeTypes;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.util.ResourceHelper;

public class MistakeDetectionTest {


  /**
   * Test to check if all the classes exist in Instructor solution are loaded in cdmFile
   */
  @Test
  public void testLoadingInstructorSolution() {
    CdmPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
    var classDiagram = cdmFromFile(cdmFile);

    Classifier busClass = getClassFromClassDiagram("Bus", classDiagram);
    Classifier driverClass = getClassFromClassDiagram("Driver", classDiagram);

    assertEquals(busClass, classDiagram.getClasses().get(0));
    assertEquals("Bus", busClass.getName());
    assertEquals(driverClass, classDiagram.getClasses().get(1));
    assertEquals("Driver", driverClass.getName());

    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    assertTrue(solution.getClassDiagram().getClasses().containsAll(List.of(busClass, driverClass)));
  }

  /**
   * Test to check if all the classes exist in Student solution are loaded in cdmFile
   */
  @Test
  public void testLoadingStudentSolution1() {
    CdmPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
    var classDiagram = cdmFromFile(cdmFile);

    Classifier busClass = getClassFromClassDiagram("Bus", classDiagram);
    Classifier driverClass = getClassFromClassDiagram("Driver", classDiagram);

    assertEquals(busClass, classDiagram.getClasses().get(0));
    assertEquals("Bus", busClass.getName());
    assertEquals(driverClass, classDiagram.getClasses().get(1));
    assertEquals("Driver", driverClass.getName());

    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    List.of(busClass, driverClass)
        .forEach(c -> assertTrue(solution.getClassDiagram().getClasses().contains(c)));
  }

  /**
   * Test to check if cdm file with attributes is loaded correctly.
   */
  @Test
  public void checkSolution_withAttributes() {
    CdmPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);

    Classifier busClass = getClassFromClassDiagram("Bus", classDiagram);
    Classifier driverClass = getClassFromClassDiagram("Driver", classDiagram);
    Classifier passangerClass = getClassFromClassDiagram("Passenger", classDiagram);

    assertEquals(busClass, classDiagram.getClasses().get(0));
    assertEquals("Bus", busClass.getName());
    assertEquals(driverClass, classDiagram.getClasses().get(1));
    assertEquals("Driver", driverClass.getName());
    assertEquals(passangerClass, classDiagram.getClasses().get(2));
    assertEquals("Passenger", passangerClass.getName());

    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    List.of(busClass, driverClass, passangerClass)
        .forEach(c -> assertTrue(solution.getClassDiagram().getClasses().contains(c)));
  }



  /**
   * Test to check Mistakes in Metamodel
   */
  @Test
  public void checkCompareWithSolution1_Metamodel() {
    CdmPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    CdmPackage.eINSTANCE.eClass();
    var cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
    var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
    var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
    var modelingAssistant1 = maf.createModelingAssistant();
    var solution1 = maf.createSolution();
    solution1.setModelingAssistant(modelingAssistant1);
    solution1.setClassDiagram(classDiagram1);
    var student = maf.createStudent();
    solution1.setStudent(student);

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", classDiagram);
    Classifier instructorDriverClass = getClassFromClassDiagram("Driver", classDiagram);

    Classifier studentBusClass = getClassFromClassDiagram("Bus", classDiagram1);
    Classifier studentDriverClass = getClassFromClassDiagram("Driver", classDiagram1);

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

    // Loading 2nd Solution to check Mistakes Update in Metamodel
    cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution-a.domain_model.cdm";
    resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
    classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
    solution1 = maf.createSolution();
    solution1.setModelingAssistant(modelingAssistant1);
    solution1.setClassDiagram(classDiagram1);
    solution1.setStudent(student);

    instructorBusClass = getClassFromClassDiagram("Bus", classDiagram);
    instructorDriverClass = getClassFromClassDiagram("Driver", classDiagram);

    Classifier studentBusesClass = getClassFromClassDiagram("Buses", classDiagram1);
    Classifier studentDriversClass = getClassFromClassDiagram("Drivers", classDiagram1);

    assertTrue(MistakeDetection.checkCorrectTest(instructorBusClass, studentBusesClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorDriverClass, studentDriversClass));

    comparison = MistakeDetection.compare(solution, solution1);
    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 2);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusesClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriversClass);

    assertEquals(comparison.newMistakes.size(), 6); // 2 Bad Role Name Spelling
    assertEquals(solution1.getMistakes().size(), 6);

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
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
    }
    // Running the second Solution again to check updated attribute values in Mistake in Metamodel
    assertEquals(solution1.getMistakes().size(), 4 + 2);
    comparison = MistakeDetection.compare(solution, solution1);
    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 2);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusesClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriversClass);

    assertEquals(comparison.newMistakes.size(), 6);
    assertEquals(solution1.getMistakes().size(), 6);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.PLURAL_CLASS_NAME
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.PLURAL_CLASS_NAME
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

    comparison = MistakeDetection.compare(solution, solution1);
    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 2);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusesClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriversClass);

    assertEquals(comparison.newMistakes.size(), 6);
    assertEquals(solution1.getMistakes().size(), 6);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.PLURAL_CLASS_NAME
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 3);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.PLURAL_CLASS_NAME
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
    cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
    resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
    classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
    modelingAssistant1 = maf.createModelingAssistant();
    solution1.setModelingAssistant(modelingAssistant1);
    solution1.setClassDiagram(classDiagram1);
    solution1.setStudent(student);

    instructorBusClass = getClassFromClassDiagram("Bus", classDiagram);
    instructorDriverClass = getClassFromClassDiagram("Driver", classDiagram);

    studentBusClass = getClassFromClassDiagram("Bus", classDiagram1);
    studentDriverClass = getClassFromClassDiagram("Driver", classDiagram1);

    comparison = MistakeDetection.compare(solution, solution1);
    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 2);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertEquals(comparison.newMistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 6);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.PLURAL_CLASS_NAME
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClass);
        assertEquals(m.getNumDetectionSinceResolved(), 1);
        assertEquals(m.getNumDetection(), 3);
        assertTrue(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.PLURAL_CLASS_NAME
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
   * Test to check for mapped classifiers(Passenger,Bus,Driver) and attributes Spelling Mistakes
   * (nam,capacty,nme,noPlate)
   */
  @Test
  public void checkCorrectTestWithSolutionThree_withAttributes() {
    CdmPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    var cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/three(withAttributes)/ClassDiagram/Three(withAttributes).domain_model.cdm";
    var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
    var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
    var maf1 = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant1 = maf1.createModelingAssistant();
    var solution1 = maf1.createSolution();
    solution1.setModelingAssistant(modelingAssistant1);
    solution1.setClassDiagram(classDiagram1);
    var student = maf1.createStudent();
    solution1.setStudent(student);

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", classDiagram);
    Classifier instructorDriverClass = getClassFromClassDiagram("Driver", classDiagram);
    Classifier instructorPassengerClass = getClassFromClassDiagram("Passenger", classDiagram);

    Attribute instructorBusClassAttributeCapacity =
        getAttributeFromClass("capacity", instructorBusClass);
    Attribute instructorBusClassAttributeNumberPlate =
        getAttributeFromClass("numberPlate", instructorBusClass);
    Attribute instructorDriverClassAttributeName =
        getAttributeFromClass("name", instructorDriverClass);
    Attribute instructorPassengerClassAttributeName =
        getAttributeFromClass("name", instructorPassengerClass);

    Classifier studentBusClass = getClassFromClassDiagram("Bus", classDiagram1);
    Classifier studentDriverClass = getClassFromClassDiagram("Driver", classDiagram1);
    Classifier studentPassengerClass = getClassFromClassDiagram("Passenger", classDiagram1);

    Attribute studentBusClassAttributeCapacty = getAttributeFromClass("capacty", studentBusClass);
    Attribute studentBusClassAttributeNamberPlate =
        getAttributeFromClass("namberPlate", studentBusClass);
    Attribute studentDriverClassAttributeNme = getAttributeFromClass("nme", studentDriverClass);
    Attribute studentPassengerClassAttributeNam =
        getAttributeFromClass("nam", studentPassengerClass);

    assertTrue(MistakeDetection.checkCorrectTest(instructorBusClass, studentBusClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorDriverClass, studentDriverClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorPassengerClass, studentPassengerClass));

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 3);

    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassengerClass), studentPassengerClass);

    assertEquals(comparison.notMappedInstructorAttribute.size(), 0);
    assertEquals(comparison.extraStudentAttribute.size(), 0);
    assertEquals(comparison.duplicateStudentAttribute.size(), 0);
    assertEquals(comparison.mappedAttribute.size(), 4);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeCapacity),
        studentBusClassAttributeCapacty);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeNumberPlate),
        studentBusClassAttributeNamberPlate);
    assertEquals(comparison.mappedAttribute.get(instructorDriverClassAttributeName),
        studentDriverClassAttributeNme);
    assertEquals(comparison.mappedAttribute.get(instructorPassengerClassAttributeName),
        studentPassengerClassAttributeNam);

    assertEquals(comparison.newMistakes.size(), 4);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_NAME
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeCapacty) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusClassAttributeCapacty);
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorBusClassAttributeCapacity);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_NAME
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeNamberPlate) {
        assertEquals(m.getStudentElements().get(0).getElement(),
            studentBusClassAttributeNamberPlate);
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorBusClassAttributeNumberPlate);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_NAME
          && m.getStudentElements().get(0).getElement() == studentDriverClassAttributeNme) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriverClassAttributeNme);
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorDriverClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_NAME
          && m.getStudentElements().get(0).getElement() == studentPassengerClassAttributeNam) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentPassengerClassAttributeNam);
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorPassengerClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
    }
  }

  /**
   * Test to check for mapped classifiers(Passenger,Bus,Driver) and
   * attributes(name,capacity,name,numberPlate) with Wrong Attribute Types
   */
  @Test
  public void checkCorrectTestWithSolution4_withWrongAttributesTypes() {
    CdmPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    CdmPackage.eINSTANCE.eClass();
    var cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/four(WrongAttibuteType)/ClassDiagram/Four(WrongAttibuteType).domain_model.cdm";
    var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
    var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
    var maf1 = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant1 = maf1.createModelingAssistant();
    var solution1 = maf1.createSolution();
    solution1.setModelingAssistant(modelingAssistant1);
    solution1.setClassDiagram(classDiagram1);
    var student = maf1.createStudent();
    solution1.setStudent(student);

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", classDiagram);
    Classifier instructorDriverClass = getClassFromClassDiagram("Driver", classDiagram);
    Classifier instructorPassengerClass = getClassFromClassDiagram("Passenger", classDiagram);

    Attribute instructorBusClassAttributeCapacity =
        getAttributeFromClass("capacity", instructorBusClass);
    Attribute instructorBusClassAttributeNumberPlate =
        getAttributeFromClass("numberPlate", instructorBusClass);
    Attribute instructorDriverClassAttributeName =
        getAttributeFromClass("name", instructorDriverClass);
    Attribute instructorPassengerClassAttributeName =
        getAttributeFromClass("name", instructorPassengerClass);

    Classifier studentBusClass = getClassFromClassDiagram("Bus", classDiagram1);
    Classifier studentDriverClass = getClassFromClassDiagram("Driver", classDiagram1);
    Classifier studentPassengerClass = getClassFromClassDiagram("Passenger", classDiagram1);

    Attribute studentBusClassAttributeCapacity = getAttributeFromClass("capacity", studentBusClass);
    Attribute studentBusClassAttributeNumberPlate =
        getAttributeFromClass("numberPlate", studentBusClass);
    Attribute studentDriverClassAttributeName = getAttributeFromClass("name", studentDriverClass);
    Attribute studentPassengerClassAttributeName =
        getAttributeFromClass("name", studentPassengerClass);

    assertTrue(MistakeDetection.checkCorrectTest(instructorBusClass, studentBusClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorDriverClass, studentDriverClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorPassengerClass, studentPassengerClass));

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 3);

    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassengerClass), studentPassengerClass);

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
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorBusClassAttributeCapacity);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeNumberPlate) {
        assertEquals(m.getStudentElements().get(0).getElement(),
            studentBusClassAttributeNumberPlate);
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorBusClassAttributeNumberPlate);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentDriverClassAttributeName) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriverClassAttributeName);
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorDriverClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());

      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentPassengerClassAttributeName) {
        assertEquals(m.getStudentElements().get(0).getElement(),
            studentPassengerClassAttributeName);
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorPassengerClassAttributeName);
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
    assertEquals(comparison.mappedClassifier.get(instructorPassengerClass), studentPassengerClass);

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
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorBusClassAttributeCapacity);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeNumberPlate) {
        assertEquals(m.getStudentElements().get(0).getElement(),
            studentBusClassAttributeNumberPlate);
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorBusClassAttributeNumberPlate);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentDriverClassAttributeName) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriverClassAttributeName);
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorDriverClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentPassengerClassAttributeName) {
        assertEquals(m.getStudentElements().get(0).getElement(),
            studentPassengerClassAttributeName);
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorPassengerClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
    }
  }

  /**
   * Helper function returns a classifier from a class diagram based on class name.
   *
   * @param className
   * @param classDiagram
   * @return Classifier
   */
  public static Classifier getClassFromClassDiagram(String className, ClassDiagram classDiagram) {
    Classifier seekedClass = null;
    for (var c : classDiagram.getClasses()) {
      if (className.equals(c.getName()))
        seekedClass = c;
    }
    if (seekedClass == null) {
      throw new IllegalArgumentException("No Class Found, Please check the class name");
    }
    return seekedClass;
  }

  /**
   * Helper function returns an attribute from a class based on attribute name.
   *
   * @param className
   * @param classDiagram
   * @return Attribute
   */
  public static Attribute getAttributeFromClass(String attributeName, Classifier givenClass) {
    Attribute seekedAttribute = null;
    for (var a : givenClass.getAttributes()) {
      if (attributeName.equals(a.getName())) {
        seekedAttribute = a;
      }
    }
    if (seekedAttribute == null) {
      throw new IllegalArgumentException("No Attribute Found, Please check the attribute name");
    }
    return seekedAttribute;
  }

  /**
   * Helper function returns an association between 2 classes from a class diagram.
   *
   * @param className
   * @param classDiagram
   * @return Association
   */
  public static Association getAssociationFromClassDiagram(Classifier class1, Classifier class2,
      ClassDiagram classDiagram) {
    Association seekedAssociation = null;
    for (var assoc : classDiagram.getAssociations()) {
      if (assoc.getName().contains(class1.getName())
          && assoc.getName().contains(class2.getName())) {
        seekedAssociation = assoc;
      }
    }
    if (seekedAssociation == null) {
      throw new IllegalArgumentException("No Association Found, Please check the association name");
    }
    return seekedAssociation;
  }

  /**
   * Helper function returns an association end of a class based on association end name.
   *
   * @param className
   * @param classDiagram
   * @return AssociationEnd
   */
  public static AssociationEnd getAssociationEndFromClass(String associationEndName,
      Classifier givenClass) {
    AssociationEnd seekedAssociationEnd = null;
    for (var assocEnd : givenClass.getAssociationEnds()) {
      if (associationEndName.equals(assocEnd.getName())) {
        seekedAssociationEnd = assocEnd;
      }
    }
    if (seekedAssociationEnd == null) {
      throw new IllegalArgumentException(
          "No Association End Found, Please check the association end name");
    }
    return seekedAssociationEnd;
  }

  public static boolean mistakesContainMistakeType(List<Mistake> mistakes,
      MistakeType mistakeType) {
    return mistakes.stream().anyMatch(mistake -> mistake.getMistakeType().equals(mistakeType));
  }

  /**
   * Returns the class diagram at the given *.cdm file.
   */
  public static ClassDiagram cdmFromFile(File file) {
    CdmPackage.eINSTANCE.eClass();
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cdm", new CdmResourceFactoryImpl());
    try {
      var cdmResource = rset.createResource(URI.createFileURI(file.getCanonicalPath()));
      cdmResource.load(Collections.EMPTY_MAP);
      return (ClassDiagram) cdmResource.getContents().get(0);
    } catch (IOException e) {
      return null;
    }
  }

  /**
   * Returns the class diagram at the given *.cdm file path.
   */
  static ClassDiagram cdmFromFile(String path) {
    return cdmFromFile(new File(path));
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
    comparison.mappedAttribute.forEach((key, value) -> System.out.println(key.getType().getClass()
        + " " + key.getName() + " = " + value.getType().getClass() + " " + value.getName()));

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
    comparison.mappedAssociation
        .forEach((key, value) -> System.out.println(key.getName() + " " + value.getName()));

    System.out.println();
    System.out.println("Mistakes : ");
    comparison.newMistakes.forEach(m -> {
      if (!m.getInstructorElements().isEmpty() && !m.getStudentElements().isEmpty()) {
        System.out.print(" ' " + m.getMistakeType().getName() + " ' " + " Inst Elements : ");
        m.getInstructorElements()
            .forEach(ie -> System.out.print(ie.getElement().getName() + " "));
        System.out.print(" student Elements :");
        m.getStudentElements().forEach(se -> System.out.print(se.getElement().getName() + " "));
        System.out.println();
      } else if (!m.getInstructorElements().isEmpty()) {
        System.out.print(" ' " + m.getMistakeType().getName() + " ' " + " Inst Elements : ");
        m.getInstructorElements()
            .forEach(ie -> System.out.print(ie.getElement().getName() + " "));
        System.out.println();
      } else if (!m.getStudentElements().isEmpty()) {
        System.out.print(" ' " + m.getMistakeType().getName() + " ' " + " Stud Elements : ");
        m.getStudentElements().forEach(se -> System.out.print(se.getElement().getName() + " "));
        System.out.println();
      } else {
        System.out.println(" ' " + m.getMistakeType().getName() + " ' ");
      }
    });

  }

}
