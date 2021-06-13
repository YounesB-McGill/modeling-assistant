/**
 */
package learningcorpus.impl;

import java.util.Collection;

import learningcorpus.LearningCorpus;
import learningcorpus.LearningItem;
import learningcorpus.LearningcorpusPackage;
import learningcorpus.UmlElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Uml Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpus.impl.UmlElementImpl#getLearningItems <em>Learning Items</em>}</li>
 *   <li>{@link learningcorpus.impl.UmlElementImpl#getLearningCorpus <em>Learning Corpus</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UmlElementImpl extends MinimalEObjectImpl.Container implements UmlElement {
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
    return LearningcorpusPackage.Literals.UML_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<LearningItem> getLearningItems() {
    if (learningItems == null) {
      learningItems = new EObjectWithInverseResolvingEList.ManyInverse<LearningItem>(LearningItem.class, this, LearningcorpusPackage.UML_ELEMENT__LEARNING_ITEMS, LearningcorpusPackage.LEARNING_ITEM__UML_ELEMENTS);
    }
    return learningItems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LearningCorpus getLearningCorpus() {
    if (eContainerFeatureID() != LearningcorpusPackage.UML_ELEMENT__LEARNING_CORPUS) return null;
    return (LearningCorpus)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLearningCorpus(LearningCorpus newLearningCorpus, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newLearningCorpus, LearningcorpusPackage.UML_ELEMENT__LEARNING_CORPUS, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLearningCorpus(LearningCorpus newLearningCorpus) {
    if (newLearningCorpus != eInternalContainer() || (eContainerFeatureID() != LearningcorpusPackage.UML_ELEMENT__LEARNING_CORPUS && newLearningCorpus != null)) {
      if (EcoreUtil.isAncestor(this, newLearningCorpus))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newLearningCorpus != null)
        msgs = ((InternalEObject)newLearningCorpus).eInverseAdd(this, LearningcorpusPackage.LEARNING_CORPUS__UML_ELEMENTS, LearningCorpus.class, msgs);
      msgs = basicSetLearningCorpus(newLearningCorpus, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.UML_ELEMENT__LEARNING_CORPUS, newLearningCorpus, newLearningCorpus));
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
      case LearningcorpusPackage.UML_ELEMENT__LEARNING_ITEMS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getLearningItems()).basicAdd(otherEnd, msgs);
      case LearningcorpusPackage.UML_ELEMENT__LEARNING_CORPUS:
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
      case LearningcorpusPackage.UML_ELEMENT__LEARNING_ITEMS:
        return ((InternalEList<?>)getLearningItems()).basicRemove(otherEnd, msgs);
      case LearningcorpusPackage.UML_ELEMENT__LEARNING_CORPUS:
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
      case LearningcorpusPackage.UML_ELEMENT__LEARNING_CORPUS:
        return eInternalContainer().eInverseRemove(this, LearningcorpusPackage.LEARNING_CORPUS__UML_ELEMENTS, LearningCorpus.class, msgs);
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
      case LearningcorpusPackage.UML_ELEMENT__LEARNING_ITEMS:
        return getLearningItems();
      case LearningcorpusPackage.UML_ELEMENT__LEARNING_CORPUS:
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
      case LearningcorpusPackage.UML_ELEMENT__LEARNING_ITEMS:
        getLearningItems().clear();
        getLearningItems().addAll((Collection<? extends LearningItem>)newValue);
        return;
      case LearningcorpusPackage.UML_ELEMENT__LEARNING_CORPUS:
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
      case LearningcorpusPackage.UML_ELEMENT__LEARNING_ITEMS:
        getLearningItems().clear();
        return;
      case LearningcorpusPackage.UML_ELEMENT__LEARNING_CORPUS:
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
      case LearningcorpusPackage.UML_ELEMENT__LEARNING_ITEMS:
        return learningItems != null && !learningItems.isEmpty();
      case LearningcorpusPackage.UML_ELEMENT__LEARNING_CORPUS:
        return getLearningCorpus() != null;
    }
    return super.eIsSet(featureID);
  }

} //UmlElementImpl
