package problemstatementgenerator;

import classdiagram.AssociationEnd;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
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
	    //printAssocs(classDiagram);
	    //printClasses(classDiagram);
	    
	    for (var t: classDiagram.getAssociations()) {
	    	
	    	var print = describeAssociationEnd(t.getEnds().get(1));
	    	System.out.println(print);
	    	
	    	
	    }
	    
	    
	}
	
	public static String describeAssociationEnd(AssociationEnd ae) {
		
		String description = "";
		
		
		
		
		description += describeReferenceType(ae);
		description += " ";
		description += describePrimaryClass(ae);
		
		
		
		
		
		
		return description;
	}
	
	public static String describePrimaryClass(AssociationEnd ae) {
		
		Classifier p = ae.getClassifier();
		
		String primaryClassDescription = "";
		
		//parentClassDescription += parent.getAttributes();
		
		if (p.getAttributes().size()>0) {
			
			primaryClassDescription = p.getName() + " has the following attributes:";
			for(int i = 0; i < p.getAttributes().size(); i++) {
				
				var att = p.getAttributes().get(i);
				
				if(i > 0) {
					primaryClassDescription += ",";
				}
				primaryClassDescription += " ";
				primaryClassDescription += att.getName();
				
			}
			primaryClassDescription += ".";
		}
		
		if (p.getOperations().size()>0) {
			
			primaryClassDescription = p.getName() + " has the following methods:";
			for(int i = 0; i < p.getOperations().size(); i++) {
				
				var opp = p.getOperations().get(i);
				
				if (i > 0) {
					primaryClassDescription += ",";
				}
				primaryClassDescription += " ";
				primaryClassDescription += opp.getName();
			}
			
		}
		
		
		return primaryClassDescription;
		
	}
	
	public static String describeReferenceType(AssociationEnd ae) {
		
		
		
		String aeName = ae.getName();
		String aeParentClass = ae.getClassifier().getName();
		String aeReferenceType = ae.getReferenceType().getName();
		String referenceTypeDescription = "";
		
		String referenceTypeWord;
		if (aeReferenceType.equals("Composition")) {
			
			referenceTypeWord = " is composed of ";
		}
		else {
			referenceTypeWord = " has a ";
		}

		
		referenceTypeDescription = "A "+aeParentClass + referenceTypeWord + aeName + ".";
		
		
		return referenceTypeDescription;
		
	}
	
	
	
	
	
	
	
	public static void printClasses(ClassDiagram cd){
		
		

		for(var clazz : cd.getClasses()) {
			
			
			
			System.out.println("Class name: "+clazz.getName());
			
			printClassAttributes(clazz);
			printAssocs(clazz);
			System.out.println("---------------------------");
		}
		
		
	}
	
	public static void tab(int a) {
		for(int i = 0; i<a; i++) {
			System.out.print("   ");
		}
		
	}
	
	public static void printAssocs(ClassDiagram cd) {
		System.out.println("ClassDiagram associations:");
		for(var assoc : cd.getAssociations()) {
			tab(1);
			System.out.println(assoc.getAssociationClass().getName());
		}
		
	}
	
	private static void printClassAttributes(Classifier clazz) {
		
		for(var att: clazz.getAttributes()) {
			tab(1);
			System.out.println("Attriute name: "+att.getName());
			tab(2);
			System.out.println("visibility: "+att.getVisibility());
		}
		
	}

	public static void printAssocs(Classifier clazz) {

		
		for(var assocEnd : clazz.getAssociationEnds()) {
			tab(1);
			System.out.println("Assoc. name: "+assocEnd.getAssoc().getName());
			tab(2);
			System.out.println("ref. type: "+assocEnd.getReferenceType().getName());
			tab(2);
			System.out.println("name: "+assocEnd.getName());
			tab(2);
			System.out.println("type: "+assocEnd.getType());
			
			
		}
	}
	

}
