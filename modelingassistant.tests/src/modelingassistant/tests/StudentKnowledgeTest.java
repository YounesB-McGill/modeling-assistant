/**
 */
package modelingassistant.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import modelingassistant.ModelingassistantFactory;
import modelingassistant.StudentKnowledge;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Student Knowledge</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StudentKnowledgeTest extends TestCase {

  /**
   * The fixture for this Student Knowledge test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StudentKnowledge fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(StudentKnowledgeTest.class);
  }

  /**
   * Constructs a new Student Knowledge test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StudentKnowledgeTest(String name) {
    super(name);
  }

  /**
   * Sets the fixture for this Student Knowledge test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(StudentKnowledge fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Student Knowledge test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StudentKnowledge getFixture() {
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
    setFixture(ModelingassistantFactory.eINSTANCE.createStudentKnowledge());
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

} //StudentKnowledgeTest
