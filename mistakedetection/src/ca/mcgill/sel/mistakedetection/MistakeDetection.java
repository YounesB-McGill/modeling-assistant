package ca.mcgill.sel.mistakedetection;

import static ca.mcgill.sel.classdiagram.ReferenceType.AGGREGATION;
import static ca.mcgill.sel.classdiagram.ReferenceType.COMPOSITION;
import static ca.mcgill.sel.classdiagram.ReferenceType.REGULAR;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_CLASS_SHOULD_BE_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_SHOULD_BE_ENUM_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_SHOULD_BE_FULL_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ASSOC_SHOULD_BE_SUBCLASS_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ASSOC_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ENUM_ITEM_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ENUM_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ROLE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ASSOC_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.CLASS_SHOULD_BE_ENUM;
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
import static learningcorpus.mistaketypes.MistakeTypes.FULL_PR_PATTERN_SHOULD_BE_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.FULL_PR_PATTERN_SHOULD_BE_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.FULL_PR_PATTERN_SHOULD_BE_SUBCLASS;
import static learningcorpus.mistaketypes.MistakeTypes.INCOMPLETE_AO_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.INCOMPLETE_CONTAINMENT_TREE;
import static learningcorpus.mistaketypes.MistakeTypes.INCOMPLETE_PR_PATTERN;
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
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ROLE_NAMES;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.REPRESENTING_ACTION_WITH_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.SIMILAR_ATTRIBUTE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.SOFTWARE_ENGINEERING_TERM;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_ASSOC_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_ENUM_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.SUBCLASS_SHOULD_BE_FULL_PR_PATTERN;
import static learningcorpus.mistaketypes.MistakeTypes.UPPERCASE_ATTRIBUTE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_INSTEAD_OF_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ASSOC_INSTEAD_OF_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ASSOC_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_ASSOC;
import static learningcorpus.mistaketypes.MistakeTypes.USING_DIRECTED_ASSOC_INSTEAD_OF_UNDIRECTED;
import static learningcorpus.mistaketypes.MistakeTypes.USING_UNDIRECTED_ASSOC_INSTEAD_OF_DIRECTED;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ROLE_NAME;
import static modelingassistant.TagType.ABSTRACTION;
import static modelingassistant.TagType.OCCURRENCE;
import static modelingassistant.TagType.PLAYER;
import static modelingassistant.TagType.ROLE;
import static modelingassistant.util.ClassDiagramUtils.getAssociationsFromClassDiagram;
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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.Attribute;
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

