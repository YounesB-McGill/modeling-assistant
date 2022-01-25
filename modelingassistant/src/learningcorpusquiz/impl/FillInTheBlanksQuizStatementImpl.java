/**
 */
package learningcorpusquiz.impl;

import java.util.Collection;

import learningcorpusquiz.FillInTheBlanksQuiz;
import learningcorpusquiz.FillInTheBlanksQuizStatement;
import learningcorpusquiz.FillInTheBlanksQuizStatementComponent;
import learningcorpusquiz.LearningcorpusquizPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fill In The Blanks Quiz Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.impl.FillInTheBlanksQuizStatementImpl#getQuiz <em>Quiz</em>}</li>
 *   <li>{@link learningcorpusquiz.impl.FillInTheBlanksQuizStatementImpl#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FillInTheBlanksQuizStatementImpl extends MinimalEObjectImpl.Container implements FillInTheBlanksQuizStatement {
  /**
   * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatements()
   * @generated
   * @ordered
   */
  protected EList<FillInTheBlanksQuizStatementComponent> statements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FillInTheBlanksQuizStatementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LearningcorpusquizPackage.Literals.FILL_IN_THE_BLANKS_QUIZ_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FillInTheBlanksQuiz getQuiz() {
    if (eContainerFeatureID() != LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ) return null;
    return (FillInTheBlanksQuiz)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQuiz(FillInTheBlanksQuiz newQuiz, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newQuiz, LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setQuiz(FillInTheBlanksQuiz newQuiz) {
    if (newQuiz != eInternalContainer() || (eContainerFeatureID() != LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ && newQuiz != null)) {
      if (EcoreUtil.isAncestor(this, newQuiz))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newQuiz != null)
        msgs = ((InternalEObject)newQuiz).eInverseAdd(this, LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ__STATEMENTS, FillInTheBlanksQuiz.class, msgs);
      msgs = basicSetQuiz(newQuiz, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ, newQuiz, newQuiz));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<FillInTheBlanksQuizStatementComponent> getStatements() {
    if (statements == null) {
      statements = new EObjectContainmentWithInverseEList<FillInTheBlanksQuizStatementComponent>(FillInTheBlanksQuizStatementComponent.class, this, LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__STATEMENTS, LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT);
    }
    return statements;
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
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetQuiz((FillInTheBlanksQuiz)otherEnd, msgs);
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__STATEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStatements()).basicAdd(otherEnd, msgs);
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
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ:
        return basicSetQuiz(null, msgs);
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__STATEMENTS:
        return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
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
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ:
        return eInternalContainer().eInverseRemove(this, LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ__STATEMENTS, FillInTheBlanksQuiz.class, msgs);
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
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ:
        return getQuiz();
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__STATEMENTS:
        return getStatements();
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
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ:
        setQuiz((FillInTheBlanksQuiz)newValue);
        return;
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__STATEMENTS:
        getStatements().clear();
        getStatements().addAll((Collection<? extends FillInTheBlanksQuizStatementComponent>)newValue);
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
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ:
        setQuiz((FillInTheBlanksQuiz)null);
        return;
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__STATEMENTS:
        getStatements().clear();
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
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__QUIZ:
        return getQuiz() != null;
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__STATEMENTS:
        return statements != null && !statements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FillInTheBlanksQuizStatementImpl
