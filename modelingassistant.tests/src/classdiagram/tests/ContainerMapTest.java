/**
 */
package classdiagram.tests;

import classdiagram.ClassdiagramFactory;
import classdiagram.ClassdiagramPackage;
import classdiagram.LayoutElement;

import java.util.Map;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Container Map</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContainerMapTest extends TestCase {

  /**
   * The fixture for this Container Map test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Map.Entry<EObject, EMap<EObject, LayoutElement>> fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(ContainerMapTest.class);
  }

  /**
   * Constructs a new Container Map test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContainerMapTest(String name) {
    super(name);
  }

  /**
   * Sets the fixture for this Container Map test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(Map.Entry<EObject, EMap<EObject, LayoutElement>> fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Container Map test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Map.Entry<EObject, EMap<EObject, LayoutElement>> getFixture() {
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
    setFixture((Map.Entry<EObject, EMap<EObject, LayoutElement>>)ClassdiagramFactory.eINSTANCE.create(ClassdiagramPackage.Literals.CONTAINER_MAP));
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

} //ContainerMapTest
