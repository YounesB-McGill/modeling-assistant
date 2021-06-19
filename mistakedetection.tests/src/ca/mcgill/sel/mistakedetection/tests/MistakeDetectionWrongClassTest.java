package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getClassFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_CLASS_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import learningcorpus.mistaketypes.MistakeTypes;
import modelingassistant.Mistake;

public class MistakeDetectionWrongClassTest {

	/**
	 * Test to check for plural class names in student solution
	 */
	@Test
	public void testStudentSolution_1_PluralClassName() {

		var classDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution-a.domain_model.cdm");
		for (var c : classDiagram.getClasses()) {
			assertTrue(MistakeDetection.isPlural(c.getName()));
		}

		classDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/InstructorSolution/One/Class Diagram/InstructorSolution.domain_model.cdm");
		for (var c : classDiagram.getClasses()) {
			assertFalse(MistakeDetection.isPlural(c.getName()));
		}
	}

	/**
	 * Test for checking mapping between instructor classifier(Bus, Driver) and
	 * Student classifier(Bus, Driver)
	 */
	@Test
	public void testCheckMapping() {
		var instructorClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/InstructorSolution/One/Class Diagram/InstructorSolution.domain_model.cdm");
		var instructorSolution = MistakeDetectionTest.instructorSolutionFromClassDiagram(instructorClassDiagram);

		var studentClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution.domain_model.cdm");
		var studentSolution = MistakeDetectionTest.studentSolutionFromClassDiagram(studentClassDiagram);

		Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
		Classifier instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

		Classifier studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
		Classifier studentDriverClass = getClassFromClassDiagram("Driver", studentClassDiagram);

		assertTrue(MistakeDetection.checkCorrectTest(instructorBusClass, studentBusClass));
		assertTrue(MistakeDetection.checkCorrectTest(instructorDriverClass, studentDriverClass));

		var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
		assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
		assertEquals(comparison.extraStudentClassifier.size(), 0);
		assertEquals(comparison.mappedClassifier.size(), 2);
		assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusClass);
		assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriverClass);

		assertEquals(comparison.newMistakes.size(), 0);
		assertEquals(studentSolution.getMistakes().size(), 0);
	}

	/**
	 * Test for checking mapping between instructor classifier(Bus, Driver) and
	 * Student classifier(Buses, Drivers) and plural Class names
	 */
	@Test
	public void testPluralClassNames() {
		var instructorClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/InstructorSolution/One/Class Diagram/InstructorSolution.domain_model.cdm");
		var instructorSolution = MistakeDetectionTest.instructorSolutionFromClassDiagram(instructorClassDiagram);

		var studentClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/StudentSolution/One/Class Diagram/StudentSolution-a.domain_model.cdm");
		var studentSolution = MistakeDetectionTest.studentSolutionFromClassDiagram(studentClassDiagram);

		Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
		Classifier instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

		Classifier studentBusesClass = getClassFromClassDiagram("Buses", studentClassDiagram);
		Classifier studentDriversClass = getClassFromClassDiagram("Drivers", studentClassDiagram);

		assertTrue(MistakeDetection.checkCorrectTest(instructorBusClass, studentBusesClass));
		assertTrue(MistakeDetection.checkCorrectTest(instructorDriverClass, studentDriversClass));

		var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

		assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
		assertEquals(comparison.extraStudentClassifier.size(), 0);
		assertEquals(comparison.mappedClassifier.size(), 2);
		assertEquals(comparison.mappedClassifier.get(instructorBusClass), studentBusesClass);
		assertEquals(comparison.mappedClassifier.get(instructorDriverClass), studentDriversClass);
		assertEquals(comparison.newMistakes.size(), 4); // 2 Bad Role Names
		assertEquals(studentSolution.getMistakes().size(), 4);

		for (Mistake m : studentSolution.getMistakes()) {
			MistakeDetectionTest.assertMistake(m, PLURAL_CLASS_NAME, studentBusesClass, instructorBusClass, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, PLURAL_CLASS_NAME, studentDriversClass, instructorDriverClass, 0, 1, false);
		}
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
		var expected = MistakeDetection.MAF.createMistake();
		expected.setMistakeType(MistakeTypes.PLURAL_CLASS_NAME);
		studentClass = MistakeDetection.CDF.createClass();
		studentClass.setName("Women");

		instructorClass = MistakeDetection.CDF.createClass();
		instructorClass.setName("Woman");

		var actual = MistakeDetection.checkMistakePluralClassName(studentClass, instructorClass).get();
		assertEquals(expected.getMistakeType(), actual.getMistakeType());
	}
}
