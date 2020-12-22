/**
 */
package modelingassistant;

import classdiagram.ClassDiagram;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.Solution#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.Solution#getStudent <em>Student</em>}</li>
 *   <li>{@link modelingassistant.Solution#getSolutionElements <em>Solution Elements</em>}</li>
 *   <li>{@link modelingassistant.Solution#getClassDiagram <em>Class Diagram</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getSolution()
 * @model
 * @generated
 */
public interface Solution extends EObject {
  /**
   * Returns the value of the '<em><b>Modeling Assistant</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ModelingAssistant#getSolutions <em>Solutions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modeling Assistant</em>' reference.
   * @see #setModelingAssistant(ModelingAssistant)
   * @see modelingassistant.ModelingassistantPackage#getSolution_ModelingAssistant()
   * @see modelingassistant.ModelingAssistant#getSolutions
   * @model opposite="solutions" required="true"
   * @generated
   */
  ModelingAssistant getModelingAssistant();

  /**
   * Sets the value of the '{@link modelingassistant.Solution#getModelingAssistant <em>Modeling Assistant</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modeling Assistant</em>' reference.
   * @see #getModelingAssistant()
   * @generated
   */
  void setModelingAssistant(ModelingAssistant value);

  /**
   * Returns the value of the '<em><b>Student</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Student#getSolutions <em>Solutions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Student</em>' reference.
   * @see #setStudent(Student)
   * @see modelingassistant.ModelingassistantPackage#getSolution_Student()
   * @see modelingassistant.Student#getSolutions
   * @model opposite="solutions"
   * @generated
   */
  Student getStudent();

  /**
   * Sets the value of the '{@link modelingassistant.Solution#getStudent <em>Student</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Student</em>' reference.
   * @see #getStudent()
   * @generated
   */
  void setStudent(Student value);

  /**
   * Returns the value of the '<em><b>Solution Elements</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.SolutionElement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.SolutionElement#getSolution <em>Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution Elements</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getSolution_SolutionElements()
   * @see modelingassistant.SolutionElement#getSolution
   * @model opposite="solution"
   * @generated
   */
  EList<SolutionElement> getSolutionElements();

  /**
   * Returns the value of the '<em><b>Class Diagram</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Diagram</em>' reference.
   * @see #setClassDiagram(ClassDiagram)
   * @see modelingassistant.ModelingassistantPackage#getSolution_ClassDiagram()
   * @model required="true"
   * @generated
   */
  ClassDiagram getClassDiagram();

  /**
   * Sets the value of the '{@link modelingassistant.Solution#getClassDiagram <em>Class Diagram</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Diagram</em>' reference.
   * @see #getClassDiagram()
   * @generated
   */
  void setClassDiagram(ClassDiagram value);

} // Solution