package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import classdiagram.Attribute;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import modelingassistant.Mistake;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.mistaketypes.MistakeTypes;
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
  /**
   * Test to check if all the classes exist in Instructor solution are loaded in cdmFile
   * */
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
  /**
   * Test to check if all the classes exist in Student solution are loaded in cdmFile
   * */
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
/**
 * Test to check for plural class names in student solution
 */
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
/**
 * Test to check if isLowerName working correctly.
 */
  @Test public void checkLowerCase() {
    assertTrue(MistakeDetection.isLowerName("class1"));
    assertFalse(MistakeDetection.isLowerName("Class1"));
  }
  /**
   * Test to check mapping function(checkCorrect) that will be called with .compare. For testing checkCorrectTest is created and called.
   * It has same functionality as checkCorrect. This test check for mapping b/w Bus = Bus and Driver != Bus.
   */
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
    
    Classifier StudentBusClass = solution.getClassDiagram().getClasses().get(0);
    Classifier StudentDriverClass = solution.getClassDiagram().getClasses().get(1);
   
    
    assertTrue(MistakeDetection.checkCorrectTest(StudentBusClass, StudentBusClass));
    assertFalse(MistakeDetection.checkCorrectTest(StudentBusClass,StudentDriverClass ));
    
    
    
  }
  /**
   * Test for checking mapping between instructor classifier(Bus, Driver) and Student classifier(Bus, Driver)
   */
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
    
    Classifier InstructorBusClass = null;
    Classifier InstructorDriverClass = null;

    for (var c : classDiagram.getClasses()) {
      if ("Bus".equals(c.getName()))
        InstructorBusClass = c;
      else if ("Driver".equals(c.getName()))
        InstructorDriverClass = c;
    }
    
    Classifier StudentBusClass = null;
    Classifier StudentDriverClass = null;

    for (var c : classDiagram1.getClasses()) {
      if ("Bus".equals(c.getName()))
        StudentBusClass = c;
      else if ("Driver".equals(c.getName()))
        StudentDriverClass = c;
    }
    assertTrue(MistakeDetection.checkCorrectTest(InstructorBusClass, StudentBusClass));
       
    assertTrue(MistakeDetection.checkCorrectTest(InstructorDriverClass, StudentDriverClass));
    
    MistakeDetection.compare(solution, solution1);    
    assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
    assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
    assertEquals(MistakeDetection.mappedClassifier.size(), 2);
    assertEquals(MistakeDetection.mappedClassifier.get(InstructorBusClass),StudentBusClass);
    assertEquals(MistakeDetection.mappedClassifier.get(InstructorDriverClass),StudentDriverClass);
    assertEquals(MistakeDetection.newMistakes.size(), 0);
    
    
  }
/**
 * Test for checking mapping between instructor classifier(Bus, Driver) and Student classifier(Buses, Drivers)
 */
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
  
  Classifier InstructorBusClass = null;
  Classifier InstructorDriverClass = null;

  for (var c : classDiagram.getClasses()) {
    if ("Bus".equals(c.getName()))
      InstructorBusClass = c;
    else if ("Driver".equals(c.getName()))
      InstructorDriverClass = c;
  }
  
  Classifier StudentBusesClass = null;
  Classifier StudentDriversClass = null;

  for (var c : classDiagram1.getClasses()) {
    if ("Buses".equals(c.getName()))
      StudentBusesClass = c;
    else if ("Drivers".equals(c.getName()))
      StudentDriversClass = c;
  }
  
  assertTrue(MistakeDetection.checkCorrectTest(InstructorBusClass, StudentBusesClass));
   
  assertTrue(MistakeDetection.checkCorrectTest(InstructorDriverClass, StudentDriversClass));
  
  MistakeDetection.compare(solution,solution1);
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 2);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorBusClass),StudentBusesClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorDriverClass),StudentDriversClass);
  
  assertEquals(MistakeDetection.newMistakes.size(), 4);
  
  for(Mistake m: MistakeDetection.newMistakes) {
    
   if(m.getMistakeType()==MistakeTypes.USING_PLURAL_OR_LOWERCASE && m.getStudentElements().get(0).getElement() == StudentBusesClass) {
     assertEquals(m.getStudentElements().get(0).getElement(),StudentBusesClass);
     
   }
   if(m.getMistakeType()==MistakeTypes.USING_PLURAL_OR_LOWERCASE && m.getStudentElements().get(0).getElement() == StudentDriversClass) {
     assertEquals(m.getStudentElements().get(0).getElement(),StudentDriversClass);
     
   }
   if(m.getMistakeType()==MistakeTypes.BAD_CLASS_NAME_SPELLING && m.getStudentElements().get(0).getElement() == StudentBusesClass) {
     assertEquals(m.getStudentElements().get(0).getElement(),StudentBusesClass);
     
   }
   if(m.getMistakeType()==MistakeTypes.BAD_CLASS_NAME_SPELLING && m.getStudentElements().get(0).getElement() == StudentDriversClass) {
     assertEquals(m.getStudentElements().get(0).getElement(),StudentDriversClass);
     
   }
  
  }
  
  }
