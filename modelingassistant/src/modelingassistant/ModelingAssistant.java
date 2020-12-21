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
 *   <li>{@link modelingassistant.ModelingAssistant#getLearningItems <em>Learning Items</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getLearningResources <em>Learning Resources</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getProblemStatements <em>Problem Statements</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getUmlElements <em>Uml Elements</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getStudents <em>Students</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getFeedbacks <em>Feedbacks</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getMistakes <em>Mistakes</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getMistakeTypes <em>Mistake Types</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getModelingAssistant()
 * @model
 * @generated
 */
public interface ModelingAssistant extends EObject {
  /**
   * Returns the value of the '<em><b>Learning Items</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.LearningItem}.
   * It is bidirectional and its opposite is '{@link modelingassistant.LearningItem#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Items</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_LearningItems()
   * @see modelingassistant.LearningItem#getModelingAssistant
   * @model opposite="modelingAssistant"
   * @generated
   */
  EList<LearningItem> getLearningItems();

  /**
   * Returns the value of the '<em><b>Learning Resources</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.LearningResource}.
   * It is bidirectional and its opposite is '{@link modelingassistant.LearningResource#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Resources</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_LearningResources()
   * @see modelingassistant.LearningResource#getModelingAssistant
   * @model opposite="modelingAssistant"
   * @generated
   */
  EList<LearningResource> getLearningResources();

  /**
   * Returns the value of the '<em><b>Problem Statements</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.ProblemStatement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.ProblemStatement#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Problem Statements</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_ProblemStatements()
   * @see modelingassistant.ProblemStatement#getModelingAssistant
   * @model opposite="modelingAssistant"
   * @generated
   */
  EList<ProblemStatement> getProblemStatements();

  /**
   * Returns the value of the '<em><b>Solutions</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Solution}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Solution#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solutions</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_Solutions()
   * @see modelingassistant.Solution#getModelingAssistant
   * @model opposite="modelingAssistant"
   * @generated
   */
  EList<Solution> getSolutions();

  /**
   * Returns the value of the '<em><b>Uml Elements</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.UmlElement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.UmlElement#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uml Elements</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_UmlElements()
   * @see modelingassistant.UmlElement#getModelingAssistant
   * @model opposite="modelingAssistant"
   * @generated
   */
  EList<UmlElement> getUmlElements();

  /**
   * Returns the value of the '<em><b>Students</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Student}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Student#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Students</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_Students()
   * @see modelingassistant.Student#getModelingAssistant
   * @model opposite="modelingAssistant"
   * @generated
   */
  EList<Student> getStudents();

  /**
   * Returns the value of the '<em><b>Feedbacks</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Feedback}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Feedback#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feedbacks</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_Feedbacks()
   * @see modelingassistant.Feedback#getModelingAssistant
   * @model opposite="modelingAssistant"
   * @generated
   */
  EList<Feedback> getFeedbacks();

  /**
   * Returns the value of the '<em><b>Mistakes</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Mistake}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Mistake#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistakes</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_Mistakes()
   * @see modelingassistant.Mistake#getModelingAssistant
   * @model opposite="modelingAssistant"
   * @generated
   */
  EList<Mistake> getMistakes();

  /**
   * Returns the value of the '<em><b>Mistake Types</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.MistakeType}.
   * It is bidirectional and its opposite is '{@link modelingassistant.MistakeType#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake Types</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_MistakeTypes()
   * @see modelingassistant.MistakeType#getModelingAssistant
   * @model opposite="modelingAssistant"
   * @generated
   */
  EList<MistakeType> getMistakeTypes();

} // ModelingAssistant
