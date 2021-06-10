/**
 */
package learningcorpus.tests;

import junit.textui.TestRunner;

import learningcorpus.LearningItem;
import learningcorpus.LearningcorpusFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Learning Item</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LearningItemTest extends NamedElementTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(LearningItemTest.class);
  }

  /**
   * Constructs a new Learning Item test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningItemTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Learning Item test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected LearningItem getFixture() {
    return (LearningItem)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(LearningcorpusFactory.eINSTANCE.createLearningItem());
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

} //LearningItemTest
