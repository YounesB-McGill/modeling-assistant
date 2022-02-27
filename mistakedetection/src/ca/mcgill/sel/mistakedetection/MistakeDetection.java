package ca.mcgill.sel.mistakedetection;

import static ca.mcgill.sel.classdiagram.ReferenceType.AGGREGATION;
import static ca.mcgill.sel.classdiagram.ReferenceType.COMPOSITION;
import static ca.mcgill.sel.classdiagram.ReferenceType.REGULAR;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_CLASS_SHOULD_BE_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_SHOULD_BE_ENUM_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_SHOULD_BE_FULL_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_SHOULD_BE_SUBCLASS_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_DUPLICATED;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_MISPLACED;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ASSOC_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ENUM_ITEM_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ENUM_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ROLE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ABSTRACT;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_NOT_BE_ABSTRACT;
import static learningcorpus.mistaketypes.MistakeTypes.COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_ASSOC_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_FULL_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_SUBCLASS_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ENUM_ITEM;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_GENERALIZATION;
import static learningcorpus.mistaketypes.MistakeTypes.FULL_PR_PATTERN_SHOULD_BE_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.FULL_PR_PATTERN_SHOULD_BE_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.FULL_PR_PATTERN_SHOULD_BE_SUBCLASS;
import static learningcorpus.mistaketypes.MistakeTypes.GENERALIZATION_SHOULD_BE_ASSOC_AO_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.INCOMPLETE_AO_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.INCOMPLETE_CONTAINMENT_TREE;
import static learningcorpus.mistaketypes.MistakeTypes.INCOMPLETE_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.INFINITE_RECURSIVE_DEPENDENCY;
import static learningcorpus.mistaketypes.MistakeTypes.LIST_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.LOWERCASE_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_AO_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ENUM_ITEM;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_GENERALIZATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ROLE_NAMES;
import static learningcorpus.mistaketypes.MistakeTypes.NON_DIFFERENTIATED_SUBCLASS;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.REPRESENTING_ACTION_WITH_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.SOFTWARE_ENGINEERING_TERM;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_ASSOC_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_ENUM_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_FULL_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.UPPERCASE_ATTRIBUTE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_INSTEAD_OF_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ASSOC_INSTEAD_OF_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ASSOC_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ATTRIBUTE_INSTEAD_OF_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED;
import static learningcorpus.mistaketypes.MistakeTypes.USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_GENERALIZATION_DIRECTION;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_RELATIONSHIP_DIRECTION;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_SUPERCLASS;
import static modelingassistant.TagType.ABSTRACTION;
import static modelingassistant.TagType.OCCURRENCE;
import static modelingassistant.TagType.PLAYER;
import static modelingassistant.TagType.ROLE;
import static modelingassistant.util.ClassDiagramUtils.getAssocAggCompFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getEnumFromClassDiagram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.apache.commons.text.similarity.LevenshteinDistance;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.CDArray;
import ca.mcgill.sel.classdiagram.CDCollection;
import ca.mcgill.sel.classdiagram.CDEnum;
import ca.mcgill.sel.classdiagram.CDEnumLiteral;
import ca.mcgill.sel.classdiagram.CdmFactory;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.classdiagram.NamedElement;
import ca.mcgill.sel.classdiagram.ReferenceType;
import ca.mcgill.sel.classdiagram.Type;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import learningcorpus.MistakeType;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.Solution;
import modelingassistant.SolutionElement;
import modelingassistant.Tag;
import modelingassistant.TagGroup;
import modelingassistant.TagType;

/**
 * This is the main class of Mistake Detection System. This class contains functions that maps and
 * find mistakes in the elements of the two solutions passed to it. 'compare()' is the function to
 * call to check mistakes in two solutions.
 *
 * @author Prabhsimran Singh
 */
public class MistakeDetection {

  public static final CdmFactory CDF = CdmFactory.eINSTANCE;
  public static final ModelingassistantFactory MAF = ModelingassistantFactory.eINSTANCE;

  /** The maximum limit after which a resolved mistake will be removed from student solution. */
  public static final int MAX_DETECTIONS_AFTER_RESOLUTION = 5;

  /** The maximum number of difference two words can have in terms of letters. */
  public static final int MAX_LEVENSHTEIN_DISTANCE_ALLOWED = 2;

  public static final int LOW_PRIORITY = 1;
  public static final int MID_PRIORITY = 2;
  public static final int HIGH_PRIORITY = 3;

  /** The minimum number of roles and player required for a pattern match. */
  public static final int MIN_PR_MATCH_REQIUIRED = 2;

  public static final String SUB_CLASS_PR_PATTERN = "subClassPlayerRolePattern";

  public static final String FULL_PR_PATTERN = "fullPlayerRolePattern";

  public static final String ENUM_PR_PATTERN = "EnumerationPlayerRolePattern";

  public static final String ASSOC_PR_PATTERN = "AssociationPlayerRolePattern";

  public static final String ABSTRACTION_OCCURRENCE_PATTERN = "AbstractionOccurrencePattern";

  public static final String NO_PR_PATTERN_DETECTED = "NoPlayerRolePatternDetected";

  /** Cache to map nouns to true if they are plural, false otherwise. */
  static final Map<String, Boolean> nounPluralStatus = new HashMap<>();

  /** Cache to map verbs to true if they are verb, false otherwise. */
  static final Map<String, Boolean> verbStatus = new HashMap<>();

  /** The Stanford NLP Maximum Entropy Part-of-Speech Tagger. */
  private static final MaxentTagger maxentTagger = getMaxentTagger();

  /**
   * Compares the given student solution to the instructor's and adds filtered mistakes to it.
   *
   * Calling this method is equivalent to calling
   * {@code compare(instructorSolution, studentSolution, true)}.
   *
   * @param instructorSolution
   * @param studentSolution
   * @return a Comparison object
   */
  public static Comparison compare(Solution instructorSolution, Solution studentSolution) {
    return compare(instructorSolution, studentSolution, true);
  }

  public static Comparison compare(Solution instructorSolution, Solution studentSolution, boolean filter) {
    if (!isInstructorSolution(instructorSolution) || !isStudentSolution(studentSolution)) {
      throw new IllegalArgumentException("The input is not a valid (instructorSolution, studentSolution) pair.");
    }
    var comparison = new Comparison();

    var newMistakes = comparison.newMistakes;
    var instructorClassifiers = instructorSolution.getClassDiagram().getClasses();
    var studentClassifiers = studentSolution.getClassDiagram().getClasses();

    var processed = false;
    if (instructorClassifiers.isEmpty()) {
      for (Classifier studentClassifier : studentClassifiers) {
        comparison.extraStudentClassifiers.add(studentClassifier);
        List<Attribute> studentAttributes = studentClassifier.getAttributes();
        comparison.extraStudentAttributes.addAll(studentAttributes);
        List<String> processedStudentAttributes = new ArrayList<String>();
        for (Attribute studentAttribute : studentAttributes) {
          if (processedStudentAttributes.contains(studentAttribute.getName())
              && !isMistakeExist(ATTRIBUTE_DUPLICATED, studentAttribute, comparison)) {
            comparison.newMistakes.add(createMistake(ATTRIBUTE_DUPLICATED, studentAttribute, null));
          }
          processedStudentAttributes.add(studentAttribute.getName());
        }
        studentClassifier.getAssociationEnds().forEach((assoc) -> {
          if (!comparison.extraStudentAssociations.contains(assoc.getAssoc())) {
            comparison.extraStudentAssociations.add(assoc.getAssoc());
          }
        });
      }
    }
    for (Classifier instructorClassifier : instructorClassifiers) {
      comparison.notMappedInstructorClassifiers.add(instructorClassifier);
      if (!instructorClassifier.getSuperTypes().isEmpty()) {
        comparison.instructorGeneralizationClassifiers.add(instructorClassifier);
      }
      List<Attribute> instructorAttributes = instructorClassifier.getAttributes();
      comparison.notMappedInstructorAttributes.addAll(instructorAttributes);
      instructorClassifier.getAssociationEnds().forEach(assoc -> {
        if (!comparison.notMappedInstructorAssociations.contains(assoc.getAssoc())) {
          comparison.notMappedInstructorAssociations.add(assoc.getAssoc());
        }
      });
      Classifier possibleClassifierMatch = null;
      int priority = 0;
      for (Classifier studentClassifier : studentClassifiers) {
        if (!processed) { // To stop duplicate entries.
          comparison.extraStudentClassifiers.add(studentClassifier);
          if(!studentClassifier.getSuperTypes().isEmpty()) {
            comparison.studentGeneralizationClassifiers.add(studentClassifier);
          }
          List<Attribute> studentAttributes = studentClassifier.getAttributes();
          comparison.extraStudentAttributes.addAll(studentAttributes);
          List<String> processedStudentAttributes = new ArrayList<String>();
          for (Attribute studentAttribute : studentAttributes) {
            if (processedStudentAttributes.contains(studentAttribute.getName())
                && !isMistakeExist(ATTRIBUTE_DUPLICATED, studentAttribute, comparison)) {
              comparison.newMistakes.add(createMistake(ATTRIBUTE_DUPLICATED, studentAttribute, null));
            }
            processedStudentAttributes.add(studentAttribute.getName());
          }
          studentClassifier.getAssociationEnds().forEach((assoc) -> {
            if (!comparison.extraStudentAssociations.contains(assoc.getAssoc())) {
              comparison.extraStudentAssociations.add(assoc.getAssoc());
            }
          });
        }

        if (classifierNameMatch(instructorClassifier, studentClassifier)) {
          if (priority <= HIGH_PRIORITY) {
            possibleClassifierMatch = studentClassifier;
            priority = HIGH_PRIORITY;
          }
        } else if (checkClassAndAttribBasedOnSpellingError(instructorClassifier, studentClassifier)) {
          if (priority <= MID_PRIORITY) {
            possibleClassifierMatch = studentClassifier;
            priority = MID_PRIORITY;
          }
        } else if (checkClassAndAttribBasedOnSubStrings(instructorClassifier, studentClassifier)) {
          if (priority <= LOW_PRIORITY) {
            possibleClassifierMatch = studentClassifier;
            priority = LOW_PRIORITY;
          }
        }
      }
      processed = true;

      if (possibleClassifierMatch == null) {
        continue;
      }

      Classifier classToRemove = null;
      if (priority == HIGH_PRIORITY && comparison.mappedClassifiers.containsValue(possibleClassifierMatch)) {
        classToRemove = getKey(comparison.mappedClassifiers, possibleClassifierMatch);
        comparison.mappedClassifiers.remove(classToRemove);
        comparison.notMappedInstructorClassifiers.add(classToRemove);
        comparison.extraStudentClassifiers.add(possibleClassifierMatch);
      }

      mapClasses(comparison, possibleClassifierMatch, instructorClassifier);
      checkMistakesInClassifier(possibleClassifierMatch, instructorClassifier, newMistakes);

      List<Attribute> studentAttributes = possibleClassifierMatch.getAttributes();
      for (Attribute instructorAttribute : instructorAttributes) {
        for (Attribute studentAttribute : studentAttributes) {
          float lDistance = levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
          if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
            mapAttributes(comparison, studentAttribute, instructorAttribute);
            checkMistakesInAttributes(studentAttribute, instructorAttribute, comparison.newMistakes);
            break;
          }
        }
      }
    }

    mapClassAndAttribBasedOnAttribsAssocAndAssocEnds(comparison);
    checkMistakesClassNameSpellings(comparison);
    mapRelations(comparison);
    mapEnumerations(instructorSolution, studentSolution, comparison);
    mapPatterns(instructorSolution, studentSolution, comparison);
    populateGeneralizationTree(comparison, instructorClassifiers, studentClassifiers);
    mapAttributesBasedOnClassifierMap(comparison);
    checkMistakeMissingClassAndEnumInsteadOfClass(comparison);
    checkMistakeExtraClassAndClassShouldBeEnum(comparison);
    checkMistakeMissingExtraEnum(comparison);
    checkMistakesInGeneralization(comparison);
    checkMistakeAttributeMisplaced(comparison);
    checkMistakeExtraAttribute(comparison);
    checkMistakeMissingAttribute(comparison);
    checkMistakeIncompleteContainmentTree(comparison, studentSolution.getClassDiagram());
    checkMistakeMissingAssociationCompositionAggregation(comparison);
    checkMistakeExtraAssociationCompositionAggregation(comparison);

