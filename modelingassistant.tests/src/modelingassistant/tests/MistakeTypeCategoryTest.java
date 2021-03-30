/**
 */
package modelingassistant.tests;

import junit.textui.TestRunner;

import modelingassistant.MistakeTypeCategory;
import modelingassistant.ModelingassistantFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Mistake Type Category</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MistakeTypeCategoryTest extends NamedElementTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(MistakeTypeCategoryTest.class);
  }

  /**
   * Constructs a new Mistake Type Category test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeTypeCategoryTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Mistake Type Category test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected MistakeTypeCategory getFixture() {
    return (MistakeTypeCategory)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ModelingassistantFactory.eINSTANCE.createMistakeTypeCategory());
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

} //MistakeTypeCategoryTest
