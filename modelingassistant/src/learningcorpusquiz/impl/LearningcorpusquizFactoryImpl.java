/**
 */
package learningcorpusquiz.impl;

import learningcorpusquiz.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LearningcorpusquizFactoryImpl extends EFactoryImpl implements LearningcorpusquizFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LearningcorpusquizFactory init() {
    try {
      LearningcorpusquizFactory theLearningcorpusquizFactory = (LearningcorpusquizFactory)EPackage.Registry.INSTANCE.getEFactory(LearningcorpusquizPackage.eNS_URI);
      if (theLearningcorpusquizFactory != null) {
        return theLearningcorpusquizFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LearningcorpusquizFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningcorpusquizFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ: return createFillInTheBlanksQuiz();
      case LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ: return createListMultipleChoiceQuiz();
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ: return createTableMultipleChoiceQuiz();
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT: return createFillInTheBlanksQuizStatement();
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT: return createFillInTheBlanksQuizStatementComponent();
      case LearningcorpusquizPackage.NON_BLANK: return createNonBlank();
      case LearningcorpusquizPackage.BLANK: return createBlank();
      case LearningcorpusquizPackage.CHOICE: return createChoice();
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY: return createTableMcqEntry();
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM: return createTableMcqRowItem();
      case LearningcorpusquizPackage.TABLE_MCQ_COLUMN_ITEM: return createTableMcqColumnItem();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FillInTheBlanksQuiz createFillInTheBlanksQuiz() {
    FillInTheBlanksQuizImpl fillInTheBlanksQuiz = new FillInTheBlanksQuizImpl();
    return fillInTheBlanksQuiz;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ListMultipleChoiceQuiz createListMultipleChoiceQuiz() {
    ListMultipleChoiceQuizImpl listMultipleChoiceQuiz = new ListMultipleChoiceQuizImpl();
    return listMultipleChoiceQuiz;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TableMultipleChoiceQuiz createTableMultipleChoiceQuiz() {
    TableMultipleChoiceQuizImpl tableMultipleChoiceQuiz = new TableMultipleChoiceQuizImpl();
    return tableMultipleChoiceQuiz;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FillInTheBlanksQuizStatement createFillInTheBlanksQuizStatement() {
    FillInTheBlanksQuizStatementImpl fillInTheBlanksQuizStatement = new FillInTheBlanksQuizStatementImpl();
    return fillInTheBlanksQuizStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FillInTheBlanksQuizStatementComponent createFillInTheBlanksQuizStatementComponent() {
    FillInTheBlanksQuizStatementComponentImpl fillInTheBlanksQuizStatementComponent = new FillInTheBlanksQuizStatementComponentImpl();
    return fillInTheBlanksQuizStatementComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NonBlank createNonBlank() {
    NonBlankImpl nonBlank = new NonBlankImpl();
    return nonBlank;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Blank createBlank() {
    BlankImpl blank = new BlankImpl();
    return blank;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Choice createChoice() {
    ChoiceImpl choice = new ChoiceImpl();
    return choice;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TableMcqEntry createTableMcqEntry() {
    TableMcqEntryImpl tableMcqEntry = new TableMcqEntryImpl();
    return tableMcqEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TableMcqRowItem createTableMcqRowItem() {
    TableMcqRowItemImpl tableMcqRowItem = new TableMcqRowItemImpl();
    return tableMcqRowItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TableMcqColumnItem createTableMcqColumnItem() {
    TableMcqColumnItemImpl tableMcqColumnItem = new TableMcqColumnItemImpl();
    return tableMcqColumnItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LearningcorpusquizPackage getLearningcorpusquizPackage() {
    return (LearningcorpusquizPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LearningcorpusquizPackage getPackage() {
    return LearningcorpusquizPackage.eINSTANCE;
  }

} //LearningcorpusquizFactoryImpl
