/**
 */
package learningcorpus;

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
 *   <li>{@link learningcorpus.LearningItem#getUmlElements <em>Uml Elements</em>}</li>
 *   <li>{@link learningcorpus.LearningItem#getLearningResources <em>Learning Resources</em>}</li>
 *   <li>{@link learningcorpus.LearningItem#getMistakeTypes <em>Mistake Types</em>}</li>
 *   <li>{@link learningcorpus.LearningItem#getDescription <em>Description</em>}</li>
 *   <li>{@link learningcorpus.LearningItem#getLearningCorpus <em>Learning Corpus</em>}</li>
 * </ul>
 *
 * @see learningcorpus.LearningcorpusPackage#getLearningItem()
 * @model
 * @generated
 */
public interface LearningItem extends NamedElement {
  /**
   * Returns the value of the '<em><b>Uml Elements</b></em>' reference list.
   * The list contents are of type {@link learningcorpus.UmlElement}.
   * It is bidirectional and its opposite is '{@link learningcorpus.UmlElement#getLearningItems <em>Learning Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uml Elements</em>' reference list.
   * @see learningcorpus.LearningcorpusPackage#getLearningItem_UmlElements()
   * @see learningcorpus.UmlElement#getLearningItems
   * @model opposite="learningItems"
   * @generated
   */
  EList<UmlElement> getUmlElements();

  /**
   * Returns the value of the '<em><b>Learning Resources</b></em>' reference list.
   * The list contents are of type {@link learningcorpus.LearningResource}.
   * It is bidirectional and its opposite is '{@link learningcorpus.LearningResource#getLearningItem <em>Learning Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Resources</em>' reference list.
   * @see learningcorpus.LearningcorpusPackage#getLearningItem_LearningResources()
   * @see learningcorpus.LearningResource#getLearningItem
   * @model opposite="learningItem"
   * @generated
   */
  EList<LearningResource> getLearningResources();

  /**
   * Returns the value of the '<em><b>Mistake Types</b></em>' reference list.
   * The list contents are of type {@link learningcorpus.MistakeType}.
   * It is bidirectional and its opposite is '{@link learningcorpus.MistakeType#getLearningItem <em>Learning Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake Types</em>' reference list.
   * @see learningcorpus.LearningcorpusPackage#getLearningItem_MistakeTypes()
   * @see learningcorpus.MistakeType#getLearningItem
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
   * @see learningcorpus.LearningcorpusPackage#getLearningItem_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link learningcorpus.LearningItem#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Learning Corpus</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link learningcorpus.LearningCorpus#getLearningItems <em>Learning Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Corpus</em>' container reference.
   * @see #setLearningCorpus(LearningCorpus)
   * @see learningcorpus.LearningcorpusPackage#getLearningItem_LearningCorpus()
   * @see learningcorpus.LearningCorpus#getLearningItems
   * @model opposite="learningItems" required="true" transient="false"
   * @generated
   */
  LearningCorpus getLearningCorpus();

  /**
   * Sets the value of the '{@link learningcorpus.LearningItem#getLearningCorpus <em>Learning Corpus</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Learning Corpus</em>' container reference.
   * @see #getLearningCorpus()
   * @generated
   */
  void setLearningCorpus(LearningCorpus value);

} // LearningItem
