/**
 */
package learningcorpusquiz;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Mcq Correct Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.TableMcqCorrectEntry#getQuiz <em>Quiz</em>}</li>
 *   <li>{@link learningcorpusquiz.TableMcqCorrectEntry#getColumnItem <em>Column Item</em>}</li>
 *   <li>{@link learningcorpusquiz.TableMcqCorrectEntry#getRowitem <em>Rowitem</em>}</li>
 * </ul>
 *
 * @see learningcorpusquiz.LearningcorpusquizPackage#getTableMcqCorrectEntry()
 * @model
 * @generated
 */
public interface TableMcqCorrectEntry extends EObject {
  /**
   * Returns the value of the '<em><b>Quiz</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.TableMultipleChoiceQuiz#getCorrectEntries <em>Correct Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quiz</em>' container reference.
   * @see #setQuiz(TableMultipleChoiceQuiz)
   * @see learningcorpusquiz.LearningcorpusquizPackage#getTableMcqCorrectEntry_Quiz()
   * @see learningcorpusquiz.TableMultipleChoiceQuiz#getCorrectEntries
   * @model opposite="correctEntries" required="true" transient="false"
   * @generated
   */
  TableMultipleChoiceQuiz getQuiz();

  /**
   * Sets the value of the '{@link learningcorpusquiz.TableMcqCorrectEntry#getQuiz <em>Quiz</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quiz</em>' container reference.
   * @see #getQuiz()
   * @generated
   */
  void setQuiz(TableMultipleChoiceQuiz value);

  /**
   * Returns the value of the '<em><b>Column Item</b></em>' reference.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.TableMcqColumnItem#getCorrectEntries <em>Correct Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Column Item</em>' reference.
   * @see #setColumnItem(TableMcqColumnItem)
   * @see learningcorpusquiz.LearningcorpusquizPackage#getTableMcqCorrectEntry_ColumnItem()
   * @see learningcorpusquiz.TableMcqColumnItem#getCorrectEntries
   * @model opposite="correctEntries" required="true"
   * @generated
   */
  TableMcqColumnItem getColumnItem();

  /**
   * Sets the value of the '{@link learningcorpusquiz.TableMcqCorrectEntry#getColumnItem <em>Column Item</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Column Item</em>' reference.
   * @see #getColumnItem()
   * @generated
   */
  void setColumnItem(TableMcqColumnItem value);

  /**
   * Returns the value of the '<em><b>Rowitem</b></em>' reference.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.TableMcqRowItem#getCorrectEntries <em>Correct Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rowitem</em>' reference.
   * @see #setRowitem(TableMcqRowItem)
   * @see learningcorpusquiz.LearningcorpusquizPackage#getTableMcqCorrectEntry_Rowitem()
   * @see learningcorpusquiz.TableMcqRowItem#getCorrectEntries
   * @model opposite="correctEntries" required="true"
   * @generated
   */
  TableMcqRowItem getRowitem();

  /**
   * Sets the value of the '{@link learningcorpusquiz.TableMcqCorrectEntry#getRowitem <em>Rowitem</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rowitem</em>' reference.
   * @see #getRowitem()
   * @generated
   */
  void setRowitem(TableMcqRowItem value);

} // TableMcqCorrectEntry
