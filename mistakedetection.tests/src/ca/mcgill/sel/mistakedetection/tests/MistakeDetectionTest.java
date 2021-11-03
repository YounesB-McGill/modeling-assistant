package ca.mcgill.sel.mistakedetection.tests;

import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import static modelingassistant.util.ClassDiagramUtils.getAttributeFromClass;
import static modelingassistant.util.ClassDiagramUtils.getAttributeFromDiagram;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.emf.common.util.ECollections;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.CDEnum;
import ca.mcgill.sel.classdiagram.CDEnumLiteral;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.classdiagram.NamedElement;
import ca.mcgill.sel.mistakedetection.Comparison;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import learningcorpus.MistakeType;
import modelingassistant.Mistake;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.Solution;
import modelingassistant.SolutionElement;

public class MistakeDetectionTest {

  /** The ModelingassistantFactory instance. */
  private static final ModelingassistantFactory maf = ModelingassistantFactory.eINSTANCE;

  /**
   * Test to check if all the classes exist in Instructor solution are loaded in cdmFile.
   */
  @Test
  public void testLoadingInstructorSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/One/Class Diagram/InstructorSolution.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    Classifier busClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    Classifier driverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

    assertTrue(instructorSolution.getClassDiagram().getClasses().containsAll(List.of(busClass, driverClass)));

  }

  /**
   * Test to check if all the classes exist in Student solution are loaded in cdmFile
   */
  @Test
  public void testLoadingStudentSolution() {
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier busClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    Classifier driverClass = getClassFromClassDiagram("Driver", studentClassDiagram);

    List.of(busClass, driverClass).forEach(c -> assertTrue(studentSolution.getClassDiagram().getClasses().contains(c)));
  }

  /**
   * Test to check if cdm file with attributes is loaded correctly.
   */
  @Test
  public void testLoadingSolutionWithAttributes() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/Class Diagram/Two(withAttributes).domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    Classifier busClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    Classifier driverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);
    Classifier passangerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);

    List.of(busClass, driverClass, passangerClass)
        .forEach(c -> assertTrue(instructorSolution.getClassDiagram().getClasses().contains(c)));
  }

  /**
   * Test to check Mistakes in Metamodel
   */
  @Test
  public void testUpdateInMistakeAttributes() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/One/Class Diagram/InstructorSolution.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var modelingAssistant = maf.createModelingAssistant();
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(modelingAssistant, studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 1);// Incomplete Containment tree
    assertEquals(studentSolution.getMistakes().size(), 1);

    // Loading 2nd Solution to check Mistakes Update in Metamodel
    studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution-a.domain_model.cdm");
    studentSolution = studentSolutionFromClassDiagram(modelingAssistant, studentClassDiagram);

    comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 5); // 2 Plural Class names + 2 Bad Role Name Spelling + Incomplete
                                                    // Containment tree
    assertEquals(studentSolution.getMistakes().size(), 5);

    // Running the second Solution again to check updated attribute values in Mistake in Metamodel
    assertEquals(studentSolution.getMistakes().size(), 5);
    comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(comparison.newMistakes.size(), 5);
    assertEquals(studentSolution.getMistakes().size(), 5);

    comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 5);
    assertEquals(studentSolution.getMistakes().size(), 5);

    // checking with perfect solution
    studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution.domain_model.cdm");
    studentSolution = studentSolutionFromClassDiagram(modelingAssistant, studentClassDiagram);

    comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 1); // Incomplete Containment tree
    // assertEquals(studentSolution.getMistakes().size(), 4); // TODO Discuss in meeting
    // next meeting

  }

  /**
   * Test to check for attributes(name,capacity,name,numberPlate) for Wrong Attribute Types
   */
  @Test
  public void testMultiAttributeWrongTypes() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/Class Diagram/Two(withAttributes).domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/four(WrongAttibuteType)/Class Diagram/Four(WrongAttibuteType).domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    Classifier instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);
    Classifier instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);

    Attribute instructorBusClassAttributeCapacity = getAttributeFromClass("capacity", instructorBusClass);
    Attribute instructorBusClassAttributeNumberPlate = getAttributeFromClass("numberPlate", instructorBusClass);
    Attribute instructorDriverClassAttributeName = getAttributeFromClass("name", instructorDriverClass);
    Attribute instructorPassengerClassAttributeName = getAttributeFromClass("name", instructorPassengerClass);

    Classifier studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    Classifier studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);
    Classifier studentPassengerClass = getClassFromClassDiagram("Passenger", studentClassDiagram);

    Attribute studentBusClassAttributeCapacity = getAttributeFromClass("capacity", studentBusClass);
    Attribute studentBusClassAttributeNumberPlate = getAttributeFromClass("numberPlate", studentBusClass);
    Attribute studentDriverClassAttributeName = getAttributeFromClass("name", studentDriverClass);
    Attribute studentPassengerClassAttributeName = getAttributeFromClass("name", studentPassengerClass);

    assertTrue(MistakeDetection.checkCorrectTest(instructorBusClass, studentBusClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorDriverClass, studentDriverClass));
    assertTrue(MistakeDetection.checkCorrectTest(instructorPassengerClass, studentPassengerClass));

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 5);// Incomplete Containment tree
    assertEquals(studentSolution.getMistakes().size(), 5);

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, WRONG_ATTRIBUTE_TYPE, studentBusClassAttributeCapacity,
          instructorBusClassAttributeCapacity, 0, 1, false);
      assertMistakeConditional(m, WRONG_ATTRIBUTE_TYPE, studentBusClassAttributeNumberPlate,
          instructorBusClassAttributeNumberPlate, 0, 1, false);
      assertMistakeConditional(m, WRONG_ATTRIBUTE_TYPE, studentDriverClassAttributeName,
          instructorDriverClassAttributeName, 0, 1, false);
      assertMistakeConditional(m, WRONG_ATTRIBUTE_TYPE, studentPassengerClassAttributeName,
          instructorPassengerClassAttributeName, 0, 1, false);
    }

    // ---------Second iteration to test update of mistake Properties---
    comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 5);
    assertEquals(studentSolution.getMistakes().size(), 5);

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, WRONG_ATTRIBUTE_TYPE, studentBusClassAttributeCapacity,
          instructorBusClassAttributeCapacity, 0, 2, false);
      assertMistakeConditional(m, WRONG_ATTRIBUTE_TYPE, studentBusClassAttributeNumberPlate,
          instructorBusClassAttributeNumberPlate, 0, 2, false);
      assertMistakeConditional(m, WRONG_ATTRIBUTE_TYPE, studentDriverClassAttributeName,
          instructorDriverClassAttributeName, 0, 2, false);
      assertMistakeConditional(m, WRONG_ATTRIBUTE_TYPE, studentPassengerClassAttributeName,
          instructorPassengerClassAttributeName, 0, 2, false);
    }
  }

  /**
   * Test to check mapping for Passenger = Customer
   */
  @Test
  public void testCheckMappingWithDiffName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/Class Diagram/Two(withAttributes).domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/two(withAttribute)/Class Diagram/Two(withAttribute)-d.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    Classifier instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);
    Classifier instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);

    Attribute instructorBusClassAttributeCapacity = getAttributeFromClass("capacity", instructorBusClass);
    Attribute instructorBusClassAttributeNumberPlate = getAttributeFromClass("numberPlate", instructorBusClass);
    Attribute instructorDriverClassAttributeName = getAttributeFromClass("name", instructorDriverClass);
    Attribute instructorPassengerClassAttributeName = getAttributeFromClass("name", instructorPassengerClass);

    Classifier studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    Classifier studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);
    Classifier studentCustomerClass = getClassFromClassDiagram("Customer", studentClassDiagram);

    Attribute studentBusClassAttributeCapacity = getAttributeFromClass("capacity", studentBusClass);
    Attribute studentBusClassAttributeNumberPlate = getAttributeFromClass("numberPlate", studentBusClass);
    Attribute studentDriverClassAttributeName = getAttributeFromClass("name", studentDriverClass);
    Attribute studentCustomerClassAttributeName = getAttributeFromClass("name", studentCustomerClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

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

    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeCapacity), studentBusClassAttributeCapacity);
    assertEquals(comparison.mappedAttribute.get(instructorPassengerClassAttributeName),
        studentCustomerClassAttributeName);
    assertEquals(comparison.mappedAttribute.get(instructorBusClassAttributeNumberPlate),
        studentBusClassAttributeNumberPlate);
    assertEquals(comparison.mappedAttribute.get(instructorDriverClassAttributeName), studentDriverClassAttributeName);
    assertEquals(comparison.newMistakes.size(), 2); // Incomplete Containment tree + Wrong Class name
    assertEquals(studentSolution.getMistakes().size(), 2);
  }

  /**
   * Test to check mapping for Bus = Vehicle, Passenger = Customer, Driver = Pilot.
   */
  @Test
  public void testCheckMappingWithMultiDiffNames() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/Class Diagram/Two(withAttributes).domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/two(withAttribute)/Class Diagram/Two(withAttribute)-e.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    Classifier instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);
    Classifier instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);

    Attribute instructorBusClassAttributeCapacity = getAttributeFromClass("capacity", instructorBusClass);
    Attribute instructorBusClassAttributeNumberPlate = getAttributeFromClass("numberPlate", instructorBusClass);
    Attribute instructorDriverClassAttributeName = getAttributeFromClass("name", instructorDriverClass);
    Attribute instructorPassengerClassAttributeName = getAttributeFromClass("name", instructorPassengerClass);

    Classifier studentVehicleClass = getClassFromClassDiagram("Vehicle", studentClassDiagram);
    Classifier studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);
    Classifier studentCustomerClass = getClassFromClassDiagram("Customer", studentClassDiagram);

    Attribute studentVehicleClassAttributeCapacity = getAttributeFromClass("capacity", studentVehicleClass);
    Attribute studentVehicleClassAttributeNumberPlate = getAttributeFromClass("numberPlate", studentVehicleClass);
    Attribute studentPilotClassAttributeName = getAttributeFromClass("name", studentPilotClass);
    Attribute studentCustomerClassAttributeName = getAttributeFromClass("name", studentCustomerClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

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
    assertEquals(comparison.mappedAttribute.get(instructorDriverClassAttributeName), studentPilotClassAttributeName);

    assertEquals(comparison.newMistakes.size(), 4); // 3 + Incomplete Containment tree
    assertEquals(studentSolution.getMistakes().size(), 4);
  }

  public static boolean mistakesContainMistakeType(List<Mistake> mistakes, MistakeType mistakeType) {
    return mistakes.stream().anyMatch(mistake -> mistake.getMistakeType().equals(mistakeType));
  }

  public static Solution instructorSolutionFromClassDiagram(ClassDiagram classDiagram) {
    var modelingAssistant = maf.createModelingAssistant();
    var instructorSolution = maf.createSolution();
    instructorSolution.setModelingAssistant(modelingAssistant);
    instructorSolution.setClassDiagram(classDiagram);
    return instructorSolution;
  }

  public static Solution studentSolutionFromClassDiagram(ClassDiagram classDiagram) {
    var modelingAssistant = maf.createModelingAssistant();
    var studentSolution = maf.createSolution();
    studentSolution.setModelingAssistant(modelingAssistant);
    studentSolution.setClassDiagram(classDiagram);
    var student = maf.createStudent();
    studentSolution.setStudent(student);
    return studentSolution;
  }

  public static Solution studentSolutionFromClassDiagram(ModelingAssistant ma, ClassDiagram classDiagram) {
    var studentSolution = maf.createSolution();
    studentSolution.setModelingAssistant(ma);
    studentSolution.setClassDiagram(classDiagram);
    var student = maf.createStudent();
    studentSolution.setStudent(student);
    return studentSolution;
  }

  /**
   * Asserts a mistake's links with single student or instructor element.
   *
   * @param mistake
   * @param mistakeType
   * @param element
   */
  public static void assertMistakeLinks(Mistake mistake, MistakeType mistakeType, NamedElement element) {
    assertEquals(mistake.getMistakeType(), mistakeType);
    if (mistake.getStudentElements().isEmpty()) {
      assertEquals(mistake.getInstructorElements().get(0).getElement(), element);
    }
    if (mistake.getInstructorElements().isEmpty()) {
      assertEquals(mistake.getStudentElements().get(0).getElement(), element);
    }
  }

  /**
   * Asserts a mistake's links with multiple student or instructor element.
   *
   * @param mistake
   * @param mistakeType
   * @param elements
   */
  public static void assertMistakeLinks(Mistake mistake, MistakeType mistakeType, List<NamedElement> elements) {
    assertEquals(mistake.getMistakeType(), mistakeType);
    if (mistake.getStudentElements().isEmpty()) {
      assertTrue(mistakeElemsContainGivenElems(mistake.getInstructorElements(), elements));
    }
    if (mistake.getInstructorElements().isEmpty()) {
      assertTrue(mistakeElemsContainGivenElems(mistake.getStudentElements(), elements));
    }
  }


  /**
   * Asserts a mistake's links with student and instructor element(s).
   *
   * @param mistake
   * @param mistakeType
   * @param studentElem_s a NamedElement or a List of NamedElements
   * @param instructorElem_s a NamedElement or a List of NamedElements
   */
  @SuppressWarnings("unchecked") // need to do this to get around lack of union types in Java
  public static void assertMistakeLinks(Mistake mistake, MistakeType mistakeType, Object studentElem_s,
      Object instructorElem_s) {
    assertEquals(mistake.getMistakeType(), mistakeType);

    if (studentElem_s instanceof NamedElement) {
      assertEquals(mistake.getStudentElements().get(0).getElement(), studentElem_s);
    } else if (studentElem_s instanceof List) {
      assertTrue(mistakeElemsContainGivenElems(mistake.getStudentElements(),
          ECollections.unmodifiableEList((List<NamedElement>) studentElem_s)));
    } else {
      fail("Wrong type for studentElem(s): NamedElement or List<NamedElement> expected");
    }

    if (instructorElem_s instanceof NamedElement) {
      assertEquals(mistake.getInstructorElements().get(0).getElement(), instructorElem_s);
    } else if (instructorElem_s instanceof List) {
      assertTrue(mistakeElemsContainGivenElems(mistake.getInstructorElements(), (List<NamedElement>) instructorElem_s));
    } else {
      fail("Wrong type for instructorElem(s): NamedElement or List<NamedElement> expected");
    }
  }

  /**
   * Asserts a mistake's links with student and instructor element(s).
   *
   * @param mistake
   * @param mistakeType
   * @param elements a NamedElement or a List of NamedElements
   * @param instructorElem_s a NamedElement or a List of NamedElements
   */
  @SuppressWarnings("unchecked") // need to do this to get around lack of union types in Java
  public static void assertMistakeLinks(Mistake mistake, MistakeType mistakeType, Object elements) {
    assertEquals(mistake.getMistakeType(), mistakeType);
    if (mistake.getInstructorElements().isEmpty()) {
      if (elements instanceof NamedElement) {
        assertEquals(mistake.getStudentElements().get(0).getElement(), elements);
      } else if (elements instanceof List) {
        assertTrue(mistakeElemsContainGivenElems(mistake.getStudentElements(),
            ECollections.unmodifiableEList((List<NamedElement>) elements)));
      } else {
        fail("Wrong type for studentElem(s): NamedElement or List<NamedElement> expected");
      }
    }
    if (mistake.getStudentElements().isEmpty()) {
      if (elements instanceof NamedElement) {
        assertEquals(mistake.getInstructorElements().get(0).getElement(), elements);
      } else if (elements instanceof List) {
        assertTrue(mistakeElemsContainGivenElems(mistake.getInstructorElements(), (List<NamedElement>) elements));
      } else {
        fail("Wrong type for instructorElem(s): NamedElement or List<NamedElement> expected");
      }
    }
  }

  /**
   * Asserts a mistake's Attributes with only single instructor and student element.
   *
   * @param mistake
   * @param numSinceResolved
   * @param numDetections
   * @param resolved
   */
  public static void assertMistakeAttribute(Mistake mistake, int numSinceResolved, int numDetections,
      boolean resolved) {
    assertEquals(mistake.getNumSinceResolved(), numSinceResolved);
    assertEquals(mistake.getNumDetections(), numDetections);
    assertEquals(mistake.isResolved(), resolved);
  }

  public static FluentMistakeAssertion assertMistake() {
    return new FluentMistakeAssertion();
  }

  /**
   * Asserts a mistake with only single instructor and student element.
   *
   * @param mistake
   * @param mistakeType
   * @param element
   * @param numSinceResolved
   * @param numDetections
   * @param resolved
   */
  public static void assertMistake(Mistake mistake, MistakeType mistakeType, NamedElement studentElement,
      NamedElement instructorElement, int numSinceResolved, int numDetections, boolean resolved) {
    assertMistakeLinks(mistake, mistakeType, studentElement, instructorElement);
    assertMistakeAttribute(mistake, numSinceResolved, numDetections, resolved);
  }

  /**
   * Asserts a mistake with multiple single instructor and student element.
   *
   * @param mistake
   * @param mistakeType
   * @param element
   * @param numSinceResolved
   * @param numDetections
   * @param resolved
   */
  public static void assertMistake(Mistake mistake, MistakeType mistakeType,
      List<? extends NamedElement> studentElements, List<? extends NamedElement> instructorElements,
      int numSinceResolved, int numDetections, boolean resolved) {
    assertMistakeLinks(mistake, mistakeType, studentElements, instructorElements);
    assertMistakeAttribute(mistake, numSinceResolved, numDetections, resolved);
  }

  /**
   * Asserts a mistake with only single instructor or student element.
   *
   * @param mistake
   * @param mistakeType
   * @param element
   * @param numSinceResolved
   * @param numDetections
   * @param resolved
   */
  public static void assertMistake(Mistake mistake, MistakeType mistakeType, NamedElement element, int numSinceResolved,
      int numDetections, boolean resolved) {
    assertMistakeLinks(mistake, mistakeType, element);
    assertMistakeAttribute(mistake, numSinceResolved, numDetections, resolved);
  }

  /**
   * Asserts a mistake with multiple instructor and student elements.
   *
   * @param mistake
   * @param mistakeType
   * @param element
   * @param numSinceResolved
   * @param numDetections
   * @param resolved
   */
  public static void assertMistake(Mistake mistake, MistakeType mistakeType, List<? extends NamedElement> elements,
      int numSinceResolved, int numDetections, boolean resolved) {
    assertMistakeLinks(mistake, mistakeType, elements);
    assertMistakeAttribute(mistake, numSinceResolved, numDetections, resolved);
  }

  /**
   * Asserts a wrong class name mistake.
   *
   * @param instructorSol
   * @param studentSol
   * @param mistakeIdx
   * @param mistakeType
   * @param instructorClsName
   * @param studentClsName
   * @param numSinceResolved
   * @param numDetections
   * @param resolved
   */
  public static void assertMistake(Solution instructorSol, Solution studentSol, int mistakeIdx, MistakeType mistakeType,
      String instructorClsName, String studentClsName, int numSinceResolved, int numDetections, boolean resolved) {
    assertMistake(studentSol.getMistakes().get(mistakeIdx), mistakeType,
        getClassFromClassDiagram(studentClsName, studentSol.getClassDiagram()),
        getClassFromClassDiagram(instructorClsName, instructorSol.getClassDiagram()), numSinceResolved, numDetections,
        resolved);
  }


  /**
   * Asserts an attribute mistake where the class name is the same.
   *
   * @param instructorSol
   * @param studentSol
   * @param mistakeIdx
   * @param mistakeType
   * @param commonClsName
   * @param instructorAttrName
   * @param studentAttrName
   * @param numSinceResolved
   * @param numDetections
   * @param resolved
   */
  public static void assertMistake(Solution instructorSol, Solution studentSol, int mistakeIdx, MistakeType mistakeType,
      String commonClsName, String instructorAttrName, String studentAttrName, int numSinceResolved, int numDetections,
      boolean resolved) {
    assertMistake(studentSol.getMistakes().get(mistakeIdx), mistakeType,
        getAttributeFromDiagram(commonClsName, studentAttrName, studentSol.getClassDiagram()),
        getAttributeFromDiagram(commonClsName, instructorAttrName, instructorSol.getClassDiagram()), numSinceResolved,
        numDetections, resolved);
  }

  /**
   * Asserts a mistake in loop with only single instructor and student element.
   *
   * @param mistake
   * @param mistakeType
   * @param element
   * @param numSinceResolved
   * @param numDetections
   * @param resolved
   */
  public static void assertMistakeConditional(Mistake mistake, MistakeType mistakeType, NamedElement studentElement,
      NamedElement instructorElement, int numSinceResolved, int numDetections, boolean resolved) {
    if (mistake.getMistakeType() == mistakeType && mistake.getStudentElements().get(0).getElement() == studentElement) {
      assertMistake(mistake, mistakeType, studentElement, instructorElement, numSinceResolved, numDetections, resolved);
    }
  }

  /**
   * Asserts a mistake in loop with multiple instructor and student element.
   *
   * @param mistake
   * @param mistakeType
   * @param element
   * @param numSinceResolved
   * @param numDetections
   * @param resolved
   */
  public static void assertMistakeConditional(Mistake mistake, MistakeType mistakeType,
      List<NamedElement> studentElements, List<NamedElement> instructorElements, int numSinceResolved,
      int numDetections, boolean resolved) {
    if (mistake.getMistakeType() == mistakeType
        && mistakeElemsContainGivenElems(mistake.getStudentElements(), studentElements)) {
      assertMistake(mistake, mistakeType, studentElements, instructorElements, numSinceResolved, numDetections,
          resolved);
    }
  }

  /**
   * Asserts a mistake in loop with only single instructor or student element.
   *
   * @param mistake
   * @param mistakeType
   * @param element
   * @param numSinceResolved
   * @param numDetections
   * @param resolved
   */
  public static void assertMistakeConditional(Mistake mistake, MistakeType mistakeType, NamedElement element,
      int numSinceResolved, int numDetections, boolean resolved) {
    if (mistake.getStudentElements().isEmpty()) {
      if (mistake.getMistakeType() == mistakeType && mistake.getInstructorElements().get(0).getElement() == element) {
        assertMistake(mistake, mistakeType, element, numSinceResolved, numDetections, resolved);
      }
    }
    if (mistake.getInstructorElements().isEmpty()) {
      if (mistake.getMistakeType() == mistakeType && mistake.getStudentElements().get(0).getElement() == element) {
        assertMistake(mistake, mistakeType, element, numSinceResolved, numDetections, resolved);
      }
    }
  }

  /**
   * Asserts a mistake with multiple instructor or student element .
   *
   * @param mistake
   * @param mistakeType
   * @param element
   * @param numSinceResolved
   * @param numDetections
   * @param resolved
   */
  public static void assertMistakeConditional(Mistake mistake, MistakeType mistakeType, List<NamedElement> elements,
      int numSinceResolved, int numDetections, boolean resolved) {
    if (mistake.getStudentElements().isEmpty()) {
      if (mistake.getMistakeType() == mistakeType
          && mistakeElemsContainGivenElems(mistake.getInstructorElements(), elements)) {
        assertMistake(mistake, mistakeType, elements, numSinceResolved, numDetections, resolved);
      }
    }
    if (mistake.getInstructorElements().isEmpty()) {
      if (mistake.getMistakeType() == mistakeType
          && mistakeElemsContainGivenElems(mistake.getStudentElements(), elements)) {
        assertMistake(mistake, mistakeType, elements, numSinceResolved, numDetections, resolved);
      }
    }
  }

  /**
   * Returns the zeroth student mistake for a given cdm element, if any. This is equivalent to
   *
   * <pre>
   * studentMistakesFor(cdmElement).get(0)
   * </pre>
   *
   * @throws IndexOutOfBoundsException if the cdm element has no student mistakes
   */
  public static Mistake studentMistakeFor(NamedElement cdmElement) {
    return studentMistakeFor(cdmElement, 0);
  }

  /**
   * Returns the student mistake at the given position for a given cdm element, if any. This is equivalent to
   *
   * <pre>
   * studentMistakesFor(cdmElement).get(position)
   * </pre>
   *
   * @throws IndexOutOfBoundsException if the index is out of range
   */
  public static Mistake studentMistakeFor(NamedElement cdmElement, int position) {
    var mistakes = studentMistakesFor(cdmElement);
    if (0 <= position && position < mistakes.size()) {
      return mistakes.get(position);
    } else {
      throw new IndexOutOfBoundsException(
          "The given cdm element " + cdmElement.getName() + " does not have a student mistake at position " + position);
    }
  }

  /**
   * Returns the student mistakes for a given cdm element.
   */
  public static List<Mistake> studentMistakesFor(NamedElement cdmElement) {
    return SolutionElement.forCdmElement(cdmElement).getStudentElementMistakes();
  }

  /**
   * Compares the list of elements of one mistake with the given elements. This function is to be used when testing
   * mistake types with more than one element.
   *
   * @param mistakeElements
   * @param givenElements
   * @return true if mistakeElements contain givenElements
   */
  public static boolean mistakeElemsContainGivenElems(List<SolutionElement> mistakeElements,
      List<NamedElement> givenElements) {
    var namedElemsFromMistake = mistakeElements.stream().map(SolutionElement::getElement).collect(Collectors.toList());
    return namedElemsFromMistake.containsAll(givenElements);
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
    comparison.mappedClassifier.forEach((key, value) -> System.out.println(key.getName() + " = " + value.getName()));
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
        key.getType().getClass() + " " + key.getName() + " = " + value.getType().getClass() + " " + value.getName()));

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
    comparison.mappedAssociation.forEach((key, value) -> System.out.println(key.getName() + " " + value.getName()));

    System.out.println();
    System.out.println("Mapped Enumerations : ");
    comparison.mappedEnumeration.forEach((key, value) -> System.out.println(key.getName() + " " + value.getName()));

    System.out.println();
    System.out.print("Not Mapped Enumerations : ");
    for (CDEnum c : comparison.notMappedInstructorEnum) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Extra Enumeration : ");
    for (CDEnum c : comparison.extraStudentEnum) {
      System.out.print(c.getName() + " ");
    }

    System.out.println();
    System.out.println("Mapped Enumerations items: ");
    comparison.mappedEnumerationItems
        .forEach((key, value) -> System.out.println(key.getName() + " " + value.getName()));

    System.out.println();
    System.out.print("Not Mapped Enumerations items : ");
    for (CDEnumLiteral c : comparison.notMappedInstructorEnumLiterals) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
    System.out.print("Extra Enumeration items: ");
    for (CDEnumLiteral c : comparison.extraStudentEnumLiterals) {
      System.out.print(c.getName() + " ");
    }

    System.out.println();
    System.out.println("Instructor Generalization tree: ");
    comparison.instructorGeneraltionTree
        .forEach((key, value) -> System.out.println(key.getName() + " " + value) );

    System.out.println();
    System.out.println("Student Generalization tree: ");
    comparison.studentGeneraltionTree
        .forEach((key, value) -> System.out.println(key.getName() + " " + value) );


    System.out.println();
    System.out.println("Mistakes : ");
    comparison.newMistakes.forEach(m -> {
      if (!m.getInstructorElements().isEmpty() && !m.getStudentElements().isEmpty()) {
        System.out.print(" ' " + m.getMistakeType().getName() + " ' " + " Inst Elements : ");
        m.getInstructorElements().forEach(ie -> System.out.print(ie.getElement().getName() + " "));
        System.out.print(" student Elements :");
        m.getStudentElements().forEach(se -> System.out.print(se.getElement().getName() + " "));
        System.out.println();
      } else if (!m.getInstructorElements().isEmpty()) {
        System.out.print(" ' " + m.getMistakeType().getName() + " ' " + " Inst Elements : ");
        m.getInstructorElements().forEach(ie -> System.out.print(ie.getElement().getName() + " "));
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


class FluentMistakeAssertion {

  private Mistake mistake;
  private MistakeType expectedType;
  private Solution instructorSolution;
  private Solution studentSolution;
  private NamedElement instructorElement;
  private NamedElement studentElement;
  private int haveable;

  public FluentMistakeAssertion fromSolution(Solution studentSolution) {
    this.studentSolution = studentSolution;
    mistake = studentSolution.getMistakes().get(0);
    return this;
  }

  public FluentMistakeAssertion fromSolutions(Solution instructorSolution, Solution studentSolution) {
    this.instructorSolution = instructorSolution;
    return fromSolution(studentSolution);
  }

  public FluentMistakeAssertion atPosition(int position) {
    mistake = studentSolution.getMistakes().get(position);
    return this;
  }

  public FluentMistakeAssertion hasType(MistakeType type) {
    expectedType = type;
    assertEquals(type, mistake.getMistakeType());
    return this;
  }

  public FluentMistakeAssertion withInstructorElement(NamedElement instructorElement) {
    this.instructorElement = instructorElement;
    if (studentElement != null) {
      assertLinks(instructorElement, studentElement);
    }
    return this;
  }

  public FluentMistakeAssertion withStudentElement(NamedElement studentElement) {
    this.studentElement = studentElement;
    if (instructorElement != null) {
      assertLinks(instructorElement, studentElement);
    }
    return this;
  }

  public FluentMistakeAssertion withInstructorClassName(String instructorClassName) {
    instructorElement = getClassFromClassDiagram(instructorClassName, instructorSolution.getClassDiagram());
    if (studentElement != null) {
      assertLinks(instructorElement, studentElement);
    }
    return this;
  }

  public FluentMistakeAssertion withStudentClassName(String studentClassName) {
    studentElement = getClassFromClassDiagram(studentClassName, studentSolution.getClassDiagram());
    if (instructorElement != null) {
      assertLinks(instructorElement, studentElement);
    }
    return this;
  }

  public FluentMistakeAssertion withInstructorAttributeName(String className, String attributeName) {
    instructorElement = getAttributeFromDiagram(className, attributeName, instructorSolution.getClassDiagram());
    if (studentElement != null) {
      assertLinks(instructorElement, studentElement);
    }
    return this;
  }

  public FluentMistakeAssertion withStudentAttributeName(String className, String attributeName) {
    studentElement = getAttributeFromDiagram(className, attributeName, studentSolution.getClassDiagram());
    if (instructorElement != null) {
      assertLinks(instructorElement, studentElement);
    }
    return this;
  }

  public FluentMistakeAssertion has(int number) {
    haveable = number;
    return this;
  }

  public FluentMistakeAssertion hasNumSinceResolved(int numSinceResolved) {
    assertEquals(numSinceResolved, mistake.getNumSinceResolved());
    return this;
  }

  public FluentMistakeAssertion numSinceResolved() {
    return hasNumSinceResolved(haveable);
  }

  public FluentMistakeAssertion hasNumDetections(int numDetections) {
    assertEquals(numDetections, mistake.getNumDetections());
    return this;
  }

  public FluentMistakeAssertion numDetections() {
    return hasNumDetections(haveable);
  }

  public FluentMistakeAssertion and() {
    return this;
  }

  public FluentMistakeAssertion isResolved() {
    assertTrue(mistake.isResolved());
    return this;
  }

  public FluentMistakeAssertion isUnresolved() {
    assertFalse(mistake.isResolved());
    return this;
  }

  private FluentMistakeAssertion assertLinks(NamedElement instructorElement, NamedElement studentElement) {
    var type = expectedType != null ? expectedType : mistake.getMistakeType();
    MistakeDetectionTest.assertMistakeLinks(mistake, type, studentElement, instructorElement);
    return this;
  }

}
