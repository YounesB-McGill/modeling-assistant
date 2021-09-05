#!/usr/bin/env python3

from fileserdes import save_to_files
from corpus_definition import corpus
from learningcorpus import LearningCorpus, MistakeTypeCategory

MAX_NUM_OF_HASHES_IN_HEADING = 6  # See https://github.github.com/gfm/#atx-heading

"""
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
"""

def generate_markdown(lc: LearningCorpus) -> str:
    """
    Generate Markdown table-of-contents from input learning corpus.
    """


def generate_python_mts(mtc: MistakeTypeCategory) -> str:
    """
    Generate mistake types from input mistake type category.
    """


def underscorify(s: str) -> str:
    """
    Underscorifies and capitalizes the given input string, omitting any information in parentheses.
    Example: "Extra (redundant) class" -> "EXTRA_CLASS"
    """






if __name__ == "__main__":
    "Main entry point."
    save_to_files({"modelingassistant.learningcorpus.dsl.instances/default.learningcorpus": corpus})
    print(f"Created learning corpus with {len(corpus.mistakeTypes())} mistake types.")
