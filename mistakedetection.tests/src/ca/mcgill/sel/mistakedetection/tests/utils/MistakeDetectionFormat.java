package ca.mcgill.sel.mistakedetection.tests.utils;

import java.util.ArrayList;
import java.util.List;
import modelingassistant.Mistake;

public class MistakeDetectionFormat {

  List<String> stud = new ArrayList<>();
  List<String> inst = new ArrayList<>();

  private MistakeDetectionFormat(Mistake mistake) {
    int[] cnt = {0, 0};
    mistake.getStudentElements().forEach(e -> stud.add(ElementDescription.fromElement(e).toShortString(cnt[0]++)));
    mistake.getInstructorElements().forEach(e -> inst.add(ElementDescription.fromElement(e).toShortString(cnt[1]++)));
    if (stud.size() == 1) {
      stud.set(0, stud.get(0).replace("0_", ""));
    }
    if (inst.size() == 1) {
      inst.set(0, inst.get(0).replace("0_", ""));
    }
  }

  private MistakeDetectionFormat(List<String> studentElemsDescriptions, List<String> instructorElemsDescriptions) {
    stud = studentElemsDescriptions;
    inst = instructorElemsDescriptions;
  }

  public static MistakeDetectionFormat forMistake(Mistake mistake) {
    if (HumanValidatedMistakeDetectionFormats.mappings.containsKey(mistake.getMistakeType())) {
      return HumanValidatedMistakeDetectionFormats.mappings.get(mistake.getMistakeType());
    }
    return new MistakeDetectionFormat(mistake);
  }

  public static MistakeDetectionFormat mdf(List<String> studentElemsDescriptions,
      List<String> instructorElemsDescriptions) {
    return new MistakeDetectionFormat(studentElemsDescriptions, instructorElemsDescriptions);
  }

  // eg, ([], ["cls"])
  @Override public String toString() {
    var studTag = stud.isEmpty() ? "" : "\"";
    var instTag = inst.isEmpty() ? "" : "\"";
    return "([" + studTag + String.join("\", \"", stud) + studTag + "], ["
        + instTag + String.join("\", \"", inst) + instTag + "])";
  }

}
