/**
 */
package learningcorpusquiz.impl;

import learningcorpusquiz.Choice;
import learningcorpusquiz.LearningcorpusquizPackage;
import learningcorpusquiz.ListMultipleChoiceQuiz;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.impl.ChoiceImpl#getQuiz <em>Quiz</em>}</li>
 *   <li>{@link learningcorpusquiz.impl.ChoiceImpl#getText <em>Text</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChoiceImpl extends MinimalEObjectImpl.Container implements Choice {
  /**
   * The default value of the '{@link #getText() <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getText()
   * @generated
   * @ordered
   */
  protected static final String TEXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getText()
   * @generated
   * @ordered
   */
  protected String text = TEXT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ChoiceImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LearningcorpusquizPackage.Literals.CHOICE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ListMultipleChoiceQuiz getQuiz() {
    if (eContainerFeatureID() != LearningcorpusquizPackage.CHOICE__QUIZ) return null;
    return (ListMultipleChoiceQuiz)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQuiz(ListMultipleChoiceQuiz newQuiz, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newQuiz, LearningcorpusquizPackage.CHOICE__QUIZ, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setQuiz(ListMultipleChoiceQuiz newQuiz) {
    if (newQuiz != eInternalContainer() || (eContainerFeatureID() != LearningcorpusquizPackage.CHOICE__QUIZ && newQuiz != null)) {
      if (EcoreUtil.isAncestor(this, newQuiz))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newQuiz != null)
        msgs = ((InternalEObject)newQuiz).eInverseAdd(this, LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CHOICES, ListMultipleChoiceQuiz.class, msgs);
      msgs = basicSetQuiz(newQuiz, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusquizPackage.CHOICE__QUIZ, newQuiz, newQuiz));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText() {
    return text;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setText(String newText) {
    String oldText = text;
    text = newText;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusquizPackage.CHOICE__TEXT, oldText, text));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case LearningcorpusquizPackage.CHOICE__QUIZ:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetQuiz((ListMultipleChoiceQuiz)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case LearningcorpusquizPackage.CHOICE__QUIZ:
        return basicSetQuiz(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
      case LearningcorpusquizPackage.CHOICE__QUIZ:
        return eInternalContainer().eInverseRemove(this, LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CHOICES, ListMultipleChoiceQuiz.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case LearningcorpusquizPackage.CHOICE__QUIZ:
        return getQuiz();
      case LearningcorpusquizPackage.CHOICE__TEXT:
        return getText();
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
      case LearningcorpusquizPackage.CHOICE__QUIZ:
        setQuiz((ListMultipleChoiceQuiz)newValue);
        return;
      case LearningcorpusquizPackage.CHOICE__TEXT:
        setText((String)newValue);
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
      case LearningcorpusquizPackage.CHOICE__QUIZ:
        setQuiz((ListMultipleChoiceQuiz)null);
        return;
      case LearningcorpusquizPackage.CHOICE__TEXT:
        setText(TEXT_EDEFAULT);
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
      case LearningcorpusquizPackage.CHOICE__QUIZ:
        return getQuiz() != null;
      case LearningcorpusquizPackage.CHOICE__TEXT:
        return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
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
    result.append(" (text: ");
    result.append(text);
    result.append(')');
    return result.toString();
  }

} //ChoiceImpl
