/**
 */
package modelingassistant.impl;

import learningcorpus.Feedback;

import modelingassistant.FeedbackItem;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.Solution;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feedback Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.FeedbackItemImpl#getMistake <em>Mistake</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackItemImpl#getUsefulness <em>Usefulness</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackItemImpl#getFeedback <em>Feedback</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackItemImpl#getSolution <em>Solution</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeedbackItemImpl extends MinimalEObjectImpl.Container implements FeedbackItem {
  /**
   * The cached value of the '{@link #getMistake() <em>Mistake</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMistake()
   * @generated
   * @ordered
   */
  protected Mistake mistake;

  /**
   * The default value of the '{@link #getUsefulness() <em>Usefulness</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsefulness()
   * @generated
   * @ordered
   */
  protected static final double USEFULNESS_EDEFAULT = 0.0;

  /**
   * The cached value of the '{@link #getUsefulness() <em>Usefulness</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsefulness()
   * @generated
   * @ordered
   */
  protected double usefulness = USEFULNESS_EDEFAULT;

  /**
   * The cached value of the '{@link #getFeedback() <em>Feedback</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeedback()
   * @generated
   * @ordered
   */
  protected Feedback feedback;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeedbackItemImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.FEEDBACK_ITEM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Mistake getMistake() {
    if (mistake != null && mistake.eIsProxy()) {
      InternalEObject oldMistake = (InternalEObject)mistake;
      mistake = (Mistake)eResolveProxy(oldMistake);
      if (mistake != oldMistake) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.FEEDBACK_ITEM__MISTAKE, oldMistake, mistake));
      }
    }
    return mistake;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mistake basicGetMistake() {
    return mistake;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMistake(Mistake newMistake, NotificationChain msgs) {
    Mistake oldMistake = mistake;
    mistake = newMistake;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK_ITEM__MISTAKE, oldMistake, newMistake);
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
  public void setMistake(Mistake newMistake) {
    if (newMistake != mistake) {
      NotificationChain msgs = null;
      if (mistake != null)
        msgs = ((InternalEObject)mistake).eInverseRemove(this, ModelingassistantPackage.MISTAKE__LAST_FEEDBACK, Mistake.class, msgs);
      if (newMistake != null)
        msgs = ((InternalEObject)newMistake).eInverseAdd(this, ModelingassistantPackage.MISTAKE__LAST_FEEDBACK, Mistake.class, msgs);
      msgs = basicSetMistake(newMistake, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK_ITEM__MISTAKE, newMistake, newMistake));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public double getUsefulness() {
    return usefulness;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUsefulness(double newUsefulness) {
    double oldUsefulness = usefulness;
    usefulness = newUsefulness;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK_ITEM__USEFULNESS, oldUsefulness, usefulness));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Feedback getFeedback() {
    if (feedback != null && feedback.eIsProxy()) {
      InternalEObject oldFeedback = (InternalEObject)feedback;
      feedback = (Feedback)eResolveProxy(oldFeedback);
      if (feedback != oldFeedback) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.FEEDBACK_ITEM__FEEDBACK, oldFeedback, feedback));
      }
    }
    return feedback;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feedback basicGetFeedback() {
    return feedback;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFeedback(Feedback newFeedback) {
    Feedback oldFeedback = feedback;
    feedback = newFeedback;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK_ITEM__FEEDBACK, oldFeedback, feedback));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Solution getSolution() {
    if (eContainerFeatureID() != ModelingassistantPackage.FEEDBACK_ITEM__SOLUTION) return null;
    return (Solution)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSolution(Solution newSolution, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newSolution, ModelingassistantPackage.FEEDBACK_ITEM__SOLUTION, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSolution(Solution newSolution) {
    if (newSolution != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.FEEDBACK_ITEM__SOLUTION && newSolution != null)) {
      if (EcoreUtil.isAncestor(this, newSolution))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newSolution != null)
        msgs = ((InternalEObject)newSolution).eInverseAdd(this, ModelingassistantPackage.SOLUTION__FEEDBACK_ITEMS, Solution.class, msgs);
      msgs = basicSetSolution(newSolution, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK_ITEM__SOLUTION, newSolution, newSolution));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelingassistantPackage.FEEDBACK_ITEM__MISTAKE:
        if (mistake != null)
          msgs = ((InternalEObject)mistake).eInverseRemove(this, ModelingassistantPackage.MISTAKE__LAST_FEEDBACK, Mistake.class, msgs);
        return basicSetMistake((Mistake)otherEnd, msgs);
      case ModelingassistantPackage.FEEDBACK_ITEM__SOLUTION:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetSolution((Solution)otherEnd, msgs);
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
      case ModelingassistantPackage.FEEDBACK_ITEM__MISTAKE:
        return basicSetMistake(null, msgs);
      case ModelingassistantPackage.FEEDBACK_ITEM__SOLUTION:
        return basicSetSolution(null, msgs);
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
      case ModelingassistantPackage.FEEDBACK_ITEM__SOLUTION:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.SOLUTION__FEEDBACK_ITEMS, Solution.class, msgs);
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
      case ModelingassistantPackage.FEEDBACK_ITEM__MISTAKE:
        if (resolve) return getMistake();
        return basicGetMistake();
      case ModelingassistantPackage.FEEDBACK_ITEM__USEFULNESS:
        return getUsefulness();
      case ModelingassistantPackage.FEEDBACK_ITEM__FEEDBACK:
        if (resolve) return getFeedback();
        return basicGetFeedback();
      case ModelingassistantPackage.FEEDBACK_ITEM__SOLUTION:
        return getSolution();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelingassistantPackage.FEEDBACK_ITEM__MISTAKE:
        setMistake((Mistake)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK_ITEM__USEFULNESS:
        setUsefulness((Double)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK_ITEM__FEEDBACK:
        setFeedback((Feedback)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK_ITEM__SOLUTION:
        setSolution((Solution)newValue);
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
      case ModelingassistantPackage.FEEDBACK_ITEM__MISTAKE:
        setMistake((Mistake)null);
        return;
      case ModelingassistantPackage.FEEDBACK_ITEM__USEFULNESS:
        setUsefulness(USEFULNESS_EDEFAULT);
        return;
      case ModelingassistantPackage.FEEDBACK_ITEM__FEEDBACK:
        setFeedback((Feedback)null);
        return;
      case ModelingassistantPackage.FEEDBACK_ITEM__SOLUTION:
        setSolution((Solution)null);
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
      case ModelingassistantPackage.FEEDBACK_ITEM__MISTAKE:
        return mistake != null;
      case ModelingassistantPackage.FEEDBACK_ITEM__USEFULNESS:
        return usefulness != USEFULNESS_EDEFAULT;
      case ModelingassistantPackage.FEEDBACK_ITEM__FEEDBACK:
        return feedback != null;
      case ModelingassistantPackage.FEEDBACK_ITEM__SOLUTION:
        return getSolution() != null;
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
    result.append(" (usefulness: ");
    result.append(usefulness);
    result.append(')');
    return result.toString();
  }

} //FeedbackItemImpl
