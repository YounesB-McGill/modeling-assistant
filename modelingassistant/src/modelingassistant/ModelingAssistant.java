/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modeling Assistant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.ModelingAssistant#getProblemStatements <em>Problem Statements</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getStudents <em>Students</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getStudentKnowledges <em>Student Knowledges</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getFeedbackItems <em>Feedback Items</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getModelingAssistant()
 * @model
 * @generated
 */
public interface ModelingAssistant extends EObject {
  /**
   * Returns the value of the '<em><b>Problem Statements</b></em>' containment reference list.
   * The list contents are of type {@link modelingassistant.ProblemStatement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.ProblemStatement#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Problem Statements</em>' containment reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_ProblemStatements()
   * @see modelingassistant.ProblemStatement#getModelingAssistant
   * @model opposite="modelingAssistant" containment="true"
   * @generated
   */
  EList<ProblemStatement> getProblemStatements();

  /**
   * Returns the value of the '<em><b>Solutions</b></em>' containment reference list.
   * The list contents are of type {@link modelingassistant.Solution}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Solution#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solutions</em>' containment reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_Solutions()
   * @see modelingassistant.Solution#getModelingAssistant
   * @model opposite="modelingAssistant" containment="true"
   * @generated
   */
  EList<Solution> getSolutions();

  /**
   * Returns the value of the '<em><b>Students</b></em>' containment reference list.
   * The list contents are of type {@link modelingassistant.Student}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Student#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Students</em>' containment reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_Students()
   * @see modelingassistant.Student#getModelingAssistant
   * @model opposite="modelingAssistant" containment="true"
   * @generated
   */
  EList<Student> getStudents();

  /**
   * Returns the value of the '<em><b>Student Knowledges</b></em>' containment reference list.
   * The list contents are of type {@link modelingassistant.StudentKnowledge}.
   * It is bidirectional and its opposite is '{@link modelingassistant.StudentKnowledge#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Student Knowledges</em>' containment reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_StudentKnowledges()
   * @see modelingassistant.StudentKnowledge#getModelingAssistant
   * @model opposite="modelingAssistant" containment="true"
   * @generated
   */
  EList<StudentKnowledge> getStudentKnowledges();

  /**
   * Returns the value of the '<em><b>Feedback Items</b></em>' containment reference list.
   * The list contents are of type {@link modelingassistant.FeedbackItem}.
   * It is bidirectional and its opposite is '{@link modelingassistant.FeedbackItem#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feedback Items</em>' containment reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_FeedbackItems()
   * @see modelingassistant.FeedbackItem#getModelingAssistant
   * @model opposite="modelingAssistant" containment="true"
   * @generated
   */
  EList<FeedbackItem> getFeedbackItems();

} // ModelingAssistant
