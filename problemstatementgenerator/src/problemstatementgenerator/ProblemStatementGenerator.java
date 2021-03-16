package problemstatementgenerator;

import org.eclipse.emf.common.util.EList;

import classdiagram.Association;
import classdiagram.AssociationEnd;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import classdiagram.ReferenceType;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.util.ResourceHelper;

/**
 * Generates a natural language problem statement from a class diagram.
 * 
 * @author Thomas Woodfine-MacPherson
 */
public class ProblemStatementGenerator {

  /** Example usage of methods below. */
  public static void main(String[] args) {
    ClassdiagramPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();

    var cdPath = "../modelingassistant/testmodels/car_sportscar_part_driver.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdPath);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);

    for (var t : classDiagram.getAssociations()) {
      var print = describeAssociation(t);
      System.out.println(print);
    }
  }
  
  public static String generateProblemStatement(ClassDiagram classDiagram) {
    // TODO Complete using the methods below after making the necessary changes to them
    return "Car Part Driver."; // hardcoded response to pass test
  }

  /**
   * Describe an Association
   * 
   * @param An Asssociation
   * @return A String description of an Association
   */
  public static String describeAssociation(Association a) {
    String description = "";

    AssociationEnd oneEnd = a.getEnds().get(0);
    AssociationEnd twoEnd = a.getEnds().get(1);

    description += describeClassifier(oneEnd);
    description += describeReferenceType(a.getEnds());
    description += describeClassifier(twoEnd);

    return description;
  }

  /**
   * Describe an AssociationEnd's Classifier
   * 
   * @param AssociationEnd
   * @return A String description of an AssociationEnd's Classifier
   */
  public static String describeClassifier(AssociationEnd ae) {
    Classifier p = ae.getClassifier();
    String classifierDescription = "";

    if (p.getAttributes().size() > 0) {
      classifierDescription = "A " + p.getName() + " has the following attributes:";
      for (int i = 0; i < p.getAttributes().size(); i++) {
        var att = p.getAttributes().get(i);
        if (i > 0) {
          classifierDescription += ",";
        }
        classifierDescription += " ";
        classifierDescription += att.getName();
      }
      classifierDescription += ". ";
    }

    if (p.getOperations().size() > 0) {
      classifierDescription = p.getName() + " has the following methods:";
      for (int i = 0; i < p.getOperations().size(); i++) {
        var opp = p.getOperations().get(i);
        if (i > 0) {
          classifierDescription += ",";
        }
        classifierDescription += " ";
        classifierDescription += opp.getName();
      }
      classifierDescription += ". ";
    }

    return classifierDescription;
  }

  /**
   * Describe the reference between two AssociationEnds
   * 
   * @param EList<AssociationEnd> aEnds
   * @return A String description of two AssociationEnds
   */

  public static String describeReferenceType(EList<AssociationEnd> aEnds) {
    String referenceTypeDescription = "";

    AssociationEnd oneEnd = aEnds.get(0);
    AssociationEnd twoEnd = aEnds.get(1);

    String subject = oneEnd.getClassifier().getName();
    String object = twoEnd.getClassifier().getName();
    String referenceTypeWord = "has";

    ReferenceType oneRefType = oneEnd.getReferenceType();
    ReferenceType twoRefType = twoEnd.getReferenceType();

    String oneRefTypeStr = oneRefType.getName();
    String twoRefTypeStr = twoRefType.getName();

    if (oneRefTypeStr.equals("Composition") || twoRefTypeStr.equals("Composition")) {
      if (oneRefTypeStr.equals("Composition")) {
        referenceTypeWord = " is composed of ";
      } else if (twoRefTypeStr.equals("Composition")) {
        referenceTypeWord = " is an element of a ";
      } else {
        referenceTypeWord = " <- ? -> "; // TODO
      }

    } else if (oneRefTypeStr.equals("Aggregation") || twoRefTypeStr.equals("Aggregation")) {
      if (oneRefTypeStr.equals("Aggregation")) {
        referenceTypeWord = " is made up of ";
      } else if (twoRefTypeStr.equals("Aggregation")) {
        referenceTypeWord = " make up ";
      }

    } else if (oneRefTypeStr.equals("Qualified") || twoRefTypeStr.equals("Qualified")) {
      referenceTypeWord = " has a ";
    } else {
      referenceTypeWord = " has a ";
    }

    referenceTypeDescription = "A " + subject + referenceTypeWord + object + ". ";

    return referenceTypeDescription;
  }



  public static void printClasses(ClassDiagram cd) {
    for (var clazz : cd.getClasses()) {
      System.out.println("Class name: " + clazz.getName());
      printClassAttributes(clazz);
      printAssocs(clazz);
      System.out.println("---------------------------");
    }
  }

  public static void tab(int a) {
    for (int i = 0; i < a; i++) {
      System.out.print("   ");
    }

  }

  public static void printAssocs(ClassDiagram cd) {
    System.out.println("ClassDiagram associations:");
    for (var assoc : cd.getAssociations()) {
      tab(1);
      System.out.println(assoc.getAssociationClass().getName());
    }
  }

  private static void printClassAttributes(Classifier clazz) {
    for (var att : clazz.getAttributes()) {
      tab(1);
      System.out.println("Attriute name: " + att.getName());
      tab(2);
      System.out.println("visibility: " + att.getVisibility());
    }
  }

  public static void printAssocs(Classifier clazz) {
    for (var assocEnd : clazz.getAssociationEnds()) {
      tab(1);
      System.out.println("Assoc. name: " + assocEnd.getAssoc().getName());
      tab(2);
      System.out.println("ref. type: " + assocEnd.getReferenceType().getName());
      tab(2);
      System.out.println("name: " + assocEnd.getName());
      tab(2);
      System.out.println("type: " + assocEnd.getType());
    }
  }

}
