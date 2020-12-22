/**
 */
package modelingassistant.impl;

import java.util.Collection;

import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.ProblemStatement;
import modelingassistant.ProblemStatementElement;

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
 * An implementation of the model object '<em><b>Problem Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.ProblemStatementImpl#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.impl.ProblemStatementImpl#getProblemStatementElements <em>Problem Statement Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProblemStatementImpl extends MinimalEObjectImpl.Container implements ProblemStatement {
  /**
   * The cached value of the '{@link #getModelingAssistant() <em>Modeling Assistant</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelingAssistant()
   * @generated
   * @ordered
   */
  protected ModelingAssistant modelingAssistant;

  /**
   * The cached value of the '{@link #getProblemStatementElements() <em>Problem Statement Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProblemStatementElements()
   * @generated
   * @ordered
   */
  protected EList<ProblemStatementElement> problemStatementElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProblemStatementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.PROBLEM_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingAssistant getModelingAssistant() {
    if (modelingAssistant != null && modelingAssistant.eIsProxy()) {
      InternalEObject oldModelingAssistant = (InternalEObject)modelingAssistant;
      modelingAssistant = (ModelingAssistant)eResolveProxy(oldModelingAssistant);
      if (modelingAssistant != oldModelingAssistant) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT, oldModelingAssistant, modelingAssistant));
      }
    }
    return modelingAssistant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingAssistant basicGetModelingAssistant() {
    return modelingAssistant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelingAssistant(ModelingAssistant newModelingAssistant, NotificationChain msgs) {
    ModelingAssistant oldModelingAssistant = modelingAssistant;
    modelingAssistant = newModelingAssistant;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT, oldModelingAssistant, newModelingAssistant);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelingAssistant(ModelingAssistant newModelingAssistant) {
    if (newModelingAssistant != modelingAssistant) {
      NotificationChain msgs = null;
      if (modelingAssistant != null)
        msgs = ((InternalEObject)modelingAssistant).eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS, ModelingAssistant.class, msgs);
      if (newModelingAssistant != null)
        msgs = ((InternalEObject)newModelingAssistant).eInverseAdd(this, ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS, ModelingAssistant.class, msgs);
      msgs = basicSetModelingAssistant(newModelingAssistant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT, newModelingAssistant, newModelingAssistant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ProblemStatementElement> getProblemStatementElements() {
    if (problemStatementElements == null) {
      problemStatementElements = new EObjectWithInverseResolvingEList<ProblemStatementElement>(ProblemStatementElement.class, this, ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS, ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT);
    }
    return problemStatementElements;
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        if (modelingAssistant != null)
          msgs = ((InternalEObject)modelingAssistant).eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS, ModelingAssistant.class, msgs);
        return basicSetModelingAssistant((ModelingAssistant)otherEnd, msgs);
      case ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getProblemStatementElements()).basicAdd(otherEnd, msgs);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        return basicSetModelingAssistant(null, msgs);
      case ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS:
        return ((InternalEList<?>)getProblemStatementElements()).basicRemove(otherEnd, msgs);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        if (resolve) return getModelingAssistant();
        return basicGetModelingAssistant();
      case ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS:
        return getProblemStatementElements();
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)newValue);
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS:
        getProblemStatementElements().clear();
        getProblemStatementElements().addAll((Collection<? extends ProblemStatementElement>)newValue);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)null);
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS:
        getProblemStatementElements().clear();
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        return modelingAssistant != null;
      case ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS:
        return problemStatementElements != null && !problemStatementElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ProblemStatementImpl