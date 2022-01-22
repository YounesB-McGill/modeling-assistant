/**
 */
package learningcorpusquiz.impl;

import ca.mcgill.sel.classdiagram.CdmPackage;

import ca.mcgill.sel.core.CorePackage;

import learningcorpus.LearningcorpusPackage;

import learningcorpus.impl.LearningcorpusPackageImpl;

import learningcorpusquiz.FillInTheBlanksQuiz;
import learningcorpusquiz.LearningcorpusquizFactory;
import learningcorpusquiz.LearningcorpusquizPackage;

import modelingassistant.ModelingassistantPackage;

import modelingassistant.impl.ModelingassistantPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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

    // Initialize classes, features, and operations; add parameters
    initEClass(fillInTheBlanksQuizEClass, FillInTheBlanksQuiz.class, "FillInTheBlanksQuiz", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //LearningcorpusquizPackageImpl
