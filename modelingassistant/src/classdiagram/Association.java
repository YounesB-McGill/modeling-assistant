/**
 */
package classdiagram;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.Association#getEnds <em>Ends</em>}</li>
 *   <li>{@link classdiagram.Association#getAssociationClass <em>Association Class</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends NamedElement {
  /**
   * Returns the value of the '<em><b>Ends</b></em>' reference list.
   * The list contents are of type {@link classdiagram.AssociationEnd}.
   * It is bidirectional and its opposite is '{@link classdiagram.AssociationEnd#getAssoc <em>Assoc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ends</em>' reference list.
   * @see classdiagram.ClassdiagramPackage#getAssociation_Ends()
   * @see classdiagram.AssociationEnd#getAssoc
   * @model opposite="assoc" lower="2"
   * @generated
   */
  EList<AssociationEnd> getEnds();

  /**
   * Returns the value of the '<em><b>Association Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association Class</em>' reference.
   * @see #setAssociationClass(classdiagram.Class)
   * @see classdiagram.ClassdiagramPackage#getAssociation_AssociationClass()
   * @model
   * @generated
   */
  classdiagram.Class getAssociationClass();

  /**
   * Sets the value of the '{@link classdiagram.Association#getAssociationClass <em>Association Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Association Class</em>' reference.
   * @see #getAssociationClass()
   * @generated
   */
  void setAssociationClass(classdiagram.Class value);

} // Association
