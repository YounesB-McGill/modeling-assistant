package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import classdiagram.Attribute;
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
  
  @Test public void checkCorrectTest() {
    
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);
    
    assertTrue(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(0), solution.getClassDiagram().getClasses().get(0)));
   
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(),1);
    
    System.out.println("--");
    
    MistakeDetection.mappedClassifier.clear();
    MistakeDetection.extraStudentClassifier.clear();
    MistakeDetection.notMappedInstructorClassifier.clear();
    
    assertFalse(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(0), solution.getClassDiagram().getClasses().get(1)));
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 1);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 1);
    assertEquals(MistakeDetection.mappedClassifier.size(), 0);
    
    clearClassifier();
  }
@Test public void checkCorrectTestWithSolution1() {
    
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);
    
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile1 = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution.domain_model.cdm";
    var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
    var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
    var maf1 = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant1 = maf1.createModelingAssistant();
    var solution1 = maf1.createSolution();
    solution1.setModelingAssistant(modelingAssistant1);
    solution1.setClassDiagram(classDiagram1);
    
    assertTrue(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(0), solution1.getClassDiagram().getClasses().get(0)));
       
    assertTrue(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(1), solution1.getClassDiagram().getClasses().get(1)));
    
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 2);
    
    clearClassifier();
  }

@Test public void checkCorrectTestWithSolution2() {
  
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile = "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
  var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
  var classDiagram = (ClassDiagram) resource.getContents().get(0);
  var maf = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant = maf.createModelingAssistant();
  var solution = maf.createSolution();
  solution.setModelingAssistant(modelingAssistant);
  solution.setClassDiagram(classDiagram);
  
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile1 = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution-a.domain_model.cdm";
  var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
  var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
  var maf1 = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant1 = maf1.createModelingAssistant();
  var solution1 = maf1.createSolution();
  solution1.setModelingAssistant(modelingAssistant1);
  solution1.setClassDiagram(classDiagram1);
  
  assertTrue(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(0), solution1.getClassDiagram().getClasses().get(0)));
     
  assertTrue(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(1), solution1.getClassDiagram().getClasses().get(1)));
  
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 2);
  
  clearClassifier();
  }
@Test public void checkCorrectTestWithSolution3() {
  
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile = "../mistakedetection/testModels/InstructorSolution/One/ClassDiagram/InstructorSolution.domain_model.cdm";
  var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
  var classDiagram = (ClassDiagram) resource.getContents().get(0);
  var maf = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant = maf.createModelingAssistant();
  var solution = maf.createSolution();
  solution.setModelingAssistant(modelingAssistant);
  solution.setClassDiagram(classDiagram);
  
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile1 = "../mistakedetection/testModels/StudentSolution/One/ClassDiagram/StudentSolution-b.domain_model.cdm";
  var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
  var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
  var maf1 = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant1 = maf1.createModelingAssistant();
  var solution1 = maf1.createSolution();
  solution1.setModelingAssistant(modelingAssistant1);
  solution1.setClassDiagram(classDiagram1);
  
  assertTrue(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(0), solution1.getClassDiagram().getClasses().get(0)));
     
  assertTrue(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(1), solution1.getClassDiagram().getClasses().get(1)));
  
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 2);
  
  clearClassifier();
  }

