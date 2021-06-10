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
      case ModelingassistantPackage.SOLUTION: return createSolution();
      case ModelingassistantPackage.SOLUTION_ELEMENT: return createSolutionElement();
      case ModelingassistantPackage.STUDENT_KNOWLEDGE: return createStudentKnowledge();
      case ModelingassistantPackage.MISTAKE: return createMistake();
      case ModelingassistantPackage.FEEDBACK_ITEM: return createFeedbackItem();
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
  @Override
  public ModelingAssistant createModelingAssistant() {
    ModelingAssistantImpl modelingAssistant = new ModelingAssistantImpl();
    return modelingAssistant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Student createStudent() {
    StudentImpl student = new StudentImpl();
    return student;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ProblemStatement createProblemStatement() {
    ProblemStatementImpl problemStatement = new ProblemStatementImpl();
    return problemStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ProblemStatementElement createProblemStatementElement() {
    ProblemStatementElementImpl problemStatementElement = new ProblemStatementElementImpl();
    return problemStatementElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Solution createSolution() {
    SolutionImpl solution = new SolutionImpl();
    return solution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SolutionElement createSolutionElement() {
    SolutionElementImpl solutionElement = new SolutionElementImpl();
    return solutionElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StudentKnowledge createStudentKnowledge() {
    StudentKnowledgeImpl studentKnowledge = new StudentKnowledgeImpl();
    return studentKnowledge;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Mistake createMistake() {
    MistakeImpl mistake = new MistakeImpl();
    return mistake;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FeedbackItem createFeedbackItem() {
    FeedbackItemImpl feedbackItem = new FeedbackItemImpl();
    return feedbackItem;
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
