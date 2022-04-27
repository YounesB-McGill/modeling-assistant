package ca.mcgill.sel.mistakedetection.tests;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ca.mcgill.sel.mistakedetection.MistakeDetectionConfig;

public abstract class MistakeDetectionBaseTest {

  @BeforeAll
  public static void setup() {
    MistakeDetectionConfig.trackComparisonInstances = true;
  }

  public static void testMdfsFromMdsAreCompatibleWithHumanValidatedMdfs() {
    fail();
  }

  @AfterAll
  public static void teardown() {
    testMdfsFromMdsAreCompatibleWithHumanValidatedMdfs();
  }

}
