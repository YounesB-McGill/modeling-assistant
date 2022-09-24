package modelingassistant.restapi;

import static ca.mcgill.sel.mistakedetection.MistakeDetection.compare;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.mcgill.sel.mistakedetection.MistakeDetectionConfig;
import modelingassistant.ModelingAssistant;

/**
 * Mistake detection data transfer object (DTO), to be used primarily by the REST API.
 *
 * @author Prabhsimran Singh
 * @author Younes Boubekeur
 */
public class MistakeDetection {
  /** The XMI Ecore representation of the modeling assistant instance. */
  private final String modelingAssistantXmi;

  /** Constructs a MistakeDetection instance with the given modeling assistant XMI. */
  public MistakeDetection(String modelingAssistantXmi) {
    this.modelingAssistantXmi = modelingAssistantXmi;
  }

  /** Returns the modeling assistant XMI string. */
  public String getModelingAssistantXmi() {
    return modelingAssistantXmi;
  }

  /**
   * Wrapper for MistakeDetectionController.detectMistakes(), intended to be called from Eclipse for easier testing.
   *
   * @param modelingAssistantXmi
   * @return a REST API MistakeDetection DTO with a modeling assistant XMI that contains the detected mistakes
   */
  public static MistakeDetection detectMistakes(String modelingAssistantXmi) {
    var oldTaggerPath = MistakeDetectionConfig.taggerPath;
    var mdc = new MistakeDetectionController();
    MistakeDetectionConfig.taggerPath = "../mistakedetection/" + oldTaggerPath;
    return mdc.detectMistakes(modelingAssistantXmi);
  }
}

/**
 * The mistake detection REST API controller.
 *
 * @author Younes Boubekeur
 */
@RestController
class MistakeDetectionController {

  static {
    // Use this tagger when called from Maven
    MistakeDetectionConfig.taggerPath = "../mistakedetection/taggers/english-bidirectional-distsim.tagger";
  }

  /**
   * Returns a MistakeDetection DTO with a modeling assistant string that contains all detected mistakes.
   * This is a wrapper for the compare() method.
   *
   * @param modelingAssistantXmi
   */
  @GetMapping("/detectmistakes")
  public MistakeDetection detectMistakes(@RequestParam(value = "modelingassistant") String modelingAssistantXmi) {
    // TODO Optimize this to only detect mistakes in active problem statements

    // Print detailed input and output while integration test is still being debugged
    var dashes = "-".repeat(80);
    System.out.println("\n\n" + dashes + "\n\nInput MA:\n\n" + modelingAssistantXmi + "\n\n" + dashes + "\n\n");

    var modelingAssistant = ModelingAssistant.fromEcoreString(modelingAssistantXmi);

    // Uncomment for detailed output on each mistake
    //System.out.println("\n\nSolutions before:");
    //modelingAssistant.getSolutions().forEach(sol -> {
    //  System.out.println(sol + ", " + sol.eResource());
    //  sol.getMistakes().forEach(mistake ->
    //    System.out.println(mistake.getMistakeType().getName() + ": " + mistake + ", " + mistake.eResource()));
    //});

    modelingAssistant.getProblemStatements().forEach(ps -> {
      ps.getStudentSolutions().forEach(studentSolution -> compare(ps.getInstructorSolution(), studentSolution).log());
    });

    // Uncomment for detailed output on each mistake
    //System.out.println("\n\nSolutions after:");
    //modelingAssistant.getSolutions().forEach(sol -> {
    //  System.out.println(sol + ", " + sol.eResource());
    //  sol.getMistakes().forEach(mistake ->
    //    System.out.println(mistake.getMistakeType().getName() + ": " + mistake + ", " + mistake.eResource()));
    //});

    System.out.println("\n\n" + dashes + "\n\nReturning MA:\n\n" + modelingAssistant.toEcoreString());

    return new MistakeDetection(modelingAssistant.toEcoreString());
  }

}
