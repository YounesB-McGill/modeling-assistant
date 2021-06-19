package ca.mcgill.sel.mistakedetection.tests;

import static learningcorpus.mistaketypes.MistakeTypes.BAD_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ROLE_NAME_SPELLING;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import modelingassistant.Mistake;

public class MistakeDetectionWrongRelationshipsTest {

	/**
	 * Test to check mapping of relationships (No Mistakes)
	 */
	@Test
	public void testToCheckRelationshipMapping() {
		var instructorClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm");
		var instructorSolution = MistakeDetectionTest.instructorSolutionFromClassDiagram(instructorClassDiagram);

		var studentClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute).domain_model.cdm");
		var studentSolution = MistakeDetectionTest.studentSolutionFromClassDiagram(studentClassDiagram);

		var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

		assertEquals(comparison.newMistakes.size(), 0);
		assertEquals(studentSolution.getMistakes().size(), 0);
	}

	/**
	 * test to check bad role name spelling
	 */
	@Test
	public void checkCorrectTestWithSolution3() {
		var instructorClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm");
		var instructorSolution = MistakeDetectionTest.instructorSolutionFromClassDiagram(instructorClassDiagram);

		var studentClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution-b.domain_model.cdm");
		var studentSolution = MistakeDetectionTest.studentSolutionFromClassDiagram(studentClassDiagram);

		Classifier instructorBusClass = MistakeDetectionTest.getClassFromClassDiagram("Bus", instructorClassDiagram);
		Classifier instructorDriverClass = MistakeDetectionTest.getClassFromClassDiagram("Driver",
				instructorClassDiagram);

		Classifier studentBusClass = MistakeDetectionTest.getClassFromClassDiagram("Bus", studentClassDiagram);
		Classifier studentDrivrClass = MistakeDetectionTest.getClassFromClassDiagram("Drivr", studentClassDiagram);

		AssociationEnd instructorMyDriverAssociationEnd = MistakeDetectionTest.getAssociationEndFromClass("myDriver",
				instructorBusClass);

		AssociationEnd studentMyDrivrAssociationEnd = MistakeDetectionTest.getAssociationEndFromClass("myDrivr",
				studentBusClass);

		var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
		assertEquals(comparison.newMistakes.size(), 3);
		assertEquals(studentSolution.getMistakes().size(), 3);

		for (Mistake m : studentSolution.getMistakes()) {
			MistakeDetectionTest.assertMistake(m, BAD_CLASS_NAME_SPELLING, studentDrivrClass, instructorDriverClass, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, BAD_ROLE_NAME_SPELLING, studentMyDrivrAssociationEnd, instructorMyDriverAssociationEnd, 0, 1, false);
		}
	}

}
