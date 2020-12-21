/**
 */
package classdiagram.util;

import classdiagram.Association;
import classdiagram.AssociationEnd;
import classdiagram.Attribute;
import classdiagram.CDAny;
import classdiagram.CDArray;
import classdiagram.CDBoolean;
import classdiagram.CDByte;
import classdiagram.CDChar;
import classdiagram.CDCollection;
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
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import classdiagram.ImplementationClass;
import classdiagram.Layout;
import classdiagram.LayoutElement;
import classdiagram.NamedElement;
import classdiagram.Note;
import classdiagram.ObjectType;
import classdiagram.Operation;
import classdiagram.OperationType;
import classdiagram.Parameter;
import classdiagram.PrimitiveType;
import classdiagram.ReferenceType;
import classdiagram.StructuralFeature;
import classdiagram.Type;
import classdiagram.TypeParameter;
import classdiagram.TypedElement;
import classdiagram.VisibilityType;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see classdiagram.ClassdiagramPackage
 * @generated
 */
public class ClassdiagramValidator extends EObjectValidator {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final ClassdiagramValidator INSTANCE = new ClassdiagramValidator();

  /**
   * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.common.util.Diagnostic#getSource()
   * @see org.eclipse.emf.common.util.Diagnostic#getCode()
   * @generated
   */
  public static final String DIAGNOSTIC_SOURCE = "classdiagram";

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassdiagramValidator() {
    super();
  }

