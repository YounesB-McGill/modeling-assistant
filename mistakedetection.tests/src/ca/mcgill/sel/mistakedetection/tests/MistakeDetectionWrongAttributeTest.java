package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistakeConditional;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistakeTypesContain;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentMistakeFor;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_DUPLICATED;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_MISPLACED;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.UPPERCASE_ATTRIBUTE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import static modelingassistant.util.ClassDiagramUtils.getAttributeFromClass;
import static modelingassistant.util.ClassDiagramUtils.getAttributeFromDiagram;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import modelingassistant.Mistake;

public class MistakeDetectionWrongAttributeTest {

  /**
   * Test to check for attributes(name,capacity,name,numberPlate)
   */
  @Test
  public void testNoAttributeMistake() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/Class Diagram/Two(withAttributes).domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/two(withAttribute)/Class Diagram/Two(withAttribute).domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
  }

  /**
   * Test to check for attributes Spelling Mistakes (nam,capacty,nme,noPlate)
   */
  @Test
  public void testAttributeWrongSpelling() {
    var instructorCdm = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/Class Diagram/Two(withAttributes).domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorCdm);

    var studentCdm = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/three(withAttributes)/Class Diagram/Three(withAttributes).domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentCdm);

    var instructorBusClassAttributeCapacity = getAttributeFromDiagram("Bus", "capacity", instructorCdm);
    var instructorBusClassAttributeNumberPlate = getAttributeFromDiagram("Bus", "numberPlate", instructorCdm);
    var instructorDriverClassAttributeName = getAttributeFromDiagram("Driver", "name", instructorCdm);
    var instructorPassengerClassAttributeName = getAttributeFromDiagram("Passenger", "name", instructorCdm);

    var studentBusClassAttributeCapacty = getAttributeFromDiagram("Bus", "capacty", studentCdm);
    var studentBusClassAttributeNamberPlate = getAttributeFromDiagram("Bus", "namberPlate", studentCdm);
    var studentDriverClassAttributeNme = getAttributeFromDiagram("Driver", "nme", studentCdm);
    var studentPassengerClassAttributeNam = getAttributeFromDiagram("Passenger", "nam", studentCdm);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(comparison.newMistakes.size(), 5);
    assertEquals(studentSolution.getMistakes().size(), 5);

    assertMistake(studentMistakeFor(studentBusClassAttributeCapacty), BAD_ATTRIBUTE_NAME_SPELLING,
        studentBusClassAttributeCapacty, instructorBusClassAttributeCapacity, 0, 1, false);
    assertMistake(studentMistakeFor(studentBusClassAttributeNamberPlate), BAD_ATTRIBUTE_NAME_SPELLING,
        studentBusClassAttributeNamberPlate, instructorBusClassAttributeNumberPlate, 0, 1, false);
    assertMistake(studentMistakeFor(studentDriverClassAttributeNme), BAD_ATTRIBUTE_NAME_SPELLING,
        studentDriverClassAttributeNme, instructorDriverClassAttributeName, 0, 1, false);
    assertMistake(studentMistakeFor(studentPassengerClassAttributeNam), BAD_ATTRIBUTE_NAME_SPELLING,
        studentPassengerClassAttributeNam, instructorPassengerClassAttributeName, 0, 1, false);
  }

  /**
   * Test to check classifier and attribute mapping (2 Attributes unmapped, all classes mapped)
   */
  @Test
  public void testMistakeMissingAttributes() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/Class Diagram/Two(withAttributes).domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/two(withAttribute)/Class Diagram/Two(withAttribute)-a.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

    var instructorBusClassAttributeNumberPlate = getAttributeFromClass("numberPlate", instructorBusClass);
    var instructorDriverClassAttributeName = getAttributeFromClass("name", instructorDriverClass);

    var studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    var studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(comparison.newMistakes.size(), 3);
    assertEquals(studentSolution.getMistakes().size(), 3);
    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, MISSING_ATTRIBUTE, instructorDriverClassAttributeName, studentDriverClass, 0, 1, false);
      assertMistakeConditional(m, MISSING_ATTRIBUTE, instructorBusClassAttributeNumberPlate, studentBusClass, 0, 1, false);
    }
  }

  /**
   * Test to detect other extra Attribute.
   */
  @Test
  public void testMistakeExtraAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_person_nameAttribute/Class Diagram/Instructor_person_nameAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_extraAttribute/Class Diagram/Student_extraAttribute.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);

    var studentDateOfBirthAttribute = getAttributeFromClass("dateOfBirth", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), EXTRA_ATTRIBUTE, studentDateOfBirthAttribute, 0, 1, false);
  }

  /**
   * Test to detect Missing Attribute.
   */
  @Test
  public void testMistakeMissingAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_person_nameAttribute/Class Diagram/Instructor_person_nameAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_missingAtterbute/Class Diagram/Student_missingAtterbute.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);

    var instructorNameAttribute = getAttributeFromClass("name", instructorPersonClass);

    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ATTRIBUTE, studentPersonClass, instructorNameAttribute, 0, 1, false);
  }

  /**
   * Test to detect Missing code Attribute in Airplane.
   */
  @Test
  public void testMistakeMissingCodeAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_attributeMissingCodeAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCodeAttribute = getAttributeFromDiagram("Airport", "code", instructorClassDiagram);

    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ATTRIBUTE, studentAirportClass, instructorCodeAttribute, 0, 1, false);
  }

  /**
   * Test to detect Missing company Attribute in Airport.
   */
  @Test
  public void testMistakeMissingCompanyAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_attributeMissingCompanyAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);

    var instructorCompanyAttribute = getAttributeFromClass("company", instructorAirplaneClass);

    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ATTRIBUTE, studentAirplaneClass, instructorCompanyAttribute, 0, 1, false);
  }

  /**
   * Test to detect Missing name Attribute in City.
   */
  @Test
  public void testMistakeMissingNameAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_attributeMissingNameCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);

    var instructornameAttribute = getAttributeFromClass("name", instructorCityClass);

    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ATTRIBUTE,studentCityClass, instructornameAttribute, 0, 1, false);
  }

  /**
   * Test to detect Missing name Attribute in Pilot.
   */
  @Test
  public void testMistakeMissingPilotNameAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_attributeMissingNamePilot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);

    var instructornameAttribute = getAttributeFromClass("name", instructorPilotClass);

    var studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(1), MISSING_ATTRIBUTE, studentPilotClass, instructornameAttribute, 0, 1, false);
  }

  /**
   * Test to detect Missing ticketNo Attribute in Passenger.
   */
  @Test
  public void testMistakeMissingticketNoAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_attributeMissingticketNoPassenger/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);

    var instructorticketNoAttribute = getAttributeFromClass("ticketNo", instructorPassengerClass);

    var studentPassengerClass = getClassFromClassDiagram("Passenger", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(1), MISSING_ATTRIBUTE, studentPassengerClass, instructorticketNoAttribute, 0, 1, false);
  }

  /**
   * Test to detect Missing Name Attribute in City.
   */
  @Test
  public void testMistakeMissingFlightNoAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_attributeMissingFlightNoAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);

    var instructorflightNoAttribute = getAttributeFromClass("flightNo", instructorAirplaneClass);

    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ATTRIBUTE, studentAirplaneClass, instructorflightNoAttribute, 0, 1, false);
  }

  /**
   * Test to detect other extra Attribute.
   */
  @Test
  public void testMistakeOtherExtraAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_pilot_genderAtterbute/Class Diagram/Instructor_pilot_genderAtterbute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_extraAtterbute1/Class Diagram/Student_extraAtterbute1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);

    var studentnameAttribute = getAttributeFromClass("name", studentPilotClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), EXTRA_ATTRIBUTE, studentnameAttribute, 0, 1, false);
  }

  /**
   * Test to detect capacity extra Attribute in Airport.
   */
  @Test
  public void testMistakeExtraCapacityAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_extraAtribCapacityAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);

    var studentCapacityAttribute = getAttributeFromClass("capacity", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), EXTRA_ATTRIBUTE, studentCapacityAttribute, 0, 1, false);
  }

  /**
   * Test to detect crew capacity extra Attribute in Airplane.
   */
  @Test
  public void testMistakeExtraCrewAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_extraAtribCrewAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var studentCrewCapAttribute = getAttributeFromClass("crewCap", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), EXTRA_ATTRIBUTE, studentCrewCapAttribute, 0, 1, false);
  }

  /**
   * Test to detect date of birth extra Attribute in Person.
   */
  @Test
  public void testMistakeExtraDOBAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_extraAtribDOBPerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);

    var studentDateOfBirthAttribute = getAttributeFromClass("dateOfBirth", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), EXTRA_ATTRIBUTE, studentDateOfBirthAttribute, 0, 1, false);
  }

  /**
   * Test to detect name extra Attribute in Passenger.
   */
  @Test
  public void testMistakeExtraNameAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_extraAtribNamePassenger/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentPassengerClass = getClassFromClassDiagram("Passenger", studentClassDiagram);

    var studentNameAttribute = getAttributeFromClass("name", studentPassengerClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), EXTRA_ATTRIBUTE, studentNameAttribute, 0, 1, false);
  }

  /**
   * Test to detect PinCode extra Attribute in City.
   */
  @Test
  public void testMistakeExtraPinAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_extraAtribPinCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);

    var studentPinCodeAttribute = getAttributeFromClass("pinCode", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), EXTRA_ATTRIBUTE, studentPinCodeAttribute, 0, 1, false);
  }

  /**
   * Test to detect rank extra Attribute in Pilot.
   */
  @Test
  public void testMistakeExtraRankAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_extraAtribRankPilot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);

    var studentRankAttribute = getAttributeFromClass("rank", studentPilotClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), EXTRA_ATTRIBUTE, studentRankAttribute, 0, 1, false);
  }

  /**
   * Test to detect other extra Attribute.
   */
  @Test
  public void testMistakeExtraAttributeInStudentSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_car_priceAttribute/Class Diagram/Instructor_car_priceAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_extraAttribute2/Class Diagram/Student_extraAttribute2.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);

    var studenttypeAttribute = getAttributeFromClass("type", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), EXTRA_ATTRIBUTE, studenttypeAttribute, 0, 1, false);
  }

  /**
   * Test to detect plural Attribute name.
   */
  @Test
  public void testMistakepluralAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_person_nameAttribute/Class Diagram/Instructor_person_nameAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_pluralAttribute1/Class Diagram/Student_pluralAttribute1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);

    var instructornameAttribute = getAttributeFromClass("name", instructorPersonClass);
    var studentnamesAttribute = getAttributeFromClass("names", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), PLURAL_ATTRIBUTE, studentnamesAttribute,
        instructornameAttribute, 0, 1, false);
  }

  /**
   * Test to detect plural Attribute name.
   */
  @Test
  public void testMistakepluralAttributeInStudentSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_ filght_destinationAttribute/Class Diagram/Instructor_ filght_destinationAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_pluralAttribute/Class Diagram/Student_pluralAttribute.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorFlightClass = getClassFromClassDiagram("Flight", instructorClassDiagram);
    var studentFlightClass = getClassFromClassDiagram("Flight", studentClassDiagram);

    var instructorNameAttribute = getAttributeFromClass("destination", instructorFlightClass);
    var studentNamesAttribute = getAttributeFromClass("destinations", studentFlightClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), PLURAL_ATTRIBUTE, studentNamesAttribute,
        instructorNameAttribute, 0, 1, false);
  }

  /**
   * Test to detect plural Code Attribute.
   */
  @Test
  public void testMistakepluralAttributeInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_pluralAtribCodeAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);

    var instructorCodeAttribute = getAttributeFromClass("code", instructorAirportClass);
    var studentCodesAttribute = getAttributeFromClass("codes", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), PLURAL_ATTRIBUTE, studentCodesAttribute,
        instructorCodeAttribute, 0, 1, false);
  }

  /**
   * Test to detect plural company Attribute.
   */
  @Test
  public void testMistakepluralAttributeInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_pluralAtribCompanyAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var instructorCompanyAttribute = getAttributeFromClass("company", instructorAirplaneClass);
    var studentCompaniesAttribute = getAttributeFromClass("companies", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), PLURAL_ATTRIBUTE, studentCompaniesAttribute,
        instructorCompanyAttribute, 0, 1, false);
  }

  /**
   * Test to detect plural flightNo Attribute.
   */
  @Test
  public void testMistakepluralFlightNoAttributeInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_pluralAtribFlightNoAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var instructorFlightNoAttribute = getAttributeFromClass("flightNo", instructorAirplaneClass);
    var studentFlightNumbersAttribute = getAttributeFromClass("flightNumbers", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), PLURAL_ATTRIBUTE, studentFlightNumbersAttribute,
        instructorFlightNoAttribute, 0, 1, false);
  }

  /**
   * Test to detect plural name Attribute.
   */
  @Test
  public void testMistakepluralAttributeInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_pluralAtribNameCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);

    var instructorNameAttribute = getAttributeFromClass("name", instructorCityClass);
    var studentNamesAttribute = getAttributeFromClass("names", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), PLURAL_ATTRIBUTE, studentNamesAttribute,
        instructorNameAttribute, 0, 1, false);
  }

  /**
   * Test to detect plural name Attribute.
   */
  @Test
  public void testMistakepluralAttributeInPilot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_pluralAtribNamePilot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    var studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);

    var instructorNameAttribute = getAttributeFromClass("name", instructorPilotClass);
    var studentNamesAttribute = getAttributeFromClass("names", studentPilotClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), PLURAL_ATTRIBUTE, studentNamesAttribute,
        instructorNameAttribute, 0, 1, false);
  }

  /**
   * Test to detect plural ticketNo Attribute.
   */
  @Test
  public void testMistakepluralAttributeInPassenger() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_pluralAtribTicketNoPassenger/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var studentPassengerClass = getClassFromClassDiagram("Passenger", studentClassDiagram);

    var instructorTicketNoAttribute = getAttributeFromClass("ticketNo", instructorPassengerClass);
    var studentTicketNosAttribute = getAttributeFromClass("ticketNos", studentPassengerClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), PLURAL_ATTRIBUTE, studentTicketNosAttribute,
        instructorTicketNoAttribute, 0, 1, false);
  }

  /**
   * Test to detect uppercase Code Attribute.
   */
  @Test
  public void testMistakeUppercaseAttributeInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_uppercaseAtribCodeAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);

    var instructorCodeAttribute = getAttributeFromClass("code", instructorAirportClass);
    var studentCodeAttribute = getAttributeFromClass("Code", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), UPPERCASE_ATTRIBUTE_NAME, studentCodeAttribute,
        instructorCodeAttribute, 0, 1, false);
  }

  /**
   * Test to detect uppercase company Attribute.
   */
  @Test
  public void testMistakeUppercaseAttributeInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_uppercaseAtribCompanyAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var instructorCompanyAttribute = getAttributeFromClass("company", instructorAirplaneClass);
    var studentCompanyAttribute = getAttributeFromClass("Company", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), UPPERCASE_ATTRIBUTE_NAME, studentCompanyAttribute,
        instructorCompanyAttribute, 0, 1, false);
  }

  /**
   * Test to detect uppercase flightNo Attribute.
   */
  @Test
  public void testMistakeUppercaseFlightNoAttributeInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_uppercaseAtribFlightNoAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var instructorFlightNoAttribute = getAttributeFromClass("flightNo", instructorAirplaneClass);
    var studentFlightNoAttribute = getAttributeFromClass("FlightNo", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), UPPERCASE_ATTRIBUTE_NAME, studentFlightNoAttribute,
        instructorFlightNoAttribute, 0, 1, false);
  }

  /**
   * Test to detect uppercase name Attribute.
   */
  @Test
  public void testMistakeUppercaseAttributeInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_uppercaseAtribNameCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);

    var instructorNameAttribute = getAttributeFromClass("name", instructorCityClass);
    var studentNameAttribute = getAttributeFromClass("Name", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), UPPERCASE_ATTRIBUTE_NAME, studentNameAttribute,
        instructorNameAttribute, 0, 1, false);
  }

  /**
   * Test to detect uppercase name Attribute.
   */
  @Test
  public void testMistakeUppercaseAttributeInPilot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_uppercaseAtribNamePilot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    var studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);

    var instructorNameAttribute = getAttributeFromClass("name", instructorPilotClass);
    var studentNameAttribute = getAttributeFromClass("Name", studentPilotClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), UPPERCASE_ATTRIBUTE_NAME, studentNameAttribute,
        instructorNameAttribute, 0, 1, false);
  }

  /**
   * Test to detect uppercase ticketNo Attribute.
   */
  @Test
  public void testMistakeUppercaseAttributeInPassenger() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_uppercaseAtribTicketNoPassenger/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var studentPassengerClass = getClassFromClassDiagram("Passenger", studentClassDiagram);

    var instructorTicketNoAttribute = getAttributeFromClass("ticketNo", instructorPassengerClass);
    var studentTicketNoAttribute = getAttributeFromClass("TicketNo", studentPassengerClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), UPPERCASE_ATTRIBUTE_NAME, studentTicketNoAttribute,
        instructorTicketNoAttribute, 0, 1, false);
  }

  /**
   * Test to detect wrong attribute type of code Attribute.
   */
  @Test
  public void testMistakeWrongAttributeTypeInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_wrongAtribTypeCodeAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);

    var instructorCodeAttribute = getAttributeFromClass("code", instructorAirportClass);
    var studentCodeAttribute = getAttributeFromClass("code", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ATTRIBUTE_TYPE, studentCodeAttribute,
        instructorCodeAttribute, 0, 1, false);
  }

  /**
   * Test to detect wrong attribute type of company Attribute.
   */
  @Test
  public void testMistakeWrongAttributeTypeInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_wrongAtribTypeCompanyAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var instructorCompanyAttribute = getAttributeFromClass("company", instructorAirplaneClass);
    var studentCompanyAttribute = getAttributeFromClass("company", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ATTRIBUTE_TYPE, studentCompanyAttribute,
        instructorCompanyAttribute, 0, 1, false);
  }

  /**
   * Test to detect wrong attribute type of flightNo Attribute.
   */
  @Test
  public void testMistakeWrongAttributeTypeFlightNoInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_wrongAtribTypeFlightNoAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var instructorFlightNoAttribute = getAttributeFromClass("flightNo", instructorAirplaneClass);
    var studentFlightNoAttribute = getAttributeFromClass("flightNo", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ATTRIBUTE_TYPE, studentFlightNoAttribute,
        instructorFlightNoAttribute, 0, 1, false);
  }

  /**
   * Test to detect wrong attribute type of city Attribute.
   */
  @Test
  public void testMistakeWrongAttributeTypeAttributeInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_wrongAtribTypeNameCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);

    var instructorNameAttribute = getAttributeFromClass("name", instructorCityClass);
    var studentNameAttribute = getAttributeFromClass("name", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ATTRIBUTE_TYPE, studentNameAttribute,
        instructorNameAttribute, 0, 1, false);
  }

  /**
   * Test to detect wrong attribute type of Pilot Attribute.
   */
  @Test
  public void testMistakeWrongAttributeTypeInPilot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_wrongAtribTypeNamePilot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    var studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);

    var instructorNameAttribute = getAttributeFromClass("name", instructorPilotClass);
    var studentNameAttribute = getAttributeFromClass("name", studentPilotClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ATTRIBUTE_TYPE, studentNameAttribute,
        instructorNameAttribute, 0, 1, false);
  }

  /**
   * Test to detect wrong attribute type of ticketNo Attribute.
   */
  @Test
  public void testMistakeWrongAttributeTypeInPassenger() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_wrongAtribTypeTicketNoPassenger/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var studentPassengerClass = getClassFromClassDiagram("Passenger", studentClassDiagram);

    var instructorTicketNoAttribute = getAttributeFromClass("ticketNo", instructorPassengerClass);
    var studentTicketNoAttribute = getAttributeFromClass("ticketNo", studentPassengerClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ATTRIBUTE_TYPE, studentTicketNoAttribute,
        instructorTicketNoAttribute, 0, 1, false);
  }

  /**
   * Test to detect static code Attribute.
   */
  @Test
  public void testMistakeAttributeNotStaticInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_staticAtribCodeAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);

    var instructorCodeAttribute = getAttributeFromClass("code", instructorAirportClass);
    var studentCodeAttribute = getAttributeFromClass("code", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_NOT_BE_STATIC, studentCodeAttribute,
        instructorCodeAttribute, 0, 1, false);
  }

  /**
   * Test to detect static company Attribute.
   */
  @Test
  public void testMistakeAttributeNotStaticInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_staticAtribCompanyAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var instructorCompanyAttribute = getAttributeFromClass("company", instructorAirplaneClass);
    var studentCompanyAttribute = getAttributeFromClass("company", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_NOT_BE_STATIC, studentCompanyAttribute,
        instructorCompanyAttribute, 0, 1, false);
  }

  /**
   * Test to detect static flightNo Attribute.
   */
  @Test
  public void testMistakeAttributeNotStaticFlightNoInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_staticAtribFlightNoAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var instructorFlightNoAttribute = getAttributeFromClass("flightNo", instructorAirplaneClass);
    var studentFlightNoAttribute = getAttributeFromClass("flightNo", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_NOT_BE_STATIC, studentFlightNoAttribute,
        instructorFlightNoAttribute, 0, 1, false);
  }

  /**
   * Test to detect static city Attribute.
   */
  @Test
  public void testMistakeAttributeNotStaticInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_staticAtribNameCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);

    var instructorNameAttribute = getAttributeFromClass("name", instructorCityClass);
    var studentNameAttribute = getAttributeFromClass("name", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_NOT_BE_STATIC, studentNameAttribute,
        instructorNameAttribute, 0, 1, false);
  }

  /**
   * Test to detect static Pilot Attribute.
   */
  @Test
  public void testMistakeAttributeNotStaticInPilot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_staticAtribNamePilot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    var studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);

    var instructorNameAttribute = getAttributeFromClass("name", instructorPilotClass);
    var studentNameAttribute = getAttributeFromClass("name", studentPilotClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_NOT_BE_STATIC, studentNameAttribute,
        instructorNameAttribute, 0, 1, false);
  }

  /**
   * Test to static ticketNo Attribute.
   */
  @Test
  public void testMistakeAttributeNotStaticInPassenger() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_staticAtribTicketNoPassenger/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var studentPassengerClass = getClassFromClassDiagram("Passenger", studentClassDiagram);

    var instructorTicketNoAttribute = getAttributeFromClass("ticketNo", instructorPassengerClass);
    var studentTicketNoAttribute = getAttributeFromClass("ticketNo", studentPassengerClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_NOT_BE_STATIC, studentTicketNoAttribute,
        instructorTicketNoAttribute, 0, 1, false);
  }

  /**
   * Test to detect static code Attribute.
   */
  @Test
  public void testMistakeAttributeStaticInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_AirportSystem_static/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_notStaticAtribCodeAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);

    var instructorCodeAttribute = getAttributeFromClass("code", instructorAirportClass);
    var studentCodeAttribute = getAttributeFromClass("code", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_BE_STATIC, studentCodeAttribute,
        instructorCodeAttribute, 0, 1, false);
  }

  /**
   * Test to detect not static company Attribute.
   */
  @Test
  public void testMistakeAttributeStaticInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_AirportSystem_static/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_notStaticAtribCompanyAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var instructorCompanyAttribute = getAttributeFromClass("company", instructorAirplaneClass);
    var studentCompanyAttribute = getAttributeFromClass("company", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_BE_STATIC, studentCompanyAttribute,
        instructorCompanyAttribute, 0, 1, false);
  }

  /**
   * Test to detect not static flightNo Attribute.
   */
  @Test
  public void testMistakeAttributeStaticFlightNoInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_AirportSystem_static/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_notStaticAtribFlightNoAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var instructorFlightNoAttribute = getAttributeFromClass("flightNo", instructorAirplaneClass);
    var studentFlightNoAttribute = getAttributeFromClass("flightNo", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_BE_STATIC, studentFlightNoAttribute,
        instructorFlightNoAttribute, 0, 1, false);
  }

  /**
   * Test to detect not static city Attribute.
   */
  @Test
  public void testMistakeAttributeStaticInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_AirportSystem_static/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_notStaticAtribNameCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);

    var instructorNameAttribute = getAttributeFromClass("name", instructorCityClass);
    var studentNameAttribute = getAttributeFromClass("name", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_BE_STATIC, studentNameAttribute,
        instructorNameAttribute, 0, 1, false);
  }

  /**
   * Test to detect not static Pilot Attribute.
   */
  @Test
  public void testMistakeAttributeStaticInPilot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_AirportSystem_static/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_notStaticAtribNamePilot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    var studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);

    var instructorNameAttribute = getAttributeFromClass("name", instructorPilotClass);
    var studentNameAttribute = getAttributeFromClass("name", studentPilotClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_BE_STATIC, studentNameAttribute,
        instructorNameAttribute, 0, 1, false);
  }

  /**
   * Test to not static ticketNo Attribute.
   */
  @Test
  public void testMistakeAttributeStaticInPassenger() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_AirportSystem_static/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_notStaticAtribTicketNoPassenger/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var studentPassengerClass = getClassFromClassDiagram("Passenger", studentClassDiagram);

    var instructorTicketNoAttribute = getAttributeFromClass("ticketNo", instructorPassengerClass);
    var studentTicketNoAttribute = getAttributeFromClass("ticketNo", studentPassengerClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_BE_STATIC, studentTicketNoAttribute,
        instructorTicketNoAttribute, 0, 1, false);
  }


  /**
   * Test to detect wrong Attribute name.
   */
  @Test
  public void testMistakeBadSpellingAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_car_typeAndColorAttribute/Class Diagram/Instructor_car_typeAndColorAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_wrongAttributeName1/Class Diagram/Student_wrongAttributeName1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);

    var instructorcolorAttribute = getAttributeFromClass("color", instructorCarClass);
    var studentcolerAttribute = getAttributeFromClass("coler", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ATTRIBUTE_NAME_SPELLING, studentcolerAttribute,
        instructorcolorAttribute, 0, 1, false);
  }

  /**
   * Test to detect wrong Attribute name.
   */
  @Test
  public void testMistakeSpellingAttributeInStudentSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_car_priceAttribute/Class Diagram/Instructor_car_priceAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_wrongAttributeName2/Class Diagram/Student_wrongAttributeName2.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);

    var instructorpriceAttribute = getAttributeFromClass("price", instructorCarClass);
    var studentpriseAttribute = getAttributeFromClass("prise", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ATTRIBUTE_NAME_SPELLING, studentpriseAttribute,
        instructorpriceAttribute, 0, 1, false);
  }

  /**
   * Test to detect wrong Attribute name in Airport.
   */
  @Test
  public void testMistakeSpellingAttributeInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_wrongAtribCodeAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);

    var instructorCodeAttribute = getAttributeFromClass("code", instructorAirportClass);
    var studentCodeAttribute = getAttributeFromClass("codee", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ATTRIBUTE_NAME_SPELLING, studentCodeAttribute,
        instructorCodeAttribute, 0, 1, false);
  }

  /**
   * Test to detect wrong Attribute name in Airplane.
   */
  @Test
  public void testMistakeSpellingAttributeInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_wrongAtribCompanyAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var instructorCompanyAttribute = getAttributeFromClass("company", instructorAirplaneClass);
    var studentComponyAttribute = getAttributeFromClass("compony", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ATTRIBUTE_NAME_SPELLING, studentComponyAttribute,
        instructorCompanyAttribute, 0, 1, false);
  }

  /**
   * Test to detect wrong Attribute name in Airplane.
   */
  @Test
  public void testMistakeSpellingFlightNoAttributeInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_wrongAtribFlightNoAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);

    var instructorFlightNoAttribute = getAttributeFromClass("flightNo", instructorAirplaneClass);
    var studentFlightNumberAttribute = getAttributeFromClass("flightNunber", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ATTRIBUTE_NAME_SPELLING, studentFlightNumberAttribute,
        instructorFlightNoAttribute, 0, 1, false);
  }

  /**
   * Test to detect wrong Attribute name in City.
   */
  @Test
  public void testMistakeSpellingAttributeInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_wrongAtribNameCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);

    var instructorNameAttribute = getAttributeFromClass("name", instructorCityClass);
    var studentNamAttribute = getAttributeFromClass("nam", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ATTRIBUTE_NAME_SPELLING, studentNamAttribute,
        instructorNameAttribute, 0, 1, false);
  }

  /**
   * Test to detect wrong Attribute name in Pilot.
   */
  @Test
  public void testMistakeSpellingAttributeInPilot() {
    var instructorSol = instructorSolutionFromClassDiagram(cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm"));

    var studentSol = studentSolutionFromClassDiagram(cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_wrongAtribNamePilot/Class Diagram/Student_AirportSystem.domain_model.cdm"));

    var comparison = MistakeDetection.compare(instructorSol, studentSol, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSol.getMistakes().size());

    assertMistake(instructorSol, studentSol, 0, BAD_ATTRIBUTE_NAME_SPELLING, "Pilot", "name", "nam", 0, 1, false);
  }

  /**
   * Test to detect wrong Attribute name in Passenger.
   */
  @Test
  public void testMistakeSpellingAttributeInPassenger() {
    var instructorSolution = instructorSolutionFromClassDiagram(cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm"));

    var studentSolution = studentSolutionFromClassDiagram(cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_AirportSystem_wrongAtribTicketNoPassenger/Class Diagram/Student_AirportSystem.domain_model.cdm"));

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake().fromSolutions(instructorSolution, studentSolution)
        .withInstructorAttributeName("Passenger", "ticketNo")
        .withStudentAttributeName("Passenger", "ticketNumber")
        .hasType(BAD_ATTRIBUTE_NAME_SPELLING)
        .hasNumSinceResolved(0)
        .hasNumDetections(1)
        .isUnresolved();

    // same assertion as above, written in less lines
    assertMistake().fromSolutions(instructorSolution, studentSolution)
        .withInstructorAttributeName("Passenger", "ticketNo").withStudentAttributeName("Passenger", "ticketNumber")
        .hasType(BAD_ATTRIBUTE_NAME_SPELLING).has(0).numSinceResolved().has(1).numDetections().and().isUnresolved();
  }

  /**
   * Test to detect misplaced Attribute.
   */
  @Test
  public void testMistakeMisplacedAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_carAndBus_capacityAttribute/Class Diagram/Instructor_carAndBus_capacityAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_misplacedAttribute/Class Diagram/Student_misplacedAttribute.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);

    var instructorcapacityAttribute = getAttributeFromClass("capacity", instructorBusClass);
    var studentcapacityAttribute = getAttributeFromClass("capacity", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_MISPLACED, studentcapacityAttribute,
        instructorcapacityAttribute, 0, 1, false);
  }

  /**
   * Test to detect misplaced Attribute.
   */
  @Test
  public void testMistakeMisplacedAttributeInStudentSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/insructor_orderAndProduct_typeAttribute/Class Diagram/Insructor_orderAndProduct_typeAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_misplacedAttribute1/Class Diagram/Student_misplacedAttribute1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorProductClass = getClassFromClassDiagram("Product", instructorClassDiagram);
    var studentOrderClass = getClassFromClassDiagram("Order", studentClassDiagram);

    var instructortypeAttribute = getAttributeFromClass("type", instructorProductClass);
    var studenttypeAttribute = getAttributeFromClass("type", studentOrderClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_MISPLACED, studenttypeAttribute,
        instructortypeAttribute, 0, 1, false);
  }

  /**
   * Test to detect misplaced Attribute in generalization hierarchy.
   */
  @Test
  public void testMistakeMisplacedAttributeInGH() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_three_classes_misplaceAttrib/Class Diagram/Three_classes.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_three_classes_misplaceAttrib/Class Diagram/Three_classes.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());
    assertMistakeTypesContain(comparison.newMistakes, ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY);
  }

  /**
   * Test to detect Attribute not static.
   */
  @Test
  public void testMistakeShouldNotStaticAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_car_typeAndColorAttribute/Class Diagram/Instructor_car_typeAndColorAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_shouldNotBeStaticAttribute/Class Diagram/Student_shouldNotBeStaticAttribute.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);

    var instructortypeAttribute = getAttributeFromClass("type", instructorCarClass);
    var studenttypeAttribute = getAttributeFromClass("type", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_NOT_BE_STATIC, studenttypeAttribute,
        instructortypeAttribute, 0, 1, false);
  }

  /**
   * Test to detect wrong Attribute type.
   */
  @Test
  public void testMistakewrongtypeAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_ filght_destinationAttribute/Class Diagram/Instructor_ filght_destinationAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_wrongAttributeType/Class Diagram/Student_wrongAttributeType.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorFlightClass = getClassFromClassDiagram("Flight", instructorClassDiagram);
    var studentFlightClass = getClassFromClassDiagram("Flight", studentClassDiagram);

    var instructordestinationAttribute = getAttributeFromClass("destination", instructorFlightClass);
    var studentdestinationAttribute = getAttributeFromClass("destination", studentFlightClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ATTRIBUTE_TYPE, studentdestinationAttribute,
        instructordestinationAttribute, 0, 1, false);
  }

  /**
   * Test to detect should be static Attribute.
   */
  @Test
  public void testMistakeShouldBeStaticAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_student_addressAttribute/Class Diagram/Instructor_student_addressAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_shouldBeStaticAttribute/Class Diagram/Student_shouldBeStaticAttribute.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorSTUClass = getClassFromClassDiagram("Student", instructorClassDiagram);
    var studentSTUClass = getClassFromClassDiagram("Student", studentClassDiagram);

    var instructoraddAttribute = getAttributeFromClass("address", instructorSTUClass);
    var studentaddAttribute = getAttributeFromClass("address", studentSTUClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_BE_STATIC, studentaddAttribute,
        instructoraddAttribute, 0, 1, false);
  }

  /**
   * Test to detect Duplicate Attribute.
   */
  @Test
  public void testMistakeDuplicateAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_chocolate_whitechocolateAttribute/Class Diagram/Instructor_chocolate_whitechocolateAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_dublicatedAttribute/Class Diagram/Student_dublicatedAttribute.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());
    assertMistakeTypesContain(comparison.newMistakes, ATTRIBUTE_DUPLICATED);
  }

  /**
   * Test to detect Duplicate Attribute in Generalization Hierarchy.
   */
  @Test
  public void testMistakeDuplicateAttributeInGH() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_three_classes_duplicateAttrib/Class Diagram/Three_classes.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_three_classes_duplicateAttrib/Class Diagram/Three_classes.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());
    assertMistakeTypesContain(comparison.newMistakes, ATTRIBUTE_DUPLICATED);
  }

  /**
   * Test to detect Duplicate Attribute.
   */
  @Test
  public void testMistakeDuplicateAttributeInStudentSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_animalAndCat_nameAttribute/Class Diagram/Instructor_animalAndCat_nameAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_duplicateAttribute1/Class Diagram/Student_duplicateAttribute1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentCatClass = getClassFromClassDiagram("Cat", studentClassDiagram);

    var studentnameAttribute = getAttributeFromClass("name", studentCatClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_DUPLICATED, studentnameAttribute, 0, 1, false);
  }
}
