/**
 */
package modelingassistant.impl;

import modelingassistant.ModelingassistantPackage;
import modelingassistant.SolutionElement;
import modelingassistant.Synonym;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Synonym</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.SynonymImpl#getSolutionElement <em>Solution Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SynonymImpl extends NamedElementImpl implements Synonym {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SynonymImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.SYNONYM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SolutionElement getSolutionElement() {
    if (eContainerFeatureID() != ModelingassistantPackage.SYNONYM__SOLUTION_ELEMENT) return null;
    return (SolutionElement)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSolutionElement(SolutionElement newSolutionElement, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newSolutionElement, ModelingassistantPackage.SYNONYM__SOLUTION_ELEMENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSolutionElement(SolutionElement newSolutionElement) {
    if (newSolutionElement != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.SYNONYM__SOLUTION_ELEMENT && newSolutionElement != null)) {
      if (EcoreUtil.isAncestor(this, newSolutionElement))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newSolutionElement != null)
        msgs = ((InternalEObject)newSolutionElement).eInverseAdd(this, ModelingassistantPackage.SOLUTION_ELEMENT__SYNONYMS, SolutionElement.class, msgs);
      msgs = basicSetSolutionElement(newSolutionElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.SYNONYM__SOLUTION_ELEMENT, newSolutionElement, newSolutionElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelingassistantPackage.SYNONYM__SOLUTION_ELEMENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetSolutionElement((SolutionElement)otherEnd, msgs);
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
      case ModelingassistantPackage.SYNONYM__SOLUTION_ELEMENT:
        return basicSetSolutionElement(null, msgs);
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
      case ModelingassistantPackage.SYNONYM__SOLUTION_ELEMENT:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.SOLUTION_ELEMENT__SYNONYMS, SolutionElement.class, msgs);
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
      case ModelingassistantPackage.SYNONYM__SOLUTION_ELEMENT:
        return getSolutionElement();
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
      case ModelingassistantPackage.SYNONYM__SOLUTION_ELEMENT:
        setSolutionElement((SolutionElement)newValue);
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
      case ModelingassistantPackage.SYNONYM__SOLUTION_ELEMENT:
        setSolutionElement((SolutionElement)null);
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
      case ModelingassistantPackage.SYNONYM__SOLUTION_ELEMENT:
        return getSolutionElement() != null;
    }
    return super.eIsSet(featureID);
  }

} //SynonymImpl
