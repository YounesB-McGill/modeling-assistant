package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import static ca.mcgill.sel.mistakedetection.tests.utils.Color.colorString;
import ca.mcgill.sel.mistakedetection.tests.utils.Color;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedMistakeElementGroups;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeElementGroup;

public class MistakeElementGroupComparison extends MistakeDetectionInformationService {

  static final String CHECK = "√";
  static final String WARN = "!";
  static final String X = "X";

  private MistakeElementGroupComparison() {
    super("Mistake Detection Format Comparison (MDS vs Human-validated)");
  }

  @Override public String getOutput() {
    return title(name) + "\n" + megComparison();
  }

  public static MistakeElementGroupComparison get() {
    return new MistakeElementGroupComparison();
  }

  private static String megComparison() {
    var megsFromMds = getMistakeElementGroupsAsIsFromMistakeDetectionSystem();
    var humanValidatedMegs = HumanValidatedMistakeElementGroups.mappings;
    var sb = new StringBuilder();
    megsFromMds.forEach((mti, meg) -> {
      var megFromMdsShape = meg.shape();
      var hvMegShape = humanValidatedMegs.getOrDefault(mti.mistakeType, MistakeElementGroup.EMPTY_MEG).shape();
      var source = "unknown source";
      if (!mti.mistakeInfo.caller.isEmpty()) {
        source = mti.mistakeInfo.caller;
      }
      if (megFromMdsShape.equals(hvMegShape)
          || (HumanValidatedMistakeElementGroups.exemptions.contains(mti.mistakeType)
              && megFromMdsShape.isCompatibleWith(hvMegShape))) {
        sb.append(CHECK + " " + mti.mistakeType.getName() + "\n\n");
      } else if (megFromMdsShape.isCompatibleWith(hvMegShape)) {
        sb.append(colorString(Color.DARK_YELLOW, WARN + " " + mti.mistakeType.getName() + "\n~ "
            + meg.shape().reduceToSimplestForm() + "\n  MEG created from " + source + "\n\n"));
      } else {
        sb.append(colorString(Color.ORANGE, X + " " + mti.mistakeType.getName()  + "\n" + meg.shape() + "\n"
            + hvMegShape + "\n  MEG created from " + source + "\n\n"));
      }
    });
    return sb.toString();
  }

}
