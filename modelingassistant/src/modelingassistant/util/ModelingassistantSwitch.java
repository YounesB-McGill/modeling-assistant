/**
 */
package modelingassistant.util;

import modelingassistant.*;

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
 * @see modelingassistant.ModelingassistantPackage
 * @generated
 */
public class ModelingassistantSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ModelingassistantPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingassistantSwitch() {
    if (modelPackage == null) {
      modelPackage = ModelingassistantPackage.eINSTANCE;
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
      case ModelingassistantPackage.MODELING_ASSISTANT: {
        ModelingAssistant modelingAssistant = (ModelingAssistant)theEObject;
        T result = caseModelingAssistant(modelingAssistant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelingassistantPackage.STUDENT: {
        Student student = (Student)theEObject;
        T result = caseStudent(student);
        if (result == null) result = caseNamedElement(student);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelingassistantPackage.PROBLEM_STATEMENT: {
        ProblemStatement problemStatement = (ProblemStatement)theEObject;
        T result = caseProblemStatement(problemStatement);
        if (result == null) result = caseNamedElement(problemStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelingassistantPackage.PROBLEM_STATEMENT_ELEMENT: {
        ProblemStatementElement problemStatementElement = (ProblemStatementElement)theEObject;
        T result = caseProblemStatementElement(problemStatementElement);
        if (result == null) result = caseNamedElement(problemStatementElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelingassistantPackage.SOLUTION: {
        Solution solution = (Solution)theEObject;
        T result = caseSolution(solution);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelingassistantPackage.SOLUTION_ELEMENT: {
        SolutionElement solutionElement = (SolutionElement)theEObject;
        T result = caseSolutionElement(solutionElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelingassistantPackage.STUDENT_KNOWLEDGE: {
        StudentKnowledge studentKnowledge = (StudentKnowledge)theEObject;
        T result = caseStudentKnowledge(studentKnowledge);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelingassistantPackage.MISTAKE: {
        Mistake mistake = (Mistake)theEObject;
        T result = caseMistake(mistake);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelingassistantPackage.NAMED_ELEMENT: {
        NamedElement namedElement = (NamedElement)theEObject;
        T result = caseNamedElement(namedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelingassistantPackage.FEEDBACK_ITEM: {
        FeedbackItem feedbackItem = (FeedbackItem)theEObject;
        T result = caseFeedbackItem(feedbackItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelingassistantPackage.TAG: {
        Tag tag = (Tag)theEObject;
        T result = caseTag(tag);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelingassistantPackage.TAG_GROUP: {
        TagGroup tagGroup = (TagGroup)theEObject;
        T result = caseTagGroup(tagGroup);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Modeling Assistant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Modeling Assistant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelingAssistant(ModelingAssistant object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Student</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Student</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStudent(Student object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Problem Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Problem Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProblemStatement(ProblemStatement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Problem Statement Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Problem Statement Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProblemStatementElement(ProblemStatementElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Solution</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Solution</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSolution(Solution object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Solution Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Solution Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSolutionElement(SolutionElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Student Knowledge</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Student Knowledge</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStudentKnowledge(StudentKnowledge object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mistake</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mistake</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMistake(Mistake object) {
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
   * Returns the result of interpreting the object as an instance of '<em>Feedback Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feedback Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeedbackItem(FeedbackItem object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tag</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tag</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTag(Tag object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tag Group</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tag Group</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTagGroup(TagGroup object) {
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

} //ModelingassistantSwitch
