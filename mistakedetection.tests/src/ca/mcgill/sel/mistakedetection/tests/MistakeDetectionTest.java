package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
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
  
  @Test public void CheckInstructorSolution() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile =
        "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
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

  @Test public void CheckStudentSolution_1_PluralClassName() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution-a.domain_model.cdm";
    // Contains Class Buses and Drivers
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);

    for (var c : classDiagram.getClasses()) {
      assertEquals(MistakeDetection.isPlural(c.getName()), true);
    }

    ClassdiagramPackage.eINSTANCE.eClass();
    cdmFile = "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
    // Contains Class Buses and Driver
    resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    classDiagram = (ClassDiagram) resource.getContents().get(0);

    for (var c : classDiagram.getClasses()) {
      assertEquals(MistakeDetection.isPlural(c.getName()), false);
    }
  }

  @Test public void checkLowerCase() {
    assertTrue(MistakeDetection.isLowerName("class1"));
    assertFalse(MistakeDetection.isLowerName("Class1"));
  }
  
  @Test public void checkCorrect() {
    
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);
    
    assertTrue(MistakeDetection.checkCorrect(solution.getClassDiagram().getClasses().get(0), solution.getClassDiagram().getClasses().get(0)));
   
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 1);
    
    System.out.println("--");
    
    MistakeDetection.mappedClassifier.clear();
    MistakeDetection.extraStudentClassifier.clear();
    MistakeDetection.notMappedInstructorClassifier.clear();
    
    assertFalse(MistakeDetection.checkCorrect(solution.getClassDiagram().getClasses().get(0), solution.getClassDiagram().getClasses().get(1)));
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 1);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 1);
    assertEquals(MistakeDetection.mappedClassifier.size(), 0);
  }
}
