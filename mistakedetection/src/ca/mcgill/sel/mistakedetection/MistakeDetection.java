package ca.mcgill.sel.mistakedetection;

import static classdiagram.ReferenceType.AGGREGATION;
import static classdiagram.ReferenceType.COMPOSITION;
import static classdiagram.ReferenceType.REGULAR;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ASSOCIATION_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ASSOCIATION_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ROLE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.ENUMERATION_SHOULD_BE_A_REGULAR_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ASSOCIATION_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.LOWERCASE_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION_NAME_WHEN_ONE_WAS_EXPECTED;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ROLE_NAMES;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_EXTRA_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_EXTRA_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_WRONG_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.REGULAR_CLASS_SHOULD_BE_AN_ENUMERATION;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_NAMES_PRESENT_BUT_INCORRECT;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.SIMILAR_ATTRIBUTE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.SIMILAR_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.SOFTWARE_ENGINEERING_TERM;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AN_AGGREGATION_COMPOSITION_INSTEAD_OF_AN_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AN_ASSOCIATION_INSTEAD_OF_AN_AGGREGATION_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import classdiagram.Association;
import classdiagram.AssociationEnd;
import classdiagram.Attribute;
import classdiagram.CDEnum;
import classdiagram.Class;
import classdiagram.ClassdiagramFactory;
import classdiagram.Classifier;
import classdiagram.NamedElement;
import classdiagram.ReferenceType;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import learningcorpus.MistakeType;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.Solution;
import modelingassistant.SolutionElement;


/**
 * This is the main class of Mistake Detection System. This class contains
 * functions that maps and find mistakes in the elements of the two solutions passed to it.
 * 'compare()' is the function to call to check mistakes in two solutions.
 *
 * @author Prabhsimran Singh
 */
public class MistakeDetection {

  public static final ClassdiagramFactory CDF = ClassdiagramFactory.eINSTANCE;
  public static final ModelingassistantFactory MAF = ModelingassistantFactory.eINSTANCE;

  /** The maximum limit after which a resolved mistake will be removed from student solution. */
  public static final int MAX_DETECTIONS_AFTER_RESOLUTION = 5;

  /** The maximum number of difference two words can have in terms of letters. */
  public static final int MAX_LEVENSHTEIN_DISTANCE_ALLOWED = 2;

  /** Cache to map nouns to true if they are plural, false otherwise. */
  static Map<String, Boolean> nounPluralStatus = new HashMap<String, Boolean>();

  /** The Stanford NLP Maximum Entropy Part-of-Speech Tagger. */
  private static MaxentTagger maxentTagger = getMaxentTagger();