/**
 * Test for checking mapping between instructor classifier(Bus, Driver) and Student classifier(Buses, Drivr)
 */
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
  
  Classifier InstructorBusClass = null;
  Classifier InstructorDriverClass = null;

  for (var c : classDiagram.getClasses()) {
    if ("Bus".equals(c.getName()))
      InstructorBusClass = c;
    else if ("Driver".equals(c.getName()))
      InstructorDriverClass = c;
  }
  
  Classifier StudentBusClass = null;
  Classifier StudentDrivrClass = null;

  for (var c : classDiagram1.getClasses()) {
    if ("Bus".equals(c.getName()))
      StudentBusClass = c;
    else if ("Drivr".equals(c.getName()))
      StudentDrivrClass = c;
  }
  
  assertTrue(MistakeDetection.checkCorrectTest(InstructorBusClass, StudentBusClass));
     
  assertTrue(MistakeDetection.checkCorrectTest(InstructorDriverClass, StudentDrivrClass));
  MistakeDetection.compare(solution,solution1);
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 2);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorBusClass),StudentBusClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorDriverClass),StudentDrivrClass);
  assertEquals(MistakeDetection.newMistakes.size(), 1);
  
  for(Mistake m: MistakeDetection.newMistakes) {
    /*
    if(m.getMistakeType()==MistakeTypes.BAD_CLASS_NAME_SPELLING && m.getStudentElements().get(0).getElement() == StudentDrivrClass) {
      assertEquals(m.getStudentElements().get(0).getElement(),StudentDrivrClass);
      
    }
      */
   }
 
  }
/**
 * Test to check if cdm file with attributes is loaded correctly.
 */
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
/**
 * Test to check for mapped classifiers(Passanger,Bus,Driver) and attributes(name,capacity,name,numberPlate)
 */
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
  
  Classifier InstructorBusClass = null;
  Classifier InstructorDriverClass = null;
  Classifier InstructorPassangerClass = null;

  Attribute InstructorBusClassAttributeCapacity = null;
  Attribute InstructorBusClassAttributeNumberPlate = null;
  Attribute InstructorDriverClassAttributeName = null;
  Attribute InstructorPassengerClassAttributeName = null;

  for (var c : classDiagram.getClasses()) {
    if ("Bus".equals(c.getName())) {
      InstructorBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          InstructorBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          InstructorBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      InstructorDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorDriverClassAttributeName = a;
        }

      }
    } else if ("Passanger".equals(c.getName())) {
      InstructorPassangerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorPassengerClassAttributeName = a;
        }

      }
    }
  }
  
  Classifier StudentBusClass = null;
  Classifier StudentDriverClass = null;
  Classifier StudentPassangerClass = null;

  Attribute StudentBusClassAttributeCapacity = null;
  Attribute StudentBusClassAttributeNumberPlate = null;
  Attribute StudentDriverClassAttributeName = null;
  Attribute StudentPassengerClassAttributeName = null;

  for (var c : classDiagram1.getClasses()) {
    if ("Bus".equals(c.getName())) {
      StudentBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          StudentBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          StudentBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      StudentDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentDriverClassAttributeName = a;
        }

      }
    } else if ("Passanger".equals(c.getName())) {
      StudentPassangerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentPassengerClassAttributeName = a;
        }

      }
    }
  }
  
  assertTrue(MistakeDetection.checkCorrectTest(InstructorBusClass, StudentBusClass)); 
  
  assertTrue(MistakeDetection.checkCorrectTest(InstructorDriverClass, StudentDriverClass));
 
  assertTrue(MistakeDetection.checkCorrectTest(InstructorPassangerClass,StudentPassangerClass));
  
  MistakeDetection.compare(solution,solution1);
   
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 3);
  
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorBusClass),StudentBusClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorDriverClass),StudentDriverClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorPassangerClass),StudentPassangerClass);
  
  assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
  assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.dulplicateStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.mappedAttribute.size(), 4);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorBusClassAttributeCapacity),StudentBusClassAttributeCapacity);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorBusClassAttributeNumberPlate),StudentBusClassAttributeNumberPlate);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorDriverClassAttributeName),StudentDriverClassAttributeName);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorPassengerClassAttributeName),StudentPassengerClassAttributeName);
  assertEquals(MistakeDetection.newMistakes.size(), 0);
  
 
  }
