/**
 */
package learningcorpusquiz.impl;

import learningcorpusquiz.LearningcorpusquizPackage;
import learningcorpusquiz.TableMcqColumnItem;
import learningcorpusquiz.TableMcqEntry;
import learningcorpusquiz.TableMcqRowItem;
import learningcorpusquiz.TableMultipleChoiceQuiz;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table Mcq Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.impl.TableMcqEntryImpl#getQuiz <em>Quiz</em>}</li>
 *   <li>{@link learningcorpusquiz.impl.TableMcqEntryImpl#getColumnItem <em>Column Item</em>}</li>
 *   <li>{@link learningcorpusquiz.impl.TableMcqEntryImpl#getRowitem <em>Rowitem</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableMcqEntryImpl extends MinimalEObjectImpl.Container implements TableMcqEntry {
  /**
   * The cached value of the '{@link #getColumnItem() <em>Column Item</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumnItem()
   * @generated
   * @ordered
   */
  protected TableMcqColumnItem columnItem;

  /**
   * The cached value of the '{@link #getRowitem() <em>Rowitem</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRowitem()
   * @generated
   * @ordered
   */
  protected TableMcqRowItem rowitem;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TableMcqEntryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LearningcorpusquizPackage.Literals.TABLE_MCQ_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TableMultipleChoiceQuiz getQuiz() {
    if (eContainerFeatureID() != LearningcorpusquizPackage.TABLE_MCQ_ENTRY__QUIZ) return null;
    return (TableMultipleChoiceQuiz)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQuiz(TableMultipleChoiceQuiz newQuiz, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newQuiz, LearningcorpusquizPackage.TABLE_MCQ_ENTRY__QUIZ, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setQuiz(TableMultipleChoiceQuiz newQuiz) {
    if (newQuiz != eInternalContainer() || (eContainerFeatureID() != LearningcorpusquizPackage.TABLE_MCQ_ENTRY__QUIZ && newQuiz != null)) {
      if (EcoreUtil.isAncestor(this, newQuiz))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newQuiz != null)
        msgs = ((InternalEObject)newQuiz).eInverseAdd(this, LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ENTRIES, TableMultipleChoiceQuiz.class, msgs);
      msgs = basicSetQuiz(newQuiz, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusquizPackage.TABLE_MCQ_ENTRY__QUIZ, newQuiz, newQuiz));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TableMcqColumnItem getColumnItem() {
    if (columnItem != null && columnItem.eIsProxy()) {
      InternalEObject oldColumnItem = (InternalEObject)columnItem;
      columnItem = (TableMcqColumnItem)eResolveProxy(oldColumnItem);
      if (columnItem != oldColumnItem) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LearningcorpusquizPackage.TABLE_MCQ_ENTRY__COLUMN_ITEM, oldColumnItem, columnItem));
      }
    }
    return columnItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TableMcqColumnItem basicGetColumnItem() {
    return columnItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetColumnItem(TableMcqColumnItem newColumnItem, NotificationChain msgs) {
    TableMcqColumnItem oldColumnItem = columnItem;
    columnItem = newColumnItem;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LearningcorpusquizPackage.TABLE_MCQ_ENTRY__COLUMN_ITEM, oldColumnItem, newColumnItem);
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
  public void setColumnItem(TableMcqColumnItem newColumnItem) {
    if (newColumnItem != columnItem) {
      NotificationChain msgs = null;
      if (columnItem != null)
        msgs = ((InternalEObject)columnItem).eInverseRemove(this, LearningcorpusquizPackage.TABLE_MCQ_COLUMN_ITEM__ENTRIES, TableMcqColumnItem.class, msgs);
      if (newColumnItem != null)
        msgs = ((InternalEObject)newColumnItem).eInverseAdd(this, LearningcorpusquizPackage.TABLE_MCQ_COLUMN_ITEM__ENTRIES, TableMcqColumnItem.class, msgs);
      msgs = basicSetColumnItem(newColumnItem, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusquizPackage.TABLE_MCQ_ENTRY__COLUMN_ITEM, newColumnItem, newColumnItem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TableMcqRowItem getRowitem() {
    if (rowitem != null && rowitem.eIsProxy()) {
      InternalEObject oldRowitem = (InternalEObject)rowitem;
      rowitem = (TableMcqRowItem)eResolveProxy(oldRowitem);
      if (rowitem != oldRowitem) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LearningcorpusquizPackage.TABLE_MCQ_ENTRY__ROWITEM, oldRowitem, rowitem));
      }
    }
    return rowitem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TableMcqRowItem basicGetRowitem() {
    return rowitem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRowitem(TableMcqRowItem newRowitem, NotificationChain msgs) {
    TableMcqRowItem oldRowitem = rowitem;
    rowitem = newRowitem;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LearningcorpusquizPackage.TABLE_MCQ_ENTRY__ROWITEM, oldRowitem, newRowitem);
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
  public void setRowitem(TableMcqRowItem newRowitem) {
    if (newRowitem != rowitem) {
      NotificationChain msgs = null;
      if (rowitem != null)
        msgs = ((InternalEObject)rowitem).eInverseRemove(this, LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__ENTRIES, TableMcqRowItem.class, msgs);
      if (newRowitem != null)
        msgs = ((InternalEObject)newRowitem).eInverseAdd(this, LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__ENTRIES, TableMcqRowItem.class, msgs);
      msgs = basicSetRowitem(newRowitem, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LearningcorpusquizPackage.TABLE_MCQ_ENTRY__ROWITEM, newRowitem, newRowitem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__QUIZ:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetQuiz((TableMultipleChoiceQuiz)otherEnd, msgs);
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__COLUMN_ITEM:
        if (columnItem != null)
          msgs = ((InternalEObject)columnItem).eInverseRemove(this, LearningcorpusquizPackage.TABLE_MCQ_COLUMN_ITEM__ENTRIES, TableMcqColumnItem.class, msgs);
        return basicSetColumnItem((TableMcqColumnItem)otherEnd, msgs);
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__ROWITEM:
        if (rowitem != null)
          msgs = ((InternalEObject)rowitem).eInverseRemove(this, LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__ENTRIES, TableMcqRowItem.class, msgs);
        return basicSetRowitem((TableMcqRowItem)otherEnd, msgs);
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
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__QUIZ:
        return basicSetQuiz(null, msgs);
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__COLUMN_ITEM:
        return basicSetColumnItem(null, msgs);
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__ROWITEM:
        return basicSetRowitem(null, msgs);
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
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__QUIZ:
        return eInternalContainer().eInverseRemove(this, LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ENTRIES, TableMultipleChoiceQuiz.class, msgs);
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
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__QUIZ:
        return getQuiz();
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__COLUMN_ITEM:
        if (resolve) return getColumnItem();
        return basicGetColumnItem();
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__ROWITEM:
        if (resolve) return getRowitem();
        return basicGetRowitem();
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
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__QUIZ:
        setQuiz((TableMultipleChoiceQuiz)newValue);
        return;
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__COLUMN_ITEM:
        setColumnItem((TableMcqColumnItem)newValue);
        return;
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__ROWITEM:
        setRowitem((TableMcqRowItem)newValue);
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
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__QUIZ:
        setQuiz((TableMultipleChoiceQuiz)null);
        return;
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__COLUMN_ITEM:
        setColumnItem((TableMcqColumnItem)null);
        return;
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__ROWITEM:
        setRowitem((TableMcqRowItem)null);
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
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__QUIZ:
        return getQuiz() != null;
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__COLUMN_ITEM:
        return columnItem != null;
      case LearningcorpusquizPackage.TABLE_MCQ_ENTRY__ROWITEM:
        return rowitem != null;
    }
    return super.eIsSet(featureID);
  }

} //TableMcqEntryImpl
