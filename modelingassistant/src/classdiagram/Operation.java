/**
 */
package classdiagram;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.Operation#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link classdiagram.Operation#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link classdiagram.Operation#isStatic <em>Static</em>}</li>
 *   <li>{@link classdiagram.Operation#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link classdiagram.Operation#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link classdiagram.Operation#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getOperation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='correctVisibility'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot correctVisibility='Tuple {\n\tmessage : String = \'COREVisibility and Visibility attributes are not in sync\',\n\tstatus : Boolean = if visibility = VisibilityType::public then visibility = VisibilityType::public else visibility &lt;&gt; VisibilityType::public endif\n}.status'"
 * @generated
 */
public interface Operation extends NamedElement {
  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see classdiagram.ClassdiagramPackage#getOperation_Abstract()
   * @model default="false" required="true"
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link classdiagram.Operation#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * The default value is <code>"public"</code>.
   * The literals are from the enumeration {@link classdiagram.VisibilityType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see classdiagram.VisibilityType
   * @see #setVisibility(VisibilityType)
   * @see classdiagram.ClassdiagramPackage#getOperation_Visibility()
   * @model default="public"
   * @generated
   */
  VisibilityType getVisibility();

  /**
   * Sets the value of the '{@link classdiagram.Operation#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see classdiagram.VisibilityType
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(VisibilityType value);

  /**
   * Returns the value of the '<em><b>Static</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Static</em>' attribute.
   * @see #setStatic(boolean)
   * @see classdiagram.ClassdiagramPackage#getOperation_Static()
   * @model default="false" required="true"
   * @generated
   */
  boolean isStatic();

  /**
   * Sets the value of the '{@link classdiagram.Operation#isStatic <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Static</em>' attribute.
   * @see #isStatic()
   * @generated
   */
  void setStatic(boolean value);

  /**
   * Returns the value of the '<em><b>Operation Type</b></em>' attribute.
   * The default value is <code>"Normal"</code>.
   * The literals are from the enumeration {@link classdiagram.OperationType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation Type</em>' attribute.
   * @see classdiagram.OperationType
   * @see #setOperationType(OperationType)
   * @see classdiagram.ClassdiagramPackage#getOperation_OperationType()
   * @model default="Normal" required="true"
   * @generated
   */
  OperationType getOperationType();

  /**
   * Sets the value of the '{@link classdiagram.Operation#getOperationType <em>Operation Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation Type</em>' attribute.
   * @see classdiagram.OperationType
   * @see #getOperationType()
   * @generated
   */
  void setOperationType(OperationType value);

  /**
   * Returns the value of the '<em><b>Return Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return Type</em>' reference.
   * @see #setReturnType(Type)
   * @see classdiagram.ClassdiagramPackage#getOperation_ReturnType()
   * @model required="true"
   * @generated
   */
  Type getReturnType();

  /**
   * Sets the value of the '{@link classdiagram.Operation#getReturnType <em>Return Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return Type</em>' reference.
   * @see #getReturnType()
   * @generated
   */
  void setReturnType(Type value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link classdiagram.Parameter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see classdiagram.ClassdiagramPackage#getOperation_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParameters();

} // Operation
