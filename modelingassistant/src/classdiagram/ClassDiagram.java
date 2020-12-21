/**
 */
package classdiagram;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.ClassDiagram#getClasses <em>Classes</em>}</li>
 *   <li>{@link classdiagram.ClassDiagram#getTypes <em>Types</em>}</li>
 *   <li>{@link classdiagram.ClassDiagram#getAssociations <em>Associations</em>}</li>
 *   <li>{@link classdiagram.ClassDiagram#getNotes <em>Notes</em>}</li>
 *   <li>{@link classdiagram.ClassDiagram#getLayout <em>Layout</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getClassDiagram()
 * @model
 * @generated
 */
public interface ClassDiagram extends NamedElement {
  /**
   * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
   * The list contents are of type {@link classdiagram.Classifier}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classes</em>' containment reference list.
   * @see classdiagram.ClassdiagramPackage#getClassDiagram_Classes()
   * @model containment="true"
   * @generated
   */
  EList<Classifier> getClasses();

  /**
   * Returns the value of the '<em><b>Types</b></em>' containment reference list.
   * The list contents are of type {@link classdiagram.Type}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' containment reference list.
   * @see classdiagram.ClassdiagramPackage#getClassDiagram_Types()
   * @model containment="true"
   * @generated
   */
  EList<Type> getTypes();

  /**
   * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
   * The list contents are of type {@link classdiagram.Association}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Associations</em>' containment reference list.
   * @see classdiagram.ClassdiagramPackage#getClassDiagram_Associations()
   * @model containment="true"
   * @generated
   */
  EList<Association> getAssociations();

  /**
   * Returns the value of the '<em><b>Notes</b></em>' containment reference list.
   * The list contents are of type {@link classdiagram.Note}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Notes</em>' containment reference list.
   * @see classdiagram.ClassdiagramPackage#getClassDiagram_Notes()
   * @model containment="true"
   * @generated
   */
  EList<Note> getNotes();

  /**
   * Returns the value of the '<em><b>Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Layout</em>' containment reference.
   * @see #setLayout(Layout)
   * @see classdiagram.ClassdiagramPackage#getClassDiagram_Layout()
   * @model containment="true"
   * @generated
   */
  Layout getLayout();

  /**
   * Sets the value of the '{@link classdiagram.ClassDiagram#getLayout <em>Layout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Layout</em>' containment reference.
   * @see #getLayout()
   * @generated
   */
  void setLayout(Layout value);

} // ClassDiagram
