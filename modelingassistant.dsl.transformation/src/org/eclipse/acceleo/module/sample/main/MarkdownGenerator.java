package org.eclipse.acceleo.module.sample.main;

import java.util.stream.Collectors;
import modelingassistant.MistakeTypeCategory;
import modelingassistant.ModelingAssistant;

/**
 * Generates markdown for mistake types and their categories.
 * 
 * @author Younes Boubekeur
 * @generated NOT
 */
public class MarkdownGenerator {

  public static String generate(ModelingAssistant modelingAssistant) {
    var joiner = Collectors.joining("\n");
    var topLevelMistakeTypeCategories = modelingAssistant.getMistaketypecategory().stream()
        .filter(mtc -> mtc.getSupercategory() == null).collect(Collectors.toUnmodifiableList());
    return topLevelMistakeTypeCategories.stream().map(mtc -> getNestedTocOutputFor(mtc, 0)).collect(joiner)
        + "\n" + topLevelMistakeTypeCategories.stream().map(mtc -> getNestedBodyOutputFor(mtc, 0)).collect(joiner);
  }

  private static String getNestedTocOutputFor(MistakeTypeCategory mtc, int indentation) {
    var joiner = Collectors.joining("");
    return makeTocTitle(mtc.getName(), indentation)
        + mtc.getSubcategories().stream().map(sc -> getNestedTocOutputFor(sc, indentation + 3)).collect(joiner)
        + mtc.getMistaketype().stream().map(mt -> makeTocTitle(mt.getName(), indentation + 3)).collect(joiner);
  }

  private static String makeTocTitle(String name, int indentation) {
    return " ".repeat(indentation) + "1. [" + name + "](#" + dashify(name) + ")\n";
  }
  
  private static String getNestedBodyOutputFor(MistakeTypeCategory mtc, int indentation) {
    var joiner = Collectors.joining("\n");
    return makeBodyTitle(mtc.getName(), indentation)
        + mtc.getSubcategories().stream().map(sc -> getNestedBodyOutputFor(sc, indentation + 1)).collect(joiner)
        + mtc.getMistaketype().stream().map(mt -> makeBodyTitle(mt.getName(), indentation + 1)).collect(joiner);
  }

  private static String makeBodyTitle(String name, int indentation) {
    return "#".repeat(indentation + 2) + " " + clean(name) + "\n\n";
  }
  
  private static String dashify(String s) {
    return clean(s).replace(" ", "-").replace("/", "-").replace("--", "-").toLowerCase();
  }
  
  private static String clean(String s) {
    return s.replace("(", "").replace(")", "").replace(",", "").replace("yet incorrect", "");
  }

}
