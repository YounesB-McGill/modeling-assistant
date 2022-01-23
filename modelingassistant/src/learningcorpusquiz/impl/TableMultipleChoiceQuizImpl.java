/**
 */
package learningcorpusquiz.impl;

import java.util.Collection;

import learningcorpus.impl.QuizImpl;

import learningcorpusquiz.LearningcorpusquizPackage;
import learningcorpusquiz.TableMcqColumnItem;
import learningcorpusquiz.TableMcqEntry;
import learningcorpusquiz.TableMcqRowItem;
import learningcorpusquiz.TableMultipleChoiceQuiz;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table Multiple Choice Quiz</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link learningcorpusquiz.impl.TableMultipleChoiceQuizImpl#getRowItems <em>Row Items</em>}</li>
 *   <li>{@link learningcorpusquiz.impl.TableMultipleChoiceQuizImpl#getColumnItems <em>Column Items</em>}</li>
 *   <li>{@link learningcorpusquiz.impl.TableMultipleChoiceQuizImpl#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableMultipleChoiceQuizImpl extends QuizImpl implements TableMultipleChoiceQuiz {
  /**
   * The cached value of the '{@link #getRowItems() <em>Row Items</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRowItems()
   * @generated
   * @ordered
   */
  protected EList<TableMcqRowItem> rowItems;

  /**
   * The cached value of the '{@link #getColumnItems() <em>Column Items</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumnItems()
   * @generated
   * @ordered
   */
  protected EList<TableMcqColumnItem> columnItems;

  /**
   * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
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
  protected TableMultipleChoiceQuizImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LearningcorpusquizPackage.Literals.TABLE_MULTIPLE_CHOICE_QUIZ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<TableMcqRowItem> getRowItems() {
    if (rowItems == null) {
      rowItems = new EObjectContainmentWithInverseEList<TableMcqRowItem>(TableMcqRowItem.class, this, LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS, LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM__QUIZ);
    }
    return rowItems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<TableMcqColumnItem> getColumnItems() {
    if (columnItems == null) {
      columnItems = new EObjectContainmentWithInverseEList<TableMcqColumnItem>(TableMcqColumnItem.class, this, LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS, LearningcorpusquizPackage.TABLE_MCQ_COLUMN_ITEM__QUIZ);
    }
    return columnItems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<TableMcqEntry> getEntries() {
    if (entries == null) {
      entries = new EObjectContainmentWithInverseEList<TableMcqEntry>(TableMcqEntry.class, this, LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ENTRIES, LearningcorpusquizPackage.TABLE_MCQ_ENTRY__QUIZ);
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
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getRowItems()).basicAdd(otherEnd, msgs);
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getColumnItems()).basicAdd(otherEnd, msgs);
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ENTRIES:
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
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS:
        return ((InternalEList<?>)getRowItems()).basicRemove(otherEnd, msgs);
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS:
        return ((InternalEList<?>)getColumnItems()).basicRemove(otherEnd, msgs);
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ENTRIES:
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
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS:
        return getRowItems();
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS:
        return getColumnItems();
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ENTRIES:
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
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS:
        getRowItems().clear();
        getRowItems().addAll((Collection<? extends TableMcqRowItem>)newValue);
        return;
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS:
        getColumnItems().clear();
        getColumnItems().addAll((Collection<? extends TableMcqColumnItem>)newValue);
        return;
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ENTRIES:
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
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS:
        getRowItems().clear();
        return;
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS:
        getColumnItems().clear();
        return;
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ENTRIES:
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
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS:
        return rowItems != null && !rowItems.isEmpty();
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS:
        return columnItems != null && !columnItems.isEmpty();
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ENTRIES:
        return entries != null && !entries.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TableMultipleChoiceQuizImpl
