/**
 */
package modelingassistant.tests;

import junit.textui.TestRunner;

import modelingassistant.ModelingassistantFactory;
import modelingassistant.Synonym;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Synonym</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SynonymTest extends NamedElementTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(SynonymTest.class);
  }

  /**
   * Constructs a new Synonym test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SynonymTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Synonym test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Synonym getFixture() {
    return (Synonym)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ModelingassistantFactory.eINSTANCE.createSynonym());
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

} //SynonymTest
