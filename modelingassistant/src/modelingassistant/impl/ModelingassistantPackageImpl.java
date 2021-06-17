/**
 */
package modelingassistant.impl;

import classdiagram.ClassdiagramPackage;

import classdiagram.impl.ClassdiagramPackageImpl;

import java.sql.Time;

import learningcorpus.LearningcorpusPackage;

import learningcorpus.impl.LearningcorpusPackageImpl;

import modelingassistant.FeedbackItem;
import modelingassistant.Mistake;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.NamedElement;
import modelingassistant.ProblemStatement;
import modelingassistant.ProblemStatementElement;
import modelingassistant.Solution;
import modelingassistant.SolutionElement;
import modelingassistant.Student;
import modelingassistant.StudentKnowledge;

import modelingassistant.Tag;
import modelingassistant.TagGroup;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelingassistantPackageImpl extends EPackageImpl implements ModelingassistantPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelingAssistantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass studentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass problemStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass problemStatementElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass solutionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass solutionElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass studentKnowledgeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mistakeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass feedbackItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tagEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tagGroupEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType timeEDataType = null;

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
   * @see modelingassistant.ModelingassistantPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ModelingassistantPackageImpl() {
    super(eNS_URI, ModelingassistantFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ModelingassistantPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ModelingassistantPackage init() {
    if (isInited) return (ModelingassistantPackage)EPackage.Registry.INSTANCE.getEPackage(ModelingassistantPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredModelingassistantPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    ModelingassistantPackageImpl theModelingassistantPackage = registeredModelingassistantPackage instanceof ModelingassistantPackageImpl ? (ModelingassistantPackageImpl)registeredModelingassistantPackage : new ModelingassistantPackageImpl();

    isInited = true;

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ClassdiagramPackage.eNS_URI);
    ClassdiagramPackageImpl theClassdiagramPackage = (ClassdiagramPackageImpl)(registeredPackage instanceof ClassdiagramPackageImpl ? registeredPackage : ClassdiagramPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(LearningcorpusPackage.eNS_URI);
    LearningcorpusPackageImpl theLearningcorpusPackage = (LearningcorpusPackageImpl)(registeredPackage instanceof LearningcorpusPackageImpl ? registeredPackage : LearningcorpusPackage.eINSTANCE);

    // Create package meta-data objects
    theModelingassistantPackage.createPackageContents();
    theClassdiagramPackage.createPackageContents();
    theLearningcorpusPackage.createPackageContents();

    // Initialize created meta-data
    theModelingassistantPackage.initializePackageContents();
    theClassdiagramPackage.initializePackageContents();
    theLearningcorpusPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theModelingassistantPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ModelingassistantPackage.eNS_URI, theModelingassistantPackage);
    return theModelingassistantPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getModelingAssistant() {
    return modelingAssistantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModelingAssistant_ProblemStatements() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModelingAssistant_Solutions() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModelingAssistant_Students() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModelingAssistant_StudentKnowledges() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModelingAssistant_FeedbackItems() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getStudent() {
    return studentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getStudent_Id() {
    return (EAttribute)studentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getStudent_ModelingAssistant() {
    return (EReference)studentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getStudent_Solutions() {
    return (EReference)studentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getStudent_StudentKnowledges() {
    return (EReference)studentEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getStudent_CurrentSolution() {
    return (EReference)studentEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getProblemStatement() {
    return problemStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getProblemStatement_ProblemStatementElements() {
    return (EReference)problemStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getProblemStatement_ModelingAssistant() {
    return (EReference)problemStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getProblemStatement_StudentSolutions() {
    return (EReference)problemStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getProblemStatement_InstructorSolution() {
    return (EReference)problemStatementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getProblemStatementElement() {
    return problemStatementElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getProblemStatementElement_ProblemStatement() {
    return (EReference)problemStatementElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getProblemStatementElement_SolutionElements() {
    return (EReference)problemStatementElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSolution() {
    return solutionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolution_ModelingAssistant() {
    return (EReference)solutionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolution_Student() {
    return (EReference)solutionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolution_SolutionElements() {
    return (EReference)solutionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolution_ClassDiagram() {
    return (EReference)solutionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolution_Mistakes() {
    return (EReference)solutionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolution_CurrentMistake() {
    return (EReference)solutionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolution_TagGroups() {
    return (EReference)solutionEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolution_ProblemStatement() {
    return (EReference)solutionEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSolutionElement() {
    return solutionElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolutionElement_ProblemStatementElements() {
    return (EReference)solutionElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolutionElement_Solution() {
    return (EReference)solutionElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolutionElement_StudentElementMistakes() {
    return (EReference)solutionElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolutionElement_Element() {
    return (EReference)solutionElementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolutionElement_InstructorElementMistakes() {
    return (EReference)solutionElementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSolutionElement_Tags() {
    return (EReference)solutionElementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getStudentKnowledge() {
    return studentKnowledgeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getStudentKnowledge_LevelOfKnowledge() {
    return (EAttribute)studentKnowledgeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getStudentKnowledge_Student() {
    return (EReference)studentKnowledgeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getStudentKnowledge_ModelingAssistant() {
    return (EReference)studentKnowledgeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getStudentKnowledge_MistakeType() {
    return (EReference)studentKnowledgeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMistake() {
    return mistakeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMistake_Resolved() {
    return (EAttribute)mistakeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMistake_TimeToAddress() {
    return (EAttribute)mistakeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMistake_NumStepsBeforeNotification() {
    return (EAttribute)mistakeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistake_StudentElements() {
    return (EReference)mistakeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistake_LastFeedback() {
    return (EReference)mistakeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistake_InstructorElements() {
    return (EReference)mistakeEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistake_StudentSolution() {
    return (EReference)mistakeEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMistake_NumDetection() {
    return (EAttribute)mistakeEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMistake_NumDetectionSinceResolved() {
    return (EAttribute)mistakeEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistake_MistakeType() {
    return (EReference)mistakeEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getNamedElement() {
    return namedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getNamedElement_Name() {
    return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getFeedbackItem() {
    return feedbackItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFeedbackItem_Mistakes() {
    return (EReference)feedbackItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFeedbackItem_ModelingAssistant() {
    return (EReference)feedbackItemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getFeedbackItem_Usefulness() {
    return (EAttribute)feedbackItemEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFeedbackItem_Feedback() {
    return (EReference)feedbackItemEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTag() {
    return tagEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTag_Solutionelement() {
    return (EReference)tagEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTag_TagGroup() {
    return (EReference)tagEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTagGroup() {
    return tagGroupEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTagGroup_Tags() {
    return (EReference)tagGroupEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTagGroup_Solution() {
    return (EReference)tagGroupEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getTime() {
    return timeEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ModelingassistantFactory getModelingassistantFactory() {
    return (ModelingassistantFactory)getEFactoryInstance();
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
    modelingAssistantEClass = createEClass(MODELING_ASSISTANT);
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__PROBLEM_STATEMENTS);
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__SOLUTIONS);
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__STUDENTS);
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__STUDENT_KNOWLEDGES);
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__FEEDBACK_ITEMS);

    studentEClass = createEClass(STUDENT);
    createEAttribute(studentEClass, STUDENT__ID);
    createEReference(studentEClass, STUDENT__MODELING_ASSISTANT);
    createEReference(studentEClass, STUDENT__SOLUTIONS);
    createEReference(studentEClass, STUDENT__STUDENT_KNOWLEDGES);
    createEReference(studentEClass, STUDENT__CURRENT_SOLUTION);

    problemStatementEClass = createEClass(PROBLEM_STATEMENT);
    createEReference(problemStatementEClass, PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS);
    createEReference(problemStatementEClass, PROBLEM_STATEMENT__MODELING_ASSISTANT);
    createEReference(problemStatementEClass, PROBLEM_STATEMENT__STUDENT_SOLUTIONS);
    createEReference(problemStatementEClass, PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION);

    problemStatementElementEClass = createEClass(PROBLEM_STATEMENT_ELEMENT);
    createEReference(problemStatementElementEClass, PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT);
    createEReference(problemStatementElementEClass, PROBLEM_STATEMENT_ELEMENT__SOLUTION_ELEMENTS);

    solutionEClass = createEClass(SOLUTION);
    createEReference(solutionEClass, SOLUTION__MODELING_ASSISTANT);
    createEReference(solutionEClass, SOLUTION__STUDENT);
    createEReference(solutionEClass, SOLUTION__SOLUTION_ELEMENTS);
    createEReference(solutionEClass, SOLUTION__CLASS_DIAGRAM);
    createEReference(solutionEClass, SOLUTION__MISTAKES);
    createEReference(solutionEClass, SOLUTION__CURRENT_MISTAKE);
    createEReference(solutionEClass, SOLUTION__TAG_GROUPS);
    createEReference(solutionEClass, SOLUTION__PROBLEM_STATEMENT);

    solutionElementEClass = createEClass(SOLUTION_ELEMENT);
    createEReference(solutionElementEClass, SOLUTION_ELEMENT__PROBLEM_STATEMENT_ELEMENTS);
    createEReference(solutionElementEClass, SOLUTION_ELEMENT__SOLUTION);
    createEReference(solutionElementEClass, SOLUTION_ELEMENT__STUDENT_ELEMENT_MISTAKES);
    createEReference(solutionElementEClass, SOLUTION_ELEMENT__ELEMENT);
    createEReference(solutionElementEClass, SOLUTION_ELEMENT__INSTRUCTOR_ELEMENT_MISTAKES);
    createEReference(solutionElementEClass, SOLUTION_ELEMENT__TAGS);

    studentKnowledgeEClass = createEClass(STUDENT_KNOWLEDGE);
    createEAttribute(studentKnowledgeEClass, STUDENT_KNOWLEDGE__LEVEL_OF_KNOWLEDGE);
    createEReference(studentKnowledgeEClass, STUDENT_KNOWLEDGE__STUDENT);
    createEReference(studentKnowledgeEClass, STUDENT_KNOWLEDGE__MODELING_ASSISTANT);
    createEReference(studentKnowledgeEClass, STUDENT_KNOWLEDGE__MISTAKE_TYPE);

    mistakeEClass = createEClass(MISTAKE);
    createEAttribute(mistakeEClass, MISTAKE__RESOLVED);
    createEAttribute(mistakeEClass, MISTAKE__TIME_TO_ADDRESS);
    createEAttribute(mistakeEClass, MISTAKE__NUM_STEPS_BEFORE_NOTIFICATION);
    createEReference(mistakeEClass, MISTAKE__STUDENT_ELEMENTS);
    createEReference(mistakeEClass, MISTAKE__LAST_FEEDBACK);
    createEReference(mistakeEClass, MISTAKE__INSTRUCTOR_ELEMENTS);
    createEReference(mistakeEClass, MISTAKE__STUDENT_SOLUTION);
    createEAttribute(mistakeEClass, MISTAKE__NUM_DETECTION);
    createEAttribute(mistakeEClass, MISTAKE__NUM_DETECTION_SINCE_RESOLVED);
    createEReference(mistakeEClass, MISTAKE__MISTAKE_TYPE);

    namedElementEClass = createEClass(NAMED_ELEMENT);
    createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

    feedbackItemEClass = createEClass(FEEDBACK_ITEM);
    createEReference(feedbackItemEClass, FEEDBACK_ITEM__MISTAKES);
    createEReference(feedbackItemEClass, FEEDBACK_ITEM__MODELING_ASSISTANT);
    createEAttribute(feedbackItemEClass, FEEDBACK_ITEM__USEFULNESS);
    createEReference(feedbackItemEClass, FEEDBACK_ITEM__FEEDBACK);

    tagEClass = createEClass(TAG);
    createEReference(tagEClass, TAG__SOLUTIONELEMENT);
    createEReference(tagEClass, TAG__TAG_GROUP);

    tagGroupEClass = createEClass(TAG_GROUP);
    createEReference(tagGroupEClass, TAG_GROUP__TAGS);
    createEReference(tagGroupEClass, TAG_GROUP__SOLUTION);

    // Create data types
    timeEDataType = createEDataType(TIME);
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
    ClassdiagramPackage theClassdiagramPackage = (ClassdiagramPackage)EPackage.Registry.INSTANCE.getEPackage(ClassdiagramPackage.eNS_URI);
    LearningcorpusPackage theLearningcorpusPackage = (LearningcorpusPackage)EPackage.Registry.INSTANCE.getEPackage(LearningcorpusPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    studentEClass.getESuperTypes().add(this.getNamedElement());
    problemStatementEClass.getESuperTypes().add(this.getNamedElement());
    problemStatementElementEClass.getESuperTypes().add(this.getNamedElement());

    // Initialize classes, features, and operations; add parameters
    initEClass(modelingAssistantEClass, ModelingAssistant.class, "ModelingAssistant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModelingAssistant_ProblemStatements(), this.getProblemStatement(), this.getProblemStatement_ModelingAssistant(), "problemStatements", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelingAssistant_Solutions(), this.getSolution(), this.getSolution_ModelingAssistant(), "solutions", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelingAssistant_Students(), this.getStudent(), this.getStudent_ModelingAssistant(), "students", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelingAssistant_StudentKnowledges(), this.getStudentKnowledge(), this.getStudentKnowledge_ModelingAssistant(), "studentKnowledges", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelingAssistant_FeedbackItems(), this.getFeedbackItem(), this.getFeedbackItem_ModelingAssistant(), "feedbackItems", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(studentEClass, Student.class, "Student", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStudent_Id(), ecorePackage.getEString(), "id", null, 0, 1, Student.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudent_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_Students(), "modelingAssistant", null, 1, 1, Student.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudent_Solutions(), this.getSolution(), this.getSolution_Student(), "solutions", null, 0, -1, Student.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudent_StudentKnowledges(), this.getStudentKnowledge(), this.getStudentKnowledge_Student(), "studentKnowledges", null, 0, -1, Student.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudent_CurrentSolution(), this.getSolution(), null, "currentSolution", null, 0, 1, Student.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(problemStatementEClass, ProblemStatement.class, "ProblemStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProblemStatement_ProblemStatementElements(), this.getProblemStatementElement(), this.getProblemStatementElement_ProblemStatement(), "problemStatementElements", null, 0, -1, ProblemStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProblemStatement_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_ProblemStatements(), "modelingAssistant", null, 1, 1, ProblemStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProblemStatement_StudentSolutions(), this.getSolution(), null, "studentSolutions", null, 0, -1, ProblemStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProblemStatement_InstructorSolution(), this.getSolution(), null, "instructorSolution", null, 1, 1, ProblemStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(problemStatementElementEClass, ProblemStatementElement.class, "ProblemStatementElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProblemStatementElement_ProblemStatement(), this.getProblemStatement(), this.getProblemStatement_ProblemStatementElements(), "problemStatement", null, 1, 1, ProblemStatementElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProblemStatementElement_SolutionElements(), this.getSolutionElement(), this.getSolutionElement_ProblemStatementElements(), "solutionElements", null, 0, -1, ProblemStatementElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(solutionEClass, Solution.class, "Solution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSolution_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_Solutions(), "modelingAssistant", null, 1, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolution_Student(), this.getStudent(), this.getStudent_Solutions(), "student", null, 0, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolution_SolutionElements(), this.getSolutionElement(), this.getSolutionElement_Solution(), "solutionElements", null, 0, -1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolution_ClassDiagram(), theClassdiagramPackage.getClassDiagram(), null, "classDiagram", null, 1, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolution_Mistakes(), this.getMistake(), this.getMistake_StudentSolution(), "mistakes", null, 0, -1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolution_CurrentMistake(), this.getMistake(), null, "currentMistake", null, 0, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolution_TagGroups(), this.getTagGroup(), this.getTagGroup_Solution(), "tagGroups", null, 0, -1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolution_ProblemStatement(), this.getProblemStatement(), null, "problemStatement", null, 1, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(solutionElementEClass, SolutionElement.class, "SolutionElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSolutionElement_ProblemStatementElements(), this.getProblemStatementElement(), this.getProblemStatementElement_SolutionElements(), "problemStatementElements", null, 0, -1, SolutionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolutionElement_Solution(), this.getSolution(), this.getSolution_SolutionElements(), "solution", null, 1, 1, SolutionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolutionElement_StudentElementMistakes(), this.getMistake(), this.getMistake_StudentElements(), "studentElementMistakes", null, 0, -1, SolutionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolutionElement_Element(), theClassdiagramPackage.getNamedElement(), null, "element", null, 1, 1, SolutionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolutionElement_InstructorElementMistakes(), this.getMistake(), this.getMistake_InstructorElements(), "instructorElementMistakes", null, 0, -1, SolutionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolutionElement_Tags(), this.getTag(), this.getTag_Solutionelement(), "tags", null, 0, -1, SolutionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(studentKnowledgeEClass, StudentKnowledge.class, "StudentKnowledge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStudentKnowledge_LevelOfKnowledge(), ecorePackage.getEInt(), "levelOfKnowledge", null, 0, 1, StudentKnowledge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudentKnowledge_Student(), this.getStudent(), this.getStudent_StudentKnowledges(), "student", null, 1, 1, StudentKnowledge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudentKnowledge_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_StudentKnowledges(), "modelingAssistant", null, 1, 1, StudentKnowledge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudentKnowledge_MistakeType(), theLearningcorpusPackage.getMistakeType(), null, "mistakeType", null, 0, 1, StudentKnowledge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mistakeEClass, Mistake.class, "Mistake", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMistake_Resolved(), ecorePackage.getEBoolean(), "resolved", null, 0, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistake_TimeToAddress(), this.getTime(), "timeToAddress", null, 0, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistake_NumStepsBeforeNotification(), ecorePackage.getEInt(), "numStepsBeforeNotification", null, 0, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistake_StudentElements(), this.getSolutionElement(), this.getSolutionElement_StudentElementMistakes(), "studentElements", null, 0, -1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistake_LastFeedback(), this.getFeedbackItem(), this.getFeedbackItem_Mistakes(), "lastFeedback", null, 0, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistake_InstructorElements(), this.getSolutionElement(), this.getSolutionElement_InstructorElementMistakes(), "instructorElements", null, 0, -1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistake_StudentSolution(), this.getSolution(), this.getSolution_Mistakes(), "studentSolution", null, 1, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistake_NumDetection(), ecorePackage.getEInt(), "numDetection", null, 0, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistake_NumDetectionSinceResolved(), ecorePackage.getEInt(), "numDetectionSinceResolved", null, 0, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistake_MistakeType(), theLearningcorpusPackage.getMistakeType(), null, "mistakeType", null, 0, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(feedbackItemEClass, FeedbackItem.class, "FeedbackItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFeedbackItem_Mistakes(), this.getMistake(), this.getMistake_LastFeedback(), "mistakes", null, 0, 1, FeedbackItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeedbackItem_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_FeedbackItems(), "modelingAssistant", null, 1, 1, FeedbackItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeedbackItem_Usefulness(), ecorePackage.getEDouble(), "usefulness", null, 0, 1, FeedbackItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeedbackItem_Feedback(), theLearningcorpusPackage.getFeedback(), null, "feedback", null, 0, 1, FeedbackItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tagEClass, Tag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTag_Solutionelement(), this.getSolutionElement(), this.getSolutionElement_Tags(), "solutionelement", null, 1, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTag_TagGroup(), this.getTagGroup(), this.getTagGroup_Tags(), "tagGroup", null, 1, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tagGroupEClass, TagGroup.class, "TagGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTagGroup_Tags(), this.getTag(), this.getTag_TagGroup(), "tags", null, 0, -1, TagGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTagGroup_Solution(), this.getSolution(), this.getSolution_TagGroups(), "solution", null, 1, 1, TagGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize data types
    initEDataType(timeEDataType, Time.class, "Time", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //ModelingassistantPackageImpl
