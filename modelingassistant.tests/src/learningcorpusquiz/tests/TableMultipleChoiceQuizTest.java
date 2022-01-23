/**
 */
package learningcorpusquiz.tests;

import junit.textui.TestRunner;

import learningcorpus.tests.QuizTest;

import learningcorpusquiz.LearningcorpusquizFactory;
import learningcorpusquiz.TableMultipleChoiceQuiz;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Table Multiple Choice Quiz</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TableMultipleChoiceQuizTest extends QuizTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(TableMultipleChoiceQuizTest.class);
  }

  /**
   * Constructs a new Table Multiple Choice Quiz test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TableMultipleChoiceQuizTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Table Multiple Choice Quiz test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected TableMultipleChoiceQuiz getFixture() {
    return (TableMultipleChoiceQuiz)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(LearningcorpusquizFactory.eINSTANCE.createTableMultipleChoiceQuiz());
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

} //TableMultipleChoiceQuizTest
