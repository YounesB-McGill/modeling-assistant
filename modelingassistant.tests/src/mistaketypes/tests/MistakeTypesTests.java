package mistaketypes.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import learningcorpus.LearningcorpusFactory;
import learningcorpus.mistaketypes.MistakeTypes;

public class MistakeTypesTests {

  public static final LearningcorpusFactory LCF = LearningcorpusFactory.eINSTANCE;

  @Test public void testGetMistakeTypeAndMistakeTypeCategoryByNames() {
    final var wrongClassMistakeTypeCategoryName = "Wrong class";
    final var missingClassMistakeTypeName = "Missing class";

    var expectedWrongClassMistakeTypeCategory = LCF.createMistakeTypeCategory();
    expectedWrongClassMistakeTypeCategory.setName(wrongClassMistakeTypeCategoryName);

    var expectedMissingClassMistakeType = LCF.createMistakeType();
    expectedMissingClassMistakeType.setName(missingClassMistakeTypeName);
    expectedMissingClassMistakeType.setAtomic(false);
    expectedMissingClassMistakeType.setMistakeTypeCategory(expectedWrongClassMistakeTypeCategory);
    expectedMissingClassMistakeType.setNumStepsBeforeNotification(3); // Should be in DSL
    expectedMissingClassMistakeType.setTimeToAddress(null);

    var actualWrongClassMistakeTypeCategory = MistakeTypes.WRONG_CLASS;
    var actualMissingClassMistakeType = MistakeTypes.MISSING_CLASS;

    assertEquals(expectedWrongClassMistakeTypeCategory.getName(), actualWrongClassMistakeTypeCategory.getName());

    assertEquals(expectedMissingClassMistakeType.getName(), actualMissingClassMistakeType.getName());
    assertEquals(expectedMissingClassMistakeType.isAtomic(), actualMissingClassMistakeType.isAtomic());
    assertEquals(expectedMissingClassMistakeType.getMistakeTypeCategory().getName(),
        actualMissingClassMistakeType.getMistakeTypeCategory().getName());

    assertNotNull(actualWrongClassMistakeTypeCategory.getLearningCorpus());
    assertEquals(actualWrongClassMistakeTypeCategory.getLearningCorpus(),
        actualMissingClassMistakeType.getMistakeTypeCategory().getLearningCorpus());
  }

}
