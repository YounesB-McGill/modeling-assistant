/**
 */
package learningcorpus.tests;

import junit.textui.TestRunner;

import learningcorpus.LearningcorpusFactory;
import learningcorpus.ResourceResponse;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Resource Response</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourceResponseTest extends FeedbackTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(ResourceResponseTest.class);
  }

  /**
   * Constructs a new Resource Response test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResourceResponseTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Resource Response test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected ResourceResponse getFixture() {
    return (ResourceResponse)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(LearningcorpusFactory.eINSTANCE.createResourceResponse());
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

} //ResourceResponseTest
