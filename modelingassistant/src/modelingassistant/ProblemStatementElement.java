/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Problem Statement Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.ProblemStatementElement#getProblemStatement <em>Problem Statement</em>}</li>
 *   <li>{@link modelingassistant.ProblemStatementElement#getSolutionElements <em>Solution Elements</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getProblemStatementElement()
 * @model
 * @generated
 */
public interface ProblemStatementElement extends EObject {
  /**
   * Returns the value of the '<em><b>Problem Statement</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ProblemStatement#getProblemStatementElements <em>Problem Statement Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Problem Statement</em>' reference.
   * @see #setProblemStatement(ProblemStatement)
   * @see modelingassistant.ModelingassistantPackage#getProblemStatementElement_ProblemStatement()
   * @see modelingassistant.ProblemStatement#getProblemStatementElements
   * @model opposite="problemStatementElements" required="true"
   * @generated
   */
  ProblemStatement getProblemStatement();

  /**
   * Sets the value of the '{@link modelingassistant.ProblemStatementElement#getProblemStatement <em>Problem Statement</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Problem Statement</em>' reference.
   * @see #getProblemStatement()
   * @generated
   */
  void setProblemStatement(ProblemStatement value);

  /**
   * Returns the value of the '<em><b>Solution Elements</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.SolutionElement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.SolutionElement#getProblemStatementElements <em>Problem Statement Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution Elements</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getProblemStatementElement_SolutionElements()
   * @see modelingassistant.SolutionElement#getProblemStatementElements
   * @model opposite="problemStatementElements"
   * @generated
   */
  EList<SolutionElement> getSolutionElements();

} // ProblemStatementElement
