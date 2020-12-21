/**
 */
package modelingassistant.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Modeling Assistant</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelingAssistantTest extends TestCase {

  /**
   * The fixture for this Modeling Assistant test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelingAssistant fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(ModelingAssistantTest.class);
  }

  /**
   * Constructs a new Modeling Assistant test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingAssistantTest(String name) {
    super(name);
  }

  /**
   * Sets the fixture for this Modeling Assistant test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(ModelingAssistant fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Modeling Assistant test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelingAssistant getFixture() {
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
    setFixture(ModelingassistantFactory.eINSTANCE.createModelingAssistant());
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

} //ModelingAssistantTest
