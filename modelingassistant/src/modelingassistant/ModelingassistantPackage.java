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
   * The feature id for the '<em><b>Problem Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__PROBLEM_STATEMENTS = 0;

  /**
   * The feature id for the '<em><b>Solutions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__SOLUTIONS = 1;

  /**
   * The feature id for the '<em><b>Students</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__STUDENTS = 2;

  /**
   * The feature id for the '<em><b>Student Knowledges</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__STUDENT_KNOWLEDGES = 3;

  /**
   * The feature id for the '<em><b>Feedback Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT__FEEDBACK_ITEMS = 4;

  /**
   * The number of structural features of the '<em>Modeling Assistant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODELING_ASSISTANT_FEATURE_COUNT = 5;

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
  int NAMED_ELEMENT = 8;

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
   * The feature id for the '<em><b>Solutions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT__SOLUTIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Student Knowledges</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT__STUDENT_KNOWLEDGES = NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Current Solution</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT__CURRENT_SOLUTION = NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Student</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

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
   * The feature id for the '<em><b>Student Solution</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT__STUDENT_SOLUTION = NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Instructor Solution</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION = NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Problem Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBLEM_STATEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

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
   * The meta object id for the '{@link modelingassistant.impl.SolutionImpl <em>Solution</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.SolutionImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getSolution()
   * @generated
   */
  int SOLUTION = 4;

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
   * The feature id for the '<em><b>Mistakes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__MISTAKES = 4;

  /**
   * The feature id for the '<em><b>Current Mistake</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__CURRENT_MISTAKE = 5;

  /**
   * The feature id for the '<em><b>Student Problem Statement</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__STUDENT_PROBLEM_STATEMENT = 6;

  /**
   * The feature id for the '<em><b>Instructor Problem Statement</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__INSTRUCTOR_PROBLEM_STATEMENT = 7;

  /**
   * The number of structural features of the '<em>Solution</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_FEATURE_COUNT = 8;

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
  int SOLUTION_ELEMENT = 5;

  /**
   * The feature id for the '<em><b>Problem Statement Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_ELEMENT__PROBLEM_STATEMENT_ELEMENTS = 0;

  /**
   * The feature id for the '<em><b>Solution</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_ELEMENT__SOLUTION = 1;

  /**
   * The feature id for the '<em><b>Student Element Mistakes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_ELEMENT__STUDENT_ELEMENT_MISTAKES = 2;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_ELEMENT__ELEMENT = 3;

  /**
   * The feature id for the '<em><b>Instructor Element Mistakes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_ELEMENT__INSTRUCTOR_ELEMENT_MISTAKES = 4;

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
   * The meta object id for the '{@link modelingassistant.impl.StudentKnowledgeImpl <em>Student Knowledge</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.StudentKnowledgeImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getStudentKnowledge()
   * @generated
   */
  int STUDENT_KNOWLEDGE = 6;

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
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT_KNOWLEDGE__MODELING_ASSISTANT = 2;

  /**
   * The feature id for the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUDENT_KNOWLEDGE__MISTAKE_TYPE = 3;

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
   * The meta object id for the '{@link modelingassistant.impl.MistakeImpl <em>Mistake</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.MistakeImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getMistake()
   * @generated
   */
  int MISTAKE = 7;

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
   * The feature id for the '<em><b>Student Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__STUDENT_ELEMENTS = 3;

  /**
   * The feature id for the '<em><b>Last Feedback</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__LAST_FEEDBACK = 4;

  /**
   * The feature id for the '<em><b>Instructor Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__INSTRUCTOR_ELEMENTS = 5;

  /**
   * The feature id for the '<em><b>Student Solution</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__STUDENT_SOLUTION = 6;

  /**
   * The feature id for the '<em><b>Num Detection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__NUM_DETECTION = 7;

  /**
   * The feature id for the '<em><b>Num Detection Since Resolved</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__NUM_DETECTION_SINCE_RESOLVED = 8;

  /**
   * The feature id for the '<em><b>Mistake Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE__MISTAKE_TYPE = 9;

  /**
   * The number of structural features of the '<em>Mistake</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_FEATURE_COUNT = 10;

  /**
   * The number of operations of the '<em>Mistake</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MISTAKE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link modelingassistant.impl.FeedbackItemImpl <em>Feedback Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see modelingassistant.impl.FeedbackItemImpl
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getFeedbackItem()
   * @generated
   */
  int FEEDBACK_ITEM = 9;

  /**
   * The feature id for the '<em><b>Mistakes</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK_ITEM__MISTAKES = 0;

  /**
   * The feature id for the '<em><b>Modeling Assistant</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK_ITEM__MODELING_ASSISTANT = 1;

  /**
   * The feature id for the '<em><b>Usefulness</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK_ITEM__USEFULNESS = 2;

  /**
   * The feature id for the '<em><b>Feedback</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK_ITEM__FEEDBACK = 3;

  /**
   * The number of structural features of the '<em>Feedback Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK_ITEM_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Feedback Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEEDBACK_ITEM_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '<em>Time</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.sql.Time
   * @see modelingassistant.impl.ModelingassistantPackageImpl#getTime()
   * @generated
   */
  int TIME = 10;


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
   * Returns the meta object for the containment reference list '{@link modelingassistant.ModelingAssistant#getStudentKnowledges <em>Student Knowledges</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Student Knowledges</em>'.
   * @see modelingassistant.ModelingAssistant#getStudentKnowledges()
   * @see #getModelingAssistant()
   * @generated
   */
  EReference getModelingAssistant_StudentKnowledges();

  /**
   * Returns the meta object for the containment reference list '{@link modelingassistant.ModelingAssistant#getFeedbackItems <em>Feedback Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Feedback Items</em>'.
   * @see modelingassistant.ModelingAssistant#getFeedbackItems()
   * @see #getModelingAssistant()
   * @generated
   */
  EReference getModelingAssistant_FeedbackItems();

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
   * Returns the meta object for the reference '{@link modelingassistant.Student#getCurrentSolution <em>Current Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Current Solution</em>'.
   * @see modelingassistant.Student#getCurrentSolution()
   * @see #getStudent()
   * @generated
   */
  EReference getStudent_CurrentSolution();

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
   * Returns the meta object for the reference list '{@link modelingassistant.ProblemStatement#getStudentSolution <em>Student Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Student Solution</em>'.
   * @see modelingassistant.ProblemStatement#getStudentSolution()
   * @see #getProblemStatement()
   * @generated
   */
  EReference getProblemStatement_StudentSolution();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.ProblemStatement#getInstructorSolution <em>Instructor Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Instructor Solution</em>'.
   * @see modelingassistant.ProblemStatement#getInstructorSolution()
   * @see #getProblemStatement()
   * @generated
   */
  EReference getProblemStatement_InstructorSolution();

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
   * Returns the meta object for the containment reference list '{@link modelingassistant.Solution#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mistakes</em>'.
   * @see modelingassistant.Solution#getMistakes()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_Mistakes();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.Solution#getCurrentMistake <em>Current Mistake</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Current Mistake</em>'.
   * @see modelingassistant.Solution#getCurrentMistake()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_CurrentMistake();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.Solution#getStudentProblemStatement <em>Student Problem Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Student Problem Statement</em>'.
   * @see modelingassistant.Solution#getStudentProblemStatement()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_StudentProblemStatement();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.Solution#getInstructorProblemStatement <em>Instructor Problem Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Instructor Problem Statement</em>'.
   * @see modelingassistant.Solution#getInstructorProblemStatement()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_InstructorProblemStatement();

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
   * Returns the meta object for the reference list '{@link modelingassistant.SolutionElement#getStudentElementMistakes <em>Student Element Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Student Element Mistakes</em>'.
   * @see modelingassistant.SolutionElement#getStudentElementMistakes()
   * @see #getSolutionElement()
   * @generated
   */
  EReference getSolutionElement_StudentElementMistakes();

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
   * Returns the meta object for the reference list '{@link modelingassistant.SolutionElement#getInstructorElementMistakes <em>Instructor Element Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Instructor Element Mistakes</em>'.
   * @see modelingassistant.SolutionElement#getInstructorElementMistakes()
   * @see #getSolutionElement()
   * @generated
   */
  EReference getSolutionElement_InstructorElementMistakes();

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
   * Returns the meta object for the container reference '{@link modelingassistant.StudentKnowledge#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Modeling Assistant</em>'.
   * @see modelingassistant.StudentKnowledge#getModelingAssistant()
   * @see #getStudentKnowledge()
   * @generated
   */
  EReference getStudentKnowledge_ModelingAssistant();

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
   * Returns the meta object for the reference list '{@link modelingassistant.Mistake#getStudentElements <em>Student Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Student Elements</em>'.
   * @see modelingassistant.Mistake#getStudentElements()
   * @see #getMistake()
   * @generated
   */
  EReference getMistake_StudentElements();

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
   * Returns the meta object for the reference list '{@link modelingassistant.Mistake#getInstructorElements <em>Instructor Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Instructor Elements</em>'.
   * @see modelingassistant.Mistake#getInstructorElements()
   * @see #getMistake()
   * @generated
   */
  EReference getMistake_InstructorElements();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.Mistake#getStudentSolution <em>Student Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Student Solution</em>'.
   * @see modelingassistant.Mistake#getStudentSolution()
   * @see #getMistake()
   * @generated
   */
  EReference getMistake_StudentSolution();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.Mistake#getNumDetection <em>Num Detection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Num Detection</em>'.
   * @see modelingassistant.Mistake#getNumDetection()
   * @see #getMistake()
   * @generated
   */
  EAttribute getMistake_NumDetection();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.Mistake#getNumDetectionSinceResolved <em>Num Detection Since Resolved</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Num Detection Since Resolved</em>'.
   * @see modelingassistant.Mistake#getNumDetectionSinceResolved()
   * @see #getMistake()
   * @generated
   */
  EAttribute getMistake_NumDetectionSinceResolved();

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
   * Returns the meta object for class '{@link modelingassistant.FeedbackItem <em>Feedback Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feedback Item</em>'.
   * @see modelingassistant.FeedbackItem
   * @generated
   */
  EClass getFeedbackItem();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.FeedbackItem#getMistakes <em>Mistakes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Mistakes</em>'.
   * @see modelingassistant.FeedbackItem#getMistakes()
   * @see #getFeedbackItem()
   * @generated
   */
  EReference getFeedbackItem_Mistakes();

  /**
   * Returns the meta object for the container reference '{@link modelingassistant.FeedbackItem#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Modeling Assistant</em>'.
   * @see modelingassistant.FeedbackItem#getModelingAssistant()
   * @see #getFeedbackItem()
   * @generated
   */
  EReference getFeedbackItem_ModelingAssistant();

  /**
   * Returns the meta object for the attribute '{@link modelingassistant.FeedbackItem#getUsefulness <em>Usefulness</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Usefulness</em>'.
   * @see modelingassistant.FeedbackItem#getUsefulness()
   * @see #getFeedbackItem()
   * @generated
   */
  EAttribute getFeedbackItem_Usefulness();

  /**
   * Returns the meta object for the reference '{@link modelingassistant.FeedbackItem#getFeedback <em>Feedback</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Feedback</em>'.
   * @see modelingassistant.FeedbackItem#getFeedback()
   * @see #getFeedbackItem()
   * @generated
   */
  EReference getFeedbackItem_Feedback();

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
     * The meta object literal for the '<em><b>Students</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODELING_ASSISTANT__STUDENTS = eINSTANCE.getModelingAssistant_Students();

    /**
     * The meta object literal for the '<em><b>Student Knowledges</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODELING_ASSISTANT__STUDENT_KNOWLEDGES = eINSTANCE.getModelingAssistant_StudentKnowledges();

    /**
     * The meta object literal for the '<em><b>Feedback Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODELING_ASSISTANT__FEEDBACK_ITEMS = eINSTANCE.getModelingAssistant_FeedbackItems();

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
     * The meta object literal for the '<em><b>Current Solution</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STUDENT__CURRENT_SOLUTION = eINSTANCE.getStudent_CurrentSolution();

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
     * The meta object literal for the '<em><b>Modeling Assistant</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROBLEM_STATEMENT__MODELING_ASSISTANT = eINSTANCE.getProblemStatement_ModelingAssistant();

    /**
     * The meta object literal for the '<em><b>Student Solution</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROBLEM_STATEMENT__STUDENT_SOLUTION = eINSTANCE.getProblemStatement_StudentSolution();

    /**
     * The meta object literal for the '<em><b>Instructor Solution</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROBLEM_STATEMENT__INSTRUCTOR_SOLUTION = eINSTANCE.getProblemStatement_InstructorSolution();

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
     * The meta object literal for the '<em><b>Mistakes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__MISTAKES = eINSTANCE.getSolution_Mistakes();

    /**
     * The meta object literal for the '<em><b>Current Mistake</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__CURRENT_MISTAKE = eINSTANCE.getSolution_CurrentMistake();

    /**
     * The meta object literal for the '<em><b>Student Problem Statement</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__STUDENT_PROBLEM_STATEMENT = eINSTANCE.getSolution_StudentProblemStatement();

    /**
     * The meta object literal for the '<em><b>Instructor Problem Statement</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__INSTRUCTOR_PROBLEM_STATEMENT = eINSTANCE.getSolution_InstructorProblemStatement();

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
     * The meta object literal for the '<em><b>Solution</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION_ELEMENT__SOLUTION = eINSTANCE.getSolutionElement_Solution();

    /**
     * The meta object literal for the '<em><b>Student Element Mistakes</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION_ELEMENT__STUDENT_ELEMENT_MISTAKES = eINSTANCE.getSolutionElement_StudentElementMistakes();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION_ELEMENT__ELEMENT = eINSTANCE.getSolutionElement_Element();

    /**
     * The meta object literal for the '<em><b>Instructor Element Mistakes</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION_ELEMENT__INSTRUCTOR_ELEMENT_MISTAKES = eINSTANCE.getSolutionElement_InstructorElementMistakes();

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
     * The meta object literal for the '<em><b>Modeling Assistant</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STUDENT_KNOWLEDGE__MODELING_ASSISTANT = eINSTANCE.getStudentKnowledge_ModelingAssistant();

    /**
     * The meta object literal for the '<em><b>Mistake Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STUDENT_KNOWLEDGE__MISTAKE_TYPE = eINSTANCE.getStudentKnowledge_MistakeType();

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
     * The meta object literal for the '<em><b>Student Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE__STUDENT_ELEMENTS = eINSTANCE.getMistake_StudentElements();

    /**
     * The meta object literal for the '<em><b>Last Feedback</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE__LAST_FEEDBACK = eINSTANCE.getMistake_LastFeedback();

    /**
     * The meta object literal for the '<em><b>Instructor Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE__INSTRUCTOR_ELEMENTS = eINSTANCE.getMistake_InstructorElements();

    /**
     * The meta object literal for the '<em><b>Student Solution</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE__STUDENT_SOLUTION = eINSTANCE.getMistake_StudentSolution();

    /**
     * The meta object literal for the '<em><b>Num Detection</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MISTAKE__NUM_DETECTION = eINSTANCE.getMistake_NumDetection();

    /**
     * The meta object literal for the '<em><b>Num Detection Since Resolved</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MISTAKE__NUM_DETECTION_SINCE_RESOLVED = eINSTANCE.getMistake_NumDetectionSinceResolved();

    /**
     * The meta object literal for the '<em><b>Mistake Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MISTAKE__MISTAKE_TYPE = eINSTANCE.getMistake_MistakeType();

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
     * The meta object literal for the '{@link modelingassistant.impl.FeedbackItemImpl <em>Feedback Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see modelingassistant.impl.FeedbackItemImpl
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getFeedbackItem()
     * @generated
     */
    EClass FEEDBACK_ITEM = eINSTANCE.getFeedbackItem();

    /**
     * The meta object literal for the '<em><b>Mistakes</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEEDBACK_ITEM__MISTAKES = eINSTANCE.getFeedbackItem_Mistakes();

    /**
     * The meta object literal for the '<em><b>Modeling Assistant</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEEDBACK_ITEM__MODELING_ASSISTANT = eINSTANCE.getFeedbackItem_ModelingAssistant();

    /**
     * The meta object literal for the '<em><b>Usefulness</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEEDBACK_ITEM__USEFULNESS = eINSTANCE.getFeedbackItem_Usefulness();

    /**
     * The meta object literal for the '<em><b>Feedback</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEEDBACK_ITEM__FEEDBACK = eINSTANCE.getFeedbackItem_Feedback();

    /**
     * The meta object literal for the '<em>Time</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.sql.Time
     * @see modelingassistant.impl.ModelingassistantPackageImpl#getTime()
     * @generated
     */
    EDataType TIME = eINSTANCE.getTime();

  }

} //ModelingassistantPackage