@Test public void CheckSolution_withAttributes() {
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile = "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
  var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
  var classDiagram = (ClassDiagram) resource.getContents().get(0);

  Classifier busClass = null;
  Classifier driverClass = null;
  Classifier passangerClass = null;

  for (var c : classDiagram.getClasses()) {
    if ("Bus".equals(c.getName()))
      busClass = c;
    else if ("Driver".equals(c.getName()))
      driverClass = c;
    else if ("Passanger".equals(c.getName()))
       passangerClass = c;
  }

  assertEquals(busClass, classDiagram.getClasses().get(0));
  assertEquals("Bus", busClass.getName());
  assertEquals(driverClass, classDiagram.getClasses().get(1));
  assertEquals("Driver", driverClass.getName());
  assertEquals(passangerClass, classDiagram.getClasses().get(2));
  assertEquals("Passanger", passangerClass.getName());

  var maf = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant = maf.createModelingAssistant();
  var solution = maf.createSolution();
  solution.setModelingAssistant(modelingAssistant);
  solution.setClassDiagram(classDiagram);

  List.of(busClass, driverClass, passangerClass).forEach(c -> assertTrue(solution.getClassDiagram().getClasses().contains(c)));
}
@Test public void checkCorrectTestWithSolution1_withAttributes() {
  
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile = "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
  var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
  var classDiagram = (ClassDiagram) resource.getContents().get(0);
  var maf = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant = maf.createModelingAssistant();
  var solution = maf.createSolution();
  solution.setModelingAssistant(modelingAssistant);
  solution.setClassDiagram(classDiagram);
  
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute).domain_model.cdm";
  var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
  var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
  var maf1 = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant1 = maf1.createModelingAssistant();
  var solution1 = maf1.createSolution();
  solution1.setModelingAssistant(modelingAssistant1);
  solution1.setClassDiagram(classDiagram1);
  
  
  assertTrue(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(0), solution1.getClassDiagram().getClasses().get(2))); 
  
  assertTrue(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(1), solution1.getClassDiagram().getClasses().get(1)));
 
  assertTrue(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(2), solution1.getClassDiagram().getClasses().get(0)));
  
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 3);
  
  assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
  assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.dulpicateStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.mappedAttribute.size(), 4);
  
 
  clearAttributesAndClassifer();
  }

@Test public void checkCorrectTestWithSolution2_withAttributes() {
  
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile = "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
  var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
  var classDiagram = (ClassDiagram) resource.getContents().get(0);
  var maf = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant = maf.createModelingAssistant();
  var solution = maf.createSolution();
  solution.setModelingAssistant(modelingAssistant);
  solution.setClassDiagram(classDiagram);
  
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-a.domain_model.cdm";
  var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
  var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
  var maf1 = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant1 = maf1.createModelingAssistant();
  var solution1 = maf1.createSolution();
  solution1.setModelingAssistant(modelingAssistant1);
  solution1.setClassDiagram(classDiagram1);
  
  
  assertTrue(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(0), solution1.getClassDiagram().getClasses().get(0))); 
  
  assertTrue(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(1), solution1.getClassDiagram().getClasses().get(1)));
 
  assertTrue(MistakeDetection.checkCorrectTest(solution.getClassDiagram().getClasses().get(2), solution1.getClassDiagram().getClasses().get(2)));
  
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 3);
  
  assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 2);
  assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.dulpicateStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.mappedAttribute.size(), 2);
  Attribute a =MistakeDetection.notMappedInstructorAttribute.get(1);
  EList<Classifier>  c=solution.getClassDiagram().getClasses();
  Classifier t=null;
  for(Classifier cl:c) {
    for(Attribute al: cl.getAttributes()) {
      if(a==al) {
        t=cl;
      }
    }
  }
  assertEquals(t,solution.getClassDiagram().getClasses().get(1) );
  
 
  clearAttributesAndClassifer();
  }

@Test public void checkCorrectTestWithSolution3_withAttributes() {
  
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile = "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
  var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
  var classDiagram = (ClassDiagram) resource.getContents().get(0);
  var maf = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant = maf.createModelingAssistant();
  var solution = maf.createSolution();
  solution.setModelingAssistant(modelingAssistant);
  solution.setClassDiagram(classDiagram);
  
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-b.domain_model.cdm";
  var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
  var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
  var maf1 = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant1 = maf1.createModelingAssistant();
  var solution1 = maf1.createSolution();
  solution1.setModelingAssistant(modelingAssistant1);
  solution1.setClassDiagram(classDiagram1);
  
  
  MistakeDetection.compare(solution,solution1);
 
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 2);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 1);
  
  assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 4);
  assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.dulpicateStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.mappedAttribute.size(), 0);
  
  clearAttributesAndClassifer();
  }

