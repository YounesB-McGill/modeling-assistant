package ca.mcgill.sel.mistakedetection;

import classdiagram.Association;
import classdiagram.Attribute;
import classdiagram.CDEnum;
import classdiagram.ClassdiagramFactory;
import classdiagram.Classifier;
import org.apache.commons.text.similarity.LevenshteinDistance;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import modelingassistant.Mistake;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.Solution;
import modelingassistant.SolutionElement;
import modelingassistant.mistaketypes.MistakeTypes;

public class MistakeDetection {

  public static final ClassdiagramFactory CDF = ClassdiagramFactory.eINSTANCE;
  public static final ModelingassistantFactory MAF = ModelingassistantFactory.eINSTANCE;

  /** Maps nouns to true if they are plural, false otherwise. */
  static HashMap<String, Boolean> nounPluralStatus = new HashMap<String, Boolean>();

  public static EList<Mistake> newMistakes = new BasicEList<Mistake>();// List of mistakes in
  // current iteration



  /**
   * It maps an instructor solution classifier to student solution classifier
   */
  public static HashMap<Classifier, Classifier> mappedClassifier =
      new HashMap<Classifier, Classifier>();
  /**
   * It maps an instructor solution classifier attribute to student solution classifier attribute
   */
  public static HashMap<Attribute, Attribute> mappedAttribute = new HashMap<Attribute, Attribute>();
  /**
   * It maps an instructor solution classifier relation to student solution classifier relation
   */
  public static HashMap<Association, Association> mappedRelation =
      new HashMap<Association, Association>();

  public static EList<Classifier> notMappedInstructorClassifier = new BasicEList<Classifier>();
  public static EList<Classifier> extraStudentClassifier = new BasicEList<Classifier>();

  public static EList<Attribute> notMappedInstructorAttribute = new BasicEList<Attribute>();
  public static EList<Attribute> extraStudentAttribute = new BasicEList<Attribute>();
  public static EList<Attribute> dulplicateStudentAttribute = new BasicEList<Attribute>();
  // EList<Attribute> wrongStudentAttribute = new EList<Attribute>; // Commented temporarly

  public static EList<Association> notMappedInstructorRelation;

  public static EList<Association> extraStudentRelation;



