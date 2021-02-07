/**
 */
package modelingassistant.impl;

import classdiagram.ClassDiagram;

import java.util.Collection;

import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.Solution;
import modelingassistant.SolutionElement;
import modelingassistant.Student;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.SolutionImpl#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.impl.SolutionImpl#getStudent <em>Student</em>}</li>
 *   <li>{@link modelingassistant.impl.SolutionImpl#getSolutionElements <em>Solution Elements</em>}</li>
 *   <li>{@link modelingassistant.impl.SolutionImpl#getClassDiagram <em>Class Diagram</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionImpl extends MinimalEObjectImpl.Container implements Solution {
  /**
   * The cached value of the '{@link #getStudent() <em>Student</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStudent()
   * @generated
   * @ordered
   */
  protected Student student;

  /**
   * The cached value of the '{@link #getSolutionElements() <em>Solution Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSolutionElements()
   * @generated
   * @ordered
   */
  protected EList<SolutionElement> solutionElements;

  /**
   * The cached value of the '{@link #getClassDiagram() <em>Class Diagram</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassDiagram()
   * @generated
   * @ordered
   */
  protected ClassDiagram classDiagram;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SolutionImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.SOLUTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingAssistant getModelingAssistant() {
    if (eContainerFeatureID() != ModelingassistantPackage.SOLUTION__MODELING_ASSISTANT) return null;
    return (ModelingAssistant)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelingAssistant(ModelingAssistant newModelingAssistant, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newModelingAssistant, ModelingassistantPackage.SOLUTION__MODELING_ASSISTANT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelingAssistant(ModelingAssistant newModelingAssistant) {
    if (newModelingAssistant != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.SOLUTION__MODELING_ASSISTANT && newModelingAssistant != null)) {
      if (EcoreUtil.isAncestor(this, newModelingAssistant))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newModelingAssistant != null)
        msgs = ((InternalEObject)newModelingAssistant).eInverseAdd(this, ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS, ModelingAssistant.class, msgs);
      msgs = basicSetModelingAssistant(newModelingAssistant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.SOLUTION__MODELING_ASSISTANT, newModelingAssistant, newModelingAssistant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Student getStudent() {
    if (student != null && student.eIsProxy()) {
      InternalEObject oldStudent = (InternalEObject)student;
      student = (Student)eResolveProxy(oldStudent);
      if (student != oldStudent) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.SOLUTION__STUDENT, oldStudent, student));
      }
    }
    return student;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Student basicGetStudent() {
    return student;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStudent(Student newStudent, NotificationChain msgs) {
    Student oldStudent = student;
    student = newStudent;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.SOLUTION__STUDENT, oldStudent, newStudent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStudent(Student newStudent) {
    if (newStudent != student) {
      NotificationChain msgs = null;
      if (student != null)
        msgs = ((InternalEObject)student).eInverseRemove(this, ModelingassistantPackage.STUDENT__SOLUTIONS, Student.class, msgs);
      if (newStudent != null)
        msgs = ((InternalEObject)newStudent).eInverseAdd(this, ModelingassistantPackage.STUDENT__SOLUTIONS, Student.class, msgs);
      msgs = basicSetStudent(newStudent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.SOLUTION__STUDENT, newStudent, newStudent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SolutionElement> getSolutionElements() {
    if (solutionElements == null) {
      solutionElements = new EObjectContainmentWithInverseEList<SolutionElement>(SolutionElement.class, this, ModelingassistantPackage.SOLUTION__SOLUTION_ELEMENTS, ModelingassistantPackage.SOLUTION_ELEMENT__SOLUTION);
    }
    return solutionElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDiagram getClassDiagram() {
    if (classDiagram != null && classDiagram.eIsProxy()) {
      InternalEObject oldClassDiagram = (InternalEObject)classDiagram;
      classDiagram = (ClassDiagram)eResolveProxy(oldClassDiagram);
      if (classDiagram != oldClassDiagram) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.SOLUTION__CLASS_DIAGRAM, oldClassDiagram, classDiagram));
      }
    }
    return classDiagram;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDiagram basicGetClassDiagram() {
    return classDiagram;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassDiagram(ClassDiagram newClassDiagram) {
    ClassDiagram oldClassDiagram = classDiagram;
    classDiagram = newClassDiagram;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.SOLUTION__CLASS_DIAGRAM, oldClassDiagram, classDiagram));
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
      case ModelingassistantPackage.SOLUTION__MODELING_ASSISTANT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetModelingAssistant((ModelingAssistant)otherEnd, msgs);
      case ModelingassistantPackage.SOLUTION__STUDENT:
        if (student != null)
          msgs = ((InternalEObject)student).eInverseRemove(this, ModelingassistantPackage.STUDENT__SOLUTIONS, Student.class, msgs);
        return basicSetStudent((Student)otherEnd, msgs);
      case ModelingassistantPackage.SOLUTION__SOLUTION_ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSolutionElements()).basicAdd(otherEnd, msgs);
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
      case ModelingassistantPackage.SOLUTION__MODELING_ASSISTANT:
        return basicSetModelingAssistant(null, msgs);
      case ModelingassistantPackage.SOLUTION__STUDENT:
        return basicSetStudent(null, msgs);
      case ModelingassistantPackage.SOLUTION__SOLUTION_ELEMENTS:
        return ((InternalEList<?>)getSolutionElements()).basicRemove(otherEnd, msgs);
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
      case ModelingassistantPackage.SOLUTION__MODELING_ASSISTANT:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS, ModelingAssistant.class, msgs);
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
      case ModelingassistantPackage.SOLUTION__MODELING_ASSISTANT:
        return getModelingAssistant();
      case ModelingassistantPackage.SOLUTION__STUDENT:
        if (resolve) return getStudent();
        return basicGetStudent();
      case ModelingassistantPackage.SOLUTION__SOLUTION_ELEMENTS:
        return getSolutionElements();
      case ModelingassistantPackage.SOLUTION__CLASS_DIAGRAM:
        if (resolve) return getClassDiagram();
        return basicGetClassDiagram();
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
      case ModelingassistantPackage.SOLUTION__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)newValue);
        return;
      case ModelingassistantPackage.SOLUTION__STUDENT:
        setStudent((Student)newValue);
        return;
      case ModelingassistantPackage.SOLUTION__SOLUTION_ELEMENTS:
        getSolutionElements().clear();
        getSolutionElements().addAll((Collection<? extends SolutionElement>)newValue);
        return;
      case ModelingassistantPackage.SOLUTION__CLASS_DIAGRAM:
        setClassDiagram((ClassDiagram)newValue);
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
      case ModelingassistantPackage.SOLUTION__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)null);
        return;
      case ModelingassistantPackage.SOLUTION__STUDENT:
        setStudent((Student)null);
        return;
      case ModelingassistantPackage.SOLUTION__SOLUTION_ELEMENTS:
        getSolutionElements().clear();
        return;
      case ModelingassistantPackage.SOLUTION__CLASS_DIAGRAM:
        setClassDiagram((ClassDiagram)null);
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
      case ModelingassistantPackage.SOLUTION__MODELING_ASSISTANT:
        return getModelingAssistant() != null;
      case ModelingassistantPackage.SOLUTION__STUDENT:
        return student != null;
      case ModelingassistantPackage.SOLUTION__SOLUTION_ELEMENTS:
        return solutionElements != null && !solutionElements.isEmpty();
      case ModelingassistantPackage.SOLUTION__CLASS_DIAGRAM:
        return classDiagram != null;
    }
    return super.eIsSet(featureID);
  }

} //SolutionImpl
