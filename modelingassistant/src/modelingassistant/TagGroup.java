/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.TagGroup#getTags <em>Tags</em>}</li>
 *   <li>{@link modelingassistant.TagGroup#getSolution <em>Solution</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getTagGroup()
 * @model
 * @generated
 */
public interface TagGroup extends EObject {
  /**
   * Returns the value of the '<em><b>Tags</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Tag}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Tag#getTagGroup <em>Tag Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tags</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getTagGroup_Tags()
   * @see modelingassistant.Tag#getTagGroup
   * @model opposite="tagGroup"
   * @generated
   */
  EList<Tag> getTags();

  /**
   * Returns the value of the '<em><b>Solution</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Solution#getTagGroups <em>Tag Groups</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution</em>' container reference.
   * @see #setSolution(Solution)
   * @see modelingassistant.ModelingassistantPackage#getTagGroup_Solution()
   * @see modelingassistant.Solution#getTagGroups
   * @model opposite="tagGroups" required="true" transient="false"
   * @generated
   */
  Solution getSolution();

  /**
   * Sets the value of the '{@link modelingassistant.TagGroup#getSolution <em>Solution</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Solution</em>' container reference.
   * @see #getSolution()
   * @generated
   */
  void setSolution(Solution value);

} // TagGroup
