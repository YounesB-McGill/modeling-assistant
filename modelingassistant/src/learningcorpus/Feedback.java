/**
 */
package learningcorpus;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feedback</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link learningcorpus.Feedback#getLevel <em>Level</em>}</li>
 *   <li>{@link learningcorpus.Feedback#isCongratulatory <em>Congratulatory</em>}</li>
 *   <li>{@link learningcorpus.Feedback#getUsefulness <em>Usefulness</em>}</li>
 *   <li>{@link learningcorpus.Feedback#isHighlightProblem <em>Highlight Problem</em>}</li>
 *   <li>{@link learningcorpus.Feedback#isHighlightSolution <em>Highlight Solution</em>}</li>
 *   <li>{@link learningcorpus.Feedback#getMistakeType <em>Mistake Type</em>}</li>
 *   <li>{@link learningcorpus.Feedback#getText <em>Text</em>}</li>
 *   <li>{@link learningcorpus.Feedback#getLearningCorpus <em>Learning Corpus</em>}</li>
 * </ul>
 *
 * @see learningcorpus.LearningcorpusPackage#getFeedback()
 * @model
 * @generated
 */
public interface Feedback extends EObject {
  /**
   * Returns the value of the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Level</em>' attribute.
   * @see #setLevel(int)
   * @see learningcorpus.LearningcorpusPackage#getFeedback_Level()
   * @model
   * @generated
   */
  int getLevel();

  /**
   * Sets the value of the '{@link learningcorpus.Feedback#getLevel <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Level</em>' attribute.
   * @see #getLevel()
   * @generated
   */
  void setLevel(int value);

  /**
   * Returns the value of the '<em><b>Congratulatory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Congratulatory</em>' attribute.
   * @see #setCongratulatory(boolean)
   * @see learningcorpus.LearningcorpusPackage#getFeedback_Congratulatory()
   * @model
   * @generated
   */
  boolean isCongratulatory();

  /**
   * Sets the value of the '{@link learningcorpus.Feedback#isCongratulatory <em>Congratulatory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Congratulatory</em>' attribute.
   * @see #isCongratulatory()
   * @generated
   */
  void setCongratulatory(boolean value);

  /**
   * Returns the value of the '<em><b>Usefulness</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Usefulness</em>' attribute.
   * @see #setUsefulness(double)
   * @see learningcorpus.LearningcorpusPackage#getFeedback_Usefulness()
   * @model
   * @generated
   */
  double getUsefulness();

  /**
   * Sets the value of the '{@link learningcorpus.Feedback#getUsefulness <em>Usefulness</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Usefulness</em>' attribute.
   * @see #getUsefulness()
   * @generated
   */
  void setUsefulness(double value);

  /**
   * Returns the value of the '<em><b>Highlight Problem</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Highlight Problem</em>' attribute.
   * @see #setHighlightProblem(boolean)
   * @see learningcorpus.LearningcorpusPackage#getFeedback_HighlightProblem()
   * @model
   * @generated
   */
  boolean isHighlightProblem();

  /**
   * Sets the value of the '{@link learningcorpus.Feedback#isHighlightProblem <em>Highlight Problem</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Highlight Problem</em>' attribute.
   * @see #isHighlightProblem()
   * @generated
   */
  void setHighlightProblem(boolean value);

  /**
   * Returns the value of the '<em><b>Highlight Solution</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Highlight Solution</em>' attribute.
   * @see #setHighlightSolution(boolean)
   * @see learningcorpus.LearningcorpusPackage#getFeedback_HighlightSolution()
   * @model
   * @generated
   */
  boolean isHighlightSolution();

  /**
   * Sets the value of the '{@link learningcorpus.Feedback#isHighlightSolution <em>Highlight Solution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Highlight Solution</em>' attribute.
   * @see #isHighlightSolution()
   * @generated
   */
  void setHighlightSolution(boolean value);

  /**
   * Returns the value of the '<em><b>Mistake Type</b></em>' reference.
   * It is bidirectional and its opposite is '{@link learningcorpus.MistakeType#getFeedbacks <em>Feedbacks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake Type</em>' reference.
   * @see #setMistakeType(MistakeType)
   * @see learningcorpus.LearningcorpusPackage#getFeedback_MistakeType()
   * @see learningcorpus.MistakeType#getFeedbacks
   * @model opposite="feedbacks"
   * @generated
   */
  MistakeType getMistakeType();

  /**
   * Sets the value of the '{@link learningcorpus.Feedback#getMistakeType <em>Mistake Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mistake Type</em>' reference.
   * @see #getMistakeType()
   * @generated
   */
  void setMistakeType(MistakeType value);

  /**
   * Returns the value of the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' attribute.
   * @see #setText(String)
   * @see learningcorpus.LearningcorpusPackage#getFeedback_Text()
   * @model
   * @generated
   */
  String getText();

  /**
   * Sets the value of the '{@link learningcorpus.Feedback#getText <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' attribute.
   * @see #getText()
   * @generated
   */
  void setText(String value);

  /**
   * Returns the value of the '<em><b>Learning Corpus</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link learningcorpus.LearningCorpus#getFeedbacks <em>Feedbacks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Corpus</em>' container reference.
   * @see #setLearningCorpus(LearningCorpus)
   * @see learningcorpus.LearningcorpusPackage#getFeedback_LearningCorpus()
   * @see learningcorpus.LearningCorpus#getFeedbacks
   * @model opposite="feedbacks" required="true" transient="false"
   * @generated
   */
  LearningCorpus getLearningCorpus();

  /**
   * Sets the value of the '{@link learningcorpus.Feedback#getLearningCorpus <em>Learning Corpus</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Learning Corpus</em>' container reference.
   * @see #getLearningCorpus()
   * @generated
   */
  void setLearningCorpus(LearningCorpus value);

} // Feedback
