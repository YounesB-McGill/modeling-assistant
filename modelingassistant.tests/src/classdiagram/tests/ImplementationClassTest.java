/**
 */
package classdiagram.tests;

import classdiagram.ClassdiagramFactory;
import classdiagram.ImplementationClass;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Implementation Class</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImplementationClassTest extends ClassifierTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(ImplementationClassTest.class);
  }

  /**
   * Constructs a new Implementation Class test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImplementationClassTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Implementation Class test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected ImplementationClass getFixture() {
    return (ImplementationClass)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createImplementationClass());
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

} //ImplementationClassTest
