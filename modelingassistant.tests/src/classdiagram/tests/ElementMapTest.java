/**
 */
package classdiagram.tests;

import classdiagram.ClassdiagramFactory;
import classdiagram.ClassdiagramPackage;
import classdiagram.LayoutElement;

import java.util.Map;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Element Map</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ElementMapTest extends TestCase {

  /**
   * The fixture for this Element Map test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Map.Entry<EObject, LayoutElement> fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(ElementMapTest.class);
  }

  /**
   * Constructs a new Element Map test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementMapTest(String name) {
    super(name);
  }

  /**
   * Sets the fixture for this Element Map test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(Map.Entry<EObject, LayoutElement> fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Element Map test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Map.Entry<EObject, LayoutElement> getFixture() {
    return fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  @SuppressWarnings("unchecked")
  protected void setUp() throws Exception {
    setFixture((Map.Entry<EObject, LayoutElement>)ClassdiagramFactory.eINSTANCE.create(ClassdiagramPackage.Literals.ELEMENT_MAP));
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

} //ElementMapTest
