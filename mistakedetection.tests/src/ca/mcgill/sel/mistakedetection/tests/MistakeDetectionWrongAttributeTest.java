package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistakeConditional;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAttributeFromClass;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getClassFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_EXTRA_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.SIMILAR_ATTRIBUTE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.Classifier;
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 0);
    assertEquals(studentSolution.getMistakes().size(), 0);
  }

  /**
   * Test to check for attributes Spelling Mistakes (nam,capacty,nme,noPlate)
   */
  @Test
  public void testAttributeWrongSpelling() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/Class Diagram/Two(withAttributes).domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/three(withAttributes)/Class Diagram/Three(withAttributes).domain_model.cdm");
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

    Attribute studentBusClassAttributeCapacty = getAttributeFromClass("capacty", studentBusClass);
    Attribute studentBusClassAttributeNamberPlate = getAttributeFromClass("namberPlate", studentBusClass);
    Attribute studentDriverClassAttributeNme = getAttributeFromClass("nme", studentDriverClass);
    Attribute studentPassengerClassAttributeNam = getAttributeFromClass("nam", studentPassengerClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 4);
    assertEquals(studentSolution.getMistakes().size(), 4);

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, BAD_ATTRIBUTE_NAME_SPELLING, studentBusClassAttributeCapacty,
          instructorBusClassAttributeCapacity, 0, 1, false);
      assertMistakeConditional(m, BAD_ATTRIBUTE_NAME_SPELLING, studentBusClassAttributeNamberPlate,
          instructorBusClassAttributeNumberPlate, 0, 1, false);
      assertMistakeConditional(m, BAD_ATTRIBUTE_NAME_SPELLING, studentDriverClassAttributeNme,
          instructorDriverClassAttributeName, 0, 1, false);
      assertMistakeConditional(m, BAD_ATTRIBUTE_NAME_SPELLING, studentPassengerClassAttributeNam,
          instructorPassengerClassAttributeName, 0, 1, false);
    }
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

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    Classifier instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

    Attribute instructorBusClassAttributeNumberPlate = getAttributeFromClass("numberPlate", instructorBusClass);
    Attribute instructorDriverClassAttributeName = getAttributeFromClass("name", instructorDriverClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 2);
    assertEquals(studentSolution.getMistakes().size(), 2);
    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, MISSING_ATTRIBUTE, instructorDriverClassAttributeName, 0, 1, false);
      assertMistakeConditional(m, MISSING_ATTRIBUTE, instructorBusClassAttributeNumberPlate, 0, 1, false);
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

    Classifier studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);

    Attribute studentDateOfBirthAttribute = getAttributeFromClass("dateOfBirth", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 1);
    assertEquals(studentSolution.getMistakes().size(), 1);

    assertMistake(studentSolution.getMistakes().get(0), OTHER_EXTRA_ATTRIBUTE, studentDateOfBirthAttribute, 0, 1,
        false);
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

    Classifier instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);

    Attribute instructorNameAttribute = getAttributeFromClass("name", instructorPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 1);
    assertEquals(studentSolution.getMistakes().size(), 1);

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ATTRIBUTE, instructorNameAttribute, 0, 1,
        false);
  }

  /**
   * Test to detect other extra Attribute.
   */
  @Test
  public void testMistakeExtraAttribute1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_pilot_genderAtterbute/Class Diagram/Instructor_pilot_genderAtterbute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_extraAtterbute1/Class Diagram/Student_extraAtterbute1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);

    Attribute studentnameAttribute = getAttributeFromClass("name", studentPilotClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 1);
    assertEquals(studentSolution.getMistakes().size(), 1);

    assertMistake(studentSolution.getMistakes().get(0), OTHER_EXTRA_ATTRIBUTE, studentnameAttribute, 0, 1,
        false);
  }

  /**
   * Test to detect other extra Attribute.
   */
  @Test
  public void testMistakeExtraAttribute2() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_car_priceAttribute/Class Diagram/Instructor_car_priceAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_extraAttribute2/Class Diagram/Student_extraAttribute2.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);

    Attribute studenttypeAttribute = getAttributeFromClass("type", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(comparison.newMistakes.size(), 1);
    assertEquals(studentSolution.getMistakes().size(), 1);

    assertMistake(studentSolution.getMistakes().get(0), OTHER_EXTRA_ATTRIBUTE, studenttypeAttribute, 0, 1,
        false);
  }

  /**
   * Test to detect wrong Attribute name.
   */
  @Disabled
  @Test
  public void testMistakepluralAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_person_nameAttribute/Class Diagram/Instructor_person_nameAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram); //cdm file was modified by prabhsimran pull request

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_wrongAttributeName/Class Diagram/Student_wrongAttributeName.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram); // cdm file named as wrong attribute but its test the plural mistake

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);

    Attribute instructornameAttribute = getAttributeFromClass("name", instructorPersonClass);
    Attribute studentnamesAttribute = getAttributeFromClass("names", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size(), 1);

    assertMistake(studentSolution.getMistakes().get(0), PLURAL_ATTRIBUTE, studentnamesAttribute, instructornameAttribute,  0, 1,
        false);
  }

  /**
   * Test to detect plural Attribute name.
   */
  @Disabled
  @Test
  public void testMistakepluralAttribute1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_ filght_destinationAttribute/Class Diagram/Instructor_ filght_destinationAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_pluralAttribute/Class Diagram/Student_pluralAttribute.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorFlightClass = getClassFromClassDiagram("Flight", instructorClassDiagram);
    var studentFlightClass = getClassFromClassDiagram("Flight", studentClassDiagram);

    Attribute instructornameAttribute = getAttributeFromClass("destination", instructorFlightClass);
    Attribute studentnamesAttribute = getAttributeFromClass("destinations", studentFlightClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), PLURAL_ATTRIBUTE, studentnamesAttribute, instructornameAttribute,  0, 1,
        false);
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

    Attribute instructorcolorAttribute = getAttributeFromClass("color", instructorCarClass);
    Attribute studentcolerAttribute = getAttributeFromClass("coler", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ATTRIBUTE_NAME_SPELLING, studentcolerAttribute, instructorcolorAttribute,  0, 1,
        false);
  }

  /**
   * Test to detect wrong Attribute name.
   */
  @Test
  public void testMistakeSpellingAttribute1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_car_priceAttribute/Class Diagram/Instructor_car_priceAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_wrongAttributeName2/Class Diagram/Student_wrongAttributeName2.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);

    Attribute instructorpriceAttribute = getAttributeFromClass("price", instructorCarClass);
    Attribute studentpriseAttribute = getAttributeFromClass("prise", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ATTRIBUTE_NAME_SPELLING, studentpriseAttribute, instructorpriceAttribute,  0, 1,
        false);
  }

  /**
   * Test to detect similar Attribute.
   */
  @Disabled
  @Test
  public void testMistakeSimilarAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_car_typeAndColorAttribute/Class Diagram/Instructor_car_typeAndColorAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_similarAttribute/Class Diagram/Student_similarAttribute.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);

    Attribute instructortypeAttribute = getAttributeFromClass("type", instructorCarClass);
    Attribute studentkindAttribute = getAttributeFromClass("kind", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), SIMILAR_ATTRIBUTE_NAME, studentkindAttribute, instructortypeAttribute,  0, 1,
        false);
  }

  /**
   * Test to detect similar Attribute.
   */
  @Disabled
  @Test
  public void testMistakeSimilarAttribute1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_car_priceAttribute/Class Diagram/Instructor_car_priceAttribute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_similarAttribute1/Class Diagram/Student_similarAttribute1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);

    Attribute instructorpriceAttribute = getAttributeFromClass("price", instructorCarClass);
    Attribute studentcostAttribute = getAttributeFromClass("cost", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), SIMILAR_ATTRIBUTE_NAME, studentcostAttribute, instructorpriceAttribute,  0, 1,
        false);
  }

  /**
   * Test to detect similar Attribute.
   */
  @Disabled
  @Test
  public void testMistakeSimilarAttribute2() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_pilot_genderAtterbute/Class Diagram/Instructor_pilot_genderAtterbute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_similarAttribute2/Class Diagram/Student_similarAttribute2.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    var studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);

    Attribute instructorgenderAttribute = getAttributeFromClass("gender", instructorPilotClass);
    Attribute studentGenderAttribute = getAttributeFromClass("Gender", studentPilotClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), SIMILAR_ATTRIBUTE_NAME, studentGenderAttribute, instructorgenderAttribute,  0, 1,
        false);
  }

  /**
   * Test to detect  misplaced Attribute.
   */
  @Disabled
  @Test
  public void testMistakeMisplacedAttribute() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestAttribute/instructor_pilot_genderAtterbute/Class Diagram/Instructor_pilot_genderAtterbute.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestAttribute/student_similarAttribute2/Class Diagram/Student_similarAttribute2.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    //var instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);

    //Attribute instructorcapacityAttribute = getAttributeFromClass("capacity", instructorBusClass);
    var studentcapacityAttribute = getAttributeFromClass("capacity", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

   //TODO assertMistake(studentSolution.getMistakes().get(0), , studentcapacityAttribute, 0, 1, false);
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

    Attribute instructortypeAttribute = getAttributeFromClass("type", instructorCarClass);
    Attribute studenttypeAttribute = getAttributeFromClass("type", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_NOT_BE_STATIC, studenttypeAttribute, instructortypeAttribute,  0, 1,
        false);
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

    Attribute instructordestinationAttribute = getAttributeFromClass("destination", instructorFlightClass);
    Attribute studentdestinationAttribute = getAttributeFromClass("destination", studentFlightClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ATTRIBUTE_TYPE, studentdestinationAttribute, instructordestinationAttribute,  0, 1,
        false);
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

    Attribute instructoraddressAttribute = getAttributeFromClass("address", instructorSTUClass);
    Attribute studentaddressAttribute = getAttributeFromClass("address", studentSTUClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ATTRIBUTE_SHOULD_BE_STATIC, studentaddressAttribute, instructoraddressAttribute,  0, 1,
        false);
  }
}
