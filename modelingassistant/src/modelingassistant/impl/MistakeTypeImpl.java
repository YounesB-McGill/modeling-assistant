/**
 */
package modelingassistant.impl;

import java.sql.Time;

import java.util.Collection;

import modelingassistant.Feedback;
import modelingassistant.LearningItem;
import modelingassistant.Mistake;
import modelingassistant.MistakeType;
import modelingassistant.MistakeTypeCategory;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.StudentKnowledge;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mistake Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.MistakeTypeImpl#isAtomic <em>Atomic</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeTypeImpl#getTimeToAddress <em>Time To Address</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeTypeImpl#getNumStepsBeforeNotification <em>Num Steps Before Notification</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeTypeImpl#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeTypeImpl#getLearningItem <em>Learning Item</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeTypeImpl#getStudentKnowledges <em>Student Knowledges</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeTypeImpl#getMistakes <em>Mistakes</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeTypeImpl#getFeedbacks <em>Feedbacks</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeTypeImpl#getMistakeTypeCategory <em>Mistake Type Category</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MistakeTypeImpl extends NamedElementImpl implements MistakeType {
  /**
   * The default value of the '{@link #isAtomic() <em>Atomic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAtomic()
   * @generated
   * @ordered
   */
  protected static final boolean ATOMIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAtomic() <em>Atomic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAtomic()
   * @generated
   * @ordered
   */
  protected boolean atomic = ATOMIC_EDEFAULT;

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
   * The cached value of the '{@link #getLearningItem() <em>Learning Item</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLearningItem()
   * @generated
   * @ordered
   */
  protected LearningItem learningItem;

  /**
   * The cached value of the '{@link #getStudentKnowledges() <em>Student Knowledges</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStudentKnowledges()
   * @generated
   * @ordered
   */
  protected EList<StudentKnowledge> studentKnowledges;

  /**
   * The cached value of the '{@link #getMistakes() <em>Mistakes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMistakes()
   * @generated
   * @ordered
   */
  protected EList<Mistake> mistakes;

  /**
   * The cached value of the '{@link #getFeedbacks() <em>Feedbacks</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeedbacks()
   * @generated
   * @ordered
   */
  protected EList<Feedback> feedbacks;

  /**
   * The cached value of the '{@link #getMistakeTypeCategory() <em>Mistake Type Category</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMistakeTypeCategory()
   * @generated
   * @ordered
   */
  protected MistakeTypeCategory mistakeTypeCategory;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MistakeTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.MISTAKE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAtomic() {
    return atomic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAtomic(boolean newAtomic) {
    boolean oldAtomic = atomic;
    atomic = newAtomic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE_TYPE__ATOMIC, oldAtomic, atomic));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE_TYPE__TIME_TO_ADDRESS, oldTimeToAddress, timeToAddress));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION, oldNumStepsBeforeNotification, numStepsBeforeNotification));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingAssistant getModelingAssistant() {
    if (eContainerFeatureID() != ModelingassistantPackage.MISTAKE_TYPE__MODELING_ASSISTANT) return null;
    return (ModelingAssistant)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelingAssistant(ModelingAssistant newModelingAssistant, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newModelingAssistant, ModelingassistantPackage.MISTAKE_TYPE__MODELING_ASSISTANT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelingAssistant(ModelingAssistant newModelingAssistant) {
    if (newModelingAssistant != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.MISTAKE_TYPE__MODELING_ASSISTANT && newModelingAssistant != null)) {
      if (EcoreUtil.isAncestor(this, newModelingAssistant))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newModelingAssistant != null)
        msgs = ((InternalEObject)newModelingAssistant).eInverseAdd(this, ModelingassistantPackage.MODELING_ASSISTANT__MISTAKE_TYPES, ModelingAssistant.class, msgs);
      msgs = basicSetModelingAssistant(newModelingAssistant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE_TYPE__MODELING_ASSISTANT, newModelingAssistant, newModelingAssistant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningItem getLearningItem() {
    if (learningItem != null && learningItem.eIsProxy()) {
      InternalEObject oldLearningItem = (InternalEObject)learningItem;
      learningItem = (LearningItem)eResolveProxy(oldLearningItem);
      if (learningItem != oldLearningItem) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.MISTAKE_TYPE__LEARNING_ITEM, oldLearningItem, learningItem));
      }
    }
    return learningItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningItem basicGetLearningItem() {
    return learningItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLearningItem(LearningItem newLearningItem, NotificationChain msgs) {
    LearningItem oldLearningItem = learningItem;
    learningItem = newLearningItem;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE_TYPE__LEARNING_ITEM, oldLearningItem, newLearningItem);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLearningItem(LearningItem newLearningItem) {
    if (newLearningItem != learningItem) {
      NotificationChain msgs = null;
      if (learningItem != null)
        msgs = ((InternalEObject)learningItem).eInverseRemove(this, ModelingassistantPackage.LEARNING_ITEM__MISTAKE_TYPES, LearningItem.class, msgs);
      if (newLearningItem != null)
        msgs = ((InternalEObject)newLearningItem).eInverseAdd(this, ModelingassistantPackage.LEARNING_ITEM__MISTAKE_TYPES, LearningItem.class, msgs);
      msgs = basicSetLearningItem(newLearningItem, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE_TYPE__LEARNING_ITEM, newLearningItem, newLearningItem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StudentKnowledge> getStudentKnowledges() {
    if (studentKnowledges == null) {
      studentKnowledges = new EObjectWithInverseResolvingEList<StudentKnowledge>(StudentKnowledge.class, this, ModelingassistantPackage.MISTAKE_TYPE__STUDENT_KNOWLEDGES, ModelingassistantPackage.STUDENT_KNOWLEDGE__MISTAKE_TYPE);
    }
    return studentKnowledges;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Mistake> getMistakes() {
    if (mistakes == null) {
      mistakes = new EObjectWithInverseResolvingEList<Mistake>(Mistake.class, this, ModelingassistantPackage.MISTAKE_TYPE__MISTAKES, ModelingassistantPackage.MISTAKE__MISTAKE_TYPE);
    }
    return mistakes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feedback> getFeedbacks() {
    if (feedbacks == null) {
      feedbacks = new EObjectWithInverseResolvingEList<Feedback>(Feedback.class, this, ModelingassistantPackage.MISTAKE_TYPE__FEEDBACKS, ModelingassistantPackage.FEEDBACK__MISTAKE_TYPE);
    }
    return feedbacks;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeTypeCategory getMistakeTypeCategory() {
    if (mistakeTypeCategory != null && mistakeTypeCategory.eIsProxy()) {
      InternalEObject oldMistakeTypeCategory = (InternalEObject)mistakeTypeCategory;
      mistakeTypeCategory = (MistakeTypeCategory)eResolveProxy(oldMistakeTypeCategory);
      if (mistakeTypeCategory != oldMistakeTypeCategory) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY, oldMistakeTypeCategory, mistakeTypeCategory));
      }
    }
    return mistakeTypeCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeTypeCategory basicGetMistakeTypeCategory() {
    return mistakeTypeCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMistakeTypeCategory(MistakeTypeCategory newMistakeTypeCategory, NotificationChain msgs) {
    MistakeTypeCategory oldMistakeTypeCategory = mistakeTypeCategory;
    mistakeTypeCategory = newMistakeTypeCategory;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY, oldMistakeTypeCategory, newMistakeTypeCategory);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMistakeTypeCategory(MistakeTypeCategory newMistakeTypeCategory) {
    if (newMistakeTypeCategory != mistakeTypeCategory) {
      NotificationChain msgs = null;
      if (mistakeTypeCategory != null)
        msgs = ((InternalEObject)mistakeTypeCategory).eInverseRemove(this, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES, MistakeTypeCategory.class, msgs);
      if (newMistakeTypeCategory != null)
        msgs = ((InternalEObject)newMistakeTypeCategory).eInverseAdd(this, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES, MistakeTypeCategory.class, msgs);
      msgs = basicSetMistakeTypeCategory(newMistakeTypeCategory, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY, newMistakeTypeCategory, newMistakeTypeCategory));
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
      case ModelingassistantPackage.MISTAKE_TYPE__MODELING_ASSISTANT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetModelingAssistant((ModelingAssistant)otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE__LEARNING_ITEM:
        if (learningItem != null)
          msgs = ((InternalEObject)learningItem).eInverseRemove(this, ModelingassistantPackage.LEARNING_ITEM__MISTAKE_TYPES, LearningItem.class, msgs);
        return basicSetLearningItem((LearningItem)otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE__STUDENT_KNOWLEDGES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStudentKnowledges()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE__MISTAKES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getMistakes()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE__FEEDBACKS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeedbacks()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY:
        if (mistakeTypeCategory != null)
          msgs = ((InternalEObject)mistakeTypeCategory).eInverseRemove(this, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES, MistakeTypeCategory.class, msgs);
        return basicSetMistakeTypeCategory((MistakeTypeCategory)otherEnd, msgs);
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
      case ModelingassistantPackage.MISTAKE_TYPE__MODELING_ASSISTANT:
        return basicSetModelingAssistant(null, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE__LEARNING_ITEM:
        return basicSetLearningItem(null, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE__STUDENT_KNOWLEDGES:
        return ((InternalEList<?>)getStudentKnowledges()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE__MISTAKES:
        return ((InternalEList<?>)getMistakes()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE__FEEDBACKS:
        return ((InternalEList<?>)getFeedbacks()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY:
        return basicSetMistakeTypeCategory(null, msgs);
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
      case ModelingassistantPackage.MISTAKE_TYPE__MODELING_ASSISTANT:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__MISTAKE_TYPES, ModelingAssistant.class, msgs);
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
      case ModelingassistantPackage.MISTAKE_TYPE__ATOMIC:
        return isAtomic();
      case ModelingassistantPackage.MISTAKE_TYPE__TIME_TO_ADDRESS:
        return getTimeToAddress();
      case ModelingassistantPackage.MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION:
        return getNumStepsBeforeNotification();
      case ModelingassistantPackage.MISTAKE_TYPE__MODELING_ASSISTANT:
        return getModelingAssistant();
      case ModelingassistantPackage.MISTAKE_TYPE__LEARNING_ITEM:
        if (resolve) return getLearningItem();
        return basicGetLearningItem();
      case ModelingassistantPackage.MISTAKE_TYPE__STUDENT_KNOWLEDGES:
        return getStudentKnowledges();
      case ModelingassistantPackage.MISTAKE_TYPE__MISTAKES:
        return getMistakes();
      case ModelingassistantPackage.MISTAKE_TYPE__FEEDBACKS:
        return getFeedbacks();
      case ModelingassistantPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY:
        if (resolve) return getMistakeTypeCategory();
        return basicGetMistakeTypeCategory();
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
      case ModelingassistantPackage.MISTAKE_TYPE__ATOMIC:
        setAtomic((Boolean)newValue);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__TIME_TO_ADDRESS:
        setTimeToAddress((Time)newValue);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION:
        setNumStepsBeforeNotification((Integer)newValue);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)newValue);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__LEARNING_ITEM:
        setLearningItem((LearningItem)newValue);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__STUDENT_KNOWLEDGES:
        getStudentKnowledges().clear();
        getStudentKnowledges().addAll((Collection<? extends StudentKnowledge>)newValue);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__MISTAKES:
        getMistakes().clear();
        getMistakes().addAll((Collection<? extends Mistake>)newValue);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__FEEDBACKS:
        getFeedbacks().clear();
        getFeedbacks().addAll((Collection<? extends Feedback>)newValue);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY:
        setMistakeTypeCategory((MistakeTypeCategory)newValue);
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
      case ModelingassistantPackage.MISTAKE_TYPE__ATOMIC:
        setAtomic(ATOMIC_EDEFAULT);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__TIME_TO_ADDRESS:
        setTimeToAddress(TIME_TO_ADDRESS_EDEFAULT);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION:
        setNumStepsBeforeNotification(NUM_STEPS_BEFORE_NOTIFICATION_EDEFAULT);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)null);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__LEARNING_ITEM:
        setLearningItem((LearningItem)null);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__STUDENT_KNOWLEDGES:
        getStudentKnowledges().clear();
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__MISTAKES:
        getMistakes().clear();
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__FEEDBACKS:
        getFeedbacks().clear();
        return;
      case ModelingassistantPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY:
        setMistakeTypeCategory((MistakeTypeCategory)null);
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
      case ModelingassistantPackage.MISTAKE_TYPE__ATOMIC:
        return atomic != ATOMIC_EDEFAULT;
      case ModelingassistantPackage.MISTAKE_TYPE__TIME_TO_ADDRESS:
        return TIME_TO_ADDRESS_EDEFAULT == null ? timeToAddress != null : !TIME_TO_ADDRESS_EDEFAULT.equals(timeToAddress);
      case ModelingassistantPackage.MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION:
        return numStepsBeforeNotification != NUM_STEPS_BEFORE_NOTIFICATION_EDEFAULT;
      case ModelingassistantPackage.MISTAKE_TYPE__MODELING_ASSISTANT:
        return getModelingAssistant() != null;
      case ModelingassistantPackage.MISTAKE_TYPE__LEARNING_ITEM:
        return learningItem != null;
      case ModelingassistantPackage.MISTAKE_TYPE__STUDENT_KNOWLEDGES:
        return studentKnowledges != null && !studentKnowledges.isEmpty();
      case ModelingassistantPackage.MISTAKE_TYPE__MISTAKES:
        return mistakes != null && !mistakes.isEmpty();
      case ModelingassistantPackage.MISTAKE_TYPE__FEEDBACKS:
        return feedbacks != null && !feedbacks.isEmpty();
      case ModelingassistantPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY:
        return mistakeTypeCategory != null;
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
    result.append(" (atomic: ");
    result.append(atomic);
    result.append(", timeToAddress: ");
    result.append(timeToAddress);
    result.append(", numStepsBeforeNotification: ");
    result.append(numStepsBeforeNotification);
    result.append(')');
    return result.toString();
  }

} //MistakeTypeImpl
