/**
 */
package learningcorpusquiz;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fill In The Blanks Quiz Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.FillInTheBlanksQuizStatement#getQuiz <em>Quiz</em>}</li>
 *   <li>{@link learningcorpusquiz.FillInTheBlanksQuizStatement#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see learningcorpusquiz.LearningcorpusquizPackage#getFillInTheBlanksQuizStatement()
 * @model
 * @generated
 */
public interface FillInTheBlanksQuizStatement extends EObject {
  /**
   * Returns the value of the '<em><b>Quiz</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.FillInTheBlanksQuiz#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quiz</em>' container reference.
   * @see #setQuiz(FillInTheBlanksQuiz)
   * @see learningcorpusquiz.LearningcorpusquizPackage#getFillInTheBlanksQuizStatement_Quiz()
   * @see learningcorpusquiz.FillInTheBlanksQuiz#getStatements
   * @model opposite="statements" required="true" transient="false"
   * @generated
   */
  FillInTheBlanksQuiz getQuiz();

  /**
   * Sets the value of the '{@link learningcorpusquiz.FillInTheBlanksQuizStatement#getQuiz <em>Quiz</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quiz</em>' container reference.
   * @see #getQuiz()
   * @generated
   */
  void setQuiz(FillInTheBlanksQuiz value);

  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link learningcorpusquiz.FillInTheBlanksQuizStatementComponent}.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.FillInTheBlanksQuizStatementComponent#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see learningcorpusquiz.LearningcorpusquizPackage#getFillInTheBlanksQuizStatement_Statements()
   * @see learningcorpusquiz.FillInTheBlanksQuizStatementComponent#getStatement
   * @model opposite="statement" containment="true"
   * @generated
   */
  EList<FillInTheBlanksQuizStatementComponent> getStatements();

} // FillInTheBlanksQuizStatement
