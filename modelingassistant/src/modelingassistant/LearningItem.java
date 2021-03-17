/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Learning Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.LearningItem#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.LearningItem#getUmlElements <em>Uml Elements</em>}</li>
 *   <li>{@link modelingassistant.LearningItem#getLearningResources <em>Learning Resources</em>}</li>
 *   <li>{@link modelingassistant.LearningItem#getMistakeTypes <em>Mistake Types</em>}</li>
 *   <li>{@link modelingassistant.LearningItem#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getLearningItem()
 * @model
 * @generated
 */
public interface LearningItem extends NamedElement {
  /**
   * Returns the value of the '<em><b>Modeling Assistant</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ModelingAssistant#getLearningItems <em>Learning Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modeling Assistant</em>' container reference.
   * @see #setModelingAssistant(ModelingAssistant)
   * @see modelingassistant.ModelingassistantPackage#getLearningItem_ModelingAssistant()
   * @see modelingassistant.ModelingAssistant#getLearningItems
   * @model opposite="learningItems" required="true" transient="false"
   * @generated
   */
  ModelingAssistant getModelingAssistant();

  /**
   * Sets the value of the '{@link modelingassistant.LearningItem#getModelingAssistant <em>Modeling Assistant</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modeling Assistant</em>' container reference.
   * @see #getModelingAssistant()
   * @generated
   */
  void setModelingAssistant(ModelingAssistant value);

  /**
   * Returns the value of the '<em><b>Uml Elements</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.UmlElement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.UmlElement#getLearningItems <em>Learning Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uml Elements</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getLearningItem_UmlElements()
   * @see modelingassistant.UmlElement#getLearningItems
   * @model opposite="learningItems"
   * @generated
   */
  EList<UmlElement> getUmlElements();

  /**
   * Returns the value of the '<em><b>Learning Resources</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.LearningResource}.
   * It is bidirectional and its opposite is '{@link modelingassistant.LearningResource#getLearningItem <em>Learning Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Resources</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getLearningItem_LearningResources()
   * @see modelingassistant.LearningResource#getLearningItem
   * @model opposite="learningItem"
   * @generated
   */
  EList<LearningResource> getLearningResources();

  /**
   * Returns the value of the '<em><b>Mistake Types</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.MistakeType}.
   * It is bidirectional and its opposite is '{@link modelingassistant.MistakeType#getLearningItem <em>Learning Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake Types</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getLearningItem_MistakeTypes()
   * @see modelingassistant.MistakeType#getLearningItem
   * @model opposite="learningItem"
   * @generated
   */
  EList<MistakeType> getMistakeTypes();

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see modelingassistant.ModelingassistantPackage#getLearningItem_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link modelingassistant.LearningItem#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

} // LearningItem
