/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import ca.mcgill.sel.classdiagram.ClassDiagram;

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
 *   <li>{@link modelingassistant.Solution#getMistakes <em>Mistakes</em>}</li>
 *   <li>{@link modelingassistant.Solution#getCurrentMistake <em>Current Mistake</em>}</li>
 *   <li>{@link modelingassistant.Solution#getStudentProblemStatement <em>Student Problem Statement</em>}</li>
 *   <li>{@link modelingassistant.Solution#getInstructorProblemStatement <em>Instructor Problem Statement</em>}</li>
 *   <li>{@link modelingassistant.Solution#getCurrentStudent <em>Current Student</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getSolution()
 * @model
 * @generated
 */
public interface Solution extends EObject {
  /**
   * Returns the value of the '<em><b>Modeling Assistant</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ModelingAssistant#getSolutions <em>Solutions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modeling Assistant</em>' container reference.
   * @see #setModelingAssistant(ModelingAssistant)
   * @see modelingassistant.ModelingassistantPackage#getSolution_ModelingAssistant()
   * @see modelingassistant.ModelingAssistant#getSolutions
   * @model opposite="solutions" required="true" transient="false"
   * @generated
   */
  ModelingAssistant getModelingAssistant();

  /**
   * Sets the value of the '{@link modelingassistant.Solution#getModelingAssistant <em>Modeling Assistant</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modeling Assistant</em>' container reference.
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
   * Returns the value of the '<em><b>Solution Elements</b></em>' containment reference list.
   * The list contents are of type {@link modelingassistant.SolutionElement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.SolutionElement#getSolution <em>Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution Elements</em>' containment reference list.
   * @see modelingassistant.ModelingassistantPackage#getSolution_SolutionElements()
   * @see modelingassistant.SolutionElement#getSolution
   * @model opposite="solution" containment="true"
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

  /**
   * Returns the value of the '<em><b>Mistakes</b></em>' containment reference list.
   * The list contents are of type {@link modelingassistant.Mistake}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Mistake#getStudentSolution <em>Student Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistakes</em>' containment reference list.
   * @see modelingassistant.ModelingassistantPackage#getSolution_Mistakes()
   * @see modelingassistant.Mistake#getStudentSolution
   * @model opposite="studentSolution" containment="true"
   * @generated
   */
  EList<Mistake> getMistakes();

  /**
   * Returns the value of the '<em><b>Current Mistake</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Current Mistake</em>' reference.
   * @see #setCurrentMistake(Mistake)
   * @see modelingassistant.ModelingassistantPackage#getSolution_CurrentMistake()
   * @model
   * @generated
   */
  Mistake getCurrentMistake();

  /**
   * Sets the value of the '{@link modelingassistant.Solution#getCurrentMistake <em>Current Mistake</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Current Mistake</em>' reference.
   * @see #getCurrentMistake()
   * @generated
   */
  void setCurrentMistake(Mistake value);

  /**
   * Returns the value of the '<em><b>Student Problem Statement</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ProblemStatement#getStudentSolution <em>Student Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Student Problem Statement</em>' reference.
   * @see #setStudentProblemStatement(ProblemStatement)
   * @see modelingassistant.ModelingassistantPackage#getSolution_StudentProblemStatement()
   * @see modelingassistant.ProblemStatement#getStudentSolution
   * @model opposite="studentSolution" required="true"
   * @generated
   */
  ProblemStatement getStudentProblemStatement();

  /**
   * Sets the value of the '{@link modelingassistant.Solution#getStudentProblemStatement <em>Student Problem Statement</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Student Problem Statement</em>' reference.
   * @see #getStudentProblemStatement()
   * @generated
   */
  void setStudentProblemStatement(ProblemStatement value);

  /**
   * Returns the value of the '<em><b>Instructor Problem Statement</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ProblemStatement#getInstructorSolution <em>Instructor Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instructor Problem Statement</em>' reference.
   * @see #setInstructorProblemStatement(ProblemStatement)
   * @see modelingassistant.ModelingassistantPackage#getSolution_InstructorProblemStatement()
   * @see modelingassistant.ProblemStatement#getInstructorSolution
   * @model opposite="instructorSolution" required="true"
   * @generated
   */
  ProblemStatement getInstructorProblemStatement();

  /**
   * Sets the value of the '{@link modelingassistant.Solution#getInstructorProblemStatement <em>Instructor Problem Statement</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instructor Problem Statement</em>' reference.
   * @see #getInstructorProblemStatement()
   * @generated
   */
  void setInstructorProblemStatement(ProblemStatement value);

  /**
   * Returns the value of the '<em><b>Current Student</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Student#getCurrentSolution <em>Current Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Current Student</em>' reference.
   * @see #setCurrentStudent(Student)
   * @see modelingassistant.ModelingassistantPackage#getSolution_CurrentStudent()
   * @see modelingassistant.Student#getCurrentSolution
   * @model opposite="currentSolution"
   * @generated
   */
  Student getCurrentStudent();

  /**
   * Sets the value of the '{@link modelingassistant.Solution#getCurrentStudent <em>Current Student</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Current Student</em>' reference.
   * @see #getCurrentStudent()
   * @generated
   */
  void setCurrentStudent(Student value);

} // Solution
