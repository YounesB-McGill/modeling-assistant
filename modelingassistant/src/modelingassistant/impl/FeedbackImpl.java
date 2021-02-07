/**
 */
package modelingassistant.impl;

import java.util.Collection;

import modelingassistant.Feedback;
import modelingassistant.Mistake;
import modelingassistant.MistakeType;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;

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
 * An implementation of the model object '<em><b>Feedback</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.impl.FeedbackImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackImpl#isCongratulatory <em>Congratulatory</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackImpl#getUsefulness <em>Usefulness</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackImpl#isHighlightProblem <em>Highlight Problem</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackImpl#isHighlightSolution <em>Highlight Solution</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackImpl#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackImpl#getMistakeType <em>Mistake Type</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackImpl#getMistakes <em>Mistakes</em>}</li>
 *   <li>{@link modelingassistant.impl.FeedbackImpl#getText <em>Text</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeedbackImpl extends MinimalEObjectImpl.Container implements Feedback {
  /**
   * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLevel()
   * @generated
   * @ordered
   */
  protected static final int LEVEL_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLevel()
   * @generated
   * @ordered
   */
  protected int level = LEVEL_EDEFAULT;

  /**
   * The default value of the '{@link #isCongratulatory() <em>Congratulatory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCongratulatory()
   * @generated
   * @ordered
   */
  protected static final boolean CONGRATULATORY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCongratulatory() <em>Congratulatory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCongratulatory()
   * @generated
   * @ordered
   */
  protected boolean congratulatory = CONGRATULATORY_EDEFAULT;

  /**
   * The default value of the '{@link #getUsefulness() <em>Usefulness</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsefulness()
   * @generated
   * @ordered
   */
  protected static final double USEFULNESS_EDEFAULT = 0.0;

  /**
   * The cached value of the '{@link #getUsefulness() <em>Usefulness</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsefulness()
   * @generated
   * @ordered
   */
  protected double usefulness = USEFULNESS_EDEFAULT;

  /**
   * The default value of the '{@link #isHighlightProblem() <em>Highlight Problem</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHighlightProblem()
   * @generated
   * @ordered
   */
  protected static final boolean HIGHLIGHT_PROBLEM_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHighlightProblem() <em>Highlight Problem</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHighlightProblem()
   * @generated
   * @ordered
   */
  protected boolean highlightProblem = HIGHLIGHT_PROBLEM_EDEFAULT;

  /**
   * The default value of the '{@link #isHighlightSolution() <em>Highlight Solution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHighlightSolution()
   * @generated
   * @ordered
   */
  protected static final boolean HIGHLIGHT_SOLUTION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHighlightSolution() <em>Highlight Solution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHighlightSolution()
   * @generated
   * @ordered
   */
  protected boolean highlightSolution = HIGHLIGHT_SOLUTION_EDEFAULT;

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
   * The cached value of the '{@link #getMistakes() <em>Mistakes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMistakes()
   * @generated
   * @ordered
   */
  protected EList<Mistake> mistakes;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeedbackImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelingassistantPackage.Literals.FEEDBACK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLevel() {
    return level;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLevel(int newLevel) {
    int oldLevel = level;
    level = newLevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK__LEVEL, oldLevel, level));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCongratulatory() {
    return congratulatory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCongratulatory(boolean newCongratulatory) {
    boolean oldCongratulatory = congratulatory;
    congratulatory = newCongratulatory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK__CONGRATULATORY, oldCongratulatory, congratulatory));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getUsefulness() {
    return usefulness;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUsefulness(double newUsefulness) {
    double oldUsefulness = usefulness;
    usefulness = newUsefulness;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK__USEFULNESS, oldUsefulness, usefulness));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isHighlightProblem() {
    return highlightProblem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHighlightProblem(boolean newHighlightProblem) {
    boolean oldHighlightProblem = highlightProblem;
    highlightProblem = newHighlightProblem;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK__HIGHLIGHT_PROBLEM, oldHighlightProblem, highlightProblem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isHighlightSolution() {
    return highlightSolution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHighlightSolution(boolean newHighlightSolution) {
    boolean oldHighlightSolution = highlightSolution;
    highlightSolution = newHighlightSolution;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK__HIGHLIGHT_SOLUTION, oldHighlightSolution, highlightSolution));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingAssistant getModelingAssistant() {
    if (eContainerFeatureID() != ModelingassistantPackage.FEEDBACK__MODELING_ASSISTANT) return null;
    return (ModelingAssistant)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelingAssistant(ModelingAssistant newModelingAssistant, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newModelingAssistant, ModelingassistantPackage.FEEDBACK__MODELING_ASSISTANT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelingAssistant(ModelingAssistant newModelingAssistant) {
    if (newModelingAssistant != eInternalContainer() || (eContainerFeatureID() != ModelingassistantPackage.FEEDBACK__MODELING_ASSISTANT && newModelingAssistant != null)) {
      if (EcoreUtil.isAncestor(this, newModelingAssistant))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newModelingAssistant != null)
        msgs = ((InternalEObject)newModelingAssistant).eInverseAdd(this, ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACKS, ModelingAssistant.class, msgs);
      msgs = basicSetModelingAssistant(newModelingAssistant, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK__MODELING_ASSISTANT, newModelingAssistant, newModelingAssistant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeType getMistakeType() {
    if (mistakeType != null && mistakeType.eIsProxy()) {
      InternalEObject oldMistakeType = (InternalEObject)mistakeType;
      mistakeType = (MistakeType)eResolveProxy(oldMistakeType);
      if (mistakeType != oldMistakeType) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingassistantPackage.FEEDBACK__MISTAKE_TYPE, oldMistakeType, mistakeType));
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
  public NotificationChain basicSetMistakeType(MistakeType newMistakeType, NotificationChain msgs) {
    MistakeType oldMistakeType = mistakeType;
    mistakeType = newMistakeType;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK__MISTAKE_TYPE, oldMistakeType, newMistakeType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMistakeType(MistakeType newMistakeType) {
    if (newMistakeType != mistakeType) {
      NotificationChain msgs = null;
      if (mistakeType != null)
        msgs = ((InternalEObject)mistakeType).eInverseRemove(this, ModelingassistantPackage.MISTAKE_TYPE__FEEDBACKS, MistakeType.class, msgs);
      if (newMistakeType != null)
        msgs = ((InternalEObject)newMistakeType).eInverseAdd(this, ModelingassistantPackage.MISTAKE_TYPE__FEEDBACKS, MistakeType.class, msgs);
      msgs = basicSetMistakeType(newMistakeType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK__MISTAKE_TYPE, newMistakeType, newMistakeType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Mistake> getMistakes() {
    if (mistakes == null) {
      mistakes = new EObjectWithInverseResolvingEList<Mistake>(Mistake.class, this, ModelingassistantPackage.FEEDBACK__MISTAKES, ModelingassistantPackage.MISTAKE__LAST_FEEDBACK);
    }
    return mistakes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getText() {
    return text;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setText(String newText) {
    String oldText = text;
    text = newText;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelingassistantPackage.FEEDBACK__TEXT, oldText, text));
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
      case ModelingassistantPackage.FEEDBACK__MODELING_ASSISTANT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetModelingAssistant((ModelingAssistant)otherEnd, msgs);
      case ModelingassistantPackage.FEEDBACK__MISTAKE_TYPE:
        if (mistakeType != null)
          msgs = ((InternalEObject)mistakeType).eInverseRemove(this, ModelingassistantPackage.MISTAKE_TYPE__FEEDBACKS, MistakeType.class, msgs);
        return basicSetMistakeType((MistakeType)otherEnd, msgs);
      case ModelingassistantPackage.FEEDBACK__MISTAKES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getMistakes()).basicAdd(otherEnd, msgs);
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
      case ModelingassistantPackage.FEEDBACK__MODELING_ASSISTANT:
        return basicSetModelingAssistant(null, msgs);
      case ModelingassistantPackage.FEEDBACK__MISTAKE_TYPE:
        return basicSetMistakeType(null, msgs);
      case ModelingassistantPackage.FEEDBACK__MISTAKES:
        return ((InternalEList<?>)getMistakes()).basicRemove(otherEnd, msgs);
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
      case ModelingassistantPackage.FEEDBACK__MODELING_ASSISTANT:
        return eInternalContainer().eInverseRemove(this, ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACKS, ModelingAssistant.class, msgs);
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
      case ModelingassistantPackage.FEEDBACK__LEVEL:
        return getLevel();
      case ModelingassistantPackage.FEEDBACK__CONGRATULATORY:
        return isCongratulatory();
      case ModelingassistantPackage.FEEDBACK__USEFULNESS:
        return getUsefulness();
      case ModelingassistantPackage.FEEDBACK__HIGHLIGHT_PROBLEM:
        return isHighlightProblem();
      case ModelingassistantPackage.FEEDBACK__HIGHLIGHT_SOLUTION:
        return isHighlightSolution();
      case ModelingassistantPackage.FEEDBACK__MODELING_ASSISTANT:
        return getModelingAssistant();
      case ModelingassistantPackage.FEEDBACK__MISTAKE_TYPE:
        if (resolve) return getMistakeType();
        return basicGetMistakeType();
      case ModelingassistantPackage.FEEDBACK__MISTAKES:
        return getMistakes();
      case ModelingassistantPackage.FEEDBACK__TEXT:
        return getText();
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
      case ModelingassistantPackage.FEEDBACK__LEVEL:
        setLevel((Integer)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK__CONGRATULATORY:
        setCongratulatory((Boolean)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK__USEFULNESS:
        setUsefulness((Double)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK__HIGHLIGHT_PROBLEM:
        setHighlightProblem((Boolean)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK__HIGHLIGHT_SOLUTION:
        setHighlightSolution((Boolean)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK__MISTAKE_TYPE:
        setMistakeType((MistakeType)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK__MISTAKES:
        getMistakes().clear();
        getMistakes().addAll((Collection<? extends Mistake>)newValue);
        return;
      case ModelingassistantPackage.FEEDBACK__TEXT:
        setText((String)newValue);
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
      case ModelingassistantPackage.FEEDBACK__LEVEL:
        setLevel(LEVEL_EDEFAULT);
        return;
      case ModelingassistantPackage.FEEDBACK__CONGRATULATORY:
        setCongratulatory(CONGRATULATORY_EDEFAULT);
        return;
      case ModelingassistantPackage.FEEDBACK__USEFULNESS:
        setUsefulness(USEFULNESS_EDEFAULT);
        return;
      case ModelingassistantPackage.FEEDBACK__HIGHLIGHT_PROBLEM:
        setHighlightProblem(HIGHLIGHT_PROBLEM_EDEFAULT);
        return;
      case ModelingassistantPackage.FEEDBACK__HIGHLIGHT_SOLUTION:
        setHighlightSolution(HIGHLIGHT_SOLUTION_EDEFAULT);
        return;
      case ModelingassistantPackage.FEEDBACK__MODELING_ASSISTANT:
        setModelingAssistant((ModelingAssistant)null);
        return;
      case ModelingassistantPackage.FEEDBACK__MISTAKE_TYPE:
        setMistakeType((MistakeType)null);
        return;
      case ModelingassistantPackage.FEEDBACK__MISTAKES:
        getMistakes().clear();
        return;
      case ModelingassistantPackage.FEEDBACK__TEXT:
        setText(TEXT_EDEFAULT);
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
      case ModelingassistantPackage.FEEDBACK__LEVEL:
        return level != LEVEL_EDEFAULT;
      case ModelingassistantPackage.FEEDBACK__CONGRATULATORY:
        return congratulatory != CONGRATULATORY_EDEFAULT;
      case ModelingassistantPackage.FEEDBACK__USEFULNESS:
        return usefulness != USEFULNESS_EDEFAULT;
      case ModelingassistantPackage.FEEDBACK__HIGHLIGHT_PROBLEM:
        return highlightProblem != HIGHLIGHT_PROBLEM_EDEFAULT;
      case ModelingassistantPackage.FEEDBACK__HIGHLIGHT_SOLUTION:
        return highlightSolution != HIGHLIGHT_SOLUTION_EDEFAULT;
      case ModelingassistantPackage.FEEDBACK__MODELING_ASSISTANT:
        return getModelingAssistant() != null;
      case ModelingassistantPackage.FEEDBACK__MISTAKE_TYPE:
        return mistakeType != null;
      case ModelingassistantPackage.FEEDBACK__MISTAKES:
        return mistakes != null && !mistakes.isEmpty();
      case ModelingassistantPackage.FEEDBACK__TEXT:
        return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
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
    result.append(" (level: ");
    result.append(level);
    result.append(", congratulatory: ");
    result.append(congratulatory);
    result.append(", usefulness: ");
    result.append(usefulness);
    result.append(", highlightProblem: ");
    result.append(highlightProblem);
    result.append(", highlightSolution: ");
    result.append(highlightSolution);
    result.append(", text: ");
    result.append(text);
    result.append(')');
    return result.toString();
  }

} //FeedbackImpl
