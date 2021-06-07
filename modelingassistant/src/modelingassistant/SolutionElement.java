/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import ca.mcgill.sel.classdiagram.NamedElement;

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
 *   <li>{@link modelingassistant.SolutionElement#getSolution <em>Solution</em>}</li>
 *   <li>{@link modelingassistant.SolutionElement#getStudentElementMistakes <em>Student Element Mistakes</em>}</li>
 *   <li>{@link modelingassistant.SolutionElement#getElement <em>Element</em>}</li>
 *   <li>{@link modelingassistant.SolutionElement#getInstructorElementMistakes <em>Instructor Element Mistakes</em>}</li>
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
   * Returns the value of the '<em><b>Solution</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Solution#getSolutionElements <em>Solution Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution</em>' container reference.
   * @see #setSolution(Solution)
   * @see modelingassistant.ModelingassistantPackage#getSolutionElement_Solution()
   * @see modelingassistant.Solution#getSolutionElements
   * @model opposite="solutionElements" required="true" transient="false"
   * @generated
   */
  Solution getSolution();

  /**
   * Sets the value of the '{@link modelingassistant.SolutionElement#getSolution <em>Solution</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Solution</em>' container reference.
   * @see #getSolution()
   * @generated
   */
  void setSolution(Solution value);

  /**
   * Returns the value of the '<em><b>Student Element Mistakes</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Mistake}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Mistake#getStudentElements <em>Student Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Student Element Mistakes</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getSolutionElement_StudentElementMistakes()
   * @see modelingassistant.Mistake#getStudentElements
   * @model opposite="studentElements"
   * @generated
   */
  EList<Mistake> getStudentElementMistakes();

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

  /**
   * Returns the value of the '<em><b>Instructor Element Mistakes</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Mistake}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Mistake#getInstructorElements <em>Instructor Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instructor Element Mistakes</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getSolutionElement_InstructorElementMistakes()
   * @see modelingassistant.Mistake#getInstructorElements
   * @model opposite="instructorElements"
   * @generated
   */
  EList<Mistake> getInstructorElementMistakes();

} // SolutionElement
