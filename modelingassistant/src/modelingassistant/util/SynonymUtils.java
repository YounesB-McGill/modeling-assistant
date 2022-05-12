package modelingassistant.util;

import static modelingassistant.util.ClassDiagramUtils.getAssociationEndFromClass;
import static modelingassistant.util.ClassDiagramUtils.getAttributeFromClass;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import java.util.List;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.Solution;
import modelingassistant.SolutionElement;

/**
 * Utility class for synonyms.
 *
 * @author Prabhsimran Singh
 *
 * @generated NOT
 */
public class SynonymUtils {

  /** The ModelingassistantFactory instance. */
  private static final ModelingassistantFactory maf = ModelingassistantFactory.eINSTANCE;


  /**
   * Assigns the given list of synonyms to the given class, such that a student class with any of the names is considered to have a correct name.
   */
  public static void setSynonymToClassInClassDiag(String className, List<String> synonymNames, ClassDiagram classDiagram,
      Solution instructorSolution) {
    var instClass = getClassFromClassDiagram(className, classDiagram);
    var se = SolutionElement.forCdmElement(instClass);
    se.setSolution(instructorSolution);

    setSynonyms(synonymNames, se);
  }

  /**
   * Assigns the given list of synonyms to the given attribute, such that a student attribute with any of the names is considered to have a correct name.
   */
  public static void setSynonymToAttribInClassInClassDiag(String className, String attributeName, List<String> synonymNames, ClassDiagram classDiagram,
      Solution instructorSolution) {
    var instClass = getClassFromClassDiagram(className, classDiagram);
    var instClassAttribute = getAttributeFromClass(attributeName, instClass);
    var se = SolutionElement.forCdmElement(instClassAttribute);
    se.setSolution(instructorSolution);

    setSynonyms(synonymNames, se);
  }

  /**
   * Assigns the given list of synonyms to the given assoc end, such that a student assoc end with any of the names is considered to have a correct name.
   */
  public static void setSynonymToRoleInClassInClassDiag(String className, String assocEndName, List<String> synonymNames, ClassDiagram classDiagram,
      Solution instructorSolution) {
    var instClass = getClassFromClassDiagram(className, classDiagram);
    var instClassAssocEnd = getAssociationEndFromClass(assocEndName, instClass);
    var se = SolutionElement.forCdmElement(instClassAssocEnd);
    se.setSolution(instructorSolution);

    setSynonyms(synonymNames, se);
  }

  /** Creates a synonym and assigns it to the solution element for each name in the given list. */
  public static void setSynonyms(List<String> synonymNames, SolutionElement se) {
    synonymNames.forEach(s -> {
      var synonym = maf.createSynonym();
      synonym.setName(s);
      synonym.setSolutionElement(se);
     });
  }
}
