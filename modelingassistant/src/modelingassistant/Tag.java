/**
 */
package modelingassistant;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.Tag#getSolutionelement <em>Solutionelement</em>}</li>
 *   <li>{@link modelingassistant.Tag#getTagGroup <em>Tag Group</em>}</li>
 *   <li>{@link modelingassistant.Tag#getTagType <em>Tag Type</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getTag()
 * @model
 * @generated
 */
public interface Tag extends EObject {
  /**
   * Returns the value of the '<em><b>Solutionelement</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.SolutionElement#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solutionelement</em>' container reference.
   * @see #setSolutionelement(SolutionElement)
   * @see modelingassistant.ModelingassistantPackage#getTag_Solutionelement()
   * @see modelingassistant.SolutionElement#getTags
   * @model opposite="tags" required="true" transient="false"
   * @generated
   */
  SolutionElement getSolutionelement();

  /**
   * Sets the value of the '{@link modelingassistant.Tag#getSolutionelement <em>Solutionelement</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Solutionelement</em>' container reference.
   * @see #getSolutionelement()
   * @generated
   */
  void setSolutionelement(SolutionElement value);

  /**
   * Returns the value of the '<em><b>Tag Group</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.TagGroup#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tag Group</em>' reference.
   * @see #setTagGroup(TagGroup)
   * @see modelingassistant.ModelingassistantPackage#getTag_TagGroup()
   * @see modelingassistant.TagGroup#getTags
   * @model opposite="tags" required="true"
   * @generated
   */
  TagGroup getTagGroup();

  /**
   * Sets the value of the '{@link modelingassistant.Tag#getTagGroup <em>Tag Group</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tag Group</em>' reference.
   * @see #getTagGroup()
   * @generated
   */
  void setTagGroup(TagGroup value);

  /**
   * Returns the value of the '<em><b>Tag Type</b></em>' attribute.
   * The literals are from the enumeration {@link modelingassistant.TagType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tag Type</em>' attribute.
   * @see modelingassistant.TagType
   * @see #setTagType(TagType)
   * @see modelingassistant.ModelingassistantPackage#getTag_TagType()
   * @model
   * @generated
   */
  TagType getTagType();

  /**
   * Sets the value of the '{@link modelingassistant.Tag#getTagType <em>Tag Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tag Type</em>' attribute.
   * @see modelingassistant.TagType
   * @see #getTagType()
   * @generated
   */
  void setTagType(TagType value);

} // Tag