    updateMistakes(instructorSolution, studentSolution, comparison, filter);
    return comparison;
  }

  private static void checkMistakesMissingExtraGenWrongSuperclassWrongDirection(Comparison comparison) {
    for (Classifier instClass : comparison.instructorGeneralizationClassifiers) {
      Classifier instSuperClass = instClass.getSuperTypes().get(0);
      Classifier studClass = comparison.mappedClassifiers.get(instClass);

      if (!comparison.mappedClassifiers.containsKey(instClass)) {
        comparison.newMistakes.add(createMistake(MISSING_GENERALIZATION, null, List.of(instClass, instSuperClass)));
        comparison.studentGeneralizationClassifiers.remove(studClass);
        continue;
      }

      Classifier studMappedSuperClass = comparison.mappedClassifiers.get(instSuperClass);

      var studClassSuperClasses = getAllSuperClasses(studClass);
      if (studMappedSuperClass == null && !studClass.getSuperTypes().isEmpty()) {
        comparison.newMistakes.add(createMistake(WRONG_SUPERCLASS, List.of(studClass, studClass.getSuperTypes().get(0)),
            List.of(instClass, instSuperClass)));
        comparison.studentGeneralizationClassifiers.remove(studClass);
        continue;
      } else if (studMappedSuperClass == null) {
        comparison.newMistakes.add(createMistake(MISSING_GENERALIZATION, null, List.of(instClass, instSuperClass)));
        comparison.studentGeneralizationClassifiers.remove(studClass);
        continue;
      }

      if (studClassSuperClasses.contains(studMappedSuperClass)) {
        comparison.studentGeneralizationClassifiers.remove(studClass);
        continue;
      }

      studClassSuperClasses = getAllSuperClasses(studMappedSuperClass);
      if (studClassSuperClasses.contains(studClass)) {
        comparison.newMistakes.add(createMistake(WRONG_GENERALIZATION_DIRECTION,
            List.of(studClass, studMappedSuperClass), List.of(instClass, instSuperClass)));
        comparison.studentGeneralizationClassifiers.remove(studClass);
      } else {
        if (studClass.getSuperTypes().isEmpty()) {
          comparison.newMistakes.add(createMistake(MISSING_GENERALIZATION, List.of(studClass, studMappedSuperClass), List.of(instClass, instSuperClass)));
          comparison.studentGeneralizationClassifiers.remove(studClass);
        } else {
          comparison.newMistakes.add(createMistake(WRONG_SUPERCLASS,
              List.of(studClass, studClass.getSuperTypes().get(0)), List.of(instClass, instSuperClass)));
          comparison.studentGeneralizationClassifiers.remove(studClass);
        }
      }
    }
    comparison.studentGeneralizationClassifiers.forEach(studClass -> {
      if (comparison.mappedClassifiers.containsValue(studClass)
          && comparison.mappedClassifiers.containsValue(studClass.getSuperTypes().get(0))) {

        comparison.newMistakes
            .add(createMistake(EXTRA_GENERALIZATION, List.of(studClass, studClass.getSuperTypes().get(0)),
                List.of(getKey(comparison.mappedClassifiers, studClass),
                    getKey(comparison.mappedClassifiers, studClass.getSuperTypes().get(0)))));
      } else {
        comparison.newMistakes
            .add(createMistake(EXTRA_GENERALIZATION, List.of(studClass, studClass.getSuperTypes().get(0)), null));
      }
    });
  }

  private static void checkMistakesClassNameSpellings(Comparison comparison) {
    comparison.mappedClassifiers.forEach((key, value) -> {
      checkMistakeClassSpelling(value, key).ifPresent(comparison.newMistakes::add);
    });
  }

  private static void checkMistakeAttributeMisplaced(Comparison comparison) {
    List<Attribute> studAttributesProcessed = new ArrayList<>();
    List<Attribute> instAttributesProcessed = new ArrayList<>();

    for (Attribute studAttrib : comparison.extraStudentAttributes) {
      for (Attribute instAttrib : comparison.notMappedInstructorAttributes) {
        if (studAttrib.getName().equals(instAttrib.getName())) {
          comparison.newMistakes.add(createMistake(ATTRIBUTE_MISPLACED, studAttrib, instAttrib));
          comparison.mappedAttributes.put(instAttrib, studAttrib);
          checkMistakesInAttributes(studAttrib, instAttrib, comparison.newMistakes);
          studAttributesProcessed.add(studAttrib);
          instAttributesProcessed.add(instAttrib);
        }
      }
    }
    comparison.extraStudentAttributes.removeAll(studAttributesProcessed);
    comparison.notMappedInstructorAttributes.removeAll(instAttributesProcessed);
  }

  private static void checkMistakesInGeneralization(Comparison comparison) {
    checkMistakeNonDifferentiatedSubClass(comparison);
    checkMistakeAttribMisplacedInGenHierarchyAndDuplicateAttrib(comparison);
    checkMistakesMissingExtraGenWrongSuperclassWrongDirection(comparison);
  }

  private static void checkMistakeAttribMisplacedInGenHierarchyAndDuplicateAttrib(Comparison comparison) {
    Set<Classifier> studentGeneralizationClasses = new HashSet<>(comparison.studentSuperclassesToSubclasses.keySet());
    for (var classifiers : comparison.studentSuperclassesToSubclasses.values()) {
      studentGeneralizationClasses.addAll(classifiers);
    }

    for (var classifier : studentGeneralizationClasses) {
      for (var attribute : classifier.getAttributes()) {
        if (isSuperClassAttribMatch(attribute, classifier)
            && !isMistakeExist(ATTRIBUTE_DUPLICATED, attribute, comparison)) {
          comparison.newMistakes.add(createMistake(ATTRIBUTE_DUPLICATED, attribute, null));
        }
      }
    }

    for (var classifier : studentGeneralizationClasses) {
      List<Attribute> attribsToRemove = new ArrayList<Attribute>();
      for (var attribute : comparison.notMappedInstructorAttributes) {
        var attrib = matchedSuperClassAttribMatch(attribute, classifier);
        if (attrib != null && !isMistakeExist(ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY, attrib, comparison)
            && !comparison.mappedAttributes.containsValue(attrib)) {
          comparison.newMistakes.add(createMistake(ATTRIBUTE_MISPLACED_IN_GENERALIZATION_HIERARCHY, attrib, attribute));
          attribsToRemove.add(attribute);
          comparison.extraStudentAttributes.remove(attrib);
        }
      }
      comparison.notMappedInstructorAttributes.removeAll(attribsToRemove);
    }
  }

  private static boolean isSuperClassAttribMatch(Attribute attribute, Classifier classifier) {
    var superclasses = getAllSuperClasses(classifier);
    for (var sc : superclasses) {
      var attributes = sc.getAttributes();
      if (attributes.stream().anyMatch(a -> a.getName().equals(attribute.getName()))) {
        return true;
      }
    }
    return false;
  }

  /** Returns an attribute if found in any superclass else returns null. */
  private static Attribute matchedSuperClassAttribMatch(Attribute attribute, Classifier classifier) {
    var superclasses = getAllSuperClasses(classifier);
    superclasses.add(classifier);
    for (var sc : superclasses) {
      for (var attrib : sc.getAttributes()) {
        if (attrib.getName().toLowerCase().equals(attribute.getName().toLowerCase())) {
          return attrib;
        }
      }
    }
    return null;
  }

  private static List<Classifier> getAllSuperClasses(Classifier classifier) {
    List<Classifier> superclasses = new ArrayList<Classifier>();
    while (!classifier.getSuperTypes().isEmpty()) {
      classifier = classifier.getSuperTypes().get(0);
      superclasses.add(classifier);
    }
    return superclasses;
  }

  private static void checkMistakeNonDifferentiatedSubClass(Comparison comparison) {
    Set<String> classesIterated = new HashSet<String>();
    for (var set : comparison.studentSuperclassesToSubclasses.entrySet()) {
      Classifier superClass = set.getKey();
      List<Classifier> subClasses = set.getValue();
      List<Attribute> superClassAttributes = superClass.getAttributes();
      for (Classifier subClass : subClasses) {
        List<Attribute> subClassAttributes = subClass.getAttributes();
        if (areAttributesEqual(superClassAttributes, subClassAttributes)
             && !superClass.isAbstract()) {
          if (!classesIterated.contains(subClass.getName())) {
            classesIterated.add(subClass.getName());
            comparison.newMistakes.add(createMistake(NON_DIFFERENTIATED_SUBCLASS, subClass, null));
          }
        }
      }
      for (var subClass1 : subClasses) {
        List<Attribute> subClass1Attributes = subClass1.getAttributes();
        for (var subClass2 : subClasses) {
          List<Attribute> subClass2Attributes = subClass2.getAttributes();
          if (subClass1 != subClass2 && areAttributesEqual(subClass1Attributes, subClass2Attributes)
              && subClassesAttriAssocEqual(subClass1, subClass2, comparison)) {
            if (!classesIterated.contains(subClass1.getName())) {
              classesIterated.add(subClass1.getName());
              comparison.newMistakes.add(createMistake(NON_DIFFERENTIATED_SUBCLASS, subClass1, null));
            }
          }
        }
      }
    }
  }

  private static boolean subClassesAttriAssocEqual(Classifier subClass1, Classifier subClass2, Comparison comparison) {

    List<AssociationEnd> subClass1AssocEnds = subClass1.getAssociationEnds();
    List<AssociationEnd> subClass2AssocEnds = subClass2.getAssociationEnds();

    if (subClass1AssocEnds.size() != subClass2AssocEnds.size()) {
      return false;
    } else if (subClass1AssocEnds.isEmpty() && subClass2AssocEnds.isEmpty()) {
      return true;
    }
    List<Classifier> subClass1ConnectedClass = new ArrayList<>();
    List<Classifier> subClass2ConnectedClass = new ArrayList<>();

    for (AssociationEnd assocEnd : subClass1AssocEnds) {
      var ends = assocEnd.getAssoc().getEnds();
      var end = ends.get(0);
      if (end.equals(assocEnd)) {
        end = ends.get(1);
      }
      subClass1ConnectedClass.add(end.getClassifier());
    }

    for (AssociationEnd assocEnd : subClass2AssocEnds) {
      var ends = assocEnd.getAssoc().getEnds();
      var end = ends.get(0);
      if (end.equals(assocEnd)) {
        end = ends.get(1);
      }
      subClass2ConnectedClass.add(end.getClassifier());
    }

    for (Classifier cls : subClass1ConnectedClass) {
      if (!subClass2ConnectedClass.contains(cls)) {
        return false;
      }
    }

    for (Classifier cls1 : subClass1ConnectedClass) {
      for (Classifier cls2 : subClass2ConnectedClass) {
        // To check associations between subClass1 -- connectedClass and subClass2 -- connectedClass.
        if (!cls1.equals(cls2)) {
          continue;
        }
        var subCls1AssocEnds = subClass1.getAssociationEnds();
        var subCls2AssocEnds = subClass2.getAssociationEnds();
        for (AssociationEnd subCls2AssocEnd : subCls2AssocEnds) {
          if (subCls1AssocEnds.stream()
              .noneMatch(ae -> ae.getName().equals(subCls2AssocEnd.getName())
                            || ae.getLowerBound() == subCls2AssocEnd.getLowerBound()
                            || ae.getUpperBound() == subCls2AssocEnd.getUpperBound())) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private static boolean areAttributesEqual(List<Attribute> superClassAttributes, List<Attribute> subClassAttributes) {
    if ((subClassAttributes.isEmpty() && !superClassAttributes.isEmpty())
        || (!subClassAttributes.isEmpty() && superClassAttributes.isEmpty())) {
      return false;
    }
    for (Attribute attrib : superClassAttributes) {
      if (!subClassAttributes.contains(attrib)) {
        return false;
      }
    }
    return true;
  }

  private static void populateGeneralizationTree(Comparison comparison, List<Classifier> instructorClassifiers,
      List<Classifier> studentClassifiers) {

    for (Classifier instrucotrClassifier : instructorClassifiers) {
      Classifier superClass = instrucotrClassifier;
      List<Classifier> subClasses = new ArrayList<>();
      for (Classifier instrucotrClassifier2 : instructorClassifiers) {
        if (instrucotrClassifier2.getSuperTypes().contains(superClass)) {
          subClasses.add(instrucotrClassifier2);
        }
      }
      if (!subClasses.isEmpty()) {
        comparison.instructorSuperclassesToSubclasses.put(superClass, subClasses);
      }
    }

    for (Classifier studentClassifier : studentClassifiers) {
      Classifier superClass = studentClassifier;
      List<Classifier> subClasses = new ArrayList<>();
      for (Classifier studentClassifier2 : studentClassifiers) {
        if (studentClassifier2.getSuperTypes().contains(superClass)) {
          subClasses.add(studentClassifier2);
        }
      }
      if (!subClasses.isEmpty()) {
        comparison.studentSuperclassesToSubclasses.put(superClass, subClasses);
      }
    }
  }

  private static void checkMistakeIncompleteContainmentTree(Comparison comparison, ClassDiagram classDiagram) {

    var studentClassifiers = classDiagram.getClasses();
    if (studentClassifiers.size() < 2) {
      return;
    }
    Map<Classifier, Integer> classCompositionCount = new HashMap<Classifier, Integer>();
    List<NamedElement> notComposedClasses = new ArrayList<>();
    for (Classifier studClass : studentClassifiers) {
      classCompositionCount.put(studClass, 0);
      notComposedClasses.add(studClass);
      for (AssociationEnd assocEnd : studClass.getAssociationEnds()) {
        if (assocEnd.getReferenceType().equals(COMPOSITION)) {
          classCompositionCount.put(studClass, classCompositionCount.get(studClass) + 1);
        }
      }
    }
    Classifier ClassWithMostCompositions = null;
    int maxValue = 0;
    for (Classifier i : classCompositionCount.keySet()) {
      if (classCompositionCount.get(i) > maxValue) {
        ClassWithMostCompositions = i;
        maxValue = classCompositionCount.get(i);
      }
    }
    if (ClassWithMostCompositions == null) {
      comparison.newMistakes.add(createMistake(INCOMPLETE_CONTAINMENT_TREE, notComposedClasses, null));
      return;
    }
    Classifier rootClass = ClassWithMostCompositions;
    List<Classifier> composedClasses = new ArrayList<Classifier>();
    composedClasses.add(rootClass);
    for (AssociationEnd assocEnd : rootClass.getAssociationEnds()) {
      if (assocEnd.getReferenceType().equals(COMPOSITION)) {
        composedClasses.add(getOtherAssocEnd(assocEnd).getClassifier());
      }
    }
    for (Classifier studClass : studentClassifiers) {
      if (composedClasses.contains(studClass)) {
        continue;
      }
      for (AssociationEnd assocEnd : studClass.getAssociationEnds()) {
        List<Association> associations =
            getAssocAggCompFromClassDiagram(studClass, getOtherAssocEnd(assocEnd).getClassifier(), classDiagram);
        if (includesComposition(associations) && composedClasses.contains(getOtherAssocEnd(assocEnd).getClassifier())) {
          composedClasses.add(studClass);
        }
      }
    }
    if (!composedClasses.containsAll(studentClassifiers)) {
      composedClasses.forEach(notComposedClasses::remove);
      List<NamedElement> notComposedClassesToRemove = new ArrayList<>();
      for (NamedElement cls : notComposedClasses) {
        Classifier studClass = (Classifier) cls;
        if (!studClass.getSuperTypes().isEmpty()) {
          for (Classifier c : getAllSuperClasses(studClass)) {
            if (composedClasses.contains(c)) {
              notComposedClassesToRemove.add(cls);
            }
          }
        }
      }
      notComposedClasses.removeAll(notComposedClassesToRemove);
      for (Association assoc : classDiagram.getAssociations()) {
        if (assoc.getAssociationClass() != null && notComposedClasses.contains(assoc.getAssociationClass())) {
          notComposedClasses.remove(assoc.getAssociationClass());
        }
      }
      if (!notComposedClasses.isEmpty()) {
        comparison.newMistakes.add(createMistake(INCOMPLETE_CONTAINMENT_TREE, notComposedClasses, null));
      }
    }
    checkMistakeContainedInMoreThanOneParent(rootClass, comparison, classDiagram);
  }

  private static void checkMistakeContainedInMoreThanOneParent(Classifier rootClass, Comparison comparison,
      ClassDiagram classDiagram) {
    List<Classifier> composedClasses = new ArrayList<Classifier>();
    composedClasses.add(rootClass);
    for (Association assoc : classDiagram.getAssociations()) {
      for (AssociationEnd assocEnd : assoc.getEnds()) {
        if (assocEnd.getReferenceType().equals(COMPOSITION)) {
          composedClasses.add(getOtherAssocEnd(assocEnd).getClassifier());
        }
      }
    }
    Set<NamedElement> multiComposedClasses = new HashSet<>();
    multiComposedClasses.addAll(findDuplicateInList(composedClasses));
    List<NamedElement> studClasses = new ArrayList<>();
    studClasses.addAll(multiComposedClasses);
    if (!multiComposedClasses.isEmpty()) {
      comparison.newMistakes.add(createMistake(COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT, studClasses, null));
    }
  }

  /** Return the set of duplicate elements. */
  public static List<Classifier> findDuplicateInList(List<Classifier> list) {
    return list.stream().filter(i -> Collections.frequency(list, i) > 1).collect(Collectors.toList());
  }

  private static boolean includesComposition(List<Association> associations) {
    for (Association assoc : associations) {
      for (AssociationEnd assocEnd : assoc.getEnds()) {
        if (assocEnd.getReferenceType().equals(COMPOSITION)) {
          return true;
        }
      }
    }
    return false;
  }

  /** Returns null if key not found in mapping. */
  public static Classifier getKey(Map<Classifier, Classifier> map, Classifier value) {
    for (Entry<Classifier, Classifier> entry : map.entrySet()) {
      if (entry.getValue().equals(value)) {
        return entry.getKey();
      }
    }
    return null;
  }

  private static void mapEnumerations(Solution instructorSolution, Solution studentSolution, Comparison comparison) {
    var instructorClassDiagram = instructorSolution.getClassDiagram();
    var studentClassDiagram = studentSolution.getClassDiagram();

    for (Type studElementType : studentClassDiagram.getTypes()) {
      if (studElementType instanceof CDEnum) {
        CDEnum studEnumClass = (CDEnum) studElementType;
        comparison.extraStudentEnums.add(studEnumClass);
        comparison.extraStudentEnumLiterals.addAll(studEnumClass.getLiterals());
      }
    }
    for (Type instElementType : instructorClassDiagram.getTypes()) {
      if (instElementType instanceof CDEnum) {
        CDEnum instEnumClass = (CDEnum) instElementType;
        comparison.notMappedInstructorEnums.add(instEnumClass);
        comparison.notMappedInstructorEnumLiterals.addAll(instEnumClass.getLiterals());
        for (Type studElementType : studentClassDiagram.getTypes()) {
          if (studElementType instanceof CDEnum) {
            CDEnum studEnumClass = (CDEnum) studElementType;
            if (studEnumClass.getName().equals(instEnumClass.getName())) {
              addEnumsToMap(instEnumClass, studEnumClass, comparison);
              mapEnumLiterals(instEnumClass, studEnumClass, comparison);
            }
          }
        }
      }
    }


    comparison.mappedAttributes.forEach((key, value) -> {
      if (!(key.getType() instanceof CDEnum && value.getType() instanceof CDEnum)) {
        return;
      }
      CDEnum instEnum = getEnumFromClassDiagram(key.getType().getName(), instructorClassDiagram);
      CDEnum studEnum = getEnumFromClassDiagram(value.getType().getName(), studentClassDiagram);
      if (instEnum == null && studEnum == null) {
        return;
      }
      if (!comparison.mappedEnumerations.containsKey(instEnum)) {
        addEnumsToMap(instEnum, studEnum, comparison);
        mapEnumLiterals(instEnum, studEnum, comparison);
      }
    });
  }


  private static void mapEnumLiterals(CDEnum instEnum, CDEnum studEnum, Comparison comparison) {
    for (CDEnumLiteral instEnumLiteral : instEnum.getLiterals()) {
      for (CDEnumLiteral studEnumLiteral : studEnum.getLiterals()) {
        var lDistance = levenshteinDistance(instEnumLiteral.getName(), studEnumLiteral.getName());
        if (lDistance < MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
          comparison.mappedEnumerationItems.put(instEnumLiteral, studEnumLiteral);
          comparison.notMappedInstructorEnumLiterals.remove(instEnumLiteral);
          comparison.extraStudentEnumLiterals.remove(studEnumLiteral);
          checkMistakeBadEnumLiteralSpelling(studEnumLiteral, instEnumLiteral).ifPresent(comparison.newMistakes::add);
        }
      }
    }
  }

  private static void addEnumsToMap(CDEnum instEnum, CDEnum studEnum, Comparison comparison) {
    comparison.mappedEnumerations.put(instEnum, studEnum);
    comparison.notMappedInstructorEnums.remove(instEnum);
    comparison.extraStudentEnums.remove(studEnum);
    checkMistakeBadEnumNameSpelling(studEnum, instEnum).ifPresent(comparison.newMistakes::add);
  }
  private static void checkMistakesInAttributes(Attribute studentAttribute, Attribute instructorAttribute,
      List<Mistake> newMistakes) {
    checkMistakeWrongAttributeTypeAndListAttrib(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
    checkMistakeAttributeExpectedStatic(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
    checkMistakeAttributeNotExpectedStatic(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
    if (studentAttribute.getName() != instructorAttribute.getName()) {
      checkMistakeAttributeSpelling(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
      checkMistakePluralAttribName(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
      checkMistakeUppercaseAttribName(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
    }
  }

  private static void checkMistakesInClassifier(Classifier studentClassifier, Classifier instructorClassifier,
      List<Mistake> newMistakes) {
    checkMistakeSoftwareEngineeringTerm(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
    checkMistakePluralClassName(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
    checkMistakeLowerClassName(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
    checkMistakeIncorrectClassNameButCorrectAttribRel(studentClassifier, instructorClassifier)
        .ifPresent(newMistakes::add);
    checkMistakeAbstractClass(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
  }

  private static Optional<Mistake> checkMistakeAbstractClass(Classifier studentClassifier,
      Classifier instructorClassifier) {
    if (!studentClassifier.isAbstract() && instructorClassifier.isAbstract()) {
      return Optional.of(createMistake(CLASS_SHOULD_BE_ABSTRACT, studentClassifier, instructorClassifier));
    } else if (studentClassifier.isAbstract() && !instructorClassifier.isAbstract()) {
      return Optional.of(createMistake(CLASS_SHOULD_NOT_BE_ABSTRACT, studentClassifier, instructorClassifier));
    }
    return Optional.empty();
  }

  /**
   * Function maps patterns if exist in instructor solution
   *
   * @param instructorSolution
   * @param studentSolution
   * @param comparison
   */
  private static void mapPatterns(Solution instructorSolution, Solution studentSolution, Comparison comparison) {
    if (instructorSolution.getTagGroups().isEmpty()) {
      return;
    }
    String instPattern;
    for (TagGroup tg : instructorSolution.getTagGroups()) {
      for (Tag tag : tg.getTags()) {
        if (tag.getTagType().equals(PLAYER)) {
          instPattern = checkPRPattern(tg);
          if (instPattern.equals(FULL_PR_PATTERN)) {
            checkStudentFullPattern(tg, comparison, instPattern, studentSolution);
          } else if (instPattern.equals(SUB_CLASS_PR_PATTERN)) {
            checkStudentSubclassPattern(tg, comparison, instPattern, studentSolution);
          } else if (instPattern.equals(ASSOC_PR_PATTERN)) {
            checkStudentAssocPattern(tg, comparison, instPattern, studentSolution);
          } else if (instPattern.equals(ENUM_PR_PATTERN)) {
            checkStudentEnumPattern(tg, comparison, instPattern, studentSolution);
          }
          break;
        }
        if (tag.getTagType().equals(ABSTRACTION)) {
          checkStudentAOPattern(tg, comparison, studentSolution);
          break;
        }
      }
    }
  }

  private static void checkStudentAOPattern(TagGroup tg, Comparison comparison, Solution studentSolution) {
    List<NamedElement> totalMatchesExpected = new ArrayList<>();
    int matchedElements = 0;
    for (Tag tag : tg.getTags()) {
      if (comparison.mappedClassifiers.containsKey(tag.getSolutionElement().getElement())) {
        if (tag.getTagType().equals(ABSTRACTION)
            && comparison.mappedClassifiers.get(tag.getSolutionElement().getElement()).isAbstract()
            || tag.getTagType().equals(OCCURRENCE)) {
          matchedElements++;
        }
      }
      totalMatchesExpected.add(tag.getSolutionElement().getElement());
    }
    if (matchedElements == 0 && !totalMatchesExpected.isEmpty()) {
      comparison.newMistakes.add(createMistake(MISSING_AO_PATTERN, null, totalMatchesExpected));
    } else if (matchedElements != 0 && totalMatchesExpected.size() == matchedElements) {
      checkMistakeGenInsteadOfAssocInAOPattern(tg, comparison);
    } else if (matchedElements != 0 && totalMatchesExpected.size() != matchedElements) {
      createMistakeIncompleteAOPattern(tg, comparison);
    }
  }

  private static void checkMistakeGenInsteadOfAssocInAOPattern(TagGroup tg, Comparison comparison) {
    Classifier instAbsClass = null;
    Classifier instOccClass = null;
    for (Tag tag : tg.getTags()) {
      if (tag.getTagType().equals(ABSTRACTION)) {
        instAbsClass = (Classifier) tag.getSolutionElement().getElement();
      } else if (tag.getTagType().equals(OCCURRENCE)) {
        instOccClass = (Classifier) tag.getSolutionElement().getElement();
      }
    }
    Classifier studAbsClass = comparison.mappedClassifiers.get(instAbsClass);
    Classifier studOccClass = comparison.mappedClassifiers.get(instOccClass);

    if (!studOccClass.getSuperTypes().isEmpty() && studOccClass.getSuperTypes().get(0).equals(studAbsClass)) {
   // studOccClass -> subclass and studAbsClass -> superclass
      comparison.newMistakes.add(createMistake(GENERALIZATION_SHOULD_BE_ASSOC_AO_PATTERN,
          List.of(studOccClass, studAbsClass), List.of(instAbsClass, instOccClass)));
    } else if (!studAbsClass.getSuperTypes().isEmpty() && studAbsClass.getSuperTypes().get(0).equals(studOccClass)) {
   // studAbsClass -> subclass and studOccClass -> superclass
      comparison.newMistakes.add(createMistake(GENERALIZATION_SHOULD_BE_ASSOC_AO_PATTERN,
          List.of(studAbsClass, studOccClass), List.of(instAbsClass, instOccClass)));
    }

  }

  private static void checkStudentEnumPattern(TagGroup tg, Comparison comparison, String instPattern,
      Solution studentSolution) {
    int totalMatchesExpected = 1;
    int totalMatched = 0;
    LinkedList<NamedElement> studentMatchedElements = new LinkedList<>();
    Classifier studentPlayerClass = null;
    for (Tag tag : tg.getTags()) {
      if (tag.getTagType().equals(PLAYER)
          && comparison.mappedClassifiers.containsKey(tag.getSolutionElement().getElement())) {
        studentPlayerClass = comparison.mappedClassifiers.get(tag.getSolutionElement().getElement());
        totalMatched += 1;
        studentMatchedElements.addFirst(studentPlayerClass);
      } else if (tag.getTagType().equals(ROLE)
          && comparison.mappedAttributes.containsKey(tag.getSolutionElement().getElement())) {
        Attribute attrib = (Attribute) tag.getSolutionElement().getElement();
        studentMatchedElements.add(comparison.mappedAttributes.get(attrib));
        CDEnum enumClass =
            getEnumFromClassDiagram(attrib.getType().getName(), tag.getTagGroup().getSolution().getClassDiagram());
        totalMatchesExpected = totalMatchesExpected + enumClass.getLiterals().size();
        for (CDEnumLiteral enumClassLiteral : enumClass.getLiterals()) {
          if (comparison.mappedEnumerationItems.containsKey(enumClassLiteral)) {
            totalMatched += 1;
          }
        }
      }
    }
    if (totalMatched == totalMatchesExpected && totalMatched != 1) {
      return;
    }
    if (totalMatched != totalMatchesExpected && totalMatched != 1) {
      createMistakeIncompletePRPattern(studentMatchedElements, tg, comparison);
      return;
    } else if (MIN_PR_MATCH_REQIUIRED < totalMatched && studentPlayerClass != null) {
      createMistakeIncompletePRPattern(studentMatchedElements, tg, comparison);
      return;
    }
    if (studentPlayerClass != null) {
      checkOtherPattern(tg, comparison, instPattern, studentSolution);
    }
  }

  private static void checkStudentAssocPattern(TagGroup tg, Comparison comparison, String instPattern,
      Solution studentSolution) {
    int totalMatcheExpected = tg.getTags().size();
    int totalMatched = 0;
    List<String> studentRoleAssocEnd = new ArrayList<>();
    LinkedList<NamedElement> studentMatchedElements = new LinkedList<>();
    Classifier studentPlayerClass = null;
    for (Tag tag : tg.getTags()) {
      if (tag.getTagType().equals(PLAYER)
          && comparison.mappedClassifiers.containsKey(tag.getSolutionElement().getElement())) {
        studentPlayerClass = comparison.mappedClassifiers.get(tag.getSolutionElement().getElement());
        totalMatched += 1;
        studentMatchedElements.addFirst(studentPlayerClass);
      } else {
        if (tag.getSolutionElement().getElement() instanceof AssociationEnd) {
          AssociationEnd assocEnd = (AssociationEnd) tag.getSolutionElement().getElement();
          if (comparison.mappedAssociations.containsKey(assocEnd.getAssoc())) {
            studentRoleAssocEnd.add(assocEnd.getName());
            totalMatched += 1;
            studentMatchedElements.add(assocEnd);
          }
        }
      }
    }
    if (totalMatched == totalMatcheExpected) {
      if (!assocPatternCorrect(studentPlayerClass, studentRoleAssocEnd)) {
        createMistakeIncompletePRPattern(studentMatchedElements, tg, comparison);
        return;
      } else {
        return;
      }
    } else if (MIN_PR_MATCH_REQIUIRED < totalMatched && studentPlayerClass != null) {
      createMistakeIncompletePRPattern(studentMatchedElements, tg, comparison);
      return;
    }
    if (studentPlayerClass != null) {
      checkOtherPattern(tg, comparison, instPattern, studentSolution);
    }
  }

  /** Checks if associations are linked to player class. */
  private static boolean assocPatternCorrect(Classifier studentPlayerClass, List<String> studentRoleAssocEnd) {
    int count = 0;
    for (AssociationEnd assocEnd : studentPlayerClass.getAssociationEnds()) {
      AssociationEnd otherAssocEnd = getOtherAssocEnd(assocEnd);
      if (studentRoleAssocEnd.contains(otherAssocEnd.getName())) {
        count += 1;
      }
    }
    return count == studentRoleAssocEnd.size();
  }

  private static void checkStudentFullPattern(TagGroup tg, Comparison comparison, String instPattern,
      Solution studentSolution) {
    int totalMatcheExpected = tg.getTags().size();
    int totalMatched = 0;
    boolean isStudentClassAbstract = false;
    List<Classifier> studentRoleClasses = new ArrayList<>();
    LinkedList<NamedElement> studentMatchedElements = new LinkedList<>();
    List<NamedElement> instElements = new ArrayList<>();
    Classifier studentPlayerClass = null;
    Classifier studentAbstractClass = null;
    List<String> mappedClassifierNames = new ArrayList<>();
    mappedClassifierNames = getMappedNames(comparison.mappedClassifiers);
    for (Tag tag : tg.getTags()) {
      instElements.add(tag.getSolutionElement().getElement());
      if (comparison.mappedClassifiers.containsKey(tag.getSolutionElement().getElement())) {
        if (tag.getTagType().equals(PLAYER)) {
          studentPlayerClass = comparison.mappedClassifiers.get(tag.getSolutionElement().getElement());
          studentMatchedElements.addFirst(studentPlayerClass);
        } else {
          studentRoleClasses.add(comparison.mappedClassifiers.get(tag.getSolutionElement().getElement()));
          studentMatchedElements.add(comparison.mappedClassifiers.get(tag.getSolutionElement().getElement()));
        }
        if (mappedClassifierNames.contains(tag.getSolutionElement().getElement().getName())) {
          totalMatched += 1;
        }
      }
    }
    if (studentRoleClasses.isEmpty() && studentPlayerClass != null) {
      checkOtherPattern(tg, comparison, instPattern, studentSolution);
      return;
    }
    if (studentRoleClasses.get(0).getSuperTypes().isEmpty() && studentPlayerClass != null) {
      checkOtherPattern(tg, comparison, instPattern, studentSolution);
      return;
    }
    studentAbstractClass = studentRoleClasses.get(0).getSuperTypes().get(0);
    isStudentClassAbstract = studentAbstractClass.isAbstract();

    if (totalMatched == totalMatcheExpected) {
      if (studentAbstractClass == studentPlayerClass && studentPlayerClass != null) {
        checkMistakeUsingSubclassPattern(instPattern, studentMatchedElements, instElements, comparison);
        return;
      }
      if (!studentAbstractClass.isAbstract()) {
        createMistakeIncompletePRPattern(studentMatchedElements, tg, comparison);
        return;
      }
      if (!subClassPatternCorrect(studentAbstractClass, studentRoleClasses)) {
        createMistakeIncompletePRPattern(studentMatchedElements, tg, comparison);
        return;
      } else {
        if (!assocExists(studentPlayerClass, studentAbstractClass)) {
          createMistakeIncompletePRPattern(studentMatchedElements, tg, comparison);
        } else {
          return;
        }
      }
    } else if (MIN_PR_MATCH_REQIUIRED <= totalMatched && studentPlayerClass != null && isStudentClassAbstract) {
      createMistakeIncompletePRPattern(studentMatchedElements, tg, comparison);
      return;
    }
    if (studentPlayerClass != null) {
      checkOtherPattern(tg, comparison, instPattern, studentSolution);
    }
  }

  private static void checkStudentSubclassPattern(TagGroup tg, Comparison comparison, String instPattern,
      Solution studentSolution) {
    int totalMatcheExpected = tg.getTags().size();
    int totalMatched = 0;
    boolean studentClassAbstract = false;
    List<Classifier> studentRoleClasses = new ArrayList<>();
    LinkedList<NamedElement> studentMatchedElements = new LinkedList<>();
    List<NamedElement> instElements = new ArrayList<>();
    Classifier studentPlayerClass = null;
    List<String> mappedClassifierNames = new ArrayList<>();
    mappedClassifierNames = getMappedNames(comparison.mappedClassifiers);
    for (Tag tag : tg.getTags()) {
      instElements.add(tag.getSolutionElement().getElement());
      if (comparison.mappedClassifiers.containsKey(tag.getSolutionElement().getElement())) {
        if (tag.getTagType().equals(PLAYER)) {
          studentPlayerClass = comparison.mappedClassifiers.get(tag.getSolutionElement().getElement());
          studentMatchedElements.addFirst(comparison.mappedClassifiers.get(tag.getSolutionElement().getElement()));
        } else {
          studentRoleClasses.add(comparison.mappedClassifiers.get(tag.getSolutionElement().getElement()));
          studentMatchedElements.add(comparison.mappedClassifiers.get(tag.getSolutionElement().getElement()));
        }
        if (mappedClassifierNames.contains(tag.getSolutionElement().getElement().getName())) {
          totalMatched += 1;
        }
      }
    }
    studentClassAbstract = isAnyClassAbstract(studentMatchedElements);
    if (totalMatched == totalMatcheExpected) {
      if (!subClassPatternCorrect(studentPlayerClass, studentRoleClasses)) {
        if (studentRoleClasses.get(0).getSuperTypes().get(0).isAbstract()) {
          if (assocExists(studentRoleClasses.get(0).getSuperTypes().get(0), studentPlayerClass)) {
            checkMistakeUsingFullPattern(instPattern, studentMatchedElements, instElements, comparison);
            return;
          }
        }
        createMistakeIncompletePRPattern(studentMatchedElements, tg, comparison);
        return;
      } else {
        return;
      }
    } else if (MIN_PR_MATCH_REQIUIRED <= totalMatched && studentPlayerClass != null && !studentClassAbstract) {
      createMistakeIncompletePRPattern(studentMatchedElements, tg, comparison);
      return;
    }
    if (studentPlayerClass != null) {
      checkOtherPattern(tg, comparison, instPattern, studentSolution);
    }
  }

  /** Returns true if at least one of the given elements is an abstract classifier. */
  private static boolean isAnyClassAbstract(List<NamedElement> elements) {
    return elements.stream().filter(Classifier.class::isInstance).map(Classifier.class::cast)
        .anyMatch(Classifier::isAbstract);
  }

  private static List<String> getMappedNames(Map<Classifier, Classifier> mappedClassifier) {
    List<String> tempList = new ArrayList<>();
    mappedClassifier.forEach((key, value) -> {
      if (levenshteinDistance(key.getName(), value.getName()) <= 2) {
        tempList.add(key.getName());
      } else {
        tempList.add(value.getName());
      }
    });
    return tempList;
  }

  private static void checkOtherPattern(TagGroup tg, Comparison comparison, String instPattern,
      Solution studentSolution) {
    int studentSubclassesPatternScore = 0;
    int studentEnumsPatternScore = 0;
    int studentFullPatternScore = 0;
    int studentAssocPatternScore = 0;
    Classifier studPlayerClass = null;
    ClassDiagram studentClassDiagram = studentSolution.getClassDiagram();
    List<Classifier> studRoleClass = new ArrayList<>();
    List<String> studRoleAssocEndName = new ArrayList<>();
    List<String> instEnumLiterals = new ArrayList<>();
    List<NamedElement> instElements = new ArrayList<>();
    LinkedList<NamedElement> studEnumElements = new LinkedList<>();
    LinkedList<NamedElement> studAssocElements = new LinkedList<>();
    LinkedList<NamedElement> studFullElements = new LinkedList<>();
    LinkedList<NamedElement> studSubclassElements = new LinkedList<>();
    List<CDEnum> studSolutionEnums = new ArrayList<>();
    List<CDEnumLiteral> studSolutionEnumLiterals = new ArrayList<>();

    for (Type ty : studentClassDiagram.getTypes()) {
      if (ty instanceof CDEnum) {
        studSolutionEnums.add((CDEnum) ty);
        studSolutionEnumLiterals.addAll(((CDEnum) ty).getLiterals());
      }
    }

    instElements = getOrderedInstPatternElements(tg, comparison, PLAYER);
    for (Tag tag : tg.getTags()) {
      if (tag.getTagType().equals(PLAYER)) {
        if (comparison.mappedClassifiers.containsKey(tag.getSolutionElement().getElement())) {
          studPlayerClass = comparison.mappedClassifiers.get(tag.getSolutionElement().getElement());
        }
      }
      if (tag.getTagType().equals(ROLE) && tag.getSolutionElement().getElement() instanceof Attribute) {
        Attribute instAttrib = (Attribute) tag.getSolutionElement().getElement();
        if (instAttrib.getType() instanceof CDEnum) {
          CDEnum instEnum = getEnumFromClassDiagram(instAttrib.getType().getName(),
              tag.getTagGroup().getSolution().getClassDiagram());
          for (CDEnumLiteral enumLitral : instEnum.getLiterals()) {
            instEnumLiterals.add(enumLitral.getName());
          }
        }
      }
      for (Classifier studClass : studentClassDiagram.getClasses()) {
        if (studClass.getName().toLowerCase().equals(tag.getSolutionElement().getElement().getName().toLowerCase())
            && !studSubclassElements.contains(studClass)) {
          if (tag.getTagType().equals(PLAYER)) {
            if (!comparison.mappedClassifiers.containsKey(tag.getSolutionElement().getElement())) {
              studPlayerClass = studClass;
            }
          } else {
            studRoleClass.add(studClass);
          }
          studentSubclassesPatternScore += 1;
          studentFullPatternScore += 1;
          if (tag.getTagType().equals(PLAYER)) {
            studentEnumsPatternScore += 1;
          }
          studSubclassElements.add(studClass);
          studFullElements.add(studClass);
        }
      }
      for (Association studAssoc : studentClassDiagram.getAssociations()) {
        for (AssociationEnd studAssocEnd : studAssoc.getEnds()) {
          var levenshteinDistance = levenshteinDistance(studAssocEnd.getName().toLowerCase(),
              tag.getSolutionElement().getElement().getName().toLowerCase());
          if (levenshteinDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED && !studAssocElements.contains(studAssocEnd)) {
            studentAssocPatternScore += 1;
            studRoleAssocEndName.add(studAssocEnd.getName());
            studAssocElements.add(studAssocEnd);
          }
        }
      }

      for (CDEnum studEnum : studSolutionEnums) {
        var levenshteinDistance = levenshteinDistance(studEnum.getName().toLowerCase(),
            tag.getSolutionElement().getElement().getName().toLowerCase());
        if (levenshteinDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
          studentEnumsPatternScore += 1;
          studEnumElements.add(studEnum);
        }
      }

      for (CDEnumLiteral studEnumLiteral : studSolutionEnumLiterals) {
        var levenshteinDistance = levenshteinDistance(studEnumLiteral.getName().toLowerCase(),
            tag.getSolutionElement().getElement().getName().toLowerCase());
        if (levenshteinDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
          studentEnumsPatternScore += 1;
          studEnumElements.add(studEnumLiteral);
        }
      }
    }
    if (!instEnumLiterals.isEmpty()) {
      for (String enumLiteralName : instEnumLiterals) {
        for (Classifier studClass : studentClassDiagram.getClasses()) {
          var levenshteinDistance =
              levenshteinDistance(studClass.getName().toLowerCase(), enumLiteralName.toLowerCase());
          if (levenshteinDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED && !studSubclassElements.contains(studClass)) {
            studRoleClass.add(studClass);
            studentSubclassesPatternScore += 1;
            studentFullPatternScore += 1;
            studSubclassElements.add(studClass);
            studFullElements.add(studClass);
          }
        }
        for (Association studAssoc : studentClassDiagram.getAssociations()) {
          for (AssociationEnd studAssocEnd : studAssoc.getEnds()) {
            var levenshteinDistance =
                levenshteinDistance(studAssocEnd.getName().toLowerCase(), enumLiteralName.toLowerCase());
            if (levenshteinDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED && !studAssocElements.contains(studAssocEnd)) {
              studentAssocPatternScore += 1;
              studRoleAssocEndName.add(studAssocEnd.getName());
              studAssocElements.add(studAssocEnd);
            }
          }
        }
        for (CDEnum studEnum : studSolutionEnums) {
          var levenshteinDistance =
              levenshteinDistance(studEnum.getName().toLowerCase(), enumLiteralName.toLowerCase());
          if (levenshteinDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
            studentEnumsPatternScore += 1;
            studEnumElements.add(studEnum);
          }
        }
        for (CDEnumLiteral studEnumLiteral : studSolutionEnumLiterals) {
          var levenshteinDistance =
              levenshteinDistance(enumLiteralName.toLowerCase(), studEnumLiteral.getName().toLowerCase());
          if (levenshteinDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
            studentEnumsPatternScore += 1;
            studEnumElements.add(studEnumLiteral);
          }
        }
      }
    }
    if (studentAssocPatternScore == studentEnumsPatternScore) {
      studentEnumsPatternScore += 1;
    }
    var scores = List.of(studentSubclassesPatternScore, studentFullPatternScore, studentEnumsPatternScore,
        studentAssocPatternScore);
    var highestScore = Collections.max(scores);
    if (highestScore == 0) {
      checkMistakeMissingPattern(tg, comparison);
      return;
    }
    if (studPlayerClass != null) {
      studAssocElements.addFirst(studPlayerClass);
      studEnumElements.addFirst(studPlayerClass);
      studFullElements.addFirst(studPlayerClass);
    }
    if (studentSubclassesPatternScore == studentFullPatternScore && studentFullPatternScore == highestScore) {
      if (studPlayerClass != null) {
        if (subClassPatternCorrect(studPlayerClass, studRoleClass)) {
          studentSubclassesPatternScore += 1;
          highestScore += 1;
        }
        if (!studRoleClass.get(0).getSuperTypes().contains(studPlayerClass)
            && subClassPatternCorrect(studRoleClass.get(0).getSuperTypes().get(0), studRoleClass)) {
          studentFullPatternScore += 1;
          highestScore += 1;
        }
      } else {
        checkMistakeMissingPattern(tg, comparison);
        return;
      }
    }
    if (studentSubclassesPatternScore == highestScore) {
      if (studSubclassElements.contains(studPlayerClass)) {
        studSubclassElements.remove(studPlayerClass);
        studSubclassElements.addFirst(studPlayerClass);
      }
      checkMistakeUsingSubclassPattern(instPattern, studSubclassElements, instElements, comparison);
      return;
    } else if (studentAssocPatternScore == highestScore) {
      if (assocPatternCorrect(studPlayerClass, studRoleAssocEndName)) {
        checkMistakeUsingAssocPattern(instPattern, studAssocElements, instElements, comparison);
        return;
      } else {
        checkMistakeMissingPattern(tg, comparison);
        return;
      }
    } else if (studentFullPatternScore == highestScore) {
      checkMistakeUsingFullPattern(instPattern, studFullElements, instElements, comparison);
      return;
    } else if (studentEnumsPatternScore == highestScore) {
      checkMistakeUsingEnumPattern(instPattern, studEnumElements, instElements, comparison);
      return;
    } else {
      checkMistakeMissingPattern(tg, comparison);
      return;
    }
  }

  private static boolean subClassPatternCorrect(Classifier studentPlayerClass, List<Classifier> studentRoleClasses) {
    return studentRoleClasses.stream().allMatch(rc -> rc.getSuperTypes().contains(studentPlayerClass));
  }

  /** Returns the pattern detected in the instructor solution. */
  public static String checkPRPattern(TagGroup tg) {
    SolutionElement playerSolutionElement = null;
    List<SolutionElement> roleSolutionElements = new ArrayList<>();
    for (Tag tag : tg.getTags()) {
      if (tag.getTagType().equals(PLAYER)) {
        playerSolutionElement = tag.getSolutionElement();
      } else if (tag.getTagType().equals(ROLE)) {
        roleSolutionElements.add(tag.getSolutionElement());
      }
    }
    if (subclassPattern(playerSolutionElement, roleSolutionElements)) {
      return SUB_CLASS_PR_PATTERN;
    } else if (fullPattern(playerSolutionElement, roleSolutionElements)) {
      return FULL_PR_PATTERN;
    } else if (assocPattern(playerSolutionElement, roleSolutionElements)) {
      return ASSOC_PR_PATTERN;
    } else if (enumPattern(playerSolutionElement, roleSolutionElements)) {
      return ENUM_PR_PATTERN;
    }
    return NO_PR_PATTERN_DETECTED;
  }

  private static boolean enumPattern(SolutionElement playerSolutionElement,
      List<SolutionElement> roleSolutionElements) {
    if (!(playerSolutionElement.getElement() instanceof Classifier)) {
      return true;
    }
    return roleSolutionElements.stream().allMatch(
        se -> se.getElement() instanceof Attribute && ((Attribute) se.getElement()).getType() instanceof CDEnum);
  }

  private static boolean assocPattern(SolutionElement playerSolutionElement,
      List<SolutionElement> roleSolutionElements) {
    if (!(playerSolutionElement.getElement() instanceof Classifier)) {
      return true;
    }
    return roleSolutionElements.stream().allMatch(se -> se.getElement() instanceof AssociationEnd);
  }

  private static boolean fullPattern(SolutionElement playerSolutionElement,
      List<SolutionElement> roleSolutionElements) {
    if (playerSolutionElement.getElement() instanceof Classifier) {
      if (!(roleSolutionElements.get(0).getElement() instanceof Classifier)) {
        return false;
      }
      Classifier cl = (Classifier) roleSolutionElements.get(0).getElement();
      Classifier superAbstractClass = null;
      for (Classifier c : cl.getSuperTypes()) {
        if (c.isAbstract()) {
          superAbstractClass = c;
        }
      }
      if (superAbstractClass == null) {
        return false;
      }
      if (!assocExists(superAbstractClass, (Classifier) playerSolutionElement.getElement())) {
        return false;
      }
      for (SolutionElement se : roleSolutionElements) {
        Classifier c = (Classifier) se.getElement();
        if (!c.getSuperTypes().contains(superAbstractClass)) {
          return false;
        }
      }
    }
    return true;
  }

  /** Returns true if an association exists between two classes in a solution. */
  private static boolean assocExists(Classifier class1, Classifier class2) {
    return class1.getAssociationEnds().stream().anyMatch(ae -> getOtherAssocEnd(ae).getClassifier().equals(class2));
  }

  public static boolean subclassPattern(SolutionElement playerSolutionElement,
      List<SolutionElement> roleSolutionElements) {
    if (playerSolutionElement.getElement() instanceof Classifier) {
      if (!(roleSolutionElements.get(0).getElement() instanceof Classifier)) {
        return false;
      }
      for (SolutionElement se : roleSolutionElements) {
        Classifier c = (Classifier) se.getElement();
        if (!c.getSuperTypes().contains(playerSolutionElement.getElement())) {
          return false;
        }
      }
    }
    return true;
  }

  /** Maps associations for mapped classes */
  private static void mapRelations(Comparison comparison) {
    comparison.mappedClassifiers.forEach((key, value) -> compareAssocation(key, value, comparison));
    checkAssociationClassMappingWithNonAssociationClass(comparison);
    comparison.assocClassifiersToRemove.forEach(c -> comparison.mappedClassifiers.remove(c));
    comparison.assocClassMappingToAdd.forEach((key, value) -> {
      comparison.mappedClassifiers.put(key, value);
      checkMistakesInClassifier(value, key, comparison.newMistakes);
    });
  }

  /** Maps the associations and check for mistakes */
  private static void compareAssocation(Classifier instructorClassifier, Classifier studentClassifier,
      Comparison comparison) {
    var instructorClassifierAssocEnds = instructorClassifier.getAssociationEnds();
    var studentClassifierAssocEnds = studentClassifier.getAssociationEnds();

    for (AssociationEnd instructorClassifierAssocEnd : instructorClassifierAssocEnds) {
      var instructorClassifierAssoc = instructorClassifierAssocEnd.getAssoc();
      var otherInstructorClassifierAssocEnd = getOtherAssocEnd(instructorClassifierAssocEnd);

      var otherInstructorClassifier = otherInstructorClassifierAssocEnd.getClassifier();
      Map<Association, List<AssociationEnd>> possibleAssocMatch = new HashMap<>();
      for (AssociationEnd studentClassifierAssocEnd : studentClassifierAssocEnds) {
        var studentClassifierAssoc = studentClassifierAssocEnd.getAssoc();
        var otherStudentClassifierAssocEnd = getOtherAssocEnd(studentClassifierAssocEnd);

        var otherStudentClassifier = otherStudentClassifierAssocEnd.getClassifier();
        if (otherStudentClassifier.equals(studentClassifier)) {
          checkMistakeInfiniteRecursiveDependency(studentClassifierAssocEnd, otherStudentClassifierAssocEnd,
              comparison);
        }

        if (comparison.mappedClassifiers.get(otherInstructorClassifier) == null
            || comparison.mappedAssociations.containsKey(instructorClassifierAssoc)
            || comparison.mappedAssociations.containsValue(studentClassifierAssoc)) {
          continue;
        }

        if (comparison.mappedClassifiers.get(otherInstructorClassifier).equals(otherStudentClassifier)) {
          List<AssociationEnd> matchedAssocEnds = new ArrayList<>();
          matchedAssocEnds.addAll(List.of(studentClassifierAssocEnd, instructorClassifierAssocEnd,
              otherStudentClassifierAssocEnd, otherInstructorClassifierAssocEnd));
          possibleAssocMatch.put(studentClassifierAssoc, matchedAssocEnds);
        }
      }
      if (!possibleAssocMatch.isEmpty()) {
        var values = getMatchedAssoc(possibleAssocMatch);
        mapAssociation(comparison, instructorClassifierAssoc, (Association) values.get(0));
        detectMistakeInAssoc(comparison, (Association) values.get(0), instructorClassifierAssoc,
            (AssociationEnd) values.get(1), (AssociationEnd) values.get(2), (AssociationEnd) values.get(3),
            (AssociationEnd) values.get(4));
      }
    }
  }

  public static AssociationEnd getOtherAssocEnd(AssociationEnd assocEnd) {
    var assocEnds = assocEnd.getAssoc().getEnds();
    if (assocEnds.get(0).equals(assocEnd)) {
      return assocEnds.get(1);
    } else {
      return assocEnds.get(0);
    }
  }

  private static void detectMistakeInAssoc(Comparison comparison, Association studentClassifierAssoc,
      Association instructorClassifierAssoc, AssociationEnd studentClassifierAssocEnd,
      AssociationEnd instructorClassifierAssocEnd, AssociationEnd otherStudentClassifierAssocEnd,
      AssociationEnd otherInstructorClassifierAssocEnd) {

    if (studentClassifierAssocEnd.getName().equals(otherInstructorClassifierAssocEnd.getName())) {
      var temp = studentClassifierAssocEnd;
      studentClassifierAssocEnd = otherStudentClassifierAssocEnd;
      otherStudentClassifierAssocEnd = temp;
    } else if(otherStudentClassifierAssocEnd.getName().equals(instructorClassifierAssocEnd.getName())) {
      var temp = otherStudentClassifierAssocEnd;
      otherStudentClassifierAssocEnd = studentClassifierAssocEnd;
      studentClassifierAssocEnd = temp;
    }

    checkAssociationClassMapping(comparison, studentClassifierAssoc, instructorClassifierAssoc);

    if (!checkStudentElementForMistake(comparison.newMistakes, studentClassifierAssoc)) {
      checkMistakeExtraAssociationClass(studentClassifierAssoc, instructorClassifierAssoc, comparison.newMistakes);

      if (studentClassifierAssoc.getAssociationClass() != null
          && instructorClassifierAssoc.getAssociationClass() != null) {
        checkMistakeBadAssociationClassNameSpelling(studentClassifierAssoc, instructorClassifierAssoc, comparison)
            .ifPresent(comparison.newMistakes::add);
      }
    }

    if (!checkInstructorElementForMistake(comparison.newMistakes, instructorClassifierAssoc)) {
      checkMistakeMissingAssociationClass(studentClassifierAssoc, instructorClassifierAssoc, comparison.newMistakes);
    }
    if (!checkInstructorElementForMistake(comparison.newMistakes, instructorClassifierAssocEnd)) {
      checkMistakesForAssociationEnds(studentClassifierAssocEnd, instructorClassifierAssocEnd, comparison);
    }
    // -- Check for Other Assoc End-----
    if (!checkInstructorElementForMistake(comparison.newMistakes, otherInstructorClassifierAssocEnd)) {
      checkMistakesForAssociationEnds(otherStudentClassifierAssocEnd, otherInstructorClassifierAssocEnd, comparison);
    }
  }

  private static void removeMistakesRelatedToElement(Classifier cls, List<Mistake> newMistakes) {
    newMistakes.removeAll(mistakeForElement(cls, newMistakes));
  }

  private static void checkAssociationClassMapping(Comparison comparison, Association studentClassifierAssoc,
      Association instructorClassifierAssoc) {
    if (studentClassifierAssoc.getAssociationClass() != null
        && instructorClassifierAssoc.getAssociationClass() != null) {
      Classifier studAssocClass = studentClassifierAssoc.getAssociationClass();
      Classifier instAssocClass = instructorClassifierAssoc.getAssociationClass();
      if (!comparison.mappedClassifiers.containsKey(instAssocClass)) {
        comparison.assocClassMappingToAdd.put(instAssocClass, studAssocClass);
        return;
      }
      if (!comparison.mappedClassifiers.get(instAssocClass).equals(studAssocClass)) {
        comparison.extraStudentClassifiers.add(comparison.mappedClassifiers.get(instAssocClass));
        comparison.mappedClassifiers.put(instAssocClass, studAssocClass);
        comparison.extraStudentClassifiers.remove(studAssocClass);
      }
    }
    if (studentClassifierAssoc.getAssociationClass() == null
        && instructorClassifierAssoc.getAssociationClass() != null) {
      Classifier instAssocClass = instructorClassifierAssoc.getAssociationClass();
      if (comparison.mappedClassifiers.containsKey(instAssocClass)) {
        comparison.newMistakes.add(createMistake(CLASS_SHOULD_BE_ASSOC_CLASS,
            comparison.mappedClassifiers.get(instAssocClass), instAssocClass));
        comparison.extraStudentClassifiers.add(comparison.mappedClassifiers.get(instAssocClass));
        comparison.notMappedInstructorClassifiers.add(instAssocClass);
        comparison.assocClassifiersToRemove.add(instAssocClass);
      }
    }
    if (studentClassifierAssoc.getAssociationClass() != null
        && instructorClassifierAssoc.getAssociationClass() == null) {
      Classifier studAssocClass = studentClassifierAssoc.getAssociationClass();
      if (comparison.mappedClassifiers.containsValue(studAssocClass)) {
        comparison.extraStudentClassifiers.add(studAssocClass);
        comparison.mappedClassifiers.forEach((key, value) -> {
          if (value.equals(studAssocClass)) {
            comparison.notMappedInstructorClassifiers.add(key);
            comparison.assocClassifiersToRemove.add(key);
            comparison.newMistakes.add(createMistake(ASSOC_CLASS_SHOULD_BE_CLASS, studAssocClass, key));
            return;
          }
        });
      }
    }
  }

  private static void checkAssociationClassMappingWithNonAssociationClass(Comparison comparison) {
    for (Association instAssoc : comparison.notMappedInstructorAssociations) {
      if (instAssoc.getAssociationClass() != null
          && comparison.mappedClassifiers.containsKey(instAssoc.getAssociationClass())) {
        Classifier instAssocClass = instAssoc.getAssociationClass();
        comparison.extraStudentClassifiers.add(comparison.mappedClassifiers.get(instAssocClass));
        comparison.notMappedInstructorClassifiers.add(instAssocClass);
        comparison.assocClassifiersToRemove.add(instAssocClass);
      }
    }

  }

  private static void mapAssociation(Comparison comparison, Association instructorClassifierAssoc,
      Association studentClassifierAssoc) {
    comparison.mappedAssociations.put(instructorClassifierAssoc, studentClassifierAssoc);
    comparison.notMappedInstructorAssociations.remove(instructorClassifierAssoc);
    comparison.extraStudentAssociations.remove(studentClassifierAssoc);
  }

  private static List<Object> getMatchedAssoc(Map<Association, List<AssociationEnd>> possibleAssocMatch) {
    List<Object> seekedAssocAndEnds = new ArrayList<>();
    // use linked hash map to preserve insertion order
    Map<Association, Double> assocScoreMap = new LinkedHashMap<Association, Double>();
    for (var entry : possibleAssocMatch.entrySet()) {
      double score = 0;
      double multiplicityWeightage = 0.15;
      double roleNameWeightage = 0.20;
      int lDistance1 = levenshteinDistance(entry.getValue().get(0).getName(), entry.getValue().get(1).getName());
      int lDistance2 = levenshteinDistance(entry.getValue().get(2).getName(), entry.getValue().get(3).getName());
      if (associationEndMultiplicityUpperBoundsMatch(entry.getValue().get(0), entry.getValue().get(1))) {
        score = score + multiplicityWeightage;
      }
      if (associationEndMultiplicityLowerBoundsMatch(entry.getValue().get(0), entry.getValue().get(1))) {
        score = score + multiplicityWeightage;
      }
      if (lDistance1 <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
        score = score + roleNameWeightage;
      }
      if (associationEndMultiplicityUpperBoundsMatch(entry.getValue().get(2), entry.getValue().get(3))) {
        score = score + multiplicityWeightage;
      }
      if (associationEndMultiplicityLowerBoundsMatch(entry.getValue().get(2), entry.getValue().get(3))) {
        score = score + multiplicityWeightage;
      }
      if (lDistance2 <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
        score = score + roleNameWeightage;
      }
      assocScoreMap.put(entry.getKey(), score);
    } ;
    var matchedAssoc = maxAssociationMatch(assocScoreMap);
    for (var entry : possibleAssocMatch.entrySet()) {
      if (entry.getKey() == matchedAssoc.get(0)) {
        seekedAssocAndEnds.addAll(List.of(entry.getKey(), entry.getValue().get(0), entry.getValue().get(1),
            entry.getValue().get(2), entry.getValue().get(3)));
      }
    }
    return seekedAssocAndEnds;
  }

  private static void checkMistakesForAssociationEnds(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd, Comparison comparison) {
    final Consumer<? super Mistake> addMist = comparison.newMistakes::add; // method reference to save space
    checkMistakeWrongRelationshipDirection(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    if (!isMistakeExist(WRONG_RELATIONSHIP_DIRECTION, studentClassAssocEnd, comparison)) {
      checkMistakeUsingAssociationInsteadOfComposition(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
      checkMistakeUsingAssociationInsteadOfAggregation(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
      checkMistakeUsingCompositionInsteadOfAssociation(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
      checkMistakeUsingAggregationInsteadOfAssociation(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
      checkMistakeUsingAggregationInsteadOfComposition(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
      checkMistakeUsingCompositionInsteadOfAggregation(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    }
    checkMistakeUsingDirectedInsteadOfUndirected(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeUsingUndirectedInsteadOfDirected(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeRepresentingActionWithAssoc(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeRoleNameExpectedStactic(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeRoleNameNotExpectedStactic(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    if (!(isUsingDirectedInsteadOfUndirected(studentClassAssocEnd, instructorClassAssocEnd)
        || isUsingUndirectedInsteadOfDirected(studentClassAssocEnd, instructorClassAssocEnd))) {
      checkMistakeOtherWrongMultiplicity(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
      checkMistakeMissingRoleName(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
      checkMistakeRoleNamePresentButIncorrect(studentClassAssocEnd, instructorClassAssocEnd,comparison).ifPresent(addMist);
      checkMistakeBadRoleNameSpelling(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    }
  }

  private static Optional<Mistake> checkMistakeWrongRelationshipDirection(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    var otherStudentClassAssocEnd = getOtherAssocEnd(studentClassAssocEnd);
    var otherInstructorClassAssocEnd = getOtherAssocEnd(instructorClassAssocEnd);
    if (!(studentClassAssocEnd.getReferenceType().equals(REGULAR)
        && otherStudentClassAssocEnd.getReferenceType().equals(REGULAR))
        && studentClassAssocEnd.getReferenceType().equals(otherInstructorClassAssocEnd.getReferenceType())
        && otherStudentClassAssocEnd.getReferenceType().equals(instructorClassAssocEnd.getReferenceType())) {
      return Optional.of(createMistake(WRONG_RELATIONSHIP_DIRECTION, getAssociationElements(studentClassAssocEnd),
          getAssociationElements(instructorClassAssocEnd)));
    } else if (studentClassAssocEnd.getReferenceType().equals(REGULAR) // checks bi-directional associations.
        && otherStudentClassAssocEnd.getReferenceType().equals(REGULAR)
        && studentClassAssocEnd.getReferenceType().equals(otherInstructorClassAssocEnd.getReferenceType())
        && otherStudentClassAssocEnd.getReferenceType().equals(instructorClassAssocEnd.getReferenceType())
        && (isBiDirectionAssocDirectionWrong(studentClassAssocEnd, otherStudentClassAssocEnd,
            instructorClassAssocEnd, otherInstructorClassAssocEnd))) {
      return Optional.of(createMistake(WRONG_RELATIONSHIP_DIRECTION, getAssociationElements(studentClassAssocEnd),
          getAssociationElements(instructorClassAssocEnd)));
    }
    return Optional.empty();
  }

  public static boolean isBiDirectionAssocDirectionWrong(AssociationEnd studentClassAssocEnd,
      AssociationEnd otherStudentClassAssocEnd, AssociationEnd instructorClassAssocEnd,
      AssociationEnd otherInstructorClassAssocEnd) {
    return (studentClassAssocEnd.isNavigable() && !instructorClassAssocEnd.isNavigable()
        && !otherStudentClassAssocEnd.isNavigable() && otherInstructorClassAssocEnd.isNavigable())
        || (!studentClassAssocEnd.isNavigable() && instructorClassAssocEnd.isNavigable()
            && otherStudentClassAssocEnd.isNavigable() && !otherInstructorClassAssocEnd.isNavigable());
  }

  /** Check for infinite recursive dependency. */
  private static void checkMistakeInfiniteRecursiveDependency(AssociationEnd studentClassAssocEnd,
      AssociationEnd otherStudentClassAssocEnd, Comparison comparison) {
    var studClassAssocEndLowerBound = studentClassAssocEnd.getLowerBound();
    var otherStudClassAssocEndLowerBound = otherStudentClassAssocEnd.getLowerBound();

    if (!isMistakeExist(INFINITE_RECURSIVE_DEPENDENCY, studentClassAssocEnd, comparison)
        && !isMistakeExist(INFINITE_RECURSIVE_DEPENDENCY, otherStudentClassAssocEnd, comparison)){
      if(studClassAssocEndLowerBound >= 1 && otherStudClassAssocEndLowerBound >= 1) {
        if (otherStudClassAssocEndLowerBound > studClassAssocEndLowerBound) {
          comparison.newMistakes.add(createMistake(INFINITE_RECURSIVE_DEPENDENCY,
              List.of(studentClassAssocEnd, otherStudentClassAssocEnd), null));
        } else {
          comparison.newMistakes.add(createMistake(INFINITE_RECURSIVE_DEPENDENCY,
              List.of(otherStudentClassAssocEnd, studentClassAssocEnd), null));
        }
      } else if (studClassAssocEndLowerBound >= 1) {
        comparison.newMistakes.add(createMistake(INFINITE_RECURSIVE_DEPENDENCY,
            studentClassAssocEnd, null));
      } else if (otherStudClassAssocEndLowerBound >= 1) {
        comparison.newMistakes.add(createMistake(INFINITE_RECURSIVE_DEPENDENCY,
            otherStudentClassAssocEnd, null));
      }
    }
  }

  private static boolean isMistakeExist(MistakeType mistakeType, NamedElement NamedElement, Comparison comparison) {
    if (NamedElement == null) {
      return false;
    }
    for (Mistake mistake : comparison.newMistakes) {
      if (mistake.getMistakeType().equals(mistakeType) && !mistake.getStudentElements().isEmpty()) {
        for (var element : mistake.getStudentElements()) {
          if (element.getElement().equals(NamedElement)) {
            return true;
          }
        }
      } else if (mistake.getMistakeType().equals(mistakeType) && !mistake.getInstructorElements().isEmpty()) {
        for (var element : mistake.getInstructorElements()) {
          if (element.getElement().equals(NamedElement)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private static void mapAttributesBasedOnClassifierMap(Comparison comparison) {
    // To map attribute like ticketNo with TicketNumber
    comparison.mappedClassifiers.forEach((key, value) -> {
      for (Attribute instAttrib : key.getAttributes()) {
        for (Attribute studAttrib : value.getAttributes()) {
          if (!comparison.mappedAttributes.containsKey(instAttrib)) {
            if (studAttrib.getName().contains("ies")) { // To deal with cases like companies and company
              String name = studAttrib.getName();
              name = name.replaceAll("ies", "y");
              if (name.equals(instAttrib.getName())) {
                comparison.mappedAttributes.put(instAttrib, studAttrib);
                comparison.notMappedInstructorAttributes.remove(instAttrib);
                comparison.extraStudentAttributes.remove(studAttrib);
                checkMistakePluralAttribName(studAttrib, instAttrib).ifPresent(comparison.newMistakes::add);
              }
              break;
            }
            String[] attribNameSunStrings = studAttrib.getName().split("(?=\\p{Upper})");
            for (String subString : attribNameSunStrings) {
              if (instAttrib.getName().contains(subString)) {
                comparison.mappedAttributes.put(instAttrib, studAttrib);
                comparison.notMappedInstructorAttributes.remove(instAttrib);
                comparison.extraStudentAttributes.remove(studAttrib);
                if (isPlural(studAttrib.getName())) {
                  comparison.newMistakes.add(createMistake(PLURAL_ATTRIBUTE, studAttrib, instAttrib));
                } else {
                  comparison.newMistakes.add(createMistake(BAD_ATTRIBUTE_NAME_SPELLING, studAttrib, instAttrib));
                }
                break;
              }
            }
          }
        }
      }
    });
  }

  /** Returns true if a student element has a mistake associated with it. */
  private static boolean checkStudentElementForMistake(List<Mistake> newMistakes, NamedElement value) {
    for (Mistake mistake : newMistakes) {
      for (var studentElement : mistake.getStudentElements()) {
        if (studentElement.getElement().equals(value)) { // TODO Double check whether equals() works here
          return true;
        }
      }
    }
    return false;
  }

  /** Returns true if a instructor element has a mistake associated with it. */
  private static boolean checkInstructorElementForMistake(List<Mistake> newMistakes, NamedElement value) {
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
  private static void updateMistakes(Solution instructorSolution, Solution studentSolution, Comparison comparison,
      boolean filter) {
    final Consumer<? super Mistake> setSolutionForElems = m -> {
      m.getInstructorElements().forEach(ie -> ie.setSolution(instructorSolution));
      m.getStudentElements().forEach(se -> se.setSolution(studentSolution));
    };

    // List containing mistakes associated with a student Solution
    var existingMistakes = List.copyOf(studentSolution.getMistakes()); // copy to simplify removals
    var newMistakes = comparison.newMistakes;
    existingMistakes.forEach(setSolutionForElems);
    newMistakes.forEach(setSolutionForElems);

    // List containing existing mistakes that are equal to newMistakes
    List<Mistake> existingMistakesProcessed = new ArrayList<>();
    // List containing new mistakes that are already present in a solution (i.e
    // existingMistakes)
    List<Mistake> newMistakesProcessed = new ArrayList<>();

    // Condition when only new mistakes exists.
    if (existingMistakes.isEmpty() && !newMistakes.isEmpty()) {
      updateNewMistakes(newMistakes, studentSolution, filter);
    } else if (!existingMistakes.isEmpty() && !newMistakes.isEmpty()) {
      for (Mistake existingMistake : existingMistakes) {
        for (Mistake newMistake : newMistakes) {
          if (existingMistake.getMistakeType() == newMistake.getMistakeType()) {
            if (haveInstructorAndStudentElements(existingMistake, newMistake)) {
              if (compareInstructorElements(newMistake, existingMistake)) {
                setMistakeProperties(existingMistake, false, existingMistake.getNumDetections() + 1, 0);
                updateElementsOfExistingMistake(newMistake, existingMistake);
                existingMistakesProcessed.add(existingMistake);
                newMistakesProcessed.add(newMistake);
              }
            } else if (haveOnlyStudentElements(existingMistake, newMistake)) {
              if (compareStudentElements(newMistake, existingMistake)) {
                setMistakeProperties(existingMistake, false, existingMistake.getNumDetections() + 1, 0);
                updateElementsOfExistingMistake(newMistake, existingMistake);
                existingMistakesProcessed.add(existingMistake);
                newMistakesProcessed.add(newMistake);
              }
            } else if (haveOnlyInstructorElements(existingMistake, newMistake)) {
              if (compareInstructorElements(newMistake, existingMistake)) {
                setMistakeProperties(existingMistake, false, existingMistake.getNumDetections() + 1, 0);
                existingMistakesProcessed.add(existingMistake);
                newMistakesProcessed.add(newMistake);
              }
            }
          }
        }
      }
      List<Mistake> newUnProcessedMistakes = new ArrayList<>();
      newUnProcessedMistakes.addAll(newMistakes);
      newUnProcessedMistakes.removeAll(newMistakesProcessed);
      updateNewMistakes(newUnProcessedMistakes, studentSolution, filter);
      for (var existingMistake : existingMistakes) {
        if (!existingMistakesProcessed.contains(existingMistake)) {
          if (existingMistake.getNumSinceResolved() <= MAX_DETECTIONS_AFTER_RESOLUTION
              && existingMistake.isResolved()) {
            existingMistake.setResolved(true);
            existingMistake.setNumSinceResolved(existingMistake.getNumSinceResolved() + 1);
          } else {
            removeStaleMistake(existingMistake);
          }
        }
      }
    } else if (!existingMistakes.isEmpty() && newMistakes.isEmpty()) {
      for (Mistake existingMistake : existingMistakes) {
        if (existingMistake.getNumSinceResolved() <= MAX_DETECTIONS_AFTER_RESOLUTION) {
          existingMistake.setResolved(true);
          existingMistake.setNumSinceResolved(existingMistake.getNumSinceResolved() + 1);
        } else {
          removeStaleMistake(existingMistake);
        }
      }
    }
  }

  /** Removes a stale mistake from the solution that contains it. */
  private static void removeStaleMistake(Mistake mistake) {
    mistake.getInstructorElements().clear();
    mistake.getStudentElements().clear();
    mistake.getSolution().getMistakes().remove(mistake);
    mistake.setLastFeedback(null);
    mistake.setSolution(null);
  }

  private static void updateNewMistakes(List<Mistake> newMistakes, Solution studentSolution, boolean filter) {
    var patternMistakeTypes =
        List.of(ASSOC_SHOULD_BE_ENUM_PR_PATTERN, ASSOC_SHOULD_BE_FULL_PR_PATTERN, ASSOC_SHOULD_BE_SUBCLASS_PR_PATTERN,
            ENUM_SHOULD_BE_ASSOC_PR_PATTERN, ENUM_SHOULD_BE_FULL_PR_PATTERN, ENUM_SHOULD_BE_SUBCLASS_PR_PATTERN,
            FULL_PR_PATTERN_SHOULD_BE_ASSOC, FULL_PR_PATTERN_SHOULD_BE_ENUM, FULL_PR_PATTERN_SHOULD_BE_SUBCLASS,
            SUBCLASS_SHOULD_BE_ASSOC_PR_PATTERN, SUBCLASS_SHOULD_BE_FULL_PR_PATTERN, INCOMPLETE_PR_PATTERN,
            INCOMPLETE_AO_PATTERN, MISSING_AO_PATTERN);

    if (filter && mistakesInvolvePattern(newMistakes, patternMistakeTypes)) {
      updateMistakesInvolvingPattern(newMistakes, patternMistakeTypes, studentSolution);
    }
    else {
      for (Mistake newMistake : newMistakes) {
        setMistakeProperties(newMistake, false, 1, 0);
        newMistake.setSolution(studentSolution);
      }
    }
  }

  /** Returns instructor solution elements for a pattern. */
  private static List<NamedElement> getPatternInstructorElements(List<Mistake> newMistakes,
      List<MistakeType> patternMistakeTypes) {
    List<NamedElement> patternSolutionElements = new ArrayList<>();
    for (Mistake m : newMistakes) {
      if (patternMistakeTypes.contains(m.getMistakeType())) {
        for (SolutionElement s : m.getInstructorElements()) {
          patternSolutionElements.add(s.getElement());
        }
      }
    }
    return patternSolutionElements;
  }

  /** Returns student solution elements for a pattern. */
  private static List<NamedElement> getPatternStudentrElements(List<Mistake> newMistakes,
      List<MistakeType> patternMistakeTypes) {
    List<NamedElement> patternSolutionElements = new ArrayList<>();
    for (Mistake m : newMistakes) {
      if (patternMistakeTypes.contains(m.getMistakeType())) {
        for (SolutionElement s : m.getStudentElements()) {
          patternSolutionElements.add(s.getElement());
        }
      }
    }
    return patternSolutionElements;
  }

  /** Checks if mistake type related to patterns exists in detected mistakes. */
  private static boolean mistakesInvolvePattern(List<Mistake> newMistakes, List<MistakeType> patternMistakeTypes) {
    return newMistakes.stream().anyMatch(m -> patternMistakeTypes.contains(m.getMistakeType()));
  }

  private static void updateMistakesInvolvingPattern(List<Mistake> newMistakes, List<MistakeType> patternMistakeTypes,
      Solution studentSolution) {
    HashSet<Mistake> newMistakesToRemove = new HashSet<>();
    var patternInstructorElement = getPatternInstructorElements(newMistakes, patternMistakeTypes);
    var patternStudentElement = getPatternStudentrElements(newMistakes, patternMistakeTypes);
    for (Mistake newMistake : newMistakes) {
      if (!(newMistake.getMistakeType().equals(EXTRA_ATTRIBUTE) || newMistake.getMistakeType().equals(MISSING_ATTRIBUTE))) {
        if (!newMistake.getInstructorElements().isEmpty() && !patternMistakeTypes.contains(newMistake.getMistakeType())
            && patternInstructorElement.contains(newMistake.getInstructorElements().get(0).getElement())) {
          newMistakesToRemove.add(newMistake);
          continue;
        } else if (!newMistake.getStudentElements().isEmpty()
            && !patternMistakeTypes.contains(newMistake.getMistakeType())
            && patternStudentElement.contains(newMistake.getStudentElements().get(0).getElement())) {
          newMistakesToRemove.add(newMistake);
          continue;
        }
      }
      setMistakeProperties(newMistake, false, 1, 0);
      newMistake.setSolution(studentSolution);
    }
    newMistakes.removeAll(newMistakesToRemove);
  }

  /**
   * Updates the student elements of an existing mistake.
   *
   * @param newMistake
   * @param existingMistake
   */
  private static void updateElementsOfExistingMistake(Mistake newMistake, Mistake existingMistake) {
    existingMistake.getStudentElements().clear();
    existingMistake.getStudentElements().addAll(newMistake.getStudentElements());
  }

  // TODO Move helper methods to their relevant classes so they can be reused
  // elsewhere in the app

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
      if (!compareElement(existingMistake.getInstructorElements().get(i), newMistake.getInstructorElements().get(i))) {
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
      if (!compareElement(existingMistake.getStudentElements().get(i), newMistake.getStudentElements().get(i))) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns true if both elements are equal.
   *
   * @param existingElement
   * @param newElement
   * @return boolean
   */
  private static boolean compareElement(SolutionElement existingElement, SolutionElement newElement) {
    return existingElement.getElement().equals(newElement.getElement());
  }

  /** Sets the properties of a mistake. */
  private static void setMistakeProperties(Mistake mistake, boolean isResolved, int numDetection,
      int numDetectionSinceResolved) {
    mistake.setResolved(isResolved);
    mistake.setNumDetections(numDetection);
    mistake.setNumSinceResolved(numDetectionSinceResolved);
  }

  /**
   * Method to check if two classifiers match or not.
   *
   * @param instructorClass
   * @param studentClass
   * @return true if classifier match
   */
  public static boolean classifierNameMatch(Classifier instructorClass, Classifier studentClass) {
    return instructorClass.getName().toLowerCase().equals(studentClass.getName().toLowerCase());
  }

  /** Map classes with levenshtein distance less than or eqauls to MAX_LEVENSHTEIN_DISTANCE_ALLOWED*/
  public static boolean checkClassAndAttribBasedOnSpellingError(Classifier instructorClass, Classifier studentClass) {
    float lDistance = levenshteinDistance(studentClass.getName(), instructorClass.getName());
    return 0 <= lDistance && lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED;
  }

  /** Maps if instructor class name is present in a student class name */
  public static boolean checkClassAndAttribBasedOnSubStrings(Classifier instructorClass, Classifier studentClass) {
    return studentClass.getName().toLowerCase().contains(instructorClass.getName().toLowerCase());
  }

  /** Finds mappings in previously unmapped classes and attributes by comparing Attributes and Association Ends */
  public static void mapClassAndAttribBasedOnAttribsAssocAndAssocEnds(Comparison comparison) {
    if (comparison.notMappedInstructorClassifiers.isEmpty() || comparison.extraStudentClassifiers.isEmpty()) {
      return;
    }
    int counter = 1;
    int MAX_ATTRIBUTE_ALLOWED = 2;
    for (int i = 0; i < counter; i++) {
      for (int j = 0; j < comparison.notMappedInstructorClassifiers.size(); j++) {
        Classifier instructorClassifier = comparison.notMappedInstructorClassifiers.get(j);
        List<Attribute> instructorAttributes = instructorClassifier.getAttributes();
        int totalAttributes = instructorAttributes.size();
        Map<Classifier, Double> possibleClassMatch = new LinkedHashMap<Classifier, Double>();
        HashMap<Classifier, Integer> possibleClassMatchWithNoAttribute = new HashMap<Classifier, Integer>();
        for (int k = 0; k < comparison.extraStudentClassifiers.size(); k++) {
          Classifier studentClassifier = comparison.extraStudentClassifiers.get(k);
          List<Attribute> studentAttributes = studentClassifier.getAttributes();
          int correctAttribute = 0;
          if (totalAttributes == 0) {
            if (studentAttributes.size() <= MAX_ATTRIBUTE_ALLOWED) {
              possibleClassMatchWithNoAttribute.put(studentClassifier, studentAttributes.size());
            } else {
              continue;
            }
          }
          for (Attribute instructorAttribute : instructorAttributes) {
            for (Attribute studentAttribute : studentAttributes) {
              float lDistance = levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
              if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
                correctAttribute++;
                break;
              }
            }
          }
          if (totalAttributes != 0) {
            if ((double) correctAttribute / (double) totalAttributes >= 0.5) {
              possibleClassMatch.put(studentClassifier, (double) correctAttribute / (double) totalAttributes);
            }
          }
        }
        if (totalAttributes == 0 && possibleClassMatchWithNoAttribute.size() != 0) {
          List<Classifier> sortedClosestClasssifier = sortByValueClassifier(possibleClassMatchWithNoAttribute);
          Classifier possibleMatch =
              classWithOtherAssociationClassMatch(sortedClosestClasssifier, instructorClassifier);
          counter++;
          if (possibleMatch != null) {
            mapClasses(comparison, possibleMatch, instructorClassifier);
            checkMistakesInClassifier(possibleMatch, instructorClassifier, comparison.newMistakes);
          } else {
            Classifier sClass = classWithAssociationEndsMatch(sortedClosestClasssifier, instructorClassifier);
            mapClasses(comparison, sClass, instructorClassifier);
            checkMistakesInClassifier(sClass, instructorClassifier, comparison.newMistakes);
          }
        }
        if (totalAttributes == 0) {
          continue;
        }
        if (!possibleClassMatch.isEmpty() && nearestMatchExists(possibleClassMatch)) {
          Classifier studentClassifier = getMatchedClassifier(possibleClassMatch, instructorClassifier);
          counter++;
          mapClasses(comparison, studentClassifier, instructorClassifier);
          checkMistakesInClassifier(studentClassifier, instructorClassifier, comparison.newMistakes);
          List<Attribute> studentAttributes = studentClassifier.getAttributes();
          for (Attribute instructorAttribute : instructorAttributes) {
            for (Attribute studentAttribute : studentAttributes) {
              float lDistance = levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
              if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
                mapAttributes(comparison, studentAttribute, instructorAttribute);
                checkMistakesInAttributes(studentAttribute, instructorAttribute, comparison.newMistakes);
                break;
              }
            }
          }
        }
      }
    }
  }

  /** Returns true if nearest matching student class to the instructorClass exists. */
  private static boolean nearestMatchExists(Map<Classifier, Double> possibleClassMatch) {
    return !maxAttributeMatch(possibleClassMatch).isEmpty();
  }

  /**
   * Returns the nearest matching student class to the instructorClass.
   * If a match is found then zeroth element of list will be true, else false.
   */
  private static Classifier getMatchedClassifier(Map<Classifier, Double> possibleClassMatch,
      Classifier instructorClass) {
    var elements = maxAttributeMatch(possibleClassMatch);
    if (!elements.isEmpty() && elements.size() == 1) {
      return elements.get(0);
    } else if (elements.size() > 1) {
      Classifier possibleMatch = classWithOtherAssociationClassMatch(elements, instructorClass);
      if (possibleMatch != null) {
        return classWithOtherAssociationClassMatch(elements, instructorClass);
      } else {
        return classWithAssociationEndsMatch(elements, instructorClass);
      }
    }
    return null;
  }

  /** Returns the class with the closest number of association end classes matching with that of a instructor class. */
  private static Classifier classWithOtherAssociationClassMatch(List<Classifier> studentClasses,
      Classifier instructorClass) {
    List<String> instClassesName = new ArrayList<>();
    int instAssocEnds = instructorClass.getAssociationEnds().size();
    for (AssociationEnd instAssocEnd : instructorClass.getAssociationEnds()) {
      instClassesName.add(getOtherAssocEnd(instAssocEnd).getClassifier().getName());
    }

    Classifier seekedClassifier = null;
    Integer[] assocClassMatchValue = new Integer[studentClasses.size()];
    Map<Classifier, Integer> possibleClassMatches = new HashMap<Classifier, Integer>();
    int i = 0;
    for (Classifier sc : studentClasses) {
      assocClassMatchValue[i] = 0;
      for (AssociationEnd studAssocEnd : sc.getAssociationEnds()) {
        if (instClassesName.contains(getOtherAssocEnd(studAssocEnd).getClassifier().getName())) {
          assocClassMatchValue[i] += 1;
        }
      }
      possibleClassMatches.put(sc, assocClassMatchValue[i]);
      i++;
    }
    List<Integer> assocClassMatchValuList = Arrays.asList(assocClassMatchValue);
    var closestAssocValue = findClosest(assocClassMatchValuList, instAssocEnds);
    // System.out.println("classs"+closestAssocValue);

    for (Map.Entry<Classifier, Integer> entry : possibleClassMatches.entrySet()) {
      if (entry.getValue() == closestAssocValue) {
        seekedClassifier = entry.getKey();
        break;
      }
    } ;

    // System.out.println(seekedClassifier.getName()+" "+ instructorClass.getName());
    if (instAssocEnds != 0 && closestAssocValue == 0) {
      return null;
    }
    return seekedClassifier;
  }

  /** Returns the class with closest number of association ends with that of a instructor class. */
  private static Classifier classWithAssociationEndsMatch(List<Classifier> studentClasses, Classifier instructorClass) {
    int instAssocEnds = instructorClass.getAssociationEnds().size();
    Classifier seekedClassifier = null;
    List<Integer> assocEndValues = new ArrayList<>();
    studentClasses.forEach(sc -> {
      assocEndValues.add(sc.getAssociationEnds().size());
      // System.out.println(sc.getName() +" " + sc.getAssociationEnds().size());
    });
    var closestAssocValue = findClosest(assocEndValues, instAssocEnds);
    // System.out.println(closestAssocValue);
    for (Classifier sc : studentClasses) {
      if (sc.getAssociationEnds().size() == closestAssocValue) {
        seekedClassifier = sc;
        break;
      }
    }
    // System.out.println(seekedClassifier.getName()+" "+ instructorClass.getName());

    return seekedClassifier;
  }

  /** Returns the classifiers with maximum number of matched attributes. */
  public static List<Classifier> maxAttributeMatch(Map<Classifier, Double> map) {
    Map.Entry<Classifier, Double> entryWithMaxValue = null;
    List<Classifier> topMatchedElements = new ArrayList<>();
    for (Map.Entry<Classifier, Double> entry : map.entrySet()) {
      if (entryWithMaxValue == null || entry.getValue() > entryWithMaxValue.getValue()) {
        entryWithMaxValue = entry;
      }
    }
    final double maxValue = entryWithMaxValue.getValue();
    map.forEach((key, value) -> {
      if (value == maxValue) {
        topMatchedElements.add(key);
      }
    });
    return topMatchedElements;
  }

  /** Returns the associations with maximum number of score. */
  public static List<Association> maxAssociationMatch(Map<Association, Double> map) {
    Map.Entry<Association, Double> entryWithMaxValue = null;
    List<Association> topMatchedElements = new ArrayList<>();
    for (Map.Entry<Association, Double> entry : map.entrySet()) {
      if (entryWithMaxValue == null || entry.getValue() > entryWithMaxValue.getValue()) {
        entryWithMaxValue = entry;
      }
    }
    final double maxValue = entryWithMaxValue.getValue();
    map.forEach((key, value) -> {
      if (value == maxValue) {
        topMatchedElements.add(key);
      }
    });
    return topMatchedElements;
  }

  /** Returns element closest to target in array. */
  public static int findClosest(List<Integer> assocEndValues, int target) {
    Map<Integer, Integer> closestNumbDiffMap = new HashMap<>();
    assocEndValues.forEach(value -> {
      int diff = target - value;
      closestNumbDiffMap.put(value, Math.abs(diff));
    });
    Map<Integer, Integer> sortedClosestNumbDiffMap = sortByValue(closestNumbDiffMap);
    return sortedClosestNumbDiffMap.keySet().stream().findFirst().get();
  }

  /** Sorts input map by values. */
  public static Map<Integer, Integer> sortByValue(Map<Integer, Integer> hm) {
    // Create a list from elements of input map
    List<Map.Entry<Integer, Integer>> list = new LinkedList<>(hm.entrySet());
    // Sort the list
    Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
    // Put data from sorted list to hash map
    Map<Integer, Integer> result = new LinkedHashMap<>();
    for (var entry : list) {
      result.put(entry.getKey(), entry.getValue());
    }
    return result;
  }

  /** Sorts input by values. */
  public static List<Classifier> sortByValueClassifier(Map<Classifier, Integer> hm) {
    // Create a list from elements of input map
    List<Map.Entry<Classifier, Integer>> list = new LinkedList<>(hm.entrySet());
    // Sort the list
    Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
    // Put data from sorted list to hash map
    List<Classifier> result = new ArrayList<>();
    for (var entry : list) {
      result.add(entry.getKey());
    }
    return result;
  }

  public static void mapAttributes(Comparison comparison, Attribute studentAttribute, Attribute instructorAttribute) {
    comparison.mappedAttributes.put(instructorAttribute, studentAttribute);
    comparison.notMappedInstructorAttributes.remove(instructorAttribute);
    comparison.extraStudentAttributes.remove(studentAttribute);
  }

  public static void mapClasses(Comparison comparison, Classifier studentClass, Classifier instructorClass) {
    if (comparison.mappedClassifiers.containsValue(studentClass)) {
      return;
    }
    comparison.mappedClassifiers.put(instructorClass, studentClass);
    comparison.notMappedInstructorClassifiers.remove(instructorClass);
    comparison.extraStudentClassifiers.remove(studentClass);
  }

  /** Checks for a software engineering term in a given classifier. */
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

  public static Optional<Mistake> checkMistakeIncorrectClassNameButCorrectAttribRel(Classifier studentClass,
      Classifier instructorClass) {
    int lDistance = levenshteinDistance(studentClass.getName(), instructorClass.getName());
    if (!isPlural(studentClass.getName()) && !isSoftwareEngineeringTerm(studentClass.getName())
        && lDistance > MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      return Optional.of(createMistake(WRONG_CLASS_NAME, studentClass, instructorClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakePluralAttribName(Attribute studentAttrib, Attribute instructorAttrib) {
    if (isPlural(studentAttrib.getName())) {
      return Optional.of(createMistake(PLURAL_ATTRIBUTE, studentAttrib, instructorAttrib));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUppercaseAttribName(Attribute studentAttrib, Attribute instructorAttrib) {
    if (startsWithUppercase(studentAttrib.getName())) {
      return Optional.of(createMistake(UPPERCASE_ATTRIBUTE_NAME, studentAttrib, instructorAttrib));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeClassSpelling(Classifier studentClass, Classifier instructorClass) {
    if (spellingMistakeCheck(studentClass.getName(), instructorClass.getName()) && !isPlural(studentClass.getName())
        && !isLowerName(studentClass.getName())) {
      return Optional.of(createMistake(BAD_CLASS_NAME_SPELLING, studentClass, instructorClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeAttributeSpelling(Attribute studentAttribute,
      Attribute instructorAttribute) {
    if (!isPlural(studentAttribute.getName()) && levenshteinDistance(studentAttribute.getName().toLowerCase(),
        instructorAttribute.getName().toLowerCase()) >= 1) {
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

  public static Optional<Mistake> checkMistakeWrongAttributeTypeAndListAttrib(Attribute studentAttribute,
      Attribute instructorAttribute) {
    if (!attributeTypesMatch(studentAttribute, instructorAttribute)
        && (studentAttribute.getType() instanceof CDArray || studentAttribute.getType() instanceof CDCollection)) {
      return Optional.of(createMistake(LIST_ATTRIBUTE, studentAttribute, instructorAttribute));
    } else if (!attributeTypesMatch(studentAttribute, instructorAttribute)) {
      return Optional.of(createMistake(WRONG_ATTRIBUTE_TYPE, studentAttribute, instructorAttribute));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeAttributeExpectedStatic(Attribute studentAttribute,
      Attribute instructorAttribute) {
    if (isAttributeExpectedStatic(studentAttribute, instructorAttribute)) {
      return Optional.of(createMistake(ATTRIBUTE_SHOULD_BE_STATIC, studentAttribute, instructorAttribute));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeAttributeNotExpectedStatic(Attribute studentAttribute,
      Attribute instructorAttribute) {
    if (isAttributeNotExpectedStatic(studentAttribute, instructorAttribute)) {
      return Optional.of(createMistake(ATTRIBUTE_SHOULD_NOT_BE_STATIC, studentAttribute, instructorAttribute));
    }
    return Optional.empty();
  }

  /** Returns association, association end and other association end in order. */
  public static List<NamedElement> getAssociationElements(AssociationEnd assocEnd){
    return List.of(assocEnd.getAssoc(), assocEnd, getOtherAssocEnd(assocEnd));
  }

  public static Optional<Mistake> checkMistakeUsingAssociationInsteadOfComposition(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingAssociationInsteadOfComposition(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_ASSOC_INSTEAD_OF_COMPOSITION, getAssociationElements(studentClassAssocEnd),
          getAssociationElements(instructorClassAssocEnd)));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingAssociationInsteadOfAggregation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingAssociationInsteadOfAggregation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_ASSOC_INSTEAD_OF_AGGREGATION, getAssociationElements(studentClassAssocEnd),
          getAssociationElements(instructorClassAssocEnd)));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingCompositionInsteadOfAssociation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingCompositionInsteadOfAssociation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_COMPOSITION_INSTEAD_OF_ASSOC, getAssociationElements(studentClassAssocEnd),
          getAssociationElements(instructorClassAssocEnd)));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingAggregationInsteadOfAssociation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingAggregationInsteadOfAssociation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_AGGREGATION_INSTEAD_OF_ASSOC, getAssociationElements(studentClassAssocEnd),
          getAssociationElements(instructorClassAssocEnd)));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingAggregationInsteadOfComposition(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingAggregationInsteadOfComposition(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_AGGREGATION_INSTEAD_OF_COMPOSITION,
          getAssociationElements(studentClassAssocEnd), getAssociationElements(instructorClassAssocEnd)));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingCompositionInsteadOfAggregation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingCompositionInsteadOfAggregation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_COMPOSITION_INSTEAD_OF_AGGREGATION,
          getAssociationElements(studentClassAssocEnd), getAssociationElements(instructorClassAssocEnd)));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingDirectedInsteadOfUndirected(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingDirectedInsteadOfUndirected(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_DIRECTED_RELATIONSHIP_INSTEAD_OF_UNDIRECTED,
          getAssociationElements(studentClassAssocEnd), getAssociationElements(instructorClassAssocEnd)));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingUndirectedInsteadOfDirected(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingUndirectedInsteadOfDirected(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED,
          getAssociationElements(studentClassAssocEnd), getAssociationElements(instructorClassAssocEnd)));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeRepresentingActionWithAssoc(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (!isVerb(instructorClassAssocEnd.getName()) && isVerb(studentClassAssocEnd.getName())) {
      return Optional.of(createMistake(REPRESENTING_ACTION_WITH_ASSOC, studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeOtherWrongMultiplicity(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (!associationEndMultiplicityMatch(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(WRONG_MULTIPLICITY, studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeMissingRoleName(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isRoleNameMissing(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(MISSING_ROLE_NAMES, studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeRoleNameExpectedStactic(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isRoleNameExpectedStatic(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(ROLE_SHOULD_BE_STATIC, studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeRoleNameNotExpectedStactic(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isRoleNameNotExpectedStatic(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(ROLE_SHOULD_NOT_BE_STATIC, studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeBadRoleNameSpelling(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (spellingMistakeCheck(studentClassAssocEnd.getName(), instructorClassAssocEnd.getName())) {
      return Optional.of(createMistake(BAD_ROLE_NAME_SPELLING, studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeBadEnumNameSpelling(CDEnum studentEnum, CDEnum instructorEnum) {
    if (levenshteinDistance(studentEnum.getName().toLowerCase(), instructorEnum.getName().toLowerCase()) >= 1) {
      return Optional.of(createMistake(BAD_ENUM_NAME_SPELLING, studentEnum, instructorEnum));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeBadEnumLiteralSpelling(CDEnumLiteral studentEnumLiteral,
      CDEnumLiteral instructorEnumLiteral) {
    if (levenshteinDistance(studentEnumLiteral.getName().toLowerCase(), instructorEnumLiteral.getName().toLowerCase())>= 1) {
      return Optional.of(createMistake(BAD_ENUM_ITEM_SPELLING, studentEnumLiteral, instructorEnumLiteral));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeRoleNamePresentButIncorrect(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd, Comparison comparison) {
    int lDistance = levenshteinDistance(studentClassAssocEnd.getName(), instructorClassAssocEnd.getName());
    var m = getMistakeForElement(studentClassAssocEnd, USING_UNDIRECTED_RELATIONSHIP_INSTEAD_OF_DIRECTED, comparison);
    if (lDistance > MAX_LEVENSHTEIN_DISTANCE_ALLOWED && m == null) {
      return Optional.of(createMistake(WRONG_ROLE_NAME, studentClassAssocEnd, instructorClassAssocEnd));
    }

    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeBadAssociationClassNameSpelling(Association studentClassAssoc,
      Association instructorClassAssoc, Comparison comparison) {
    if (levenshteinDistance(studentClassAssoc.getAssociationClass().getName(),
        instructorClassAssoc.getAssociationClass().getName())>= 1) {
      if (isMistakeExist(BAD_CLASS_NAME_SPELLING, studentClassAssoc.getAssociationClass(), comparison)) {
        Mistake m = getMistakeForElement(studentClassAssoc.getAssociationClass(), BAD_CLASS_NAME_SPELLING, comparison);
        if (m != null) {
          comparison.newMistakes.remove(m);
        }
      }
      return Optional.of(createMistake(BAD_ASSOC_CLASS_NAME_SPELLING, studentClassAssoc.getAssociationClass(),
          instructorClassAssoc.getAssociationClass()));
    }
    return Optional.empty();
  }

  /** Returns mistake for a element, if not found then returns Null. */
  public static Mistake getMistakeForElement(NamedElement studentElement, MistakeType mistakeType,
      Comparison comparison) {
    for (var m : comparison.newMistakes) {
      if (m.getMistakeType().equals(mistakeType) && m.getStudentElements().get(0).getElement().equals(studentElement)) {
        return m;
      }
    }
    return null;
  }

  public static void checkMistakeMissingAssociationClass(Association studentClassAssoc,
      Association instructorClassAssoc, List<Mistake> newMistakes) {
    if (isAssociationClassMissing(studentClassAssoc, instructorClassAssoc)) {
      for (Mistake m : mistakeForElement(instructorClassAssoc.getAssociationClass(), newMistakes)) {
        if (m.getMistakeType().equals(CLASS_SHOULD_BE_ASSOC_CLASS)) {
          return;
        }
      }
      removeMistakesRelatedToElement(instructorClassAssoc.getAssociationClass(), newMistakes);
      newMistakes.add(createMistake(MISSING_ASSOC_CLASS, null,
          List.of(instructorClassAssoc, instructorClassAssoc.getAssociationClass())));
    }
  }

  public static void checkMistakeExtraAssociationClass(Association studentClassAssoc, Association instructorClassAssoc,
      List<Mistake> newMistakes) {
    if (isAssociationClassExtra(studentClassAssoc, instructorClassAssoc)) {
      for (Mistake m : mistakeForElement(studentClassAssoc.getAssociationClass(), newMistakes)) {
        if (m.getMistakeType().equals(ASSOC_CLASS_SHOULD_BE_CLASS)) {
          return;
        }
      }
      removeMistakesRelatedToElement(studentClassAssoc.getAssociationClass(), newMistakes);
      newMistakes.add(createMistake(EXTRA_ASSOC_CLASS, List.of(studentClassAssoc, studentClassAssoc.getAssociationClass()),
          null));
    }

  }

  public static void checkMistakeMissingClassAndEnumInsteadOfClass(Comparison comparison) {

    comparison.notMappedInstructorClassifiers.forEach(cls -> {
      comparison.extraStudentEnums.forEach(studEnum -> {
        if (studEnum.getName().equals(cls.getName())) {
          comparison.newMistakes.add(createMistake(ENUM_SHOULD_BE_CLASS, studEnum, cls));
        }
      });
      if (!mistakeForElementExists(cls, comparison.newMistakes)) {
        comparison.newMistakes.add(createMistake(MISSING_CLASS, null, cls));
      }
    }); // No Student Element
  }

  private static boolean mistakeForElementExists(NamedElement cls, List<Mistake> newMistakes) {
    for (Mistake m : newMistakes) {
      if ((!m.getInstructorElements().isEmpty() && m.getInstructorElements().get(0).getElement().equals(cls))
          || (!m.getStudentElements().isEmpty() && m.getStudentElements().get(0).getElement().equals(cls))) {
        return true;
      }
    }
    return false;
  }

  private static List<Mistake> mistakeForElement(Classifier cls, List<Mistake> newMistakes) {
    List<Mistake> mistakesFound = new ArrayList<>();
    for (Mistake m : newMistakes) {
      if ((!m.getInstructorElements().isEmpty() && m.getInstructorElements().get(0).getElement().equals(cls))
          || (!m.getStudentElements().isEmpty() && m.getStudentElements().get(0).getElement().equals(cls))) {
        mistakesFound.add(m);
      }
    }
    return mistakesFound;
  }

  public static void checkMistakeExtraClassAndClassShouldBeEnum(Comparison comparison) {
    comparison.extraStudentClassifiers.forEach(cls -> {
      comparison.notMappedInstructorEnums.forEach(instEnum -> {
        if (instEnum.getName().equals(cls.getName())) {
          comparison.newMistakes.add(createMistake(CLASS_SHOULD_BE_ENUM, cls, instEnum));
        }
      });
      if (!mistakeForElementExists(cls, comparison.newMistakes)) {
        comparison.newMistakes.add(createMistake(EXTRA_CLASS, cls, null));
      }
    });
  }

  /** Creates missing attribute mistake for mapped instructor classes only. */
  public static void checkMistakeMissingAttribute(Comparison comparison) {
    comparison.notMappedInstructorAttributes.forEach(attrib -> {
      comparison.mappedClassifiers.keySet().forEach(cls -> {
        if (cls.getAttributes().contains(attrib))
          comparison.newMistakes.add(createMistake(MISSING_ATTRIBUTE, comparison.mappedClassifiers.get(cls), attrib));
      });
    });
  }

  /** Creates missing enum literal mistake for mapped enums only. */
  public static void checkMistakeMissingExtraEnum(Comparison comparison) {
    comparison.notMappedInstructorEnumLiterals.forEach(enuml -> {
      comparison.mappedEnumerations.keySet().forEach(e -> {
        if(e.equals(enuml.getEnum()))
        comparison.newMistakes.add(createMistake(MISSING_ENUM_ITEM, comparison.mappedEnumerations.get(e) , enuml));
      });
    });

    comparison.notMappedInstructorEnums.forEach(cls -> {
      if (!mistakeForElementExists(cls, comparison.newMistakes)) {
        comparison.newMistakes.add(createMistake(MISSING_ENUM, null, cls));
      }
    });

    /** Creates extra enum literal mistake for mapped enums only. */
    comparison.extraStudentEnumLiterals.forEach(enuml -> {
      comparison.mappedEnumerations.forEach((key,value) -> {
        if (value.equals(enuml.getEnum())) {
          comparison.newMistakes.add(createMistake(EXTRA_ENUM_ITEM, enuml, key));
        }
      });
    });

    comparison.extraStudentEnums.forEach(cls -> {
      if (!mistakeForElementExists(cls, comparison.newMistakes)) {
        comparison.newMistakes.add(createMistake(EXTRA_ENUM, cls, null));
      }
    });

  }

  /** Creates extra attribute mistake for mapped classifiers only. */
  public static void checkMistakeExtraAttribute(Comparison comparison) {
    comparison.extraStudentAttributes.forEach(attrib ->{
      comparison.mappedClassifiers.forEach((key, value) -> {
        if (value.getAttributes().contains(attrib))
          comparison.newMistakes.add(createMistake(EXTRA_ATTRIBUTE, attrib, key));
      });
    });
  }

  public static void checkMistakeMissingAssociationCompositionAggregation(Comparison comparison) {
    for (Association association : comparison.notMappedInstructorAssociations) {
      checkMistakeAttributeInsteadOfAssociation(association, comparison);
      if (association.getEnds().get(0).getReferenceType().equals(COMPOSITION)) {
        if (!isMistakeExist(INCOMPLETE_CONTAINMENT_TREE,
            comparison.mappedClassifiers.get(association.getEnds().get(0).getClassifier()), comparison)) {
          comparison.newMistakes
              .add(createMistake(MISSING_COMPOSITION, null, getAssociationElements(association.getEnds().get(0))));
        }
      } else if (association.getEnds().get(1).getReferenceType().equals(COMPOSITION)) {
        if (!isMistakeExist(INCOMPLETE_CONTAINMENT_TREE,
            comparison.mappedClassifiers.get(association.getEnds().get(1).getClassifier()), comparison)) {
          comparison.newMistakes
              .add(createMistake(MISSING_COMPOSITION, null, getAssociationElements(association.getEnds().get(1))));
        }
      } else if (association.getEnds().get(0).getReferenceType().equals(AGGREGATION)) {
        comparison.newMistakes
            .add(createMistake(MISSING_AGGREGATION, null, getAssociationElements(association.getEnds().get(0))));
      } else if (association.getEnds().get(1).getReferenceType().equals(AGGREGATION)) {
        comparison.newMistakes
            .add(createMistake(MISSING_AGGREGATION, null, getAssociationElements(association.getEnds().get(1))));
      } else {
        comparison.newMistakes.add(createMistake(MISSING_ASSOCIATION, null, association));
      }
      if (association.getAssociationClass() != null) {
        removeMistakesRelatedToElement(association.getAssociationClass(), comparison.newMistakes);
        comparison.newMistakes
            .add(createMistake(MISSING_ASSOC_CLASS, null, List.of(association, association.getAssociationClass())));
      }
    }
  }

  private static void checkMistakeAttributeInsteadOfAssociation(Association association, Comparison comparison) {
    var assocEnds = association.getEnds();
    var assocEndStudClass = comparison.mappedClassifiers.get(assocEnds.get(0).getClassifier());
    var otherAssocEndStudClass = comparison.mappedClassifiers.get(assocEnds.get(1).getClassifier());

    if (assocEndStudClass != null && otherAssocEndStudClass != null) {
      var studClassOneAttrib = assocEndStudClass.getAttributes();
      var studClassTwoAttrib = otherAssocEndStudClass.getAttributes();

      for (var attrib : studClassOneAttrib) {
        if (attrib.getName().toLowerCase().equals(assocEnds.get(0).getClassifier().getName().toLowerCase())) {
          comparison.newMistakes.add(createMistake(USING_ATTRIBUTE_INSTEAD_OF_ASSOC, attrib, assocEnds.get(0)));
        }
      }
      for (var attrib : studClassTwoAttrib) {
        if (attrib.getName().toLowerCase().equals(assocEnds.get(0).getClassifier().getName().toLowerCase())) {
          comparison.newMistakes.add(createMistake(USING_ATTRIBUTE_INSTEAD_OF_ASSOC, attrib, assocEnds.get(0)));
        }
      }
    }

    else if (assocEndStudClass == null && otherAssocEndStudClass != null) {
      var studClassTwoAttrib = otherAssocEndStudClass.getAttributes();
      for (var attrib : studClassTwoAttrib) {
        if (comparison.notMappedInstructorClassifiers.stream()
            .anyMatch(c -> c.getName().toLowerCase().equals(attrib.getName().toLowerCase()))) {
          comparison.newMistakes.add(createMistake(USING_ATTRIBUTE_INSTEAD_OF_ASSOC, attrib, assocEnds.get(1)));
        }
      }
    }

    else if (assocEndStudClass != null && otherAssocEndStudClass == null) {
      var studClassOneAttrib = assocEndStudClass.getAttributes();
      for (var attrib : studClassOneAttrib) {
        if (comparison.notMappedInstructorClassifiers.stream()
            .anyMatch(c -> c.getName().toLowerCase().equals(attrib.getName().toLowerCase()))) {
          comparison.newMistakes.add(createMistake(USING_ATTRIBUTE_INSTEAD_OF_ASSOC, attrib, assocEnds.get(0)));
        }
      }
    }
  }

  public static void checkMistakeExtraAssociationCompositionAggregation(Comparison comparison) {
    for (Association association : comparison.extraStudentAssociations) {
      if (association.getEnds().get(0).getReferenceType().equals(COMPOSITION)) {
        comparison.newMistakes
            .add(createMistake(EXTRA_COMPOSITION, getAssociationElements(association.getEnds().get(0)), null));
      } else if (association.getEnds().get(1).getReferenceType().equals(COMPOSITION)) {
        comparison.newMistakes
            .add(createMistake(EXTRA_COMPOSITION, getAssociationElements(association.getEnds().get(1)), null));
      } else if (association.getEnds().get(0).getReferenceType().equals(AGGREGATION)) {
        comparison.newMistakes
            .add(createMistake(EXTRA_AGGREGATION, getAssociationElements(association.getEnds().get(0)), null));
      } else if (association.getEnds().get(1).getReferenceType().equals(AGGREGATION)) {
        comparison.newMistakes
            .add(createMistake(EXTRA_AGGREGATION, getAssociationElements(association.getEnds().get(1)), null));
      } else {
        comparison.newMistakes.add(createMistake(EXTRA_ASSOCIATION, association, null));
      }
      if (association.getAssociationClass() != null) {
        removeMistakesRelatedToElement(association.getAssociationClass(), comparison.newMistakes);
        comparison.newMistakes
            .add(createMistake(EXTRA_ASSOC_CLASS, List.of(association, association.getAssociationClass()), null));
      }
    }
  }

  /** Returns list of student elements in order based on tagType->Abstraction, Occurrence. */
  public static LinkedList<NamedElement> getOrderedStudAOPatternElements(TagGroup tg, Comparison comparison) {
    LinkedList<NamedElement> studentElements = new LinkedList<>();
    for (Tag tag : tg.getTags()) {
      var tagElement = tag.getSolutionElement().getElement();
      if (comparison.mappedClassifiers.containsKey(tagElement)) {
        if (tag.getTagType() == ABSTRACTION) {
          if(comparison.mappedClassifiers.containsKey(tagElement))
          studentElements.addFirst(comparison.mappedClassifiers.get(tagElement));
        } else {
          studentElements.add(comparison.mappedClassifiers.get(tagElement));
        }
      }
    }
    return studentElements;
  }

  /** Returns list of instructor elements in order based on tagType-> Player/Abstraction, Role/Occurrence. */
  public static LinkedList<NamedElement> getOrderedInstPatternElements(TagGroup tg, Comparison comparison,
      TagType tagType) {
    LinkedList<NamedElement> instructorElements = new LinkedList<>();
    for (Tag tag : tg.getTags()) {
      if (tag.getTagType().equals(tagType)) {
        instructorElements.addFirst(tag.getSolutionElement().getElement());
      } else {
        instructorElements.add(tag.getSolutionElement().getElement());
      }
    }
    return instructorElements;
  }

  public static void checkMistakeMissingPattern(TagGroup tg, Comparison comparison) {
    var missingElements = getOrderedInstPatternElements(tg, comparison, PLAYER);
    comparison.newMistakes.add(createMistake(MISSING_PR_PATTERN, null, missingElements));
  }

  /** Make sure that studentMissingElements are in order -> Player, roles. */
  public static void createMistakeIncompletePRPattern(List<NamedElement> studentMissingElements, TagGroup tg, Comparison comparison) {
    var instructorElements = getOrderedInstPatternElements(tg, comparison, PLAYER);
    comparison.newMistakes.add(createMistake(INCOMPLETE_PR_PATTERN, studentMissingElements, instructorElements));
  }

  public static void createMistakeIncompleteAOPattern(TagGroup tg, Comparison comparison) {
    var studentMissingElements = getOrderedStudAOPatternElements(tg, comparison);
    var instructorElements = getOrderedInstPatternElements(tg, comparison, ABSTRACTION);
    comparison.newMistakes.add(createMistake(INCOMPLETE_AO_PATTERN, studentMissingElements, instructorElements));
  }

  /** Make sure that studentElements and instructorElements are in order -> Player, roles. */
  public static void checkMistakeUsingEnumPattern(String instPattern, List<NamedElement> studentElements,
      List<NamedElement> instElements, Comparison comparison) {
    if (instPattern.equals(ASSOC_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(ENUM_SHOULD_BE_ASSOC_PR_PATTERN, studentElements, instElements));
    } else if (instPattern.equals(FULL_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(ENUM_SHOULD_BE_FULL_PR_PATTERN, studentElements, instElements));
    } else if (instPattern.equals(SUB_CLASS_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(ENUM_SHOULD_BE_SUBCLASS_PR_PATTERN, studentElements, instElements));
    }
  }

  /** Make sure that studentElements and instructorElements are in order -> Player, roles. */
  public static void checkMistakeUsingFullPattern(String instPattern, List<NamedElement> studentElements,
      List<NamedElement> instElements, Comparison comparison) {
    if (instPattern.equals(ASSOC_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(FULL_PR_PATTERN_SHOULD_BE_ASSOC, studentElements, instElements));
    } else if (instPattern.equals(ENUM_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(FULL_PR_PATTERN_SHOULD_BE_ENUM, studentElements, instElements));
    } else if (instPattern.equals(SUB_CLASS_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(FULL_PR_PATTERN_SHOULD_BE_SUBCLASS, studentElements, instElements));
    }
  }

  /** Make sure that studentElements and instructorElements are in order -> Player, roles. */
  public static void checkMistakeUsingSubclassPattern(String instPattern, List<NamedElement> studentElements,
      List<NamedElement> instElements, Comparison comparison) {
    if (instPattern.equals(ASSOC_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(SUBCLASS_SHOULD_BE_ASSOC_PR_PATTERN, studentElements, instElements));
    } else if (instPattern.equals(FULL_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(SUBCLASS_SHOULD_BE_FULL_PR_PATTERN, studentElements, instElements));
    } else if (instPattern.equals(ENUM_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(SUBCLASS_SHOULD_BE_ENUM_PR_PATTERN, studentElements, instElements));
    }
  }

  /** Make sure that studentElements and instructorElements are in order -> Player, roles. */
  public static void checkMistakeUsingAssocPattern(String instPattern, List<NamedElement> studentElements,
      List<NamedElement> instElements, Comparison comparison) {
    if (instPattern.equals(ENUM_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(ASSOC_SHOULD_BE_ENUM_PR_PATTERN, studentElements, instElements));
    } else if (instPattern.equals(FULL_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(ASSOC_SHOULD_BE_FULL_PR_PATTERN, studentElements, instElements));
    } else if (instPattern.equals(SUB_CLASS_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(ASSOC_SHOULD_BE_SUBCLASS_PR_PATTERN, studentElements, instElements));
    }
  }

  /** Returns true if the input string is a software engineering term. */
  public static boolean isSoftwareEngineeringTerm(String s) {
    final var softwareEnginneringTerms = List.of("data", "record", "table", "info", "class", "list");
    for (var seTerm : softwareEnginneringTerms) {
      if (s.toLowerCase().contains(seTerm))
        return true;
    }
    return false;
  }

  /**Returns true if the input string is plural. */
  public static boolean isPlural(String s) {
    boolean isPlural = false;

    if (nounPluralStatus.containsKey(s)) {
      return nounPluralStatus.get(s);
    } else {
      String tagged = taggerOut(s);
      String[] str = tagged.split("(_|/)");
      String pluralTag = "NNS";
      // Tagger also considers string ending with 5 as plural, therefore adding a
      // condition to prevent this
      if (str[1].contains(pluralTag) && str[0].charAt(str[0].length() - 1) != '5') {
        isPlural = true;
      }
      nounPluralStatus.put(s, isPlural);
    }
    return isPlural;
  }

  /**Returns true if the input string is a verb. */
  public static boolean isVerb(String s) {
    boolean isVerb = false;
    if (s.isBlank()) {
      return false;
    }

    if (verbStatus.containsKey(s)) {
      return verbStatus.get(s);
    } else {
      String tagged = taggerOut(s);
      String[] str = tagged.split("(_|/)");
      char verbTag = 'V';
      if (str[1].charAt(0) == verbTag) {
        isVerb = true;
      }
      verbStatus.put(s, isVerb);
    }
    return isVerb;
  }

  public static String taggerOut(String s) {
    String taggerInput = s;
    taggerInput = taggerInput.toLowerCase(); // Tagger works on lower case string
    String tagged = maxentTagger.tagString(taggerInput);
    return tagged;
  }

  public static boolean isLowerName(String name) {
    return name.toLowerCase() == name;
  }

  public static boolean startsWithUppercase(String name) {
    return Character.isUpperCase(name.charAt(0));
  }

  public static boolean attributeTypesMatch(Attribute studentAttribute, Attribute instructorAttribute) {
    return studentAttribute.getType().getClass().equals(instructorAttribute.getType().getClass());
  }

  private static boolean spellingMistakeCheck(String name1, String name2) {
    int lDistance = levenshteinDistance(name1, name2);
    return lDistance > 0 && lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED;
  }

  /** Returns true if the student has made attribute not static but static is required. */
  public static boolean isAttributeExpectedStatic(Attribute studentAttribute, Attribute instructorAttribute) {
    return !studentAttribute.isStatic() && instructorAttribute.isStatic();
  }

  /** Returns true if the student has made attribute static but static is not required. */
  public static boolean isAttributeNotExpectedStatic(Attribute studentAttribute, Attribute instructorAttribute) {
    return studentAttribute.isStatic() && !instructorAttribute.isStatic();
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
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, COMPOSITION, REGULAR);
  }

  public static boolean isUsingAggregationInsteadOfAssociation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, AGGREGATION, REGULAR);
  }

  public static boolean isUsingAggregationInsteadOfComposition(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, AGGREGATION, COMPOSITION);
  }

  public static boolean isUsingCompositionInsteadOfAggregation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, COMPOSITION, AGGREGATION);
  }

  public static boolean isUsingDirectedInsteadOfUndirected(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return instructorClassAssocEnd.isNavigable() && !studentClassAssocEnd.isNavigable();
  }

  public static boolean isUsingUndirectedInsteadOfDirected(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return !instructorClassAssocEnd.isNavigable() && studentClassAssocEnd.isNavigable();
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
      AssociationEnd instructorClassAssocEnd, ReferenceType assocTypeS, ReferenceType assocTypeI) {
    return studentClassAssocEnd.getReferenceType().equals(assocTypeS)
        && instructorClassAssocEnd.getReferenceType().equals(assocTypeI);
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

  /** Returns true if association class is extra. */
  public static boolean isAssociationClassExtra(Association studentClassAssoc, Association instructorClassAssoc) {
    return studentClassAssoc.getAssociationClass() != null && instructorClassAssoc.getAssociationClass() == null;
  }

  /** Returns true if association class is missing. */
  public static boolean isAssociationClassMissing(Association studentClassAssoc, Association instructorClassAssoc) {
    return studentClassAssoc.getAssociationClass() == null && instructorClassAssoc.getAssociationClass() != null;
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
    List<NamedElement> studentElements = studentElement == null ? Collections.emptyList() : List.of(studentElement);
    List<NamedElement> instructorElements =
        instructorElement == null ? Collections.emptyList() : List.of(instructorElement);
    return createMistake(mistakeType, studentElements, instructorElements);
  }

  /**
   * Creates a new mistake from the input parameters.
   *
   * @param mistakeType
   * @param studentElements
   * @param instructorElements
   */
  private static Mistake createMistake(MistakeType mistakeType, List<? extends NamedElement> studentElements,
      List<? extends NamedElement> instructorElements) {
    var mistake = MAF.createMistakeOfType(mistakeType);
    if (studentElements != null) {
      studentElements.forEach(se -> {
        var solutionElement = SolutionElement.forCdmElement(se);
        mistake.getStudentElements().add(solutionElement);
      });
    }
    if (instructorElements != null) {
      instructorElements.forEach(ie -> {
        var solutionElement = SolutionElement.forCdmElement(ie);
        mistake.getInstructorElements().add(solutionElement);
      });
    }
    return mistake;
  }

  /** Overloaded method used for testing. */
  public static boolean checkCorrectTest(Classifier instructorClassifier, Classifier studentClassifier) {
    return checkCorrectTest(instructorClassifier, studentClassifier, new Comparison());
  }

  /**
   * This is a function created for testing the logic. Only for test.
   *
   * @param instructorClassifier
   * @param studentClassifier
   * @return
   */
  public static boolean checkCorrectTest(Classifier instructorClassifier, Classifier studentClassifier,
      Comparison comparison) {
    // clearAttributesAndClassifer();
    boolean isMapped = false;
    List<Attribute> instructorAttributes = instructorClassifier.getAttributes();
    List<Attribute> studentAttributes = studentClassifier.getAttributes();

    comparison.notMappedInstructorClassifiers.add(instructorClassifier);
    comparison.extraStudentClassifiers.add(studentClassifier);

    int totalAttibutes = instructorAttributes.size();
    int correctAttribute = 0;
    float lDistance = levenshteinDistance(studentClassifier.getName(), instructorClassifier.getName());
    if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      isMapped = true;
      comparison.mappedClassifiers.put(instructorClassifier, studentClassifier);
      comparison.notMappedInstructorClassifiers.remove(instructorClassifier);
      comparison.extraStudentClassifiers.remove(studentClassifier);
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
        comparison.mappedClassifiers.put(instructorClassifier, studentClassifier);
        comparison.notMappedInstructorClassifiers.remove(instructorClassifier);
        comparison.extraStudentClassifiers.remove(studentClassifier);

        isMapped = true;
      }
    }

    if (isMapped) { // Map attributes if classifiers map.
      boolean processed = false;
      for (Attribute instructorAttribute : instructorAttributes) { // To check association -> Not at present.
        comparison.notMappedInstructorAttributes.add(instructorAttribute);
        for (Attribute studentAttribute : studentAttributes) {
          if (!processed) { // To stop duplicate entries.
            comparison.extraStudentAttributes.add(studentAttribute);
          }
          lDistance = levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
          if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED
              && comparison.mappedAttributes.containsValue(studentAttribute)) {
            comparison.duplicateStudentAttributes.add(studentAttribute);
            comparison.extraStudentAttributes.remove(studentAttribute);
          } else if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
            comparison.mappedAttributes.put(instructorAttribute, studentAttribute);
            comparison.notMappedInstructorAttributes.remove(instructorAttribute);
            comparison.extraStudentAttributes.remove(studentAttribute);
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
      System.out.println(m.getMistakeType().getName() + " in " + m.getStudentElements().get(0).getElement().getName());
    }
  }

  private static MaxentTagger getMaxentTagger() {
    try {
      return new MaxentTagger(MistakeDetectionConfig.taggerPath);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}
