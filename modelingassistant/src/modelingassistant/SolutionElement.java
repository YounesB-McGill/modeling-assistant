/**
 */
package modelingassistant;

import classdiagram.NamedElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solution Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.SolutionElement#getProblemStatementElements <em>Problem Statement Elements</em>}</li>
 *   <li>{@link modelingassistant.SolutionElement#getType <em>Type</em>}</li>
 *   <li>{@link modelingassistant.SolutionElement#getSolution <em>Solution</em>}</li>
 *   <li>{@link modelingassistant.SolutionElement#getMistakes <em>Mistakes</em>}</li>
 *   <li>{@link modelingassistant.SolutionElement#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getSolutionElement()
 * @model
 * @generated
 */
public interface SolutionElement extends EObject {
  /**
   * Returns the value of the '<em><b>Problem Statement Elements</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.ProblemStatementElement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.ProblemStatementElement#getSolutionElements <em>Solution Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Problem Statement Elements</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getSolutionElement_ProblemStatementElements()
   * @see modelingassistant.ProblemStatementElement#getSolutionElements
   * @model opposite="solutionElements"
   * @generated
   */
  EList<ProblemStatementElement> getProblemStatementElements();

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.UmlElement#getSolutionElements <em>Solution Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(UmlElement)
   * @see modelingassistant.ModelingassistantPackage#getSolutionElement_Type()
   * @see modelingassistant.UmlElement#getSolutionElements
   * @model opposite="solutionElements" required="true"
   * @generated
   */
  UmlElement getType();

  /**
   * Sets the value of the '{@link modelingassistant.SolutionElement#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(UmlElement value);

  /**
   * Returns the value of the '<em><b>Solution</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Solution#getSolutionElements <em>Solution Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution</em>' reference.
   * @see #setSolution(Solution)
   * @see modelingassistant.ModelingassistantPackage#getSolutionElement_Solution()
   * @see modelingassistant.Solution#getSolutionElements
   * @model opposite="solutionElements" required="true"
   * @generated
   */
  Solution getSolution();

  /**
   * Sets the value of the '{@link modelingassistant.SolutionElement#getSolution <em>Solution</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Solution</em>' reference.
   * @see #getSolution()
   * @generated
   */
  void setSolution(Solution value);

  /**
   * Returns the value of the '<em><b>Mistakes</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Mistake}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Mistake#getSolutionElements <em>Solution Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistakes</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getSolutionElement_Mistakes()
   * @see modelingassistant.Mistake#getSolutionElements
   * @model opposite="solutionElements"
   * @generated
   */
  EList<Mistake> getMistakes();

  /**
   * Returns the value of the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' reference.
   * @see #setElement(NamedElement)
   * @see modelingassistant.ModelingassistantPackage#getSolutionElement_Element()
   * @model required="true"
   * @generated
   */
  NamedElement getElement();

  /**
   * Sets the value of the '{@link modelingassistant.SolutionElement#getElement <em>Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' reference.
   * @see #getElement()
   * @generated
   */
  void setElement(NamedElement value);

} // SolutionElement
