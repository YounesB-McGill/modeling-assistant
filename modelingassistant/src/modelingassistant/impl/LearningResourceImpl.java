/**
 */
package modelingassistant.impl;

import java.util.Collection;

import modelingassistant.LearningItem;
import modelingassistant.LearningResource;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.ResourceResponse;

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
 * An implementation of the model object '<em><b>Learning Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.LearningResourceImpl#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.impl.LearningResourceImpl#getLearningItem <em>Learning Item</em>}</li>
 *   <li>{@link modelingassistant.impl.LearningResourceImpl#getResourceResponses <em>Resource Responses</em>}</li>
 *   <li>{@link modelingassistant.impl.LearningResourceImpl#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LearningResourceImpl extends MinimalEObjectImpl.Container implements LearningResource {
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
   * The cached value of the '{@link #getResourceResponses() <em>Resource Responses</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResourceResponses()
   * @generated
   * @ordered
   */
  protected EList<ResourceResponse> resourceResponses;

  /**
   * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected static final Object CONTENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected Object content = CONTENT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LearningResourceImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.LEARNING_RESOURCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingAssistant getModelingAssistant() {
    if (eContainerFeatureID() != ModelingassistantPackage.LEARNING_RESOURCE__MODELING_ASSISTANT) return null;
    return (ModelingAssistant)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelingAssistant(ModelingAssistant newModelingAssistant, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newModelingAssistant, ModelingassistantPackage.LEARNING_RESOURCE__MODELING_ASSISTANT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelingAssistant(ModelingAssistant newModelingAssistant) {
    if (newModelingAssistant != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.LEARNING_RESOURCE__MODELING_ASSISTANT && newModelingAssistant != null)) {
      if (EcoreUtil.isAncestor(this, newModelingAssistant))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newModelingAssistant != null)
        msgs = ((InternalEObject)newModelingAssistant).eInverseAdd(this, ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_RESOURCES, ModelingAssistant.class, msgs);
      msgs = basicSetModelingAssistant(newModelingAssistant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.LEARNING_RESOURCE__MODELING_ASSISTANT, newModelingAssistant, newModelingAssistant));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.LEARNING_RESOURCE__LEARNING_ITEM, oldLearningItem, learningItem));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.LEARNING_RESOURCE__LEARNING_ITEM, oldLearningItem, newLearningItem);
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
        msgs = ((InternalEObject)learningItem).eInverseRemove(this, ModelingassistantPackage.LEARNING_ITEM__LEARNING_RESOURCES, LearningItem.class, msgs);
      if (newLearningItem != null)
        msgs = ((InternalEObject)newLearningItem).eInverseAdd(this, ModelingassistantPackage.LEARNING_ITEM__LEARNING_RESOURCES, LearningItem.class, msgs);
      msgs = basicSetLearningItem(newLearningItem, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.LEARNING_RESOURCE__LEARNING_ITEM, newLearningItem, newLearningItem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ResourceResponse> getResourceResponses() {
    if (resourceResponses == null) {
      resourceResponses = new EObjectWithInverseResolvingEList.ManyInverse<ResourceResponse>(ResourceResponse.class, this, ModelingassistantPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES, ModelingassistantPackage.RESOURCE_RESPONSE__LEARNING_RESOURCES);
    }
    return resourceResponses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object getContent() {
    return content;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContent(Object newContent) {
    Object oldContent = content;
    content = newContent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.LEARNING_RESOURCE__CONTENT, oldContent, content));
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
      case ModelingassistantPackage.LEARNING_RESOURCE__MODELING_ASSISTANT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetModelingAssistant((ModelingAssistant)otherEnd, msgs);
      case ModelingassistantPackage.LEARNING_RESOURCE__LEARNING_ITEM:
        if (learningItem != null)
          msgs = ((InternalEObject)learningItem).eInverseRemove(this, ModelingassistantPackage.LEARNING_ITEM__LEARNING_RESOURCES, LearningItem.class, msgs);
        return basicSetLearningItem((LearningItem)otherEnd, msgs);
      case ModelingassistantPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getResourceResponses()).basicAdd(otherEnd, msgs);
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
      case ModelingassistantPackage.LEARNING_RESOURCE__MODELING_ASSISTANT:
        return basicSetModelingAssistant(null, msgs);
      case ModelingassistantPackage.LEARNING_RESOURCE__LEARNING_ITEM:
        return basicSetLearningItem(null, msgs);
      case ModelingassistantPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES:
        return ((InternalEList<?>)getResourceResponses()).basicRemove(otherEnd, msgs);
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
      case ModelingassistantPackage.LEARNING_RESOURCE__MODELING_ASSISTANT:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_RESOURCES, ModelingAssistant.class, msgs);
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
      case ModelingassistantPackage.LEARNING_RESOURCE__MODELING_ASSISTANT:
        return getModelingAssistant();
      case ModelingassistantPackage.LEARNING_RESOURCE__LEARNING_ITEM:
        if (resolve) return getLearningItem();
        return basicGetLearningItem();
      case ModelingassistantPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES:
        return getResourceResponses();
      case ModelingassistantPackage.LEARNING_RESOURCE__CONTENT:
        return getContent();
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
      case ModelingassistantPackage.LEARNING_RESOURCE__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)newValue);
        return;
      case ModelingassistantPackage.LEARNING_RESOURCE__LEARNING_ITEM:
        setLearningItem((LearningItem)newValue);
        return;
      case ModelingassistantPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES:
        getResourceResponses().clear();
        getResourceResponses().addAll((Collection<? extends ResourceResponse>)newValue);
        return;
      case ModelingassistantPackage.LEARNING_RESOURCE__CONTENT:
        setContent(newValue);
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
      case ModelingassistantPackage.LEARNING_RESOURCE__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)null);
        return;
      case ModelingassistantPackage.LEARNING_RESOURCE__LEARNING_ITEM:
        setLearningItem((LearningItem)null);
        return;
      case ModelingassistantPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES:
        getResourceResponses().clear();
        return;
      case ModelingassistantPackage.LEARNING_RESOURCE__CONTENT:
        setContent(CONTENT_EDEFAULT);
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
      case ModelingassistantPackage.LEARNING_RESOURCE__MODELING_ASSISTANT:
        return getModelingAssistant() != null;
      case ModelingassistantPackage.LEARNING_RESOURCE__LEARNING_ITEM:
        return learningItem != null;
      case ModelingassistantPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES:
        return resourceResponses != null && !resourceResponses.isEmpty();
      case ModelingassistantPackage.LEARNING_RESOURCE__CONTENT:
        return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
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
    result.append(" (content: ");
    result.append(content);
    result.append(')');
    return result.toString();
  }

} //LearningResourceImpl
