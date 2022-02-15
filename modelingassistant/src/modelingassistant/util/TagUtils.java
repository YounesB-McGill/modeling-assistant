package modelingassistant.util;

import static modelingassistant.TagType.ABSTRACTION;
import static modelingassistant.TagType.OCCURRENCE;
import static modelingassistant.TagType.PLAYER;
import static modelingassistant.TagType.ROLE;
import static modelingassistant.util.ClassDiagramUtils.getAssociationEndFromClass;
import static modelingassistant.util.ClassDiagramUtils.getAttributeFromClass;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.classdiagram.Classifier;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.Solution;
import modelingassistant.SolutionElement;
import modelingassistant.TagGroup;

/**
 * Utility class for design pattern tags.
 *
 * @author Prabhsimran Singh
 * @author Younes Boubekeur
 *
 * @generated NOT
 */
public class TagUtils {

  /** The ModelingassistantFactory instance. */
  private static final ModelingassistantFactory maf = ModelingassistantFactory.eINSTANCE;

  /**
   * Creates a new tag group and sets an solution element to player tag in that tag group.
   */
  public static TagGroup setPlayerTagToClassInClassDiag(String className, ClassDiagram classDiagram,
      Solution instructorSolution) {
    var tagGroup = maf.createTagGroup();
    tagGroup.setSolution(instructorSolution);
    var tag = maf.createTag();
    tag.setTagType(PLAYER);
    var instClass = getClassFromClassDiagram(className, classDiagram);
    var se = SolutionElement.forCdmElement(instClass);
    se.setSolution(instructorSolution);
    tag.setSolutionElement(se);
    tag.setTagGroup(tagGroup);
    return tagGroup;
  }

  /**
   * Sets role tag to a class in tagGroup.
   */
  public static void setRoleTagToClassInClassDiag(String className, TagGroup tagGroup, ClassDiagram classDiagram) {
    var tag = maf.createTag();
    tag.setTagType(ROLE);
    var instClass = getClassFromClassDiagram(className, classDiagram);
    var se = SolutionElement.forCdmElement(instClass);
    tag.setSolutionElement(se);
    tag.setTagGroup(tagGroup);
    se.setSolution(tag.getTagGroup().getSolution());
  }

  /**
   * Sets role tag to a association end in tagGroup.
   */
  public static void setRoleTagToAssocEndInClass(String assocEndName, TagGroup tagGroup, Classifier assocClass) {
    var tag = maf.createTag();
    tag.setTagType(ROLE);
    var instClass = getAssociationEndFromClass(assocEndName, assocClass);
    var se = SolutionElement.forCdmElement(instClass);
    tag.setSolutionElement(se);
    tag.setTagGroup(tagGroup);
    se.setSolution(tag.getTagGroup().getSolution());
  }

  /**
   * Sets role tag to a attribute in tagGroup.
   */
  public static void setRoleTagToAttribInClass(String attributeName, TagGroup tagGroup, Classifier assocClass) {
    var tag = maf.createTag();
    tag.setTagType(ROLE);
    var instClass = getAttributeFromClass(attributeName, assocClass);
    var se = SolutionElement.forCdmElement(instClass);
    tag.setSolutionElement(se);
    tag.setTagGroup(tagGroup);
    se.setSolution(tag.getTagGroup().getSolution());
  }

  /**
   * Creates a new tag group and sets an solution element to abstraction tag in that tag group.
   */
  public static TagGroup setAbstractionTagToClassInClassDiag(String className, ClassDiagram classDiagram,
      Solution instructorSolution) {
    var tagGroup = maf.createTagGroup();
    tagGroup.setSolution(instructorSolution);
    var tag = maf.createTag();
    tag.setTagType(ABSTRACTION);
    var instClass = getClassFromClassDiagram(className, classDiagram);
    var se = SolutionElement.forCdmElement(instClass);
    se.setSolution(instructorSolution);
    tag.setSolutionElement(se);
    tag.setTagGroup(tagGroup);
    return tagGroup;
  }

  /**
   * Sets occurrence tag to a class in tagGroup.
   */
  public static void setOccurrenceTagToClassInClassDiag(String className, TagGroup tagGroup,
      ClassDiagram classDiagram) {
    var tag = maf.createTag();
    tag.setTagType(OCCURRENCE);
    var instClass = getClassFromClassDiagram(className, classDiagram);
    var se = SolutionElement.forCdmElement(instClass);
    tag.setSolutionElement(se);
    tag.setTagGroup(tagGroup);
    se.setSolution(tag.getTagGroup().getSolution());
  }

}
