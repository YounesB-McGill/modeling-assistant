/**
 */
package modelingassistant.impl;

import java.util.Collection;

import modelingassistant.ModelingassistantPackage;
import modelingassistant.ProblemStatement;
import modelingassistant.ProblemStatementElement;
import modelingassistant.SolutionElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Problem Statement Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.ProblemStatementElementImpl#getProblemStatement <em>Problem Statement</em>}</li>
 *   <li>{@link modelingassistant.impl.ProblemStatementElementImpl#getSolutionElements <em>Solution Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProblemStatementElementImpl extends MinimalEObjectImpl.Container implements ProblemStatementElement {
  /**
   * The cached value of the '{@link #getProblemStatement() <em>Problem Statement</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProblemStatement()
   * @generated
   * @ordered
   */
  protected ProblemStatement problemStatement;

  /**
   * The cached value of the '{@link #getSolutionElements() <em>Solution Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSolutionElements()
   * @generated
   * @ordered
   */
  protected EList<SolutionElement> solutionElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProblemStatementElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.PROBLEM_STATEMENT_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProblemStatement getProblemStatement() {
    if (problemStatement != null && problemStatement.eIsProxy()) {
      InternalEObject oldProblemStatement = (InternalEObject)problemStatement;
      problemStatement = (ProblemStatement)eResolveProxy(oldProblemStatement);
      if (problemStatement != oldProblemStatement) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT, oldProblemStatement, problemStatement));
      }
    }
    return problemStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProblemStatement basicGetProblemStatement() {
    return problemStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProblemStatement(ProblemStatement newProblemStatement, NotificationChain msgs) {
    ProblemStatement oldProblemStatement = problemStatement;
    problemStatement = newProblemStatement;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT, oldProblemStatement, newProblemStatement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProblemStatement(ProblemStatement newProblemStatement) {
    if (newProblemStatement != problemStatement) {
      NotificationChain msgs = null;
      if (problemStatement != null)
        msgs = ((InternalEObject)problemStatement).eInverseRemove(this, ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS, ProblemStatement.class, msgs);
      if (newProblemStatement != null)
        msgs = ((InternalEObject)newProblemStatement).eInverseAdd(this, ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS, ProblemStatement.class, msgs);
      msgs = basicSetProblemStatement(newProblemStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT, newProblemStatement, newProblemStatement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SolutionElement> getSolutionElements() {
    if (solutionElements == null) {
      solutionElements = new EObjectWithInverseResolvingEList.ManyInverse<SolutionElement>(SolutionElement.class, this, ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__SOLUTION_ELEMENTS, ModelingassistantPackage.SOLUTION_ELEMENT__PROBLEM_STATEMENT_ELEMENTS);
    }
    return solutionElements;
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
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT:
        if (problemStatement != null)
          msgs = ((InternalEObject)problemStatement).eInverseRemove(this, ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS, ProblemStatement.class, msgs);
        return basicSetProblemStatement((ProblemStatement)otherEnd, msgs);
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__SOLUTION_ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSolutionElements()).basicAdd(otherEnd, msgs);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT:
        return basicSetProblemStatement(null, msgs);
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__SOLUTION_ELEMENTS:
        return ((InternalEList<?>)getSolutionElements()).basicRemove(otherEnd, msgs);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT:
        if (resolve) return getProblemStatement();
        return basicGetProblemStatement();
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__SOLUTION_ELEMENTS:
        return getSolutionElements();
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
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT:
        setProblemStatement((ProblemStatement)newValue);
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__SOLUTION_ELEMENTS:
        getSolutionElements().clear();
        getSolutionElements().addAll((Collection<? extends SolutionElement>)newValue);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT:
        setProblemStatement((ProblemStatement)null);
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__SOLUTION_ELEMENTS:
        getSolutionElements().clear();
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
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT:
        return problemStatement != null;
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__SOLUTION_ELEMENTS:
        return solutionElements != null && !solutionElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ProblemStatementElementImpl
