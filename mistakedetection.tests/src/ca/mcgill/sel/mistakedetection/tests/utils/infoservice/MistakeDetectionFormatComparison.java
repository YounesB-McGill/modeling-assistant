package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import static ca.mcgill.sel.mistakedetection.tests.utils.Color.colorString;
import ca.mcgill.sel.mistakedetection.tests.utils.Color;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedMistakeDetectionFormats;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeDetectionFormat;

public class MistakeDetectionFormatComparison extends MistakeDetectionInformationService {

  static final String CHECK = "√";
  static final String WARN = "!";
  static final String X = "X";

  private MistakeDetectionFormatComparison() {
    super("Mistake Detection Format Comparison (MDS vs Human-validated)");
  }

  @Override public String getOutput() {
    return title(name) + "\n" + mdfComparison();
  }

  public static MistakeDetectionFormatComparison get() {
    return new MistakeDetectionFormatComparison();
  }

  private static String mdfComparison() {
    var mdfsFromMds = getMistakeDetectionFormatsAsIsFromMistakeDetectionSystem();
    var humanValidatedMdfs = HumanValidatedMistakeDetectionFormats.mappings;
    var sb = new StringBuilder();
    mdfsFromMds.forEach((mt, mdf) -> {
      var mdfFromMdsShape = mdf.shape();
      var hvMdfShape = humanValidatedMdfs.getOrDefault(mt, MistakeDetectionFormat.emptyMdf()).shape();
      if (mdfFromMdsShape.equals(hvMdfShape)) {
        sb.append(CHECK + " " + mt.getName() + "\n\n");
      } else if (mdfFromMdsShape.isCompatibleWith(hvMdfShape)) {
        sb.append(colorString(Color.DARK_YELLOW, WARN + " " + mt.getName() + "\n~ " + mdf.shape().reduceToSimplestForm()
            + "\n\n"));
      } else {
        sb.append(colorString(Color.ORANGE, X + " " + mt.getName() + "\n" + mdf.shape() + "\n" + hvMdfShape + "\n\n"));
      }
    });
    return sb.toString();
  }

}
