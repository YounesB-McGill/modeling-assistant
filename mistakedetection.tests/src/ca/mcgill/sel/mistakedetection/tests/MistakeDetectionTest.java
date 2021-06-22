package ca.mcgill.sel.mistakedetection.tests;

import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.CdmPackage;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.classdiagram.NamedElement;
import ca.mcgill.sel.classdiagram.util.CdmResourceFactoryImpl;
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
   * Test to check if all the classes exist in Instructor solution are loaded in cdmFile
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
  public void testLoadingStudentSolution1() {

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
  public void test_UpdateInMistakeAttributes() {

    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/One/Class Diagram/InstructorSolution.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var modelingAssistant = maf.createModelingAssistant();
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(modelingAssistant, studentClassDiagram);

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    Classifier instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 0);
    assertEquals(studentSolution.getMistakes().size(), 0);

    // Loading 2nd Solution to check Mistakes Update in Metamodel
    studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution-a.domain_model.cdm");
    studentSolution = studentSolutionFromClassDiagram(modelingAssistant, studentClassDiagram);

    instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

    Classifier studentBusesClass = getClassFromClassDiagram("Buses", studentClassDiagram);
    Classifier studentDriversClass = getClassFromClassDiagram("Drivers", studentClassDiagram);

    comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 4); // 2 Bad Role Name Spelling
    assertEquals(studentSolution.getMistakes().size(), 4);

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, PLURAL_CLASS_NAME, studentBusesClass, instructorBusClass, 0, 1, false);
      assertMistakeConditional(m, PLURAL_CLASS_NAME, studentDriversClass, instructorDriverClass, 0, 1, false);
    }
    // Running the second Solution again to check updated attribute values in Mistake in Metamodel
    assertEquals(studentSolution.getMistakes().size(), 4);
    comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 4);
    assertEquals(studentSolution.getMistakes().size(), 4);

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, PLURAL_CLASS_NAME, studentBusesClass, instructorBusClass, 0, 2, false);
      assertMistakeConditional(m, PLURAL_CLASS_NAME, studentDriversClass, instructorDriverClass, 0, 2, false);
    }

    comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 4);
    assertEquals(studentSolution.getMistakes().size(), 4);

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, PLURAL_CLASS_NAME, studentBusesClass, instructorBusClass, 0, 3, false);
      assertMistakeConditional(m, PLURAL_CLASS_NAME, studentDriversClass, instructorDriverClass, 0, 3, false);
    }

    // checking with perfect solution
    studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution.domain_model.cdm");
    studentSolution = studentSolutionFromClassDiagram(modelingAssistant, studentClassDiagram);

    instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

    comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 0);
    // assertEquals(studentSolution.getMistakes().size(), 6); // TODO Discuss in meeting
    // next meeting

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, PLURAL_CLASS_NAME, studentBusesClass, instructorBusClass, 1, 3, false);
      assertMistakeConditional(m, PLURAL_CLASS_NAME, studentDriversClass, instructorDriverClass, 1, 3, false);
    }
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

    assertEquals(comparison.newMistakes.size(), 4);
    assertEquals(studentSolution.getMistakes().size(), 4);

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

    assertEquals(comparison.newMistakes.size(), 4);
    assertEquals(studentSolution.getMistakes().size(), 4);

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
    assertEquals(comparison.newMistakes.size(), 0);
    assertEquals(studentSolution.getMistakes().size(), 0);
  }

  /**
   * Test to check mapping for Bus = Vehicle , Passenger = Customer, Driver = Pilot
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

    assertEquals(comparison.newMistakes.size(), 0);
    assertEquals(studentSolution.getMistakes().size(), 0);
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
      throw new IllegalArgumentException("No Class Found, please check the class name");
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
      throw new IllegalArgumentException("No Attribute Found, please check the attribute name");
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
      if (assoc.getName().contains(class1.getName()) && assoc.getName().contains(class2.getName())) {
        seekedAssociation = assoc;
      }
    }
    if (seekedAssociation == null) {
      throw new IllegalArgumentException("No Association Found, please check the association name");
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
  public static AssociationEnd getAssociationEndFromClass(String associationEndName, Classifier givenClass) {
    AssociationEnd seekedAssociationEnd = null;
    for (var assocEnd : givenClass.getAssociationEnds()) {
      if (associationEndName.equals(assocEnd.getName())) {
        seekedAssociationEnd = assocEnd;
      }
    }
    if (seekedAssociationEnd == null) {
      throw new IllegalArgumentException("No Association End Found, Please check the association end name");
    }
    return seekedAssociationEnd;
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
  public static void assertMistakeLinks(Mistake mistake, MistakeType mistakeType, EList<NamedElement> elements) {
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
   * @param studentElem_s a NamedElement or an EList of NamedElements
   * @param instructorElem_s a NamedElement or an EList of NamedElements
   */
  @SuppressWarnings("unchecked") // need to do this to get around lack of union types in Java
  public static void assertMistakeLinks(Mistake mistake, MistakeType mistakeType, Object studentElem_s,
      Object instructorElem_s) {
    assertEquals(mistake.getMistakeType(), mistakeType);

    if (studentElem_s instanceof NamedElement) {
      assertEquals(mistake.getStudentElements().get(0).getElement(), studentElem_s);
    } else if (studentElem_s instanceof EList) {
      assertTrue(mistakeElemsContainGivenElems(mistake.getStudentElements(), (EList<NamedElement>) studentElem_s));
    } else {
      fail("Wrong type for studentElem(s): NamedElement or EList<NamedElement> expected");
    }

    if (instructorElem_s instanceof NamedElement) {
      assertEquals(mistake.getInstructorElements().get(0).getElement(), instructorElem_s);
    } else if (instructorElem_s instanceof EList) {
      assertTrue(mistakeElemsContainGivenElems(mistake.getInstructorElements(),
          (EList<NamedElement>) instructorElem_s));
    } else {
      fail("Wrong type for instructorElem(s): NamedElement or EList<NamedElement> expected");
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
    assertEquals(mistake.getNumDetectionSinceResolved(), numSinceResolved);
    assertEquals(mistake.getNumDetection(), numDetections);
    assertEquals(mistake.isResolved(), resolved);
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
  public static void assertMistake(Mistake mistake, MistakeType mistakeType, EList<NamedElement> studentElements,
      EList<NamedElement> instructorElements, int numSinceResolved, int numDetections, boolean resolved) {
    assertMistakeLinks(mistake, mistakeType, studentElements, instructorElements);
    assertMistakeAttribute(mistake, numSinceResolved, numDetections, resolved);
  }

  /**
   * Asserts a mistake with only single instructor or student element .
   *
   * @param mistake
   * @param mistakeType
   * @param element
   * @param numSinceResolved
   * @param numDetections
   * @param resolved
   */
  public static void assertMistake(Mistake mistake, MistakeType mistakeType, NamedElement element,
      int numSinceResolved, int numDetections, boolean resolved) {
    assertMistakeLinks(mistake, mistakeType, element);
    assertMistakeAttribute(mistake, numSinceResolved, numDetections, resolved);
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
  public static void assertMistake(Mistake mistake, MistakeType mistakeType, EList<NamedElement> elements,
      int numSinceResolved, int numDetections, boolean resolved) {
    assertMistakeLinks(mistake, mistakeType, elements);
    assertMistakeAttribute(mistake, numSinceResolved, numDetections, resolved);
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
   * Asserts a mistake in loop with multiple instructor and student element .
   *
   * @param mistake
   * @param mistakeType
   * @param element
   * @param numSinceResolved
   * @param numDetections
   * @param resolved
   */
  public static void assertMistakeConditional(Mistake mistake, MistakeType mistakeType,
      EList<NamedElement> studentElements, EList<NamedElement> instructorElements, int numSinceResolved,
      int numDetections, boolean resolved) {
    if (mistake.getMistakeType() == mistakeType
        && mistakeElemsContainGivenElems(mistake.getStudentElements(), studentElements)) {
      assertMistake(mistake, mistakeType, studentElements, instructorElements, numSinceResolved, numDetections,
          resolved);
    }
  }

  /**
   * Asserts a mistake in loop with only single instructor or student element .
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
  public static void assertMistakeConditional(Mistake mistake, MistakeType mistakeType, EList<NamedElement> elements,
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
   * Returns the class diagram at the given *.cdm file path.
   */
  static ClassDiagram cdmFromFile(String path) {
    return cdmFromFile(new File(path));
  }

  /**
   * Compares the list of elements of one mistake with the given elements. This function is to be used when testing
   * mistake types with more than one element.
   *
   * @param mistakeElements
   * @param givenElements
   * @return true if mistakeElements contain givenElements
   */
  public static boolean mistakeElemsContainGivenElems(EList<SolutionElement> mistakeElements,
      EList<NamedElement> givenElements) {
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
