/**
 */
package learningcorpusquiz.impl;

import ca.mcgill.sel.classdiagram.CdmPackage;

import ca.mcgill.sel.core.CorePackage;

import learningcorpus.LearningcorpusPackage;

import learningcorpus.impl.LearningcorpusPackageImpl;

import learningcorpusquiz.Blank;
import learningcorpusquiz.Choice;
import learningcorpusquiz.FillInTheBlanksQuiz;
import learningcorpusquiz.FillInTheBlanksQuizStatement;
import learningcorpusquiz.FillInTheBlanksQuizStatementComponent;
import learningcorpusquiz.LearningcorpusquizFactory;
import learningcorpusquiz.LearningcorpusquizPackage;

import learningcorpusquiz.ListMultipleChoiceQuiz;
import learningcorpusquiz.NonBlank;
import learningcorpusquiz.TableMcqColumnItem;
import learningcorpusquiz.TableMcqCorrectEntry;
import learningcorpusquiz.TableMcqRowItem;
import learningcorpusquiz.TableMultipleChoiceQuiz;
import modelingassistant.ModelingassistantPackage;

import modelingassistant.impl.ModelingassistantPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LearningcorpusquizPackageImpl extends EPackageImpl implements LearningcorpusquizPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fillInTheBlanksQuizEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listMultipleChoiceQuizEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tableMultipleChoiceQuizEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fillInTheBlanksQuizStatementEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fillInTheBlanksQuizStatementComponentEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonBlankEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blankEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass choiceEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tableMcqCorrectEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tableMcqRowItemEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tableMcqColumnItemEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see learningcorpusquiz.LearningcorpusquizPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private LearningcorpusquizPackageImpl() {
    super(eNS_URI, LearningcorpusquizFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>This method is used to initialize {@link LearningcorpusquizPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static LearningcorpusquizPackage init() {
    if (isInited) return (LearningcorpusquizPackage)EPackage.Registry.INSTANCE.getEPackage(LearningcorpusquizPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredLearningcorpusquizPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    LearningcorpusquizPackageImpl theLearningcorpusquizPackage = registeredLearningcorpusquizPackage instanceof LearningcorpusquizPackageImpl ? (LearningcorpusquizPackageImpl)registeredLearningcorpusquizPackage : new LearningcorpusquizPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    CdmPackage.eINSTANCE.eClass();
    CorePackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(LearningcorpusPackage.eNS_URI);
    LearningcorpusPackageImpl theLearningcorpusPackage = (LearningcorpusPackageImpl)(registeredPackage instanceof LearningcorpusPackageImpl ? registeredPackage : LearningcorpusPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ModelingassistantPackage.eNS_URI);
    ModelingassistantPackageImpl theModelingassistantPackage = (ModelingassistantPackageImpl)(registeredPackage instanceof ModelingassistantPackageImpl ? registeredPackage : ModelingassistantPackage.eINSTANCE);

    // Create package meta-data objects
    theLearningcorpusquizPackage.createPackageContents();
    theLearningcorpusPackage.createPackageContents();
    theModelingassistantPackage.createPackageContents();

    // Initialize created meta-data
    theLearningcorpusquizPackage.initializePackageContents();
    theLearningcorpusPackage.initializePackageContents();
    theModelingassistantPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theLearningcorpusquizPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(LearningcorpusquizPackage.eNS_URI, theLearningcorpusquizPackage);
    return theLearningcorpusquizPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getFillInTheBlanksQuiz() {
    return fillInTheBlanksQuizEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFillInTheBlanksQuiz_Statements() {
    return (EReference)fillInTheBlanksQuizEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getListMultipleChoiceQuiz() {
    return listMultipleChoiceQuizEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getListMultipleChoiceQuiz_Choices() {
    return (EReference)listMultipleChoiceQuizEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getListMultipleChoiceQuiz_CorrectChoices() {
    return (EReference)listMultipleChoiceQuizEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTableMultipleChoiceQuiz() {
    return tableMultipleChoiceQuizEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTableMultipleChoiceQuiz_RowItems() {
    return (EReference)tableMultipleChoiceQuizEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTableMultipleChoiceQuiz_ColumnItems() {
    return (EReference)tableMultipleChoiceQuizEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTableMultipleChoiceQuiz_CorrectEntries() {
    return (EReference)tableMultipleChoiceQuizEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getFillInTheBlanksQuizStatement() {
    return fillInTheBlanksQuizStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFillInTheBlanksQuizStatement_Quiz() {
    return (EReference)fillInTheBlanksQuizStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFillInTheBlanksQuizStatement_Components() {
    return (EReference)fillInTheBlanksQuizStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getFillInTheBlanksQuizStatementComponent() {
    return fillInTheBlanksQuizStatementComponentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFillInTheBlanksQuizStatementComponent_Statement() {
    return (EReference)fillInTheBlanksQuizStatementComponentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getNonBlank() {
    return nonBlankEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getNonBlank_Text() {
    return (EAttribute)nonBlankEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBlank() {
    return blankEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBlank_CorrectAnswer() {
    return (EAttribute)blankEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getChoice() {
    return choiceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getChoice_Quiz() {
    return (EReference)choiceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getChoice_Text() {
    return (EAttribute)choiceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTableMcqCorrectEntry() {
    return tableMcqCorrectEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTableMcqCorrectEntry_Quiz() {
    return (EReference)tableMcqCorrectEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTableMcqCorrectEntry_ColumnItem() {
    return (EReference)tableMcqCorrectEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTableMcqCorrectEntry_Rowitem() {
    return (EReference)tableMcqCorrectEntryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTableMcqRowItem() {
    return tableMcqRowItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTableMcqRowItem_Text() {
    return (EAttribute)tableMcqRowItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTableMcqRowItem_Quiz() {
    return (EReference)tableMcqRowItemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTableMcqRowItem_CorrectEntries() {
    return (EReference)tableMcqRowItemEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTableMcqColumnItem() {
    return tableMcqColumnItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTableMcqColumnItem_Text() {
    return (EAttribute)tableMcqColumnItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTableMcqColumnItem_Quiz() {
    return (EReference)tableMcqColumnItemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTableMcqColumnItem_CorrectEntries() {
    return (EReference)tableMcqColumnItemEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LearningcorpusquizFactory getLearningcorpusquizFactory() {
    return (LearningcorpusquizFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    fillInTheBlanksQuizEClass = createEClass(FILL_IN_THE_BLANKS_QUIZ);
    createEReference(fillInTheBlanksQuizEClass, FILL_IN_THE_BLANKS_QUIZ__STATEMENTS);

    listMultipleChoiceQuizEClass = createEClass(LIST_MULTIPLE_CHOICE_QUIZ);
    createEReference(listMultipleChoiceQuizEClass, LIST_MULTIPLE_CHOICE_QUIZ__CHOICES);
    createEReference(listMultipleChoiceQuizEClass, LIST_MULTIPLE_CHOICE_QUIZ__CORRECT_CHOICES);

    tableMultipleChoiceQuizEClass = createEClass(TABLE_MULTIPLE_CHOICE_QUIZ);
    createEReference(tableMultipleChoiceQuizEClass, TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS);
    createEReference(tableMultipleChoiceQuizEClass, TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS);
    createEReference(tableMultipleChoiceQuizEClass, TABLE_MULTIPLE_CHOICE_QUIZ__CORRECT_ENTRIES);

    fillInTheBlanksQuizStatementEClass = createEClass(FILL_IN_THE_BLANKS_QUIZ_STATEMENT);
    createEReference(fillInTheBlanksQuizStatementEClass, FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ);
    createEReference(fillInTheBlanksQuizStatementEClass, FILL_IN_THE_BLANKS_QUIZ_STATEMENT__COMPONENTS);

    fillInTheBlanksQuizStatementComponentEClass = createEClass(FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT);
    createEReference(fillInTheBlanksQuizStatementComponentEClass, FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT);

    nonBlankEClass = createEClass(NON_BLANK);
    createEAttribute(nonBlankEClass, NON_BLANK__TEXT);

    blankEClass = createEClass(BLANK);
    createEAttribute(blankEClass, BLANK__CORRECT_ANSWER);

    choiceEClass = createEClass(CHOICE);
    createEReference(choiceEClass, CHOICE__QUIZ);
    createEAttribute(choiceEClass, CHOICE__TEXT);

    tableMcqCorrectEntryEClass = createEClass(TABLE_MCQ_CORRECT_ENTRY);
    createEReference(tableMcqCorrectEntryEClass, TABLE_MCQ_CORRECT_ENTRY__QUIZ);
    createEReference(tableMcqCorrectEntryEClass, TABLE_MCQ_CORRECT_ENTRY__COLUMN_ITEM);
    createEReference(tableMcqCorrectEntryEClass, TABLE_MCQ_CORRECT_ENTRY__ROWITEM);

    tableMcqRowItemEClass = createEClass(TABLE_MCQ_ROW_ITEM);
    createEAttribute(tableMcqRowItemEClass, TABLE_MCQ_ROW_ITEM__TEXT);
    createEReference(tableMcqRowItemEClass, TABLE_MCQ_ROW_ITEM__QUIZ);
    createEReference(tableMcqRowItemEClass, TABLE_MCQ_ROW_ITEM__CORRECT_ENTRIES);

    tableMcqColumnItemEClass = createEClass(TABLE_MCQ_COLUMN_ITEM);
    createEAttribute(tableMcqColumnItemEClass, TABLE_MCQ_COLUMN_ITEM__TEXT);
    createEReference(tableMcqColumnItemEClass, TABLE_MCQ_COLUMN_ITEM__QUIZ);
    createEReference(tableMcqColumnItemEClass, TABLE_MCQ_COLUMN_ITEM__CORRECT_ENTRIES);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    LearningcorpusPackage theLearningcorpusPackage = (LearningcorpusPackage)EPackage.Registry.INSTANCE.getEPackage(LearningcorpusPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    fillInTheBlanksQuizEClass.getESuperTypes().add(theLearningcorpusPackage.getQuiz());
    listMultipleChoiceQuizEClass.getESuperTypes().add(theLearningcorpusPackage.getQuiz());
    tableMultipleChoiceQuizEClass.getESuperTypes().add(theLearningcorpusPackage.getQuiz());
    nonBlankEClass.getESuperTypes().add(this.getFillInTheBlanksQuizStatementComponent());
    blankEClass.getESuperTypes().add(this.getFillInTheBlanksQuizStatementComponent());

    // Initialize classes, features, and operations; add parameters
    initEClass(fillInTheBlanksQuizEClass, FillInTheBlanksQuiz.class, "FillInTheBlanksQuiz", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFillInTheBlanksQuiz_Statements(), this.getFillInTheBlanksQuizStatement(), this.getFillInTheBlanksQuizStatement_Quiz(), "statements", null, 0, -1, FillInTheBlanksQuiz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(listMultipleChoiceQuizEClass, ListMultipleChoiceQuiz.class, "ListMultipleChoiceQuiz", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getListMultipleChoiceQuiz_Choices(), this.getChoice(), this.getChoice_Quiz(), "choices", null, 0, -1, ListMultipleChoiceQuiz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getListMultipleChoiceQuiz_CorrectChoices(), this.getChoice(), null, "correctChoices", null, 0, -1, ListMultipleChoiceQuiz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tableMultipleChoiceQuizEClass, TableMultipleChoiceQuiz.class, "TableMultipleChoiceQuiz", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTableMultipleChoiceQuiz_RowItems(), this.getTableMcqRowItem(), this.getTableMcqRowItem_Quiz(), "rowItems", null, 0, -1, TableMultipleChoiceQuiz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableMultipleChoiceQuiz_ColumnItems(), this.getTableMcqColumnItem(), this.getTableMcqColumnItem_Quiz(), "columnItems", null, 0, -1, TableMultipleChoiceQuiz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableMultipleChoiceQuiz_CorrectEntries(), this.getTableMcqCorrectEntry(), this.getTableMcqCorrectEntry_Quiz(), "correctEntries", null, 0, -1, TableMultipleChoiceQuiz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fillInTheBlanksQuizStatementEClass, FillInTheBlanksQuizStatement.class, "FillInTheBlanksQuizStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFillInTheBlanksQuizStatement_Quiz(), this.getFillInTheBlanksQuiz(), this.getFillInTheBlanksQuiz_Statements(), "quiz", null, 1, 1, FillInTheBlanksQuizStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFillInTheBlanksQuizStatement_Components(), this.getFillInTheBlanksQuizStatementComponent(), this.getFillInTheBlanksQuizStatementComponent_Statement(), "components", null, 0, -1, FillInTheBlanksQuizStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fillInTheBlanksQuizStatementComponentEClass, FillInTheBlanksQuizStatementComponent.class, "FillInTheBlanksQuizStatementComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFillInTheBlanksQuizStatementComponent_Statement(), this.getFillInTheBlanksQuizStatement(), this.getFillInTheBlanksQuizStatement_Components(), "statement", null, 1, 1, FillInTheBlanksQuizStatementComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nonBlankEClass, NonBlank.class, "NonBlank", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNonBlank_Text(), ecorePackage.getEString(), "text", null, 0, 1, NonBlank.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(blankEClass, Blank.class, "Blank", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBlank_CorrectAnswer(), ecorePackage.getEString(), "correctAnswer", null, 0, 1, Blank.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(choiceEClass, Choice.class, "Choice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getChoice_Quiz(), this.getListMultipleChoiceQuiz(), this.getListMultipleChoiceQuiz_Choices(), "quiz", null, 1, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getChoice_Text(), ecorePackage.getEString(), "text", null, 0, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tableMcqCorrectEntryEClass, TableMcqCorrectEntry.class, "TableMcqCorrectEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTableMcqCorrectEntry_Quiz(), this.getTableMultipleChoiceQuiz(), this.getTableMultipleChoiceQuiz_CorrectEntries(), "quiz", null, 1, 1, TableMcqCorrectEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableMcqCorrectEntry_ColumnItem(), this.getTableMcqColumnItem(), this.getTableMcqColumnItem_CorrectEntries(), "columnItem", null, 1, 1, TableMcqCorrectEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableMcqCorrectEntry_Rowitem(), this.getTableMcqRowItem(), this.getTableMcqRowItem_CorrectEntries(), "rowitem", null, 1, 1, TableMcqCorrectEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tableMcqRowItemEClass, TableMcqRowItem.class, "TableMcqRowItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTableMcqRowItem_Text(), ecorePackage.getEString(), "text", null, 0, 1, TableMcqRowItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableMcqRowItem_Quiz(), this.getTableMultipleChoiceQuiz(), this.getTableMultipleChoiceQuiz_RowItems(), "quiz", null, 1, 1, TableMcqRowItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableMcqRowItem_CorrectEntries(), this.getTableMcqCorrectEntry(), this.getTableMcqCorrectEntry_Rowitem(), "correctEntries", null, 0, -1, TableMcqRowItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tableMcqColumnItemEClass, TableMcqColumnItem.class, "TableMcqColumnItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTableMcqColumnItem_Text(), ecorePackage.getEString(), "text", null, 0, 1, TableMcqColumnItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableMcqColumnItem_Quiz(), this.getTableMultipleChoiceQuiz(), this.getTableMultipleChoiceQuiz_ColumnItems(), "quiz", null, 1, 1, TableMcqColumnItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableMcqColumnItem_CorrectEntries(), this.getTableMcqCorrectEntry(), this.getTableMcqCorrectEntry_ColumnItem(), "correctEntries", null, 0, -1, TableMcqColumnItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //LearningcorpusquizPackageImpl
