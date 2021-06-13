/**
 */
package modelingassistant.impl;

import java.util.Collection;

import modelingassistant.FeedbackItem;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.ProblemStatement;
import modelingassistant.Solution;
import modelingassistant.Student;
import modelingassistant.StudentKnowledge;

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
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getProblemStatements <em>Problem Statements</em>}</li>
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getStudents <em>Students</em>}</li>
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getStudentKnowledges <em>Student Knowledges</em>}</li>
 *   <li>{@link modelingassistant.impl.ModelingAssistantImpl#getFeedbackItems <em>Feedback Items</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelingAssistantImpl extends MinimalEObjectImpl.Container implements ModelingAssistant {
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
   * The cached value of the '{@link #getStudents() <em>Students</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStudents()
   * @generated
   * @ordered
   */
  protected EList<Student> students;

  /**
   * The cached value of the '{@link #getStudentKnowledges() <em>Student Knowledges</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStudentKnowledges()
   * @generated
   * @ordered
   */
  protected EList<StudentKnowledge> studentKnowledges;

  /**
   * The cached value of the '{@link #getFeedbackItems() <em>Feedback Items</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeedbackItems()
   * @generated
   * @ordered
   */
  protected EList<FeedbackItem> feedbackItems;

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
  @Override
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
  @Override
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
  @Override
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
  @Override
  public EList<StudentKnowledge> getStudentKnowledges() {
    if (studentKnowledges == null) {
      studentKnowledges = new EObjectContainmentWithInverseEList<StudentKnowledge>(StudentKnowledge.class, this, ModelingassistantPackage.MODELING_ASSISTANT__STUDENT_KNOWLEDGES, ModelingassistantPackage.STUDENT_KNOWLEDGE__MODELING_ASSISTANT);
    }
    return studentKnowledges;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<FeedbackItem> getFeedbackItems() {
    if (feedbackItems == null) {
      feedbackItems = new EObjectContainmentWithInverseEList<FeedbackItem>(FeedbackItem.class, this, ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACK_ITEMS, ModelingassistantPackage.FEEDBACK_ITEM__MODELING_ASSISTANT);
    }
    return feedbackItems;
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
      case ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getProblemStatements()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSolutions()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStudents()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENT_KNOWLEDGES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStudentKnowledges()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACK_ITEMS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeedbackItems()).basicAdd(otherEnd, msgs);
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
      case ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS:
        return ((InternalEList<?>)getProblemStatements()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS:
        return ((InternalEList<?>)getSolutions()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS:
        return ((InternalEList<?>)getStudents()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENT_KNOWLEDGES:
        return ((InternalEList<?>)getStudentKnowledges()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACK_ITEMS:
        return ((InternalEList<?>)getFeedbackItems()).basicRemove(otherEnd, msgs);
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
      case ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS:
        return getProblemStatements();
      case ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS:
        return getSolutions();
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS:
        return getStudents();
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENT_KNOWLEDGES:
        return getStudentKnowledges();
      case ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACK_ITEMS:
        return getFeedbackItems();
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
      case ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS:
        getProblemStatements().clear();
        getProblemStatements().addAll((Collection<? extends ProblemStatement>)newValue);
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS:
        getSolutions().clear();
        getSolutions().addAll((Collection<? extends Solution>)newValue);
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS:
        getStudents().clear();
        getStudents().addAll((Collection<? extends Student>)newValue);
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENT_KNOWLEDGES:
        getStudentKnowledges().clear();
        getStudentKnowledges().addAll((Collection<? extends StudentKnowledge>)newValue);
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACK_ITEMS:
        getFeedbackItems().clear();
        getFeedbackItems().addAll((Collection<? extends FeedbackItem>)newValue);
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
      case ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS:
        getProblemStatements().clear();
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS:
        getSolutions().clear();
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS:
        getStudents().clear();
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENT_KNOWLEDGES:
        getStudentKnowledges().clear();
        return;
      case ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACK_ITEMS:
        getFeedbackItems().clear();
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
      case ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS:
        return problemStatements != null && !problemStatements.isEmpty();
      case ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS:
        return solutions != null && !solutions.isEmpty();
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS:
        return students != null && !students.isEmpty();
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENT_KNOWLEDGES:
        return studentKnowledges != null && !studentKnowledges.isEmpty();
      case ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACK_ITEMS:
        return feedbackItems != null && !feedbackItems.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModelingAssistantImpl
