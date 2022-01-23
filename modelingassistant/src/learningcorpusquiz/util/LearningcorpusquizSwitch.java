/**
 */
package learningcorpusquiz.util;

import learningcorpus.LearningResource;
import learningcorpus.NamedElement;
import learningcorpus.Quiz;

import learningcorpusquiz.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see learningcorpusquiz.LearningcorpusquizPackage
 * @generated
 */
public class LearningcorpusquizSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static LearningcorpusquizPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningcorpusquizSwitch() {
    if (modelPackage == null) {
      modelPackage = LearningcorpusquizPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ: {
        FillInTheBlanksQuiz fillInTheBlanksQuiz = (FillInTheBlanksQuiz)theEObject;
        T result = caseFillInTheBlanksQuiz(fillInTheBlanksQuiz);
        if (result == null) result = caseQuiz(fillInTheBlanksQuiz);
        if (result == null) result = caseLearningResource(fillInTheBlanksQuiz);
        if (result == null) result = caseNamedElement(fillInTheBlanksQuiz);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LearningcorpusquizPackage.LIST_MULTIPLE_CHOICE_QUIZ: {
        ListMultipleChoiceQuiz listMultipleChoiceQuiz = (ListMultipleChoiceQuiz)theEObject;
        T result = caseListMultipleChoiceQuiz(listMultipleChoiceQuiz);
        if (result == null) result = caseQuiz(listMultipleChoiceQuiz);
        if (result == null) result = caseLearningResource(listMultipleChoiceQuiz);
        if (result == null) result = caseNamedElement(listMultipleChoiceQuiz);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ: {
        TableMultipleChoiceQuiz tableMultipleChoiceQuiz = (TableMultipleChoiceQuiz)theEObject;
        T result = caseTableMultipleChoiceQuiz(tableMultipleChoiceQuiz);
        if (result == null) result = caseQuiz(tableMultipleChoiceQuiz);
        if (result == null) result = caseLearningResource(tableMultipleChoiceQuiz);
        if (result == null) result = caseNamedElement(tableMultipleChoiceQuiz);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT: {
        FillInTheBlanksQuizStatement fillInTheBlanksQuizStatement = (FillInTheBlanksQuizStatement)theEObject;
        T result = caseFillInTheBlanksQuizStatement(fillInTheBlanksQuizStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ_STATEMENT_COMPONENT: {
        FillInTheBlanksQuizStatementComponent fillInTheBlanksQuizStatementComponent = (FillInTheBlanksQuizStatementComponent)theEObject;
        T result = caseFillInTheBlanksQuizStatementComponent(fillInTheBlanksQuizStatementComponent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LearningcorpusquizPackage.NON_BLANK: {
        NonBlank nonBlank = (NonBlank)theEObject;
        T result = caseNonBlank(nonBlank);
        if (result == null) result = caseFillInTheBlanksQuizStatementComponent(nonBlank);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LearningcorpusquizPackage.BLANK: {
        Blank blank = (Blank)theEObject;
        T result = caseBlank(blank);
        if (result == null) result = caseFillInTheBlanksQuizStatementComponent(blank);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LearningcorpusquizPackage.CHOICE: {
        Choice choice = (Choice)theEObject;
        T result = caseChoice(choice);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LearningcorpusquizPackage.TABLE_MCQ_CORRECT_ENTRY: {
        TableMcqCorrectEntry tableMcqCorrectEntry = (TableMcqCorrectEntry)theEObject;
        T result = caseTableMcqCorrectEntry(tableMcqCorrectEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LearningcorpusquizPackage.TABLE_MCQ_ROW_ITEM: {
        TableMcqRowItem tableMcqRowItem = (TableMcqRowItem)theEObject;
        T result = caseTableMcqRowItem(tableMcqRowItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LearningcorpusquizPackage.TABLE_MCQ_COLUMN_ITEM: {
        TableMcqColumnItem tableMcqColumnItem = (TableMcqColumnItem)theEObject;
        T result = caseTableMcqColumnItem(tableMcqColumnItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fill In The Blanks Quiz</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fill In The Blanks Quiz</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFillInTheBlanksQuiz(FillInTheBlanksQuiz object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List Multiple Choice Quiz</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List Multiple Choice Quiz</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseListMultipleChoiceQuiz(ListMultipleChoiceQuiz object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Table Multiple Choice Quiz</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Table Multiple Choice Quiz</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTableMultipleChoiceQuiz(TableMultipleChoiceQuiz object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fill In The Blanks Quiz Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fill In The Blanks Quiz Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFillInTheBlanksQuizStatement(FillInTheBlanksQuizStatement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fill In The Blanks Quiz Statement Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fill In The Blanks Quiz Statement Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFillInTheBlanksQuizStatementComponent(FillInTheBlanksQuizStatementComponent object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Non Blank</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Non Blank</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNonBlank(NonBlank object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Blank</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Blank</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlank(Blank object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Choice</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Choice</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChoice(Choice object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Table Mcq Correct Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Table Mcq Correct Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTableMcqCorrectEntry(TableMcqCorrectEntry object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Table Mcq Row Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Table Mcq Row Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTableMcqRowItem(TableMcqRowItem object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Table Mcq Column Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Table Mcq Column Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTableMcqColumnItem(TableMcqColumnItem object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElement(NamedElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Learning Resource</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Learning Resource</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLearningResource(LearningResource object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Quiz</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Quiz</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQuiz(Quiz object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object) {
    return null;
  }

} //LearningcorpusquizSwitch
