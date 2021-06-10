/**
 */
package modelingassistant.impl;

import java.sql.Time;

import java.util.Collection;

import learningcorpus.MistakeType;

import modelingassistant.FeedbackItem;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.Solution;
import modelingassistant.SolutionElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mistake</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.MistakeImpl#isResolved <em>Resolved</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getTimeToAddress <em>Time To Address</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getNumStepsBeforeNotification <em>Num Steps Before Notification</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getStudentElements <em>Student Elements</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getLastFeedback <em>Last Feedback</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getInstructorElements <em>Instructor Elements</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getStudentSolution <em>Student Solution</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getNumDetection <em>Num Detection</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getNumDetectionSinceResolved <em>Num Detection Since Resolved</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getMistakeType <em>Mistake Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MistakeImpl extends MinimalEObjectImpl.Container implements Mistake {
  /**
   * The default value of the '{@link #isResolved() <em>Resolved</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isResolved()
   * @generated
   * @ordered
   */
  protected static final boolean RESOLVED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isResolved() <em>Resolved</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isResolved()
   * @generated
   * @ordered
   */
  protected boolean resolved = RESOLVED_EDEFAULT;

  /**
   * The default value of the '{@link #getTimeToAddress() <em>Time To Address</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeToAddress()
   * @generated
   * @ordered
   */
  protected static final Time TIME_TO_ADDRESS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTimeToAddress() <em>Time To Address</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeToAddress()
   * @generated
   * @ordered
   */
  protected Time timeToAddress = TIME_TO_ADDRESS_EDEFAULT;

  /**
   * The default value of the '{@link #getNumStepsBeforeNotification() <em>Num Steps Before Notification</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumStepsBeforeNotification()
   * @generated
   * @ordered
   */
  protected static final int NUM_STEPS_BEFORE_NOTIFICATION_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNumStepsBeforeNotification() <em>Num Steps Before Notification</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumStepsBeforeNotification()
   * @generated
   * @ordered
   */
  protected int numStepsBeforeNotification = NUM_STEPS_BEFORE_NOTIFICATION_EDEFAULT;

  /**
   * The cached value of the '{@link #getStudentElements() <em>Student Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStudentElements()
   * @generated
   * @ordered
   */
  protected EList<SolutionElement> studentElements;

  /**
   * The cached value of the '{@link #getLastFeedback() <em>Last Feedback</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastFeedback()
   * @generated
   * @ordered
   */
  protected FeedbackItem lastFeedback;

  /**
   * The cached value of the '{@link #getInstructorElements() <em>Instructor Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstructorElements()
   * @generated
   * @ordered
   */
  protected EList<SolutionElement> instructorElements;

  /**
   * The default value of the '{@link #getNumDetection() <em>Num Detection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumDetection()
   * @generated
   * @ordered
   */
  protected static final int NUM_DETECTION_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNumDetection() <em>Num Detection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumDetection()
   * @generated
   * @ordered
   */
  protected int numDetection = NUM_DETECTION_EDEFAULT;

  /**
   * The default value of the '{@link #getNumDetectionSinceResolved() <em>Num Detection Since Resolved</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumDetectionSinceResolved()
   * @generated
   * @ordered
   */
  protected static final int NUM_DETECTION_SINCE_RESOLVED_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNumDetectionSinceResolved() <em>Num Detection Since Resolved</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumDetectionSinceResolved()
   * @generated
   * @ordered
   */
  protected int numDetectionSinceResolved = NUM_DETECTION_SINCE_RESOLVED_EDEFAULT;

  /**
   * The cached value of the '{@link #getMistakeType() <em>Mistake Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMistakeType()
   * @generated
   * @ordered
   */
  protected MistakeType mistakeType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MistakeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.MISTAKE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isResolved() {
    return resolved;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setResolved(boolean newResolved) {
    boolean oldResolved = resolved;
    resolved = newResolved;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__RESOLVED, oldResolved, resolved));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Time getTimeToAddress() {
    return timeToAddress;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTimeToAddress(Time newTimeToAddress) {
    Time oldTimeToAddress = timeToAddress;
    timeToAddress = newTimeToAddress;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__TIME_TO_ADDRESS, oldTimeToAddress, timeToAddress));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getNumStepsBeforeNotification() {
    return numStepsBeforeNotification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNumStepsBeforeNotification(int newNumStepsBeforeNotification) {
    int oldNumStepsBeforeNotification = numStepsBeforeNotification;
    numStepsBeforeNotification = newNumStepsBeforeNotification;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__NUM_STEPS_BEFORE_NOTIFICATION, oldNumStepsBeforeNotification, numStepsBeforeNotification));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<SolutionElement> getStudentElements() {
    if (studentElements == null) {
      studentElements = new EObjectWithInverseResolvingEList.ManyInverse<SolutionElement>(SolutionElement.class, this, ModelingassistantPackage.MISTAKE__STUDENT_ELEMENTS, ModelingassistantPackage.SOLUTION_ELEMENT__STUDENT_ELEMENT_MISTAKES);
    }
    return studentElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FeedbackItem getLastFeedback() {
    if (lastFeedback != null && lastFeedback.eIsProxy()) {
      InternalEObject oldLastFeedback = (InternalEObject)lastFeedback;
      lastFeedback = (FeedbackItem)eResolveProxy(oldLastFeedback);
      if (lastFeedback != oldLastFeedback) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.MISTAKE__LAST_FEEDBACK, oldLastFeedback, lastFeedback));
      }
    }
    return lastFeedback;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeedbackItem basicGetLastFeedback() {
    return lastFeedback;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLastFeedback(FeedbackItem newLastFeedback, NotificationChain msgs) {
    FeedbackItem oldLastFeedback = lastFeedback;
    lastFeedback = newLastFeedback;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__LAST_FEEDBACK, oldLastFeedback, newLastFeedback);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLastFeedback(FeedbackItem newLastFeedback) {
    if (newLastFeedback != lastFeedback) {
      NotificationChain msgs = null;
      if (lastFeedback != null)
        msgs = ((InternalEObject)lastFeedback).eInverseRemove(this, ModelingassistantPackage.FEEDBACK_ITEM__MISTAKES, FeedbackItem.class, msgs);
      if (newLastFeedback != null)
        msgs = ((InternalEObject)newLastFeedback).eInverseAdd(this, ModelingassistantPackage.FEEDBACK_ITEM__MISTAKES, FeedbackItem.class, msgs);
      msgs = basicSetLastFeedback(newLastFeedback, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__LAST_FEEDBACK, newLastFeedback, newLastFeedback));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<SolutionElement> getInstructorElements() {
    if (instructorElements == null) {
      instructorElements = new EObjectWithInverseResolvingEList.ManyInverse<SolutionElement>(SolutionElement.class, this, ModelingassistantPackage.MISTAKE__INSTRUCTOR_ELEMENTS, ModelingassistantPackage.SOLUTION_ELEMENT__INSTRUCTOR_ELEMENT_MISTAKES);
    }
    return instructorElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Solution getStudentSolution() {
    if (eContainerFeatureID() != ModelingassistantPackage.MISTAKE__STUDENT_SOLUTION) return null;
    return (Solution)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStudentSolution(Solution newStudentSolution, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newStudentSolution, ModelingassistantPackage.MISTAKE__STUDENT_SOLUTION, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStudentSolution(Solution newStudentSolution) {
    if (newStudentSolution != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.MISTAKE__STUDENT_SOLUTION && newStudentSolution != null)) {
      if (EcoreUtil.isAncestor(this, newStudentSolution))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newStudentSolution != null)
        msgs = ((InternalEObject)newStudentSolution).eInverseAdd(this, ModelingassistantPackage.SOLUTION__MISTAKES, Solution.class, msgs);
      msgs = basicSetStudentSolution(newStudentSolution, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__STUDENT_SOLUTION, newStudentSolution, newStudentSolution));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getNumDetection() {
    return numDetection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNumDetection(int newNumDetection) {
    int oldNumDetection = numDetection;
    numDetection = newNumDetection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__NUM_DETECTION, oldNumDetection, numDetection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getNumDetectionSinceResolved() {
    return numDetectionSinceResolved;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNumDetectionSinceResolved(int newNumDetectionSinceResolved) {
    int oldNumDetectionSinceResolved = numDetectionSinceResolved;
    numDetectionSinceResolved = newNumDetectionSinceResolved;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__NUM_DETECTION_SINCE_RESOLVED, oldNumDetectionSinceResolved, numDetectionSinceResolved));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MistakeType getMistakeType() {
    if (mistakeType != null && mistakeType.eIsProxy()) {
      InternalEObject oldMistakeType = (InternalEObject)mistakeType;
      mistakeType = (MistakeType)eResolveProxy(oldMistakeType);
      if (mistakeType != oldMistakeType) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.MISTAKE__MISTAKE_TYPE, oldMistakeType, mistakeType));
      }
    }
    return mistakeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeType basicGetMistakeType() {
    return mistakeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMistakeType(MistakeType newMistakeType) {
    MistakeType oldMistakeType = mistakeType;
    mistakeType = newMistakeType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__MISTAKE_TYPE, oldMistakeType, mistakeType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelingassistantPackage.MISTAKE__STUDENT_ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStudentElements()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE__LAST_FEEDBACK:
        if (lastFeedback != null)
          msgs = ((InternalEObject)lastFeedback).eInverseRemove(this, ModelingassistantPackage.FEEDBACK_ITEM__MISTAKES, FeedbackItem.class, msgs);
        return basicSetLastFeedback((FeedbackItem)otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE__INSTRUCTOR_ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getInstructorElements()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE__STUDENT_SOLUTION:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetStudentSolution((Solution)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelingassistantPackage.MISTAKE__STUDENT_ELEMENTS:
        return ((InternalEList<?>)getStudentElements()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE__LAST_FEEDBACK:
        return basicSetLastFeedback(null, msgs);
      case ModelingassistantPackage.MISTAKE__INSTRUCTOR_ELEMENTS:
        return ((InternalEList<?>)getInstructorElements()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE__STUDENT_SOLUTION:
        return basicSetStudentSolution(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
      case ModelingassistantPackage.MISTAKE__STUDENT_SOLUTION:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.SOLUTION__MISTAKES, Solution.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelingassistantPackage.MISTAKE__RESOLVED:
        return isResolved();
      case ModelingassistantPackage.MISTAKE__TIME_TO_ADDRESS:
        return getTimeToAddress();
      case ModelingassistantPackage.MISTAKE__NUM_STEPS_BEFORE_NOTIFICATION:
        return getNumStepsBeforeNotification();
      case ModelingassistantPackage.MISTAKE__STUDENT_ELEMENTS:
        return getStudentElements();
      case ModelingassistantPackage.MISTAKE__LAST_FEEDBACK:
        if (resolve) return getLastFeedback();
        return basicGetLastFeedback();
      case ModelingassistantPackage.MISTAKE__INSTRUCTOR_ELEMENTS:
        return getInstructorElements();
      case ModelingassistantPackage.MISTAKE__STUDENT_SOLUTION:
        return getStudentSolution();
      case ModelingassistantPackage.MISTAKE__NUM_DETECTION:
        return getNumDetection();
      case ModelingassistantPackage.MISTAKE__NUM_DETECTION_SINCE_RESOLVED:
        return getNumDetectionSinceResolved();
      case ModelingassistantPackage.MISTAKE__MISTAKE_TYPE:
        if (resolve) return getMistakeType();
        return basicGetMistakeType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelingassistantPackage.MISTAKE__RESOLVED:
        setResolved((Boolean)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__TIME_TO_ADDRESS:
        setTimeToAddress((Time)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__NUM_STEPS_BEFORE_NOTIFICATION:
        setNumStepsBeforeNotification((Integer)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__STUDENT_ELEMENTS:
        getStudentElements().clear();
        getStudentElements().addAll((Collection<? extends SolutionElement>)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__LAST_FEEDBACK:
        setLastFeedback((FeedbackItem)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__INSTRUCTOR_ELEMENTS:
        getInstructorElements().clear();
        getInstructorElements().addAll((Collection<? extends SolutionElement>)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__STUDENT_SOLUTION:
        setStudentSolution((Solution)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__NUM_DETECTION:
        setNumDetection((Integer)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__NUM_DETECTION_SINCE_RESOLVED:
        setNumDetectionSinceResolved((Integer)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__MISTAKE_TYPE:
        setMistakeType((MistakeType)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case ModelingassistantPackage.MISTAKE__RESOLVED:
        setResolved(RESOLVED_EDEFAULT);
        return;
      case ModelingassistantPackage.MISTAKE__TIME_TO_ADDRESS:
        setTimeToAddress(TIME_TO_ADDRESS_EDEFAULT);
        return;
      case ModelingassistantPackage.MISTAKE__NUM_STEPS_BEFORE_NOTIFICATION:
        setNumStepsBeforeNotification(NUM_STEPS_BEFORE_NOTIFICATION_EDEFAULT);
        return;
      case ModelingassistantPackage.MISTAKE__STUDENT_ELEMENTS:
        getStudentElements().clear();
        return;
      case ModelingassistantPackage.MISTAKE__LAST_FEEDBACK:
        setLastFeedback((FeedbackItem)null);
        return;
      case ModelingassistantPackage.MISTAKE__INSTRUCTOR_ELEMENTS:
        getInstructorElements().clear();
        return;
      case ModelingassistantPackage.MISTAKE__STUDENT_SOLUTION:
        setStudentSolution((Solution)null);
        return;
      case ModelingassistantPackage.MISTAKE__NUM_DETECTION:
        setNumDetection(NUM_DETECTION_EDEFAULT);
        return;
      case ModelingassistantPackage.MISTAKE__NUM_DETECTION_SINCE_RESOLVED:
        setNumDetectionSinceResolved(NUM_DETECTION_SINCE_RESOLVED_EDEFAULT);
        return;
      case ModelingassistantPackage.MISTAKE__MISTAKE_TYPE:
        setMistakeType((MistakeType)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ModelingassistantPackage.MISTAKE__RESOLVED:
        return resolved != RESOLVED_EDEFAULT;
      case ModelingassistantPackage.MISTAKE__TIME_TO_ADDRESS:
        return TIME_TO_ADDRESS_EDEFAULT == null ? timeToAddress != null : !TIME_TO_ADDRESS_EDEFAULT.equals(timeToAddress);
      case ModelingassistantPackage.MISTAKE__NUM_STEPS_BEFORE_NOTIFICATION:
        return numStepsBeforeNotification != NUM_STEPS_BEFORE_NOTIFICATION_EDEFAULT;
      case ModelingassistantPackage.MISTAKE__STUDENT_ELEMENTS:
        return studentElements != null && !studentElements.isEmpty();
      case ModelingassistantPackage.MISTAKE__LAST_FEEDBACK:
        return lastFeedback != null;
      case ModelingassistantPackage.MISTAKE__INSTRUCTOR_ELEMENTS:
        return instructorElements != null && !instructorElements.isEmpty();
      case ModelingassistantPackage.MISTAKE__STUDENT_SOLUTION:
        return getStudentSolution() != null;
      case ModelingassistantPackage.MISTAKE__NUM_DETECTION:
        return numDetection != NUM_DETECTION_EDEFAULT;
      case ModelingassistantPackage.MISTAKE__NUM_DETECTION_SINCE_RESOLVED:
        return numDetectionSinceResolved != NUM_DETECTION_SINCE_RESOLVED_EDEFAULT;
      case ModelingassistantPackage.MISTAKE__MISTAKE_TYPE:
        return mistakeType != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (resolved: ");
    result.append(resolved);
    result.append(", timeToAddress: ");
    result.append(timeToAddress);
    result.append(", numStepsBeforeNotification: ");
    result.append(numStepsBeforeNotification);
    result.append(", numDetection: ");
    result.append(numDetection);
    result.append(", numDetectionSinceResolved: ");
    result.append(numDetectionSinceResolved);
    result.append(')');
    return result.toString();
  }

} //MistakeImpl
