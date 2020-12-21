/**
 */
package classdiagram;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.Classifier#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link classdiagram.Classifier#isDataType <em>Data Type</em>}</li>
 *   <li>{@link classdiagram.Classifier#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link classdiagram.Classifier#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link classdiagram.Classifier#getOperations <em>Operations</em>}</li>
 *   <li>{@link classdiagram.Classifier#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link classdiagram.Classifier#getAssociationEnds <em>Association Ends</em>}</li>
 *   <li>{@link classdiagram.Classifier#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getClassifier()
 * @model abstract="true"
 * @generated
 */
public interface Classifier extends ObjectType {
  /**
   * Returns the value of the '<em><b>Super Types</b></em>' reference list.
   * The list contents are of type {@link classdiagram.Classifier}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Types</em>' reference list.
   * @see classdiagram.ClassdiagramPackage#getClassifier_SuperTypes()
   * @model
   * @generated
   */
  EList<Classifier> getSuperTypes();

  /**
   * Returns the value of the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Type</em>' attribute.
   * @see #setDataType(boolean)
   * @see classdiagram.ClassdiagramPackage#getClassifier_DataType()
   * @model required="true"
   * @generated
   */
  boolean isDataType();

  /**
   * Sets the value of the '{@link classdiagram.Classifier#isDataType <em>Data Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Type</em>' attribute.
   * @see #isDataType()
   * @generated
   */
  void setDataType(boolean value);

  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see classdiagram.ClassdiagramPackage#getClassifier_Abstract()
   * @model required="true"
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link classdiagram.Classifier#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * The default value is <code>"package"</code>.
   * The literals are from the enumeration {@link classdiagram.VisibilityType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see classdiagram.VisibilityType
   * @see #setVisibility(VisibilityType)
   * @see classdiagram.ClassdiagramPackage#getClassifier_Visibility()
   * @model default="package"
   * @generated
   */
  VisibilityType getVisibility();

  /**
   * Sets the value of the '{@link classdiagram.Classifier#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see classdiagram.VisibilityType
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(VisibilityType value);

  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
   * The list contents are of type {@link classdiagram.Operation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operations</em>' containment reference list.
   * @see classdiagram.ClassdiagramPackage#getClassifier_Operations()
   * @model containment="true"
   * @generated
   */
  EList<Operation> getOperations();

  /**
   * Returns the value of the '<em><b>Type Parameters</b></em>' containment reference list.
   * The list contents are of type {@link classdiagram.TypeParameter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Parameters</em>' containment reference list.
   * @see classdiagram.ClassdiagramPackage#getClassifier_TypeParameters()
   * @model containment="true"
   * @generated
   */
  EList<TypeParameter> getTypeParameters();

  /**
   * Returns the value of the '<em><b>Association Ends</b></em>' containment reference list.
   * The list contents are of type {@link classdiagram.AssociationEnd}.
   * It is bidirectional and its opposite is '{@link classdiagram.AssociationEnd#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association Ends</em>' containment reference list.
   * @see classdiagram.ClassdiagramPackage#getClassifier_AssociationEnds()
   * @see classdiagram.AssociationEnd#getClassifier
   * @model opposite="classifier" containment="true"
   * @generated
   */
  EList<AssociationEnd> getAssociationEnds();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link classdiagram.Attribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see classdiagram.ClassdiagramPackage#getClassifier_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

} // Classifier
