/**
 */
package classdiagram;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layout Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.LayoutElement#getX <em>X</em>}</li>
 *   <li>{@link classdiagram.LayoutElement#getY <em>Y</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getLayoutElement()
 * @model
 * @generated
 */
public interface LayoutElement extends EObject {
  /**
   * Returns the value of the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>X</em>' attribute.
   * @see #setX(float)
   * @see classdiagram.ClassdiagramPackage#getLayoutElement_X()
   * @model required="true"
   * @generated
   */
  float getX();

  /**
   * Sets the value of the '{@link classdiagram.LayoutElement#getX <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>X</em>' attribute.
   * @see #getX()
   * @generated
   */
  void setX(float value);

  /**
   * Returns the value of the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Y</em>' attribute.
   * @see #setY(float)
   * @see classdiagram.ClassdiagramPackage#getLayoutElement_Y()
   * @model required="true"
   * @generated
   */
  float getY();

  /**
   * Sets the value of the '{@link classdiagram.LayoutElement#getY <em>Y</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Y</em>' attribute.
   * @see #getY()
   * @generated
   */
  void setY(float value);

} // LayoutElement
