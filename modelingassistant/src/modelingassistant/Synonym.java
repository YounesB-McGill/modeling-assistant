/**
 */
package modelingassistant;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Synonym</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.Synonym#getSolutionElement <em>Solution Element</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getSynonym()
 * @model
 * @generated
 */
public interface Synonym extends NamedElement {
  /**
   * Returns the value of the '<em><b>Solution Element</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.SolutionElement#getSynonyms <em>Synonyms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution Element</em>' container reference.
   * @see #setSolutionElement(SolutionElement)
   * @see modelingassistant.ModelingassistantPackage#getSynonym_SolutionElement()
   * @see modelingassistant.SolutionElement#getSynonyms
   * @model opposite="synonyms" transient="false"
   * @generated
   */
  SolutionElement getSolutionElement();

  /**
   * Sets the value of the '{@link modelingassistant.Synonym#getSolutionElement <em>Solution Element</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Solution Element</em>' container reference.
   * @see #getSolutionElement()
   * @generated
   */
  void setSolutionElement(SolutionElement value);

} // Synonym
