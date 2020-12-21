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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see classdiagram.ClassdiagramPackage
 * @generated
 */
public class ClassdiagramAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ClassdiagramPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassdiagramAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = ClassdiagramPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassdiagramSwitch<Adapter> modelSwitch =
    new ClassdiagramSwitch<Adapter>() {
      @Override
      public Adapter caseNamedElement(NamedElement object) {
        return createNamedElementAdapter();
      }
      @Override
      public Adapter caseTypedElement(TypedElement object) {
        return createTypedElementAdapter();
      }
      @Override
      public Adapter caseParameter(Parameter object) {
        return createParameterAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object) {
        return createAttributeAdapter();
      }
      @Override
      public Adapter caseStructuralFeature(StructuralFeature object) {
        return createStructuralFeatureAdapter();
      }
      @Override
      public Adapter caseType(Type object) {
        return createTypeAdapter();
      }
      @Override
      public Adapter caseObjectType(ObjectType object) {
        return createObjectTypeAdapter();
      }
      @Override
      public Adapter casePrimitiveType(PrimitiveType object) {
        return createPrimitiveTypeAdapter();
      }
      @Override
      public Adapter caseClassifier(Classifier object) {
        return createClassifierAdapter();
      }
      @Override
      public Adapter caseOperation(Operation object) {
        return createOperationAdapter();
      }
      @Override
      public Adapter caseClass(classdiagram.Class object) {
        return createClassAdapter();
      }
      @Override
      public Adapter caseTypeParameter(TypeParameter object) {
        return createTypeParameterAdapter();
      }
      @Override
      public Adapter caseAssociation(Association object) {
        return createAssociationAdapter();
      }
      @Override
      public Adapter caseAssociationEnd(AssociationEnd object) {
        return createAssociationEndAdapter();
      }
      @Override
      public Adapter caseClassDiagram(ClassDiagram object) {
        return createClassDiagramAdapter();
      }
      @Override
      public Adapter caseImplementationClass(ImplementationClass object) {
        return createImplementationClassAdapter();
      }
      @Override
      public Adapter caseNote(Note object) {
        return createNoteAdapter();
      }
      @Override
      public Adapter caseElementMap(Map.Entry<EObject, LayoutElement> object) {
        return createElementMapAdapter();
      }
      @Override
      public Adapter caseLayout(Layout object) {
        return createLayoutAdapter();
      }
      @Override
      public Adapter caseLayoutElement(LayoutElement object) {
        return createLayoutElementAdapter();
      }
      @Override
      public Adapter caseContainerMap(Map.Entry<EObject, EMap<EObject, LayoutElement>> object) {
        return createContainerMapAdapter();
      }
      @Override
      public Adapter caseCDBoolean(CDBoolean object) {
        return createCDBooleanAdapter();
      }
      @Override
      public Adapter caseCDDouble(CDDouble object) {
        return createCDDoubleAdapter();
      }
      @Override
      public Adapter caseCDInt(CDInt object) {
        return createCDIntAdapter();
      }
      @Override
      public Adapter caseCDLong(CDLong object) {
        return createCDLongAdapter();
      }
      @Override
      public Adapter caseCDString(CDString object) {
        return createCDStringAdapter();
      }
      @Override
      public Adapter caseCDByte(CDByte object) {
        return createCDByteAdapter();
      }
      @Override
      public Adapter caseCDFloat(CDFloat object) {
        return createCDFloatAdapter();
      }
      @Override
      public Adapter caseCDArray(CDArray object) {
        return createCDArrayAdapter();
      }
      @Override
      public Adapter caseCDChar(CDChar object) {
        return createCDCharAdapter();
      }
      @Override
      public Adapter caseCDEnum(CDEnum object) {
        return createCDEnumAdapter();
      }
      @Override
      public Adapter caseCDEnumLiteral(CDEnumLiteral object) {
        return createCDEnumLiteralAdapter();
      }
      @Override
      public Adapter caseCDAny(CDAny object) {
        return createCDAnyAdapter();
      }
      @Override
      public Adapter caseCDVoid(CDVoid object) {
        return createCDVoidAdapter();
      }
      @Override
      public Adapter caseCDCollection(CDCollection object) {
        return createCDCollectionAdapter();
      }
      @Override
      public Adapter caseCDSet(CDSet object) {
        return createCDSetAdapter();
      }
      @Override
      public Adapter caseCDSequence(CDSequence object) {
        return createCDSequenceAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link classdiagram.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.NamedElement
   * @generated
   */
  public Adapter createNamedElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.TypedElement <em>Typed Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.TypedElement
   * @generated
   */
  public Adapter createTypedElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.Parameter
   * @generated
   */
  public Adapter createParameterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.StructuralFeature <em>Structural Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.StructuralFeature
   * @generated
   */
  public Adapter createStructuralFeatureAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.Type
   * @generated
   */
  public Adapter createTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.ObjectType <em>Object Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.ObjectType
   * @generated
   */
  public Adapter createObjectTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.PrimitiveType <em>Primitive Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.PrimitiveType
   * @generated
   */
  public Adapter createPrimitiveTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.Classifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.Classifier
   * @generated
   */
  public Adapter createClassifierAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.Operation
   * @generated
   */
  public Adapter createOperationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.Class <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.Class
   * @generated
   */
  public Adapter createClassAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.TypeParameter <em>Type Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.TypeParameter
   * @generated
   */
  public Adapter createTypeParameterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.Association <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.Association
   * @generated
   */
  public Adapter createAssociationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.AssociationEnd <em>Association End</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.AssociationEnd
   * @generated
   */
  public Adapter createAssociationEndAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.ClassDiagram <em>Class Diagram</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.ClassDiagram
   * @generated
   */
  public Adapter createClassDiagramAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.ImplementationClass <em>Implementation Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.ImplementationClass
   * @generated
   */
  public Adapter createImplementationClassAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.Note <em>Note</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.Note
   * @generated
   */
  public Adapter createNoteAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Element Map</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see java.util.Map.Entry
   * @generated
   */
  public Adapter createElementMapAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.Layout <em>Layout</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.Layout
   * @generated
   */
  public Adapter createLayoutAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.LayoutElement <em>Layout Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.LayoutElement
   * @generated
   */
  public Adapter createLayoutElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Container Map</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see java.util.Map.Entry
   * @generated
   */
  public Adapter createContainerMapAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDBoolean <em>CD Boolean</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDBoolean
   * @generated
   */
  public Adapter createCDBooleanAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDDouble <em>CD Double</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDDouble
   * @generated
   */
  public Adapter createCDDoubleAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDInt <em>CD Int</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDInt
   * @generated
   */
  public Adapter createCDIntAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDLong <em>CD Long</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDLong
   * @generated
   */
  public Adapter createCDLongAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDString <em>CD String</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDString
   * @generated
   */
  public Adapter createCDStringAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDByte <em>CD Byte</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDByte
   * @generated
   */
  public Adapter createCDByteAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDFloat <em>CD Float</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDFloat
   * @generated
   */
  public Adapter createCDFloatAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDArray <em>CD Array</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDArray
   * @generated
   */
  public Adapter createCDArrayAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDChar <em>CD Char</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDChar
   * @generated
   */
  public Adapter createCDCharAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDEnum <em>CD Enum</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDEnum
   * @generated
   */
  public Adapter createCDEnumAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDEnumLiteral <em>CD Enum Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDEnumLiteral
   * @generated
   */
  public Adapter createCDEnumLiteralAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDAny <em>CD Any</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDAny
   * @generated
   */
  public Adapter createCDAnyAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDVoid <em>CD Void</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDVoid
   * @generated
   */
  public Adapter createCDVoidAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDCollection <em>CD Collection</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDCollection
   * @generated
   */
  public Adapter createCDCollectionAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDSet <em>CD Set</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDSet
   * @generated
   */
  public Adapter createCDSetAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link classdiagram.CDSequence <em>CD Sequence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see classdiagram.CDSequence
   * @generated
   */
  public Adapter createCDSequenceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} //ClassdiagramAdapterFactory
