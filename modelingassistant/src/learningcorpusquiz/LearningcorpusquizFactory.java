/**
 */
package learningcorpusquiz;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see learningcorpusquiz.LearningcorpusquizPackage
 * @generated
 */
public interface LearningcorpusquizFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LearningcorpusquizFactory eINSTANCE = learningcorpusquiz.impl.LearningcorpusquizFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Fill In The Blanks Quiz</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fill In The Blanks Quiz</em>'.
   * @generated
   */
  FillInTheBlanksQuiz createFillInTheBlanksQuiz();

  /**
   * Returns a new object of class '<em>List Multiple Choice Quiz</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Multiple Choice Quiz</em>'.
   * @generated
   */
  ListMultipleChoiceQuiz createListMultipleChoiceQuiz();

  /**
   * Returns a new object of class '<em>Table Multiple Choice Quiz</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Table Multiple Choice Quiz</em>'.
   * @generated
   */
  TableMultipleChoiceQuiz createTableMultipleChoiceQuiz();

  /**
   * Returns a new object of class '<em>Fill In The Blanks Quiz Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fill In The Blanks Quiz Statement</em>'.
   * @generated
   */
  FillInTheBlanksQuizStatement createFillInTheBlanksQuizStatement();

  /**
   * Returns a new object of class '<em>Fill In The Blanks Quiz Statement Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fill In The Blanks Quiz Statement Component</em>'.
   * @generated
   */
  FillInTheBlanksQuizStatementComponent createFillInTheBlanksQuizStatementComponent();

  /**
   * Returns a new object of class '<em>Non Blank</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Non Blank</em>'.
   * @generated
   */
  NonBlank createNonBlank();

  /**
   * Returns a new object of class '<em>Blank</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Blank</em>'.
   * @generated
   */
  Blank createBlank();

  /**
   * Returns a new object of class '<em>Choice</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Choice</em>'.
   * @generated
   */
  Choice createChoice();

  /**
   * Returns a new object of class '<em>Table Mcq Correct Entry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Table Mcq Correct Entry</em>'.
   * @generated
   */
  TableMcqCorrectEntry createTableMcqCorrectEntry();

  /**
   * Returns a new object of class '<em>Table Mcq Row Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Table Mcq Row Item</em>'.
   * @generated
   */
  TableMcqRowItem createTableMcqRowItem();

  /**
   * Returns a new object of class '<em>Table Mcq Column Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Table Mcq Column Item</em>'.
   * @generated
   */
  TableMcqColumnItem createTableMcqColumnItem();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  LearningcorpusquizPackage getLearningcorpusquizPackage();

} //LearningcorpusquizFactory
