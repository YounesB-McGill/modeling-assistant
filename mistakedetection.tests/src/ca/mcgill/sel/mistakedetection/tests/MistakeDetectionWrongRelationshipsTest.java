package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ROLE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.INCOMPLETE_CONTAINMENT_TREE;
import static learningcorpus.mistaketypes.MistakeTypes.INFINITE_RECURSIVE_DEPENDENCY;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_EXTRA_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_WRONG_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.SIMILAR_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AN_ATTRIBUTE_INSTEAD_OF_AN_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ASSOCIATION_INSTEAD_OF_AGGREGATION_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_DIRECTED_ASSOCIATION_INSTEAD_OF_UNDIRECTED;
import static learningcorpus.mistaketypes.MistakeTypes.USING_UNDIRECTED_ASSOCIATION_INSTEAD_OF_DIRECTED;
import static modelingassistant.util.ClassDiagramUtils.getAssociationEndFromClass;
import static modelingassistant.util.ClassDiagramUtils.getAssociationsFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getAttributeFromClass;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;

public class MistakeDetectionWrongRelationshipsTest {

  /**
   * Test to check mapping of relationships (No Mistakes).
   */
  @Test
  public void testToCheckRelationshipMappings() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_bus_driver_associ/Class Diagram/Instructor_bus_driver_associ.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_bus_driver_associ/Class Diagram/Instructor_bus_driver_associ.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);
    var instructorAssociations =
        getAssociationsFromClassDiagram(instructorBusClass, instructorDriverClass, instructorClassDiagram);
    var instructorAssociation0 = instructorAssociations.get(0);
    var instructorAssociation1 = instructorAssociations.get(1);

    var studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    var studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);
    var studentAssociations = getAssociationsFromClassDiagram(studentBusClass, studentDriverClass, studentClassDiagram);
    var studentAssociation0 = studentAssociations.get(0);
    var studentAssociation1 = studentAssociations.get(1);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
    assertEquals(studentAssociation0, comparison.mappedAssociation.get(instructorAssociation0));
    assertEquals(studentAssociation1, comparison.mappedAssociation.get(instructorAssociation1));
  }

  /**
   * Test to check mapping of relationships .
   */
  @Test
  public void testToCheckRelationshipMapping() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_bus_driver_associ/Class Diagram/Instructor_bus_driver_associ.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_bus_driver_assoc/Class Diagram/Student_bus_driver_assoc.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);
    var instructorAssociations =getAssociationsFromClassDiagram(instructorBusClass, instructorDriverClass, instructorClassDiagram);
    var instructorAssociation0 = instructorAssociations.get(0);

    var studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    var studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);
    var studentAssociations = getAssociationsFromClassDiagram(studentBusClass, studentDriverClass, studentClassDiagram);
    var studentAssociation0 = studentAssociations.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(3, comparison.newMistakes.size());
    assertEquals(3, studentSolution.getMistakes().size());
    assertEquals(studentAssociation0, comparison.mappedAssociation.get(instructorAssociation0));
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

    var instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    var instructorMyDriverAssociationEnd = getAssociationEndFromClass("myDriver", instructorBusClass);
    var studentMyDrivrAssociationEnd = getAssociationEndFromClass("myDrivr", studentBusClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(1,comparison.newMistakes.size());
    assertEquals(1,studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentMyDrivrAssociationEnd, instructorMyDriverAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check mistake of using Attribute instead of an association.
   */
  @Disabled("Not implemented yet.")
  @Test
  public void testMistakeAttributeInsteadOfAnAssociation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_busAndDriverClass/Class Diagram/Instructor_busAndDriverClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_attributeInsteadOfAssociation/Class Diagram/Student_attributeInsteadOfAssociation.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

    var studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);

    var instructorBusToDriverAssociation = getAssociationsFromClassDiagram(instructorDriverClass, instructorBusClass, instructorClassDiagram);
    var studentdriverAttribute = getAttributeFromClass("driver", studentBusClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_AN_ATTRIBUTE_INSTEAD_OF_AN_ASSOCIATION, studentdriverAttribute, instructorBusToDriverAssociation.get(0), 0, 1, false);
    }

  /**
   * Test to check mistake of using Attribute instead of an association. //not implemented yet
   */
  @Disabled("Not implemented yet.")
  @Test
  public void testMistakeAttributeInsteadOfAnAssociationInStudentSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_pilotAndFlightClass/Class Diagram/Instructor_pilotAndFlightClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_attributeInsteadOfAssociation1/Class Diagram/Student_attributeInsteadOfAssociation1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPilotClass = getClassFromClassDiagram("Pilot", instructorClassDiagram);
    var instructorFlightClass = getClassFromClassDiagram("Flight", instructorClassDiagram);

    var studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);

    var instructorPilotandFlightAssociation = getAssociationsFromClassDiagram(instructorPilotClass, instructorFlightClass, instructorClassDiagram);
    var studentflightAttribute = getAttributeFromClass("flight", studentPilotClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_AN_ATTRIBUTE_INSTEAD_OF_AN_ASSOCIATION, studentflightAttribute,
          instructorPilotandFlightAssociation.get(0), 0, 1, false);
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

    var instructorCompanyToEmployeeAssociation = getAssociationsFromClassDiagram(instructorCompanyClass, instructorEmployeeClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_COMPOSITION, instructorCompanyToEmployeeAssociation.get(0), 0, 1, false);
  }

  /**
   * Test to check Missing composition.
   */
  @Test
  public void testMistakeMissingCompositionInStudentSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_bookAndchapterClass/Class Diagram/Instructor_bookAndchapterClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_missingComposition1/Class Diagram/Student_missingComposition1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorBookClass = getClassFromClassDiagram("Book", instructorClassDiagram);
    var instructorChapterClass = getClassFromClassDiagram("Chapter", instructorClassDiagram);

    var instructorBookToChapterAssociation = getAssociationsFromClassDiagram(instructorBookClass, instructorChapterClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_COMPOSITION, instructorBookToChapterAssociation.get(0), 0, 1, false);
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

    var instructorTeamToPlayerAssociation = getAssociationsFromClassDiagram(instructorTeamClass, instructorPlayerClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_AGGREGATION, instructorTeamToPlayerAssociation.get(0), 0, 1, false);
  }

  /**
   * Test to check Missing Aggregation.
   */
  @Test
  public void testMistakeMissingAggregationInStudentSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndEngineClass/Class Diagram/Instructor_carAndEngineClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_missingAggregation1/Class Diagram/Student_missingAggregation1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var instructorEngineClass = getClassFromClassDiagram("Engine", instructorClassDiagram);

    var instructorCarToEngineAssociation = getAssociationsFromClassDiagram(instructorCarClass, instructorEngineClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_AGGREGATION, instructorCarToEngineAssociation.get(0), 0, 1, false);
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

    var instructorCarToOwnerAssociation = getAssociationsFromClassDiagram(instructorCarClass, instructorOwnerClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ASSOCIATION, instructorCarToOwnerAssociation.get(0), 0, 1, false);
  }

  /**
   * Test to check mistake of missing association.
   */
  @Test
  public void testMistakeMissingAssociationInStudentSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_passengerAndAirplanClass/Class Diagram/Instructor_passengerAndAirplanClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_missingAssociation1/Class Diagram/Student_missingAssociation1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var instructorAirplanClass = getClassFromClassDiagram("Airplan", instructorClassDiagram);

    var instructorPassengerToAirplanAssociation = getAssociationsFromClassDiagram(instructorPassengerClass, instructorAirplanClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ASSOCIATION, instructorPassengerToAirplanAssociation.get(0), 0, 1, false);
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

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);
    var instructorMyEmployeeAssociationEnd =getAssociationEndFromClass("myEmployee", instructorCompanyClass);
    var studentMyEmployeeAssociationEnd = getAssociationEndFromClass("myEmployee", studentCompanyClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_ASSOCIATION_INSTEAD_OF_AGGREGATION_COMPOSITION, studentMyEmployeeAssociationEnd, instructorMyEmployeeAssociationEnd, 0, 1, false);
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

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    var instructorMyEngineAssociationEnd = getAssociationEndFromClass("myEngine", instructorCarClass);
    var studentMyEngineAssociationEnd = getAssociationEndFromClass("myEngine", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_ASSOCIATION_INSTEAD_OF_AGGREGATION_COMPOSITION, studentMyEngineAssociationEnd, instructorMyEngineAssociationEnd, 0, 1, false);
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

    var instructorTeamClass = getClassFromClassDiagram("Team", instructorClassDiagram);
    var studentTeamClass = getClassFromClassDiagram("Team", studentClassDiagram);
    var instructorMyPlayerAssociationEnd = getAssociationEndFromClass("myPlayer", instructorTeamClass);
    var studentMyPlayerAssociationEnd = getAssociationEndFromClass("myPlayer", studentTeamClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_COMPOSITION_INSTEAD_OF_AGGREGATION, studentMyPlayerAssociationEnd, instructorMyPlayerAssociationEnd, 0, 1, false);
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

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);
    var instructorMyEmployeeAssociationEnd = getAssociationEndFromClass("myEmployee", instructorCompanyClass);
    var studentMyEmployeeAssociationEnd = getAssociationEndFromClass("myEmployee", studentCompanyClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_AGGREGATION_INSTEAD_OF_COMPOSITION, studentMyEmployeeAssociationEnd, instructorMyEmployeeAssociationEnd, 0, 1, false);
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

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    var instructorOwnerAssociationEnd = getAssociationEndFromClass("Owner", instructorCarClass);
    var studentOwnerAssociationEnd = getAssociationEndFromClass("Owner", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION, studentOwnerAssociationEnd, instructorOwnerAssociationEnd, 0, 1, false);
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

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    var instructorMyOwnerAssociationEnd = getAssociationEndFromClass("Owner", instructorCarClass);
    var studentCarOwnerAssociationEnd = getAssociationEndFromClass("CarOwner", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), OTHER_WRONG_ROLE_NAME, studentCarOwnerAssociationEnd, instructorMyOwnerAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check present but incorrect role name.
   */
  @Test
  public void testMistakePresentButIncorrectRoleNameInStudentSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_passengerAndAirplanClass/Class Diagram/Instructor_passengerAndAirplanClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_incorrectRoleName1/Class Diagram/Student_incorrectRoleName1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplanClass = getClassFromClassDiagram("Airplan", instructorClassDiagram);
    var studentAirplanClass = getClassFromClassDiagram("Airplan", studentClassDiagram);
    var instructorMyPassengerAssociationEnd = getAssociationEndFromClass("myPassenger", instructorAirplanClass);
    var studentPeopleAssociationEnd = getAssociationEndFromClass("People", studentAirplanClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), OTHER_WRONG_ROLE_NAME, studentPeopleAssociationEnd, instructorMyPassengerAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeIncorrectRoleNameInStudentSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndEngineClass/Class Diagram/Instructor_carAndEngineClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_badRoleNameSpelling/Class Diagram/Student_badRoleNameSpelling.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    var instructormyEngineAssociationEnd = getAssociationEndFromClass("myEngine", instructorCarClass);
    var studentmyengineAssociationEnd = getAssociationEndFromClass("myengine", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentmyengineAssociationEnd, instructormyEngineAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeOtherIncorrectRoleName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_companyAndEmployeeClass/Class Diagram/Instructor_companyAndEmployeeClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_badRoleNameSpelling1/Class Diagram/Student_badRoleNameSpelling1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorEmployeeClass = getClassFromClassDiagram("Employee", instructorClassDiagram);
    var studentEmployeeClass = getClassFromClassDiagram("Employee", studentClassDiagram);
    var instructormyCompanyAssociationEnd = getAssociationEndFromClass("myCompany", instructorEmployeeClass);
    var studentmyCompaneyAssociationEnd = getAssociationEndFromClass("myCompaney", studentEmployeeClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentmyCompaneyAssociationEnd, instructormyCompanyAssociationEnd, 0, 1, false);
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

    var instructorTeamClass = getClassFromClassDiagram("Team", instructorClassDiagram);
    var studentTeamClass = getClassFromClassDiagram("Team", studentClassDiagram);
    var instructorMyPlayerAssociationEnd = getAssociationEndFromClass("myPlayer", instructorTeamClass);
    var studentMyPlayerAssociationEnd = getAssociationEndFromClass("myPlayer", studentTeamClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentMyPlayerAssociationEnd, instructorMyPlayerAssociationEnd, 0, 1, false);
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

    var instructorOrderClass = getClassFromClassDiagram("Order", instructorClassDiagram);
    var studentOrderClass = getClassFromClassDiagram("Order", studentClassDiagram);
    var instructorMyCustomerAssociationEnd = getAssociationEndFromClass("myCustomer", instructorOrderClass);
    var studentMyCustomerAssociationEnd = getAssociationEndFromClass("myCustomer", studentOrderClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentMyCustomerAssociationEnd, instructorMyCustomerAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check similar role name.
   */
  @Disabled("Not implemented yet.")
  @Test
  public void testMistakesimilarRoleName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_passengerAndAirplanClass/Class Diagram/Instructor_passengerAndAirplanClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_similarRoleName/Class Diagram/Student_similarRoleName.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplanClass = getClassFromClassDiagram("Airplan", instructorClassDiagram);
    var studentAirplanClass = getClassFromClassDiagram("Airplan", studentClassDiagram);
    var instructorMyPassengerAssociationEnd = getAssociationEndFromClass("myPassenger", instructorAirplanClass);
    var studentTravellerAssociationEnd = getAssociationEndFromClass("myTraveller", studentAirplanClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), SIMILAR_ROLE_NAME, studentTravellerAssociationEnd, instructorMyPassengerAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check similar role name spelling.
   */
  @Disabled("Not implemented yet.")
  @Test
  public void testMistakesimilarRoleNameInStudentSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndEngineClass/Class Diagram/Instructor_carAndEngineClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_similarRoleName1/Class Diagram/Student_similarRoleName1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    var instructorMyEngineAssociationEnd = getAssociationEndFromClass("myEngine", instructorCarClass);
    var studentMyMotorAssociationEnd = getAssociationEndFromClass("myMotor", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), SIMILAR_ROLE_NAME, studentMyMotorAssociationEnd, instructorMyEngineAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check directed association.
   */
  @Disabled("Not implemented yet.")
  @Test
  public void testMistakeUsingDirectedAssociation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_companyAndOfficeClass/Class Diagram/Instructor_companyAndOfficeClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_usingDirectedAssociation/Class Diagram/Student_usingDirectedAssociation.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCompanyClass = getClassFromClassDiagram("Company", instructorClassDiagram);
    var studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);
    var instructorMyOfficeAssociationEnd = getAssociationEndFromClass("myOffice", instructorCompanyClass);
    var studentMyOfficeAssociationEnd = getAssociationEndFromClass("myOffice", studentCompanyClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_DIRECTED_ASSOCIATION_INSTEAD_OF_UNDIRECTED, studentMyOfficeAssociationEnd, instructorMyOfficeAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check undirected association.
   */
  @Disabled("Not implemented yet.")
  @Test
  public void testMistakeUsingUnDirectedAssociation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndWheelClass/Class Diagram/Instructor_carAndWheelClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_usingUndirectedAssociation/Class Diagram/Student_usingUndirectedAssociation.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    var instructorMyWheelAssociationEnd = getAssociationEndFromClass("myWheel", instructorCarClass);
    var studentMyWheelAssociationEnd = getAssociationEndFromClass("myWheel", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_UNDIRECTED_ASSOCIATION_INSTEAD_OF_DIRECTED, studentMyWheelAssociationEnd, instructorMyWheelAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check extra association.
   */
  @Test
  public void testMistakeExtraAssociation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndOwnerClass/Class Diagram/Instructor_carAndOwnerClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_extraAssociation/Class Diagram/Student_extraAssociation.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentOwnerClass = getClassFromClassDiagram("Owner", studentClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);

    var studentCarToOwnerAssociation = getAssociationsFromClassDiagram(studentOwnerClass, studentCarClass, studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), OTHER_EXTRA_ASSOCIATION, studentCarToOwnerAssociation.get(1), 0, 1, false);
  }

  /**
   * Test to check incomplete containment tree.
   */
  @Disabled("Not implemented yet.")
  @Test
  public void testMistakeIncompleteContainmentTreeBankAndAccountExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_bankAndAccountClass/Class Diagram/Instructor_bankAndAccountClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_incompleteContainmentTree/Class Diagram/Student_incompleteContainmentTree.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorBankClass = getClassFromClassDiagram("Bank", instructorClassDiagram);
    var instructorAccountClass = getClassFromClassDiagram("Account", instructorClassDiagram);

    var studentBankClass = getClassFromClassDiagram("Bank", studentClassDiagram);
    var studentAccountClass = getClassFromClassDiagram("Account", studentClassDiagram);

    var instructorBankToAccountAssociation = getAssociationsFromClassDiagram(instructorBankClass, instructorAccountClass, instructorClassDiagram);
    var studentBankToAccountAssociation = getAssociationsFromClassDiagram(studentBankClass, studentAccountClass, studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    // TODO Verify the solution elements that should be linked to this mistake
    assertMistake(studentSolution.getMistakes().get(0), INCOMPLETE_CONTAINMENT_TREE, studentBankToAccountAssociation.get(0), instructorBankToAccountAssociation.get(0), 0, 1, false);
   }

  /**
   * Test to check incomplete containment tree.
   */
  @Disabled("Not implemented yet.")
  @Test
  public void testMistakeIncompleteContainmentTreeCarAndWheelExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndWheelClass/Class Diagram/Instructor_carAndWheelClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_incompleteContainmentTree1/Class Diagram/Student_incompleteContainmentTree1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var instructorWheelClass = getClassFromClassDiagram("Wheel", instructorClassDiagram);

    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    var studentWheelClass = getClassFromClassDiagram("Wheel", studentClassDiagram);

    var instructorCarToWheelAssociation = getAssociationsFromClassDiagram(instructorCarClass, instructorWheelClass, instructorClassDiagram);
    var studentCarToWheelAssociation = getAssociationsFromClassDiagram(studentCarClass, studentWheelClass, studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    // TODO Verify the solution elements that should be linked to this mistake
    assertMistake(studentSolution.getMistakes().get(0), INCOMPLETE_CONTAINMENT_TREE, studentCarToWheelAssociation.get(0), instructorCarToWheelAssociation.get(0), 0, 1, false);
   }

  /**
   * Test to check infinite recursive dependency.
   */
  @Disabled("Not implemented yet. Matching association ends incorrectly.")
  @Test
  public void testMistakeInfiniteRecursiveDependency() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_personClass/Class Diagram/Instructor_personClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_infiniteRecursiveDependency/Class Diagram/Student_infiniteRecursiveDependency.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);


    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);
    var instructorChildAssociationEnd = getAssociationEndFromClass("Child", instructorPersonClass);
    var studentChildAssociationEnd = getAssociationEndFromClass("Child", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), INFINITE_RECURSIVE_DEPENDENCY, studentChildAssociationEnd, instructorChildAssociationEnd, 0, 1, false);
    }
  }
