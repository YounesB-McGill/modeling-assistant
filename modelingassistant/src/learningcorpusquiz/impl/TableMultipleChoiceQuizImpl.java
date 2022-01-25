/**
 */
package learningcorpusquiz.impl;

import java.util.Collection;

import learningcorpus.impl.QuizImpl;

import learningcorpusquiz.LearningcorpusquizPackage;
import learningcorpusquiz.TableMcqColumnItem;
import learningcorpusquiz.TableMcqCorrectEntry;
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
 *   <li>{@link learningcorpusquiz.impl.TableMultipleChoiceQuizImpl#getCorrectEntries <em>Correct Entries</em>}</li>
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
   * The cached value of the '{@link #getCorrectEntries() <em>Correct Entries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCorrectEntries()
   * @generated
   * @ordered
   */
  protected EList<TableMcqCorrectEntry> correctEntries;

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
  public EList<TableMcqCorrectEntry> getCorrectEntries() {
    if (correctEntries == null) {
      correctEntries = new EObjectContainmentWithInverseEList<TableMcqCorrectEntry>(TableMcqCorrectEntry.class, this, LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__CORRECT_ENTRIES, LearningcorpusquizPackage.TABLE_MCQ_CORRECT_ENTRY__QUIZ);
    }
    return correctEntries;
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
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__CORRECT_ENTRIES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getCorrectEntries()).basicAdd(otherEnd, msgs);
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
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__CORRECT_ENTRIES:
        return ((InternalEList<?>)getCorrectEntries()).basicRemove(otherEnd, msgs);
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
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__CORRECT_ENTRIES:
        return getCorrectEntries();
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
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__CORRECT_ENTRIES:
        getCorrectEntries().clear();
        getCorrectEntries().addAll((Collection<? extends TableMcqCorrectEntry>)newValue);
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
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__CORRECT_ENTRIES:
        getCorrectEntries().clear();
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
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__CORRECT_ENTRIES:
        return correctEntries != null && !correctEntries.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TableMultipleChoiceQuizImpl
