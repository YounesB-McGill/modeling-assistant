/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mistake Type Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.MistakeTypeCategory#getMistaketype <em>Mistaketype</em>}</li>
 *   <li>{@link modelingassistant.MistakeTypeCategory#getSupercategory <em>Supercategory</em>}</li>
 *   <li>{@link modelingassistant.MistakeTypeCategory#getSubcategories <em>Subcategories</em>}</li>
 *   <li>{@link modelingassistant.MistakeTypeCategory#getModelingassistant <em>Modelingassistant</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getMistakeTypeCategory()
 * @model
 * @generated
 */
public interface MistakeTypeCategory extends NamedElement {
  /**
   * Returns the value of the '<em><b>Mistaketype</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.MistakeType}.
   * It is bidirectional and its opposite is '{@link modelingassistant.MistakeType#getMistaketypecategory <em>Mistaketypecategory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistaketype</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getMistakeTypeCategory_Mistaketype()
   * @see modelingassistant.MistakeType#getMistaketypecategory
   * @model opposite="mistaketypecategory"
   * @generated
   */
  EList<MistakeType> getMistaketype();

  /**
   * Returns the value of the '<em><b>Supercategory</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.MistakeTypeCategory#getSubcategories <em>Subcategories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supercategory</em>' reference.
   * @see #setSupercategory(MistakeTypeCategory)
   * @see modelingassistant.ModelingassistantPackage#getMistakeTypeCategory_Supercategory()
   * @see modelingassistant.MistakeTypeCategory#getSubcategories
   * @model opposite="subcategories"
   * @generated
   */
  MistakeTypeCategory getSupercategory();

  /**
   * Sets the value of the '{@link modelingassistant.MistakeTypeCategory#getSupercategory <em>Supercategory</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Supercategory</em>' reference.
   * @see #getSupercategory()
   * @generated
   */
  void setSupercategory(MistakeTypeCategory value);

  /**
   * Returns the value of the '<em><b>Subcategories</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.MistakeTypeCategory#getSupercategory <em>Supercategory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subcategories</em>' reference.
   * @see #setSubcategories(MistakeTypeCategory)
   * @see modelingassistant.ModelingassistantPackage#getMistakeTypeCategory_Subcategories()
   * @see modelingassistant.MistakeTypeCategory#getSupercategory
   * @model opposite="supercategory"
   * @generated
   */
  MistakeTypeCategory getSubcategories();

  /**
   * Sets the value of the '{@link modelingassistant.MistakeTypeCategory#getSubcategories <em>Subcategories</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subcategories</em>' reference.
   * @see #getSubcategories()
   * @generated
   */
  void setSubcategories(MistakeTypeCategory value);

  /**
   * Returns the value of the '<em><b>Modelingassistant</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ModelingAssistant#getMistaketypecategory <em>Mistaketypecategory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modelingassistant</em>' container reference.
   * @see #setModelingassistant(ModelingAssistant)
   * @see modelingassistant.ModelingassistantPackage#getMistakeTypeCategory_Modelingassistant()
   * @see modelingassistant.ModelingAssistant#getMistaketypecategory
   * @model opposite="mistaketypecategory" required="true" transient="false"
   * @generated
   */
  ModelingAssistant getModelingassistant();

  /**
   * Sets the value of the '{@link modelingassistant.MistakeTypeCategory#getModelingassistant <em>Modelingassistant</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modelingassistant</em>' container reference.
   * @see #getModelingassistant()
   * @generated
   */
  void setModelingassistant(ModelingAssistant value);

} // MistakeTypeCategory
