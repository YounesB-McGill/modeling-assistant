/**
 */
package learningcorpus;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see learningcorpus.LearningcorpusPackage
 * @generated
 */
public interface LearningcorpusFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LearningcorpusFactory eINSTANCE = learningcorpus.impl.LearningcorpusFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Learning Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Learning Item</em>'.
   * @generated
   */
  LearningItem createLearningItem();

  /**
   * Returns a new object of class '<em>Mistake Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mistake Type</em>'.
   * @generated
   */
  MistakeType createMistakeType();

  /**
   * Returns a new object of class '<em>Feedback</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feedback</em>'.
   * @generated
   */
  Feedback createFeedback();

  /**
   * Returns a new object of class '<em>Text Response</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Text Response</em>'.
   * @generated
   */
  TextResponse createTextResponse();

  /**
   * Returns a new object of class '<em>Parametrized Response</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parametrized Response</em>'.
   * @generated
   */
  ParametrizedResponse createParametrizedResponse();

  /**
   * Returns a new object of class '<em>Resource Response</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Resource Response</em>'.
   * @generated
   */
  ResourceResponse createResourceResponse();

  /**
   * Returns a new object of class '<em>Learning Resource</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Learning Resource</em>'.
   * @generated
   */
  LearningResource createLearningResource();

  /**
   * Returns a new object of class '<em>Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference</em>'.
   * @generated
   */
  Reference createReference();

  /**
   * Returns a new object of class '<em>Tutorial</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tutorial</em>'.
   * @generated
   */
  Tutorial createTutorial();

  /**
   * Returns a new object of class '<em>Example</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Example</em>'.
   * @generated
   */
  Example createExample();

  /**
   * Returns a new object of class '<em>Quiz</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Quiz</em>'.
   * @generated
   */
  Quiz createQuiz();

  /**
   * Returns a new object of class '<em>Mistake Type Category</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mistake Type Category</em>'.
   * @generated
   */
  MistakeTypeCategory createMistakeTypeCategory();

  /**
   * Returns a new object of class '<em>Learning Corpus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Learning Corpus</em>'.
   * @generated
   */
  LearningCorpus createLearningCorpus();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  LearningcorpusPackage getLearningcorpusPackage();

} //LearningcorpusFactory