/**
 * This is the main class of Mistake Detection System. This class contains functions that maps and find mistakes in the
 * elements of the two solutions passed to it. 'compare()' is the function to call to check mistakes in two solutions.
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
  static Map<String, Boolean> nounPluralStatus = new HashMap<String, Boolean>();

  /** Cache to map verbs to true if they are verb, false otherwise. */
  static Map<String, Boolean> verbStatus = new HashMap<String, Boolean>();

  /** The Stanford NLP Maximum Entropy Part-of-Speech Tagger. */
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
      EList<Attribute> instructorAttributes = instructorClassifier.getAttributes();
      comparison.notMappedInstructorAttribute.addAll(instructorAttributes);
      instructorClassifier.getAssociationEnds().forEach(assoc -> {
        if (!comparison.notMappedInstructorAssociation.contains(assoc.getAssoc())) {
          comparison.notMappedInstructorAssociation.add(assoc.getAssoc());
        }
      });
      Classifier possibleClassifierMatch = null;
      int priority = 0;
      for (Classifier studentClassifier : studentClassifiers) {
        if (!processed) { // To stop duplicate entries.
          comparison.extraStudentClassifier.add(studentClassifier);
          EList<Attribute> studentAttributes = studentClassifier.getAttributes();
          comparison.extraStudentAttribute.addAll(studentAttributes);
          studentClassifier.getAssociationEnds().forEach((assoc) -> {
            if (!comparison.extraStudentAssociation.contains(assoc.getAssoc())) {
              comparison.extraStudentAssociation.add(assoc.getAssoc());
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
      if (priority == MID_PRIORITY) {
        checkMistakeClassSpelling(possibleClassifierMatch, instructorClassifier).ifPresent(comparison.newMistakes::add);
      }
      if (possibleClassifierMatch == null) {
        continue;
      }

      Classifier classToRemove = null;
      if (priority == HIGH_PRIORITY && comparison.mappedClassifier.containsValue(possibleClassifierMatch)) {
        classToRemove = getKey(comparison.mappedClassifier, possibleClassifierMatch);
        comparison.mappedClassifier.remove(classToRemove);
        comparison.notMappedInstructorClassifier.add(classToRemove);
        comparison.extraStudentClassifier.add(possibleClassifierMatch);
      }

      mapClasses(comparison, possibleClassifierMatch, instructorClassifier);
      checkMistakesInClassifier(possibleClassifierMatch, instructorClassifier, newMistakes);

      EList<Attribute> studentAttributes = possibleClassifierMatch.getAttributes();
      for (Attribute instructorAttribute : instructorAttributes) {
        var mappedStudentAttribute = comparison.mappedAttribute.get(instructorAttribute);
        for (Attribute studentAttribute : studentAttributes) {
          float lDistance = levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
          if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
            if (mappedStudentAttribute == studentAttribute) {
              comparison.duplicateStudentAttribute.add(studentAttribute);
              comparison.extraStudentAttribute.remove(studentAttribute);
            } else {
              mapAttributes(comparison, studentAttribute, instructorAttribute);
              checkMistakesInAttributes(studentAttribute, instructorAttribute, comparison.newMistakes);
              break;
            }
          }
        }
      }
    }

    mapClassAndAttribBasedOnAttribsAssocAndAssocEnds(comparison);
    mapRelations(comparison);
    mapEnumerations(instructorSolution, studentSolution, comparison);
    mapPatterns(instructorSolution, studentSolution, comparison);
    checkMistakesAfterMapping(comparison); // TO BE Discussed
    checkMistakeMissingClass(comparison);
    checkMistakeExtraClass(comparison);
    // checkMistakeDuplicateAttributes();
    checkMistakeExtraAttribute(comparison);
    checkMistakeMissingAttribute(comparison);
    checkMistakeMissingExtraEnum(comparison);
    // checkMistakeWrongAttribute();
    // checkMistakeAttributeMisplaced();
    checkMistakeIncompleteContainmentTree(comparison, studentSolution.getClassDiagram());
    checkMistakeMissingAssociationCompositionAggregation(comparison);
    checkMistakeExtraAssociationCompositionAggregation(comparison);

    updateMistakes(instructorSolution, studentSolution, comparison);
    return comparison;
  }

  private static void checkMistakeIncompleteContainmentTree(Comparison comparison, ClassDiagram classDiagram) {

    var studentClassifiers = classDiagram.getClasses();
    if (studentClassifiers.size() < 2) {
      return;
    }
    Map<Classifier, Integer> classCompositionCount = new HashMap<Classifier, Integer>();
    EList<NamedElement> notComposedClasses = new BasicEList<NamedElement>();
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
            getAssociationsFromClassDiagram(studClass, getOtherAssocEnd(assocEnd).getClassifier(), classDiagram);
        if (includesComposition(associations) && composedClasses.contains(getOtherAssocEnd(assocEnd).getClassifier())) {
          composedClasses.add(studClass);
        }
      }
    }
    if (!composedClasses.containsAll(studentClassifiers)) {
      composedClasses.forEach(notComposedClasses::remove);
      EList<NamedElement> notComposedClassesToRemove = new BasicEList<NamedElement>();
      for (NamedElement cls : notComposedClasses) {
        Classifier studClass = (Classifier) cls;
        if (!studClass.getSuperTypes().isEmpty()) {
          for (Classifier c : studClass.getSuperTypes()) {
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
    EList<NamedElement> studClasses = new BasicEList<NamedElement>();
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
    boolean processed = false;
    for (Type instElementType : instructorClassDiagram.getTypes()) {
      if (instElementType instanceof CDEnum) {
        CDEnum instEnumClass = (CDEnum) instElementType;
        comparison.notMappedInstructorEnum.add(instEnumClass);
        comparison.notMappedInstructorEnumLiterals.addAll(instEnumClass.getLiterals());
      }
      for (Type studElementType : studentClassDiagram.getTypes()) {
        if (studElementType instanceof CDEnum && !processed) {
          CDEnum studEnumClass = (CDEnum) studElementType;
          comparison.extraStudentEnum.add(studEnumClass);
          comparison.extraStudentEnumLiterals.addAll(studEnumClass.getLiterals());
        }
      }
      processed = true;
    }
    comparison.mappedAttribute.forEach((key, value) -> {
      if (!(key.getType() instanceof CDEnum && value.getType() instanceof CDEnum)) {
        return;
      }
      CDEnum instEnum = getEnumFromClassDiagram(key.getType().getName(), instructorClassDiagram);
      CDEnum studEnum = getEnumFromClassDiagram(value.getType().getName(), studentClassDiagram);
      if (instEnum == null && studEnum == null) {
        return;
      }
      comparison.mappedEnumeration.put(instEnum, studEnum);
      comparison.notMappedInstructorEnum.remove(instEnum);
      comparison.extraStudentEnum.remove(studEnum);
      checkMistakeBadEnumNameSpelling(studEnum, instEnum).ifPresent(comparison.newMistakes::add);

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
    });
  }

  private static void checkMistakesInAttributes(Attribute studentAttribute, Attribute instructorAttribute,
      EList<Mistake> newMistakes) {
    checkMistakeWrongAttributeType(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
    checkMistakeAttributeExpectedStatic(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
    checkMistakeAttributeNotExpectedStatic(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
    checkMistakeAttributeSpelling(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
    checkMistakePluralAttribName(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
    checkMistakeUppercaseAttribName(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
  }

  private static void checkMistakesInClassifier(Classifier studentClassifier, Classifier instructorClassifier,
      EList<Mistake> newMistakes) {

    checkMistakeSoftwareEngineeringTerm(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
    checkMistakePluralClassName(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
    checkMistakeLowerClassName(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
    checkMistakeRegularBeEnumerationClass(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
    checkMistakeEnumerationBeRegularClass(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
    checkMistakeIncorrectClassNameButCorrectAttribRel(studentClassifier, instructorClassifier)
        .ifPresent(newMistakes::add);
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
    EList<NamedElement> totalMatchesExpected = new BasicEList<NamedElement>();
    int matchedElements = 0;
    for (Tag tag : tg.getTags()) {
      if (comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
        if (tag.getTagType().equals(ABSTRACTION)
            && comparison.mappedClassifier.get(tag.getSolutionElement().getElement()).isAbstract()
            || tag.getTagType().equals(OCCURRENCE)) {
          matchedElements++;
        }
      }
      totalMatchesExpected.add(tag.getSolutionElement().getElement());
    }
    if (matchedElements == 0 && !totalMatchesExpected.isEmpty()) {
      comparison.newMistakes.add(createMistake(MISSING_AO_PATTERN, null, totalMatchesExpected));
    } else if (matchedElements != 0 && totalMatchesExpected.size() != matchedElements) {
      createMistakeIncompleteAOPattern(tg, comparison);
    }
  }

  private static void checkStudentEnumPattern(TagGroup tg, Comparison comparison, String instPattern,
      Solution studentSolution) {
    int totalMatchesExpected = 1;
    int totalMatched = 0;
    EList<NamedElement> studentMatchedElements = new BasicEList<NamedElement>();
    Classifier studentPlayerClass = null;
    for (Tag tag : tg.getTags()) {
      if (tag.getTagType().equals(PLAYER)
          && comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
        studentPlayerClass = comparison.mappedClassifier.get(tag.getSolutionElement().getElement());
        totalMatched += 1;
        studentMatchedElements.add(studentPlayerClass);
      } else if (tag.getTagType().equals(ROLE)
          && comparison.mappedAttribute.containsKey(tag.getSolutionElement().getElement())) {
        Attribute attrib = (Attribute) tag.getSolutionElement().getElement();
        studentMatchedElements.add(comparison.mappedAttribute.get(attrib));
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
      createMistakeIncompletePRPattern(tg, comparison);
      return;
    } else if (MIN_PR_MATCH_REQIUIRED < totalMatched && studentPlayerClass != null) {
      createMistakeIncompletePRPattern(tg, comparison);
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
    EList<String> studentRoleAssocEnd = new BasicEList<String>();
    EList<NamedElement> studentMatchedElements = new BasicEList<NamedElement>();
    Classifier studentPlayerClass = null;
    for (Tag tag : tg.getTags()) {
      if (tag.getTagType().equals(PLAYER)
          && comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
        studentPlayerClass = comparison.mappedClassifier.get(tag.getSolutionElement().getElement());
        totalMatched += 1;
        studentMatchedElements.add(studentPlayerClass);
      } else {
        if (tag.getSolutionElement().getElement() instanceof AssociationEnd) {
          AssociationEnd assocEnd = (AssociationEnd) tag.getSolutionElement().getElement();
          if (comparison.mappedAssociation.containsKey(assocEnd.getAssoc())) {
            studentRoleAssocEnd.add(assocEnd.getName());
            totalMatched += 1;
            studentMatchedElements.add(assocEnd);
          }
        }
      }
    }
    if (totalMatched == totalMatcheExpected) {
      if (!assocPatternCorrect(studentPlayerClass, studentRoleAssocEnd)) {
        createMistakeIncompletePRPattern(tg, comparison);
        return;
      } else {
        return;
      }
    } else if (MIN_PR_MATCH_REQIUIRED < totalMatched && studentPlayerClass != null) {
      createMistakeIncompletePRPattern(tg, comparison);
      return;
    }
    if (studentPlayerClass != null) {
      checkOtherPattern(tg, comparison, instPattern, studentSolution);
    }
  }

  /**
   * Checks if associations are linked to player class.
   */
  private static boolean assocPatternCorrect(Classifier studentPlayerClass, EList<String> studentRoleAssocEnd) {
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
    EList<Classifier> studentRoleClasses = new BasicEList<Classifier>();
    EList<NamedElement> studentMatchedElements = new BasicEList<NamedElement>();
    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    Classifier studentPlayerClass = null;
    Classifier studentAbstractClass = null;
    EList<String> mappedClassifierNames = new BasicEList<String>();
    mappedClassifierNames = getMappedNames(comparison.mappedClassifier);
    for (Tag tag : tg.getTags()) {
      instElements.add(tag.getSolutionElement().getElement());
      if (comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
        if (tag.getTagType().equals(PLAYER)) {
          studentPlayerClass = comparison.mappedClassifier.get(tag.getSolutionElement().getElement());
        } else {
          studentRoleClasses.add(comparison.mappedClassifier.get(tag.getSolutionElement().getElement()));
        }
        if (mappedClassifierNames.contains(tag.getSolutionElement().getElement().getName())) {
          totalMatched += 1;
        }
        studentMatchedElements.add(comparison.mappedClassifier.get(tag.getSolutionElement().getElement()));
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
        createMistakeIncompletePRPattern(tg, comparison);
        return;
      }
      if (!subClassPatternCorrect(studentAbstractClass, studentRoleClasses)) {
        createMistakeIncompletePRPattern(tg, comparison);
        return;
      } else {
        if (!assocExists(studentPlayerClass, studentAbstractClass)) {
          createMistakeIncompletePRPattern(tg, comparison);
        } else {
          return;
        }
      }
    } else if (MIN_PR_MATCH_REQIUIRED <= totalMatched && studentPlayerClass != null && isStudentClassAbstract) {
      createMistakeIncompletePRPattern(tg, comparison);
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
    EList<Classifier> studentRoleClasses = new BasicEList<Classifier>();
    EList<NamedElement> studentMatchedElements = new BasicEList<NamedElement>();
    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    Classifier studentPlayerClass = null;
    EList<String> mappedClassifierNames = new BasicEList<String>();
    mappedClassifierNames = getMappedNames(comparison.mappedClassifier);
    for (Tag tag : tg.getTags()) {
      instElements.add(tag.getSolutionElement().getElement());
      if (comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
        if (tag.getTagType().equals(PLAYER)) {
          studentPlayerClass = comparison.mappedClassifier.get(tag.getSolutionElement().getElement());
        } else {
          studentRoleClasses.add(comparison.mappedClassifier.get(tag.getSolutionElement().getElement()));
        }
        if (mappedClassifierNames.contains(tag.getSolutionElement().getElement().getName())) {
          totalMatched += 1;
        }
        studentMatchedElements.add(comparison.mappedClassifier.get(tag.getSolutionElement().getElement()));
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
        createMistakeIncompletePRPattern(tg, comparison);
        return;
      } else {
        return;
      }
    } else if (MIN_PR_MATCH_REQIUIRED <= totalMatched && studentPlayerClass != null && !studentClassAbstract) {
      createMistakeIncompletePRPattern(tg, comparison);
      return;
    }
    if (studentPlayerClass != null) {
      checkOtherPattern(tg, comparison, instPattern, studentSolution);
    }
  }

  /**
   * Returns true if at least one of the given elements is an abstract classifier.
   */
  private static boolean isAnyClassAbstract(EList<NamedElement> elements) {
    return elements.stream().filter(Classifier.class::isInstance).map(Classifier.class::cast)
        .anyMatch(Classifier::isAbstract);
  }

  private static EList<String> getMappedNames(Map<Classifier, Classifier> mappedClassifier) {
    EList<String> tempList = new BasicEList<String>();
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
    EList<Classifier> studRoleClass = new BasicEList<Classifier>();
    EList<String> studRoleAssocEndName = new BasicEList<String>();
    EList<String> instEnumLiterals = new BasicEList<String>();
    EList<NamedElement> instElements = new BasicEList<NamedElement>();
    EList<NamedElement> studEnumElements = new BasicEList<NamedElement>();
    EList<NamedElement> studAssocElements = new BasicEList<NamedElement>();
    EList<NamedElement> studFullElements = new BasicEList<NamedElement>();
    EList<NamedElement> studSubclassElements = new BasicEList<NamedElement>();
    EList<CDEnum> studSolutionEnums = new BasicEList<CDEnum>();
    EList<CDEnumLiteral> studSolutionEnumLiterals = new BasicEList<CDEnumLiteral>();

    for (Type ty : studentClassDiagram.getTypes()) {
      if (ty instanceof CDEnum) {
        studSolutionEnums.add((CDEnum) ty);
        studSolutionEnumLiterals.addAll(((CDEnum) ty).getLiterals());
      }
    }

    for (Tag tag : tg.getTags()) {
      instElements.add(tag.getSolutionElement().getElement());
      if (tag.getTagType().equals(PLAYER)) {
        if (comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
          studPlayerClass = comparison.mappedClassifier.get(tag.getSolutionElement().getElement());
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
            if (!comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
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
      studAssocElements.add(studPlayerClass);
      studEnumElements.add(studPlayerClass);
      studFullElements.add(studPlayerClass);
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

  private static boolean subClassPatternCorrect(Classifier studentPlayerClass, EList<Classifier> studentRoleClasses) {
    return studentRoleClasses.stream().allMatch(rc -> rc.getSuperTypes().contains(studentPlayerClass));
  }

  /**
   * Returns the pattern detected in the instructor solution.
   */
  public static String checkPRPattern(TagGroup tg) {
    SolutionElement playerSolutionElement = null;
    List<SolutionElement> roleSolutionElements = new BasicEList<SolutionElement>();
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

  /**
   * Returns true if an association exists between two classes in a solution.
   */
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

  /**
   * Maps associations for mapped classes
   */
  private static void mapRelations(Comparison comparison) {
    comparison.mappedClassifier.forEach((key, value) -> compareAssocation(key, value, comparison));
    checkAssociationClassMappingWithNonAssociationClass(comparison);
    comparison.assocClassifiersToRemove.forEach(c -> comparison.mappedClassifier.remove(c));
    comparison.assocClassMappingToAdd.forEach((key, value) -> {
      comparison.mappedClassifier.put(key, value);
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
      Map<Association, EList<AssociationEnd>> possibleAssocMatch = new HashMap<Association, EList<AssociationEnd>>();
      for (AssociationEnd studentClassifierAssocEnd : studentClassifierAssocEnds) {
        var studentClassifierAssoc = studentClassifierAssocEnd.getAssoc();
        var otherStudentClassifierAssocEnd = getOtherAssocEnd(studentClassifierAssocEnd);

        var otherStudentClassifier = otherStudentClassifierAssocEnd.getClassifier();

        if (comparison.mappedClassifier.get(otherInstructorClassifier) == null
            || comparison.mappedAssociation.containsKey(instructorClassifierAssoc)
            || comparison.mappedAssociation.containsValue(studentClassifierAssoc)) {
          continue;
        }

        if (comparison.mappedClassifier.get(otherInstructorClassifier).equals(otherStudentClassifier)) {
          EList<AssociationEnd> matchedAssocEnds = new BasicEList<AssociationEnd>();
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

  private static AssociationEnd getOtherAssocEnd(AssociationEnd assocEnd) {
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

    checkAssociationClassMapping(comparison, studentClassifierAssoc, instructorClassifierAssoc);

    if (!checkStudentElementForMistake(comparison.newMistakes, studentClassifierAssoc)) {
      checkMistakeExtraAssociationClass(studentClassifierAssoc, instructorClassifierAssoc, comparison.newMistakes);

      if (studentClassifierAssoc.getAssociationClass() != null
          && instructorClassifierAssoc.getAssociationClass() != null) {
        checkMistakeBadAssociationClassNameSpelling(studentClassifierAssoc, instructorClassifierAssoc)
            .ifPresent(comparison.newMistakes::add);
        checkMistakeSimilarYetIncorrectAssociationClassName(studentClassifierAssoc, instructorClassifierAssoc)
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

  private static void removeMistakesRelatedToElement(Classifier cls, EList<Mistake> newMistakes) {
    newMistakes.removeAll(mistakeForElement(cls, newMistakes));
  }

  private static void checkAssociationClassMapping(Comparison comparison, Association studentClassifierAssoc,
      Association instructorClassifierAssoc) {
    if (studentClassifierAssoc.getAssociationClass() != null
        && instructorClassifierAssoc.getAssociationClass() != null) {
      Classifier studAssocClass = studentClassifierAssoc.getAssociationClass();
      Classifier instAssocClass = instructorClassifierAssoc.getAssociationClass();
      if (!comparison.mappedClassifier.containsKey(instAssocClass)) {
        comparison.assocClassMappingToAdd.put(instAssocClass, studAssocClass);
        return;
      }
      if (!comparison.mappedClassifier.get(instAssocClass).equals(studAssocClass)) {
        comparison.extraStudentClassifier.add(comparison.mappedClassifier.get(instAssocClass));
        comparison.mappedClassifier.put(instAssocClass, studAssocClass);
        comparison.extraStudentClassifier.remove(studAssocClass);
      }
    }
    if (studentClassifierAssoc.getAssociationClass() == null
        && instructorClassifierAssoc.getAssociationClass() != null) {
      Classifier instAssocClass = instructorClassifierAssoc.getAssociationClass();
      if (comparison.mappedClassifier.containsKey(instAssocClass)) {
        comparison.newMistakes.add(createMistake(CLASS_SHOULD_BE_ASSOC_CLASS,
            comparison.mappedClassifier.get(instAssocClass), instAssocClass));
        comparison.extraStudentClassifier.add(comparison.mappedClassifier.get(instAssocClass));
        comparison.notMappedInstructorClassifier.add(instAssocClass);
        comparison.assocClassifiersToRemove.add(instAssocClass);
      }
    }
    if (studentClassifierAssoc.getAssociationClass() != null
        && instructorClassifierAssoc.getAssociationClass() == null) {
      Classifier studAssocClass = studentClassifierAssoc.getAssociationClass();
      if (comparison.mappedClassifier.containsValue(studAssocClass)) {
        comparison.extraStudentClassifier.add(studAssocClass);
        comparison.mappedClassifier.forEach((key, value) -> {
          if (value.equals(studAssocClass)) {
            comparison.notMappedInstructorClassifier.add(key);
            comparison.assocClassifiersToRemove.add(key);
            comparison.newMistakes.add(createMistake(ASSOC_CLASS_SHOULD_BE_CLASS, studAssocClass, key));
            return;
          }
        });
      }
    }
  }

  private static void checkAssociationClassMappingWithNonAssociationClass(Comparison comparison) {
    for (Association instAssoc : comparison.notMappedInstructorAssociation) {
      if (instAssoc.getAssociationClass() != null
          && comparison.mappedClassifier.containsKey(instAssoc.getAssociationClass())) {
        Classifier instAssocClass = instAssoc.getAssociationClass();
        comparison.extraStudentClassifier.add(comparison.mappedClassifier.get(instAssocClass));
        comparison.notMappedInstructorClassifier.add(instAssocClass);
        comparison.assocClassifiersToRemove.add(instAssocClass);
      }
    }

  }

  private static void mapAssociation(Comparison comparison, Association instructorClassifierAssoc,
      Association studentClassifierAssoc) {
    comparison.mappedAssociation.put(instructorClassifierAssoc, studentClassifierAssoc);
    comparison.notMappedInstructorAssociation.remove(instructorClassifierAssoc);
    comparison.extraStudentAssociation.remove(studentClassifierAssoc);
  }

  private static EList<Object> getMatchedAssoc(Map<Association, EList<AssociationEnd>> possibleAssocMatch) {
    EList<Object> seekedAssocAndEnds = new BasicEList<Object>();
    // use linked hash map to preserve insertion order
    Map<Association, Double> assocScoreMap = new LinkedHashMap<Association, Double>();
    for (Map.Entry<Association, EList<AssociationEnd>> entry : possibleAssocMatch.entrySet()) {
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
    for (Map.Entry<Association, EList<AssociationEnd>> entry : possibleAssocMatch.entrySet()) {
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
    checkMistakeUsingAssociationInsteadOfComposition(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeUsingAssociationInsteadOfAggregation(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeUsingCompositionInsteadOfAssociation(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeUsingAggregationInsteadOfAssociation(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeUsingAggregationInsteadOfComposition(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeUsingCompositionInsteadOfAggregation(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeUsingDirectedInsteadOfUndirected(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeUsingUndirectedInsteadOfDirected(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeRepresentingActionWithAssoc(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeOtherWrongMultiplicity(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeMissingRoleName(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeRoleNameExpectedStactic(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeRoleNameNotExpectedStactic(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeRoleNamePresentButIncorrect(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    // checkMistakeRoleNameSimilarYetIncorrect(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
    checkMistakeBadRoleNameSpelling(studentClassAssocEnd, instructorClassAssocEnd).ifPresent(addMist);
  }

  /** Finds Mistakes in newly mapped elements */
  private static void checkMistakesAfterMapping(Comparison comparison) { // TO BE Discussed
    var newMistakes = comparison.newMistakes;
    // TOOD work in progress(Location may be changed)
    // To map attribute like ticketNo with TicketNumber
    comparison.mappedClassifier.forEach((key, value) -> {
      for (Attribute instAttrib : key.getAttributes()) {
        for (Attribute studAttrib : value.getAttributes()) {
          if (!comparison.mappedAttribute.containsKey(instAttrib)) {
            if (studAttrib.getName().contains("ies")) { // TO deal with cases like companies and company
              String name = studAttrib.getName();
              name = name.replaceAll("ies", "y");
              if (name.equals(instAttrib.getName())) {
                comparison.mappedAttribute.put(instAttrib, studAttrib);
                comparison.notMappedInstructorAttribute.remove(instAttrib);
                comparison.extraStudentAttribute.remove(studAttrib);
                checkMistakePluralAttribName(studAttrib, instAttrib).ifPresent(comparison.newMistakes::add);
              }
              break;
            }
            String[] attribNameSunStrings = studAttrib.getName().split("(?=\\p{Upper})");
            for (String subString : attribNameSunStrings) {
              if (instAttrib.getName().contains(subString)) {
                comparison.mappedAttribute.put(instAttrib, studAttrib);
                comparison.notMappedInstructorAttribute.remove(instAttrib);
                comparison.extraStudentAttribute.remove(studAttrib);
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
  private static void updateMistakes(Solution instructorSolution, Solution studentSolution, Comparison comparison) {
    final Consumer<? super Mistake> setSolutionForElems = m -> {
      m.getInstructorElements().forEach(ie -> ie.setSolution(instructorSolution));
      m.getStudentElements().forEach(se -> se.setSolution(studentSolution));
    };

    // List containing mistakes associated with a student Solution
    var existingMistakes = studentSolution.getMistakes();
    var newMistakes = comparison.newMistakes;
    existingMistakes.forEach(setSolutionForElems);
    newMistakes.forEach(setSolutionForElems);

    // List containing existing mistakes that are equal to newMistakes
    EList<Mistake> existingMistakesProcessed = new BasicEList<Mistake>();
    // List containing new mistakes that are already present in a solution (i.e existingMistakes)
    EList<Mistake> newMistakesProcessed = new BasicEList<Mistake>();

    // Condition when only new mistakes exists.
    if (existingMistakes.size() == 0 && newMistakes.size() != 0) {
      updateNewMistakes(newMistakes, studentSolution);
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
      EList<Mistake> newUnProcessedMistakes = new BasicEList<Mistake>();
      newUnProcessedMistakes.addAll(newMistakes);
      newUnProcessedMistakes.removeAll(newMistakesProcessed);
      updateNewMistakes(newUnProcessedMistakes, studentSolution);
      for (int i = 0; i < existingMistakes.size(); i++) {
        if (!existingMistakesProcessed.contains(existingMistakes.get(i))) {
          if (existingMistakes.get(i).getNumSinceResolved() <= MAX_DETECTIONS_AFTER_RESOLUTION
              && existingMistakes.get(i).isResolved()) {
            existingMistakes.get(i).setResolved(true);
            existingMistakes.get(i).setNumSinceResolved(existingMistakes.get(i).getNumSinceResolved() + 1);
          } else {
            existingMistakes.get(i).setSolution(null);
            existingMistakes.get(i).getInstructorElements().clear();
            existingMistakes.get(i).getStudentElements().clear();
          }
        }
      }
    } else if (existingMistakes.size() != 0 && newMistakes.size() == 0) {
      for (Mistake existingMistake : existingMistakes) {
        if (existingMistake.getNumSinceResolved() <= MAX_DETECTIONS_AFTER_RESOLUTION) {
          existingMistake.setResolved(true);
          existingMistake.setNumSinceResolved(existingMistake.getNumSinceResolved() + 1);
        } else {
          existingMistake.setSolution(null);
          existingMistake.getInstructorElements().clear();
          existingMistake.getStudentElements().clear();
        }
      }
    }
  }

  private static void updateNewMistakes(EList<Mistake> newMistakes, Solution studentSolution) {

    var patternMistakeTypes =
        List.of(ASSOC_SHOULD_BE_ENUM_PR_PATTERN, ASSOC_SHOULD_BE_FULL_PR_PATTERN, ASSOC_SHOULD_BE_SUBCLASS_PR_PATTERN,
            ENUM_SHOULD_BE_ASSOC_PR_PATTERN, ENUM_SHOULD_BE_FULL_PR_PATTERN, ENUM_SHOULD_BE_SUBCLASS_PR_PATTERN,
            FULL_PR_PATTERN_SHOULD_BE_ASSOC, FULL_PR_PATTERN_SHOULD_BE_ENUM, FULL_PR_PATTERN_SHOULD_BE_SUBCLASS,
            SUBCLASS_SHOULD_BE_ASSOC_PR_PATTERN, SUBCLASS_SHOULD_BE_FULL_PR_PATTERN, INCOMPLETE_PR_PATTERN);
    EList<MistakeType> containmentMistakeTypes = new BasicEList<MistakeType>();
    containmentMistakeTypes
        .addAll(List.of(INCOMPLETE_CONTAINMENT_TREE, COMPOSED_PART_CONTAINED_IN_MORE_THAN_ONE_PARENT));

    if (mistakesInvolvePattern(newMistakes, patternMistakeTypes)) {
      updateMistakesInvolvingPattern(newMistakes, patternMistakeTypes, studentSolution);
    } // TODO ADD For containment Mistake
    else {
      for (Mistake newMistake : newMistakes) {
        setMistakeProperties(newMistake, false, 1, 0);
        newMistake.setSolution(studentSolution);
      }
    }
  }

  /** Returns student solution elements for a pattern. */
  private static EList<NamedElement> getPatternStudentElements(EList<Mistake> newMistakes,
      List<MistakeType> patternMistakeTypes) {
    EList<NamedElement> patternSolutionElements = new BasicEList<NamedElement>();
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
  private static boolean mistakesInvolvePattern(EList<Mistake> newMistakes, List<MistakeType> patternMistakeTypes) {
    return newMistakes.stream().anyMatch(m -> patternMistakeTypes.contains(m.getMistakeType()));
  }

  private static void updateMistakesInvolvingPattern(EList<Mistake> newMistakes, List<MistakeType> patternMistakeTypes,
      Solution studentSolution) {
    EList<Mistake> newMistakesToRemove = new BasicEList<Mistake>();
    var patternStudentElement = getPatternStudentElements(newMistakes, patternMistakeTypes);
    for (Mistake newMistake : newMistakes) {
      if (!newMistake.getStudentElements().isEmpty() && !patternMistakeTypes.contains(newMistake.getMistakeType())
          && patternStudentElement.contains(newMistake.getStudentElements().get(0).getElement())) {
        newMistakesToRemove.add(newMistake);
        continue;
      }
      setMistakeProperties(newMistake, false, 1, 0);
      newMistake.setSolution(studentSolution);
    }
    newMistakes.removeAll(newMistakesToRemove);
  }

  // TODO IN Progress
  private static void updateMistakesInvolvingContainment(EList<Mistake> newMistakes,
      EList<MistakeType> containmentMistakeTypes, Solution studentSolution) {
    EList<Mistake> newMistakesToRemove = new BasicEList<Mistake>();
    var containmentStudentElement = getPatternStudentElements(newMistakes, containmentMistakeTypes);
    for (Mistake newMistake : newMistakes) {
      if (!newMistake.getStudentElements().isEmpty() && !containmentMistakeTypes.contains(newMistake.getMistakeType())
          && containmentStudentElement.contains(newMistake.getStudentElements().get(0).getElement())) {
        newMistakesToRemove.add(newMistake);
        continue;
      }
      setMistakeProperties(newMistake, false, 1, 0);
      newMistake.setSolution(studentSolution);
    }
    System.out.println("Removed");
    newMistakesToRemove.forEach(key -> {
      System.out.println(key.getMistakeType());
    });
    newMistakes.removeAll(newMistakesToRemove);
  }

  /**
   * Updates the student elemenets of an existing mistake.
   *
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
   * Function returns true if both elements are equal
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

  /** Map classes with levenshtein distance less than or eqauls to MAX_LEVENSHTEIN_DISTANCE_ALLOWED */
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
    if (comparison.notMappedInstructorClassifier.isEmpty() || comparison.extraStudentClassifier.isEmpty()) {
      return;
    }
    int counter = 1;
    int MAX_ATTRIBUTE_ALLOWED = 2;
    for (int i = 0; i < counter; i++) {
      for (int j = 0; j < comparison.notMappedInstructorClassifier.size(); j++) {
        Classifier instructorClassifier = comparison.notMappedInstructorClassifier.get(j);
        EList<Attribute> instructorAttributes = instructorClassifier.getAttributes();
        int totalAttributes = instructorAttributes.size();
        Map<Classifier, Double> possibleClassMatch = new LinkedHashMap<Classifier, Double>();
        HashMap<Classifier, Integer> possibleClassMatchWithNoAttribute = new HashMap<Classifier, Integer>();
        for (int k = 0; k < comparison.extraStudentClassifier.size(); k++) {
          Classifier studentClassifier = comparison.extraStudentClassifier.get(k);
          EList<Attribute> studentAttributes = studentClassifier.getAttributes();
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
          EList<Classifier> sortedClosestClasssifier = sortByValueClassifier(possibleClassMatchWithNoAttribute);
          Classifier possibleMatch =
              classWithOtherAssociationClassMatch(sortedClosestClasssifier, instructorClassifier);
          counter++;
          if (possibleMatch != null) {
            mapClasses(comparison, possibleMatch, instructorClassifier);
            checkMistakesInClassifier(possibleMatch, instructorClassifier, comparison.newMistakes);
          } else {
            Classifier sClass = classWithAssociationEndsMatch(sortedClosestClasssifier, instructorClassifier);
            mapClasses(comparison, sClass,
                instructorClassifier);
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
          EList<Attribute> studentAttributes = studentClassifier.getAttributes();
          for (Attribute instructorAttribute : instructorAttributes) { // To check association -> Not at present.
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

  /**
   * Returns true if nearest matching student class to the instructorClass exists.
   */
  private static boolean nearestMatchExists(Map<Classifier, Double> possibleClassMatch) {
    return !maxAttributeMatch(possibleClassMatch).isEmpty();
  }

  /**
   * Returns the nearest matching student class to the instructorClass.
   *
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

  /**
   * Returns the class with closest number of association ends with that of a instructor class.
   */
  private static Classifier classWithOtherAssociationClassMatch(List<Classifier> studentClasses,
      Classifier instructorClass) {
    List<String> instClassesName = new BasicEList<String>();
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
    List<Integer> assocClassMatchValueList = Arrays.asList(assocClassMatchValue);
    var closestAssocValue = findClosest(assocClassMatchValueList, instAssocEnds);
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

  /**
   * Returns the class with closest number of association ends with that of a instructor class.
   */
  private static Classifier classWithAssociationEndsMatch(List<Classifier> studentClasses, Classifier instructorClass) {
    int instAssocEnds = instructorClass.getAssociationEnds().size();
    Classifier seekedClassifier = null;
    List<Integer> assocEndValues = new BasicEList<Integer>();
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

  /**
   * Returns the classifiers with maximum number of matched attributes.
   */
  public static List<Classifier> maxAttributeMatch(Map<Classifier, Double> map) {
    Map.Entry<Classifier, Double> entryWithMaxValue = null;
    EList<Classifier> topMatchedElements = new BasicEList<Classifier>();
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

  /**
   * Returns the associations with maximum number of score.
   */
  public static List<Association> maxAssociationMatch(Map<Association, Double> map) {
    Map.Entry<Association, Double> entryWithMaxValue = null;
    EList<Association> topMatchedElements = new BasicEList<Association>();
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

  /**
   * Returns element closest to target in array.
   */
  public static int findClosest(List<Integer> assocEndValues, int target) {
    HashMap<Integer, Integer> closestNumbDiffMap = new HashMap<Integer, Integer>();
    assocEndValues.forEach(value -> {
      int diff = target - value;
      closestNumbDiffMap.put(value, Math.abs(diff));
    });
    Map<Integer, Integer> sortedClosestNumbDiffMap = sortByValue(closestNumbDiffMap);
    return sortedClosestNumbDiffMap.keySet().stream().findFirst().get();
  }

  /**
   * Sorts hash map by values.
   */
  public static Map<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
    // Create a list from elements of HashMap
    List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
    // Sort the list
    Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
    // Put data from sorted list to hash map
    Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
    for (var entry : list) {
      result.put(entry.getKey(), entry.getValue());
    }
    return result;
  }

  /**
   * Sorts hash map by values.
   */
  public static EList<Classifier> sortByValueClassifier(HashMap<Classifier, Integer> hm) {
    // Create a list from elements of HashMap
    List<Map.Entry<Classifier, Integer>> list = new LinkedList<Map.Entry<Classifier, Integer>>(hm.entrySet());
    // Sort the list
    Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
    // Put data from sorted list to hash map
    EList<Classifier> result = new BasicEList<Classifier>();
    for (var entry : list) {
      result.add(entry.getKey());
    }
    return result;
  }

  public static void mapAttributes(Comparison comparison, Attribute studentAttribute, Attribute instructorAttribute) {
    comparison.mappedAttribute.put(instructorAttribute, studentAttribute);
    comparison.notMappedInstructorAttribute.remove(instructorAttribute);
    comparison.extraStudentAttribute.remove(studentAttribute);
  }

  public static void mapClasses(Comparison comparison, Classifier studentClass, Classifier instructorClass) {
    if (comparison.mappedClassifier.containsValue(studentClass)) {
      return;
    }
    comparison.mappedClassifier.put(instructorClass, studentClass);
    comparison.notMappedInstructorClassifier.remove(instructorClass);
    comparison.extraStudentClassifier.remove(studentClass);
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
    if (!isPlural(studentAttribute.getName()) && spellingMistakeCheck(studentAttribute.getName().toLowerCase(),
        instructorAttribute.getName().toLowerCase())) {
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
      return Optional.of(createMistake(ENUM_SHOULD_BE_CLASS, studentClass, instructorClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeRegularBeEnumerationClass(Classifier studentClass,
      Classifier instructorClass) {
    if (isClassRegularInsteadOfEnum(studentClass, instructorClass)) {
      return Optional.of(createMistake(CLASS_SHOULD_BE_ENUM, studentClass, instructorClass));
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

  public static Optional<Mistake> checkMistakeUsingAssociationInsteadOfComposition(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingAssociationInsteadOfComposition(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_ASSOC_INSTEAD_OF_COMPOSITION, studentClassAssocEnd,
          instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingAssociationInsteadOfAggregation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingAssociationInsteadOfAggregation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_ASSOC_INSTEAD_OF_AGGREGATION, studentClassAssocEnd,
          instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingCompositionInsteadOfAssociation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingCompositionInsteadOfAssociation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_COMPOSITION_INSTEAD_OF_ASSOC, studentClassAssocEnd,
          instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingAggregationInsteadOfAssociation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingAggregationInsteadOfAssociation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_AGGREGATION_INSTEAD_OF_ASSOC, studentClassAssocEnd,
          instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingAggregationInsteadOfComposition(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingAggregationInsteadOfComposition(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional
          .of(createMistake(USING_AGGREGATION_INSTEAD_OF_COMPOSITION, studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingCompositionInsteadOfAggregation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingCompositionInsteadOfAggregation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional
          .of(createMistake(USING_COMPOSITION_INSTEAD_OF_AGGREGATION, studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingDirectedInsteadOfUndirected(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingDirectedInsteadOfUndirected(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional
          .of(createMistake(USING_DIRECTED_ASSOC_INSTEAD_OF_UNDIRECTED, studentClassAssocEnd, instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingUndirectedInsteadOfDirected(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingUndirectedInsteadOfDirected(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional
          .of(createMistake(USING_UNDIRECTED_ASSOC_INSTEAD_OF_DIRECTED, studentClassAssocEnd, instructorClassAssocEnd));
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
    if (spellingMistakeCheck(studentEnum.getName(), instructorEnum.getName())) {
      return Optional.of(createMistake(BAD_ENUM_NAME_SPELLING, studentEnum, instructorEnum));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeBadEnumLiteralSpelling(CDEnumLiteral studentEnumLiteral,
      CDEnumLiteral instructorEnumLiteral) {
    if (spellingMistakeCheck(studentEnumLiteral.getName(), instructorEnumLiteral.getName())) {
      return Optional.of(createMistake(BAD_ENUM_ITEM_SPELLING, studentEnumLiteral, instructorEnumLiteral));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeRoleNamePresentButIncorrect(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    int lDistance = levenshteinDistance(studentClassAssocEnd.getName(), instructorClassAssocEnd.getName());
    if (lDistance > MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      return Optional.of(createMistake(WRONG_ROLE_NAME, studentClassAssocEnd, instructorClassAssocEnd));
    }

    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeRoleNameSimilarYetIncorrect(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    int lDistance = levenshteinDistance(studentClassAssocEnd.getName(), instructorClassAssocEnd.getName());
    if (lDistance > MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      // return Optional.of(createMistake(BAD_ROLENAME_Present_But_Incorrect,
      // studentClassAssocEnd,instructorClassAssocEnd));
      return Optional.empty();
    }
    return Optional.empty();
  }


  public static Optional<Mistake> checkMistakeBadAssociationClassNameSpelling(Association studentClassAssoc,
      Association instructorClassAssoc) {
    if (spellingMistakeCheck(studentClassAssoc.getAssociationClass().getName(),
        instructorClassAssoc.getAssociationClass().getName())) {
      return Optional.of(createMistake(BAD_ASSOC_CLASS_NAME_SPELLING, studentClassAssoc.getAssociationClass(),
          instructorClassAssoc.getAssociationClass()));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeSimilarYetIncorrectAssociationClassName(Association studentClassAssoc,
      Association instructorClassAssoc) {
    int lDistance = levenshteinDistance(studentClassAssoc.getAssociationClass().getName(),
        instructorClassAssoc.getAssociationClass().getName());
    if (lDistance != 0) {
      // return Optional.of(createMistake(,
      // studentClassAssoc.getAssociationClass(), instructorClassAssoc.getAssociationClass()));
    }
    return Optional.empty();
  }

  public static void checkMistakeMissingAssociationClass(Association studentClassAssoc,
      Association instructorClassAssoc, EList<Mistake> newMistakes) {
    if (isAssociationClassMissing(studentClassAssoc, instructorClassAssoc)) {
      for (Mistake m : mistakeForElement(instructorClassAssoc.getAssociationClass(), newMistakes)) {
        if (m.getMistakeType().equals(CLASS_SHOULD_BE_ASSOC_CLASS)) {
          return;
        }
      }
      removeMistakesRelatedToElement(instructorClassAssoc.getAssociationClass(), newMistakes);
      newMistakes.add(createMistake(MISSING_ASSOC_CLASS, studentClassAssoc.getAssociationClass(),
          instructorClassAssoc.getAssociationClass()));
    }

  }

  public static void checkMistakeExtraAssociationClass(Association studentClassAssoc, Association instructorClassAssoc,
      EList<Mistake> newMistakes) {
    if (isAssociationClassExtra(studentClassAssoc, instructorClassAssoc)) {
      for (Mistake m : mistakeForElement(studentClassAssoc.getAssociationClass(), newMistakes)) {
        if (m.getMistakeType().equals(ASSOC_CLASS_SHOULD_BE_CLASS)) {
          return;
        }
      }
      removeMistakesRelatedToElement(studentClassAssoc.getAssociationClass(), newMistakes);
      newMistakes.add(createMistake(EXTRA_ASSOC_CLASS, studentClassAssoc.getAssociationClass(),
          instructorClassAssoc.getAssociationClass()));
    }

  }

  public static void checkMistakeMissingClass(Comparison comparison) {
    comparison.notMappedInstructorClassifier.forEach(cls -> {
      if (!mistakeForElementExists(cls, comparison.newMistakes)) {
        comparison.newMistakes.add(createMistake(MISSING_CLASS, null, cls));
      }
    }); // No Student Element
  }

  private static boolean mistakeForElementExists(Classifier cls, EList<Mistake> newMistakes) {
    for (Mistake m : newMistakes) {
      if ((!m.getInstructorElements().isEmpty() && m.getInstructorElements().get(0).getElement().equals(cls))
          || (!m.getStudentElements().isEmpty() && m.getStudentElements().get(0).getElement().equals(cls))) {
        return true;
      }
    }
    return false;
  }

  private static EList<Mistake> mistakeForElement(Classifier cls, EList<Mistake> newMistakes) {
    EList<Mistake> mistakesFound = new BasicEList<Mistake>();
    for (Mistake m : newMistakes) {
      if ((!m.getInstructorElements().isEmpty() && m.getInstructorElements().get(0).getElement().equals(cls))
          || (!m.getStudentElements().isEmpty() && m.getStudentElements().get(0).getElement().equals(cls))) {
        mistakesFound.add(m);
      }
    }
    return mistakesFound;
  }

  public static void checkMistakeExtraClass(Comparison comparison) {
    // No Instructor Element
    comparison.extraStudentClassifier.forEach(cls -> {
      if (!mistakeForElementExists(cls, comparison.newMistakes)) {
        comparison.newMistakes.add(createMistake(EXTRA_CLASS, cls, null));
      }
    });
  }

  public static void checkMistakeMissingAttribute(Comparison comparison) {
    comparison.notMappedInstructorAttribute
        .forEach(cls -> comparison.newMistakes.add(createMistake(MISSING_ATTRIBUTE, null, cls)));
  }

  public static void checkMistakeMissingExtraEnum(Comparison comparison) {
    comparison.notMappedInstructorEnumLiterals
        .forEach(cls -> comparison.newMistakes.add(createMistake(MISSING_ENUM_ITEM, null, cls)));

    comparison.notMappedInstructorEnum
        .forEach(cls -> comparison.newMistakes.add(createMistake(MISSING_ENUM, null, cls)));

    comparison.extraStudentEnumLiterals
        .forEach(cls -> comparison.newMistakes.add(createMistake(EXTRA_ENUM_ITEM, cls, null)));

    comparison.extraStudentEnum.forEach(cls -> comparison.newMistakes.add(createMistake(EXTRA_ENUM, cls, null)));


  }


  public static void checkMistakeExtraAttribute(Comparison comparison) {
    comparison.extraStudentAttribute
        .forEach(cls -> comparison.newMistakes.add(createMistake(EXTRA_ATTRIBUTE, cls, null)));
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
        removeMistakesRelatedToElement(association.getAssociationClass(), comparison.newMistakes);
        comparison.newMistakes.add(createMistake(MISSING_ASSOC_CLASS, null, association.getAssociationClass()));
      }
    }
  }

  public static void checkMistakeExtraAssociationCompositionAggregation(Comparison comparison) {
    for (Association association : comparison.extraStudentAssociation) {
      if (association.getEnds().get(0).getReferenceType().equals(COMPOSITION)
          || association.getEnds().get(1).getReferenceType().equals(COMPOSITION)) {
        comparison.newMistakes.add(createMistake(EXTRA_COMPOSITION, association, null));
      } else if (association.getEnds().get(0).getReferenceType().equals(AGGREGATION)
          || association.getEnds().get(1).getReferenceType().equals(AGGREGATION)) {
        comparison.newMistakes.add(createMistake(EXTRA_AGGREGATION, association, null));
      } else {
        comparison.newMistakes.add(createMistake(EXTRA_ASSOCIATION, association, null));
      }
      if (association.getAssociationClass() != null) {
        removeMistakesRelatedToElement(association.getAssociationClass(), comparison.newMistakes);
        comparison.newMistakes.add(createMistake(EXTRA_ASSOC_CLASS, association.getAssociationClass(), null));
      }
    }
  }

  public static void checkMistakeMissingPattern(TagGroup tg, Comparison comparison) {
    EList<NamedElement> missingElements = new BasicEList<NamedElement>();
    for (Tag tag : tg.getTags()) {
      missingElements.add(tag.getSolutionElement().getElement());
    }
    comparison.newMistakes.add(createMistake(MISSING_PR_PATTERN, null, missingElements));
  }

  public static void createMistakeIncompletePRPattern(TagGroup tg, Comparison comparison) {
    EList<NamedElement> studentMissingElements = new BasicEList<NamedElement>();
    EList<NamedElement> instructorElements = new BasicEList<NamedElement>();
    for (Tag tag : tg.getTags()) {
      instructorElements.add(tag.getSolutionElement().getElement());
      if (comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
        studentMissingElements.add(comparison.mappedClassifier.get(tag.getSolutionElement().getElement()));
      }
    }
    comparison.newMistakes.add(createMistake(INCOMPLETE_PR_PATTERN, studentMissingElements, instructorElements));
  }

  public static void createMistakeIncompleteAOPattern(TagGroup tg, Comparison comparison) {
    EList<NamedElement> studentMissingElements = new BasicEList<NamedElement>();
    EList<NamedElement> instructorElements = new BasicEList<NamedElement>();
    for (Tag tag : tg.getTags()) {
      instructorElements.add(tag.getSolutionElement().getElement());
      if (comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
        studentMissingElements.add(comparison.mappedClassifier.get(tag.getSolutionElement().getElement()));
      }
    }
    comparison.newMistakes.add(createMistake(INCOMPLETE_AO_PATTERN, studentMissingElements, instructorElements));
  }


  public static void checkMistakeUsingEnumPattern(String instPattern, EList<NamedElement> studentElements,
      EList<NamedElement> instElements, Comparison comparison) {
    if (instPattern.equals(ASSOC_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(ENUM_SHOULD_BE_ASSOC_PR_PATTERN, studentElements, instElements));
    } else if (instPattern.equals(FULL_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(ENUM_SHOULD_BE_FULL_PR_PATTERN, studentElements, instElements));
    } else if (instPattern.equals(SUB_CLASS_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(ENUM_SHOULD_BE_SUBCLASS_PR_PATTERN, studentElements, instElements));
    }
  }

  public static void checkMistakeUsingFullPattern(String instPattern, EList<NamedElement> studentElements,
      EList<NamedElement> instElements, Comparison comparison) {
    if (instPattern.equals(ASSOC_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(FULL_PR_PATTERN_SHOULD_BE_ASSOC, studentElements, instElements));
    } else if (instPattern.equals(ENUM_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(FULL_PR_PATTERN_SHOULD_BE_ENUM, studentElements, instElements));
    } else if (instPattern.equals(SUB_CLASS_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(FULL_PR_PATTERN_SHOULD_BE_SUBCLASS, studentElements, instElements));
    }
  }

  public static void checkMistakeUsingSubclassPattern(String instPattern, EList<NamedElement> studentElements,
      EList<NamedElement> instElements, Comparison comparison) {
    if (instPattern.equals(ASSOC_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(SUBCLASS_SHOULD_BE_ASSOC_PR_PATTERN, studentElements, instElements));
    } else if (instPattern.equals(FULL_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(SUBCLASS_SHOULD_BE_FULL_PR_PATTERN, studentElements, instElements));
    } else if (instPattern.equals(ENUM_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(SUBCLASS_SHOULD_BE_ENUM_PR_PATTERN, studentElements, instElements));
    }
  }

  public static void checkMistakeUsingAssocPattern(String instPattern, EList<NamedElement> studentElements,
      EList<NamedElement> instElements, Comparison comparison) {
    if (instPattern.equals(ENUM_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(ASSOC_SHOULD_BE_ENUM_PR_PATTERN, studentElements, instElements));
    } else if (instPattern.equals(FULL_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(ASSOC_SHOULD_BE_FULL_PR_PATTERN, studentElements, instElements));
    } else if (instPattern.equals(SUB_CLASS_PR_PATTERN)) {
      comparison.newMistakes.add(createMistake(ASSOC_SHOULD_BE_SUBCLASS_PR_PATTERN, studentElements, instElements));
    }
  }

  /**
   * Returns true if the input string is a software engineering term.
   */
  public static boolean isSoftwareEngineeringTerm(String s) {
    final var softwareEnginneringTerms = List.of("data", "record", "table", "info", "class", "list");
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
      String tagged = taggerOut(s);
      String[] str = tagged.split("(_|/)");
      String pluralTag = "NNS";
      if (str[1].contains(pluralTag)) {
        isPlural = true;
      }
      nounPluralStatus.put(s, isPlural);
    }
    return isPlural;
  }

  /**
   * Returns true if the input string is a verb.
   */
  public static boolean isVerb(String s) {
    boolean isVerb = false;

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

  /** Returns true if student has defined class as type enum instead of regular. */
  public static boolean isClassEnumInsteadOfRegular(Classifier studentClassifier, Classifier instructorClassifier) {
    return !(instructorClassifier instanceof CDEnum) && studentClassifier instanceof CDEnum;
  }

  /** Returns true if student has defined class as regular instead of type enum . */
  public static boolean isClassRegularInsteadOfEnum(Classifier studentClassifier, Classifier instructorClassifier) {
    return instructorClassifier instanceof CDEnum && !(studentClassifier instanceof CDEnum);
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

  /**
   * Returns true if association class is extra.
   */
  public static boolean isAssociationClassExtra(Association studentClassAssoc, Association instructorClassAssoc) {
    return studentClassAssoc.getAssociationClass() != null && instructorClassAssoc.getAssociationClass() == null;
  }

  /**
   * Returns true if association class is missing.
   */
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

  private static Mistake createMistake(MistakeType mistakeType, EList<NamedElement> studentElements,
      EList<NamedElement> instructorElements) {
    var mistake = MAF.createMistakeOfType(mistakeType);
    if (studentElements != null) {
      studentElements.forEach(se -> {
        var solutionElement = MAF.createSolutionElement();
        solutionElement.setElement(se);
        mistake.getStudentElements().add(solutionElement);
      });
    }
    if (instructorElements != null) {
      instructorElements.forEach(ie -> {
        var solutionElement = MAF.createSolutionElement();
        solutionElement.setElement(ie);
        mistake.getInstructorElements().add(solutionElement);
      });
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
    // clearAttributesAndClassifer();
    boolean isMapped = false;
    EList<Attribute> instructorAttributes = instructorClassifier.getAttributes();
    EList<Attribute> studentAttributes = studentClassifier.getAttributes();

    comparison.notMappedInstructorClassifier.add(instructorClassifier);
    comparison.extraStudentClassifier.add(studentClassifier);

    int totalAttibutes = instructorAttributes.size();
    int correctAttribute = 0;
    float lDistance = levenshteinDistance(studentClassifier.getName(), instructorClassifier.getName());
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
