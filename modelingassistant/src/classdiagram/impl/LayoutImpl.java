/**
 */
package classdiagram.impl;

import classdiagram.ClassdiagramPackage;
import classdiagram.Layout;
import classdiagram.LayoutElement;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.impl.LayoutImpl#getContainers <em>Containers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LayoutImpl extends MinimalEObjectImpl.Container implements Layout {
  /**
   * The cached value of the '{@link #getContainers() <em>Containers</em>}' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContainers()
   * @generated
   * @ordered
   */
  protected EMap<EObject, EMap<EObject, LayoutElement>> containers;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LayoutImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ClassdiagramPackage.Literals.LAYOUT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMap<EObject, EMap<EObject, LayoutElement>> getContainers() {
    if (containers == null) {
      containers = new EcoreEMap<EObject,EMap<EObject, LayoutElement>>(ClassdiagramPackage.Literals.CONTAINER_MAP, ContainerMapImpl.class, this, ClassdiagramPackage.LAYOUT__CONTAINERS);
    }
    return containers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ClassdiagramPackage.LAYOUT__CONTAINERS:
        return ((InternalEList<?>)getContainers()).basicRemove(otherEnd, msgs);
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
      case ClassdiagramPackage.LAYOUT__CONTAINERS:
        if (coreType) return getContainers();
        else return getContainers().map();
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
      case ClassdiagramPackage.LAYOUT__CONTAINERS:
        ((EStructuralFeature.Setting)getContainers()).set(newValue);
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
      case ClassdiagramPackage.LAYOUT__CONTAINERS:
        getContainers().clear();
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
      case ClassdiagramPackage.LAYOUT__CONTAINERS:
        return containers != null && !containers.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //LayoutImpl
