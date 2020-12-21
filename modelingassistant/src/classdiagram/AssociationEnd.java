/**
 */
package classdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.AssociationEnd#isNavigable <em>Navigable</em>}</li>
 *   <li>{@link classdiagram.AssociationEnd#getAssoc <em>Assoc</em>}</li>
 *   <li>{@link classdiagram.AssociationEnd#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link classdiagram.AssociationEnd#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link classdiagram.AssociationEnd#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link classdiagram.AssociationEnd#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link classdiagram.AssociationEnd#getReferenceType <em>Reference Type</em>}</li>
 *   <li>{@link classdiagram.AssociationEnd#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link classdiagram.AssociationEnd#isUnique <em>Unique</em>}</li>
 * </ul>
 *
 * @see classdiagram.ClassdiagramPackage#getAssociationEnd()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='uniqueName'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot uniqueName='Tuple {\n\tmessage : String = \'AssociationEnds of a class must be unique\',\n\tstatus : Boolean = self.classifier.associationEnds-&gt;select(associationEnd : AssociationEnd | associationEnd.name &lt;&gt; null and associationEnd.name &lt;&gt; \'\')-&gt;isUnique(name)\n}.status'"
 * @generated
 */
public interface AssociationEnd extends StructuralFeature {
  /**
   * Returns the value of the '<em><b>Navigable</b></em>' attribute.
   * The default value is <code>"true"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Navigable</em>' attribute.
   * @see #setNavigable(boolean)
   * @see classdiagram.ClassdiagramPackage#getAssociationEnd_Navigable()
   * @model default="true" required="true"
   * @generated
   */
  boolean isNavigable();

  /**
   * Sets the value of the '{@link classdiagram.AssociationEnd#isNavigable <em>Navigable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Navigable</em>' attribute.
   * @see #isNavigable()
   * @generated
   */
  void setNavigable(boolean value);

  /**
   * Returns the value of the '<em><b>Assoc</b></em>' reference.
   * It is bidirectional and its opposite is '{@link classdiagram.Association#getEnds <em>Ends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assoc</em>' reference.
   * @see #setAssoc(Association)
   * @see classdiagram.ClassdiagramPackage#getAssociationEnd_Assoc()
   * @see classdiagram.Association#getEnds
   * @model opposite="ends" required="true"
   * @generated
   */
  Association getAssoc();

  /**
   * Sets the value of the '{@link classdiagram.AssociationEnd#getAssoc <em>Assoc</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assoc</em>' reference.
   * @see #getAssoc()
   * @generated
   */
  void setAssoc(Association value);

  /**
   * Returns the value of the '<em><b>Classifier</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link classdiagram.Classifier#getAssociationEnds <em>Association Ends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classifier</em>' container reference.
   * @see #setClassifier(Classifier)
   * @see classdiagram.ClassdiagramPackage#getAssociationEnd_Classifier()
   * @see classdiagram.Classifier#getAssociationEnds
   * @model opposite="associationEnds" required="true" transient="false"
   * @generated
   */
  Classifier getClassifier();

  /**
   * Sets the value of the '{@link classdiagram.AssociationEnd#getClassifier <em>Classifier</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Classifier</em>' container reference.
   * @see #getClassifier()
   * @generated
   */
  void setClassifier(Classifier value);

  /**
   * Returns the value of the '<em><b>Qualifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualifier</em>' reference.
   * @see #setQualifier(Type)
   * @see classdiagram.ClassdiagramPackage#getAssociationEnd_Qualifier()
   * @model
   * @generated
   */
  Type getQualifier();

  /**
   * Sets the value of the '{@link classdiagram.AssociationEnd#getQualifier <em>Qualifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualifier</em>' reference.
   * @see #getQualifier()
   * @generated
   */
  void setQualifier(Type value);

  /**
   * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower Bound</em>' attribute.
   * @see #setLowerBound(int)
   * @see classdiagram.ClassdiagramPackage#getAssociationEnd_LowerBound()
   * @model default="0" required="true"
   * @generated
   */
  int getLowerBound();

  /**
   * Sets the value of the '{@link classdiagram.AssociationEnd#getLowerBound <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower Bound</em>' attribute.
   * @see #getLowerBound()
   * @generated
   */
  void setLowerBound(int value);

  /**
   * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
   * The default value is <code>"1"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper Bound</em>' attribute.
   * @see #setUpperBound(int)
   * @see classdiagram.ClassdiagramPackage#getAssociationEnd_UpperBound()
   * @model default="1" required="true"
   * @generated
   */
  int getUpperBound();

  /**
   * Sets the value of the '{@link classdiagram.AssociationEnd#getUpperBound <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper Bound</em>' attribute.
   * @see #getUpperBound()
   * @generated
   */
  void setUpperBound(int value);

  /**
   * Returns the value of the '<em><b>Reference Type</b></em>' attribute.
   * The default value is <code>"Regular"</code>.
   * The literals are from the enumeration {@link classdiagram.ReferenceType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference Type</em>' attribute.
   * @see classdiagram.ReferenceType
   * @see #setReferenceType(ReferenceType)
   * @see classdiagram.ClassdiagramPackage#getAssociationEnd_ReferenceType()
   * @model default="Regular"
   * @generated
   */
  ReferenceType getReferenceType();

  /**
   * Sets the value of the '{@link classdiagram.AssociationEnd#getReferenceType <em>Reference Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference Type</em>' attribute.
   * @see classdiagram.ReferenceType
   * @see #getReferenceType()
   * @generated
   */
  void setReferenceType(ReferenceType value);

  /**
   * Returns the value of the '<em><b>Ordered</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ordered</em>' attribute.
   * @see #setOrdered(boolean)
   * @see classdiagram.ClassdiagramPackage#getAssociationEnd_Ordered()
   * @model default="false" required="true"
   * @generated
   */
  boolean isOrdered();

  /**
   * Sets the value of the '{@link classdiagram.AssociationEnd#isOrdered <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ordered</em>' attribute.
   * @see #isOrdered()
   * @generated
   */
  void setOrdered(boolean value);

  /**
   * Returns the value of the '<em><b>Unique</b></em>' attribute.
   * The default value is <code>"true"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unique</em>' attribute.
   * @see #setUnique(boolean)
   * @see classdiagram.ClassdiagramPackage#getAssociationEnd_Unique()
   * @model default="true" required="true"
   * @generated
   */
  boolean isUnique();

  /**
   * Sets the value of the '{@link classdiagram.AssociationEnd#isUnique <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unique</em>' attribute.
   * @see #isUnique()
   * @generated
   */
  void setUnique(boolean value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='if (assoc.ends-&gt;size() &lt;= 2) then self.assoc.ends-&gt;select(end : AssociationEnd | end &lt;&gt; self)-&gt;at(1) else null endif'"
   * @generated
   */
  AssociationEnd getOppositeEnd();

} // AssociationEnd
