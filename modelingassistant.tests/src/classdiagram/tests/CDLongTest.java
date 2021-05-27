/**
 */
package classdiagram.tests;

import classdiagram.CDLong;
import classdiagram.ClassdiagramFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>CD Long</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link classdiagram.CDLong#getName() <em>Get Name</em>}</li>
 *   <li>{@link classdiagram.CDLong#getInstanceClassName() <em>Get Instance Class Name</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class CDLongTest extends PrimitiveTypeTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(CDLongTest.class);
  }

  /**
   * Constructs a new CD Long test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CDLongTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this CD Long test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected CDLong getFixture() {
    return (CDLong)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createCDLong());
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
   * Tests the '{@link classdiagram.CDLong#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.CDLong#getName()
   * @generated NOT
   */
  public void testGetName() {
    // TODO: implement this operation test method
  }

  /**
   * Tests the '{@link classdiagram.CDLong#getInstanceClassName() <em>Get Instance Class Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.CDLong#getInstanceClassName()
   * @generated NOT
   */
  public void testGetInstanceClassName() {
    // TODO: implement this operation test method
  }

} //CDLongTest
