/**
 */
package learningcorpus.impl;

import java.util.Collection;

import learningcorpus.ElementType;
import learningcorpus.LearningCorpus;
import learningcorpus.LearningItem;
import learningcorpus.LearningResource;
import learningcorpus.LearningcorpusPackage;
import learningcorpus.MistakeType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Learning Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpus.impl.LearningItemImpl#getLearningResources <em>Learning Resources</em>}</li>
 *   <li>{@link learningcorpus.impl.LearningItemImpl#getMistakeTypes <em>Mistake Types</em>}</li>
 *   <li>{@link learningcorpus.impl.LearningItemImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link learningcorpus.impl.LearningItemImpl#getLearningCorpus <em>Learning Corpus</em>}</li>
 *   <li>{@link learningcorpus.impl.LearningItemImpl#getElementType <em>Element Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LearningItemImpl extends NamedElementImpl implements LearningItem {
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
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getElementType() <em>Element Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementType()
   * @generated
   * @ordered
   */
  protected static final ElementType ELEMENT_TYPE_EDEFAULT = ElementType.CLASS;

  /**
   * The cached value of the '{@link #getElementType() <em>Element Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementType()
   * @generated
   * @ordered
   */
  protected ElementType elementType = ELEMENT_TYPE_EDEFAULT;

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
    return LearningcorpusPackage.Literals.LEARNING_ITEM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<LearningResource> getLearningResources() {
    if (learningResources == null) {
      learningResources = new EObjectWithInverseResolvingEList<LearningResource>(LearningResource.class, this, LearningcorpusPackage.LEARNING_ITEM__LEARNING_RESOURCES, LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_ITEM);
    }
    return learningResources;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<MistakeType> getMistakeTypes() {
    if (mistakeTypes == null) {
      mistakeTypes = new EObjectWithInverseResolvingEList<MistakeType>(MistakeType.class, this, LearningcorpusPackage.LEARNING_ITEM__MISTAKE_TYPES, LearningcorpusPackage.MISTAKE_TYPE__LEARNING_ITEM);
    }
    return mistakeTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDescription() {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDescription(String newDescription) {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.LEARNING_ITEM__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LearningCorpus getLearningCorpus() {
    if (eContainerFeatureID() != LearningcorpusPackage.LEARNING_ITEM__LEARNING_CORPUS) return null;
    return (LearningCorpus)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLearningCorpus(LearningCorpus newLearningCorpus, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newLearningCorpus, LearningcorpusPackage.LEARNING_ITEM__LEARNING_CORPUS, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLearningCorpus(LearningCorpus newLearningCorpus) {
    if (newLearningCorpus != eInternalContainer() || (eContainerFeatureID() != LearningcorpusPackage.LEARNING_ITEM__LEARNING_CORPUS && newLearningCorpus != null)) {
      if (EcoreUtil.isAncestor(this, newLearningCorpus))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newLearningCorpus != null)
        msgs = ((InternalEObject)newLearningCorpus).eInverseAdd(this, LearningcorpusPackage.LEARNING_CORPUS__LEARNING_ITEMS, LearningCorpus.class, msgs);
      msgs = basicSetLearningCorpus(newLearningCorpus, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.LEARNING_ITEM__LEARNING_CORPUS, newLearningCorpus, newLearningCorpus));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ElementType getElementType() {
    return elementType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setElementType(ElementType newElementType) {
    ElementType oldElementType = elementType;
    elementType = newElementType == null ? ELEMENT_TYPE_EDEFAULT : newElementType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.LEARNING_ITEM__ELEMENT_TYPE, oldElementType, elementType));
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
      case LearningcorpusPackage.LEARNING_ITEM__LEARNING_RESOURCES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getLearningResources()).basicAdd(otherEnd, msgs);
      case LearningcorpusPackage.LEARNING_ITEM__MISTAKE_TYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getMistakeTypes()).basicAdd(otherEnd, msgs);
      case LearningcorpusPackage.LEARNING_ITEM__LEARNING_CORPUS:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetLearningCorpus((LearningCorpus)otherEnd, msgs);
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
      case LearningcorpusPackage.LEARNING_ITEM__LEARNING_RESOURCES:
        return ((InternalEList<?>)getLearningResources()).basicRemove(otherEnd, msgs);
      case LearningcorpusPackage.LEARNING_ITEM__MISTAKE_TYPES:
        return ((InternalEList<?>)getMistakeTypes()).basicRemove(otherEnd, msgs);
      case LearningcorpusPackage.LEARNING_ITEM__LEARNING_CORPUS:
        return basicSetLearningCorpus(null, msgs);
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
      case LearningcorpusPackage.LEARNING_ITEM__LEARNING_CORPUS:
        return eInternalContainer().eInverseRemove(this, LearningcorpusPackage.LEARNING_CORPUS__LEARNING_ITEMS, LearningCorpus.class, msgs);
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
      case LearningcorpusPackage.LEARNING_ITEM__LEARNING_RESOURCES:
        return getLearningResources();
      case LearningcorpusPackage.LEARNING_ITEM__MISTAKE_TYPES:
        return getMistakeTypes();
      case LearningcorpusPackage.LEARNING_ITEM__DESCRIPTION:
        return getDescription();
      case LearningcorpusPackage.LEARNING_ITEM__LEARNING_CORPUS:
        return getLearningCorpus();
      case LearningcorpusPackage.LEARNING_ITEM__ELEMENT_TYPE:
        return getElementType();
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
      case LearningcorpusPackage.LEARNING_ITEM__LEARNING_RESOURCES:
        getLearningResources().clear();
        getLearningResources().addAll((Collection<? extends LearningResource>)newValue);
        return;
      case LearningcorpusPackage.LEARNING_ITEM__MISTAKE_TYPES:
        getMistakeTypes().clear();
        getMistakeTypes().addAll((Collection<? extends MistakeType>)newValue);
        return;
      case LearningcorpusPackage.LEARNING_ITEM__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case LearningcorpusPackage.LEARNING_ITEM__LEARNING_CORPUS:
        setLearningCorpus((LearningCorpus)newValue);
        return;
      case LearningcorpusPackage.LEARNING_ITEM__ELEMENT_TYPE:
        setElementType((ElementType)newValue);
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
      case LearningcorpusPackage.LEARNING_ITEM__LEARNING_RESOURCES:
        getLearningResources().clear();
        return;
      case LearningcorpusPackage.LEARNING_ITEM__MISTAKE_TYPES:
        getMistakeTypes().clear();
        return;
      case LearningcorpusPackage.LEARNING_ITEM__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case LearningcorpusPackage.LEARNING_ITEM__LEARNING_CORPUS:
        setLearningCorpus((LearningCorpus)null);
        return;
      case LearningcorpusPackage.LEARNING_ITEM__ELEMENT_TYPE:
        setElementType(ELEMENT_TYPE_EDEFAULT);
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
      case LearningcorpusPackage.LEARNING_ITEM__LEARNING_RESOURCES:
        return learningResources != null && !learningResources.isEmpty();
      case LearningcorpusPackage.LEARNING_ITEM__MISTAKE_TYPES:
        return mistakeTypes != null && !mistakeTypes.isEmpty();
      case LearningcorpusPackage.LEARNING_ITEM__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case LearningcorpusPackage.LEARNING_ITEM__LEARNING_CORPUS:
        return getLearningCorpus() != null;
      case LearningcorpusPackage.LEARNING_ITEM__ELEMENT_TYPE:
        return elementType != ELEMENT_TYPE_EDEFAULT;
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
    result.append(" (description: ");
    result.append(description);
    result.append(", elementType: ");
    result.append(elementType);
    result.append(')');
    return result.toString();
  }

} //LearningItemImpl
