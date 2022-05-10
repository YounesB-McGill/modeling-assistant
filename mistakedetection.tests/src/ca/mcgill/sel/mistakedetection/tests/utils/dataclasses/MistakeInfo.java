package ca.mcgill.sel.mistakedetection.tests.utils.dataclasses;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import learningcorpus.ParametrizedResponse;
import modelingassistant.Mistake;

public class MistakeInfo {

  public static final String TABLE_HEADER =
      "MistakeType,StudentElems,InstructorElems,TotalElems,MaxParamRespNumParams,SolElemDescriptions\n";

  public final Mistake mistake;
  final int numStudentElems;
  final int numInstructorElems;
  final int totalElems;
  final List<Integer> paramRespParamNums;
  final int maxParamRespNumParams;
  final List<String> studentElementNames;
  final List<String> instructorElementNames;

  public MistakeInfo(Mistake mistake) {
    this.mistake = mistake;
    numStudentElems = mistake.getStudentElements().size();
    numInstructorElems = mistake.getInstructorElements().size();
    totalElems = numStudentElems + numInstructorElems;
    paramRespParamNums = calculateParamRespParamNums();
    maxParamRespNumParams = Collections.max(paramRespParamNums);
    studentElementNames = mistake.getStudentElements().stream().map(e -> e.getElement().getName())
        .collect(Collectors.toUnmodifiableList());
    instructorElementNames = mistake.getInstructorElements().stream().map(e -> e.getElement().getName())
        .collect(Collectors.toUnmodifiableList());
  }

  private List<Integer> calculateParamRespParamNums() {
    var counts = mistake.getMistakeType().getFeedbacks().stream().filter(fb -> fb instanceof ParametrizedResponse)
        .map(pr -> Pattern.compile("\\$\\{.*?\\}").matcher(((ParametrizedResponse) pr).getText()).results().count())
        .map(Math::toIntExact).collect(Collectors.toList()); // use mutable list to allow sorting in next step
    if (counts.isEmpty()) {
      return List.of(0);
    }
    Collections.sort(counts);
    return Collections.unmodifiableList(counts);
  }

  String firstColumnEntries() {
    return mistake.getMistakeType().getName() + "," + numStudentElems + "," + numInstructorElems + "," + totalElems
        + "," + maxParamRespNumParams;
  }

  @Override public String toString() {
    return firstColumnEntries() + ","
        + mistake.getStudentElements().stream().map(e -> ElementDescription.fromElement(e).toString())
            .collect(Collectors.joining(",")) + ","
        + mistake.getInstructorElements().stream().map(e -> ElementDescription.fromElement(e).toString())
            .collect(Collectors.joining(","));
  }

  // value-based equality based on some fields only, to avoid set duplicates
  @Override public boolean equals(Object o) {
    if (o instanceof MistakeInfo) {
      var mistakeInfo = (MistakeInfo) o;
      return firstColumnEntries().equals(mistakeInfo.firstColumnEntries())
          && studentElementNames.equals(mistakeInfo.studentElementNames)
          && instructorElementNames.equals(mistakeInfo.instructorElementNames);
    }
    return false;
  }

  @Override public int hashCode() {
    return firstColumnEntries().hashCode() + studentElementNames.hashCode() + instructorElementNames.hashCode();
  }

  /** Represents the general structure of a MistakeInfo, useful to avoid duplicates of similar MistakeInfo instances. */
  public static class Shape extends MistakeInfo {
    public Shape(Mistake mistake) {
      super(mistake);
    }

    // value-based equality based on some fields only, to avoid set duplicates
    @Override public boolean equals(Object o) {
      if (o instanceof MistakeInfo) {
        var mistakeInfo = (MistakeInfo) o;
        return firstColumnEntries().equals(mistakeInfo.firstColumnEntries());
      }
      return false;
    }

    @Override public int hashCode() {
      return firstColumnEntries().hashCode();
    }
  }

}
