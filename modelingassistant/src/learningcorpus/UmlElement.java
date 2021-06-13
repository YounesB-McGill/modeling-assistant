/**
 */
package learningcorpus;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uml Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link learningcorpus.UmlElement#getLearningItems <em>Learning Items</em>}</li>
 *   <li>{@link learningcorpus.UmlElement#getLearningCorpus <em>Learning Corpus</em>}</li>
 * </ul>
 *
 * @see learningcorpus.LearningcorpusPackage#getUmlElement()
 * @model
 * @generated
 */
public interface UmlElement extends EObject {
  /**
   * Returns the value of the '<em><b>Learning Items</b></em>' reference list.
   * The list contents are of type {@link learningcorpus.LearningItem}.
   * It is bidirectional and its opposite is '{@link learningcorpus.LearningItem#getUmlElements <em>Uml Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Items</em>' reference list.
   * @see learningcorpus.LearningcorpusPackage#getUmlElement_LearningItems()
   * @see learningcorpus.LearningItem#getUmlElements
   * @model opposite="umlElements"
   * @generated
   */
  EList<LearningItem> getLearningItems();

  /**
   * Returns the value of the '<em><b>Learning Corpus</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link learningcorpus.LearningCorpus#getUmlElements <em>Uml Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Corpus</em>' container reference.
   * @see #setLearningCorpus(LearningCorpus)
   * @see learningcorpus.LearningcorpusPackage#getUmlElement_LearningCorpus()
   * @see learningcorpus.LearningCorpus#getUmlElements
   * @model opposite="umlElements" required="true" transient="false"
   * @generated
   */
  LearningCorpus getLearningCorpus();

  /**
   * Sets the value of the '{@link learningcorpus.UmlElement#getLearningCorpus <em>Learning Corpus</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Learning Corpus</em>' container reference.
   * @see #getLearningCorpus()
   * @generated
   */
  void setLearningCorpus(LearningCorpus value);

} // UmlElement
