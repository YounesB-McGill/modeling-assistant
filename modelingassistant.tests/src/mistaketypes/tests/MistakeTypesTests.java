package mistaketypes.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import modelingassistant.ModelingassistantFactory;
import modelingassistant.mistaketypes.MistakeTypes;

public class MistakeTypesTests {
  
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
    expectedMissingClassMistakeType.setNumStepsBeforeNotification(3); // Should be in Sirius
    expectedMissingClassMistakeType.setTimeToAddress(null);
    
    var actualWrongClassMistakeTypeCategory = MistakeTypes.WRONG_CLASS;
    var actualMissingClassMistakeType = MistakeTypes.MISSING_CLASS;
    
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
