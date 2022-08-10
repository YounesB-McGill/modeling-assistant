/**
 */
package learningcorpus;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mistake Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link learningcorpus.MistakeElement#isMany <em>Many</em>}</li>
 *   <li>{@link learningcorpus.MistakeElement#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see learningcorpus.LearningcorpusPackage#getMistakeElement()
 * @model
 * @generated
 */
public interface MistakeElement extends NamedElement {
  /**
   * Returns the value of the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Many</em>' attribute.
   * @see #setMany(boolean)
   * @see learningcorpus.LearningcorpusPackage#getMistakeElement_Many()
   * @model
   * @generated
   */
  boolean isMany();

  /**
   * Sets the value of the '{@link learningcorpus.MistakeElement#isMany <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Many</em>' attribute.
   * @see #isMany()
   * @generated
   */
  void setMany(boolean value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EObject)
   * @see learningcorpus.LearningcorpusPackage#getMistakeElement_Type()
   * @model required="true"
   * @generated
   */
  EObject getType();

  /**
   * Sets the value of the '{@link learningcorpus.MistakeElement#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EObject value);

} // MistakeElement
