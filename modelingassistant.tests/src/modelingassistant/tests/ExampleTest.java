/**
 */
package modelingassistant.tests;

import junit.textui.TestRunner;

import modelingassistant.Example;
import modelingassistant.ModelingassistantFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Example</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExampleTest extends LearningResourceTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(ExampleTest.class);
  }

  /**
   * Constructs a new Example test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExampleTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Example test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Example getFixture() {
    return (Example)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ModelingassistantFactory.eINSTANCE.createExample());
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

} //ExampleTest
