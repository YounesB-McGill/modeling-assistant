package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import classdiagram.CDInt;
import classdiagram.CDString;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import classdiagram.ReferenceType;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.util.ResourceHelper;

public class MistakeDetectionTest {

  /**
   * Tests for checking Software Engineering terms, eg, CarData.
   */
  @Test public void testCheckingSoftwareEngineeringTerm() {
    List.of("Car", "Driver", "Part").forEach(s -> assertFalse(MistakeDetection.isSoftwareEngineeringTerm(s)));
    List.of("CarData", "DriverRecord", "PartInfo").forEach(s ->
        assertTrue(MistakeDetection.isSoftwareEngineeringTerm(s)));
  }
  
  /**
   * Tests for checking Plural in Class Name, eg Cars.
   */
  @Test public void testIsPlural() {
   
    List.of("Car", "Driver").forEach(s -> assertFalse(MistakeDetection.isPlural(s)));
    
   
    List.of("Cars","People","Men").forEach(s -> assertTrue(MistakeDetection.isPlural(s)));
    
   
  }

  /**
   * Tests for checking Spelling Mistake in Class Name, eg Cars.
   */
  @Test public void testIsSpelledWrong() {
	
    String class1= "Car";
    String class2= "Car";
    assertEquals(0, MistakeDetection.levenshteinDistance(class1, class2));
    
     class1= "Car";
     class2= "Cer";
    assertEquals(1, MistakeDetection.levenshteinDistance(class1, class2));
  }
  
	@Test
	public void CheckInstructorSolution() {

		ClassdiagramPackage.eINSTANCE.eClass();
		var cdmFile = "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
		var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
		var classDiagram = (ClassDiagram) resource.getContents().get(0);

		Classifier busClass = null;
		Classifier driverClass = null;

		for (var c : classDiagram.getClasses()) {
			if ("Bus".equals(c.getName()))
				busClass = c;
			else if ("Driver".equals(c.getName()))
				driverClass = c;

		}

		assertEquals(busClass, classDiagram.getClasses().get(0));
		assertEquals("Bus", busClass.getName());
		assertEquals(driverClass, classDiagram.getClasses().get(1));
		assertEquals("Driver", driverClass.getName());

		var maf = ModelingassistantFactory.eINSTANCE;
		var modelingAssistant = maf.createModelingAssistant();
		var solution = maf.createSolution();
		solution.setModelingAssistant(modelingAssistant);
		solution.setClassDiagram(classDiagram);

		List.of(busClass, driverClass).forEach(c -> assertTrue(solution.getClassDiagram().getClasses().contains(c)));
	}
	@Test
	public void CheckStudentSolution1() {

		ClassdiagramPackage.eINSTANCE.eClass();
		var cdmFile = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
		var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
		var classDiagram = (ClassDiagram) resource.getContents().get(0);

		Classifier busClass = null;
		Classifier driverClass = null;

		for (var c : classDiagram.getClasses()) {
			if ("Bus".equals(c.getName()))
				busClass = c;
			else if ("Driver".equals(c.getName()))
				driverClass = c;

		}

		assertEquals(busClass, classDiagram.getClasses().get(0));
		assertEquals("Bus", busClass.getName());
		assertEquals(driverClass, classDiagram.getClasses().get(1));
		assertEquals("Driver", driverClass.getName());

		var maf = ModelingassistantFactory.eINSTANCE;
		var modelingAssistant = maf.createModelingAssistant();
		var solution = maf.createSolution();
		solution.setModelingAssistant(modelingAssistant);
		solution.setClassDiagram(classDiagram);

		List.of(busClass, driverClass).forEach(c -> assertTrue(solution.getClassDiagram().getClasses().contains(c)));
	}
	@Test
	public void CheckStudentSolution_1_PluralClassName() {

		ClassdiagramPackage.eINSTANCE.eClass();
		var cdmFile = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
		var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
		var classDiagram = (ClassDiagram) resource.getContents().get(0);

		for (var c : classDiagram.getClasses()) {
			assertEquals(MistakeDetection.isPlural(c.getName()),false);

		}

	}
}
