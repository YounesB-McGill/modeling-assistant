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
	
	int errorCount = 0;
	String error = "";
	
	
	@Test public void checkClassDiagramExists() {

	    
	    ClassdiagramPackage.eINSTANCE.eClass();
	    ModelingassistantPackage.eINSTANCE.eClass();
	    
	    try {
	    	var cdPath = "../modelingassistant/testmodels/car_sportscar_part_driver.domain_model.cdm";
	    	var resource = ResourceHelper.INSTANCE.loadResource(cdPath);
	    	var classDiagram = (ClassDiagram) resource.getContents().get(0);
	    	assertTrue(classDiagram!=null);
	    	
	    }
	    catch(Exception e) {
	    	errorCount += 1;
	    	error += "classDiagram not loaded properly. \n";
	    }
	    

	    
	    
	    
	  }
	
	@Test public void checkClassDiagramAssociations() {
		ClassdiagramPackage.eINSTANCE.eClass();
		ModelingassistantPackage.eINSTANCE.eClass();
		
		try {
			var cdPath = "../modelingassistant/testmodels/car_sportscar_part_driver.domain_model.cdm";
		    var resource = ResourceHelper.INSTANCE.loadResource(cdPath);
		    var classDiagram = (ClassDiagram) resource.getContents().get(0);
		    
		    assertTrue(classDiagram.getAssociations().size() >= 1);
		    assertTrue(classDiagram.getClasses().size() >= 2);
	    }
		catch(Exception e) {
			errorCount += 1;
			error += "Class Diagram has less than 1 Association or less than 2 Classes";
			
		}
	    
		
	}

}