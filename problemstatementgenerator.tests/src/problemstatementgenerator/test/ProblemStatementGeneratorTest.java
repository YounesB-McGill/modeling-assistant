package problemstatementgenerator.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.CdmPackage;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.util.ResourceHelper;
import problemstatementgenerator.ProblemStatementGenerator;

public class ProblemStatementGeneratorTest {

  @Test public void checkClassDiagramExists() {
    CdmPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();

    var cdPath = "../modelingassistant/testmodels/car_sportscar_part_driver.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdPath);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var problemStatement = ProblemStatementGenerator.generateProblemStatement(classDiagram);
    assertTrue(Character.isUpperCase(problemStatement.charAt(0)));
    assertTrue(problemStatement.endsWith("."));
    List.of("Car", "Part", "Driver").forEach(s ->
        assertTrue(problemStatement.toLowerCase().contains(s.toLowerCase())));
  }

}
