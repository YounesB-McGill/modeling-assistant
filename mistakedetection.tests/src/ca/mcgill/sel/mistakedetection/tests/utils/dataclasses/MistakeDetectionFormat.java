package ca.mcgill.sel.mistakedetection.tests.utils.dataclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedMistakeDetectionFormats;
import modelingassistant.Mistake;

public class MistakeDetectionFormat {

  public List<String> stud = new ArrayList<>();
  public List<String> inst = new ArrayList<>();

  public MistakeDetectionFormat(Mistake mistake) {
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

  public MistakeDetectionFormat.Shape shape() {
    return new MistakeDetectionFormat.Shape(this);
  }

  // eg, ([], ["cls"])
  @Override public String toString() {
    var studTag = stud.isEmpty() ? "" : "\"";
    var instTag = inst.isEmpty() ? "" : "\"";
    return "([" + studTag + String.join("\", \"", stud) + studTag + "], ["
        + instTag + String.join("\", \"", inst) + instTag + "])";
  }

  @Override public boolean equals(Object o) {
    if (!(o instanceof MistakeDetectionFormat)) {
      return false;
    }
    var other = (MistakeDetectionFormat) o;
    return stud.equals(other.stud) && inst.equals(other.inst);
  }

  @Override public int hashCode() {
    return 17 * stud.hashCode() + 31 * inst.hashCode();
  }

  /** The shape of the mistake detection format, which is the lists of its student and instructor metatypes. */
  public static class Shape {

    public final List<String> stud;
    public final List<String> inst;

    public Shape(MistakeDetectionFormat mdf) {
      stud = mapToShape(mdf.stud);
      inst = mapToShape(mdf.inst);
    }

    /** Maps type lists, eg, ["compos", "cls", "cls", "cls"] -> ["compos", "cls*"]. */
    static List<String> mapToShape(List<String> elems) {
      var types = elems.stream().map(e -> {
        var splitElem = e.split("_");
        return splitElem[splitElem.length - 1]; // return the type, eg, cls
      }).collect(Collectors.toUnmodifiableList());
      /*
       * Working backwards, collapse duplicate types into one vararg type with a *, for example:
       *
       * ["compos", "cls", "cls", "cls"] -> ["compos", "cls", "cls*"] -> ["compos", "cls*"]
       */
      List<String> shape = new ArrayList<>(types);
      int i = types.size() - 1;
      while (i > 0) {
        var first = shape.get(i - 1);
        var second = shape.get(i);
        if (first.equals(second.replace("*", ""))) {
          shape.set(i - 1, first + "*");
          shape.remove(i);
        } else {
          break;
        }
        i--;
      }
      return shape;
    }

    @Override public String toString() {
      var studTag = stud.isEmpty() ? "" : "\"";
      var instTag = inst.isEmpty() ? "" : "\"";
      return "([" + studTag + String.join("\", \"", stud) + studTag + "], ["
          + instTag + String.join("\", \"", inst) + instTag + "])";
    }

    @Override public boolean equals(Object o) {
      if (!(o instanceof MistakeDetectionFormat.Shape)) {
        return false;
      }
      var other = (MistakeDetectionFormat.Shape) o;
      return stud.equals(other.stud) && inst.equals(other.inst);
    }

    @Override public int hashCode() {
      return 17 * stud.hashCode() + 31 * inst.hashCode();
    }

  }

}
