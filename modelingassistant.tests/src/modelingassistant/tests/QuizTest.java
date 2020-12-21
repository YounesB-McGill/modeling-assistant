/**
 */
package modelingassistant.tests;

import junit.textui.TestRunner;

import modelingassistant.ModelingassistantFactory;
import modelingassistant.Quiz;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Quiz</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class QuizTest extends LearningResourceTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(QuizTest.class);
  }

  /**
   * Constructs a new Quiz test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QuizTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Quiz test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Quiz getFixture() {
    return (Quiz)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ModelingassistantFactory.eINSTANCE.createQuiz());
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

} //QuizTest
