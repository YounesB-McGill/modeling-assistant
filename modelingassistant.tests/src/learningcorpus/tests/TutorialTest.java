/**
 */
package learningcorpus.tests;

import junit.textui.TestRunner;

import learningcorpus.LearningcorpusFactory;
import learningcorpus.Tutorial;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Tutorial</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TutorialTest extends LearningResourceTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(TutorialTest.class);
  }

  /**
   * Constructs a new Tutorial test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TutorialTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Tutorial test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Tutorial getFixture() {
    return (Tutorial)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(LearningcorpusFactory.eINSTANCE.createTutorial());
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

} //TutorialTest
