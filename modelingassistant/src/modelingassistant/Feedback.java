/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link modelingassistant.Feedback#getLevel <em>Level</em>}</li>
 *   <li>{@link modelingassistant.Feedback#isCongratulatory <em>Congratulatory</em>}</li>
 *   <li>{@link modelingassistant.Feedback#getUsefulness <em>Usefulness</em>}</li>
 *   <li>{@link modelingassistant.Feedback#isHighlightProblem <em>Highlight Problem</em>}</li>
 *   <li>{@link modelingassistant.Feedback#isHighlightSolution <em>Highlight Solution</em>}</li>
 *   <li>{@link modelingassistant.Feedback#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.Feedback#getMistakeType <em>Mistake Type</em>}</li>
 *   <li>{@link modelingassistant.Feedback#getMistakes <em>Mistakes</em>}</li>
 *   <li>{@link modelingassistant.Feedback#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getFeedback()
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
   * @see modelingassistant.ModelingassistantPackage#getFeedback_Level()
   * @model
   * @generated
   */
  int getLevel();

  /**
   * Sets the value of the '{@link modelingassistant.Feedback#getLevel <em>Level</em>}' attribute.
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
   * @see modelingassistant.ModelingassistantPackage#getFeedback_Congratulatory()
   * @model
   * @generated
   */
  boolean isCongratulatory();

  /**
   * Sets the value of the '{@link modelingassistant.Feedback#isCongratulatory <em>Congratulatory</em>}' attribute.
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
   * @see modelingassistant.ModelingassistantPackage#getFeedback_Usefulness()
   * @model
   * @generated
   */
  double getUsefulness();

  /**
   * Sets the value of the '{@link modelingassistant.Feedback#getUsefulness <em>Usefulness</em>}' attribute.
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
   * @see modelingassistant.ModelingassistantPackage#getFeedback_HighlightProblem()
   * @model
   * @generated
   */
  boolean isHighlightProblem();

  /**
   * Sets the value of the '{@link modelingassistant.Feedback#isHighlightProblem <em>Highlight Problem</em>}' attribute.
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
   * @see modelingassistant.ModelingassistantPackage#getFeedback_HighlightSolution()
   * @model
   * @generated
   */
  boolean isHighlightSolution();

  /**
   * Sets the value of the '{@link modelingassistant.Feedback#isHighlightSolution <em>Highlight Solution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Highlight Solution</em>' attribute.
   * @see #isHighlightSolution()
   * @generated
   */
  void setHighlightSolution(boolean value);

  /**
   * Returns the value of the '<em><b>Modeling Assistant</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ModelingAssistant#getFeedbacks <em>Feedbacks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modeling Assistant</em>' container reference.
   * @see #setModelingAssistant(ModelingAssistant)
   * @see modelingassistant.ModelingassistantPackage#getFeedback_ModelingAssistant()
   * @see modelingassistant.ModelingAssistant#getFeedbacks
   * @model opposite="feedbacks" required="true" transient="false"
   * @generated
   */
  ModelingAssistant getModelingAssistant();

  /**
   * Sets the value of the '{@link modelingassistant.Feedback#getModelingAssistant <em>Modeling Assistant</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modeling Assistant</em>' container reference.
   * @see #getModelingAssistant()
   * @generated
   */
  void setModelingAssistant(ModelingAssistant value);

  /**
   * Returns the value of the '<em><b>Mistake Type</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.MistakeType#getFeedbacks <em>Feedbacks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake Type</em>' reference.
   * @see #setMistakeType(MistakeType)
   * @see modelingassistant.ModelingassistantPackage#getFeedback_MistakeType()
   * @see modelingassistant.MistakeType#getFeedbacks
   * @model opposite="feedbacks" required="true"
   * @generated
   */
  MistakeType getMistakeType();

  /**
   * Sets the value of the '{@link modelingassistant.Feedback#getMistakeType <em>Mistake Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mistake Type</em>' reference.
   * @see #getMistakeType()
   * @generated
   */
  void setMistakeType(MistakeType value);

  /**
   * Returns the value of the '<em><b>Mistakes</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Mistake}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Mistake#getLastFeedback <em>Last Feedback</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistakes</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getFeedback_Mistakes()
   * @see modelingassistant.Mistake#getLastFeedback
   * @model opposite="lastFeedback"
   * @generated
   */
  EList<Mistake> getMistakes();

  /**
   * Returns the value of the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' attribute.
   * @see #setText(String)
   * @see modelingassistant.ModelingassistantPackage#getFeedback_Text()
   * @model
   * @generated
   */
  String getText();

  /**
   * Sets the value of the '{@link modelingassistant.Feedback#getText <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' attribute.
   * @see #getText()
   * @generated
   */
  void setText(String value);

} // Feedback
