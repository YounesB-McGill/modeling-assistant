/**
 */
package modelingassistant.tests;

import junit.textui.TestRunner;

import modelingassistant.ModelingassistantFactory;
import modelingassistant.ProblemStatementElement;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Problem Statement Element</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProblemStatementElementTest extends NamedElementTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(ProblemStatementElementTest.class);
  }

  /**
   * Constructs a new Problem Statement Element test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProblemStatementElementTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Problem Statement Element test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected ProblemStatementElement getFixture() {
    return (ProblemStatementElement)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ModelingassistantFactory.eINSTANCE.createProblemStatementElement());
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

} //ProblemStatementElementTest
