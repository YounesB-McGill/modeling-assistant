/**
 */
package classdiagram.tests;

import classdiagram.AssociationEnd;
import classdiagram.ClassdiagramFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Association End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link classdiagram.AssociationEnd#getOppositeEnd() <em>Get Opposite End</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class AssociationEndTest extends StructuralFeatureTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(AssociationEndTest.class);
  }

  /**
   * Constructs a new Association End test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationEndTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Association End test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected AssociationEnd getFixture() {
    return (AssociationEnd)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createAssociationEnd());
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
   * Tests the '{@link classdiagram.AssociationEnd#getOppositeEnd() <em>Get Opposite End</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.AssociationEnd#getOppositeEnd()
   * @generated NOT
   */
  public void testGetOppositeEnd() {
    // TODO: implement this operation test method
  }

} //AssociationEndTest
