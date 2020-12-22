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
import classdiagram.Parameter;
import classdiagram.PrimitiveType;
import classdiagram.StructuralFeature;
import classdiagram.Type;
import classdiagram.TypeParameter;
import classdiagram.TypedElement;

import java.util.Map;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see classdiagram.ClassdiagramPackage
 * @generated
 */
public class ClassdiagramSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ClassdiagramPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassdiagramSwitch() {
    if (modelPackage == null) {
      modelPackage = ClassdiagramPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case ClassdiagramPackage.NAMED_ELEMENT: {
        NamedElement namedElement = (NamedElement)theEObject;
        T result = caseNamedElement(namedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.TYPED_ELEMENT: {
        TypedElement typedElement = (TypedElement)theEObject;
        T result = caseTypedElement(typedElement);
        if (result == null) result = caseNamedElement(typedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.PARAMETER: {
        Parameter parameter = (Parameter)theEObject;
        T result = caseParameter(parameter);
        if (result == null) result = caseTypedElement(parameter);
        if (result == null) result = caseNamedElement(parameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.ATTRIBUTE: {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = caseStructuralFeature(attribute);
        if (result == null) result = caseTypedElement(attribute);
        if (result == null) result = caseNamedElement(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.STRUCTURAL_FEATURE: {
        StructuralFeature structuralFeature = (StructuralFeature)theEObject;
        T result = caseStructuralFeature(structuralFeature);
        if (result == null) result = caseTypedElement(structuralFeature);
        if (result == null) result = caseNamedElement(structuralFeature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.TYPE: {
        Type type = (Type)theEObject;
        T result = caseType(type);
        if (result == null) result = caseNamedElement(type);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.OBJECT_TYPE: {
        ObjectType objectType = (ObjectType)theEObject;
        T result = caseObjectType(objectType);
        if (result == null) result = caseType(objectType);
        if (result == null) result = caseNamedElement(objectType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.PRIMITIVE_TYPE: {
        PrimitiveType primitiveType = (PrimitiveType)theEObject;
        T result = casePrimitiveType(primitiveType);
        if (result == null) result = caseImplementationClass(primitiveType);
        if (result == null) result = caseClassifier(primitiveType);
        if (result == null) result = caseObjectType(primitiveType);
        if (result == null) result = caseType(primitiveType);
        if (result == null) result = caseNamedElement(primitiveType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CLASSIFIER: {
        Classifier classifier = (Classifier)theEObject;
        T result = caseClassifier(classifier);
        if (result == null) result = caseObjectType(classifier);
        if (result == null) result = caseType(classifier);
        if (result == null) result = caseNamedElement(classifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.OPERATION: {
        Operation operation = (Operation)theEObject;
        T result = caseOperation(operation);
        if (result == null) result = caseNamedElement(operation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CLASS: {
        classdiagram.Class class_ = (classdiagram.Class)theEObject;
        T result = caseClass(class_);
        if (result == null) result = caseClassifier(class_);
        if (result == null) result = caseObjectType(class_);
        if (result == null) result = caseType(class_);
        if (result == null) result = caseNamedElement(class_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.TYPE_PARAMETER: {
        TypeParameter typeParameter = (TypeParameter)theEObject;
        T result = caseTypeParameter(typeParameter);
        if (result == null) result = caseType(typeParameter);
        if (result == null) result = caseNamedElement(typeParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.ASSOCIATION: {
        Association association = (Association)theEObject;
        T result = caseAssociation(association);
        if (result == null) result = caseNamedElement(association);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.ASSOCIATION_END: {
        AssociationEnd associationEnd = (AssociationEnd)theEObject;
        T result = caseAssociationEnd(associationEnd);
        if (result == null) result = caseStructuralFeature(associationEnd);
        if (result == null) result = caseTypedElement(associationEnd);
        if (result == null) result = caseNamedElement(associationEnd);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CLASS_DIAGRAM: {
        ClassDiagram classDiagram = (ClassDiagram)theEObject;
        T result = caseClassDiagram(classDiagram);
        if (result == null) result = caseNamedElement(classDiagram);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.IMPLEMENTATION_CLASS: {
        ImplementationClass implementationClass = (ImplementationClass)theEObject;
        T result = caseImplementationClass(implementationClass);
        if (result == null) result = caseClassifier(implementationClass);
        if (result == null) result = caseObjectType(implementationClass);
        if (result == null) result = caseType(implementationClass);
        if (result == null) result = caseNamedElement(implementationClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.NOTE: {
        Note note = (Note)theEObject;
        T result = caseNote(note);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.ELEMENT_MAP: {
        @SuppressWarnings("unchecked") Map.Entry<EObject, LayoutElement> elementMap = (Map.Entry<EObject, LayoutElement>)theEObject;
        T result = caseElementMap(elementMap);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.LAYOUT: {
        Layout layout = (Layout)theEObject;
        T result = caseLayout(layout);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.LAYOUT_ELEMENT: {
        LayoutElement layoutElement = (LayoutElement)theEObject;
        T result = caseLayoutElement(layoutElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CONTAINER_MAP: {
        @SuppressWarnings("unchecked") Map.Entry<EObject, EMap<EObject, LayoutElement>> containerMap = (Map.Entry<EObject, EMap<EObject, LayoutElement>>)theEObject;
        T result = caseContainerMap(containerMap);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_BOOLEAN: {
        CDBoolean cdBoolean = (CDBoolean)theEObject;
        T result = caseCDBoolean(cdBoolean);
        if (result == null) result = casePrimitiveType(cdBoolean);
        if (result == null) result = caseImplementationClass(cdBoolean);
        if (result == null) result = caseClassifier(cdBoolean);
        if (result == null) result = caseObjectType(cdBoolean);
        if (result == null) result = caseType(cdBoolean);
        if (result == null) result = caseNamedElement(cdBoolean);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_DOUBLE: {
        CDDouble cdDouble = (CDDouble)theEObject;
        T result = caseCDDouble(cdDouble);
        if (result == null) result = casePrimitiveType(cdDouble);
        if (result == null) result = caseImplementationClass(cdDouble);
        if (result == null) result = caseClassifier(cdDouble);
        if (result == null) result = caseObjectType(cdDouble);
        if (result == null) result = caseType(cdDouble);
        if (result == null) result = caseNamedElement(cdDouble);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_INT: {
        CDInt cdInt = (CDInt)theEObject;
        T result = caseCDInt(cdInt);
        if (result == null) result = casePrimitiveType(cdInt);
        if (result == null) result = caseImplementationClass(cdInt);
        if (result == null) result = caseClassifier(cdInt);
        if (result == null) result = caseObjectType(cdInt);
        if (result == null) result = caseType(cdInt);
        if (result == null) result = caseNamedElement(cdInt);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_LONG: {
        CDLong cdLong = (CDLong)theEObject;
        T result = caseCDLong(cdLong);
        if (result == null) result = casePrimitiveType(cdLong);
        if (result == null) result = caseImplementationClass(cdLong);
        if (result == null) result = caseClassifier(cdLong);
        if (result == null) result = caseObjectType(cdLong);
        if (result == null) result = caseType(cdLong);
        if (result == null) result = caseNamedElement(cdLong);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_STRING: {
        CDString cdString = (CDString)theEObject;
        T result = caseCDString(cdString);
        if (result == null) result = casePrimitiveType(cdString);
        if (result == null) result = caseImplementationClass(cdString);
        if (result == null) result = caseClassifier(cdString);
        if (result == null) result = caseObjectType(cdString);
        if (result == null) result = caseType(cdString);
        if (result == null) result = caseNamedElement(cdString);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_BYTE: {
        CDByte cdByte = (CDByte)theEObject;
        T result = caseCDByte(cdByte);
        if (result == null) result = casePrimitiveType(cdByte);
        if (result == null) result = caseImplementationClass(cdByte);
        if (result == null) result = caseClassifier(cdByte);
        if (result == null) result = caseObjectType(cdByte);
        if (result == null) result = caseType(cdByte);
        if (result == null) result = caseNamedElement(cdByte);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_FLOAT: {
        CDFloat cdFloat = (CDFloat)theEObject;
        T result = caseCDFloat(cdFloat);
        if (result == null) result = casePrimitiveType(cdFloat);
        if (result == null) result = caseImplementationClass(cdFloat);
        if (result == null) result = caseClassifier(cdFloat);
        if (result == null) result = caseObjectType(cdFloat);
        if (result == null) result = caseType(cdFloat);
        if (result == null) result = caseNamedElement(cdFloat);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_ARRAY: {
        CDArray cdArray = (CDArray)theEObject;
        T result = caseCDArray(cdArray);
        if (result == null) result = casePrimitiveType(cdArray);
        if (result == null) result = caseImplementationClass(cdArray);
        if (result == null) result = caseClassifier(cdArray);
        if (result == null) result = caseObjectType(cdArray);
        if (result == null) result = caseType(cdArray);
        if (result == null) result = caseNamedElement(cdArray);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_CHAR: {
        CDChar cdChar = (CDChar)theEObject;
        T result = caseCDChar(cdChar);
        if (result == null) result = casePrimitiveType(cdChar);
        if (result == null) result = caseImplementationClass(cdChar);
        if (result == null) result = caseClassifier(cdChar);
        if (result == null) result = caseObjectType(cdChar);
        if (result == null) result = caseType(cdChar);
        if (result == null) result = caseNamedElement(cdChar);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_ENUM: {
        CDEnum cdEnum = (CDEnum)theEObject;
        T result = caseCDEnum(cdEnum);
        if (result == null) result = casePrimitiveType(cdEnum);
        if (result == null) result = caseImplementationClass(cdEnum);
        if (result == null) result = caseClassifier(cdEnum);
        if (result == null) result = caseObjectType(cdEnum);
        if (result == null) result = caseType(cdEnum);
        if (result == null) result = caseNamedElement(cdEnum);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_ENUM_LITERAL: {
        CDEnumLiteral cdEnumLiteral = (CDEnumLiteral)theEObject;
        T result = caseCDEnumLiteral(cdEnumLiteral);
        if (result == null) result = caseNamedElement(cdEnumLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_ANY: {
        CDAny cdAny = (CDAny)theEObject;
        T result = caseCDAny(cdAny);
        if (result == null) result = caseObjectType(cdAny);
        if (result == null) result = caseType(cdAny);
        if (result == null) result = caseNamedElement(cdAny);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_VOID: {
        CDVoid cdVoid = (CDVoid)theEObject;
        T result = caseCDVoid(cdVoid);
        if (result == null) result = caseObjectType(cdVoid);
        if (result == null) result = caseType(cdVoid);
        if (result == null) result = caseNamedElement(cdVoid);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_COLLECTION: {
        CDCollection cdCollection = (CDCollection)theEObject;
        T result = caseCDCollection(cdCollection);
        if (result == null) result = caseImplementationClass(cdCollection);
        if (result == null) result = caseClassifier(cdCollection);
        if (result == null) result = caseObjectType(cdCollection);
        if (result == null) result = caseType(cdCollection);
        if (result == null) result = caseNamedElement(cdCollection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_SET: {
        CDSet cdSet = (CDSet)theEObject;
        T result = caseCDSet(cdSet);
        if (result == null) result = caseCDCollection(cdSet);
        if (result == null) result = caseImplementationClass(cdSet);
        if (result == null) result = caseClassifier(cdSet);
        if (result == null) result = caseObjectType(cdSet);
        if (result == null) result = caseType(cdSet);
        if (result == null) result = caseNamedElement(cdSet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassdiagramPackage.CD_SEQUENCE: {
        CDSequence cdSequence = (CDSequence)theEObject;
        T result = caseCDSequence(cdSequence);
        if (result == null) result = caseCDCollection(cdSequence);
        if (result == null) result = caseImplementationClass(cdSequence);
        if (result == null) result = caseClassifier(cdSequence);
        if (result == null) result = caseObjectType(cdSequence);
        if (result == null) result = caseType(cdSequence);
        if (result == null) result = caseNamedElement(cdSequence);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElement(NamedElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypedElement(TypedElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameter(Parameter object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Structural Feature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Structural Feature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructuralFeature(StructuralFeature object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectType(ObjectType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimitiveType(PrimitiveType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifier(Classifier object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperation(Operation object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClass(classdiagram.Class object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeParameter(TypeParameter object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociation(Association object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association End</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association End</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociationEnd(AssociationEnd object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Diagram</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Diagram</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassDiagram(ClassDiagram object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Implementation Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Implementation Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImplementationClass(ImplementationClass object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Note</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Note</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNote(Note object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element Map</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element Map</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElementMap(Map.Entry<EObject, LayoutElement> object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Layout</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Layout</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLayout(Layout object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Layout Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Layout Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLayoutElement(LayoutElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Container Map</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Container Map</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContainerMap(Map.Entry<EObject, EMap<EObject, LayoutElement>> object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Boolean</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Boolean</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDBoolean(CDBoolean object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Double</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Double</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDDouble(CDDouble object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Int</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Int</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDInt(CDInt object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Long</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Long</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDLong(CDLong object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD String</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD String</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDString(CDString object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Byte</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Byte</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDByte(CDByte object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Float</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Float</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDFloat(CDFloat object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Array</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Array</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDArray(CDArray object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Char</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Char</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDChar(CDChar object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Enum</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Enum</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDEnum(CDEnum object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Enum Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Enum Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDEnumLiteral(CDEnumLiteral object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Any</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Any</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDAny(CDAny object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Void</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Void</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDVoid(CDVoid object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Collection</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Collection</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDCollection(CDCollection object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDSet(CDSet object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CD Sequence</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CD Sequence</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCDSequence(CDSequence object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object) {
    return null;
  }

} //ClassdiagramSwitch
