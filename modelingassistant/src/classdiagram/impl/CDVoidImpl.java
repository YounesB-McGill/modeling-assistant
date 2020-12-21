/**
 */
package classdiagram.impl;

import classdiagram.CDVoid;
import classdiagram.ClassdiagramPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CD Void</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CDVoidImpl extends ObjectTypeImpl implements CDVoid {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CDVoidImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ClassdiagramPackage.Literals.CD_VOID;
  }

  /**
   * The cached invocation delegate for the '{@link #getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassdiagramPackage.Literals.CD_VOID___GET_NAME).getInvocationDelegate();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName() {
    try {
      return (String)GET_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    }
    catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case ClassdiagramPackage.CD_VOID___GET_NAME:
        return getName();
    }
    return super.eInvoke(operationID, arguments);
  }

} //CDVoidImpl
