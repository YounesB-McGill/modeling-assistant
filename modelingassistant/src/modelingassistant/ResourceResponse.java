/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.ResourceResponse#getLearningResources <em>Learning Resources</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getResourceResponse()
 * @model
 * @generated
 */
public interface ResourceResponse extends Feedback {
  /**
   * Returns the value of the '<em><b>Learning Resources</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.LearningResource}.
   * It is bidirectional and its opposite is '{@link modelingassistant.LearningResource#getResourceResponses <em>Resource Responses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Resources</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getResourceResponse_LearningResources()
   * @see modelingassistant.LearningResource#getResourceResponses
   * @model opposite="resourceResponses" required="true"
   * @generated
   */
  EList<LearningResource> getLearningResources();

} // ResourceResponse
