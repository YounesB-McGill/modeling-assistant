package ca.mcgill.sel.mistakedetection;

import static modelingassistant.mistaketypes.MistakeTypes.ATTRIBUTE_EXPECTED_TO_BE_STATIC_BUT_IS_NOT_OR_VICE_VERSA;
import static modelingassistant.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static modelingassistant.mistaketypes.MistakeTypes.BAD_CLASS_NAME_SPELLING;
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
import classdiagram.Association;
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

  // TODO Refactor lists and hashmaps

  /** Maps an instructor solution classifier to student solution classifier. */
  public static Map<Classifier, Classifier> mappedClassifier =
      new HashMap<Classifier, Classifier>();

  /** Maps an instructor solution classifier attribute to student solution classifier attribute. */
  public static Map<Attribute, Attribute> mappedAttribute = new HashMap<Attribute, Attribute>();

  /** Maps an instructor solution classifier relation to student solution classifier relation. */
  public static Map<Association, Association> mappedRelation =
      new HashMap<Association, Association>();

  public static EList<Classifier> notMappedInstructorClassifier = new BasicEList<Classifier>();
  public static EList<Classifier> extraStudentClassifier = new BasicEList<Classifier>();

  public static EList<Attribute> notMappedInstructorAttribute = new BasicEList<Attribute>();
  public static EList<Attribute> extraStudentAttribute = new BasicEList<Attribute>();
  public static EList<Attribute> duplicateStudentAttribute = new BasicEList<Attribute>();
  // EList<Attribute> wrongStudentAttribute = new EList<Attribute>; // Commented temporarily

  // public static EList<Association> notMappedInstructorRelation;

  // public static EList<Association> extraStudentRelation;


  public static List<Mistake> compare(Solution instructorSolution, Solution studentSolution) {
    if (!isInstructorSolution(instructorSolution) || !isStudentSolution(studentSolution)) {
      throw new IllegalArgumentException("The input is not a valid (instructorSolution, studentSolution) pair.");
    }
    clearAttributesAndClassifer();

    EList<Mistake> newMistakes = new BasicEList<Mistake>();
    var instructorClassifiers = instructorSolution.getClassDiagram().getClasses();
    var studentClassifiers = studentSolution.getClassDiagram().getClasses();

    var processed = false;
    for (Classifier instructorClassifier : instructorClassifiers) {
      notMappedInstructorClassifier.add(instructorClassifier);
      EList<Attribute> iAttributes = instructorClassifier.getAttributes();
      for (Attribute attribute : iAttributes) {
        notMappedInstructorAttribute.add(attribute);
      }

      for (Classifier studentClassifier : studentClassifiers) {
        if (!processed) { // To stop duplicate entries.
          extraStudentClassifier.add(studentClassifier);
          EList<Attribute> sAttributes = studentClassifier.getAttributes();
          for (Attribute attribute : sAttributes) {
            extraStudentAttribute.add(attribute);
          }
        }
        if (checkCorrect(instructorClassifier, studentClassifier)) {
          checkMistakeClassSpelling(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
          checkMistakeSoftwareEngineeringTerm(studentClassifier).ifPresent(newMistakes::add);
          checkMistakePluralClassName(studentClassifier).ifPresent(newMistakes::add);
          checkMistakeLowerClassName(studentClassifier).ifPresent(newMistakes::add);
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
    notMatchedMapping();
    // checkMistakeMissingClass();
    // checkMistakeExtraClass();
    // checkMistakeDuplicateAttributes();
    // checkMistakeExtraAttribute();
    // checkMistakeMissingAttribute();
    // checkMistakeWrongAttribute();
    // checkMistakeAttributeMisplaced();
    // checkMistakeIncompleteContainmentTree(studentClassifiers);

    return updateMistakes(studentSolution, newMistakes); // This function updates new and older mistakes in the metamodel.
  }

  private static List<Mistake> updateMistakes(Solution studentSolution, List<Mistake> newMistakes) {
    // List containing mistakes associated with a student Solution
    EList<Mistake> existingMistakes = new BasicEList<Mistake>();
    existingMistakes = studentSolution.getMistakes();

    // List containing existing mistakes that are equal to newMistakes
    EList<Mistake> existingMistakesProcessed = new BasicEList<Mistake>();

    // List containing mistakes to  be removed from new Mistake
    EList<Mistake> newMistakesToRemove = new BasicEList<Mistake>();

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
                newMistakesToRemove.add(newMistake);
              }
            } else if (haveOnlyStudentElements(existingMistake, newMistake)) {
              // System.out.println("O "+existingMistake.getStudentElements().get(0).getElement());
              // System.out.println("F "+zerothStudentElement(existingMistake));
              if (zerothStudentElement(existingMistake).equals(zerothStudentElement(newMistake))) {
                setMistakeProperties(existingMistake, false, existingMistake.getNumDetection() + 1, 0);
                existingMistakesProcessed.add(existingMistake);
                newMistakesToRemove.add(newMistake);
              }
            } else if (haveOnlyInstructorElements(existingMistake, newMistake)) {
              if (zerothInstructorElement(existingMistake).equals(zerothInstructorElement(newMistake))) {
                setMistakeProperties(existingMistake, false, existingMistake.getNumDetection() + 1, 0);
                existingMistakesProcessed.add(existingMistake);
                newMistakesToRemove.add(newMistake);
              }
            }
          }
        }
      }
      newMistakes.removeAll(newMistakesToRemove);
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
        setMistakeProperties(newMistake, false, 1, 0);
        newMistake.setStudentSolution(studentSolution);
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
    return newMistakes;
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
   * @param instructorClassifier
   * @param studentClassifier
   * @return boolean
   */
  public static boolean checkCorrect(Classifier instructorClassifier,
      Classifier studentClassifier) {
    boolean isMapped = false;
    EList<Attribute> iAttributes = instructorClassifier.getAttributes();
    EList<Attribute> sAttributes = studentClassifier.getAttributes();
    // System.out.println("Function called with i="+ instructorClassifier.getName() +" s="
    // +studentClassifier.getName()); //FOR DEBUGGING

    float lDistance =
        levenshteinDistance(studentClassifier.getName(), instructorClassifier.getName());
    if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      isMapped = true;
      mappedClassifier.put(instructorClassifier, studentClassifier);
      notMappedInstructorClassifier.remove(instructorClassifier);
      extraStudentClassifier.remove(studentClassifier);
    }

    // Commented print statements for debugging
    if (isMapped) { // Map attributes if classifiers map.
      for (Attribute iAttribute : iAttributes) { // To check association -> Not at present.
        // System.out.println("Instructor "+ iAttribute +" " +instructorClassifier.getName());
        for (Attribute sAttribute : sAttributes) {
          // System.out.println("Student "+ sAttribute+" " +studentClassifier.getName());
          lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
          if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED && mappedAttribute.get(iAttribute) == sAttribute) {
            duplicateStudentAttribute.add(sAttribute);
            extraStudentAttribute.remove(sAttribute);
          } else if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
            // System.out.println("Mapped");
            mappedAttribute.put(iAttribute, sAttribute);
            notMappedInstructorAttribute.remove(iAttribute);
            extraStudentAttribute.remove(sAttribute);
            break;
          }
        }
      }
    }

    return isMapped;
  }

  public static void notMatchedMapping() {
    if (!notMappedInstructorClassifier.isEmpty() && !extraStudentClassifier.isEmpty()) {
      int counter = 1;
      for (int k = 0; k < counter; k++) {
        for (int i = 0; i < notMappedInstructorClassifier.size(); i++) {
          EList<Attribute> iAttributes = notMappedInstructorClassifier.get(i).getAttributes();
          Classifier instructorClassifier = notMappedInstructorClassifier.get(i);
          // System.out.println("Instructor " + instructorClassifier.getName());
          int totalAttributes = iAttributes.size();

          for (int j = 0; j < extraStudentClassifier.size(); j++) {
            Classifier studentClassifier = extraStudentClassifier.get(j);
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
                mappedClassifier.put(instructorClassifier, studentClassifier);
                notMappedInstructorClassifier.remove(instructorClassifier);
                extraStudentClassifier.remove(studentClassifier);
                counter++;
                for (Attribute iAttribute : iAttributes) { // To check association -> Not at present.
                  for (Attribute sAttribute : sAttributes) {
                    float lDistance =
                        levenshteinDistance(sAttribute.getName(), iAttribute.getName());
                    if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
                      // System.out.println(instructorClassifier.getName() + " " +
                      // sAttribute.getName()+ " " + iAttribute.getName());
                      mappedAttribute.put(iAttribute, sAttribute);
                      notMappedInstructorAttribute.remove(iAttribute);
                      extraStudentAttribute.remove(sAttribute);
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
  public static Optional<Mistake> checkMistakeSoftwareEngineeringTerm(Classifier studentClass) {
    if (isSoftwareEngineeringTerm(studentClass.getName())) {
      return Optional.of(createMistake(SOFTWARE_ENGINEERING_TERM, studentClass));
    }
    return Optional.empty();
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
    MaxentTagger tagger;
    Boolean bool = false;

    if (nounPluralStatus.containsKey(s)) {
      return nounPluralStatus.get(s);
    } else {
      try {
        tagger = new MaxentTagger("taggers/left3words-wsj-0-18.tagger");
        s = s.toLowerCase();
        String tagged = tagger.tagString(s);
        String[] str = tagged.split("/");
        String pluralTag = "NNS";
        if (str[1].contains(pluralTag)) {
          bool = true;
        }
      } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
      }
      s = s.substring(0, 1).toUpperCase() + s.substring(1);
      nounPluralStatus.put(s, bool);

      return bool;
    }
  }

  public static Optional<Mistake> checkMistakePluralClassName(Classifier studentClass) {
    if (isPlural(studentClass.getName())) {
      return Optional.of(createMistake(USING_PLURAL_OR_LOWERCASE, studentClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeClassSpelling(Classifier studentClass, Classifier instructorClass) {
    int lDistance = levenshteinDistance(studentClass.getName(), instructorClass.getName());
    if (lDistance != 0) {
      return Optional.of(createMistake(BAD_CLASS_NAME_SPELLING, studentClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeAttributeSpelling(Attribute sAttribute, Attribute iAttribute) {
    int lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
    if (lDistance != 0) {
      return Optional.of(createMistake(BAD_ATTRIBUTE_NAME_SPELLING, sAttribute));
    }
    return Optional.empty();
  }

  public static int levenshteinDistance(String string1, String string2) {
    return LevenshteinDistance.getDefaultInstance().apply(string1, string2);
  }

  public static Optional<Mistake> checkMistakeLowerClassName(Classifier studentClass) {
    if (isLowerName(studentClass.getName())) {
      return Optional.of(createMistake(USING_PLURAL_OR_LOWERCASE, studentClass));
    }
    return Optional.empty();
  }

  public static boolean isLowerName(String name) {
    return name.toLowerCase() == name;
  }

  public static Optional<Mistake> checkMistakeWrongEnumerationClass(Classifier studentClass,
      Classifier instructorClass) {
    if (!classEnumStatusesMatch(studentClass, instructorClass)) {
      return Optional.of(createMistake(REGULAR_CLASS_SHOULD_BE_AN_ENUMERATION_OR_VICE_VERSA, studentClass));
    }
    return Optional.empty();
   }

  /** Returns true if both classes are enum classes or if both are not. */
  public static boolean classEnumStatusesMatch(Classifier studentClassifier,
      Classifier instructorClassifier) {
    return instructorClassifier instanceof CDEnum == studentClassifier instanceof CDEnum;
  }

  public static Optional<Mistake> checkMistakeWrongAttributeType(Attribute sAttribute, Attribute iAttribute) {
    if (!attributeTypesMatch(sAttribute, iAttribute)) {
      return Optional.of(createMistake(WRONG_ATTRIBUTE_TYPE, sAttribute));
    }
    return Optional.empty();
  }

  public static boolean attributeTypesMatch(Attribute sAttribute, Attribute iAttribute){
    return sAttribute.getType().getClass().equals(iAttribute.getType().getClass());
  }

  public static Optional<Mistake> checkMistakeAttributeStatic(Attribute sAttribute, Attribute iAttribute) {
    if (!attributeStaticPropertiesMatch(sAttribute, iAttribute)) {
      return Optional.of(createMistake(ATTRIBUTE_EXPECTED_TO_BE_STATIC_BUT_IS_NOT_OR_VICE_VERSA, sAttribute));
    }
    return Optional.empty();
  }

  /** Returns true if the student and instructor attributes' static properties match. */
  public static boolean attributeStaticPropertiesMatch(Attribute sAttribute, Attribute iAttribute) {
    return sAttribute.isStatic() == iAttribute.isStatic();
  }

  /** Creates a new mistake from the input parameters. */
  private static Mistake createMistake(MistakeType mistakeType, NamedElement studentElement) {
    var mistake = MAF.createMistake();
    mistake.setMistakeType(mistakeType);

    // TODO Use existing solution element when available
    var solutionElement = MAF.createSolutionElement();
    solutionElement.setElement(studentElement);
    mistake.getStudentElements().add(solutionElement);

    return mistake;
  }

  /***
   * This is a function created for testing the logic. Only for test.
   *
   * @param instructorClassifier
   * @param studentClassifier
   * @return
   */
  public static boolean checkCorrectTest(Classifier instructorClassifier, Classifier studentClassifier) {
    clearAttributesAndClassifer();
    boolean isMapped = false;
    EList<Attribute> iAttributes = instructorClassifier.getAttributes();
    EList<Attribute> sAttributes = studentClassifier.getAttributes();

    notMappedInstructorClassifier.add(instructorClassifier);
    extraStudentClassifier.add(studentClassifier);

    int totalAttibutes = iAttributes.size();
    int correctAttribute = 0;
    float lDistance =
        levenshteinDistance(studentClassifier.getName(), instructorClassifier.getName());
    if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      isMapped = true;
      mappedClassifier.put(instructorClassifier, studentClassifier);
      notMappedInstructorClassifier.remove(instructorClassifier);
      extraStudentClassifier.remove(studentClassifier);
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
      if (correctAttribute / totalAttibutes > 0.5 && isMapped == false) {
        mappedClassifier.put(instructorClassifier, studentClassifier);
        notMappedInstructorClassifier.remove(instructorClassifier);
        extraStudentClassifier.remove(studentClassifier);

        isMapped = true;
      }
    }

    if (isMapped == true) { // Map attributes if classifiers map.
      int count = 0;
      for (Attribute iAttribute : iAttributes) { // To check association -> Not at present.
        notMappedInstructorAttribute.add(iAttribute);
        for (Attribute sAttribute : sAttributes) {
          if (count != 1) // To stop duplicate entries.
            extraStudentAttribute.add(sAttribute);

          lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
          if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED && mappedAttribute.containsValue(sAttribute)) {
            duplicateStudentAttribute.add(sAttribute);
            extraStudentAttribute.remove(sAttribute);
          } else if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
            mappedAttribute.put(iAttribute, sAttribute);
            notMappedInstructorAttribute.remove(iAttribute);
            extraStudentAttribute.remove(sAttribute);
            break;
          }
        }
        count = 1;
      }
    }

    return isMapped;
  }

  public static void clearAttributesAndClassifer() {
    mappedClassifier.clear();
    extraStudentClassifier.clear();
    notMappedInstructorClassifier.clear();
    mappedAttribute.clear();
    extraStudentAttribute.clear();
    notMappedInstructorAttribute.clear();
    duplicateStudentAttribute.clear();
  }

  public static void showMistakes(List<Mistake> mistakes) {
    for (Mistake m : mistakes) {
      System.out.println(m.getMistakeType().getName() + " in "
          + m.getStudentElements().get(0).getElement().getName());
    }
  }

}
