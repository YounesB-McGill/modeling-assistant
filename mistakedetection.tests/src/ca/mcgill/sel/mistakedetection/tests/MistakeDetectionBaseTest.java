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
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedMistakeElementGroups;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeElementGroup;
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
    testMegsFromMdsAreCompatibleWithHumanValidatedMegs();
    testSourcesTargetsWholesAndPartsAreProperlySpecified();

    printWarnings();
  }

  /** Ensures that the MEGs inferred from the MDS are compatible with the human-validated ones. */
  static void testMegsFromMdsAreCompatibleWithHumanValidatedMegs() {
    var megsFromMds = MistakeDetectionInformationService.getMistakeElementGroupsAsIsFromMistakeDetectionSystem();
    var humanValidatedMegs = HumanValidatedMistakeElementGroups.mappings;
    megsFromMds.forEach((mti, meg) -> {
      var megFromMdsShape = meg.shape();
      var hvMegShape = humanValidatedMegs.getOrDefault(mti.mistakeType, MistakeElementGroup.EMPTY_MEG).shape();
      if (!megFromMdsShape.equals(hvMegShape)) {
        var source = "unknown source";
        if (!mti.mistakeInfo.caller.isEmpty()) {
          source = mti.mistakeInfo.caller;
        }
        if (megFromMdsShape.isCompatibleWith(hvMegShape)) {
          if (!HumanValidatedMistakeElementGroups.exemptions.contains(mti.mistakeType)) {
            warnings.putIfAbsent(colorString(Color.DARK_YELLOW, "! Double-check MEG for " + mti.mistakeType.getName()
                + ": " + meg.shape().reduceToSimplestForm() + ".\n MEG created from " + source), false);
          }
        } else {
          fail("X MEG for " + mti.mistakeType.getName() + " is " + meg.shape() + " but expected " + hvMegShape
              + ".\n MEG created from " + source);
        }
      }
    });
  }

  /** Enforces the automated checks made by the SourceTargetVerifier. */
  static void testSourcesTargetsWholesAndPartsAreProperlySpecified() {
    sourceTargetWholePartMistakeTypesAndInfos().forEach((mt, mistakeInfos) -> {
      var meg = HumanValidatedMistakeElementGroups.mappings.get(mt);
      mistakeInfos.forEach(mi -> {
        for (int i = 0; i < meg.stud.size(); i++) {
          validateMistakeElementGroupMatchesElement(meg.stud.get(i), mi.mistake.getStudentElements().get(i));
        }
        for (int i = 0; i < meg.inst.size(); i++) {
          validateMistakeElementGroupMatchesElement(meg.inst.get(i), mi.mistake.getInstructorElements().get(i));
        }
      });
    });
  }

  /**
   * Validates that the given mistake element format string is consistent with the given solution element.
   * If not, a test failure with the inconsistency will be reported.
   */
  private static void validateMistakeElementGroupMatchesElement(String format, SolutionElement elem) {
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

  private static void printWarnings() {
    warnings.forEach((text, isPrinted) -> {
      if (!isPrinted) {
        System.out.println(text);
      }
      warnings.put(text, true);
    });
  }

}
