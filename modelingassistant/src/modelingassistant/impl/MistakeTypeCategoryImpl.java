/**
 */
package modelingassistant.impl;

import java.util.Collection;

import modelingassistant.MistakeType;
import modelingassistant.MistakeTypeCategory;
import modelingassistant.ModelingassistantPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mistake Type Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.MistakeTypeCategoryImpl#getMistaketype <em>Mistaketype</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeTypeCategoryImpl#getSupercategory <em>Supercategory</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeTypeCategoryImpl#getSubcategories <em>Subcategories</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MistakeTypeCategoryImpl extends NamedElementImpl implements MistakeTypeCategory {
  /**
   * The cached value of the '{@link #getMistaketype() <em>Mistaketype</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMistaketype()
   * @generated
   * @ordered
   */
  protected EList<MistakeType> mistaketype;

  /**
   * The cached value of the '{@link #getSupercategory() <em>Supercategory</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupercategory()
   * @generated
   * @ordered
   */
  protected MistakeTypeCategory supercategory;

  /**
   * The cached value of the '{@link #getSubcategories() <em>Subcategories</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubcategories()
   * @generated
   * @ordered
   */
  protected MistakeTypeCategory subcategories;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MistakeTypeCategoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.MISTAKE_TYPE_CATEGORY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MistakeType> getMistaketype() {
    if (mistaketype == null) {
      mistaketype = new EObjectWithInverseResolvingEList<MistakeType>(MistakeType.class, this, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MISTAKETYPE, ModelingassistantPackage.MISTAKE_TYPE__MISTAKETYPECATEGORY);
    }
    return mistaketype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeTypeCategory getSupercategory() {
    if (supercategory != null && supercategory.eIsProxy()) {
      InternalEObject oldSupercategory = (InternalEObject)supercategory;
      supercategory = (MistakeTypeCategory)eResolveProxy(oldSupercategory);
      if (supercategory != oldSupercategory) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY, oldSupercategory, supercategory));
      }
    }
    return supercategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeTypeCategory basicGetSupercategory() {
    return supercategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSupercategory(MistakeTypeCategory newSupercategory, NotificationChain msgs) {
    MistakeTypeCategory oldSupercategory = supercategory;
    supercategory = newSupercategory;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY, oldSupercategory, newSupercategory);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSupercategory(MistakeTypeCategory newSupercategory) {
    if (newSupercategory != supercategory) {
      NotificationChain msgs = null;
      if (supercategory != null)
        msgs = ((InternalEObject)supercategory).eInverseRemove(this, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES, MistakeTypeCategory.class, msgs);
      if (newSupercategory != null)
        msgs = ((InternalEObject)newSupercategory).eInverseAdd(this, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES, MistakeTypeCategory.class, msgs);
      msgs = basicSetSupercategory(newSupercategory, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY, newSupercategory, newSupercategory));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeTypeCategory getSubcategories() {
    if (subcategories != null && subcategories.eIsProxy()) {
      InternalEObject oldSubcategories = (InternalEObject)subcategories;
      subcategories = (MistakeTypeCategory)eResolveProxy(oldSubcategories);
      if (subcategories != oldSubcategories) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES, oldSubcategories, subcategories));
      }
    }
    return subcategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeTypeCategory basicGetSubcategories() {
    return subcategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubcategories(MistakeTypeCategory newSubcategories, NotificationChain msgs) {
    MistakeTypeCategory oldSubcategories = subcategories;
    subcategories = newSubcategories;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES, oldSubcategories, newSubcategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubcategories(MistakeTypeCategory newSubcategories) {
    if (newSubcategories != subcategories) {
      NotificationChain msgs = null;
      if (subcategories != null)
        msgs = ((InternalEObject)subcategories).eInverseRemove(this, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY, MistakeTypeCategory.class, msgs);
      if (newSubcategories != null)
        msgs = ((InternalEObject)newSubcategories).eInverseAdd(this, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY, MistakeTypeCategory.class, msgs);
      msgs = basicSetSubcategories(newSubcategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES, newSubcategories, newSubcategories));
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
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MISTAKETYPE:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getMistaketype()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY:
        if (supercategory != null)
          msgs = ((InternalEObject)supercategory).eInverseRemove(this, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES, MistakeTypeCategory.class, msgs);
        return basicSetSupercategory((MistakeTypeCategory)otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES:
        if (subcategories != null)
          msgs = ((InternalEObject)subcategories).eInverseRemove(this, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY, MistakeTypeCategory.class, msgs);
        return basicSetSubcategories((MistakeTypeCategory)otherEnd, msgs);
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
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MISTAKETYPE:
        return ((InternalEList<?>)getMistaketype()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY:
        return basicSetSupercategory(null, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES:
        return basicSetSubcategories(null, msgs);
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
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MISTAKETYPE:
        return getMistaketype();
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY:
        if (resolve) return getSupercategory();
        return basicGetSupercategory();
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES:
        if (resolve) return getSubcategories();
        return basicGetSubcategories();
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
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MISTAKETYPE:
        getMistaketype().clear();
        getMistaketype().addAll((Collection<? extends MistakeType>)newValue);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY:
        setSupercategory((MistakeTypeCategory)newValue);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES:
        setSubcategories((MistakeTypeCategory)newValue);
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
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MISTAKETYPE:
        getMistaketype().clear();
        return;
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY:
        setSupercategory((MistakeTypeCategory)null);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES:
        setSubcategories((MistakeTypeCategory)null);
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
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MISTAKETYPE:
        return mistaketype != null && !mistaketype.isEmpty();
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY:
        return supercategory != null;
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES:
        return subcategories != null;
    }
    return super.eIsSet(featureID);
  }

} //MistakeTypeCategoryImpl
