/**
 */
package learningcorpus.tests;

import junit.textui.TestRunner;

import learningcorpus.LearningcorpusFactory;
import learningcorpus.ParametrizedResponse;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Parametrized Response</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParametrizedResponseTest extends FeedbackTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(ParametrizedResponseTest.class);
  }

  /**
   * Constructs a new Parametrized Response test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParametrizedResponseTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Parametrized Response test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected ParametrizedResponse getFixture() {
    return (ParametrizedResponse)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(LearningcorpusFactory.eINSTANCE.createParametrizedResponse());
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

} //ParametrizedResponseTest
