/**
 */
package modelingassistant.impl;

import java.util.Collection;

import modelingassistant.Feedback;
import modelingassistant.LearningItem;
import modelingassistant.LearningResource;
import modelingassistant.Mistake;
import modelingassistant.MistakeType;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.ProblemStatement;
import modelingassistant.Solution;
import modelingassistant.Student;
import modelingassistant.UmlElement;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modeling Assistant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getLearningItems <em>Learning Items</em>}</li>
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getLearningResources <em>Learning Resources</em>}</li>
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getProblemStatements <em>Problem Statements</em>}</li>
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getUmlElements <em>Uml Elements</em>}</li>
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getStudents <em>Students</em>}</li>
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getFeedbacks <em>Feedbacks</em>}</li>
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getMistakes <em>Mistakes</em>}</li>
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getMistakeTypes <em>Mistake Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelingAssistantImpl extends MinimalEObjectImpl.Container implements ModelingAssistant {
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
   * The cached value of the '{@link #getProblemStatements() <em>Problem Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProblemStatements()
   * @generated
   * @ordered
   */
  protected EList<ProblemStatement> problemStatements;

  /**
   * The cached value of the '{@link #getSolutions() <em>Solutions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSolutions()
   * @generated
   * @ordered
   */
  protected EList<Solution> solutions;

  /**
   * The cached value of the '{@link #getUmlElements() <em>Uml Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUmlElements()
   * @generated
   * @ordered
   */
  protected EList<UmlElement> umlElements;

  /**
   * The cached value of the '{@link #getStudents() <em>Students</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStudents()
   * @generated
   * @ordered
   */
  protected EList<Student> students;

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
   * The cached value of the '{@link #getMistakes() <em>Mistakes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMistakes()
   * @generated
   * @ordered
   */
  protected EList<Mistake> mistakes;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelingAssistantImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.MODELING_ASSISTANT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LearningItem> getLearningItems() {
    if (learningItems == null) {
      learningItems = new EObjectContainmentWithInverseEList<LearningItem>(LearningItem.class, this, ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_ITEMS, ModelingassistantPackage.LEARNING_ITEM__MODELING_ASSISTANT);
    }
    return learningItems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LearningResource> getLearningResources() {
    if (learningResources == null) {
      learningResources = new EObjectContainmentWithInverseEList<LearningResource>(LearningResource.class, this, ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_RESOURCES, ModelingassistantPackage.LEARNING_RESOURCE__MODELING_ASSISTANT);
    }
    return learningResources;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ProblemStatement> getProblemStatements() {
    if (problemStatements == null) {
      problemStatements = new EObjectContainmentWithInverseEList<ProblemStatement>(ProblemStatement.class, this, ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS, ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT);
    }
    return problemStatements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Solution> getSolutions() {
    if (solutions == null) {
      solutions = new EObjectContainmentWithInverseEList<Solution>(Solution.class, this, ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS, ModelingassistantPackage.SOLUTION__MODELING_ASSISTANT);
    }
    return solutions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UmlElement> getUmlElements() {
    if (umlElements == null) {
      umlElements = new EObjectContainmentWithInverseEList<UmlElement>(UmlElement.class, this, ModelingassistantPackage.MODELING_ASSISTANT__UML_ELEMENTS, ModelingassistantPackage.UML_ELEMENT__MODELING_ASSISTANT);
    }
    return umlElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Student> getStudents() {
    if (students == null) {
      students = new EObjectContainmentWithInverseEList<Student>(Student.class, this, ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS, ModelingassistantPackage.STUDENT__MODELING_ASSISTANT);
    }
    return students;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feedback> getFeedbacks() {
    if (feedbacks == null) {
      feedbacks = new EObjectContainmentWithInverseEList<Feedback>(Feedback.class, this, ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACKS, ModelingassistantPackage.FEEDBACK__MODELING_ASSISTANT);
    }
    return feedbacks;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Mistake> getMistakes() {
    if (mistakes == null) {
      mistakes = new EObjectContainmentWithInverseEList<Mistake>(Mistake.class, this, ModelingassistantPackage.MODELING_ASSISTANT__MISTAKES, ModelingassistantPackage.MISTAKE__MODELING_ASSISTANT);
    }
    return mistakes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MistakeType> getMistakeTypes() {
    if (mistakeTypes == null) {
      mistakeTypes = new EObjectContainmentWithInverseEList<MistakeType>(MistakeType.class, this, ModelingassistantPackage.MODELING_ASSISTANT__MISTAKE_TYPES, ModelingassistantPackage.MISTAKE_TYPE__MODELING_ASSISTANT);
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
      case ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_ITEMS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getLearningItems()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_RESOURCES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getLearningResources()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getProblemStatements()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSolutions()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__UML_ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getUmlElements()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStudents()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACKS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeedbacks()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__MISTAKES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getMistakes()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__MISTAKE_TYPES:
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
      case ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_ITEMS:
        return ((InternalEList<?>)getLearningItems()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_RESOURCES:
        return ((InternalEList<?>)getLearningResources()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS:
        return ((InternalEList<?>)getProblemStatements()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS:
        return ((InternalEList<?>)getSolutions()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__UML_ELEMENTS:
        return ((InternalEList<?>)getUmlElements()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS:
        return ((InternalEList<?>)getStudents()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACKS:
        return ((InternalEList<?>)getFeedbacks()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__MISTAKES:
        return ((InternalEList<?>)getMistakes()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__MISTAKE_TYPES:
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
      case ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_ITEMS:
        return getLearningItems();
      case ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_RESOURCES:
        return getLearningResources();
      case ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS:
        return getProblemStatements();
      case ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS:
        return getSolutions();
      case ModelingassistantPackage.MODELING_ASSISTANT__UML_ELEMENTS:
        return getUmlElements();
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS:
        return getStudents();
      case ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACKS:
        return getFeedbacks();
      case ModelingassistantPackage.MODELING_ASSISTANT__MISTAKES:
        return getMistakes();
      case ModelingassistantPackage.MODELING_ASSISTANT__MISTAKE_TYPES:
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
      case ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_ITEMS:
        getLearningItems().clear();
        getLearningItems().addAll((Collection<? extends LearningItem>)newValue);
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_RESOURCES:
        getLearningResources().clear();
        getLearningResources().addAll((Collection<? extends LearningResource>)newValue);
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS:
        getProblemStatements().clear();
        getProblemStatements().addAll((Collection<? extends ProblemStatement>)newValue);
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS:
        getSolutions().clear();
        getSolutions().addAll((Collection<? extends Solution>)newValue);
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__UML_ELEMENTS:
        getUmlElements().clear();
        getUmlElements().addAll((Collection<? extends UmlElement>)newValue);
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS:
        getStudents().clear();
        getStudents().addAll((Collection<? extends Student>)newValue);
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACKS:
        getFeedbacks().clear();
        getFeedbacks().addAll((Collection<? extends Feedback>)newValue);
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__MISTAKES:
        getMistakes().clear();
        getMistakes().addAll((Collection<? extends Mistake>)newValue);
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__MISTAKE_TYPES:
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
      case ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_ITEMS:
        getLearningItems().clear();
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_RESOURCES:
        getLearningResources().clear();
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS:
        getProblemStatements().clear();
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS:
        getSolutions().clear();
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__UML_ELEMENTS:
        getUmlElements().clear();
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS:
        getStudents().clear();
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACKS:
        getFeedbacks().clear();
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__MISTAKES:
        getMistakes().clear();
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__MISTAKE_TYPES:
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
      case ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_ITEMS:
        return learningItems != null && !learningItems.isEmpty();
      case ModelingassistantPackage.MODELING_ASSISTANT__LEARNING_RESOURCES:
        return learningResources != null && !learningResources.isEmpty();
      case ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS:
        return problemStatements != null && !problemStatements.isEmpty();
      case ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS:
        return solutions != null && !solutions.isEmpty();
      case ModelingassistantPackage.MODELING_ASSISTANT__UML_ELEMENTS:
        return umlElements != null && !umlElements.isEmpty();
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS:
        return students != null && !students.isEmpty();
      case ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACKS:
        return feedbacks != null && !feedbacks.isEmpty();
      case ModelingassistantPackage.MODELING_ASSISTANT__MISTAKES:
        return mistakes != null && !mistakes.isEmpty();
      case ModelingassistantPackage.MODELING_ASSISTANT__MISTAKE_TYPES:
        return mistakeTypes != null && !mistakeTypes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModelingAssistantImpl
