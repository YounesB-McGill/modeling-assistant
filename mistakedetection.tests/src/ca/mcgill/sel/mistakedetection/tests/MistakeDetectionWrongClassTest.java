package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistakeAttribute;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistakeLinks;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentMistakeFor;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ABSTRACT;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_NOT_BE_ABSTRACT;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.LOWERCASE_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.SOFTWARE_ENGINEERING_TERM;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_CLASS_NAME;
import static modelingassistant.util.ClassDiagramUtils.getAssocAggCompFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import ca.mcgill.sel.mistakedetection.MistakeDetectionUtils;
import learningcorpus.mistaketypes.MistakeTypes;

public class MistakeDetectionWrongClassTest extends MistakeDetectionBaseTest {

  /**
   * Test to check for plural class names in student solution.
   */
  @Test
  public void testStudentSolution_1_PluralClassName() {
    var classDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution-a.domain_model.cdm");
    for (var c : classDiagram.getClasses()) {
      assertTrue(MistakeDetection.isPlural(c.getName()));
    }

    classDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/One/Class Diagram/InstructorSolution.domain_model.cdm");
    for (var c : classDiagram.getClasses()) {
      assertFalse(MistakeDetection.isPlural(c.getName()));
    }
  }

  /**
   * Test to check for plural class names in student solution.
   */
  @Test
  public void testVerbs() {
    var verbs = List.of("Walked", "Ran", "eats", "Jumped", "Danced");
    for (String verb : verbs) {
      assertTrue(MistakeDetection.isVerb(verb));
    }
  }

  /**
   * Test for checking mapping between instructor classifier(Bus, Driver) and Student classifier(Bus, Driver).
   */
  @Test
  public void testCheckMapping() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/One/Class Diagram/InstructorSolution.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    Classifier instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

    Classifier studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    Classifier studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(comparison.notMappedInstructorClassifiers.size(), 0);
    assertEquals(comparison.extraStudentClassifiers.size(), 0);
    assertEquals(comparison.mappedClassifiers.size(), 2);
    assertEquals(comparison.mappedClassifiers.get(instructorBusClass), studentBusClass);
    assertEquals(comparison.mappedClassifiers.get(instructorDriverClass), studentDriverClass);

