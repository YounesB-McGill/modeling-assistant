/**
 */
package learningcorpusquiz;

import learningcorpus.Quiz;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Multiple Choice Quiz</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.ListMultipleChoiceQuiz#getChoices <em>Choices</em>}</li>
 *   <li>{@link learningcorpusquiz.ListMultipleChoiceQuiz#getCorrectChoices <em>Correct Choices</em>}</li>
 * </ul>
 *
 * @see learningcorpusquiz.LearningcorpusquizPackage#getListMultipleChoiceQuiz()
 * @model
 * @generated
 */
public interface ListMultipleChoiceQuiz extends Quiz {
  /**
   * Returns the value of the '<em><b>Choices</b></em>' containment reference list.
   * The list contents are of type {@link learningcorpusquiz.Choice}.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.Choice#getQuiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Choices</em>' containment reference list.
   * @see learningcorpusquiz.LearningcorpusquizPackage#getListMultipleChoiceQuiz_Choices()
   * @see learningcorpusquiz.Choice#getQuiz
   * @model opposite="quiz" containment="true"
   * @generated
   */
  EList<Choice> getChoices();

  /**
   * Returns the value of the '<em><b>Correct Choices</b></em>' reference list.
   * The list contents are of type {@link learningcorpusquiz.Choice}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Correct Choices</em>' reference list.
   * @see learningcorpusquiz.LearningcorpusquizPackage#getListMultipleChoiceQuiz_CorrectChoices()
   * @model
   * @generated
   */
  EList<Choice> getCorrectChoices();

} // ListMultipleChoiceQuiz