/**
 * Test to check classifier and attribute mapping (2 Attributes unmapped, all classes mapped)
 */
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
  
  
  Classifier InstructorBusClass = null;
  Classifier InstructorDriverClass = null;
  Classifier InstructorPassangerClass = null;

  Attribute InstructorBusClassAttributeCapacity = null;
  Attribute InstructorBusClassAttributeNumberPlate = null;
  Attribute InstructorDriverClassAttributeName = null;
  Attribute InstructorPassengerClassAttributeName = null;

  for (var c : classDiagram.getClasses()) {
    if ("Bus".equals(c.getName())) {
      InstructorBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          InstructorBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          InstructorBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      InstructorDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorDriverClassAttributeName = a;
        }

      }
    } else if ("Passanger".equals(c.getName())) {
      InstructorPassangerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorPassengerClassAttributeName = a;
        }

      }
    }
  }
  
  Classifier StudentBusClass = null;
  Classifier StudentDriverClass = null;
  Classifier StudentPassangerClass = null;

  Attribute StudentBusClassAttributeCapacity = null;
  Attribute StudentBusClassAttributeNumberPlate = null;
  Attribute StudentDriverClassAttributeName = null;
  Attribute StudentPassengerClassAttributeName = null;

  for (var c : classDiagram1.getClasses()) {
    if ("Bus".equals(c.getName())) {
      StudentBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          StudentBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          StudentBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      StudentDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentDriverClassAttributeName = a;
        }

      }
    } else if ("Passanger".equals(c.getName())) {
      StudentPassangerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentPassengerClassAttributeName = a;
        }

      }
    }
  }
  
  assertTrue(MistakeDetection.checkCorrectTest(InstructorBusClass, StudentBusClass)); 
  
  assertTrue(MistakeDetection.checkCorrectTest(InstructorDriverClass, StudentDriverClass));
 
  assertTrue(MistakeDetection.checkCorrectTest(InstructorPassangerClass,StudentPassangerClass));
  
  MistakeDetection.compare(solution,solution1);
  
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 3);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorBusClass),StudentBusClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorDriverClass),StudentDriverClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorPassangerClass),StudentPassangerClass);
  
  assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 2);
  assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.dulplicateStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.mappedAttribute.size(), 2);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorBusClassAttributeCapacity),StudentBusClassAttributeCapacity);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorPassengerClassAttributeName),StudentPassengerClassAttributeName);
  assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(InstructorDriverClassAttributeName));
  assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(InstructorBusClassAttributeNumberPlate));
  assertEquals(MistakeDetection.newMistakes.size(), 0);
  
  }
/**
 * Test to check for mapped classifier and attributes (2 classifiers and 4 attributes unmapped)
 */
