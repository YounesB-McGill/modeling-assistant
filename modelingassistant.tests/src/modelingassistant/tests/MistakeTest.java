/**
 */
package modelingassistant.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Mistake</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MistakeTest extends TestCase {

  /**
   * The fixture for this Mistake test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Mistake fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(MistakeTest.class);
  }

  /**
   * Constructs a new Mistake test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeTest(String name) {
    super(name);
  }

  /**
   * Sets the fixture for this Mistake test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(Mistake fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Mistake test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Mistake getFixture() {
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
    setFixture(ModelingassistantFactory.eINSTANCE.createMistake());
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

} //MistakeTest
