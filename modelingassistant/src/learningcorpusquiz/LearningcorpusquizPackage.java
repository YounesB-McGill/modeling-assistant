/**
 */
package learningcorpusquiz;

import learningcorpus.LearningcorpusPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see learningcorpusquiz.LearningcorpusquizFactory
 * @model kind="package"
 * @generated
 */
public interface LearningcorpusquizPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "learningcorpusquiz";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://cs.mcgill.ca/sel/modelingassistant/learningcorpusquiz/1.0";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "learningcorpusquiz";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LearningcorpusquizPackage eINSTANCE = learningcorpusquiz.impl.LearningcorpusquizPackageImpl.init();

  /**
   * The meta object id for the '{@link learningcorpusquiz.impl.FillInTheBlanksQuizImpl <em>Fill In The Blanks Quiz</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpusquiz.impl.FillInTheBlanksQuizImpl
   * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getFillInTheBlanksQuiz()
   * @generated
   */
  int FILL_IN_THE_BLANKS_QUIZ = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ__NAME = LearningcorpusPackage.QUIZ__NAME;

  /**
   * The feature id for the '<em><b>Learning Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ__LEARNING_ITEM = LearningcorpusPackage.QUIZ__LEARNING_ITEM;

  /**
   * The feature id for the '<em><b>Resource Responses</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ__RESOURCE_RESPONSES = LearningcorpusPackage.QUIZ__RESOURCE_RESPONSES;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ__CONTENT = LearningcorpusPackage.QUIZ__CONTENT;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ__LEARNING_CORPUS = LearningcorpusPackage.QUIZ__LEARNING_CORPUS;

  /**
   * The number of structural features of the '<em>Fill In The Blanks Quiz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ_FEATURE_COUNT = LearningcorpusPackage.QUIZ_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Fill In The Blanks Quiz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ_OPERATION_COUNT = LearningcorpusPackage.QUIZ_OPERATION_COUNT + 0;


  /**
   * Returns the meta object for class '{@link learningcorpusquiz.FillInTheBlanksQuiz <em>Fill In The Blanks Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fill In The Blanks Quiz</em>'.
   * @see learningcorpusquiz.FillInTheBlanksQuiz
   * @generated
   */
  EClass getFillInTheBlanksQuiz();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  LearningcorpusquizFactory getLearningcorpusquizFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link learningcorpusquiz.impl.FillInTheBlanksQuizImpl <em>Fill In The Blanks Quiz</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpusquiz.impl.FillInTheBlanksQuizImpl
     * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getFillInTheBlanksQuiz()
     * @generated
     */
    EClass FILL_IN_THE_BLANKS_QUIZ = eINSTANCE.getFillInTheBlanksQuiz();

  }

} //LearningcorpusquizPackage
