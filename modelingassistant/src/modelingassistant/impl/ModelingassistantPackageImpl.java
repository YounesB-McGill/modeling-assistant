/**
 */
package modelingassistant.impl;

import classdiagram.ClassdiagramPackage;

import classdiagram.impl.ClassdiagramPackageImpl;

import java.sql.Time;

import modelingassistant.Example;
import modelingassistant.Feedback;
import modelingassistant.LearningItem;
import modelingassistant.LearningResource;
import modelingassistant.Mistake;
import modelingassistant.MistakeType;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.ParametrizedResponse;
import modelingassistant.ProblemStatement;
import modelingassistant.ProblemStatementElement;
import modelingassistant.Quiz;
import modelingassistant.Reference;
import modelingassistant.ResourceResponse;
import modelingassistant.Solution;
import modelingassistant.SolutionElement;
import modelingassistant.Student;
import modelingassistant.StudentKnowledge;
import modelingassistant.TextResponse;
import modelingassistant.Tutorial;
import modelingassistant.UmlElement;

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
  private EClass umlElementEClass = null;

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
  private EClass learningItemEClass = null;

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
  private EClass mistakeTypeEClass = null;

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
  private EClass feedbackEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass textResponseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parametrizedResponseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resourceResponseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass learningResourceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tutorialEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exampleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass quizEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType intEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType booleanEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType timeEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType doubleEDataType = null;

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

    // Create package meta-data objects
    theModelingassistantPackage.createPackageContents();
    theClassdiagramPackage.createPackageContents();

    // Initialize created meta-data
    theModelingassistantPackage.initializePackageContents();
    theClassdiagramPackage.initializePackageContents();

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
  public EClass getModelingAssistant() {
    return modelingAssistantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelingAssistant_LearningItems() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelingAssistant_LearningResources() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelingAssistant_ProblemStatements() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelingAssistant_Solutions() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelingAssistant_UmlElements() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelingAssistant_Students() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelingAssistant_Feedbacks() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelingAssistant_Mistakes() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelingAssistant_MistakeTypes() {
    return (EReference)modelingAssistantEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStudent() {
    return studentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStudent_Id() {
    return (EAttribute)studentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStudent_ModelingAssistant() {
    return (EReference)studentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStudent_Mistakes() {
    return (EReference)studentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStudent_CurrentMistake() {
    return (EReference)studentEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStudent_Solutions() {
    return (EReference)studentEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStudent_StudentKnowledges() {
    return (EReference)studentEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProblemStatement() {
    return problemStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProblemStatement_ModelingAssistant() {
    return (EReference)problemStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProblemStatement_ProblemStatementElements() {
    return (EReference)problemStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProblemStatementElement() {
    return problemStatementElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProblemStatementElement_ProblemStatement() {
    return (EReference)problemStatementElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProblemStatementElement_SolutionElements() {
    return (EReference)problemStatementElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUmlElement() {
    return umlElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUmlElement_ModelingAssistant() {
    return (EReference)umlElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUmlElement_SolutionElements() {
    return (EReference)umlElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUmlElement_LearningItems() {
    return (EReference)umlElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSolution() {
    return solutionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSolution_ModelingAssistant() {
    return (EReference)solutionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSolution_Student() {
    return (EReference)solutionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSolution_SolutionElements() {
    return (EReference)solutionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSolution_ClassDiagram() {
    return (EReference)solutionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSolutionElement() {
    return solutionElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSolutionElement_ProblemStatementElements() {
    return (EReference)solutionElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSolutionElement_Type() {
    return (EReference)solutionElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSolutionElement_Solution() {
    return (EReference)solutionElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSolutionElement_Mistakes() {
    return (EReference)solutionElementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSolutionElement_Element() {
    return (EReference)solutionElementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLearningItem() {
    return learningItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLearningItem_ModelingAssistant() {
    return (EReference)learningItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLearningItem_UmlElements() {
    return (EReference)learningItemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLearningItem_LearningResources() {
    return (EReference)learningItemEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLearningItem_MistakeTypes() {
    return (EReference)learningItemEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStudentKnowledge() {
    return studentKnowledgeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStudentKnowledge_LevelOfKnowledge() {
    return (EAttribute)studentKnowledgeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStudentKnowledge_Student() {
    return (EReference)studentKnowledgeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStudentKnowledge_MistakeType() {
    return (EReference)studentKnowledgeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMistakeType() {
    return mistakeTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMistakeType_Name() {
    return (EAttribute)mistakeTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMistakeType_Atomic() {
    return (EAttribute)mistakeTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMistakeType_TimeToAddress() {
    return (EAttribute)mistakeTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMistakeType_NumStepsBeforeNotification() {
    return (EAttribute)mistakeTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMistakeType_ModelingAssistant() {
    return (EReference)mistakeTypeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMistakeType_LearningItem() {
    return (EReference)mistakeTypeEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMistakeType_StudentKnowledges() {
    return (EReference)mistakeTypeEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMistakeType_Mistakes() {
    return (EReference)mistakeTypeEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMistakeType_Feedbacks() {
    return (EReference)mistakeTypeEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMistake() {
    return mistakeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMistake_Resolved() {
    return (EAttribute)mistakeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMistake_TimeToAddress() {
    return (EAttribute)mistakeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMistake_NumStepsBeforeNotification() {
    return (EAttribute)mistakeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMistake_ModelingAssistant() {
    return (EReference)mistakeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMistake_MistakeStudent() {
    return (EReference)mistakeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMistake_CurrentMistakeStudent() {
    return (EReference)mistakeEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMistake_SolutionElements() {
    return (EReference)mistakeEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMistake_MistakeType() {
    return (EReference)mistakeEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMistake_LastFeedback() {
    return (EReference)mistakeEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeedback() {
    return feedbackEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeedback_Level() {
    return (EAttribute)feedbackEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeedback_Congratulatory() {
    return (EAttribute)feedbackEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeedback_Usefulness() {
    return (EAttribute)feedbackEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeedback_HighlightProblem() {
    return (EAttribute)feedbackEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeedback_HighlightSolution() {
    return (EAttribute)feedbackEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeedback_ModelingAssistant() {
    return (EReference)feedbackEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeedback_MistakeType() {
    return (EReference)feedbackEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeedback_Mistakes() {
    return (EReference)feedbackEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTextResponse() {
    return textResponseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParametrizedResponse() {
    return parametrizedResponseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResourceResponse() {
    return resourceResponseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResourceResponse_LearningResources() {
    return (EReference)resourceResponseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLearningResource() {
    return learningResourceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLearningResource_ModelingAssistant() {
    return (EReference)learningResourceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLearningResource_LearningItem() {
    return (EReference)learningResourceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLearningResource_ResourceResponses() {
    return (EReference)learningResourceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReference() {
    return referenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTutorial() {
    return tutorialEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExample() {
    return exampleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQuiz() {
    return quizEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getint() {
    return intEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getboolean() {
    return booleanEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getTime() {
    return timeEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getdouble() {
    return doubleEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__LEARNING_ITEMS);
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__LEARNING_RESOURCES);
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__PROBLEM_STATEMENTS);
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__SOLUTIONS);
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__UML_ELEMENTS);
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__STUDENTS);
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__FEEDBACKS);
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__MISTAKES);
    createEReference(modelingAssistantEClass, MODELING_ASSISTANT__MISTAKE_TYPES);

    studentEClass = createEClass(STUDENT);
    createEAttribute(studentEClass, STUDENT__ID);
    createEReference(studentEClass, STUDENT__MODELING_ASSISTANT);
    createEReference(studentEClass, STUDENT__MISTAKES);
    createEReference(studentEClass, STUDENT__CURRENT_MISTAKE);
    createEReference(studentEClass, STUDENT__SOLUTIONS);
    createEReference(studentEClass, STUDENT__STUDENT_KNOWLEDGES);

    problemStatementEClass = createEClass(PROBLEM_STATEMENT);
    createEReference(problemStatementEClass, PROBLEM_STATEMENT__MODELING_ASSISTANT);
    createEReference(problemStatementEClass, PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS);

    problemStatementElementEClass = createEClass(PROBLEM_STATEMENT_ELEMENT);
    createEReference(problemStatementElementEClass, PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT);
    createEReference(problemStatementElementEClass, PROBLEM_STATEMENT_ELEMENT__SOLUTION_ELEMENTS);

    umlElementEClass = createEClass(UML_ELEMENT);
    createEReference(umlElementEClass, UML_ELEMENT__MODELING_ASSISTANT);
    createEReference(umlElementEClass, UML_ELEMENT__SOLUTION_ELEMENTS);
    createEReference(umlElementEClass, UML_ELEMENT__LEARNING_ITEMS);

    solutionEClass = createEClass(SOLUTION);
    createEReference(solutionEClass, SOLUTION__MODELING_ASSISTANT);
    createEReference(solutionEClass, SOLUTION__STUDENT);
    createEReference(solutionEClass, SOLUTION__SOLUTION_ELEMENTS);
    createEReference(solutionEClass, SOLUTION__CLASS_DIAGRAM);

    solutionElementEClass = createEClass(SOLUTION_ELEMENT);
    createEReference(solutionElementEClass, SOLUTION_ELEMENT__PROBLEM_STATEMENT_ELEMENTS);
    createEReference(solutionElementEClass, SOLUTION_ELEMENT__TYPE);
    createEReference(solutionElementEClass, SOLUTION_ELEMENT__SOLUTION);
    createEReference(solutionElementEClass, SOLUTION_ELEMENT__MISTAKES);
    createEReference(solutionElementEClass, SOLUTION_ELEMENT__ELEMENT);

    learningItemEClass = createEClass(LEARNING_ITEM);
    createEReference(learningItemEClass, LEARNING_ITEM__MODELING_ASSISTANT);
    createEReference(learningItemEClass, LEARNING_ITEM__UML_ELEMENTS);
    createEReference(learningItemEClass, LEARNING_ITEM__LEARNING_RESOURCES);
    createEReference(learningItemEClass, LEARNING_ITEM__MISTAKE_TYPES);

    studentKnowledgeEClass = createEClass(STUDENT_KNOWLEDGE);
    createEAttribute(studentKnowledgeEClass, STUDENT_KNOWLEDGE__LEVEL_OF_KNOWLEDGE);
    createEReference(studentKnowledgeEClass, STUDENT_KNOWLEDGE__STUDENT);
    createEReference(studentKnowledgeEClass, STUDENT_KNOWLEDGE__MISTAKE_TYPE);

    mistakeTypeEClass = createEClass(MISTAKE_TYPE);
    createEAttribute(mistakeTypeEClass, MISTAKE_TYPE__NAME);
    createEAttribute(mistakeTypeEClass, MISTAKE_TYPE__ATOMIC);
    createEAttribute(mistakeTypeEClass, MISTAKE_TYPE__TIME_TO_ADDRESS);
    createEAttribute(mistakeTypeEClass, MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION);
    createEReference(mistakeTypeEClass, MISTAKE_TYPE__MODELING_ASSISTANT);
    createEReference(mistakeTypeEClass, MISTAKE_TYPE__LEARNING_ITEM);
    createEReference(mistakeTypeEClass, MISTAKE_TYPE__STUDENT_KNOWLEDGES);
    createEReference(mistakeTypeEClass, MISTAKE_TYPE__MISTAKES);
    createEReference(mistakeTypeEClass, MISTAKE_TYPE__FEEDBACKS);

    mistakeEClass = createEClass(MISTAKE);
    createEAttribute(mistakeEClass, MISTAKE__RESOLVED);
    createEAttribute(mistakeEClass, MISTAKE__TIME_TO_ADDRESS);
    createEAttribute(mistakeEClass, MISTAKE__NUM_STEPS_BEFORE_NOTIFICATION);
    createEReference(mistakeEClass, MISTAKE__MODELING_ASSISTANT);
    createEReference(mistakeEClass, MISTAKE__MISTAKE_STUDENT);
    createEReference(mistakeEClass, MISTAKE__CURRENT_MISTAKE_STUDENT);
    createEReference(mistakeEClass, MISTAKE__SOLUTION_ELEMENTS);
    createEReference(mistakeEClass, MISTAKE__MISTAKE_TYPE);
    createEReference(mistakeEClass, MISTAKE__LAST_FEEDBACK);

    feedbackEClass = createEClass(FEEDBACK);
    createEAttribute(feedbackEClass, FEEDBACK__LEVEL);
    createEAttribute(feedbackEClass, FEEDBACK__CONGRATULATORY);
    createEAttribute(feedbackEClass, FEEDBACK__USEFULNESS);
    createEAttribute(feedbackEClass, FEEDBACK__HIGHLIGHT_PROBLEM);
    createEAttribute(feedbackEClass, FEEDBACK__HIGHLIGHT_SOLUTION);
    createEReference(feedbackEClass, FEEDBACK__MODELING_ASSISTANT);
    createEReference(feedbackEClass, FEEDBACK__MISTAKE_TYPE);
    createEReference(feedbackEClass, FEEDBACK__MISTAKES);

    textResponseEClass = createEClass(TEXT_RESPONSE);

    parametrizedResponseEClass = createEClass(PARAMETRIZED_RESPONSE);

    resourceResponseEClass = createEClass(RESOURCE_RESPONSE);
    createEReference(resourceResponseEClass, RESOURCE_RESPONSE__LEARNING_RESOURCES);

    learningResourceEClass = createEClass(LEARNING_RESOURCE);
    createEReference(learningResourceEClass, LEARNING_RESOURCE__MODELING_ASSISTANT);
    createEReference(learningResourceEClass, LEARNING_RESOURCE__LEARNING_ITEM);
    createEReference(learningResourceEClass, LEARNING_RESOURCE__RESOURCE_RESPONSES);

    referenceEClass = createEClass(REFERENCE);

    tutorialEClass = createEClass(TUTORIAL);

    exampleEClass = createEClass(EXAMPLE);

    quizEClass = createEClass(QUIZ);

    // Create data types
    intEDataType = createEDataType(INT);
    booleanEDataType = createEDataType(BOOLEAN);
    timeEDataType = createEDataType(TIME);
    doubleEDataType = createEDataType(DOUBLE);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    textResponseEClass.getESuperTypes().add(this.getFeedback());
    parametrizedResponseEClass.getESuperTypes().add(this.getFeedback());
    resourceResponseEClass.getESuperTypes().add(this.getFeedback());
    referenceEClass.getESuperTypes().add(this.getLearningResource());
    tutorialEClass.getESuperTypes().add(this.getLearningResource());
    exampleEClass.getESuperTypes().add(this.getLearningResource());
    quizEClass.getESuperTypes().add(this.getLearningResource());

    // Initialize classes, features, and operations; add parameters
    initEClass(modelingAssistantEClass, ModelingAssistant.class, "ModelingAssistant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModelingAssistant_LearningItems(), this.getLearningItem(), this.getLearningItem_ModelingAssistant(), "learningItems", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelingAssistant_LearningResources(), this.getLearningResource(), this.getLearningResource_ModelingAssistant(), "learningResources", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelingAssistant_ProblemStatements(), this.getProblemStatement(), this.getProblemStatement_ModelingAssistant(), "problemStatements", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelingAssistant_Solutions(), this.getSolution(), this.getSolution_ModelingAssistant(), "solutions", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelingAssistant_UmlElements(), this.getUmlElement(), this.getUmlElement_ModelingAssistant(), "umlElements", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelingAssistant_Students(), this.getStudent(), this.getStudent_ModelingAssistant(), "students", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelingAssistant_Feedbacks(), this.getFeedback(), this.getFeedback_ModelingAssistant(), "feedbacks", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelingAssistant_Mistakes(), this.getMistake(), this.getMistake_ModelingAssistant(), "mistakes", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelingAssistant_MistakeTypes(), this.getMistakeType(), this.getMistakeType_ModelingAssistant(), "mistakeTypes", null, 0, -1, ModelingAssistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(studentEClass, Student.class, "Student", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStudent_Id(), ecorePackage.getEString(), "id", null, 0, 1, Student.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudent_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_Students(), "modelingAssistant", null, 1, 1, Student.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudent_Mistakes(), this.getMistake(), this.getMistake_MistakeStudent(), "mistakes", null, 0, -1, Student.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudent_CurrentMistake(), this.getMistake(), this.getMistake_CurrentMistakeStudent(), "currentMistake", null, 0, 1, Student.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudent_Solutions(), this.getSolution(), this.getSolution_Student(), "solutions", null, 0, -1, Student.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudent_StudentKnowledges(), this.getStudentKnowledge(), this.getStudentKnowledge_Student(), "studentKnowledges", null, 0, -1, Student.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(problemStatementEClass, ProblemStatement.class, "ProblemStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProblemStatement_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_ProblemStatements(), "modelingAssistant", null, 1, 1, ProblemStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProblemStatement_ProblemStatementElements(), this.getProblemStatementElement(), this.getProblemStatementElement_ProblemStatement(), "problemStatementElements", null, 0, -1, ProblemStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(problemStatementElementEClass, ProblemStatementElement.class, "ProblemStatementElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProblemStatementElement_ProblemStatement(), this.getProblemStatement(), this.getProblemStatement_ProblemStatementElements(), "problemStatement", null, 1, 1, ProblemStatementElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProblemStatementElement_SolutionElements(), this.getSolutionElement(), this.getSolutionElement_ProblemStatementElements(), "solutionElements", null, 0, -1, ProblemStatementElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlElementEClass, UmlElement.class, "UmlElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUmlElement_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_UmlElements(), "modelingAssistant", null, 1, 1, UmlElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUmlElement_SolutionElements(), this.getSolutionElement(), this.getSolutionElement_Type(), "solutionElements", null, 0, -1, UmlElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUmlElement_LearningItems(), this.getLearningItem(), this.getLearningItem_UmlElements(), "learningItems", null, 0, -1, UmlElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(solutionEClass, Solution.class, "Solution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSolution_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_Solutions(), "modelingAssistant", null, 1, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolution_Student(), this.getStudent(), this.getStudent_Solutions(), "student", null, 0, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolution_SolutionElements(), this.getSolutionElement(), this.getSolutionElement_Solution(), "solutionElements", null, 0, -1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolution_ClassDiagram(), theClassdiagramPackage.getClassDiagram(), null, "classDiagram", null, 1, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(solutionElementEClass, SolutionElement.class, "SolutionElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSolutionElement_ProblemStatementElements(), this.getProblemStatementElement(), this.getProblemStatementElement_SolutionElements(), "problemStatementElements", null, 0, -1, SolutionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolutionElement_Type(), this.getUmlElement(), this.getUmlElement_SolutionElements(), "type", null, 1, 1, SolutionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolutionElement_Solution(), this.getSolution(), this.getSolution_SolutionElements(), "solution", null, 1, 1, SolutionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolutionElement_Mistakes(), this.getMistake(), this.getMistake_SolutionElements(), "mistakes", null, 0, -1, SolutionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSolutionElement_Element(), theClassdiagramPackage.getNamedElement(), null, "element", null, 1, 1, SolutionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(learningItemEClass, LearningItem.class, "LearningItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLearningItem_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_LearningItems(), "modelingAssistant", null, 1, 1, LearningItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLearningItem_UmlElements(), this.getUmlElement(), this.getUmlElement_LearningItems(), "umlElements", null, 0, -1, LearningItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLearningItem_LearningResources(), this.getLearningResource(), this.getLearningResource_LearningItem(), "learningResources", null, 0, -1, LearningItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLearningItem_MistakeTypes(), this.getMistakeType(), this.getMistakeType_LearningItem(), "mistakeTypes", null, 0, -1, LearningItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(studentKnowledgeEClass, StudentKnowledge.class, "StudentKnowledge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStudentKnowledge_LevelOfKnowledge(), this.getint(), "levelOfKnowledge", null, 0, 1, StudentKnowledge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudentKnowledge_Student(), this.getStudent(), this.getStudent_StudentKnowledges(), "student", null, 1, 1, StudentKnowledge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStudentKnowledge_MistakeType(), this.getMistakeType(), this.getMistakeType_StudentKnowledges(), "mistakeType", null, 1, 1, StudentKnowledge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mistakeTypeEClass, MistakeType.class, "MistakeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMistakeType_Name(), ecorePackage.getEString(), "name", null, 0, 1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistakeType_Atomic(), this.getboolean(), "atomic", null, 0, 1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistakeType_TimeToAddress(), this.getTime(), "timeToAddress", null, 0, 1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistakeType_NumStepsBeforeNotification(), this.getint(), "numStepsBeforeNotification", null, 0, 1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistakeType_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_MistakeTypes(), "modelingAssistant", null, 1, 1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistakeType_LearningItem(), this.getLearningItem(), this.getLearningItem_MistakeTypes(), "learningItem", null, 1, 1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistakeType_StudentKnowledges(), this.getStudentKnowledge(), this.getStudentKnowledge_MistakeType(), "studentKnowledges", null, 0, -1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistakeType_Mistakes(), this.getMistake(), this.getMistake_MistakeType(), "mistakes", null, 0, -1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistakeType_Feedbacks(), this.getFeedback(), this.getFeedback_MistakeType(), "feedbacks", null, 0, -1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mistakeEClass, Mistake.class, "Mistake", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMistake_Resolved(), this.getboolean(), "resolved", null, 0, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistake_TimeToAddress(), this.getTime(), "timeToAddress", null, 0, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistake_NumStepsBeforeNotification(), this.getint(), "numStepsBeforeNotification", null, 0, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistake_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_Mistakes(), "modelingAssistant", null, 1, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistake_MistakeStudent(), this.getStudent(), this.getStudent_Mistakes(), "mistakeStudent", null, 1, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistake_CurrentMistakeStudent(), this.getStudent(), this.getStudent_CurrentMistake(), "currentMistakeStudent", null, 1, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistake_SolutionElements(), this.getSolutionElement(), this.getSolutionElement_Mistakes(), "solutionElements", null, 0, -1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistake_MistakeType(), this.getMistakeType(), this.getMistakeType_Mistakes(), "mistakeType", null, 1, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistake_LastFeedback(), this.getFeedback(), this.getFeedback_Mistakes(), "lastFeedback", null, 0, 1, Mistake.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(feedbackEClass, Feedback.class, "Feedback", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFeedback_Level(), this.getint(), "level", null, 0, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeedback_Congratulatory(), this.getboolean(), "congratulatory", null, 0, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeedback_Usefulness(), this.getdouble(), "usefulness", null, 0, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeedback_HighlightProblem(), this.getboolean(), "highlightProblem", null, 0, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeedback_HighlightSolution(), this.getboolean(), "highlightSolution", null, 0, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeedback_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_Feedbacks(), "modelingAssistant", null, 1, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeedback_MistakeType(), this.getMistakeType(), this.getMistakeType_Feedbacks(), "mistakeType", null, 1, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeedback_Mistakes(), this.getMistake(), this.getMistake_LastFeedback(), "mistakes", null, 0, -1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(textResponseEClass, TextResponse.class, "TextResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(parametrizedResponseEClass, ParametrizedResponse.class, "ParametrizedResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(resourceResponseEClass, ResourceResponse.class, "ResourceResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResourceResponse_LearningResources(), this.getLearningResource(), this.getLearningResource_ResourceResponses(), "learningResources", null, 1, -1, ResourceResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(learningResourceEClass, LearningResource.class, "LearningResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLearningResource_ModelingAssistant(), this.getModelingAssistant(), this.getModelingAssistant_LearningResources(), "modelingAssistant", null, 1, 1, LearningResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLearningResource_LearningItem(), this.getLearningItem(), this.getLearningItem_LearningResources(), "learningItem", null, 1, 1, LearningResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLearningResource_ResourceResponses(), this.getResourceResponse(), this.getResourceResponse_LearningResources(), "resourceResponses", null, 0, -1, LearningResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tutorialEClass, Tutorial.class, "Tutorial", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(exampleEClass, Example.class, "Example", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(quizEClass, Quiz.class, "Quiz", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize data types
    initEDataType(intEDataType, int.class, "int", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(booleanEDataType, boolean.class, "boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(timeEDataType, Time.class, "Time", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(doubleEDataType, double.class, "double", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //ModelingassistantPackageImpl