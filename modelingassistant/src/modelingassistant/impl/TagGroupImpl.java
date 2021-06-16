/**
 */
package modelingassistant.impl;

import java.util.Collection;

import modelingassistant.ModelingassistantPackage;
import modelingassistant.Solution;
import modelingassistant.Tag;
import modelingassistant.TagGroup;

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
 * An implementation of the model object '<em><b>Tag Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.TagGroupImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link modelingassistant.impl.TagGroupImpl#getSolution <em>Solution</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TagGroupImpl extends MinimalEObjectImpl.Container implements TagGroup {
  /**
   * The cached value of the '{@link #getTags() <em>Tags</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTags()
   * @generated
   * @ordered
   */
  protected EList<Tag> tags;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TagGroupImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.TAG_GROUP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Tag> getTags() {
    if (tags == null) {
      tags = new EObjectWithInverseResolvingEList<Tag>(Tag.class, this, ModelingassistantPackage.TAG_GROUP__TAGS, ModelingassistantPackage.TAG__TAG_GROUP);
    }
    return tags;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Solution getSolution() {
    if (eContainerFeatureID() != ModelingassistantPackage.TAG_GROUP__SOLUTION) return null;
    return (Solution)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSolution(Solution newSolution, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newSolution, ModelingassistantPackage.TAG_GROUP__SOLUTION, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSolution(Solution newSolution) {
    if (newSolution != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.TAG_GROUP__SOLUTION && newSolution != null)) {
      if (EcoreUtil.isAncestor(this, newSolution))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newSolution != null)
        msgs = ((InternalEObject)newSolution).eInverseAdd(this, ModelingassistantPackage.SOLUTION__TAG_GROUPS, Solution.class, msgs);
      msgs = basicSetSolution(newSolution, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.TAG_GROUP__SOLUTION, newSolution, newSolution));
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
      case ModelingassistantPackage.TAG_GROUP__TAGS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getTags()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.TAG_GROUP__SOLUTION:
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
      case ModelingassistantPackage.TAG_GROUP__TAGS:
        return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.TAG_GROUP__SOLUTION:
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
      case ModelingassistantPackage.TAG_GROUP__SOLUTION:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.SOLUTION__TAG_GROUPS, Solution.class, msgs);
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
      case ModelingassistantPackage.TAG_GROUP__TAGS:
        return getTags();
      case ModelingassistantPackage.TAG_GROUP__SOLUTION:
        return getSolution();
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
      case ModelingassistantPackage.TAG_GROUP__TAGS:
        getTags().clear();
        getTags().addAll((Collection<? extends Tag>)newValue);
        return;
      case ModelingassistantPackage.TAG_GROUP__SOLUTION:
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
      case ModelingassistantPackage.TAG_GROUP__TAGS:
        getTags().clear();
        return;
      case ModelingassistantPackage.TAG_GROUP__SOLUTION:
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
      case ModelingassistantPackage.TAG_GROUP__TAGS:
        return tags != null && !tags.isEmpty();
      case ModelingassistantPackage.TAG_GROUP__SOLUTION:
        return getSolution() != null;
    }
    return super.eIsSet(featureID);
  }

} //TagGroupImpl
