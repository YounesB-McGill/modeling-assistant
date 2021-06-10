/**
 */
package learningcorpus.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import learningcorpus.LearningCorpus;
import learningcorpus.LearningcorpusFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Learning Corpus</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LearningCorpusTest extends TestCase {

  /**
   * The fixture for this Learning Corpus test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LearningCorpus fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(LearningCorpusTest.class);
  }

  /**
   * Constructs a new Learning Corpus test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningCorpusTest(String name) {
    super(name);
  }

  /**
   * Sets the fixture for this Learning Corpus test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(LearningCorpus fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Learning Corpus test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LearningCorpus getFixture() {
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
    setFixture(LearningcorpusFactory.eINSTANCE.createLearningCorpus());
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

} //LearningCorpusTest
