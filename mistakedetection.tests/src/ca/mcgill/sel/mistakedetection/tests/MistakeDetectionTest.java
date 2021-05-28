package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import classdiagram.Attribute;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.mistaketypes.MistakeTypes;
import modelingassistant.util.ResourceHelper;

public class MistakeDetectionTest {

  /**
   * Tests for checking Software Engineering terms, eg, CarData.
   */
  @Test public void testCheckingSoftwareEngineeringTerm() {
    List.of("Car", "Driver", "Part").forEach(s -> assertFalse(MistakeDetection.isSoftwareEngineeringTerm(s)));
    List.of("CarData", "DriverRecord", "PartInfo").forEach(s ->
        assertTrue(MistakeDetection.isSoftwareEngineeringTerm(s)));
  }

  /**
   * Tests for checking Plural in Class Name, eg Cars.
   */
  @Test public void testIsPlural() {
    List.of("Car", "Driver").forEach(s -> assertFalse(MistakeDetection.isPlural(s)));
    List.of("Cars","People","Men").forEach(s -> assertTrue(MistakeDetection.isPlural(s)));
    List.of("Car", "Driver").forEach(s -> assertFalse(MistakeDetection.isPlural(s)));
    List.of("Cars","People","Men").forEach(s -> assertTrue(MistakeDetection.isPlural(s)));
  }

