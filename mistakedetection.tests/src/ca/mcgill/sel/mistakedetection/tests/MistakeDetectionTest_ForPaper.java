package ca.mcgill.sel.mistakedetection.tests;

import static learningcorpus.mistaketypes.MistakeTypes.BAD_ASSOCIATION_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_WRONG_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_WRONG_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import learningcorpus.MistakeType;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.util.ResourceHelper;

public class MistakeDetectionTest_ForPaper {

  @Test
  public void mistakeDetection_ForPaperExample() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var instructorCdmFile =
        "../mistakedetection/testModels/InstructorSolution/ExampleForPaper/ClassDiagram/PISystem_InstructorSolution.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(instructorCdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var instructorSolution = maf.createSolution();
    instructorSolution.setModelingAssistant(modelingAssistant);
    instructorSolution.setClassDiagram(classDiagram);

    ClassdiagramPackage.eINSTANCE.eClass();
    var studentCdmFile =
        "../mistakedetection/testModels/StudentSolution/ExampleForPaper/ClassDiagram/PISystem_StudentSolution.domain_model.cdm";
    resource = ResourceHelper.INSTANCE.loadResource(studentCdmFile);
    var classDiagram1 = (ClassDiagram) resource.getContents().get(0);
    var modelingAssistant1 = maf.createModelingAssistant();
    var studentSolution = maf.createSolution();
    studentSolution.setModelingAssistant(modelingAssistant1);
    studentSolution.setClassDiagram(classDiagram1);
    var student = maf.createStudent();
    studentSolution.setStudent(student);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);
    assertEquals(comparison.notMappedInstructorClassifier.size(), 0);
    assertEquals(comparison.extraStudentClassifier.size(), 0);
    assertEquals(comparison.mappedClassifier.size(), 5);
    assertEquals(comparison.mappedAttribute.size(), 6);
    assertEquals(comparison.notMappedInstructorAttribute.size(), 1);
    assertEquals(comparison.extraStudentAttribute.size(), 0);
    assertEquals(comparison.mappedAssociation.size(), 6);
    assertEquals(studentSolution.getMistakes().size(), 13);

    EList<MistakeType> mistakeTypes = new BasicEList<MistakeType>();
    for (Mistake m : studentSolution.getMistakes()) {
      mistakeTypes.add(m.getMistakeType());
    }

    assertTrue(mistakeTypes.containsAll(List.of(
        WRONG_ATTRIBUTE_TYPE,
        BAD_CLASS_NAME_SPELLING,
        PLURAL_CLASS_NAME,
        BAD_ATTRIBUTE_NAME_SPELLING,
        USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION,
        BAD_ASSOCIATION_NAME_SPELLING,
        OTHER_WRONG_ROLE_NAME,
        OTHER_WRONG_MULTIPLICITY,
        MISSING_ATTRIBUTE,
        MISSING_COMPOSITION
    )));
  }
}
