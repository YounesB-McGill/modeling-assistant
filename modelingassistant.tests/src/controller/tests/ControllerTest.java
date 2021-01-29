package controller.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;

import classdiagram.CDInt;
import classdiagram.CDString;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramFactory;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import classdiagram.ReferenceType;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.util.ResourceHelper;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.common.util.URI;

public class ControllerTest {
  
  @Test public void testJunitIsWorking() {
    assertTrue(true);
  }
  
  @Test public void testCreatingEmptySolution() {
    var maf = ModelingassistantFactory.eINSTANCE;
    var cdf = ClassdiagramFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    var classDiagram = cdf.createClassDiagram();
    classDiagram.setName("Student1_solution");
    solution.setClassDiagram(classDiagram);
    modelingAssistant.getSolutions().add(solution);
    assertEquals("Student1_solution", modelingAssistant.getSolutions().get(0).getClassDiagram().getName());
  }
  
  /**
   * Tests that a solution with one class can be created (Umple syntax):
   * 
   * class Car {
   *   int id;
   *   String make; // eg, BMW, Honda
   * }
   */
  @Test public void testCreatingOneClassSolution() {
    var maf = ModelingassistantFactory.eINSTANCE;
    var cdf = ClassdiagramFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    var classDiagram = cdf.createClassDiagram();
    classDiagram.setName("Student1_solution");
    solution.setClassDiagram(classDiagram);
    modelingAssistant.getSolutions().add(solution);
    
    var carClass = cdf.createClass();
    carClass.setName("Car");
    var carId = cdf.createAttribute();
    carId.setName("id");
    var intType = cdf.createCDInt();
    carId.setType(intType);
    var carMake = cdf.createAttribute();
    carMake.setName("make");
    var stringType = cdf.createCDString();
    carMake.setType(stringType);
    carClass.getAttributes().add(carId);
    carClass.getAttributes().add(carMake);
    
    classDiagram.getClasses().add(carClass);
    
    assertEquals("Student1_solution", modelingAssistant.getSolutions().get(0).getClassDiagram().getName());
    
    assertEquals("Car", classDiagram.getClasses().get(0).getName());
    assertEquals("id", classDiagram.getClasses().get(0).getAttributes().get(0).getName());
    assertEquals("make", classDiagram.getClasses().get(0).getAttributes().get(1).getName());
    assertEquals(intType, classDiagram.getClasses().get(0).getAttributes().get(0).getType());
    assertEquals(stringType, classDiagram.getClasses().get(0).getAttributes().get(1).getType());
  }
  
