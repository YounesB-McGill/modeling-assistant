package problemstatementgenerator;

import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.util.ResourceHelper;

public class ProblemStatementGenerator {

	public static void main(String[] args) {
						
		ClassdiagramPackage.eINSTANCE.eClass();
	    ModelingassistantPackage.eINSTANCE.eClass();
	    
	    var cdPath = "../modelingassistant/testmodels/car_sportscar_part_driver.domain_model.cdm";
	    
	    var resource = ResourceHelper.INSTANCE.loadResource(cdPath);
	    
	    var classDiagram = (ClassDiagram) resource.getContents().get(0);
	    
	    printClasses(classDiagram);

	}
	
	public static void printClasses(ClassDiagram cd){
		
		for(var clazz : cd.getClasses()) {
			
			System.out.println(clazz.getName());
			
			
			
		}
		
		
		
	}

}
