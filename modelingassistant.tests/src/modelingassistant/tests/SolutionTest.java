/**
 */
package modelingassistant.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import modelingassistant.ModelingassistantFactory;
import modelingassistant.Solution;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SolutionTest extends TestCase {

  /**
   * The fixture for this Solution test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Solution fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(SolutionTest.class);
  }

  /**
   * Constructs a new Solution test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SolutionTest(String name) {
    super(name);
  }

  /**
   * Sets the fixture for this Solution test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(Solution fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Solution test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Solution getFixture() {
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
    setFixture(ModelingassistantFactory.eINSTANCE.createSolution());
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

} //SolutionTest
