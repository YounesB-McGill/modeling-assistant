/**
 */
package modelingassistant.impl;

import java.util.Collection;

import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.Solution;
import modelingassistant.Student;
import modelingassistant.StudentKnowledge;

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
 * An implementation of the model object '<em><b>Student</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.StudentImpl#getId <em>Id</em>}</li>
 *   <li>{@link modelingassistant.impl.StudentImpl#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.impl.StudentImpl#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link modelingassistant.impl.StudentImpl#getStudentKnowledges <em>Student Knowledges</em>}</li>
 *   <li>{@link modelingassistant.impl.StudentImpl#getCurrentSolution <em>Current Solution</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StudentImpl extends NamedElementImpl implements Student {
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getSolutions() <em>Solutions</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSolutions()
   * @generated
   * @ordered
   */
  protected EList<Solution> solutions;

  /**
   * The cached value of the '{@link #getStudentKnowledges() <em>Student Knowledges</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStudentKnowledges()
   * @generated
   * @ordered
   */
  protected EList<StudentKnowledge> studentKnowledges;

  /**
   * The cached value of the '{@link #getCurrentSolution() <em>Current Solution</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCurrentSolution()
   * @generated
   * @ordered
   */
  protected Solution currentSolution;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StudentImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.STUDENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getId() {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setId(String newId) {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.STUDENT__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ModelingAssistant getModelingAssistant() {
    if (eContainerFeatureID() != ModelingassistantPackage.STUDENT__MODELING_ASSISTANT) return null;
    return (ModelingAssistant)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelingAssistant(ModelingAssistant newModelingAssistant, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newModelingAssistant, ModelingassistantPackage.STUDENT__MODELING_ASSISTANT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setModelingAssistant(ModelingAssistant newModelingAssistant) {
    if (newModelingAssistant != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.STUDENT__MODELING_ASSISTANT && newModelingAssistant != null)) {
      if (EcoreUtil.isAncestor(this, newModelingAssistant))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newModelingAssistant != null)
        msgs = ((InternalEObject)newModelingAssistant).eInverseAdd(this, ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS, ModelingAssistant.class, msgs);
      msgs = basicSetModelingAssistant(newModelingAssistant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.STUDENT__MODELING_ASSISTANT, newModelingAssistant, newModelingAssistant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Solution> getSolutions() {
    if (solutions == null) {
      solutions = new EObjectWithInverseResolvingEList<Solution>(Solution.class, this, ModelingassistantPackage.STUDENT__SOLUTIONS, ModelingassistantPackage.SOLUTION__STUDENT);
    }
    return solutions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<StudentKnowledge> getStudentKnowledges() {
    if (studentKnowledges == null) {
      studentKnowledges = new EObjectWithInverseResolvingEList<StudentKnowledge>(StudentKnowledge.class, this, ModelingassistantPackage.STUDENT__STUDENT_KNOWLEDGES, ModelingassistantPackage.STUDENT_KNOWLEDGE__STUDENT);
    }
    return studentKnowledges;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Solution getCurrentSolution() {
    if (currentSolution != null && currentSolution.eIsProxy()) {
      InternalEObject oldCurrentSolution = (InternalEObject)currentSolution;
      currentSolution = (Solution)eResolveProxy(oldCurrentSolution);
      if (currentSolution != oldCurrentSolution) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.STUDENT__CURRENT_SOLUTION, oldCurrentSolution, currentSolution));
      }
    }
    return currentSolution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Solution basicGetCurrentSolution() {
    return currentSolution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCurrentSolution(Solution newCurrentSolution) {
    Solution oldCurrentSolution = currentSolution;
    currentSolution = newCurrentSolution;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.STUDENT__CURRENT_SOLUTION, oldCurrentSolution, currentSolution));
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
      case ModelingassistantPackage.STUDENT__MODELING_ASSISTANT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetModelingAssistant((ModelingAssistant)otherEnd, msgs);
      case ModelingassistantPackage.STUDENT__SOLUTIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSolutions()).basicAdd(otherEnd, msgs);
      case ModelingassistantPackage.STUDENT__STUDENT_KNOWLEDGES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStudentKnowledges()).basicAdd(otherEnd, msgs);
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
      case ModelingassistantPackage.STUDENT__MODELING_ASSISTANT:
        return basicSetModelingAssistant(null, msgs);
      case ModelingassistantPackage.STUDENT__SOLUTIONS:
        return ((InternalEList<?>)getSolutions()).basicRemove(otherEnd, msgs);
      case ModelingassistantPackage.STUDENT__STUDENT_KNOWLEDGES:
        return ((InternalEList<?>)getStudentKnowledges()).basicRemove(otherEnd, msgs);
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
      case ModelingassistantPackage.STUDENT__MODELING_ASSISTANT:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS, ModelingAssistant.class, msgs);
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
      case ModelingassistantPackage.STUDENT__ID:
        return getId();
      case ModelingassistantPackage.STUDENT__MODELING_ASSISTANT:
        return getModelingAssistant();
      case ModelingassistantPackage.STUDENT__SOLUTIONS:
        return getSolutions();
      case ModelingassistantPackage.STUDENT__STUDENT_KNOWLEDGES:
        return getStudentKnowledges();
      case ModelingassistantPackage.STUDENT__CURRENT_SOLUTION:
        if (resolve) return getCurrentSolution();
        return basicGetCurrentSolution();
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
      case ModelingassistantPackage.STUDENT__ID:
        setId((String)newValue);
        return;
      case ModelingassistantPackage.STUDENT__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)newValue);
        return;
      case ModelingassistantPackage.STUDENT__SOLUTIONS:
        getSolutions().clear();
        getSolutions().addAll((Collection<? extends Solution>)newValue);
        return;
      case ModelingassistantPackage.STUDENT__STUDENT_KNOWLEDGES:
        getStudentKnowledges().clear();
        getStudentKnowledges().addAll((Collection<? extends StudentKnowledge>)newValue);
        return;
      case ModelingassistantPackage.STUDENT__CURRENT_SOLUTION:
        setCurrentSolution((Solution)newValue);
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
      case ModelingassistantPackage.STUDENT__ID:
        setId(ID_EDEFAULT);
        return;
      case ModelingassistantPackage.STUDENT__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)null);
        return;
      case ModelingassistantPackage.STUDENT__SOLUTIONS:
        getSolutions().clear();
        return;
      case ModelingassistantPackage.STUDENT__STUDENT_KNOWLEDGES:
        getStudentKnowledges().clear();
        return;
      case ModelingassistantPackage.STUDENT__CURRENT_SOLUTION:
        setCurrentSolution((Solution)null);
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
      case ModelingassistantPackage.STUDENT__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case ModelingassistantPackage.STUDENT__MODELING_ASSISTANT:
        return getModelingAssistant() != null;
      case ModelingassistantPackage.STUDENT__SOLUTIONS:
        return solutions != null && !solutions.isEmpty();
      case ModelingassistantPackage.STUDENT__STUDENT_KNOWLEDGES:
        return studentKnowledges != null && !studentKnowledges.isEmpty();
      case ModelingassistantPackage.STUDENT__CURRENT_SOLUTION:
        return currentSolution != null;
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
    result.append(" (id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} //StudentImpl
