/**
 */
package learningcorpusquiz.impl;

import java.util.Collection;

import learningcorpus.impl.QuizImpl;

import learningcorpusquiz.Choice;
import learningcorpusquiz.LearningcorpusquizPackage;
import learningcorpusquiz.ListMultipleChoiceQuiz;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Multiple Choice Quiz</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.impl.ListMultipleChoiceQuizImpl#getChoices <em>Choices</em>}</li>
 *   <li>{@link learningcorpusquiz.impl.ListMultipleChoiceQuizImpl#getCorrectChoices <em>Correct Choices</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListMultipleChoiceQuizImpl extends QuizImpl implements ListMultipleChoiceQuiz {
  /**
   * The cached value of the '{@link #getChoices() <em>Choices</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChoices()
   * @generated
   * @ordered
   */
  protected EList<Choice> choices;

  /**
   * The cached value of the '{@link #getCorrectChoices() <em>Correct Choices</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCorrectChoices()
   * @generated
   * @ordered
   */
  protected EList<Choice> correctChoices;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ListMultipleChoiceQuizImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LearningcorpusquizPackage.Literals.LIST_MULTIPLE_CHOICE_QUIZ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Choice> getChoices() {
    if (choices == null) {
      choices = new EObjectContainmentWithInverseEList<Choice>(Choice.class, this, LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CHOICES, LearningcorpusquizPackage.CHOICE__QUIZ);
    }
    return choices;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Choice> getCorrectChoices() {
    if (correctChoices == null) {
      correctChoices = new EObjectResolvingEList<Choice>(Choice.class, this, LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CORRECT_CHOICES);
    }
    return correctChoices;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CHOICES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getChoices()).basicAdd(otherEnd, msgs);
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
      case LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CHOICES:
        return ((InternalEList<?>)getChoices()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CHOICES:
        return getChoices();
      case LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CORRECT_CHOICES:
        return getCorrectChoices();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CHOICES:
        getChoices().clear();
        getChoices().addAll((Collection<? extends Choice>)newValue);
        return;
      case LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CORRECT_CHOICES:
        getCorrectChoices().clear();
        getCorrectChoices().addAll((Collection<? extends Choice>)newValue);
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
      case LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CHOICES:
        getChoices().clear();
        return;
      case LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CORRECT_CHOICES:
        getCorrectChoices().clear();
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
      case LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CHOICES:
        return choices != null && !choices.isEmpty();
      case LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ__CORRECT_CHOICES:
        return correctChoices != null && !correctChoices.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ListMultipleChoiceQuizImpl
