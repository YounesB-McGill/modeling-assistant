/**
 */
package learningcorpusquiz;

import learningcorpus.Quiz;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Multiple Choice Quiz</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.TableMultipleChoiceQuiz#getRowItems <em>Row Items</em>}</li>
 *   <li>{@link learningcorpusquiz.TableMultipleChoiceQuiz#getColumnItems <em>Column Items</em>}</li>
 *   <li>{@link learningcorpusquiz.TableMultipleChoiceQuiz#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @see learningcorpusquiz.LearningcorpusquizPackage#getTableMultipleChoiceQuiz()
 * @model
 * @generated
 */
public interface TableMultipleChoiceQuiz extends Quiz {
  /**
   * Returns the value of the '<em><b>Row Items</b></em>' containment reference list.
   * The list contents are of type {@link learningcorpusquiz.TableMcqRowItem}.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.TableMcqRowItem#getQuiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Row Items</em>' containment reference list.
   * @see learningcorpusquiz.LearningcorpusquizPackage#getTableMultipleChoiceQuiz_RowItems()
   * @see learningcorpusquiz.TableMcqRowItem#getQuiz
   * @model opposite="quiz" containment="true"
   * @generated
   */
  EList<TableMcqRowItem> getRowItems();

  /**
   * Returns the value of the '<em><b>Column Items</b></em>' containment reference list.
   * The list contents are of type {@link learningcorpusquiz.TableMcqColumnItem}.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.TableMcqColumnItem#getQuiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Column Items</em>' containment reference list.
   * @see learningcorpusquiz.LearningcorpusquizPackage#getTableMultipleChoiceQuiz_ColumnItems()
   * @see learningcorpusquiz.TableMcqColumnItem#getQuiz
   * @model opposite="quiz" containment="true"
   * @generated
   */
  EList<TableMcqColumnItem> getColumnItems();

  /**
   * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
   * The list contents are of type {@link learningcorpusquiz.TableMcqEntry}.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.TableMcqEntry#getQuiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entries</em>' containment reference list.
   * @see learningcorpusquiz.LearningcorpusquizPackage#getTableMultipleChoiceQuiz_Entries()
   * @see learningcorpusquiz.TableMcqEntry#getQuiz
   * @model opposite="quiz" containment="true"
   * @generated
   */
  EList<TableMcqEntry> getEntries();

} // TableMultipleChoiceQuiz
