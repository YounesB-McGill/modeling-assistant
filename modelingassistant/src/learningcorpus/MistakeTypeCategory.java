/**
 */
package learningcorpus;

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
 *   <li>{@link learningcorpus.MistakeTypeCategory#getMistakeTypes <em>Mistake Types</em>}</li>
 *   <li>{@link learningcorpus.MistakeTypeCategory#getSupercategory <em>Supercategory</em>}</li>
 *   <li>{@link learningcorpus.MistakeTypeCategory#getSubcategories <em>Subcategories</em>}</li>
 *   <li>{@link learningcorpus.MistakeTypeCategory#getLearningCorpus <em>Learning Corpus</em>}</li>
 * </ul>
 *
 * @see learningcorpus.LearningcorpusPackage#getMistakeTypeCategory()
 * @model
 * @generated
 */
public interface MistakeTypeCategory extends NamedElement {
  /**
   * Returns the value of the '<em><b>Mistake Types</b></em>' containment reference list.
   * The list contents are of type {@link learningcorpus.MistakeType}.
   * It is bidirectional and its opposite is '{@link learningcorpus.MistakeType#getMistakeTypeCategory <em>Mistake Type Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake Types</em>' containment reference list.
   * @see learningcorpus.LearningcorpusPackage#getMistakeTypeCategory_MistakeTypes()
   * @see learningcorpus.MistakeType#getMistakeTypeCategory
   * @model opposite="mistakeTypeCategory" containment="true"
   * @generated
   */
  EList<MistakeType> getMistakeTypes();

  /**
   * Returns the value of the '<em><b>Supercategory</b></em>' reference.
   * It is bidirectional and its opposite is '{@link learningcorpus.MistakeTypeCategory#getSubcategories <em>Subcategories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supercategory</em>' reference.
   * @see #setSupercategory(MistakeTypeCategory)
   * @see learningcorpus.LearningcorpusPackage#getMistakeTypeCategory_Supercategory()
   * @see learningcorpus.MistakeTypeCategory#getSubcategories
   * @model opposite="subcategories"
   * @generated
   */
  MistakeTypeCategory getSupercategory();

  /**
   * Sets the value of the '{@link learningcorpus.MistakeTypeCategory#getSupercategory <em>Supercategory</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Supercategory</em>' reference.
   * @see #getSupercategory()
   * @generated
   */
  void setSupercategory(MistakeTypeCategory value);

  /**
   * Returns the value of the '<em><b>Subcategories</b></em>' reference list.
   * The list contents are of type {@link learningcorpus.MistakeTypeCategory}.
   * It is bidirectional and its opposite is '{@link learningcorpus.MistakeTypeCategory#getSupercategory <em>Supercategory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subcategories</em>' reference list.
   * @see learningcorpus.LearningcorpusPackage#getMistakeTypeCategory_Subcategories()
   * @see learningcorpus.MistakeTypeCategory#getSupercategory
   * @model opposite="supercategory"
   * @generated
   */
  EList<MistakeTypeCategory> getSubcategories();

  /**
   * Returns the value of the '<em><b>Learning Corpus</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link learningcorpus.LearningCorpus#getMistakeTypeCategories <em>Mistake Type Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Corpus</em>' container reference.
   * @see #setLearningCorpus(LearningCorpus)
   * @see learningcorpus.LearningcorpusPackage#getMistakeTypeCategory_LearningCorpus()
   * @see learningcorpus.LearningCorpus#getMistakeTypeCategories
   * @model opposite="mistakeTypeCategories" required="true" transient="false"
   * @generated
   */
  LearningCorpus getLearningCorpus();

  /**
   * Sets the value of the '{@link learningcorpus.MistakeTypeCategory#getLearningCorpus <em>Learning Corpus</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Learning Corpus</em>' container reference.
   * @see #getLearningCorpus()
   * @generated
   */
  void setLearningCorpus(LearningCorpus value);

} // MistakeTypeCategory
