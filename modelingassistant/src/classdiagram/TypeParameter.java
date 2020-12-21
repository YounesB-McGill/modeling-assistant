/**
 */
package classdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.TypeParameter#getGenericType <em>Generic Type</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getTypeParameter()
 * @model
 * @generated
 */
public interface TypeParameter extends Type {
  /**
   * Returns the value of the '<em><b>Generic Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generic Type</em>' reference.
   * @see #setGenericType(ObjectType)
   * @see classdiagram.ClassdiagramPackage#getTypeParameter_GenericType()
   * @model
   * @generated
   */
  ObjectType getGenericType();

  /**
   * Sets the value of the '{@link classdiagram.TypeParameter#getGenericType <em>Generic Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Generic Type</em>' reference.
   * @see #getGenericType()
   * @generated
   */
  void setGenericType(ObjectType value);

} // TypeParameter