@Test public void checkCorrectTestWithSolution3_withAttributes_compare() {
  
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
  
  Classifier InstructorBusClass = null;
  Classifier InstructorDriverClass = null;
  Classifier InstructorPassangerClass = null;

  Attribute InstructorBusClassAttributeCapacity = null;
  Attribute InstructorBusClassAttributeNumberPlate = null;
  Attribute InstructorDriverClassAttributeName = null;
  Attribute InstructorPassengerClassAttributeName = null;

  for (var c : classDiagram.getClasses()) {
    if ("Bus".equals(c.getName())) {
      InstructorBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          InstructorBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          InstructorBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      InstructorDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorDriverClassAttributeName = a;
        }

      }
    } else if ("Passanger".equals(c.getName())) {
      InstructorPassangerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorPassengerClassAttributeName = a;
        }

      }
    }
  }
  
  Classifier StudentDriverClass = null;
  
  
  for (var c : classDiagram1.getClasses()) {
   
   if ("Driver".equals(c.getName())) 
      StudentDriverClass = c;
 
  }
  MistakeDetection.compare(solution,solution1);
 
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 2);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 1);
  
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorDriverClass),StudentDriverClass);
  assertTrue(MistakeDetection.notMappedInstructorClassifier.contains(InstructorPassangerClass));
  assertTrue(MistakeDetection.notMappedInstructorClassifier.contains(InstructorBusClass));
  
  assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 4);
  assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.dulplicateStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.mappedAttribute.size(), 0);
  
  assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(InstructorDriverClassAttributeName));
  assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(InstructorBusClassAttributeNumberPlate));
  assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(InstructorPassengerClassAttributeName));
  assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(InstructorBusClassAttributeCapacity));
  assertEquals(MistakeDetection.newMistakes.size(), 0);
  
  
  }
/**
 * Similar to "checkCorrectTestWithSolution2_withAttributes()" 
 */
@Test public void checkCorrectTestWithSolution2_withAttributes_Compare() {
  
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
  
  Classifier InstructorBusClass = null;
  Classifier InstructorDriverClass = null;
  Classifier InstructorPassangerClass = null;

  Attribute InstructorBusClassAttributeCapacity = null;
  Attribute InstructorBusClassAttributeNumberPlate = null;
  Attribute InstructorDriverClassAttributeName = null;
  Attribute InstructorPassengerClassAttributeName = null;

  for (var c : classDiagram.getClasses()) {
    if ("Bus".equals(c.getName())) {
      InstructorBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          InstructorBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          InstructorBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      InstructorDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorDriverClassAttributeName = a;
        }

      }
    } else if ("Passanger".equals(c.getName())) {
      InstructorPassangerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorPassengerClassAttributeName = a;
        }

      }
    }
  }
  
  Classifier StudentBusClass = null;
  Classifier StudentDriverClass = null;
  Classifier StudentPassangerClass = null;

  Attribute StudentBusClassAttributeCapacity = null;
  Attribute StudentBusClassAttributeNumberPlate = null;
  Attribute StudentDriverClassAttributeName = null;
  Attribute StudentPassengerClassAttributeName = null;

  for (var c : classDiagram1.getClasses()) {
    if ("Bus".equals(c.getName())) {
      StudentBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          StudentBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          StudentBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      StudentDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentDriverClassAttributeName = a;
        }

      }
    } else if ("Passanger".equals(c.getName())) {
      StudentPassangerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentPassengerClassAttributeName = a;
        }

      }
    }
  }
  
  MistakeDetection.compare(solution,solution1);
  
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 3);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorBusClass),StudentBusClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorDriverClass),StudentDriverClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorPassangerClass),StudentPassangerClass);
  
  assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 2);
  assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.dulplicateStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.mappedAttribute.size(), 2);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorBusClassAttributeCapacity),StudentBusClassAttributeCapacity);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorPassengerClassAttributeName),StudentPassengerClassAttributeName);
  assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(InstructorDriverClassAttributeName));
  assertTrue(MistakeDetection.notMappedInstructorAttribute.contains(InstructorBusClassAttributeNumberPlate));
  assertEquals(MistakeDetection.newMistakes.size(), 0);
   
  }
