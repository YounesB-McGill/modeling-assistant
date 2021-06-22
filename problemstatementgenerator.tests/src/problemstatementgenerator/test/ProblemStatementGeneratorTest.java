package problemstatementgenerator.test;

import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.CdmPackage;
import modelingassistant.ModelingassistantPackage;
import problemstatementgenerator.ProblemStatementGenerator;

public class ProblemStatementGeneratorTest {

  @Test public void checkClassDiagramExists() {
    CdmPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();

    var cdPath = "../modelingassistant/testmodels/car_sportscar_part_driver.domain_model.cdm";
    var classDiagram = cdmFromFile(cdPath);
    var problemStatement = ProblemStatementGenerator.generateProblemStatement(classDiagram);
    assertTrue(Character.isUpperCase(problemStatement.charAt(0)));
    assertTrue(problemStatement.endsWith("."));
    List.of("Car", "Part", "Driver").forEach(s ->
        assertTrue(problemStatement.toLowerCase().contains(s.toLowerCase())));
  }

}
