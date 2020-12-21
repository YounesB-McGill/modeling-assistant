/**
 */
package classdiagram.impl;

import classdiagram.ClassdiagramPackage;
import classdiagram.ObjectType;
import classdiagram.TypeParameter;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.impl.TypeParameterImpl#getGenericType <em>Generic Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeParameterImpl extends TypeImpl implements TypeParameter {
  /**
   * The cached value of the '{@link #getGenericType() <em>Generic Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenericType()
   * @generated
   * @ordered
   */
  protected ObjectType genericType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeParameterImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ClassdiagramPackage.Literals.TYPE_PARAMETER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectType getGenericType() {
    if (genericType != null && genericType.eIsProxy()) {
      InternalEObject oldGenericType = (InternalEObject)genericType;
      genericType = (ObjectType)eResolveProxy(oldGenericType);
      if (genericType != oldGenericType) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramPackage.TYPE_PARAMETER__GENERIC_TYPE, oldGenericType, genericType));
      }
    }
    return genericType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectType basicGetGenericType() {
    return genericType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGenericType(ObjectType newGenericType) {
    ObjectType oldGenericType = genericType;
    genericType = newGenericType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.TYPE_PARAMETER__GENERIC_TYPE, oldGenericType, genericType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ClassdiagramPackage.TYPE_PARAMETER__GENERIC_TYPE:
        if (resolve) return getGenericType();
        return basicGetGenericType();
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
      case ClassdiagramPackage.TYPE_PARAMETER__GENERIC_TYPE:
        setGenericType((ObjectType)newValue);
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
      case ClassdiagramPackage.TYPE_PARAMETER__GENERIC_TYPE:
        setGenericType((ObjectType)null);
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
      case ClassdiagramPackage.TYPE_PARAMETER__GENERIC_TYPE:
        return genericType != null;
    }
    return super.eIsSet(featureID);
  }

} //TypeParameterImpl
