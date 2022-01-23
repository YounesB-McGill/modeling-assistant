/**
 */
package learningcorpusquiz.tests;

import junit.textui.TestRunner;

import learningcorpus.tests.QuizTest;

import learningcorpusquiz.LearningcorpusquizFactory;
import learningcorpusquiz.ListMultipleChoiceQuiz;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>List Multiple Choice Quiz</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ListMultipleChoiceQuizTest extends QuizTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(ListMultipleChoiceQuizTest.class);
  }

  /**
   * Constructs a new List Multiple Choice Quiz test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListMultipleChoiceQuizTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this List Multiple Choice Quiz test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected ListMultipleChoiceQuiz getFixture() {
    return (ListMultipleChoiceQuiz)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(LearningcorpusquizFactory.eINSTANCE.createListMultipleChoiceQuiz());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#tearDown()
   * @generated
   */
  @Override
  protected void tearDown() throws Exception {
    setFixture(null);
  }

} //ListMultipleChoiceQuizTest
