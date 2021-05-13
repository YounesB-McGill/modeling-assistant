/**
 */
package modelingassistant.impl;

import classdiagram.NamedElement;

import java.util.Collection;

import modelingassistant.Mistake;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.ProblemStatementElement;
import modelingassistant.Solution;
import modelingassistant.SolutionElement;
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
 * An implementation of the model object '<em><b>Solution Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.SolutionElementImpl#getProblemStatementElements <em>Problem Statement Elements</em>}</li>
 *   <li>{@link modelingassistant.impl.SolutionElementImpl#getSolution <em>Solution</em>}</li>
 *   <li>{@link modelingassistant.impl.SolutionElementImpl#getStudentElementMistakes <em>Student Element Mistakes</em>}</li>
 *   <li>{@link modelingassistant.impl.SolutionElementImpl#getElement <em>Element</em>}</li>
 *   <li>{@link modelingassistant.impl.SolutionElementImpl#getInstructorElementMistakes <em>Instructor Element Mistakes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionElementImpl extends MinimalEObjectImpl.Container implements SolutionElement {
  /**
   * The cached value of the '{@link #getProblemStatementElements() <em>Problem Statement Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProblemStatementElements()
   * @generated
   * @ordered
   */
  protected EList<ProblemStatementElement> problemStatementElements;

  /**
   * The cached value of the '{@link #getStudentElementMistakes() <em>Student Element Mistakes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStudentElementMistakes()
   * @generated
   * @ordered
   */
  protected EList<Mistake> studentElementMistakes;

  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected NamedElement element;

  /**
   * The cached value of the '{@link #getInstructorElementMistakes() <em>Instructor Element Mistakes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstructorElementMistakes()
   * @generated
   * @ordered
   */
  protected EList<Mistake> instructorElementMistakes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SolutionElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.SOLUTION_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ProblemStatementElement> getProblemStatementElements() {
    if (problemStatementElements == null) {
      problemStatementElements = new EObjectWithInverseResolvingEList.ManyInverse<ProblemStatementElement>(ProblemStatementElement.class, this, ModelingassistantPackage.SOLUTION_ELEMENT__PROBLEM_STATEMENT_ELEMENTS, ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT__SOLUTION_ELEMENTS);
    }
    return problemStatementElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Solution getSolution() {
    if (eContainerFeatureID() != ModelingassistantPackage.SOLUTION_ELEMENT__SOLUTION) return null;
    return (Solution)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSolution(Solution newSolution, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newSolution, ModelingassistantPackage.SOLUTION_ELEMENT__SOLUTION, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSolution(Solution newSolution) {
    if (newSolution != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.SOLUTION_ELEMENT__SOLUTION && newSolution != null)) {
      if (EcoreUtil.isAncestor(this, newSolution))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newSolution != null)
        msgs = ((InternalEObject)newSolution).eInverseAdd(this, ModelingassistantPackage.SOLUTION__SOLUTION_ELEMENTS, Solution.class, msgs);
      msgs = basicSetSolution(newSolution, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.SOLUTION_ELEMENT__SOLUTION, newSolution, newSolution));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Mistake> getStudentElementMistakes() {
    if (studentElementMistakes == null) {
      studentElementMistakes = new EObjectWithInverseResolvingEList.ManyInverse<Mistake>(Mistake.class, this, ModelingassistantPackage.SOLUTION_ELEMENT__STUDENT_ELEMENT_MISTAKES, ModelingassistantPackage.MISTAKE__STUDENT_ELEMENTS);
    }
    return studentElementMistakes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement getElement() {
    if (element != null && element.eIsProxy()) {
      InternalEObject oldElement = (InternalEObject)element;
      element = (NamedElement)eResolveProxy(oldElement);
      if (element != oldElement) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.SOLUTION_ELEMENT__ELEMENT, oldElement, element));
      }
    }
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetElement() {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(NamedElement newElement) {
    NamedElement oldElement = element;
    element = newElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.SOLUTION_ELEMENT__ELEMENT, oldElement, element));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Mistake> getInstructorElementMistakes() {
    if (instructorElementMistakes == null) {
      instructorElementMistakes = new EObjectWithInverseResolvingEList.ManyInverse<Mistake>(Mistake.class, this, ModelingassistantPackage.SOLUTION_ELEMENT__INSTRUCTOR_ELEMENT_MISTAKES, ModelingassistantPackage.MISTAKE__INSTRUCTOR_ELEMENTS);
    }
    return instructorElementMistakes;
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
      case ModelingassistantPackage.SOLUTION_ELEMENT__PROBLEM_STATEMENT_ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getProblemStatementElements()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.SOLUTION_ELEMENT__SOLUTION:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetSolution((Solution)otherEnd, msgs);
      case ModelingassistantPackage.SOLUTION_ELEMENT__STUDENT_ELEMENT_MISTAKES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStudentElementMistakes()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.SOLUTION_ELEMENT__INSTRUCTOR_ELEMENT_MISTAKES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getInstructorElementMistakes()).basicAdd(otherEnd, msgs);
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
      case ModelingassistantPackage.SOLUTION_ELEMENT__PROBLEM_STATEMENT_ELEMENTS:
        return ((InternalEList<?>)getProblemStatementElements()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.SOLUTION_ELEMENT__SOLUTION:
        return basicSetSolution(null, msgs);
      case ModelingassistantPackage.SOLUTION_ELEMENT__STUDENT_ELEMENT_MISTAKES:
        return ((InternalEList<?>)getStudentElementMistakes()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.SOLUTION_ELEMENT__INSTRUCTOR_ELEMENT_MISTAKES:
        return ((InternalEList<?>)getInstructorElementMistakes()).basicRemove(otherEnd, msgs);
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
      case ModelingassistantPackage.SOLUTION_ELEMENT__SOLUTION:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.SOLUTION__SOLUTION_ELEMENTS, Solution.class, msgs);
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
      case ModelingassistantPackage.SOLUTION_ELEMENT__PROBLEM_STATEMENT_ELEMENTS:
        return getProblemStatementElements();
      case ModelingassistantPackage.SOLUTION_ELEMENT__SOLUTION:
        return getSolution();
      case ModelingassistantPackage.SOLUTION_ELEMENT__STUDENT_ELEMENT_MISTAKES:
        return getStudentElementMistakes();
      case ModelingassistantPackage.SOLUTION_ELEMENT__ELEMENT:
        if (resolve) return getElement();
        return basicGetElement();
      case ModelingassistantPackage.SOLUTION_ELEMENT__INSTRUCTOR_ELEMENT_MISTAKES:
        return getInstructorElementMistakes();
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
      case ModelingassistantPackage.SOLUTION_ELEMENT__PROBLEM_STATEMENT_ELEMENTS:
        getProblemStatementElements().clear();
        getProblemStatementElements().addAll((Collection<? extends ProblemStatementElement>)newValue);
        return;
      case ModelingassistantPackage.SOLUTION_ELEMENT__SOLUTION:
        setSolution((Solution)newValue);
        return;
      case ModelingassistantPackage.SOLUTION_ELEMENT__STUDENT_ELEMENT_MISTAKES:
        getStudentElementMistakes().clear();
        getStudentElementMistakes().addAll((Collection<? extends Mistake>)newValue);
        return;
      case ModelingassistantPackage.SOLUTION_ELEMENT__ELEMENT:
        setElement((NamedElement)newValue);
        return;
      case ModelingassistantPackage.SOLUTION_ELEMENT__INSTRUCTOR_ELEMENT_MISTAKES:
        getInstructorElementMistakes().clear();
        getInstructorElementMistakes().addAll((Collection<? extends Mistake>)newValue);
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
      case ModelingassistantPackage.SOLUTION_ELEMENT__PROBLEM_STATEMENT_ELEMENTS:
        getProblemStatementElements().clear();
        return;
      case ModelingassistantPackage.SOLUTION_ELEMENT__SOLUTION:
        setSolution((Solution)null);
        return;
      case ModelingassistantPackage.SOLUTION_ELEMENT__STUDENT_ELEMENT_MISTAKES:
        getStudentElementMistakes().clear();
        return;
      case ModelingassistantPackage.SOLUTION_ELEMENT__ELEMENT:
        setElement((NamedElement)null);
        return;
      case ModelingassistantPackage.SOLUTION_ELEMENT__INSTRUCTOR_ELEMENT_MISTAKES:
        getInstructorElementMistakes().clear();
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
      case ModelingassistantPackage.SOLUTION_ELEMENT__PROBLEM_STATEMENT_ELEMENTS:
        return problemStatementElements != null && !problemStatementElements.isEmpty();
      case ModelingassistantPackage.SOLUTION_ELEMENT__SOLUTION:
        return getSolution() != null;
      case ModelingassistantPackage.SOLUTION_ELEMENT__STUDENT_ELEMENT_MISTAKES:
        return studentElementMistakes != null && !studentElementMistakes.isEmpty();
      case ModelingassistantPackage.SOLUTION_ELEMENT__ELEMENT:
        return element != null;
      case ModelingassistantPackage.SOLUTION_ELEMENT__INSTRUCTOR_ELEMENT_MISTAKES:
        return instructorElementMistakes != null && !instructorElementMistakes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SolutionElementImpl
