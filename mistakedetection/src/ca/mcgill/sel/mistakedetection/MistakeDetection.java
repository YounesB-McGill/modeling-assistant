package ca.mcgill.sel.mistakedetection;

import classdiagram.ClassdiagramFactory;
import classdiagram.Classifier;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.SolutionElement;
import org.eclipse.emf.common.util.EList;

public class MistakeDetection {
  
  public static final ClassdiagramFactory CDF = ClassdiagramFactory.eINSTANCE;
  public static final ModelingassistantFactory MAF = ModelingassistantFactory.eINSTANCE;

  EList<Mistake> mistakes;
  HashMap<Classifier, Classifier> mappedClassifier = new HashMap<Classifier, Classifier>();
  
  public void checkMistakeSoftwareEngineeringTerm(Classifier sClassifier) {
	  if (isSoftwareEngineeringTerm(sClassifier.getName())) {
//		  Mistake m = new Mistake("Class Name contains software engineering term");
//	      SolutionElement s = new SolutionElement(sClassifier);
//	      m.getSolutionElements().add(s);
//	      mistakes.add(m);
		  SolutionElement s = MAF.createSolutionElement();
		  s.setElement(sClassifier);
		  Mistake m =MAF.createMistake();
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
