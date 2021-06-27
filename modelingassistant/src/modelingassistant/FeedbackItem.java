/**
 */
package modelingassistant;

import learningcorpus.Feedback;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feedback Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.FeedbackItem#getMistake <em>Mistake</em>}</li>
 *   <li>{@link modelingassistant.FeedbackItem#getUsefulness <em>Usefulness</em>}</li>
 *   <li>{@link modelingassistant.FeedbackItem#getFeedback <em>Feedback</em>}</li>
 *   <li>{@link modelingassistant.FeedbackItem#getSolution <em>Solution</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getFeedbackItem()
 * @model
 * @generated
 */
public interface FeedbackItem extends EObject {
  /**
   * Returns the value of the '<em><b>Mistake</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Mistake#getLastFeedback <em>Last Feedback</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake</em>' reference.
   * @see #setMistake(Mistake)
   * @see modelingassistant.ModelingassistantPackage#getFeedbackItem_Mistake()
   * @see modelingassistant.Mistake#getLastFeedback
   * @model opposite="lastFeedback"
   * @generated
   */
  Mistake getMistake();

  /**
   * Sets the value of the '{@link modelingassistant.FeedbackItem#getMistake <em>Mistake</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mistake</em>' reference.
   * @see #getMistake()
   * @generated
   */
  void setMistake(Mistake value);

  /**
   * Returns the value of the '<em><b>Usefulness</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Usefulness</em>' attribute.
   * @see #setUsefulness(double)
   * @see modelingassistant.ModelingassistantPackage#getFeedbackItem_Usefulness()
   * @model
   * @generated
   */
  double getUsefulness();

  /**
   * Sets the value of the '{@link modelingassistant.FeedbackItem#getUsefulness <em>Usefulness</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Usefulness</em>' attribute.
   * @see #getUsefulness()
   * @generated
   */
  void setUsefulness(double value);

  /**
   * Returns the value of the '<em><b>Feedback</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feedback</em>' reference.
   * @see #setFeedback(Feedback)
   * @see modelingassistant.ModelingassistantPackage#getFeedbackItem_Feedback()
   * @model
   * @generated
   */
  Feedback getFeedback();

  /**
   * Sets the value of the '{@link modelingassistant.FeedbackItem#getFeedback <em>Feedback</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feedback</em>' reference.
   * @see #getFeedback()
   * @generated
   */
  void setFeedback(Feedback value);

  /**
   * Returns the value of the '<em><b>Solution</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Solution#getFeedbackItems <em>Feedback Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution</em>' container reference.
   * @see #setSolution(Solution)
   * @see modelingassistant.ModelingassistantPackage#getFeedbackItem_Solution()
   * @see modelingassistant.Solution#getFeedbackItems
   * @model opposite="feedbackItems" required="true" transient="false"
   * @generated
   */
  Solution getSolution();

  /**
   * Sets the value of the '{@link modelingassistant.FeedbackItem#getSolution <em>Solution</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Solution</em>' container reference.
   * @see #getSolution()
   * @generated
   */
  void setSolution(Solution value);

} // FeedbackItem
