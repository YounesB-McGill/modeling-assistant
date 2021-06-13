/**
 */
package learningcorpus.tests;

import junit.textui.TestRunner;

import learningcorpus.LearningResource;
import learningcorpus.LearningcorpusFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Learning Resource</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LearningResourceTest extends NamedElementTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(LearningResourceTest.class);
  }

  /**
   * Constructs a new Learning Resource test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningResourceTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Learning Resource test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected LearningResource getFixture() {
    return (LearningResource)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(LearningcorpusFactory.eINSTANCE.createLearningResource());
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

} //LearningResourceTest
