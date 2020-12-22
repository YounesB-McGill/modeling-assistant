/**
 */
package classdiagram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see classdiagram.ClassdiagramFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface ClassdiagramPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "classdiagram";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://cs.mcgill.ca/sel/cdm/1.0";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "classdiagram";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ClassdiagramPackage eINSTANCE = classdiagram.impl.ClassdiagramPackageImpl.init();

  /**
   * The meta object id for the '{@link classdiagram.impl.NamedElementImpl <em>Named Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.NamedElementImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getNamedElement()
   * @generated
   */
  int NAMED_ELEMENT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Named Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Named Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.TypedElementImpl <em>Typed Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.TypedElementImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getTypedElement()
   * @generated
   */
  int TYPED_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_ELEMENT__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_ELEMENT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Typed Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Typed Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_ELEMENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.ParameterImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = TYPED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__TYPE = TYPED_ELEMENT__TYPE;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.StructuralFeatureImpl <em>Structural Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.StructuralFeatureImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getStructuralFeature()
   * @generated
   */
  int STRUCTURAL_FEATURE = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_FEATURE__NAME = TYPED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_FEATURE__TYPE = TYPED_ELEMENT__TYPE;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_FEATURE__STATIC = TYPED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_FEATURE__VISIBILITY = TYPED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Structural Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_FEATURE_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>Structural Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_FEATURE_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.AttributeImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = STRUCTURAL_FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__TYPE = STRUCTURAL_FEATURE__TYPE;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__STATIC = STRUCTURAL_FEATURE__STATIC;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VISIBILITY = STRUCTURAL_FEATURE__VISIBILITY;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = STRUCTURAL_FEATURE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_OPERATION_COUNT = STRUCTURAL_FEATURE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.TypeImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getType()
   * @generated
   */
  int TYPE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__NAME = NAMED_ELEMENT__NAME;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.ObjectTypeImpl <em>Object Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.ObjectTypeImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getObjectType()
   * @generated
   */
  int OBJECT_TYPE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_TYPE__NAME = TYPE__NAME;

  /**
   * The number of structural features of the '<em>Object Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Object Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_TYPE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.PrimitiveTypeImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getPrimitiveType()
   * @generated
   */
  int PRIMITIVE_TYPE = 7;

  /**
   * The meta object id for the '{@link classdiagram.impl.ClassifierImpl <em>Classifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.ClassifierImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getClassifier()
   * @generated
   */
  int CLASSIFIER = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER__NAME = OBJECT_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER__SUPER_TYPES = OBJECT_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER__DATA_TYPE = OBJECT_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER__ABSTRACT = OBJECT_TYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER__VISIBILITY = OBJECT_TYPE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER__OPERATIONS = OBJECT_TYPE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER__TYPE_PARAMETERS = OBJECT_TYPE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER__ASSOCIATION_ENDS = OBJECT_TYPE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER__ATTRIBUTES = OBJECT_TYPE_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Classifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_FEATURE_COUNT = OBJECT_TYPE_FEATURE_COUNT + 8;

  /**
   * The number of operations of the '<em>Classifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_OPERATION_COUNT = OBJECT_TYPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.OperationImpl <em>Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.OperationImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getOperation()
   * @generated
   */
  int OPERATION = 9;

  /**
   * The meta object id for the '{@link classdiagram.impl.ClassImpl <em>Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.ClassImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getClass_()
   * @generated
   */
  int CLASS = 10;

  /**
   * The meta object id for the '{@link classdiagram.impl.TypeParameterImpl <em>Type Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.TypeParameterImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getTypeParameter()
   * @generated
   */
  int TYPE_PARAMETER = 11;

  /**
   * The meta object id for the '{@link classdiagram.impl.AssociationImpl <em>Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.AssociationImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getAssociation()
   * @generated
   */
  int ASSOCIATION = 12;

  /**
   * The meta object id for the '{@link classdiagram.impl.AssociationEndImpl <em>Association End</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.AssociationEndImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getAssociationEnd()
   * @generated
   */
  int ASSOCIATION_END = 13;

  /**
   * The meta object id for the '{@link classdiagram.impl.ClassDiagramImpl <em>Class Diagram</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.ClassDiagramImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getClassDiagram()
   * @generated
   */
  int CLASS_DIAGRAM = 14;

  /**
   * The meta object id for the '{@link classdiagram.impl.ImplementationClassImpl <em>Implementation Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.ImplementationClassImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getImplementationClass()
   * @generated
   */
  int IMPLEMENTATION_CLASS = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_CLASS__NAME = CLASSIFIER__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_CLASS__SUPER_TYPES = CLASSIFIER__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_CLASS__DATA_TYPE = CLASSIFIER__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_CLASS__ABSTRACT = CLASSIFIER__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_CLASS__VISIBILITY = CLASSIFIER__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_CLASS__OPERATIONS = CLASSIFIER__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_CLASS__TYPE_PARAMETERS = CLASSIFIER__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_CLASS__ASSOCIATION_ENDS = CLASSIFIER__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_CLASS__ATTRIBUTES = CLASSIFIER__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_CLASS__INSTANCE_CLASS_NAME = CLASSIFIER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_CLASS__INTERFACE = CLASSIFIER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Implementation Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_CLASS_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>Implementation Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_CLASS_OPERATION_COUNT = CLASSIFIER_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__NAME = IMPLEMENTATION_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__SUPER_TYPES = IMPLEMENTATION_CLASS__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__DATA_TYPE = IMPLEMENTATION_CLASS__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__ABSTRACT = IMPLEMENTATION_CLASS__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__VISIBILITY = IMPLEMENTATION_CLASS__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__OPERATIONS = IMPLEMENTATION_CLASS__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__TYPE_PARAMETERS = IMPLEMENTATION_CLASS__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__ASSOCIATION_ENDS = IMPLEMENTATION_CLASS__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__ATTRIBUTES = IMPLEMENTATION_CLASS__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__INSTANCE_CLASS_NAME = IMPLEMENTATION_CLASS__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__INTERFACE = IMPLEMENTATION_CLASS__INTERFACE;

  /**
   * The number of structural features of the '<em>Primitive Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE_FEATURE_COUNT = IMPLEMENTATION_CLASS_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Primitive Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE_OPERATION_COUNT = IMPLEMENTATION_CLASS_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__ABSTRACT = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__VISIBILITY = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__STATIC = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Operation Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__OPERATION_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Return Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__RETURN_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The number of operations of the '<em>Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__NAME = CLASSIFIER__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__SUPER_TYPES = CLASSIFIER__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__DATA_TYPE = CLASSIFIER__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__ABSTRACT = CLASSIFIER__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__VISIBILITY = CLASSIFIER__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__OPERATIONS = CLASSIFIER__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__TYPE_PARAMETERS = CLASSIFIER__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__ASSOCIATION_ENDS = CLASSIFIER__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__ATTRIBUTES = CLASSIFIER__ATTRIBUTES;

  /**
   * The number of structural features of the '<em>Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_OPERATION_COUNT = CLASSIFIER_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_PARAMETER__NAME = TYPE__NAME;

  /**
   * The feature id for the '<em><b>Generic Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_PARAMETER__GENERIC_TYPE = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_PARAMETER_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Type Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_PARAMETER_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Ends</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__ENDS = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Association Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__ASSOCIATION_CLASS = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__NAME = STRUCTURAL_FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__TYPE = STRUCTURAL_FEATURE__TYPE;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__STATIC = STRUCTURAL_FEATURE__STATIC;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__VISIBILITY = STRUCTURAL_FEATURE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Navigable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__NAVIGABLE = STRUCTURAL_FEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Assoc</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__ASSOC = STRUCTURAL_FEATURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__CLASSIFIER = STRUCTURAL_FEATURE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Qualifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__QUALIFIER = STRUCTURAL_FEATURE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__LOWER_BOUND = STRUCTURAL_FEATURE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__UPPER_BOUND = STRUCTURAL_FEATURE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Reference Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__REFERENCE_TYPE = STRUCTURAL_FEATURE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__ORDERED = STRUCTURAL_FEATURE_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__UNIQUE = STRUCTURAL_FEATURE_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>Association End</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END_FEATURE_COUNT = STRUCTURAL_FEATURE_FEATURE_COUNT + 9;

  /**
   * The operation id for the '<em>Get Opposite End</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END___GET_OPPOSITE_END = STRUCTURAL_FEATURE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Association End</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END_OPERATION_COUNT = STRUCTURAL_FEATURE_OPERATION_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DIAGRAM__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DIAGRAM__CLASSES = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DIAGRAM__TYPES = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Associations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DIAGRAM__ASSOCIATIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Notes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DIAGRAM__NOTES = NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DIAGRAM__LAYOUT = NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Class Diagram</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DIAGRAM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The number of operations of the '<em>Class Diagram</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DIAGRAM_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.NoteImpl <em>Note</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.NoteImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getNote()
   * @generated
   */
  int NOTE = 16;

  /**
   * The feature id for the '<em><b>Noted Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOTE__NOTED_ELEMENT = 0;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOTE__CONTENT = 1;

  /**
   * The number of structural features of the '<em>Note</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOTE_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Note</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOTE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.ElementMapImpl <em>Element Map</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.ElementMapImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getElementMap()
   * @generated
   */
  int ELEMENT_MAP = 17;

  /**
   * The feature id for the '<em><b>Key</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_MAP__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_MAP__VALUE = 1;

  /**
   * The number of structural features of the '<em>Element Map</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_MAP_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Element Map</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_MAP_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.LayoutImpl <em>Layout</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.LayoutImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getLayout()
   * @generated
   */
  int LAYOUT = 18;

  /**
   * The feature id for the '<em><b>Containers</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT__CONTAINERS = 0;

  /**
   * The number of structural features of the '<em>Layout</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Layout</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.LayoutElementImpl <em>Layout Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.LayoutElementImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getLayoutElement()
   * @generated
   */
  int LAYOUT_ELEMENT = 19;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT_ELEMENT__X = 0;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT_ELEMENT__Y = 1;

  /**
   * The number of structural features of the '<em>Layout Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Layout Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.ContainerMapImpl <em>Container Map</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.ContainerMapImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getContainerMap()
   * @generated
   */
  int CONTAINER_MAP = 20;

  /**
   * The feature id for the '<em><b>Key</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINER_MAP__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINER_MAP__VALUE = 1;

  /**
   * The number of structural features of the '<em>Container Map</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINER_MAP_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Container Map</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINER_MAP_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDBooleanImpl <em>CD Boolean</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDBooleanImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDBoolean()
   * @generated
   */
  int CD_BOOLEAN = 21;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN__NAME = PRIMITIVE_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN__SUPER_TYPES = PRIMITIVE_TYPE__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN__DATA_TYPE = PRIMITIVE_TYPE__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN__ABSTRACT = PRIMITIVE_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN__OPERATIONS = PRIMITIVE_TYPE__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN__TYPE_PARAMETERS = PRIMITIVE_TYPE__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN__ASSOCIATION_ENDS = PRIMITIVE_TYPE__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN__ATTRIBUTES = PRIMITIVE_TYPE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN__INSTANCE_CLASS_NAME = PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN__INTERFACE = PRIMITIVE_TYPE__INTERFACE;

  /**
   * The number of structural features of the '<em>CD Boolean</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN___GET_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Instance Class Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN___GET_INSTANCE_CLASS_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>CD Boolean</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BOOLEAN_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 2;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDDoubleImpl <em>CD Double</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDDoubleImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDDouble()
   * @generated
   */
  int CD_DOUBLE = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE__NAME = PRIMITIVE_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE__SUPER_TYPES = PRIMITIVE_TYPE__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE__DATA_TYPE = PRIMITIVE_TYPE__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE__ABSTRACT = PRIMITIVE_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE__OPERATIONS = PRIMITIVE_TYPE__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE__TYPE_PARAMETERS = PRIMITIVE_TYPE__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE__ASSOCIATION_ENDS = PRIMITIVE_TYPE__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE__ATTRIBUTES = PRIMITIVE_TYPE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE__INSTANCE_CLASS_NAME = PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE__INTERFACE = PRIMITIVE_TYPE__INTERFACE;

  /**
   * The number of structural features of the '<em>CD Double</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE___GET_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Instance Class Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE___GET_INSTANCE_CLASS_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>CD Double</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_DOUBLE_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 2;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDIntImpl <em>CD Int</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDIntImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDInt()
   * @generated
   */
  int CD_INT = 23;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT__NAME = PRIMITIVE_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT__SUPER_TYPES = PRIMITIVE_TYPE__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT__DATA_TYPE = PRIMITIVE_TYPE__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT__ABSTRACT = PRIMITIVE_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT__OPERATIONS = PRIMITIVE_TYPE__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT__TYPE_PARAMETERS = PRIMITIVE_TYPE__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT__ASSOCIATION_ENDS = PRIMITIVE_TYPE__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT__ATTRIBUTES = PRIMITIVE_TYPE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT__INSTANCE_CLASS_NAME = PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT__INTERFACE = PRIMITIVE_TYPE__INTERFACE;

  /**
   * The number of structural features of the '<em>CD Int</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT___GET_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Instance Class Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT___GET_INSTANCE_CLASS_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>CD Int</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_INT_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 2;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDLongImpl <em>CD Long</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDLongImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDLong()
   * @generated
   */
  int CD_LONG = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG__NAME = PRIMITIVE_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG__SUPER_TYPES = PRIMITIVE_TYPE__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG__DATA_TYPE = PRIMITIVE_TYPE__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG__ABSTRACT = PRIMITIVE_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG__OPERATIONS = PRIMITIVE_TYPE__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG__TYPE_PARAMETERS = PRIMITIVE_TYPE__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG__ASSOCIATION_ENDS = PRIMITIVE_TYPE__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG__ATTRIBUTES = PRIMITIVE_TYPE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG__INSTANCE_CLASS_NAME = PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG__INTERFACE = PRIMITIVE_TYPE__INTERFACE;

  /**
   * The number of structural features of the '<em>CD Long</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG___GET_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Instance Class Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG___GET_INSTANCE_CLASS_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>CD Long</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_LONG_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 2;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDStringImpl <em>CD String</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDStringImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDString()
   * @generated
   */
  int CD_STRING = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING__NAME = PRIMITIVE_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING__SUPER_TYPES = PRIMITIVE_TYPE__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING__DATA_TYPE = PRIMITIVE_TYPE__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING__ABSTRACT = PRIMITIVE_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING__OPERATIONS = PRIMITIVE_TYPE__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING__TYPE_PARAMETERS = PRIMITIVE_TYPE__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING__ASSOCIATION_ENDS = PRIMITIVE_TYPE__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING__ATTRIBUTES = PRIMITIVE_TYPE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING__INSTANCE_CLASS_NAME = PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING__INTERFACE = PRIMITIVE_TYPE__INTERFACE;

  /**
   * The number of structural features of the '<em>CD String</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING___GET_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Instance Class Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING___GET_INSTANCE_CLASS_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>CD String</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_STRING_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 2;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDByteImpl <em>CD Byte</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDByteImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDByte()
   * @generated
   */
  int CD_BYTE = 26;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE__NAME = PRIMITIVE_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE__SUPER_TYPES = PRIMITIVE_TYPE__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE__DATA_TYPE = PRIMITIVE_TYPE__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE__ABSTRACT = PRIMITIVE_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE__OPERATIONS = PRIMITIVE_TYPE__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE__TYPE_PARAMETERS = PRIMITIVE_TYPE__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE__ASSOCIATION_ENDS = PRIMITIVE_TYPE__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE__ATTRIBUTES = PRIMITIVE_TYPE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE__INSTANCE_CLASS_NAME = PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE__INTERFACE = PRIMITIVE_TYPE__INTERFACE;

  /**
   * The number of structural features of the '<em>CD Byte</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE___GET_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Instance Class Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE___GET_INSTANCE_CLASS_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>CD Byte</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_BYTE_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 2;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDFloatImpl <em>CD Float</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDFloatImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDFloat()
   * @generated
   */
  int CD_FLOAT = 27;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT__NAME = PRIMITIVE_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT__SUPER_TYPES = PRIMITIVE_TYPE__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT__DATA_TYPE = PRIMITIVE_TYPE__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT__ABSTRACT = PRIMITIVE_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT__OPERATIONS = PRIMITIVE_TYPE__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT__TYPE_PARAMETERS = PRIMITIVE_TYPE__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT__ASSOCIATION_ENDS = PRIMITIVE_TYPE__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT__ATTRIBUTES = PRIMITIVE_TYPE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT__INSTANCE_CLASS_NAME = PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT__INTERFACE = PRIMITIVE_TYPE__INTERFACE;

  /**
   * The number of structural features of the '<em>CD Float</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT___GET_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Instance Class Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT___GET_INSTANCE_CLASS_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>CD Float</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_FLOAT_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 2;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDArrayImpl <em>CD Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDArrayImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDArray()
   * @generated
   */
  int CD_ARRAY = 28;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY__NAME = PRIMITIVE_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY__SUPER_TYPES = PRIMITIVE_TYPE__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY__DATA_TYPE = PRIMITIVE_TYPE__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY__ABSTRACT = PRIMITIVE_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY__OPERATIONS = PRIMITIVE_TYPE__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY__TYPE_PARAMETERS = PRIMITIVE_TYPE__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY__ASSOCIATION_ENDS = PRIMITIVE_TYPE__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY__ATTRIBUTES = PRIMITIVE_TYPE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY__INSTANCE_CLASS_NAME = PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY__INTERFACE = PRIMITIVE_TYPE__INTERFACE;

  /**
   * The feature id for the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY__SIZE = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY__TYPE = PRIMITIVE_TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>CD Array</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY___GET_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Instance Class Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY___GET_INSTANCE_CLASS_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>CD Array</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ARRAY_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 2;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDCharImpl <em>CD Char</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDCharImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDChar()
   * @generated
   */
  int CD_CHAR = 29;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR__NAME = PRIMITIVE_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR__SUPER_TYPES = PRIMITIVE_TYPE__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR__DATA_TYPE = PRIMITIVE_TYPE__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR__ABSTRACT = PRIMITIVE_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR__OPERATIONS = PRIMITIVE_TYPE__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR__TYPE_PARAMETERS = PRIMITIVE_TYPE__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR__ASSOCIATION_ENDS = PRIMITIVE_TYPE__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR__ATTRIBUTES = PRIMITIVE_TYPE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR__INSTANCE_CLASS_NAME = PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR__INTERFACE = PRIMITIVE_TYPE__INTERFACE;

  /**
   * The number of structural features of the '<em>CD Char</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR___GET_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Instance Class Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR___GET_INSTANCE_CLASS_NAME = PRIMITIVE_TYPE_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>CD Char</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_CHAR_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 2;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDEnumImpl <em>CD Enum</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDEnumImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDEnum()
   * @generated
   */
  int CD_ENUM = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM__NAME = PRIMITIVE_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM__SUPER_TYPES = PRIMITIVE_TYPE__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM__DATA_TYPE = PRIMITIVE_TYPE__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM__ABSTRACT = PRIMITIVE_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM__VISIBILITY = PRIMITIVE_TYPE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM__OPERATIONS = PRIMITIVE_TYPE__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM__TYPE_PARAMETERS = PRIMITIVE_TYPE__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM__ASSOCIATION_ENDS = PRIMITIVE_TYPE__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM__ATTRIBUTES = PRIMITIVE_TYPE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM__INSTANCE_CLASS_NAME = PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM__INTERFACE = PRIMITIVE_TYPE__INTERFACE;

  /**
   * The feature id for the '<em><b>Literals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM__LITERALS = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>CD Enum</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>CD Enum</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM_OPERATION_COUNT = PRIMITIVE_TYPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDEnumLiteralImpl <em>CD Enum Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDEnumLiteralImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDEnumLiteral()
   * @generated
   */
  int CD_ENUM_LITERAL = 31;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM_LITERAL__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Enum</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM_LITERAL__ENUM = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>CD Enum Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM_LITERAL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>CD Enum Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ENUM_LITERAL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDAnyImpl <em>CD Any</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDAnyImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDAny()
   * @generated
   */
  int CD_ANY = 32;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ANY__NAME = OBJECT_TYPE__NAME;

  /**
   * The number of structural features of the '<em>CD Any</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ANY_FEATURE_COUNT = OBJECT_TYPE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ANY___GET_NAME = OBJECT_TYPE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>CD Any</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_ANY_OPERATION_COUNT = OBJECT_TYPE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDVoidImpl <em>CD Void</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDVoidImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDVoid()
   * @generated
   */
  int CD_VOID = 33;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_VOID__NAME = OBJECT_TYPE__NAME;

  /**
   * The number of structural features of the '<em>CD Void</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_VOID_FEATURE_COUNT = OBJECT_TYPE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_VOID___GET_NAME = OBJECT_TYPE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>CD Void</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_VOID_OPERATION_COUNT = OBJECT_TYPE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDCollectionImpl <em>CD Collection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDCollectionImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDCollection()
   * @generated
   */
  int CD_COLLECTION = 34;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION__NAME = IMPLEMENTATION_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION__SUPER_TYPES = IMPLEMENTATION_CLASS__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION__DATA_TYPE = IMPLEMENTATION_CLASS__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION__ABSTRACT = IMPLEMENTATION_CLASS__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION__VISIBILITY = IMPLEMENTATION_CLASS__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION__OPERATIONS = IMPLEMENTATION_CLASS__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION__TYPE_PARAMETERS = IMPLEMENTATION_CLASS__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION__ASSOCIATION_ENDS = IMPLEMENTATION_CLASS__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION__ATTRIBUTES = IMPLEMENTATION_CLASS__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION__INSTANCE_CLASS_NAME = IMPLEMENTATION_CLASS__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION__INTERFACE = IMPLEMENTATION_CLASS__INTERFACE;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION__TYPE = IMPLEMENTATION_CLASS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>CD Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION_FEATURE_COUNT = IMPLEMENTATION_CLASS_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION___GET_NAME = IMPLEMENTATION_CLASS_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>CD Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_COLLECTION_OPERATION_COUNT = IMPLEMENTATION_CLASS_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDSetImpl <em>CD Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDSetImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDSet()
   * @generated
   */
  int CD_SET = 35;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET__NAME = CD_COLLECTION__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET__SUPER_TYPES = CD_COLLECTION__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET__DATA_TYPE = CD_COLLECTION__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET__ABSTRACT = CD_COLLECTION__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET__VISIBILITY = CD_COLLECTION__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET__OPERATIONS = CD_COLLECTION__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET__TYPE_PARAMETERS = CD_COLLECTION__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET__ASSOCIATION_ENDS = CD_COLLECTION__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET__ATTRIBUTES = CD_COLLECTION__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET__INSTANCE_CLASS_NAME = CD_COLLECTION__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET__INTERFACE = CD_COLLECTION__INTERFACE;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET__TYPE = CD_COLLECTION__TYPE;

  /**
   * The number of structural features of the '<em>CD Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET_FEATURE_COUNT = CD_COLLECTION_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET___GET_NAME = CD_COLLECTION___GET_NAME;

  /**
   * The number of operations of the '<em>CD Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SET_OPERATION_COUNT = CD_COLLECTION_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link classdiagram.impl.CDSequenceImpl <em>CD Sequence</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.impl.CDSequenceImpl
   * @see classdiagram.impl.ClassdiagramPackageImpl#getCDSequence()
   * @generated
   */
  int CD_SEQUENCE = 36;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE__NAME = CD_COLLECTION__NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE__SUPER_TYPES = CD_COLLECTION__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE__DATA_TYPE = CD_COLLECTION__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE__ABSTRACT = CD_COLLECTION__ABSTRACT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE__VISIBILITY = CD_COLLECTION__VISIBILITY;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE__OPERATIONS = CD_COLLECTION__OPERATIONS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE__TYPE_PARAMETERS = CD_COLLECTION__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE__ASSOCIATION_ENDS = CD_COLLECTION__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE__ATTRIBUTES = CD_COLLECTION__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE__INSTANCE_CLASS_NAME = CD_COLLECTION__INSTANCE_CLASS_NAME;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE__INTERFACE = CD_COLLECTION__INTERFACE;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE__TYPE = CD_COLLECTION__TYPE;

  /**
   * The number of structural features of the '<em>CD Sequence</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE_FEATURE_COUNT = CD_COLLECTION_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE___GET_NAME = CD_COLLECTION___GET_NAME;

  /**
   * The number of operations of the '<em>CD Sequence</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CD_SEQUENCE_OPERATION_COUNT = CD_COLLECTION_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link classdiagram.VisibilityType <em>Visibility Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.VisibilityType
   * @see classdiagram.impl.ClassdiagramPackageImpl#getVisibilityType()
   * @generated
   */
  int VISIBILITY_TYPE = 37;

  /**
   * The meta object id for the '{@link classdiagram.OperationType <em>Operation Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.OperationType
   * @see classdiagram.impl.ClassdiagramPackageImpl#getOperationType()
   * @generated
   */
  int OPERATION_TYPE = 38;

  /**
   * The meta object id for the '{@link classdiagram.ReferenceType <em>Reference Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see classdiagram.ReferenceType
   * @see classdiagram.impl.ClassdiagramPackageImpl#getReferenceType()
   * @generated
   */
  int REFERENCE_TYPE = 39;


  /**
   * Returns the meta object for class '{@link classdiagram.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Element</em>'.
   * @see classdiagram.NamedElement
   * @generated
   */
  EClass getNamedElement();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.NamedElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see classdiagram.NamedElement#getName()
   * @see #getNamedElement()
   * @generated
   */
  EAttribute getNamedElement_Name();

  /**
   * Returns the meta object for class '{@link classdiagram.TypedElement <em>Typed Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typed Element</em>'.
   * @see classdiagram.TypedElement
   * @generated
   */
  EClass getTypedElement();

  /**
   * Returns the meta object for the reference '{@link classdiagram.TypedElement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see classdiagram.TypedElement#getType()
   * @see #getTypedElement()
   * @generated
   */
  EReference getTypedElement_Type();

  /**
   * Returns the meta object for class '{@link classdiagram.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see classdiagram.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for class '{@link classdiagram.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see classdiagram.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for class '{@link classdiagram.StructuralFeature <em>Structural Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Structural Feature</em>'.
   * @see classdiagram.StructuralFeature
   * @generated
   */
  EClass getStructuralFeature();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.StructuralFeature#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see classdiagram.StructuralFeature#isStatic()
   * @see #getStructuralFeature()
   * @generated
   */
  EAttribute getStructuralFeature_Static();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.StructuralFeature#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see classdiagram.StructuralFeature#getVisibility()
   * @see #getStructuralFeature()
   * @generated
   */
  EAttribute getStructuralFeature_Visibility();

  /**
   * Returns the meta object for class '{@link classdiagram.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see classdiagram.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link classdiagram.ObjectType <em>Object Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Type</em>'.
   * @see classdiagram.ObjectType
   * @generated
   */
  EClass getObjectType();

  /**
   * Returns the meta object for class '{@link classdiagram.PrimitiveType <em>Primitive Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Type</em>'.
   * @see classdiagram.PrimitiveType
   * @generated
   */
  EClass getPrimitiveType();

  /**
   * Returns the meta object for class '{@link classdiagram.Classifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Classifier</em>'.
   * @see classdiagram.Classifier
   * @generated
   */
  EClass getClassifier();

  /**
   * Returns the meta object for the reference list '{@link classdiagram.Classifier#getSuperTypes <em>Super Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Super Types</em>'.
   * @see classdiagram.Classifier#getSuperTypes()
   * @see #getClassifier()
   * @generated
   */
  EReference getClassifier_SuperTypes();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.Classifier#isDataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Data Type</em>'.
   * @see classdiagram.Classifier#isDataType()
   * @see #getClassifier()
   * @generated
   */
  EAttribute getClassifier_DataType();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.Classifier#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see classdiagram.Classifier#isAbstract()
   * @see #getClassifier()
   * @generated
   */
  EAttribute getClassifier_Abstract();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.Classifier#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see classdiagram.Classifier#getVisibility()
   * @see #getClassifier()
   * @generated
   */
  EAttribute getClassifier_Visibility();

  /**
   * Returns the meta object for the containment reference list '{@link classdiagram.Classifier#getOperations <em>Operations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operations</em>'.
   * @see classdiagram.Classifier#getOperations()
   * @see #getClassifier()
   * @generated
   */
  EReference getClassifier_Operations();

  /**
   * Returns the meta object for the containment reference list '{@link classdiagram.Classifier#getTypeParameters <em>Type Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
   * @see classdiagram.Classifier#getTypeParameters()
   * @see #getClassifier()
   * @generated
   */
  EReference getClassifier_TypeParameters();

  /**
   * Returns the meta object for the containment reference list '{@link classdiagram.Classifier#getAssociationEnds <em>Association Ends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association Ends</em>'.
   * @see classdiagram.Classifier#getAssociationEnds()
   * @see #getClassifier()
   * @generated
   */
  EReference getClassifier_AssociationEnds();

  /**
   * Returns the meta object for the containment reference list '{@link classdiagram.Classifier#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see classdiagram.Classifier#getAttributes()
   * @see #getClassifier()
   * @generated
   */
  EReference getClassifier_Attributes();

  /**
   * Returns the meta object for class '{@link classdiagram.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation</em>'.
   * @see classdiagram.Operation
   * @generated
   */
  EClass getOperation();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.Operation#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see classdiagram.Operation#isAbstract()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_Abstract();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.Operation#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see classdiagram.Operation#getVisibility()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_Visibility();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.Operation#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see classdiagram.Operation#isStatic()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_Static();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.Operation#getOperationType <em>Operation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operation Type</em>'.
   * @see classdiagram.Operation#getOperationType()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_OperationType();

  /**
   * Returns the meta object for the reference '{@link classdiagram.Operation#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Return Type</em>'.
   * @see classdiagram.Operation#getReturnType()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_ReturnType();

  /**
   * Returns the meta object for the containment reference list '{@link classdiagram.Operation#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see classdiagram.Operation#getParameters()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_Parameters();

  /**
   * Returns the meta object for class '{@link classdiagram.Class <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class</em>'.
   * @see classdiagram.Class
   * @generated
   */
  EClass getClass_();

  /**
   * Returns the meta object for class '{@link classdiagram.TypeParameter <em>Type Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Parameter</em>'.
   * @see classdiagram.TypeParameter
   * @generated
   */
  EClass getTypeParameter();

  /**
   * Returns the meta object for the reference '{@link classdiagram.TypeParameter#getGenericType <em>Generic Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Generic Type</em>'.
   * @see classdiagram.TypeParameter#getGenericType()
   * @see #getTypeParameter()
   * @generated
   */
  EReference getTypeParameter_GenericType();

  /**
   * Returns the meta object for class '{@link classdiagram.Association <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association</em>'.
   * @see classdiagram.Association
   * @generated
   */
  EClass getAssociation();

  /**
   * Returns the meta object for the reference list '{@link classdiagram.Association#getEnds <em>Ends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Ends</em>'.
   * @see classdiagram.Association#getEnds()
   * @see #getAssociation()
   * @generated
   */
  EReference getAssociation_Ends();

  /**
   * Returns the meta object for the reference '{@link classdiagram.Association#getAssociationClass <em>Association Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Association Class</em>'.
   * @see classdiagram.Association#getAssociationClass()
   * @see #getAssociation()
   * @generated
   */
  EReference getAssociation_AssociationClass();

  /**
   * Returns the meta object for class '{@link classdiagram.AssociationEnd <em>Association End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association End</em>'.
   * @see classdiagram.AssociationEnd
   * @generated
   */
  EClass getAssociationEnd();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.AssociationEnd#isNavigable <em>Navigable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Navigable</em>'.
   * @see classdiagram.AssociationEnd#isNavigable()
   * @see #getAssociationEnd()
   * @generated
   */
  EAttribute getAssociationEnd_Navigable();

  /**
   * Returns the meta object for the reference '{@link classdiagram.AssociationEnd#getAssoc <em>Assoc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Assoc</em>'.
   * @see classdiagram.AssociationEnd#getAssoc()
   * @see #getAssociationEnd()
   * @generated
   */
  EReference getAssociationEnd_Assoc();

  /**
   * Returns the meta object for the container reference '{@link classdiagram.AssociationEnd#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Classifier</em>'.
   * @see classdiagram.AssociationEnd#getClassifier()
   * @see #getAssociationEnd()
   * @generated
   */
  EReference getAssociationEnd_Classifier();

  /**
   * Returns the meta object for the reference '{@link classdiagram.AssociationEnd#getQualifier <em>Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Qualifier</em>'.
   * @see classdiagram.AssociationEnd#getQualifier()
   * @see #getAssociationEnd()
   * @generated
   */
  EReference getAssociationEnd_Qualifier();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.AssociationEnd#getLowerBound <em>Lower Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound</em>'.
   * @see classdiagram.AssociationEnd#getLowerBound()
   * @see #getAssociationEnd()
   * @generated
   */
  EAttribute getAssociationEnd_LowerBound();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.AssociationEnd#getUpperBound <em>Upper Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound</em>'.
   * @see classdiagram.AssociationEnd#getUpperBound()
   * @see #getAssociationEnd()
   * @generated
   */
  EAttribute getAssociationEnd_UpperBound();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.AssociationEnd#getReferenceType <em>Reference Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reference Type</em>'.
   * @see classdiagram.AssociationEnd#getReferenceType()
   * @see #getAssociationEnd()
   * @generated
   */
  EAttribute getAssociationEnd_ReferenceType();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.AssociationEnd#isOrdered <em>Ordered</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ordered</em>'.
   * @see classdiagram.AssociationEnd#isOrdered()
   * @see #getAssociationEnd()
   * @generated
   */
  EAttribute getAssociationEnd_Ordered();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.AssociationEnd#isUnique <em>Unique</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unique</em>'.
   * @see classdiagram.AssociationEnd#isUnique()
   * @see #getAssociationEnd()
   * @generated
   */
  EAttribute getAssociationEnd_Unique();

  /**
   * Returns the meta object for the '{@link classdiagram.AssociationEnd#getOppositeEnd() <em>Get Opposite End</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Opposite End</em>' operation.
   * @see classdiagram.AssociationEnd#getOppositeEnd()
   * @generated
   */
  EOperation getAssociationEnd__GetOppositeEnd();

  /**
   * Returns the meta object for class '{@link classdiagram.ClassDiagram <em>Class Diagram</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Diagram</em>'.
   * @see classdiagram.ClassDiagram
   * @generated
   */
  EClass getClassDiagram();

  /**
   * Returns the meta object for the containment reference list '{@link classdiagram.ClassDiagram#getClasses <em>Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Classes</em>'.
   * @see classdiagram.ClassDiagram#getClasses()
   * @see #getClassDiagram()
   * @generated
   */
  EReference getClassDiagram_Classes();

  /**
   * Returns the meta object for the containment reference list '{@link classdiagram.ClassDiagram#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Types</em>'.
   * @see classdiagram.ClassDiagram#getTypes()
   * @see #getClassDiagram()
   * @generated
   */
  EReference getClassDiagram_Types();

  /**
   * Returns the meta object for the containment reference list '{@link classdiagram.ClassDiagram#getAssociations <em>Associations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Associations</em>'.
   * @see classdiagram.ClassDiagram#getAssociations()
   * @see #getClassDiagram()
   * @generated
   */
  EReference getClassDiagram_Associations();

  /**
   * Returns the meta object for the containment reference list '{@link classdiagram.ClassDiagram#getNotes <em>Notes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Notes</em>'.
   * @see classdiagram.ClassDiagram#getNotes()
   * @see #getClassDiagram()
   * @generated
   */
  EReference getClassDiagram_Notes();

  /**
   * Returns the meta object for the containment reference '{@link classdiagram.ClassDiagram#getLayout <em>Layout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Layout</em>'.
   * @see classdiagram.ClassDiagram#getLayout()
   * @see #getClassDiagram()
   * @generated
   */
  EReference getClassDiagram_Layout();

  /**
   * Returns the meta object for class '{@link classdiagram.ImplementationClass <em>Implementation Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Implementation Class</em>'.
   * @see classdiagram.ImplementationClass
   * @generated
   */
  EClass getImplementationClass();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.ImplementationClass#getInstanceClassName <em>Instance Class Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Instance Class Name</em>'.
   * @see classdiagram.ImplementationClass#getInstanceClassName()
   * @see #getImplementationClass()
   * @generated
   */
  EAttribute getImplementationClass_InstanceClassName();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.ImplementationClass#isInterface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Interface</em>'.
   * @see classdiagram.ImplementationClass#isInterface()
   * @see #getImplementationClass()
   * @generated
   */
  EAttribute getImplementationClass_Interface();

  /**
   * Returns the meta object for class '{@link classdiagram.Note <em>Note</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Note</em>'.
   * @see classdiagram.Note
   * @generated
   */
  EClass getNote();

  /**
   * Returns the meta object for the reference list '{@link classdiagram.Note#getNotedElement <em>Noted Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Noted Element</em>'.
   * @see classdiagram.Note#getNotedElement()
   * @see #getNote()
   * @generated
   */
  EReference getNote_NotedElement();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.Note#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content</em>'.
   * @see classdiagram.Note#getContent()
   * @see #getNote()
   * @generated
   */
  EAttribute getNote_Content();

  /**
   * Returns the meta object for class '{@link java.util.Map.Entry <em>Element Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Map</em>'.
   * @see java.util.Map.Entry
   * @model keyType="org.eclipse.emf.ecore.EObject" keyRequired="true"
   *        valueType="classdiagram.LayoutElement" valueContainment="true" valueRequired="true"
   * @generated
   */
  EClass getElementMap();

  /**
   * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Key</em>'.
   * @see java.util.Map.Entry
   * @see #getElementMap()
   * @generated
   */
  EReference getElementMap_Key();

  /**
   * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see java.util.Map.Entry
   * @see #getElementMap()
   * @generated
   */
  EReference getElementMap_Value();

  /**
   * Returns the meta object for class '{@link classdiagram.Layout <em>Layout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Layout</em>'.
   * @see classdiagram.Layout
   * @generated
   */
  EClass getLayout();

  /**
   * Returns the meta object for the map '{@link classdiagram.Layout#getContainers <em>Containers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>Containers</em>'.
   * @see classdiagram.Layout#getContainers()
   * @see #getLayout()
   * @generated
   */
  EReference getLayout_Containers();

  /**
   * Returns the meta object for class '{@link classdiagram.LayoutElement <em>Layout Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Layout Element</em>'.
   * @see classdiagram.LayoutElement
   * @generated
   */
  EClass getLayoutElement();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.LayoutElement#getX <em>X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>X</em>'.
   * @see classdiagram.LayoutElement#getX()
   * @see #getLayoutElement()
   * @generated
   */
  EAttribute getLayoutElement_X();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.LayoutElement#getY <em>Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Y</em>'.
   * @see classdiagram.LayoutElement#getY()
   * @see #getLayoutElement()
   * @generated
   */
  EAttribute getLayoutElement_Y();

  /**
   * Returns the meta object for class '{@link java.util.Map.Entry <em>Container Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Container Map</em>'.
   * @see java.util.Map.Entry
   * @model keyType="org.eclipse.emf.ecore.EObject" keyRequired="true"
   *        valueMapType="classdiagram.ElementMap&lt;org.eclipse.emf.ecore.EObject, classdiagram.LayoutElement&gt;"
   * @generated
   */
  EClass getContainerMap();

  /**
   * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Key</em>'.
   * @see java.util.Map.Entry
   * @see #getContainerMap()
   * @generated
   */
  EReference getContainerMap_Key();

  /**
   * Returns the meta object for the map '{@link java.util.Map.Entry <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>Value</em>'.
   * @see java.util.Map.Entry
   * @see #getContainerMap()
   * @generated
   */
  EReference getContainerMap_Value();

  /**
   * Returns the meta object for class '{@link classdiagram.CDBoolean <em>CD Boolean</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Boolean</em>'.
   * @see classdiagram.CDBoolean
   * @generated
   */
  EClass getCDBoolean();

  /**
   * Returns the meta object for the '{@link classdiagram.CDBoolean#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Name</em>' operation.
   * @see classdiagram.CDBoolean#getName()
   * @generated
   */
  EOperation getCDBoolean__GetName();

  /**
   * Returns the meta object for the '{@link classdiagram.CDBoolean#getInstanceClassName() <em>Get Instance Class Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Instance Class Name</em>' operation.
   * @see classdiagram.CDBoolean#getInstanceClassName()
   * @generated
   */
  EOperation getCDBoolean__GetInstanceClassName();

  /**
   * Returns the meta object for class '{@link classdiagram.CDDouble <em>CD Double</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Double</em>'.
   * @see classdiagram.CDDouble
   * @generated
   */
  EClass getCDDouble();

  /**
   * Returns the meta object for the '{@link classdiagram.CDDouble#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Name</em>' operation.
   * @see classdiagram.CDDouble#getName()
   * @generated
   */
  EOperation getCDDouble__GetName();

  /**
   * Returns the meta object for the '{@link classdiagram.CDDouble#getInstanceClassName() <em>Get Instance Class Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Instance Class Name</em>' operation.
   * @see classdiagram.CDDouble#getInstanceClassName()
   * @generated
   */
  EOperation getCDDouble__GetInstanceClassName();

  /**
   * Returns the meta object for class '{@link classdiagram.CDInt <em>CD Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Int</em>'.
   * @see classdiagram.CDInt
   * @generated
   */
  EClass getCDInt();

  /**
   * Returns the meta object for the '{@link classdiagram.CDInt#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Name</em>' operation.
   * @see classdiagram.CDInt#getName()
   * @generated
   */
  EOperation getCDInt__GetName();

  /**
   * Returns the meta object for the '{@link classdiagram.CDInt#getInstanceClassName() <em>Get Instance Class Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Instance Class Name</em>' operation.
   * @see classdiagram.CDInt#getInstanceClassName()
   * @generated
   */
  EOperation getCDInt__GetInstanceClassName();

  /**
   * Returns the meta object for class '{@link classdiagram.CDLong <em>CD Long</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Long</em>'.
   * @see classdiagram.CDLong
   * @generated
   */
  EClass getCDLong();

  /**
   * Returns the meta object for the '{@link classdiagram.CDLong#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Name</em>' operation.
   * @see classdiagram.CDLong#getName()
   * @generated
   */
  EOperation getCDLong__GetName();

  /**
   * Returns the meta object for the '{@link classdiagram.CDLong#getInstanceClassName() <em>Get Instance Class Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Instance Class Name</em>' operation.
   * @see classdiagram.CDLong#getInstanceClassName()
   * @generated
   */
  EOperation getCDLong__GetInstanceClassName();

  /**
   * Returns the meta object for class '{@link classdiagram.CDString <em>CD String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD String</em>'.
   * @see classdiagram.CDString
   * @generated
   */
  EClass getCDString();

  /**
   * Returns the meta object for the '{@link classdiagram.CDString#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Name</em>' operation.
   * @see classdiagram.CDString#getName()
   * @generated
   */
  EOperation getCDString__GetName();

  /**
   * Returns the meta object for the '{@link classdiagram.CDString#getInstanceClassName() <em>Get Instance Class Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Instance Class Name</em>' operation.
   * @see classdiagram.CDString#getInstanceClassName()
   * @generated
   */
  EOperation getCDString__GetInstanceClassName();

  /**
   * Returns the meta object for class '{@link classdiagram.CDByte <em>CD Byte</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Byte</em>'.
   * @see classdiagram.CDByte
   * @generated
   */
  EClass getCDByte();

  /**
   * Returns the meta object for the '{@link classdiagram.CDByte#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Name</em>' operation.
   * @see classdiagram.CDByte#getName()
   * @generated
   */
  EOperation getCDByte__GetName();

  /**
   * Returns the meta object for the '{@link classdiagram.CDByte#getInstanceClassName() <em>Get Instance Class Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Instance Class Name</em>' operation.
   * @see classdiagram.CDByte#getInstanceClassName()
   * @generated
   */
  EOperation getCDByte__GetInstanceClassName();

  /**
   * Returns the meta object for class '{@link classdiagram.CDFloat <em>CD Float</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Float</em>'.
   * @see classdiagram.CDFloat
   * @generated
   */
  EClass getCDFloat();

  /**
   * Returns the meta object for the '{@link classdiagram.CDFloat#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Name</em>' operation.
   * @see classdiagram.CDFloat#getName()
   * @generated
   */
  EOperation getCDFloat__GetName();

  /**
   * Returns the meta object for the '{@link classdiagram.CDFloat#getInstanceClassName() <em>Get Instance Class Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Instance Class Name</em>' operation.
   * @see classdiagram.CDFloat#getInstanceClassName()
   * @generated
   */
  EOperation getCDFloat__GetInstanceClassName();

  /**
   * Returns the meta object for class '{@link classdiagram.CDArray <em>CD Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Array</em>'.
   * @see classdiagram.CDArray
   * @generated
   */
  EClass getCDArray();

  /**
   * Returns the meta object for the attribute '{@link classdiagram.CDArray#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Size</em>'.
   * @see classdiagram.CDArray#getSize()
   * @see #getCDArray()
   * @generated
   */
  EAttribute getCDArray_Size();

  /**
   * Returns the meta object for the reference '{@link classdiagram.CDArray#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see classdiagram.CDArray#getType()
   * @see #getCDArray()
   * @generated
   */
  EReference getCDArray_Type();

  /**
   * Returns the meta object for the '{@link classdiagram.CDArray#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Name</em>' operation.
   * @see classdiagram.CDArray#getName()
   * @generated
   */
  EOperation getCDArray__GetName();

  /**
   * Returns the meta object for the '{@link classdiagram.CDArray#getInstanceClassName() <em>Get Instance Class Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Instance Class Name</em>' operation.
   * @see classdiagram.CDArray#getInstanceClassName()
   * @generated
   */
  EOperation getCDArray__GetInstanceClassName();

  /**
   * Returns the meta object for class '{@link classdiagram.CDChar <em>CD Char</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Char</em>'.
   * @see classdiagram.CDChar
   * @generated
   */
  EClass getCDChar();

  /**
   * Returns the meta object for the '{@link classdiagram.CDChar#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Name</em>' operation.
   * @see classdiagram.CDChar#getName()
   * @generated
   */
  EOperation getCDChar__GetName();

  /**
   * Returns the meta object for the '{@link classdiagram.CDChar#getInstanceClassName() <em>Get Instance Class Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Instance Class Name</em>' operation.
   * @see classdiagram.CDChar#getInstanceClassName()
   * @generated
   */
  EOperation getCDChar__GetInstanceClassName();

  /**
   * Returns the meta object for class '{@link classdiagram.CDEnum <em>CD Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Enum</em>'.
   * @see classdiagram.CDEnum
   * @generated
   */
  EClass getCDEnum();

  /**
   * Returns the meta object for the containment reference list '{@link classdiagram.CDEnum#getLiterals <em>Literals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Literals</em>'.
   * @see classdiagram.CDEnum#getLiterals()
   * @see #getCDEnum()
   * @generated
   */
  EReference getCDEnum_Literals();

  /**
   * Returns the meta object for class '{@link classdiagram.CDEnumLiteral <em>CD Enum Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Enum Literal</em>'.
   * @see classdiagram.CDEnumLiteral
   * @generated
   */
  EClass getCDEnumLiteral();

  /**
   * Returns the meta object for the container reference '{@link classdiagram.CDEnumLiteral#getEnum <em>Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Enum</em>'.
   * @see classdiagram.CDEnumLiteral#getEnum()
   * @see #getCDEnumLiteral()
   * @generated
   */
  EReference getCDEnumLiteral_Enum();

  /**
   * Returns the meta object for class '{@link classdiagram.CDAny <em>CD Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Any</em>'.
   * @see classdiagram.CDAny
   * @generated
   */
  EClass getCDAny();

  /**
   * Returns the meta object for the '{@link classdiagram.CDAny#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Name</em>' operation.
   * @see classdiagram.CDAny#getName()
   * @generated
   */
  EOperation getCDAny__GetName();

  /**
   * Returns the meta object for class '{@link classdiagram.CDVoid <em>CD Void</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Void</em>'.
   * @see classdiagram.CDVoid
   * @generated
   */
  EClass getCDVoid();

  /**
   * Returns the meta object for the '{@link classdiagram.CDVoid#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Name</em>' operation.
   * @see classdiagram.CDVoid#getName()
   * @generated
   */
  EOperation getCDVoid__GetName();

  /**
   * Returns the meta object for class '{@link classdiagram.CDCollection <em>CD Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Collection</em>'.
   * @see classdiagram.CDCollection
   * @generated
   */
  EClass getCDCollection();

  /**
   * Returns the meta object for the reference '{@link classdiagram.CDCollection#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see classdiagram.CDCollection#getType()
   * @see #getCDCollection()
   * @generated
   */
  EReference getCDCollection_Type();

  /**
   * Returns the meta object for the '{@link classdiagram.CDCollection#getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Name</em>' operation.
   * @see classdiagram.CDCollection#getName()
   * @generated
   */
  EOperation getCDCollection__GetName();

  /**
   * Returns the meta object for class '{@link classdiagram.CDSet <em>CD Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Set</em>'.
   * @see classdiagram.CDSet
   * @generated
   */
  EClass getCDSet();

  /**
   * Returns the meta object for class '{@link classdiagram.CDSequence <em>CD Sequence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CD Sequence</em>'.
   * @see classdiagram.CDSequence
   * @generated
   */
  EClass getCDSequence();

  /**
   * Returns the meta object for enum '{@link classdiagram.VisibilityType <em>Visibility Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Visibility Type</em>'.
   * @see classdiagram.VisibilityType
   * @generated
   */
  EEnum getVisibilityType();

  /**
   * Returns the meta object for enum '{@link classdiagram.OperationType <em>Operation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Operation Type</em>'.
   * @see classdiagram.OperationType
   * @generated
   */
  EEnum getOperationType();

  /**
   * Returns the meta object for enum '{@link classdiagram.ReferenceType <em>Reference Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Reference Type</em>'.
   * @see classdiagram.ReferenceType
   * @generated
   */
  EEnum getReferenceType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ClassdiagramFactory getClassdiagramFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link classdiagram.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.NamedElementImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getNamedElement()
     * @generated
     */
    EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

    /**
     * The meta object literal for the '{@link classdiagram.impl.TypedElementImpl <em>Typed Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.TypedElementImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getTypedElement()
     * @generated
     */
    EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

    /**
     * The meta object literal for the '{@link classdiagram.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.ParameterImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '{@link classdiagram.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.AttributeImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '{@link classdiagram.impl.StructuralFeatureImpl <em>Structural Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.StructuralFeatureImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getStructuralFeature()
     * @generated
     */
    EClass STRUCTURAL_FEATURE = eINSTANCE.getStructuralFeature();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRUCTURAL_FEATURE__STATIC = eINSTANCE.getStructuralFeature_Static();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRUCTURAL_FEATURE__VISIBILITY = eINSTANCE.getStructuralFeature_Visibility();

    /**
     * The meta object literal for the '{@link classdiagram.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.TypeImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link classdiagram.impl.ObjectTypeImpl <em>Object Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.ObjectTypeImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getObjectType()
     * @generated
     */
    EClass OBJECT_TYPE = eINSTANCE.getObjectType();

    /**
     * The meta object literal for the '{@link classdiagram.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.PrimitiveTypeImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getPrimitiveType()
     * @generated
     */
    EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

    /**
     * The meta object literal for the '{@link classdiagram.impl.ClassifierImpl <em>Classifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.ClassifierImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getClassifier()
     * @generated
     */
    EClass CLASSIFIER = eINSTANCE.getClassifier();

    /**
     * The meta object literal for the '<em><b>Super Types</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER__SUPER_TYPES = eINSTANCE.getClassifier_SuperTypes();

    /**
     * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER__DATA_TYPE = eINSTANCE.getClassifier_DataType();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER__ABSTRACT = eINSTANCE.getClassifier_Abstract();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER__VISIBILITY = eINSTANCE.getClassifier_Visibility();

    /**
     * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER__OPERATIONS = eINSTANCE.getClassifier_Operations();

    /**
     * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER__TYPE_PARAMETERS = eINSTANCE.getClassifier_TypeParameters();

    /**
     * The meta object literal for the '<em><b>Association Ends</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER__ASSOCIATION_ENDS = eINSTANCE.getClassifier_AssociationEnds();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER__ATTRIBUTES = eINSTANCE.getClassifier_Attributes();

    /**
     * The meta object literal for the '{@link classdiagram.impl.OperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.OperationImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getOperation()
     * @generated
     */
    EClass OPERATION = eINSTANCE.getOperation();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION__ABSTRACT = eINSTANCE.getOperation_Abstract();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION__VISIBILITY = eINSTANCE.getOperation_Visibility();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION__STATIC = eINSTANCE.getOperation_Static();

    /**
     * The meta object literal for the '<em><b>Operation Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION__OPERATION_TYPE = eINSTANCE.getOperation_OperationType();

    /**
     * The meta object literal for the '<em><b>Return Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__RETURN_TYPE = eINSTANCE.getOperation_ReturnType();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__PARAMETERS = eINSTANCE.getOperation_Parameters();

    /**
     * The meta object literal for the '{@link classdiagram.impl.ClassImpl <em>Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.ClassImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getClass_()
     * @generated
     */
    EClass CLASS = eINSTANCE.getClass_();

    /**
     * The meta object literal for the '{@link classdiagram.impl.TypeParameterImpl <em>Type Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.TypeParameterImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getTypeParameter()
     * @generated
     */
    EClass TYPE_PARAMETER = eINSTANCE.getTypeParameter();

    /**
     * The meta object literal for the '<em><b>Generic Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_PARAMETER__GENERIC_TYPE = eINSTANCE.getTypeParameter_GenericType();

    /**
     * The meta object literal for the '{@link classdiagram.impl.AssociationImpl <em>Association</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.AssociationImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getAssociation()
     * @generated
     */
    EClass ASSOCIATION = eINSTANCE.getAssociation();

    /**
     * The meta object literal for the '<em><b>Ends</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION__ENDS = eINSTANCE.getAssociation_Ends();

    /**
     * The meta object literal for the '<em><b>Association Class</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION__ASSOCIATION_CLASS = eINSTANCE.getAssociation_AssociationClass();

    /**
     * The meta object literal for the '{@link classdiagram.impl.AssociationEndImpl <em>Association End</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.AssociationEndImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getAssociationEnd()
     * @generated
     */
    EClass ASSOCIATION_END = eINSTANCE.getAssociationEnd();

    /**
     * The meta object literal for the '<em><b>Navigable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSOCIATION_END__NAVIGABLE = eINSTANCE.getAssociationEnd_Navigable();

    /**
     * The meta object literal for the '<em><b>Assoc</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION_END__ASSOC = eINSTANCE.getAssociationEnd_Assoc();

    /**
     * The meta object literal for the '<em><b>Classifier</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION_END__CLASSIFIER = eINSTANCE.getAssociationEnd_Classifier();

    /**
     * The meta object literal for the '<em><b>Qualifier</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION_END__QUALIFIER = eINSTANCE.getAssociationEnd_Qualifier();

    /**
     * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSOCIATION_END__LOWER_BOUND = eINSTANCE.getAssociationEnd_LowerBound();

    /**
     * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSOCIATION_END__UPPER_BOUND = eINSTANCE.getAssociationEnd_UpperBound();

    /**
     * The meta object literal for the '<em><b>Reference Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSOCIATION_END__REFERENCE_TYPE = eINSTANCE.getAssociationEnd_ReferenceType();

    /**
     * The meta object literal for the '<em><b>Ordered</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSOCIATION_END__ORDERED = eINSTANCE.getAssociationEnd_Ordered();

    /**
     * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSOCIATION_END__UNIQUE = eINSTANCE.getAssociationEnd_Unique();

    /**
     * The meta object literal for the '<em><b>Get Opposite End</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ASSOCIATION_END___GET_OPPOSITE_END = eINSTANCE.getAssociationEnd__GetOppositeEnd();

    /**
     * The meta object literal for the '{@link classdiagram.impl.ClassDiagramImpl <em>Class Diagram</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.ClassDiagramImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getClassDiagram()
     * @generated
     */
    EClass CLASS_DIAGRAM = eINSTANCE.getClassDiagram();

    /**
     * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_DIAGRAM__CLASSES = eINSTANCE.getClassDiagram_Classes();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_DIAGRAM__TYPES = eINSTANCE.getClassDiagram_Types();

    /**
     * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_DIAGRAM__ASSOCIATIONS = eINSTANCE.getClassDiagram_Associations();

    /**
     * The meta object literal for the '<em><b>Notes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_DIAGRAM__NOTES = eINSTANCE.getClassDiagram_Notes();

    /**
     * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_DIAGRAM__LAYOUT = eINSTANCE.getClassDiagram_Layout();

    /**
     * The meta object literal for the '{@link classdiagram.impl.ImplementationClassImpl <em>Implementation Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.ImplementationClassImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getImplementationClass()
     * @generated
     */
    EClass IMPLEMENTATION_CLASS = eINSTANCE.getImplementationClass();

    /**
     * The meta object literal for the '<em><b>Instance Class Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPLEMENTATION_CLASS__INSTANCE_CLASS_NAME = eINSTANCE.getImplementationClass_InstanceClassName();

    /**
     * The meta object literal for the '<em><b>Interface</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPLEMENTATION_CLASS__INTERFACE = eINSTANCE.getImplementationClass_Interface();

    /**
     * The meta object literal for the '{@link classdiagram.impl.NoteImpl <em>Note</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.NoteImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getNote()
     * @generated
     */
    EClass NOTE = eINSTANCE.getNote();

    /**
     * The meta object literal for the '<em><b>Noted Element</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOTE__NOTED_ELEMENT = eINSTANCE.getNote_NotedElement();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NOTE__CONTENT = eINSTANCE.getNote_Content();

    /**
     * The meta object literal for the '{@link classdiagram.impl.ElementMapImpl <em>Element Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.ElementMapImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getElementMap()
     * @generated
     */
    EClass ELEMENT_MAP = eINSTANCE.getElementMap();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_MAP__KEY = eINSTANCE.getElementMap_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_MAP__VALUE = eINSTANCE.getElementMap_Value();

    /**
     * The meta object literal for the '{@link classdiagram.impl.LayoutImpl <em>Layout</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.LayoutImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getLayout()
     * @generated
     */
    EClass LAYOUT = eINSTANCE.getLayout();

    /**
     * The meta object literal for the '<em><b>Containers</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LAYOUT__CONTAINERS = eINSTANCE.getLayout_Containers();

    /**
     * The meta object literal for the '{@link classdiagram.impl.LayoutElementImpl <em>Layout Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.LayoutElementImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getLayoutElement()
     * @generated
     */
    EClass LAYOUT_ELEMENT = eINSTANCE.getLayoutElement();

    /**
     * The meta object literal for the '<em><b>X</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LAYOUT_ELEMENT__X = eINSTANCE.getLayoutElement_X();

    /**
     * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LAYOUT_ELEMENT__Y = eINSTANCE.getLayoutElement_Y();

    /**
     * The meta object literal for the '{@link classdiagram.impl.ContainerMapImpl <em>Container Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.ContainerMapImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getContainerMap()
     * @generated
     */
    EClass CONTAINER_MAP = eINSTANCE.getContainerMap();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTAINER_MAP__KEY = eINSTANCE.getContainerMap_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTAINER_MAP__VALUE = eINSTANCE.getContainerMap_Value();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDBooleanImpl <em>CD Boolean</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDBooleanImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDBoolean()
     * @generated
     */
    EClass CD_BOOLEAN = eINSTANCE.getCDBoolean();

    /**
     * The meta object literal for the '<em><b>Get Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_BOOLEAN___GET_NAME = eINSTANCE.getCDBoolean__GetName();

    /**
     * The meta object literal for the '<em><b>Get Instance Class Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_BOOLEAN___GET_INSTANCE_CLASS_NAME = eINSTANCE.getCDBoolean__GetInstanceClassName();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDDoubleImpl <em>CD Double</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDDoubleImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDDouble()
     * @generated
     */
    EClass CD_DOUBLE = eINSTANCE.getCDDouble();

    /**
     * The meta object literal for the '<em><b>Get Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_DOUBLE___GET_NAME = eINSTANCE.getCDDouble__GetName();

    /**
     * The meta object literal for the '<em><b>Get Instance Class Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_DOUBLE___GET_INSTANCE_CLASS_NAME = eINSTANCE.getCDDouble__GetInstanceClassName();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDIntImpl <em>CD Int</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDIntImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDInt()
     * @generated
     */
    EClass CD_INT = eINSTANCE.getCDInt();

    /**
     * The meta object literal for the '<em><b>Get Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_INT___GET_NAME = eINSTANCE.getCDInt__GetName();

    /**
     * The meta object literal for the '<em><b>Get Instance Class Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_INT___GET_INSTANCE_CLASS_NAME = eINSTANCE.getCDInt__GetInstanceClassName();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDLongImpl <em>CD Long</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDLongImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDLong()
     * @generated
     */
    EClass CD_LONG = eINSTANCE.getCDLong();

    /**
     * The meta object literal for the '<em><b>Get Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_LONG___GET_NAME = eINSTANCE.getCDLong__GetName();

    /**
     * The meta object literal for the '<em><b>Get Instance Class Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_LONG___GET_INSTANCE_CLASS_NAME = eINSTANCE.getCDLong__GetInstanceClassName();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDStringImpl <em>CD String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDStringImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDString()
     * @generated
     */
    EClass CD_STRING = eINSTANCE.getCDString();

    /**
     * The meta object literal for the '<em><b>Get Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_STRING___GET_NAME = eINSTANCE.getCDString__GetName();

    /**
     * The meta object literal for the '<em><b>Get Instance Class Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_STRING___GET_INSTANCE_CLASS_NAME = eINSTANCE.getCDString__GetInstanceClassName();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDByteImpl <em>CD Byte</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDByteImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDByte()
     * @generated
     */
    EClass CD_BYTE = eINSTANCE.getCDByte();

    /**
     * The meta object literal for the '<em><b>Get Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_BYTE___GET_NAME = eINSTANCE.getCDByte__GetName();

    /**
     * The meta object literal for the '<em><b>Get Instance Class Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_BYTE___GET_INSTANCE_CLASS_NAME = eINSTANCE.getCDByte__GetInstanceClassName();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDFloatImpl <em>CD Float</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDFloatImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDFloat()
     * @generated
     */
    EClass CD_FLOAT = eINSTANCE.getCDFloat();

    /**
     * The meta object literal for the '<em><b>Get Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_FLOAT___GET_NAME = eINSTANCE.getCDFloat__GetName();

    /**
     * The meta object literal for the '<em><b>Get Instance Class Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_FLOAT___GET_INSTANCE_CLASS_NAME = eINSTANCE.getCDFloat__GetInstanceClassName();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDArrayImpl <em>CD Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDArrayImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDArray()
     * @generated
     */
    EClass CD_ARRAY = eINSTANCE.getCDArray();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CD_ARRAY__SIZE = eINSTANCE.getCDArray_Size();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CD_ARRAY__TYPE = eINSTANCE.getCDArray_Type();

    /**
     * The meta object literal for the '<em><b>Get Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_ARRAY___GET_NAME = eINSTANCE.getCDArray__GetName();

    /**
     * The meta object literal for the '<em><b>Get Instance Class Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_ARRAY___GET_INSTANCE_CLASS_NAME = eINSTANCE.getCDArray__GetInstanceClassName();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDCharImpl <em>CD Char</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDCharImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDChar()
     * @generated
     */
    EClass CD_CHAR = eINSTANCE.getCDChar();

    /**
     * The meta object literal for the '<em><b>Get Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_CHAR___GET_NAME = eINSTANCE.getCDChar__GetName();

    /**
     * The meta object literal for the '<em><b>Get Instance Class Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_CHAR___GET_INSTANCE_CLASS_NAME = eINSTANCE.getCDChar__GetInstanceClassName();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDEnumImpl <em>CD Enum</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDEnumImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDEnum()
     * @generated
     */
    EClass CD_ENUM = eINSTANCE.getCDEnum();

    /**
     * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CD_ENUM__LITERALS = eINSTANCE.getCDEnum_Literals();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDEnumLiteralImpl <em>CD Enum Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDEnumLiteralImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDEnumLiteral()
     * @generated
     */
    EClass CD_ENUM_LITERAL = eINSTANCE.getCDEnumLiteral();

    /**
     * The meta object literal for the '<em><b>Enum</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CD_ENUM_LITERAL__ENUM = eINSTANCE.getCDEnumLiteral_Enum();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDAnyImpl <em>CD Any</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDAnyImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDAny()
     * @generated
     */
    EClass CD_ANY = eINSTANCE.getCDAny();

    /**
     * The meta object literal for the '<em><b>Get Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_ANY___GET_NAME = eINSTANCE.getCDAny__GetName();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDVoidImpl <em>CD Void</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDVoidImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDVoid()
     * @generated
     */
    EClass CD_VOID = eINSTANCE.getCDVoid();

    /**
     * The meta object literal for the '<em><b>Get Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_VOID___GET_NAME = eINSTANCE.getCDVoid__GetName();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDCollectionImpl <em>CD Collection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDCollectionImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDCollection()
     * @generated
     */
    EClass CD_COLLECTION = eINSTANCE.getCDCollection();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CD_COLLECTION__TYPE = eINSTANCE.getCDCollection_Type();

    /**
     * The meta object literal for the '<em><b>Get Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CD_COLLECTION___GET_NAME = eINSTANCE.getCDCollection__GetName();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDSetImpl <em>CD Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDSetImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDSet()
     * @generated
     */
    EClass CD_SET = eINSTANCE.getCDSet();

    /**
     * The meta object literal for the '{@link classdiagram.impl.CDSequenceImpl <em>CD Sequence</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.impl.CDSequenceImpl
     * @see classdiagram.impl.ClassdiagramPackageImpl#getCDSequence()
     * @generated
     */
    EClass CD_SEQUENCE = eINSTANCE.getCDSequence();

    /**
     * The meta object literal for the '{@link classdiagram.VisibilityType <em>Visibility Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.VisibilityType
     * @see classdiagram.impl.ClassdiagramPackageImpl#getVisibilityType()
     * @generated
     */
    EEnum VISIBILITY_TYPE = eINSTANCE.getVisibilityType();

    /**
     * The meta object literal for the '{@link classdiagram.OperationType <em>Operation Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.OperationType
     * @see classdiagram.impl.ClassdiagramPackageImpl#getOperationType()
     * @generated
     */
    EEnum OPERATION_TYPE = eINSTANCE.getOperationType();

    /**
     * The meta object literal for the '{@link classdiagram.ReferenceType <em>Reference Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see classdiagram.ReferenceType
     * @see classdiagram.impl.ClassdiagramPackageImpl#getReferenceType()
     * @generated
     */
    EEnum REFERENCE_TYPE = eINSTANCE.getReferenceType();

  }

} //ClassdiagramPackage
