/**
 */
package modelingassistant.impl;

import java.util.Collection;

import modelingassistant.LearningItem;
import modelingassistant.LearningResource;
import modelingassistant.MistakeType;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
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
 * An implementation of the model object '<em><b>Learning Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.LearningItemImpl#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.impl.LearningItemImpl#getUmlElements <em>Uml Elements</em>}</li>
 *   <li>{@link modelingassistant.impl.LearningItemImpl#getLearningResources <em>Learning Resources</em>}</li>
 *   <li>{@link modelingassistant.impl.LearningItemImpl#getMistakeTypes <em>Mistake Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LearningItemImpl extends MinimalEObjectImpl.Container implements LearningItem {
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
   * The cached value of the '{@link #getUmlElements() <em>Uml Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUmlElements()
   * @generated
   * @ordered
   */
  protected EList<UmlElement> umlElements;

  /**
   * The cached value of the '{@link #getLearningResources() <em>Learning Resources</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLearningResources()
   * @generated
   * @ordered
   */
  protected EList<LearningResource> learningResources;

  /**
   * The cached value of the '{@link #getMistakeTypes() <em>Mistake Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMistakeTypes()
   * @generated
   * @ordered
   */
  protected EList<MistakeType> mistakeTypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LearningItemImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.LEARNING_ITEM;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.LEARNING_ITEM__MODELING_ASSISTANT, oldModelingAssistant, modelingAssistant));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.LEARNING_ITEM__MODELING_ASSISTANT, oldModelingAssistant, newModelingAssistant);
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
        msgs = ((InternalEObject)modelingAssistant).eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_ITEMS, ModelingAssistant.class, msgs);
      if (newModelingAssistant != null)
        msgs = ((InternalEObject)newModelingAssistant).eInverseAdd(this, ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_ITEMS, ModelingAssistant.class, msgs);
      msgs = basicSetModelingAssistant(newModelingAssistant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.LEARNING_ITEM__MODELING_ASSISTANT, newModelingAssistant, newModelingAssistant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UmlElement> getUmlElements() {
    if (umlElements == null) {
      umlElements = new EObjectWithInverseResolvingEList.ManyInverse<UmlElement>(UmlElement.class, this, ModelingassistantPackage.LEARNING_ITEM__UML_ELEMENTS, ModelingassistantPackage.UML_ELEMENT__LEARNING_ITEMS);
    }
    return umlElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LearningResource> getLearningResources() {
    if (learningResources == null) {
      learningResources = new EObjectWithInverseResolvingEList<LearningResource>(LearningResource.class, this, ModelingassistantPackage.LEARNING_ITEM__LEARNING_RESOURCES, ModelingassistantPackage.LEARNING_RESOURCE__LEARNING_ITEM);
    }
    return learningResources;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MistakeType> getMistakeTypes() {
    if (mistakeTypes == null) {
      mistakeTypes = new EObjectWithInverseResolvingEList<MistakeType>(MistakeType.class, this, ModelingassistantPackage.LEARNING_ITEM__MISTAKE_TYPES, ModelingassistantPackage.MISTAKE_TYPE__LEARNING_ITEM);
    }
    return mistakeTypes;
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
      case ModelingassistantPackage.LEARNING_ITEM__MODELING_ASSISTANT:
        if (modelingAssistant != null)
          msgs = ((InternalEObject)modelingAssistant).eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_ITEMS, ModelingAssistant.class, msgs);
        return basicSetModelingAssistant((ModelingAssistant)otherEnd, msgs);
      case ModelingassistantPackage.LEARNING_ITEM__UML_ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getUmlElements()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.LEARNING_ITEM__LEARNING_RESOURCES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getLearningResources()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.LEARNING_ITEM__MISTAKE_TYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getMistakeTypes()).basicAdd(otherEnd, msgs);
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
      case ModelingassistantPackage.LEARNING_ITEM__MODELING_ASSISTANT:
        return basicSetModelingAssistant(null, msgs);
      case ModelingassistantPackage.LEARNING_ITEM__UML_ELEMENTS:
        return ((InternalEList<?>)getUmlElements()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.LEARNING_ITEM__LEARNING_RESOURCES:
        return ((InternalEList<?>)getLearningResources()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.LEARNING_ITEM__MISTAKE_TYPES:
        return ((InternalEList<?>)getMistakeTypes()).basicRemove(otherEnd, msgs);
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
      case ModelingassistantPackage.LEARNING_ITEM__MODELING_ASSISTANT:
        if (resolve) return getModelingAssistant();
        return basicGetModelingAssistant();
      case ModelingassistantPackage.LEARNING_ITEM__UML_ELEMENTS:
        return getUmlElements();
      case ModelingassistantPackage.LEARNING_ITEM__LEARNING_RESOURCES:
        return getLearningResources();
      case ModelingassistantPackage.LEARNING_ITEM__MISTAKE_TYPES:
        return getMistakeTypes();
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
      case ModelingassistantPackage.LEARNING_ITEM__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)newValue);
        return;
      case ModelingassistantPackage.LEARNING_ITEM__UML_ELEMENTS:
        getUmlElements().clear();
        getUmlElements().addAll((Collection<? extends UmlElement>)newValue);
        return;
      case ModelingassistantPackage.LEARNING_ITEM__LEARNING_RESOURCES:
        getLearningResources().clear();
        getLearningResources().addAll((Collection<? extends LearningResource>)newValue);
        return;
      case ModelingassistantPackage.LEARNING_ITEM__MISTAKE_TYPES:
        getMistakeTypes().clear();
        getMistakeTypes().addAll((Collection<? extends MistakeType>)newValue);
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
      case ModelingassistantPackage.LEARNING_ITEM__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)null);
        return;
      case ModelingassistantPackage.LEARNING_ITEM__UML_ELEMENTS:
        getUmlElements().clear();
        return;
      case ModelingassistantPackage.LEARNING_ITEM__LEARNING_RESOURCES:
        getLearningResources().clear();
        return;
      case ModelingassistantPackage.LEARNING_ITEM__MISTAKE_TYPES:
        getMistakeTypes().clear();
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
      case ModelingassistantPackage.LEARNING_ITEM__MODELING_ASSISTANT:
        return modelingAssistant != null;
      case ModelingassistantPackage.LEARNING_ITEM__UML_ELEMENTS:
        return umlElements != null && !umlElements.isEmpty();
      case ModelingassistantPackage.LEARNING_ITEM__LEARNING_RESOURCES:
        return learningResources != null && !learningResources.isEmpty();
      case ModelingassistantPackage.LEARNING_ITEM__MISTAKE_TYPES:
        return mistakeTypes != null && !mistakeTypes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //LearningItemImpl