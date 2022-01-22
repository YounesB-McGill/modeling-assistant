/**
 */
package learningcorpusquiz.tests;

import junit.textui.TestRunner;

import learningcorpus.tests.QuizTest;

import learningcorpusquiz.FillInTheBlanksQuiz;
import learningcorpusquiz.LearningcorpusquizFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Fill In The Blanks Quiz</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FillInTheBlanksQuizTest extends QuizTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(FillInTheBlanksQuizTest.class);
  }

  /**
   * Constructs a new Fill In The Blanks Quiz test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FillInTheBlanksQuizTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Fill In The Blanks Quiz test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected FillInTheBlanksQuiz getFixture() {
    return (FillInTheBlanksQuiz)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(LearningcorpusquizFactory.eINSTANCE.createFillInTheBlanksQuiz());
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

} //FillInTheBlanksQuizTest
