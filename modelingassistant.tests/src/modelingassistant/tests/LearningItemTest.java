/**
 */
package modelingassistant.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import modelingassistant.LearningItem;
import modelingassistant.ModelingassistantFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Learning Item</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LearningItemTest extends TestCase {

  /**
   * The fixture for this Learning Item test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LearningItem fixture = null;

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
   * Sets the fixture for this Learning Item test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(LearningItem fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Learning Item test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LearningItem getFixture() {
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
    setFixture(ModelingassistantFactory.eINSTANCE.createLearningItem());
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
