/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Problem Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.ProblemStatement#getProblemStatementElements <em>Problem Statement Elements</em>}</li>
 *   <li>{@link modelingassistant.ProblemStatement#getText <em>Text</em>}</li>
 *   <li>{@link modelingassistant.ProblemStatement#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.ProblemStatement#getStudentSolution <em>Student Solution</em>}</li>
 *   <li>{@link modelingassistant.ProblemStatement#getInstructorSolution <em>Instructor Solution</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getProblemStatement()
 * @model
 * @generated
 */
public interface ProblemStatement extends NamedElement {
  /**
   * Returns the value of the '<em><b>Problem Statement Elements</b></em>' containment reference list.
   * The list contents are of type {@link modelingassistant.ProblemStatementElement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.ProblemStatementElement#getProblemStatement <em>Problem Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Problem Statement Elements</em>' containment reference list.
   * @see modelingassistant.ModelingassistantPackage#getProblemStatement_ProblemStatementElements()
   * @see modelingassistant.ProblemStatementElement#getProblemStatement
   * @model opposite="problemStatement" containment="true"
   * @generated
   */
  EList<ProblemStatementElement> getProblemStatementElements();

  /**
   * Returns the value of the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' attribute.
   * @see #setText(String)
   * @see modelingassistant.ModelingassistantPackage#getProblemStatement_Text()
   * @model
   * @generated
   */
  String getText();

  /**
   * Sets the value of the '{@link modelingassistant.ProblemStatement#getText <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' attribute.
   * @see #getText()
   * @generated
   */
  void setText(String value);

  /**
   * Returns the value of the '<em><b>Modeling Assistant</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ModelingAssistant#getProblemStatements <em>Problem Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modeling Assistant</em>' container reference.
   * @see #setModelingAssistant(ModelingAssistant)
   * @see modelingassistant.ModelingassistantPackage#getProblemStatement_ModelingAssistant()
   * @see modelingassistant.ModelingAssistant#getProblemStatements
   * @model opposite="problemStatements" required="true" transient="false"
   * @generated
   */
  ModelingAssistant getModelingAssistant();

  /**
   * Sets the value of the '{@link modelingassistant.ProblemStatement#getModelingAssistant <em>Modeling Assistant</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modeling Assistant</em>' container reference.
   * @see #getModelingAssistant()
   * @generated
   */
  void setModelingAssistant(ModelingAssistant value);

  /**
   * Returns the value of the '<em><b>Student Solution</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Solution}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Solution#getStudentProblemStatement <em>Student Problem Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Student Solution</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getProblemStatement_StudentSolution()
   * @see modelingassistant.Solution#getStudentProblemStatement
   * @model opposite="studentProblemStatement"
   * @generated
   */
  EList<Solution> getStudentSolution();

  /**
   * Returns the value of the '<em><b>Instructor Solution</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Solution#getInstructorProblemStatement <em>Instructor Problem Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instructor Solution</em>' reference.
   * @see #setInstructorSolution(Solution)
   * @see modelingassistant.ModelingassistantPackage#getProblemStatement_InstructorSolution()
   * @see modelingassistant.Solution#getInstructorProblemStatement
   * @model opposite="instructorProblemStatement" required="true"
   * @generated
   */
  Solution getInstructorSolution();

  /**
   * Sets the value of the '{@link modelingassistant.ProblemStatement#getInstructorSolution <em>Instructor Solution</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instructor Solution</em>' reference.
   * @see #getInstructorSolution()
   * @generated
   */
  void setInstructorSolution(Solution value);

} // ProblemStatement