  public static Comparison compare(Solution instructorSolution, Solution studentSolution) {
    if (!isInstructorSolution(instructorSolution) || !isStudentSolution(studentSolution)) {
      throw new IllegalArgumentException(
          "The input is not a valid (instructorSolution, studentSolution) pair.");
    }
    var comparison = new Comparison();

    var newMistakes = comparison.newMistakes;
    var instructorClassifiers = instructorSolution.getClassDiagram().getClasses();
    var studentClassifiers = studentSolution.getClassDiagram().getClasses();

    var processed = false;
    for (Classifier instructorClassifier : instructorClassifiers) {
      comparison.notMappedInstructorClassifier.add(instructorClassifier);
      EList<Attribute> instructorAttributes = instructorClassifier.getAttributes();
      for (Attribute attribute : instructorAttributes) {
        comparison.notMappedInstructorAttribute.add(attribute);
      }
      instructorClassifier.getAssociationEnds().forEach((assoc) -> {
        if (!comparison.notMappedInstructorAssociation.contains(assoc.getAssoc())) {
          comparison.notMappedInstructorAssociation.add(assoc.getAssoc());
        }
      });

      for (Classifier studentClassifier : studentClassifiers) {
        if (!processed) { // To stop duplicate entries.
          comparison.extraStudentClassifier.add(studentClassifier);
          EList<Attribute> studentAttributes = studentClassifier.getAttributes();
          for (Attribute attribute : studentAttributes) {
            comparison.extraStudentAttribute.add(attribute);
          }
          studentClassifier.getAssociationEnds().forEach((assoc) -> {
            if (!comparison.extraStudentAssociation.contains(assoc.getAssoc())) {
              comparison.extraStudentAssociation.add(assoc.getAssoc());
            }
          });
        }
        if (checkCorrect(instructorClassifier, studentClassifier, comparison)) {
          checkMistakeClassSpelling(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
          checkMistakeSoftwareEngineeringTerm(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
          checkMistakePluralClassName(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
          checkMistakeLowerClassName(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
          checkMistakeRegularBeEnumerationClass(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
          checkMistakeEnumerationBeRegularClass(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
          // checkMistakeWrongEnumerationClassItems(studentClassifier,instructorClassifier).ifPresent(newMistakes::add);

          EList<Attribute> studentAttributes = studentClassifier.getAttributes();
          for (Attribute instructorAttribute : instructorAttributes) {
            for (Attribute studentAttribute : studentAttributes) {
              float lDistance =
                  levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
              if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
                checkMistakeAttributeSpelling(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
                checkMistakeWrongAttributeType(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
                checkMistakeAttributeExpectedStatic(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
                checkMistakeAttributeNotExpectedStatic(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
              }
            }
          }
        }
      }
      processed = true;
    }

    notMatchedMapping(comparison);
    mapRelations(comparison);
    checkMistakesAfterMapping(comparison); // TO BE Discussed
    checkMistakeMissingClass(comparison);
    checkMistakeExtraClass(comparison);
    // checkMistakeDuplicateAttributes();
    checkMistakeExtraAttribute(comparison);
    checkMistakeMissingAttribute(comparison);
    // checkMistakeWrongAttribute();
    // checkMistakeAttributeMisplaced();
    // checkMistakeIncompleteContainmentTree(studentClassifiers);
    checkMistakeMissingAssociationCompositionAggregation(comparison);
    checkMistakeExtraAssociation(comparison);

    updateMistakes(studentSolution, comparison);
    return comparison;
  }

  /**
   * Maps associations for mapped classes
   */
  private static void mapRelations(Comparison comparison) {
    comparison.mappedClassifier.forEach((key, value) -> {
      compareAssocation(key, value, comparison);
    });
  }

  /** Maps the associations and check for mistakes */
  private static void compareAssocation(Classifier instructorClassifier,
      Classifier studentClassifier, Comparison comparison) {
    var instructorClassifierAssocEnds = instructorClassifier.getAssociationEnds();
    var studentClassifierAssocEnds = studentClassifier.getAssociationEnds();

    for (AssociationEnd instructorClassifierAssocEnd : instructorClassifierAssocEnds) {
      var instructorClassifierAssoc = instructorClassifierAssocEnd.getAssoc();
      AssociationEnd otherInstructorClassifierAssocEnd;
      if (instructorClassifierAssoc.getEnds().get(0).equals(instructorClassifierAssocEnd)) {
        otherInstructorClassifierAssocEnd = instructorClassifierAssoc.getEnds().get(1);
      } else {
        otherInstructorClassifierAssocEnd = instructorClassifierAssoc.getEnds().get(0);
      }

      var otherInstructorClassifier = otherInstructorClassifierAssocEnd.getClassifier();

      for (AssociationEnd studentClassifierAssocEnd : studentClassifierAssocEnds) {
        var studentClassifierAssoc = studentClassifierAssocEnd.getAssoc();
        AssociationEnd otherStudentClassifierAssocEnd;
        if (studentClassifierAssoc.getEnds().get(0).equals(studentClassifierAssocEnd)) {
          otherStudentClassifierAssocEnd = studentClassifierAssoc.getEnds().get(1);
        } else {
          otherStudentClassifierAssocEnd = studentClassifierAssoc.getEnds().get(0);
        }
        var otherStudentClassifier = otherStudentClassifierAssocEnd.getClassifier();

        if (comparison.mappedClassifier.get(otherInstructorClassifier)
            .equals(otherStudentClassifier)) {
          comparison.mappedAssociation.put(instructorClassifierAssoc, studentClassifierAssoc);
          comparison.notMappedInstructorAssociation.remove(instructorClassifierAssoc);
          comparison.extraStudentAssociation.remove(studentClassifierAssoc);

          if (!checkStudentElementForMistake(comparison.newMistakes, studentClassifierAssoc)) {
            checkMistakeMissingAssociationNameWhenExpected(studentClassifierAssoc,
                instructorClassifierAssoc).ifPresent(comparison.newMistakes::add);
            checkMistakeBadAssociationNameSpelling(studentClassifierAssoc,
                instructorClassifierAssoc).ifPresent(comparison.newMistakes::add);
            // checkMistakeSimilarYetIncorrectAssociationName(studentClassifierAssoc,instructorClassifierAssoc).ifPresent(comparison.newMistakes::add);

            checkMistakeExtraAssociationClass(studentClassifierAssoc, instructorClassifierAssoc)
                .ifPresent(comparison.newMistakes::add);
            if (studentClassifierAssoc.getAssociationClass() != null
                && instructorClassifierAssoc.getAssociationClass() != null) {
              checkMistakeBadAssociationClassNameSpelling(studentClassifierAssoc,
                  instructorClassifierAssoc).ifPresent(comparison.newMistakes::add);
              checkMistakeSimilarYetIncorrectAssociationClassName(studentClassifierAssoc,
                  instructorClassifierAssoc).ifPresent(comparison.newMistakes::add);
            }
          }

          if (!checkInstructorElementForMistake(comparison.newMistakes,
              instructorClassifierAssoc)) {
            checkMistakeMissingAssociationClass(studentClassifierAssoc, instructorClassifierAssoc)
                .ifPresent(comparison.newMistakes::add);
          }

          if (!checkInstructorElementForMistake(comparison.newMistakes,
              instructorClassifierAssocEnd)) {
            checkMistakesForAssociationEnds(studentClassifierAssocEnd, instructorClassifierAssocEnd,
                comparison);
          }

          // -- Check for Other Assoc End-----
          if (!checkInstructorElementForMistake(comparison.newMistakes,
              otherInstructorClassifierAssocEnd)) {
            checkMistakesForAssociationEnds(otherStudentClassifierAssocEnd,
                otherInstructorClassifierAssocEnd, comparison);
          }
        }
      }
    }
  }

  private static void checkMistakesForAssociationEnds(AssociationEnd studentClassifierAssocEnd,
      AssociationEnd instructorClassifierAssocEnd, Comparison comparison) {

    checkMistakeUsingAssociationInsteadOfComposition(studentClassifierAssocEnd,
        instructorClassifierAssocEnd).ifPresent(comparison.newMistakes::add);
    checkMistakeUsingAssociationInsteadOfAggregation(studentClassifierAssocEnd,
        instructorClassifierAssocEnd).ifPresent(comparison.newMistakes::add);
    checkMistakeUsingCompositionInsteadOfAssociation(studentClassifierAssocEnd,
        instructorClassifierAssocEnd).ifPresent(comparison.newMistakes::add);
    checkMistakeUsingAggregationInsteadOfAssociation(studentClassifierAssocEnd,
        instructorClassifierAssocEnd).ifPresent(comparison.newMistakes::add);
    checkMistakeUsingAggregationInsteadOfComposition(studentClassifierAssocEnd,
        instructorClassifierAssocEnd).ifPresent(comparison.newMistakes::add);
    checkMistakeUsingCompositionInsteadOfAggregation(studentClassifierAssocEnd,
        instructorClassifierAssocEnd).ifPresent(comparison.newMistakes::add);
    checkMistakeOtherWrongMultiplicity(studentClassifierAssocEnd, instructorClassifierAssocEnd)
        .ifPresent(comparison.newMistakes::add);
    checkMistakeMissingRoleName(studentClassifierAssocEnd, instructorClassifierAssocEnd)
        .ifPresent(comparison.newMistakes::add);
    checkMistakeRoleNameExpectedStactic(studentClassifierAssocEnd, instructorClassifierAssocEnd)
        .ifPresent(comparison.newMistakes::add);
    checkMistakeRoleNameNotExpectedStactic(studentClassifierAssocEnd, instructorClassifierAssocEnd)
        .ifPresent(comparison.newMistakes::add);
    checkMistakeRoleNamePresentButIncorrect(studentClassifierAssocEnd, instructorClassifierAssocEnd)
        .ifPresent(comparison.newMistakes::add);
    // checkMistakeRoleNameSimilarYetIncorrect(studentClassifierAssocEnd,
    // instructorClassifierAssocEnd)
    // .ifPresent(comparison.newMistakes::add);
    checkMistakeBadRoleNameSpelling(studentClassifierAssocEnd, instructorClassifierAssocEnd)
        .ifPresent(comparison.newMistakes::add);

  }

  /** Finds Mistakes in newly mapped elements */
  private static void checkMistakesAfterMapping(Comparison comparison) { // TO BE Discussed
    var newMistakes = comparison.newMistakes;

    comparison.mappedClassifier.forEach((key, value) -> {
      // System.out.println(checkElementForMistake(newMistakes,value)+" value: "+ value+" Key: "+key);
      if (!checkStudentElementForMistake(newMistakes, value)) {
        checkMistakePluralClassName(value, key).ifPresent(newMistakes::add);
        // checkMistakeSimilarYetIncorrectClassName(value,key).ifPresent(comparison.newMistakes::add);
        // TO BE Discussed
      }
    });

    comparison.mappedAttribute.forEach((key, value) -> {
      // System.out.println(checkElementForMistake(newMistakes,value)+" value: "+ value+" Key: "+key);
      if (!checkStudentElementForMistake(newMistakes, value)) {
        // checkMistakeSimilarYetIncorrectAttributeName(value,key).ifPresent(comparison.newMistakes::add);
        // TO BE Discussed
      }
    });
  }

  /**
   * Returns true if a student element has a mistake associated with it.
   */
  private static boolean checkStudentElementForMistake(EList<Mistake> newMistakes, NamedElement value) {
    for (Mistake mistake : newMistakes) {
      for (var studentElement : mistake.getStudentElements()) {
        if (studentElement.getElement().equals(value)) { // TODO Double check whether equals() works here
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Returns true if a instructor element has a mistake associated with it.
   */
  private static boolean checkInstructorElementForMistake(EList<Mistake> newMistakes, NamedElement value) {
    for (Mistake mistake : newMistakes) {
      for (var instructorElement : mistake.getInstructorElements()) {
        if (instructorElement.getElement().equals(value)) {
          return true;
        }
      }
    }
    return false;
  }

  /** This function updates new and older mistakes in the metamodel and comparison. */
  private static void updateMistakes(Solution studentSolution, Comparison comparison) {
    // List containing mistakes associated with a student Solution
    var existingMistakes = studentSolution.getMistakes();

    var newMistakes = comparison.newMistakes;

    // List containing existing mistakes that are equal to newMistakes
    EList<Mistake> existingMistakesProcessed = new BasicEList<Mistake>();

    // List containing new mistakes that are already present in a solution (i.e existingMistakes)
    EList<Mistake> newMistakesProcessed = new BasicEList<Mistake>();

    // Condition when only new mistakes exists.
    if (existingMistakes.size() == 0 && newMistakes.size() != 0) {
      for (Mistake newMistake : newMistakes) {
        setMistakeProperties(newMistake, false, 1, 0);
        newMistake.setStudentSolution(studentSolution);
      }
    } else if (!existingMistakes.isEmpty() && !newMistakes.isEmpty()) {
      for (Mistake existingMistake : existingMistakes) {
        for (Mistake newMistake : newMistakes) {
          if (existingMistake.getMistakeType() == newMistake.getMistakeType()) {
            if (haveInstructorAndStudentElements(existingMistake, newMistake)) {
              if (compareInstructorElements(newMistake, existingMistake)) {
                setMistakeProperties(existingMistake, false, existingMistake.getNumDetection() + 1,
                    0);
                updateElementsOfExistingMistake(newMistake, existingMistake);
                existingMistakesProcessed.add(existingMistake);
                newMistakesProcessed.add(newMistake);
              }
            } else if (haveOnlyStudentElements(existingMistake, newMistake)) {
              if (compareStudentElements(newMistake, existingMistake)) {
                setMistakeProperties(existingMistake, false, existingMistake.getNumDetection() + 1,
                    0);
                updateElementsOfExistingMistake(newMistake, existingMistake);
                existingMistakesProcessed.add(existingMistake);
                newMistakesProcessed.add(newMistake);
              }
            } else if (haveOnlyInstructorElements(existingMistake, newMistake)) {
              if (compareInstructorElements(newMistake, existingMistake)) {
                setMistakeProperties(existingMistake, false, existingMistake.getNumDetection() + 1,
                    0);
                existingMistakesProcessed.add(existingMistake);
                newMistakesProcessed.add(newMistake);
              }
            }
          }
        }
      }
      for (Mistake newMistake : newMistakes) {
        if (!newMistakesProcessed.contains(newMistake)) {
          setMistakeProperties(newMistake, false, 1, 0);
          newMistake.setStudentSolution(studentSolution);
        }
      }
      for (int i = 0; i < existingMistakes.size(); i++) {
        if (!existingMistakesProcessed.contains(existingMistakes.get(i))) {
          if (existingMistakes.get(i)
              .getNumDetectionSinceResolved() <= MAX_DETECTIONS_AFTER_RESOLUTION
              && existingMistakes.get(i).isResolved()) {
            existingMistakes.get(i).setResolved(true);
            existingMistakes.get(i).setNumDetectionSinceResolved(
                existingMistakes.get(i).getNumDetectionSinceResolved() + 1);
          } else {
            existingMistakes.get(i).setStudentSolution(null);
            existingMistakes.get(i).getInstructorElements().clear();
            existingMistakes.get(i).getStudentElements().clear();
          }
        }
      }
    } else if (existingMistakes.size() != 0 && newMistakes.size() == 0) {
      for (Mistake existingMistake : existingMistakes) {
        if (existingMistake.getNumDetectionSinceResolved() <= MAX_DETECTIONS_AFTER_RESOLUTION) {
          existingMistake.setResolved(true);
          existingMistake
              .setNumDetectionSinceResolved(existingMistake.getNumDetectionSinceResolved() + 1);
        } else {
          existingMistake.setStudentSolution(null);
          existingMistake.getInstructorElements().clear();
          existingMistake.getStudentElements().clear();
        }
      }
    }

  }
/**
 * Updates the student elemenets of an existing mistake.
 * @param newMistake
 * @param existingMistake
 */
  private static void updateElementsOfExistingMistake(Mistake newMistake, Mistake existingMistake) {
    existingMistake.getStudentElements().clear();
    existingMistake.getStudentElements().addAll(newMistake.getStudentElements());
  }

  // TODO Move helper methods to their relevant classes so they can be reused elsewhere in the app

  /** Returns true if the given mistake has both instructor and student elements. */
  private static boolean hasInstructorAndStudentElements(Mistake mistake) {
    return !mistake.getInstructorElements().isEmpty() && !mistake.getStudentElements().isEmpty();
  }

  /** Returns true if the given mistakes have both instructor and student elements. */
  private static boolean haveInstructorAndStudentElements(Mistake... mistakes) {
    return Arrays.stream(mistakes).allMatch(MistakeDetection::hasInstructorAndStudentElements);
  }

  /** Returns true if the given mistake has only instructor elements. */
  private static boolean hasOnlyInstructorElements(Mistake mistake) {
    return !mistake.getInstructorElements().isEmpty() && mistake.getStudentElements().isEmpty();
  }

  /** Returns true if the given mistakes have only instructor elements. */
  private static boolean haveOnlyInstructorElements(Mistake... mistakes) {
    return Arrays.stream(mistakes).allMatch(MistakeDetection::hasOnlyInstructorElements);
  }

  /** Returns true if the given mistake has only student elements. */
  private static boolean hasOnlyStudentElements(Mistake mistake) {
    return mistake.getInstructorElements().isEmpty() && !mistake.getStudentElements().isEmpty();
  }

  /** Returns true if the given mistakes have only student elements. */
  private static boolean haveOnlyStudentElements(Mistake... mistakes) {
    return Arrays.stream(mistakes).allMatch(MistakeDetection::hasOnlyStudentElements);
  }

  /** Returns true if a student is associated with a solution. */
  private static boolean isStudentSolution(Solution solution) {
    return solution.getStudent() != null;
  }

  /** Returns true if NO student is associated with a solution. */
  private static boolean isInstructorSolution(Solution solution) {
    return solution.getStudent() == null;
  }

  /** Returns a true if all instructor elements are equal. */
  private static boolean compareInstructorElements(Mistake newMistake, Mistake existingMistake) {
    if (existingMistake.getInstructorElements().size() != newMistake.getInstructorElements().size()) {
      return false;
    }
    for (int i = 0; i < existingMistake.getInstructorElements().size(); i++) {
      if (!compareElement(existingMistake.getInstructorElements().get(i),newMistake.getInstructorElements().get(i))) {
        return false;
      }
    }
    return true;
  }

  /** Returns a true if all student elements are equal. */
  private static boolean compareStudentElements(Mistake newMistake, Mistake existingMistake) {
    if (existingMistake.getStudentElements().size() != newMistake.getStudentElements().size()) {
      return false;
    }
    for (int i = 0; i < existingMistake.getStudentElements().size(); i++) {
      if (!compareElement(existingMistake.getStudentElements().get(i),newMistake.getStudentElements().get(i))) {
        return false;
      }
    }
    return true;
  }
/**
 * Function returns true if both elements are equal
 *
 * @param existingElement
 * @param newElement
 * @return boolean
 */
  private static boolean compareElement(SolutionElement existingElement, SolutionElement newElement) {
    if(existingElement.getElement().equals(newElement.getElement())) {
      return true;
    }
    return false;
  }

  /** Sets the properties of a mistake. */
  private static void setMistakeProperties(Mistake mistake, boolean isResolved, int numDetection,
      int numDetectionSiceResolved) {
    mistake.setResolved(isResolved);
    mistake.setNumDetection(numDetection);
    mistake.setNumDetectionSinceResolved(numDetectionSiceResolved);
  }

  /**
   * Method to check if two classifiers match or not.
   *
   * @param instructorClass
   * @param studentClass
   * @return true if classifier match
   */
  public static boolean checkCorrect(Classifier instructorClass, Classifier studentClass,
      Comparison comparison) {
    boolean isMapped = false;
    EList<Attribute> instructorAttributes = instructorClass.getAttributes();
    EList<Attribute> studentAttributes = studentClass.getAttributes();


    float lDistance = levenshteinDistance(studentClass.getName(), instructorClass.getName());
    if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      isMapped = true;
      comparison.mappedClassifier.put(instructorClass, studentClass);
      comparison.notMappedInstructorClassifier.remove(instructorClass);
      comparison.extraStudentClassifier.remove(studentClass);
    }

    // Commented print statements for debugging
    if (isMapped) { // Map attributes if classifiers map.
      for (Attribute instructorAttribute : instructorAttributes) { // To check association -> Not at present.
        // System.out.println("Instructor "+ instructorAttribute +" "
        // +instructorClassifier.getName());
        for (Attribute studentAttribute : studentAttributes) {
          // System.out.println("Student "+ studentAttribute+" " +studentClassifier.getName());
          lDistance = levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
          if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED
              && comparison.mappedAttribute.get(instructorAttribute) == studentAttribute) {
            comparison.duplicateStudentAttribute.add(studentAttribute);
            comparison.extraStudentAttribute.remove(studentAttribute);
          } else if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
            // System.out.println("Mapped");
            comparison.mappedAttribute.put(instructorAttribute, studentAttribute);
            comparison.notMappedInstructorAttribute.remove(instructorAttribute);
            comparison.extraStudentAttribute.remove(studentAttribute);
            break;
          }
        }
      }
    }

    return isMapped;
  }

  /** Finds mappings in previously unmapped elements */
  public static void notMatchedMapping(Comparison comparison) {
    if (comparison.notMappedInstructorClassifier.isEmpty() || comparison.extraStudentClassifier.isEmpty()) {
      return;
    }

    int counter = 1;
    for (int k = 0; k < counter; k++) {
      for (int i = 0; i < comparison.notMappedInstructorClassifier.size(); i++) {
        Classifier instructorClassifier = comparison.notMappedInstructorClassifier.get(i);
        EList<Attribute> instructorAttributes = instructorClassifier.getAttributes();
        // System.out.println("Instructor " + instructorClassifier.getName());
        int totalAttributes = instructorAttributes.size();

        for (int j = 0; j < comparison.extraStudentClassifier.size(); j++) {
          Classifier studentClassifier = comparison.extraStudentClassifier.get(j);
          EList<Attribute> studentAttributes = studentClassifier.getAttributes();
          // System.out.println("Student " + studentClassifier.getName());
          int correctAttribute = 0;
          for (Attribute instructorAttribute : instructorAttributes) { // To check association ->
                                                                       // Not at present.
            for (Attribute studentAttribute : studentAttributes) {
              float lDistance = levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
              if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
                correctAttribute++;
                break;
              }
            }
          }
          // System.out.println("CorrectAttribute "+ " "+ instructorClassifier.getName() +" "+
          // studentClassifier.getName()+" "+ correctAttribute);
          if (totalAttributes != 0) {
            if ((double) correctAttribute / (double) totalAttributes >= 0.5) {
              comparison.mappedClassifier.put(instructorClassifier, studentClassifier);
              comparison.notMappedInstructorClassifier.remove(instructorClassifier);
              comparison.extraStudentClassifier.remove(studentClassifier);
              // Similar Mistake Can be placed here as well.
              counter++;
              for (Attribute instructorAttribute : instructorAttributes) { // To check association
                                                                           // -> Not at present.
                for (Attribute studentAttribute : studentAttributes) {
                  float lDistance = levenshteinDistance(studentAttribute.getName(),
                      instructorAttribute.getName());
                  if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
                    // System.out.println(instructorClassifier.getName() + " " +
                    // studentAttribute.getName()+ " " + instructorAttribute.getName());
                    comparison.mappedAttribute.put(instructorAttribute, studentAttribute);
                    comparison.notMappedInstructorAttribute.remove(instructorAttribute);
                    comparison.extraStudentAttribute.remove(studentAttribute);
                    break;
                  }
                }
              }


            }
          }
        }

      }
    }
  }

  /**
   * Checks for a software engineering term in a given classifier.
   */
  public static Optional<Mistake> checkMistakeSoftwareEngineeringTerm(Classifier studentClass,
      Classifier instructorClass) {
    if (isSoftwareEngineeringTerm(studentClass.getName())) {
      return Optional.of(createMistake(SOFTWARE_ENGINEERING_TERM, studentClass, instructorClass));
    }
    return Optional.empty();
  }


  public static Optional<Mistake> checkMistakePluralClassName(Classifier studentClass, Classifier instructorClass) {
    if (isPlural(studentClass.getName())) {
      return Optional.of(createMistake(PLURAL_CLASS_NAME, studentClass, instructorClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeClassSpelling(Classifier studentClass, Classifier instructorClass) {
    int lDistance = levenshteinDistance(studentClass.getName(), instructorClass.getName());
    if (lDistance > 0 && lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      return Optional.of(createMistake(BAD_CLASS_NAME_SPELLING, studentClass, instructorClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeSimilarYetIncorrectClassName(Classifier studentClass,
      Classifier instructorClass) {
    int lDistance = levenshteinDistance(studentClass.getName(), instructorClass.getName());
    if (lDistance != 0) {
      return Optional.of(createMistake(SIMILAR_CLASS_NAME, studentClass, instructorClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeSimilarYetIncorrectAttributeName(Attribute studentClassAttribute,
      Attribute instructorClassAttribute) {
    int lDistance = levenshteinDistance(studentClassAttribute.getName(), instructorClassAttribute.getName());
    if (lDistance != 0) {
      return Optional.of(createMistake(SIMILAR_ATTRIBUTE_NAME, studentClassAttribute, instructorClassAttribute));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeAttributeSpelling(Attribute studentAttribute,
      Attribute instructorAttribute) {
    int lDistance = levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
    if (lDistance > 0 && lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      return Optional.of(createMistake(BAD_ATTRIBUTE_NAME_SPELLING, studentAttribute, instructorAttribute));
    }
    return Optional.empty();
  }

  public static int levenshteinDistance(String string1, String string2) {
    return LevenshteinDistance.getDefaultInstance().apply(string1, string2);
  }

  public static Optional<Mistake> checkMistakeLowerClassName(Classifier studentClass, Classifier instructorClass) {
    if (isLowerName(studentClass.getName())) {
      return Optional.of(createMistake(LOWERCASE_CLASS_NAME, studentClass, instructorClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeEnumerationBeRegularClass(Classifier studentClass,
      Classifier instructorClass) {
    if (isClassEnumInsteadOfRegular(studentClass, instructorClass)) {

      return Optional
          .of(createMistake(ENUMERATION_SHOULD_BE_A_REGULAR_CLASS, studentClass, instructorClass));
    }
    return Optional.empty();
  }
  public static Optional<Mistake> checkMistakeRegularBeEnumerationClass(Classifier studentClass,
      Classifier instructorClass) {
    if (isClassRegularInsteadOfEnum(studentClass, instructorClass)) {

      return Optional
          .of(createMistake(REGULAR_CLASS_SHOULD_BE_AN_ENUMERATION, studentClass, instructorClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeWrongAttributeType(Attribute studentAttribute,
      Attribute instructorAttribute) {
    if (!attributeTypesMatch(studentAttribute, instructorAttribute)) {
      return Optional.of(createMistake(WRONG_ATTRIBUTE_TYPE, studentAttribute, instructorAttribute));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeAttributeExpectedStatic(Attribute studentAttribute,
      Attribute instructorAttribute) {
     if (isAttributeExpectedStatic(studentAttribute, instructorAttribute)) {
      return Optional.of(createMistake(ATTRIBUTE_SHOULD_BE_STATIC, studentAttribute,
          instructorAttribute));
    }
    return Optional.empty();
  }
  public static Optional<Mistake> checkMistakeAttributeNotExpectedStatic(Attribute studentAttribute,
      Attribute instructorAttribute) {
     if (isAttributeNotExpectedStatic(studentAttribute, instructorAttribute)) {
      return Optional.of(createMistake(ATTRIBUTE_SHOULD_NOT_BE_STATIC, studentAttribute,
          instructorAttribute));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingAssociationInsteadOfComposition(
      AssociationEnd studentClassAssocEnd, AssociationEnd instructorClassAssocEnd) {
    if (isUsingAssociationInsteadOfComposition(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_AN_ASSOCIATION_INSTEAD_OF_AN_AGGREGATION_COMPOSITION,
          studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingAssociationInsteadOfAggregation(
      AssociationEnd studentClassAssocEnd, AssociationEnd instructorClassAssocEnd) {
    if (isUsingAssociationInsteadOfAggregation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_AN_ASSOCIATION_INSTEAD_OF_AN_AGGREGATION_COMPOSITION,
          studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingCompositionInsteadOfAssociation(
      AssociationEnd studentClassAssocEnd, AssociationEnd instructorClassAssocEnd) {
    if (isUsingCompositionInsteadOfAssociation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_AN_AGGREGATION_COMPOSITION_INSTEAD_OF_AN_ASSOCIATION,
          studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingAggregationInsteadOfAssociation(
      AssociationEnd studentClassAssocEnd, AssociationEnd instructorClassAssocEnd) {
    if (isUsingAggregationInsteadOfAssociation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_AN_AGGREGATION_COMPOSITION_INSTEAD_OF_AN_ASSOCIATION,
          studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingAggregationInsteadOfComposition(
      AssociationEnd studentClassAssocEnd, AssociationEnd instructorClassAssocEnd) {
    if (isUsingAggregationInsteadOfComposition(studentClassAssocEnd,
        instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_AGGREGATION_INSTEAD_OF_COMPOSITION,
          studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }
  public static Optional<Mistake> checkMistakeUsingCompositionInsteadOfAggregation(
      AssociationEnd studentClassAssocEnd, AssociationEnd instructorClassAssocEnd) {
    if (isUsingCompositionInsteadOfAggregation(studentClassAssocEnd,
        instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_COMPOSITION_INSTEAD_OF_AGGREGATION,
          studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeOtherWrongMultiplicity(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (!associationEndMultiplicityMatch(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(
          createMistake(OTHER_WRONG_MULTIPLICITY, studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeMissingRoleName(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isRoleNameMissing(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(
          createMistake(MISSING_ROLE_NAMES, studentClassAssocEnd, instructorClassAssocEnd));
     }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeRoleNameExpectedStactic(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isRoleNameExpectedStatic(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional
          .of(createMistake(ROLE_SHOULD_BE_STATIC, studentClassAssocEnd, instructorClassAssocEnd));
       }
    return Optional.empty();
  }
  public static Optional<Mistake> checkMistakeRoleNameNotExpectedStactic(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isRoleNameNotExpectedStatic(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(
          createMistake(ROLE_SHOULD_NOT_BE_STATIC, studentClassAssocEnd, instructorClassAssocEnd));
      }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeBadRoleNameSpelling(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    int lDistance =
        levenshteinDistance(studentClassAssocEnd.getName(), instructorClassAssocEnd.getName());
    if (lDistance > 0 && lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      return Optional
          .of(createMistake(BAD_ROLE_NAME_SPELLING, studentClassAssocEnd, instructorClassAssocEnd));
      }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeRoleNamePresentButIncorrect(
      AssociationEnd studentClassAssocEnd, AssociationEnd instructorClassAssocEnd) {
    int lDistance =
        levenshteinDistance(studentClassAssocEnd.getName(), instructorClassAssocEnd.getName());
    if (lDistance > MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      return Optional.of(
          createMistake(ROLE_NAMES_PRESENT_BUT_INCORRECT, studentClassAssocEnd, instructorClassAssocEnd));
    }

    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeRoleNameSimilarYetIncorrect(
      AssociationEnd studentClassAssocEnd, AssociationEnd instructorClassAssocEnd) {
    int lDistance =
        levenshteinDistance(studentClassAssocEnd.getName(), instructorClassAssocEnd.getName());
    if (lDistance > MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      // return Optional.of(createMistake(BAD_ROLENAME_Present_But_Incorrect,
      // studentClassAssocEnd,instructorClassAssocEnd));
      return Optional.empty();
    }

    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeMissingAssociationNameWhenExpected(Association studentClassAssoc,
      Association instructorClassAssoc) {
    if (!associationNamePresent(studentClassAssoc, instructorClassAssoc)) {
      return Optional
          .of(createMistake(MISSING_ASSOCIATION_NAME_WHEN_ONE_WAS_EXPECTED, studentClassAssoc, instructorClassAssoc));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeBadAssociationNameSpelling(Association studentClassAssoc,
      Association instructorClassAssoc) {
    int lDistance = levenshteinDistance(studentClassAssoc.getName(), instructorClassAssoc.getName());
    if (lDistance > 0 && lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      return Optional.of(createMistake(BAD_ASSOCIATION_NAME_SPELLING, studentClassAssoc, instructorClassAssoc));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeBadAssociationClassNameSpelling(Association studentClassAssoc,
      Association instructorClassAssoc) {
    int lDistance = levenshteinDistance(studentClassAssoc.getAssociationClass().getName(),
        instructorClassAssoc.getAssociationClass().getName());
    if (lDistance > 0 && lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      return Optional.of(createMistake(BAD_ASSOCIATION_CLASS_NAME_SPELLING,
          studentClassAssoc.getAssociationClass(), instructorClassAssoc.getAssociationClass()));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeSimilarYetIncorrectAssociationClassName(Association studentClassAssoc,
      Association instructorClassAssoc) {
    int lDistance = levenshteinDistance(studentClassAssoc.getAssociationClass().getName(),
        instructorClassAssoc.getAssociationClass().getName());
    if (lDistance != 0) {
     // return Optional.of(createMistake(,
     //     studentClassAssoc.getAssociationClass(), instructorClassAssoc.getAssociationClass()));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeMissingAssociationClass(Association studentClassAssoc,
      Association instructorClassAssoc) {
    if (isAssociationClassMissing(studentClassAssoc, instructorClassAssoc)) {
      return Optional.of(createMistake(MISSING_ASSOCIATION_CLASS,
          studentClassAssoc.getAssociationClass(), instructorClassAssoc.getAssociationClass()));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeExtraAssociationClass(Association studentClassAssoc,
      Association instructorClassAssoc) {
    if (isAssociationClassExtra(studentClassAssoc, instructorClassAssoc)) {
      return Optional.of(createMistake(EXTRA_ASSOCIATION_CLASS,
          studentClassAssoc.getAssociationClass(), instructorClassAssoc.getAssociationClass()));
    }
    return Optional.empty();
  }

  public static void checkMistakeMissingClass(Comparison comparison) {
    comparison.notMappedInstructorClassifier
        .forEach(cls -> comparison.newMistakes.add(createMistake(MISSING_CLASS, null, cls))); // No Student Element
  }

  public static void checkMistakeExtraClass(Comparison comparison) {
    // No Instructor Element
    comparison.extraStudentClassifier.forEach(cls -> comparison.newMistakes.add(createMistake(EXTRA_CLASS, cls, null)));
  }

  public static void checkMistakeMissingAttribute(Comparison comparison) {
    comparison.notMappedInstructorAttribute
        .forEach(cls -> comparison.newMistakes.add(createMistake(MISSING_ATTRIBUTE, null, cls)));
  }

  public static void checkMistakeExtraAttribute(Comparison comparison) {
    comparison.extraStudentAttribute.forEach(cls -> comparison.newMistakes
        .add(createMistake(OTHER_EXTRA_ATTRIBUTE, cls, null)));
  }

  public static void checkMistakeMissingAssociationCompositionAggregation(Comparison comparison) {
    for (Association association : comparison.notMappedInstructorAssociation) {
      if (association.getEnds().get(0).getReferenceType().equals(COMPOSITION)
          || association.getEnds().get(1).getReferenceType().equals(COMPOSITION)) {
        comparison.newMistakes.add(createMistake(MISSING_COMPOSITION, null, association));
      } else if (association.getEnds().get(0).getReferenceType().equals(AGGREGATION)
          || association.getEnds().get(1).getReferenceType().equals(AGGREGATION)) {
        comparison.newMistakes.add(createMistake(MISSING_AGGREGATION, null, association));
      } else {
        comparison.newMistakes.add(createMistake(MISSING_ASSOCIATION, null, association));
      }
      if (association.getAssociationClass() != null) {
        comparison.newMistakes
            .add(createMistake(MISSING_ASSOCIATION_CLASS, null, association.getAssociationClass()));
      }
    }
  }

  public static void checkMistakeExtraAssociation(Comparison comparison) {
    for (Association association : comparison.extraStudentAssociation) {
      comparison.newMistakes.add(createMistake(OTHER_EXTRA_ASSOCIATION, association, null));
      if (association.getAssociationClass() != null) {
        comparison.newMistakes
            .add(createMistake(EXTRA_ASSOCIATION_CLASS, association.getAssociationClass(), null));
      }
    }
  }

  /**
   * Returns true if the input string is a software engineering term.
   */
  public static boolean isSoftwareEngineeringTerm(String s) {
    final var softwareEnginneringTerms = List.of("data", "record", "table", "info");
    for (var seTerm : softwareEnginneringTerms) {
      if (s.toLowerCase().contains(seTerm))
        return true;
    }
    return false;
  }

  /**
   * Returns true if the input string is plural.
   */
  public static boolean isPlural(String s) {
    boolean isPlural = false;

    if (nounPluralStatus.containsKey(s)) {
      return nounPluralStatus.get(s);
    } else {
      String taggerInput = s;
      taggerInput = taggerInput.toLowerCase(); // Tagger works on lower case string
      String tagged = maxentTagger.tagString(taggerInput);
      String[] str = tagged.split("/");
      String pluralTag = "NNS";
      if (str[1].contains(pluralTag)) {
        isPlural = true;
      }

      nounPluralStatus.put(s, isPlural);
    }
    return isPlural;
  }

  public static boolean isLowerName(String name) {
    return name.toLowerCase() == name;
  }

  public static boolean attributeTypesMatch(Attribute studentAttribute, Attribute instructorAttribute) {
    return studentAttribute.getType().getClass().equals(instructorAttribute.getType().getClass());
  }

  /** Returns true if student has defined class as type enum instead of regular. */
  public static boolean isClassEnumInsteadOfRegular(Classifier studentClassifier, Classifier instructorClassifier) {
    return !(instructorClassifier instanceof CDEnum) && studentClassifier instanceof CDEnum;
  }
  /** Returns true if student has defined class  as regular instead of type enum  . */
  public static boolean isClassRegularInsteadOfEnum(Classifier studentClassifier, Classifier instructorClassifier) {
    return instructorClassifier instanceof CDEnum && !(studentClassifier instanceof CDEnum);
  }

  /** Returns true if the student has made attribute not static but static is required. */
  public static boolean isAttributeExpectedStatic(Attribute studentAttribute, Attribute instructorAttribute) {
    return !studentAttribute.isStatic()  && instructorAttribute.isStatic();
  }
  /** Returns true if the student has made attribute static but static is not required. */
  public static boolean isAttributeNotExpectedStatic(Attribute studentAttribute, Attribute instructorAttribute) {
    return studentAttribute.isStatic()  && !instructorAttribute.isStatic();
  }

  public static boolean isUsingAssociationInsteadOfComposition(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, REGULAR, COMPOSITION);
  }

  public static boolean isUsingAssociationInsteadOfAggregation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, REGULAR, AGGREGATION);
  }
  public static boolean isUsingCompositionInsteadOfAssociation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, COMPOSITION, REGULAR );
  }

  public static boolean isUsingAggregationInsteadOfAssociation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd,AGGREGATION, REGULAR );
  }
  public static boolean isUsingAggregationInsteadOfComposition(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd,AGGREGATION, COMPOSITION );
  }
  public static boolean isUsingCompositionInsteadOfAggregation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, COMPOSITION, AGGREGATION );
  }

  public static boolean associationEndAssociationPropertyMatch(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, REGULAR, REGULAR);
  }

  /** Returns true if both association ends have the same reference type. */
  public static boolean associationEndsMatchType(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return studentClassAssocEnd.getReferenceType().equals(instructorClassAssocEnd.getReferenceType());
  }

  /** Returns true if both association ends match the given reference type or not. */
  public static boolean associationEndsMatchType(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd, ReferenceType assocTypeS , ReferenceType assocTypeI) {
    return studentClassAssocEnd.getReferenceType().equals(assocTypeS) && instructorClassAssocEnd.getReferenceType()
        .equals(assocTypeI);
  }

  public static boolean associationEndMultiplicityMatch(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndMultiplicityLowerBoundsMatch(studentClassAssocEnd, instructorClassAssocEnd)
        && associationEndMultiplicityUpperBoundsMatch(studentClassAssocEnd, instructorClassAssocEnd);
  }

  public static boolean associationEndMultiplicityLowerBoundsMatch(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return studentClassAssocEnd.getLowerBound() == instructorClassAssocEnd.getLowerBound();
  }

  public static boolean associationEndMultiplicityUpperBoundsMatch(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return studentClassAssocEnd.getUpperBound() == instructorClassAssocEnd.getUpperBound();
  }

  public static boolean isRoleNameMissing(AssociationEnd studentClassAssocEnd, AssociationEnd instructorClassAssocEnd) {
    return studentClassAssocEnd.getName().isEmpty() && !instructorClassAssocEnd.getName().isEmpty();
  }

  public static boolean isRoleNameExpectedStatic(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return !studentClassAssocEnd.isStatic() && instructorClassAssocEnd.isStatic();
  }
  public static boolean isRoleNameNotExpectedStatic(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return studentClassAssocEnd.isStatic() && !instructorClassAssocEnd.isStatic();
  }

  public static boolean associationNamePresent(Association studentClassAssoc, Association instructorClassAssoc) {
    return !studentClassAssoc.getName().isEmpty() && !instructorClassAssoc.getName().isEmpty();
  }

  /**
   * Returns true if association class is extra.
   */
  public static boolean isAssociationClassExtra(Association studentClassAssoc, Association instructorClassAssoc) {
    Class Classnull = null; // getAssociationClass() return null class named "Classnull" if it does not exist.
    return studentClassAssoc.getAssociationClass() != Classnull  && instructorClassAssoc.getAssociationClass() == Classnull;
  }

  /**
   * Returns true if association class is missing.
   */
  public static boolean isAssociationClassMissing(Association studentClassAssoc, Association instructorClassAssoc) {
     Class Classnull = null; // getAssociationClass() return null class named "Classnull" if it does not exist
     return studentClassAssoc.getAssociationClass() == Classnull && instructorClassAssoc.getAssociationClass() != Classnull;
  }

  /**
   * Creates a new mistake from the input parameters.
   *
   * @param mistakeType
   * @param studentElement
   * @param instructorElement
   */
  private static Mistake createMistake(MistakeType mistakeType, NamedElement studentElement,
      NamedElement instructorElement) {
    var mistake = MAF.createMistakeOfType(mistakeType);

    // TODO Use existing solution element when available
    if (studentElement != null) {
      var solutionElement = MAF.createSolutionElement();
      solutionElement.setElement(studentElement);
      mistake.getStudentElements().add(solutionElement);
    }
    if (instructorElement != null) {
      var solutionElement = MAF.createSolutionElement();
      solutionElement.setElement(instructorElement);
      mistake.getInstructorElements().add(solutionElement);
    }

    return mistake;
  }

  /** Overloaded method used for testing. */
  public static boolean checkCorrectTest(Classifier instructorClassifier, Classifier studentClassifier) {
    return checkCorrectTest(instructorClassifier, studentClassifier, new Comparison());
  }

  /***
   * This is a function created for testing the logic. Only for test.
   *
   * @param instructorClassifier
   * @param studentClassifier
   * @return
   */
  public static boolean checkCorrectTest(Classifier instructorClassifier,
      Classifier studentClassifier, Comparison comparison) {
    // clearAttributesAndClassifer();
    boolean isMapped = false;
    EList<Attribute> instructorAttributes = instructorClassifier.getAttributes();
    EList<Attribute> studentAttributes = studentClassifier.getAttributes();

    comparison.notMappedInstructorClassifier.add(instructorClassifier);
    comparison.extraStudentClassifier.add(studentClassifier);

    int totalAttibutes = instructorAttributes.size();
    int correctAttribute = 0;
    float lDistance =
        levenshteinDistance(studentClassifier.getName(), instructorClassifier.getName());
    if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      isMapped = true;
      comparison.mappedClassifier.put(instructorClassifier, studentClassifier);
      comparison.notMappedInstructorClassifier.remove(instructorClassifier);
      comparison.extraStudentClassifier.remove(studentClassifier);
    } else {
      for (Attribute instructorAttribute : instructorAttributes) { // To check association -> Not at present.
        for (Attribute studentAttribute : studentAttributes) {
          lDistance = levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
          if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
            correctAttribute++;
            break;
          }
        }
      }
    }
    if (totalAttibutes != 0) {
      if ((double) correctAttribute / totalAttibutes > 0.5 && !isMapped) {
        comparison.mappedClassifier.put(instructorClassifier, studentClassifier);
        comparison.notMappedInstructorClassifier.remove(instructorClassifier);
        comparison.extraStudentClassifier.remove(studentClassifier);

        isMapped = true;
      }
    }

    if (isMapped) { // Map attributes if classifiers map.
      boolean processed = false;
      for (Attribute instructorAttribute : instructorAttributes) { // To check association -> Not at present.
        comparison.notMappedInstructorAttribute.add(instructorAttribute);
        for (Attribute studentAttribute : studentAttributes) {
          if (!processed) { // To stop duplicate entries.
            comparison.extraStudentAttribute.add(studentAttribute);
          }
          lDistance = levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
          if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED
              && comparison.mappedAttribute.containsValue(studentAttribute)) {
            comparison.duplicateStudentAttribute.add(studentAttribute);
            comparison.extraStudentAttribute.remove(studentAttribute);
          } else if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
            comparison.mappedAttribute.put(instructorAttribute, studentAttribute);
            comparison.notMappedInstructorAttribute.remove(instructorAttribute);
            comparison.extraStudentAttribute.remove(studentAttribute);
            break;
          }
        }
        processed = true;
      }
    }

    return isMapped;
  }

  public static void showMistakes(List<Mistake> mistakes) {
    for (Mistake m : mistakes) {
      System.out.println(m.getMistakeType().getName() + " in "
          + m.getStudentElements().get(0).getElement().getName());
    }
  }

  private static MaxentTagger getMaxentTagger() {
    try {
      return new MaxentTagger("taggers/left3words-wsj-0-18.tagger");
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
