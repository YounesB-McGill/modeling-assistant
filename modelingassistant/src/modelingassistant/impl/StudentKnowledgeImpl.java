/**
 */
package modelingassistant.impl;

import learningcorpus.MistakeType;

import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.Student;
import modelingassistant.StudentKnowledge;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Student Knowledge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.StudentKnowledgeImpl#getLevelOfKnowledge <em>Level Of Knowledge</em>}</li>
 *   <li>{@link modelingassistant.impl.StudentKnowledgeImpl#getStudent <em>Student</em>}</li>
 *   <li>{@link modelingassistant.impl.StudentKnowledgeImpl#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.impl.StudentKnowledgeImpl#getMistakeType <em>Mistake Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StudentKnowledgeImpl extends MinimalEObjectImpl.Container implements StudentKnowledge {
  /**
   * The default value of the '{@link #getLevelOfKnowledge() <em>Level Of Knowledge</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLevelOfKnowledge()
   * @generated
   * @ordered
   */
  protected static final double LEVEL_OF_KNOWLEDGE_EDEFAULT = 5.0;

  /**
   * The cached value of the '{@link #getLevelOfKnowledge() <em>Level Of Knowledge</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLevelOfKnowledge()
   * @generated
   * @ordered
   */
  protected double levelOfKnowledge = LEVEL_OF_KNOWLEDGE_EDEFAULT;

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
   * The cached value of the '{@link #getMistakeType() <em>Mistake Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMistakeType()
   * @generated
   * @ordered
   */
  protected MistakeType mistakeType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StudentKnowledgeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.STUDENT_KNOWLEDGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public double getLevelOfKnowledge() {
    return levelOfKnowledge;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLevelOfKnowledge(double newLevelOfKnowledge) {
    double oldLevelOfKnowledge = levelOfKnowledge;
    levelOfKnowledge = newLevelOfKnowledge;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.STUDENT_KNOWLEDGE__LEVEL_OF_KNOWLEDGE, oldLevelOfKnowledge, levelOfKnowledge));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Student getStudent() {
    if (student != null && student.eIsProxy()) {
      InternalEObject oldStudent = (InternalEObject)student;
      student = (Student)eResolveProxy(oldStudent);
      if (student != oldStudent) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.STUDENT_KNOWLEDGE__STUDENT, oldStudent, student));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.STUDENT_KNOWLEDGE__STUDENT, oldStudent, newStudent);
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
  public void setStudent(Student newStudent) {
    if (newStudent != student) {
      NotificationChain msgs = null;
      if (student != null)
        msgs = ((InternalEObject)student).eInverseRemove(this, ModelingassistantPackage.STUDENT__STUDENT_KNOWLEDGES, Student.class, msgs);
      if (newStudent != null)
        msgs = ((InternalEObject)newStudent).eInverseAdd(this, ModelingassistantPackage.STUDENT__STUDENT_KNOWLEDGES, Student.class, msgs);
      msgs = basicSetStudent(newStudent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.STUDENT_KNOWLEDGE__STUDENT, newStudent, newStudent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ModelingAssistant getModelingAssistant() {
    if (eContainerFeatureID() != ModelingassistantPackage.STUDENT_KNOWLEDGE__MODELING_ASSISTANT) return null;
    return (ModelingAssistant)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelingAssistant(ModelingAssistant newModelingAssistant, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newModelingAssistant, ModelingassistantPackage.STUDENT_KNOWLEDGE__MODELING_ASSISTANT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setModelingAssistant(ModelingAssistant newModelingAssistant) {
    if (newModelingAssistant != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.STUDENT_KNOWLEDGE__MODELING_ASSISTANT && newModelingAssistant != null)) {
      if (EcoreUtil.isAncestor(this, newModelingAssistant))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newModelingAssistant != null)
        msgs = ((InternalEObject)newModelingAssistant).eInverseAdd(this, ModelingassistantPackage.MODELING_ASSISTANT__STUDENT_KNOWLEDGES, ModelingAssistant.class, msgs);
      msgs = basicSetModelingAssistant(newModelingAssistant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.STUDENT_KNOWLEDGE__MODELING_ASSISTANT, newModelingAssistant, newModelingAssistant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MistakeType getMistakeType() {
    if (mistakeType != null && mistakeType.eIsProxy()) {
      InternalEObject oldMistakeType = (InternalEObject)mistakeType;
      mistakeType = (MistakeType)eResolveProxy(oldMistakeType);
      if (mistakeType != oldMistakeType) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.STUDENT_KNOWLEDGE__MISTAKE_TYPE, oldMistakeType, mistakeType));
      }
    }
    return mistakeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeType basicGetMistakeType() {
    return mistakeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMistakeType(MistakeType newMistakeType) {
    MistakeType oldMistakeType = mistakeType;
    mistakeType = newMistakeType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.STUDENT_KNOWLEDGE__MISTAKE_TYPE, oldMistakeType, mistakeType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__STUDENT:
        if (student != null)
          msgs = ((InternalEObject)student).eInverseRemove(this, ModelingassistantPackage.STUDENT__STUDENT_KNOWLEDGES, Student.class, msgs);
        return basicSetStudent((Student)otherEnd, msgs);
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__MODELING_ASSISTANT:
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
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__STUDENT:
        return basicSetStudent(null, msgs);
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__MODELING_ASSISTANT:
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
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__MODELING_ASSISTANT:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__STUDENT_KNOWLEDGES, ModelingAssistant.class, msgs);
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
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__LEVEL_OF_KNOWLEDGE:
        return getLevelOfKnowledge();
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__STUDENT:
        if (resolve) return getStudent();
        return basicGetStudent();
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__MODELING_ASSISTANT:
        return getModelingAssistant();
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__MISTAKE_TYPE:
        if (resolve) return getMistakeType();
        return basicGetMistakeType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__LEVEL_OF_KNOWLEDGE:
        setLevelOfKnowledge((Double)newValue);
        return;
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__STUDENT:
        setStudent((Student)newValue);
        return;
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)newValue);
        return;
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__MISTAKE_TYPE:
        setMistakeType((MistakeType)newValue);
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
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__LEVEL_OF_KNOWLEDGE:
        setLevelOfKnowledge(LEVEL_OF_KNOWLEDGE_EDEFAULT);
        return;
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__STUDENT:
        setStudent((Student)null);
        return;
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)null);
        return;
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__MISTAKE_TYPE:
        setMistakeType((MistakeType)null);
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
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__LEVEL_OF_KNOWLEDGE:
        return levelOfKnowledge != LEVEL_OF_KNOWLEDGE_EDEFAULT;
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__STUDENT:
        return student != null;
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__MODELING_ASSISTANT:
        return getModelingAssistant() != null;
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__MISTAKE_TYPE:
        return mistakeType != null;
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
    result.append(" (levelOfKnowledge: ");
    result.append(levelOfKnowledge);
    result.append(')');
    return result.toString();
  }

} //StudentKnowledgeImpl
