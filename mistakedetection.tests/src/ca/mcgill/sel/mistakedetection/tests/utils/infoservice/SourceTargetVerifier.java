package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import static ca.mcgill.sel.mistakedetection.tests.utils.infoservice.MappingToMistakeInfos.mapToMistakeInfos;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedMistakeDetectionFormats;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.ElementDescription;

/**
 * Helps verify that the source, target, whole, and part classes and association ends are properly defined in the
 * Learning Corpus and Mistake Detection Systems.<br>
 * <br>
 * For classes, the concepts are defined as follows (Umple syntax):
 * <pre>
 * Target <- Source
 * Whole <@>- Part
 * </pre>
 *
 * For association ends, the following convention is used:<br>
 * <br>
 * A source association end refers to the source but is contained in the target<br>
 * A target association end refers to the target but is contained in the source<br>
 * <br>
 * A part association end refers to the part but is contained in the whole<br>
 * A whole association end refers to the whole but is contained in the part<br>
 * <br>
 * Examples:
 * <pre>
 * AttendanceRole <- Student // Target, Source
 * AttendanceRole.student is the source association end with navigable set to false
 * Student.attendanceRole is the target association end, visually shown with an arrow
 *
 * Car <@>- Engine // Whole, Part
 * Car.engine is the part association end with composition reference type
 * Engine.car (visually shown on the side with the diamond) is the whole association end
 * </pre>
 *
 * @author Younes Boubekeur
 * @author Prabhsimran Singh
 */
public class SourceTargetVerifier extends MistakeDetectionInformationService {

  private SourceTargetVerifier() {
    super("Source-Target and Whole-Part verifier");
  }

  @Override
  public String getOutput() {
    final var mdfs = HumanValidatedMistakeDetectionFormats.mappings;
    var relevantMistakeTypesAndInfos = mapToMistakeInfos().entrySet().stream()
        .filter(e -> mdfs.get(e.getKey()).toString().toLowerCase().contains("target")
            || mdfs.get(e.getKey()).toString().toLowerCase().contains("whole"))
        .collect(Collectors.toMap(Map.Entry::getKey,
            Map.Entry::getValue,
            MistakeDetectionInformationService::setUnion,
            TreeMap::new));
    var sb = new StringBuilder();
    relevantMistakeTypesAndInfos.forEach((mt, mis) -> {
      var mdf = mdfs.get(mt);
      sb.append(mt.getName() + ": \n");
      mis.forEach(mi -> {
        var studElems = mi.mistake.getStudentElements();
        var instElems = mi.mistake.getInstructorElements();
        for (int i = 0; i < mdf.stud.size(); i++) {
          sb.append(mdf.stud.get(i) + ": " + ElementDescription.fromElement(studElems.get(i)));
          if (i < mdf.stud.size() - 1) {
            sb.append(", ");
          }
        }
        for (int i = 0; i < mdf.inst.size(); i++) {
          sb.append(mdf.inst.get(i) + ": " + ElementDescription.fromElement(instElems.get(i)));
          if (i < mdf.inst.size() - 1) {
            sb.append(", ");
          }
        }
        sb.append("\n");
      });
      sb.append("\n\n");
    });
    return title(name) + "\n" + sb.toString();
  }

  public static SourceTargetVerifier get() {
    return new SourceTargetVerifier();
  }

}
