/**
 */
package learningcorpus.tests;

import junit.textui.TestRunner;

import learningcorpus.LearningcorpusFactory;
import learningcorpus.TextResponse;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Text Response</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TextResponseTest extends FeedbackTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(TextResponseTest.class);
  }

  /**
   * Constructs a new Text Response test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TextResponseTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Text Response test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected TextResponse getFixture() {
    return (TextResponse)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(LearningcorpusFactory.eINSTANCE.createTextResponse());
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

} //TextResponseTest
