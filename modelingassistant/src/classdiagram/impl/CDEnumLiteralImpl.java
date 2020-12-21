/**
 */
package classdiagram.impl;

import classdiagram.CDEnum;
import classdiagram.CDEnumLiteral;
import classdiagram.ClassdiagramPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CD Enum Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.impl.CDEnumLiteralImpl#getEnum <em>Enum</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CDEnumLiteralImpl extends NamedElementImpl implements CDEnumLiteral {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CDEnumLiteralImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ClassdiagramPackage.Literals.CD_ENUM_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CDEnum getEnum() {
    if (eContainerFeatureID() != ClassdiagramPackage.CD_ENUM_LITERAL__ENUM) return null;
    return (CDEnum)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnum(CDEnum newEnum, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newEnum, ClassdiagramPackage.CD_ENUM_LITERAL__ENUM, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnum(CDEnum newEnum) {
    if (newEnum != eInternalContainer() || (eContainerFeatureID() != ClassdiagramPackage.CD_ENUM_LITERAL__ENUM && newEnum != null)) {
      if (EcoreUtil.isAncestor(this, newEnum))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newEnum != null)
        msgs = ((InternalEObject)newEnum).eInverseAdd(this, ClassdiagramPackage.CD_ENUM__LITERALS, CDEnum.class, msgs);
      msgs = basicSetEnum(newEnum, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.CD_ENUM_LITERAL__ENUM, newEnum, newEnum));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ClassdiagramPackage.CD_ENUM_LITERAL__ENUM:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetEnum((CDEnum)otherEnd, msgs);
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
      case ClassdiagramPackage.CD_ENUM_LITERAL__ENUM:
        return basicSetEnum(null, msgs);
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
      case ClassdiagramPackage.CD_ENUM_LITERAL__ENUM:
        return eInternalContainer().eInverseRemove(this, ClassdiagramPackage.CD_ENUM__LITERALS, CDEnum.class, msgs);
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
      case ClassdiagramPackage.CD_ENUM_LITERAL__ENUM:
        return getEnum();
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
      case ClassdiagramPackage.CD_ENUM_LITERAL__ENUM:
        setEnum((CDEnum)newValue);
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
      case ClassdiagramPackage.CD_ENUM_LITERAL__ENUM:
        setEnum((CDEnum)null);
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
      case ClassdiagramPackage.CD_ENUM_LITERAL__ENUM:
        return getEnum() != null;
    }
    return super.eIsSet(featureID);
  }

} //CDEnumLiteralImpl
