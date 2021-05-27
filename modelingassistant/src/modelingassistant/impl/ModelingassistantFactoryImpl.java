/**
 */
package modelingassistant.impl;

import java.sql.Time;

import modelingassistant.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class ModelingassistantFactoryImpl extends EFactoryImpl implements ModelingassistantFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ModelingassistantFactory init() {
    try {
      ModelingassistantFactory theModelingassistantFactory = (ModelingassistantFactory)EPackage.Registry.INSTANCE.getEFactory(ModelingassistantPackage.eNS_URI);
      if (theModelingassistantFactory != null) {
        return theModelingassistantFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ModelingassistantFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingassistantFactoryImpl() {
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
      case ModelingassistantPackage.MODELING_ASSISTANT: return createModelingAssistant();
      case ModelingassistantPackage.STUDENT: return createStudent();
      case ModelingassistantPackage.PROBLEM_STATEMENT: return createProblemStatement();
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT: return createProblemStatementElement();
      case ModelingassistantPackage.UML_ELEMENT: return createUmlElement();
      case ModelingassistantPackage.SOLUTION: return createSolution();
      case ModelingassistantPackage.SOLUTION_ELEMENT: return createSolutionElement();
      case ModelingassistantPackage.LEARNING_ITEM: return createLearningItem();
      case ModelingassistantPackage.STUDENT_KNOWLEDGE: return createStudentKnowledge();
      case ModelingassistantPackage.MISTAKE_TYPE: return createMistakeType();
      case ModelingassistantPackage.MISTAKE: return createMistake();
      case ModelingassistantPackage.FEEDBACK: return createFeedback();
      case ModelingassistantPackage.TEXT_RESPONSE: return createTextResponse();
      case ModelingassistantPackage.PARAMETRIZED_RESPONSE: return createParametrizedResponse();
      case ModelingassistantPackage.RESOURCE_RESPONSE: return createResourceResponse();
      case ModelingassistantPackage.LEARNING_RESOURCE: return createLearningResource();
      case ModelingassistantPackage.REFERENCE: return createReference();
      case ModelingassistantPackage.TUTORIAL: return createTutorial();
      case ModelingassistantPackage.EXAMPLE: return createExample();
      case ModelingassistantPackage.QUIZ: return createQuiz();
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY: return createMistakeTypeCategory();
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
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
      case ModelingassistantPackage.TIME:
        return createTimeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
      case ModelingassistantPackage.TIME:
        return convertTimeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingAssistant createModelingAssistant() {
    ModelingAssistantImpl modelingAssistant = new ModelingAssistantImpl();
    return modelingAssistant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Student createStudent() {
    StudentImpl student = new StudentImpl();
    return student;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProblemStatement createProblemStatement() {
    ProblemStatementImpl problemStatement = new ProblemStatementImpl();
    return problemStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProblemStatementElement createProblemStatementElement() {
    ProblemStatementElementImpl problemStatementElement = new ProblemStatementElementImpl();
    return problemStatementElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlElement createUmlElement() {
    UmlElementImpl umlElement = new UmlElementImpl();
    return umlElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Solution createSolution() {
    SolutionImpl solution = new SolutionImpl();
    return solution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SolutionElement createSolutionElement() {
    SolutionElementImpl solutionElement = new SolutionElementImpl();
    return solutionElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningItem createLearningItem() {
    LearningItemImpl learningItem = new LearningItemImpl();
    return learningItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StudentKnowledge createStudentKnowledge() {
    StudentKnowledgeImpl studentKnowledge = new StudentKnowledgeImpl();
    return studentKnowledge;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeType createMistakeType() {
    MistakeTypeImpl mistakeType = new MistakeTypeImpl();
    return mistakeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mistake createMistake() {
    MistakeImpl mistake = new MistakeImpl();
    return mistake;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feedback createFeedback() {
    FeedbackImpl feedback = new FeedbackImpl();
    return feedback;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TextResponse createTextResponse() {
    TextResponseImpl textResponse = new TextResponseImpl();
    return textResponse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParametrizedResponse createParametrizedResponse() {
    ParametrizedResponseImpl parametrizedResponse = new ParametrizedResponseImpl();
    return parametrizedResponse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResourceResponse createResourceResponse() {
    ResourceResponseImpl resourceResponse = new ResourceResponseImpl();
    return resourceResponse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningResource createLearningResource() {
    LearningResourceImpl learningResource = new LearningResourceImpl();
    return learningResource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reference createReference() {
    ReferenceImpl reference = new ReferenceImpl();
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tutorial createTutorial() {
    TutorialImpl tutorial = new TutorialImpl();
    return tutorial;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Example createExample() {
    ExampleImpl example = new ExampleImpl();
    return example;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Quiz createQuiz() {
    QuizImpl quiz = new QuizImpl();
    return quiz;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeTypeCategory createMistakeTypeCategory() {
    MistakeTypeCategoryImpl mistakeTypeCategory = new MistakeTypeCategoryImpl();
    return mistakeTypeCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Time createTimeFromString(EDataType eDataType, String initialValue) {
    return (Time)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTimeToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingassistantPackage getModelingassistantPackage() {
    return (ModelingassistantPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ModelingassistantPackage getPackage() {
    return ModelingassistantPackage.eINSTANCE;
  }

} //ModelingassistantFactoryImpl
