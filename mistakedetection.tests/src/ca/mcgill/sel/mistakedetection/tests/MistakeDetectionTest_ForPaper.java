package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import classdiagram.Association;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import learningcorpus.MistakeType;
import learningcorpus.mistaketypes.MistakeTypes;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.util.ResourceHelper;

public class MistakeDetectionTest_ForPaper {
 
  @Test
  public void mistakeDetection_ForPaperExample() {
    ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile =
      "../mistakedetection/testModels/InstructorSolution/ExampleForPaper/ClassDiagram/PISystem_InstructorSolution.domain_model.cdm";
  var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
  var classDiagram = (ClassDiagram) resource.getContents().get(0);
  var maf = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant = maf.createModelingAssistant();
  var solution = maf.createSolution();
  solution.setModelingAssistant(modelingAssistant);
  solution.setClassDiagram(classDiagram);

  ClassdiagramPackage.eINSTANCE.eClass();
  var cdmFile1 =
      "../mistakedetection/testModels/StudentSolution/ExampleForPaper/ClassDiagram/PISystem_StudentSolution.domain_model.cdm";
  var resource1 = ResourceHelper.INSTANCE.loadResource(cdmFile1);
  var classDiagram1 = (ClassDiagram) resource1.getContents().get(0);
  var maf1 = ModelingassistantFactory.eINSTANCE;
  var modelingAssistant1 = maf1.createModelingAssistant();
  var solution1 = maf1.createSolution();
  solution1.setModelingAssistant(modelingAssistant1);
  solution1.setClassDiagram(classDiagram1);
  var student = maf1.createStudent();
  solution1.setStudent(student);

  var comparison = MistakeDetection.compare(solution, solution1);
  assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
  assertEquals(comparison.extraStudentClassifier.size(), 0);
  assertEquals(comparison.mappedClassifier.size(), 5);
  assertEquals(comparison.mappedAttribute.size(), 6);
  assertEquals(comparison.notMappedInstructorAttribute.size(), 1);
  assertEquals(comparison.extraStudentAttribute.size(), 0);
  assertEquals(comparison.mappedAssociation.size(), 6);
  assertEquals(solution1.getMistakes().size(), 13);
  EList<MistakeType> mistakeTypes = new BasicEList<MistakeType>();
  for (Mistake m : solution1.getMistakes()) {
    mistakeTypes.add(m.getMistakeType());
  }
  assertTrue(mistakeTypes.contains(MistakeTypes.WRONG_ATTRIBUTE_TYPE));
  assertTrue(mistakeTypes.contains(MistakeTypes.BAD_CLASS_NAME_SPELLING));
  assertTrue(mistakeTypes.contains(MistakeTypes.PLURAL_CLASS_NAME));
  assertTrue(mistakeTypes.contains(MistakeTypes.PLURAL_CLASS_NAME));
  assertTrue(mistakeTypes.contains(MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING));
  assertTrue(mistakeTypes.contains(MistakeTypes.USING_AN_AGGREGATION_COMPOSITION_INSTEAD_OF_AN_ASSOCIATION));
  assertTrue(mistakeTypes.contains(MistakeTypes.BAD_ASSOCIATION_NAME_SPELLING));
  assertTrue(mistakeTypes.contains(MistakeTypes.ROLE_NAMES_PRESENT_BUT_INCORRECT));
  assertTrue(mistakeTypes.contains(MistakeTypes.OTHER_WRONG_MULTIPLICITY));
  assertTrue(mistakeTypes.contains(MistakeTypes.ROLE_NAMES_PRESENT_BUT_INCORRECT));
  assertTrue(mistakeTypes.contains(MistakeTypes.ROLE_NAMES_PRESENT_BUT_INCORRECT));
  assertTrue(mistakeTypes.contains(MistakeTypes.MISSING_ATTRIBUTE));
  assertTrue(mistakeTypes.contains(MistakeTypes.MISSING_COMPOSITION));
  
}
}
