/**
 */
package classdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CD Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.CDArray#getSize <em>Size</em>}</li>
 *   <li>{@link classdiagram.CDArray#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getCDArray()
 * @model
 * @generated
 */
public interface CDArray extends PrimitiveType {
  /**
   * Returns the value of the '<em><b>Size</b></em>' attribute.
   * The default value is <code>"-1"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Size</em>' attribute.
   * @see #setSize(int)
   * @see classdiagram.ClassdiagramPackage#getCDArray_Size()
   * @model default="-1" required="true"
   * @generated
   */
  int getSize();

  /**
   * Sets the value of the '{@link classdiagram.CDArray#getSize <em>Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Size</em>' attribute.
   * @see #getSize()
   * @generated
   */
  void setSize(int value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(Type)
   * @see classdiagram.ClassdiagramPackage#getCDArray_Type()
   * @model required="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link classdiagram.CDArray#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='if (self.type &lt;&gt; null and self.type.name &lt;&gt; null) then self.type.name + \'[\' + if (self.size &gt;= 0) then self.size.toString() else \'\' endif + \']\' else null endif'"
   * @generated
   */
  String getName();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\'java.lang.reflect.Array\''"
   * @generated
   */
  String getInstanceClassName();

} // CDArray
