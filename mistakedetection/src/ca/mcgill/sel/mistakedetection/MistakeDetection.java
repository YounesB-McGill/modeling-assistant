package ca.mcgill.sel.mistakedetection;

import static ca.mcgill.sel.classdiagram.ReferenceType.AGGREGATION;
import static ca.mcgill.sel.classdiagram.ReferenceType.COMPOSITION;
import static ca.mcgill.sel.classdiagram.ReferenceType.REGULAR;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ATTRIBUTE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ASSOCIATION_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ATTRIBUTE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_CLASS_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.BAD_ROLE_NAME_SPELLING;
import static learningcorpus.mistaketypes.MistakeTypes.ENUM_SHOULD_BE_REGULAR_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_ASSOCIATION_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.EXTRA_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.LOWERCASE_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ASSOCIATION_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_CLASS;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.MISSING_ROLE_NAMES;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_EXTRA_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_EXTRA_ATTRIBUTE;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_WRONG_MULTIPLICITY;
import static learningcorpus.mistaketypes.MistakeTypes.OTHER_WRONG_ROLE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.PLURAL_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.REGULAR_CLASS_SHOULD_BE_ENUM;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.ROLE_SHOULD_NOT_BE_STATIC;
import static learningcorpus.mistaketypes.MistakeTypes.SIMILAR_ATTRIBUTE_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.SIMILAR_CLASS_NAME;
import static learningcorpus.mistaketypes.MistakeTypes.SOFTWARE_ENGINEERING_TERM;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_AGGREGATION_INSTEAD_OF_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_ASSOCIATION_INSTEAD_OF_AGGREGATION_COMPOSITION;
import static learningcorpus.mistaketypes.MistakeTypes.USING_COMPOSITION_INSTEAD_OF_AGGREGATION;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ATTRIBUTE_TYPE;
import static learningcorpus.mistaketypes.MistakeTypes.WRONG_ENUM_ITEMS;
import static modelingassistant.TagType.PLAYER;
import static modelingassistant.TagType.ROLE;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

  /** The minimum number of roles and player required for a pattern match. */
  public static final int MIN_MATCH_REQIUIRED = 2;

  public static final String SUB_CLASS_PR_PATTERN = "subClassPlayerRolePattern";

  public static final String FULL_PR_PATTERN = "fullPlayerRolePattern";

  public static final String ENUM_PR_PATTERN = "EnumerationPlayerRolePattern";

  public static final String ASSOC_PR_PATTERN = "AssociationPlayerRolePattern";

  public static final String NO_PR_PATTERN_DETECTED = "NoPlayerRolePatternDetected";

  /** Cache to map nouns to true if they are plural, false otherwise. */
  static Map<String, Boolean> nounPluralStatus = new HashMap<String, Boolean>();

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
          checkMistakesInClassifier(studentClassifier, instructorClassifier, newMistakes);

          EList<Attribute> studentAttributes = studentClassifier.getAttributes();
          for (Attribute instructorAttribute : instructorAttributes) {
            for (Attribute studentAttribute : studentAttributes) {
              float lDistance = levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
              if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
                checkMistakeAttributeSpelling(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
                checkMistakesInAttributes(studentAttribute, instructorAttribute, newMistakes);
                break;
              }
            }
          }
        }
      }
      processed = true;
    }
    mappingBasedOnSubStrings(comparison);
    mappingBasedOnAtribsAndAssocEnds(comparison);
    mapRelations(comparison);
    mapEnumerations(instructorSolution, studentSolution, comparison);
    mapPatterns(instructorSolution, studentSolution, comparison);
    checkMistakesAfterMapping(comparison); // TO BE Discussed
    checkMistakeMissingClass(comparison);
    checkMistakeExtraClass(comparison);
    // checkMistakeDuplicateAttributes();
    checkMistakeExtraAttribute(comparison);
    checkMistakeMissingAttribute(comparison);
    checkMistakeWrongEnumerationItems(comparison);
    // checkMistakeWrongAttribute();
    // checkMistakeAttributeMisplaced();
    // checkMistakeIncompleteContainmentTree(studentClassifiers);
    checkMistakeMissingAssociationCompositionAggregation(comparison);
    checkMistakeExtraAssociation(comparison);

    updateMistakes(studentSolution, comparison);
    return comparison;
  }

  private static void mapEnumerations(Solution instructorSolution, Solution studentSolution, Comparison comparison) {
    var instructorClassDiagram = instructorSolution.getClassDiagram();
    var studentClassDiagram = studentSolution.getClassDiagram();
    boolean processed = false;
    for (Type instElementType : instructorClassDiagram.getTypes()) {
      if (instElementType instanceof CDEnum) {
        CDEnum instEnumClass = (CDEnum) instElementType;
        comparison.notMappedInstructorEnum.add(instEnumClass);
        instEnumClass.getLiterals().forEach(lit -> {
          comparison.notMappedInstructorEnumLiterals.add(lit);
        });
      }
      for (Type studElementType : studentClassDiagram.getTypes()) {
        if (studElementType instanceof CDEnum && !processed) {
          CDEnum studEnumClass = (CDEnum) studElementType;
          comparison.extraStudentEnum.add(studEnumClass);
          studEnumClass.getLiterals().forEach(lit -> {
            comparison.extraStudentEnumLiterals.add(lit);
          });
        }
      }
      processed = true;
    }
    comparison.mappedAttribute.forEach((key, value) -> {
      if (key.getType() instanceof CDEnum && value.getType() instanceof CDEnum) {
        CDEnum instEnum = getEnumFromClassDiagram(key.getType().getName(), instructorClassDiagram);
        CDEnum studEnum = getEnumFromClassDiagram(value.getType().getName(), studentClassDiagram);
        if (instEnum != null && studEnum != null) {
          comparison.mappedEnumeration.put(instEnum, studEnum);
          comparison.notMappedInstructorEnum.remove(instEnum);
          comparison.extraStudentEnum.remove(studEnum);

          for (CDEnumLiteral instEnumLiteral : instEnum.getLiterals()) {
            for (CDEnumLiteral studEnumLiteral : studEnum.getLiterals()) {
              var lDistance = levenshteinDistance(instEnumLiteral.getName(), studEnumLiteral.getName());
              if (lDistance < MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
                comparison.mappedEnumerationItems.put(instEnumLiteral, studEnumLiteral);
                comparison.notMappedInstructorEnumLiterals.remove(instEnumLiteral);
                comparison.extraStudentEnumLiterals.remove(studEnumLiteral);
              }

            }
          }
        }
      }
    });
  }

  public static CDEnum getEnumFromClassDiagram(String name, ClassDiagram classDiagram) {
    for (Type type : classDiagram.getTypes()) {
      if (type instanceof CDEnum) {
        if (type.getName().equals(name)) {
          return (CDEnum) type;
        }
      }
    }
    return null;
  }

  private static void checkMistakesInAttributes(Attribute studentAttribute, Attribute instructorAttribute,
      EList<Mistake> newMistakes) {
    checkMistakeWrongAttributeType(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
    checkMistakeAttributeExpectedStatic(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
    checkMistakeAttributeNotExpectedStatic(studentAttribute, instructorAttribute).ifPresent(newMistakes::add);
  }

  private static void checkMistakesInClassifier(Classifier studentClassifier, Classifier instructorClassifier,
      EList<Mistake> newMistakes) {

    checkMistakeSoftwareEngineeringTerm(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
    checkMistakePluralClassName(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
    checkMistakeLowerClassName(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
    checkMistakeRegularBeEnumerationClass(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
    checkMistakeEnumerationBeRegularClass(studentClassifier, instructorClassifier).ifPresent(newMistakes::add);
    // checkMistakeWrongEnumerationClassItems(studentClassifier,instructorClassifier).ifPresent(newMistakes::add);
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
          instPattern = checkPattern(tg);
          if (instPattern.equals(FULL_PR_PATTERN)) {
            checkStudentFullPattern(tg, comparison, instPattern);
          } else if (instPattern.equals(SUB_CLASS_PR_PATTERN)) {
            checkStudentSubClassPattern(tg, comparison, instPattern);
          } else if (instPattern.equals(ASSOC_PR_PATTERN)) {
            checkStudentAssocPattern(tg, comparison, instPattern);
          } else if (instPattern.equals(ENUM_PR_PATTERN)) {
            checkStudentEnumPattern(tg, comparison, instPattern);
          }
          break;
        }
      }
    }
  }

  private static void checkStudentEnumPattern(TagGroup tg, Comparison comparison, String instPattern) {
    int totalMatcheExpected = 1;
    int totalMatched = 0;
    EList<Attribute> studentRoleAttribute = new BasicEList<Attribute>();
    Classifier studentPlayerClass = null;
    for (Tag tag : tg.getTags()) {
      if (tag.getTagType().equals(PLAYER)
          && comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
        studentPlayerClass = comparison.mappedClassifier.get(tag.getSolutionElement().getElement());
        totalMatched = totalMatched + 1;
      } else if (tag.getTagType().equals(ROLE)
          && comparison.mappedAttribute.containsKey(tag.getSolutionElement().getElement())) {
        Attribute atrib = (Attribute) tag.getSolutionElement().getElement();
        studentRoleAttribute.add(comparison.mappedAttribute.get(atrib));
        CDEnum enumClass =
            getEnumFromClassDiagram(atrib.getType().getName(), tag.getTagGroup().getSolution().getClassDiagram());
        totalMatcheExpected = totalMatcheExpected + enumClass.getLiterals().size();
        for (CDEnumLiteral enumClassLiteral : enumClass.getLiterals()) {
          if (comparison.mappedEnumerationItems.containsKey(enumClassLiteral)) {
            totalMatched = totalMatched + 1;
          }
        }
      }
    }
    if (totalMatched == totalMatcheExpected && totalMatched != 1) {
      System.out.println("Success Enum");
      return;
    }
    if (totalMatched != totalMatcheExpected && totalMatched != 1) {
      // TODO Create Mistake Incorect Patter
      System.out.println("Incorrect Pattern Enum");
      return;
    } else if (MIN_MATCH_REQIUIRED < totalMatched && studentPlayerClass != null) {
      // TODO createMistake(incorrect patter)
      System.out.println("Incorrect Pattern Enum");
      return;
    }
    checkOtherPattern(tg, comparison, instPattern);
  }

  private static void checkStudentAssocPattern(TagGroup tg, Comparison comparison, String instPattern) {
    int totalMatcheExpected = tg.getTags().size();
    int totalMatched = 0;
    EList<String> studentRoleAssocEnd = new BasicEList<String>();
    Classifier studentPlayerClass = null;
    for (Tag tag : tg.getTags()) {
      if (tag.getTagType().equals(PLAYER)
          && comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
        studentPlayerClass = comparison.mappedClassifier.get(tag.getSolutionElement().getElement());
        totalMatched = totalMatched + 1;
      } else {
        if (tag.getSolutionElement().getElement() instanceof AssociationEnd) {
          AssociationEnd assocEnd = (AssociationEnd) tag.getSolutionElement().getElement();
          if (comparison.mappedAssociation.containsKey(assocEnd.getAssoc())) {
            studentRoleAssocEnd.add(assocEnd.getName());
            totalMatched = totalMatched + 1;
          }
        }
      }
    }
    if (totalMatched == totalMatcheExpected) {
      if (!assocPatternCorrect(studentPlayerClass, studentRoleAssocEnd)) {
        // TODO createMistake(incorrect patter)
        System.out.println("Incorrect Pattern Assoc");
        return;
      } else {
        System.out.println("Success Assoc");
        return;
      }
    } else if (MIN_MATCH_REQIUIRED < totalMatched && studentPlayerClass != null) {
      // TODO createMistake(incorrect patter)
      System.out.println("Incorrect Pattern assoc");
      return;
    }
    checkOtherPattern(tg, comparison, instPattern);
  }

/**
 * Function checks if associations are linked to player class
 *
 *
 * @param studentPlayerClass
 * @param studentRoleAssocEnd
 * @return
 */
  private static boolean assocPatternCorrect(Classifier studentPlayerClass, EList<String> studentRoleAssocEnd) {
    int count = 0;
    for (AssociationEnd assocEnd : studentPlayerClass.getAssociationEnds()) {
      Association assoc = assocEnd.getAssoc();
      AssociationEnd otherAssocEnd = getOtherAssocEnd(assoc, assocEnd);
      if (studentRoleAssocEnd.contains(otherAssocEnd.getName())) {
        count = count + 1;
      }
    }
    return count == studentRoleAssocEnd.size();
  }

  private static void checkStudentFullPattern(TagGroup tg, Comparison comparison, String instPattern) {
    int totalMatcheExpected = tg.getTags().size();
    int totalMatched = 0;
    EList<Classifier> studentRoleClasses = new BasicEList<Classifier>();
    Classifier studentPlayerClass = null;
    Classifier studentAbstractClass = null;
    for (Tag tag : tg.getTags()) {
      if (comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
        if (tag.getTagType().equals(PLAYER)) {
          studentPlayerClass = comparison.mappedClassifier.get(tag.getSolutionElement().getElement());
        } else {
          studentRoleClasses.add(comparison.mappedClassifier.get(tag.getSolutionElement().getElement()));
        }
        totalMatched = totalMatched + 1;
      }
    }
    if (studentRoleClasses.isEmpty()) {
      checkOtherPattern(tg, comparison, instPattern);
      return;
    }
    if (studentRoleClasses.get(0).getSuperTypes().isEmpty()) {
      checkOtherPattern(tg, comparison, instPattern);
      return;
    }
    studentAbstractClass = studentRoleClasses.get(0).getSuperTypes().get(0);
    if (totalMatched == totalMatcheExpected) {
      if (studentAbstractClass == studentPlayerClass && studentPlayerClass != null) {
        System.out.println("Using subClasses instead of Full Player-Role Pattern");
        return;
      }
      if (!studentAbstractClass.isAbstract()) {
        System.out.println("Incorrect Pattern Full");
        return;
      }
      if (!subClassPatternCorrect(studentAbstractClass, studentRoleClasses)) {
        // TODO createMistake(incorrect patter)
        System.out.println("Incorrect Pattern full");
        return;
      } else {
        if (!assocExists(studentPlayerClass, studentAbstractClass)) {
          System.out.println("Incorrect Pattern full");
        } else {
          System.out.println("Success Full");
          return;
        }
      }
    } else if (MIN_MATCH_REQIUIRED < totalMatched && studentPlayerClass != null && studentAbstractClass != null) {
      // TODO createMistake(incorrect patter)
      System.out.println("Incorrect Pattern full");
      return;
    }
    checkOtherPattern(tg, comparison, instPattern);
  }

  private static void checkStudentSubClassPattern(TagGroup tg, Comparison comparison, String instPattern) {
    int totalMatcheExpected = tg.getTags().size();
    int totalMatched = 0;
    EList<Classifier> studentRoleClasses = new BasicEList<Classifier>();
    Classifier studentPlayerClass = null;
    for (Tag tag : tg.getTags()) {
      if (comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
        if (tag.getTagType().equals(PLAYER)) {
          studentPlayerClass = comparison.mappedClassifier.get(tag.getSolutionElement().getElement());
        } else {
          studentRoleClasses.add(comparison.mappedClassifier.get(tag.getSolutionElement().getElement()));
        }
        totalMatched = totalMatched + 1;
      }
    }
    if (totalMatched == totalMatcheExpected) {
      if (!subClassPatternCorrect(studentPlayerClass, studentRoleClasses)) {
        // TODO createMistake(incorrect patter)
        if (studentRoleClasses.get(0).getSuperTypes().get(0).isAbstract()) {
          if (assocExists(studentRoleClasses.get(0).getSuperTypes().get(0), studentPlayerClass)) {
            System.out.println("Using Full Pattern instead of SubClasses");
            return;
          }
        }
        System.out.println("Incorrect Pattern sub");
        return;
      } else {
        System.out.println("Success Sub");
        return;
      }
    } else if (MIN_MATCH_REQIUIRED < totalMatched && studentPlayerClass != null) {
      // TODO createMistake(incorrect patter)
      System.out.println("Incorrect Pattern sub");
      return;
    }
    checkOtherPattern(tg, comparison, instPattern);
  }

  private static void checkOtherPattern(TagGroup tg, Comparison comparison, String instPattern) {
    int studentSubClassesPatternScore = 0;
    int studentEnumsPatternScore = 0;
    int studentFullPatternScore = 0;
    int studentAssocPatternScore = 0;
    Classifier studPlayerClass = null;
    EList<Classifier> studRoleClass = new BasicEList<Classifier>();
    EList<String> studRoleAssocEndName = new BasicEList<String>();
    EList<String> instEnumLiterals = new BasicEList<String>();

    for (Tag tag : tg.getTags()) {
      if (tag.getTagType().equals(PLAYER)) {
        if (comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
          studPlayerClass = comparison.mappedClassifier.get(tag.getSolutionElement().getElement());
        }
      }
      if (tag.getTagType().equals(ROLE) && tag.getSolutionElement().getElement() instanceof Attribute) {
        Attribute instAtrib = (Attribute) tag.getSolutionElement().getElement();
        if (instAtrib.getType() instanceof CDEnum) {
          CDEnum instEnum =
              getEnumFromClassDiagram(instAtrib.getType().getName(), tag.getTagGroup().getSolution().getClassDiagram());
          for (CDEnumLiteral enumLitral : instEnum.getLiterals()) {
            instEnumLiterals.add(enumLitral.getName());
          }
        }
      }
      for (Classifier studClass : comparison.extraStudentClassifier) {
        if (studClass.getName().toLowerCase().equals(tag.getSolutionElement().getElement().getName().toLowerCase())) {
          if (tag.getTagType().equals(PLAYER)) {
            if (!comparison.mappedClassifier.containsKey(tag.getSolutionElement().getElement())) {
              studPlayerClass = studClass;
            }
          } else {
            studRoleClass.add(studClass);
          }
          studentSubClassesPatternScore = studentSubClassesPatternScore + 1;
          studentFullPatternScore = studentFullPatternScore + 1;
        }
      }
      for (Association studAssoc : comparison.extraStudentAssociation) {
        for (AssociationEnd studAssocEnd : studAssoc.getEnds()) {
          if (studAssocEnd.getName().toLowerCase()
              .equals(tag.getSolutionElement().getElement().getName().toLowerCase())) {
            studentAssocPatternScore = studentAssocPatternScore + 1;
            studRoleAssocEndName.add(studAssocEnd.getName());
          }
        }
      }

      for (CDEnum studEnum : comparison.extraStudentEnum) {
        if (studEnum.getName().toLowerCase().equals(tag.getSolutionElement().getElement().getName().toLowerCase())) {
          studentEnumsPatternScore = studentEnumsPatternScore + 1;
        }
      }

      for (CDEnumLiteral studEnumLiteral : comparison.extraStudentEnumLiterals) {
        if (tag.getSolutionElement().getElement().getName().toLowerCase()
            .equals(studEnumLiteral.getName().toLowerCase())) {
          studentEnumsPatternScore = studentEnumsPatternScore + 1;
        }
      }
    }
    if (!instEnumLiterals.isEmpty()) {
      for (String enumLiteralName : instEnumLiterals) {
        for (Classifier studClass : comparison.extraStudentClassifier) {
          if (studClass.getName().toLowerCase().equals(enumLiteralName.toLowerCase())) {
            studRoleClass.add(studClass);
            studentSubClassesPatternScore = studentSubClassesPatternScore + 1;
            studentFullPatternScore = studentFullPatternScore + 1;
          }
        }
        for (Association studAssoc : comparison.extraStudentAssociation) {
          for (AssociationEnd studAssocEnd : studAssoc.getEnds()) {
            if (studAssocEnd.getName().toLowerCase().equals(enumLiteralName.toLowerCase())) {
              studentAssocPatternScore = studentAssocPatternScore + 1;
              studRoleAssocEndName.add(studAssocEnd.getName());
            }
          }
        }
        for (CDEnum studEnum : comparison.extraStudentEnum) {
          if (studEnum.getName().toLowerCase().equals(enumLiteralName.toLowerCase())) {
            studentEnumsPatternScore = studentEnumsPatternScore + 1;
          }
        }
        for (CDEnumLiteral studEnumLiteral : comparison.extraStudentEnumLiterals) {
          if (enumLiteralName.toLowerCase().equals(studEnumLiteral.getName().toLowerCase())) {
            studentEnumsPatternScore = studentEnumsPatternScore + 1;
          }
        }
      }
    }
    int scores[] =
        {studentSubClassesPatternScore, studentFullPatternScore, studentEnumsPatternScore, studentAssocPatternScore};
    int highestScore = getHighestScore(scores);
    if (highestScore == 0) {
      System.out.println("Missing Pattern");
      return;
    }
    if (studentSubClassesPatternScore == studentFullPatternScore && studentFullPatternScore == highestScore) {
      if (studPlayerClass != null) {
        if (subClassPatternCorrect(studPlayerClass, studRoleClass)) {
          studentSubClassesPatternScore = studentSubClassesPatternScore + 1;
          highestScore = highestScore + 1;
        }
        if (!studRoleClass.get(0).getSuperTypes().contains(studPlayerClass)
            && subClassPatternCorrect(studRoleClass.get(0).getSuperTypes().get(0), studRoleClass)) {
          studentFullPatternScore = studentFullPatternScore + 1;
          highestScore = highestScore + 1;
        }
      } else {
        System.out.println("Missing Pattern");
        return;
      }
    }
    if (studentSubClassesPatternScore == highestScore) {
      System.out.println(SUB_CLASS_PR_PATTERN + " instead of " + instPattern);
      return;
    } else if (studentAssocPatternScore == highestScore) {
      if(assocPatternCorrect(studPlayerClass, studRoleAssocEndName)) {
      System.out.println(ASSOC_PR_PATTERN + " instead of " + instPattern);
      return;
      }else {
        System.out.println("Missing Pattern");
        return;
      }
    } else if (studentFullPatternScore == highestScore) {
      System.out.println(FULL_PR_PATTERN + " instead of " + instPattern);
      return;
    } else if (studentEnumsPatternScore == highestScore) {
      System.out.println(ENUM_PR_PATTERN + " instead of " + instPattern);
      return;
    } else {
      System.out.println("Missing Pattern");
      return;
    }
  }

  private static int getHighestScore(int[] scores) {
    Arrays.sort(scores);
    return scores[scores.length - 1];
  }

  private static boolean subClassPatternCorrect(Classifier studentPlayerClass, EList<Classifier> studentRoleClasses) {
    for (Classifier roleClass : studentRoleClasses) {
      if (!roleClass.getSuperTypes().contains(studentPlayerClass)) {
        return false;
      }
    }
    return true;
  }

  /**
   * returns the pattern detected in the instructor solution
   *
   * @param TagGroup
   * @return string
   */
  public static String checkPattern(TagGroup tg) {
    SolutionElement playerSolutionElement = null;
    List<SolutionElement> roleSolutionElements = new BasicEList<SolutionElement>();
    for (Tag tag : tg.getTags()) {
      if (tag.getTagType().equals(PLAYER)) {
        playerSolutionElement = tag.getSolutionElement();
      } else if (tag.getTagType().equals(ROLE)) {
        roleSolutionElements.add(tag.getSolutionElement());
      }
    }
    if (subClassPattern(playerSolutionElement, roleSolutionElements)) {
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
    if (playerSolutionElement.getElement() instanceof Classifier) {
      for (SolutionElement se : roleSolutionElements) {
        Attribute atrib = (Attribute) se.getElement();
        if (!(atrib.getType() instanceof CDEnum)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean assocPattern(SolutionElement playerSolutionElement,
      List<SolutionElement> roleSolutionElements) {
    if (playerSolutionElement.getElement() instanceof Classifier) {
      for (SolutionElement se : roleSolutionElements) {
        if (!(se.getElement() instanceof AssociationEnd)) {
          return false;
        }
      }
    }
    return true;
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
   * returns true if a association exists b/w 2 classes in a solution
   *
   * @param class1
   * @param class2
   * @return boolean
   */
  private static boolean assocExists(Classifier class1, Classifier class2) {
    var classifierAssocEnds = class1.getAssociationEnds();

    for (AssociationEnd classifierAssocEnd : classifierAssocEnds) {
      var classifierAssoc = classifierAssocEnd.getAssoc();
      AssociationEnd otherClassifierAssocEnd = getOtherAssocEnd(classifierAssoc, classifierAssocEnd);
      var otherClassifier = otherClassifierAssocEnd.getClassifier();
      if (otherClassifier.equals(class2)) {
        return true;
      }
    }
    return false;
  }

  public static boolean subClassPattern(SolutionElement playerSolutionElement,
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
    comparison.mappedClassifier.forEach((key, value) -> {
      compareAssocation(key, value, comparison);
    });
  }

  /** Maps the associations and check for mistakes */
  private static void compareAssocation(Classifier instructorClassifier, Classifier studentClassifier,
      Comparison comparison) {
    var instructorClassifierAssocEnds = instructorClassifier.getAssociationEnds();
    var studentClassifierAssocEnds = studentClassifier.getAssociationEnds();

    for (AssociationEnd instructorClassifierAssocEnd : instructorClassifierAssocEnds) {
      var instructorClassifierAssoc = instructorClassifierAssocEnd.getAssoc();
      AssociationEnd otherInstructorClassifierAssocEnd =
          getOtherAssocEnd(instructorClassifierAssoc, instructorClassifierAssocEnd);

      var otherInstructorClassifier = otherInstructorClassifierAssocEnd.getClassifier();
      Map<Association, EList<AssociationEnd>> possibleAssocMatch = new HashMap<Association, EList<AssociationEnd>>();
      for (AssociationEnd studentClassifierAssocEnd : studentClassifierAssocEnds) {
        var studentClassifierAssoc = studentClassifierAssocEnd.getAssoc();
        AssociationEnd otherStudentClassifierAssocEnd =
            getOtherAssocEnd(studentClassifierAssoc, studentClassifierAssocEnd);

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

  private static AssociationEnd getOtherAssocEnd(Association assoc, AssociationEnd assocEnd) {
    AssociationEnd otherAssocEnd;
    if (assoc.getEnds().get(0).equals(assocEnd)) {
      otherAssocEnd = assoc.getEnds().get(1);
    } else {
      otherAssocEnd = assoc.getEnds().get(0);
    }
    return otherAssocEnd;
  }

  private static void detectMistakeInAssoc(Comparison comparison, Association studentClassifierAssoc,
      Association instructorClassifierAssoc, AssociationEnd studentClassifierAssocEnd,
      AssociationEnd instructorClassifierAssocEnd, AssociationEnd otherStudentClassifierAssocEnd,
      AssociationEnd otherInstructorClassifierAssocEnd) {
    if (!checkStudentElementForMistake(comparison.newMistakes, studentClassifierAssoc)) {
      checkMistakeExtraAssociationClass(studentClassifierAssoc, instructorClassifierAssoc)
          .ifPresent(comparison.newMistakes::add);
      if (studentClassifierAssoc.getAssociationClass() != null
          && instructorClassifierAssoc.getAssociationClass() != null) {
        checkMistakeBadAssociationClassNameSpelling(studentClassifierAssoc, instructorClassifierAssoc)
            .ifPresent(comparison.newMistakes::add);
        checkMistakeSimilarYetIncorrectAssociationClassName(studentClassifierAssoc, instructorClassifierAssoc)
            .ifPresent(comparison.newMistakes::add);
      }
    }
    if (!checkInstructorElementForMistake(comparison.newMistakes, instructorClassifierAssoc)) {
      checkMistakeMissingAssociationClass(studentClassifierAssoc, instructorClassifierAssoc)
          .ifPresent(comparison.newMistakes::add);
    }
    if (!checkInstructorElementForMistake(comparison.newMistakes, instructorClassifierAssocEnd)) {
      checkMistakesForAssociationEnds(studentClassifierAssocEnd, instructorClassifierAssocEnd, comparison);
    }
    // -- Check for Other Assoc End-----
    if (!checkInstructorElementForMistake(comparison.newMistakes, otherInstructorClassifierAssocEnd)) {
      checkMistakesForAssociationEnds(otherStudentClassifierAssocEnd, otherInstructorClassifierAssocEnd, comparison);
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
    Map<Association, Double> assocScoreMap = new LinkedHashMap<Association, Double>();
    for (Map.Entry<Association, EList<AssociationEnd>> entry : possibleAssocMatch.entrySet()) {
      double score = 0;
      int lDistance1 = levenshteinDistance(entry.getValue().get(0).getName(), entry.getValue().get(1).getName());
      int lDistance2 = levenshteinDistance(entry.getValue().get(2).getName(), entry.getValue().get(3).getName());
      if (associationEndMultiplicityUpperBoundsMatch(entry.getValue().get(0), entry.getValue().get(1))) {
        score = score + 0.15;
      }
      if (associationEndMultiplicityLowerBoundsMatch(entry.getValue().get(0), entry.getValue().get(1))) {
        score = score + 0.15;
      }
      if (lDistance1 <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
        score = score + 0.20;
      }
      if (associationEndMultiplicityUpperBoundsMatch(entry.getValue().get(2), entry.getValue().get(3))) {
        score = score + 0.15;
      }
      if (associationEndMultiplicityLowerBoundsMatch(entry.getValue().get(2), entry.getValue().get(3))) {
        score = score + 0.15;
      }
      if (lDistance2 <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
        score = score + 0.20;
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

  private static void checkMistakesForAssociationEnds(AssociationEnd studentClassifierAssocEnd,
      AssociationEnd instructorClassifierAssocEnd, Comparison comparison) {

    checkMistakeUsingAssociationInsteadOfComposition(studentClassifierAssocEnd, instructorClassifierAssocEnd)
        .ifPresent(comparison.newMistakes::add);
    checkMistakeUsingAssociationInsteadOfAggregation(studentClassifierAssocEnd, instructorClassifierAssocEnd)
        .ifPresent(comparison.newMistakes::add);
    checkMistakeUsingCompositionInsteadOfAssociation(studentClassifierAssocEnd, instructorClassifierAssocEnd)
        .ifPresent(comparison.newMistakes::add);
    checkMistakeUsingAggregationInsteadOfAssociation(studentClassifierAssocEnd, instructorClassifierAssocEnd)
        .ifPresent(comparison.newMistakes::add);
    checkMistakeUsingAggregationInsteadOfComposition(studentClassifierAssocEnd, instructorClassifierAssocEnd)
        .ifPresent(comparison.newMistakes::add);
    checkMistakeUsingCompositionInsteadOfAggregation(studentClassifierAssocEnd, instructorClassifierAssocEnd)
        .ifPresent(comparison.newMistakes::add);
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
        newMistake.setSolution(studentSolution);
      }
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
      for (Mistake newMistake : newMistakes) {
        if (!newMistakesProcessed.contains(newMistake)) {
          setMistakeProperties(newMistake, false, 1, 0);
          newMistake.setSolution(studentSolution);
        }
      }
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
  public static boolean checkCorrect(Classifier instructorClass, Classifier studentClass, Comparison comparison) {
    boolean isMapped = false;
    EList<Attribute> instructorAttributes = instructorClass.getAttributes();
    EList<Attribute> studentAttributes = studentClass.getAttributes();


    float lDistance = levenshteinDistance(studentClass.getName(), instructorClass.getName());
    if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      isMapped = true;
      mapClasses(comparison, studentClass, instructorClass);
      for (Attribute instructorAttribute : instructorAttributes) { // To check association -> Not at present.
        for (Attribute studentAttribute : studentAttributes) {
          lDistance = levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
          if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED
              && comparison.mappedAttribute.get(instructorAttribute) == studentAttribute) {
            comparison.duplicateStudentAttribute.add(studentAttribute);
            comparison.extraStudentAttribute.remove(studentAttribute);
          } else if (lDistance <= MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {

            mapAttributes(comparison, studentAttribute, instructorAttribute);
            break;
          }
        }
      }
    }

    return isMapped;
  }

  /** Maps if instructor class name is present in a student class name */
  public static void mappingBasedOnSubStrings(Comparison comparison) {
    if (comparison.notMappedInstructorClassifier.isEmpty() || comparison.extraStudentClassifier.isEmpty()) {
      return;
    }

    for (int i = 0; i < comparison.notMappedInstructorClassifier.size(); i++) {
      Classifier instructorClassifier = comparison.notMappedInstructorClassifier.get(i);
      EList<Attribute> instructorAttributes = instructorClassifier.getAttributes();
      String instructorClassName = instructorClassifier.getName();
      for (int j = 0; j < comparison.extraStudentClassifier.size(); j++) {
        Classifier studentClassifier = comparison.extraStudentClassifier.get(j);
        EList<Attribute> studentAttributes = studentClassifier.getAttributes();
        String studentClassName = studentClassifier.getName();
        if (studentClassName.toLowerCase().contains(instructorClassName.toLowerCase())) {
          mapClasses(comparison, studentClassifier, instructorClassifier);
          checkMistakesInClassifier(studentClassifier, instructorClassifier, comparison.newMistakes);
          for (Attribute instructorAttribute : instructorAttributes) {
            for (Attribute studentAttribute : studentAttributes) {
              var lDistance = levenshteinDistance(studentAttribute.getName(), instructorAttribute.getName());
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

  /** Finds mappings in previously unmapped elements by comparing Attributes and Association Ends */
  public static void mappingBasedOnAtribsAndAssocEnds(Comparison comparison) {
    if (comparison.notMappedInstructorClassifier.isEmpty() || comparison.extraStudentClassifier.isEmpty()) {
      return;
    }
    int counter = 1;
    int MAX_ATTRIBUTE_ALLOWED = 2;
    for (int k = 0; k < counter; k++) {
      for (int i = 0; i < comparison.notMappedInstructorClassifier.size(); i++) {
        Classifier instructorClassifier = comparison.notMappedInstructorClassifier.get(i);
        EList<Attribute> instructorAttributes = instructorClassifier.getAttributes();
        int totalAttributes = instructorAttributes.size();
        Map<Classifier, Double> possibleClassMatch = new LinkedHashMap<Classifier, Double>();
        HashMap<Classifier, Integer> possibleClassMatchWithNoAttribute = new HashMap<Classifier, Integer>();
        for (int j = 0; j < comparison.extraStudentClassifier.size(); j++) {
          Classifier studentClassifier = comparison.extraStudentClassifier.get(j);
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
          Map<Classifier, Integer> sortedClosestClasssifier = sortByValueClassifier(possibleClassMatchWithNoAttribute);
          mapClasses(comparison, sortedClosestClasssifier.keySet().stream().findFirst().get(), instructorClassifier);
        }
        if (totalAttributes == 0) {
          continue;
        }
        if (nearestMatchExist(possibleClassMatch)) {
          Classifier studentClassifier = getMatchedClassifier(possibleClassMatch, instructorClassifier);
          counter++;
          mapClasses(comparison, studentClassifier, instructorClassifier);
          checkMistakesInClassifier(studentClassifier, instructorClassifier, comparison.newMistakes);
          EList<Attribute> studentAttributes = studentClassifier.getAttributes();
          for (Attribute instructorAttribute : instructorAttributes) { // To check association
                                                                       // -> Not at present.
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
   * returns true if nearest matching student class to the instructorClass exists
   **
   * @param possibleClassMatch
   * @param instructorClass
   * @return boolean
   */
  private static boolean nearestMatchExist(Map<Classifier, Double> possibleClassMatch) {
    var elements = maxAttributeMatch(possibleClassMatch);
    if (!elements.isEmpty()) {
      return true;
    }
    return false;
  }

  /**
   * returns the nearest matching student class to the instructorClass
   *
   * If a match is found then zeroth element of list will be True else False
   *
   * @param possibleClassMatch
   * @param instructorClass
   * @return list of objects
   */
  private static Classifier getMatchedClassifier(Map<Classifier, Double> possibleClassMatch,
      Classifier instructorClass) {
    var elements = maxAttributeMatch(possibleClassMatch);
    if (!elements.isEmpty() && elements.size() == 1) {
      return elements.get(0);
    } else if (elements.size() > 1) {
      return classWithAssociationEndsMatch(elements, instructorClass);
    }
    return null;
  }

  /**
   * returns the class with closest number of association ends with that of a instructor class
   *
   * @param studentClasses
   * @param instructorClass
   * @return class
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
    // System.out.println(seekedClassifier.getName());

    return seekedClassifier;
  }

  /**
   * returns the classifiers with maximum number of matched attributes
   *
   * @param map
   * @return List of classifiers
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
   * returns the associations with maximum number of score
   *
   * @param map
   * @return List of association
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

  // Returns element closest to target in arr[]
  public static int findClosest(List<Integer> assocEndValues, int target) {
    HashMap<Integer, Integer> closestNumbDiffMap = new HashMap<Integer, Integer>();
    assocEndValues.forEach(value -> {
      int diff = target - value;
      closestNumbDiffMap.put(value, Math.abs(diff));
    });
    Map<Integer, Integer> sortedClosestNumbDiffMap = sortByValue(closestNumbDiffMap);
    return sortedClosestNumbDiffMap.keySet().stream().findFirst().get();
  }

  // function to sort hash map by values
  public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
    // Create a list from elements of HashMap
    List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
    // Sort the list
    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return (o1.getValue()).compareTo(o2.getValue());
      }
    });
    // put data from sorted list to hash map
    HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
    for (Map.Entry<Integer, Integer> aa : list) {
      temp.put(aa.getKey(), aa.getValue());
    }
    return temp;
  }
  // function to sort hash map by values
  public static HashMap<Classifier, Integer> sortByValueClassifier(HashMap<Classifier, Integer> hm) {
    // Create a list from elements of HashMap
    List<Map.Entry<Classifier, Integer>> list = new LinkedList<Map.Entry<Classifier, Integer>>(hm.entrySet());
    // Sort the list
    Collections.sort(list, new Comparator<Map.Entry<Classifier, Integer>>() {
      @Override
      public int compare(Map.Entry<Classifier, Integer> o1, Map.Entry<Classifier, Integer> o2) {
        return (o1.getValue()).compareTo(o2.getValue());
      }
    });
    // put data from sorted list to hash map
    HashMap<Classifier, Integer> temp = new LinkedHashMap<Classifier, Integer>();
    for (Map.Entry<Classifier, Integer> aa : list) {
      temp.put(aa.getKey(), aa.getValue());
    }
    return temp;
  }

  public static void mapAttributes(Comparison comparison, Attribute studentAttribute, Attribute instructorAttribute) {
    comparison.mappedAttribute.put(instructorAttribute, studentAttribute);
    comparison.notMappedInstructorAttribute.remove(instructorAttribute);
    comparison.extraStudentAttribute.remove(studentAttribute);
  }

  public static void mapClasses(Comparison comparison, Classifier studentClass, Classifier instructorClass) {
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

  public static Optional<Mistake> checkMistakeClassSpelling(Classifier studentClass, Classifier instructorClass) {
    if (spellingMistakeCheck(studentClass.getName(), instructorClass.getName()) && !isPlural(studentClass.getName())
        && !isLowerName(studentClass.getName())) {
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
    if (spellingMistakeCheck(studentAttribute.getName().toLowerCase(), instructorAttribute.getName().toLowerCase())) {
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
      return Optional.of(createMistake(ENUM_SHOULD_BE_REGULAR_CLASS, studentClass, instructorClass));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeRegularBeEnumerationClass(Classifier studentClass,
      Classifier instructorClass) {
    if (isClassRegularInsteadOfEnum(studentClass, instructorClass)) {
      return Optional.of(createMistake(REGULAR_CLASS_SHOULD_BE_ENUM, studentClass, instructorClass));
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
      return Optional.of(createMistake(USING_ASSOCIATION_INSTEAD_OF_AGGREGATION_COMPOSITION, studentClassAssocEnd,
          instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingAssociationInsteadOfAggregation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingAssociationInsteadOfAggregation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_ASSOCIATION_INSTEAD_OF_AGGREGATION_COMPOSITION, studentClassAssocEnd,
          instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingCompositionInsteadOfAssociation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingCompositionInsteadOfAssociation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION, studentClassAssocEnd,
          instructorClassAssocEnd));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeUsingAggregationInsteadOfAssociation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (isUsingAggregationInsteadOfAssociation(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(USING_AGGREGATION_COMPOSITION_INSTEAD_OF_ASSOCIATION, studentClassAssocEnd,
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

  public static Optional<Mistake> checkMistakeOtherWrongMultiplicity(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    if (!associationEndMultiplicityMatch(studentClassAssocEnd, instructorClassAssocEnd)) {
      return Optional.of(createMistake(OTHER_WRONG_MULTIPLICITY, studentClassAssocEnd, instructorClassAssocEnd));
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

  public static Optional<Mistake> checkMistakeRoleNamePresentButIncorrect(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    int lDistance = levenshteinDistance(studentClassAssocEnd.getName(), instructorClassAssocEnd.getName());
    if (lDistance > MAX_LEVENSHTEIN_DISTANCE_ALLOWED) {
      return Optional.of(createMistake(OTHER_WRONG_ROLE_NAME, studentClassAssocEnd, instructorClassAssocEnd));
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
      return Optional.of(createMistake(BAD_ASSOCIATION_CLASS_NAME_SPELLING, studentClassAssoc.getAssociationClass(),
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

  public static Optional<Mistake> checkMistakeMissingAssociationClass(Association studentClassAssoc,
      Association instructorClassAssoc) {
    if (isAssociationClassMissing(studentClassAssoc, instructorClassAssoc)) {
      return Optional.of(createMistake(MISSING_ASSOCIATION_CLASS, studentClassAssoc.getAssociationClass(),
          instructorClassAssoc.getAssociationClass()));
    }
    return Optional.empty();
  }

  public static Optional<Mistake> checkMistakeExtraAssociationClass(Association studentClassAssoc,
      Association instructorClassAssoc) {
    if (isAssociationClassExtra(studentClassAssoc, instructorClassAssoc)) {
      return Optional.of(createMistake(EXTRA_ASSOCIATION_CLASS, studentClassAssoc.getAssociationClass(),
          instructorClassAssoc.getAssociationClass()));
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

  public static void checkMistakeWrongEnumerationItems(Comparison comparison) {
    comparison.notMappedInstructorEnumLiterals
        .forEach(cls -> comparison.newMistakes.add(createMistake(WRONG_ENUM_ITEMS, null, cls)));

    comparison.extraStudentEnumLiterals
        .forEach(cls -> comparison.newMistakes.add(createMistake(WRONG_ENUM_ITEMS, cls, null)));
  }


  public static void checkMistakeExtraAttribute(Comparison comparison) {
    comparison.extraStudentAttribute
        .forEach(cls -> comparison.newMistakes.add(createMistake(OTHER_EXTRA_ATTRIBUTE, cls, null)));
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
        comparison.newMistakes.add(createMistake(MISSING_ASSOCIATION_CLASS, null, association.getAssociationClass()));
      }
    }
  }

  public static void checkMistakeExtraAssociation(Comparison comparison) {
    for (Association association : comparison.extraStudentAssociation) {
      comparison.newMistakes.add(createMistake(OTHER_EXTRA_ASSOCIATION, association, null));
      if (association.getAssociationClass() != null) {
        comparison.newMistakes.add(createMistake(EXTRA_ASSOCIATION_CLASS, association.getAssociationClass(), null));
      }
    }
  }

  /**
   * Returns true if the input string is a software engineering term.
   */
  public static boolean isSoftwareEngineeringTerm(String s) {
    final var softwareEnginneringTerms = List.of("data", "record", "table", "info", "class");
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
      return new MaxentTagger("taggers/bidirectional-distsim-wsj-0-18.tagger");
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
