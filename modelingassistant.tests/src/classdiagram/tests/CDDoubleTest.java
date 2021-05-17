/**
 */
package classdiagram.tests;

import classdiagram.CDDouble;
import classdiagram.ClassdiagramFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>CD Double</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link classdiagram.CDDouble#getName() <em>Get Name</em>}</li>
 *   <li>{@link classdiagram.CDDouble#getInstanceClassName() <em>Get Instance Class Name</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class CDDoubleTest extends PrimitiveTypeTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(CDDoubleTest.class);
  }

  /**
   * Constructs a new CD Double test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CDDoubleTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this CD Double test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected CDDouble getFixture() {
    return (CDDouble)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createCDDouble());
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
   * Tests the '{@link classdiagram.CDDouble#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.CDDouble#getName()
   * @generated NOT
   */
  public void testGetName() {
    // TODO: implement this operation test method
  }

  /**
   * Tests the '{@link classdiagram.CDDouble#getInstanceClassName() <em>Get Instance Class Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.CDDouble#getInstanceClassName()
   * @generated NOT
   */
  public void testGetInstanceClassName() {
    // TODO: implement this operation test method
  }

} //CDDoubleTest
