/**
 */
package modelingassistant.impl;

import java.util.Collection;

import modelingassistant.LearningItem;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.SolutionElement;
import modelingassistant.UmlElement;

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
 * An implementation of the model object '<em><b>Uml Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.UmlElementImpl#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.impl.UmlElementImpl#getSolutionElements <em>Solution Elements</em>}</li>
 *   <li>{@link modelingassistant.impl.UmlElementImpl#getLearningItems <em>Learning Items</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UmlElementImpl extends MinimalEObjectImpl.Container implements UmlElement {
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
   * The cached value of the '{@link #getSolutionElements() <em>Solution Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSolutionElements()
   * @generated
   * @ordered
   */
  protected EList<SolutionElement> solutionElements;

  /**
   * The cached value of the '{@link #getLearningItems() <em>Learning Items</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLearningItems()
   * @generated
   * @ordered
   */
  protected EList<LearningItem> learningItems;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UmlElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.UML_ELEMENT;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.UML_ELEMENT__MODELING_ASSISTANT, oldModelingAssistant, modelingAssistant));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.UML_ELEMENT__MODELING_ASSISTANT, oldModelingAssistant, newModelingAssistant);
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
        msgs = ((InternalEObject)modelingAssistant).eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__UML_ELEMENTS, ModelingAssistant.class, msgs);
      if (newModelingAssistant != null)
        msgs = ((InternalEObject)newModelingAssistant).eInverseAdd(this, ModelingassistantPackage.MODELING_ASSISTANT__UML_ELEMENTS, ModelingAssistant.class, msgs);
      msgs = basicSetModelingAssistant(newModelingAssistant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.UML_ELEMENT__MODELING_ASSISTANT, newModelingAssistant, newModelingAssistant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SolutionElement> getSolutionElements() {
    if (solutionElements == null) {
      solutionElements = new EObjectWithInverseResolvingEList<SolutionElement>(SolutionElement.class, this, ModelingassistantPackage.UML_ELEMENT__SOLUTION_ELEMENTS, ModelingassistantPackage.SOLUTION_ELEMENT__TYPE);
    }
    return solutionElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LearningItem> getLearningItems() {
    if (learningItems == null) {
      learningItems = new EObjectWithInverseResolvingEList.ManyInverse<LearningItem>(LearningItem.class, this, ModelingassistantPackage.UML_ELEMENT__LEARNING_ITEMS, ModelingassistantPackage.LEARNING_ITEM__UML_ELEMENTS);
    }
    return learningItems;
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
      case ModelingassistantPackage.UML_ELEMENT__MODELING_ASSISTANT:
        if (modelingAssistant != null)
          msgs = ((InternalEObject)modelingAssistant).eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__UML_ELEMENTS, ModelingAssistant.class, msgs);
        return basicSetModelingAssistant((ModelingAssistant)otherEnd, msgs);
      case ModelingassistantPackage.UML_ELEMENT__SOLUTION_ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSolutionElements()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.UML_ELEMENT__LEARNING_ITEMS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getLearningItems()).basicAdd(otherEnd, msgs);
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
      case ModelingassistantPackage.UML_ELEMENT__MODELING_ASSISTANT:
        return basicSetModelingAssistant(null, msgs);
      case ModelingassistantPackage.UML_ELEMENT__SOLUTION_ELEMENTS:
        return ((InternalEList<?>)getSolutionElements()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.UML_ELEMENT__LEARNING_ITEMS:
        return ((InternalEList<?>)getLearningItems()).basicRemove(otherEnd, msgs);
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
      case ModelingassistantPackage.UML_ELEMENT__MODELING_ASSISTANT:
        if (resolve) return getModelingAssistant();
        return basicGetModelingAssistant();
      case ModelingassistantPackage.UML_ELEMENT__SOLUTION_ELEMENTS:
        return getSolutionElements();
      case ModelingassistantPackage.UML_ELEMENT__LEARNING_ITEMS:
        return getLearningItems();
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
      case ModelingassistantPackage.UML_ELEMENT__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)newValue);
        return;
      case ModelingassistantPackage.UML_ELEMENT__SOLUTION_ELEMENTS:
        getSolutionElements().clear();
        getSolutionElements().addAll((Collection<? extends SolutionElement>)newValue);
        return;
      case ModelingassistantPackage.UML_ELEMENT__LEARNING_ITEMS:
        getLearningItems().clear();
        getLearningItems().addAll((Collection<? extends LearningItem>)newValue);
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
      case ModelingassistantPackage.UML_ELEMENT__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)null);
        return;
      case ModelingassistantPackage.UML_ELEMENT__SOLUTION_ELEMENTS:
        getSolutionElements().clear();
        return;
      case ModelingassistantPackage.UML_ELEMENT__LEARNING_ITEMS:
        getLearningItems().clear();
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
      case ModelingassistantPackage.UML_ELEMENT__MODELING_ASSISTANT:
        return modelingAssistant != null;
      case ModelingassistantPackage.UML_ELEMENT__SOLUTION_ELEMENTS:
        return solutionElements != null && !solutionElements.isEmpty();
      case ModelingassistantPackage.UML_ELEMENT__LEARNING_ITEMS:
        return learningItems != null && !learningItems.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //UmlElementImpl
