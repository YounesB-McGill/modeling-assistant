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
import classdiagram.ClassdiagramFactory;
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

import classdiagram.util.ClassdiagramValidator;

import java.util.Map;

import learningcorpus.LearningcorpusPackage;

import learningcorpus.impl.LearningcorpusPackageImpl;

import modelingassistant.ModelingassistantPackage;

import modelingassistant.impl.ModelingassistantPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassdiagramPackageImpl extends EPackageImpl implements ClassdiagramPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structuralFeatureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primitiveTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass associationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass associationEndEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classDiagramEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass implementationClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass noteEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elementMapEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass layoutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass layoutElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass containerMapEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdBooleanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdDoubleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdIntEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdLongEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdStringEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdByteEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdFloatEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdArrayEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdCharEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdEnumEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdEnumLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdAnyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdVoidEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdCollectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdSequenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum visibilityTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum operationTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum referenceTypeEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see classdiagram.ClassdiagramPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ClassdiagramPackageImpl() {
    super(eNS_URI, ClassdiagramFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>This method is used to initialize {@link ClassdiagramPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ClassdiagramPackage init() {
    if (isInited) return (ClassdiagramPackage)EPackage.Registry.INSTANCE.getEPackage(ClassdiagramPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredClassdiagramPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    ClassdiagramPackageImpl theClassdiagramPackage = registeredClassdiagramPackage instanceof ClassdiagramPackageImpl ? (ClassdiagramPackageImpl)registeredClassdiagramPackage : new ClassdiagramPackageImpl();

    isInited = true;

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ModelingassistantPackage.eNS_URI);
    ModelingassistantPackageImpl theModelingassistantPackage = (ModelingassistantPackageImpl)(registeredPackage instanceof ModelingassistantPackageImpl ? registeredPackage : ModelingassistantPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(LearningcorpusPackage.eNS_URI);
    LearningcorpusPackageImpl theLearningcorpusPackage = (LearningcorpusPackageImpl)(registeredPackage instanceof LearningcorpusPackageImpl ? registeredPackage : LearningcorpusPackage.eINSTANCE);

    // Create package meta-data objects
    theClassdiagramPackage.createPackageContents();
    theModelingassistantPackage.createPackageContents();
    theLearningcorpusPackage.createPackageContents();

    // Initialize created meta-data
    theClassdiagramPackage.initializePackageContents();
    theModelingassistantPackage.initializePackageContents();
    theLearningcorpusPackage.initializePackageContents();

    // Register package validator
    EValidator.Registry.INSTANCE.put
      (theClassdiagramPackage,
       new EValidator.Descriptor() {
         @Override
         public EValidator getEValidator() {
           return ClassdiagramValidator.INSTANCE;
         }
       });

    // Mark meta-data to indicate it can't be changed
    theClassdiagramPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ClassdiagramPackage.eNS_URI, theClassdiagramPackage);
    return theClassdiagramPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getNamedElement() {
    return namedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getNamedElement_Name() {
    return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTypedElement() {
    return typedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTypedElement_Type() {
    return (EReference)typedElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getParameter() {
    return parameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAttribute() {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getStructuralFeature() {
    return structuralFeatureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getStructuralFeature_Static() {
    return (EAttribute)structuralFeatureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getStructuralFeature_Visibility() {
    return (EAttribute)structuralFeatureEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getType() {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getObjectType() {
    return objectTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPrimitiveType() {
    return primitiveTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getClassifier() {
    return classifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClassifier_SuperTypes() {
    return (EReference)classifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getClassifier_DataType() {
    return (EAttribute)classifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getClassifier_Abstract() {
    return (EAttribute)classifierEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getClassifier_Visibility() {
    return (EAttribute)classifierEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClassifier_Operations() {
    return (EReference)classifierEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClassifier_TypeParameters() {
    return (EReference)classifierEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClassifier_AssociationEnds() {
    return (EReference)classifierEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClassifier_Attributes() {
    return (EReference)classifierEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getOperation() {
    return operationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOperation_Abstract() {
    return (EAttribute)operationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOperation_Visibility() {
    return (EAttribute)operationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOperation_Static() {
    return (EAttribute)operationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOperation_OperationType() {
    return (EAttribute)operationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getOperation_ReturnType() {
    return (EReference)operationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getOperation_Parameters() {
    return (EReference)operationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getClass_() {
    return classEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTypeParameter() {
    return typeParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTypeParameter_GenericType() {
    return (EReference)typeParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAssociation() {
    return associationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAssociation_Ends() {
    return (EReference)associationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAssociation_AssociationClass() {
    return (EReference)associationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAssociationEnd() {
    return associationEndEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAssociationEnd_Navigable() {
    return (EAttribute)associationEndEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAssociationEnd_Assoc() {
    return (EReference)associationEndEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAssociationEnd_Classifier() {
    return (EReference)associationEndEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAssociationEnd_Qualifier() {
    return (EReference)associationEndEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAssociationEnd_LowerBound() {
    return (EAttribute)associationEndEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAssociationEnd_UpperBound() {
    return (EAttribute)associationEndEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAssociationEnd_ReferenceType() {
    return (EAttribute)associationEndEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAssociationEnd_Ordered() {
    return (EAttribute)associationEndEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAssociationEnd_Unique() {
    return (EAttribute)associationEndEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getAssociationEnd__GetOppositeEnd() {
    return associationEndEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getClassDiagram() {
    return classDiagramEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClassDiagram_Classes() {
    return (EReference)classDiagramEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClassDiagram_Types() {
    return (EReference)classDiagramEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClassDiagram_Associations() {
    return (EReference)classDiagramEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClassDiagram_Notes() {
    return (EReference)classDiagramEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClassDiagram_Layout() {
    return (EReference)classDiagramEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getImplementationClass() {
    return implementationClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getImplementationClass_InstanceClassName() {
    return (EAttribute)implementationClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getImplementationClass_Interface() {
    return (EAttribute)implementationClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getNote() {
    return noteEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getNote_NotedElement() {
    return (EReference)noteEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getNote_Content() {
    return (EAttribute)noteEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getElementMap() {
    return elementMapEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getElementMap_Key() {
    return (EReference)elementMapEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getElementMap_Value() {
    return (EReference)elementMapEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLayout() {
    return layoutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLayout_Containers() {
    return (EReference)layoutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLayoutElement() {
    return layoutElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getLayoutElement_X() {
    return (EAttribute)layoutElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getLayoutElement_Y() {
    return (EAttribute)layoutElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getContainerMap() {
    return containerMapEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContainerMap_Key() {
    return (EReference)containerMapEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContainerMap_Value() {
    return (EReference)containerMapEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDBoolean() {
    return cdBooleanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDBoolean__GetName() {
    return cdBooleanEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDBoolean__GetInstanceClassName() {
    return cdBooleanEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDDouble() {
    return cdDoubleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDDouble__GetName() {
    return cdDoubleEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDDouble__GetInstanceClassName() {
    return cdDoubleEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDInt() {
    return cdIntEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDInt__GetName() {
    return cdIntEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDInt__GetInstanceClassName() {
    return cdIntEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDLong() {
    return cdLongEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDLong__GetName() {
    return cdLongEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDLong__GetInstanceClassName() {
    return cdLongEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDString() {
    return cdStringEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDString__GetName() {
    return cdStringEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDString__GetInstanceClassName() {
    return cdStringEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDByte() {
    return cdByteEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDByte__GetName() {
    return cdByteEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDByte__GetInstanceClassName() {
    return cdByteEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDFloat() {
    return cdFloatEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDFloat__GetName() {
    return cdFloatEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDFloat__GetInstanceClassName() {
    return cdFloatEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDArray() {
    return cdArrayEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getCDArray_Size() {
    return (EAttribute)cdArrayEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCDArray_Type() {
    return (EReference)cdArrayEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDArray__GetName() {
    return cdArrayEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDArray__GetInstanceClassName() {
    return cdArrayEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDChar() {
    return cdCharEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDChar__GetName() {
    return cdCharEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDChar__GetInstanceClassName() {
    return cdCharEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDEnum() {
    return cdEnumEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCDEnum_Literals() {
    return (EReference)cdEnumEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDEnumLiteral() {
    return cdEnumLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCDEnumLiteral_Enum() {
    return (EReference)cdEnumLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDAny() {
    return cdAnyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDAny__GetName() {
    return cdAnyEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDVoid() {
    return cdVoidEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDVoid__GetName() {
    return cdVoidEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDCollection() {
    return cdCollectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCDCollection_Type() {
    return (EReference)cdCollectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getCDCollection__GetName() {
    return cdCollectionEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDSet() {
    return cdSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCDSequence() {
    return cdSequenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getVisibilityType() {
    return visibilityTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getOperationType() {
    return operationTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getReferenceType() {
    return referenceTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClassdiagramFactory getClassdiagramFactory() {
    return (ClassdiagramFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    namedElementEClass = createEClass(NAMED_ELEMENT);
    createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

    typedElementEClass = createEClass(TYPED_ELEMENT);
    createEReference(typedElementEClass, TYPED_ELEMENT__TYPE);

    parameterEClass = createEClass(PARAMETER);

    attributeEClass = createEClass(ATTRIBUTE);

    structuralFeatureEClass = createEClass(STRUCTURAL_FEATURE);
    createEAttribute(structuralFeatureEClass, STRUCTURAL_FEATURE__STATIC);
    createEAttribute(structuralFeatureEClass, STRUCTURAL_FEATURE__VISIBILITY);

    typeEClass = createEClass(TYPE);

    objectTypeEClass = createEClass(OBJECT_TYPE);

    primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

    classifierEClass = createEClass(CLASSIFIER);
    createEReference(classifierEClass, CLASSIFIER__SUPER_TYPES);
    createEAttribute(classifierEClass, CLASSIFIER__DATA_TYPE);
    createEAttribute(classifierEClass, CLASSIFIER__ABSTRACT);
    createEAttribute(classifierEClass, CLASSIFIER__VISIBILITY);
    createEReference(classifierEClass, CLASSIFIER__OPERATIONS);
    createEReference(classifierEClass, CLASSIFIER__TYPE_PARAMETERS);
    createEReference(classifierEClass, CLASSIFIER__ASSOCIATION_ENDS);
    createEReference(classifierEClass, CLASSIFIER__ATTRIBUTES);

    operationEClass = createEClass(OPERATION);
    createEAttribute(operationEClass, OPERATION__ABSTRACT);
    createEAttribute(operationEClass, OPERATION__VISIBILITY);
    createEAttribute(operationEClass, OPERATION__STATIC);
    createEAttribute(operationEClass, OPERATION__OPERATION_TYPE);
    createEReference(operationEClass, OPERATION__RETURN_TYPE);
    createEReference(operationEClass, OPERATION__PARAMETERS);

    classEClass = createEClass(CLASS);

    typeParameterEClass = createEClass(TYPE_PARAMETER);
    createEReference(typeParameterEClass, TYPE_PARAMETER__GENERIC_TYPE);

    associationEClass = createEClass(ASSOCIATION);
    createEReference(associationEClass, ASSOCIATION__ENDS);
    createEReference(associationEClass, ASSOCIATION__ASSOCIATION_CLASS);

    associationEndEClass = createEClass(ASSOCIATION_END);
    createEAttribute(associationEndEClass, ASSOCIATION_END__NAVIGABLE);
    createEReference(associationEndEClass, ASSOCIATION_END__ASSOC);
    createEReference(associationEndEClass, ASSOCIATION_END__CLASSIFIER);
    createEReference(associationEndEClass, ASSOCIATION_END__QUALIFIER);
    createEAttribute(associationEndEClass, ASSOCIATION_END__LOWER_BOUND);
    createEAttribute(associationEndEClass, ASSOCIATION_END__UPPER_BOUND);
    createEAttribute(associationEndEClass, ASSOCIATION_END__REFERENCE_TYPE);
    createEAttribute(associationEndEClass, ASSOCIATION_END__ORDERED);
    createEAttribute(associationEndEClass, ASSOCIATION_END__UNIQUE);
    createEOperation(associationEndEClass, ASSOCIATION_END___GET_OPPOSITE_END);

    classDiagramEClass = createEClass(CLASS_DIAGRAM);
    createEReference(classDiagramEClass, CLASS_DIAGRAM__CLASSES);
    createEReference(classDiagramEClass, CLASS_DIAGRAM__TYPES);
    createEReference(classDiagramEClass, CLASS_DIAGRAM__ASSOCIATIONS);
    createEReference(classDiagramEClass, CLASS_DIAGRAM__NOTES);
    createEReference(classDiagramEClass, CLASS_DIAGRAM__LAYOUT);

    implementationClassEClass = createEClass(IMPLEMENTATION_CLASS);
    createEAttribute(implementationClassEClass, IMPLEMENTATION_CLASS__INSTANCE_CLASS_NAME);
    createEAttribute(implementationClassEClass, IMPLEMENTATION_CLASS__INTERFACE);

    noteEClass = createEClass(NOTE);
    createEReference(noteEClass, NOTE__NOTED_ELEMENT);
    createEAttribute(noteEClass, NOTE__CONTENT);

    elementMapEClass = createEClass(ELEMENT_MAP);
    createEReference(elementMapEClass, ELEMENT_MAP__KEY);
    createEReference(elementMapEClass, ELEMENT_MAP__VALUE);

    layoutEClass = createEClass(LAYOUT);
    createEReference(layoutEClass, LAYOUT__CONTAINERS);

    layoutElementEClass = createEClass(LAYOUT_ELEMENT);
    createEAttribute(layoutElementEClass, LAYOUT_ELEMENT__X);
    createEAttribute(layoutElementEClass, LAYOUT_ELEMENT__Y);

    containerMapEClass = createEClass(CONTAINER_MAP);
    createEReference(containerMapEClass, CONTAINER_MAP__KEY);
    createEReference(containerMapEClass, CONTAINER_MAP__VALUE);

    cdBooleanEClass = createEClass(CD_BOOLEAN);
    createEOperation(cdBooleanEClass, CD_BOOLEAN___GET_NAME);
    createEOperation(cdBooleanEClass, CD_BOOLEAN___GET_INSTANCE_CLASS_NAME);

    cdDoubleEClass = createEClass(CD_DOUBLE);
    createEOperation(cdDoubleEClass, CD_DOUBLE___GET_NAME);
    createEOperation(cdDoubleEClass, CD_DOUBLE___GET_INSTANCE_CLASS_NAME);

    cdIntEClass = createEClass(CD_INT);
    createEOperation(cdIntEClass, CD_INT___GET_NAME);
    createEOperation(cdIntEClass, CD_INT___GET_INSTANCE_CLASS_NAME);

    cdLongEClass = createEClass(CD_LONG);
    createEOperation(cdLongEClass, CD_LONG___GET_NAME);
    createEOperation(cdLongEClass, CD_LONG___GET_INSTANCE_CLASS_NAME);

    cdStringEClass = createEClass(CD_STRING);
    createEOperation(cdStringEClass, CD_STRING___GET_NAME);
    createEOperation(cdStringEClass, CD_STRING___GET_INSTANCE_CLASS_NAME);

    cdByteEClass = createEClass(CD_BYTE);
    createEOperation(cdByteEClass, CD_BYTE___GET_NAME);
    createEOperation(cdByteEClass, CD_BYTE___GET_INSTANCE_CLASS_NAME);

    cdFloatEClass = createEClass(CD_FLOAT);
    createEOperation(cdFloatEClass, CD_FLOAT___GET_NAME);
    createEOperation(cdFloatEClass, CD_FLOAT___GET_INSTANCE_CLASS_NAME);

    cdArrayEClass = createEClass(CD_ARRAY);
    createEAttribute(cdArrayEClass, CD_ARRAY__SIZE);
    createEReference(cdArrayEClass, CD_ARRAY__TYPE);
    createEOperation(cdArrayEClass, CD_ARRAY___GET_NAME);
    createEOperation(cdArrayEClass, CD_ARRAY___GET_INSTANCE_CLASS_NAME);

    cdCharEClass = createEClass(CD_CHAR);
    createEOperation(cdCharEClass, CD_CHAR___GET_NAME);
    createEOperation(cdCharEClass, CD_CHAR___GET_INSTANCE_CLASS_NAME);

    cdEnumEClass = createEClass(CD_ENUM);
    createEReference(cdEnumEClass, CD_ENUM__LITERALS);

    cdEnumLiteralEClass = createEClass(CD_ENUM_LITERAL);
    createEReference(cdEnumLiteralEClass, CD_ENUM_LITERAL__ENUM);

    cdAnyEClass = createEClass(CD_ANY);
    createEOperation(cdAnyEClass, CD_ANY___GET_NAME);

    cdVoidEClass = createEClass(CD_VOID);
    createEOperation(cdVoidEClass, CD_VOID___GET_NAME);

    cdCollectionEClass = createEClass(CD_COLLECTION);
    createEReference(cdCollectionEClass, CD_COLLECTION__TYPE);
    createEOperation(cdCollectionEClass, CD_COLLECTION___GET_NAME);

    cdSetEClass = createEClass(CD_SET);

    cdSequenceEClass = createEClass(CD_SEQUENCE);

    // Create enums
    visibilityTypeEEnum = createEEnum(VISIBILITY_TYPE);
    operationTypeEEnum = createEEnum(OPERATION_TYPE);
    referenceTypeEEnum = createEEnum(REFERENCE_TYPE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    typedElementEClass.getESuperTypes().add(this.getNamedElement());
    parameterEClass.getESuperTypes().add(this.getTypedElement());
    attributeEClass.getESuperTypes().add(this.getStructuralFeature());
    structuralFeatureEClass.getESuperTypes().add(this.getTypedElement());
    typeEClass.getESuperTypes().add(this.getNamedElement());
    objectTypeEClass.getESuperTypes().add(this.getType());
    primitiveTypeEClass.getESuperTypes().add(this.getImplementationClass());
    classifierEClass.getESuperTypes().add(this.getObjectType());
    operationEClass.getESuperTypes().add(this.getNamedElement());
    classEClass.getESuperTypes().add(this.getClassifier());
    typeParameterEClass.getESuperTypes().add(this.getType());
    associationEClass.getESuperTypes().add(this.getNamedElement());
    associationEndEClass.getESuperTypes().add(this.getStructuralFeature());
    classDiagramEClass.getESuperTypes().add(this.getNamedElement());
    implementationClassEClass.getESuperTypes().add(this.getClassifier());
    cdBooleanEClass.getESuperTypes().add(this.getPrimitiveType());
    cdDoubleEClass.getESuperTypes().add(this.getPrimitiveType());
    cdIntEClass.getESuperTypes().add(this.getPrimitiveType());
    cdLongEClass.getESuperTypes().add(this.getPrimitiveType());
    cdStringEClass.getESuperTypes().add(this.getPrimitiveType());
    cdByteEClass.getESuperTypes().add(this.getPrimitiveType());
    cdFloatEClass.getESuperTypes().add(this.getPrimitiveType());
    cdArrayEClass.getESuperTypes().add(this.getPrimitiveType());
    cdCharEClass.getESuperTypes().add(this.getPrimitiveType());
    cdEnumEClass.getESuperTypes().add(this.getPrimitiveType());
    cdEnumLiteralEClass.getESuperTypes().add(this.getNamedElement());
    cdAnyEClass.getESuperTypes().add(this.getObjectType());
    cdVoidEClass.getESuperTypes().add(this.getObjectType());
    cdCollectionEClass.getESuperTypes().add(this.getImplementationClass());
    cdSetEClass.getESuperTypes().add(this.getCDCollection());
    cdSequenceEClass.getESuperTypes().add(this.getCDCollection());

    // Initialize classes, features, and operations; add parameters
    initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typedElementEClass, TypedElement.class, "TypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypedElement_Type(), this.getType(), null, "type", null, 1, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(structuralFeatureEClass, StructuralFeature.class, "StructuralFeature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStructuralFeature_Static(), ecorePackage.getEBoolean(), "static", "false", 1, 1, StructuralFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStructuralFeature_Visibility(), this.getVisibilityType(), "visibility", "package", 0, 1, StructuralFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(objectTypeEClass, ObjectType.class, "ObjectType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(classifierEClass, Classifier.class, "Classifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassifier_SuperTypes(), this.getClassifier(), null, "superTypes", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClassifier_DataType(), ecorePackage.getEBoolean(), "dataType", null, 1, 1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClassifier_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 1, 1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClassifier_Visibility(), this.getVisibilityType(), "visibility", "package", 0, 1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassifier_Operations(), this.getOperation(), null, "operations", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassifier_TypeParameters(), this.getTypeParameter(), null, "typeParameters", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassifier_AssociationEnds(), this.getAssociationEnd(), this.getAssociationEnd_Classifier(), "associationEnds", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassifier_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOperation_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOperation_Visibility(), this.getVisibilityType(), "visibility", "public", 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOperation_Static(), ecorePackage.getEBoolean(), "static", "false", 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOperation_OperationType(), this.getOperationType(), "operationType", "Normal", 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperation_ReturnType(), this.getType(), null, "returnType", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperation_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classEClass, classdiagram.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typeParameterEClass, TypeParameter.class, "TypeParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeParameter_GenericType(), this.getObjectType(), null, "genericType", null, 0, 1, TypeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssociation_Ends(), this.getAssociationEnd(), this.getAssociationEnd_Assoc(), "ends", null, 2, -1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssociation_AssociationClass(), this.getClass_(), null, "associationClass", null, 0, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(associationEndEClass, AssociationEnd.class, "AssociationEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssociationEnd_Navigable(), ecorePackage.getEBoolean(), "navigable", "true", 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssociationEnd_Assoc(), this.getAssociation(), this.getAssociation_Ends(), "assoc", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssociationEnd_Classifier(), this.getClassifier(), this.getClassifier_AssociationEnds(), "classifier", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssociationEnd_Qualifier(), this.getType(), null, "qualifier", null, 0, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssociationEnd_LowerBound(), ecorePackage.getEInt(), "lowerBound", "0", 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssociationEnd_UpperBound(), ecorePackage.getEInt(), "upperBound", "1", 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssociationEnd_ReferenceType(), this.getReferenceType(), "referenceType", "Regular", 0, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssociationEnd_Ordered(), ecorePackage.getEBoolean(), "ordered", "false", 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssociationEnd_Unique(), ecorePackage.getEBoolean(), "unique", "true", 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getAssociationEnd__GetOppositeEnd(), this.getAssociationEnd(), "getOppositeEnd", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(classDiagramEClass, ClassDiagram.class, "ClassDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassDiagram_Classes(), this.getClassifier(), null, "classes", null, 0, -1, ClassDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassDiagram_Types(), this.getType(), null, "types", null, 0, -1, ClassDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassDiagram_Associations(), this.getAssociation(), null, "associations", null, 0, -1, ClassDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassDiagram_Notes(), this.getNote(), null, "notes", null, 0, -1, ClassDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassDiagram_Layout(), this.getLayout(), null, "layout", null, 0, 1, ClassDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(implementationClassEClass, ImplementationClass.class, "ImplementationClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImplementationClass_InstanceClassName(), ecorePackage.getEString(), "instanceClassName", null, 1, 1, ImplementationClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getImplementationClass_Interface(), ecorePackage.getEBoolean(), "interface", "false", 1, 1, ImplementationClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(noteEClass, Note.class, "Note", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNote_NotedElement(), this.getNamedElement(), null, "notedElement", null, 0, -1, Note.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNote_Content(), ecorePackage.getEString(), "content", null, 0, 1, Note.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elementMapEClass, Map.Entry.class, "ElementMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    initEReference(getElementMap_Key(), ecorePackage.getEObject(), null, "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getElementMap_Value(), this.getLayoutElement(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(layoutEClass, Layout.class, "Layout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLayout_Containers(), this.getContainerMap(), null, "containers", null, 1, -1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(layoutElementEClass, LayoutElement.class, "LayoutElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLayoutElement_X(), ecorePackage.getEFloat(), "x", null, 1, 1, LayoutElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLayoutElement_Y(), ecorePackage.getEFloat(), "y", null, 1, 1, LayoutElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(containerMapEClass, Map.Entry.class, "ContainerMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    initEReference(getContainerMap_Key(), ecorePackage.getEObject(), null, "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContainerMap_Value(), this.getElementMap(), null, "value", null, 1, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(cdBooleanEClass, CDBoolean.class, "CDBoolean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getCDBoolean__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getCDBoolean__GetInstanceClassName(), ecorePackage.getEString(), "getInstanceClassName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(cdDoubleEClass, CDDouble.class, "CDDouble", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getCDDouble__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getCDDouble__GetInstanceClassName(), ecorePackage.getEString(), "getInstanceClassName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(cdIntEClass, CDInt.class, "CDInt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getCDInt__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getCDInt__GetInstanceClassName(), ecorePackage.getEString(), "getInstanceClassName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(cdLongEClass, CDLong.class, "CDLong", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getCDLong__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getCDLong__GetInstanceClassName(), ecorePackage.getEString(), "getInstanceClassName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(cdStringEClass, CDString.class, "CDString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getCDString__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getCDString__GetInstanceClassName(), ecorePackage.getEString(), "getInstanceClassName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(cdByteEClass, CDByte.class, "CDByte", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getCDByte__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getCDByte__GetInstanceClassName(), ecorePackage.getEString(), "getInstanceClassName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(cdFloatEClass, CDFloat.class, "CDFloat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getCDFloat__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getCDFloat__GetInstanceClassName(), ecorePackage.getEString(), "getInstanceClassName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(cdArrayEClass, CDArray.class, "CDArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCDArray_Size(), ecorePackage.getEInt(), "size", "-1", 1, 1, CDArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCDArray_Type(), this.getType(), null, "type", null, 1, 1, CDArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getCDArray__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getCDArray__GetInstanceClassName(), ecorePackage.getEString(), "getInstanceClassName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(cdCharEClass, CDChar.class, "CDChar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getCDChar__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getCDChar__GetInstanceClassName(), ecorePackage.getEString(), "getInstanceClassName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(cdEnumEClass, CDEnum.class, "CDEnum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCDEnum_Literals(), this.getCDEnumLiteral(), this.getCDEnumLiteral_Enum(), "literals", null, 1, -1, CDEnum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(cdEnumLiteralEClass, CDEnumLiteral.class, "CDEnumLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCDEnumLiteral_Enum(), this.getCDEnum(), this.getCDEnum_Literals(), "enum", null, 1, 1, CDEnumLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(cdAnyEClass, CDAny.class, "CDAny", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getCDAny__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(cdVoidEClass, CDVoid.class, "CDVoid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getCDVoid__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(cdCollectionEClass, CDCollection.class, "CDCollection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCDCollection_Type(), this.getType(), null, "type", null, 1, 1, CDCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getCDCollection__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(cdSetEClass, CDSet.class, "CDSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(cdSequenceEClass, CDSequence.class, "CDSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(visibilityTypeEEnum, VisibilityType.class, "VisibilityType");
    addEEnumLiteral(visibilityTypeEEnum, VisibilityType.PUBLIC);
    addEEnumLiteral(visibilityTypeEEnum, VisibilityType.PROTECTED);
    addEEnumLiteral(visibilityTypeEEnum, VisibilityType.PRIVATE);
    addEEnumLiteral(visibilityTypeEEnum, VisibilityType.PACKAGE);

    initEEnum(operationTypeEEnum, OperationType.class, "OperationType");
    addEEnumLiteral(operationTypeEEnum, OperationType.NORMAL);
    addEEnumLiteral(operationTypeEEnum, OperationType.CONSTRUCTOR);
    addEEnumLiteral(operationTypeEEnum, OperationType.DESTRUCTOR);

    initEEnum(referenceTypeEEnum, ReferenceType.class, "ReferenceType");
    addEEnumLiteral(referenceTypeEEnum, ReferenceType.COMPOSITION);
    addEEnumLiteral(referenceTypeEEnum, ReferenceType.AGGREGATION);
    addEEnumLiteral(referenceTypeEEnum, ReferenceType.REGULAR);
    addEEnumLiteral(referenceTypeEEnum, ReferenceType.QUALIFIED);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http://www.eclipse.org/OCL/Import
    createImportAnnotations();
    // http://www.eclipse.org/emf/2002/Ecore
    createEcoreAnnotations();
    // http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
    createPivotAnnotations();
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createImportAnnotations() {
    String source = "http://www.eclipse.org/OCL/Import";
    addAnnotation
      (this,
       source,
       new String[] {
         "ecore", "http://www.eclipse.org/emf/2002/Ecore"
       });
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createEcoreAnnotations() {
    String source = "http://www.eclipse.org/emf/2002/Ecore";
    addAnnotation
      (this,
       source,
       new String[] {
         "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
       });
    addAnnotation
      (namedElementEClass,
       source,
       new String[] {
         "constraints", "validName"
       });
    addAnnotation
      (parameterEClass,
       source,
       new String[] {
         "constraints", "notVoid"
       });
    addAnnotation
      (operationEClass,
       source,
       new String[] {
         "constraints", "correctVisibility"
       });
    addAnnotation
      (classEClass,
       source,
       new String[] {
         "constraints", "notSelfSuperType"
       });
    addAnnotation
      (associationEndEClass,
       source,
       new String[] {
         "constraints", "uniqueName"
       });
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createPivotAnnotations() {
    String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
    addAnnotation
      (namedElementEClass,
       source,
       new String[] {
         "validName", "Tuple {\n\tmessage : String = \'Name of elements may not be empty\',\n\tstatus : Boolean = if self.oclIsTypeOf(AssociationEnd) and self.oclAsType(AssociationEnd).navigable = false then true else self.name <> \'\' endif\n}.status"
       });
    addAnnotation
      (parameterEClass,
       source,
       new String[] {
         "notVoid", "Tuple {\n\tmessage : String = \'The type of the parameter may not be void\',\n\tstatus : Boolean = not self.type.oclIsTypeOf(CDVoid)\n}.status"
       });
    addAnnotation
      (operationEClass,
       source,
       new String[] {
         "correctVisibility", "Tuple {\n\tmessage : String = \'COREVisibility and Visibility attributes are not in sync\',\n\tstatus : Boolean = if visibility = VisibilityType::public then visibility = VisibilityType::public else visibility <> VisibilityType::public endif\n}.status"
       });
    addAnnotation
      (classEClass,
       source,
       new String[] {
         "notSelfSuperType", "Tuple {\n\tmessage : String = \'A class may not be it\\\'s own supertype\',\n\tstatus : Boolean = not self.superTypes->includes(self)\n}.status"
       });
    addAnnotation
      (associationEndEClass,
       source,
       new String[] {
         "uniqueName", "Tuple {\n\tmessage : String = \'AssociationEnds of a class must be unique\',\n\tstatus : Boolean = self.classifier.associationEnds->select(associationEnd : AssociationEnd | associationEnd.name <> null and associationEnd.name <> \'\')->isUnique(name)\n}.status"
       });
    addAnnotation
      (getAssociationEnd__GetOppositeEnd(),
       source,
       new String[] {
         "body", "if (assoc.ends->size() <= 2) then self.assoc.ends->select(end : AssociationEnd | end <> self)->at(1) else null endif"
       });
    addAnnotation
      (getCDBoolean__GetName(),
       source,
       new String[] {
         "body", "\'boolean\'"
       });
    addAnnotation
      (getCDBoolean__GetInstanceClassName(),
       source,
       new String[] {
         "body", "\'java.lang.Boolean\'"
       });
    addAnnotation
      (getCDDouble__GetName(),
       source,
       new String[] {
         "body", "\'double\'"
       });
    addAnnotation
      (getCDDouble__GetInstanceClassName(),
       source,
       new String[] {
         "body", "\'java.lang.Double\'"
       });
    addAnnotation
      (getCDInt__GetName(),
       source,
       new String[] {
         "body", "\'int\'"
       });
    addAnnotation
      (getCDInt__GetInstanceClassName(),
       source,
       new String[] {
         "body", "\'java.lang.Integer\'"
       });
    addAnnotation
      (getCDLong__GetName(),
       source,
       new String[] {
         "body", "\'long\'"
       });
    addAnnotation
      (getCDLong__GetInstanceClassName(),
       source,
       new String[] {
         "body", "\'java.lang.Long\'"
       });
    addAnnotation
      (getCDString__GetName(),
       source,
       new String[] {
         "body", "\'String\'"
       });
    addAnnotation
      (getCDString__GetInstanceClassName(),
       source,
       new String[] {
         "body", "\'java.lang.String\'"
       });
    addAnnotation
      (getCDByte__GetName(),
       source,
       new String[] {
         "body", "\'byte\'"
       });
    addAnnotation
      (getCDByte__GetInstanceClassName(),
       source,
       new String[] {
         "body", "\'java.lang.Byte\'"
       });
    addAnnotation
      (getCDFloat__GetName(),
       source,
       new String[] {
         "body", "\'float\'"
       });
    addAnnotation
      (getCDFloat__GetInstanceClassName(),
       source,
       new String[] {
         "body", "\'java.lang.Float\'"
       });
    addAnnotation
      (getCDArray__GetName(),
       source,
       new String[] {
         "body", "if (self.type <> null and self.type.name <> null) then self.type.name + \'[\' + if (self.size >= 0) then self.size.toString() else \'\' endif + \']\' else null endif"
       });
    addAnnotation
      (getCDArray__GetInstanceClassName(),
       source,
       new String[] {
         "body", "\'java.lang.reflect.Array\'"
       });
    addAnnotation
      (getCDChar__GetName(),
       source,
       new String[] {
         "body", "\'char\'"
       });
    addAnnotation
      (getCDChar__GetInstanceClassName(),
       source,
       new String[] {
         "body", "\'java.lang.Character\'"
       });
    addAnnotation
      (getCDAny__GetName(),
       source,
       new String[] {
         "body", "\'*\'"
       });
    addAnnotation
      (getCDVoid__GetName(),
       source,
       new String[] {
         "body", "\'void\'"
       });
    addAnnotation
      (getCDCollection__GetName(),
       source,
       new String[] {
         "body", "let typeName : String = self.oclType().toString() in \n                    let name : String = typeName.substring(typeName.lastIndexOf(\':\') + 2, typeName.size()) in \n                        if type.name.oclIsUndefined() then name \n                        else name + \'<\' + type.name + \'>\' endif"
       });
  }

} //ClassdiagramPackageImpl
