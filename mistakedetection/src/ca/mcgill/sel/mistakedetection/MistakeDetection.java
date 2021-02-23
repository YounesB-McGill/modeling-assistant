package ca.mcgill.sel.mistakedetection;

import classdiagram.Association;
import classdiagram.Attribute;
import classdiagram.ClassdiagramFactory;
import classdiagram.Classifier;
import org.apache.commons.text.similarity.LevenshteinDistance;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.Solution;
import modelingassistant.SolutionElement;

public class MistakeDetection {

  public static final ClassdiagramFactory CDF = ClassdiagramFactory.eINSTANCE;
  public static final ModelingassistantFactory MAF = ModelingassistantFactory.eINSTANCE;

  /** Maps nouns to true if they are plural, false otherwise. */
  static HashMap<String, Boolean> nounPluralStatus = new HashMap<String, Boolean>();

  static EList<Mistake> mistakes;
  public static HashMap<Classifier, Classifier> mappedClassifier = new HashMap<Classifier, Classifier>();
  public static HashMap<Attribute, Attribute> mappedAttribute = new HashMap<Attribute, Attribute>();
  public static HashMap<Association, Association> mappedRelation = new HashMap<Association, Association>();

  public static EList<Classifier> notMappedInstructorClassifier =  new BasicEList<Classifier>() ;
  public  static EList<Classifier> extraStudentClassifier =  new BasicEList<Classifier>() ;

  public static EList<Attribute> notMappedInstructorAttribute =  new BasicEList<Attribute>();
  public static EList<Attribute> extraStudentAttribute =  new BasicEList<Attribute>();
  public static EList<Attribute> dulpicateStudentAttribute =  new BasicEList<Attribute>();
  // EList<Attribute> wrongStudentAttribute = new EList<Attribute>; // Commented temporarly

  public static EList<Association> notMappedInstructorRelation;
       
  public static EList<Association> extraStudentRelation; 



