package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.classdiagram.ReferenceType.AGGREGATION;
import static ca.mcgill.sel.classdiagram.ReferenceType.COMPOSITION;
import static ca.mcgill.sel.classdiagram.ReferenceType.REGULAR;
import static ca.mcgill.sel.mistakedetection.tests.utils.Color.colorString;
import static ca.mcgill.sel.mistakedetection.tests.utils.infoservice.SourceTargetVerifier.sourceTargetWholePartMistakeTypesAndInfos;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.mistakedetection.MistakeDetectionConfig;
import ca.mcgill.sel.mistakedetection.tests.utils.Color;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedMistakeDetectionFormats;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeDetectionFormat;
import ca.mcgill.sel.mistakedetection.tests.utils.infoservice.MistakeDetectionInformationService;
import modelingassistant.SolutionElement;

/**
 * Provisional base class for all mistake detection tests, since JUnit 5 test {@code @Suite}s are not supported in the
 * current version of Eclipse.
 */
public abstract class MistakeDetectionBaseTest {

  /** Warnings printed to console. A true value means the warning is already printed and is therefore not repeated. */
  private static final Map<String, Boolean> warnings = new TreeMap<>();

  @BeforeAll
  public static void setup() {
    MistakeDetectionConfig.trackComparisonInstances = true;
  }

  @AfterAll
  public static void teardown() {
    testMdfsFromMdsAreCompatibleWithHumanValidatedMdfs();
    testSourcesTargetsWholesAndPartsAreProperlySpecified();

    warnings.forEach((text, isPrinted) -> {
      if (!isPrinted) {
        System.out.println(text);
      }
      warnings.put(text, true);
    });
  }

  /** Ensures that the MDFs inferred from the MDS are compatible with the human-validated ones. */
  static void testMdfsFromMdsAreCompatibleWithHumanValidatedMdfs() {
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

  /** Enforces the automated checks made by the SourceTargetVerifier. */
  static void testSourcesTargetsWholesAndPartsAreProperlySpecified() {
    sourceTargetWholePartMistakeTypesAndInfos().forEach((mt, mistakeInfos) -> {
      var mdf = HumanValidatedMistakeDetectionFormats.mappings.get(mt);
      mistakeInfos.forEach(mi -> {
        for (int i = 0; i < mdf.stud.size(); i++) {
          validateMistakeDetectionFormatMatchesElement(mdf.stud.get(i), mi.mistake.getStudentElements().get(i));
        }
        for (int i = 0; i < mdf.inst.size(); i++) {
          validateMistakeDetectionFormatMatchesElement(mdf.inst.get(i), mi.mistake.getInstructorElements().get(i));
        }
      });
    });
  }

  /**
   * Validates that the given mistake detection format string is consistent with the given solution element.
   * If not, a non-empty string warning will be returned to the caller.
   */
  private static void validateMistakeDetectionFormatMatchesElement(String format, SolutionElement elem) {
    final var specAs = " is specified as a "; // to save space below
    if (!(elem.getElement() instanceof AssociationEnd)) {
      return; // no need for assertion for other element types
    }
    var ae = (AssociationEnd) elem.getElement(); // use pattern matching in Java 17+
    var refType = ae.getReferenceType();
    if ((format.contains("whole") && format.contains("target"))
        || (format.contains("part") && format.contains("source"))) {
      return; // special case with multiple labels, always accept
    } else if (format.contains("target") && !ae.isNavigable()) {
      fail("The directed association end " + ae.getName() + specAs + "target but is not navigable!");
    } else if (format.contains("source") && ae.isNavigable()) {
      fail("The directed association end " + ae.getName() + specAs + "source but is navigable!");
    } else if (format.contains("whole") && List.of(AGGREGATION, COMPOSITION).contains(refType)) {
      fail("The aggregation/composition end " + ae.getName() + specAs + "whole but has a regular reference type!");
    } else if (format.contains("part") && refType == REGULAR) {
      fail("The association end " + ae.getName() + specAs + "part but has a " + refType.getName() + " reference type!");
    }
  }

}
