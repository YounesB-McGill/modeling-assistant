package ca.mcgill.sel.mistakedetection;

import classdiagram.ClassdiagramFactory;
import classdiagram.Classifier;
import org.apache.commons.text.similarity.LevenshteinDistance;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.SolutionElement;

public class MistakeDetection {
  
  public static final ClassdiagramFactory CDF = ClassdiagramFactory.eINSTANCE;
  public static final ModelingassistantFactory MAF = ModelingassistantFactory.eINSTANCE;

  /** Maps nouns to true if they are plural, false otherwise. */
  static HashMap<String, Boolean> nounPluralStatus = new HashMap<String, Boolean>();
  
  EList<Mistake> mistakes;
  HashMap<Classifier, Classifier> mappedClassifier = new HashMap<Classifier, Classifier>();
  
  public void checkMistakeSoftwareEngineeringTerm(Classifier studentClassifier) {
    if (isSoftwareEngineeringTerm(studentClassifier.getName())) {
      SolutionElement s = MAF.createSolutionElement();
      s.setElement(studentClassifier);
      Mistake m = MAF.createMistake();
      m.setMistakeType(MistakeTypes.SOFTWARE_ENGINEERING_TERM);// Have a helper Method.
      m.getSolutionElements().add(s);
      mistakes.add(m);
    }
  }
  
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
    MaxentTagger tagger;
    Boolean bool = false;

    if (nounPluralStatus.containsKey(s)) {
      return nounPluralStatus.get(s);
    } else {
      try {
        tagger = new MaxentTagger("taggers/left3words-wsj-0-18.tagger");
        s = s.toLowerCase();
        String tagged = tagger.tagString(s);
        String[] str = tagged.split("/");
        String pluralTag = "NNS";
        if (str[1].contains(pluralTag)) {
          bool = true;
        }
      } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
      }
      s = s.substring(0, 1).toUpperCase() + s.substring(1);
      nounPluralStatus.put(s, bool);

      return bool;
    }
  }
  
  public static Mistake checkMistakePluralClassName(Classifier sClassifier) {
    if (isPlural(sClassifier.getName())) {
       var mistake = MAF.createMistake();
       mistake.setMistakeType(MistakeTypes.PLURAL_CLASS_NAME);
       
       // TODO
    }
    return null;
  }
  
  public static void checkMistakeClassSpelling(Classifier sClassifier, Classifier iClassifier) {
    int lDistance = levenshteinDistance(sClassifier.getName(), iClassifier.getName());
    if (lDistance != 0) {
      // Mistake m = new Mistake("Class Name Spelled wrong");
      // SolutionElement s = new SolutionElement(sClassifier);
      // m.getSolutionElements().add(s);
      // mistakes.add(m);
    }
  }
  
  public static int levenshteinDistance(String sClassName, String iClassName) {
    LevenshteinDistance ld = new LevenshteinDistance();
    return ld.apply(sClassName, iClassName);
  }

}
