/**
 */
package learningcorpusquiz.impl;

import java.util.Collection;

import learningcorpusquiz.LearningcorpusquizPackage;
import learningcorpusquiz.TableMcqEntry;
import learningcorpusquiz.TableMcqRowItem;
import learningcorpusquiz.TableMultipleChoiceQuiz;

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
 * An implementation of the model object '<em><b>Table Mcq Row Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.impl.TableMcqRowItemImpl#getText <em>Text</em>}</li>
 *   <li>{@link learningcorpusquiz.impl.TableMcqRowItemImpl#getQuiz <em>Quiz</em>}</li>
 *   <li>{@link learningcorpusquiz.impl.TableMcqRowItemImpl#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableMcqRowItemImpl extends MinimalEObjectImpl.Container implements TableMcqRowItem {
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
   * The cached value of the '{@link #getEntries() <em>Entries</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEntries()
   * @generated
   * @ordered
   */
  protected EList<TableMcqEntry> entries;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TableMcqRowItemImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LearningcorpusquizPackage.Literals.TABLE_MCQ_ROW_ITEM;
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
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__TEXT, oldText, text));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TableMultipleChoiceQuiz getQuiz() {
    if (eContainerFeatureID() != LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__QUIZ) return null;
    return (TableMultipleChoiceQuiz)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQuiz(TableMultipleChoiceQuiz newQuiz, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newQuiz, LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__QUIZ, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setQuiz(TableMultipleChoiceQuiz newQuiz) {
    if (newQuiz != eInternalContainer() || (eContainerFeatureID() != LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__QUIZ && newQuiz != null)) {
      if (EcoreUtil.isAncestor(this, newQuiz))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newQuiz != null)
        msgs = ((InternalEObject)newQuiz).eInverseAdd(this, LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS, TableMultipleChoiceQuiz.class, msgs);
      msgs = basicSetQuiz(newQuiz, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__QUIZ, newQuiz, newQuiz));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<TableMcqEntry> getEntries() {
    if (entries == null) {
      entries = new EObjectWithInverseResolvingEList<TableMcqEntry>(TableMcqEntry.class, this, LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__ENTRIES, LearningcorpusquizPackage.TABLE_MCQ_ENTRY__ROWITEM);
    }
    return entries;
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
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__QUIZ:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetQuiz((TableMultipleChoiceQuiz)otherEnd, msgs);
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__ENTRIES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getEntries()).basicAdd(otherEnd, msgs);
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
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__QUIZ:
        return basicSetQuiz(null, msgs);
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__ENTRIES:
        return ((InternalEList<?>)getEntries()).basicRemove(otherEnd, msgs);
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
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__QUIZ:
        return eInternalContainer().eInverseRemove(this, LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS, TableMultipleChoiceQuiz.class, msgs);
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
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__TEXT:
        return getText();
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__QUIZ:
        return getQuiz();
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__ENTRIES:
        return getEntries();
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
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__TEXT:
        setText((String)newValue);
        return;
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__QUIZ:
        setQuiz((TableMultipleChoiceQuiz)newValue);
        return;
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__ENTRIES:
        getEntries().clear();
        getEntries().addAll((Collection<? extends TableMcqEntry>)newValue);
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
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__TEXT:
        setText(TEXT_EDEFAULT);
        return;
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__QUIZ:
        setQuiz((TableMultipleChoiceQuiz)null);
        return;
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__ENTRIES:
        getEntries().clear();
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
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__TEXT:
        return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__QUIZ:
        return getQuiz() != null;
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__ENTRIES:
        return entries != null && !entries.isEmpty();
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

} //TableMcqRowItemImpl
