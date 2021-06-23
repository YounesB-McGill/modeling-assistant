package org.eclipse.acceleo.module.sample.main;

import java.util.stream.Collectors;
import learningcorpus.MistakeTypeCategory;

public class PythonGenerator {

  public static String generatePythonMistakeTypes(MistakeTypeCategory mtc) {
    if (mtc.getMistakeTypes().isEmpty()) {
      return "";
    }
    // missing_class := mt(n="Missing class"),
    return ", mistakeTypes=[\n"
        + mtc.getMistakeTypes().stream().map(mt ->
            " ".repeat(8) + underscorify(mt.getName()) + " := mt(n=\"" + mt.getName() + "\"),")
            .collect(Collectors.joining("\n"))
        + "\n    ]";
  }

  public static String underscorify(String s) {
    return s.replaceAll("\\((.+?)\\)", "").trim().replaceAll("/", "_").replaceAll("-", "_")
        .replaceAll("\\s+", "_").replaceAll("_+", "_").toLowerCase();
  }

}
