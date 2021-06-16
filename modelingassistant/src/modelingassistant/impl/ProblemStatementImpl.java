/**
 */
package modelingassistant.impl;

import java.util.Collection;

import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.ProblemStatement;
import modelingassistant.ProblemStatementElement;
import modelingassistant.Solution;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Problem Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.ProblemStatementImpl#getProblemStatementElements <em>Problem Statement Elements</em>}</li>
 *   <li>{@link modelingassistant.impl.ProblemStatementImpl#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.impl.ProblemStatementImpl#getStudentSolutions <em>Student Solutions</em>}</li>
 *   <li>{@link modelingassistant.impl.ProblemStatementImpl#getInstructorSolution <em>Instructor Solution</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProblemStatementImpl extends NamedElementImpl implements ProblemStatement {
  /**
   * The cached value of the '{@link #getProblemStatementElements() <em>Problem Statement Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProblemStatementElements()
   * @generated
   * @ordered
   */
  protected EList<ProblemStatementElement> problemStatementElements;

  /**
   * The cached value of the '{@link #getStudentSolutions() <em>Student Solutions</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStudentSolutions()
   * @generated
   * @ordered
   */
  protected EList<Solution> studentSolutions;

  /**
   * The cached value of the '{@link #getInstructorSolution() <em>Instructor Solution</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstructorSolution()
   * @generated
   * @ordered
   */
  protected Solution instructorSolution;

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
  @Override
  public EList<ProblemStatementElement> getProblemStatementElements() {
    if (problemStatementElements == null) {
      problemStatementElements = new EObjectContainmentWithInverseEList<ProblemStatementElement>(ProblemStatementElement.class, this, ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS, ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT);
    }
    return problemStatementElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ModelingAssistant getModelingAssistant() {
    if (eContainerFeatureID() != ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT) return null;
    return (ModelingAssistant)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelingAssistant(ModelingAssistant newModelingAssistant, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newModelingAssistant, ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setModelingAssistant(ModelingAssistant newModelingAssistant) {
    if (newModelingAssistant != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT && newModelingAssistant != null)) {
      if (EcoreUtil.isAncestor(this, newModelingAssistant))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
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
  @Override
  public EList<Solution> getStudentSolutions() {
    if (studentSolutions == null) {
      studentSolutions = new EObjectResolvingEList<Solution>(Solution.class, this, ModelingassistantPackage.PROBLEM_STATEMENT__STUDENT_SOLUTIONS);
    }
    return studentSolutions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Solution getInstructorSolution() {
    if (instructorSolution != null && instructorSolution.eIsProxy()) {
      InternalEObject oldInstructorSolution = (InternalEObject)instructorSolution;
      instructorSolution = (Solution)eResolveProxy(oldInstructorSolution);
      if (instructorSolution != oldInstructorSolution) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION, oldInstructorSolution, instructorSolution));
      }
    }
    return instructorSolution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Solution basicGetInstructorSolution() {
    return instructorSolution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setInstructorSolution(Solution newInstructorSolution) {
    Solution oldInstructorSolution = instructorSolution;
    instructorSolution = newInstructorSolution;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION, oldInstructorSolution, instructorSolution));
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getProblemStatementElements()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetModelingAssistant((ModelingAssistant)otherEnd, msgs);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS:
        return ((InternalEList<?>)getProblemStatementElements()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        return basicSetModelingAssistant(null, msgs);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS, ModelingAssistant.class, msgs);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS:
        return getProblemStatementElements();
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        return getModelingAssistant();
      case ModelingassistantPackage.PROBLEM_STATEMENT__STUDENT_SOLUTIONS:
        return getStudentSolutions();
      case ModelingassistantPackage.PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION:
        if (resolve) return getInstructorSolution();
        return basicGetInstructorSolution();
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS:
        getProblemStatementElements().clear();
        getProblemStatementElements().addAll((Collection<? extends ProblemStatementElement>)newValue);
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)newValue);
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT__STUDENT_SOLUTIONS:
        getStudentSolutions().clear();
        getStudentSolutions().addAll((Collection<? extends Solution>)newValue);
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION:
        setInstructorSolution((Solution)newValue);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS:
        getProblemStatementElements().clear();
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)null);
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT__STUDENT_SOLUTIONS:
        getStudentSolutions().clear();
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION:
        setInstructorSolution((Solution)null);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS:
        return problemStatementElements != null && !problemStatementElements.isEmpty();
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        return getModelingAssistant() != null;
      case ModelingassistantPackage.PROBLEM_STATEMENT__STUDENT_SOLUTIONS:
        return studentSolutions != null && !studentSolutions.isEmpty();
      case ModelingassistantPackage.PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION:
        return instructorSolution != null;
    }
    return super.eIsSet(featureID);
  }

} //ProblemStatementImpl
