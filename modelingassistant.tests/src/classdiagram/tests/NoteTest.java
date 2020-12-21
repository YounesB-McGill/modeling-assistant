/**
 */
package classdiagram.tests;

import classdiagram.ClassdiagramFactory;
import classdiagram.Note;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Note</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NoteTest extends TestCase {

  /**
   * The fixture for this Note test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Note fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(NoteTest.class);
  }

  /**
   * Constructs a new Note test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NoteTest(String name) {
    super(name);
  }

  /**
   * Sets the fixture for this Note test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(Note fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Note test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Note getFixture() {
    return fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createNote());
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

} //NoteTest
