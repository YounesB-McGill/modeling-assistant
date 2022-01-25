/**
 */
package learningcorpusquiz;

import learningcorpus.LearningcorpusPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ__STATEMENTS = LearningcorpusPackage.QUIZ_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fill In The Blanks Quiz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ_FEATURE_COUNT = LearningcorpusPackage.QUIZ_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Fill In The Blanks Quiz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ_OPERATION_COUNT = LearningcorpusPackage.QUIZ_OPERATION_COUNT + 0;


  /**
   * The meta object id for the '{@link learningcorpusquiz.impl.ListMultipleChoiceQuizImpl <em>List Multiple Choice Quiz</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpusquiz.impl.ListMultipleChoiceQuizImpl
   * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getListMultipleChoiceQuiz()
   * @generated
   */
  int LIST_MULTIPLE_CHOICE_QUIZ = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_MULTIPLE_CHOICE_QUIZ__NAME = LearningcorpusPackage.QUIZ__NAME;

  /**
   * The feature id for the '<em><b>Learning Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_MULTIPLE_CHOICE_QUIZ__LEARNING_ITEM = LearningcorpusPackage.QUIZ__LEARNING_ITEM;

  /**
   * The feature id for the '<em><b>Resource Responses</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_MULTIPLE_CHOICE_QUIZ__RESOURCE_RESPONSES = LearningcorpusPackage.QUIZ__RESOURCE_RESPONSES;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_MULTIPLE_CHOICE_QUIZ__CONTENT = LearningcorpusPackage.QUIZ__CONTENT;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_MULTIPLE_CHOICE_QUIZ__LEARNING_CORPUS = LearningcorpusPackage.QUIZ__LEARNING_CORPUS;

  /**
   * The feature id for the '<em><b>Choices</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_MULTIPLE_CHOICE_QUIZ__CHOICES = LearningcorpusPackage.QUIZ_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Correct Choices</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_MULTIPLE_CHOICE_QUIZ__CORRECT_CHOICES = LearningcorpusPackage.QUIZ_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>List Multiple Choice Quiz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_MULTIPLE_CHOICE_QUIZ_FEATURE_COUNT = LearningcorpusPackage.QUIZ_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>List Multiple Choice Quiz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_MULTIPLE_CHOICE_QUIZ_OPERATION_COUNT = LearningcorpusPackage.QUIZ_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpusquiz.impl.TableMultipleChoiceQuizImpl <em>Table Multiple Choice Quiz</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpusquiz.impl.TableMultipleChoiceQuizImpl
   * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getTableMultipleChoiceQuiz()
   * @generated
   */
  int TABLE_MULTIPLE_CHOICE_QUIZ = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MULTIPLE_CHOICE_QUIZ__NAME = LearningcorpusPackage.QUIZ__NAME;

  /**
   * The feature id for the '<em><b>Learning Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MULTIPLE_CHOICE_QUIZ__LEARNING_ITEM = LearningcorpusPackage.QUIZ__LEARNING_ITEM;

  /**
   * The feature id for the '<em><b>Resource Responses</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MULTIPLE_CHOICE_QUIZ__RESOURCE_RESPONSES = LearningcorpusPackage.QUIZ__RESOURCE_RESPONSES;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MULTIPLE_CHOICE_QUIZ__CONTENT = LearningcorpusPackage.QUIZ__CONTENT;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MULTIPLE_CHOICE_QUIZ__LEARNING_CORPUS = LearningcorpusPackage.QUIZ__LEARNING_CORPUS;

  /**
   * The feature id for the '<em><b>Row Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS = LearningcorpusPackage.QUIZ_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Column Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS = LearningcorpusPackage.QUIZ_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Correct Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MULTIPLE_CHOICE_QUIZ__CORRECT_ENTRIES = LearningcorpusPackage.QUIZ_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Table Multiple Choice Quiz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MULTIPLE_CHOICE_QUIZ_FEATURE_COUNT = LearningcorpusPackage.QUIZ_FEATURE_COUNT + 3;

  /**
   * The number of operations of the '<em>Table Multiple Choice Quiz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MULTIPLE_CHOICE_QUIZ_OPERATION_COUNT = LearningcorpusPackage.QUIZ_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpusquiz.impl.FillInTheBlanksQuizStatementImpl <em>Fill In The Blanks Quiz Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpusquiz.impl.FillInTheBlanksQuizStatementImpl
   * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getFillInTheBlanksQuizStatement()
   * @generated
   */
  int FILL_IN_THE_BLANKS_QUIZ_STATEMENT = 3;

  /**
   * The feature id for the '<em><b>Quiz</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ = 0;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ_STATEMENT__STATEMENTS = 1;

  /**
   * The number of structural features of the '<em>Fill In The Blanks Quiz Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ_STATEMENT_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Fill In The Blanks Quiz Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ_STATEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link learningcorpusquiz.impl.FillInTheBlanksQuizStatementComponentImpl <em>Fill In The Blanks Quiz Statement Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpusquiz.impl.FillInTheBlanksQuizStatementComponentImpl
   * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getFillInTheBlanksQuizStatementComponent()
   * @generated
   */
  int FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT = 4;

  /**
   * The feature id for the '<em><b>Statement</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT = 0;

  /**
   * The number of structural features of the '<em>Fill In The Blanks Quiz Statement Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Fill In The Blanks Quiz Statement Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link learningcorpusquiz.impl.NonBlankImpl <em>Non Blank</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpusquiz.impl.NonBlankImpl
   * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getNonBlank()
   * @generated
   */
  int NON_BLANK = 5;

  /**
   * The feature id for the '<em><b>Statement</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_BLANK__STATEMENT = FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_BLANK__TEXT = FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Non Blank</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_BLANK_FEATURE_COUNT = FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Non Blank</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_BLANK_OPERATION_COUNT = FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpusquiz.impl.BlankImpl <em>Blank</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpusquiz.impl.BlankImpl
   * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getBlank()
   * @generated
   */
  int BLANK = 6;

  /**
   * The feature id for the '<em><b>Statement</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLANK__STATEMENT = FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT;

  /**
   * The feature id for the '<em><b>Correct Answer</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLANK__CORRECT_ANSWER = FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Blank</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLANK_FEATURE_COUNT = FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Blank</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLANK_OPERATION_COUNT = FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpusquiz.impl.ChoiceImpl <em>Choice</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpusquiz.impl.ChoiceImpl
   * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getChoice()
   * @generated
   */
  int CHOICE = 7;

  /**
   * The feature id for the '<em><b>Quiz</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE__QUIZ = 0;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE__TEXT = 1;

  /**
   * The number of structural features of the '<em>Choice</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Choice</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link learningcorpusquiz.impl.TableMcqCorrectEntryImpl <em>Table Mcq Correct Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpusquiz.impl.TableMcqCorrectEntryImpl
   * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getTableMcqCorrectEntry()
   * @generated
   */
  int TABLE_MCQ_CORRECT_ENTRY = 8;

  /**
   * The feature id for the '<em><b>Quiz</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_CORRECT_ENTRY__QUIZ = 0;

  /**
   * The feature id for the '<em><b>Column Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_CORRECT_ENTRY__COLUMN_ITEM = 1;

  /**
   * The feature id for the '<em><b>Rowitem</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_CORRECT_ENTRY__ROWITEM = 2;

  /**
   * The number of structural features of the '<em>Table Mcq Correct Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_CORRECT_ENTRY_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Table Mcq Correct Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_CORRECT_ENTRY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link learningcorpusquiz.impl.TableMcqRowItemImpl <em>Table Mcq Row Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpusquiz.impl.TableMcqRowItemImpl
   * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getTableMcqRowItem()
   * @generated
   */
  int TABLE_MCQ_ROW_ITEM = 9;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_ROW_ITEM__TEXT = 0;

  /**
   * The feature id for the '<em><b>Quiz</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_ROW_ITEM__QUIZ = 1;

  /**
   * The feature id for the '<em><b>Correct Entries</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_ROW_ITEM__CORRECT_ENTRIES = 2;

  /**
   * The number of structural features of the '<em>Table Mcq Row Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_ROW_ITEM_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Table Mcq Row Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_ROW_ITEM_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link learningcorpusquiz.impl.TableMcqColumnItemImpl <em>Table Mcq Column Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpusquiz.impl.TableMcqColumnItemImpl
   * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getTableMcqColumnItem()
   * @generated
   */
  int TABLE_MCQ_COLUMN_ITEM = 10;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_COLUMN_ITEM__TEXT = 0;

  /**
   * The feature id for the '<em><b>Quiz</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_COLUMN_ITEM__QUIZ = 1;

  /**
   * The feature id for the '<em><b>Correct Entries</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_COLUMN_ITEM__CORRECT_ENTRIES = 2;

  /**
   * The number of structural features of the '<em>Table Mcq Column Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_COLUMN_ITEM_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Table Mcq Column Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_MCQ_COLUMN_ITEM_OPERATION_COUNT = 0;


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
   * Returns the meta object for the containment reference list '{@link learningcorpusquiz.FillInTheBlanksQuiz#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see learningcorpusquiz.FillInTheBlanksQuiz#getStatements()
   * @see #getFillInTheBlanksQuiz()
   * @generated
   */
  EReference getFillInTheBlanksQuiz_Statements();

  /**
   * Returns the meta object for class '{@link learningcorpusquiz.ListMultipleChoiceQuiz <em>List Multiple Choice Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Multiple Choice Quiz</em>'.
   * @see learningcorpusquiz.ListMultipleChoiceQuiz
   * @generated
   */
  EClass getListMultipleChoiceQuiz();

  /**
   * Returns the meta object for the containment reference list '{@link learningcorpusquiz.ListMultipleChoiceQuiz#getChoices <em>Choices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Choices</em>'.
   * @see learningcorpusquiz.ListMultipleChoiceQuiz#getChoices()
   * @see #getListMultipleChoiceQuiz()
   * @generated
   */
  EReference getListMultipleChoiceQuiz_Choices();

  /**
   * Returns the meta object for the reference list '{@link learningcorpusquiz.ListMultipleChoiceQuiz#getCorrectChoices <em>Correct Choices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Correct Choices</em>'.
   * @see learningcorpusquiz.ListMultipleChoiceQuiz#getCorrectChoices()
   * @see #getListMultipleChoiceQuiz()
   * @generated
   */
  EReference getListMultipleChoiceQuiz_CorrectChoices();

  /**
   * Returns the meta object for class '{@link learningcorpusquiz.TableMultipleChoiceQuiz <em>Table Multiple Choice Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Table Multiple Choice Quiz</em>'.
   * @see learningcorpusquiz.TableMultipleChoiceQuiz
   * @generated
   */
  EClass getTableMultipleChoiceQuiz();

  /**
   * Returns the meta object for the containment reference list '{@link learningcorpusquiz.TableMultipleChoiceQuiz#getRowItems <em>Row Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Row Items</em>'.
   * @see learningcorpusquiz.TableMultipleChoiceQuiz#getRowItems()
   * @see #getTableMultipleChoiceQuiz()
   * @generated
   */
  EReference getTableMultipleChoiceQuiz_RowItems();

  /**
   * Returns the meta object for the containment reference list '{@link learningcorpusquiz.TableMultipleChoiceQuiz#getColumnItems <em>Column Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Column Items</em>'.
   * @see learningcorpusquiz.TableMultipleChoiceQuiz#getColumnItems()
   * @see #getTableMultipleChoiceQuiz()
   * @generated
   */
  EReference getTableMultipleChoiceQuiz_ColumnItems();

  /**
   * Returns the meta object for the containment reference list '{@link learningcorpusquiz.TableMultipleChoiceQuiz#getCorrectEntries <em>Correct Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Correct Entries</em>'.
   * @see learningcorpusquiz.TableMultipleChoiceQuiz#getCorrectEntries()
   * @see #getTableMultipleChoiceQuiz()
   * @generated
   */
  EReference getTableMultipleChoiceQuiz_CorrectEntries();

  /**
   * Returns the meta object for class '{@link learningcorpusquiz.FillInTheBlanksQuizStatement <em>Fill In The Blanks Quiz Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fill In The Blanks Quiz Statement</em>'.
   * @see learningcorpusquiz.FillInTheBlanksQuizStatement
   * @generated
   */
  EClass getFillInTheBlanksQuizStatement();

  /**
   * Returns the meta object for the container reference '{@link learningcorpusquiz.FillInTheBlanksQuizStatement#getQuiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Quiz</em>'.
   * @see learningcorpusquiz.FillInTheBlanksQuizStatement#getQuiz()
   * @see #getFillInTheBlanksQuizStatement()
   * @generated
   */
  EReference getFillInTheBlanksQuizStatement_Quiz();

  /**
   * Returns the meta object for the containment reference list '{@link learningcorpusquiz.FillInTheBlanksQuizStatement#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see learningcorpusquiz.FillInTheBlanksQuizStatement#getStatements()
   * @see #getFillInTheBlanksQuizStatement()
   * @generated
   */
  EReference getFillInTheBlanksQuizStatement_Statements();

  /**
   * Returns the meta object for class '{@link learningcorpusquiz.FillInTheBlanksQuizStatementComponent <em>Fill In The Blanks Quiz Statement Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fill In The Blanks Quiz Statement Component</em>'.
   * @see learningcorpusquiz.FillInTheBlanksQuizStatementComponent
   * @generated
   */
  EClass getFillInTheBlanksQuizStatementComponent();

  /**
   * Returns the meta object for the container reference '{@link learningcorpusquiz.FillInTheBlanksQuizStatementComponent#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Statement</em>'.
   * @see learningcorpusquiz.FillInTheBlanksQuizStatementComponent#getStatement()
   * @see #getFillInTheBlanksQuizStatementComponent()
   * @generated
   */
  EReference getFillInTheBlanksQuizStatementComponent_Statement();

  /**
   * Returns the meta object for class '{@link learningcorpusquiz.NonBlank <em>Non Blank</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Non Blank</em>'.
   * @see learningcorpusquiz.NonBlank
   * @generated
   */
  EClass getNonBlank();

  /**
   * Returns the meta object for the attribute '{@link learningcorpusquiz.NonBlank#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see learningcorpusquiz.NonBlank#getText()
   * @see #getNonBlank()
   * @generated
   */
  EAttribute getNonBlank_Text();

  /**
   * Returns the meta object for class '{@link learningcorpusquiz.Blank <em>Blank</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Blank</em>'.
   * @see learningcorpusquiz.Blank
   * @generated
   */
  EClass getBlank();

  /**
   * Returns the meta object for the attribute '{@link learningcorpusquiz.Blank#getCorrectAnswer <em>Correct Answer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Correct Answer</em>'.
   * @see learningcorpusquiz.Blank#getCorrectAnswer()
   * @see #getBlank()
   * @generated
   */
  EAttribute getBlank_CorrectAnswer();

  /**
   * Returns the meta object for class '{@link learningcorpusquiz.Choice <em>Choice</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Choice</em>'.
   * @see learningcorpusquiz.Choice
   * @generated
   */
  EClass getChoice();

  /**
   * Returns the meta object for the container reference '{@link learningcorpusquiz.Choice#getQuiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Quiz</em>'.
   * @see learningcorpusquiz.Choice#getQuiz()
   * @see #getChoice()
   * @generated
   */
  EReference getChoice_Quiz();

  /**
   * Returns the meta object for the attribute '{@link learningcorpusquiz.Choice#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see learningcorpusquiz.Choice#getText()
   * @see #getChoice()
   * @generated
   */
  EAttribute getChoice_Text();

  /**
   * Returns the meta object for class '{@link learningcorpusquiz.TableMcqCorrectEntry <em>Table Mcq Correct Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Table Mcq Correct Entry</em>'.
   * @see learningcorpusquiz.TableMcqCorrectEntry
   * @generated
   */
  EClass getTableMcqCorrectEntry();

  /**
   * Returns the meta object for the container reference '{@link learningcorpusquiz.TableMcqCorrectEntry#getQuiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Quiz</em>'.
   * @see learningcorpusquiz.TableMcqCorrectEntry#getQuiz()
   * @see #getTableMcqCorrectEntry()
   * @generated
   */
  EReference getTableMcqCorrectEntry_Quiz();

  /**
   * Returns the meta object for the reference '{@link learningcorpusquiz.TableMcqCorrectEntry#getColumnItem <em>Column Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Column Item</em>'.
   * @see learningcorpusquiz.TableMcqCorrectEntry#getColumnItem()
   * @see #getTableMcqCorrectEntry()
   * @generated
   */
  EReference getTableMcqCorrectEntry_ColumnItem();

  /**
   * Returns the meta object for the reference '{@link learningcorpusquiz.TableMcqCorrectEntry#getRowitem <em>Rowitem</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Rowitem</em>'.
   * @see learningcorpusquiz.TableMcqCorrectEntry#getRowitem()
   * @see #getTableMcqCorrectEntry()
   * @generated
   */
  EReference getTableMcqCorrectEntry_Rowitem();

  /**
   * Returns the meta object for class '{@link learningcorpusquiz.TableMcqRowItem <em>Table Mcq Row Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Table Mcq Row Item</em>'.
   * @see learningcorpusquiz.TableMcqRowItem
   * @generated
   */
  EClass getTableMcqRowItem();

  /**
   * Returns the meta object for the attribute '{@link learningcorpusquiz.TableMcqRowItem#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see learningcorpusquiz.TableMcqRowItem#getText()
   * @see #getTableMcqRowItem()
   * @generated
   */
  EAttribute getTableMcqRowItem_Text();

  /**
   * Returns the meta object for the container reference '{@link learningcorpusquiz.TableMcqRowItem#getQuiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Quiz</em>'.
   * @see learningcorpusquiz.TableMcqRowItem#getQuiz()
   * @see #getTableMcqRowItem()
   * @generated
   */
  EReference getTableMcqRowItem_Quiz();

  /**
   * Returns the meta object for the reference list '{@link learningcorpusquiz.TableMcqRowItem#getCorrectEntries <em>Correct Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Correct Entries</em>'.
   * @see learningcorpusquiz.TableMcqRowItem#getCorrectEntries()
   * @see #getTableMcqRowItem()
   * @generated
   */
  EReference getTableMcqRowItem_CorrectEntries();

  /**
   * Returns the meta object for class '{@link learningcorpusquiz.TableMcqColumnItem <em>Table Mcq Column Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Table Mcq Column Item</em>'.
   * @see learningcorpusquiz.TableMcqColumnItem
   * @generated
   */
  EClass getTableMcqColumnItem();

  /**
   * Returns the meta object for the attribute '{@link learningcorpusquiz.TableMcqColumnItem#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see learningcorpusquiz.TableMcqColumnItem#getText()
   * @see #getTableMcqColumnItem()
   * @generated
   */
  EAttribute getTableMcqColumnItem_Text();

  /**
   * Returns the meta object for the container reference '{@link learningcorpusquiz.TableMcqColumnItem#getQuiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Quiz</em>'.
   * @see learningcorpusquiz.TableMcqColumnItem#getQuiz()
   * @see #getTableMcqColumnItem()
   * @generated
   */
  EReference getTableMcqColumnItem_Quiz();

  /**
   * Returns the meta object for the reference list '{@link learningcorpusquiz.TableMcqColumnItem#getCorrectEntries <em>Correct Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Correct Entries</em>'.
   * @see learningcorpusquiz.TableMcqColumnItem#getCorrectEntries()
   * @see #getTableMcqColumnItem()
   * @generated
   */
  EReference getTableMcqColumnItem_CorrectEntries();

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
    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILL_IN_THE_BLANKS_QUIZ__STATEMENTS = eINSTANCE.getFillInTheBlanksQuiz_Statements();
    /**
     * The meta object literal for the '{@link learningcorpusquiz.impl.ListMultipleChoiceQuizImpl <em>List Multiple Choice Quiz</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpusquiz.impl.ListMultipleChoiceQuizImpl
     * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getListMultipleChoiceQuiz()
     * @generated
     */
    EClass LIST_MULTIPLE_CHOICE_QUIZ = eINSTANCE.getListMultipleChoiceQuiz();
    /**
     * The meta object literal for the '<em><b>Choices</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_MULTIPLE_CHOICE_QUIZ__CHOICES = eINSTANCE.getListMultipleChoiceQuiz_Choices();
    /**
     * The meta object literal for the '<em><b>Correct Choices</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_MULTIPLE_CHOICE_QUIZ__CORRECT_CHOICES = eINSTANCE.getListMultipleChoiceQuiz_CorrectChoices();
    /**
     * The meta object literal for the '{@link learningcorpusquiz.impl.TableMultipleChoiceQuizImpl <em>Table Multiple Choice Quiz</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpusquiz.impl.TableMultipleChoiceQuizImpl
     * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getTableMultipleChoiceQuiz()
     * @generated
     */
    EClass TABLE_MULTIPLE_CHOICE_QUIZ = eINSTANCE.getTableMultipleChoiceQuiz();
    /**
     * The meta object literal for the '<em><b>Row Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS = eINSTANCE.getTableMultipleChoiceQuiz_RowItems();
    /**
     * The meta object literal for the '<em><b>Column Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS = eINSTANCE.getTableMultipleChoiceQuiz_ColumnItems();
    /**
     * The meta object literal for the '<em><b>Correct Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_MULTIPLE_CHOICE_QUIZ__CORRECT_ENTRIES = eINSTANCE.getTableMultipleChoiceQuiz_CorrectEntries();
    /**
     * The meta object literal for the '{@link learningcorpusquiz.impl.FillInTheBlanksQuizStatementImpl <em>Fill In The Blanks Quiz Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpusquiz.impl.FillInTheBlanksQuizStatementImpl
     * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getFillInTheBlanksQuizStatement()
     * @generated
     */
    EClass FILL_IN_THE_BLANKS_QUIZ_STATEMENT = eINSTANCE.getFillInTheBlanksQuizStatement();
    /**
     * The meta object literal for the '<em><b>Quiz</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ = eINSTANCE.getFillInTheBlanksQuizStatement_Quiz();
    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILL_IN_THE_BLANKS_QUIZ_STATEMENT__STATEMENTS = eINSTANCE.getFillInTheBlanksQuizStatement_Statements();
    /**
     * The meta object literal for the '{@link learningcorpusquiz.impl.FillInTheBlanksQuizStatementComponentImpl <em>Fill In The Blanks Quiz Statement Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpusquiz.impl.FillInTheBlanksQuizStatementComponentImpl
     * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getFillInTheBlanksQuizStatementComponent()
     * @generated
     */
    EClass FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT = eINSTANCE.getFillInTheBlanksQuizStatementComponent();
    /**
     * The meta object literal for the '<em><b>Statement</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT = eINSTANCE.getFillInTheBlanksQuizStatementComponent_Statement();
    /**
     * The meta object literal for the '{@link learningcorpusquiz.impl.NonBlankImpl <em>Non Blank</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpusquiz.impl.NonBlankImpl
     * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getNonBlank()
     * @generated
     */
    EClass NON_BLANK = eINSTANCE.getNonBlank();
    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NON_BLANK__TEXT = eINSTANCE.getNonBlank_Text();
    /**
     * The meta object literal for the '{@link learningcorpusquiz.impl.BlankImpl <em>Blank</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpusquiz.impl.BlankImpl
     * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getBlank()
     * @generated
     */
    EClass BLANK = eINSTANCE.getBlank();
    /**
     * The meta object literal for the '<em><b>Correct Answer</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BLANK__CORRECT_ANSWER = eINSTANCE.getBlank_CorrectAnswer();
    /**
     * The meta object literal for the '{@link learningcorpusquiz.impl.ChoiceImpl <em>Choice</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpusquiz.impl.ChoiceImpl
     * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getChoice()
     * @generated
     */
    EClass CHOICE = eINSTANCE.getChoice();
    /**
     * The meta object literal for the '<em><b>Quiz</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHOICE__QUIZ = eINSTANCE.getChoice_Quiz();
    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHOICE__TEXT = eINSTANCE.getChoice_Text();
    /**
     * The meta object literal for the '{@link learningcorpusquiz.impl.TableMcqCorrectEntryImpl <em>Table Mcq Correct Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpusquiz.impl.TableMcqCorrectEntryImpl
     * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getTableMcqCorrectEntry()
     * @generated
     */
    EClass TABLE_MCQ_CORRECT_ENTRY = eINSTANCE.getTableMcqCorrectEntry();
    /**
     * The meta object literal for the '<em><b>Quiz</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_MCQ_CORRECT_ENTRY__QUIZ = eINSTANCE.getTableMcqCorrectEntry_Quiz();
    /**
     * The meta object literal for the '<em><b>Column Item</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_MCQ_CORRECT_ENTRY__COLUMN_ITEM = eINSTANCE.getTableMcqCorrectEntry_ColumnItem();
    /**
     * The meta object literal for the '<em><b>Rowitem</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_MCQ_CORRECT_ENTRY__ROWITEM = eINSTANCE.getTableMcqCorrectEntry_Rowitem();
    /**
     * The meta object literal for the '{@link learningcorpusquiz.impl.TableMcqRowItemImpl <em>Table Mcq Row Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpusquiz.impl.TableMcqRowItemImpl
     * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getTableMcqRowItem()
     * @generated
     */
    EClass TABLE_MCQ_ROW_ITEM = eINSTANCE.getTableMcqRowItem();
    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TABLE_MCQ_ROW_ITEM__TEXT = eINSTANCE.getTableMcqRowItem_Text();
    /**
     * The meta object literal for the '<em><b>Quiz</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_MCQ_ROW_ITEM__QUIZ = eINSTANCE.getTableMcqRowItem_Quiz();
    /**
     * The meta object literal for the '<em><b>Correct Entries</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_MCQ_ROW_ITEM__CORRECT_ENTRIES = eINSTANCE.getTableMcqRowItem_CorrectEntries();
    /**
     * The meta object literal for the '{@link learningcorpusquiz.impl.TableMcqColumnItemImpl <em>Table Mcq Column Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpusquiz.impl.TableMcqColumnItemImpl
     * @see learningcorpusquiz.impl.LearningcorpusquizPackageImpl#getTableMcqColumnItem()
     * @generated
     */
    EClass TABLE_MCQ_COLUMN_ITEM = eINSTANCE.getTableMcqColumnItem();
    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TABLE_MCQ_COLUMN_ITEM__TEXT = eINSTANCE.getTableMcqColumnItem_Text();
    /**
     * The meta object literal for the '<em><b>Quiz</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_MCQ_COLUMN_ITEM__QUIZ = eINSTANCE.getTableMcqColumnItem_Quiz();
    /**
     * The meta object literal for the '<em><b>Correct Entries</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_MCQ_COLUMN_ITEM__CORRECT_ENTRIES = eINSTANCE.getTableMcqColumnItem_CorrectEntries();

  }

} //LearningcorpusquizPackage
