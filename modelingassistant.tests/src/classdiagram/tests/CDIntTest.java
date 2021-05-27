/**
 */
package classdiagram.tests;

import classdiagram.CDInt;
import classdiagram.ClassdiagramFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>CD Int</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link classdiagram.CDInt#getName() <em>Get Name</em>}</li>
 *   <li>{@link classdiagram.CDInt#getInstanceClassName() <em>Get Instance Class Name</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class CDIntTest extends PrimitiveTypeTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(CDIntTest.class);
  }

  /**
   * Constructs a new CD Int test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CDIntTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this CD Int test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected CDInt getFixture() {
    return (CDInt)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createCDInt());
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
   * Tests the '{@link classdiagram.CDInt#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.CDInt#getName()
   * @generated NOT
   */
  public void testGetName() {
    // TODO: implement this operation test method
  }

  /**
   * Tests the '{@link classdiagram.CDInt#getInstanceClassName() <em>Get Instance Class Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.CDInt#getInstanceClassName()
   * @generated NOT
   */
  public void testGetInstanceClassName() {
    // TODO: implement this operation test method
  }

} //CDIntTest
