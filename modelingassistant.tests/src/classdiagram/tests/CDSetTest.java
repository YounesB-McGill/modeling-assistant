/**
 */
package classdiagram.tests;

import classdiagram.CDSet;
import classdiagram.ClassdiagramFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>CD Set</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CDSetTest extends CDCollectionTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(CDSetTest.class);
  }

  /**
   * Constructs a new CD Set test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CDSetTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this CD Set test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected CDSet getFixture() {
    return (CDSet)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createCDSet());
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

} //CDSetTest
