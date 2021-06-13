/**
 */
package learningcorpus.impl;

import java.util.Collection;

import learningcorpus.LearningCorpus;
import learningcorpus.LearningcorpusPackage;
import learningcorpus.MistakeType;
import learningcorpus.MistakeTypeCategory;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mistake Type Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpus.impl.MistakeTypeCategoryImpl#getMistakeTypes <em>Mistake Types</em>}</li>
 *   <li>{@link learningcorpus.impl.MistakeTypeCategoryImpl#getSupercategory <em>Supercategory</em>}</li>
 *   <li>{@link learningcorpus.impl.MistakeTypeCategoryImpl#getSubcategories <em>Subcategories</em>}</li>
 *   <li>{@link learningcorpus.impl.MistakeTypeCategoryImpl#getLearningCorpus <em>Learning Corpus</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MistakeTypeCategoryImpl extends NamedElementImpl implements MistakeTypeCategory {
  /**
   * The cached value of the '{@link #getMistakeTypes() <em>Mistake Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMistakeTypes()
   * @generated
   * @ordered
   */
  protected EList<MistakeType> mistakeTypes;

  /**
   * The cached value of the '{@link #getSupercategory() <em>Supercategory</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupercategory()
   * @generated
   * @ordered
   */
  protected MistakeTypeCategory supercategory;

  /**
   * The cached value of the '{@link #getSubcategories() <em>Subcategories</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubcategories()
   * @generated
   * @ordered
   */
  protected EList<MistakeTypeCategory> subcategories;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MistakeTypeCategoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LearningcorpusPackage.Literals.MISTAKE_TYPE_CATEGORY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<MistakeType> getMistakeTypes() {
    if (mistakeTypes == null) {
      mistakeTypes = new EObjectContainmentWithInverseEList<MistakeType>(MistakeType.class, this, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES, LearningcorpusPackage.MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY);
    }
    return mistakeTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MistakeTypeCategory getSupercategory() {
    if (supercategory != null && supercategory.eIsProxy()) {
      InternalEObject oldSupercategory = (InternalEObject)supercategory;
      supercategory = (MistakeTypeCategory)eResolveProxy(oldSupercategory);
      if (supercategory != oldSupercategory) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY, oldSupercategory, supercategory));
      }
    }
    return supercategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeTypeCategory basicGetSupercategory() {
    return supercategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSupercategory(MistakeTypeCategory newSupercategory, NotificationChain msgs) {
    MistakeTypeCategory oldSupercategory = supercategory;
    supercategory = newSupercategory;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY, oldSupercategory, newSupercategory);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSupercategory(MistakeTypeCategory newSupercategory) {
    if (newSupercategory != supercategory) {
      NotificationChain msgs = null;
      if (supercategory != null)
        msgs = ((InternalEObject)supercategory).eInverseRemove(this, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES, MistakeTypeCategory.class, msgs);
      if (newSupercategory != null)
        msgs = ((InternalEObject)newSupercategory).eInverseAdd(this, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES, MistakeTypeCategory.class, msgs);
      msgs = basicSetSupercategory(newSupercategory, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY, newSupercategory, newSupercategory));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<MistakeTypeCategory> getSubcategories() {
    if (subcategories == null) {
      subcategories = new EObjectWithInverseResolvingEList<MistakeTypeCategory>(MistakeTypeCategory.class, this, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY);
    }
    return subcategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LearningCorpus getLearningCorpus() {
    if (eContainerFeatureID() != LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS) return null;
    return (LearningCorpus)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLearningCorpus(LearningCorpus newLearningCorpus, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newLearningCorpus, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLearningCorpus(LearningCorpus newLearningCorpus) {
    if (newLearningCorpus != eInternalContainer() || (eContainerFeatureID() != LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS && newLearningCorpus != null)) {
      if (EcoreUtil.isAncestor(this, newLearningCorpus))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newLearningCorpus != null)
        msgs = ((InternalEObject)newLearningCorpus).eInverseAdd(this, LearningcorpusPackage.LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES, LearningCorpus.class, msgs);
      msgs = basicSetLearningCorpus(newLearningCorpus, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS, newLearningCorpus, newLearningCorpus));
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
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getMistakeTypes()).basicAdd(otherEnd, msgs);
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY:
        if (supercategory != null)
          msgs = ((InternalEObject)supercategory).eInverseRemove(this, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES, MistakeTypeCategory.class, msgs);
        return basicSetSupercategory((MistakeTypeCategory)otherEnd, msgs);
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubcategories()).basicAdd(otherEnd, msgs);
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS:
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
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES:
        return ((InternalEList<?>)getMistakeTypes()).basicRemove(otherEnd, msgs);
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY:
        return basicSetSupercategory(null, msgs);
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES:
        return ((InternalEList<?>)getSubcategories()).basicRemove(otherEnd, msgs);
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS:
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
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS:
        return eInternalContainer().eInverseRemove(this, LearningcorpusPackage.LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES, LearningCorpus.class, msgs);
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
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES:
        return getMistakeTypes();
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY:
        if (resolve) return getSupercategory();
        return basicGetSupercategory();
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES:
        return getSubcategories();
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS:
        return getLearningCorpus();
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
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES:
        getMistakeTypes().clear();
        getMistakeTypes().addAll((Collection<? extends MistakeType>)newValue);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY:
        setSupercategory((MistakeTypeCategory)newValue);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES:
        getSubcategories().clear();
        getSubcategories().addAll((Collection<? extends MistakeTypeCategory>)newValue);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS:
        setLearningCorpus((LearningCorpus)newValue);
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
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES:
        getMistakeTypes().clear();
        return;
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY:
        setSupercategory((MistakeTypeCategory)null);
        return;
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES:
        getSubcategories().clear();
        return;
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS:
        setLearningCorpus((LearningCorpus)null);
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
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES:
        return mistakeTypes != null && !mistakeTypes.isEmpty();
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUPERCATEGORY:
        return supercategory != null;
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__SUBCATEGORIES:
        return subcategories != null && !subcategories.isEmpty();
      case LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS:
        return getLearningCorpus() != null;
    }
    return super.eIsSet(featureID);
  }

} //MistakeTypeCategoryImpl
