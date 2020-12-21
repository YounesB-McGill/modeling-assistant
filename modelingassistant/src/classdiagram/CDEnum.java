/**
 */
package classdiagram;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CD Enum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.CDEnum#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getCDEnum()
 * @model
 * @generated
 */
public interface CDEnum extends PrimitiveType {
  /**
   * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
   * The list contents are of type {@link classdiagram.CDEnumLiteral}.
   * It is bidirectional and its opposite is '{@link classdiagram.CDEnumLiteral#getEnum <em>Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literals</em>' containment reference list.
   * @see classdiagram.ClassdiagramPackage#getCDEnum_Literals()
   * @see classdiagram.CDEnumLiteral#getEnum
   * @model opposite="enum" containment="true" required="true"
   * @generated
   */
  EList<CDEnumLiteral> getLiterals();

} // CDEnum
