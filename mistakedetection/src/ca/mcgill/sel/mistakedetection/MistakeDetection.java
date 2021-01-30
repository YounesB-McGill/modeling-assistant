package ca.mcgill.sel.mistakedetection;

import classdiagram.ClassdiagramFactory;
import classdiagram.Classifier;
import java.util.List;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;

public class MistakeDetection {
  
  public static final ClassdiagramFactory CDF = ClassdiagramFactory.eINSTANCE;
  public static final ModelingassistantFactory MAF = ModelingassistantFactory.eINSTANCE;

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
  
  public static Mistake checkMistakePluralClassName(Classifier sClassifier) {
    if (isPlural(sClassifier.getName())) {
       var mistake = MAF.createMistake();
       mistake.setMistakeType(MistakeTypes.PLURAL_CLASS_NAME);
       
       // TODO
    }
    return null;
 }


}
