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
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.Classifier;
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

    Classifier instructorPoliceOfficerClass = getClassFromClassDiagram("PoliceOfficer", instructorClassDiagram);
    Attribute instructorBadgeNumberAttribute = getAttributeFromClass("badgeNumber", instructorPoliceOfficerClass);
    AssociationEnd instructorAsscocEndWorkLocation =
        getAssociationEndFromClass("workLocation", instructorPoliceOfficerClass);

    Classifier instructorAssignementClass = getClassFromClassDiagram("Assignment", instructorClassDiagram);
    Attribute instructorEndDateAttribute = getAttributeFromClass("endDate", instructorAssignementClass);
    AssociationEnd instructorAssocEndAssignedOfficer =
        getAssociationEndFromClass("assignedOfficer", instructorAssignementClass);

    Classifier instructorPersonClass = getClassFromClassDiagram("Person", instructorClassDiagram);
    AssociationEnd instructorAssocEndOfficer = getAssociationEndFromClass("officer", instructorPersonClass);

    Classifier instructorPoliceStationClass = getClassFromClassDiagram("PoliceStation", instructorClassDiagram);
    Attribute instructorAddressAttribute = getAttributeFromClass("address", instructorPoliceStationClass);

    Classifier instructorPIClass = getClassFromClassDiagram("PISystem", instructorClassDiagram);
    AssociationEnd instructorAssocEndPoliceStation = getAssociationEndFromClass("policeStations", instructorPIClass);

    Association instructorPoliceOfficer_PISystem = getAssociationFromClassDiagram(instructorPoliceOfficerClass,
        instructorPIClass, instructorClassDiagram);

    Classifier studentPoliceOfficerClass = getClassFromClassDiagram("PoliceOfficer", studentClassDiagram);
    Attribute studentBadgeNumberAttribute = getAttributeFromClass("badgeNumber", studentPoliceOfficerClass);
    AssociationEnd studentAssocEndWorkAt = getAssociationEndFromClass("workAt", studentPoliceOfficerClass);

    Classifier studentAssignementsClass = getClassFromClassDiagram("Assignments", studentClassDiagram);
    AssociationEnd studentAssocEndOfficers = getAssociationEndFromClass("officers", studentAssignementsClass);

    Classifier studentPeopleClass = getClassFromClassDiagram("People", studentClassDiagram);
    AssociationEnd studentAssocEndOfficer = getAssociationEndFromClass("officer", studentPeopleClass);

    Classifier studentPIClass = getClassFromClassDiagram("PISystem", studentClassDiagram);
    AssociationEnd studentAssocEndStations = getAssociationEndFromClass("station", studentPIClass);

    Classifier studentPoliceStationClass = getClassFromClassDiagram("PoliceStation", studentClassDiagram);
    Attribute studentAddresAttribute = getAttributeFromClass("adress", studentPoliceStationClass);

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
      assertMistakeConditional(m, BAD_ATTRIBUTE_NAME_SPELLING, studentAddresAttribute,
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
          instructorAsscocEndWorkLocation, 0, 1, false);
      assertMistakeConditional(m, MISSING_ATTRIBUTE, instructorEndDateAttribute, 0, 1, false);
      assertMistakeConditional(m, MISSING_COMPOSITION, instructorPoliceOfficer_PISystem, 0, 1, false);
    }
  }

}