  public static void compare(Solution instructor, Solution student) {
    EList<Classifier> instructorClassifiers = instructor.getClassDiagram().getClasses();
    EList<Classifier> studentClassifiers = student.getClassDiagram().getClasses();

    int count = 0;
    for (Classifier instructorClassifier : instructorClassifiers) {
      notMappedInstructorClassifier.add(instructorClassifier);
      EList<Attribute> iAttributes = instructorClassifier.getAttributes();
      for (Attribute attribute : iAttributes) {
        notMappedInstructorAttribute.add(attribute);
      }
      
      for (Classifier studentClassifier : studentClassifiers) {
        if (count == 0) // To stop duplicate entries.
          extraStudentClassifier.add(studentClassifier);

        if (checkCorrect(instructorClassifier, studentClassifier)) {
          checkMistakeClassSpelling(studentClassifier, instructorClassifier);
          checkMistakeSoftwareEngineeringTerm(studentClassifier);
          checkMistakePluralClassName(studentClassifier);
          checkMistakeLowerClassName(studentClassifier);
          // checkMistakeWrongEnumerationClass(studentClassifier,instructorClassifier);
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
    // checkMistakeMissingClass();
    // checkMistakeExtraClass();
    // checkMistakeDuplicateAttributes();
    // checkMistakeExtraAttribute();
    // checkMistakeMissingAttribute();
    // checkMistakeWrongAttribute();
    // checkMistakeAttributeMisplaced();
    // checkMistakeIncompleteContainmentTree(studentClassifiers);


  }

  /**
   * Method to check if two classifiers match or not.
   * @param instructorClassifier
   * @param studentClassifier
   * @return
   */
  public static boolean checkCorrect(Classifier instructorClassifier, Classifier studentClassifier) {
    boolean flag = false;
    EList<Attribute> iAttributes = instructorClassifier.getAttributes();
    EList<Attribute> sAttributes = studentClassifier.getAttributes();
    // System.out.println("Function called with i="+ instructorClassifier.getName() +" s=" +studentClassifier.getName()); //FOR DEBUGGING
    int totalAttibutes = iAttributes.size();
    int correctAttribute = 0;
    float lDistance = levenshteinDistance(studentClassifier.getName(), instructorClassifier.getName());
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
    if(totalAttibutes!=0) {
    if (correctAttribute / totalAttibutes > 0.5 && flag == false) {
    //  mappedClassifier.put(instructorClassifier, studentClassifier);
  //    notMappedInstructorClassifier.remove(instructorClassifier);
   //   extraStudentClassifier.remove(studentClassifier);

   //   flag = true;
    }
    }
   ;
    if (flag == true) { // Map attributes if classifiers map.
      int count = 0;
      for (Attribute iAttribute : iAttributes) { // To check association -> Not at present.
     //   System.out.println("Instructor "+ iAttribute +" " +instructorClassifier.getName());//FOR DEBUGGING
        for (Attribute sAttribute : sAttributes) {
        //  System.out.println("Student "+ sAttribute+" " +studentClassifier.getName());//FOR DEBUGGING
          if (count != 1) // To stop duplicate entries.
            extraStudentAttribute.add(sAttribute);


          lDistance = levenshteinDistance(sAttribute.getName(), iAttribute.getName());
          if (lDistance <= 2 && mappedAttribute.get(iAttribute)==sAttribute) {
            dulpicateStudentAttribute.add(sAttribute);
            extraStudentAttribute.remove(sAttribute);
          } else if (lDistance <=2) {
           // System.out.println("Mapped");
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


  /**
   * Checks for a software engineering term in a given classifier.
   */
  public static void checkMistakeSoftwareEngineeringTerm(Classifier studentClassifier) {
    if (isSoftwareEngineeringTerm(studentClassifier.getName())) {
      SolutionElement s = MAF.createSolutionElement();
      s.setElement(studentClassifier);
      Mistake m = MAF.createMistake();
      m.setMistakeType(MistakeTypes.SOFTWARE_ENGINEERING_TERM);// Have a helper Method.
      m.getSolutionElements().add(s);
      mistakes.add(m);
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
      var mistake = MAF.createMistake();
      mistake.setMistakeType(MistakeTypes.PLURAL_CLASS_NAME);

    }
 
  }

  public static void checkMistakeClassSpelling(Classifier studentClassifier,
      Classifier instructorClassifier) {
    int lDistance =
        levenshteinDistance(studentClassifier.getName(), instructorClassifier.getName());
    if (lDistance != 0) {
      // Mistake m = new Mistake("Class Name Spelled wrong");
      // SolutionElement s = new SolutionElement(studentClassifier);
      // m.getSolutionElements().add(s);
      // mistakes.add(m);
    }
  }

  public static int levenshteinDistance(String sClassName, String iClassName) {
    LevenshteinDistance ld = new LevenshteinDistance();
    return ld.apply(sClassName, iClassName);
  }

  public static void checkMistakeLowerClassName(Classifier studentClassifier) {
    if (isLowerName(studentClassifier.getName())) {

    }
  }

  public static boolean isLowerName(String name) {
    if (name.toLowerCase() == name) {
      return true;
    }
    return false;
  }
  
    /***
     * This is a fuunction created for testing the logic. Only for test.
     * @param instructorClassifier
     * @param studentClassifier
     * @return
     */
    public static boolean checkCorrectTest(Classifier instructorClassifier, Classifier studentClassifier) {
    boolean flag = false;
    EList<Attribute> iAttributes = instructorClassifier.getAttributes();
    EList<Attribute> sAttributes = studentClassifier.getAttributes();
    
    
    notMappedInstructorClassifier.add(instructorClassifier);
    extraStudentClassifier.add(studentClassifier);
   
    int totalAttibutes = iAttributes.size();
    int correctAttribute = 0;
    float lDistance = levenshteinDistance(studentClassifier.getName(), instructorClassifier.getName());
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
    if(totalAttibutes!=0) {
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
            dulpicateStudentAttribute.add(sAttribute);
            extraStudentAttribute.remove(sAttribute);
          } else if (lDistance <=2) {
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
}
