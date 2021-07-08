/**
 */
package modelingassistant;

import learningcorpus.MistakeType;

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
 *   <li>{@link modelingassistant.StudentKnowledge#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.StudentKnowledge#getMistakeType <em>Mistake Type</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getStudentKnowledge()
 * @model
 * @generated
 */
public interface StudentKnowledge extends EObject {
  /**
   * Returns the value of the '<em><b>Level Of Knowledge</b></em>' attribute.
   * The default value is <code>"5.0"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Level Of Knowledge</em>' attribute.
   * @see #setLevelOfKnowledge(double)
   * @see modelingassistant.ModelingassistantPackage#getStudentKnowledge_LevelOfKnowledge()
   * @model default="5.0"
   * @generated
   */
  double getLevelOfKnowledge();

  /**
   * Sets the value of the '{@link modelingassistant.StudentKnowledge#getLevelOfKnowledge <em>Level Of Knowledge</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Level Of Knowledge</em>' attribute.
   * @see #getLevelOfKnowledge()
   * @generated
   */
  void setLevelOfKnowledge(double value);

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
   * Returns the value of the '<em><b>Modeling Assistant</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ModelingAssistant#getStudentKnowledges <em>Student Knowledges</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modeling Assistant</em>' container reference.
   * @see #setModelingAssistant(ModelingAssistant)
   * @see modelingassistant.ModelingassistantPackage#getStudentKnowledge_ModelingAssistant()
   * @see modelingassistant.ModelingAssistant#getStudentKnowledges
   * @model opposite="studentKnowledges" required="true" transient="false"
   * @generated
   */
  ModelingAssistant getModelingAssistant();

  /**
   * Sets the value of the '{@link modelingassistant.StudentKnowledge#getModelingAssistant <em>Modeling Assistant</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modeling Assistant</em>' container reference.
   * @see #getModelingAssistant()
   * @generated
   */
  void setModelingAssistant(ModelingAssistant value);

  /**
   * Returns the value of the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake Type</em>' reference.
   * @see #setMistakeType(MistakeType)
   * @see modelingassistant.ModelingassistantPackage#getStudentKnowledge_MistakeType()
   * @model
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

} // StudentKnowledge
