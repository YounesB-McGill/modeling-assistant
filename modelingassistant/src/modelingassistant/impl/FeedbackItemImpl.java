/**
 */
package modelingassistant.impl;

import learningcorpus.Feedback;

import modelingassistant.FeedbackItem;
import modelingassistant.Mistake;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;

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
 *   <li>{@link modelingassistant.impl.FeedbackItemImpl#getMistakes <em>Mistakes</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackItemImpl#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackItemImpl#getUsefulness <em>Usefulness</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackItemImpl#getFeedback <em>Feedback</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeedbackItemImpl extends MinimalEObjectImpl.Container implements FeedbackItem {
  /**
   * The cached value of the '{@link #getMistakes() <em>Mistakes</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMistakes()
   * @generated
   * @ordered
   */
  protected Mistake mistakes;

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
  public Mistake getMistakes() {
    if (mistakes != null && mistakes.eIsProxy()) {
      InternalEObject oldMistakes = (InternalEObject)mistakes;
      mistakes = (Mistake)eResolveProxy(oldMistakes);
      if (mistakes != oldMistakes) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.FEEDBACK_ITEM__MISTAKES, oldMistakes, mistakes));
      }
    }
    return mistakes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mistake basicGetMistakes() {
    return mistakes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMistakes(Mistake newMistakes, NotificationChain msgs) {
    Mistake oldMistakes = mistakes;
    mistakes = newMistakes;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK_ITEM__MISTAKES, oldMistakes, newMistakes);
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
  public void setMistakes(Mistake newMistakes) {
    if (newMistakes != mistakes) {
      NotificationChain msgs = null;
      if (mistakes != null)
        msgs = ((InternalEObject)mistakes).eInverseRemove(this, ModelingassistantPackage.MISTAKE__LAST_FEEDBACK, Mistake.class, msgs);
      if (newMistakes != null)
        msgs = ((InternalEObject)newMistakes).eInverseAdd(this, ModelingassistantPackage.MISTAKE__LAST_FEEDBACK, Mistake.class, msgs);
      msgs = basicSetMistakes(newMistakes, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK_ITEM__MISTAKES, newMistakes, newMistakes));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ModelingAssistant getModelingAssistant() {
    if (eContainerFeatureID() != ModelingassistantPackage.FEEDBACK_ITEM__MODELING_ASSISTANT) return null;
    return (ModelingAssistant)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelingAssistant(ModelingAssistant newModelingAssistant, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newModelingAssistant, ModelingassistantPackage.FEEDBACK_ITEM__MODELING_ASSISTANT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setModelingAssistant(ModelingAssistant newModelingAssistant) {
    if (newModelingAssistant != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.FEEDBACK_ITEM__MODELING_ASSISTANT && newModelingAssistant != null)) {
      if (EcoreUtil.isAncestor(this, newModelingAssistant))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newModelingAssistant != null)
        msgs = ((InternalEObject)newModelingAssistant).eInverseAdd(this, ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACK_ITEMS, ModelingAssistant.class, msgs);
      msgs = basicSetModelingAssistant(newModelingAssistant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK_ITEM__MODELING_ASSISTANT, newModelingAssistant, newModelingAssistant));
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
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelingassistantPackage.FEEDBACK_ITEM__MISTAKES:
        if (mistakes != null)
          msgs = ((InternalEObject)mistakes).eInverseRemove(this, ModelingassistantPackage.MISTAKE__LAST_FEEDBACK, Mistake.class, msgs);
        return basicSetMistakes((Mistake)otherEnd, msgs);
      case ModelingassistantPackage.FEEDBACK_ITEM__MODELING_ASSISTANT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetModelingAssistant((ModelingAssistant)otherEnd, msgs);
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
      case ModelingassistantPackage.FEEDBACK_ITEM__MISTAKES:
        return basicSetMistakes(null, msgs);
      case ModelingassistantPackage.FEEDBACK_ITEM__MODELING_ASSISTANT:
        return basicSetModelingAssistant(null, msgs);
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
      case ModelingassistantPackage.FEEDBACK_ITEM__MODELING_ASSISTANT:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACK_ITEMS, ModelingAssistant.class, msgs);
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
      case ModelingassistantPackage.FEEDBACK_ITEM__MISTAKES:
        if (resolve) return getMistakes();
        return basicGetMistakes();
      case ModelingassistantPackage.FEEDBACK_ITEM__MODELING_ASSISTANT:
        return getModelingAssistant();
      case ModelingassistantPackage.FEEDBACK_ITEM__USEFULNESS:
        return getUsefulness();
      case ModelingassistantPackage.FEEDBACK_ITEM__FEEDBACK:
        if (resolve) return getFeedback();
        return basicGetFeedback();
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
      case ModelingassistantPackage.FEEDBACK_ITEM__MISTAKES:
        setMistakes((Mistake)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK_ITEM__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK_ITEM__USEFULNESS:
        setUsefulness((Double)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK_ITEM__FEEDBACK:
        setFeedback((Feedback)newValue);
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
      case ModelingassistantPackage.FEEDBACK_ITEM__MISTAKES:
        setMistakes((Mistake)null);
        return;
      case ModelingassistantPackage.FEEDBACK_ITEM__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)null);
        return;
      case ModelingassistantPackage.FEEDBACK_ITEM__USEFULNESS:
        setUsefulness(USEFULNESS_EDEFAULT);
        return;
      case ModelingassistantPackage.FEEDBACK_ITEM__FEEDBACK:
        setFeedback((Feedback)null);
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
      case ModelingassistantPackage.FEEDBACK_ITEM__MISTAKES:
        return mistakes != null;
      case ModelingassistantPackage.FEEDBACK_ITEM__MODELING_ASSISTANT:
        return getModelingAssistant() != null;
      case ModelingassistantPackage.FEEDBACK_ITEM__USEFULNESS:
        return usefulness != USEFULNESS_EDEFAULT;
      case ModelingassistantPackage.FEEDBACK_ITEM__FEEDBACK:
        return feedback != null;
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
