/**
 */
package learningcorpusquiz.impl;

import learningcorpusquiz.Blank;
import learningcorpusquiz.LearningcorpusquizPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Blank</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.impl.BlankImpl#getCorrectAnswer <em>Correct Answer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlankImpl extends FillInTheBlanksQuizStatementComponentImpl implements Blank {
  /**
   * The default value of the '{@link #getCorrectAnswer() <em>Correct Answer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCorrectAnswer()
   * @generated
   * @ordered
   */
  protected static final String CORRECT_ANSWER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCorrectAnswer() <em>Correct Answer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCorrectAnswer()
   * @generated
   * @ordered
   */
  protected String correctAnswer = CORRECT_ANSWER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BlankImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LearningcorpusquizPackage.Literals.BLANK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getCorrectAnswer() {
    return correctAnswer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCorrectAnswer(String newCorrectAnswer) {
    String oldCorrectAnswer = correctAnswer;
    correctAnswer = newCorrectAnswer;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusquizPackage.BLANK__CORRECT_ANSWER, oldCorrectAnswer, correctAnswer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case LearningcorpusquizPackage.BLANK__CORRECT_ANSWER:
        return getCorrectAnswer();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case LearningcorpusquizPackage.BLANK__CORRECT_ANSWER:
        setCorrectAnswer((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case LearningcorpusquizPackage.BLANK__CORRECT_ANSWER:
        setCorrectAnswer(CORRECT_ANSWER_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case LearningcorpusquizPackage.BLANK__CORRECT_ANSWER:
        return CORRECT_ANSWER_EDEFAULT == null ? correctAnswer != null : !CORRECT_ANSWER_EDEFAULT.equals(correctAnswer);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (correctAnswer: ");
    result.append(correctAnswer);
    result.append(')');
    return result.toString();
  }

} //BlankImpl
