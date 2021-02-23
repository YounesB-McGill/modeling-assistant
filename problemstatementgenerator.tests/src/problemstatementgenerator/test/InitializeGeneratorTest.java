package problemstatementgenerator.test;

import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.util.ResourceHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class InitializeGeneratorTest {
	
	
	@Test public void CheckInstructorSolution() {

	    
	    ClassdiagramPackage.eINSTANCE.eClass();
	    ModelingassistantPackage.eINSTANCE.eClass();
	    
	    var cdPath = "../modelingassistant/testmodels/car_sportscar_part_driver.domain_model.cdm";
	    
	    var resource = ResourceHelper.INSTANCE.loadResource(cdPath);
	    
	    var classDiagram = (ClassDiagram) resource.getContents().get(0);

	    assertTrue( )
	    
	    
	  }

}
