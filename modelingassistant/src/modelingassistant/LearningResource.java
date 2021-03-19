/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Learning Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.LearningResource#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.LearningResource#getLearningItem <em>Learning Item</em>}</li>
 *   <li>{@link modelingassistant.LearningResource#getResourceResponses <em>Resource Responses</em>}</li>
 *   <li>{@link modelingassistant.LearningResource#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getLearningResource()
 * @model
 * @generated
 */
public interface LearningResource extends NamedElement {
  /**
   * Returns the value of the '<em><b>Modeling Assistant</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ModelingAssistant#getLearningResources <em>Learning Resources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modeling Assistant</em>' container reference.
   * @see #setModelingAssistant(ModelingAssistant)
   * @see modelingassistant.ModelingassistantPackage#getLearningResource_ModelingAssistant()
   * @see modelingassistant.ModelingAssistant#getLearningResources
   * @model opposite="learningResources" required="true" transient="false"
   * @generated
   */
  ModelingAssistant getModelingAssistant();

  /**
   * Sets the value of the '{@link modelingassistant.LearningResource#getModelingAssistant <em>Modeling Assistant</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modeling Assistant</em>' container reference.
   * @see #getModelingAssistant()
   * @generated
   */
  void setModelingAssistant(ModelingAssistant value);

  /**
   * Returns the value of the '<em><b>Learning Item</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.LearningItem#getLearningResources <em>Learning Resources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Item</em>' reference.
   * @see #setLearningItem(LearningItem)
   * @see modelingassistant.ModelingassistantPackage#getLearningResource_LearningItem()
   * @see modelingassistant.LearningItem#getLearningResources
   * @model opposite="learningResources" required="true"
   * @generated
   */
  LearningItem getLearningItem();

  /**
   * Sets the value of the '{@link modelingassistant.LearningResource#getLearningItem <em>Learning Item</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Learning Item</em>' reference.
   * @see #getLearningItem()
   * @generated
   */
  void setLearningItem(LearningItem value);

  /**
   * Returns the value of the '<em><b>Resource Responses</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.ResourceResponse}.
   * It is bidirectional and its opposite is '{@link modelingassistant.ResourceResponse#getLearningResources <em>Learning Resources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Resource Responses</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getLearningResource_ResourceResponses()
   * @see modelingassistant.ResourceResponse#getLearningResources
   * @model opposite="learningResources"
   * @generated
   */
  EList<ResourceResponse> getResourceResponses();

  /**
   * Returns the value of the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' attribute.
   * @see #setContent(Object)
   * @see modelingassistant.ModelingassistantPackage#getLearningResource_Content()
   * @model
   * @generated
   */
  Object getContent();

  /**
   * Sets the value of the '{@link modelingassistant.LearningResource#getContent <em>Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Content</em>' attribute.
   * @see #getContent()
   * @generated
   */
  void setContent(Object value);

} // LearningResource