/**
 * Test to detect 1 extra class and map other 3
 */
@Test public void checkCorrectTestWithSolution4_withAttributes_Compare() {
  
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
  var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-c.domain_model.cdm";
  var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
  var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
  var maf1 = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant1 = maf1.createModelingAssistant();
  var solution1 = maf1.createSolution();
  solution1.setModelingAssistant(modelingAssistant1);
  solution1.setClassDiagram(classDiagram1);
  
  
  Classifier InstructorBusClass = null;
  Classifier InstructorDriverClass = null;
  Classifier InstructorPassangerClass = null;

  Attribute InstructorBusClassAttributeCapacity = null;
  Attribute InstructorBusClassAttributeNumberPlate = null;
  Attribute InstructorDriverClassAttributeName = null;
  Attribute InstructorPassengerClassAttributeName = null;

  for (var c : classDiagram.getClasses()) {
    if ("Bus".equals(c.getName())) {
      InstructorBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          InstructorBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          InstructorBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      InstructorDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorDriverClassAttributeName = a;
        }

      }
    } else if ("Passanger".equals(c.getName())) {
      InstructorPassangerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorPassengerClassAttributeName = a;
        }

      }
    }
  }
  
  Classifier StudentBusClass = null;
  Classifier StudentDriverClass = null;
  Classifier StudentPassangerClass = null;
  Classifier StudentCustomerClass = null;

  Attribute StudentBusClassAttributeCapacity = null;
  Attribute StudentBusClassAttributeNumberPlate = null;
  Attribute StudentDriverClassAttributeName = null;
  Attribute StudentPassengerClassAttributeName = null;
  Attribute StudentCustomerClassAttributeName=null;

  for (var c : classDiagram1.getClasses()) {
    if ("Bus".equals(c.getName())) {
      StudentBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          StudentBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          StudentBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      StudentDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentDriverClassAttributeName = a;
        }

      }
    } else if ("Passanger".equals(c.getName())) {
      StudentPassangerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentPassengerClassAttributeName = a;
        }

      }
    }
    else if ("Customer".equals(c.getName())) {
      StudentCustomerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentCustomerClassAttributeName = a;
        }

      }
    }
  }
  
  MistakeDetection.compare(solution,solution1);
  
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 1);
  assertEquals(MistakeDetection.mappedClassifier.size(), 3);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorBusClass),StudentBusClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorDriverClass),StudentDriverClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorPassangerClass),StudentPassangerClass);
  assertTrue(MistakeDetection.extraStudentClassifier.contains(StudentCustomerClass));
  assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
  assertEquals(MistakeDetection.extraStudentAttribute.size(), 1);
  assertEquals(MistakeDetection.dulplicateStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.mappedAttribute.size(), 4);
  
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorBusClassAttributeCapacity),StudentBusClassAttributeCapacity);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorPassengerClassAttributeName),StudentPassengerClassAttributeName);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorBusClassAttributeNumberPlate),StudentBusClassAttributeNumberPlate);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorDriverClassAttributeName),StudentDriverClassAttributeName);
  assertTrue(MistakeDetection.extraStudentAttribute.contains(StudentCustomerClassAttributeName));
  assertEquals(MistakeDetection.newMistakes.size(), 0);
  
  }
/**
 * Test to check mapping for Passenger = Customer 
 */
