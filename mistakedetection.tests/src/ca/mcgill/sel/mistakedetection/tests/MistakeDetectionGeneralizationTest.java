package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static org.junit.Assert.assertTrue;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.mistakedetection.MistakeDetection;

public class MistakeDetectionGeneralizationTest {

  String instructorCDMPath = "../mistakedetection/testModels/InstructorSolution/ModelToTestGeneralization/";
  String studentCDMPath = "../mistakedetection/testModels/StudentSolution/ModelToTestGeneralization/";

  /**
   * Test to check generalization structure .
   */
  @Test
  public void testToCheckGenerailzationTree() {
    var instructorClassDiagram = cdmFromFile(
        instructorCDMPath +"instructor_two_subClasses/Class Diagram/Two_subClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        studentCDMPath +"student_two_subClasses/Class Diagram/Two_subClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var instCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var instTATAManzaClass = getClassFromClassDiagram("TATAManza", instructorClassDiagram);
    var instHondaCity = getClassFromClassDiagram("HondaCity", instructorClassDiagram);

    var studCarClass = getClassFromClassDiagram("Car", studentClassDiagram);
    var studTATAManzaClass = getClassFromClassDiagram("TATAManza", studentClassDiagram);
    var studHondaCity = getClassFromClassDiagram("HondaCity", studentClassDiagram);

    EList<Classifier> instClasses = new BasicEList<Classifier>();
    instClasses.add(instTATAManzaClass);
    instClasses.add(instHondaCity);

    EList<Classifier> studClasses = new BasicEList<Classifier>();
    studClasses.add(studTATAManzaClass);
    studClasses.add(studHondaCity);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    assertTrue(comparison.instructorGeneraltionTree.containsKey(instCarClass));
    assertTrue(comparison.studentGeneraltionTree.containsKey(studCarClass));

    for(Classifier Class : comparison.instructorGeneraltionTree.get(instCarClass)){
      assertTrue(instClasses.contains(Class));
    }
    for(Classifier Class : comparison.studentGeneraltionTree.get(studCarClass)){
      assertTrue(studClasses.contains(Class));
    }
    //MistakeDetectionTest.log(comparison);
  }

  /**
   * Test to check generalization structure .
   */
  @Test
  public void testToCheckGenerailzationTreeWithDiifInput() {
    var instructorClassDiagram = cdmFromFile(
        instructorCDMPath + "instructor_multiSubClasses/Class Diagram/MultiSubClasses.domain_model.cdm");
    var instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);

    var studentClassDiagram = cdmFromFile(
        instructorCDMPath + "instructor_multiSubClasses/Class Diagram/MultiSubClasses.domain_model.cdm");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution);

    var instCarClass = getClassFromClassDiagram("Car", instructorClassDiagram);
    var instTATAManzaClass = getClassFromClassDiagram("TATAManza", instructorClassDiagram);
    var instTATAManzaModel2Class = getClassFromClassDiagram("TATAManzaModel2", instructorClassDiagram);
    var instTATAManzaModel3Class = getClassFromClassDiagram("TATAManzaModel3", instructorClassDiagram);

    assertTrue(comparison.instructorGeneraltionTree.containsKey(instCarClass));
    assertTrue(comparison.instructorGeneraltionTree.containsKey(instTATAManzaClass));
    assertTrue(comparison.instructorGeneraltionTree.containsKey(instTATAManzaModel2Class));
    assertTrue(comparison.instructorGeneraltionTree.containsKey(instTATAManzaModel3Class));
   // MistakeDetectionTest.log(comparison);


  }

}
