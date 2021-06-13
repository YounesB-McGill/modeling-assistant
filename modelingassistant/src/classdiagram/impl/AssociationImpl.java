/**
 */
package classdiagram.impl;

import classdiagram.Association;
import classdiagram.AssociationEnd;
import classdiagram.ClassdiagramPackage;

import java.util.Collection;

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
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.impl.AssociationImpl#getEnds <em>Ends</em>}</li>
 *   <li>{@link classdiagram.impl.AssociationImpl#getAssociationClass <em>Association Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssociationImpl extends NamedElementImpl implements Association {
  /**
   * The cached value of the '{@link #getEnds() <em>Ends</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnds()
   * @generated
   * @ordered
   */
  protected EList<AssociationEnd> ends;

  /**
   * The cached value of the '{@link #getAssociationClass() <em>Association Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociationClass()
   * @generated
   * @ordered
   */
  protected classdiagram.Class associationClass;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssociationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ClassdiagramPackage.Literals.ASSOCIATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AssociationEnd> getEnds() {
    if (ends == null) {
      ends = new EObjectWithInverseResolvingEList<AssociationEnd>(AssociationEnd.class, this, ClassdiagramPackage.ASSOCIATION__ENDS, ClassdiagramPackage.ASSOCIATION_END__ASSOC);
    }
    return ends;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public classdiagram.Class getAssociationClass() {
    if (associationClass != null && associationClass.eIsProxy()) {
      InternalEObject oldAssociationClass = (InternalEObject)associationClass;
      associationClass = (classdiagram.Class)eResolveProxy(oldAssociationClass);
      if (associationClass != oldAssociationClass) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramPackage.ASSOCIATION__ASSOCIATION_CLASS, oldAssociationClass, associationClass));
      }
    }
    return associationClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public classdiagram.Class basicGetAssociationClass() {
    return associationClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAssociationClass(classdiagram.Class newAssociationClass) {
    classdiagram.Class oldAssociationClass = associationClass;
    associationClass = newAssociationClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.ASSOCIATION__ASSOCIATION_CLASS, oldAssociationClass, associationClass));
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
      case ClassdiagramPackage.ASSOCIATION__ENDS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getEnds()).basicAdd(otherEnd, msgs);
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
      case ClassdiagramPackage.ASSOCIATION__ENDS:
        return ((InternalEList<?>)getEnds()).basicRemove(otherEnd, msgs);
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
      case ClassdiagramPackage.ASSOCIATION__ENDS:
        return getEnds();
      case ClassdiagramPackage.ASSOCIATION__ASSOCIATION_CLASS:
        if (resolve) return getAssociationClass();
        return basicGetAssociationClass();
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
      case ClassdiagramPackage.ASSOCIATION__ENDS:
        getEnds().clear();
        getEnds().addAll((Collection<? extends AssociationEnd>)newValue);
        return;
      case ClassdiagramPackage.ASSOCIATION__ASSOCIATION_CLASS:
        setAssociationClass((classdiagram.Class)newValue);
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
      case ClassdiagramPackage.ASSOCIATION__ENDS:
        getEnds().clear();
        return;
      case ClassdiagramPackage.ASSOCIATION__ASSOCIATION_CLASS:
        setAssociationClass((classdiagram.Class)null);
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
      case ClassdiagramPackage.ASSOCIATION__ENDS:
        return ends != null && !ends.isEmpty();
      case ClassdiagramPackage.ASSOCIATION__ASSOCIATION_CLASS:
        return associationClass != null;
    }
    return super.eIsSet(featureID);
  }

} //AssociationImpl
