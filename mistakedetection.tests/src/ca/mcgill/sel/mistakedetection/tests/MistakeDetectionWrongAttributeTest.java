package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAssociationFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getAttributeFromClass;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.getClassFromClassDiagram;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_EXTRA_ATTRIBUTE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import learningcorpus.mistaketypes.MistakeTypes;
import modelingassistant.Mistake;

public class MistakeDetectionWrongAttributeTest {
	/**
	 * Test to check for attributes(name,capacity,name,numberPlate)
	 */
	@Test
	public void testNoAttributeMistake() {
		var instructorClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/InstructorSolution/two(withAttributes)/Class Diagram/Two(withAttributes).domain_model.cdm");
		var instructorSolution = MistakeDetectionTest.instructorSolutionFromClassDiagram(instructorClassDiagram);

		var studentClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/StudentSolution/two(withAttribute)/Class Diagram/Two(withAttribute).domain_model.cdm");
		var studentSolution = MistakeDetectionTest.studentSolutionFromClassDiagram(studentClassDiagram);

		var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

		assertEquals(comparison.newMistakes.size(), 0);
		assertEquals(studentSolution.getMistakes().size(), 0);
	}

	/**
	 * Test to check for attributes Spelling Mistakes (nam,capacty,nme,noPlate)
	 */
	@Test
	public void testAttributeWrongSpelling() {
		var instructorClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/InstructorSolution/two(withAttributes)/Class Diagram/Two(withAttributes).domain_model.cdm");
		var instructorSolution = MistakeDetectionTest.instructorSolutionFromClassDiagram(instructorClassDiagram);

		var studentClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/StudentSolution/three(withAttributes)/Class Diagram/Three(withAttributes).domain_model.cdm");
		var studentSolution = MistakeDetectionTest.studentSolutionFromClassDiagram(studentClassDiagram);

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
			MistakeDetectionTest.assertMistake(m, BAD_ATTRIBUTE_NAME_SPELLING, studentBusClassAttributeCapacty, instructorBusClassAttributeCapacity, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, BAD_ATTRIBUTE_NAME_SPELLING, studentBusClassAttributeNamberPlate, instructorBusClassAttributeNumberPlate, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, BAD_ATTRIBUTE_NAME_SPELLING, studentDriverClassAttributeNme, instructorDriverClassAttributeName, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, BAD_ATTRIBUTE_NAME_SPELLING, studentPassengerClassAttributeNam, instructorPassengerClassAttributeName, 0, 1, false);
		}
	}

	/**
	 * Test to check classifier and attribute mapping (2 Attributes unmapped, all
	 * classes mapped)
	 */
	@Test
	public void testMistakeMissingAttribute() {
		var instructorClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/InstructorSolution/two(withAttributes)/Class Diagram/Two(withAttributes).domain_model.cdm");
		var instructorSolution = MistakeDetectionTest.instructorSolutionFromClassDiagram(instructorClassDiagram);

		var studentClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/StudentSolution/two(withAttribute)/Class Diagram/Two(withAttribute)-a.domain_model.cdm");
		var studentSolution = MistakeDetectionTest.studentSolutionFromClassDiagram(studentClassDiagram);

		Classifier instructorBusClass = getClassFromClassDiagram("Bus", instructorClassDiagram);
		Classifier instructorDriverClass = getClassFromClassDiagram("Driver", instructorClassDiagram);

		Attribute instructorBusClassAttributeNumberPlate = getAttributeFromClass("numberPlate", instructorBusClass);
		Attribute instructorDriverClassAttributeName = getAttributeFromClass("name", instructorDriverClass);

		var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

		assertEquals(comparison.newMistakes.size(), 2);
		assertEquals(studentSolution.getMistakes().size(), 2);
		for (Mistake m : studentSolution.getMistakes()) {
			MistakeDetectionTest.assertMistake(m, MISSING_ATTRIBUTE, instructorDriverClassAttributeName, 0, 1, false);
			MistakeDetectionTest.assertMistake(m, MISSING_ATTRIBUTE, instructorBusClassAttributeNumberPlate, 0, 1, false);
		}
	}


	/**
	 * Test to detect other extra Attribute.
	 */
	@Test
	public void testMistakeExtraAttribute() {
		var instructorClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/InstructorSolution/two(withAttributes)/Class Diagram/Two(withAttributes).domain_model.cdm");
		var instructorSolution = MistakeDetectionTest.instructorSolutionFromClassDiagram(instructorClassDiagram);

		var studentClassDiagram = MistakeDetectionTest.cdmFromFile(
				"../mistakedetection/testModels/StudentSolution/two(withAttribute)/Class Diagram/Two(withAttribute)-c.domain_model.cdm");
		var studentSolution = MistakeDetectionTest.studentSolutionFromClassDiagram(studentClassDiagram);

		Classifier instructorPassengerClass = getClassFromClassDiagram("Passenger", instructorClassDiagram);

		getAttributeFromClass("name", instructorPassengerClass);

		Classifier studentBusClass = getClassFromClassDiagram("Bus", studentClassDiagram);
		Classifier studentCustomerClass = getClassFromClassDiagram("Customer", studentClassDiagram);

		Attribute studentCustomerClassAttributeName = getAttributeFromClass("name", studentCustomerClass);

		Association studentBusCustomerAssociation = getAssociationFromClassDiagram(studentBusClass,
				studentCustomerClass, studentClassDiagram);

		var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

		assertEquals(comparison.newMistakes.size(), 3);
		assertEquals(studentSolution.getMistakes().size(), 3);

		assertEquals(comparison.notMappedInstructorAssociation.size(), 0);
		assertEquals(comparison.extraStudentAssociation.size(), 1);
		assertEquals(comparison.mappedAssociation.size(), 2);

		for (Mistake m : studentSolution.getMistakes()) {

			if (m.getMistakeType() == MistakeTypes.EXTRA_CLASS
					&& m.getStudentElements().get(0).getElement() == studentCustomerClass) {
				assertEquals(m.getStudentElements().get(0).getElement(), studentCustomerClass);
				assertEquals(m.getNumDetectionSinceResolved(), 0);
				assertEquals(m.getNumDetection(), 1);
				assertFalse(m.isResolved());
			}
			MistakeDetectionTest.assertMistake(m, OTHER_EXTRA_ATTRIBUTE, studentCustomerClassAttributeName, 0, 1, false);

			if (m.getMistakeType() == MistakeTypes.OTHER_EXTRA_ASSOCIATION
					&& m.getStudentElements().get(0).getElement() == studentBusCustomerAssociation) {
				assertEquals(m.getStudentElements().get(0).getElement(), studentBusCustomerAssociation);
				assertEquals(m.getNumDetectionSinceResolved(), 0);
				assertEquals(m.getNumDetection(), 1);
				assertFalse(m.isResolved());
			}
		}
	}
}
