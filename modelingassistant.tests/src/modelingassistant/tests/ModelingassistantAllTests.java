/**
 */
package modelingassistant.tests;

import classdiagram.tests.ClassdiagramTests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Modelingassistant</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelingassistantAllTests extends TestSuite {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(suite());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Test suite() {
    TestSuite suite = new ModelingassistantAllTests("Modelingassistant Tests");
    suite.addTest(ClassdiagramTests.suite());
    return suite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingassistantAllTests(String name) {
    super(name);
  }

} //ModelingassistantAllTests
