package ca.mcgill.sel.mistakedetection.tests;

import static learningcorpus.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_WRONG_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_WRONG_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import modelingassistant.Mistake;

public class MistakeDetectionTest_ForPaper {

	@Test
	public void mistakeDetection_ForPaperExample() {
		var instructorClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/InstructorSolution/ExampleForPaper/ClassDiagram/PISystem_InstructorSolution.domain_model.cdm");
		var instructorSolution = MistakeDetectionTest.instructorSolutionFromClassDiagram(instructorClassDiagram);

		var studentClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/StudentSolution/ExampleForPaper/ClassDiagram/PISystem_StudentSolution.domain_model.cdm");
		var studentSolution = MistakeDetectionTest.studentSolutionFromClassDiagram(studentClassDiagram);

		Classifier instructorPoliceOfficerClass = MistakeDetectionTest.getClassFromClassDiagram("PoliceOfficer", instructorClassDiagram);
		Attribute instructorBadgeNumberAttribute =  MistakeDetectionTest.getAttributeFromClass("badgeNumber", instructorPoliceOfficerClass);
		AssociationEnd instructorAsscocEndWorkLocation = MistakeDetectionTest.getAssociationEndFromClass("workLocation", instructorPoliceOfficerClass);

		Classifier instructorAssignementClass = MistakeDetectionTest.getClassFromClassDiagram("Assignment", instructorClassDiagram);
		Attribute instructorEndDateAttribute =  MistakeDetectionTest.getAttributeFromClass("endDate", instructorAssignementClass);
		AssociationEnd instructorAssocEndAssignedOfficer = MistakeDetectionTest.getAssociationEndFromClass("assignedOfficer", instructorAssignementClass);

		Classifier instructorPersonClass = MistakeDetectionTest.getClassFromClassDiagram("Person", instructorClassDiagram);
		AssociationEnd instructorAssocEndOfficer = MistakeDetectionTest.getAssociationEndFromClass("officer", instructorPersonClass);

		Classifier instructorPoliceStationClass = MistakeDetectionTest.getClassFromClassDiagram("PoliceStation", instructorClassDiagram);
		Attribute instructorAddressAttribute =  MistakeDetectionTest.getAttributeFromClass("address", instructorPoliceStationClass);

		Classifier instructorPIClass = MistakeDetectionTest.getClassFromClassDiagram("PISystem", instructorClassDiagram);
		AssociationEnd instructorAssocEndPoliceStation = MistakeDetectionTest.getAssociationEndFromClass("policeStations", instructorPIClass);

		Association instructorPoliceOfficer_PISystem = MistakeDetectionTest.getAssociationFromClassDiagram(instructorPoliceOfficerClass, instructorPIClass, instructorClassDiagram);

		Classifier studentPoliceOfficerClass = MistakeDetectionTest.getClassFromClassDiagram("PoliceOfficer", studentClassDiagram);
		Attribute studentBadgeNumberAttribute =  MistakeDetectionTest.getAttributeFromClass("badgeNumber", studentPoliceOfficerClass);
		AssociationEnd studentAssocEndWorkAt = MistakeDetectionTest.getAssociationEndFromClass("workAt", studentPoliceOfficerClass);

		Classifier studentAssignementsClass = MistakeDetectionTest.getClassFromClassDiagram("Assignments", studentClassDiagram);
		AssociationEnd studentAssocEndOfficers = MistakeDetectionTest.getAssociationEndFromClass("officers", studentAssignementsClass);

		Classifier studentPeopleClass = MistakeDetectionTest.getClassFromClassDiagram("People", studentClassDiagram);
		AssociationEnd studentAssocEndOfficer = MistakeDetectionTest.getAssociationEndFromClass("officer", studentPeopleClass);

		Classifier studentPIClass = MistakeDetectionTest.getClassFromClassDiagram("PISystem", studentClassDiagram);
		AssociationEnd studentAssocEndStations = MistakeDetectionTest.getAssociationEndFromClass("station", studentPIClass);

		Classifier studentPoliceStationClass = MistakeDetectionTest.getClassFromClassDiagram("PoliceStation", studentClassDiagram);
		Attribute studentAddresAttribute =  MistakeDetectionTest.getAttributeFromClass("adress", studentPoliceStationClass);

		var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
		assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
		assertEquals(comparison.extraStudentClassifier.size(), 0);
		assertEquals(comparison.mappedClassifier.size(), 5);
		assertEquals(comparison.mappedAttribute.size(), 6);
		assertEquals(comparison.notMappedInstructorAttribute.size(), 1);
		assertEquals(comparison.extraStudentAttribute.size(), 0);
		assertEquals(comparison.mappedAssociation.size(), 6);
		assertEquals(studentSolution.getMistakes().size(), 13);

		for (Mistake m : studentSolution.getMistakes()) {
			MistakeDetectionTest.assertMistake(m, WRONG_ATTRIBUTE_TYPE, studentBadgeNumberAttribute, instructorBadgeNumberAttribute, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, PLURAL_CLASS_NAME,studentAssignementsClass, instructorAssignementClass, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, PLURAL_CLASS_NAME, studentPeopleClass, instructorPersonClass, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, BAD_ATTRIBUTE_NAME_SPELLING, studentAddresAttribute, instructorAddressAttribute, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, OTHER_WRONG_MULTIPLICITY, studentAssocEndOfficers, instructorAssocEndAssignedOfficer, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, OTHER_WRONG_ROLE_NAME, studentAssocEndOfficers, instructorAssocEndAssignedOfficer, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, OTHER_WRONG_ROLE_NAME, studentAssocEndStations, instructorAssocEndPoliceStation, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION, studentAssocEndOfficer, instructorAssocEndOfficer, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, OTHER_WRONG_ROLE_NAME, studentAssocEndWorkAt, instructorAsscocEndWorkLocation, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, MISSING_ATTRIBUTE, instructorEndDateAttribute,0, 1, false);
			MistakeDetectionTest.assertMistake(m, MISSING_COMPOSITION, instructorPoliceOfficer_PISystem,0, 1, false);
		}

	}
}
