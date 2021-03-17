/**
 */
package modelingassistant;

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
 * @see modelingassistant.ModelingassistantFactory
 * @model kind="package"
 * @generated
 */
public interface ModelingassistantPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "modelingassistant";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://cs.mcgill.ca/sel/modelingassistant/1.0";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "modelingassistant";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ModelingassistantPackage eINSTANCE = modelingassistant.impl.ModelingassistantPackageImpl.init();

  /**
   * The meta object id for the '{@link modelingassistant.impl.ModelingAssistantImpl <em>Modeling Assistant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.ModelingAssistantImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getModelingAssistant()
   * @generated
   */
  int MODELING_ASSISTANT = 0;

  /**
   * The feature id for the '<em><b>Learning Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__LEARNING_ITEMS = 0;

  /**
   * The feature id for the '<em><b>Learning Resources</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__LEARNING_RESOURCES = 1;

  /**
   * The feature id for the '<em><b>Problem Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__PROBLEM_STATEMENTS = 2;

  /**
   * The feature id for the '<em><b>Solutions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__SOLUTIONS = 3;

  /**
   * The feature id for the '<em><b>Uml Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__UML_ELEMENTS = 4;

  /**
   * The feature id for the '<em><b>Students</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__STUDENTS = 5;

  /**
   * The feature id for the '<em><b>Feedbacks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__FEEDBACKS = 6;

  /**
   * The feature id for the '<em><b>Mistakes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__MISTAKES = 7;

  /**
   * The feature id for the '<em><b>Mistake Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__MISTAKE_TYPES = 8;

  /**
   * The feature id for the '<em><b>Studentknowledge</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__STUDENTKNOWLEDGE = 9;

  /**
   * The number of structural features of the '<em>Modeling Assistant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT_FEATURE_COUNT = 10;

  /**
   * The number of operations of the '<em>Modeling Assistant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link modelingassistant.impl.NamedElementImpl <em>Named Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.NamedElementImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getNamedElement()
   * @generated
   */
  int NAMED_ELEMENT = 20;

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
   * The meta object id for the '{@link modelingassistant.impl.StudentImpl <em>Student</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.StudentImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getStudent()
   * @generated
   */
  int STUDENT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT__ID = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT__MODELING_ASSISTANT = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Mistakes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT__MISTAKES = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Current Mistake</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT__CURRENT_MISTAKE = NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Solutions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT__SOLUTIONS = NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Student Knowledges</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT__STUDENT_KNOWLEDGES = NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Student</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The number of operations of the '<em>Student</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link modelingassistant.impl.ProblemStatementImpl <em>Problem Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.ProblemStatementImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getProblemStatement()
   * @generated
   */
  int PROBLEM_STATEMENT = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Problem Statement Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT__TEXT = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT__MODELING_ASSISTANT = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Problem Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of operations of the '<em>Problem Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link modelingassistant.impl.ProblemStatementElementImpl <em>Problem Statement Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.ProblemStatementElementImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getProblemStatementElement()
   * @generated
   */
  int PROBLEM_STATEMENT_ELEMENT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT_ELEMENT__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Problem Statement</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Solution Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT_ELEMENT__SOLUTION_ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Problem Statement Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>Problem Statement Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT_ELEMENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link modelingassistant.impl.UmlElementImpl <em>Uml Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.UmlElementImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getUmlElement()
   * @generated
   */
  int UML_ELEMENT = 4;

  /**
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ELEMENT__MODELING_ASSISTANT = 0;

  /**
   * The feature id for the '<em><b>Solution Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ELEMENT__SOLUTION_ELEMENTS = 1;

  /**
   * The feature id for the '<em><b>Learning Items</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ELEMENT__LEARNING_ITEMS = 2;

  /**
   * The number of structural features of the '<em>Uml Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ELEMENT_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Uml Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link modelingassistant.impl.SolutionImpl <em>Solution</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.SolutionImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getSolution()
   * @generated
   */
  int SOLUTION = 5;

  /**
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__MODELING_ASSISTANT = 0;

  /**
   * The feature id for the '<em><b>Student</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__STUDENT = 1;

  /**
   * The feature id for the '<em><b>Solution Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__SOLUTION_ELEMENTS = 2;

  /**
   * The feature id for the '<em><b>Class Diagram</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__CLASS_DIAGRAM = 3;

  /**
   * The number of structural features of the '<em>Solution</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Solution</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link modelingassistant.impl.SolutionElementImpl <em>Solution Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.SolutionElementImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getSolutionElement()
   * @generated
   */
  int SOLUTION_ELEMENT = 6;

  /**
   * The feature id for the '<em><b>Problem Statement Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_ELEMENT__PROBLEM_STATEMENT_ELEMENTS = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_ELEMENT__TYPE = 1;

  /**
   * The feature id for the '<em><b>Solution</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_ELEMENT__SOLUTION = 2;

  /**
   * The feature id for the '<em><b>Mistakes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_ELEMENT__MISTAKES = 3;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_ELEMENT__ELEMENT = 4;

  /**
   * The number of structural features of the '<em>Solution Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_ELEMENT_FEATURE_COUNT = 5;

  /**
   * The number of operations of the '<em>Solution Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link modelingassistant.impl.LearningItemImpl <em>Learning Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.LearningItemImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getLearningItem()
   * @generated
   */
  int LEARNING_ITEM = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM__MODELING_ASSISTANT = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Uml Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM__UML_ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Learning Resources</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM__LEARNING_RESOURCES = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Mistake Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM__MISTAKE_TYPES = NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_ITEM__DESCRIPTION = NAMED_ELEMENT_FEATURE_COUNT + 4;

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
   * The meta object id for the '{@link modelingassistant.impl.StudentKnowledgeImpl <em>Student Knowledge</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.StudentKnowledgeImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getStudentKnowledge()
   * @generated
   */
  int STUDENT_KNOWLEDGE = 8;

  /**
   * The feature id for the '<em><b>Level Of Knowledge</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT_KNOWLEDGE__LEVEL_OF_KNOWLEDGE = 0;

  /**
   * The feature id for the '<em><b>Student</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT_KNOWLEDGE__STUDENT = 1;

  /**
   * The feature id for the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT_KNOWLEDGE__MISTAKE_TYPE = 2;

  /**
   * The feature id for the '<em><b>Modelingassistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT_KNOWLEDGE__MODELINGASSISTANT = 3;

  /**
   * The number of structural features of the '<em>Student Knowledge</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT_KNOWLEDGE_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Student Knowledge</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT_KNOWLEDGE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link modelingassistant.impl.MistakeTypeImpl <em>Mistake Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.MistakeTypeImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getMistakeType()
   * @generated
   */
  int MISTAKE_TYPE = 9;

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
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE__MODELING_ASSISTANT = NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Learning Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE__LEARNING_ITEM = NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Student Knowledges</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE__STUDENT_KNOWLEDGES = NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Mistakes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE__MISTAKES = NAMED_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Feedbacks</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE__FEEDBACKS = NAMED_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Mistake Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The number of operations of the '<em>Mistake Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_TYPE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link modelingassistant.impl.MistakeImpl <em>Mistake</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.MistakeImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getMistake()
   * @generated
   */
  int MISTAKE = 10;

  /**
   * The feature id for the '<em><b>Resolved</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__RESOLVED = 0;

  /**
   * The feature id for the '<em><b>Time To Address</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__TIME_TO_ADDRESS = 1;

  /**
   * The feature id for the '<em><b>Num Steps Before Notification</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__NUM_STEPS_BEFORE_NOTIFICATION = 2;

  /**
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__MODELING_ASSISTANT = 3;

  /**
   * The feature id for the '<em><b>Mistake Student</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__MISTAKE_STUDENT = 4;

  /**
   * The feature id for the '<em><b>Current Mistake Student</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__CURRENT_MISTAKE_STUDENT = 5;

  /**
   * The feature id for the '<em><b>Solution Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__SOLUTION_ELEMENTS = 6;

  /**
   * The feature id for the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__MISTAKE_TYPE = 7;

  /**
   * The feature id for the '<em><b>Last Feedback</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__LAST_FEEDBACK = 8;

  /**
   * The number of structural features of the '<em>Mistake</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_FEATURE_COUNT = 9;

  /**
   * The number of operations of the '<em>Mistake</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link modelingassistant.impl.FeedbackImpl <em>Feedback</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.FeedbackImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getFeedback()
   * @generated
   */
  int FEEDBACK = 11;

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
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK__MODELING_ASSISTANT = 5;

  /**
   * The feature id for the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK__MISTAKE_TYPE = 6;

  /**
   * The feature id for the '<em><b>Mistakes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK__MISTAKES = 7;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK__TEXT = 8;

  /**
   * The number of structural features of the '<em>Feedback</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK_FEATURE_COUNT = 9;

  /**
   * The number of operations of the '<em>Feedback</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link modelingassistant.impl.TextResponseImpl <em>Text Response</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.TextResponseImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getTextResponse()
   * @generated
   */
  int TEXT_RESPONSE = 12;

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
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE__MODELING_ASSISTANT = FEEDBACK__MODELING_ASSISTANT;

  /**
   * The feature id for the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE__MISTAKE_TYPE = FEEDBACK__MISTAKE_TYPE;

  /**
   * The feature id for the '<em><b>Mistakes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE__MISTAKES = FEEDBACK__MISTAKES;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_RESPONSE__TEXT = FEEDBACK__TEXT;

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
   * The meta object id for the '{@link modelingassistant.impl.ParametrizedResponseImpl <em>Parametrized Response</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.ParametrizedResponseImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getParametrizedResponse()
   * @generated
   */
  int PARAMETRIZED_RESPONSE = 13;

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
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE__MODELING_ASSISTANT = FEEDBACK__MODELING_ASSISTANT;

  /**
   * The feature id for the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE__MISTAKE_TYPE = FEEDBACK__MISTAKE_TYPE;

  /**
   * The feature id for the '<em><b>Mistakes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE__MISTAKES = FEEDBACK__MISTAKES;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETRIZED_RESPONSE__TEXT = FEEDBACK__TEXT;

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
   * The meta object id for the '{@link modelingassistant.impl.ResourceResponseImpl <em>Resource Response</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.ResourceResponseImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getResourceResponse()
   * @generated
   */
  int RESOURCE_RESPONSE = 14;

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
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE__MODELING_ASSISTANT = FEEDBACK__MODELING_ASSISTANT;

  /**
   * The feature id for the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE__MISTAKE_TYPE = FEEDBACK__MISTAKE_TYPE;

  /**
   * The feature id for the '<em><b>Mistakes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE__MISTAKES = FEEDBACK__MISTAKES;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_RESPONSE__TEXT = FEEDBACK__TEXT;

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
   * The meta object id for the '{@link modelingassistant.impl.LearningResourceImpl <em>Learning Resource</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.LearningResourceImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getLearningResource()
   * @generated
   */
  int LEARNING_RESOURCE = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_RESOURCE__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_RESOURCE__MODELING_ASSISTANT = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Learning Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_RESOURCE__LEARNING_ITEM = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Resource Responses</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_RESOURCE__RESOURCE_RESPONSES = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEARNING_RESOURCE__CONTENT = NAMED_ELEMENT_FEATURE_COUNT + 3;

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
   * The meta object id for the '{@link modelingassistant.impl.ReferenceImpl <em>Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.ReferenceImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getReference()
   * @generated
   */
  int REFERENCE = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__NAME = LEARNING_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__MODELING_ASSISTANT = LEARNING_RESOURCE__MODELING_ASSISTANT;

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
   * The meta object id for the '{@link modelingassistant.impl.TutorialImpl <em>Tutorial</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.TutorialImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getTutorial()
   * @generated
   */
  int TUTORIAL = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUTORIAL__NAME = LEARNING_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUTORIAL__MODELING_ASSISTANT = LEARNING_RESOURCE__MODELING_ASSISTANT;

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
   * The meta object id for the '{@link modelingassistant.impl.ExampleImpl <em>Example</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.ExampleImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getExample()
   * @generated
   */
  int EXAMPLE = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXAMPLE__NAME = LEARNING_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXAMPLE__MODELING_ASSISTANT = LEARNING_RESOURCE__MODELING_ASSISTANT;

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
   * The meta object id for the '{@link modelingassistant.impl.QuizImpl <em>Quiz</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.QuizImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getQuiz()
   * @generated
   */
  int QUIZ = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUIZ__NAME = LEARNING_RESOURCE__NAME;

  /**
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUIZ__MODELING_ASSISTANT = LEARNING_RESOURCE__MODELING_ASSISTANT;

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
   * The meta object id for the '<em>int</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getint()
   * @generated
   */
  int INT = 21;

  /**
   * The meta object id for the '<em>boolean</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getboolean()
   * @generated
   */
  int BOOLEAN = 22;

  /**
   * The meta object id for the '<em>Time</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.sql.Time
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getTime()
   * @generated
   */
  int TIME = 23;

  /**
   * The meta object id for the '<em>double</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getdouble()
   * @generated
   */
  int DOUBLE = 24;


  /**
   * Returns the meta object for class '{@link modelingassistant.ModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modeling Assistant</em>'.
   * @see modelingassistant.ModelingAssistant
   * @generated
   */
  EClass getModelingAssistant();

  /**
   * Returns the meta object for the containment reference list '{@link modelingassistant.ModelingAssistant#getLearningItems <em>Learning Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Learning Items</em>'.
   * @see modelingassistant.ModelingAssistant#getLearningItems()
   * @see #getModelingAssistant()
   * @generated
   */
  EReference getModelingAssistant_LearningItems();

  /**
   * Returns the meta object for the containment reference list '{@link modelingassistant.ModelingAssistant#getLearningResources <em>Learning Resources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Learning Resources</em>'.
   * @see modelingassistant.ModelingAssistant#getLearningResources()
   * @see #getModelingAssistant()
   * @generated
   */
  EReference getModelingAssistant_LearningResources();

  /**
   * Returns the meta object for the containment reference list '{@link modelingassistant.ModelingAssistant#getProblemStatements <em>Problem Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Problem Statements</em>'.
   * @see modelingassistant.ModelingAssistant#getProblemStatements()
   * @see #getModelingAssistant()
   * @generated
   */
  EReference getModelingAssistant_ProblemStatements();

  /**
   * Returns the meta object for the containment reference list '{@link modelingassistant.ModelingAssistant#getSolutions <em>Solutions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Solutions</em>'.
   * @see modelingassistant.ModelingAssistant#getSolutions()
   * @see #getModelingAssistant()
   * @generated
   */
  EReference getModelingAssistant_Solutions();

  /**
   * Returns the meta object for the containment reference list '{@link modelingassistant.ModelingAssistant#getUmlElements <em>Uml Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Uml Elements</em>'.
   * @see modelingassistant.ModelingAssistant#getUmlElements()
   * @see #getModelingAssistant()
   * @generated
   */
  EReference getModelingAssistant_UmlElements();

  /**
   * Returns the meta object for the containment reference list '{@link modelingassistant.ModelingAssistant#getStudents <em>Students</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Students</em>'.
   * @see modelingassistant.ModelingAssistant#getStudents()
   * @see #getModelingAssistant()
   * @generated
   */
  EReference getModelingAssistant_Students();

  /**
   * Returns the meta object for the containment reference list '{@link modelingassistant.ModelingAssistant#getFeedbacks <em>Feedbacks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Feedbacks</em>'.
   * @see modelingassistant.ModelingAssistant#getFeedbacks()
   * @see #getModelingAssistant()
   * @generated
   */
  EReference getModelingAssistant_Feedbacks();

  /**
   * Returns the meta object for the containment reference list '{@link modelingassistant.ModelingAssistant#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mistakes</em>'.
   * @see modelingassistant.ModelingAssistant#getMistakes()
   * @see #getModelingAssistant()
   * @generated
   */
  EReference getModelingAssistant_Mistakes();

  /**
   * Returns the meta object for the containment reference list '{@link modelingassistant.ModelingAssistant#getMistakeTypes <em>Mistake Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mistake Types</em>'.
   * @see modelingassistant.ModelingAssistant#getMistakeTypes()
   * @see #getModelingAssistant()
   * @generated
   */
  EReference getModelingAssistant_MistakeTypes();

  /**
   * Returns the meta object for the containment reference list '{@link modelingassistant.ModelingAssistant#getStudentknowledge <em>Studentknowledge</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Studentknowledge</em>'.
   * @see modelingassistant.ModelingAssistant#getStudentknowledge()
   * @see #getModelingAssistant()
   * @generated
   */
  EReference getModelingAssistant_Studentknowledge();

  /**
   * Returns the meta object for class '{@link modelingassistant.Student <em>Student</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Student</em>'.
   * @see modelingassistant.Student
   * @generated
   */
  EClass getStudent();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.Student#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see modelingassistant.Student#getId()
   * @see #getStudent()
   * @generated
   */
  EAttribute getStudent_Id();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.Student#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Modeling Assistant</em>'.
   * @see modelingassistant.Student#getModelingAssistant()
   * @see #getStudent()
   * @generated
   */
  EReference getStudent_ModelingAssistant();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.Student#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Mistakes</em>'.
   * @see modelingassistant.Student#getMistakes()
   * @see #getStudent()
   * @generated
   */
  EReference getStudent_Mistakes();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.Student#getCurrentMistake <em>Current Mistake</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Current Mistake</em>'.
   * @see modelingassistant.Student#getCurrentMistake()
   * @see #getStudent()
   * @generated
   */
  EReference getStudent_CurrentMistake();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.Student#getSolutions <em>Solutions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Solutions</em>'.
   * @see modelingassistant.Student#getSolutions()
   * @see #getStudent()
   * @generated
   */
  EReference getStudent_Solutions();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.Student#getStudentKnowledges <em>Student Knowledges</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Student Knowledges</em>'.
   * @see modelingassistant.Student#getStudentKnowledges()
   * @see #getStudent()
   * @generated
   */
  EReference getStudent_StudentKnowledges();

  /**
   * Returns the meta object for class '{@link modelingassistant.ProblemStatement <em>Problem Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Problem Statement</em>'.
   * @see modelingassistant.ProblemStatement
   * @generated
   */
  EClass getProblemStatement();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.ProblemStatement#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Modeling Assistant</em>'.
   * @see modelingassistant.ProblemStatement#getModelingAssistant()
   * @see #getProblemStatement()
   * @generated
   */
  EReference getProblemStatement_ModelingAssistant();

  /**
   * Returns the meta object for the containment reference list '{@link modelingassistant.ProblemStatement#getProblemStatementElements <em>Problem Statement Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Problem Statement Elements</em>'.
   * @see modelingassistant.ProblemStatement#getProblemStatementElements()
   * @see #getProblemStatement()
   * @generated
   */
  EReference getProblemStatement_ProblemStatementElements();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.ProblemStatement#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see modelingassistant.ProblemStatement#getText()
   * @see #getProblemStatement()
   * @generated
   */
  EAttribute getProblemStatement_Text();

  /**
   * Returns the meta object for class '{@link modelingassistant.ProblemStatementElement <em>Problem Statement Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Problem Statement Element</em>'.
   * @see modelingassistant.ProblemStatementElement
   * @generated
   */
  EClass getProblemStatementElement();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.ProblemStatementElement#getProblemStatement <em>Problem Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Problem Statement</em>'.
   * @see modelingassistant.ProblemStatementElement#getProblemStatement()
   * @see #getProblemStatementElement()
   * @generated
   */
  EReference getProblemStatementElement_ProblemStatement();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.ProblemStatementElement#getSolutionElements <em>Solution Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Solution Elements</em>'.
   * @see modelingassistant.ProblemStatementElement#getSolutionElements()
   * @see #getProblemStatementElement()
   * @generated
   */
  EReference getProblemStatementElement_SolutionElements();

  /**
   * Returns the meta object for class '{@link modelingassistant.UmlElement <em>Uml Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Uml Element</em>'.
   * @see modelingassistant.UmlElement
   * @generated
   */
  EClass getUmlElement();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.UmlElement#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Modeling Assistant</em>'.
   * @see modelingassistant.UmlElement#getModelingAssistant()
   * @see #getUmlElement()
   * @generated
   */
  EReference getUmlElement_ModelingAssistant();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.UmlElement#getSolutionElements <em>Solution Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Solution Elements</em>'.
   * @see modelingassistant.UmlElement#getSolutionElements()
   * @see #getUmlElement()
   * @generated
   */
  EReference getUmlElement_SolutionElements();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.UmlElement#getLearningItems <em>Learning Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Learning Items</em>'.
   * @see modelingassistant.UmlElement#getLearningItems()
   * @see #getUmlElement()
   * @generated
   */
  EReference getUmlElement_LearningItems();

  /**
   * Returns the meta object for class '{@link modelingassistant.Solution <em>Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Solution</em>'.
   * @see modelingassistant.Solution
   * @generated
   */
  EClass getSolution();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.Solution#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Modeling Assistant</em>'.
   * @see modelingassistant.Solution#getModelingAssistant()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_ModelingAssistant();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.Solution#getStudent <em>Student</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Student</em>'.
   * @see modelingassistant.Solution#getStudent()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_Student();

  /**
   * Returns the meta object for the containment reference list '{@link modelingassistant.Solution#getSolutionElements <em>Solution Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Solution Elements</em>'.
   * @see modelingassistant.Solution#getSolutionElements()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_SolutionElements();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.Solution#getClassDiagram <em>Class Diagram</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Class Diagram</em>'.
   * @see modelingassistant.Solution#getClassDiagram()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_ClassDiagram();

  /**
   * Returns the meta object for class '{@link modelingassistant.SolutionElement <em>Solution Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Solution Element</em>'.
   * @see modelingassistant.SolutionElement
   * @generated
   */
  EClass getSolutionElement();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.SolutionElement#getProblemStatementElements <em>Problem Statement Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Problem Statement Elements</em>'.
   * @see modelingassistant.SolutionElement#getProblemStatementElements()
   * @see #getSolutionElement()
   * @generated
   */
  EReference getSolutionElement_ProblemStatementElements();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.SolutionElement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see modelingassistant.SolutionElement#getType()
   * @see #getSolutionElement()
   * @generated
   */
  EReference getSolutionElement_Type();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.SolutionElement#getSolution <em>Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Solution</em>'.
   * @see modelingassistant.SolutionElement#getSolution()
   * @see #getSolutionElement()
   * @generated
   */
  EReference getSolutionElement_Solution();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.SolutionElement#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Mistakes</em>'.
   * @see modelingassistant.SolutionElement#getMistakes()
   * @see #getSolutionElement()
   * @generated
   */
  EReference getSolutionElement_Mistakes();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.SolutionElement#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Element</em>'.
   * @see modelingassistant.SolutionElement#getElement()
   * @see #getSolutionElement()
   * @generated
   */
  EReference getSolutionElement_Element();

  /**
   * Returns the meta object for class '{@link modelingassistant.LearningItem <em>Learning Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Learning Item</em>'.
   * @see modelingassistant.LearningItem
   * @generated
   */
  EClass getLearningItem();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.LearningItem#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Modeling Assistant</em>'.
   * @see modelingassistant.LearningItem#getModelingAssistant()
   * @see #getLearningItem()
   * @generated
   */
  EReference getLearningItem_ModelingAssistant();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.LearningItem#getUmlElements <em>Uml Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Uml Elements</em>'.
   * @see modelingassistant.LearningItem#getUmlElements()
   * @see #getLearningItem()
   * @generated
   */
  EReference getLearningItem_UmlElements();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.LearningItem#getLearningResources <em>Learning Resources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Learning Resources</em>'.
   * @see modelingassistant.LearningItem#getLearningResources()
   * @see #getLearningItem()
   * @generated
   */
  EReference getLearningItem_LearningResources();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.LearningItem#getMistakeTypes <em>Mistake Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Mistake Types</em>'.
   * @see modelingassistant.LearningItem#getMistakeTypes()
   * @see #getLearningItem()
   * @generated
   */
  EReference getLearningItem_MistakeTypes();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.LearningItem#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see modelingassistant.LearningItem#getDescription()
   * @see #getLearningItem()
   * @generated
   */
  EAttribute getLearningItem_Description();

  /**
   * Returns the meta object for class '{@link modelingassistant.StudentKnowledge <em>Student Knowledge</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Student Knowledge</em>'.
   * @see modelingassistant.StudentKnowledge
   * @generated
   */
  EClass getStudentKnowledge();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.StudentKnowledge#getLevelOfKnowledge <em>Level Of Knowledge</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Level Of Knowledge</em>'.
   * @see modelingassistant.StudentKnowledge#getLevelOfKnowledge()
   * @see #getStudentKnowledge()
   * @generated
   */
  EAttribute getStudentKnowledge_LevelOfKnowledge();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.StudentKnowledge#getStudent <em>Student</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Student</em>'.
   * @see modelingassistant.StudentKnowledge#getStudent()
   * @see #getStudentKnowledge()
   * @generated
   */
  EReference getStudentKnowledge_Student();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.StudentKnowledge#getMistakeType <em>Mistake Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Mistake Type</em>'.
   * @see modelingassistant.StudentKnowledge#getMistakeType()
   * @see #getStudentKnowledge()
   * @generated
   */
  EReference getStudentKnowledge_MistakeType();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.StudentKnowledge#getModelingassistant <em>Modelingassistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Modelingassistant</em>'.
   * @see modelingassistant.StudentKnowledge#getModelingassistant()
   * @see #getStudentKnowledge()
   * @generated
   */
  EReference getStudentKnowledge_Modelingassistant();

  /**
   * Returns the meta object for class '{@link modelingassistant.MistakeType <em>Mistake Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mistake Type</em>'.
   * @see modelingassistant.MistakeType
   * @generated
   */
  EClass getMistakeType();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.MistakeType#isAtomic <em>Atomic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Atomic</em>'.
   * @see modelingassistant.MistakeType#isAtomic()
   * @see #getMistakeType()
   * @generated
   */
  EAttribute getMistakeType_Atomic();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.MistakeType#getTimeToAddress <em>Time To Address</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Time To Address</em>'.
   * @see modelingassistant.MistakeType#getTimeToAddress()
   * @see #getMistakeType()
   * @generated
   */
  EAttribute getMistakeType_TimeToAddress();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.MistakeType#getNumStepsBeforeNotification <em>Num Steps Before Notification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Num Steps Before Notification</em>'.
   * @see modelingassistant.MistakeType#getNumStepsBeforeNotification()
   * @see #getMistakeType()
   * @generated
   */
  EAttribute getMistakeType_NumStepsBeforeNotification();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.MistakeType#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Modeling Assistant</em>'.
   * @see modelingassistant.MistakeType#getModelingAssistant()
   * @see #getMistakeType()
   * @generated
   */
  EReference getMistakeType_ModelingAssistant();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.MistakeType#getLearningItem <em>Learning Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Learning Item</em>'.
   * @see modelingassistant.MistakeType#getLearningItem()
   * @see #getMistakeType()
   * @generated
   */
  EReference getMistakeType_LearningItem();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.MistakeType#getStudentKnowledges <em>Student Knowledges</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Student Knowledges</em>'.
   * @see modelingassistant.MistakeType#getStudentKnowledges()
   * @see #getMistakeType()
   * @generated
   */
  EReference getMistakeType_StudentKnowledges();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.MistakeType#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Mistakes</em>'.
   * @see modelingassistant.MistakeType#getMistakes()
   * @see #getMistakeType()
   * @generated
   */
  EReference getMistakeType_Mistakes();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.MistakeType#getFeedbacks <em>Feedbacks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Feedbacks</em>'.
   * @see modelingassistant.MistakeType#getFeedbacks()
   * @see #getMistakeType()
   * @generated
   */
  EReference getMistakeType_Feedbacks();

  /**
   * Returns the meta object for class '{@link modelingassistant.Mistake <em>Mistake</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mistake</em>'.
   * @see modelingassistant.Mistake
   * @generated
   */
  EClass getMistake();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.Mistake#isResolved <em>Resolved</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Resolved</em>'.
   * @see modelingassistant.Mistake#isResolved()
   * @see #getMistake()
   * @generated
   */
  EAttribute getMistake_Resolved();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.Mistake#getTimeToAddress <em>Time To Address</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Time To Address</em>'.
   * @see modelingassistant.Mistake#getTimeToAddress()
   * @see #getMistake()
   * @generated
   */
  EAttribute getMistake_TimeToAddress();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.Mistake#getNumStepsBeforeNotification <em>Num Steps Before Notification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Num Steps Before Notification</em>'.
   * @see modelingassistant.Mistake#getNumStepsBeforeNotification()
   * @see #getMistake()
   * @generated
   */
  EAttribute getMistake_NumStepsBeforeNotification();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.Mistake#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Modeling Assistant</em>'.
   * @see modelingassistant.Mistake#getModelingAssistant()
   * @see #getMistake()
   * @generated
   */
  EReference getMistake_ModelingAssistant();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.Mistake#getMistakeStudent <em>Mistake Student</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Mistake Student</em>'.
   * @see modelingassistant.Mistake#getMistakeStudent()
   * @see #getMistake()
   * @generated
   */
  EReference getMistake_MistakeStudent();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.Mistake#getCurrentMistakeStudent <em>Current Mistake Student</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Current Mistake Student</em>'.
   * @see modelingassistant.Mistake#getCurrentMistakeStudent()
   * @see #getMistake()
   * @generated
   */
  EReference getMistake_CurrentMistakeStudent();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.Mistake#getSolutionElements <em>Solution Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Solution Elements</em>'.
   * @see modelingassistant.Mistake#getSolutionElements()
   * @see #getMistake()
   * @generated
   */
  EReference getMistake_SolutionElements();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.Mistake#getMistakeType <em>Mistake Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Mistake Type</em>'.
   * @see modelingassistant.Mistake#getMistakeType()
   * @see #getMistake()
   * @generated
   */
  EReference getMistake_MistakeType();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.Mistake#getLastFeedback <em>Last Feedback</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Last Feedback</em>'.
   * @see modelingassistant.Mistake#getLastFeedback()
   * @see #getMistake()
   * @generated
   */
  EReference getMistake_LastFeedback();

  /**
   * Returns the meta object for class '{@link modelingassistant.Feedback <em>Feedback</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feedback</em>'.
   * @see modelingassistant.Feedback
   * @generated
   */
  EClass getFeedback();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.Feedback#getLevel <em>Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Level</em>'.
   * @see modelingassistant.Feedback#getLevel()
   * @see #getFeedback()
   * @generated
   */
  EAttribute getFeedback_Level();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.Feedback#isCongratulatory <em>Congratulatory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Congratulatory</em>'.
   * @see modelingassistant.Feedback#isCongratulatory()
   * @see #getFeedback()
   * @generated
   */
  EAttribute getFeedback_Congratulatory();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.Feedback#getUsefulness <em>Usefulness</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Usefulness</em>'.
   * @see modelingassistant.Feedback#getUsefulness()
   * @see #getFeedback()
   * @generated
   */
  EAttribute getFeedback_Usefulness();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.Feedback#isHighlightProblem <em>Highlight Problem</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Highlight Problem</em>'.
   * @see modelingassistant.Feedback#isHighlightProblem()
   * @see #getFeedback()
   * @generated
   */
  EAttribute getFeedback_HighlightProblem();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.Feedback#isHighlightSolution <em>Highlight Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Highlight Solution</em>'.
   * @see modelingassistant.Feedback#isHighlightSolution()
   * @see #getFeedback()
   * @generated
   */
  EAttribute getFeedback_HighlightSolution();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.Feedback#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Modeling Assistant</em>'.
   * @see modelingassistant.Feedback#getModelingAssistant()
   * @see #getFeedback()
   * @generated
   */
  EReference getFeedback_ModelingAssistant();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.Feedback#getMistakeType <em>Mistake Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Mistake Type</em>'.
   * @see modelingassistant.Feedback#getMistakeType()
   * @see #getFeedback()
   * @generated
   */
  EReference getFeedback_MistakeType();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.Feedback#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Mistakes</em>'.
   * @see modelingassistant.Feedback#getMistakes()
   * @see #getFeedback()
   * @generated
   */
  EReference getFeedback_Mistakes();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.Feedback#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see modelingassistant.Feedback#getText()
   * @see #getFeedback()
   * @generated
   */
  EAttribute getFeedback_Text();

  /**
   * Returns the meta object for class '{@link modelingassistant.TextResponse <em>Text Response</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Text Response</em>'.
   * @see modelingassistant.TextResponse
   * @generated
   */
  EClass getTextResponse();

  /**
   * Returns the meta object for class '{@link modelingassistant.ParametrizedResponse <em>Parametrized Response</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parametrized Response</em>'.
   * @see modelingassistant.ParametrizedResponse
   * @generated
   */
  EClass getParametrizedResponse();

  /**
   * Returns the meta object for class '{@link modelingassistant.ResourceResponse <em>Resource Response</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Resource Response</em>'.
   * @see modelingassistant.ResourceResponse
   * @generated
   */
  EClass getResourceResponse();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.ResourceResponse#getLearningResources <em>Learning Resources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Learning Resources</em>'.
   * @see modelingassistant.ResourceResponse#getLearningResources()
   * @see #getResourceResponse()
   * @generated
   */
  EReference getResourceResponse_LearningResources();

  /**
   * Returns the meta object for class '{@link modelingassistant.LearningResource <em>Learning Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Learning Resource</em>'.
   * @see modelingassistant.LearningResource
   * @generated
   */
  EClass getLearningResource();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.LearningResource#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Modeling Assistant</em>'.
   * @see modelingassistant.LearningResource#getModelingAssistant()
   * @see #getLearningResource()
   * @generated
   */
  EReference getLearningResource_ModelingAssistant();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.LearningResource#getLearningItem <em>Learning Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Learning Item</em>'.
   * @see modelingassistant.LearningResource#getLearningItem()
   * @see #getLearningResource()
   * @generated
   */
  EReference getLearningResource_LearningItem();

  /**
   * Returns the meta object for the reference list '{@link modelingassistant.LearningResource#getResourceResponses <em>Resource Responses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Resource Responses</em>'.
   * @see modelingassistant.LearningResource#getResourceResponses()
   * @see #getLearningResource()
   * @generated
   */
  EReference getLearningResource_ResourceResponses();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.LearningResource#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content</em>'.
   * @see modelingassistant.LearningResource#getContent()
   * @see #getLearningResource()
   * @generated
   */
  EAttribute getLearningResource_Content();

  /**
   * Returns the meta object for class '{@link modelingassistant.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference</em>'.
   * @see modelingassistant.Reference
   * @generated
   */
  EClass getReference();

  /**
   * Returns the meta object for class '{@link modelingassistant.Tutorial <em>Tutorial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tutorial</em>'.
   * @see modelingassistant.Tutorial
   * @generated
   */
  EClass getTutorial();

  /**
   * Returns the meta object for class '{@link modelingassistant.Example <em>Example</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Example</em>'.
   * @see modelingassistant.Example
   * @generated
   */
  EClass getExample();

  /**
   * Returns the meta object for class '{@link modelingassistant.Quiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quiz</em>'.
   * @see modelingassistant.Quiz
   * @generated
   */
  EClass getQuiz();

  /**
   * Returns the meta object for class '{@link modelingassistant.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Element</em>'.
   * @see modelingassistant.NamedElement
   * @generated
   */
  EClass getNamedElement();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.NamedElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see modelingassistant.NamedElement#getName()
   * @see #getNamedElement()
   * @generated
   */
  EAttribute getNamedElement_Name();

  /**
   * Returns the meta object for data type '<em>int</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>int</em>'.
   * @model instanceClass="int"
   * @generated
   */
  EDataType getint();

  /**
   * Returns the meta object for data type '<em>boolean</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>boolean</em>'.
   * @model instanceClass="boolean"
   * @generated
   */
  EDataType getboolean();

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
   * Returns the meta object for data type '<em>double</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>double</em>'.
   * @model instanceClass="double"
   * @generated
   */
  EDataType getdouble();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ModelingassistantFactory getModelingassistantFactory();

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
     * The meta object literal for the '{@link modelingassistant.impl.ModelingAssistantImpl <em>Modeling Assistant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.ModelingAssistantImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getModelingAssistant()
     * @generated
     */
    EClass MODELING_ASSISTANT = eINSTANCE.getModelingAssistant();

    /**
     * The meta object literal for the '<em><b>Learning Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODELING_ASSISTANT__LEARNING_ITEMS = eINSTANCE.getModelingAssistant_LearningItems();

    /**
     * The meta object literal for the '<em><b>Learning Resources</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODELING_ASSISTANT__LEARNING_RESOURCES = eINSTANCE.getModelingAssistant_LearningResources();

    /**
     * The meta object literal for the '<em><b>Problem Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODELING_ASSISTANT__PROBLEM_STATEMENTS = eINSTANCE.getModelingAssistant_ProblemStatements();

    /**
     * The meta object literal for the '<em><b>Solutions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODELING_ASSISTANT__SOLUTIONS = eINSTANCE.getModelingAssistant_Solutions();

    /**
     * The meta object literal for the '<em><b>Uml Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODELING_ASSISTANT__UML_ELEMENTS = eINSTANCE.getModelingAssistant_UmlElements();

    /**
     * The meta object literal for the '<em><b>Students</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODELING_ASSISTANT__STUDENTS = eINSTANCE.getModelingAssistant_Students();

    /**
     * The meta object literal for the '<em><b>Feedbacks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODELING_ASSISTANT__FEEDBACKS = eINSTANCE.getModelingAssistant_Feedbacks();

    /**
     * The meta object literal for the '<em><b>Mistakes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODELING_ASSISTANT__MISTAKES = eINSTANCE.getModelingAssistant_Mistakes();

    /**
     * The meta object literal for the '<em><b>Mistake Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODELING_ASSISTANT__MISTAKE_TYPES = eINSTANCE.getModelingAssistant_MistakeTypes();

    /**
     * The meta object literal for the '<em><b>Studentknowledge</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODELING_ASSISTANT__STUDENTKNOWLEDGE = eINSTANCE.getModelingAssistant_Studentknowledge();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.StudentImpl <em>Student</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.StudentImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getStudent()
     * @generated
     */
    EClass STUDENT = eINSTANCE.getStudent();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STUDENT__ID = eINSTANCE.getStudent_Id();

    /**
     * The meta object literal for the '<em><b>Modeling Assistant</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STUDENT__MODELING_ASSISTANT = eINSTANCE.getStudent_ModelingAssistant();

    /**
     * The meta object literal for the '<em><b>Mistakes</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STUDENT__MISTAKES = eINSTANCE.getStudent_Mistakes();

    /**
     * The meta object literal for the '<em><b>Current Mistake</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STUDENT__CURRENT_MISTAKE = eINSTANCE.getStudent_CurrentMistake();

    /**
     * The meta object literal for the '<em><b>Solutions</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STUDENT__SOLUTIONS = eINSTANCE.getStudent_Solutions();

    /**
     * The meta object literal for the '<em><b>Student Knowledges</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STUDENT__STUDENT_KNOWLEDGES = eINSTANCE.getStudent_StudentKnowledges();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.ProblemStatementImpl <em>Problem Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.ProblemStatementImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getProblemStatement()
     * @generated
     */
    EClass PROBLEM_STATEMENT = eINSTANCE.getProblemStatement();

    /**
     * The meta object literal for the '<em><b>Modeling Assistant</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROBLEM_STATEMENT__MODELING_ASSISTANT = eINSTANCE.getProblemStatement_ModelingAssistant();

    /**
     * The meta object literal for the '<em><b>Problem Statement Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROBLEM_STATEMENT__PROBLEM_STATEMENT_ELEMENTS = eINSTANCE.getProblemStatement_ProblemStatementElements();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROBLEM_STATEMENT__TEXT = eINSTANCE.getProblemStatement_Text();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.ProblemStatementElementImpl <em>Problem Statement Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.ProblemStatementElementImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getProblemStatementElement()
     * @generated
     */
    EClass PROBLEM_STATEMENT_ELEMENT = eINSTANCE.getProblemStatementElement();

    /**
     * The meta object literal for the '<em><b>Problem Statement</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROBLEM_STATEMENT_ELEMENT__PROBLEM_STATEMENT = eINSTANCE.getProblemStatementElement_ProblemStatement();

    /**
     * The meta object literal for the '<em><b>Solution Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROBLEM_STATEMENT_ELEMENT__SOLUTION_ELEMENTS = eINSTANCE.getProblemStatementElement_SolutionElements();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.UmlElementImpl <em>Uml Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.UmlElementImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getUmlElement()
     * @generated
     */
    EClass UML_ELEMENT = eINSTANCE.getUmlElement();

    /**
     * The meta object literal for the '<em><b>Modeling Assistant</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ELEMENT__MODELING_ASSISTANT = eINSTANCE.getUmlElement_ModelingAssistant();

    /**
     * The meta object literal for the '<em><b>Solution Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ELEMENT__SOLUTION_ELEMENTS = eINSTANCE.getUmlElement_SolutionElements();

    /**
     * The meta object literal for the '<em><b>Learning Items</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ELEMENT__LEARNING_ITEMS = eINSTANCE.getUmlElement_LearningItems();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.SolutionImpl <em>Solution</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.SolutionImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getSolution()
     * @generated
     */
    EClass SOLUTION = eINSTANCE.getSolution();

    /**
     * The meta object literal for the '<em><b>Modeling Assistant</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__MODELING_ASSISTANT = eINSTANCE.getSolution_ModelingAssistant();

    /**
     * The meta object literal for the '<em><b>Student</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__STUDENT = eINSTANCE.getSolution_Student();

    /**
     * The meta object literal for the '<em><b>Solution Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__SOLUTION_ELEMENTS = eINSTANCE.getSolution_SolutionElements();

    /**
     * The meta object literal for the '<em><b>Class Diagram</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__CLASS_DIAGRAM = eINSTANCE.getSolution_ClassDiagram();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.SolutionElementImpl <em>Solution Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.SolutionElementImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getSolutionElement()
     * @generated
     */
    EClass SOLUTION_ELEMENT = eINSTANCE.getSolutionElement();

    /**
     * The meta object literal for the '<em><b>Problem Statement Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION_ELEMENT__PROBLEM_STATEMENT_ELEMENTS = eINSTANCE.getSolutionElement_ProblemStatementElements();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION_ELEMENT__TYPE = eINSTANCE.getSolutionElement_Type();

    /**
     * The meta object literal for the '<em><b>Solution</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION_ELEMENT__SOLUTION = eINSTANCE.getSolutionElement_Solution();

    /**
     * The meta object literal for the '<em><b>Mistakes</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION_ELEMENT__MISTAKES = eINSTANCE.getSolutionElement_Mistakes();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION_ELEMENT__ELEMENT = eINSTANCE.getSolutionElement_Element();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.LearningItemImpl <em>Learning Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.LearningItemImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getLearningItem()
     * @generated
     */
    EClass LEARNING_ITEM = eINSTANCE.getLearningItem();

    /**
     * The meta object literal for the '<em><b>Modeling Assistant</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_ITEM__MODELING_ASSISTANT = eINSTANCE.getLearningItem_ModelingAssistant();

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
     * The meta object literal for the '{@link modelingassistant.impl.StudentKnowledgeImpl <em>Student Knowledge</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.StudentKnowledgeImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getStudentKnowledge()
     * @generated
     */
    EClass STUDENT_KNOWLEDGE = eINSTANCE.getStudentKnowledge();

    /**
     * The meta object literal for the '<em><b>Level Of Knowledge</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STUDENT_KNOWLEDGE__LEVEL_OF_KNOWLEDGE = eINSTANCE.getStudentKnowledge_LevelOfKnowledge();

    /**
     * The meta object literal for the '<em><b>Student</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STUDENT_KNOWLEDGE__STUDENT = eINSTANCE.getStudentKnowledge_Student();

    /**
     * The meta object literal for the '<em><b>Mistake Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STUDENT_KNOWLEDGE__MISTAKE_TYPE = eINSTANCE.getStudentKnowledge_MistakeType();

    /**
     * The meta object literal for the '<em><b>Modelingassistant</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STUDENT_KNOWLEDGE__MODELINGASSISTANT = eINSTANCE.getStudentKnowledge_Modelingassistant();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.MistakeTypeImpl <em>Mistake Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.MistakeTypeImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getMistakeType()
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
     * The meta object literal for the '<em><b>Modeling Assistant</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE_TYPE__MODELING_ASSISTANT = eINSTANCE.getMistakeType_ModelingAssistant();

    /**
     * The meta object literal for the '<em><b>Learning Item</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE_TYPE__LEARNING_ITEM = eINSTANCE.getMistakeType_LearningItem();

    /**
     * The meta object literal for the '<em><b>Student Knowledges</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE_TYPE__STUDENT_KNOWLEDGES = eINSTANCE.getMistakeType_StudentKnowledges();

    /**
     * The meta object literal for the '<em><b>Mistakes</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE_TYPE__MISTAKES = eINSTANCE.getMistakeType_Mistakes();

    /**
     * The meta object literal for the '<em><b>Feedbacks</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE_TYPE__FEEDBACKS = eINSTANCE.getMistakeType_Feedbacks();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.MistakeImpl <em>Mistake</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.MistakeImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getMistake()
     * @generated
     */
    EClass MISTAKE = eINSTANCE.getMistake();

    /**
     * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MISTAKE__RESOLVED = eINSTANCE.getMistake_Resolved();

    /**
     * The meta object literal for the '<em><b>Time To Address</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MISTAKE__TIME_TO_ADDRESS = eINSTANCE.getMistake_TimeToAddress();

    /**
     * The meta object literal for the '<em><b>Num Steps Before Notification</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MISTAKE__NUM_STEPS_BEFORE_NOTIFICATION = eINSTANCE.getMistake_NumStepsBeforeNotification();

    /**
     * The meta object literal for the '<em><b>Modeling Assistant</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE__MODELING_ASSISTANT = eINSTANCE.getMistake_ModelingAssistant();

    /**
     * The meta object literal for the '<em><b>Mistake Student</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE__MISTAKE_STUDENT = eINSTANCE.getMistake_MistakeStudent();

    /**
     * The meta object literal for the '<em><b>Current Mistake Student</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE__CURRENT_MISTAKE_STUDENT = eINSTANCE.getMistake_CurrentMistakeStudent();

    /**
     * The meta object literal for the '<em><b>Solution Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE__SOLUTION_ELEMENTS = eINSTANCE.getMistake_SolutionElements();

    /**
     * The meta object literal for the '<em><b>Mistake Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE__MISTAKE_TYPE = eINSTANCE.getMistake_MistakeType();

    /**
     * The meta object literal for the '<em><b>Last Feedback</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE__LAST_FEEDBACK = eINSTANCE.getMistake_LastFeedback();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.FeedbackImpl <em>Feedback</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.FeedbackImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getFeedback()
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
     * The meta object literal for the '<em><b>Modeling Assistant</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEEDBACK__MODELING_ASSISTANT = eINSTANCE.getFeedback_ModelingAssistant();

    /**
     * The meta object literal for the '<em><b>Mistake Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEEDBACK__MISTAKE_TYPE = eINSTANCE.getFeedback_MistakeType();

    /**
     * The meta object literal for the '<em><b>Mistakes</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEEDBACK__MISTAKES = eINSTANCE.getFeedback_Mistakes();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEEDBACK__TEXT = eINSTANCE.getFeedback_Text();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.TextResponseImpl <em>Text Response</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.TextResponseImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getTextResponse()
     * @generated
     */
    EClass TEXT_RESPONSE = eINSTANCE.getTextResponse();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.ParametrizedResponseImpl <em>Parametrized Response</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.ParametrizedResponseImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getParametrizedResponse()
     * @generated
     */
    EClass PARAMETRIZED_RESPONSE = eINSTANCE.getParametrizedResponse();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.ResourceResponseImpl <em>Resource Response</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.ResourceResponseImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getResourceResponse()
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
     * The meta object literal for the '{@link modelingassistant.impl.LearningResourceImpl <em>Learning Resource</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.LearningResourceImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getLearningResource()
     * @generated
     */
    EClass LEARNING_RESOURCE = eINSTANCE.getLearningResource();

    /**
     * The meta object literal for the '<em><b>Modeling Assistant</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEARNING_RESOURCE__MODELING_ASSISTANT = eINSTANCE.getLearningResource_ModelingAssistant();

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
     * The meta object literal for the '{@link modelingassistant.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.ReferenceImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getReference()
     * @generated
     */
    EClass REFERENCE = eINSTANCE.getReference();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.TutorialImpl <em>Tutorial</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.TutorialImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getTutorial()
     * @generated
     */
    EClass TUTORIAL = eINSTANCE.getTutorial();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.ExampleImpl <em>Example</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.ExampleImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getExample()
     * @generated
     */
    EClass EXAMPLE = eINSTANCE.getExample();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.QuizImpl <em>Quiz</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.QuizImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getQuiz()
     * @generated
     */
    EClass QUIZ = eINSTANCE.getQuiz();

    /**
     * The meta object literal for the '{@link modelingassistant.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.NamedElementImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getNamedElement()
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
     * The meta object literal for the '<em>int</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getint()
     * @generated
     */
    EDataType INT = eINSTANCE.getint();

    /**
     * The meta object literal for the '<em>boolean</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getboolean()
     * @generated
     */
    EDataType BOOLEAN = eINSTANCE.getboolean();

    /**
     * The meta object literal for the '<em>Time</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.sql.Time
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getTime()
     * @generated
     */
    EDataType TIME = eINSTANCE.getTime();

    /**
     * The meta object literal for the '<em>double</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getdouble()
     * @generated
     */
    EDataType DOUBLE = eINSTANCE.getdouble();

  }

} //ModelingassistantPackage
