/**
 */
package classdiagram;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.Layout#getContainers <em>Containers</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getLayout()
 * @model
 * @generated
 */
public interface Layout extends EObject {
  /**
   * Returns the value of the '<em><b>Containers</b></em>' map.
   * The key is of type {@link org.eclipse.emf.ecore.EObject},
   * and the value is of type list of {@link java.util.Map.Entry<org.eclipse.emf.ecore.EObject, classdiagram.LayoutElement>},
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Containers</em>' map.
   * @see classdiagram.ClassdiagramPackage#getLayout_Containers()
   * @model mapType="classdiagram.ContainerMap&lt;org.eclipse.emf.ecore.EObject, classdiagram.ElementMap&gt;"
   * @generated
   */
  EMap<EObject, EMap<EObject, LayoutElement>> getContainers();

} // Layout
