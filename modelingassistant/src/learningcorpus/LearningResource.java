/**
 */
package learningcorpus;

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
 *   <li>{@link learningcorpus.LearningResource#getLearningItem <em>Learning Item</em>}</li>
 *   <li>{@link learningcorpus.LearningResource#getResourceResponses <em>Resource Responses</em>}</li>
 *   <li>{@link learningcorpus.LearningResource#getContent <em>Content</em>}</li>
 *   <li>{@link learningcorpus.LearningResource#getLearningCorpus <em>Learning Corpus</em>}</li>
 * </ul>
 *
 * @see learningcorpus.LearningcorpusPackage#getLearningResource()
 * @model
 * @generated
 */
public interface LearningResource extends NamedElement {
  /**
   * Returns the value of the '<em><b>Learning Item</b></em>' reference.
   * It is bidirectional and its opposite is '{@link learningcorpus.LearningItem#getLearningResources <em>Learning Resources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Item</em>' reference.
   * @see #setLearningItem(LearningItem)
   * @see learningcorpus.LearningcorpusPackage#getLearningResource_LearningItem()
   * @see learningcorpus.LearningItem#getLearningResources
   * @model opposite="learningResources" required="true"
   * @generated
   */
  LearningItem getLearningItem();

  /**
   * Sets the value of the '{@link learningcorpus.LearningResource#getLearningItem <em>Learning Item</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Learning Item</em>' reference.
   * @see #getLearningItem()
   * @generated
   */
  void setLearningItem(LearningItem value);

  /**
   * Returns the value of the '<em><b>Resource Responses</b></em>' reference list.
   * The list contents are of type {@link learningcorpus.ResourceResponse}.
   * It is bidirectional and its opposite is '{@link learningcorpus.ResourceResponse#getLearningResources <em>Learning Resources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Resource Responses</em>' reference list.
   * @see learningcorpus.LearningcorpusPackage#getLearningResource_ResourceResponses()
   * @see learningcorpus.ResourceResponse#getLearningResources
   * @model opposite="learningResources"
   * @generated
   */
  EList<ResourceResponse> getResourceResponses();

  /**
   * Returns the value of the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' attribute.
   * @see #setContent(String)
   * @see learningcorpus.LearningcorpusPackage#getLearningResource_Content()
   * @model
   * @generated
   */
  String getContent();

  /**
   * Sets the value of the '{@link learningcorpus.LearningResource#getContent <em>Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Content</em>' attribute.
   * @see #getContent()
   * @generated
   */
  void setContent(String value);

  /**
   * Returns the value of the '<em><b>Learning Corpus</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link learningcorpus.LearningCorpus#getLearningResources <em>Learning Resources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Corpus</em>' container reference.
   * @see #setLearningCorpus(LearningCorpus)
   * @see learningcorpus.LearningcorpusPackage#getLearningResource_LearningCorpus()
   * @see learningcorpus.LearningCorpus#getLearningResources
   * @model opposite="learningResources" required="true" transient="false"
   * @generated
   */
  LearningCorpus getLearningCorpus();

  /**
   * Sets the value of the '{@link learningcorpus.LearningResource#getLearningCorpus <em>Learning Corpus</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Learning Corpus</em>' container reference.
   * @see #getLearningCorpus()
   * @generated
   */
  void setLearningCorpus(LearningCorpus value);

} // LearningResource
