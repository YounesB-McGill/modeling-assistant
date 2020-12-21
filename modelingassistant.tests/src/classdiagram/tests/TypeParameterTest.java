/**
 */
package classdiagram.tests;

import classdiagram.ClassdiagramFactory;
import classdiagram.TypeParameter;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypeParameterTest extends TypeTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(TypeParameterTest.class);
  }

  /**
   * Constructs a new Type Parameter test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeParameterTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Type Parameter test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected TypeParameter getFixture() {
    return (TypeParameter)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createTypeParameter());
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

} //TypeParameterTest
