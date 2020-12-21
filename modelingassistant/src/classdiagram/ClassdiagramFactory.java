/**
 */
package classdiagram;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see classdiagram.ClassdiagramPackage
 * @generated
 */
public interface ClassdiagramFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ClassdiagramFactory eINSTANCE = classdiagram.impl.ClassdiagramFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter</em>'.
   * @generated
   */
  Parameter createParameter();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation</em>'.
   * @generated
   */
  Operation createOperation();

  /**
   * Returns a new object of class '<em>Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class</em>'.
   * @generated
   */
  Class createClass();

  /**
   * Returns a new object of class '<em>Type Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Parameter</em>'.
   * @generated
   */
  TypeParameter createTypeParameter();

  /**
   * Returns a new object of class '<em>Association</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association</em>'.
   * @generated
   */
  Association createAssociation();

  /**
   * Returns a new object of class '<em>Association End</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association End</em>'.
   * @generated
   */
  AssociationEnd createAssociationEnd();

  /**
   * Returns a new object of class '<em>Class Diagram</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Diagram</em>'.
   * @generated
   */
  ClassDiagram createClassDiagram();

  /**
   * Returns a new object of class '<em>Implementation Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implementation Class</em>'.
   * @generated
   */
  ImplementationClass createImplementationClass();

  /**
   * Returns a new object of class '<em>Note</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Note</em>'.
   * @generated
   */
  Note createNote();

  /**
   * Returns a new object of class '<em>Layout</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Layout</em>'.
   * @generated
   */
  Layout createLayout();

  /**
   * Returns a new object of class '<em>Layout Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Layout Element</em>'.
   * @generated
   */
  LayoutElement createLayoutElement();

  /**
   * Returns a new object of class '<em>CD Boolean</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Boolean</em>'.
   * @generated
   */
  CDBoolean createCDBoolean();

  /**
   * Returns a new object of class '<em>CD Double</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Double</em>'.
   * @generated
   */
  CDDouble createCDDouble();

  /**
   * Returns a new object of class '<em>CD Int</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Int</em>'.
   * @generated
   */
  CDInt createCDInt();

  /**
   * Returns a new object of class '<em>CD Long</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Long</em>'.
   * @generated
   */
  CDLong createCDLong();

  /**
   * Returns a new object of class '<em>CD String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD String</em>'.
   * @generated
   */
  CDString createCDString();

  /**
   * Returns a new object of class '<em>CD Byte</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Byte</em>'.
   * @generated
   */
  CDByte createCDByte();

  /**
   * Returns a new object of class '<em>CD Float</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Float</em>'.
   * @generated
   */
  CDFloat createCDFloat();

  /**
   * Returns a new object of class '<em>CD Array</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Array</em>'.
   * @generated
   */
  CDArray createCDArray();

  /**
   * Returns a new object of class '<em>CD Char</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Char</em>'.
   * @generated
   */
  CDChar createCDChar();

  /**
   * Returns a new object of class '<em>CD Enum</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Enum</em>'.
   * @generated
   */
  CDEnum createCDEnum();

  /**
   * Returns a new object of class '<em>CD Enum Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Enum Literal</em>'.
   * @generated
   */
  CDEnumLiteral createCDEnumLiteral();

  /**
   * Returns a new object of class '<em>CD Any</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Any</em>'.
   * @generated
   */
  CDAny createCDAny();

  /**
   * Returns a new object of class '<em>CD Void</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Void</em>'.
   * @generated
   */
  CDVoid createCDVoid();

  /**
   * Returns a new object of class '<em>CD Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Set</em>'.
   * @generated
   */
  CDSet createCDSet();

  /**
   * Returns a new object of class '<em>CD Sequence</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CD Sequence</em>'.
   * @generated
   */
  CDSequence createCDSequence();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ClassdiagramPackage getClassdiagramPackage();

} //ClassdiagramFactory
