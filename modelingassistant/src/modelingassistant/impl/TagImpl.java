/**
 */
package modelingassistant.impl;

import modelingassistant.ModelingassistantPackage;
import modelingassistant.SolutionElement;
import modelingassistant.Tag;
import modelingassistant.TagGroup;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.TagImpl#getSolutionelement <em>Solutionelement</em>}</li>
 *   <li>{@link modelingassistant.impl.TagImpl#getTagGroup <em>Tag Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TagImpl extends MinimalEObjectImpl.Container implements Tag {
  /**
   * The cached value of the '{@link #getTagGroup() <em>Tag Group</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTagGroup()
   * @generated
   * @ordered
   */
  protected TagGroup tagGroup;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TagImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.TAG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SolutionElement getSolutionelement() {
    if (eContainerFeatureID() != ModelingassistantPackage.TAG__SOLUTIONELEMENT) return null;
    return (SolutionElement)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSolutionelement(SolutionElement newSolutionelement, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newSolutionelement, ModelingassistantPackage.TAG__SOLUTIONELEMENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSolutionelement(SolutionElement newSolutionelement) {
    if (newSolutionelement != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.TAG__SOLUTIONELEMENT && newSolutionelement != null)) {
      if (EcoreUtil.isAncestor(this, newSolutionelement))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newSolutionelement != null)
        msgs = ((InternalEObject)newSolutionelement).eInverseAdd(this, ModelingassistantPackage.SOLUTION_ELEMENT__TAGS, SolutionElement.class, msgs);
      msgs = basicSetSolutionelement(newSolutionelement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.TAG__SOLUTIONELEMENT, newSolutionelement, newSolutionelement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TagGroup getTagGroup() {
    if (tagGroup != null && tagGroup.eIsProxy()) {
      InternalEObject oldTagGroup = (InternalEObject)tagGroup;
      tagGroup = (TagGroup)eResolveProxy(oldTagGroup);
      if (tagGroup != oldTagGroup) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.TAG__TAG_GROUP, oldTagGroup, tagGroup));
      }
    }
    return tagGroup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TagGroup basicGetTagGroup() {
    return tagGroup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTagGroup(TagGroup newTagGroup, NotificationChain msgs) {
    TagGroup oldTagGroup = tagGroup;
    tagGroup = newTagGroup;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.TAG__TAG_GROUP, oldTagGroup, newTagGroup);
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
  public void setTagGroup(TagGroup newTagGroup) {
    if (newTagGroup != tagGroup) {
      NotificationChain msgs = null;
      if (tagGroup != null)
        msgs = ((InternalEObject)tagGroup).eInverseRemove(this, ModelingassistantPackage.TAG_GROUP__TAGS, TagGroup.class, msgs);
      if (newTagGroup != null)
        msgs = ((InternalEObject)newTagGroup).eInverseAdd(this, ModelingassistantPackage.TAG_GROUP__TAGS, TagGroup.class, msgs);
      msgs = basicSetTagGroup(newTagGroup, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.TAG__TAG_GROUP, newTagGroup, newTagGroup));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelingassistantPackage.TAG__SOLUTIONELEMENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetSolutionelement((SolutionElement)otherEnd, msgs);
      case ModelingassistantPackage.TAG__TAG_GROUP:
        if (tagGroup != null)
          msgs = ((InternalEObject)tagGroup).eInverseRemove(this, ModelingassistantPackage.TAG_GROUP__TAGS, TagGroup.class, msgs);
        return basicSetTagGroup((TagGroup)otherEnd, msgs);
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
      case ModelingassistantPackage.TAG__SOLUTIONELEMENT:
        return basicSetSolutionelement(null, msgs);
      case ModelingassistantPackage.TAG__TAG_GROUP:
        return basicSetTagGroup(null, msgs);
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
      case ModelingassistantPackage.TAG__SOLUTIONELEMENT:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.SOLUTION_ELEMENT__TAGS, SolutionElement.class, msgs);
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
      case ModelingassistantPackage.TAG__SOLUTIONELEMENT:
        return getSolutionelement();
      case ModelingassistantPackage.TAG__TAG_GROUP:
        if (resolve) return getTagGroup();
        return basicGetTagGroup();
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
      case ModelingassistantPackage.TAG__SOLUTIONELEMENT:
        setSolutionelement((SolutionElement)newValue);
        return;
      case ModelingassistantPackage.TAG__TAG_GROUP:
        setTagGroup((TagGroup)newValue);
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
      case ModelingassistantPackage.TAG__SOLUTIONELEMENT:
        setSolutionelement((SolutionElement)null);
        return;
      case ModelingassistantPackage.TAG__TAG_GROUP:
        setTagGroup((TagGroup)null);
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
      case ModelingassistantPackage.TAG__SOLUTIONELEMENT:
        return getSolutionelement() != null;
      case ModelingassistantPackage.TAG__TAG_GROUP:
        return tagGroup != null;
    }
    return super.eIsSet(featureID);
  }

} //TagImpl
