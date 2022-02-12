package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import static ca.mcgill.sel.mistakedetection.tests.utils.MistakeDetectionInformationServicesForLearningCorpus.MAX_LINE_LENGTH;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import learningcorpus.ElementType;
import learningcorpus.MistakeType;

public class PythonLearningCorpusInitializationCode extends MistakeDetectionInformationService {

  String imports;
  String learningItems;

  public PythonLearningCorpusInitializationCode() {
    super("Python learning corpus initialization code (imports/learning items)");
    init();
  }

  @Override public String getOutput() {
    return title(name) + "\n" + imports + "\n" + learningItems;
  }

  public static PythonLearningCorpusInitializationCode get() {
    return new PythonLearningCorpusInitializationCode();
  }

  /** Generates Pyecore-compatible code to generate the learning corpus. This can be improved. */
  public void init() {
    var mistakesToTypes = mapMistakesToLearningCorpusElementTypes(instructorAndStudentElems);
    var typesToMistakes = new TreeMap<ElementType, Set<MistakeType>>();
    mistakesToTypes.forEach((m, types) -> types.forEach(t -> {
      if (typesToMistakes.containsKey(t)) {
        typesToMistakes.get(t).add(m);
      } else {
        typesToMistakes.put(t, new HashSet<>(List.of(m)));
      }
    }));
    var imports = new StringBuilder(
        "from corpus_definition import (corpus as corpus_def, mts_by_priority as mts_by_priority_def, ");
    var learningItems = new StringBuilder();
    typesToMistakes.forEach((t, mistakes) -> {
      learningItems.append(underscorify(t.getName()).replace("class", "class_") + " = LearningItem(name=\""
          + t.getName().replaceAll("\\s+", "") + "\", learningCorpus=corpus, mistakeTypes=[\n    ");
      mistakes.forEach(mistake -> {
        var m = underscorify(mistake.getName());
        if (learningItems.length() - learningItems.lastIndexOf("\n") + m.length() + 2 <= MAX_LINE_LENGTH) {
          learningItems.append(m + ", "); // MAX_LINE_LENGTH not exceeded, so append to same line
        } else {
          learningItems.deleteCharAt(learningItems.lastIndexOf(" ")).append("\n    " + m + ", "); // append to next line
        }
        if (imports.indexOf(m + ",") == -1) { // not found according to StringBuilder API
          if (imports.length() - imports.lastIndexOf("\n") + m.length() + 2 <= MAX_LINE_LENGTH) {
            imports.append(m + ", ");
          } else {
            imports.deleteCharAt(imports.lastIndexOf(" ")).append("\n    " + m + ", ");
          }
        }
      });
      learningItems.deleteCharAt(learningItems.lastIndexOf(",")).deleteCharAt(learningItems.lastIndexOf(" "))
          .append("])\n");
    });
    imports.deleteCharAt(imports.lastIndexOf(",")).deleteCharAt(imports.lastIndexOf(" ")).append(")\n");

    this.imports = imports.toString();
    this.learningItems = learningItems.toString();
  }

}
