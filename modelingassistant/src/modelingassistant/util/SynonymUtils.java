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
   * Sets a synonym to a class.
   */
  public static void setSynonymToClassInClassDiag(String className, List<String> synonymNames, ClassDiagram classDiagram,
      Solution instructorSolution) {
    var instClass = getClassFromClassDiagram(className, classDiagram);
    var se = SolutionElement.forCdmElement(instClass);
    se.setSolution(instructorSolution);

    setSynonyms(synonymNames, se);
  }

  /**
   * Sets a synonym to an attribute.
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
   * Sets a synonym to a role.
   */
  public static void setSynonymToRoleInClassInClassDiag(String className, String assocEndName, List<String> synonymNames, ClassDiagram classDiagram,
      Solution instructorSolution) {
    var instClass = getClassFromClassDiagram(className, classDiagram);
    var instClassAssocEnd = getAssociationEndFromClass(assocEndName, instClass);
    var se = SolutionElement.forCdmElement(instClassAssocEnd);
    se.setSolution(instructorSolution);

    setSynonyms(synonymNames, se);
  }

  /** For every name in the list, function creates a synonym and assigns it to a SE*/
  public static void setSynonyms(List<String> synonymNames, SolutionElement se) {
    synonymNames.forEach(s -> {
      var synonym = maf.createSynonym();
      synonym.setName(s);
      synonym.setSolutionElement(se);
     });
  }
}
