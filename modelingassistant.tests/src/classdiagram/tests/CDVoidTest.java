/**
 */
package classdiagram.tests;

import classdiagram.CDVoid;
import classdiagram.ClassdiagramFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>CD Void</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link classdiagram.CDVoid#getName() <em>Get Name</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class CDVoidTest extends ObjectTypeTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(CDVoidTest.class);
  }

  /**
   * Constructs a new CD Void test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CDVoidTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this CD Void test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected CDVoid getFixture() {
    return (CDVoid)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createCDVoid());
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
   * Tests the '{@link classdiagram.CDVoid#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.CDVoid#getName()
   * @generated
   */
  public void testGetName() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

} //CDVoidTest
