/**
 */
package classdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CD Enum Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.CDEnumLiteral#getEnum <em>Enum</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getCDEnumLiteral()
 * @model
 * @generated
 */
public interface CDEnumLiteral extends NamedElement {
  /**
   * Returns the value of the '<em><b>Enum</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link classdiagram.CDEnum#getLiterals <em>Literals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum</em>' container reference.
   * @see #setEnum(CDEnum)
   * @see classdiagram.ClassdiagramPackage#getCDEnumLiteral_Enum()
   * @see classdiagram.CDEnum#getLiterals
   * @model opposite="literals" required="true" transient="false"
   * @generated
   */
  CDEnum getEnum();

  /**
   * Sets the value of the '{@link classdiagram.CDEnumLiteral#getEnum <em>Enum</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enum</em>' container reference.
   * @see #getEnum()
   * @generated
   */
  void setEnum(CDEnum value);

} // CDEnumLiteral
