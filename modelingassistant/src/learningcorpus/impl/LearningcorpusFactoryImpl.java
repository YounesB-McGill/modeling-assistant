/**
 */
package learningcorpus.impl;

import java.sql.Time;

import learningcorpus.*;

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
public class LearningcorpusFactoryImpl extends EFactoryImpl implements LearningcorpusFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LearningcorpusFactory init() {
    try {
      LearningcorpusFactory theLearningcorpusFactory = (LearningcorpusFactory)EPackage.Registry.INSTANCE.getEFactory(LearningcorpusPackage.eNS_URI);
      if (theLearningcorpusFactory != null) {
        return theLearningcorpusFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LearningcorpusFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningcorpusFactoryImpl() {
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
      case LearningcorpusPackage.LEARNING_ITEM: return createLearningItem();
      case LearningcorpusPackage.MISTAKE_TYPE: return createMistakeType();
      case LearningcorpusPackage.FEEDBACK: return createFeedback();
      case LearningcorpusPackage.TEXT_RESPONSE: return createTextResponse();
      case LearningcorpusPackage.PARAMETRIZED_RESPONSE: return createParametrizedResponse();
      case LearningcorpusPackage.RESOURCE_RESPONSE: return createResourceResponse();
      case LearningcorpusPackage.LEARNING_RESOURCE: return createLearningResource();
      case LearningcorpusPackage.REFERENCE: return createReference();
      case LearningcorpusPackage.TUTORIAL: return createTutorial();
      case LearningcorpusPackage.EXAMPLE: return createExample();
      case LearningcorpusPackage.QUIZ: return createQuiz();
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY: return createMistakeTypeCategory();
      case LearningcorpusPackage.LEARNING_CORPUS: return createLearningCorpus();
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
      case LearningcorpusPackage.ELEMENT_TYPE:
        return createElementTypeFromString(eDataType, initialValue);
      case LearningcorpusPackage.TIME:
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
      case LearningcorpusPackage.ELEMENT_TYPE:
        return convertElementTypeToString(eDataType, instanceValue);
      case LearningcorpusPackage.TIME:
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
  @Override
  public LearningItem createLearningItem() {
    LearningItemImpl learningItem = new LearningItemImpl();
    return learningItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MistakeType createMistakeType() {
    MistakeTypeImpl mistakeType = new MistakeTypeImpl();
    return mistakeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Feedback createFeedback() {
    FeedbackImpl feedback = new FeedbackImpl();
    return feedback;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TextResponse createTextResponse() {
    TextResponseImpl textResponse = new TextResponseImpl();
    return textResponse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ParametrizedResponse createParametrizedResponse() {
    ParametrizedResponseImpl parametrizedResponse = new ParametrizedResponseImpl();
    return parametrizedResponse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceResponse createResourceResponse() {
    ResourceResponseImpl resourceResponse = new ResourceResponseImpl();
    return resourceResponse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LearningResource createLearningResource() {
    LearningResourceImpl learningResource = new LearningResourceImpl();
    return learningResource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Reference createReference() {
    ReferenceImpl reference = new ReferenceImpl();
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Tutorial createTutorial() {
    TutorialImpl tutorial = new TutorialImpl();
    return tutorial;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Example createExample() {
    ExampleImpl example = new ExampleImpl();
    return example;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Quiz createQuiz() {
    QuizImpl quiz = new QuizImpl();
    return quiz;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MistakeTypeCategory createMistakeTypeCategory() {
    MistakeTypeCategoryImpl mistakeTypeCategory = new MistakeTypeCategoryImpl();
    return mistakeTypeCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LearningCorpus createLearningCorpus() {
    LearningCorpusImpl learningCorpus = new LearningCorpusImpl();
    return learningCorpus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementType createElementTypeFromString(EDataType eDataType, String initialValue) {
    ElementType result = ElementType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertElementTypeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
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
  @Override
  public LearningcorpusPackage getLearningcorpusPackage() {
    return (LearningcorpusPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LearningcorpusPackage getPackage() {
    return LearningcorpusPackage.eINSTANCE;
  }

} //LearningcorpusFactoryImpl