  /**
   * Returns the package of this validator switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EPackage getEPackage() {
    return ClassdiagramPackage.eINSTANCE;
  }

  /**
   * Calls <code>validateXXX</code> for the corresponding classifier of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
    switch (classifierID) {
      case ClassdiagramPackage.NAMED_ELEMENT:
        return validateNamedElement((NamedElement)value, diagnostics, context);
      case ClassdiagramPackage.TYPED_ELEMENT:
        return validateTypedElement((TypedElement)value, diagnostics, context);
      case ClassdiagramPackage.PARAMETER:
        return validateParameter((Parameter)value, diagnostics, context);
      case ClassdiagramPackage.ATTRIBUTE:
        return validateAttribute((Attribute)value, diagnostics, context);
      case ClassdiagramPackage.STRUCTURAL_FEATURE:
        return validateStructuralFeature((StructuralFeature)value, diagnostics, context);
      case ClassdiagramPackage.TYPE:
        return validateType((Type)value, diagnostics, context);
      case ClassdiagramPackage.OBJECT_TYPE:
        return validateObjectType((ObjectType)value, diagnostics, context);
      case ClassdiagramPackage.PRIMITIVE_TYPE:
        return validatePrimitiveType((PrimitiveType)value, diagnostics, context);
      case ClassdiagramPackage.CLASSIFIER:
        return validateClassifier((Classifier)value, diagnostics, context);
      case ClassdiagramPackage.OPERATION:
        return validateOperation((Operation)value, diagnostics, context);
      case ClassdiagramPackage.CLASS:
        return validateClass((classdiagram.Class)value, diagnostics, context);
      case ClassdiagramPackage.TYPE_PARAMETER:
        return validateTypeParameter((TypeParameter)value, diagnostics, context);
      case ClassdiagramPackage.ASSOCIATION:
        return validateAssociation((Association)value, diagnostics, context);
      case ClassdiagramPackage.ASSOCIATION_END:
        return validateAssociationEnd((AssociationEnd)value, diagnostics, context);
      case ClassdiagramPackage.CLASS_DIAGRAM:
        return validateClassDiagram((ClassDiagram)value, diagnostics, context);
      case ClassdiagramPackage.IMPLEMENTATION_CLASS:
        return validateImplementationClass((ImplementationClass)value, diagnostics, context);
      case ClassdiagramPackage.NOTE:
        return validateNote((Note)value, diagnostics, context);
      case ClassdiagramPackage.ELEMENT_MAP:
        return validateElementMap((Map.Entry<?, ?>)value, diagnostics, context);
      case ClassdiagramPackage.LAYOUT:
        return validateLayout((Layout)value, diagnostics, context);
      case ClassdiagramPackage.LAYOUT_ELEMENT:
        return validateLayoutElement((LayoutElement)value, diagnostics, context);
      case ClassdiagramPackage.CONTAINER_MAP:
        return validateContainerMap((Map.Entry<?, ?>)value, diagnostics, context);
      case ClassdiagramPackage.CD_BOOLEAN:
        return validateCDBoolean((CDBoolean)value, diagnostics, context);
      case ClassdiagramPackage.CD_DOUBLE:
        return validateCDDouble((CDDouble)value, diagnostics, context);
      case ClassdiagramPackage.CD_INT:
        return validateCDInt((CDInt)value, diagnostics, context);
      case ClassdiagramPackage.CD_LONG:
        return validateCDLong((CDLong)value, diagnostics, context);
      case ClassdiagramPackage.CD_STRING:
        return validateCDString((CDString)value, diagnostics, context);
      case ClassdiagramPackage.CD_BYTE:
        return validateCDByte((CDByte)value, diagnostics, context);
      case ClassdiagramPackage.CD_FLOAT:
        return validateCDFloat((CDFloat)value, diagnostics, context);
      case ClassdiagramPackage.CD_ARRAY:
        return validateCDArray((CDArray)value, diagnostics, context);
      case ClassdiagramPackage.CD_CHAR:
        return validateCDChar((CDChar)value, diagnostics, context);
      case ClassdiagramPackage.CD_ENUM:
        return validateCDEnum((CDEnum)value, diagnostics, context);
      case ClassdiagramPackage.CD_ENUM_LITERAL:
        return validateCDEnumLiteral((CDEnumLiteral)value, diagnostics, context);
      case ClassdiagramPackage.CD_ANY:
        return validateCDAny((CDAny)value, diagnostics, context);
      case ClassdiagramPackage.CD_VOID:
        return validateCDVoid((CDVoid)value, diagnostics, context);
      case ClassdiagramPackage.CD_COLLECTION:
        return validateCDCollection((CDCollection)value, diagnostics, context);
      case ClassdiagramPackage.CD_SET:
        return validateCDSet((CDSet)value, diagnostics, context);
      case ClassdiagramPackage.CD_SEQUENCE:
        return validateCDSequence((CDSequence)value, diagnostics, context);
      case ClassdiagramPackage.VISIBILITY_TYPE:
        return validateVisibilityType((VisibilityType)value, diagnostics, context);
      case ClassdiagramPackage.OPERATION_TYPE:
        return validateOperationType((OperationType)value, diagnostics, context);
      case ClassdiagramPackage.REFERENCE_TYPE:
        return validateReferenceType((ReferenceType)value, diagnostics, context);
      default:
        return true;
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(namedElement, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(namedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(namedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(namedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(namedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(namedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(namedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(namedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(namedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(namedElement, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the validName constraint of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String NAMED_ELEMENT__VALID_NAME__EEXPRESSION = "Tuple {\n" +
    "\tmessage : String = 'Name of elements may not be empty',\n" +
    "\tstatus : Boolean = if self.oclIsTypeOf(AssociationEnd) and self.oclAsType(AssociationEnd).navigable = false then true else self.name <> '' endif\n" +
    "}.status";

  /**
   * Validates the validName constraint of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateNamedElement_validName(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (ClassdiagramPackage.Literals.NAMED_ELEMENT,
         namedElement,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "validName",
         NAMED_ELEMENT__VALID_NAME__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateTypedElement(TypedElement typedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(typedElement, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(typedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(typedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(typedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(typedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typedElement, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(typedElement, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(parameter, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(parameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(parameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(parameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(parameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(parameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(parameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(parameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(parameter, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(parameter, diagnostics, context);
    if (result || diagnostics != null) result &= validateParameter_notVoid(parameter, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the notVoid constraint of '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String PARAMETER__NOT_VOID__EEXPRESSION = "Tuple {\n" +
    "\tmessage : String = 'The type of the parameter may not be void',\n" +
    "\tstatus : Boolean = not self.type.oclIsTypeOf(CDVoid)\n" +
    "}.status";

  /**
   * Validates the notVoid constraint of '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateParameter_notVoid(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (ClassdiagramPackage.Literals.PARAMETER,
         parameter,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "notVoid",
         PARAMETER__NOT_VOID__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAttribute(Attribute attribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(attribute, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(attribute, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(attribute, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(attribute, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(attribute, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(attribute, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(attribute, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(attribute, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(attribute, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(attribute, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateStructuralFeature(StructuralFeature structuralFeature, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(structuralFeature, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(structuralFeature, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(structuralFeature, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(structuralFeature, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(structuralFeature, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(structuralFeature, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(structuralFeature, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(structuralFeature, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(structuralFeature, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(structuralFeature, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateType(Type type, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(type, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(type, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(type, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(type, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(type, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(type, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(type, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(type, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(type, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(type, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateObjectType(ObjectType objectType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(objectType, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(objectType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(objectType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(objectType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(objectType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(objectType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(objectType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(objectType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(objectType, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(objectType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validatePrimitiveType(PrimitiveType primitiveType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(primitiveType, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(primitiveType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(primitiveType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(primitiveType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(primitiveType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(primitiveType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(primitiveType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(primitiveType, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(primitiveType, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(primitiveType, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateClassifier(Classifier classifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(classifier, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(classifier, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classifier, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classifier, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classifier, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(classifier, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(classifier, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(classifier, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classifier, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(classifier, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateOperation(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(operation, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(operation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(operation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(operation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(operation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(operation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(operation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(operation, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(operation, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(operation, diagnostics, context);
    if (result || diagnostics != null) result &= validateOperation_correctVisibility(operation, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the correctVisibility constraint of '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String OPERATION__CORRECT_VISIBILITY__EEXPRESSION = "Tuple {\n" +
    "\tmessage : String = 'COREVisibility and Visibility attributes are not in sync',\n" +
    "\tstatus : Boolean = if visibility = VisibilityType::public then visibility = VisibilityType::public else visibility <> VisibilityType::public endif\n" +
    "}.status";

  /**
   * Validates the correctVisibility constraint of '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateOperation_correctVisibility(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (ClassdiagramPackage.Literals.OPERATION,
         operation,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "correctVisibility",
         OPERATION__CORRECT_VISIBILITY__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateClass(classdiagram.Class class_, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(class_, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(class_, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(class_, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(class_, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(class_, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(class_, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(class_, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(class_, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(class_, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(class_, diagnostics, context);
    if (result || diagnostics != null) result &= validateClass_notSelfSuperType(class_, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the notSelfSuperType constraint of '<em>Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String CLASS__NOT_SELF_SUPER_TYPE__EEXPRESSION = "Tuple {\n" +
    "\tmessage : String = 'A class may not be it\\'s own supertype',\n" +
    "\tstatus : Boolean = not self.superTypes->includes(self)\n" +
    "}.status";

  /**
   * Validates the notSelfSuperType constraint of '<em>Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateClass_notSelfSuperType(classdiagram.Class class_, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (ClassdiagramPackage.Literals.CLASS,
         class_,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "notSelfSuperType",
         CLASS__NOT_SELF_SUPER_TYPE__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateTypeParameter(TypeParameter typeParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(typeParameter, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(typeParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typeParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typeParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typeParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(typeParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(typeParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(typeParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typeParameter, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(typeParameter, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAssociation(Association association, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(association, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(association, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(association, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(association, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(association, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(association, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(association, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(association, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(association, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(association, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAssociationEnd(AssociationEnd associationEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(associationEnd, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(associationEnd, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(associationEnd, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(associationEnd, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(associationEnd, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(associationEnd, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(associationEnd, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(associationEnd, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(associationEnd, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(associationEnd, diagnostics, context);
    if (result || diagnostics != null) result &= validateAssociationEnd_uniqueName(associationEnd, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the uniqueName constraint of '<em>Association End</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String ASSOCIATION_END__UNIQUE_NAME__EEXPRESSION = "Tuple {\n" +
    "\tmessage : String = 'AssociationEnds of a class must be unique',\n" +
    "\tstatus : Boolean = self.classifier.associationEnds->select(associationEnd : AssociationEnd | associationEnd.name <> null and associationEnd.name <> '')->isUnique(name)\n" +
    "}.status";

  /**
   * Validates the uniqueName constraint of '<em>Association End</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAssociationEnd_uniqueName(AssociationEnd associationEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (ClassdiagramPackage.Literals.ASSOCIATION_END,
         associationEnd,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "uniqueName",
         ASSOCIATION_END__UNIQUE_NAME__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateClassDiagram(ClassDiagram classDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(classDiagram, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(classDiagram, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(classDiagram, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(classDiagram, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(classDiagram, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(classDiagram, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(classDiagram, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(classDiagram, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(classDiagram, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(classDiagram, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateImplementationClass(ImplementationClass implementationClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(implementationClass, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(implementationClass, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(implementationClass, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(implementationClass, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(implementationClass, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(implementationClass, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(implementationClass, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(implementationClass, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(implementationClass, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(implementationClass, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateNote(Note note, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(note, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateElementMap(Map.Entry<?, ?> elementMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint((EObject)elementMap, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateLayout(Layout layout, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(layout, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateLayoutElement(LayoutElement layoutElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(layoutElement, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContainerMap(Map.Entry<?, ?> containerMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint((EObject)containerMap, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDBoolean(CDBoolean cdBoolean, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdBoolean, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdBoolean, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdBoolean, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdBoolean, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdBoolean, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdBoolean, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdBoolean, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdBoolean, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdBoolean, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdBoolean, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDDouble(CDDouble cdDouble, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdDouble, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdDouble, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdDouble, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdDouble, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdDouble, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdDouble, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdDouble, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdDouble, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdDouble, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdDouble, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDInt(CDInt cdInt, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdInt, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdInt, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdInt, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdInt, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdInt, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdInt, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdInt, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdInt, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdInt, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdInt, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDLong(CDLong cdLong, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdLong, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdLong, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdLong, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdLong, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdLong, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdLong, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdLong, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdLong, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdLong, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdLong, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDString(CDString cdString, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdString, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdString, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdString, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdString, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdString, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdString, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdString, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdString, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdString, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdString, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDByte(CDByte cdByte, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdByte, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdByte, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdByte, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdByte, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdByte, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdByte, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdByte, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdByte, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdByte, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdByte, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDFloat(CDFloat cdFloat, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdFloat, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdFloat, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdFloat, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdFloat, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdFloat, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdFloat, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdFloat, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdFloat, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdFloat, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdFloat, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDArray(CDArray cdArray, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdArray, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdArray, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdArray, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdArray, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdArray, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdArray, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdArray, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdArray, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdArray, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdArray, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDChar(CDChar cdChar, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdChar, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdChar, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdChar, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdChar, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdChar, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdChar, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdChar, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdChar, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdChar, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdChar, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDEnum(CDEnum cdEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdEnum, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdEnum, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdEnum, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDEnumLiteral(CDEnumLiteral cdEnumLiteral, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdEnumLiteral, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdEnumLiteral, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdEnumLiteral, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdEnumLiteral, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdEnumLiteral, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdEnumLiteral, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdEnumLiteral, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdEnumLiteral, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdEnumLiteral, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdEnumLiteral, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDAny(CDAny cdAny, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdAny, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdAny, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdAny, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdAny, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdAny, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdAny, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdAny, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdAny, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdAny, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdAny, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDVoid(CDVoid cdVoid, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdVoid, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdVoid, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdVoid, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdVoid, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdVoid, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdVoid, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdVoid, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdVoid, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdVoid, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdVoid, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDCollection(CDCollection cdCollection, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdCollection, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdCollection, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdCollection, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdCollection, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdCollection, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdCollection, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdCollection, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdCollection, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdCollection, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdCollection, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDSet(CDSet cdSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdSet, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdSet, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdSet, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdSet, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdSet, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdSet, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdSet, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdSet, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdSet, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdSet, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCDSequence(CDSequence cdSequence, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(cdSequence, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(cdSequence, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cdSequence, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cdSequence, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cdSequence, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(cdSequence, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(cdSequence, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(cdSequence, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cdSequence, diagnostics, context);
    if (result || diagnostics != null) result &= validateNamedElement_validName(cdSequence, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateVisibilityType(VisibilityType visibilityType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateOperationType(OperationType operationType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateReferenceType(ReferenceType referenceType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    // TODO
    // Specialize this to return a resource locator for messages specific to this validator.
    // Ensure that you remove @generated or mark it @generated NOT
    return super.getResourceLocator();
  }

} //ClassdiagramValidator
