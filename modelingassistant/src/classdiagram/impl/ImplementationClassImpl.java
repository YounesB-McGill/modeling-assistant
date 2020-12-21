/**
 */
package classdiagram.impl;

import classdiagram.ClassdiagramPackage;
import classdiagram.ImplementationClass;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implementation Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.impl.ImplementationClassImpl#getInstanceClassName <em>Instance Class Name</em>}</li>
 *   <li>{@link classdiagram.impl.ImplementationClassImpl#isInterface <em>Interface</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImplementationClassImpl extends ClassifierImpl implements ImplementationClass {
  /**
   * The default value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstanceClassName()
   * @generated
   * @ordered
   */
  protected static final String INSTANCE_CLASS_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstanceClassName()
   * @generated
   * @ordered
   */
  protected String instanceClassName = INSTANCE_CLASS_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #isInterface() <em>Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInterface()
   * @generated
   * @ordered
   */
  protected static final boolean INTERFACE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isInterface() <em>Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInterface()
   * @generated
   * @ordered
   */
  protected boolean interface_ = INTERFACE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImplementationClassImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ClassdiagramPackage.Literals.IMPLEMENTATION_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getInstanceClassName() {
    return instanceClassName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInstanceClassName(String newInstanceClassName) {
    String oldInstanceClassName = instanceClassName;
    instanceClassName = newInstanceClassName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.IMPLEMENTATION_CLASS__INSTANCE_CLASS_NAME, oldInstanceClassName, instanceClassName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isInterface() {
    return interface_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInterface(boolean newInterface) {
    boolean oldInterface = interface_;
    interface_ = newInterface;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.IMPLEMENTATION_CLASS__INTERFACE, oldInterface, interface_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ClassdiagramPackage.IMPLEMENTATION_CLASS__INSTANCE_CLASS_NAME:
        return getInstanceClassName();
      case ClassdiagramPackage.IMPLEMENTATION_CLASS__INTERFACE:
        return isInterface();
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
      case ClassdiagramPackage.IMPLEMENTATION_CLASS__INSTANCE_CLASS_NAME:
        setInstanceClassName((String)newValue);
        return;
      case ClassdiagramPackage.IMPLEMENTATION_CLASS__INTERFACE:
        setInterface((Boolean)newValue);
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
      case ClassdiagramPackage.IMPLEMENTATION_CLASS__INSTANCE_CLASS_NAME:
        setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
        return;
      case ClassdiagramPackage.IMPLEMENTATION_CLASS__INTERFACE:
        setInterface(INTERFACE_EDEFAULT);
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
      case ClassdiagramPackage.IMPLEMENTATION_CLASS__INSTANCE_CLASS_NAME:
        return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
      case ClassdiagramPackage.IMPLEMENTATION_CLASS__INTERFACE:
        return interface_ != INTERFACE_EDEFAULT;
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
    result.append(" (instanceClassName: ");
    result.append(instanceClassName);
    result.append(", interface: ");
    result.append(interface_);
    result.append(')');
    return result.toString();
  }

} //ImplementationClassImpl
