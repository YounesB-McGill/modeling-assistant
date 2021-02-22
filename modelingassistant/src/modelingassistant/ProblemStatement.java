/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Problem Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.ProblemStatement#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.ProblemStatement#getProblemStatementElements <em>Problem Statement Elements</em>}</li>
 *   <li>{@link modelingassistant.ProblemStatement#getTitle <em>Title</em>}</li>
 *   <li>{@link modelingassistant.ProblemStatement#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getProblemStatement()
 * @model
 * @generated
 */
public interface ProblemStatement extends EObject {
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
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see modelingassistant.ModelingassistantPackage#getProblemStatement_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link modelingassistant.ProblemStatement#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

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

} // ProblemStatement
