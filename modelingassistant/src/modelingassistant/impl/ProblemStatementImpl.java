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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
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
 *   <li>{@link modelingassistant.impl.ProblemStatementImpl#getText <em>Text</em>}</li>
 *   <li>{@link modelingassistant.impl.ProblemStatementImpl#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.impl.ProblemStatementImpl#getStudentSolution <em>Student Solution</em>}</li>
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
   * The default value of the '{@link #getText() <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getText()
   * @generated
   * @ordered
   */
  protected static final String TEXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getText()
   * @generated
   * @ordered
   */
  protected String text = TEXT_EDEFAULT;

  /**
   * The cached value of the '{@link #getStudentSolution() <em>Student Solution</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStudentSolution()
   * @generated
   * @ordered
   */
  protected EList<Solution> studentSolution;

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
  public String getText() {
    return text;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setText(String newText) {
    String oldText = text;
    text = newText;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.PROBLEM_STATEMENT__TEXT, oldText, text));
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
  public EList<Solution> getStudentSolution() {
    if (studentSolution == null) {
      studentSolution = new EObjectWithInverseResolvingEList<Solution>(Solution.class, this, ModelingassistantPackage.PROBLEM_STATEMENT__STUDENT_SOLUTION, ModelingassistantPackage.SOLUTION__STUDENT_PROBLEM_STATEMENT);
    }
    return studentSolution;
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
  public NotificationChain basicSetInstructorSolution(Solution newInstructorSolution, NotificationChain msgs) {
    Solution oldInstructorSolution = instructorSolution;
    instructorSolution = newInstructorSolution;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION, oldInstructorSolution, newInstructorSolution);
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
  public void setInstructorSolution(Solution newInstructorSolution) {
    if (newInstructorSolution != instructorSolution) {
      NotificationChain msgs = null;
      if (instructorSolution != null)
        msgs = ((InternalEObject)instructorSolution).eInverseRemove(this, ModelingassistantPackage.SOLUTION__INSTRUCTOR_PROBLEM_STATEMENT, Solution.class, msgs);
      if (newInstructorSolution != null)
        msgs = ((InternalEObject)newInstructorSolution).eInverseAdd(this, ModelingassistantPackage.SOLUTION__INSTRUCTOR_PROBLEM_STATEMENT, Solution.class, msgs);
      msgs = basicSetInstructorSolution(newInstructorSolution, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION, newInstructorSolution, newInstructorSolution));
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__STUDENT_SOLUTION:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStudentSolution()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION:
        if (instructorSolution != null)
          msgs = ((InternalEObject)instructorSolution).eInverseRemove(this, ModelingassistantPackage.SOLUTION__INSTRUCTOR_PROBLEM_STATEMENT, Solution.class, msgs);
        return basicSetInstructorSolution((Solution)otherEnd, msgs);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__STUDENT_SOLUTION:
        return ((InternalEList<?>)getStudentSolution()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION:
        return basicSetInstructorSolution(null, msgs);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__TEXT:
        return getText();
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        return getModelingAssistant();
      case ModelingassistantPackage.PROBLEM_STATEMENT__STUDENT_SOLUTION:
        return getStudentSolution();
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__TEXT:
        setText((String)newValue);
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)newValue);
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT__STUDENT_SOLUTION:
        getStudentSolution().clear();
        getStudentSolution().addAll((Collection<? extends Solution>)newValue);
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__TEXT:
        setText(TEXT_EDEFAULT);
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)null);
        return;
      case ModelingassistantPackage.PROBLEM_STATEMENT__STUDENT_SOLUTION:
        getStudentSolution().clear();
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
      case ModelingassistantPackage.PROBLEM_STATEMENT__TEXT:
        return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
      case ModelingassistantPackage.PROBLEM_STATEMENT__MODELING_ASSISTANT:
        return getModelingAssistant() != null;
      case ModelingassistantPackage.PROBLEM_STATEMENT__STUDENT_SOLUTION:
        return studentSolution != null && !studentSolution.isEmpty();
      case ModelingassistantPackage.PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION:
        return instructorSolution != null;
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
    result.append(" (text: ");
    result.append(text);
    result.append(')');
    return result.toString();
  }

} //ProblemStatementImpl