@Test public void checkCorrectTestWithSolution5_withAttributes_Compare() {
  
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
  var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-d.domain_model.cdm";
  var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
  var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
  var maf1 = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant1 = maf1.createModelingAssistant();
  var solution1 = maf1.createSolution();
  solution1.setModelingAssistant(modelingAssistant1);
  solution1.setClassDiagram(classDiagram1);
  
  
  Classifier InstructorBusClass = null;
  Classifier InstructorDriverClass = null;
  Classifier InstructorPassangerClass = null;

  Attribute InstructorBusClassAttributeCapacity = null;
  Attribute InstructorBusClassAttributeNumberPlate = null;
  Attribute InstructorDriverClassAttributeName = null;
  Attribute InstructorPassengerClassAttributeName = null;

  for (var c : classDiagram.getClasses()) {
    if ("Bus".equals(c.getName())) {
      InstructorBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          InstructorBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          InstructorBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      InstructorDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorDriverClassAttributeName = a;
        }

      }
    } else if ("Passanger".equals(c.getName())) {
      InstructorPassangerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorPassengerClassAttributeName = a;
        }

      }
    }
  }
  
  Classifier StudentBusClass = null;
  Classifier StudentDriverClass = null;
  Classifier StudentCustomerClass = null;

  Attribute StudentBusClassAttributeCapacity = null;
  Attribute StudentBusClassAttributeNumberPlate = null;
  Attribute StudentDriverClassAttributeName = null;
  Attribute StudentCustomerClassAttributeName=null;

  for (var c : classDiagram1.getClasses()) {
    if ("Bus".equals(c.getName())) {
      StudentBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          StudentBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          StudentBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      StudentDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentDriverClassAttributeName = a;
        }

      }
    }
    else if ("Customer".equals(c.getName())) {
      StudentCustomerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentCustomerClassAttributeName = a;
        }

      }
    }
  }
  
  MistakeDetection.compare(solution,solution1);
  
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 3);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorBusClass),StudentBusClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorDriverClass),StudentDriverClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorPassangerClass),StudentCustomerClass);
 
  assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
  assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.dulplicateStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.mappedAttribute.size(), 4);
  
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorBusClassAttributeCapacity),StudentBusClassAttributeCapacity);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorPassengerClassAttributeName),StudentCustomerClassAttributeName);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorBusClassAttributeNumberPlate),StudentBusClassAttributeNumberPlate);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorDriverClassAttributeName),StudentDriverClassAttributeName);
  assertEquals(MistakeDetection.newMistakes.size(), 0);
 
  }
/**
 * Test to check mapping for Bus = Vehicle , Passenger = Customer,  Driver = Pilot
 */
@Test public void checkCorrectTestWithSolution6_withAttributes_Compare() {
  
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
  var cdmFile1 = "../mistakedetection/testModels/StudentSolution/two(withAttribute)/ClassDiagram/Two(withAttribute)-e.domain_model.cdm";
  var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
  var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
  var maf1 = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant1 = maf1.createModelingAssistant();
  var solution1 = maf1.createSolution();
  solution1.setModelingAssistant(modelingAssistant1);
  solution1.setClassDiagram(classDiagram1);
  
  Classifier InstructorBusClass = null;
  Classifier InstructorDriverClass = null;
  Classifier InstructorPassangerClass = null;

  Attribute InstructorBusClassAttributeCapacity = null;
  Attribute InstructorBusClassAttributeNumberPlate = null;
  Attribute InstructorDriverClassAttributeName = null;
  Attribute InstructorPassengerClassAttributeName = null;

  for (var c : classDiagram.getClasses()) {
    if ("Bus".equals(c.getName())) {
      InstructorBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          InstructorBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          InstructorBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      InstructorDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorDriverClassAttributeName = a;
        }

      }
    } else if ("Passanger".equals(c.getName())) {
      InstructorPassangerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorPassengerClassAttributeName = a;
        }

      }
    }
  }
  
  Classifier StudentVehicleClass = null;
  Classifier StudentPilotClass = null;
  Classifier StudentCustomerClass = null;

  Attribute StudentVehicleClassAttributeCapacity = null;
  Attribute StudentVehicleClassAttributeNumberPlate = null;
  Attribute StudentPilotClassAttributeName = null;
  Attribute StudentCustomerClassAttributeName=null;

  for (var c : classDiagram1.getClasses()) {
    if ("Vehicle".equals(c.getName())) {
      StudentVehicleClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          StudentVehicleClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          StudentVehicleClassAttributeNumberPlate = a;
        }
      }
    } else if ("Pilot".equals(c.getName())) {
      StudentPilotClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentPilotClassAttributeName = a;
        }

      }
    }
    else if ("Customer".equals(c.getName())) {
      StudentCustomerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentCustomerClassAttributeName = a;
        }

      }
    }
  }
  
  MistakeDetection.compare(solution,solution1);
  
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 3);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorBusClass),StudentVehicleClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorDriverClass),StudentPilotClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorPassangerClass),StudentCustomerClass);
 
  assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
  assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.dulplicateStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.mappedAttribute.size(), 4);
  
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorBusClassAttributeCapacity),StudentVehicleClassAttributeCapacity);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorPassengerClassAttributeName),StudentCustomerClassAttributeName);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorBusClassAttributeNumberPlate),StudentVehicleClassAttributeNumberPlate);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorDriverClassAttributeName),StudentPilotClassAttributeName);
  assertEquals(MistakeDetection.newMistakes.size(), 0);
  }
