package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.assertMistakeConditional;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAssociationEndFromClass;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAssociationFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAttributeFromClass;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getClassFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_WRONG_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_WRONG_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import modelingassistant.Mistake;

public class MistakeDetectionTestForPaper {

  @Test
  public void mistakeDetectionForPaperExample() {
    var instructorClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/InstructorSolution/ExampleForPaper/Class Diagram/PISystem_InstructorSolution.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        "../mistakedetection/testModels/StudentSolution/ExampleForPaper/Class Diagram/PISystem_StudentSolution.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instructorPoliceOfficerClass = getClassFromClassDiagram("PoliceOfficer", instructorClassDiagram);
    var instructorBadgeNumberAttribute = getAttributeFromClass("badgeNumber", instructorPoliceOfficerClass);
    var instructorAssocEndWorkLocation = getAssociationEndFromClass("workLocation", instructorPoliceOfficerClass);

    var instructorAssignementClass = getClassFromClassDiagram("Assignment", instructorClassDiagram);
    var instructorEndDateAttribute = getAttributeFromClass("endDate", instructorAssignementClass);
    var instructorAssocEndAssignedOfficer = getAssociationEndFromClass("assignedOfficer", instructorAssignementClass);

    var instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    var instructorAssocEndOfficer = getAssociationEndFromClass("officer", instructorPersonClass);

    var instructorPoliceStationClass = getClassFromClassDiagram("PoliceStation", instructorClassDiagram);
    var instructorAddressAttribute = getAttributeFromClass("address", instructorPoliceStationClass);

    var instructorPIClass = getClassFromClassDiagram("PISystem", instructorClassDiagram);
    var instructorAssocEndPoliceStation = getAssociationEndFromClass("policeStations", instructorPIClass);

    var instructorPoliceOfficerPISystem = getAssociationFromClassDiagram(instructorPoliceOfficerClass,
        instructorPIClass, instructorClassDiagram);

    var studentPoliceOfficerClass = getClassFromClassDiagram("PoliceOfficer", studentClassDiagram);
    var studentBadgeNumberAttribute = getAttributeFromClass("badgeNumber", studentPoliceOfficerClass);
    var studentAssocEndWorkAt = getAssociationEndFromClass("workAt", studentPoliceOfficerClass);

    var studentAssignementsClass = getClassFromClassDiagram("Assignments", studentClassDiagram);
    var studentAssocEndOfficers = getAssociationEndFromClass("officers", studentAssignementsClass);

    var studentPeopleClass = getClassFromClassDiagram("People", studentClassDiagram);
    var studentAssocEndOfficer = getAssociationEndFromClass("officer", studentPeopleClass);

    var studentPIClass = getClassFromClassDiagram("PISystem", studentClassDiagram);
    var studentAssocEndStations = getAssociationEndFromClass("station", studentPIClass);

    var studentPoliceStationClass = getClassFromClassDiagram("PoliceStation", studentClassDiagram);
    var studentAdressAttribute = getAttributeFromClass("adress", studentPoliceStationClass);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 5);
    assertEquals(comparison.mappedAttribute.size(), 6);
    assertEquals(comparison.notMappedInstructorAttribute.size(), 1);
    assertEquals(comparison.extraStudentAttribute.size(), 0);
    assertEquals(comparison.mappedAssociation.size(), 6);
    assertEquals(studentSolution.getMistakes().size(), 11);

    for (Mistake m : studentSolution.getMistakes()) {
      assertMistakeConditional(m, WRONG_ATTRIBUTE_TYPE, studentBadgeNumberAttribute,
          instructorBadgeNumberAttribute, 0, 1, false);
      assertMistakeConditional(m, PLURAL_CLASS_NAME, studentAssignementsClass,
          instructorAssignementClass, 0, 1, false);
      assertMistakeConditional(m, PLURAL_CLASS_NAME, studentPeopleClass, instructorPersonClass, 0, 1, false);
      assertMistakeConditional(m, BAD_ATTRIBUTE_NAME_SPELLING, studentAdressAttribute,
          instructorAddressAttribute, 0, 1, false);
      assertMistakeConditional(m, OTHER_WRONG_MULTIPLICITY, studentAssocEndOfficers,
          instructorAssocEndAssignedOfficer, 0, 1, false);
      assertMistakeConditional(m, OTHER_WRONG_ROLE_NAME, studentAssocEndOfficers,
          instructorAssocEndAssignedOfficer, 0, 1, false);
      assertMistakeConditional(m, OTHER_WRONG_ROLE_NAME, studentAssocEndStations,
          instructorAssocEndPoliceStation, 0, 1, false);
      assertMistakeConditional(m, USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION,
          studentAssocEndOfficer, instructorAssocEndOfficer, 0, 1, false);
      assertMistakeConditional(m, OTHER_WRONG_ROLE_NAME, studentAssocEndWorkAt,
          instructorAssocEndWorkLocation, 0, 1, false);
      assertMistakeConditional(m, MISSING_ATTRIBUTE, instructorEndDateAttribute, 0, 1, false);
      assertMistakeConditional(m, MISSING_COMPOSITION, instructorPoliceOfficerPISystem.get(0), 0, 1, false);
    }
  }

}
