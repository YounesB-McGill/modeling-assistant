/**
 */
package learningcorpus.impl;

import learningcorpus.Feedback;
import learningcorpus.LearningCorpus;
import learningcorpus.LearningcorpusPackage;
import learningcorpus.MistakeType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feedback</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpus.impl.FeedbackImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link learningcorpus.impl.FeedbackImpl#isCongratulatory <em>Congratulatory</em>}</li>
 *   <li>{@link learningcorpus.impl.FeedbackImpl#getUsefulness <em>Usefulness</em>}</li>
 *   <li>{@link learningcorpus.impl.FeedbackImpl#isHighlightProblem <em>Highlight Problem</em>}</li>
 *   <li>{@link learningcorpus.impl.FeedbackImpl#isHighlightSolution <em>Highlight Solution</em>}</li>
 *   <li>{@link learningcorpus.impl.FeedbackImpl#getMistakeType <em>Mistake Type</em>}</li>
 *   <li>{@link learningcorpus.impl.FeedbackImpl#getText <em>Text</em>}</li>
 *   <li>{@link learningcorpus.impl.FeedbackImpl#getLearningCorpus <em>Learning Corpus</em>}</li>
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
    return LearningcorpusPackage.Literals.FEEDBACK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getLevel() {
    return level;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLevel(int newLevel) {
    int oldLevel = level;
    level = newLevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.FEEDBACK__LEVEL, oldLevel, level));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isCongratulatory() {
    return congratulatory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCongratulatory(boolean newCongratulatory) {
    boolean oldCongratulatory = congratulatory;
    congratulatory = newCongratulatory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.FEEDBACK__CONGRATULATORY, oldCongratulatory, congratulatory));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public double getUsefulness() {
    return usefulness;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUsefulness(double newUsefulness) {
    double oldUsefulness = usefulness;
    usefulness = newUsefulness;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.FEEDBACK__USEFULNESS, oldUsefulness, usefulness));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isHighlightProblem() {
    return highlightProblem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setHighlightProblem(boolean newHighlightProblem) {
    boolean oldHighlightProblem = highlightProblem;
    highlightProblem = newHighlightProblem;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.FEEDBACK__HIGHLIGHT_PROBLEM, oldHighlightProblem, highlightProblem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isHighlightSolution() {
    return highlightSolution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setHighlightSolution(boolean newHighlightSolution) {
    boolean oldHighlightSolution = highlightSolution;
    highlightSolution = newHighlightSolution;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.FEEDBACK__HIGHLIGHT_SOLUTION, oldHighlightSolution, highlightSolution));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LearningcorpusPackage.FEEDBACK__MISTAKE_TYPE, oldMistakeType, mistakeType));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.FEEDBACK__MISTAKE_TYPE, oldMistakeType, newMistakeType);
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
  public void setMistakeType(MistakeType newMistakeType) {
    if (newMistakeType != mistakeType) {
      NotificationChain msgs = null;
      if (mistakeType != null)
        msgs = ((InternalEObject)mistakeType).eInverseRemove(this, LearningcorpusPackage.MISTAKE_TYPE__FEEDBACKS, MistakeType.class, msgs);
      if (newMistakeType != null)
        msgs = ((InternalEObject)newMistakeType).eInverseAdd(this, LearningcorpusPackage.MISTAKE_TYPE__FEEDBACKS, MistakeType.class, msgs);
      msgs = basicSetMistakeType(newMistakeType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.FEEDBACK__MISTAKE_TYPE, newMistakeType, newMistakeType));
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
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.FEEDBACK__TEXT, oldText, text));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LearningCorpus getLearningCorpus() {
    if (eContainerFeatureID() != LearningcorpusPackage.FEEDBACK__LEARNING_CORPUS) return null;
    return (LearningCorpus)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLearningCorpus(LearningCorpus newLearningCorpus, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newLearningCorpus, LearningcorpusPackage.FEEDBACK__LEARNING_CORPUS, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLearningCorpus(LearningCorpus newLearningCorpus) {
    if (newLearningCorpus != eInternalContainer() || (eContainerFeatureID() != LearningcorpusPackage.FEEDBACK__LEARNING_CORPUS && newLearningCorpus != null)) {
      if (EcoreUtil.isAncestor(this, newLearningCorpus))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newLearningCorpus != null)
        msgs = ((InternalEObject)newLearningCorpus).eInverseAdd(this, LearningcorpusPackage.LEARNING_CORPUS__FEEDBACKS, LearningCorpus.class, msgs);
      msgs = basicSetLearningCorpus(newLearningCorpus, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusPackage.FEEDBACK__LEARNING_CORPUS, newLearningCorpus, newLearningCorpus));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case LearningcorpusPackage.FEEDBACK__MISTAKE_TYPE:
        if (mistakeType != null)
          msgs = ((InternalEObject)mistakeType).eInverseRemove(this, LearningcorpusPackage.MISTAKE_TYPE__FEEDBACKS, MistakeType.class, msgs);
        return basicSetMistakeType((MistakeType)otherEnd, msgs);
      case LearningcorpusPackage.FEEDBACK__LEARNING_CORPUS:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetLearningCorpus((LearningCorpus)otherEnd, msgs);
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
      case LearningcorpusPackage.FEEDBACK__MISTAKE_TYPE:
        return basicSetMistakeType(null, msgs);
      case LearningcorpusPackage.FEEDBACK__LEARNING_CORPUS:
        return basicSetLearningCorpus(null, msgs);
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
      case LearningcorpusPackage.FEEDBACK__LEARNING_CORPUS:
        return eInternalContainer().eInverseRemove(this, LearningcorpusPackage.LEARNING_CORPUS__FEEDBACKS, LearningCorpus.class, msgs);
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
      case LearningcorpusPackage.FEEDBACK__LEVEL:
        return getLevel();
      case LearningcorpusPackage.FEEDBACK__CONGRATULATORY:
        return isCongratulatory();
      case LearningcorpusPackage.FEEDBACK__USEFULNESS:
        return getUsefulness();
      case LearningcorpusPackage.FEEDBACK__HIGHLIGHT_PROBLEM:
        return isHighlightProblem();
      case LearningcorpusPackage.FEEDBACK__HIGHLIGHT_SOLUTION:
        return isHighlightSolution();
      case LearningcorpusPackage.FEEDBACK__MISTAKE_TYPE:
        if (resolve) return getMistakeType();
        return basicGetMistakeType();
      case LearningcorpusPackage.FEEDBACK__TEXT:
        return getText();
      case LearningcorpusPackage.FEEDBACK__LEARNING_CORPUS:
        return getLearningCorpus();
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
      case LearningcorpusPackage.FEEDBACK__LEVEL:
        setLevel((Integer)newValue);
        return;
      case LearningcorpusPackage.FEEDBACK__CONGRATULATORY:
        setCongratulatory((Boolean)newValue);
        return;
      case LearningcorpusPackage.FEEDBACK__USEFULNESS:
        setUsefulness((Double)newValue);
        return;
      case LearningcorpusPackage.FEEDBACK__HIGHLIGHT_PROBLEM:
        setHighlightProblem((Boolean)newValue);
        return;
      case LearningcorpusPackage.FEEDBACK__HIGHLIGHT_SOLUTION:
        setHighlightSolution((Boolean)newValue);
        return;
      case LearningcorpusPackage.FEEDBACK__MISTAKE_TYPE:
        setMistakeType((MistakeType)newValue);
        return;
      case LearningcorpusPackage.FEEDBACK__TEXT:
        setText((String)newValue);
        return;
      case LearningcorpusPackage.FEEDBACK__LEARNING_CORPUS:
        setLearningCorpus((LearningCorpus)newValue);
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
      case LearningcorpusPackage.FEEDBACK__LEVEL:
        setLevel(LEVEL_EDEFAULT);
        return;
      case LearningcorpusPackage.FEEDBACK__CONGRATULATORY:
        setCongratulatory(CONGRATULATORY_EDEFAULT);
        return;
      case LearningcorpusPackage.FEEDBACK__USEFULNESS:
        setUsefulness(USEFULNESS_EDEFAULT);
        return;
      case LearningcorpusPackage.FEEDBACK__HIGHLIGHT_PROBLEM:
        setHighlightProblem(HIGHLIGHT_PROBLEM_EDEFAULT);
        return;
      case LearningcorpusPackage.FEEDBACK__HIGHLIGHT_SOLUTION:
        setHighlightSolution(HIGHLIGHT_SOLUTION_EDEFAULT);
        return;
      case LearningcorpusPackage.FEEDBACK__MISTAKE_TYPE:
        setMistakeType((MistakeType)null);
        return;
      case LearningcorpusPackage.FEEDBACK__TEXT:
        setText(TEXT_EDEFAULT);
        return;
      case LearningcorpusPackage.FEEDBACK__LEARNING_CORPUS:
        setLearningCorpus((LearningCorpus)null);
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
      case LearningcorpusPackage.FEEDBACK__LEVEL:
        return level != LEVEL_EDEFAULT;
      case LearningcorpusPackage.FEEDBACK__CONGRATULATORY:
        return congratulatory != CONGRATULATORY_EDEFAULT;
      case LearningcorpusPackage.FEEDBACK__USEFULNESS:
        return usefulness != USEFULNESS_EDEFAULT;
      case LearningcorpusPackage.FEEDBACK__HIGHLIGHT_PROBLEM:
        return highlightProblem != HIGHLIGHT_PROBLEM_EDEFAULT;
      case LearningcorpusPackage.FEEDBACK__HIGHLIGHT_SOLUTION:
        return highlightSolution != HIGHLIGHT_SOLUTION_EDEFAULT;
      case LearningcorpusPackage.FEEDBACK__MISTAKE_TYPE:
        return mistakeType != null;
      case LearningcorpusPackage.FEEDBACK__TEXT:
        return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
      case LearningcorpusPackage.FEEDBACK__LEARNING_CORPUS:
        return getLearningCorpus() != null;
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
