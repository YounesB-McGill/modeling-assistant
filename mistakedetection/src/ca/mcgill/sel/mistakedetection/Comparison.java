package ca.mcgill.sel.mistakedetection;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
  public Map<Classifier, Classifier> mappedClassifier = new HashMap<Classifier, Classifier>();

  /** Maps an instructor solution classifier attribute to student solution classifier attribute. */
  public Map<Attribute, Attribute> mappedAttribute = new HashMap<Attribute, Attribute>();

  /** Maps an instructor solution classifier relation to student solution classifier relation. */
  public Map<Association, Association> mappedAssociation = new HashMap<Association, Association>();

  /** Maps an instructor solution enumeration relation to student solution enumeration. */
  public Map<CDEnum, CDEnum> mappedEnumeration = new HashMap<CDEnum, CDEnum>();

  /** Maps an instructor solution enumeration item relation to student solution enumeration item . */
  public Map<CDEnumLiteral, CDEnumLiteral> mappedEnumerationItems = new HashMap<CDEnumLiteral, CDEnumLiteral>();

  public EList<Classifier> notMappedInstructorClassifier = new BasicEList<Classifier>();
  public EList<Classifier> extraStudentClassifier = new BasicEList<Classifier>();

  public EList<Attribute> notMappedInstructorAttribute = new BasicEList<Attribute>();
  public EList<Attribute> extraStudentAttribute = new BasicEList<Attribute>();
  public EList<Attribute> duplicateStudentAttribute = new BasicEList<Attribute>();

  public EList<Association> notMappedInstructorAssociation = new BasicEList<Association>();
  public EList<Association> extraStudentAssociation = new BasicEList<Association>();

  public EList<CDEnum> notMappedInstructorEnum= new BasicEList<CDEnum>();
  public EList<CDEnum> extraStudentEnum = new BasicEList<CDEnum>();

  public EList<CDEnumLiteral> notMappedInstructorEnumLiterals = new BasicEList<CDEnumLiteral>();
  public EList<CDEnumLiteral> extraStudentEnumLiterals = new BasicEList<CDEnumLiteral>();

  public EList<Mistake> newMistakes = new BasicEList<Mistake>();

  /** Below list and map are used for association class mapping **/
  public EList<Classifier> classifierToRemove = new BasicEList<Classifier>();
  public Map<Classifier, Classifier> classifierToAdd = new HashMap<Classifier, Classifier>();

}
