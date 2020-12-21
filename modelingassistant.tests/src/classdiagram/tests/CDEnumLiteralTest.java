/**
 */
package classdiagram.tests;

import classdiagram.CDEnumLiteral;
import classdiagram.ClassdiagramFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>CD Enum Literal</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CDEnumLiteralTest extends NamedElementTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(CDEnumLiteralTest.class);
  }

  /**
   * Constructs a new CD Enum Literal test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CDEnumLiteralTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this CD Enum Literal test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected CDEnumLiteral getFixture() {
    return (CDEnumLiteral)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createCDEnumLiteral());
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

} //CDEnumLiteralTest
