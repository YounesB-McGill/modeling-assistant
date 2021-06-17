package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import classdiagram.Association;
import classdiagram.AssociationEnd;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import learningcorpus.mistaketypes.MistakeTypes;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.util.ResourceHelper;

public class MistakeDetectionWrongRelationshipsTest {


  /**
   * Test to check mapping of relationships (No Mistakes)
   */
  @Test
  public void testToCheckRelationshipMapping() {
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

    Classifier instructorBusClass =
        MistakeDetectionTest.getClassFromClassDiagram("Bus", classDiagram);
    Classifier instructorDriverClass =
        MistakeDetectionTest.getClassFromClassDiagram("Driver", classDiagram);
    Classifier instructorPassengerClass =
        MistakeDetectionTest.getClassFromClassDiagram("Passenger", classDiagram);

    Association instructorBusDriverAssociation = MistakeDetectionTest.getAssociationFromClassDiagram(instructorBusClass, instructorDriverClass, classDiagram);
    Association instructorBusPassengerAssociation = MistakeDetectionTest.getAssociationFromClassDiagram(instructorBusClass,
            instructorPassengerClass, classDiagram);

    Classifier studentBusClass = MistakeDetectionTest.getClassFromClassDiagram("Bus", classDiagram1);
    Classifier studentDriverClass = MistakeDetectionTest.getClassFromClassDiagram("Driver", classDiagram1);
    Classifier studentPassengerClass = MistakeDetectionTest.getClassFromClassDiagram("Passenger", classDiagram1);

    Association studentBusDriverAssociation =
        MistakeDetectionTest.getAssociationFromClassDiagram(studentBusClass, studentDriverClass, classDiagram1);
    Association studentBusPassengerAssociation =
        MistakeDetectionTest.getAssociationFromClassDiagram(studentBusClass, studentPassengerClass, classDiagram1);

    var comparison = MistakeDetection.compare(solution, solution1);

    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 3);

    assertEquals(comparison.notMappedInstructorAttribute.size(), 0);
    assertEquals(comparison.extraStudentAttribute.size(), 0);
    assertEquals(comparison.duplicateStudentAttribute.size(), 0);
    assertEquals(comparison.mappedAttribute.size(), 4);

    assertEquals(comparison.notMappedInstructorAssociation.size(), 0);
    assertEquals(comparison.extraStudentAssociation.size(), 0);
    assertEquals(comparison.mappedAssociation.size(), 2);

    assertEquals(comparison.mappedAssociation.get(instructorBusDriverAssociation),
        studentBusDriverAssociation);
    assertEquals(comparison.mappedAssociation.get(instructorBusPassengerAssociation),
        studentBusPassengerAssociation);

    assertEquals(comparison.newMistakes.size(), 0);
    assertEquals(solution1.getMistakes().size(), 0);
  }

  /**
   * Test for checking mapping between instructor classifier(Bus, Driver) and Student
   * classifier(Buses, Drivr) and Mistake WrongClassName and WrongAssociationName
   */
  @Test
  public void checkCorrectTestWithSolution3() {
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
        "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution-b.domain_model.cdm";
    var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
    var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
    var maf1 = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant1 = maf1.createModelingAssistant();
    var solution1 = maf1.createSolution();
    solution1.setModelingAssistant(modelingAssistant1);
    solution1.setClassDiagram(classDiagram1);
    var student = maf1.createStudent();
    solution1.setStudent(student);

    Classifier instructorBusClass = MistakeDetectionTest.getClassFromClassDiagram("Bus", classDiagram);
    Classifier instructorDriverClass = MistakeDetectionTest.getClassFromClassDiagram("Driver", classDiagram);

    Classifier studentBusClass = MistakeDetectionTest.getClassFromClassDiagram("Bus", classDiagram1);
    Classifier studentDrivrClass = MistakeDetectionTest.getClassFromClassDiagram("Drivr", classDiagram1);

    AssociationEnd instructorMyDriverAssociationEnd = MistakeDetectionTest.getAssociationEndFromClass("myDriver", instructorBusClass);

    AssociationEnd StudentMyDrivrAssociationEnd = MistakeDetectionTest.getAssociationEndFromClass("myDrivr", studentBusClass);


    var comparison = MistakeDetection.compare(solution, solution1);
    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 2);
    assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDrivrClass);
    assertEquals(comparison.mappedAssociation.size(), 1);
    assertEquals(comparison.newMistakes.size(), 3);
    assertEquals(solution1.getMistakes().size(), 3);


    for (Mistake m : solution1.getMistakes()) {
      if (m.getMistakeType() == MistakeTypes.BAD_CLASS_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == studentDrivrClass) {
        assertEquals(m.getStudentElements().get(0).getElement(), studentDrivrClass);
        assertEquals(m.getInstructorElements().get(0).getElement(), instructorDriverClass);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
      if (m.getMistakeType() == MistakeTypes.BAD_ROLE_NAME_SPELLING
          && m.getStudentElements().get(0).getElement() == StudentMyDrivrAssociationEnd) {
        assertEquals(m.getStudentElements().get(0).getElement(), StudentMyDrivrAssociationEnd);
        assertEquals(m.getInstructorElements().get(0).getElement(),
            instructorMyDriverAssociationEnd);
        assertEquals(m.getNumDetectionSinceResolved(), 0);
        assertEquals(m.getNumDetection(), 1);
        assertFalse(m.isResolved());
      }
    }
  }

}
