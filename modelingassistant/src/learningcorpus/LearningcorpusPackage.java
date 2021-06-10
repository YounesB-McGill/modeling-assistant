/**
 */
package learningcorpus;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see learningcorpus.LearningcorpusFactory
 * @model kind="package"
 * @generated
 */
public interface LearningcorpusPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "learningcorpus";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://cs.mcgill.ca/sel/modelingassistant/learningcorpus/1.0";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "learningcorpus";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LearningcorpusPackage eINSTANCE = learningcorpus.impl.LearningcorpusPackageImpl.init();

  /**
   * The meta object id for the '{@link learningcorpus.impl.UmlElementImpl <em>Uml Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.UmlElementImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getUmlElement()
   * @generated
   */
  int UML_ELEMENT = 0;

  /**
   * The feature id for the '<em><b>Learning Items</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ELEMENT__LEARNING_ITEMS = 0;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ELEMENT__LEARNING_CORPUS = 1;

  /**
   * The number of structural features of the '<em>Uml Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Uml Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link learningcorpus.impl.NamedElementImpl <em>Named Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.NamedElementImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getNamedElement()
   * @generated
   */
  int NAMED_ELEMENT = 12;

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
   * The meta object id for the '{@link learningcorpus.impl.LearningItemImpl <em>Learning Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.LearningItemImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getLearningItem()
   * @generated
   */
  int LEARNING_ITEM = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Uml Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM__UML_ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Learning Resources</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM__LEARNING_RESOURCES = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Mistake Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM__MISTAKE_TYPES = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM__DESCRIPTION = NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM__LEARNING_CORPUS = NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Learning Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The number of operations of the '<em>Learning Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpus.impl.MistakeTypeImpl <em>Mistake Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.MistakeTypeImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getMistakeType()
   * @generated
   */
  int MISTAKE_TYPE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Atomic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE__ATOMIC = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Time To Address</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE__TIME_TO_ADDRESS = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Num Steps Before Notification</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Learning Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE__LEARNING_ITEM = NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Feedbacks</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE__FEEDBACKS = NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Mistake Type Category</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY = NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Mistake Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The number of operations of the '<em>Mistake Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpus.impl.FeedbackImpl <em>Feedback</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.FeedbackImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getFeedback()
   * @generated
   */
  int FEEDBACK = 3;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK__LEVEL = 0;

  /**
   * The feature id for the '<em><b>Congratulatory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK__CONGRATULATORY = 1;

  /**
   * The feature id for the '<em><b>Usefulness</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK__USEFULNESS = 2;

  /**
   * The feature id for the '<em><b>Highlight Problem</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK__HIGHLIGHT_PROBLEM = 3;

  /**
   * The feature id for the '<em><b>Highlight Solution</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK__HIGHLIGHT_SOLUTION = 4;

  /**
   * The feature id for the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK__MISTAKE_TYPE = 5;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK__TEXT = 6;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK__LEARNING_CORPUS = 7;

  /**
   * The number of structural features of the '<em>Feedback</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK_FEATURE_COUNT = 8;

  /**
   * The number of operations of the '<em>Feedback</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link learningcorpus.impl.TextResponseImpl <em>Text Response</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.TextResponseImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getTextResponse()
   * @generated
   */
  int TEXT_RESPONSE = 4;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE__LEVEL = FEEDBACK__LEVEL;

  /**
   * The feature id for the '<em><b>Congratulatory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE__CONGRATULATORY = FEEDBACK__CONGRATULATORY;

  /**
   * The feature id for the '<em><b>Usefulness</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE__USEFULNESS = FEEDBACK__USEFULNESS;

  /**
   * The feature id for the '<em><b>Highlight Problem</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE__HIGHLIGHT_PROBLEM = FEEDBACK__HIGHLIGHT_PROBLEM;

  /**
   * The feature id for the '<em><b>Highlight Solution</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE__HIGHLIGHT_SOLUTION = FEEDBACK__HIGHLIGHT_SOLUTION;

  /**
   * The feature id for the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE__MISTAKE_TYPE = FEEDBACK__MISTAKE_TYPE;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE__TEXT = FEEDBACK__TEXT;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE__LEARNING_CORPUS = FEEDBACK__LEARNING_CORPUS;

  /**
   * The number of structural features of the '<em>Text Response</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE_FEATURE_COUNT = FEEDBACK_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Text Response</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE_OPERATION_COUNT = FEEDBACK_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpus.impl.ParametrizedResponseImpl <em>Parametrized Response</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.ParametrizedResponseImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getParametrizedResponse()
   * @generated
   */
  int PARAMETRIZED_RESPONSE = 5;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE__LEVEL = FEEDBACK__LEVEL;

  /**
   * The feature id for the '<em><b>Congratulatory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE__CONGRATULATORY = FEEDBACK__CONGRATULATORY;

  /**
   * The feature id for the '<em><b>Usefulness</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE__USEFULNESS = FEEDBACK__USEFULNESS;

  /**
   * The feature id for the '<em><b>Highlight Problem</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE__HIGHLIGHT_PROBLEM = FEEDBACK__HIGHLIGHT_PROBLEM;

  /**
   * The feature id for the '<em><b>Highlight Solution</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE__HIGHLIGHT_SOLUTION = FEEDBACK__HIGHLIGHT_SOLUTION;

  /**
   * The feature id for the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE__MISTAKE_TYPE = FEEDBACK__MISTAKE_TYPE;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE__TEXT = FEEDBACK__TEXT;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE__LEARNING_CORPUS = FEEDBACK__LEARNING_CORPUS;

  /**
   * The number of structural features of the '<em>Parametrized Response</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE_FEATURE_COUNT = FEEDBACK_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Parametrized Response</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE_OPERATION_COUNT = FEEDBACK_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpus.impl.ResourceResponseImpl <em>Resource Response</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.ResourceResponseImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getResourceResponse()
   * @generated
   */
  int RESOURCE_RESPONSE = 6;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE__LEVEL = FEEDBACK__LEVEL;

  /**
   * The feature id for the '<em><b>Congratulatory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE__CONGRATULATORY = FEEDBACK__CONGRATULATORY;

  /**
   * The feature id for the '<em><b>Usefulness</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE__USEFULNESS = FEEDBACK__USEFULNESS;

  /**
   * The feature id for the '<em><b>Highlight Problem</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE__HIGHLIGHT_PROBLEM = FEEDBACK__HIGHLIGHT_PROBLEM;

  /**
   * The feature id for the '<em><b>Highlight Solution</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE__HIGHLIGHT_SOLUTION = FEEDBACK__HIGHLIGHT_SOLUTION;

  /**
   * The feature id for the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE__MISTAKE_TYPE = FEEDBACK__MISTAKE_TYPE;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE__TEXT = FEEDBACK__TEXT;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE__LEARNING_CORPUS = FEEDBACK__LEARNING_CORPUS;

  /**
   * The feature id for the '<em><b>Learning Resources</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE__LEARNING_RESOURCES = FEEDBACK_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Resource Response</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE_FEATURE_COUNT = FEEDBACK_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Resource Response</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE_OPERATION_COUNT = FEEDBACK_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpus.impl.LearningResourceImpl <em>Learning Resource</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.LearningResourceImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getLearningResource()
   * @generated
   */
  int LEARNING_RESOURCE = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_RESOURCE__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Learning Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_RESOURCE__LEARNING_ITEM = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Resource Responses</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_RESOURCE__RESOURCE_RESPONSES = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_RESOURCE__CONTENT = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_RESOURCE__LEARNING_CORPUS = NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Learning Resource</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_RESOURCE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of operations of the '<em>Learning Resource</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_RESOURCE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpus.impl.ReferenceImpl <em>Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.ReferenceImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getReference()
   * @generated
   */
  int REFERENCE = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__NAME = LEARNING_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Learning Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__LEARNING_ITEM = LEARNING_RESOURCE__LEARNING_ITEM;

  /**
   * The feature id for the '<em><b>Resource Responses</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__RESOURCE_RESPONSES = LEARNING_RESOURCE__RESOURCE_RESPONSES;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__CONTENT = LEARNING_RESOURCE__CONTENT;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__LEARNING_CORPUS = LEARNING_RESOURCE__LEARNING_CORPUS;

  /**
   * The number of structural features of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_FEATURE_COUNT = LEARNING_RESOURCE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_OPERATION_COUNT = LEARNING_RESOURCE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpus.impl.TutorialImpl <em>Tutorial</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.TutorialImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getTutorial()
   * @generated
   */
  int TUTORIAL = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUTORIAL__NAME = LEARNING_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Learning Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUTORIAL__LEARNING_ITEM = LEARNING_RESOURCE__LEARNING_ITEM;

  /**
   * The feature id for the '<em><b>Resource Responses</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUTORIAL__RESOURCE_RESPONSES = LEARNING_RESOURCE__RESOURCE_RESPONSES;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUTORIAL__CONTENT = LEARNING_RESOURCE__CONTENT;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUTORIAL__LEARNING_CORPUS = LEARNING_RESOURCE__LEARNING_CORPUS;

  /**
   * The number of structural features of the '<em>Tutorial</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUTORIAL_FEATURE_COUNT = LEARNING_RESOURCE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Tutorial</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUTORIAL_OPERATION_COUNT = LEARNING_RESOURCE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpus.impl.ExampleImpl <em>Example</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.ExampleImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getExample()
   * @generated
   */
  int EXAMPLE = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXAMPLE__NAME = LEARNING_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Learning Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXAMPLE__LEARNING_ITEM = LEARNING_RESOURCE__LEARNING_ITEM;

  /**
   * The feature id for the '<em><b>Resource Responses</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXAMPLE__RESOURCE_RESPONSES = LEARNING_RESOURCE__RESOURCE_RESPONSES;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXAMPLE__CONTENT = LEARNING_RESOURCE__CONTENT;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXAMPLE__LEARNING_CORPUS = LEARNING_RESOURCE__LEARNING_CORPUS;

  /**
   * The number of structural features of the '<em>Example</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXAMPLE_FEATURE_COUNT = LEARNING_RESOURCE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Example</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXAMPLE_OPERATION_COUNT = LEARNING_RESOURCE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpus.impl.QuizImpl <em>Quiz</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.QuizImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getQuiz()
   * @generated
   */
  int QUIZ = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUIZ__NAME = LEARNING_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Learning Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUIZ__LEARNING_ITEM = LEARNING_RESOURCE__LEARNING_ITEM;

  /**
   * The feature id for the '<em><b>Resource Responses</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUIZ__RESOURCE_RESPONSES = LEARNING_RESOURCE__RESOURCE_RESPONSES;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUIZ__CONTENT = LEARNING_RESOURCE__CONTENT;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUIZ__LEARNING_CORPUS = LEARNING_RESOURCE__LEARNING_CORPUS;

  /**
   * The number of structural features of the '<em>Quiz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUIZ_FEATURE_COUNT = LEARNING_RESOURCE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Quiz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUIZ_OPERATION_COUNT = LEARNING_RESOURCE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpus.impl.MistakeTypeCategoryImpl <em>Mistake Type Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.MistakeTypeCategoryImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getMistakeTypeCategory()
   * @generated
   */
  int MISTAKE_TYPE_CATEGORY = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE_CATEGORY__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Mistake Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Supercategory</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE_CATEGORY__SUPERCATEGORY = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Subcategories</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE_CATEGORY__SUBCATEGORIES = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Learning Corpus</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS = NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Mistake Type Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE_CATEGORY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of operations of the '<em>Mistake Type Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE_CATEGORY_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link learningcorpus.impl.LearningCorpusImpl <em>Learning Corpus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see learningcorpus.impl.LearningCorpusImpl
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getLearningCorpus()
   * @generated
   */
  int LEARNING_CORPUS = 14;

  /**
   * The feature id for the '<em><b>Mistake Type Categories</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES = 0;

  /**
   * The feature id for the '<em><b>Feedbacks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_CORPUS__FEEDBACKS = 1;

  /**
   * The feature id for the '<em><b>Learning Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_CORPUS__LEARNING_ITEMS = 2;

  /**
   * The feature id for the '<em><b>Learning Resources</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_CORPUS__LEARNING_RESOURCES = 3;

  /**
   * The feature id for the '<em><b>Uml Elements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_CORPUS__UML_ELEMENTS = 4;

  /**
   * The number of structural features of the '<em>Learning Corpus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_CORPUS_FEATURE_COUNT = 5;

  /**
   * The number of operations of the '<em>Learning Corpus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_CORPUS_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '<em>Time</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.sql.Time
   * @see learningcorpus.impl.LearningcorpusPackageImpl#getTime()
   * @generated
   */
  int TIME = 15;


  /**
   * Returns the meta object for class '{@link learningcorpus.UmlElement <em>Uml Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Uml Element</em>'.
   * @see learningcorpus.UmlElement
   * @generated
   */
  EClass getUmlElement();

  /**
   * Returns the meta object for the reference list '{@link learningcorpus.UmlElement#getLearningItems <em>Learning Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Learning Items</em>'.
   * @see learningcorpus.UmlElement#getLearningItems()
   * @see #getUmlElement()
   * @generated
   */
  EReference getUmlElement_LearningItems();

  /**
   * Returns the meta object for the container reference '{@link learningcorpus.UmlElement#getLearningCorpus <em>Learning Corpus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Learning Corpus</em>'.
   * @see learningcorpus.UmlElement#getLearningCorpus()
   * @see #getUmlElement()
   * @generated
   */
  EReference getUmlElement_LearningCorpus();

  /**
   * Returns the meta object for class '{@link learningcorpus.LearningItem <em>Learning Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Learning Item</em>'.
   * @see learningcorpus.LearningItem
   * @generated
   */
  EClass getLearningItem();

  /**
   * Returns the meta object for the reference list '{@link learningcorpus.LearningItem#getUmlElements <em>Uml Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Uml Elements</em>'.
   * @see learningcorpus.LearningItem#getUmlElements()
   * @see #getLearningItem()
   * @generated
   */
  EReference getLearningItem_UmlElements();

  /**
   * Returns the meta object for the reference list '{@link learningcorpus.LearningItem#getLearningResources <em>Learning Resources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Learning Resources</em>'.
   * @see learningcorpus.LearningItem#getLearningResources()
   * @see #getLearningItem()
   * @generated
   */
  EReference getLearningItem_LearningResources();

  /**
   * Returns the meta object for the reference list '{@link learningcorpus.LearningItem#getMistakeTypes <em>Mistake Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Mistake Types</em>'.
   * @see learningcorpus.LearningItem#getMistakeTypes()
   * @see #getLearningItem()
   * @generated
   */
  EReference getLearningItem_MistakeTypes();

  /**
   * Returns the meta object for the attribute '{@link learningcorpus.LearningItem#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see learningcorpus.LearningItem#getDescription()
   * @see #getLearningItem()
   * @generated
   */
  EAttribute getLearningItem_Description();

  /**
   * Returns the meta object for the container reference '{@link learningcorpus.LearningItem#getLearningCorpus <em>Learning Corpus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Learning Corpus</em>'.
   * @see learningcorpus.LearningItem#getLearningCorpus()
   * @see #getLearningItem()
   * @generated
   */
  EReference getLearningItem_LearningCorpus();

  /**
   * Returns the meta object for class '{@link learningcorpus.MistakeType <em>Mistake Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mistake Type</em>'.
   * @see learningcorpus.MistakeType
   * @generated
   */
  EClass getMistakeType();

  /**
   * Returns the meta object for the attribute '{@link learningcorpus.MistakeType#isAtomic <em>Atomic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Atomic</em>'.
   * @see learningcorpus.MistakeType#isAtomic()
   * @see #getMistakeType()
   * @generated
   */
  EAttribute getMistakeType_Atomic();

  /**
   * Returns the meta object for the attribute '{@link learningcorpus.MistakeType#getTimeToAddress <em>Time To Address</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Time To Address</em>'.
   * @see learningcorpus.MistakeType#getTimeToAddress()
   * @see #getMistakeType()
   * @generated
   */
  EAttribute getMistakeType_TimeToAddress();

  /**
   * Returns the meta object for the attribute '{@link learningcorpus.MistakeType#getNumStepsBeforeNotification <em>Num Steps Before Notification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Num Steps Before Notification</em>'.
   * @see learningcorpus.MistakeType#getNumStepsBeforeNotification()
   * @see #getMistakeType()
   * @generated
   */
  EAttribute getMistakeType_NumStepsBeforeNotification();

  /**
   * Returns the meta object for the reference '{@link learningcorpus.MistakeType#getLearningItem <em>Learning Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Learning Item</em>'.
   * @see learningcorpus.MistakeType#getLearningItem()
   * @see #getMistakeType()
   * @generated
   */
  EReference getMistakeType_LearningItem();

  /**
   * Returns the meta object for the reference list '{@link learningcorpus.MistakeType#getFeedbacks <em>Feedbacks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Feedbacks</em>'.
   * @see learningcorpus.MistakeType#getFeedbacks()
   * @see #getMistakeType()
   * @generated
   */
  EReference getMistakeType_Feedbacks();

  /**
   * Returns the meta object for the container reference '{@link learningcorpus.MistakeType#getMistakeTypeCategory <em>Mistake Type Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Mistake Type Category</em>'.
   * @see learningcorpus.MistakeType#getMistakeTypeCategory()
   * @see #getMistakeType()
   * @generated
   */
  EReference getMistakeType_MistakeTypeCategory();

  /**
   * Returns the meta object for class '{@link learningcorpus.Feedback <em>Feedback</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feedback</em>'.
   * @see learningcorpus.Feedback
   * @generated
   */
  EClass getFeedback();

  /**
   * Returns the meta object for the attribute '{@link learningcorpus.Feedback#getLevel <em>Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Level</em>'.
   * @see learningcorpus.Feedback#getLevel()
   * @see #getFeedback()
   * @generated
   */
  EAttribute getFeedback_Level();

  /**
   * Returns the meta object for the attribute '{@link learningcorpus.Feedback#isCongratulatory <em>Congratulatory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Congratulatory</em>'.
   * @see learningcorpus.Feedback#isCongratulatory()
   * @see #getFeedback()
   * @generated
   */
  EAttribute getFeedback_Congratulatory();

  /**
   * Returns the meta object for the attribute '{@link learningcorpus.Feedback#getUsefulness <em>Usefulness</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Usefulness</em>'.
   * @see learningcorpus.Feedback#getUsefulness()
   * @see #getFeedback()
   * @generated
   */
  EAttribute getFeedback_Usefulness();

  /**
   * Returns the meta object for the attribute '{@link learningcorpus.Feedback#isHighlightProblem <em>Highlight Problem</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Highlight Problem</em>'.
   * @see learningcorpus.Feedback#isHighlightProblem()
   * @see #getFeedback()
   * @generated
   */
  EAttribute getFeedback_HighlightProblem();

  /**
   * Returns the meta object for the attribute '{@link learningcorpus.Feedback#isHighlightSolution <em>Highlight Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Highlight Solution</em>'.
   * @see learningcorpus.Feedback#isHighlightSolution()
   * @see #getFeedback()
   * @generated
   */
  EAttribute getFeedback_HighlightSolution();

  /**
   * Returns the meta object for the reference '{@link learningcorpus.Feedback#getMistakeType <em>Mistake Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Mistake Type</em>'.
   * @see learningcorpus.Feedback#getMistakeType()
   * @see #getFeedback()
   * @generated
   */
  EReference getFeedback_MistakeType();

  /**
   * Returns the meta object for the attribute '{@link learningcorpus.Feedback#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see learningcorpus.Feedback#getText()
   * @see #getFeedback()
   * @generated
   */
  EAttribute getFeedback_Text();

  /**
   * Returns the meta object for the container reference '{@link learningcorpus.Feedback#getLearningCorpus <em>Learning Corpus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Learning Corpus</em>'.
   * @see learningcorpus.Feedback#getLearningCorpus()
   * @see #getFeedback()
   * @generated
   */
  EReference getFeedback_LearningCorpus();

  /**
   * Returns the meta object for class '{@link learningcorpus.TextResponse <em>Text Response</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Text Response</em>'.
   * @see learningcorpus.TextResponse
   * @generated
   */
  EClass getTextResponse();

  /**
   * Returns the meta object for class '{@link learningcorpus.ParametrizedResponse <em>Parametrized Response</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parametrized Response</em>'.
   * @see learningcorpus.ParametrizedResponse
   * @generated
   */
  EClass getParametrizedResponse();

  /**
   * Returns the meta object for class '{@link learningcorpus.ResourceResponse <em>Resource Response</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Resource Response</em>'.
   * @see learningcorpus.ResourceResponse
   * @generated
   */
  EClass getResourceResponse();

  /**
   * Returns the meta object for the reference list '{@link learningcorpus.ResourceResponse#getLearningResources <em>Learning Resources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Learning Resources</em>'.
   * @see learningcorpus.ResourceResponse#getLearningResources()
   * @see #getResourceResponse()
   * @generated
   */
  EReference getResourceResponse_LearningResources();

  /**
   * Returns the meta object for class '{@link learningcorpus.LearningResource <em>Learning Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Learning Resource</em>'.
   * @see learningcorpus.LearningResource
   * @generated
   */
  EClass getLearningResource();

  /**
   * Returns the meta object for the reference '{@link learningcorpus.LearningResource#getLearningItem <em>Learning Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Learning Item</em>'.
   * @see learningcorpus.LearningResource#getLearningItem()
   * @see #getLearningResource()
   * @generated
   */
  EReference getLearningResource_LearningItem();

  /**
   * Returns the meta object for the reference list '{@link learningcorpus.LearningResource#getResourceResponses <em>Resource Responses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Resource Responses</em>'.
   * @see learningcorpus.LearningResource#getResourceResponses()
   * @see #getLearningResource()
   * @generated
   */
  EReference getLearningResource_ResourceResponses();

  /**
   * Returns the meta object for the attribute '{@link learningcorpus.LearningResource#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content</em>'.
   * @see learningcorpus.LearningResource#getContent()
   * @see #getLearningResource()
   * @generated
   */
  EAttribute getLearningResource_Content();

  /**
   * Returns the meta object for the container reference '{@link learningcorpus.LearningResource#getLearningCorpus <em>Learning Corpus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Learning Corpus</em>'.
   * @see learningcorpus.LearningResource#getLearningCorpus()
   * @see #getLearningResource()
   * @generated
   */
  EReference getLearningResource_LearningCorpus();

  /**
   * Returns the meta object for class '{@link learningcorpus.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference</em>'.
   * @see learningcorpus.Reference
   * @generated
   */
  EClass getReference();

  /**
   * Returns the meta object for class '{@link learningcorpus.Tutorial <em>Tutorial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tutorial</em>'.
   * @see learningcorpus.Tutorial
   * @generated
   */
  EClass getTutorial();

  /**
   * Returns the meta object for class '{@link learningcorpus.Example <em>Example</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Example</em>'.
   * @see learningcorpus.Example
   * @generated
   */
  EClass getExample();

  /**
   * Returns the meta object for class '{@link learningcorpus.Quiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quiz</em>'.
   * @see learningcorpus.Quiz
   * @generated
   */
  EClass getQuiz();

  /**
   * Returns the meta object for class '{@link learningcorpus.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Element</em>'.
   * @see learningcorpus.NamedElement
   * @generated
   */
  EClass getNamedElement();

  /**
   * Returns the meta object for the attribute '{@link learningcorpus.NamedElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see learningcorpus.NamedElement#getName()
   * @see #getNamedElement()
   * @generated
   */
  EAttribute getNamedElement_Name();

  /**
   * Returns the meta object for class '{@link learningcorpus.MistakeTypeCategory <em>Mistake Type Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mistake Type Category</em>'.
   * @see learningcorpus.MistakeTypeCategory
   * @generated
   */
  EClass getMistakeTypeCategory();

  /**
   * Returns the meta object for the containment reference list '{@link learningcorpus.MistakeTypeCategory#getMistakeTypes <em>Mistake Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mistake Types</em>'.
   * @see learningcorpus.MistakeTypeCategory#getMistakeTypes()
   * @see #getMistakeTypeCategory()
   * @generated
   */
  EReference getMistakeTypeCategory_MistakeTypes();

  /**
   * Returns the meta object for the reference '{@link learningcorpus.MistakeTypeCategory#getSupercategory <em>Supercategory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Supercategory</em>'.
   * @see learningcorpus.MistakeTypeCategory#getSupercategory()
   * @see #getMistakeTypeCategory()
   * @generated
   */
  EReference getMistakeTypeCategory_Supercategory();

  /**
   * Returns the meta object for the reference list '{@link learningcorpus.MistakeTypeCategory#getSubcategories <em>Subcategories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Subcategories</em>'.
   * @see learningcorpus.MistakeTypeCategory#getSubcategories()
   * @see #getMistakeTypeCategory()
   * @generated
   */
  EReference getMistakeTypeCategory_Subcategories();

  /**
   * Returns the meta object for the container reference '{@link learningcorpus.MistakeTypeCategory#getLearningCorpus <em>Learning Corpus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Learning Corpus</em>'.
   * @see learningcorpus.MistakeTypeCategory#getLearningCorpus()
   * @see #getMistakeTypeCategory()
   * @generated
   */
  EReference getMistakeTypeCategory_LearningCorpus();

  /**
   * Returns the meta object for class '{@link learningcorpus.LearningCorpus <em>Learning Corpus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Learning Corpus</em>'.
   * @see learningcorpus.LearningCorpus
   * @generated
   */
  EClass getLearningCorpus();

  /**
   * Returns the meta object for the containment reference list '{@link learningcorpus.LearningCorpus#getMistakeTypeCategories <em>Mistake Type Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mistake Type Categories</em>'.
   * @see learningcorpus.LearningCorpus#getMistakeTypeCategories()
   * @see #getLearningCorpus()
   * @generated
   */
  EReference getLearningCorpus_MistakeTypeCategories();

  /**
   * Returns the meta object for the containment reference list '{@link learningcorpus.LearningCorpus#getFeedbacks <em>Feedbacks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Feedbacks</em>'.
   * @see learningcorpus.LearningCorpus#getFeedbacks()
   * @see #getLearningCorpus()
   * @generated
   */
  EReference getLearningCorpus_Feedbacks();

  /**
   * Returns the meta object for the containment reference list '{@link learningcorpus.LearningCorpus#getLearningItems <em>Learning Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Learning Items</em>'.
   * @see learningcorpus.LearningCorpus#getLearningItems()
   * @see #getLearningCorpus()
   * @generated
   */
  EReference getLearningCorpus_LearningItems();

  /**
   * Returns the meta object for the containment reference list '{@link learningcorpus.LearningCorpus#getLearningResources <em>Learning Resources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Learning Resources</em>'.
   * @see learningcorpus.LearningCorpus#getLearningResources()
   * @see #getLearningCorpus()
   * @generated
   */
  EReference getLearningCorpus_LearningResources();

  /**
   * Returns the meta object for the containment reference '{@link learningcorpus.LearningCorpus#getUmlElements <em>Uml Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Uml Elements</em>'.
   * @see learningcorpus.LearningCorpus#getUmlElements()
   * @see #getLearningCorpus()
   * @generated
   */
  EReference getLearningCorpus_UmlElements();

  /**
   * Returns the meta object for data type '{@link java.sql.Time <em>Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Time</em>'.
   * @see java.sql.Time
   * @model instanceClass="java.sql.Time"
   * @generated
   */
  EDataType getTime();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  LearningcorpusFactory getLearningcorpusFactory();

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
     * The meta object literal for the '{@link learningcorpus.impl.UmlElementImpl <em>Uml Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.UmlElementImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getUmlElement()
     * @generated
     */
    EClass UML_ELEMENT = eINSTANCE.getUmlElement();

    /**
     * The meta object literal for the '<em><b>Learning Items</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ELEMENT__LEARNING_ITEMS = eINSTANCE.getUmlElement_LearningItems();

    /**
     * The meta object literal for the '<em><b>Learning Corpus</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ELEMENT__LEARNING_CORPUS = eINSTANCE.getUmlElement_LearningCorpus();

    /**
     * The meta object literal for the '{@link learningcorpus.impl.LearningItemImpl <em>Learning Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.LearningItemImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getLearningItem()
     * @generated
     */
    EClass LEARNING_ITEM = eINSTANCE.getLearningItem();

    /**
     * The meta object literal for the '<em><b>Uml Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_ITEM__UML_ELEMENTS = eINSTANCE.getLearningItem_UmlElements();

    /**
     * The meta object literal for the '<em><b>Learning Resources</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_ITEM__LEARNING_RESOURCES = eINSTANCE.getLearningItem_LearningResources();

    /**
     * The meta object literal for the '<em><b>Mistake Types</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_ITEM__MISTAKE_TYPES = eINSTANCE.getLearningItem_MistakeTypes();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LEARNING_ITEM__DESCRIPTION = eINSTANCE.getLearningItem_Description();

    /**
     * The meta object literal for the '<em><b>Learning Corpus</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_ITEM__LEARNING_CORPUS = eINSTANCE.getLearningItem_LearningCorpus();

    /**
     * The meta object literal for the '{@link learningcorpus.impl.MistakeTypeImpl <em>Mistake Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.MistakeTypeImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getMistakeType()
     * @generated
     */
    EClass MISTAKE_TYPE = eINSTANCE.getMistakeType();

    /**
     * The meta object literal for the '<em><b>Atomic</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MISTAKE_TYPE__ATOMIC = eINSTANCE.getMistakeType_Atomic();

    /**
     * The meta object literal for the '<em><b>Time To Address</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MISTAKE_TYPE__TIME_TO_ADDRESS = eINSTANCE.getMistakeType_TimeToAddress();

    /**
     * The meta object literal for the '<em><b>Num Steps Before Notification</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION = eINSTANCE.getMistakeType_NumStepsBeforeNotification();

    /**
     * The meta object literal for the '<em><b>Learning Item</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE_TYPE__LEARNING_ITEM = eINSTANCE.getMistakeType_LearningItem();

    /**
     * The meta object literal for the '<em><b>Feedbacks</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE_TYPE__FEEDBACKS = eINSTANCE.getMistakeType_Feedbacks();

    /**
     * The meta object literal for the '<em><b>Mistake Type Category</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE_TYPE__MISTAKE_TYPE_CATEGORY = eINSTANCE.getMistakeType_MistakeTypeCategory();

    /**
     * The meta object literal for the '{@link learningcorpus.impl.FeedbackImpl <em>Feedback</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.FeedbackImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getFeedback()
     * @generated
     */
    EClass FEEDBACK = eINSTANCE.getFeedback();

    /**
     * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEEDBACK__LEVEL = eINSTANCE.getFeedback_Level();

    /**
     * The meta object literal for the '<em><b>Congratulatory</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEEDBACK__CONGRATULATORY = eINSTANCE.getFeedback_Congratulatory();

    /**
     * The meta object literal for the '<em><b>Usefulness</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEEDBACK__USEFULNESS = eINSTANCE.getFeedback_Usefulness();

    /**
     * The meta object literal for the '<em><b>Highlight Problem</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEEDBACK__HIGHLIGHT_PROBLEM = eINSTANCE.getFeedback_HighlightProblem();

    /**
     * The meta object literal for the '<em><b>Highlight Solution</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEEDBACK__HIGHLIGHT_SOLUTION = eINSTANCE.getFeedback_HighlightSolution();

    /**
     * The meta object literal for the '<em><b>Mistake Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEEDBACK__MISTAKE_TYPE = eINSTANCE.getFeedback_MistakeType();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEEDBACK__TEXT = eINSTANCE.getFeedback_Text();

    /**
     * The meta object literal for the '<em><b>Learning Corpus</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEEDBACK__LEARNING_CORPUS = eINSTANCE.getFeedback_LearningCorpus();

    /**
     * The meta object literal for the '{@link learningcorpus.impl.TextResponseImpl <em>Text Response</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.TextResponseImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getTextResponse()
     * @generated
     */
    EClass TEXT_RESPONSE = eINSTANCE.getTextResponse();

    /**
     * The meta object literal for the '{@link learningcorpus.impl.ParametrizedResponseImpl <em>Parametrized Response</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.ParametrizedResponseImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getParametrizedResponse()
     * @generated
     */
    EClass PARAMETRIZED_RESPONSE = eINSTANCE.getParametrizedResponse();

    /**
     * The meta object literal for the '{@link learningcorpus.impl.ResourceResponseImpl <em>Resource Response</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.ResourceResponseImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getResourceResponse()
     * @generated
     */
    EClass RESOURCE_RESPONSE = eINSTANCE.getResourceResponse();

    /**
     * The meta object literal for the '<em><b>Learning Resources</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESOURCE_RESPONSE__LEARNING_RESOURCES = eINSTANCE.getResourceResponse_LearningResources();

    /**
     * The meta object literal for the '{@link learningcorpus.impl.LearningResourceImpl <em>Learning Resource</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.LearningResourceImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getLearningResource()
     * @generated
     */
    EClass LEARNING_RESOURCE = eINSTANCE.getLearningResource();

    /**
     * The meta object literal for the '<em><b>Learning Item</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_RESOURCE__LEARNING_ITEM = eINSTANCE.getLearningResource_LearningItem();

    /**
     * The meta object literal for the '<em><b>Resource Responses</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_RESOURCE__RESOURCE_RESPONSES = eINSTANCE.getLearningResource_ResourceResponses();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LEARNING_RESOURCE__CONTENT = eINSTANCE.getLearningResource_Content();

    /**
     * The meta object literal for the '<em><b>Learning Corpus</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_RESOURCE__LEARNING_CORPUS = eINSTANCE.getLearningResource_LearningCorpus();

    /**
     * The meta object literal for the '{@link learningcorpus.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.ReferenceImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getReference()
     * @generated
     */
    EClass REFERENCE = eINSTANCE.getReference();

    /**
     * The meta object literal for the '{@link learningcorpus.impl.TutorialImpl <em>Tutorial</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.TutorialImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getTutorial()
     * @generated
     */
    EClass TUTORIAL = eINSTANCE.getTutorial();

    /**
     * The meta object literal for the '{@link learningcorpus.impl.ExampleImpl <em>Example</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.ExampleImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getExample()
     * @generated
     */
    EClass EXAMPLE = eINSTANCE.getExample();

    /**
     * The meta object literal for the '{@link learningcorpus.impl.QuizImpl <em>Quiz</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.QuizImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getQuiz()
     * @generated
     */
    EClass QUIZ = eINSTANCE.getQuiz();

    /**
     * The meta object literal for the '{@link learningcorpus.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.NamedElementImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getNamedElement()
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
     * The meta object literal for the '{@link learningcorpus.impl.MistakeTypeCategoryImpl <em>Mistake Type Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.MistakeTypeCategoryImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getMistakeTypeCategory()
     * @generated
     */
    EClass MISTAKE_TYPE_CATEGORY = eINSTANCE.getMistakeTypeCategory();

    /**
     * The meta object literal for the '<em><b>Mistake Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE_TYPE_CATEGORY__MISTAKE_TYPES = eINSTANCE.getMistakeTypeCategory_MistakeTypes();

    /**
     * The meta object literal for the '<em><b>Supercategory</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE_TYPE_CATEGORY__SUPERCATEGORY = eINSTANCE.getMistakeTypeCategory_Supercategory();

    /**
     * The meta object literal for the '<em><b>Subcategories</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE_TYPE_CATEGORY__SUBCATEGORIES = eINSTANCE.getMistakeTypeCategory_Subcategories();

    /**
     * The meta object literal for the '<em><b>Learning Corpus</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE_TYPE_CATEGORY__LEARNING_CORPUS = eINSTANCE.getMistakeTypeCategory_LearningCorpus();

    /**
     * The meta object literal for the '{@link learningcorpus.impl.LearningCorpusImpl <em>Learning Corpus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see learningcorpus.impl.LearningCorpusImpl
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getLearningCorpus()
     * @generated
     */
    EClass LEARNING_CORPUS = eINSTANCE.getLearningCorpus();

    /**
     * The meta object literal for the '<em><b>Mistake Type Categories</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES = eINSTANCE.getLearningCorpus_MistakeTypeCategories();

    /**
     * The meta object literal for the '<em><b>Feedbacks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_CORPUS__FEEDBACKS = eINSTANCE.getLearningCorpus_Feedbacks();

    /**
     * The meta object literal for the '<em><b>Learning Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_CORPUS__LEARNING_ITEMS = eINSTANCE.getLearningCorpus_LearningItems();

    /**
     * The meta object literal for the '<em><b>Learning Resources</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_CORPUS__LEARNING_RESOURCES = eINSTANCE.getLearningCorpus_LearningResources();

    /**
     * The meta object literal for the '<em><b>Uml Elements</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_CORPUS__UML_ELEMENTS = eINSTANCE.getLearningCorpus_UmlElements();

    /**
     * The meta object literal for the '<em>Time</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.sql.Time
     * @see learningcorpus.impl.LearningcorpusPackageImpl#getTime()
     * @generated
     */
    EDataType TIME = eINSTANCE.getTime();

  }

} //LearningcorpusPackage
