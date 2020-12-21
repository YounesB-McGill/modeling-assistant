/**
 */
package modelingassistant;

import java.sql.Time;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mistake Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.MistakeType#getName <em>Name</em>}</li>
 *   <li>{@link modelingassistant.MistakeType#isAtomic <em>Atomic</em>}</li>
 *   <li>{@link modelingassistant.MistakeType#getTimeToAddress <em>Time To Address</em>}</li>
 *   <li>{@link modelingassistant.MistakeType#getNumStepsBeforeNotification <em>Num Steps Before Notification</em>}</li>
 *   <li>{@link modelingassistant.MistakeType#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.MistakeType#getLearningItem <em>Learning Item</em>}</li>
 *   <li>{@link modelingassistant.MistakeType#getStudentKnowledges <em>Student Knowledges</em>}</li>
 *   <li>{@link modelingassistant.MistakeType#getMistakes <em>Mistakes</em>}</li>
 *   <li>{@link modelingassistant.MistakeType#getFeedbacks <em>Feedbacks</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getMistakeType()
 * @model
 * @generated
 */
public interface MistakeType extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see modelingassistant.ModelingassistantPackage#getMistakeType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link modelingassistant.MistakeType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Atomic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Atomic</em>' attribute.
   * @see #setAtomic(boolean)
   * @see modelingassistant.ModelingassistantPackage#getMistakeType_Atomic()
   * @model dataType="modelingassistant.boolean"
   * @generated
   */
  boolean isAtomic();

  /**
   * Sets the value of the '{@link modelingassistant.MistakeType#isAtomic <em>Atomic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Atomic</em>' attribute.
   * @see #isAtomic()
   * @generated
   */
  void setAtomic(boolean value);

  /**
   * Returns the value of the '<em><b>Time To Address</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time To Address</em>' attribute.
   * @see #setTimeToAddress(Time)
   * @see modelingassistant.ModelingassistantPackage#getMistakeType_TimeToAddress()
   * @model dataType="modelingassistant.Time"
   * @generated
   */
  Time getTimeToAddress();

  /**
   * Sets the value of the '{@link modelingassistant.MistakeType#getTimeToAddress <em>Time To Address</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time To Address</em>' attribute.
   * @see #getTimeToAddress()
   * @generated
   */
  void setTimeToAddress(Time value);

  /**
   * Returns the value of the '<em><b>Num Steps Before Notification</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num Steps Before Notification</em>' attribute.
   * @see #setNumStepsBeforeNotification(int)
   * @see modelingassistant.ModelingassistantPackage#getMistakeType_NumStepsBeforeNotification()
   * @model dataType="modelingassistant.int"
   * @generated
   */
  int getNumStepsBeforeNotification();

  /**
   * Sets the value of the '{@link modelingassistant.MistakeType#getNumStepsBeforeNotification <em>Num Steps Before Notification</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Num Steps Before Notification</em>' attribute.
   * @see #getNumStepsBeforeNotification()
   * @generated
   */
  void setNumStepsBeforeNotification(int value);

  /**
   * Returns the value of the '<em><b>Modeling Assistant</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ModelingAssistant#getMistakeTypes <em>Mistake Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modeling Assistant</em>' reference.
   * @see #setModelingAssistant(ModelingAssistant)
   * @see modelingassistant.ModelingassistantPackage#getMistakeType_ModelingAssistant()
   * @see modelingassistant.ModelingAssistant#getMistakeTypes
   * @model opposite="mistakeTypes" required="true"
   * @generated
   */
  ModelingAssistant getModelingAssistant();

  /**
   * Sets the value of the '{@link modelingassistant.MistakeType#getModelingAssistant <em>Modeling Assistant</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modeling Assistant</em>' reference.
   * @see #getModelingAssistant()
   * @generated
   */
  void setModelingAssistant(ModelingAssistant value);

  /**
   * Returns the value of the '<em><b>Learning Item</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.LearningItem#getMistakeTypes <em>Mistake Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Item</em>' reference.
   * @see #setLearningItem(LearningItem)
   * @see modelingassistant.ModelingassistantPackage#getMistakeType_LearningItem()
   * @see modelingassistant.LearningItem#getMistakeTypes
   * @model opposite="mistakeTypes" required="true"
   * @generated
   */
  LearningItem getLearningItem();

  /**
   * Sets the value of the '{@link modelingassistant.MistakeType#getLearningItem <em>Learning Item</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Learning Item</em>' reference.
   * @see #getLearningItem()
   * @generated
   */
  void setLearningItem(LearningItem value);

  /**
   * Returns the value of the '<em><b>Student Knowledges</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.StudentKnowledge}.
   * It is bidirectional and its opposite is '{@link modelingassistant.StudentKnowledge#getMistakeType <em>Mistake Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Student Knowledges</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getMistakeType_StudentKnowledges()
   * @see modelingassistant.StudentKnowledge#getMistakeType
   * @model opposite="mistakeType"
   * @generated
   */
  EList<StudentKnowledge> getStudentKnowledges();

  /**
   * Returns the value of the '<em><b>Mistakes</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Mistake}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Mistake#getMistakeType <em>Mistake Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistakes</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getMistakeType_Mistakes()
   * @see modelingassistant.Mistake#getMistakeType
   * @model opposite="mistakeType"
   * @generated
   */
  EList<Mistake> getMistakes();

  /**
   * Returns the value of the '<em><b>Feedbacks</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Feedback}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Feedback#getMistakeType <em>Mistake Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feedbacks</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getMistakeType_Feedbacks()
   * @see modelingassistant.Feedback#getMistakeType
   * @model opposite="mistakeType"
   * @generated
   */
  EList<Feedback> getFeedbacks();

} // MistakeType
