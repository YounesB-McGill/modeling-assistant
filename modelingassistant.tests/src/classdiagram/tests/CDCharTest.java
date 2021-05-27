/**
 */
package classdiagram.tests;

import classdiagram.CDChar;
import classdiagram.ClassdiagramFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>CD Char</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link classdiagram.CDChar#getName() <em>Get Name</em>}</li>
 *   <li>{@link classdiagram.CDChar#getInstanceClassName() <em>Get Instance Class Name</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class CDCharTest extends PrimitiveTypeTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(CDCharTest.class);
  }

  /**
   * Constructs a new CD Char test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CDCharTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this CD Char test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected CDChar getFixture() {
    return (CDChar)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createCDChar());
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

  /**
   * Tests the '{@link classdiagram.CDChar#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.CDChar#getName()
   * @generated NOT
   */
  public void testGetName() {
    // TODO: implement this operation test method
  }

  /**
   * Tests the '{@link classdiagram.CDChar#getInstanceClassName() <em>Get Instance Class Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.CDChar#getInstanceClassName()
   * @generated NOT
   */
  public void testGetInstanceClassName() {
  }

} //CDCharTest
