package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import java.util.List;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedMistakeDetectionFormats;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeDetectionFormat;
import learningcorpus.mistaketypes.MistakeTypes;

public class MistakeDetectionFormatComparison extends MistakeDetectionInformationService {

  private static final String CHECK = "√";
  private static final String X = "X";

  private MistakeDetectionFormatComparison() {
    super("Mistake Dectection Format Comparison (MDS vs Human-validated)");
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
      var hvMdfShape = humanValidatedMdfs.getOrDefault(mt, MistakeDetectionFormat.mdf(List.of(), List.of())).shape();
      if (mdfFromMdsShape.equals(hvMdfShape)) {
        //sb.append(CHECK + " " + mt.getName() + "\n\n");
      } else {
        sb.append(X + " " + mt.getName() + "\n" + mdf.shape() + "\n" + hvMdfShape + "\n\n");
      }
    });

    // debug only
    var mt = MistakeTypes.USING_ASSOC_INSTEAD_OF_COMPOSITION;
    allMistakes().filter(m -> m.getMistakeType().equals(mt))
//      .forEach(m ->
//        sb.append("> " + m.getStudentElements().stream().map(e -> e.getElement()).collect(Collectors.toUnmodifiableList())
//             + ", " + m.getInstructorElements().stream().map(e -> e.getElement()).collect(Collectors.toUnmodifiableList()) + "\n"))
    ;



    return sb.toString();
  }

}
