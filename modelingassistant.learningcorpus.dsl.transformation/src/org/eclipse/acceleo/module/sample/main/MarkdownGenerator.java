package org.eclipse.acceleo.module.sample.main;

import java.util.stream.Collectors;
import learningcorpus.LearningCorpus;
import learningcorpus.MistakeTypeCategory;

/**
 * Generates markdown for mistake types and their categories.
 *
 * @author Younes Boubekeur
 * @generated NOT
 */
public class MarkdownGenerator {

  /**
   * The maximum number of # signs in a markdown ATX heading.
   *
   * @see <a href="https://github.github.com/gfm/#atx-heading">github.github.com/gfm/#atx-heading</a>
   */
  public static final int MAX_NUM_OF_HASHES_IN_HEADING = 6;

  /** Generates markdown for the given modeling assistant instance. */
  public static String generate(LearningCorpus learningCorpus) {
    var joiner = Collectors.joining("\n");
    var topLevelMTCs = learningCorpus.getTopLevelMistakeTypeCategories();
    return topLevelMTCs.stream().map(mtc -> getNestedTocOutputFor(mtc, 0)).collect(joiner)
        + "\n" + topLevelMTCs.stream().map(mtc -> getNestedBodyOutputFor(mtc, 0)).collect(joiner);
  }

  /** Returns the nested table of contents output for the input in a recursive way. */
  private static String getNestedTocOutputFor(MistakeTypeCategory mtc, int indentation) {
    var joiner = Collectors.joining("");
    return makeTocTitle(mtc.getName(), indentation)
        + mtc.getSubcategories().stream().map(sc -> getNestedTocOutputFor(sc, indentation + 3)).collect(joiner)
        + mtc.getMistakeTypes().stream().map(mt -> makeTocTitle(mt.getName(), indentation + 3)).collect(joiner);
  }

  private static String makeTocTitle(String name, int indentation) {
    return " ".repeat(indentation) + "1. [" + name + "](#" + dashify(name) + ")\n";
  }

  /** Returns the nested body output for the input in a recursive way. */
  private static String getNestedBodyOutputFor(MistakeTypeCategory mtc, int indentation) {
    var joiner = Collectors.joining("\n");
    return makeBodyTitle(mtc.getName(), indentation)
        + mtc.getSubcategories().stream().map(sc -> getNestedBodyOutputFor(sc, indentation + 1)).collect(joiner)
        + mtc.getMistakeTypes().stream().map(mt -> makeBodyTitle(mt.getName(), indentation + 1)).collect(joiner);
  }

  private static String makeBodyTitle(String name, int indentation) {
    var numHashes = indentation + 2;
    return (numHashes <= MAX_NUM_OF_HASHES_IN_HEADING?
        "#".repeat(numHashes) + " " + clean(name) :
        "**" + clean(name) + "**")
        + "\n\n" ;
  }

  private static String dashify(String s) {
    return clean(s).replace(" ", "-").replace("/", "-").replace("--", "-").toLowerCase();
  }

  private static String clean(String s) {
    return s.replace("(", "").replace(")", "").replace(",", "").replace("yet incorrect", "");
  }

}
