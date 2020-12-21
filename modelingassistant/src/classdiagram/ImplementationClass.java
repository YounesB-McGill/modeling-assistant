/**
 */
package classdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implementation Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.ImplementationClass#getInstanceClassName <em>Instance Class Name</em>}</li>
 *   <li>{@link classdiagram.ImplementationClass#isInterface <em>Interface</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getImplementationClass()
 * @model
 * @generated
 */
public interface ImplementationClass extends Classifier {
  /**
   * Returns the value of the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instance Class Name</em>' attribute.
   * @see #setInstanceClassName(String)
   * @see classdiagram.ClassdiagramPackage#getImplementationClass_InstanceClassName()
   * @model required="true"
   * @generated
   */
  String getInstanceClassName();

  /**
   * Sets the value of the '{@link classdiagram.ImplementationClass#getInstanceClassName <em>Instance Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instance Class Name</em>' attribute.
   * @see #getInstanceClassName()
   * @generated
   */
  void setInstanceClassName(String value);

  /**
   * Returns the value of the '<em><b>Interface</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interface</em>' attribute.
   * @see #setInterface(boolean)
   * @see classdiagram.ClassdiagramPackage#getImplementationClass_Interface()
   * @model default="false" required="true"
   * @generated
   */
  boolean isInterface();

  /**
   * Sets the value of the '{@link classdiagram.ImplementationClass#isInterface <em>Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interface</em>' attribute.
   * @see #isInterface()
   * @generated
   */
  void setInterface(boolean value);

} // ImplementationClass
