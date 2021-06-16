package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAssociationFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAttributeFromClass;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getClassFromClassDiagram;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import classdiagram.Association;
import classdiagram.Attribute;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import learningcorpus.mistaketypes.MistakeTypes;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.util.ResourceHelper;;

public class MistakeDetectionWrongAttributeTest {
  /**
   * Test to check for mapped classifiers(Passenger,Bus,Driver) and
   * attributes(name,capacity,name,numberPlate)
   */
  @Test
  public void checkCorrectTestWithSolution1_withAttributes() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute).domain_model.cdm";
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
    assertEquals(comparison.newMistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);
  }

  /**
   * Test to check classifier and attribute mapping (2 Attributes unmapped, all classes mapped)
   */
  @Test
  public void checkCorrectTestWithSolution2_withAttributes() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-a.domain_model.cdm";
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

    assertEquals(comparison.notMappedInstructorAttribute.size(), 2);
    assertEquals(comparison.extraStudentAttribute.size(), 0);
    assertEquals(comparison.duplicateStudentAttribute.size(), 0);
    assertEquals(comparison.mappedAttribute.size(), 2);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeCapacity),
        studentBusClassAttributeCapacity);
    assertEquals(comparison.mappedAttribute.get(instructorPassengerClassAttributeName),
        studentPassengerClassAttributeName);
    assertTrue(
        comparison.notMappedInstructorAttribute.contains(instructorDriverClassAttributeName));
    assertTrue(
        comparison.notMappedInstructorAttribute.contains(instructorBusClassAttributeNumberPlate));
    assertEquals(comparison.newMistakes.size(), 2);
    assertEquals(solution1.getMistakes().size(), 2);
    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.MISSING_ATTRIBUTE
          && m.getInstructorElements().get(0).getElement() == instructorDriverClassAttributeName) {
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorDriverClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.MISSING_ATTRIBUTE && m.getInstructorElements().get(0)
          .getElement() == instructorBusClassAttributeNumberPlate) {
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorBusClassAttributeNumberPlate);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertFalse(m.isResolved());
      }
    }
  }

  /**
   * Test to check for mapped classifier and attributes (2 classifiers and 4 attributes unmapped)
   */
  @Test
  public void checkCorrectTestWithSolution3_withAttributes_compare() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-b.domain_model.cdm";
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

    Classifier studentDriverClass = getClassFromClassDiagram("Driver", classDiagram1);

    Association instructorBusPassengerAssociation =
        getAssociationFromClassDiagram(instructorBusClass, instructorPassengerClass, classDiagram);
    Association instructorDriverBusAssociation =
        getAssociationFromClassDiagram(instructorBusClass, instructorDriverClass, classDiagram);

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 2);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 1);

    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertTrue(comparison.notMappedInstructorClassifier.contains(instructorPassengerClass));
    assertTrue(comparison.notMappedInstructorClassifier.contains(instructorBusClass));

    assertEquals(comparison.notMappedInstructorAttribute.size(), 4);
    assertEquals(comparison.extraStudentAttribute.size(), 0);
    assertEquals(comparison.duplicateStudentAttribute.size(), 0);
    assertEquals(comparison.mappedAttribute.size(), 0);

    assertTrue(
        comparison.notMappedInstructorAttribute.contains(instructorDriverClassAttributeName));
    assertTrue(
        comparison.notMappedInstructorAttribute.contains(instructorBusClassAttributeNumberPlate));
    assertTrue(
        comparison.notMappedInstructorAttribute.contains(instructorPassengerClassAttributeName));
    assertTrue(
        comparison.notMappedInstructorAttribute.contains(instructorBusClassAttributeCapacity));

    assertEquals(comparison.notMappedInstructorAssociation.size(), 2);
    assertEquals(comparison.extraStudentAssociation.size(), 0);
    assertEquals(comparison.mappedAssociation.size(), 0);

    assertEquals(comparison.newMistakes.size(), 8);
    assertEquals(solution1.getMistakes().size(), 8);
    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.MISSING_CLASS
          && m.getInstructorElements().get(0).getElement() == instructorPassengerClass) {
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorPassengerClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.MISSING_CLASS
          && m.getInstructorElements().get(0).getElement() == instructorBusClass) {
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorBusClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.MISSING_ATTRIBUTE
          && m.getInstructorElements().get(0).getElement() == instructorDriverClassAttributeName) {
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorDriverClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.MISSING_ATTRIBUTE && m.getInstructorElements().get(0)
          .getElement() == instructorBusClassAttributeNumberPlate) {
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorBusClassAttributeNumberPlate);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.MISSING_ATTRIBUTE && m.getInstructorElements().get(0)
          .getElement() == instructorPassengerClassAttributeName) {
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorPassengerClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.MISSING_ATTRIBUTE
          && m.getInstructorElements().get(0).getElement() == instructorBusClassAttributeCapacity) {
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorBusClassAttributeCapacity);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.MISSING_ASSOCIATION
          && m.getInstructorElements().get(0).getElement() == instructorDriverBusAssociation) {
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverBusAssociation);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.MISSING_ASSOCIATION
          && m.getInstructorElements().get(0).getElement() == instructorBusPassengerAssociation) {
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorBusPassengerAssociation);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
    }
  }

  /**
   * Similar to "checkCorrectTestWithSolution2_withAttributes()"
   */
  @Test
  public void checkCorrectTestWithSolution2_withAttributes_Compare() {

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-a.domain_model.cdm";
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
    Attribute studentPassengerClassAttributeName =
        getAttributeFromClass("name", studentPassengerClass);

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 3);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassengerClass), studentPassengerClass);

    assertEquals(comparison.notMappedInstructorAttribute.size(), 2);
    assertEquals(comparison.extraStudentAttribute.size(), 0);
    assertEquals(comparison.duplicateStudentAttribute.size(), 0);
    assertEquals(comparison.mappedAttribute.size(), 2);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeCapacity),
        studentBusClassAttributeCapacity);
    assertEquals(comparison.mappedAttribute.get(instructorPassengerClassAttributeName),
        studentPassengerClassAttributeName);
    assertTrue(
        comparison.notMappedInstructorAttribute.contains(instructorDriverClassAttributeName));
    assertTrue(
        comparison.notMappedInstructorAttribute.contains(instructorBusClassAttributeNumberPlate));
    assertEquals(comparison.newMistakes.size(), 2);
    assertEquals(solution1.getMistakes().size(), 2);
    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.MISSING_ATTRIBUTE
          && m.getInstructorElements().get(0).getElement() == instructorDriverClassAttributeName) {
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorDriverClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.MISSING_ATTRIBUTE && m.getInstructorElements().get(0)
          .getElement() == instructorBusClassAttributeNumberPlate) {
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorBusClassAttributeNumberPlate);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertFalse(m.isResolved());
      }
    }
  }

  /**
   * Test to detect 1 extra class and map other 3
   */
  @Test
  public void checkCorrectTestWithSolution4_withAttributes_Compare() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-c.domain_model.cdm";
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
    Classifier studentCustomerClass = getClassFromClassDiagram("Customer", classDiagram1);

    Attribute studentBusClassAttributeCapacity = getAttributeFromClass("capacity", studentBusClass);
    Attribute studentBusClassAttributeNumberPlate =
        getAttributeFromClass("numberPlate", studentBusClass);
    Attribute studentDriverClassAttributeName = getAttributeFromClass("name", studentDriverClass);
    Attribute studentPassengerClassAttributeName =
        getAttributeFromClass("name", studentPassengerClass);
    Attribute studentCustomerClassAttributeName =
        getAttributeFromClass("name", studentCustomerClass);

    Association studentBusCustomerAssociation =
        getAssociationFromClassDiagram(studentBusClass, studentCustomerClass, classDiagram1);

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 1);
    assertEquals(comparison.mappedClassifier.size(), 3);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassengerClass), studentPassengerClass);
    assertTrue(comparison.extraStudentClassifier.contains(studentCustomerClass));
    assertEquals(comparison.notMappedInstructorAttribute.size(), 0);
    assertEquals(comparison.extraStudentAttribute.size(), 1);
    assertEquals(comparison.duplicateStudentAttribute.size(), 0);
    assertEquals(comparison.mappedAttribute.size(), 4);

    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeCapacity),
        studentBusClassAttributeCapacity);
    assertEquals(comparison.mappedAttribute.get(instructorPassengerClassAttributeName),
        studentPassengerClassAttributeName);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeNumberPlate),
        studentBusClassAttributeNumberPlate);
    assertEquals(comparison.mappedAttribute.get(instructorDriverClassAttributeName),
        studentDriverClassAttributeName);
    assertTrue(comparison.extraStudentAttribute.contains(studentCustomerClassAttributeName));

    assertEquals(comparison.newMistakes.size(), 3);
    assertEquals(solution1.getMistakes().size(), 3);

    assertEquals(comparison.notMappedInstructorAssociation.size(), 0);
    assertEquals(comparison.extraStudentAssociation.size(), 1);
    assertEquals(comparison.mappedAssociation.size(), 2);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.EXTRA_CLASS
          && m.getStudentElements().get(0).getElement() == studentCustomerClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentCustomerClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.OTHER_EXTRA_ATTRIBUTE
          && m.getStudentElements().get(0).getElement() == studentCustomerClassAttributeName) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentCustomerClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.OTHER_EXTRA_ASSOCIATION
          && m.getStudentElements().get(0).getElement() == studentBusCustomerAssociation) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusCustomerAssociation);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
    }
  }

  /**
   * Test to check mapping for Passenger = Customer
   */
  @Test
  public void checkCorrectTestWithSolution5_withAttributes_Compare() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-d.domain_model.cdm";
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
    Classifier studentCustomerClass = getClassFromClassDiagram("Customer", classDiagram1);

    Attribute studentBusClassAttributeCapacity = getAttributeFromClass("capacity", studentBusClass);
    Attribute studentBusClassAttributeNumberPlate =
        getAttributeFromClass("numberPlate", studentBusClass);
    Attribute studentDriverClassAttributeName = getAttributeFromClass("name", studentDriverClass);
    Attribute studentCustomerClassAttributeName =
        getAttributeFromClass("name", studentCustomerClass);

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 3);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassengerClass), studentCustomerClass);

    assertEquals(comparison.notMappedInstructorAttribute.size(), 0);
    assertEquals(comparison.extraStudentAttribute.size(), 0);
    assertEquals(comparison.duplicateStudentAttribute.size(), 0);
    assertEquals(comparison.mappedAttribute.size(), 4);

    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeCapacity),
        studentBusClassAttributeCapacity);
    assertEquals(comparison.mappedAttribute.get(instructorPassengerClassAttributeName),
        studentCustomerClassAttributeName);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeNumberPlate),
        studentBusClassAttributeNumberPlate);
    assertEquals(comparison.mappedAttribute.get(instructorDriverClassAttributeName),
        studentDriverClassAttributeName);
    assertEquals(comparison.newMistakes.size(), 1); // 1 Incorrect Role Name
    assertEquals(solution1.getMistakes().size(), 1);
  }

  /**
   * Test to check mapping for Bus = Vehicle , Passenger = Customer, Driver = Pilot
   */
  @Test
  public void checkCorrectTestWithSolution6_withAttributes_Compare() {

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-e.domain_model.cdm";
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

    Classifier studentVehicleClass = getClassFromClassDiagram("Vehicle", classDiagram1);
    Classifier studentPilotClass = getClassFromClassDiagram("Pilot", classDiagram1);
    Classifier studentCustomerClass = getClassFromClassDiagram("Customer", classDiagram1);

    Attribute studentVehicleClassAttributeCapacity =
        getAttributeFromClass("capacity", studentVehicleClass);
    Attribute studentVehicleClassAttributeNumberPlate =
        getAttributeFromClass("numberPlate", studentVehicleClass);
    Attribute studentPilotClassAttributeName = getAttributeFromClass("name", studentPilotClass);
    Attribute studentCustomerClassAttributeName =
        getAttributeFromClass("name", studentCustomerClass);

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 3);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentVehicleClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentPilotClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassengerClass), studentCustomerClass);

    assertEquals(comparison.notMappedInstructorAttribute.size(), 0);
    assertEquals(comparison.extraStudentAttribute.size(), 0);
    assertEquals(comparison.duplicateStudentAttribute.size(), 0);
    assertEquals(comparison.mappedAttribute.size(), 4);

    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeCapacity),
        studentVehicleClassAttributeCapacity);
    assertEquals(comparison.mappedAttribute.get(instructorPassengerClassAttributeName),
        studentCustomerClassAttributeName);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeNumberPlate),
        studentVehicleClassAttributeNumberPlate);
    assertEquals(comparison.mappedAttribute.get(instructorDriverClassAttributeName),
        studentPilotClassAttributeName);

    assertEquals(comparison.newMistakes.size(), 1); // 1 Incorrect Role name
    assertEquals(solution1.getMistakes().size(), 1);
  }

  /**
   * Test to check if both solutions are same then mapping should establish properly using
   * .compare()
   */
  @Test
  public void checkCorrectTestWithSolution1_withAttributes_Compare() {

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile1 =
        "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute).domain_model.cdm";
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
    assertEquals(solution1.getMistakes().size(), 0);
  }
}
