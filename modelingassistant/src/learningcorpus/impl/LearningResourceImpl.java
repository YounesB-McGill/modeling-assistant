/**
 */
package learningcorpus.impl;

import java.util.Collection;

import learningcorpus.LearningCorpus;
import learningcorpus.LearningItem;
import learningcorpus.LearningResource;
import learningcorpus.LearningcorpusPackage;
import learningcorpus.ResourceResponse;

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
 * An implementation of the model object '<em><b>Learning Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpus.impl.LearningResourceImpl#getLearningItem <em>Learning Item</em>}</li>
 *   <li>{@link learningcorpus.impl.LearningResourceImpl#getResourceResponses <em>Resource Responses</em>}</li>
 *   <li>{@link learningcorpus.impl.LearningResourceImpl#getContent <em>Content</em>}</li>
 *   <li>{@link learningcorpus.impl.LearningResourceImpl#getLearningCorpus <em>Learning Corpus</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LearningResourceImpl extends NamedElementImpl implements LearningResource {
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
  protected static final String CONTENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected String content = CONTENT_EDEFAULT;

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
    return LearningcorpusPackage.Literals.LEARNING_RESOURCE;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_ITEM, oldLearningItem, learningItem));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_ITEM, oldLearningItem, newLearningItem);
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
        msgs = ((InternalEObject)learningItem).eInverseRemove(this, LearningcorpusPackage.LEARNING_ITEM__LEARNING_RESOURCES, LearningItem.class, msgs);
      if (newLearningItem != null)
        msgs = ((InternalEObject)newLearningItem).eInverseAdd(this, LearningcorpusPackage.LEARNING_ITEM__LEARNING_RESOURCES, LearningItem.class, msgs);
      msgs = basicSetLearningItem(newLearningItem, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_ITEM, newLearningItem, newLearningItem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ResourceResponse> getResourceResponses() {
    if (resourceResponses == null) {
      resourceResponses = new EObjectWithInverseResolvingEList.ManyInverse<ResourceResponse>(ResourceResponse.class, this, LearningcorpusPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES, LearningcorpusPackage.RESOURCE_RESPONSE__LEARNING_RESOURCES);
    }
    return resourceResponses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getContent() {
    return content;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setContent(String newContent) {
    String oldContent = content;
    content = newContent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.LEARNING_RESOURCE__CONTENT, oldContent, content));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LearningCorpus getLearningCorpus() {
    if (eContainerFeatureID() != LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_CORPUS) return null;
    return (LearningCorpus)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLearningCorpus(LearningCorpus newLearningCorpus, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newLearningCorpus, LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_CORPUS, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLearningCorpus(LearningCorpus newLearningCorpus) {
    if (newLearningCorpus != eInternalContainer() || (eContainerFeatureID() != LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_CORPUS && newLearningCorpus != null)) {
      if (EcoreUtil.isAncestor(this, newLearningCorpus))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newLearningCorpus != null)
        msgs = ((InternalEObject)newLearningCorpus).eInverseAdd(this, LearningcorpusPackage.LEARNING_CORPUS__LEARNING_RESOURCES, LearningCorpus.class, msgs);
      msgs = basicSetLearningCorpus(newLearningCorpus, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_CORPUS, newLearningCorpus, newLearningCorpus));
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
      case LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_ITEM:
        if (learningItem != null)
          msgs = ((InternalEObject)learningItem).eInverseRemove(this, LearningcorpusPackage.LEARNING_ITEM__LEARNING_RESOURCES, LearningItem.class, msgs);
        return basicSetLearningItem((LearningItem)otherEnd, msgs);
      case LearningcorpusPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getResourceResponses()).basicAdd(otherEnd, msgs);
      case LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_CORPUS:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetLearningCorpus((LearningCorpus)otherEnd, msgs);
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
      case LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_ITEM:
        return basicSetLearningItem(null, msgs);
      case LearningcorpusPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES:
        return ((InternalEList<?>)getResourceResponses()).basicRemove(otherEnd, msgs);
      case LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_CORPUS:
        return basicSetLearningCorpus(null, msgs);
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
      case LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_CORPUS:
        return eInternalContainer().eInverseRemove(this, LearningcorpusPackage.LEARNING_CORPUS__LEARNING_RESOURCES, LearningCorpus.class, msgs);
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
      case LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_ITEM:
        if (resolve) return getLearningItem();
        return basicGetLearningItem();
      case LearningcorpusPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES:
        return getResourceResponses();
      case LearningcorpusPackage.LEARNING_RESOURCE__CONTENT:
        return getContent();
      case LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_CORPUS:
        return getLearningCorpus();
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
      case LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_ITEM:
        setLearningItem((LearningItem)newValue);
        return;
      case LearningcorpusPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES:
        getResourceResponses().clear();
        getResourceResponses().addAll((Collection<? extends ResourceResponse>)newValue);
        return;
      case LearningcorpusPackage.LEARNING_RESOURCE__CONTENT:
        setContent((String)newValue);
        return;
      case LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_CORPUS:
        setLearningCorpus((LearningCorpus)newValue);
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
      case LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_ITEM:
        setLearningItem((LearningItem)null);
        return;
      case LearningcorpusPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES:
        getResourceResponses().clear();
        return;
      case LearningcorpusPackage.LEARNING_RESOURCE__CONTENT:
        setContent(CONTENT_EDEFAULT);
        return;
      case LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_CORPUS:
        setLearningCorpus((LearningCorpus)null);
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
      case LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_ITEM:
        return learningItem != null;
      case LearningcorpusPackage.LEARNING_RESOURCE__RESOURCE_RESPONSES:
        return resourceResponses != null && !resourceResponses.isEmpty();
      case LearningcorpusPackage.LEARNING_RESOURCE__CONTENT:
        return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
      case LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_CORPUS:
        return getLearningCorpus() != null;
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
