package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.utils.Color.colorString;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ca.mcgill.sel.mistakedetection.MistakeDetectionConfig;
import ca.mcgill.sel.mistakedetection.tests.utils.Color;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedMistakeDetectionFormats;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeDetectionFormat;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.MistakeDetectionInformationService;

/**
 *
 */
public abstract class MistakeDetectionBaseTest {

  /** Warnings printed to console. A true value means the warning is already printed and is therefore not repeated. */
  private static final Map<String, Boolean> warnings = new TreeMap<>();

  @BeforeAll
  public static void setup() {
    MistakeDetectionConfig.trackComparisonInstances = true;
  }

  public static void testMdfsFromMdsAreCompatibleWithHumanValidatedMdfs() {
    var mdfsFromMds = MistakeDetectionInformationService.getMistakeDetectionFormatsAsIsFromMistakeDetectionSystem();
    var humanValidatedMdfs = HumanValidatedMistakeDetectionFormats.mappings;
    mdfsFromMds.forEach((mt, mdf) -> {
      var mdfFromMdsShape = mdf.shape();
      var hvMdfShape = humanValidatedMdfs.getOrDefault(mt, MistakeDetectionFormat.emptyMdf()).shape();
      if (!mdfFromMdsShape.equals(hvMdfShape)) {
        if (mdfFromMdsShape.isCompatibleWith(hvMdfShape)) {
          warnings.putIfAbsent(colorString(Color.DARK_YELLOW,
              "! Double-check MDF for " + mt.getName() + ": " + mdf.shape().reduceToSimplestForm()), false);
        } else {
          fail("X MDF for " + mt.getName() + " is " + mdf.shape() + " but expected " + hvMdfShape);
        }
      }
    });
  }

  @AfterAll
  public static void teardown() {
    testMdfsFromMdsAreCompatibleWithHumanValidatedMdfs();
    warnings.forEach((text, isPrinted) -> {
      if (!isPrinted) {
        System.out.println(text);
      }
      warnings.put(text, true);
    });
  }

}
