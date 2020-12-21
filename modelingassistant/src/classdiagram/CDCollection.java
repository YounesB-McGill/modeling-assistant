/**
 */
package classdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CD Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.CDCollection#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getCDCollection()
 * @model abstract="true"
 * @generated
 */
public interface CDCollection extends ImplementationClass {
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(Type)
   * @see classdiagram.ClassdiagramPackage#getCDCollection_Type()
   * @model required="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link classdiagram.CDCollection#getType <em>Type</em>}' reference.
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
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='let typeName : String = self.oclType().toString() in \n                    let name : String = typeName.substring(typeName.lastIndexOf(\':\') + 2, typeName.size()) in \n                        if type.name.oclIsUndefined() then name \n                        else name + \'&lt;\' + type.name + \'&gt;\' endif'"
   * @generated
   */
  String getName();

} // CDCollection
