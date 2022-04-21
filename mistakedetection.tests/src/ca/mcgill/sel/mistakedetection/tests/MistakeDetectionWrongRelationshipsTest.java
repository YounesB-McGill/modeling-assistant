package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.MistakeDetection.getAssociationElements;
import static ca.mcgill.sel.mistakedetection.MistakeDetection.getMistakeForElement;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistake;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistakeTypesContain;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistakeTypesDoNotContain;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_CLASS_SHOULD_BE_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ASSOC_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ROLE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.INCOMPLETE_CONTAINMENT_TREE;
import static learningcorpus.mistaketypes.MistakeTypes.INFINITE_RECURSIVE_DEPENDENCY;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.REPRESENTING_ACTION_WITH_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.REVERSED_RELATIONSHIP_DIRECTION;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ASSOC_INSTEAD_OF_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ASSOC_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ATTRIBUTE_INSTEAD_OF_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED;
import static learningcorpus.mistaketypes.MistakeTypes.USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ROLE_NAME;
import static modelingassistant.util.ClassDiagramUtils.getAssocAggCompFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getAssociationEndFromClass;
import static modelingassistant.util.ClassDiagramUtils.getAttributeFromClass;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
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
        getAssocAggCompFromClassDiagram(instructorBusClass, instructorDriverClass, instructorClassDiagram);
    var instructorAssociation0 = instructorAssociations.get(0);
    var instructorAssociation1 = instructorAssociations.get(1);

    var studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    var studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);
    var studentAssociations = getAssocAggCompFromClassDiagram(studentBusClass, studentDriverClass, studentClassDiagram);
    var studentAssociation0 = studentAssociations.get(0);
    var studentAssociation1 = studentAssociations.get(1);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
    assertEquals(studentAssociation0, comparison.mappedAssociations.get(instructorAssociation0));
    assertEquals(studentAssociation1, comparison.mappedAssociations.get(instructorAssociation1));
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
    var instructorAssociations =
        getAssocAggCompFromClassDiagram(instructorBusClass, instructorDriverClass, instructorClassDiagram);
    var instructorAssociation0 = instructorAssociations.get(0);

    var studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    var studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);
    var studentAssociations = getAssocAggCompFromClassDiagram(studentBusClass, studentDriverClass, studentClassDiagram);
    var studentAssociation0 = studentAssociations.get(0);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(3, comparison.newMistakes.size());
    assertEquals(3, studentSolution.getMistakes().size());
    assertEquals(studentAssociation0, comparison.mappedAssociations.get(instructorAssociation0));
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentMyDrivrAssociationEnd,
        instructorMyDriverAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyAirplaneRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myAirplaneRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplane", instructorRootClass);
    var studentMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplanes", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentMyAirplaneAssociationEnd,
        instructorMyAirplaneAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check wrong relationship direction.
   */
  @Test
  public void testMistakeWrongRelationshipDirection() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_wrong_relationship_direction/Class Diagram/Wrong_relationship_direction.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_wrong_relationship_direction/Class Diagram/Wrong_relationship_direction.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    var instructorMyEngineAssociationEnd = getAssociationEndFromClass("myEngine", instructorCarClass);
    var studentMyEngineAssociationEnd = getAssociationEndFromClass("myEngine", studentCarClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(3, comparison.newMistakes.size());
    assertEquals(3, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), REVERSED_RELATIONSHIP_DIRECTION,
        getAssociationElements(studentMyEngineAssociationEnd), getAssociationElements(instructorMyEngineAssociationEnd),
        0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyAirportRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myAirportRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirport", instructorRootClass);
    var studentMyAirportsAssociationEnd = getAssociationEndFromClass("myAirports", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentMyAirportsAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyCityRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myCityRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyCityAssociationEnd = getAssociationEndFromClass("myCity", instructorRootClass);
    var studentCityAssociationEnd = getAssociationEndFromClass("myCitty", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentCityAssociationEnd,
        instructorMyCityAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyPersonRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myPersonRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyPersonAssociationEnd = getAssociationEndFromClass("myPerson", instructorRootClass);
    var studentPersonAssociationEnd = getAssociationEndFromClass("mPerson", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentPersonAssociationEnd,
        instructorMyPersonAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyAirplaneRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myAirplanesAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructorMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplanes", instructorAirportClass);
    var studentMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplane", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentMyAirplaneAssociationEnd,
        instructorMyAirplaneAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyCityRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myCityAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructormyCityAssociationEnd = getAssociationEndFromClass("myCity", instructorAirportClass);
    var studentmyCityAssociationEnd = getAssociationEndFromClass("myCcity", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentmyCityAssociationEnd,
        instructormyCityAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyRootRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myRootAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorAirportClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("myroot", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyAirportRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myAirportsAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", instructorAirplaneClass);
    var studentMyAirportAssociationEnd = getAssociationEndFromClass("Airports", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentMyAirportAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyPeronRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myPersonsAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyPersonAssociationEnd = getAssociationEndFromClass("myPersons", instructorAirplaneClass);
    var studentMyPersonAssociationEnd = getAssociationEndFromClass("myPersan", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentMyPersonAssociationEnd,
        instructorMyPersonAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyRootRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myRootAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorAirplaneClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("myrot", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyAirportRoleNameInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myAirportsCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", instructorCityClass);
    var studentMyAirportAssociationEnd = getAssociationEndFromClass("Airports", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentMyAirportAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyRootRoleNameInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myRootCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorCityClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("Root", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyRootRoleNameInPerson() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myRootPerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorPersonClass);
    var studentMyRooteAssociationEnd = getAssociationEndFromClass("myRoote", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentMyRooteAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check bad role name spelling.
   */
  @Test
  public void testMistakeBadMyAirplaneRoleNameInPerson() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_myAirplanesPerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);
    var instructorMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplanes", instructorPersonClass);
    var studentMyAirplaneAssociationEnd = getAssociationEndFromClass("myAiroplane", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentMyAirplaneAssociationEnd,
        instructorMyAirplaneAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyAirplaneRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyAirplaneRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplane", instructorRootClass);
    var studentMyAirplaneAssociationEnd = getAssociationEndFromClass("plane", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentMyAirplaneAssociationEnd,
        instructorMyAirplaneAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyAirportRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyAirportRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirport", instructorRootClass);
    var studentMyAirportsAssociationEnd = getAssociationEndFromClass("airports", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentMyAirportsAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyCityRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyCityRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyCityAssociationEnd = getAssociationEndFromClass("myCity", instructorRootClass);
    var studentCityAssociationEnd = getAssociationEndFromClass("city", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentCityAssociationEnd,
        instructorMyCityAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyPersonRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyPersonRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyPersonAssociationEnd = getAssociationEndFromClass("myPerson", instructorRootClass);
    var studentPersonAssociationEnd = getAssociationEndFromClass("person", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentPersonAssociationEnd,
        instructorMyPersonAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyAirplaneRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyAirplanesAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructorMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplanes", instructorAirportClass);
    var studentMyAirplaneAssociationEnd = getAssociationEndFromClass("airplane", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentMyAirplaneAssociationEnd,
        instructorMyAirplaneAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyCityRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyCityAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructormyCityAssociationEnd = getAssociationEndFromClass("myCity", instructorAirportClass);
    var studentmyCityAssociationEnd = getAssociationEndFromClass("city", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentmyCityAssociationEnd,
        instructormyCityAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyRootRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyRootAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorAirportClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("superclass", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyAirportRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyAirportsAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", instructorAirplaneClass);
    var studentMyAirportAssociationEnd = getAssociationEndFromClass("runway", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentMyAirportAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyPeronRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyPersonsAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyPersonAssociationEnd = getAssociationEndFromClass("myPersons", instructorAirplaneClass);
    var studentMyPersonAssociationEnd = getAssociationEndFromClass("people", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentMyPersonAssociationEnd,
        instructorMyPersonAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyRootRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyRootAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorAirplaneClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("root", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyAirportRoleNameInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyAirportsCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", instructorCityClass);
    var studentMyAirportAssociationEnd = getAssociationEndFromClass("port", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentMyAirportAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyRootRoleNameInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyRootCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorCityClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("head", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyRootRoleNameInPerson() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyRootPerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorPersonClass);
    var studentMyRooteAssociationEnd = getAssociationEndFromClass("top", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentMyRooteAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
   */
  @Test
  public void testMistakeIncorrectMyAirplaneRoleNameInPerson() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_incorrectMyAirplanesPerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);
    var instructorMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplanes", instructorPersonClass);
    var studentMyAirplaneAssociationEnd = getAssociationEndFromClass("planes", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentMyAirplaneAssociationEnd,
        instructorMyAirplaneAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyAirplaneRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyAirplaneRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplane", instructorRootClass);
    var studentMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplane", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentMyAirplaneAssociationEnd,
        instructorMyAirplaneAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyAirportRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyAirportRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirport", instructorRootClass);
    var studentMyAirportsAssociationEnd = getAssociationEndFromClass("myAirport", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentMyAirportsAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyCityRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyCityRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyCityAssociationEnd = getAssociationEndFromClass("myCity", instructorRootClass);
    var studentCityAssociationEnd = getAssociationEndFromClass("myCity", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentCityAssociationEnd,
        instructorMyCityAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyPersonRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyPersonRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyPersonAssociationEnd = getAssociationEndFromClass("myPerson", instructorRootClass);
    var studentPersonAssociationEnd = getAssociationEndFromClass("myPerson", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentPersonAssociationEnd,
        instructorMyPersonAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyAirplaneRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyAirplanesAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructorMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplanes", instructorAirportClass);
    var studentMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplanes", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentMyAirplaneAssociationEnd,
        instructorMyAirplaneAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyCityRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyCityAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructormyCityAssociationEnd = getAssociationEndFromClass("myCity", instructorAirportClass);
    var studentmyCityAssociationEnd = getAssociationEndFromClass("myCity", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentmyCityAssociationEnd,
        instructormyCityAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyRootRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyRootAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorAirportClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("myRoot", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyAirportRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyAirportsAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", instructorAirplaneClass);
    var studentMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentMyAirportAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyPeronRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyPersonsAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyPersonAssociationEnd = getAssociationEndFromClass("myPersons", instructorAirplaneClass);
    var studentMyPersonAssociationEnd = getAssociationEndFromClass("myPersons", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentMyPersonAssociationEnd,
        instructorMyPersonAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyRootRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyRootAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorAirplaneClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("myRoot", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyAirportRoleNameInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyAirportsCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", instructorCityClass);
    var studentMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentMyAirportAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyRootRoleNameInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyRootCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorCityClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("myRoot", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyRootRoleNameInPerson() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyRootPerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorPersonClass);
    var studentMyRooteAssociationEnd = getAssociationEndFromClass("myRoot", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentMyRooteAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect multiplicity.
   */
  @Test
  public void testMistakeMultiplicityMyAirplaneRoleNameInPerson() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_multiMyAirplanesPerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);
    var instructorMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplanes", instructorPersonClass);
    var studentMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplanes", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_MULTIPLICITY, studentMyAirplaneAssociationEnd,
        instructorMyAirplaneAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should not be static.
   */
  @Test
  public void testMistakeNotStaticMyAirplaneRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_staticMyAirplaneRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplane", instructorRootClass);
    var studentMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplane", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentMyAirplaneAssociationEnd,
        instructorMyAirplaneAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should not be static.
   */
  @Test
  public void testMistakeNotStaticMyAirportRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_staticMyAirportRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirport", instructorRootClass);
    var studentMyAirportsAssociationEnd = getAssociationEndFromClass("myAirport", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentMyAirportsAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should not be static.
   */
  @Test
  public void testMistakeNotStaticMyCityRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_staticMyCityRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyCityAssociationEnd = getAssociationEndFromClass("myCity", instructorRootClass);
    var studentCityAssociationEnd = getAssociationEndFromClass("myCity", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentCityAssociationEnd,
        instructorMyCityAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should not be static.
   */
  @Test
  public void testMistakeNotStaticMyPersonRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_staticMyPersonRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyPersonAssociationEnd = getAssociationEndFromClass("myPerson", instructorRootClass);
    var studentPersonAssociationEnd = getAssociationEndFromClass("myPerson", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentPersonAssociationEnd,
        instructorMyPersonAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should not be static.
   */
  @Test
  public void testMistakeNotStaticMyAirplaneRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_staticMyAirplanesAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructorMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplanes", instructorAirportClass);
    var studentMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplanes", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentMyAirplaneAssociationEnd,
        instructorMyAirplaneAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should not be static.
   */
  @Test
  public void testMistakeNotStaticMyCityRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_staticMyCityAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructormyCityAssociationEnd = getAssociationEndFromClass("myCity", instructorAirportClass);
    var studentmyCityAssociationEnd = getAssociationEndFromClass("myCity", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentmyCityAssociationEnd,
        instructormyCityAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should not be static.
   */
  @Test
  public void testMistakeNotStaticMyRootRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_staticMyRootAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorAirportClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("myRoot", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should not be static.
   */
  @Test
  public void testMistakeNotStaticMyAirportRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_staticMyAirportsAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", instructorAirplaneClass);
    var studentMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentMyAirportAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should not be static.
   */
  @Test
  public void testMistakeNotStaticMyPeronRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_staticMyPersonsAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyPersonAssociationEnd = getAssociationEndFromClass("myPersons", instructorAirplaneClass);
    var studentMyPersonAssociationEnd = getAssociationEndFromClass("myPersons", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentMyPersonAssociationEnd,
        instructorMyPersonAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should not be static.
   */
  @Test
  public void testMistakeNotStaticMyRootRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_staticMyRootAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorAirplaneClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("myRoot", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should not be static.
   */
  @Test
  public void testMistakeNotStaticMyAirportRoleNameInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_staticMyAirportsCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", instructorCityClass);
    var studentMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentMyAirportAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should not be static.
   */
  @Test
  public void testMistakeNotStaticMyRootRoleNameInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_staticMyRootCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorCityClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("myRoot", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should be static.
   */
  @Test
  public void testMistakeStaticMyAirplaneRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_AirportSystem_staticRoleNames/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_notStaticMyAirplaneRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplane", instructorRootClass);
    var studentMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplane", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentMyAirplaneAssociationEnd,
        instructorMyAirplaneAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should be static.
   */
  @Test
  public void testMistakeStaticMyAirportRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_AirportSystem_staticRoleNames/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_notStaticMyAirportRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirport", instructorRootClass);
    var studentMyAirportsAssociationEnd = getAssociationEndFromClass("myAirport", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentMyAirportsAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should be static.
   */
  @Test
  public void testMistakeStaticMyCityRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_AirportSystem_staticRoleNames/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_notStaticMyCityRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyCityAssociationEnd = getAssociationEndFromClass("myCity", instructorRootClass);
    var studentCityAssociationEnd = getAssociationEndFromClass("myCity", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentCityAssociationEnd,
        instructorMyCityAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should be static.
   */
  @Test
  public void testMistakeStaticMyPersonRoleNameInRoot() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_AirportSystem_staticRoleNames/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_notStaticMyPersonRoot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyPersonAssociationEnd = getAssociationEndFromClass("myPerson", instructorRootClass);
    var studentPersonAssociationEnd = getAssociationEndFromClass("myPerson", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentPersonAssociationEnd,
        instructorMyPersonAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should be static.
   */
  @Test
  public void testMistakeStaticMyAirplaneRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_AirportSystem_staticRoleNames/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_notStaticMyAirplanesAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructorMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplanes", instructorAirportClass);
    var studentMyAirplaneAssociationEnd = getAssociationEndFromClass("myAirplanes", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentMyAirplaneAssociationEnd,
        instructorMyAirplaneAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should be static.
   */
  @Test
  public void testMistakeStaticMyCityRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_AirportSystem_staticRoleNames/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_notStaticMyCityAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructormyCityAssociationEnd = getAssociationEndFromClass("myCity", instructorAirportClass);
    var studentmyCityAssociationEnd = getAssociationEndFromClass("myCity", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentmyCityAssociationEnd,
        instructormyCityAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should be static.
   */
  @Test
  public void testMistakeStaticMyRootRoleNameInAirport() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_AirportSystem_staticRoleNames/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_notStaticMyRootAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var studentAirportClass = getClassFromClassDiagram("Airport", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorAirportClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("myRoot", studentAirportClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should be static.
   */
  @Test
  public void testMistakeStaticMyAirportRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_AirportSystem_staticRoleNames/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_notStaticMyAirportsAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", instructorAirplaneClass);
    var studentMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentMyAirportAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should be static.
   */
  @Test
  public void testMistakeStaticMyPeronRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_AirportSystem_staticRoleNames/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_notStaticMyPersonsAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyPersonAssociationEnd = getAssociationEndFromClass("myPersons", instructorAirplaneClass);
    var studentMyPersonAssociationEnd = getAssociationEndFromClass("myPersons", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentMyPersonAssociationEnd,
        instructorMyPersonAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should be static.
   */
  @Test
  public void testMistakeStaticMyRootRoleNameInAirplane() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_AirportSystem_staticRoleNames/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_notStaticMyRootAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var studentAirplaneClass = getClassFromClassDiagram("Airplane", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorAirplaneClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("myRoot", studentAirplaneClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should be static.
   */
  @Test
  public void testMistakeStaticMyAirportRoleNameInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_AirportSystem_staticRoleNames/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_notStaticMyAirportsCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);
    var instructorMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", instructorCityClass);
    var studentMyAirportAssociationEnd = getAssociationEndFromClass("myAirports", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentMyAirportAssociationEnd,
        instructorMyAirportAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should be static.
   */
  @Test
  public void testMistakeStaticMyRootRoleNameInCity() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_AirportSystem_staticRoleNames/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_notStaticMyRootCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);
    var studentCityClass = getClassFromClassDiagram("City", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorCityClass);
    var studentMyRootAssociationEnd = getAssociationEndFromClass("myRoot", studentCityClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentMyRootAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check role name should be static.
   */
  @Test
  public void testMistakeNotStaticMyRootRoleNameInPerson() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_AirportSystem_staticRoleNames/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_notStaticMyRootPerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);
    var instructorMyRootAssociationEnd = getAssociationEndFromClass("myRoot", instructorPersonClass);
    var studentMyRooteAssociationEnd = getAssociationEndFromClass("myRoot", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentMyRooteAssociationEnd,
        instructorMyRootAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check mistake of using Attribute instead of an association.
   */
  @Test
  public void testMistakeAttributeInsteadOfAnAssociation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_busAndDriverClass/Class Diagram/Instructor_busAndDriverClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_attributeInsteadOfAssociation/Class Diagram/Student_attributeInsteadOfAssociation.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    var instructorClass = getClassFromClassDiagram("Driver", instructorClassDiagram);
    var instructorAssociationEnd = getAssociationEndFromClass("myBus", instructorClass);

    var studentClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    var studentAttrib = getAttributeFromClass("driver", studentClass);

    assertEquals(5, comparison.newMistakes.size());
    assertEquals(5, studentSolution.getMistakes().size());

    assertMistake(getMistakeForElement(studentAttrib, USING_ATTRIBUTE_INSTEAD_OF_ASSOC, comparison),
        USING_ATTRIBUTE_INSTEAD_OF_ASSOC, studentAttrib, instructorAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check mistake of using Attribute instead of an association.
   */
  @Test
  public void testMistakeAttributeInsteadOfAnAssociationInStudentSolution() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_pilotAndFlightClass/Class Diagram/Instructor_pilotAndFlightClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_attributeInsteadOfAssociation1/Class Diagram/Student_attributeInsteadOfAssociation1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(5, comparison.newMistakes.size());
    assertEquals(5, studentSolution.getMistakes().size());
    assertMistakeTypesContain(comparison.newMistakes, USING_ATTRIBUTE_INSTEAD_OF_ASSOC);
  }

  /**
   * Test to check mistake of using Attribute instead of an association.
   */
  @Test
  public void testMistakeAttributeInsteadOfAnAssocWithClassPresent() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_bus_driver/Class Diagram/Bus_driver.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_bus_driver/Class Diagram/Bus_driver.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(3, comparison.newMistakes.size());
    assertEquals(3, studentSolution.getMistakes().size());
    assertMistakeTypesContain(comparison.newMistakes, USING_ATTRIBUTE_INSTEAD_OF_ASSOC);
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

    var association =
        getAssocAggCompFromClassDiagram(instructorCompanyClass, instructorEmployeeClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(1), MISSING_COMPOSITION,
        getAssociationElements(association.get(0).getEnds().get(0)), 0, 1, false);
  }

  /**
   * Test to check Missing Root Airplane composition.
   */
  @Test
  public void testMistakeMissingRootAirplaneComposition() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_missingCompositionRootAirplane/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);

    var association =
        getAssocAggCompFromClassDiagram(instructorRootClass, instructorAirplaneClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(1), MISSING_COMPOSITION,
        getAssociationElements(association.get(0).getEnds().get(0)), 0, 1, false);
  }

  /**
   * Test to check Missing Root Airport composition.
   */
  @Test
  public void testMistakeMissingRootAirportComposition() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_missingCompositionRootAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);

    var association =
        getAssocAggCompFromClassDiagram(instructorRootClass, instructorAirportClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(1), MISSING_COMPOSITION,
        getAssociationElements(association.get(0).getEnds().get(0)), 0, 1, false);
  }

  /**
   * Test to check Missing Root City composition.
   */
  @Test
  public void testMistakeMissingRootCityComposition() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_missingCompositionRootCity/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);

    var association = getAssocAggCompFromClassDiagram(instructorRootClass, instructorCityClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(1), MISSING_COMPOSITION,
        getAssociationElements(association.get(0).getEnds().get(0)), 0, 1, false);
  }

  /**
   * Test to check Missing Root Person composition.
   */
  @Test
  public void testMistakeMissingRootPersonComposition() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_missingCompositionRootPerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var instructorPeopleClass = getClassFromClassDiagram("Person", instructorClassDiagram);

    var association =
        getAssocAggCompFromClassDiagram(instructorRootClass, instructorPeopleClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(1), MISSING_COMPOSITION,
        getAssociationElements(association.get(0).getEnds().get(0)), 0, 1, false);
  }

  /**
   * Test to check extra Root Passenger composition.
   */
  @Test
  public void testMistakeMissingRootPassengerComposition() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_extraCompositionRootPassenger/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var studentPassengerClass = getClassFromClassDiagram("Passenger", studentClassDiagram);

    var studentRootToPassengerAssociation =
        getAssocAggCompFromClassDiagram(studentRootClass, studentPassengerClass, studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), EXTRA_COMPOSITION,
        getAssociationElements(studentRootToPassengerAssociation.get(0).getEnds().get(0)), 0, 1, false);
  }

  /**
   * Test to check extra Root Pilot composition.
   */
  @Test
  public void testMistakeMissingRootPilotComposition() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_extraCompositionRootPilot/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var studentPilotClass = getClassFromClassDiagram("Pilot", studentClassDiagram);

    var studentRootToPilotAssociation =
        getAssocAggCompFromClassDiagram(studentRootClass, studentPilotClass, studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), EXTRA_COMPOSITION,
        getAssociationElements(studentRootToPilotAssociation.get(0).getEnds().get(0)).get(0), 0, 1, false);
  }

  /**
   * Test to check Missing Airplane Airport association.
   */
  @Test
  public void testMistakeMissingAirplaneAirportAssociation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_missingAssociationAirplaneAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);

    var instructorAirportToAirplaneAssociation =
        getAssocAggCompFromClassDiagram(instructorAirplaneClass, instructorAirportClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ASSOCIATION,
        instructorAirportToAirplaneAssociation.get(0), 0, 1, false);
  }

  /**
   * Test to check Missing Airplane Person association.
   */
  @Test
  public void testMistakeMissingAirplanePersonAssociation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_missingAssociationAirplanePerson/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirplaneClass = getClassFromClassDiagram("Airplane", instructorClassDiagram);
    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);

    var instructorPersonToAirplaneAssociation =
        getAssocAggCompFromClassDiagram(instructorAirplaneClass, instructorPersonClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ASSOCIATION,
        instructorPersonToAirplaneAssociation.get(0), 0, 1, false);
  }

  /**
   * Test to check Missing Airport City association.
   */
  @Test
  public void testMistakeMissingAirportCityAssociation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instructor_AirportSystem/Class Diagram/Instructor_AirportSystem.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_AirportSystem_missingAssociationCityAirport/Class Diagram/Student_AirportSystem.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorAirportClass = getClassFromClassDiagram("Airport", instructorClassDiagram);
    var instructorCityClass = getClassFromClassDiagram("City", instructorClassDiagram);

    var instructorCityToAirportAssociation =
        getAssocAggCompFromClassDiagram(instructorAirportClass, instructorCityClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ASSOCIATION, instructorCityToAirportAssociation.get(0),
        0, 1, false);
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

    var association =
        getAssocAggCompFromClassDiagram(instructorBookClass, instructorChapterClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(1), MISSING_COMPOSITION,
        getAssociationElements(association.get(0).getEnds().get(0)), 0, 1, false);
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

    var aggregation =
        getAssocAggCompFromClassDiagram(instructorTeamClass, instructorPlayerClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_AGGREGATION,
        getAssociationElements(aggregation.get(0).getEnds().get(0)), 0, 1, false);
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

    var aggregation =
        getAssocAggCompFromClassDiagram(instructorCarClass, instructorEngineClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_AGGREGATION,
        getAssociationElements(aggregation.get(0).getEnds().get(0)), 0, 1, false);
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

    var instructorCarToOwnerAssociation =
        getAssocAggCompFromClassDiagram(instructorCarClass, instructorOwnerClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ASSOCIATION, instructorCarToOwnerAssociation.get(0), 0,
        1, false);
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

    var instructorPassengerToAirplanAssociation =
        getAssocAggCompFromClassDiagram(instructorPassengerClass, instructorAirplanClass, instructorClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ASSOCIATION,
        instructorPassengerToAirplanAssociation.get(0), 0, 1, false);
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
    var instructorMyEmployeeAssociationEnd = getAssociationEndFromClass("myEmployee", instructorCompanyClass);
    var studentMyEmployeeAssociationEnd = getAssociationEndFromClass("myEmployee", studentCompanyClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_ASSOC_INSTEAD_OF_COMPOSITION,
        getAssociationElements(studentMyEmployeeAssociationEnd),
        getAssociationElements(instructorMyEmployeeAssociationEnd), 0, 1, false);
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_ASSOC_INSTEAD_OF_AGGREGATION,
        getAssociationElements(studentMyEngineAssociationEnd), getAssociationElements(instructorMyEngineAssociationEnd),
        0, 1, false);
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_COMPOSITION_INSTEAD_OF_AGGREGATION,
        getAssociationElements(studentMyPlayerAssociationEnd), getAssociationElements(instructorMyPlayerAssociationEnd),
        0, 1, false);
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_AGGREGATION_INSTEAD_OF_COMPOSITION,
        getAssociationElements(studentMyEmployeeAssociationEnd),
        getAssociationElements(instructorMyEmployeeAssociationEnd), 0, 1, false);
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_COMPOSITION_INSTEAD_OF_ASSOC,
        getAssociationElements(studentOwnerAssociationEnd), getAssociationElements(instructorOwnerAssociationEnd), 0, 1,
        false);
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentCarOwnerAssociationEnd,
        instructorMyOwnerAssociationEnd, 0, 1, false);
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentPeopleAssociationEnd,
        instructorMyPassengerAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentmyengineAssociationEnd,
        instructormyEngineAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incorrect role name spelling.
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ROLE_NAME_SPELLING, studentmyCompaneyAssociationEnd,
        instructormyCompanyAssociationEnd, 0, 1, false);
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_NOT_BE_STATIC, studentMyPlayerAssociationEnd,
        instructorMyPlayerAssociationEnd, 0, 1, false);
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ROLE_SHOULD_BE_STATIC, studentMyCustomerAssociationEnd,
        instructorMyCustomerAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check similar role name.
   */
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentTravellerAssociationEnd,
        instructorMyPassengerAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check similar role name spelling.
   */
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), WRONG_ROLE_NAME, studentMyMotorAssociationEnd,
        instructorMyEngineAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check directed association.
   */
  @Test
  public void testMistakeUsingDirectedAssociation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_companyAndOfficeClass/Class Diagram/Instructor_companyAndOfficeClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_usingDirectedAssociation/Class Diagram/Student_usingDirectedAssociation.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorOfficeClass = getClassFromClassDiagram("Office", instructorClassDiagram);
    var studentOfficeClass = getClassFromClassDiagram("Office", studentClassDiagram);
    var instructorMyOfficeAssociationEnd = getAssociationEndFromClass("myCompany", instructorOfficeClass);
    var studentMyOfficeAssociationEnd = getAssociationEndFromClass("myCompany", studentOfficeClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED,
        getAssociationElements(studentMyOfficeAssociationEnd), getAssociationElements(instructorMyOfficeAssociationEnd),
        0, 1, false);
  }

  /**
   * Test to check undirected association.
   */
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

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED,
        getAssociationElements(studentMyWheelAssociationEnd), getAssociationElements(instructorMyWheelAssociationEnd),
        0, 1, false);
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

    var studentCarToOwnerAssociation =
        getAssocAggCompFromClassDiagram(studentOwnerClass, studentCarClass, studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), EXTRA_ASSOCIATION, studentCarToOwnerAssociation.get(1), 0, 1,
        false);
  }

  /**
   * Test to check extra aggregation.
   */
  @Test
  public void testMistakeExtraAggregation() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestClass/instractor_classCompany/Class Diagram/Instractor_classCompany.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_extra_agg/Class Diagram/Extra_agg.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var studentCompanyClass = getClassFromClassDiagram("Company", studentClassDiagram);

    var studentRootToCompanyAssociation =
        getAssocAggCompFromClassDiagram(studentRootClass, studentCompanyClass, studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), EXTRA_AGGREGATION,
        getAssociationElements(studentRootToCompanyAssociation.get(1).getEnds().get(0)), 0, 1, false);
  }

  /**
   * Test to check Action with association.
   */
  @Test
  public void testMistakeActionWithAssoc() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_bus_driver/Class Diagram/Bus_driver.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_bus_driver_action/Class Diagram/Bus_driver.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyDriverAssociationEnd = getAssociationEndFromClass("myDriver", instructorRootClass);
    var studentDroveAssociationEnd = getAssociationEndFromClass("drove", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), REPRESENTING_ACTION_WITH_ASSOC, studentDroveAssociationEnd,
        instructorMyDriverAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check Missing Role name.
   */
  @Test
  public void testMistakeMissingRoleName() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_bus_driver/Class Diagram/Bus_driver.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_bus_driver_MissingRoleName/Class Diagram/Bus_driver.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorRootClass = getClassFromClassDiagram("Root", instructorClassDiagram);
    var studentRootClass = getClassFromClassDiagram("Root", studentClassDiagram);
    var instructorMyDriverAssociationEnd = getAssociationEndFromClass("myDriver", instructorRootClass);
    var studentDroveAssociationEnd = getAssociationEndFromClass("", studentRootClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), MISSING_ROLE_NAME, studentDroveAssociationEnd,
        instructorMyDriverAssociationEnd, 0, 1, false);
  }

  /**
   * Test to check incomplete containment tree.
   */
  @Test
  public void testMistakeIncompleteContainmentTreeBankAndAccountExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_bankAndAccountClass/Class Diagram/Instructor_bankAndAccountClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_incompleteContainmentTree/Class Diagram/Student_incompleteContainmentTree.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentBankClass = getClassFromClassDiagram("Bank", studentClassDiagram);
    var studentAccountClass = getClassFromClassDiagram("Account", studentClassDiagram);
    var studentClassList = List.of(studentBankClass, studentAccountClass);
    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);
    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), INCOMPLETE_CONTAINMENT_TREE, studentClassList, 0, 1, false);
  }

  /**
   * Test to check no incomplete containment tree mistake.
   */
  @Test
  public void testNoMistakeIncompleteContainmentRootExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_incompleteContainmentTree/Class Diagram/IncompleteContainmentTree.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_incompleteContainmentTree/Class Diagram/IncompleteContainmentTree.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
  }

  /**
   * Test to check no incomplete containment tree mistake.
   */
  @Test
  public void testNoMistakeIncompleteContainmentRoot2Example() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_incompleteContainmentTree_2/Class Diagram/IncompleteContainmentTree.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_incompleteContainmentTree_2/Class Diagram/IncompleteContainmentTree.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
  }

  /**
   * Test to check no incomplete containment tree mistake because all classes are contained.
   */
  @Test
  public void testNoMistakeIncompleteContainmentRootExample3() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_five_classes_contained/Class Diagram/Five_classes.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_five_classes_contained/Class Diagram/Five_classes.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertMistakeTypesDoNotContain(comparison.newMistakes, INCOMPLETE_CONTAINMENT_TREE);
  }

  /**
   * Test to check incomplete containment tree mistake.
   */
  @Test
  public void testNoMistakeIncompleteContainmentRootExample4() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_five_classes_contained/Class Diagram/Five_classes.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_five_classes_not_contained/Class Diagram/Five_classes.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertMistakeTypesContain(comparison.newMistakes, INCOMPLETE_CONTAINMENT_TREE);
  }

  /**
   * Test to check no incomplete containment tree mistake.
   */
  @Test
  public void testNoMistakeIncompleteContainmentRoot8ClassExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_incompleteContainmentTree_Tree/Class Diagram/IncompleteContainmentTree.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_incompleteContainmentTree_Tree/Class Diagram/IncompleteContainmentTree.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(0, comparison.newMistakes.size());
    assertEquals(0, studentSolution.getMistakes().size());
  }

  /**
   * Test to check incomplete containment tree mistake.
   */
  @Test
  public void testMistakeIncompleteContainmentRootExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_incompleteContainmentTree/Class Diagram/IncompleteContainmentTree.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_incompleteContainmentTree_1.1/Class Diagram/IncompleteContainmentTree.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studcls1Class = getClassFromClassDiagram("Cls3", studentClassDiagram);
    var studRootClass = getClassFromClassDiagram("Root", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), INCOMPLETE_CONTAINMENT_TREE, List.of(studRootClass ,studcls1Class), 0, 1, false);
  }

  /**
   * Test to check incomplete containment tree mistake.
   */
  @Test
  public void testMistakeIncompleteContainmentRoot2Example() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_incompleteContainmentTree_2/Class Diagram/IncompleteContainmentTree.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_incompleteContainmentTree_2/Class Diagram/IncompleteContainmentTree.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studcls1Class = getClassFromClassDiagram("Cl5", studentClassDiagram);
    var studRootClass = getClassFromClassDiagram("Root", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), INCOMPLETE_CONTAINMENT_TREE, List.of(studRootClass, studcls1Class), 0, 1, false);
  }

  /**
   * Test to check incomplete containment tree mistake.
   */
  @Test
  public void testMistakeIncompleteContainmentRootClassExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_incompleteContainmentTree_Tree/Class Diagram/IncompleteContainmentTree.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_incompleteContainmentTree_Tree/Class Diagram/IncompleteContainmentTree.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studcls1Class = getClassFromClassDiagram("Cls7", studentClassDiagram);
    var studRootClass = getClassFromClassDiagram("Root", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), INCOMPLETE_CONTAINMENT_TREE,
        List.of(studRootClass ,studcls1Class), 0, 1, false);
  }

  /**
   * Test to check incomplete containment tree.
   */
  @Test
  public void testMistakeIncompleteContainmentTreeCarAndWheelExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_carAndWheelClass/Class Diagram/Instructor_carAndWheelClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_incompleteContainmentTree1/Class Diagram/Student_incompleteContainmentTree1.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    var studentWheelClass = getClassFromClassDiagram("Wheel", studentClassDiagram);

    MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertMistake(studentSolution.getMistakes().get(1), INCOMPLETE_CONTAINMENT_TREE,
        List.of(studentCarClass, studentWheelClass), 0, 1, false);

  }

  /**
   * Test to check infinite recursive dependency for 2 association ends.
   */
  @Test
  public void testMistakeInfiniteRecursiveDependencyTwoAssocEnd() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_personClass/Class Diagram/Instructor_personClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_infiniteRecursiveDependency/Class Diagram/Student_infiniteRecursiveDependency.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);
    var studentChildAssociationEnd = getAssociationEndFromClass("Child", studentPersonClass);
    var otherStudentChildAssociationEnd = MistakeDetection.getOtherAssocEnd(studentChildAssociationEnd);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), INFINITE_RECURSIVE_DEPENDENCY,
        List.of(studentChildAssociationEnd, otherStudentChildAssociationEnd), 0, 1, false);
  }

  /**
   * Test to check infinite recursive dependency for 1 association ends.
   */
  @Test
  public void testMistakeInfiniteRecursiveDependencyOneAssocEnd() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_personClass/Class Diagram/Instructor_personClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_infiniteRecursiveDependencyOneAssoc/Class Diagram/Student_infiniteRecursiveDependency.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentPersonClass = getClassFromClassDiagram("Person", studentClassDiagram);
    var studentChildAssociationEnd = getAssociationEndFromClass("Parent", studentPersonClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), INFINITE_RECURSIVE_DEPENDENCY, studentChildAssociationEnd, 0, 1,
        false);
  }

  /**
   * Test to check containment in more than one class .
   */
  @Test
  public void testToCheckContaimentInMoreClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ModelsToTestRelationship/instructor_moreContainment/Class Diagram/Instructor_moreContainment.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_moreContaiment/Class Diagram/Student_moreContaiment.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var studentPassengerClass = getClassFromClassDiagram("Passenger", studentClassDiagram);
    var studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(4, comparison.newMistakes.size());
    assertEquals(4, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT,
        List.of(studentPassengerClass, studentDriverClass), 0, 1, false);
  }

  /**
   * Test to check Association class should be Regular Class.
   */
  @Test
  public void testMistakeClassShouldBeAssocClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_RegDriverClass/Class Diagram/Student_RegDriverClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_DriverAssocClass/Class Diagram/Student_DriverAssocClass.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

    var studPassengerClass = getClassFromClassDiagram("Passenger", studentClassDiagram);
    var studBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    var studPassengerBusAssociation =
        getAssocAggCompFromClassDiagram(studPassengerClass, studBusClass, studentClassDiagram);
    var studDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), ASSOC_CLASS_SHOULD_BE_CLASS,
        List.of(studPassengerBusAssociation.get(0), studDriverClass), instDriverClass, 0, 1, false);
  }

  /**
   * Test to check Association class name spelling.
   */
  @Test
  public void testMistakeAssocClassSpelling() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_DriverAssocClass/Class Diagram/Student_DriverAssocClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_DriverBadAssocClassSpelling/Class Diagram/Student_DriverAssocClass.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var instBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var instPassengerBusAssociation =
        getAssocAggCompFromClassDiagram(instPassengerClass, instBusClass, instructorClassDiagram);
    var instDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

    var studPassengerClass = getClassFromClassDiagram("Passenger", studentClassDiagram);
    var studBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
    var studPassengerBusAssociation =
        getAssocAggCompFromClassDiagram(studPassengerClass, studBusClass, studentClassDiagram);
    var studDriverClass = getClassFromClassDiagram("Drivar", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(1, comparison.newMistakes.size());
    assertEquals(1, studentSolution.getMistakes().size());

    assertMistake(studentSolution.getMistakes().get(0), BAD_ASSOC_CLASS_NAME_SPELLING,
        List.of(studPassengerBusAssociation.get(0), studDriverClass),
        List.of(instPassengerBusAssociation.get(0), instDriverClass), 0, 1, false);
  }

  /**
   * Test to check Regular class should be Association Class.
   */
  @Test
  public void testMistakeAssocClassShouldBeClass() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_DriverAssocClass/Class Diagram/Student_DriverAssocClass.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);
    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ModelsToTestRelationship/student_RegDriverClass/Class Diagram/Student_RegDriverClass.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);
    var instBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
    var instPassengerBusAssociation =
        getAssocAggCompFromClassDiagram(instPassengerClass, instBusClass, instructorClassDiagram);
    var instDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

    var studDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, false);

    assertEquals(2, comparison.newMistakes.size());
    assertEquals(2, studentSolution.getMistakes().size());
    assertMistake(studentSolution.getMistakes().get(0), CLASS_SHOULD_BE_ASSOC_CLASS, studDriverClass,
        List.of(instPassengerBusAssociation.get(0), instDriverClass), 0, 1, false);
  }

}