  public static void compare(Solution instructorSolution, Solution studentSolution) {
    if (isSolutionInstructorSolution(instructorSolution) && isSolutionStudentSolution(studentSolution)) // checks if
    // solution is really instructor solution and vice versa
    {
      clearAttributesAndClassifer();
      newMistakes.clear();
      EList<Classifier> instructorClassifiers = instructorSolution.getClassDiagram().getClasses();
      EList<Classifier> studentClassifiers = studentSolution.getClassDiagram().getClasses();

      int count = 0;
      for (Classifier instructorClassifier : instructorClassifiers) {
        notMappedInstructorClassifier.add(instructorClassifier);
        EList<Attribute> iAttributes = instructorClassifier.getAttributes();
        for (Attribute attribute : iAttributes) {
          notMappedInstructorAttribute.add(attribute);
        }

        for (Classifier studentClassifier : studentClassifiers) {
          if (count == 0) { // To stop duplicate entries.
            extraStudentClassifier.add(studentClassifier);
            EList<Attribute> sAttributes = studentClassifier.getAttributes();
            for (Attribute attribute : sAttributes) {
              extraStudentAttribute.add(attribute);
            }
          }
          if (checkCorrect(instructorClassifier, studentClassifier)) {
            checkMistakeClassSpelling(studentClassifier, instructorClassifier);
            checkMistakeSoftwareEngineeringTerm(studentClassifier);
            checkMistakePluralClassName(studentClassifier);
            checkMistakeLowerClassName(studentClassifier);
            checkMistakeWrongEnumerationClass(studentClassifier, instructorClassifier);
            // checkMistakeWrongEnumerationClassItems(studentClassifier,instructorClassifier);


            EList<Attribute> sAttributes = studentClassifier.getAttributes();// Mapping already done
            // in check
            for (Attribute iAttribute : iAttributes) {
              for (Attribute sAttribute : sAttributes) {
                float lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
                if (lDistance < 3) {
                  // checkMistakeWrongAttributeType(sAttribute,iAttribute);
                  // checkMistakeAttributeStatic(sAttribute,iAttribute);
                }
              }

              // Relationship Loop

            }
          }
        }
        count = 1;
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

      updateMistakes(studentSolution); // This function updates new and older mistakes in the metamodel.
    }
  }

  private static void updateMistakes(Solution studentSolution) {
    ModelingAssistant ma = studentSolution.getModelingAssistant();
    
 // List containing mistakes associated with a student Solution
    EList<Mistake> existingMistakes = new BasicEList<Mistake>(); 
    existingMistakes = studentSolution.getMistakes();
    
 // List containing existing mistakes that are equal to newMistakes
    EList<Mistake> existingMistakesProcessed = new BasicEList<Mistake>(); 

    EList<Mistake> newMistakesToRemove = new BasicEList<Mistake>(); // List containing mistakes to
                                                                    // be removed from new Mistake
                                                                    // List

 // Condition when only new mistakes exists.
    if (existingMistakes.size() == 0 && newMistakes.size() != 0) {
      for (Mistake newMistake : newMistakes) {

        newMistake.setResolved(false);
        newMistake.setNumDetection(1);
        newMistake.setNumDetectionSinceResolved(0);
        newMistake.setStudentSolution(studentSolution);

      }
    } else if (existingMistakes.size() != 0 && newMistakes.size() != 0) {

      for (Mistake existingMistake : existingMistakes) {

        for (Mistake newMistake : newMistakes) {
          if (existingMistake.getMistakeType() == newMistake.getMistakeType()) {
            if (isExistingMistakesHasInstructorAndStudentElements(existingMistake) && isNewMistakesHasInstructorAndStudentElements(newMistake)) {
              if (existingMistake.getStudentElements().get(0).getElement()
                  .equals(newMistake.getStudentElements().get(0).getElement())
                  && existingMistake.getInstructorElements().get(0).getElement()
                      .equals(newMistake.getInstructorElements().get(0).getElement())) {
                
                existingMistake.setResolved(false);
                existingMistake.setNumDetection(existingMistake.getNumDetection() + 1);
                existingMistake.setNumDetectionSinceResolved(0);
                existingMistakesProcessed.add(existingMistake);
                newMistakesToRemove.add(newMistake);
              }
            } else if (isExistingMistakesHasOnlyStudentElements(existingMistake) && isNewMistakesHasOnlyStudentElements(newMistake)) {
              System.out.println(existingMistake.getStudentElements().get(0).getElement());
              System.out.println(newMistake.getStudentElements().get(0).getElement());
              if (existingMistake.getStudentElements().get(0).getElement()
                  .equals(newMistake.getStudentElements().get(0).getElement())) {
               
                existingMistake.setResolved(false);
                existingMistake.setNumDetection(existingMistake.getNumDetection() + 1);
                existingMistake.setNumDetectionSinceResolved(0);
                existingMistakesProcessed.add(existingMistake);
                newMistakesToRemove.add(newMistake);
              }
            } else if (isExistingMistakesHasOnlyInstructorElements(existingMistake) && isNewMistakesHasOnlyInstructorElements(newMistake)) {
              if (existingMistake.getInstructorElements().get(0).getElement()
                  .equals(newMistake.getInstructorElements().get(0).getElement())) {
              
                existingMistake.setResolved(false);
                existingMistake.setNumDetection(existingMistake.getNumDetection() + 1);
                existingMistake.setNumDetectionSinceResolved(0);
                existingMistakesProcessed.add(existingMistake);
                newMistakesToRemove.add(newMistake);
              }
            }
          }

        }

      }
      newMistakes.removeAll(newMistakesToRemove);
     
      for (Mistake existingMistake : existingMistakes) {
        if(!existingMistakesProcessed.contains(existingMistake)) {
                  
        if (existingMistake.getNumDetectionSinceResolved() <= 5 && existingMistake.isResolved() == true) {
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
      
      for (Mistake newMistake : newMistakes) {
        newMistake.setResolved(false);
        newMistake.setNumDetection(1);
        newMistake.setNumDetectionSinceResolved(0);
        newMistake.setStudentSolution(studentSolution);
      }
    } else if (existingMistakes.size() != 0 && newMistakes.size() == 0) {
      for (Mistake existingMistake : existingMistakes) {
        if (existingMistake.getNumDetectionSinceResolved() <= 5) {
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
   * Helper Function which returns true if a existing mistake has both instructor and student elements.
   * */
 private static boolean isExistingMistakesHasInstructorAndStudentElements(Mistake existingMistake) {
   return (existingMistake.getInstructorElements().size() != 0 && existingMistake.getStudentElements().size() != 0);
      
 }
 /**
  * Helper Function which returns true if a new mistake has both instructor and student elements.
  * */
 private static boolean isNewMistakesHasInstructorAndStudentElements(Mistake newMistake) {
   return (newMistake.getInstructorElements().size() != 0 && newMistake.getStudentElements().size() != 0);
      
 }
 /**
  * Helper Function which returns true if a existing mistake has only student elements.
  * */
 private static boolean isExistingMistakesHasOnlyStudentElements(Mistake existingMistake) {
   return (existingMistake.getInstructorElements().size() == 0 && existingMistake.getStudentElements().size() != 0);
      
 }
 /**
  * Helper Function which returns true if a new mistake has only student elements.
  * */
 private static boolean isNewMistakesHasOnlyStudentElements(Mistake newMistake) {
   return (newMistake.getInstructorElements().size() == 0 && newMistake.getStudentElements().size() != 0);
      
 }
 /**
  * Helper Function which returns true if a existing mistake has only instructor elements.
  * */
 private static boolean isExistingMistakesHasOnlyInstructorElements(Mistake existingMistake) {
   return ( existingMistake.getInstructorElements().size() != 0 && existingMistake.getStudentElements().size() == 0);
      
 }
 /**
  * Helper Function which returns true if a new mistake has only instructor elements.
  * */
 private static boolean isNewMistakesHasOnlyInstructorElements(Mistake newMistake) {
   return (newMistake.getInstructorElements().size() != 0 && newMistake.getStudentElements().size() == 0);
      
 }
     
  private static boolean isSolutionStudentSolution(Solution studentSolution) {
 
    return studentSolution.getStudent() != null;

  }
  private static boolean isSolutionInstructorSolution(Solution instructorSolution) {
    
    return instructorSolution.getStudent() == null;
      
  }

  /**
   * Method to check if two classifiers match or not.
   * 
   * @param instructorClassifier
   * @param studentClassifier
   * @return
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
    if (lDistance <= 2) {
      isMapped = true;
      mappedClassifier.put(instructorClassifier, studentClassifier);
      notMappedInstructorClassifier.remove(instructorClassifier);
      extraStudentClassifier.remove(studentClassifier);
    }

    if (isMapped == true) { // Map attributes if classifiers map.

      for (Attribute iAttribute : iAttributes) { // To check association -> Not at present.
        // System.out.println("Instructor "+ iAttribute +" " +instructorClassifier.getName());//FOR
        // DEBUGGING
        for (Attribute sAttribute : sAttributes) {
          // System.out.println("Student "+ sAttribute+" " +studentClassifier.getName());//FOR
          // DEBUGGING

          lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
          if (lDistance <= 2 && mappedAttribute.get(iAttribute) == sAttribute) {
            dulplicateStudentAttribute.add(sAttribute);
            extraStudentAttribute.remove(sAttribute);
          } else if (lDistance <= 2) {
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
                if (lDistance <= 2) {
                  correctAttribute++;
                  break;
                }
              }
            }
            // System.out.println("CorrectAttribute "+ " "+ instructorClassifier.getName() +" "+
            // studentClassifier.getName()+" "+ correctAttribute);
            if (totalAttributes != 0) {
              if (correctAttribute / totalAttributes > 0.5) {
                mappedClassifier.put(instructorClassifier, studentClassifier);
                notMappedInstructorClassifier.remove(instructorClassifier);
                extraStudentClassifier.remove(studentClassifier);
                counter++;
                for (Attribute iAttribute : iAttributes) { // To check association -> Not at
                  // present.
                  for (Attribute sAttribute : sAttributes) {
                    float lDistance =
                        levenshteinDistance(sAttribute.getName(), iAttribute.getName());
                    if (lDistance <= 2) {
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
  public static void checkMistakeSoftwareEngineeringTerm(Classifier studentClassifier) {
    if (isSoftwareEngineeringTerm(studentClassifier.getName())) {
      SolutionElement s = MAF.createSolutionElement();
      s.setElement(studentClassifier);
      Mistake m = MAF.createMistake();
      m.setMistakeType(MistakeTypes.SOFTWARE_ENGINEERING_TERM);// Have a helper Method.
      m.getStudentElements().add(s);
      newMistakes.add(m);


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

  public static void checkMistakePluralClassName(Classifier studentClassifier) {
    if (isPlural(studentClassifier.getName())) {
      SolutionElement s = MAF.createSolutionElement();
      s.setElement(studentClassifier);

      var m = MAF.createMistake();
      m.setMistakeType(MistakeTypes.USING_PLURAL_OR_LOWERCASE);
      m.getStudentElements().add(s);
      newMistakes.add(m);
    }

  }

  public static void checkMistakeClassSpelling(Classifier studentClassifier,
      Classifier instructorClassifier) {
    int lDistance =
        levenshteinDistance(studentClassifier.getName(), instructorClassifier.getName());
    if (lDistance != 0) {
      SolutionElement s = MAF.createSolutionElement();
      s.setElement(studentClassifier);

      var m = MAF.createMistake();
      m.setMistakeType(MistakeTypes.BAD_CLASS_NAME_SPELLING);
      m.getStudentElements().add(s);
      newMistakes.add(m);
    }
  }

  public static int levenshteinDistance(String sClassName, String iClassName) {
    LevenshteinDistance ld = new LevenshteinDistance();
    return ld.apply(sClassName, iClassName);
  }

  public static void checkMistakeLowerClassName(Classifier studentClassifier) {
    if (isLowerName(studentClassifier.getName())) {
      SolutionElement s = MAF.createSolutionElement();
      s.setElement(studentClassifier);

      var m = MAF.createMistake();
      m.setMistakeType(MistakeTypes.USING_PLURAL_OR_LOWERCASE);
      m.getStudentElements().add(s);
      newMistakes.add(m);
    }
  }

  public static boolean isLowerName(String name) {
    if (name.toLowerCase() == name) {
      return true;
    }
    return false;
  }

  public static void checkMistakeWrongEnumerationClass(Classifier studentClassifier,
      Classifier instructorClassifier) {
    if (isEnumerationClass(studentClassifier, instructorClassifier)) {
      SolutionElement s = MAF.createSolutionElement();
      s.setElement(studentClassifier);

      var m = MAF.createMistake();
      m.setMistakeType(MistakeTypes.REGULAR_CLASS_SHOULD_BE_AN_ENUMERATION_OR_VICE_VERSA);
      m.getStudentElements().add(s);
      newMistakes.add(m);

    } else if (isNotEnumerationClass(studentClassifier, instructorClassifier)) {
      SolutionElement s = MAF.createSolutionElement();
      s.setElement(studentClassifier);

      var m = MAF.createMistake();
      m.setMistakeType(MistakeTypes.REGULAR_CLASS_SHOULD_BE_AN_ENUMERATION_OR_VICE_VERSA);
      m.getStudentElements().add(s);
      newMistakes.add(m);
    }
  }

  public static boolean isEnumerationClass(Classifier studentClassifier,
      Classifier instructorClassifier) {

    if (instructorClassifier instanceof CDEnum && studentClassifier instanceof CDEnum) {
      return true;
    }
    return false;
  }

  public static boolean isNotEnumerationClass(Classifier studentClassifier,
      Classifier instructorClassifier) {

    if (instructorClassifier instanceof CDEnum && studentClassifier instanceof CDEnum) {
      return true;
    }
    return false;
  }


  /***
   * This is a fuunction created for testing the logic. Only for test.
   * 
   * @param instructorClassifier
   * @param studentClassifier
   * @return
   */
  public static boolean checkCorrectTest(Classifier instructorClassifier,
      Classifier studentClassifier) {
    clearAttributesAndClassifer();
    boolean flag = false;
    EList<Attribute> iAttributes = instructorClassifier.getAttributes();
    EList<Attribute> sAttributes = studentClassifier.getAttributes();


    notMappedInstructorClassifier.add(instructorClassifier);
    extraStudentClassifier.add(studentClassifier);

    int totalAttibutes = iAttributes.size();
    int correctAttribute = 0;
    float lDistance =
        levenshteinDistance(studentClassifier.getName(), instructorClassifier.getName());
    if (lDistance <= 2) {
      flag = true;
      mappedClassifier.put(instructorClassifier, studentClassifier);
      notMappedInstructorClassifier.remove(instructorClassifier);
      extraStudentClassifier.remove(studentClassifier);
    } else {
      for (Attribute iAttribute : iAttributes) { // To check association -> Not at present.
        for (Attribute sAttribute : sAttributes) {
          lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
          if (lDistance <= 2) {
            correctAttribute++;
            break;
          }
        }
      }
    }
    if (totalAttibutes != 0) {
      if (correctAttribute / totalAttibutes > 0.5 && flag == false) {
        mappedClassifier.put(instructorClassifier, studentClassifier);
        notMappedInstructorClassifier.remove(instructorClassifier);
        extraStudentClassifier.remove(studentClassifier);

        flag = true;
      }
    }

    if (flag == true) { // Map attributes if classifiers map.
      int count = 0;
      for (Attribute iAttribute : iAttributes) { // To check association -> Not at present.
        notMappedInstructorAttribute.add(iAttribute);
        for (Attribute sAttribute : sAttributes) {

          if (count != 1) // To stop duplicate entries.
            extraStudentAttribute.add(sAttribute);


          lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
          if (lDistance <= 2 && mappedAttribute.containsValue(sAttribute)) {
            dulplicateStudentAttribute.add(sAttribute);
            extraStudentAttribute.remove(sAttribute);
          } else if (lDistance <= 2) {
            mappedAttribute.put(iAttribute, sAttribute);
            notMappedInstructorAttribute.remove(iAttribute);
            extraStudentAttribute.remove(sAttribute);
            break;
          }
        }

        count = 1;
      }
    }

    return flag;
  }

  public static void clearAttributesAndClassifer() {
    mappedClassifier.clear();
    extraStudentClassifier.clear();
    notMappedInstructorClassifier.clear();
    mappedAttribute.clear();
    extraStudentAttribute.clear();
    notMappedInstructorAttribute.clear();
    dulplicateStudentAttribute.clear();

  }

  public static void showMistakes() {
    for (Mistake m : newMistakes) {
      System.out.println(m.getMistakeType().getName() + " in "
          + m.getStudentElements().get(0).getElement().getName());
    }
  }
}
