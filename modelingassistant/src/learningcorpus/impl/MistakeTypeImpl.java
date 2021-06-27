/**
 */
package learningcorpus.impl;

import java.sql.Time;

import java.util.Collection;

import learningcorpus.Feedback;
import learningcorpus.LearningItem;
import learningcorpus.LearningcorpusPackage;
import learningcorpus.MistakeType;
import learningcorpus.MistakeTypeCategory;

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
 *   <li>{@link learningcorpus.impl.MistakeTypeImpl#isAtomic <em>Atomic</em>}</li>
 *   <li>{@link learningcorpus.impl.MistakeTypeImpl#getTimeToAddress <em>Time To Address</em>}</li>
 *   <li>{@link learningcorpus.impl.MistakeTypeImpl#getNumStepsBeforeNotification <em>Num Steps Before Notification</em>}</li>
 *   <li>{@link learningcorpus.impl.MistakeTypeImpl#getLearningItem <em>Learning Item</em>}</li>
 *   <li>{@link learningcorpus.impl.MistakeTypeImpl#getFeedbacks <em>Feedbacks</em>}</li>
 *   <li>{@link learningcorpus.impl.MistakeTypeImpl#getMistakeTypeCategory <em>Mistake Type Category</em>}</li>
 *   <li>{@link learningcorpus.impl.MistakeTypeImpl#getPriority <em>Priority</em>}</li>
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
   * The cached value of the '{@link #getFeedbacks() <em>Feedbacks</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeedbacks()
   * @generated
   * @ordered
   */
  protected EList<Feedback> feedbacks;

  /**
   * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected static final int PRIORITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected int priority = PRIORITY_EDEFAULT;

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
    return LearningcorpusPackage.Literals.MISTAKE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAtomic() {
    return atomic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAtomic(boolean newAtomic) {
    boolean oldAtomic = atomic;
    atomic = newAtomic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.MISTAKE_TYPE__ATOMIC, oldAtomic, atomic));
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
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.MISTAKE_TYPE__TIME_TO_ADDRESS, oldTimeToAddress, timeToAddress));
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
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION, oldNumStepsBeforeNotification, numStepsBeforeNotification));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LearningItem getLearningItem() {
    if (learningItem != null && learningItem.eIsProxy()) {
      InternalEObject oldLearningItem = (InternalEObject)learningItem;
      learningItem = (LearningItem)eResolveProxy(oldLearningItem);
      if (learningItem != oldLearningItem) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LearningcorpusPackage.MISTAKE_TYPE__LEARNING_ITEM, oldLearningItem, learningItem));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.MISTAKE_TYPE__LEARNING_ITEM, oldLearningItem, newLearningItem);
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
  public void setLearningItem(LearningItem newLearningItem) {
    if (newLearningItem != learningItem) {
      NotificationChain msgs = null;
      if (learningItem != null)
        msgs = ((InternalEObject)learningItem).eInverseRemove(this, LearningcorpusPackage.LEARNING_ITEM__MISTAKE_TYPES, LearningItem.class, msgs);
      if (newLearningItem != null)
        msgs = ((InternalEObject)newLearningItem).eInverseAdd(this, LearningcorpusPackage.LEARNING_ITEM__MISTAKE_TYPES, LearningItem.class, msgs);
      msgs = basicSetLearningItem(newLearningItem, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.MISTAKE_TYPE__LEARNING_ITEM, newLearningItem, newLearningItem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Feedback> getFeedbacks() {
    if (feedbacks == null) {
      feedbacks = new EObjectWithInverseResolvingEList<Feedback>(Feedback.class, this, LearningcorpusPackage.MISTAKE_TYPE__FEEDBACKS, LearningcorpusPackage.FEEDBACK__MISTAKE_TYPE);
    }
    return feedbacks;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MistakeTypeCategory getMistakeTypeCategory() {
    if (eContainerFeatureID() != LearningcorpusPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY) return null;
    return (MistakeTypeCategory)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMistakeTypeCategory(MistakeTypeCategory newMistakeTypeCategory, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newMistakeTypeCategory, LearningcorpusPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMistakeTypeCategory(MistakeTypeCategory newMistakeTypeCategory) {
    if (newMistakeTypeCategory != eInternalContainer() || (eContainerFeatureID() != LearningcorpusPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY && newMistakeTypeCategory != null)) {
      if (EcoreUtil.isAncestor(this, newMistakeTypeCategory))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newMistakeTypeCategory != null)
        msgs = ((InternalEObject)newMistakeTypeCategory).eInverseAdd(this, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES, MistakeTypeCategory.class, msgs);
      msgs = basicSetMistakeTypeCategory(newMistakeTypeCategory, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY, newMistakeTypeCategory, newMistakeTypeCategory));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getPriority() {
    return priority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPriority(int newPriority) {
    int oldPriority = priority;
    priority = newPriority;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.MISTAKE_TYPE__PRIORITY, oldPriority, priority));
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
      case LearningcorpusPackage.MISTAKE_TYPE__LEARNING_ITEM:
        if (learningItem != null)
          msgs = ((InternalEObject)learningItem).eInverseRemove(this, LearningcorpusPackage.LEARNING_ITEM__MISTAKE_TYPES, LearningItem.class, msgs);
        return basicSetLearningItem((LearningItem)otherEnd, msgs);
      case LearningcorpusPackage.MISTAKE_TYPE__FEEDBACKS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeedbacks()).basicAdd(otherEnd, msgs);
      case LearningcorpusPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
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
      case LearningcorpusPackage.MISTAKE_TYPE__LEARNING_ITEM:
        return basicSetLearningItem(null, msgs);
      case LearningcorpusPackage.MISTAKE_TYPE__FEEDBACKS:
        return ((InternalEList<?>)getFeedbacks()).basicRemove(otherEnd, msgs);
      case LearningcorpusPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY:
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
      case LearningcorpusPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY:
        return eInternalContainer().eInverseRemove(this, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES, MistakeTypeCategory.class, msgs);
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
      case LearningcorpusPackage.MISTAKE_TYPE__ATOMIC:
        return isAtomic();
      case LearningcorpusPackage.MISTAKE_TYPE__TIME_TO_ADDRESS:
        return getTimeToAddress();
      case LearningcorpusPackage.MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION:
        return getNumStepsBeforeNotification();
      case LearningcorpusPackage.MISTAKE_TYPE__LEARNING_ITEM:
        if (resolve) return getLearningItem();
        return basicGetLearningItem();
      case LearningcorpusPackage.MISTAKE_TYPE__FEEDBACKS:
        return getFeedbacks();
      case LearningcorpusPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY:
        return getMistakeTypeCategory();
      case LearningcorpusPackage.MISTAKE_TYPE__PRIORITY:
        return getPriority();
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
      case LearningcorpusPackage.MISTAKE_TYPE__ATOMIC:
        setAtomic((Boolean)newValue);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE__TIME_TO_ADDRESS:
        setTimeToAddress((Time)newValue);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION:
        setNumStepsBeforeNotification((Integer)newValue);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE__LEARNING_ITEM:
        setLearningItem((LearningItem)newValue);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE__FEEDBACKS:
        getFeedbacks().clear();
        getFeedbacks().addAll((Collection<? extends Feedback>)newValue);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY:
        setMistakeTypeCategory((MistakeTypeCategory)newValue);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE__PRIORITY:
        setPriority((Integer)newValue);
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
      case LearningcorpusPackage.MISTAKE_TYPE__ATOMIC:
        setAtomic(ATOMIC_EDEFAULT);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE__TIME_TO_ADDRESS:
        setTimeToAddress(TIME_TO_ADDRESS_EDEFAULT);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION:
        setNumStepsBeforeNotification(NUM_STEPS_BEFORE_NOTIFICATION_EDEFAULT);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE__LEARNING_ITEM:
        setLearningItem((LearningItem)null);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE__FEEDBACKS:
        getFeedbacks().clear();
        return;
      case LearningcorpusPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY:
        setMistakeTypeCategory((MistakeTypeCategory)null);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE__PRIORITY:
        setPriority(PRIORITY_EDEFAULT);
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
      case LearningcorpusPackage.MISTAKE_TYPE__ATOMIC:
        return atomic != ATOMIC_EDEFAULT;
      case LearningcorpusPackage.MISTAKE_TYPE__TIME_TO_ADDRESS:
        return TIME_TO_ADDRESS_EDEFAULT == null ? timeToAddress != null : !TIME_TO_ADDRESS_EDEFAULT.equals(timeToAddress);
      case LearningcorpusPackage.MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION:
        return numStepsBeforeNotification != NUM_STEPS_BEFORE_NOTIFICATION_EDEFAULT;
      case LearningcorpusPackage.MISTAKE_TYPE__LEARNING_ITEM:
        return learningItem != null;
      case LearningcorpusPackage.MISTAKE_TYPE__FEEDBACKS:
        return feedbacks != null && !feedbacks.isEmpty();
      case LearningcorpusPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY:
        return getMistakeTypeCategory() != null;
      case LearningcorpusPackage.MISTAKE_TYPE__PRIORITY:
        return priority != PRIORITY_EDEFAULT;
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
    result.append(", priority: ");
    result.append(priority);
    result.append(')');
    return result.toString();
  }

} //MistakeTypeImpl
