/**
 */
package learningcorpus.impl;

import java.util.Collection;

import learningcorpus.Feedback;
import learningcorpus.LearningCorpus;
import learningcorpus.LearningItem;
import learningcorpus.LearningResource;
import learningcorpus.LearningcorpusPackage;
import learningcorpus.MistakeTypeCategory;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Learning Corpus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpus.impl.LearningCorpusImpl#getMistakeTypeCategories <em>Mistake Type Categories</em>}</li>
 *   <li>{@link learningcorpus.impl.LearningCorpusImpl#getFeedbacks <em>Feedbacks</em>}</li>
 *   <li>{@link learningcorpus.impl.LearningCorpusImpl#getLearningItems <em>Learning Items</em>}</li>
 *   <li>{@link learningcorpus.impl.LearningCorpusImpl#getLearningResources <em>Learning Resources</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LearningCorpusImpl extends MinimalEObjectImpl.Container implements LearningCorpus {
  /**
   * The cached value of the '{@link #getMistakeTypeCategories() <em>Mistake Type Categories</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMistakeTypeCategories()
   * @generated
   * @ordered
   */
  protected EList<MistakeTypeCategory> mistakeTypeCategories;

  /**
   * The cached value of the '{@link #getFeedbacks() <em>Feedbacks</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeedbacks()
   * @generated
   * @ordered
   */
  protected EList<Feedback> feedbacks;

  /**
   * The cached value of the '{@link #getLearningItems() <em>Learning Items</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLearningItems()
   * @generated
   * @ordered
   */
  protected EList<LearningItem> learningItems;

  /**
   * The cached value of the '{@link #getLearningResources() <em>Learning Resources</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLearningResources()
   * @generated
   * @ordered
   */
  protected EList<LearningResource> learningResources;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LearningCorpusImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LearningcorpusPackage.Literals.LEARNING_CORPUS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<MistakeTypeCategory> getMistakeTypeCategories() {
    if (mistakeTypeCategories == null) {
      mistakeTypeCategories = new EObjectContainmentWithInverseEList<MistakeTypeCategory>(MistakeTypeCategory.class, this, LearningcorpusPackage.LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES, LearningcorpusPackage.MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS);
    }
    return mistakeTypeCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Feedback> getFeedbacks() {
    if (feedbacks == null) {
      feedbacks = new EObjectContainmentWithInverseEList<Feedback>(Feedback.class, this, LearningcorpusPackage.LEARNING_CORPUS__FEEDBACKS, LearningcorpusPackage.FEEDBACK__LEARNING_CORPUS);
    }
    return feedbacks;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<LearningItem> getLearningItems() {
    if (learningItems == null) {
      learningItems = new EObjectContainmentWithInverseEList<LearningItem>(LearningItem.class, this, LearningcorpusPackage.LEARNING_CORPUS__LEARNING_ITEMS, LearningcorpusPackage.LEARNING_ITEM__LEARNING_CORPUS);
    }
    return learningItems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<LearningResource> getLearningResources() {
    if (learningResources == null) {
      learningResources = new EObjectContainmentWithInverseEList<LearningResource>(LearningResource.class, this, LearningcorpusPackage.LEARNING_CORPUS__LEARNING_RESOURCES, LearningcorpusPackage.LEARNING_RESOURCE__LEARNING_CORPUS);
    }
    return learningResources;
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
      case LearningcorpusPackage.LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getMistakeTypeCategories()).basicAdd(otherEnd, msgs);
      case LearningcorpusPackage.LEARNING_CORPUS__FEEDBACKS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeedbacks()).basicAdd(otherEnd, msgs);
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_ITEMS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getLearningItems()).basicAdd(otherEnd, msgs);
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_RESOURCES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getLearningResources()).basicAdd(otherEnd, msgs);
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
      case LearningcorpusPackage.LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES:
        return ((InternalEList<?>)getMistakeTypeCategories()).basicRemove(otherEnd, msgs);
      case LearningcorpusPackage.LEARNING_CORPUS__FEEDBACKS:
        return ((InternalEList<?>)getFeedbacks()).basicRemove(otherEnd, msgs);
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_ITEMS:
        return ((InternalEList<?>)getLearningItems()).basicRemove(otherEnd, msgs);
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_RESOURCES:
        return ((InternalEList<?>)getLearningResources()).basicRemove(otherEnd, msgs);
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
      case LearningcorpusPackage.LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES:
        return getMistakeTypeCategories();
      case LearningcorpusPackage.LEARNING_CORPUS__FEEDBACKS:
        return getFeedbacks();
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_ITEMS:
        return getLearningItems();
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_RESOURCES:
        return getLearningResources();
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
      case LearningcorpusPackage.LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES:
        getMistakeTypeCategories().clear();
        getMistakeTypeCategories().addAll((Collection<? extends MistakeTypeCategory>)newValue);
        return;
      case LearningcorpusPackage.LEARNING_CORPUS__FEEDBACKS:
        getFeedbacks().clear();
        getFeedbacks().addAll((Collection<? extends Feedback>)newValue);
        return;
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_ITEMS:
        getLearningItems().clear();
        getLearningItems().addAll((Collection<? extends LearningItem>)newValue);
        return;
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_RESOURCES:
        getLearningResources().clear();
        getLearningResources().addAll((Collection<? extends LearningResource>)newValue);
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
      case LearningcorpusPackage.LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES:
        getMistakeTypeCategories().clear();
        return;
      case LearningcorpusPackage.LEARNING_CORPUS__FEEDBACKS:
        getFeedbacks().clear();
        return;
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_ITEMS:
        getLearningItems().clear();
        return;
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_RESOURCES:
        getLearningResources().clear();
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
      case LearningcorpusPackage.LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES:
        return mistakeTypeCategories != null && !mistakeTypeCategories.isEmpty();
      case LearningcorpusPackage.LEARNING_CORPUS__FEEDBACKS:
        return feedbacks != null && !feedbacks.isEmpty();
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_ITEMS:
        return learningItems != null && !learningItems.isEmpty();
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_RESOURCES:
        return learningResources != null && !learningResources.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //LearningCorpusImpl
