/**
 */
package classdiagram.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>classdiagram</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassdiagramTests extends TestSuite {

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
    TestSuite suite = new ClassdiagramTests("classdiagram Tests");
    suite.addTestSuite(AssociationEndTest.class);
    suite.addTestSuite(CDBooleanTest.class);
    suite.addTestSuite(CDDoubleTest.class);
    suite.addTestSuite(CDIntTest.class);
    suite.addTestSuite(CDLongTest.class);
    suite.addTestSuite(CDStringTest.class);
    suite.addTestSuite(CDByteTest.class);
    suite.addTestSuite(CDFloatTest.class);
    suite.addTestSuite(CDArrayTest.class);
    suite.addTestSuite(CDCharTest.class);
    suite.addTestSuite(CDAnyTest.class);
    suite.addTestSuite(CDVoidTest.class);
    suite.addTestSuite(CDSetTest.class);
    suite.addTestSuite(CDSequenceTest.class);
    return suite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassdiagramTests(String name) {
    super(name);
  }

} //ClassdiagramTests
