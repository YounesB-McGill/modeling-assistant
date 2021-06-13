/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Student</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.Student#getId <em>Id</em>}</li>
 *   <li>{@link modelingassistant.Student#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.Student#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link modelingassistant.Student#getStudentKnowledges <em>Student Knowledges</em>}</li>
 *   <li>{@link modelingassistant.Student#getCurrentSolution <em>Current Solution</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getStudent()
 * @model
 * @generated
 */
public interface Student extends NamedElement {
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see modelingassistant.ModelingassistantPackage#getStudent_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link modelingassistant.Student#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Modeling Assistant</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ModelingAssistant#getStudents <em>Students</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modeling Assistant</em>' container reference.
   * @see #setModelingAssistant(ModelingAssistant)
   * @see modelingassistant.ModelingassistantPackage#getStudent_ModelingAssistant()
   * @see modelingassistant.ModelingAssistant#getStudents
   * @model opposite="students" required="true" transient="false"
   * @generated
   */
  ModelingAssistant getModelingAssistant();

  /**
   * Sets the value of the '{@link modelingassistant.Student#getModelingAssistant <em>Modeling Assistant</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modeling Assistant</em>' container reference.
   * @see #getModelingAssistant()
   * @generated
   */
  void setModelingAssistant(ModelingAssistant value);

  /**
   * Returns the value of the '<em><b>Solutions</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Solution}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Solution#getStudent <em>Student</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solutions</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getStudent_Solutions()
   * @see modelingassistant.Solution#getStudent
   * @model opposite="student"
   * @generated
   */
  EList<Solution> getSolutions();

  /**
   * Returns the value of the '<em><b>Student Knowledges</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.StudentKnowledge}.
   * It is bidirectional and its opposite is '{@link modelingassistant.StudentKnowledge#getStudent <em>Student</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Student Knowledges</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getStudent_StudentKnowledges()
   * @see modelingassistant.StudentKnowledge#getStudent
   * @model opposite="student"
   * @generated
   */
  EList<StudentKnowledge> getStudentKnowledges();

  /**
   * Returns the value of the '<em><b>Current Solution</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Current Solution</em>' reference.
   * @see #setCurrentSolution(Solution)
   * @see modelingassistant.ModelingassistantPackage#getStudent_CurrentSolution()
   * @model
   * @generated
   */
  Solution getCurrentSolution();

  /**
   * Sets the value of the '{@link modelingassistant.Student#getCurrentSolution <em>Current Solution</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Current Solution</em>' reference.
   * @see #getCurrentSolution()
   * @generated
   */
  void setCurrentSolution(Solution value);

} // Student
