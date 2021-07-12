package modelingassistant.restapi;

import static ca.mcgill.sel.mistakedetection.MistakeDetection.compare;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.mcgill.sel.mistakedetection.MistakeDetectionConfig;
import modelingassistant.ModelingAssistant;

public class MistakeDetection {
  private final String modelingAssistantXmi;

  public MistakeDetection(String modelingAssistantXmi) {
    this.modelingAssistantXmi = modelingAssistantXmi;
  }

  public String getModelingAssistantXmi() {
    return modelingAssistantXmi;
  }
}

@RestController
class MistakeDetectionController {
  @GetMapping("/detectmistakes")
  public MistakeDetection detectMistakes(@RequestParam(value = "modelingassistant") String modelingAssistantXmi) {
    // TODO Optimize this to only detect mistakes in active problem statements
    MistakeDetectionConfig.taggerPath = "../mistakedetection/" + MistakeDetectionConfig.taggerPath;
    var modelingAssistant = ModelingAssistant.fromEcoreString(modelingAssistantXmi);
    modelingAssistant.getProblemStatements().forEach(ps -> {
      ps.getStudentSolutions().forEach(studentSolution -> compare(ps.getInstructorSolution(), studentSolution));
    });
    return new MistakeDetection(modelingAssistant.toEcoreString());
  }
}
