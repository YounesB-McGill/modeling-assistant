/**
 */
package learningcorpusquiz.impl;

import learningcorpusquiz.FillInTheBlanksQuizStatement;
import learningcorpusquiz.FillInTheBlanksQuizStatementComponent;
import learningcorpusquiz.LearningcorpusquizPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fill In The Blanks Quiz Statement Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.impl.FillInTheBlanksQuizStatementComponentImpl#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FillInTheBlanksQuizStatementComponentImpl extends MinimalEObjectImpl.Container implements FillInTheBlanksQuizStatementComponent {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FillInTheBlanksQuizStatementComponentImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LearningcorpusquizPackage.Literals.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FillInTheBlanksQuizStatement getStatement() {
    if (eContainerFeatureID() != LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT) return null;
    return (FillInTheBlanksQuizStatement)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatement(FillInTheBlanksQuizStatement newStatement, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newStatement, LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStatement(FillInTheBlanksQuizStatement newStatement) {
    if (newStatement != eInternalContainer() || (eContainerFeatureID() != LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT && newStatement != null)) {
      if (EcoreUtil.isAncestor(this, newStatement))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newStatement != null)
        msgs = ((InternalEObject)newStatement).eInverseAdd(this, LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__COMPONENTS, FillInTheBlanksQuizStatement.class, msgs);
      msgs = basicSetStatement(newStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT, newStatement, newStatement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetStatement((FillInTheBlanksQuizStatement)otherEnd, msgs);
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
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT:
        return basicSetStatement(null, msgs);
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
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT:
        return eInternalContainer().eInverseRemove(this, LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT__COMPONENTS, FillInTheBlanksQuizStatement.class, msgs);
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
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT:
        return getStatement();
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
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT:
        setStatement((FillInTheBlanksQuizStatement)newValue);
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
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT:
        setStatement((FillInTheBlanksQuizStatement)null);
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
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT__STATEMENT:
        return getStatement() != null;
    }
    return super.eIsSet(featureID);
  }

} //FillInTheBlanksQuizStatementComponentImpl
