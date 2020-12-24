package controller.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import classdiagram.ClassdiagramFactory;
import modelingassistant.ModelingassistantFactory;

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
  
}
