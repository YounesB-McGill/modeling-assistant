/**
 */
package modelingassistant.impl;

import java.sql.Time;

import java.util.Collection;

import modelingassistant.Feedback;
import modelingassistant.Mistake;
import modelingassistant.MistakeType;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.SolutionElement;
import modelingassistant.Student;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
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
 *   <li>{@link modelingassistant.impl.MistakeImpl#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getMistakeStudent <em>Mistake Student</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getCurrentMistakeStudent <em>Current Mistake Student</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getSolutionElements <em>Solution Elements</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getMistakeType <em>Mistake Type</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeImpl#getLastFeedback <em>Last Feedback</em>}</li>
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
   * The cached value of the '{@link #getModelingAssistant() <em>Modeling Assistant</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelingAssistant()
   * @generated
   * @ordered
   */
  protected ModelingAssistant modelingAssistant;

  /**
   * The cached value of the '{@link #getMistakeStudent() <em>Mistake Student</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMistakeStudent()
   * @generated
   * @ordered
   */
  protected Student mistakeStudent;

  /**
   * The cached value of the '{@link #getCurrentMistakeStudent() <em>Current Mistake Student</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCurrentMistakeStudent()
   * @generated
   * @ordered
   */
  protected Student currentMistakeStudent;

  /**
   * The cached value of the '{@link #getSolutionElements() <em>Solution Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSolutionElements()
   * @generated
   * @ordered
   */
  protected EList<SolutionElement> solutionElements;

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
   * The cached value of the '{@link #getLastFeedback() <em>Last Feedback</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastFeedback()
   * @generated
   * @ordered
   */
  protected Feedback lastFeedback;

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
  public boolean isResolved() {
    return resolved;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
  public Time getTimeToAddress() {
    return timeToAddress;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
  public int getNumStepsBeforeNotification() {
    return numStepsBeforeNotification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
  public ModelingAssistant getModelingAssistant() {
    if (modelingAssistant != null && modelingAssistant.eIsProxy()) {
      InternalEObject oldModelingAssistant = (InternalEObject)modelingAssistant;
      modelingAssistant = (ModelingAssistant)eResolveProxy(oldModelingAssistant);
      if (modelingAssistant != oldModelingAssistant) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.MISTAKE__MODELING_ASSISTANT, oldModelingAssistant, modelingAssistant));
      }
    }
    return modelingAssistant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingAssistant basicGetModelingAssistant() {
    return modelingAssistant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelingAssistant(ModelingAssistant newModelingAssistant, NotificationChain msgs) {
    ModelingAssistant oldModelingAssistant = modelingAssistant;
    modelingAssistant = newModelingAssistant;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__MODELING_ASSISTANT, oldModelingAssistant, newModelingAssistant);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelingAssistant(ModelingAssistant newModelingAssistant) {
    if (newModelingAssistant != modelingAssistant) {
      NotificationChain msgs = null;
      if (modelingAssistant != null)
        msgs = ((InternalEObject)modelingAssistant).eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__MISTAKES, ModelingAssistant.class, msgs);
      if (newModelingAssistant != null)
        msgs = ((InternalEObject)newModelingAssistant).eInverseAdd(this, ModelingassistantPackage.MODELING_ASSISTANT__MISTAKES, ModelingAssistant.class, msgs);
      msgs = basicSetModelingAssistant(newModelingAssistant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__MODELING_ASSISTANT, newModelingAssistant, newModelingAssistant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Student getMistakeStudent() {
    if (mistakeStudent != null && mistakeStudent.eIsProxy()) {
      InternalEObject oldMistakeStudent = (InternalEObject)mistakeStudent;
      mistakeStudent = (Student)eResolveProxy(oldMistakeStudent);
      if (mistakeStudent != oldMistakeStudent) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.MISTAKE__MISTAKE_STUDENT, oldMistakeStudent, mistakeStudent));
      }
    }
    return mistakeStudent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Student basicGetMistakeStudent() {
    return mistakeStudent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMistakeStudent(Student newMistakeStudent, NotificationChain msgs) {
    Student oldMistakeStudent = mistakeStudent;
    mistakeStudent = newMistakeStudent;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__MISTAKE_STUDENT, oldMistakeStudent, newMistakeStudent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMistakeStudent(Student newMistakeStudent) {
    if (newMistakeStudent != mistakeStudent) {
      NotificationChain msgs = null;
      if (mistakeStudent != null)
        msgs = ((InternalEObject)mistakeStudent).eInverseRemove(this, ModelingassistantPackage.STUDENT__MISTAKES, Student.class, msgs);
      if (newMistakeStudent != null)
        msgs = ((InternalEObject)newMistakeStudent).eInverseAdd(this, ModelingassistantPackage.STUDENT__MISTAKES, Student.class, msgs);
      msgs = basicSetMistakeStudent(newMistakeStudent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__MISTAKE_STUDENT, newMistakeStudent, newMistakeStudent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Student getCurrentMistakeStudent() {
    if (currentMistakeStudent != null && currentMistakeStudent.eIsProxy()) {
      InternalEObject oldCurrentMistakeStudent = (InternalEObject)currentMistakeStudent;
      currentMistakeStudent = (Student)eResolveProxy(oldCurrentMistakeStudent);
      if (currentMistakeStudent != oldCurrentMistakeStudent) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.MISTAKE__CURRENT_MISTAKE_STUDENT, oldCurrentMistakeStudent, currentMistakeStudent));
      }
    }
    return currentMistakeStudent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Student basicGetCurrentMistakeStudent() {
    return currentMistakeStudent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCurrentMistakeStudent(Student newCurrentMistakeStudent, NotificationChain msgs) {
    Student oldCurrentMistakeStudent = currentMistakeStudent;
    currentMistakeStudent = newCurrentMistakeStudent;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__CURRENT_MISTAKE_STUDENT, oldCurrentMistakeStudent, newCurrentMistakeStudent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCurrentMistakeStudent(Student newCurrentMistakeStudent) {
    if (newCurrentMistakeStudent != currentMistakeStudent) {
      NotificationChain msgs = null;
      if (currentMistakeStudent != null)
        msgs = ((InternalEObject)currentMistakeStudent).eInverseRemove(this, ModelingassistantPackage.STUDENT__CURRENT_MISTAKE, Student.class, msgs);
      if (newCurrentMistakeStudent != null)
        msgs = ((InternalEObject)newCurrentMistakeStudent).eInverseAdd(this, ModelingassistantPackage.STUDENT__CURRENT_MISTAKE, Student.class, msgs);
      msgs = basicSetCurrentMistakeStudent(newCurrentMistakeStudent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__CURRENT_MISTAKE_STUDENT, newCurrentMistakeStudent, newCurrentMistakeStudent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SolutionElement> getSolutionElements() {
    if (solutionElements == null) {
      solutionElements = new EObjectWithInverseResolvingEList.ManyInverse<SolutionElement>(SolutionElement.class, this, ModelingassistantPackage.MISTAKE__SOLUTION_ELEMENTS, ModelingassistantPackage.SOLUTION_ELEMENT__MISTAKES);
    }
    return solutionElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
  public NotificationChain basicSetMistakeType(MistakeType newMistakeType, NotificationChain msgs) {
    MistakeType oldMistakeType = mistakeType;
    mistakeType = newMistakeType;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__MISTAKE_TYPE, oldMistakeType, newMistakeType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMistakeType(MistakeType newMistakeType) {
    if (newMistakeType != mistakeType) {
      NotificationChain msgs = null;
      if (mistakeType != null)
        msgs = ((InternalEObject)mistakeType).eInverseRemove(this, ModelingassistantPackage.MISTAKE_TYPE__MISTAKES, MistakeType.class, msgs);
      if (newMistakeType != null)
        msgs = ((InternalEObject)newMistakeType).eInverseAdd(this, ModelingassistantPackage.MISTAKE_TYPE__MISTAKES, MistakeType.class, msgs);
      msgs = basicSetMistakeType(newMistakeType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE__MISTAKE_TYPE, newMistakeType, newMistakeType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feedback getLastFeedback() {
    if (lastFeedback != null && lastFeedback.eIsProxy()) {
      InternalEObject oldLastFeedback = (InternalEObject)lastFeedback;
      lastFeedback = (Feedback)eResolveProxy(oldLastFeedback);
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
  public Feedback basicGetLastFeedback() {
    return lastFeedback;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLastFeedback(Feedback newLastFeedback, NotificationChain msgs) {
    Feedback oldLastFeedback = lastFeedback;
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
  public void setLastFeedback(Feedback newLastFeedback) {
    if (newLastFeedback != lastFeedback) {
      NotificationChain msgs = null;
      if (lastFeedback != null)
        msgs = ((InternalEObject)lastFeedback).eInverseRemove(this, ModelingassistantPackage.FEEDBACK__MISTAKES, Feedback.class, msgs);
      if (newLastFeedback != null)
        msgs = ((InternalEObject)newLastFeedback).eInverseAdd(this, ModelingassistantPackage.FEEDBACK__MISTAKES, Feedback.class, msgs);
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
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelingassistantPackage.MISTAKE__MODELING_ASSISTANT:
        if (modelingAssistant != null)
          msgs = ((InternalEObject)modelingAssistant).eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__MISTAKES, ModelingAssistant.class, msgs);
        return basicSetModelingAssistant((ModelingAssistant)otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE__MISTAKE_STUDENT:
        if (mistakeStudent != null)
          msgs = ((InternalEObject)mistakeStudent).eInverseRemove(this, ModelingassistantPackage.STUDENT__MISTAKES, Student.class, msgs);
        return basicSetMistakeStudent((Student)otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE__CURRENT_MISTAKE_STUDENT:
        if (currentMistakeStudent != null)
          msgs = ((InternalEObject)currentMistakeStudent).eInverseRemove(this, ModelingassistantPackage.STUDENT__CURRENT_MISTAKE, Student.class, msgs);
        return basicSetCurrentMistakeStudent((Student)otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE__SOLUTION_ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSolutionElements()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE__MISTAKE_TYPE:
        if (mistakeType != null)
          msgs = ((InternalEObject)mistakeType).eInverseRemove(this, ModelingassistantPackage.MISTAKE_TYPE__MISTAKES, MistakeType.class, msgs);
        return basicSetMistakeType((MistakeType)otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE__LAST_FEEDBACK:
        if (lastFeedback != null)
          msgs = ((InternalEObject)lastFeedback).eInverseRemove(this, ModelingassistantPackage.FEEDBACK__MISTAKES, Feedback.class, msgs);
        return basicSetLastFeedback((Feedback)otherEnd, msgs);
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
      case ModelingassistantPackage.MISTAKE__MODELING_ASSISTANT:
        return basicSetModelingAssistant(null, msgs);
      case ModelingassistantPackage.MISTAKE__MISTAKE_STUDENT:
        return basicSetMistakeStudent(null, msgs);
      case ModelingassistantPackage.MISTAKE__CURRENT_MISTAKE_STUDENT:
        return basicSetCurrentMistakeStudent(null, msgs);
      case ModelingassistantPackage.MISTAKE__SOLUTION_ELEMENTS:
        return ((InternalEList<?>)getSolutionElements()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE__MISTAKE_TYPE:
        return basicSetMistakeType(null, msgs);
      case ModelingassistantPackage.MISTAKE__LAST_FEEDBACK:
        return basicSetLastFeedback(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case ModelingassistantPackage.MISTAKE__MODELING_ASSISTANT:
        if (resolve) return getModelingAssistant();
        return basicGetModelingAssistant();
      case ModelingassistantPackage.MISTAKE__MISTAKE_STUDENT:
        if (resolve) return getMistakeStudent();
        return basicGetMistakeStudent();
      case ModelingassistantPackage.MISTAKE__CURRENT_MISTAKE_STUDENT:
        if (resolve) return getCurrentMistakeStudent();
        return basicGetCurrentMistakeStudent();
      case ModelingassistantPackage.MISTAKE__SOLUTION_ELEMENTS:
        return getSolutionElements();
      case ModelingassistantPackage.MISTAKE__MISTAKE_TYPE:
        if (resolve) return getMistakeType();
        return basicGetMistakeType();
      case ModelingassistantPackage.MISTAKE__LAST_FEEDBACK:
        if (resolve) return getLastFeedback();
        return basicGetLastFeedback();
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
      case ModelingassistantPackage.MISTAKE__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__MISTAKE_STUDENT:
        setMistakeStudent((Student)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__CURRENT_MISTAKE_STUDENT:
        setCurrentMistakeStudent((Student)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__SOLUTION_ELEMENTS:
        getSolutionElements().clear();
        getSolutionElements().addAll((Collection<? extends SolutionElement>)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__MISTAKE_TYPE:
        setMistakeType((MistakeType)newValue);
        return;
      case ModelingassistantPackage.MISTAKE__LAST_FEEDBACK:
        setLastFeedback((Feedback)newValue);
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
      case ModelingassistantPackage.MISTAKE__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)null);
        return;
      case ModelingassistantPackage.MISTAKE__MISTAKE_STUDENT:
        setMistakeStudent((Student)null);
        return;
      case ModelingassistantPackage.MISTAKE__CURRENT_MISTAKE_STUDENT:
        setCurrentMistakeStudent((Student)null);
        return;
      case ModelingassistantPackage.MISTAKE__SOLUTION_ELEMENTS:
        getSolutionElements().clear();
        return;
      case ModelingassistantPackage.MISTAKE__MISTAKE_TYPE:
        setMistakeType((MistakeType)null);
        return;
      case ModelingassistantPackage.MISTAKE__LAST_FEEDBACK:
        setLastFeedback((Feedback)null);
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
      case ModelingassistantPackage.MISTAKE__MODELING_ASSISTANT:
        return modelingAssistant != null;
      case ModelingassistantPackage.MISTAKE__MISTAKE_STUDENT:
        return mistakeStudent != null;
      case ModelingassistantPackage.MISTAKE__CURRENT_MISTAKE_STUDENT:
        return currentMistakeStudent != null;
      case ModelingassistantPackage.MISTAKE__SOLUTION_ELEMENTS:
        return solutionElements != null && !solutionElements.isEmpty();
      case ModelingassistantPackage.MISTAKE__MISTAKE_TYPE:
        return mistakeType != null;
      case ModelingassistantPackage.MISTAKE__LAST_FEEDBACK:
        return lastFeedback != null;
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
    result.append(')');
    return result.toString();
  }

} //MistakeImpl
