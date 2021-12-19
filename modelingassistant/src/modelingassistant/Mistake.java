/**
 */
package modelingassistant;

import java.sql.Time;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import learningcorpus.MistakeType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mistake</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.Mistake#isResolvedByStudent <em>Resolved By Student</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getTimeToAddress <em>Time To Address</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getNumStepsBeforeNotification <em>Num Steps Before Notification</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getStudentElements <em>Student Elements</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getLastFeedback <em>Last Feedback</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getInstructorElements <em>Instructor Elements</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getSolution <em>Solution</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getNumDetections <em>Num Detections</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getNumSinceResolved <em>Num Since Resolved</em>}</li>
 *   <li>{@link modelingassistant.Mistake#getMistakeType <em>Mistake Type</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getMistake()
 * @model
 * @generated
 */
public interface Mistake extends EObject {
  /**
   * Returns the value of the '<em><b>Resolved By Student</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Resolved By Student</em>' attribute.
   * @see #setResolvedByStudent(boolean)
   * @see modelingassistant.ModelingassistantPackage#getMistake_ResolvedByStudent()
   * @model
   * @generated
   */
  boolean isResolvedByStudent();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#isResolvedByStudent <em>Resolved By Student</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Resolved By Student</em>' attribute.
   * @see #isResolvedByStudent()
   * @generated
   */
  void setResolvedByStudent(boolean value);

  /**
   * Returns the value of the '<em><b>Resolved By Student</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Resolved By Student</em>' attribute.
   * @see #setResolved(boolean)
   * @see modelingassistant.ModelingassistantPackage#getMistake_Resolved()
   * @model
   * @generated NOT
   */
  default boolean isResolved() {
    return isResolvedByStudent();
  }

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#isResolvedByStudent <em>Resolved By Student</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Resolved By Student</em>' attribute.
   * @see #isResolved()
   * @generated NOT
   */
  default void setResolved(boolean value) {
    setResolvedByStudent(value);
  }

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
   * Returns the value of the '<em><b>Last Feedback</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.FeedbackItem#getMistake <em>Mistake</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Last Feedback</em>' reference.
   * @see #setLastFeedback(FeedbackItem)
   * @see modelingassistant.ModelingassistantPackage#getMistake_LastFeedback()
   * @see modelingassistant.FeedbackItem#getMistake
   * @model opposite="mistake"
   * @generated
   */
  FeedbackItem getLastFeedback();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getLastFeedback <em>Last Feedback</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Last Feedback</em>' reference.
   * @see #getLastFeedback()
   * @generated
   */
  void setLastFeedback(FeedbackItem value);

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
   * Returns the value of the '<em><b>Solution</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Solution#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution</em>' container reference.
   * @see #setSolution(Solution)
   * @see modelingassistant.ModelingassistantPackage#getMistake_Solution()
   * @see modelingassistant.Solution#getMistakes
   * @model opposite="mistakes" required="true" transient="false"
   * @generated
   */
  Solution getSolution();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getSolution <em>Solution</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Solution</em>' container reference.
   * @see #getSolution()
   * @generated
   */
  void setSolution(Solution value);

  /**
   * Returns the value of the '<em><b>Num Detections</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num Detections</em>' attribute.
   * @see #setNumDetections(int)
   * @see modelingassistant.ModelingassistantPackage#getMistake_NumDetections()
   * @model
   * @generated
   */
  int getNumDetections();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getNumDetections <em>Num Detections</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Num Detections</em>' attribute.
   * @see #getNumDetections()
   * @generated
   */
  void setNumDetections(int value);

  /**
   * Returns the value of the '<em><b>Num Since Resolved</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num Since Resolved</em>' attribute.
   * @see #setNumSinceResolved(int)
   * @see modelingassistant.ModelingassistantPackage#getMistake_NumSinceResolved()
   * @model
   * @generated
   */
  int getNumSinceResolved();

  /**
   * Sets the value of the '{@link modelingassistant.Mistake#getNumSinceResolved <em>Num Since Resolved</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Num Since Resolved</em>' attribute.
   * @see #getNumSinceResolved()
   * @generated
   */
  void setNumSinceResolved(int value);

  /**
   * Returns the value of the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake Type</em>' reference.
   * @see #setMistakeType(MistakeType)
   * @see modelingassistant.ModelingassistantPackage#getMistake_MistakeType()
   * @model
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

} // Mistake
