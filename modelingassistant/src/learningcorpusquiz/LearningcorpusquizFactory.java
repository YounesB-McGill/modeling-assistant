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
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  LearningcorpusquizPackage getLearningcorpusquizPackage();

} //LearningcorpusquizFactory
