package ca.mcgill.sel.mistakedetection;

import static modelingassistant.mistaketypes.MistakeTypes.ATTRIBUTE_EXPECTED_TO_BE_STATIC_BUT_IS_NOT_OR_VICE_VERSA;
import static modelingassistant.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static modelingassistant.mistaketypes.MistakeTypes.BAD_CLASS_NAME_SPELLING;
import static modelingassistant.mistaketypes.MistakeTypes.EXTRA_CLASS;
import static modelingassistant.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE;
import static modelingassistant.mistaketypes.MistakeTypes.MISSING_CLASS;
import static modelingassistant.mistaketypes.MistakeTypes.OTHER_EXTRA_ATTRIBUTE;
import static modelingassistant.mistaketypes.MistakeTypes.REGULAR_CLASS_SHOULD_BE_AN_ENUMERATION_OR_VICE_VERSA;
import static modelingassistant.mistaketypes.MistakeTypes.SOFTWARE_ENGINEERING_TERM;
import static modelingassistant.mistaketypes.MistakeTypes.USING_PLURAL_OR_LOWERCASE;
import static modelingassistant.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import classdiagram.Attribute;
import classdiagram.CDEnum;
import classdiagram.ClassdiagramFactory;
import classdiagram.Classifier;
import classdiagram.NamedElement;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import modelingassistant.Mistake;
import modelingassistant.MistakeType;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.Solution;

public class MistakeDetection {

  public static final ClassdiagramFactory CDF = ClassdiagramFactory.eINSTANCE;
  public static final ModelingassistantFactory MAF = ModelingassistantFactory.eINSTANCE;

  /** The maximum limit after which a resolved mistake will be removed from student solution. */
  public static final int MAX_DETECTIONS_AFTER_RESOLUTION = 5;

  /** The maximum number of difference two words can have in terms of letters. */
  public static final int MAX_LEVENSHTEIN_DISTANCE_ALLOWED = 2;

  /** Cache to map nouns to true if they are plural, false otherwise. */
  static Map<String, Boolean> nounPluralStatus = new HashMap<String, Boolean>();

  private static MaxentTagger maxentTagger = getMaxentTagger();