  /**
   * Tests for checking Spelling Mistake in Class Name, eg Cars.
   */
  @Test public void testIsSpelledWrong() {
    String class1 = "Car";
    String class2 = "Car";
    assertEquals(0, MistakeDetection.levenshteinDistance(class1, class2));
    class2 = "Cer";
    assertEquals(1, MistakeDetection.levenshteinDistance(class1, class2));
  }

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
   * Test to check for plural class names in student solution
   */
  @Test public void testStudentSolution_1_PluralClassName() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution-a.domain_model.cdm";
    // Contains Class Buses and Drivers
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);

    for (var c : classDiagram.getClasses()) {
      assertTrue(MistakeDetection.isPlural(c.getName()));
    }

    ClassdiagramPackage.eINSTANCE.eClass();
    cdmFile = "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
    // Contains Class Buses and Driver
    resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    classDiagram = (ClassDiagram) resource.getContents().get(0);

    for (var c : classDiagram.getClasses()) {
      assertFalse(MistakeDetection.isPlural(c.getName()));
    }
  }

  /**
   * Test to check if isLowerName working correctly.
   */
  @Test public void testCheckLowerCase() {
    assertTrue(MistakeDetection.isLowerName("class1"));
    assertFalse(MistakeDetection.isLowerName("Class1"));
  }

  /**
   * Test to check mapping function(checkCorrect) that will be called with .compare. For testing checkCorrectTest is created and called.
   * It has same functionality as checkCorrect. This test check for mapping b/w Bus = Bus and Driver != Bus.
   */
  @Test public void checkCorrectTest() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
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
    assertFalse(MistakeDetection.checkCorrectTest(studentBusClass,studentDriverClass ));
  }

  /**
   * Test for checking mapping between instructor classifier(Bus, Driver) and Student classifier(Bus, Driver)
   */
  @Test public void checkCorrectTestWithSolution1() {
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

    var mistakes = MistakeDetection.compare(solution, solution1);
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 2);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(mistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);
  }

  /**
   * Test for checking mapping between instructor classifier(Bus, Driver) and Student classifier(Buses, Drivers)
   */
  @Test public void checkCorrectTestWithSolution2() {
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
    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution-a.domain_model.cdm";
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

    var mistakes = MistakeDetection.compare(solution,solution1);
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 2);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusesClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriversClass);

    assertEquals(mistakes.size(), 4);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
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

  /**
   * Test for checking mapping between instructor classifier(Bus, Driver) and Student classifier(Buses, Drivr)
   */
  @Test public void checkCorrectTestWithSolution3() {
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
    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution-b.domain_model.cdm";
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
    Classifier studentDrivrClass = null;

    for (var c : classDiagram1.getClasses()) {
      if ("Bus".equals(c.getName()))
        studentBusClass = c;
      else if ("Drivr".equals(c.getName()))
        studentDrivrClass = c;
    }

    assertTrue(MistakeDetection.checkCorrectTest(instructorBusClass, studentBusClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorDriverClass, studentDrivrClass));

    var mistakes = MistakeDetection.compare(solution,solution1);
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 2);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDrivrClass);
    assertEquals(mistakes.size(), 1);
    assertEquals(solution1.getMistakes().size(), 1);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentDrivrClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDrivrClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
    }
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
   * Test to check for mapped classifiers(Passanger,Bus,Driver) and attributes(name,capacity,name,numberPlate)
   */
  @Test public void checkCorrectTestWithSolution1_withAttributes() {
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
    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute).domain_model.cdm";
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

    var mistakes = MistakeDetection.compare(solution,solution1);

    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 3);

    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorPassangerClass),studentPassangerClass);

    assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
    assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.duplicateStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.mappedAttribute.size(), 4);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeCapacity),studentBusClassAttributeCapacity);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeNumberPlate),
        studentBusClassAttributeNumberPlate);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorDriverClassAttributeName),
        studentDriverClassAttributeName);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorPassengerClassAttributeName),
        studentPassengerClassAttributeName);
    assertEquals(mistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);
  }

  /**
   * Test to check classifier and attribute mapping (2 Attributes unmapped, all classes mapped)
   */
  @Test public void checkCorrectTestWithSolution2_withAttributes() {
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
    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-a.domain_model.cdm";
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

    var mistakes = MistakeDetection.compare(solution,solution1);

    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 3);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorPassangerClass),studentPassangerClass);

    assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 2);
    assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.duplicateStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.mappedAttribute.size(), 2);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeCapacity),studentBusClassAttributeCapacity);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorPassengerClassAttributeName),studentPassengerClassAttributeName);
    assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(instructorDriverClassAttributeName));
    assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(instructorBusClassAttributeNumberPlate));
    assertEquals(mistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);
  }

  /**
   * Test to check for mapped classifier and attributes (2 classifiers and 4 attributes unmapped)
   */
  @Test public void checkCorrectTestWithSolution3_withAttributes_compare() {
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
    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-b.domain_model.cdm";
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

    var mistakes = MistakeDetection.compare(solution,solution1);

    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 2);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 1);

    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertTrue(MistakeDetection.notMappedInstructorClassifier.contains(instructorPassangerClass));
    assertTrue(MistakeDetection.notMappedInstructorClassifier.contains(instructorBusClass));

    assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 4);
    assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.duplicateStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.mappedAttribute.size(), 0);

    assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(instructorDriverClassAttributeName));
    assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(instructorBusClassAttributeNumberPlate));
    assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(instructorPassengerClassAttributeName));
    assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(instructorBusClassAttributeCapacity));
    assertEquals(mistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);
  }

  /**
   * Similar to "checkCorrectTestWithSolution2_withAttributes()"
   */
  @Test public void checkCorrectTestWithSolution2_withAttributes_Compare() {

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
    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-a.domain_model.cdm";
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

    var mistakes = MistakeDetection.compare(solution,solution1);

    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 3);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorPassangerClass),studentPassangerClass);

    assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 2);
    assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.duplicateStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.mappedAttribute.size(), 2);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeCapacity),studentBusClassAttributeCapacity);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorPassengerClassAttributeName),studentPassengerClassAttributeName);
    assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(instructorDriverClassAttributeName));
    assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(instructorBusClassAttributeNumberPlate));
    assertEquals(mistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);
  }

  /**
   * Test to detect 1 extra class and map other 3
   */
  @Test public void checkCorrectTestWithSolution4_withAttributes_Compare() {
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
    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-c.domain_model.cdm";
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
    Attribute studentCustomerClassAttributeName=null;

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
      else if ("Customer".equals(c.getName())) {
        studentCustomerClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            studentCustomerClassAttributeName = a;
          }
        }
      }
    }

    var mistakes = MistakeDetection.compare(solution,solution1);

    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 1);
    assertEquals(MistakeDetection.mappedClassifier.size(), 3);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorPassangerClass),studentPassangerClass);
    assertTrue(MistakeDetection.extraStudentClassifier.contains(studentCustomerClass));
    assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
    assertEquals(MistakeDetection.extraStudentAttribute.size(), 1);
    assertEquals(MistakeDetection.duplicateStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.mappedAttribute.size(), 4);

    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeCapacity),studentBusClassAttributeCapacity);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorPassengerClassAttributeName),studentPassengerClassAttributeName);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeNumberPlate),studentBusClassAttributeNumberPlate);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorDriverClassAttributeName),studentDriverClassAttributeName);
    assertTrue(MistakeDetection.extraStudentAttribute.contains(studentCustomerClassAttributeName));
    assertEquals(mistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);
  }

  /**
   * Test to check mapping for Passenger = Customer
   */
  @Test public void checkCorrectTestWithSolution5_withAttributes_Compare() {
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
    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-d.domain_model.cdm";
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
    Attribute studentCustomerClassAttributeName=null;

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
      }
      else if ("Customer".equals(c.getName())) {
        studentCustomerClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            studentCustomerClassAttributeName = a;
          }
        }
      }
    }

    var mistakes = MistakeDetection.compare(solution,solution1);

    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 3);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorPassangerClass),studentCustomerClass);

    assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
    assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.duplicateStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.mappedAttribute.size(), 4);

    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeCapacity),studentBusClassAttributeCapacity);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorPassengerClassAttributeName),studentCustomerClassAttributeName);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeNumberPlate),studentBusClassAttributeNumberPlate);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorDriverClassAttributeName),studentDriverClassAttributeName);
    assertEquals(mistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);
  }

  /**
   * Test to check mapping for Bus = Vehicle , Passenger = Customer,  Driver = Pilot
   */
  @Test public void checkCorrectTestWithSolution6_withAttributes_Compare() {

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
    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-e.domain_model.cdm";
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
    Attribute studentCustomerClassAttributeName=null;

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
      }
      else if ("Customer".equals(c.getName())) {
        studentCustomerClass = c;
        for (Attribute a : c.getAttributes()) {
          if ("name".equals(a.getName())) {
            studentCustomerClassAttributeName = a;
          }
        }
      }
    }

    var mistakes = MistakeDetection.compare(solution,solution1);

    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 3);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentVehicleClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentPilotClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorPassangerClass),studentCustomerClass);

    assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
    assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.duplicateStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.mappedAttribute.size(), 4);

    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeCapacity),studentVehicleClassAttributeCapacity);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorPassengerClassAttributeName),studentCustomerClassAttributeName);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeNumberPlate),studentVehicleClassAttributeNumberPlate);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorDriverClassAttributeName),studentPilotClassAttributeName);
    assertEquals(mistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);
  }

  /**
   * Test to check if both solutions are same then mapping should establish properly using .compare()
   */
  @Test public void checkCorrectTestWithSolution1_withAttributes_Compare() {

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
    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute).domain_model.cdm";
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

    MistakeDetection.compare(solution,solution1);

    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 3);

    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorPassangerClass),studentPassangerClass);

    assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
    assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.duplicateStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.mappedAttribute.size(), 4);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeCapacity),studentBusClassAttributeCapacity);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeNumberPlate),studentBusClassAttributeNumberPlate);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorDriverClassAttributeName),studentDriverClassAttributeName);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorPassengerClassAttributeName),studentPassengerClassAttributeName);
    assertEquals(solution1.getMistakes().size(), 0);
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

    var mistakes = MistakeDetection.compare(solution, solution1);
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 2);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(mistakes.size(), 0);
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

    mistakes = MistakeDetection.compare(solution,solution1);
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 2);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusesClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriversClass);
    assertEquals(mistakes.size(), 4);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
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

    // Running the second Solution again to check updated attribute values in Mistake in Metamodel
    assertEquals(solution1.getMistakes().size(), 4);

    mistakes = MistakeDetection.compare(solution,solution1);
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 2);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusesClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriversClass);

    assertEquals(mistakes.size(), 0); // Removed in updateMistake() function
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
    }

    mistakes = MistakeDetection.compare(solution,solution1);
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 2);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusesClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriversClass);

    assertEquals(mistakes.size(), 0); // Removed in updateMistake() function
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 3);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 3);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 3);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
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

    mistakes = MistakeDetection.compare(solution, solution1);
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 2);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(mistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getNumDetectionSinceResolved(), 1);
        assertEquals(m.getNumDetection(), 3);
        assertTrue(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.USING_PLURAL_OR_LOWERCASE
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
        assertEquals(m.getNumDetectionSinceResolved(), 1);
        assertEquals(m.getNumDetection(), 3);
        assertTrue(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentBusesClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusesClass);
        assertEquals(m.getNumDetectionSinceResolved(), 1);
        assertEquals(m.getNumDetection(), 3);
        assertTrue(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentDriversClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriversClass);
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

    var mistakes = MistakeDetection.compare(solution,solution1);

    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 3);

    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorPassangerClass),studentPassangerClass);

    assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
    assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.duplicateStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.mappedAttribute.size(), 4);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeCapacity),studentBusClassAttributeCapacty);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeNumberPlate),studentBusClassAttributeNamberPlate);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorDriverClassAttributeName),studentDriverClassAttributeNme);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorPassengerClassAttributeName),studentPassengerClassAttributeNam);
    assertEquals(mistakes.size(), 4);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_NAME
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeCapacty) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusClassAttributeCapacty);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_NAME
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeNamberPlate) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusClassAttributeNamberPlate);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_NAME
          && m.getStudentElements().get(0).getElement() == studentDriverClassAttributeNme) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriverClassAttributeNme);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_NAME
          && m.getStudentElements().get(0).getElement() == studentPassengerClassAttributeNam) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentPassengerClassAttributeNam);
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

    var mistakes = MistakeDetection.compare(solution,solution1);

    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 3);

    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass),studentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass),studentDriverClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorPassangerClass),studentPassangerClass);

    assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
    assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.duplicateStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.mappedAttribute.size(), 4);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeCapacity),studentBusClassAttributeCapacity);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeNumberPlate),studentBusClassAttributeNumberPlate);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorDriverClassAttributeName),studentDriverClassAttributeName);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorPassengerClassAttributeName),studentPassengerClassAttributeName);

    assertEquals(mistakes.size(), 4);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeCapacity) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusClassAttributeCapacity);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeNumberPlate) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusClassAttributeNumberPlate);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentDriverClassAttributeName) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriverClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());

      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentPassengerClassAttributeName) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentPassengerClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
    }

    // ---------Second iteration to test update of mistake Properties---
    mistakes = MistakeDetection.compare(solution, solution1);

    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 3);

    assertEquals(MistakeDetection.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorDriverClass), studentDriverClass);
    assertEquals(MistakeDetection.mappedClassifier.get(instructorPassangerClass), studentPassangerClass);

    assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
    assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.duplicateStudentAttribute.size(), 0);
    assertEquals(MistakeDetection.mappedAttribute.size(), 4);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeCapacity),
        studentBusClassAttributeCapacity);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorBusClassAttributeNumberPlate),
        studentBusClassAttributeNumberPlate);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorDriverClassAttributeName),
        studentDriverClassAttributeName);
    assertEquals(MistakeDetection.mappedAttribute.get(instructorPassengerClassAttributeName),
        studentPassengerClassAttributeName);

    assertEquals(mistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 4);

    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeCapacity) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusClassAttributeCapacity);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentBusClassAttributeNumberPlate) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentBusClassAttributeNumberPlate);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentDriverClassAttributeName) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDriverClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.WRONG_ATTRIBUTE_TYPE
          && m.getStudentElements().get(0).getElement() == studentPassengerClassAttributeName) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentPassengerClassAttributeName);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 2);
        assertFalse(m.isResolved());
      }
    }
  }

  /**
   * Function to print the mapped, unmapped classifier or attributes.
   */
  public void log() {
    System.out.println();
    System.out.println("----Test Logger-----");
    System.out.print("Not Mapped InstructorClassifier List : ");
    for (Classifier c : MistakeDetection.notMappedInstructorClassifier) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Not Mapped extraStudentClassifier : ");
    for (Classifier c : MistakeDetection.extraStudentClassifier) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.println("Mapped Classifiers : ");
    MistakeDetection.mappedClassifier
        .forEach((key, value) -> System.out.println(key.getName() + " = " + value.getName()));
    System.out.println();
    System.out.print("Not Mapped InstructorAttribute List : ");
    for (Attribute c : MistakeDetection.notMappedInstructorAttribute) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Not Mapped extraStudentAttribute : ");
    for (Attribute c : MistakeDetection.extraStudentAttribute) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("duplicate Attribute : ");
    for (Attribute c : MistakeDetection.duplicateStudentAttribute) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.println("Mapped Attributes : ");
    MistakeDetection.mappedAttribute.forEach((key, value) -> System.out
        .println(key.getType() + " " + key.getName() + " = " + value.getType() + " " + value.getName()));
  }

  public void clearClassifier() {
    MistakeDetection.mappedClassifier.clear();
    MistakeDetection.extraStudentClassifier.clear();
    MistakeDetection.notMappedInstructorClassifier.clear();
  }

  public void clearAttributesAndClassifer() {
    MistakeDetection.mappedClassifier.clear();
    MistakeDetection.extraStudentClassifier.clear();
    MistakeDetection.notMappedInstructorClassifier.clear();
    MistakeDetection.mappedAttribute.clear();
    MistakeDetection.extraStudentAttribute.clear();
    MistakeDetection.notMappedInstructorAttribute.clear();
    MistakeDetection.duplicateStudentAttribute.clear();
  }

}
