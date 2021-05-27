/**
 */
package classdiagram.tests;

import classdiagram.CDAny;
import classdiagram.ClassdiagramFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>CD Any</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link classdiagram.CDAny#getName() <em>Get Name</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class CDAnyTest extends ObjectTypeTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(CDAnyTest.class);
  }

  /**
   * Constructs a new CD Any test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CDAnyTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this CD Any test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected CDAny getFixture() {
    return (CDAny)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createCDAny());
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
   * Tests the '{@link classdiagram.CDAny#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.CDAny#getName()
   * @generated NOT
   */
  public void testGetName() {
    // TODO: implement this operation test method
  }

} //CDAnyTest
