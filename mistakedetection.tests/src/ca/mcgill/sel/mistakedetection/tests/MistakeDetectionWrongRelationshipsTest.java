package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAssociationEndFromClass;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAssociationFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAttributeFromClass;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getClassFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ROLE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_WRONG_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.SIMILAR_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AN_ATTRIBUTE_INSTEAD_OF_AN_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ASSOCIATION_INSTEAD_OF_AGGREGATION_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_AGGREGATION;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import modelingassistant.Mistake;

public class MistakeDetectionWrongRelationshipsTest {

  /**
   * Test to check mapping of relationships (No Mistakes).
   */
  @Test
  public void testToCheckRelationshipMapping() {
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
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeIncorrectRoleName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/One/Class Diagram/InstructorSolution.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution-b.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    Classifier studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    AssociationEnd instructorMyDriverAssociationEnd = getAssociationEndFromClass("myDriver", instructorBusClass);
    AssociationEnd studentMyDrivrAssociationEnd = getAssociationEndFromClass("myDrivr", studentBusClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(comparison.newMistakes.size(), 1);
    assertEquals(studentSolution.getMistakes().size(), 1);

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, BAD_ROLE_NAME_SPELLING, studentMyDrivrAssociationEnd, instructorMyDriverAssociationEnd, 0, 1,
          false);
    }
  }

  /**
   * Test to check mistake of using Attribute instead of an association.
   */
  @Disabled
  @Test
  public void testMistakeAttributeInsteadOfAnAssociation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_busAndDriverClass/Class Diagram/Instructor_busAndDriverClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_attributeInsteadOfAssociation/Class Diagram/Student_attributeInsteadOfAssociation.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var     instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var     instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

    var     studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);

    Association instructorBusandDriverAssociation = getAssociationFromClassDiagram(instructorDriverClass , instructorBusClass,instructorClassDiagram);
    Attribute studentdriverAttribute = getAttributeFromClass("driver", studentBusClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, USING_AN_ATTRIBUTE_INSTEAD_OF_AN_ASSOCIATION, studentdriverAttribute, instructorBusandDriverAssociation, 0, 1,
          false);
  }
  }

  /**
   * Test to check mistake of using Attribute instead of an association.
   */
  @Disabled
  @Test
  public void testMistakeAttributeInsteadOfAnAssociation1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_pilotAndFlightClass/Class Diagram/Instructor_pilotAndFlightClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_attributeInsteadOfAssociation1/Class Diagram/Student_attributeInsteadOfAssociation1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    var instructorFlightClass = getClassFromClassDiagram("Flight", instructorClassDiagram);

    var studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);

    Association instructorPilotandFlightAssociation = getAssociationFromClassDiagram(instructorPilotClass , instructorFlightClass,instructorClassDiagram);
    Attribute studentflightAttribute = getAttributeFromClass("flight", studentPilotClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, USING_AN_ATTRIBUTE_INSTEAD_OF_AN_ASSOCIATION, studentflightAttribute, instructorPilotandFlightAssociation, 0, 1,
          false);
  }
  }

  /**
   * Test to check Missing composition.
   */
  @Test
  public void testMistakeMissingComposition() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_companyAndEmployeeClass/Class Diagram/Instructor_companyAndEmployeeClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_missingComposition/Class Diagram/Student_missingComposition.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var instructorEmployeeClass = getClassFromClassDiagram("Employee", instructorClassDiagram);

    Association instructorCompanyandEmployeeAssociation = getAssociationFromClassDiagram(instructorCompanyClass , instructorEmployeeClass,instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, MISSING_COMPOSITION,instructorCompanyandEmployeeAssociation, 0, 1,
          false);
    }
  }

  /**
   * Test to check Missing composition.
   //error class book is matched with root
   */
  @Disabled
  @Test
  public void testMistakeMissingComposition1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_bookAndchapterClass/Class Diagram/Instructor_bookAndchapterClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_missingComposition1/Class Diagram/Student_missingComposition1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorBookClass = getClassFromClassDiagram("Book", instructorClassDiagram);
    var instructorChapterClass = getClassFromClassDiagram("Chapter", instructorClassDiagram);

    Association instructorBookandChapterAssociation = getAssociationFromClassDiagram(instructorBookClass , instructorChapterClass,instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    MistakeDetectionTest.log(comparison);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, MISSING_COMPOSITION, instructorBookandChapterAssociation, 0, 1,
          false);
    }
  }

  /**
   * Test to check Missing Aggregation.
   */
  @Test
  public void testMistakeMissingAggregation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_teamAndPlayerClass/Class Diagram/Instructor_teamAndPlayerClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_missingAggregation/Class Diagram/Student_missingAggregation.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorTeamClass = getClassFromClassDiagram("Team", instructorClassDiagram);
    var instructorPlayerClass = getClassFromClassDiagram("Player", instructorClassDiagram);

    Association instructorTeamandPlayerAssociation = getAssociationFromClassDiagram(instructorTeamClass , instructorPlayerClass,instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, MISSING_AGGREGATION, instructorTeamandPlayerAssociation, 0, 1,
          false);
    }
  }

  /**
   * Test to check Missing Aggregation.
   */
  @Test
  public void testMistakeMissingAggregation1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndEngineClass/Class Diagram/Instructor_carAndEngineClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_missingAggregation1/Class Diagram/Student_missingAggregation1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var instructorEngineClass = getClassFromClassDiagram("Engine", instructorClassDiagram);

    Association instructorCarandEngineAssociation = getAssociationFromClassDiagram(instructorCarClass , instructorEngineClass,instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, MISSING_AGGREGATION, instructorCarandEngineAssociation, 0, 1,
          false);
    }
  }

  /**
   * Test to check mistake of missing association.
   */
  @Test
  public void testMistakeMissingAssociation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndOwnerClass/Class Diagram/Instructor_carAndOwnerClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_missingAssociation/Class Diagram/Student_missingAssociation.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var instructorOwnerClass = getClassFromClassDiagram("Owner", instructorClassDiagram);

    Association instructorCarandOwnerAssociation = getAssociationFromClassDiagram(instructorCarClass , instructorOwnerClass,instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, MISSING_ASSOCIATION, instructorCarandOwnerAssociation, 0, 1,
          false);
  }
  }

  /**
   * Test to check mistake of missing association.
   */
  @Test
  public void testMistakeMissingAssociation1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_passengerAndAirplanClass/Class Diagram/Instructor_passengerAndAirplanClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_missingAssociation1/Class Diagram/Student_missingAssociation1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var instructorAirplanClass = getClassFromClassDiagram("Airplan", instructorClassDiagram);

    Association instructorPassengerandAirplanAssociation = getAssociationFromClassDiagram(instructorPassengerClass , instructorAirplanClass,instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, MISSING_ASSOCIATION, instructorPassengerandAirplanAssociation, 0, 1,
          false);
  }
  }

  /**
   * Test to check mistake of using association instead of composition.
   */
  @Test
  public void testMistakeUsingAssociationInsteadOfComposition() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_companyAndEmployeeClass/Class Diagram/Instructor_companyAndEmployeeClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_usingAsInsteadOfCom/Class Diagram/Student_usingAsInsteadOfCom.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var  instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var  studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);
    AssociationEnd instructorMyEmployeeAssociationEnd = getAssociationEndFromClass("myEmployee", instructorCompanyClass);
    AssociationEnd studentMyEmployeeAssociationEnd = getAssociationEndFromClass("myEmployee", studentCompanyClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, USING_ASSOCIATION_INSTEAD_OF_AGGREGATION_COMPOSITION, studentMyEmployeeAssociationEnd, instructorMyEmployeeAssociationEnd, 0, 1,
          false);
  }
  }

  /**
   * Test to check mistake of using association instead of Aggregation.
   */
  @Test
  public void testMistakeUsingAssociationInsteadOfAggregation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndEngineClass/Class Diagram/Instructor_carAndEngineClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_usingAsInsteadOfAgg/Class Diagram/Student_usingAsInsteadOfAgg.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var  instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var  studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    AssociationEnd instructorMyEngineAssociationEnd = getAssociationEndFromClass("myEngine", instructorCarClass);
    AssociationEnd studentMyEngineAssociationEnd = getAssociationEndFromClass("myEngine", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, USING_ASSOCIATION_INSTEAD_OF_AGGREGATION_COMPOSITION,  studentMyEngineAssociationEnd, instructorMyEngineAssociationEnd, 0, 1,
          false);
  }
  }

  /**
   * Test to check mistake of using composition instead of Aggregation.
   */
  @Test
  public void testMistakeUsingCompositionInsteadOfAggregation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_teamAndPlayerClass/Class Diagram/Instructor_teamAndPlayerClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_usingComInsteadOfAgg/Class Diagram/Student_usingComInsteadOfAgg.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var  instructorTeamClass = getClassFromClassDiagram("Team", instructorClassDiagram);
    var  studentTeamClass = getClassFromClassDiagram("Team", studentClassDiagram);
    AssociationEnd instructorMyPlayerAssociationEnd = getAssociationEndFromClass("myPlayer", instructorTeamClass);
    AssociationEnd studentMyPlayerAssociationEnd = getAssociationEndFromClass("myPlayer", studentTeamClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, USING_COMPOSITION_INSTEAD_OF_AGGREGATION,  studentMyPlayerAssociationEnd, instructorMyPlayerAssociationEnd , 0, 1,
          false);
  }
  }

  /**
   * Test to check mistake of using aggregation instead of composition.
   */
  @Test
  public void testMistakeUsingAggregationInsteadOfComposition() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_companyAndEmployeeClass/Class Diagram/Instructor_companyAndEmployeeClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_usingAggInsteadOfCom/Class Diagram/Student_usingAggInsteadOfCom.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var  instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var  studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);
    AssociationEnd instructorMyEmployeeAssociationEnd = getAssociationEndFromClass("myEmployee", instructorCompanyClass);
    AssociationEnd studentMyEmployeeAssociationEnd = getAssociationEndFromClass("myEmployee", studentCompanyClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, USING_AGGREGATION_INSTEAD_OF_COMPOSITION, studentMyEmployeeAssociationEnd, instructorMyEmployeeAssociationEnd, 0, 1,
          false);
  }
  }

  /**
   * Test to check mistake of using composition instead of association.
   */
  @Test
  public void testMistakeUsingCompositionInsteadOfAssociation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndOwnerClass/Class Diagram/Instructor_carAndOwnerClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_UsingComInsteadOfAs/Class Diagram/Student_UsingComInsteadOfAs.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var  instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var  studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    AssociationEnd instructorMyOwnerAssociationEnd = getAssociationEndFromClass("myOwner", instructorCarClass);
    AssociationEnd studentMyOwnerAssociationEnd = getAssociationEndFromClass("myOwner", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION, studentMyOwnerAssociationEnd, instructorMyOwnerAssociationEnd, 0, 1,
          false);
  }
  }

  /**
   * Test to check present but incorrect role name.
   */
  @Test
  public void testMistakePresentButIncorrectRoleName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndOwnerClass/Class Diagram/Instructor_carAndOwnerClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_incorrectRoleName/Class Diagram/Student_incorrectRoleName.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    Classifier studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    AssociationEnd instructorMyOwnerAssociationEnd = getAssociationEndFromClass("myOwner", instructorCarClass);
    AssociationEnd studentCarOwnerAssociationEnd = getAssociationEndFromClass("CarOwner", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, OTHER_WRONG_ROLE_NAME, studentCarOwnerAssociationEnd, instructorMyOwnerAssociationEnd, 0, 1,
          false);
    }
  }

  /**
   * Test to check present but incorrect role name.
   */
  @Test
  public void testMistakePresentButIncorrectRoleName1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_passengerAndAirplanClass/Class Diagram/Instructor_passengerAndAirplanClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_incorrectRoleName1/Class Diagram/Student_incorrectRoleName1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorAirplanClass = getClassFromClassDiagram("Airplan", instructorClassDiagram);
    Classifier studentAirplanClass = getClassFromClassDiagram("Airplan", studentClassDiagram);
    AssociationEnd instructorMyPassengerAssociationEnd = getAssociationEndFromClass("myPassenger", instructorAirplanClass);
    AssociationEnd studentPeopleAssociationEnd = getAssociationEndFromClass("People", studentAirplanClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, OTHER_WRONG_ROLE_NAME, studentPeopleAssociationEnd, instructorMyPassengerAssociationEnd, 0, 1,
          false);
    }
  }
  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeIncorrectRoleName1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndEngineClass/Class Diagram/Instructor_carAndEngineClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_badRoleNameSpelling/Class Diagram/Student_badRoleNameSpelling.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    Classifier studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    AssociationEnd instructormyEngineAssociationEnd = getAssociationEndFromClass("myEngine", instructorCarClass);
    AssociationEnd studentmyengineAssociationEnd = getAssociationEndFromClass("myengine", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, BAD_ROLE_NAME_SPELLING, studentmyengineAssociationEnd, instructormyEngineAssociationEnd, 0, 1,
          false);
    }
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeIncorrectRoleName2() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_companyAndEmployeeClass/Class Diagram/Instructor_companyAndEmployeeClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_badRoleNameSpelling1/Class Diagram/Student_badRoleNameSpelling1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorEmployeeClass = getClassFromClassDiagram("Employee", instructorClassDiagram);
    Classifier studentEmployeeClass = getClassFromClassDiagram("Employee", studentClassDiagram);
    AssociationEnd instructormyCompanyAssociationEnd = getAssociationEndFromClass("myCompany", instructorEmployeeClass);
    AssociationEnd studentmyCompaneyAssociationEnd = getAssociationEndFromClass("myCompaney", studentEmployeeClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, BAD_ROLE_NAME_SPELLING, studentmyCompaneyAssociationEnd, instructormyCompanyAssociationEnd, 0, 1,
          false);
    }
  }

  /**
   * Test to check mistake Role name Should Not be static.
   */
  @Test
  public void testMistakeRoleNameShouldNotBeStatic() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_teamAndPlayerClass/Class Diagram/Instructor_teamAndPlayerClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_shouldNotBeStaticRoleName/Class Diagram/Student_shouldNotBeStaticRoleName.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var  instructorTeamClass = getClassFromClassDiagram("Team", instructorClassDiagram);
    var  studentTeamClass = getClassFromClassDiagram("Team", studentClassDiagram);
    AssociationEnd instructorMyPlayerAssociationEnd = getAssociationEndFromClass("myPlayer", instructorTeamClass);
    AssociationEnd studentMyPlayerAssociationEnd = getAssociationEndFromClass("myPlayer", studentTeamClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, ROLE_SHOULD_NOT_BE_STATIC,  studentMyPlayerAssociationEnd, instructorMyPlayerAssociationEnd , 0, 1,
          false);
  }
  }

  /**
   * Test to check mistake Role name Should be static.
   */
  @Test
  public void testMistakeRoleNameShouldBeStatic() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_customerAndOrderClass/Class Diagram/Instructor_customerAndOrderClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_shouldBeStaticRoleName/Class Diagram/Student_shouldBeStaticRoleName.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var  instructorOrderClass = getClassFromClassDiagram("Order", instructorClassDiagram);
    var  studentOrderClass = getClassFromClassDiagram("Order", studentClassDiagram);
    AssociationEnd instructormyCustomerAssociationEnd = getAssociationEndFromClass("myCustomer", instructorOrderClass);
    AssociationEnd studentmyCustomerAssociationEnd = getAssociationEndFromClass("myCustomer", studentOrderClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, ROLE_SHOULD_BE_STATIC,  studentmyCustomerAssociationEnd, instructormyCustomerAssociationEnd , 0, 1,
          false);
  }
  }

  /**
   * Test to check similar role name.
   //detecting as wrong role name
   */
  @Disabled
  @Test
  public void testMistakesimilarRoleName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_passengerAndAirplanClass/Class Diagram/Instructor_passengerAndAirplanClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_similarRoleName/Class Diagram/Student_similarRoleName.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorAirplanClass = getClassFromClassDiagram("Airplan", instructorClassDiagram);
    Classifier studentAirplanClass = getClassFromClassDiagram("Airplan", studentClassDiagram);
    AssociationEnd instructorMyPassengerAssociationEnd = getAssociationEndFromClass("myPassenger", instructorAirplanClass);
    AssociationEnd studentTravellerAssociationEnd = getAssociationEndFromClass("myTraveller", studentAirplanClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    MistakeDetectionTest.log(comparison);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, SIMILAR_ROLE_NAME, studentTravellerAssociationEnd, instructorMyPassengerAssociationEnd, 0, 1,
          false);
    }
  }

  /**
   * Test to check similar role name spelling.
   //detecting as wrong role name
   */
  @Disabled
  @Test
  public void testMistakesimilarRoleName1() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndEngineClass/Class Diagram/Instructor_carAndEngineClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_similarRoleName1/Class Diagram/Student_similarRoleName1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    Classifier instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    Classifier studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    AssociationEnd instructormyEngineAssociationEnd = getAssociationEndFromClass("myEngine", instructorCarClass);
    AssociationEnd studentmyMotorAssociationEnd = getAssociationEndFromClass("myMotor", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    MistakeDetectionTest.log(comparison);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistake(m, SIMILAR_ROLE_NAME, studentmyMotorAssociationEnd, instructormyEngineAssociationEnd, 0, 1,
          false);
    }
  }

}