  /**
   * Test that a solution with these two classes can be created:
   * 
   * class Car {} // see above
   * class Driver {
   *   String name;
   *   * -- 1 Car primaryVehicle;
   * }
   */
  @Test public void testCreatingTwoClassSolutionWithAssociation() {
    var maf = ModelingassistantFactory.eINSTANCE;
    var cdf = ClassdiagramFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    var classDiagram = cdf.createClassDiagram();
    var cdInt = cdf.createCDInt();
    var cdString = cdf.createCDString();
    
    classDiagram.setName("Student1_solution");
    solution.setClassDiagram(classDiagram);
    modelingAssistant.getSolutions().add(solution);
    
    var carClass = cdf.createClass();
    carClass.setName("Car");
    var carId = cdf.createAttribute();
    carId.setName("id");
    carId.setType(cdInt);
    var carMake = cdf.createAttribute();
    carMake.setName("make");
    carMake.setType(cdString);
    carClass.getAttributes().add(carId);
    carClass.getAttributes().add(carMake);
    
    var driverClass = cdf.createClass();
    driverClass.setName("Driver");
    var driverName = cdf.createAttribute();
    driverName.setName("name");
    driverName.setType(cdString);
    driverClass.getAttributes().add(driverName);
    
    var carDriverAssociationEnd = cdf.createAssociationEnd();
    carDriverAssociationEnd.setClassifier(carClass);
    carDriverAssociationEnd.setNavigable(true);
    carDriverAssociationEnd.setLowerBound(1);
    carDriverAssociationEnd.setUpperBound(1);
    var driverCarAssociationEnd = cdf.createAssociationEnd();
    driverCarAssociationEnd.setClassifier(driverClass);
    driverCarAssociationEnd.setNavigable(true);
    driverCarAssociationEnd.setLowerBound(0);
    driverCarAssociationEnd.setUpperBound(-1);
    carClass.getAssociationEnds().add(carDriverAssociationEnd);
    driverClass.getAssociationEnds().add(driverCarAssociationEnd);
    var carDriverAssociation = cdf.createAssociation();
    carDriverAssociation.getEnds().addAll(List.of(carDriverAssociationEnd, driverCarAssociationEnd));
    carDriverAssociationEnd.setAssoc(carDriverAssociation);
    driverCarAssociationEnd.setAssoc(carDriverAssociation);
    
    classDiagram.getClasses().addAll(List.of(carClass, driverClass));
    
    assertEquals("Student1_solution", modelingAssistant.getSolutions().get(0).getClassDiagram().getName());
    assertEquals(classDiagram, modelingAssistant.getSolutions().get(0).getClassDiagram());
    
    assertEquals(carClass, classDiagram.getClasses().get(0));
    assertEquals("Car", carClass.getName());
    assertEquals("id", carClass.getAttributes().get(0).getName());
    assertEquals("make", carClass.getAttributes().get(1).getName());
    assertEquals(cdInt, carClass.getAttributes().get(0).getType());
    assertEquals(cdString, carClass.getAttributes().get(1).getType());
    
    assertEquals(driverClass, classDiagram.getClasses().get(1));
    assertEquals("Driver", driverClass.getName());
    assertEquals("name", driverClass.getAttributes().get(0).getName());
    assertEquals(cdString, driverClass.getAttributes().get(0).getType());
    
    assertEquals(carDriverAssociation, carClass.getAssociationEnds().get(0).getAssoc());
    assertEquals(carDriverAssociation, driverClass.getAssociationEnds().get(0).getAssoc());
    assertEquals(carDriverAssociationEnd, carDriverAssociation.getEnds().get(0));
    assertEquals(driverCarAssociationEnd, carDriverAssociation.getEnds().get(1));
    assertEquals(carClass, carDriverAssociationEnd.getClassifier());
    assertEquals(driverClass, driverCarAssociationEnd.getClassifier());
    assertEquals(1, carDriverAssociationEnd.getLowerBound());
    assertEquals(1, carDriverAssociationEnd.getUpperBound());
    assertEquals(0, driverCarAssociationEnd.getLowerBound());
    assertEquals(-1, driverCarAssociationEnd.getUpperBound());
  }
  
  /**
   * Test that a solution with these two classes can be created:
   * 
   * class Car {} // see above
   * class SportsCar { isA Car; }  
   */
  @Test
  public void testCreatingTwoClassSolutionWithGeneralization() {
    var maf = ModelingassistantFactory.eINSTANCE;
    var cdf = ClassdiagramFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    var classDiagram = cdf.createClassDiagram();
    var cdInt = cdf.createCDInt();
    var cdString = cdf.createCDString();

    classDiagram.setName("Student1_solution");
    solution.setClassDiagram(classDiagram);
    modelingAssistant.getSolutions().add(solution);

    var carClass = cdf.createClass();
    carClass.setName("Car");
    var carId = cdf.createAttribute();
    carId.setName("id");
    carId.setType(cdInt);
    var carMake = cdf.createAttribute();
    carMake.setName("make");
    carMake.setType(cdString);
    carClass.getAttributes().add(carId);
    carClass.getAttributes().add(carMake);

    var sportsCarClass = cdf.createClass();
    sportsCarClass.setName("SportsCar");
    sportsCarClass.getSuperTypes().add(carClass);

    classDiagram.getClasses().addAll(List.of(carClass, sportsCarClass));

    assertEquals("Student1_solution", modelingAssistant.getSolutions().get(0).getClassDiagram().getName());
    assertEquals(classDiagram, modelingAssistant.getSolutions().get(0).getClassDiagram());

    assertEquals(carClass, classDiagram.getClasses().get(0));
    assertEquals("Car", carClass.getName());
    assertEquals("id", carClass.getAttributes().get(0).getName());
    assertEquals("make", carClass.getAttributes().get(1).getName());
    assertEquals(cdInt, carClass.getAttributes().get(0).getType());
    assertEquals(cdString, carClass.getAttributes().get(1).getType());

    assertEquals(sportsCarClass, classDiagram.getClasses().get(1));
    assertEquals("SportsCar", sportsCarClass.getName());
    assertEquals("Car", sportsCarClass.getSuperTypes().get(0).getName());
    assertEquals("id", sportsCarClass.getSuperTypes().get(0).getAttributes().get(0).getName());
    assertEquals("make", sportsCarClass.getSuperTypes().get(0).getAttributes().get(1).getName());
  }
  
