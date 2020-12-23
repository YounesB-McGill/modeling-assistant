package controller.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
   * Tests that a solution with these one class can be created (Umple syntax):
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
  
}
