/**
 */
package modelingassistant;

import java.sql.Time;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mistake</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.Mistake#isResolved <em>Resolved</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getTimeToAddress <em>Time To Address</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getNumStepsBeforeNotification <em>Num Steps Before Notification</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getMistakeStudent <em>Mistake Student</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getCurrentMistakeStudent <em>Current Mistake Student</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getSolutionElements <em>Solution Elements</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getMistakeType <em>Mistake Type</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getLastFeedback <em>Last Feedback</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getMistake()
 * @model
 * @generated
 */
public interface Mistake extends EObject {
  /**
   * Returns the value of the '<em><b>Resolved</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Resolved</em>' attribute.
   * @see #setResolved(boolean)
   * @see modelingassistant.ModelingassistantPackage#getMistake_Resolved()
   * @model dataType="modelingassistant.boolean"
   * @generated
   */
  boolean isResolved();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#isResolved <em>Resolved</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Resolved</em>' attribute.
   * @see #isResolved()
   * @generated
   */
  void setResolved(boolean value);

  /**
   * Returns the value of the '<em><b>Time To Address</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time To Address</em>' attribute.
   * @see #setTimeToAddress(Time)
   * @see modelingassistant.ModelingassistantPackage#getMistake_TimeToAddress()
   * @model dataType="modelingassistant.Time"
   * @generated
   */
  Time getTimeToAddress();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getTimeToAddress <em>Time To Address</em>}' attribute.
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
   * @see modelingassistant.ModelingassistantPackage#getMistake_NumStepsBeforeNotification()
   * @model dataType="modelingassistant.int"
   * @generated
   */
  int getNumStepsBeforeNotification();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getNumStepsBeforeNotification <em>Num Steps Before Notification</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Num Steps Before Notification</em>' attribute.
   * @see #getNumStepsBeforeNotification()
   * @generated
   */
  void setNumStepsBeforeNotification(int value);

  /**
   * Returns the value of the '<em><b>Modeling Assistant</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ModelingAssistant#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modeling Assistant</em>' container reference.
   * @see #setModelingAssistant(ModelingAssistant)
   * @see modelingassistant.ModelingassistantPackage#getMistake_ModelingAssistant()
   * @see modelingassistant.ModelingAssistant#getMistakes
   * @model opposite="mistakes" required="true" transient="false"
   * @generated
   */
  ModelingAssistant getModelingAssistant();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getModelingAssistant <em>Modeling Assistant</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modeling Assistant</em>' container reference.
   * @see #getModelingAssistant()
   * @generated
   */
  void setModelingAssistant(ModelingAssistant value);

  /**
   * Returns the value of the '<em><b>Mistake Student</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Student#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake Student</em>' reference.
   * @see #setMistakeStudent(Student)
   * @see modelingassistant.ModelingassistantPackage#getMistake_MistakeStudent()
   * @see modelingassistant.Student#getMistakes
   * @model opposite="mistakes" required="true"
   * @generated
   */
  Student getMistakeStudent();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getMistakeStudent <em>Mistake Student</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mistake Student</em>' reference.
   * @see #getMistakeStudent()
   * @generated
   */
  void setMistakeStudent(Student value);

  /**
   * Returns the value of the '<em><b>Current Mistake Student</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Student#getCurrentMistake <em>Current Mistake</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Current Mistake Student</em>' reference.
   * @see #setCurrentMistakeStudent(Student)
   * @see modelingassistant.ModelingassistantPackage#getMistake_CurrentMistakeStudent()
   * @see modelingassistant.Student#getCurrentMistake
   * @model opposite="currentMistake" required="true"
   * @generated
   */
  Student getCurrentMistakeStudent();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getCurrentMistakeStudent <em>Current Mistake Student</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Current Mistake Student</em>' reference.
   * @see #getCurrentMistakeStudent()
   * @generated
   */
  void setCurrentMistakeStudent(Student value);

  /**
   * Returns the value of the '<em><b>Solution Elements</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.SolutionElement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.SolutionElement#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution Elements</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getMistake_SolutionElements()
   * @see modelingassistant.SolutionElement#getMistakes
   * @model opposite="mistakes"
   * @generated
   */
  EList<SolutionElement> getSolutionElements();

  /**
   * Returns the value of the '<em><b>Mistake Type</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.MistakeType#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake Type</em>' reference.
   * @see #setMistakeType(MistakeType)
   * @see modelingassistant.ModelingassistantPackage#getMistake_MistakeType()
   * @see modelingassistant.MistakeType#getMistakes
   * @model opposite="mistakes" required="true"
   * @generated
   */
  MistakeType getMistakeType();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getMistakeType <em>Mistake Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mistake Type</em>' reference.
   * @see #getMistakeType()
   * @generated
   */
  void setMistakeType(MistakeType value);

  /**
   * Returns the value of the '<em><b>Last Feedback</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Feedback#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Last Feedback</em>' reference.
   * @see #setLastFeedback(Feedback)
   * @see modelingassistant.ModelingassistantPackage#getMistake_LastFeedback()
   * @see modelingassistant.Feedback#getMistakes
   * @model opposite="mistakes"
   * @generated
   */
  Feedback getLastFeedback();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getLastFeedback <em>Last Feedback</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Last Feedback</em>' reference.
   * @see #getLastFeedback()
   * @generated
   */
  void setLastFeedback(Feedback value);

} // Mistake
