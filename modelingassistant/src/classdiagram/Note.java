/**
 */
package classdiagram;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Note</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.Note#getNotedElement <em>Noted Element</em>}</li>
 *   <li>{@link classdiagram.Note#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getNote()
 * @model
 * @generated
 */
public interface Note extends EObject {
  /**
   * Returns the value of the '<em><b>Noted Element</b></em>' reference list.
   * The list contents are of type {@link classdiagram.NamedElement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Noted Element</em>' reference list.
   * @see classdiagram.ClassdiagramPackage#getNote_NotedElement()
   * @model
   * @generated
   */
  EList<NamedElement> getNotedElement();

  /**
   * Returns the value of the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' attribute.
   * @see #setContent(String)
   * @see classdiagram.ClassdiagramPackage#getNote_Content()
   * @model
   * @generated
   */
  String getContent();

  /**
   * Sets the value of the '{@link classdiagram.Note#getContent <em>Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Content</em>' attribute.
   * @see #getContent()
   * @generated
   */
  void setContent(String value);

} // Note
