/**
 */
package modelingassistant;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see modelingassistant.ModelingassistantPackage
 * @generated
 */
public interface ModelingassistantFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ModelingassistantFactory eINSTANCE = modelingassistant.impl.ModelingassistantFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Modeling Assistant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Modeling Assistant</em>'.
   * @generated
   */
  ModelingAssistant createModelingAssistant();

  /**
   * Returns a new object of class '<em>Student</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Student</em>'.
   * @generated
   */
  Student createStudent();

  /**
   * Returns a new object of class '<em>Problem Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Problem Statement</em>'.
   * @generated
   */
  ProblemStatement createProblemStatement();

  /**
   * Returns a new object of class '<em>Problem Statement Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Problem Statement Element</em>'.
   * @generated
   */
  ProblemStatementElement createProblemStatementElement();

  /**
   * Returns a new object of class '<em>Uml Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Uml Element</em>'.
   * @generated
   */
  UmlElement createUmlElement();

  /**
   * Returns a new object of class '<em>Solution</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Solution</em>'.
   * @generated
   */
  Solution createSolution();

  /**
   * Returns a new object of class '<em>Solution Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Solution Element</em>'.
   * @generated
   */
  SolutionElement createSolutionElement();

  /**
   * Returns a new object of class '<em>Learning Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Learning Item</em>'.
   * @generated
   */
  LearningItem createLearningItem();

  /**
   * Returns a new object of class '<em>Student Knowledge</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Student Knowledge</em>'.
   * @generated
   */
  StudentKnowledge createStudentKnowledge();

  /**
   * Returns a new object of class '<em>Mistake Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mistake Type</em>'.
   * @generated
   */
  MistakeType createMistakeType();

  /**
   * Returns a new object of class '<em>Mistake</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mistake</em>'.
   * @generated
   */
  Mistake createMistake();

  /**
   * Returns a new object of class '<em>Feedback</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feedback</em>'.
   * @generated
   */
  Feedback createFeedback();

  /**
   * Returns a new object of class '<em>Text Response</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Text Response</em>'.
   * @generated
   */
  TextResponse createTextResponse();

  /**
   * Returns a new object of class '<em>Parametrized Response</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parametrized Response</em>'.
   * @generated
   */
  ParametrizedResponse createParametrizedResponse();

  /**
   * Returns a new object of class '<em>Resource Response</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Resource Response</em>'.
   * @generated
   */
  ResourceResponse createResourceResponse();

  /**
   * Returns a new object of class '<em>Learning Resource</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Learning Resource</em>'.
   * @generated
   */
  LearningResource createLearningResource();

  /**
   * Returns a new object of class '<em>Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference</em>'.
   * @generated
   */
  Reference createReference();

  /**
   * Returns a new object of class '<em>Tutorial</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tutorial</em>'.
   * @generated
   */
  Tutorial createTutorial();

  /**
   * Returns a new object of class '<em>Example</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Example</em>'.
   * @generated
   */
  Example createExample();

  /**
   * Returns a new object of class '<em>Quiz</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Quiz</em>'.
   * @generated
   */
  Quiz createQuiz();

  /**
   * Returns a new object of class '<em>Mistake Type Category</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mistake Type Category</em>'.
   * @generated
   */
  MistakeTypeCategory createMistakeTypeCategory();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ModelingassistantPackage getModelingassistantPackage();

} //ModelingassistantFactory
