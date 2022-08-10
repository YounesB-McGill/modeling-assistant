/**
 */
package learningcorpus.impl;

import ca.mcgill.sel.classdiagram.CdmPackage;
import ca.mcgill.sel.core.CorePackage;
import java.sql.Time;

import learningcorpus.ElementType;
import learningcorpus.Example;
import learningcorpus.Feedback;
import learningcorpus.LearningCorpus;
import learningcorpus.LearningItem;
import learningcorpus.LearningResource;
import learningcorpus.LearningcorpusFactory;
import learningcorpus.LearningcorpusPackage;
import learningcorpus.MistakeElement;
import learningcorpus.MistakeType;
import learningcorpus.MistakeTypeCategory;
import learningcorpus.NamedElement;
import learningcorpus.ParametrizedResponse;
import learningcorpus.Quiz;
import learningcorpus.Reference;
import learningcorpus.ResourceResponse;
import learningcorpus.TextResponse;
import learningcorpus.Tutorial;
import learningcorpusquiz.LearningcorpusquizPackage;
import learningcorpusquiz.impl.LearningcorpusquizPackageImpl;
import modelingassistant.ModelingassistantPackage;

import modelingassistant.impl.ModelingassistantPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LearningcorpusPackageImpl extends EPackageImpl implements LearningcorpusPackage {
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
  private EClass mistakeTypeEClass = null;

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
  private EClass namedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mistakeTypeCategoryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass learningCorpusEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mistakeElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum elementTypeEEnum = null;

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
   * @see learningcorpus.LearningcorpusPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private LearningcorpusPackageImpl() {
    super(eNS_URI, LearningcorpusFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link LearningcorpusPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static LearningcorpusPackage init() {
    if (isInited) return (LearningcorpusPackage)EPackage.Registry.INSTANCE.getEPackage(LearningcorpusPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredLearningcorpusPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    LearningcorpusPackageImpl theLearningcorpusPackage = registeredLearningcorpusPackage instanceof LearningcorpusPackageImpl ? (LearningcorpusPackageImpl)registeredLearningcorpusPackage : new LearningcorpusPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    CdmPackage.eINSTANCE.eClass();
    CorePackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ModelingassistantPackage.eNS_URI);
    ModelingassistantPackageImpl theModelingassistantPackage = (ModelingassistantPackageImpl)(registeredPackage instanceof ModelingassistantPackageImpl ? registeredPackage : ModelingassistantPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(LearningcorpusquizPackage.eNS_URI);
    LearningcorpusquizPackageImpl theLearningcorpusquizPackage = (LearningcorpusquizPackageImpl)(registeredPackage instanceof LearningcorpusquizPackageImpl ? registeredPackage : LearningcorpusquizPackage.eINSTANCE);

    // Create package meta-data objects
    theLearningcorpusPackage.createPackageContents();
    theModelingassistantPackage.createPackageContents();
    theLearningcorpusquizPackage.createPackageContents();

    // Initialize created meta-data
    theLearningcorpusPackage.initializePackageContents();
    theModelingassistantPackage.initializePackageContents();
    theLearningcorpusquizPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theLearningcorpusPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(LearningcorpusPackage.eNS_URI, theLearningcorpusPackage);
    return theLearningcorpusPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLearningItem() {
    return learningItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLearningItem_LearningResources() {
    return (EReference)learningItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLearningItem_MistakeTypes() {
    return (EReference)learningItemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getLearningItem_Description() {
    return (EAttribute)learningItemEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLearningItem_LearningCorpus() {
    return (EReference)learningItemEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getLearningItem_ElementType() {
    return (EAttribute)learningItemEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMistakeType() {
    return mistakeTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMistakeType_Atomic() {
    return (EAttribute)mistakeTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMistakeType_TimeToAddress() {
    return (EAttribute)mistakeTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMistakeType_NumStepsBeforeNotification() {
    return (EAttribute)mistakeTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistakeType_LearningItem() {
    return (EReference)mistakeTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistakeType_Feedbacks() {
    return (EReference)mistakeTypeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistakeType_MistakeTypeCategory() {
    return (EReference)mistakeTypeEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMistakeType_Priority() {
    return (EAttribute)mistakeTypeEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMistakeType_Description() {
    return (EAttribute)mistakeTypeEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistakeType_StudentElements() {
    return (EReference)mistakeTypeEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistakeType_InstructorElements() {
    return (EReference)mistakeTypeEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getFeedback() {
    return feedbackEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getFeedback_Level() {
    return (EAttribute)feedbackEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getFeedback_Congratulatory() {
    return (EAttribute)feedbackEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getFeedback_Usefulness() {
    return (EAttribute)feedbackEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getFeedback_HighlightProblem() {
    return (EAttribute)feedbackEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getFeedback_HighlightSolution() {
    return (EAttribute)feedbackEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFeedback_MistakeType() {
    return (EReference)feedbackEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getFeedback_Text() {
    return (EAttribute)feedbackEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFeedback_LearningCorpus() {
    return (EReference)feedbackEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTextResponse() {
    return textResponseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getParametrizedResponse() {
    return parametrizedResponseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getResourceResponse() {
    return resourceResponseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getResourceResponse_LearningResources() {
    return (EReference)resourceResponseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLearningResource() {
    return learningResourceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLearningResource_LearningItem() {
    return (EReference)learningResourceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLearningResource_ResourceResponses() {
    return (EReference)learningResourceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getLearningResource_Content() {
    return (EAttribute)learningResourceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLearningResource_LearningCorpus() {
    return (EReference)learningResourceEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getReference() {
    return referenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTutorial() {
    return tutorialEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getExample() {
    return exampleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getQuiz() {
    return quizEClass;
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
  public EClass getMistakeTypeCategory() {
    return mistakeTypeCategoryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistakeTypeCategory_MistakeTypes() {
    return (EReference)mistakeTypeCategoryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistakeTypeCategory_Supercategory() {
    return (EReference)mistakeTypeCategoryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistakeTypeCategory_Subcategories() {
    return (EReference)mistakeTypeCategoryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMistakeTypeCategory_LearningCorpus() {
    return (EReference)mistakeTypeCategoryEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLearningCorpus() {
    return learningCorpusEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLearningCorpus_MistakeTypeCategories() {
    return (EReference)learningCorpusEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLearningCorpus_Feedbacks() {
    return (EReference)learningCorpusEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLearningCorpus_LearningItems() {
    return (EReference)learningCorpusEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLearningCorpus_LearningResources() {
    return (EReference)learningCorpusEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMistakeElement() {
    return mistakeElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMistakeElement_Many() {
    return (EAttribute)mistakeElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMistakeElement_Type() {
    return (EAttribute)mistakeElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getElementType() {
    return elementTypeEEnum;
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
  public LearningcorpusFactory getLearningcorpusFactory() {
    return (LearningcorpusFactory)getEFactoryInstance();
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
    learningItemEClass = createEClass(LEARNING_ITEM);
    createEReference(learningItemEClass, LEARNING_ITEM__LEARNING_RESOURCES);
    createEReference(learningItemEClass, LEARNING_ITEM__MISTAKE_TYPES);
    createEAttribute(learningItemEClass, LEARNING_ITEM__DESCRIPTION);
    createEReference(learningItemEClass, LEARNING_ITEM__LEARNING_CORPUS);
    createEAttribute(learningItemEClass, LEARNING_ITEM__ELEMENT_TYPE);

    mistakeTypeEClass = createEClass(MISTAKE_TYPE);
    createEAttribute(mistakeTypeEClass, MISTAKE_TYPE__ATOMIC);
    createEAttribute(mistakeTypeEClass, MISTAKE_TYPE__TIME_TO_ADDRESS);
    createEAttribute(mistakeTypeEClass, MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION);
    createEReference(mistakeTypeEClass, MISTAKE_TYPE__LEARNING_ITEM);
    createEReference(mistakeTypeEClass, MISTAKE_TYPE__FEEDBACKS);
    createEReference(mistakeTypeEClass, MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY);
    createEAttribute(mistakeTypeEClass, MISTAKE_TYPE__PRIORITY);
    createEAttribute(mistakeTypeEClass, MISTAKE_TYPE__DESCRIPTION);
    createEReference(mistakeTypeEClass, MISTAKE_TYPE__STUDENT_ELEMENTS);
    createEReference(mistakeTypeEClass, MISTAKE_TYPE__INSTRUCTOR_ELEMENTS);

    feedbackEClass = createEClass(FEEDBACK);
    createEAttribute(feedbackEClass, FEEDBACK__LEVEL);
    createEAttribute(feedbackEClass, FEEDBACK__CONGRATULATORY);
    createEAttribute(feedbackEClass, FEEDBACK__USEFULNESS);
    createEAttribute(feedbackEClass, FEEDBACK__HIGHLIGHT_PROBLEM);
    createEAttribute(feedbackEClass, FEEDBACK__HIGHLIGHT_SOLUTION);
    createEReference(feedbackEClass, FEEDBACK__MISTAKE_TYPE);
    createEAttribute(feedbackEClass, FEEDBACK__TEXT);
    createEReference(feedbackEClass, FEEDBACK__LEARNING_CORPUS);

    textResponseEClass = createEClass(TEXT_RESPONSE);

    parametrizedResponseEClass = createEClass(PARAMETRIZED_RESPONSE);

    resourceResponseEClass = createEClass(RESOURCE_RESPONSE);
    createEReference(resourceResponseEClass, RESOURCE_RESPONSE__LEARNING_RESOURCES);

    learningResourceEClass = createEClass(LEARNING_RESOURCE);
    createEReference(learningResourceEClass, LEARNING_RESOURCE__LEARNING_ITEM);
    createEReference(learningResourceEClass, LEARNING_RESOURCE__RESOURCE_RESPONSES);
    createEAttribute(learningResourceEClass, LEARNING_RESOURCE__CONTENT);
    createEReference(learningResourceEClass, LEARNING_RESOURCE__LEARNING_CORPUS);

    referenceEClass = createEClass(REFERENCE);

    tutorialEClass = createEClass(TUTORIAL);

    exampleEClass = createEClass(EXAMPLE);

    quizEClass = createEClass(QUIZ);

    namedElementEClass = createEClass(NAMED_ELEMENT);
    createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

    mistakeTypeCategoryEClass = createEClass(MISTAKE_TYPE_CATEGORY);
    createEReference(mistakeTypeCategoryEClass, MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES);
    createEReference(mistakeTypeCategoryEClass, MISTAKE_TYPE_CATEGORY__SUPERCATEGORY);
    createEReference(mistakeTypeCategoryEClass, MISTAKE_TYPE_CATEGORY__SUBCATEGORIES);
    createEReference(mistakeTypeCategoryEClass, MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS);

    learningCorpusEClass = createEClass(LEARNING_CORPUS);
    createEReference(learningCorpusEClass, LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES);
    createEReference(learningCorpusEClass, LEARNING_CORPUS__FEEDBACKS);
    createEReference(learningCorpusEClass, LEARNING_CORPUS__LEARNING_ITEMS);
    createEReference(learningCorpusEClass, LEARNING_CORPUS__LEARNING_RESOURCES);

    mistakeElementEClass = createEClass(MISTAKE_ELEMENT);
    createEAttribute(mistakeElementEClass, MISTAKE_ELEMENT__MANY);
    createEAttribute(mistakeElementEClass, MISTAKE_ELEMENT__TYPE);

    // Create enums
    elementTypeEEnum = createEEnum(ELEMENT_TYPE);

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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    learningItemEClass.getESuperTypes().add(this.getNamedElement());
    mistakeTypeEClass.getESuperTypes().add(this.getNamedElement());
    textResponseEClass.getESuperTypes().add(this.getFeedback());
    parametrizedResponseEClass.getESuperTypes().add(this.getFeedback());
    resourceResponseEClass.getESuperTypes().add(this.getFeedback());
    learningResourceEClass.getESuperTypes().add(this.getNamedElement());
    referenceEClass.getESuperTypes().add(this.getLearningResource());
    tutorialEClass.getESuperTypes().add(this.getLearningResource());
    exampleEClass.getESuperTypes().add(this.getLearningResource());
    quizEClass.getESuperTypes().add(this.getLearningResource());
    mistakeTypeCategoryEClass.getESuperTypes().add(this.getNamedElement());
    mistakeElementEClass.getESuperTypes().add(this.getNamedElement());

    // Initialize classes, features, and operations; add parameters
    initEClass(learningItemEClass, LearningItem.class, "LearningItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLearningItem_LearningResources(), this.getLearningResource(), this.getLearningResource_LearningItem(), "learningResources", null, 0, -1, LearningItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLearningItem_MistakeTypes(), this.getMistakeType(), this.getMistakeType_LearningItem(), "mistakeTypes", null, 0, -1, LearningItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLearningItem_Description(), ecorePackage.getEString(), "description", null, 0, 1, LearningItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLearningItem_LearningCorpus(), this.getLearningCorpus(), this.getLearningCorpus_LearningItems(), "learningCorpus", null, 1, 1, LearningItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLearningItem_ElementType(), this.getElementType(), "elementType", null, 0, 1, LearningItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mistakeTypeEClass, MistakeType.class, "MistakeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMistakeType_Atomic(), ecorePackage.getEBoolean(), "atomic", null, 0, 1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistakeType_TimeToAddress(), this.getTime(), "timeToAddress", null, 0, 1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistakeType_NumStepsBeforeNotification(), ecorePackage.getEInt(), "numStepsBeforeNotification", null, 0, 1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistakeType_LearningItem(), this.getLearningItem(), this.getLearningItem_MistakeTypes(), "learningItem", null, 1, 1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistakeType_Feedbacks(), this.getFeedback(), this.getFeedback_MistakeType(), "feedbacks", null, 0, -1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistakeType_MistakeTypeCategory(), this.getMistakeTypeCategory(), this.getMistakeTypeCategory_MistakeTypes(), "mistakeTypeCategory", null, 1, 1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistakeType_Priority(), ecorePackage.getEInt(), "priority", null, 0, 1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistakeType_Description(), ecorePackage.getEString(), "description", null, 0, 1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistakeType_StudentElements(), this.getMistakeElement(), null, "studentElements", null, 0, -1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistakeType_InstructorElements(), this.getMistakeElement(), null, "instructorElements", null, 0, -1, MistakeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(feedbackEClass, Feedback.class, "Feedback", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFeedback_Level(), ecorePackage.getEInt(), "level", null, 0, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeedback_Congratulatory(), ecorePackage.getEBoolean(), "congratulatory", null, 0, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeedback_Usefulness(), ecorePackage.getEDouble(), "usefulness", null, 0, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeedback_HighlightProblem(), ecorePackage.getEBoolean(), "highlightProblem", null, 0, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeedback_HighlightSolution(), ecorePackage.getEBoolean(), "highlightSolution", null, 0, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeedback_MistakeType(), this.getMistakeType(), this.getMistakeType_Feedbacks(), "mistakeType", null, 0, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeedback_Text(), ecorePackage.getEString(), "text", null, 0, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeedback_LearningCorpus(), this.getLearningCorpus(), this.getLearningCorpus_Feedbacks(), "learningCorpus", null, 1, 1, Feedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(textResponseEClass, TextResponse.class, "TextResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(parametrizedResponseEClass, ParametrizedResponse.class, "ParametrizedResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(resourceResponseEClass, ResourceResponse.class, "ResourceResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResourceResponse_LearningResources(), this.getLearningResource(), this.getLearningResource_ResourceResponses(), "learningResources", null, 1, -1, ResourceResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(learningResourceEClass, LearningResource.class, "LearningResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLearningResource_LearningItem(), this.getLearningItem(), this.getLearningItem_LearningResources(), "learningItem", null, 1, 1, LearningResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLearningResource_ResourceResponses(), this.getResourceResponse(), this.getResourceResponse_LearningResources(), "resourceResponses", null, 0, -1, LearningResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLearningResource_Content(), ecorePackage.getEString(), "content", null, 0, 1, LearningResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLearningResource_LearningCorpus(), this.getLearningCorpus(), this.getLearningCorpus_LearningResources(), "learningCorpus", null, 1, 1, LearningResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tutorialEClass, Tutorial.class, "Tutorial", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(exampleEClass, Example.class, "Example", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(quizEClass, Quiz.class, "Quiz", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mistakeTypeCategoryEClass, MistakeTypeCategory.class, "MistakeTypeCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMistakeTypeCategory_MistakeTypes(), this.getMistakeType(), this.getMistakeType_MistakeTypeCategory(), "mistakeTypes", null, 0, -1, MistakeTypeCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistakeTypeCategory_Supercategory(), this.getMistakeTypeCategory(), this.getMistakeTypeCategory_Subcategories(), "supercategory", null, 0, 1, MistakeTypeCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistakeTypeCategory_Subcategories(), this.getMistakeTypeCategory(), this.getMistakeTypeCategory_Supercategory(), "subcategories", null, 0, -1, MistakeTypeCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMistakeTypeCategory_LearningCorpus(), this.getLearningCorpus(), this.getLearningCorpus_MistakeTypeCategories(), "learningCorpus", null, 1, 1, MistakeTypeCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(learningCorpusEClass, LearningCorpus.class, "LearningCorpus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLearningCorpus_MistakeTypeCategories(), this.getMistakeTypeCategory(), this.getMistakeTypeCategory_LearningCorpus(), "mistakeTypeCategories", null, 0, -1, LearningCorpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLearningCorpus_Feedbacks(), this.getFeedback(), this.getFeedback_LearningCorpus(), "feedbacks", null, 0, -1, LearningCorpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLearningCorpus_LearningItems(), this.getLearningItem(), this.getLearningItem_LearningCorpus(), "learningItems", null, 0, -1, LearningCorpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLearningCorpus_LearningResources(), this.getLearningResource(), this.getLearningResource_LearningCorpus(), "learningResources", null, 0, -1, LearningCorpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mistakeElementEClass, MistakeElement.class, "MistakeElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMistakeElement_Many(), ecorePackage.getEBoolean(), "many", null, 0, 1, MistakeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMistakeElement_Type(), ecorePackage.getEString(), "type", null, 0, 1, MistakeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(elementTypeEEnum, ElementType.class, "ElementType");
    addEEnumLiteral(elementTypeEEnum, ElementType.CLASS);
    addEEnumLiteral(elementTypeEEnum, ElementType.ATTRIBUTE);
    addEEnumLiteral(elementTypeEEnum, ElementType.ASSOCIATION);
    addEEnumLiteral(elementTypeEEnum, ElementType.ASSOCIATION_END);
    addEEnumLiteral(elementTypeEEnum, ElementType.AGGREGATION);
    addEEnumLiteral(elementTypeEEnum, ElementType.COMPOSITION);
    addEEnumLiteral(elementTypeEEnum, ElementType.GENERALIZATION);
    addEEnumLiteral(elementTypeEEnum, ElementType.PLAYER_ROLE_PATTERN);
    addEEnumLiteral(elementTypeEEnum, ElementType.ABSTRACTION_OCCURRENCE_PATTERN);

    // Initialize data types
    initEDataType(timeEDataType, Time.class, "Time", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //LearningcorpusPackageImpl
