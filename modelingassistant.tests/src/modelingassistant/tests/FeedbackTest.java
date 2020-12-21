/**
 */
package modelingassistant.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import modelingassistant.Feedback;
import modelingassistant.ModelingassistantFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Feedback</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FeedbackTest extends TestCase {

  /**
   * The fixture for this Feedback test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Feedback fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(FeedbackTest.class);
  }

  /**
   * Constructs a new Feedback test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeedbackTest(String name) {
    super(name);
  }

  /**
   * Sets the fixture for this Feedback test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(Feedback fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Feedback test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Feedback getFixture() {
    return fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ModelingassistantFactory.eINSTANCE.createFeedback());
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

} //FeedbackTest
