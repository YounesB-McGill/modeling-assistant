/**
 */
package classdiagram.tests;

import classdiagram.CDSequence;
import classdiagram.ClassdiagramFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>CD Sequence</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CDSequenceTest extends CDCollectionTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(CDSequenceTest.class);
  }

  /**
   * Constructs a new CD Sequence test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CDSequenceTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this CD Sequence test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected CDSequence getFixture() {
    return (CDSequence)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createCDSequence());
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

} //CDSequenceTest
