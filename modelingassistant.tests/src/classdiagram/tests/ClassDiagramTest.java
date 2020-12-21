/**
 */
package classdiagram.tests;

import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Class Diagram</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassDiagramTest extends NamedElementTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(ClassDiagramTest.class);
  }

  /**
   * Constructs a new Class Diagram test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDiagramTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Class Diagram test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected ClassDiagram getFixture() {
    return (ClassDiagram)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ClassdiagramFactory.eINSTANCE.createClassDiagram());
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

} //ClassDiagramTest
