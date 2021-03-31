/**
 */
package modelingassistant.impl;

import java.util.Collection;

import modelingassistant.MistakeType;
import modelingassistant.MistakeTypeCategory;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;

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
 * An implementation of the model object '<em><b>Mistake Type Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.MistakeTypeCategoryImpl#getMistaketype <em>Mistaketype</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeTypeCategoryImpl#getSupercategory <em>Supercategory</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeTypeCategoryImpl#getSubcategories <em>Subcategories</em>}</li>
 *   <li>{@link modelingassistant.impl.MistakeTypeCategoryImpl#getModelingassistant <em>Modelingassistant</em>}</li>
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
   * The cached value of the '{@link #getSubcategories() <em>Subcategories</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubcategories()
   * @generated
   * @ordered
   */
  protected EList<MistakeTypeCategory> subcategories;

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
  public EList<MistakeTypeCategory> getSubcategories() {
    if (subcategories == null) {
      subcategories = new EObjectWithInverseResolvingEList<MistakeTypeCategory>(MistakeTypeCategory.class, this, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY);
    }
    return subcategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingAssistant getModelingassistant() {
    if (eContainerFeatureID() != ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MODELINGASSISTANT) return null;
    return (ModelingAssistant)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelingassistant(ModelingAssistant newModelingassistant, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newModelingassistant, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MODELINGASSISTANT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelingassistant(ModelingAssistant newModelingassistant) {
    if (newModelingassistant != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MODELINGASSISTANT && newModelingassistant != null)) {
      if (EcoreUtil.isAncestor(this, newModelingassistant))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newModelingassistant != null)
        msgs = ((InternalEObject)newModelingassistant).eInverseAdd(this, ModelingassistantPackage.MODELING_ASSISTANT__MISTAKETYPECATEGORY, ModelingAssistant.class, msgs);
      msgs = basicSetModelingassistant(newModelingassistant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MODELINGASSISTANT, newModelingassistant, newModelingassistant));
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
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubcategories()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MODELINGASSISTANT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetModelingassistant((ModelingAssistant)otherEnd, msgs);
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
        return ((InternalEList<?>)getSubcategories()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MODELINGASSISTANT:
        return basicSetModelingassistant(null, msgs);
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
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MODELINGASSISTANT:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__MISTAKETYPECATEGORY, ModelingAssistant.class, msgs);
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
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MISTAKETYPE:
        return getMistaketype();
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY:
        if (resolve) return getSupercategory();
        return basicGetSupercategory();
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES:
        return getSubcategories();
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MODELINGASSISTANT:
        return getModelingassistant();
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
        getSubcategories().clear();
        getSubcategories().addAll((Collection<? extends MistakeTypeCategory>)newValue);
        return;
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MODELINGASSISTANT:
        setModelingassistant((ModelingAssistant)newValue);
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
        getSubcategories().clear();
        return;
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MODELINGASSISTANT:
        setModelingassistant((ModelingAssistant)null);
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
        return subcategories != null && !subcategories.isEmpty();
      case ModelingassistantPackage.MISTAKE_TYPE_CATEGORY__MODELINGASSISTANT:
        return getModelingassistant() != null;
    }
    return super.eIsSet(featureID);
  }

} //MistakeTypeCategoryImpl