    assertEquals(1, comparison.newMistakes.size());// Incomplete containment tree
    assertEquals(1, studentSolution.getMistakes().size());
  }

  /**
   * Test for checking mapping between instructor classifier(Bus, Driver) and Student classifier(Buses, Drivers) and
   * plural Class names.
   */
  @Test
  public void testPluralClassNames() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/One/Class Diagram/InstructorSolution.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution-a.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    Classifier instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

    Classifier studentBusesClass = getClassFromClassDiagram("Buses", studentClassDiagram);
    Classifier studentDriversClass = getClassFromClassDiagram("Drivers", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(comparison.notMappedInstructorClassifiers.size(), 0);
    assertEquals(comparison.extraStudentClassifiers.size(), 0);
    assertEquals(comparison.mappedClassifiers.size(), 2);
    assertEquals(comparison.mappedClassifiers.get(instructorBusClass), studentBusesClass);
    assertEquals(comparison.mappedClassifiers.get(instructorDriverClass), studentDriversClass);
    assertEquals(comparison.newMistakes.size(), 5); // 2 Bad Role Names
    assertEquals(studentSolution.getMistakes().size(), 5);

    assertMistake(studentSolution.getMistakes().get(0), PLURAL_CLASS_NAME, studentBusesClass, instructorBusClass, 0, 1,
        false);

    assertMistake(studentSolution.getMistakes().get(1), PLURAL_CLASS_NAME, studentDriversClass, instructorDriverClass,
        0, 1, false);
  }

  /**
   * Test to check Wrong class name mistake.
   */
  @Test
  public void testWrongClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classBus/Class Diagram/Instructor_classBus.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_wrongClassName/Class Diagram/Student_wrongClassName.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    Classifier studentBuseClass = getClassFromClassDiagram("Buse", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(comparison.newMistakes.size(), 1);
    assertEquals(studentSolution.getMistakes().size(), 1);

    assertMistakeLinks(studentSolution.getMistakes().get(0), BAD_CLASS_NAME_SPELLING, studentBuseClass,
        instructorBusClass);
    assertMistakeAttribute(studentSolution.getMistakes().get(0), 0, 1, false);
  }

  /**
   * Test to check Wrong Airport class name mistake.
   */
  @Test
  public void testWrongAirportClassName() {
    var instructorSol = instructorSolutionFromClassDiagram(cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm"));

    var studentSol = studentSolutionFromClassDiagram(cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_badClassNameAirport/Class Diagram/Student_AirportSystem.domain_model.cdm"));

    var comparison = MistakeDetection.compare(instructorSol, studentSol, false);

    assertEquals(comparison.newMistakes.size(), 1);
    assertEquals(studentSol.getMistakes().size(), 1);

    assertMistake().fromSolutions(instructorSol, studentSol)
        .withInstructorClassName("Airport")
        .withStudentClassName("Airpoort")
        .hasType(BAD_CLASS_NAME_SPELLING)
        .hasNumSinceResolved(0)
        .hasNumDetections(1)
        .isUnresolved();

    // same assertion as above, written even more fluently and in less lines
    assertMistake().fromSolutions(instructorSol, studentSol).withInstructorClassName("Airport")
        .withStudentClassName("Airpoort").hasType(BAD_CLASS_NAME_SPELLING).has(0).numSinceResolved()
        .has(1).numDetections().and().isUnresolved();
  }

  /**
   * Test to check Wrong Airplane class name mistake.
   */
  @Test
  public void testWrongAirplaneClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_badClassNameAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    Classifier studentAiroplaneClass = getClassFromClassDiagram("Airoplane", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(comparison.newMistakes.size(), 1);
    assertEquals(studentSolution.getMistakes().size(), 1);
    assertMistake(studentSolution.getMistakes().get(0), BAD_CLASS_NAME_SPELLING, studentAiroplaneClass,
        instructorAirplaneClass, 0, 1, false);
  }

  /**
   * Test to check Wrong City class name mistake.
   */
  @Test
  public void testWrongCityClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_badClassNameCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    Classifier studentCittyClass = getClassFromClassDiagram("Citty", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(comparison.newMistakes.size(), 1);
    assertEquals(studentSolution.getMistakes().size(), 1);
    assertMistake(studentSolution.getMistakes().get(0), BAD_CLASS_NAME_SPELLING, studentCittyClass, instructorCityClass,
        0, 1, false);
  }

  /**
   * Test to check Wrong Person class name mistake.
   */
  @Test
  public void testWrongPersonClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_badClassNamePerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    Classifier studentPersanClass = getClassFromClassDiagram("Persan", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(comparison.newMistakes.size(), 1);
    assertEquals(studentSolution.getMistakes().size(), 1);
    assertMistake(studentSolution.getMistakes().get(0), BAD_CLASS_NAME_SPELLING, studentPersanClass,
        instructorPersonClass, 0, 1, false);
  }

  /**
   * Test to check Wrong Passenger class name mistake.
   */
  @Test
  public void testWrongPassengerClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_badClassNamePassenger/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    Classifier studentPassangerClass = getClassFromClassDiagram("Passanger", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(comparison.newMistakes.size(), 1);
    assertEquals(studentSolution.getMistakes().size(), 1);
    assertMistake(studentSolution.getMistakes().get(0), BAD_CLASS_NAME_SPELLING, studentPassangerClass,
        instructorPassengerClass, 0, 1, false);
  }

  /**
   * Test to check Wrong Pilot class name mistake.
   */
  @Test
  public void testWrongPilotClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_badClassNamePilot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    Classifier studentPiloteClass = getClassFromClassDiagram("Pilote", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(comparison.newMistakes.size(), 1);
    assertEquals(studentSolution.getMistakes().size(), 1);
    assertMistake(studentSolution.getMistakes().get(0), BAD_CLASS_NAME_SPELLING, studentPiloteClass,
        instructorPilotClass, 0, 1, false);
  }

  @Test
  void testCheckMistakePluralClassName() {
    // no mistake
    var studentClass = MistakeDetection.CDF.createClass();
    studentClass.setName("Woman");

    var instructorClass = MistakeDetection.CDF.createClass();
    instructorClass.setName("Woman");

    assertTrue(MistakeDetection.checkMistakePluralClassName(studentClass, instructorClass).isEmpty());

    // mistake
    var expected = MistakeDetectionUtils.MAF.createMistake();
    expected.setMistakeType(MistakeTypes.PLURAL_CLASS_NAME);
    studentClass = MistakeDetection.CDF.createClass();
    studentClass.setName("Women");

    instructorClass = MistakeDetection.CDF.createClass();
    instructorClass.setName("Woman");

    var actual = MistakeDetection.checkMistakePluralClassName(studentClass, instructorClass).get();
    assertEquals(expected.getMistakeType(), actual.getMistakeType());
  }

  /**
   * Test to check Plural class name mistake.
   */
  @Test
  public void testPluralClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classBus/Class Diagram/Instructor_classBus.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_pluralClassName/Class Diagram/Student_pluralClassName.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    Classifier studentBusesClass = getClassFromClassDiagram("Buses", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), PLURAL_CLASS_NAME, studentBusesClass, instructorBusClass, 0, 1,
        false);
  }

  /**
   * Test to check Person Plural class name mistake.
   */
  @Test
  public void testPluralClassNamePerson() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classBusandPerson/Class Diagram/Instructor_classBusandPerson.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_pluralClassName1/Class Diagram/Student_pluralClassName1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentPeopleClass = getClassFromClassDiagram("People", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), PLURAL_CLASS_NAME, studentPeopleClass, instructorPersonClass, 0,
        1, false);
  }

  /**
   * Test to check Passenger Plural class name mistake
   */
  @Test
  public void testPluralClassNamePassenger() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classBusDriverAndPassenger/Class Diagram/Instructor_classBusDriverAndPassenger.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_pluralClassName2/Class Diagram/Student_pluralClassName2.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var studentPassengersClass = getClassFromClassDiagram("Passengers", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), PLURAL_CLASS_NAME, studentPassengersClass,
        instructorPassengerClass, 0, 1, false);
  }

  /**
   * Test to check Plural Airport class name mistake.
   */
  @Test
  public void testPluralAirportClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_pluralAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    Classifier studentAirportsClass = getClassFromClassDiagram("Airports", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), PLURAL_CLASS_NAME, studentAirportsClass, instructorAirportClass,
        0, 1, false);
  }

  /**
   * Test to check Plural Airplane class name mistake.
   */
  @Test
  public void testPluralAirplaneClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_pluralAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorAirportClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    Classifier studentAirportsClass = getClassFromClassDiagram("Airplanes", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), PLURAL_CLASS_NAME, studentAirportsClass, instructorAirportClass,
        0, 1, false);
  }

  /**
   * Test to check Plural City class name mistake.
   */
  @Test
  public void testPluralCitiesClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_pluralCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorAirportClass = getClassFromClassDiagram("City", instructorClassDiagram);
    Classifier studentAirportsClass = getClassFromClassDiagram("Cities", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), PLURAL_CLASS_NAME, studentAirportsClass, instructorAirportClass,
        0, 1, false);
  }

  /**
   * Test to check Plural Pilot class name mistake.
   */
  @Test
  public void testPluralPilotsClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_pluralPilot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorAirportClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    Classifier studentAirportsClass = getClassFromClassDiagram("Pilots", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), PLURAL_CLASS_NAME, studentAirportsClass, instructorAirportClass,
        0, 1, false);
  }

  /**
   * Test to check Plural People class name mistake.
   */
  @Test
  public void testPluralPeopleClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_pluralPerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorAirportClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    Classifier studentAirportsClass = getClassFromClassDiagram("People", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), PLURAL_CLASS_NAME, studentAirportsClass, instructorAirportClass,
        0, 1, false);
  }

  /**
   * Test to check Plural Passenger class name mistake.
   */
  @Test
  public void testPluralPassengersClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_pluralPassenger/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorAirportClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    Classifier studentAirportsClass = getClassFromClassDiagram("Passengers", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), PLURAL_CLASS_NAME, studentAirportsClass, instructorAirportClass,
        0, 1, false);
  }

  /**
   * Test to detect Driver extra Class.
   */
  @Test
  public void testMistakeExtraClassDriver() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classBus/Class Diagram/Instructor_classBus.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_extraClassName/Class Diagram/Student_extraClassName.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), EXTRA_CLASS, studentDriverClass, 0, 1, false);
  }

  /**
   * Test to detect extra Class Car.
   */
  @Test
  public void testMistakeExtraCarClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classBusandPerson/Class Diagram/Instructor_classBusandPerson.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_extraClass1/Class Diagram/Student_extraClass1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size()); // 1 mistake for extra class
    assertMistake(studentSolution.getMistakes().get(0), EXTRA_CLASS, studentCarClass, 0, 1, false);
  }

  /**
   * Test to detect Missing Class.
   */
  @Test
  public void testMistakeMissingClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classBusandPerson/Class Diagram/Instructor_classBusandPerson.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_missingAtterbute/Class Diagram/Student_missingAtterbute.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size()); // Missing Composition.
    assertMistake(studentSolution.getMistakes().get(0), MISSING_CLASS, instructorBusClass, 0, 1, false);
  }

  /**
   * Test to detect Missing City class in airport system.
   */
  @Test
  public void testMistakeMissingCityClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_missingCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(3, comparison.newMistakes.size());
    assertEquals(3, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), MISSING_CLASS, instructorCityClass, 0, 1, false);
  }

  /**
   * Test to detect Missing Airport class in airport system.
   */
  @Test
  public void testMistakeMissingAirportClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_missingAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), MISSING_CLASS, instructorAirportClass, 0, 1, false);
  }

  /**
   * Test to detect Missing Airplane class in airport system.
   */
  @Test
  public void testMistakeMissingAirplaneClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_missingAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirlaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), MISSING_CLASS, instructorAirlaneClass, 0, 1, false);
  }

  /**
   * Test to detect Missing Passenger class in airport system.
   */
  @Test
  public void testMistakeMissingPassengerClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_missingPassenger/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), MISSING_CLASS, instructorPassengerClass, 0, 1, false);
  }

  /**
   * Test to detect Missing Person class in airport system.
   */
  @Test
  public void testMistakeMissingPersonClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_missingPerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(9, comparison.newMistakes.size());
    assertEquals(9, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), MISSING_CLASS, instructorPersonClass, 0, 1, false);
  }


  /**
   * Test to detect Missing Pilot class in airport system.
   */
  @Test
  public void testMistakeMissingPilotClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_missingPilot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), MISSING_CLASS, instructorPilotClass, 0, 1, false);
  }

  /**
   * Test to detect extra Airline class in airport system.
   */
  @Test
  public void testMistakeExtraAirlineClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_extraAirline/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentAirlineClass = getClassFromClassDiagram("Airline", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(3, comparison.newMistakes.size());
    assertEquals(3, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), EXTRA_CLASS, studentAirlineClass, 0, 1, false);
  }

  /**
   * Test to detect extra GroundStaff class in airport system.
   */
  @Test
  public void testMistakeExtraGroundStaffClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_extraGroundStaff/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentAirlineClass = getClassFromClassDiagram("GroundStaff", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), EXTRA_CLASS, studentAirlineClass, 0, 1, false);
  }

  /**
   * Test to check Software Engineering term name mistake
   */
  @Test
  public void testSoftwareEngineeringTerm() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classBus/Class Diagram/Instructor_classBus.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_softwareEngineeringTerm/Class Diagram/Student_softwareEngineeringTerm.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var studentBusClassClass = getClassFromClassDiagram("BusClass", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), SOFTWARE_ENGINEERING_TERM, studentBusClassClass,
        instructorBusClass, 0, 1, false);
  }

  /**
   * Test to check Software Engineering term name mistake.
   */
  @Test
  public void testSoftwareEngineeringTerm1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classBusDriverAndPassenger/Class Diagram/Instructor_classBusDriverAndPassenger.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_softwareEngineeringTerm1/Class Diagram/Student_softwareEngineeringTerm1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);
    var studentDriverDataClass = getClassFromClassDiagram("DriverData", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), SOFTWARE_ENGINEERING_TERM, studentDriverDataClass,
        instructorDriverClass, 0, 1, false);
  }

  /**
   * Test to check Software Engineering term in Airplane Class
   */
  @Test
  public void testSoftwareEngineeringTermAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_seTermAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneDataClass = getClassFromClassDiagram("AirplaneData", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), SOFTWARE_ENGINEERING_TERM, studentAirplaneDataClass,
        instructorAirplaneClass, 0, 1, false);
  }

  /**
   * Test to check Software Engineering term in Airport Class
   */
  @Test
  public void testSoftwareEngineeringTermAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_seTermAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportRecordClass = getClassFromClassDiagram("AirportRecord", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), SOFTWARE_ENGINEERING_TERM, studentAirportRecordClass,
        instructorAirportClass, 0, 1, false);
  }

  /**
   * Test to check Software Engineering term in City Class
   */
  @Test
  public void testSoftwareEngineeringTermCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_seTermCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityInfoClass = getClassFromClassDiagram("CityInfo", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), SOFTWARE_ENGINEERING_TERM, studentCityInfoClass,
        instructorCityClass, 0, 1, false);
  }

  /**
   * Test to check Software Engineering term in Passenger Class
   */
  @Test
  public void testSoftwareEngineeringTermPassenger() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_seTermPassenger/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var studentPassengerBioClass = getClassFromClassDiagram("PassengerList", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), SOFTWARE_ENGINEERING_TERM, studentPassengerBioClass,
        instructorPassengerClass, 0, 1, false);
  }

  /**
   * Test to check Software Engineering term in Pilot Class
   */
  @Test
  public void testSoftwareEngineeringTermPilot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_seTermPilot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    var studentPilotRecordClass = getClassFromClassDiagram("PilotRecord", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), SOFTWARE_ENGINEERING_TERM, studentPilotRecordClass,
        instructorPilotClass, 0, 1, false);
  }

  /**
   * Test to check Software Engineering term in Person Class
   */
  @Test
  public void testSoftwareEngineeringTermPerson() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_seTermPerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentPersonTableClass = getClassFromClassDiagram("PersonTable", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), SOFTWARE_ENGINEERING_TERM, studentPersonTableClass,
        instructorPersonClass, 0, 1, false);
  }

  /**
   * Test to check lowercase class name mistake.
   */
  @Test
  public void testLowercaseClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classCar/Class Diagram/Instructor_classCar.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_lowercaseClasssName/Class Diagram/Student_lowercaseClasssName.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentcarClass = getClassFromClassDiagram("car", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), LOWERCASE_CLASS_NAME, studentcarClass, instructorCarClass, 0, 1,
        false);
  }

  /**
   * Test to check lowercase class name mistake.
   */
  @Test
  public void testLowercaseClassName1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classBusDriverAndPassenger/Class Diagram/Instructor_classBusDriverAndPassenger.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_lowercaseClassName1/Class Diagram/Student_lowercaseClassName1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var studentcpassengerClass = getClassFromClassDiagram("passenger", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), LOWERCASE_CLASS_NAME, studentcpassengerClass,
        instructorPassengerClass, 0, 1, false);
  }

  /**
   * Test to check lowercase Airplane class name mistake.
   */
  @Test
  public void testLowercaseAirplaneClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_lowerCaseAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentairplaneClass = getClassFromClassDiagram("airplane", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), LOWERCASE_CLASS_NAME, studentairplaneClass,
        instructorAirplaneClass, 0, 1, false);
  }

  /**
   * Test to check lowercase Airport class name mistake.
   */
  @Test
  public void testLowercaseAirportClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_lowerCaseAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentairportClass = getClassFromClassDiagram("airport", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), LOWERCASE_CLASS_NAME, studentairportClass,
        instructorAirportClass, 0, 1, false);
  }

  /**
   * Test to check lowercase City class name mistake.
   */
  @Test
  public void testLowercaseCityClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_lowerCaseCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentcityClass = getClassFromClassDiagram("city", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), LOWERCASE_CLASS_NAME, studentcityClass, instructorCityClass, 0,
        1, false);
  }

  /**
   * Test to check lowercase Passenger class name mistake.
   */
  @Test
  public void testLowercasePassengerClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_lowerCasePassenger/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var studentpassengerClass = getClassFromClassDiagram("passenger", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), LOWERCASE_CLASS_NAME, studentpassengerClass,
        instructorPassengerClass, 0, 1, false);
  }

  /**
   * Test to check lowercase Person class name mistake.
   */
  @Test
  public void testLowercasePersonClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_lowerCasePerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentpersonClass = getClassFromClassDiagram("person", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), LOWERCASE_CLASS_NAME, studentpersonClass, instructorPersonClass,
        0, 1, false);
  }

  /**
   * Test to check lowercase Pilot class name mistake.
   */
  @Test
  public void testLowercasePilotClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AirportSystem_lowerCasePilot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    var studentpilotClass = getClassFromClassDiagram("pilot", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), LOWERCASE_CLASS_NAME, studentpilotClass, instructorPilotClass,
        0, 1, false);
  }

  /**
   * Test to check wrong class name mistake.
   */
  @Test
  public void testWrongSimilarClassName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classPilot/Class Diagram/Instructor_classPilot.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_similarClassName/Class Diagram/Student _similarClassName.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    var studentFlyerClass = getClassFromClassDiagram("Flyer", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), WRONG_CLASS_NAME, studentFlyerClass, instructorPilotClass, 0, 1,
        false);
  }

  /**
   * Test to check wrong class name mistake
   */
  @Test
  public void testWrongSimilarClassName1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instractor_classCompany/Class Diagram/Instractor_classCompany.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_similarClassName1/Class Diagram/Student_similarClassName1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var studentFirmClass = getClassFromClassDiagram("Firm", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), WRONG_CLASS_NAME, studentFirmClass, instructorCompanyClass, 0,
        1, false);
  }

  /**
   * Test to check wrong class name mistake.
   */
  @Test
  public void testWrongClassName1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_classBusandPerson/Class Diagram/Instructor_classBusandPerson.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_badClassName/Class Diagram/Student_badClassName.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentPirsonClass = getClassFromClassDiagram("Pirson", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), BAD_CLASS_NAME_SPELLING, studentPirsonClass,
        instructorPersonClass, 0, 1, false);
  }

  /**
   * Test to check Company wrong class name mistake.
   */
  @Test
  public void testWrongClassNameCompany() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instractor_classCompany/Class Diagram/Instractor_classCompany.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_badClassName1/Class Diagram/Student_badClassName1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var studentCompaneyClass = getClassFromClassDiagram("Companey", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), BAD_CLASS_NAME_SPELLING, studentCompaneyClass,
        instructorCompanyClass, 0, 1, false);
  }

  /**
   * To check mapping of a class with a different name, based on classes associated to it.
   */
  @Test
  public void testCheckMappingBasedOnAssocClasses() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirplanePilotPasangerAirport/Class Diagram/Instructor_AirplanePilotPasangerAirport.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_mappingBasedOnAssocClasses/Class Diagram/Student_mappingBasedOnAssocClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentBoeingClass = getClassFromClassDiagram("Boeing777", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(studentBoeingClass, comparison.mappedClassifiers.get(instructorAirplaneClass));
  }

  /**
   * To check mapping of a class with a different name, based on classes associated to it.
   */
  @Test
  public void testCheckMappingBasedOnAssocClasses_anotherExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirplanePilotPasangerAirport/Class Diagram/Instructor_AirplanePilotPasangerAirport.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_mappingBasedOnAssocClasses1/Class Diagram/Student_mappingBasedOnAssocClasses1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var studentCustomerClass = getClassFromClassDiagram("Customer", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(studentCustomerClass, comparison.mappedClassifiers.get(instructorPassengerClass));
  }

  /**
   * To check mapping of a class with a different name, based on classes associated to it.
   */
  @Test
  public void testCheckMappingBasedOnAssocClasses_diffExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_airplannePilotAirline/Class Diagram/Instructor_airplannePilotAirline.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_MappingBasedOnAssocClasses2/Class Diagram/Student_MappingBasedOnAssocClasses2.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentLocationClass = getClassFromClassDiagram("Location", studentClassDiagram);
    var instructorAirlineClass = getClassFromClassDiagram("Airline", instructorClassDiagram);
    var studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(studentLocationClass, comparison.mappedClassifiers.get(instructorAirportClass));
    assertEquals(studentCompanyClass, comparison.mappedClassifiers.get(instructorAirlineClass));
  }

  /**
   * Check mapping for company association class b/w 2 solutions.
   */
  @Test
  public void testMappingAssocClassCompany() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_BusDiverCompanyAssocClass/Class Diagram/Instructor_BusDiverCompanyAssocClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_assocClass/Class Diagram/Student_assocClass.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(studentCompanyClass, comparison.mappedClassifiers.get(instructorCompanyClass));
  }

  /**
   * Check Company class for extra list.
   */
  @Test
  public void testMappingAssocClassExtraCompany() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_BusDiverCompanyAssocClass/Class Diagram/Instructor_BusDiverCompanyAssocClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_BusDriverCompany/Class Diagram/Student_BusDriverCompany.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertFalse(comparison.extraStudentClassifiers.contains(studentCompanyClass));
    assertFalse(comparison.notMappedInstructorClassifiers.contains(instructorCompanyClass));

    assertTrue(comparison.mappedClassifiers.containsKey(instructorCompanyClass));
    assertTrue(comparison.mappedClassifiers.containsValue(studentCompanyClass));
  }

  /**
   * Check mapping b/w Firm and Company assoc class.
   */
  @Test
  public void testMappingAssocClassFirm() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_BusDiverCompanyAssocClass/Class Diagram/Instructor_BusDiverCompanyAssocClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AssocClassFirm/Class Diagram/Student_AssocClassFirm.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var studentFirmClass = getClassFromClassDiagram("Firm", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(studentFirmClass, comparison.mappedClassifiers.get(instructorCompanyClass));
  }

  /**
   * Check mapping b/w Firm and Company assoc class with seperate company class present.
   */
  @Test
  public void testMappingAssocClassCompanyFirm() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_BusDiverCompanyAssocClass/Class Diagram/Instructor_BusDiverCompanyAssocClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AssocClassFirmCompanyy/Class Diagram/Student_AssocClassFirmCompanyy.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var studentFirmClass = getClassFromClassDiagram("Firm", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(studentFirmClass, comparison.mappedClassifiers.get(instructorCompanyClass));
  }

  /**
   * Check Company class for not mapped.
   */
  @Test
  public void testMappingAssocClassNotMappedCompany() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_BusDiverCompanyAssocClass/Class Diagram/Instructor_BusDiverCompanyAssocClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_BusDriver/Class Diagram/Student_BusDriver.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertTrue(comparison.notMappedInstructorClassifiers.contains(instructorCompanyClass));
  }

  /**
   * Check mistake missing association class.
   */
  @Test
  public void testMissingAssociationClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_BusDiverCompanyAssocClass/Class Diagram/Instructor_BusDiverCompanyAssocClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_BusDriver/Class Diagram/Student_BusDriver.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);
    var instructorAssociation = getAssocAggCompFromClassDiagram(instructorBusClass, instructorDriverClass, instructorClassDiagram);

    MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ASSOC_CLASS, List.of(instructorAssociation.get(0), instructorCompanyClass), 0, 1, false);
  }

  /**
   * Check Company class for extra.
   */
  @Test
  public void testExtraAssocClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_BusDriver/Class Diagram/Student_BusDriver.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_BusDiverCompanyAssocClass/Class Diagram/Instructor_BusDiverCompanyAssocClass.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertTrue(comparison.extraStudentClassifiers.contains(studentCompanyClass));
  }

  /**
   * Check Mistake extra Association class.
   */
  @Test
  public void testMappingAssocClassExtraCompanyAssocClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_BusDriver/Class Diagram/Student_BusDriver.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_BusDiverCompanyAssocClass/Class Diagram/Instructor_BusDiverCompanyAssocClass.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);
    var studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    var studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);
    var studentAssociation = getAssocAggCompFromClassDiagram(studentBusClass, studentDriverClass, studentClassDiagram);

    MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertMistake(studentMistakeFor(studentCompanyClass), EXTRA_ASSOC_CLASS, List.of(studentAssociation.get(0), studentCompanyClass), 0, 1, false);
  }

  /**
   * Check Company and BusPass AssocClass for mapping.
   */
  @Test
  public void testMappingAssocClassCompanyBusPass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_busDriverCompanyPassengerAssocClass/Class Diagram/Instructor_busDriverCompanyPassengerAssocClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_busDriverCompanyPassengerAssocClass/Class Diagram/Instructor_busDriverCompanyPassengerAssocClass.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);
    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var instructorBusPassClass = getClassFromClassDiagram("BusPass", instructorClassDiagram);
    var studentBusPassClass = getClassFromClassDiagram("BusPass", studentClassDiagram);
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(studentCompanyClass, comparison.mappedClassifiers.get(instructorCompanyClass));
    assertEquals(studentBusPassClass, comparison.mappedClassifiers.get(instructorBusPassClass));
    assertEquals(0, comparison.newMistakes.size());
  }

  /**
   * Check Company-Company AssocClass for mapping.
   */
  @Test
  public void testMappingAssocClassCompanyAndBusPass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_busDriverCompanyPassengerAssocClass/Class Diagram/Instructor_busDriverCompanyPassengerAssocClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AssocClassBusPassPassenger/Class Diagram/Student_AssocClassBusPassPassenger.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);
    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var instructorBusPassClass = getClassFromClassDiagram("BusPass", instructorClassDiagram);
    var studentBusPassClass = getClassFromClassDiagram("BusPass", studentClassDiagram);
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(studentBusPassClass, comparison.mappedClassifiers.get(instructorBusPassClass));
    assertEquals(studentCompanyClass, comparison.mappedClassifiers.get(instructorCompanyClass));
  }

  /**
   * Check Company-BusPass AssocClass for mapping and not mapped Company.
   */
  @Test
  public void testMappingAssocClassCompanyAndBusPassAndNotMappedCompany() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_busDriverCompanyPassengerAssocClass/Class Diagram/Instructor_busDriverCompanyPassengerAssocClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_AssocClassCompany/Class Diagram/Student_AssocClassCompany.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var instructorBusPassClass = getClassFromClassDiagram("BusPass", instructorClassDiagram);
    var studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(studentCompanyClass, comparison.mappedClassifiers.get(instructorBusPassClass));

    assertTrue(comparison.notMappedInstructorClassifiers.contains(instructorCompanyClass));
  }

  /**
   * Check Company AssocClass for notMapped and Company for extra.
   */
  @Test
  public void testMappingAssocClassCompanyAndExtraCompany() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_BusDiverCompanyAssocClass/Class Diagram/Instructor_BusDiverCompanyAssocClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestClass/student_BusDriverCompanyWithoutAssoc/Class Diagram/Student_BusDriverCompanyWithoutAssoc.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertTrue(comparison.mappedClassifiers.containsKey(instructorCompanyClass));
    assertTrue(comparison.mappedClassifiers.containsValue(studentCompanyClass));
  }

  /**
   * Check Mistake class should be abstract.
   */
  @Test
  public void testClassSholdBeAbstract() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_abstract_class/Class Diagram/Abstract_class.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_not_abstract_class/Class Diagram/Not_abstract_class.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());

    assertMistake(studentMistakeFor(studentCarClass), CLASS_SHOULD_BE_ABSTRACT, studentCarClass, instructorCarClass, 0, 1, false);
  }

  /**
   * Check Mistake class should not be abstract.
   */
  @Test
  public void testClassSholdNotBeAbstract() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_not_abstract_class/Class Diagram/Not_abstract_class.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_abstract_class/Class Diagram/Abstract_class.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());

    assertMistake(studentMistakeFor(studentCarClass), CLASS_SHOULD_NOT_BE_ABSTRACT, studentCarClass, instructorCarClass, 0, 1, false);
  }
}
