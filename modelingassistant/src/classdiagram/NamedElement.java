/**
 */
package classdiagram;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.NamedElement#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getNamedElement()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='validName'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot validName='Tuple {\n\tmessage : String = \'Name of elements may not be empty\',\n\tstatus : Boolean = if self.oclIsTypeOf(AssociationEnd) and self.oclAsType(AssociationEnd).navigable = false then true else self.name &lt;&gt; \'\' endif\n}.status'"
 * @generated
 */
public interface NamedElement extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see classdiagram.ClassdiagramPackage#getNamedElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link classdiagram.NamedElement#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // NamedElement
