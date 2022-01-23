/**
 */
package learningcorpusquiz;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Mcq Row Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.TableMcqRowItem#getText <em>Text</em>}</li>
 *   <li>{@link learningcorpusquiz.TableMcqRowItem#getQuiz <em>Quiz</em>}</li>
 *   <li>{@link learningcorpusquiz.TableMcqRowItem#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @see learningcorpusquiz.LearningcorpusquizPackage#getTableMcqRowItem()
 * @model
 * @generated
 */
public interface TableMcqRowItem extends EObject {
  /**
   * Returns the value of the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' attribute.
   * @see #setText(String)
   * @see learningcorpusquiz.LearningcorpusquizPackage#getTableMcqRowItem_Text()
   * @model
   * @generated
   */
  String getText();

  /**
   * Sets the value of the '{@link learningcorpusquiz.TableMcqRowItem#getText <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' attribute.
   * @see #getText()
   * @generated
   */
  void setText(String value);

  /**
   * Returns the value of the '<em><b>Quiz</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.TableMultipleChoiceQuiz#getRowItems <em>Row Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quiz</em>' container reference.
   * @see #setQuiz(TableMultipleChoiceQuiz)
   * @see learningcorpusquiz.LearningcorpusquizPackage#getTableMcqRowItem_Quiz()
   * @see learningcorpusquiz.TableMultipleChoiceQuiz#getRowItems
   * @model opposite="rowItems" required="true" transient="false"
   * @generated
   */
  TableMultipleChoiceQuiz getQuiz();

  /**
   * Sets the value of the '{@link learningcorpusquiz.TableMcqRowItem#getQuiz <em>Quiz</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quiz</em>' container reference.
   * @see #getQuiz()
   * @generated
   */
  void setQuiz(TableMultipleChoiceQuiz value);

  /**
   * Returns the value of the '<em><b>Entries</b></em>' reference list.
   * The list contents are of type {@link learningcorpusquiz.TableMcqEntry}.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.TableMcqEntry#getRowitem <em>Rowitem</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entries</em>' reference list.
   * @see learningcorpusquiz.LearningcorpusquizPackage#getTableMcqRowItem_Entries()
   * @see learningcorpusquiz.TableMcqEntry#getRowitem
   * @model opposite="rowitem"
   * @generated
   */
  EList<TableMcqEntry> getEntries();

} // TableMcqRowItem
