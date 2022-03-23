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

  public Mistake mistake;
  int instructorElems;
  int studentElems;
  int totalElems;
  List<Integer> paramRespParamNums;
  int maxParamRespNumParams;

  public MistakeInfo(Mistake mistake) {
    this.mistake = mistake;
    instructorElems = mistake.getInstructorElements().size();
    studentElems = mistake.getStudentElements().size();
    totalElems = instructorElems + studentElems;
    paramRespParamNums = calculateParamRespParamNums();
    maxParamRespNumParams = Collections.max(paramRespParamNums);
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

  private String firstColumnEntries() {
    return mistake.getMistakeType().getName() + "," + studentElems + "," + instructorElems + "," + totalElems + ","
        + maxParamRespNumParams;
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
      return firstColumnEntries().equals(((MistakeInfo) o).firstColumnEntries());
    }
    return false;
  }

  @Override public int hashCode() {
    return firstColumnEntries().hashCode();
  }

}
