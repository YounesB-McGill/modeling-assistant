/**
 */
package learningcorpusquiz;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fill In The Blanks Quiz Statement Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.FillInTheBlanksQuizStatementComponent#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @see learningcorpusquiz.LearningcorpusquizPackage#getFillInTheBlanksQuizStatementComponent()
 * @model
 * @generated
 */
public interface FillInTheBlanksQuizStatementComponent extends EObject {
  /**
   * Returns the value of the '<em><b>Statement</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link learningcorpusquiz.FillInTheBlanksQuizStatement#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement</em>' container reference.
   * @see #setStatement(FillInTheBlanksQuizStatement)
   * @see learningcorpusquiz.LearningcorpusquizPackage#getFillInTheBlanksQuizStatementComponent_Statement()
   * @see learningcorpusquiz.FillInTheBlanksQuizStatement#getStatements
   * @model opposite="statements" required="true" transient="false"
   * @generated
   */
  FillInTheBlanksQuizStatement getStatement();

  /**
   * Sets the value of the '{@link learningcorpusquiz.FillInTheBlanksQuizStatementComponent#getStatement <em>Statement</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statement</em>' container reference.
   * @see #getStatement()
   * @generated
   */
  void setStatement(FillInTheBlanksQuizStatement value);

} // FillInTheBlanksQuizStatementComponent