  /**
   * Verifies that it is possible to create a modeling assistant solution from a serialized TouchCORE
   * single class domain model.
   */
  @Test public void testCreatingOneClassSolutionFromSerializedClassDiagram() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../modelingassistant/testmodels/car.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var carClass = classDiagram.getClasses().get(0);

    assertEquals(carClass, classDiagram.getClasses().get(0));
    assertEquals("Car", carClass.getName());
    assertEquals("id", carClass.getAttributes().get(0).getName());
    assertEquals("make", carClass.getAttributes().get(1).getName());
    assertTrue(carClass.getAttributes().get(0).getType() instanceof CDInt);
    assertTrue(carClass.getAttributes().get(1).getType() instanceof CDString);
  }
  
  /**
   * Verifies that it is possible to create a modeling assistant solution from a serialized TouchCORE
   * multiclass domain model.
   */
  @Test public void testCreatingMulticlassSolutionFromSerializedClassDiagram() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../modelingassistant/testmodels/car_sportscar_part_driver.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    
    Classifier carClass = null;
    Classifier driverClass = null;
    Classifier sportsCarClass = null;
    Classifier partClass = null;
    for (var c: classDiagram.getClasses()) {
      if ("Car".equals(c.getName())) carClass = c;
      else if ("Driver".equals(c.getName())) driverClass = c;
      else if ("SportsCar".equals(c.getName())) sportsCarClass = c;
      else if ("Part".equals(c.getName())) partClass = c;
    }

    assertEquals(carClass, classDiagram.getClasses().get(0));
    assertEquals("Car", carClass.getName());
    assertEquals("id", carClass.getAttributes().get(0).getName());
    assertEquals("make", carClass.getAttributes().get(1).getName());
    assertTrue(carClass.getAttributes().get(0).getType() instanceof CDInt);
    assertTrue(carClass.getAttributes().get(1).getType() instanceof CDString);
    assertEquals("Part", partClass.getName());
    assertEquals("Car", sportsCarClass.getSuperTypes().get(0).getName());
    assertEquals(ReferenceType.COMPOSITION, carClass.getAssociationEnds().stream()
        .filter(ae -> "parts".equals(ae.getName())).collect(Collectors.toList()).get(0).getReferenceType());
    
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    modelingAssistant.getSolutions().add(solution);
    solution.setClassDiagram(classDiagram);
    
    List.of(carClass, driverClass, sportsCarClass, partClass).forEach(c ->
        assertTrue(solution.getClassDiagram().getClasses().contains(c)));
  }
  
  /**
   * Tests for checking Software Engineering terms (Umple syntax):
   * 
   * class CarData {
   *   
   * }
   */
  @Test public void testCheckingSoftwareEngineeringTerm() {
    var maf = ModelingassistantFactory.eINSTANCE;
    var cdf = ClassdiagramFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    var classDiagram = cdf.createClassDiagram();
    classDiagram.setName("Student1_solution");
    solution.setClassDiagram(classDiagram);
    modelingAssistant.getSolutions().add(solution);
    
    var carClass = cdf.createClass();
    carClass.setName("CarData");
        
    classDiagram.getClasses().add(carClass);
    
    assertEquals("Student1_solution", modelingAssistant.getSolutions().get(0).getClassDiagram().getName());
     
   
    String[] SoftwareEnginneringTerms = {"data", "record", "table", "information"};    
    for( String i:SoftwareEnginneringTerms ){
     if(classDiagram.getClasses().get(0).getName().toLowerCase().contains(i)){
    	
    	 assertEquals("CarData", classDiagram.getClasses().get(0).getName());
	  }
     }
    
   
  }
  
  /**
   * Tests for checking Plural in Class Name (Umple syntax):
   * 
   * class Cars {
 
   * }
   */
  @Test public void testCheckingPluralTerm() {
    var maf = ModelingassistantFactory.eINSTANCE;
    var cdf = ClassdiagramFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    var classDiagram = cdf.createClassDiagram();
    classDiagram.setName("Student1_solution");
    solution.setClassDiagram(classDiagram);
    modelingAssistant.getSolutions().add(solution);
    
    var carClass = cdf.createClass();
    carClass.setName("Cars");
  
    classDiagram.getClasses().add(carClass);
    
    assertEquals("Student1_solution", modelingAssistant.getSolutions().get(0).getClassDiagram().getName());
    
    var className=classDiagram.getClasses().get(0).getName();
    
    assertEquals("Cars", className);
    
    boolean check=false;
    
    if(Character.toUpperCase(className.charAt(className.length()-1)) == 'S') {
    	check=true;
    	    }
    assertEquals(check,true);
         
  }
   public void associate(Classifier class1, Classifier class2) {
	  var cdf = ClassdiagramFactory.eINSTANCE;
	  var class1AssociationEnd = cdf.createAssociationEnd();
	    class1AssociationEnd.setClassifier(class1);
	    class1AssociationEnd.setNavigable(true);
	    class1AssociationEnd.setLowerBound(1);
	    class1AssociationEnd.setUpperBound(1);
	    var class2AssociationEnd = cdf.createAssociationEnd();
	    class2AssociationEnd.setClassifier(class2);
	    class2AssociationEnd.setNavigable(true);
	    class2AssociationEnd.setLowerBound(0);
	    class2AssociationEnd.setUpperBound(-1);
	    class1.getAssociationEnds().add(class1AssociationEnd);
	    class2.getAssociationEnds().add(class2AssociationEnd);
	    var class1class2Association = cdf.createAssociation();
	    class1class2Association.getEnds().addAll(List.of(class1AssociationEnd, class2AssociationEnd));
	    class1AssociationEnd.setAssoc(class1class2Association);
	    class2AssociationEnd.setAssoc(class1class2Association);
	  
  }
  public void contains(Classifier containedClass, Classifier containerClass) {
	  var cdf = ClassdiagramFactory.eINSTANCE;
	  var containerClassAssociationEnd = cdf.createAssociationEnd();
	    containerClassAssociationEnd.setClassifier(containerClass);
	    containerClassAssociationEnd.setNavigable(true);
	    containerClassAssociationEnd.setLowerBound(1);
	    containerClassAssociationEnd.setUpperBound(1);
	    containerClassAssociationEnd.setReferenceType(ReferenceType.COMPOSITION);
	    var containedClassAssociationEnd = cdf.createAssociationEnd();
	    containedClassAssociationEnd.setClassifier(containedClass);
	    containedClassAssociationEnd.setNavigable(true);
	    containedClassAssociationEnd.setLowerBound(0);
	    containedClassAssociationEnd.setUpperBound(-1);
	    containerClass.getAssociationEnds().add(containerClassAssociationEnd);
	    containedClass.getAssociationEnds().add(containedClassAssociationEnd);
	    var containerClassContainedClassAssociation = cdf.createAssociation();
	    containerClassContainedClassAssociation.getEnds().addAll(List.of(containerClassAssociationEnd, containedClassAssociationEnd));
	    containerClassAssociationEnd.setAssoc(containerClassContainedClassAssociation);
	    containedClassAssociationEnd.setAssoc(containerClassContainedClassAssociation);
  }
  

}
