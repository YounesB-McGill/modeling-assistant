package ca.mcgill.sel.mistakedetection.tests.utils.dataclasses;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import ca.mcgill.sel.mistakedetection.Comparison;
import learningcorpus.MistakeType;
import learningcorpus.ParametrizedResponse;
import modelingassistant.Mistake;

public class MistakeInfo implements Comparable<MistakeInfo> {

  public static final String TABLE_HEADER =
      "MistakeType,StudentElems,InstructorElems,TotalElems,MaxParamRespNumParams,SolElemDescriptions\n";

  public final Mistake mistake;
  public final MistakeType mistakeType;
  public String caller = ""; // not final to allow for case where caller is ignored and is therefore set to empty string
  final int numStudentElems;
  final int numInstructorElems;
  final int totalElems;
  final List<Integer> paramRespParamNums;
  final int maxParamRespNumParams;
  final List<String> studentElementNames;
  final List<String> instructorElementNames;

  private static final Pattern PARAMETRIZED_RESPONSE_PARAMETER = Pattern.compile("\\$\\{.*?\\}");

  public MistakeInfo(Mistake mistake) {
    if (mistake.getStudentElements().isEmpty() && mistake.getInstructorElements().isEmpty()) {
      throw new IllegalArgumentException("Invalid mistake state: mistake does not have any solution elements");
    }
    this.mistake = mistake;
    mistakeType = mistake.getMistakeType();
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

  public MistakeInfo(Mistake mistake, Comparison comparison) {
    this(mistake);
    caller = comparison.caller;
  }

  private List<Integer> calculateParamRespParamNums() {
    var counts = mistake.getMistakeType().getFeedbacks().stream().filter(fb -> fb instanceof ParametrizedResponse)
        .map(pr -> PARAMETRIZED_RESPONSE_PARAMETER.matcher(((ParametrizedResponse) pr).getText()).results().count())
        .map(Math::toIntExact).sorted().collect(Collectors.toUnmodifiableList());
    if (counts.isEmpty()) {
      return List.of(0);
    }
    return counts;
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

  @Override public int compareTo(MistakeInfo other) {
    return mistakeType.compareTo(other.mistakeType);
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
