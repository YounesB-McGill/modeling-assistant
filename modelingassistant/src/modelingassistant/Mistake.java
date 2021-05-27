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
 *   <li>{@link modelingassistant.Mistake#getStudentElements <em>Student Elements</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getMistakeType <em>Mistake Type</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getLastFeedback <em>Last Feedback</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getInstructorElements <em>Instructor Elements</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getStudentSolution <em>Student Solution</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getNumDetection <em>Num Detection</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getNumDetectionSinceResolved <em>Num Detection Since Resolved</em>}</li>
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
   * @model
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
   * @model
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
   * Returns the value of the '<em><b>Student Elements</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.SolutionElement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.SolutionElement#getStudentElementMistakes <em>Student Element Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Student Elements</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getMistake_StudentElements()
   * @see modelingassistant.SolutionElement#getStudentElementMistakes
   * @model opposite="studentElementMistakes"
   * @generated
   */
  EList<SolutionElement> getStudentElements();

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

  /**
   * Returns the value of the '<em><b>Instructor Elements</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.SolutionElement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.SolutionElement#getInstructorElementMistakes <em>Instructor Element Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instructor Elements</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getMistake_InstructorElements()
   * @see modelingassistant.SolutionElement#getInstructorElementMistakes
   * @model opposite="instructorElementMistakes"
   * @generated
   */
  EList<SolutionElement> getInstructorElements();

  /**
   * Returns the value of the '<em><b>Student Solution</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Solution#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Student Solution</em>' container reference.
   * @see #setStudentSolution(Solution)
   * @see modelingassistant.ModelingassistantPackage#getMistake_StudentSolution()
   * @see modelingassistant.Solution#getMistakes
   * @model opposite="mistakes" required="true" transient="false"
   * @generated
   */
  Solution getStudentSolution();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getStudentSolution <em>Student Solution</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Student Solution</em>' container reference.
   * @see #getStudentSolution()
   * @generated
   */
  void setStudentSolution(Solution value);

  /**
   * Returns the value of the '<em><b>Num Detection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num Detection</em>' attribute.
   * @see #setNumDetection(int)
   * @see modelingassistant.ModelingassistantPackage#getMistake_NumDetection()
   * @model
   * @generated
   */
  int getNumDetection();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getNumDetection <em>Num Detection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Num Detection</em>' attribute.
   * @see #getNumDetection()
   * @generated
   */
  void setNumDetection(int value);

  /**
   * Returns the value of the '<em><b>Num Detection Since Resolved</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num Detection Since Resolved</em>' attribute.
   * @see #setNumDetectionSinceResolved(int)
   * @see modelingassistant.ModelingassistantPackage#getMistake_NumDetectionSinceResolved()
   * @model
   * @generated
   */
  int getNumDetectionSinceResolved();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getNumDetectionSinceResolved <em>Num Detection Since Resolved</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Num Detection Since Resolved</em>' attribute.
   * @see #getNumDetectionSinceResolved()
   * @generated
   */
  void setNumDetectionSinceResolved(int value);

} // Mistake