@Test public void checkCorrectTestWithSolution2_withAttributes_Compare() {
  System.out.println("____");
  System.out.println("Test Start");
  System.out.println("____");
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile = "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
  var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
  var classDiagram = (ClassDiagram) resource.getContents().get(0);
  var maf = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant = maf.createModelingAssistant();
  var solution = maf.createSolution();
  solution.setModelingAssistant(modelingAssistant);
  solution.setClassDiagram(classDiagram);
  
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-a.domain_model.cdm";
  var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
  var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
  var maf1 = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant1 = maf1.createModelingAssistant();
  var solution1 = maf1.createSolution();
  solution1.setModelingAssistant(modelingAssistant1);
  solution1.setClassDiagram(classDiagram1);
  
  
  MistakeDetection.compare(solution,solution1);
  
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 3);
  
  assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 2);
  assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.dulpicateStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.mappedAttribute.size(), 2);
  
  log();
  clearAttributesAndClassifer();
  }

@Test public void checkCorrectTestWithSolution1_withAttributes_Compare() {
  System.out.println("____");
  System.out.println("Test Start");
  System.out.println("____");
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile = "../mistakedetection/testModels/InstructorSolution/two(withAttributes)/ClassDiagram/Two(withAttributes).domain_model.cdm";
  var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
  var classDiagram = (ClassDiagram) resource.getContents().get(0);
  var maf = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant = maf.createModelingAssistant();
  var solution = maf.createSolution();
  solution.setModelingAssistant(modelingAssistant);
  solution.setClassDiagram(classDiagram);
  
  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute).domain_model.cdm";
  var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
  var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
  var maf1 = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant1 = maf1.createModelingAssistant();
  var solution1 = maf1.createSolution();
  solution1.setModelingAssistant(modelingAssistant1);
  solution1.setClassDiagram(classDiagram1);
  
  
  MistakeDetection.compare(solution,solution1);
  
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 3);
  
  assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
  assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.dulpicateStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.mappedAttribute.size(), 4);
  
  log();
  clearAttributesAndClassifer();
  }

/**
 * Function to print the mapped, unmapped classifier or attributes.
 */
 public void log() {
   System.out.println();
   System.out.println("----Test Logger-----");
   System.out.print("Not Mapped InstructorClassifier List : ");
   for(Classifier c: MistakeDetection.notMappedInstructorClassifier) {
     System.out.print(c.getName()+" ");
   }
   System.out.println();
   System.out.print("Not Mapped extraStudentClassifier : ");
   for(Classifier c: MistakeDetection.extraStudentClassifier) {
     System.out.print(c.getName()+" ");
   }
   System.out.println();
   System.out.println("Mapped Classifiers : ");
   MistakeDetection.mappedClassifier.forEach((key,value) -> System.out.println(key.getName() + " = " + value.getName()));
   System.out.println();
   System.out.print("Not Mapped InstructorAttribute List : ");
   for(Attribute c: MistakeDetection.notMappedInstructorAttribute) {
     System.out.print(c.getName()+" ");
   }
   System.out.println();
   System.out.print("Not Mapped extraStudentAttribute : ");
   for(Attribute c: MistakeDetection.extraStudentAttribute) {
     System.out.print(c.getName()+" ");
   }
   System.out.println();
   System.out.print("Dulpicate Attribute : ");
   for(Attribute c: MistakeDetection.dulpicateStudentAttribute) {
     System.out.print(c.getName()+" ");
   }
   System.out.println();
   System.out.println("Mapped Attributes : ");
   MistakeDetection.mappedAttribute.forEach((key,value) -> System.out.println(key.getName() + " = " + value.getName()));
 }
 public void clearClassifier() {
   MistakeDetection.mappedClassifier.clear();
   MistakeDetection.extraStudentClassifier.clear();
   MistakeDetection.notMappedInstructorClassifier.clear();
 }
 public void clearAttributesAndClassifer() {
   MistakeDetection.mappedClassifier.clear();
   MistakeDetection.extraStudentClassifier.clear();
   MistakeDetection.notMappedInstructorClassifier.clear();
   MistakeDetection.mappedAttribute.clear();
   MistakeDetection.extraStudentAttribute.clear();
   MistakeDetection.notMappedInstructorAttribute.clear();
   MistakeDetection.dulpicateStudentAttribute.clear();
   
 }
}
