/**
 */
package classdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.StructuralFeature#isStatic <em>Static</em>}</li>
 *   <li>{@link classdiagram.StructuralFeature#getVisibility <em>Visibility</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getStructuralFeature()
 * @model abstract="true"
 * @generated
 */
public interface StructuralFeature extends TypedElement {
  /**
   * Returns the value of the '<em><b>Static</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Static</em>' attribute.
   * @see #setStatic(boolean)
   * @see classdiagram.ClassdiagramPackage#getStructuralFeature_Static()
   * @model default="false" required="true"
   * @generated
   */
  boolean isStatic();

  /**
   * Sets the value of the '{@link classdiagram.StructuralFeature#isStatic <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Static</em>' attribute.
   * @see #isStatic()
   * @generated
   */
  void setStatic(boolean value);

  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * The default value is <code>"package"</code>.
   * The literals are from the enumeration {@link classdiagram.VisibilityType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see classdiagram.VisibilityType
   * @see #setVisibility(VisibilityType)
   * @see classdiagram.ClassdiagramPackage#getStructuralFeature_Visibility()
   * @model default="package"
   * @generated
   */
  VisibilityType getVisibility();

  /**
   * Sets the value of the '{@link classdiagram.StructuralFeature#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see classdiagram.VisibilityType
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(VisibilityType value);

} // StructuralFeature
