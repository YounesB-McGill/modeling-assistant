package ca.mcgill.sel.mistakedetection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.CDEnum;
import ca.mcgill.sel.classdiagram.CDEnumLiteral;
import ca.mcgill.sel.classdiagram.Classifier;
import modelingassistant.Mistake;

/**
 * Helper class to represent information about a mistake detection comparison.
 */
public class Comparison {

  // TODO Refactor lists and hashmaps

  /** Maps an instructor solution classifier to student solution classifier. */
  public Map<Classifier, Classifier> mappedClassifiers = new HashMap<>();

  /** Maps an instructor solution classifier attribute to student solution classifier attribute. */
  public Map<Attribute, Attribute> mappedAttributes = new HashMap<>();

  /** Maps an instructor solution classifier relation to student solution classifier relation. */
  public Map<Association, Association> mappedAssociations = new HashMap<>();

  /** Maps an instructor solution enumeration relation to student solution enumeration. */
  public Map<CDEnum, CDEnum> mappedEnumerations = new HashMap<>();

  /** Maps an instructor solution enumeration item relation to student solution enumeration item. */
  public Map<CDEnumLiteral, CDEnumLiteral> mappedEnumerationItems = new HashMap<>();

  /** Maps each instructor superclass to its subclasses, forming a generalization tree. */
  public Map<Classifier, List<Classifier>> instructorSuperclassesToSubclasses = new HashMap<>();

  /** Maps each instructor superclass to its subclasses, forming a generalization tree. */
  public Map<Classifier, List<Classifier>> studentSuperclassesToSubclasses = new HashMap<>();

  public List<Classifier> notMappedInstructorClassifiers = new ArrayList<>();
  public List<Classifier> extraStudentClassifiers = new ArrayList<>();

  public List<Attribute> notMappedInstructorAttributes = new ArrayList<>();
  public List<Attribute> extraStudentAttributes = new ArrayList<>();
  public List<Attribute> duplicateStudentAttributes = new ArrayList<>();

  public List<Association> notMappedInstructorAssociations = new ArrayList<>();
  public List<Association> extraStudentAssociations = new ArrayList<>();

  public List<CDEnum> notMappedInstructorEnums = new ArrayList<>();
  public List<CDEnum> extraStudentEnums = new ArrayList<>();

  public List<CDEnumLiteral> notMappedInstructorEnumLiterals = new ArrayList<>();
  public List<CDEnumLiteral> extraStudentEnumLiterals = new ArrayList<>();

  public List<Mistake> newMistakes = new ArrayList<>();

  /** List to store association classes to remove from mapped classes. */
  public List<Classifier> assocClassifiersToRemove = new ArrayList<>();

  /** Map stores possible instructor student Association Class pair that are detected after initial class mapping. */
  public Map<Classifier, Classifier> assocClassMappingToAdd = new HashMap<>();

}
