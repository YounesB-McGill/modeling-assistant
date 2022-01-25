/**
 */
package learningcorpusquiz;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.Choice#getQuiz <em>Quiz</em>}</li>
 *   <li>{@link learningcorpusquiz.Choice#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see learningcorpusquiz.LearningcorpusquizPackage#getChoice()
 * @model
 * @generated
 */
public interface Choice extends EObject {
  /**
   * Returns the value of the '<em><b>Quiz</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.ListMultipleChoiceQuiz#getChoices <em>Choices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quiz</em>' container reference.
   * @see #setQuiz(ListMultipleChoiceQuiz)
   * @see learningcorpusquiz.LearningcorpusquizPackage#getChoice_Quiz()
   * @see learningcorpusquiz.ListMultipleChoiceQuiz#getChoices
   * @model opposite="choices" required="true" transient="false"
   * @generated
   */
  ListMultipleChoiceQuiz getQuiz();

  /**
   * Sets the value of the '{@link learningcorpusquiz.Choice#getQuiz <em>Quiz</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quiz</em>' container reference.
   * @see #getQuiz()
   * @generated
   */
  void setQuiz(ListMultipleChoiceQuiz value);

  /**
   * Returns the value of the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' attribute.
   * @see #setText(String)
   * @see learningcorpusquiz.LearningcorpusquizPackage#getChoice_Text()
   * @model
   * @generated
   */
  String getText();

  /**
   * Sets the value of the '{@link learningcorpusquiz.Choice#getText <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' attribute.
   * @see #getText()
   * @generated
   */
  void setText(String value);

} // Choice