/**
 * Test to check if both solutions are same then mapping should establish properly using .compare()
 */
@Test public void checkCorrectTestWithSolution1_withAttributes_Compare() {
  
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
     
  Classifier InstructorBusClass = null;
  Classifier InstructorDriverClass = null;
  Classifier InstructorPassangerClass = null;

  Attribute InstructorBusClassAttributeCapacity = null;
  Attribute InstructorBusClassAttributeNumberPlate = null;
  Attribute InstructorDriverClassAttributeName = null;
  Attribute InstructorPassengerClassAttributeName = null;

  for (var c : classDiagram.getClasses()) {
    if ("Bus".equals(c.getName())) {
      InstructorBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          InstructorBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          InstructorBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      InstructorDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorDriverClassAttributeName = a;
        }

      }
    } else if ("Passanger".equals(c.getName())) {
      InstructorPassangerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          InstructorPassengerClassAttributeName = a;
        }

      }
    }
  }
  
  Classifier StudentBusClass = null;
  Classifier StudentDriverClass = null;
  Classifier StudentPassangerClass = null;

  Attribute StudentBusClassAttributeCapacity = null;
  Attribute StudentBusClassAttributeNumberPlate = null;
  Attribute StudentDriverClassAttributeName = null;
  Attribute StudentPassengerClassAttributeName = null;

  for (var c : classDiagram1.getClasses()) {
    if ("Bus".equals(c.getName())) {
      StudentBusClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("capacity".equals(a.getName())) {
          StudentBusClassAttributeCapacity = a;
        }
        if ("numberPlate".equals(a.getName())) {
          StudentBusClassAttributeNumberPlate = a;
        }
      }
    } else if ("Driver".equals(c.getName())) {
      StudentDriverClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentDriverClassAttributeName = a;
        }

      }
    } else if ("Passanger".equals(c.getName())) {
      StudentPassangerClass = c;
      for (Attribute a : c.getAttributes()) {
        if ("name".equals(a.getName())) {
          StudentPassengerClassAttributeName = a;
        }

      }
    }
  }
  
  
  MistakeDetection.compare(solution,solution1);
  
  assertEquals(MistakeDetection.notMappedInstructorClassifier.size(), 0);
  assertEquals(MistakeDetection.extraStudentClassifier.size(), 0);
  assertEquals(MistakeDetection.mappedClassifier.size(), 3);
  
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorBusClass),StudentBusClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorDriverClass),StudentDriverClass);
  assertEquals(MistakeDetection.mappedClassifier.get(InstructorPassangerClass),StudentPassangerClass);
  
  assertEquals(MistakeDetection.notMappedInstructorAttribute.size(), 0);
  assertEquals(MistakeDetection.extraStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.dulplicateStudentAttribute.size(), 0);
  assertEquals(MistakeDetection.mappedAttribute.size(), 4);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorBusClassAttributeCapacity),StudentBusClassAttributeCapacity);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorBusClassAttributeNumberPlate),StudentBusClassAttributeNumberPlate);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorDriverClassAttributeName),StudentDriverClassAttributeName);
  assertEquals(MistakeDetection.mappedAttribute.get(InstructorPassengerClassAttributeName),StudentPassengerClassAttributeName);
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
   System.out.print("dulplicate Attribute : ");
   for(Attribute c: MistakeDetection.dulplicateStudentAttribute) {
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
   MistakeDetection.dulplicateStudentAttribute.clear();
   
 }
}
