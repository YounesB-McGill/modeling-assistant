/**
 */
package modelingassistant;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uml Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.UmlElement#getModelingAssistant <em>Modeling Assistant</em>}</li>
 *   <li>{@link modelingassistant.UmlElement#getSolutionElements <em>Solution Elements</em>}</li>
 *   <li>{@link modelingassistant.UmlElement#getLearningItems <em>Learning Items</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getUmlElement()
 * @model
 * @generated
 */
public interface UmlElement extends EObject {
  /**
   * Returns the value of the '<em><b>Modeling Assistant</b></em>' reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.ModelingAssistant#getUmlElements <em>Uml Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modeling Assistant</em>' reference.
   * @see #setModelingAssistant(ModelingAssistant)
   * @see modelingassistant.ModelingassistantPackage#getUmlElement_ModelingAssistant()
   * @see modelingassistant.ModelingAssistant#getUmlElements
   * @model opposite="umlElements" required="true"
   * @generated
   */
  ModelingAssistant getModelingAssistant();

  /**
   * Sets the value of the '{@link modelingassistant.UmlElement#getModelingAssistant <em>Modeling Assistant</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modeling Assistant</em>' reference.
   * @see #getModelingAssistant()
   * @generated
   */
  void setModelingAssistant(ModelingAssistant value);

  /**
   * Returns the value of the '<em><b>Solution Elements</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.SolutionElement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.SolutionElement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution Elements</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getUmlElement_SolutionElements()
   * @see modelingassistant.SolutionElement#getType
   * @model opposite="type"
   * @generated
   */
  EList<SolutionElement> getSolutionElements();

  /**
   * Returns the value of the '<em><b>Learning Items</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.LearningItem}.
   * It is bidirectional and its opposite is '{@link modelingassistant.LearningItem#getUmlElements <em>Uml Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Items</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getUmlElement_LearningItems()
   * @see modelingassistant.LearningItem#getUmlElements
   * @model opposite="umlElements"
   * @generated
   */
  EList<LearningItem> getLearningItems();

} // UmlElement
