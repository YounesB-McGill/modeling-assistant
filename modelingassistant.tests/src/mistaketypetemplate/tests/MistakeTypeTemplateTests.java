package mistaketypetemplate.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import modelingassistant.ModelingassistantFactory;

public class MistakeTypeTemplateTests {
  
  public static final ModelingassistantFactory MAF = ModelingassistantFactory.eINSTANCE;
  
  @Test public void testGetMistakeTypeAndMistakeTypeCategoryByNames() {
    final var wrongClassMistakeTypeCategoryName = "Wrong class";
    final var missingClassMistakeTypeName = "Missing class";
    
    var expectedWrongClassMistakeTypeCategory = MAF.createMistakeTypeCategory();
    expectedWrongClassMistakeTypeCategory.setName(wrongClassMistakeTypeCategoryName);
    
    var expectedMissingClassMistakeType = MAF.createMistakeType();
    expectedMissingClassMistakeType.setName(missingClassMistakeTypeName);
    expectedMissingClassMistakeType.setAtomic(false);
    expectedMissingClassMistakeType.setMistaketypecategory(expectedWrongClassMistakeTypeCategory);
    expectedMissingClassMistakeType.setNumStepsBeforeNotification(3); // TODO
    expectedMissingClassMistakeType.setTimeToAddress(null);
    
    var actualWrongClassMistakeTypeCategory = MistakeTypesTemplate.WRONG_CLASS;
    var actualMissingClassMistakeType = MistakeTypesTemplate.MISSING_CLASS;
    
    assertEquals(expectedWrongClassMistakeTypeCategory.getName(), actualWrongClassMistakeTypeCategory.getName());
    
    assertEquals(expectedMissingClassMistakeType.getName(), actualMissingClassMistakeType.getName());
    assertEquals(expectedMissingClassMistakeType.isAtomic(), actualMissingClassMistakeType.isAtomic());
    assertEquals(expectedMissingClassMistakeType.getMistaketypecategory().getName(),
        actualMissingClassMistakeType.getMistaketypecategory().getName());
    
    assertNotNull(actualWrongClassMistakeTypeCategory.getModelingassistant());
    assertEquals(actualWrongClassMistakeTypeCategory.getModelingassistant(),
        actualMissingClassMistakeType.getModelingAssistant());
  }

}
