/**
 */
package modelingassistant;

import org.eclipse.emf.ecore.EFactory;
import learningcorpus.MistakeType;

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
   * Returns a new object of class '<em>Student Knowledge</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Student Knowledge</em>'.
   * @generated
   */
  StudentKnowledge createStudentKnowledge();

  /**
   * Returns a new object of class '<em>Mistake</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mistake</em>'.
   * @generated
   */
  Mistake createMistake();

  /**
   * Creates a mistake of the given type.
   *
   * @generated NOT
   */
  default Mistake createMistakeOfType(MistakeType mistakeType) {
    var mistake = createMistake();
    mistake.setMistakeType(mistakeType);
    return mistake;
  }

  /**
   * Returns a new object of class '<em>Feedback Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feedback Item</em>'.
   * @generated
   */
  FeedbackItem createFeedbackItem();

  /**
   * Returns a new object of class '<em>Tag</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tag</em>'.
   * @generated
   */
  Tag createTag();

  /**
   * Returns a new object of class '<em>Tag Group</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tag Group</em>'.
   * @generated
   */
  TagGroup createTagGroup();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ModelingassistantPackage getModelingassistantPackage();

} //ModelingassistantFactory