  public static Comparison compare(Solution instructorSolution, Solution studentSolution) {
    if (!isInstructorSolution(instructorSolution) || !isStudentSolution(studentSolution)) {
      throw new IllegalArgumentException("The input is not a valid (instructorSolution, studentSolution) pair.");
    }
    var comparison = new Comparison();

    var newMistakes = comparison.newMistakes;
    var instructorClassifiers = instructorSolution.getClassDiagram().getClasses();
    var studentClassifiers = studentSolution.getClassDiagram().getClasses();

    var processed = false;
    for (Classifier instructorClassifier : instructorClassifiers) {
      comparison.notMappedInstructorClassifier.add(instructorClassifier);
      EList<Attribute> iAttributes = instructorClassifier.getAttributes();
      for (Attribute attribute : iAttributes) {
        comparison.notMappedInstructorAttribute.add(attribute);
      }

      for (Classifier studentClassifier : studentClassifiers) {
        if (!processed) { // To stop duplicate entries.
          comparison.extraStudentClassifier.add(studentClassifier);
          EList<Attribute> sAttributes = studentClassifier.getAttributes();
          for (Attribute attribute : sAttributes) {
            comparison.extraStudentAttribute.add(attribute);
          }
        }
        if (checkCorrect(instructorClassifier, studentClassifier, comparison)) {
          checkMistakeClassSpelling(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
          checkMistakeSoftwareEngineeringTerm(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
          checkMistakePluralClassName(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
          checkMistakeLowerClassName(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
          checkMistakeWrongEnumerationClass(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
          // checkMistakeWrongEnumerationClassItems(studentClassifier,instructorClassifier).ifPresent(newMistakes::add);

          // Mapping already done in check
          EList<Attribute> sAttributes = studentClassifier.getAttributes();
          for (Attribute iAttribute : iAttributes) {
            for (Attribute sAttribute : sAttributes) {
              float lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
              if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
                checkMistakeAttributeSpelling(sAttribute,iAttribute).ifPresent(newMistakes::add);
                checkMistakeWrongAttributeType(sAttribute,iAttribute).ifPresent(newMistakes::add);
                checkMistakeAttributeStatic(sAttribute,iAttribute).ifPresent(newMistakes::add);
              }
            }
          }
        }
      }
      processed = true;
    }
    notMatchedMapping(comparison);
    checkMistakeMissingClass(comparison);
    checkMistakeExtraClass(comparison);
    // checkMistakeDuplicateAttributes();
    checkMistakeExtraAttribute(comparison);
    checkMistakeMissingAttribute(comparison);
    // checkMistakeWrongAttribute();
    // checkMistakeAttributeMisplaced();
    // checkMistakeIncompleteContainmentTree(studentClassifiers);

    updateMistakes(studentSolution, comparison);
    return comparison;
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

    // --FOR DEBUGGING--
    // System.out.println(studentSolution.getStudent());
    // System.out.println(studentSolution);// List
    // System.out.println(existingMistakes.size());
    // ---

    // Condition when only new mistakes exists.
    if (existingMistakes.size() == 0 && newMistakes.size() != 0) {
      // System.out.println("In 1");
      for (Mistake newMistake : newMistakes) {
        setMistakeProperties(newMistake, false, 1, 0);
        newMistake.setStudentSolution(studentSolution);
      }
    } else if (!existingMistakes.isEmpty() && !newMistakes.isEmpty()) {
      //  System.out.println("In 2");
      for (Mistake existingMistake : existingMistakes) {
        for (Mistake newMistake : newMistakes) {
          if (existingMistake.getMistakeType() == newMistake.getMistakeType()) {
            if (haveInstructorAndStudentElements(existingMistake, newMistake)) {
              if (zerothStudentElement(existingMistake).equals(zerothStudentElement(newMistake))
                  && zerothInstructorElement(existingMistake).equals(zerothInstructorElement(newMistake))) {
                setMistakeProperties(existingMistake, false, existingMistake.getNumDetection() + 1, 0);
                existingMistakesProcessed.add(existingMistake);
                newMistakesProcessed.add(newMistake);
              }
            } else if (haveOnlyStudentElements(existingMistake, newMistake)) {
              // System.out.println("O "+existingMistake.getStudentElements().get(0).getElement());
              // System.out.println("F "+zerothStudentElement(existingMistake));
              if (zerothStudentElement(existingMistake).equals(zerothStudentElement(newMistake))) {
                setMistakeProperties(existingMistake, false, existingMistake.getNumDetection() + 1, 0);
                existingMistakesProcessed.add(existingMistake);
                newMistakesProcessed.add(newMistake);
              }
            } else if (haveOnlyInstructorElements(existingMistake, newMistake)) {
              if (zerothInstructorElement(existingMistake).equals(zerothInstructorElement(newMistake))) {
                setMistakeProperties(existingMistake, false, existingMistake.getNumDetection() + 1, 0);
                existingMistakesProcessed.add(existingMistake);
                newMistakesProcessed.add(newMistake);
              }
            }
          }
        }
      }
      
      for (Mistake existingMistake : existingMistakes) {
        if (!existingMistakesProcessed.contains(existingMistake)) {
          if (existingMistake.getNumDetectionSinceResolved() <= MAX_DETECTIONS_AFTER_RESOLUTION
              && existingMistake.isResolved()) {
            existingMistake.setResolved(true);
            existingMistake.setNumDetectionSinceResolved(existingMistake.getNumDetectionSinceResolved() + 1);
          } else {
            existingMistake.setStudentSolution(null);
            existingMistake.getInstructorElements().clear();
            existingMistake.getStudentElements().clear();
          }
        }
      }

      for (Mistake newMistake : newMistakes) {
        if (!newMistakesProcessed.contains(newMistake)) {
        setMistakeProperties(newMistake, false, 1, 0);
        newMistake.setStudentSolution(studentSolution);
        }
      }
    } else if (existingMistakes.size() != 0 && newMistakes.size() == 0) {
      // System.out.println("In 3");
      for (Mistake existingMistake : existingMistakes) {
        if (existingMistake.getNumDetectionSinceResolved() <= MAX_DETECTIONS_AFTER_RESOLUTION) {
          existingMistake.setResolved(true);
          existingMistake.setNumDetectionSinceResolved(existingMistake.getNumDetectionSinceResolved() + 1);
        } else {
          existingMistake.setStudentSolution(null);
          existingMistake.getInstructorElements().clear();
          existingMistake.getStudentElements().clear();
        }
      }
    }

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

  /** Returns a mistake's zeroth student element. */
  private static NamedElement zerothStudentElement(Mistake mistake) {
    return mistake.getStudentElements().get(0).getElement();
  }

  /** Returns a mistake's zeroth instructor element. */
  private static NamedElement zerothInstructorElement(Mistake mistake) {
    return mistake.getInstructorElements().get(0).getElement();
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
   * @return boolean
   */
  public static boolean checkCorrect(Classifier instructorClass, Classifier studentClass, Comparison comparison) {
    boolean isMapped = false;
    EList<Attribute> iAttributes = instructorClass.getAttributes();
    EList<Attribute> sAttributes = studentClass.getAttributes();
    // System.out.println("Function called with i="+ instructorClassifier.getName() +" s="
    // +studentClassifier.getName()); //FOR DEBUGGING

    float lDistance = levenshteinDistance(studentClass.getName(), instructorClass.getName());
    if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      isMapped = true;
      comparison.mappedClassifier.put(instructorClass, studentClass);
      comparison.notMappedInstructorClassifier.remove(instructorClass);
      comparison.extraStudentClassifier.remove(studentClass);
    }

    // Commented print statements for debugging
    if (isMapped) { // Map attributes if classifiers map.
      for (Attribute iAttribute : iAttributes) { // To check association -> Not at present.
        // System.out.println("Instructor "+ iAttribute +" " +instructorClassifier.getName());
        for (Attribute sAttribute : sAttributes) {
          // System.out.println("Student "+ sAttribute+" " +studentClassifier.getName());
          lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
          if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED
              && comparison.mappedAttribute.get(iAttribute) == sAttribute) {
            comparison.duplicateStudentAttribute.add(sAttribute);
            comparison.extraStudentAttribute.remove(sAttribute);
          } else if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
            // System.out.println("Mapped");
            comparison.mappedAttribute.put(iAttribute, sAttribute);
            comparison.notMappedInstructorAttribute.remove(iAttribute);
            comparison.extraStudentAttribute.remove(sAttribute);
            break;
          }
        }
      }
    }

    return isMapped;
  }

  public static void notMatchedMapping(Comparison comparison) {
    if (!comparison.notMappedInstructorClassifier.isEmpty() && !comparison.extraStudentClassifier.isEmpty()) {
      int counter = 1;
      for (int k = 0; k < counter; k++) {
        for (int i = 0; i < comparison.notMappedInstructorClassifier.size(); i++) {
          EList<Attribute> iAttributes = comparison.notMappedInstructorClassifier.get(i).getAttributes();
          Classifier instructorClassifier = comparison.notMappedInstructorClassifier.get(i);
          // System.out.println("Instructor " + instructorClassifier.getName());
          int totalAttributes = iAttributes.size();

          for (int j = 0; j < comparison.extraStudentClassifier.size(); j++) {
            Classifier studentClassifier = comparison.extraStudentClassifier.get(j);
            EList<Attribute> sAttributes = studentClassifier.getAttributes();
            // System.out.println("Student " + studentClassifier.getName());
            int correctAttribute = 0;
            for (Attribute iAttribute : iAttributes) { // To check association -> Not at present.
              for (Attribute sAttribute : sAttributes) {
                float lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
                if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
                  correctAttribute++;
                  break;
                }
              }
            }
            // System.out.println("CorrectAttribute "+ " "+ instructorClassifier.getName() +" "+
            // studentClassifier.getName()+" "+ correctAttribute);
            if (totalAttributes != 0) {
              if ((double)correctAttribute / (double)totalAttributes > 0.5) {
                comparison.mappedClassifier.put(instructorClassifier, studentClassifier);
                comparison.notMappedInstructorClassifier.remove(instructorClassifier);
                comparison.extraStudentClassifier.remove(studentClassifier);
                counter++;
                for (Attribute iAttribute : iAttributes) { // To check association -> Not at present.
                  for (Attribute sAttribute : sAttributes) {
                    float lDistance =
                        levenshteinDistance(sAttribute.getName(), iAttribute.getName());
                    if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
                      // System.out.println(instructorClassifier.getName() + " " +
                      // sAttribute.getName()+ " " + iAttribute.getName());
                      comparison.mappedAttribute.put(iAttribute, sAttribute);
                      comparison.notMappedInstructorAttribute.remove(iAttribute);
                      comparison.extraStudentAttribute.remove(sAttribute);
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
  }

  /**
   * Checks for a software engineering term in a given classifier.
   */
  public static Optional<Mistake> checkMistakeSoftwareEngineeringTerm(Classifier studentClass,Classifier instructorClass) {
    if (isSoftwareEngineeringTerm(studentClass.getName())) {
      return Optional.of(createMistake(SOFTWARE_ENGINEERING_TERM, studentClass, instructorClass));
    }
    return Optional.empty();
  }


  public static Optional<Mistake> checkMistakePluralClassName(Classifier studentClass, Classifier instructorClass) {
    if (isPlural(studentClass.getName())) {
      return Optional.of(createMistake(USING_PLURAL_OR_LOWERCASE, studentClass, instructorClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeClassSpelling(Classifier studentClass, Classifier instructorClass) {
    int lDistance = levenshteinDistance(studentClass.getName(), instructorClass.getName());
    if (lDistance != 0) {
      return Optional.of(createMistake(BAD_CLASS_NAME_SPELLING, studentClass, instructorClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeAttributeSpelling(Attribute sAttribute, Attribute iAttribute) {
    int lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
    if (lDistance != 0) {
      return Optional.of(createMistake(BAD_ATTRIBUTE_NAME_SPELLING, sAttribute,iAttribute));
    }
    return Optional.empty();
  }

  public static int levenshteinDistance(String string1, String string2) {
    return LevenshteinDistance.getDefaultInstance().apply(string1, string2);
  }

  public static Optional<Mistake> checkMistakeLowerClassName(Classifier studentClass, Classifier instructorClass) {
    if (isLowerName(studentClass.getName())) {
      return Optional.of(createMistake(USING_PLURAL_OR_LOWERCASE, studentClass, instructorClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeWrongEnumerationClass(Classifier studentClass,
      Classifier instructorClass) {
    if (!classEnumStatusesMatch(studentClass, instructorClass)) {
      return Optional.of(createMistake(REGULAR_CLASS_SHOULD_BE_AN_ENUMERATION_OR_VICE_VERSA, studentClass,instructorClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeWrongAttributeType(Attribute sAttribute, Attribute iAttribute) {
    if (!attributeTypesMatch(sAttribute, iAttribute)) {
      return Optional.of(createMistake(WRONG_ATTRIBUTE_TYPE, sAttribute,iAttribute));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeAttributeStatic(Attribute sAttribute, Attribute iAttribute) {
    if (!attributeStaticPropertiesMatch(sAttribute, iAttribute)) {
      return Optional.of(createMistake(ATTRIBUTE_EXPECTED_TO_BE_STATIC_BUT_IS_NOT_OR_VICE_VERSA, sAttribute,iAttribute));
    }
    return Optional.empty();
  }

  public static void checkMistakeMissingClass(Comparison comparison) {
    comparison.notMappedInstructorClassifier.forEach(cls ->
      comparison.newMistakes.add(createMistake(MISSING_CLASS, null, cls))); // No Student Element
  }

  public static void checkMistakeExtraClass(Comparison comparison) {
    comparison.extraStudentClassifier.forEach(cls ->
      comparison.newMistakes.add(createMistake(EXTRA_CLASS, cls, null))); //  No Instructor Element
  }

  public static void checkMistakeMissingAttribute(Comparison comparison) {
    comparison.notMappedInstructorAttribute.forEach(cls ->
      comparison.newMistakes.add(createMistake(MISSING_ATTRIBUTE, null, cls)));
  }

  public static void checkMistakeExtraAttribute(Comparison comparison) {
    comparison.extraStudentAttribute.forEach(cls ->
      comparison.newMistakes.add(createMistake(OTHER_EXTRA_ATTRIBUTE, cls , null)));
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
      s = s.toLowerCase();
      String tagged = maxentTagger.tagString(s);
      String[] str = tagged.split("/");
      String pluralTag = "NNS";
      if (str[1].contains(pluralTag)) {
        isPlural = true;
      }
      s = s.substring(0, 1).toUpperCase() + s.substring(1);
      nounPluralStatus.put(s, isPlural);
    }
    return isPlural;
  }

  public static boolean attributeTypesMatch(Attribute sAttribute, Attribute iAttribute){
    return sAttribute.getType().getClass().equals(iAttribute.getType().getClass());
  }

  /** Returns true if both classes are enum classes or if both are not. */
  public static boolean classEnumStatusesMatch(Classifier studentClassifier,
      Classifier instructorClassifier) {
    return instructorClassifier instanceof CDEnum == studentClassifier instanceof CDEnum;
  }

  /** Returns true if the student and instructor attributes' static properties match. */
  public static boolean attributeStaticPropertiesMatch(Attribute sAttribute, Attribute iAttribute) {
    return sAttribute.isStatic() == iAttribute.isStatic();
  }

  public static boolean isLowerName(String name) {
    return name.toLowerCase() == name;
  }

  /** Creates a new mistake from the input parameters. */
  private static Mistake createMistake(MistakeType mistakeType, NamedElement studentElement, NamedElement instructorElement) {
    var mistake = MAF.createMistake();
    mistake.setMistakeType(mistakeType);

    // TODO Use existing solution element when available
    if (studentElement!= null) {
    var solutionElement = MAF.createSolutionElement();
    solutionElement.setElement(studentElement);
    mistake.getStudentElements().add(solutionElement);
    }
    if (instructorElement!= null) {
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
  public static boolean checkCorrectTest(Classifier instructorClassifier, Classifier studentClassifier,
      Comparison comparison) {
    //clearAttributesAndClassifer();
    boolean isMapped = false;
    EList<Attribute> iAttributes = instructorClassifier.getAttributes();
    EList<Attribute> sAttributes = studentClassifier.getAttributes();

    comparison.notMappedInstructorClassifier.add(instructorClassifier);
    comparison.extraStudentClassifier.add(studentClassifier);

    int totalAttibutes = iAttributes.size();
    int correctAttribute = 0;
    float lDistance =
        levenshteinDistance(studentClassifier.getName(), instructorClassifier.getName());
    if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      isMapped = true;
      comparison.mappedClassifier.put(instructorClassifier, studentClassifier);
      comparison.notMappedInstructorClassifier.remove(instructorClassifier);
      comparison.extraStudentClassifier.remove(studentClassifier);
    } else {
      for (Attribute iAttribute : iAttributes) { // To check association -> Not at present.
        for (Attribute sAttribute : sAttributes) {
          lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
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
      for (Attribute iAttribute : iAttributes) { // To check association -> Not at present.
        comparison.notMappedInstructorAttribute.add(iAttribute);
        for (Attribute sAttribute : sAttributes) {
          if (!processed) // To stop duplicate entries.
            comparison.extraStudentAttribute.add(sAttribute);

          lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
          if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED && comparison.mappedAttribute.containsValue(sAttribute)) {
            comparison.duplicateStudentAttribute.add(sAttribute);
            comparison.extraStudentAttribute.remove(sAttribute);
          } else if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
            comparison.mappedAttribute.put(iAttribute, sAttribute);
            comparison.notMappedInstructorAttribute.remove(iAttribute);
            comparison.extraStudentAttribute.remove(sAttribute);
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
