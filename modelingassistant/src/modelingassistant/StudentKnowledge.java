/**
 */
package modelingassistant;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Student Knowledge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.StudentKnowledge#getLevelOfKnowledge <em>Level Of Knowledge</em>}</li>
 *   <li>{@link modelingassistant.StudentKnowledge#getStudent <em>Student</em>}</li>
 *   <li>{@link modelingassistant.StudentKnowledge#getMistakeType <em>Mistake Type</em>}</li>
 *   <li>{@link modelingassistant.StudentKnowledge#getModelingassistant <em>Modelingassistant</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getStudentKnowledge()
 * @model
 * @generated
 */
public interface StudentKnowledge extends EObject {
  /**
   * Returns the value of the '<em><b>Level Of Knowledge</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Level Of Knowledge</em>' attribute.
   * @see #setLevelOfKnowledge(int)
   * @see modelingassistant.ModelingassistantPackage#getStudentKnowledge_LevelOfKnowledge()
   * @model dataType="modelingassistant.int"
   * @generated
   */
  int getLevelOfKnowledge();

  /**
   * Sets the value of the '{@link modelingassistant.StudentKnowledge#getLevelOfKnowledge <em>Level Of Knowledge</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Level Of Knowledge</em>' attribute.
   * @see #getLevelOfKnowledge()
   * @generated
   */
  void setLevelOfKnowledge(int value);

  /**
   * Returns the value of the '<em><b>Student</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Student#getStudentKnowledges <em>Student Knowledges</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Student</em>' reference.
   * @see #setStudent(Student)
   * @see modelingassistant.ModelingassistantPackage#getStudentKnowledge_Student()
   * @see modelingassistant.Student#getStudentKnowledges
   * @model opposite="studentKnowledges" required="true"
   * @generated
   */
  Student getStudent();

  /**
   * Sets the value of the '{@link modelingassistant.StudentKnowledge#getStudent <em>Student</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Student</em>' reference.
   * @see #getStudent()
   * @generated
   */
  void setStudent(Student value);

  /**
   * Returns the value of the '<em><b>Mistake Type</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.MistakeType#getStudentKnowledges <em>Student Knowledges</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake Type</em>' reference.
   * @see #setMistakeType(MistakeType)
   * @see modelingassistant.ModelingassistantPackage#getStudentKnowledge_MistakeType()
   * @see modelingassistant.MistakeType#getStudentKnowledges
   * @model opposite="studentKnowledges" required="true"
   * @generated
   */
  MistakeType getMistakeType();

  /**
   * Sets the value of the '{@link modelingassistant.StudentKnowledge#getMistakeType <em>Mistake Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mistake Type</em>' reference.
   * @see #getMistakeType()
   * @generated
   */
  void setMistakeType(MistakeType value);

  /**
   * Returns the value of the '<em><b>Modelingassistant</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ModelingAssistant#getStudentknowledge <em>Studentknowledge</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modelingassistant</em>' container reference.
   * @see #setModelingassistant(ModelingAssistant)
   * @see modelingassistant.ModelingassistantPackage#getStudentKnowledge_Modelingassistant()
   * @see modelingassistant.ModelingAssistant#getStudentknowledge
   * @model opposite="studentknowledge" required="true" transient="false"
   * @generated
   */
  ModelingAssistant getModelingassistant();

  /**
   * Sets the value of the '{@link modelingassistant.StudentKnowledge#getModelingassistant <em>Modelingassistant</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modelingassistant</em>' container reference.
   * @see #getModelingassistant()
   * @generated
   */
  void setModelingassistant(ModelingAssistant value);

} // StudentKnowledge
