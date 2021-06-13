/**
 */
package classdiagram.impl;

import classdiagram.Association;
import classdiagram.AssociationEnd;
import classdiagram.Attribute;
import classdiagram.CDAny;
import classdiagram.CDArray;
import classdiagram.CDBoolean;
import classdiagram.CDByte;
import classdiagram.CDChar;
import classdiagram.CDDouble;
import classdiagram.CDEnum;
import classdiagram.CDEnumLiteral;
import classdiagram.CDFloat;
import classdiagram.CDInt;
import classdiagram.CDLong;
import classdiagram.CDSequence;
import classdiagram.CDSet;
import classdiagram.CDString;
import classdiagram.CDVoid;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramFactory;
import classdiagram.ClassdiagramPackage;
import classdiagram.ImplementationClass;
import classdiagram.Layout;
import classdiagram.LayoutElement;
import classdiagram.Note;
import classdiagram.Operation;
import classdiagram.OperationType;
import classdiagram.Parameter;
import classdiagram.ReferenceType;
import classdiagram.TypeParameter;
import classdiagram.VisibilityType;

import java.util.Map;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassdiagramFactoryImpl extends EFactoryImpl implements ClassdiagramFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ClassdiagramFactory init() {
    try {
      ClassdiagramFactory theClassdiagramFactory = (ClassdiagramFactory)EPackage.Registry.INSTANCE.getEFactory(ClassdiagramPackage.eNS_URI);
      if (theClassdiagramFactory != null) {
        return theClassdiagramFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ClassdiagramFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassdiagramFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case ClassdiagramPackage.PARAMETER: return createParameter();
      case ClassdiagramPackage.ATTRIBUTE: return createAttribute();
      case ClassdiagramPackage.OPERATION: return createOperation();
      case ClassdiagramPackage.CLASS: return createClass();
      case ClassdiagramPackage.TYPE_PARAMETER: return createTypeParameter();
      case ClassdiagramPackage.ASSOCIATION: return createAssociation();
      case ClassdiagramPackage.ASSOCIATION_END: return createAssociationEnd();
      case ClassdiagramPackage.CLASS_DIAGRAM: return createClassDiagram();
      case ClassdiagramPackage.IMPLEMENTATION_CLASS: return createImplementationClass();
      case ClassdiagramPackage.NOTE: return createNote();
      case ClassdiagramPackage.ELEMENT_MAP: return (EObject)createElementMap();
      case ClassdiagramPackage.LAYOUT: return createLayout();
      case ClassdiagramPackage.LAYOUT_ELEMENT: return createLayoutElement();
      case ClassdiagramPackage.CONTAINER_MAP: return (EObject)createContainerMap();
      case ClassdiagramPackage.CD_BOOLEAN: return createCDBoolean();
      case ClassdiagramPackage.CD_DOUBLE: return createCDDouble();
      case ClassdiagramPackage.CD_INT: return createCDInt();
      case ClassdiagramPackage.CD_LONG: return createCDLong();
      case ClassdiagramPackage.CD_STRING: return createCDString();
      case ClassdiagramPackage.CD_BYTE: return createCDByte();
      case ClassdiagramPackage.CD_FLOAT: return createCDFloat();
      case ClassdiagramPackage.CD_ARRAY: return createCDArray();
      case ClassdiagramPackage.CD_CHAR: return createCDChar();
      case ClassdiagramPackage.CD_ENUM: return createCDEnum();
      case ClassdiagramPackage.CD_ENUM_LITERAL: return createCDEnumLiteral();
      case ClassdiagramPackage.CD_ANY: return createCDAny();
      case ClassdiagramPackage.CD_VOID: return createCDVoid();
      case ClassdiagramPackage.CD_SET: return createCDSet();
      case ClassdiagramPackage.CD_SEQUENCE: return createCDSequence();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
      case ClassdiagramPackage.VISIBILITY_TYPE:
        return createVisibilityTypeFromString(eDataType, initialValue);
      case ClassdiagramPackage.OPERATION_TYPE:
        return createOperationTypeFromString(eDataType, initialValue);
      case ClassdiagramPackage.REFERENCE_TYPE:
        return createReferenceTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
      case ClassdiagramPackage.VISIBILITY_TYPE:
        return convertVisibilityTypeToString(eDataType, instanceValue);
      case ClassdiagramPackage.OPERATION_TYPE:
        return convertOperationTypeToString(eDataType, instanceValue);
      case ClassdiagramPackage.REFERENCE_TYPE:
        return convertReferenceTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Parameter createParameter() {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Attribute createAttribute() {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Operation createOperation() {
    OperationImpl operation = new OperationImpl();
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public classdiagram.Class createClass() {
    ClassImpl class_ = new ClassImpl();
    return class_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TypeParameter createTypeParameter() {
    TypeParameterImpl typeParameter = new TypeParameterImpl();
    return typeParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Association createAssociation() {
    AssociationImpl association = new AssociationImpl();
    return association;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AssociationEnd createAssociationEnd() {
    AssociationEndImpl associationEnd = new AssociationEndImpl();
    return associationEnd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClassDiagram createClassDiagram() {
    ClassDiagramImpl classDiagram = new ClassDiagramImpl();
    return classDiagram;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImplementationClass createImplementationClass() {
    ImplementationClassImpl implementationClass = new ImplementationClassImpl();
    return implementationClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Note createNote() {
    NoteImpl note = new NoteImpl();
    return note;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Map.Entry<EObject, LayoutElement> createElementMap() {
    ElementMapImpl elementMap = new ElementMapImpl();
    return elementMap;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Layout createLayout() {
    LayoutImpl layout = new LayoutImpl();
    return layout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LayoutElement createLayoutElement() {
    LayoutElementImpl layoutElement = new LayoutElementImpl();
    return layoutElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Map.Entry<EObject, EMap<EObject, LayoutElement>> createContainerMap() {
    ContainerMapImpl containerMap = new ContainerMapImpl();
    return containerMap;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDBoolean createCDBoolean() {
    CDBooleanImpl cdBoolean = new CDBooleanImpl();
    return cdBoolean;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDDouble createCDDouble() {
    CDDoubleImpl cdDouble = new CDDoubleImpl();
    return cdDouble;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDInt createCDInt() {
    CDIntImpl cdInt = new CDIntImpl();
    return cdInt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDLong createCDLong() {
    CDLongImpl cdLong = new CDLongImpl();
    return cdLong;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDString createCDString() {
    CDStringImpl cdString = new CDStringImpl();
    return cdString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDByte createCDByte() {
    CDByteImpl cdByte = new CDByteImpl();
    return cdByte;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDFloat createCDFloat() {
    CDFloatImpl cdFloat = new CDFloatImpl();
    return cdFloat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDArray createCDArray() {
    CDArrayImpl cdArray = new CDArrayImpl();
    return cdArray;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDChar createCDChar() {
    CDCharImpl cdChar = new CDCharImpl();
    return cdChar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDEnum createCDEnum() {
    CDEnumImpl cdEnum = new CDEnumImpl();
    return cdEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDEnumLiteral createCDEnumLiteral() {
    CDEnumLiteralImpl cdEnumLiteral = new CDEnumLiteralImpl();
    return cdEnumLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDAny createCDAny() {
    CDAnyImpl cdAny = new CDAnyImpl();
    return cdAny;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDVoid createCDVoid() {
    CDVoidImpl cdVoid = new CDVoidImpl();
    return cdVoid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDSet createCDSet() {
    CDSetImpl cdSet = new CDSetImpl();
    return cdSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CDSequence createCDSequence() {
    CDSequenceImpl cdSequence = new CDSequenceImpl();
    return cdSequence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VisibilityType createVisibilityTypeFromString(EDataType eDataType, String initialValue) {
    VisibilityType result = VisibilityType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertVisibilityTypeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationType createOperationTypeFromString(EDataType eDataType, String initialValue) {
    OperationType result = OperationType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOperationTypeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceType createReferenceTypeFromString(EDataType eDataType, String initialValue) {
    ReferenceType result = ReferenceType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertReferenceTypeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClassdiagramPackage getClassdiagramPackage() {
    return (ClassdiagramPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ClassdiagramPackage getPackage() {
    return ClassdiagramPackage.eINSTANCE;
  }

} //ClassdiagramFactoryImpl
