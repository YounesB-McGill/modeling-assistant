package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.Comparison;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import classdiagram.Attribute;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import modelingassistant.Mistake;
import modelingassistant.MistakeType;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.mistaketypes.MistakeTypes;
import modelingassistant.util.ResourceHelper;

public class MistakeDetectionWrongAttributeTest {
  /**
   * Test to check for mapped classifiers(Passanger,Bus,Driver) and
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
    assertTrue(MistakeDetection.checkCorrectTest(instructorPassangerClass, studentPassangerClass));

    var comparison = MistakeDetection.compare(solution, solution1);

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
    Attribute studentPassengerClassAttributeName = null;

    for (var c : classDiagram1.getClasses()) {
      if ("Bus".equals(c.getName())) {
        studentBusClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("capacity".equals(a.getName())) {
            studentBusClassAttributeCapacity = a;
          }
        }
      } else if ("Driver".equals(c.getName())) {
        studentDriverClass = c;
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
    assertTrue(MistakeDetection.checkCorrectTest(instructorPassangerClass, studentPassangerClass));

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 3);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassangerClass), studentPassangerClass);

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
      if (m.getMistakeType() == MistakeTypes.MISSING_ATTRIBUTE
          && m.getInstructorElements().get(0).getElement() == instructorBusClassAttributeNumberPlate) {
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

    Classifier studentDriverClass = null;

    for (var c : classDiagram1.getClasses()) {
      if ("Driver".equals(c.getName()))
        studentDriverClass = c;
    }

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 2);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 1);

    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertTrue(comparison.notMappedInstructorClassifier.contains(instructorPassangerClass));
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
    assertEquals(comparison.newMistakes.size(), 6);
    assertEquals(solution1.getMistakes().size(), 6);
    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.MISSING_CLASS
          && m.getInstructorElements().get(0).getElement() == instructorPassangerClass) {
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorPassangerClass);
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
      if (m.getMistakeType() == MistakeTypes.MISSING_ATTRIBUTE
          && m.getInstructorElements().get(0).getElement() == instructorBusClassAttributeNumberPlate) {
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorBusClassAttributeNumberPlate);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.MISSING_ATTRIBUTE
          && m.getInstructorElements().get(0).getElement() == instructorPassengerClassAttributeName) {
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
    Attribute studentPassengerClassAttributeName = null;

    for (var c : classDiagram1.getClasses()) {
      if ("Bus".equals(c.getName())) {
        studentBusClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("capacity".equals(a.getName())) {
            studentBusClassAttributeCapacity = a;
          }
        }
      } else if ("Driver".equals(c.getName())) {
        studentDriverClass = c;
      } else if ("Passanger".equals(c.getName())) {
        studentPassangerClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            studentPassengerClassAttributeName = a;
          }
        }
      }
    }

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 3);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassangerClass), studentPassangerClass);

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
      if (m.getMistakeType() == MistakeTypes.MISSING_ATTRIBUTE
          && m.getInstructorElements().get(0).getElement() == instructorBusClassAttributeNumberPlate) {
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
    Classifier studentCustomerClass = null;

    Attribute studentBusClassAttributeCapacity = null;
    Attribute studentBusClassAttributeNumberPlate = null;
    Attribute studentDriverClassAttributeName = null;
    Attribute studentPassengerClassAttributeName = null;
    Attribute studentCustomerClassAttributeName = null;

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
      } else if ("Customer".equals(c.getName())) {
        studentCustomerClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            studentCustomerClassAttributeName = a;
          }
        }
      }
    }

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 1);
    assertEquals(comparison.mappedClassifier.size(), 3);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassangerClass), studentPassangerClass);
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
    assertEquals(comparison.newMistakes.size(), 2);
    assertEquals(solution1.getMistakes().size(), 2);

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
    Classifier studentCustomerClass = null;

    Attribute studentBusClassAttributeCapacity = null;
    Attribute studentBusClassAttributeNumberPlate = null;
    Attribute studentDriverClassAttributeName = null;
    Attribute studentCustomerClassAttributeName = null;

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
      } else if ("Customer".equals(c.getName())) {
        studentCustomerClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            studentCustomerClassAttributeName = a;
          }
        }
      }
    }

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 3);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassangerClass), studentCustomerClass);

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
    assertEquals(comparison.newMistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);
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

    Classifier studentVehicleClass = null;
    Classifier studentPilotClass = null;
    Classifier studentCustomerClass = null;

    Attribute studentVehicleClassAttributeCapacity = null;
    Attribute studentVehicleClassAttributeNumberPlate = null;
    Attribute studentPilotClassAttributeName = null;
    Attribute studentCustomerClassAttributeName = null;

    for (var c : classDiagram1.getClasses()) {
      if ("Vehicle".equals(c.getName())) {
        studentVehicleClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("capacity".equals(a.getName())) {
            studentVehicleClassAttributeCapacity = a;
          }
          if ("numberPlate".equals(a.getName())) {
            studentVehicleClassAttributeNumberPlate = a;
          }
        }
      } else if ("Pilot".equals(c.getName())) {
        studentPilotClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            studentPilotClassAttributeName = a;
          }
        }
      } else if ("Customer".equals(c.getName())) {
        studentCustomerClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            studentCustomerClassAttributeName = a;
          }
        }
      }
    }

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 3);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentVehicleClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentPilotClass);
    assertEquals(comparison.mappedClassifier.get(instructorPassangerClass), studentCustomerClass);

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
    assertEquals(comparison.newMistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);
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

    var comparison = MistakeDetection.compare(solution, solution1);

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
    assertEquals(solution1.getMistakes().size(), 0);
  }

  /**
   * Function to print the mapped, unmapped classifier or attributes.
   */
  public void log(Comparison comparison) {
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
    comparison.mappedAttribute.forEach((key, value) -> System.out.println(
        key.getType() + " " + key.getName() + " = " + value.getType() + " " + value.getName()));
  }

  private boolean mistakesContainMistakeType(List<Mistake> mistakes, MistakeType mistakeType) {
    return mistakes.stream().anyMatch(mistake -> mistake.getMistakeType().equals(mistakeType));
  }
}
