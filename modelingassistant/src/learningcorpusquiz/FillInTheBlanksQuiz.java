/**
 */
package learningcorpusquiz;

import learningcorpus.Quiz;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fill In The Blanks Quiz</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.FillInTheBlanksQuiz#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see learningcorpusquiz.LearningcorpusquizPackage#getFillInTheBlanksQuiz()
 * @model
 * @generated
 */
public interface FillInTheBlanksQuiz extends Quiz {

  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link learningcorpusquiz.FillInTheBlanksQuizStatement}.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.FillInTheBlanksQuizStatement#getQuiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see learningcorpusquiz.LearningcorpusquizPackage#getFillInTheBlanksQuiz_Statements()
   * @see learningcorpusquiz.FillInTheBlanksQuizStatement#getQuiz
   * @model opposite="quiz" containment="true"
   * @generated
   */
  EList<FillInTheBlanksQuizStatement> getStatements();
} // FillInTheBlanksQuiz
