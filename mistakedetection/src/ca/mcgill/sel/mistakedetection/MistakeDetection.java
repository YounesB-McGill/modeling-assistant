package ca.mcgill.sel.mistakedetection;

import java.util.List;

public class MistakeDetection {

  /**
   * Returns true if the input string is a software engineering term.
   */
  public static boolean isSoftwareEngineeringTerm(String s) {
    final var softwareEnginneringTerms = List.of("data", "record", "table", "info");
    for (var seTerm: softwareEnginneringTerms) {
      if (s.toLowerCase().contains(seTerm)) return true;
    }
    return false;
  }
  
  /**
   * Returns true if the input string is plural.
   */
  public static boolean isPlural(String s) {
    return s.toLowerCase().endsWith("s");
  }

}
