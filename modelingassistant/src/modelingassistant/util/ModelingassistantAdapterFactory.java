/**
 */
package modelingassistant.util;

import modelingassistant.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see modelingassistant.ModelingassistantPackage
 * @generated
 */
public class ModelingassistantAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ModelingassistantPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelingassistantAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = ModelingassistantPackage.eINSTANCE;
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
  protected ModelingassistantSwitch<Adapter> modelSwitch =
    new ModelingassistantSwitch<Adapter>() {
      @Override
      public Adapter caseModelingAssistant(ModelingAssistant object) {
        return createModelingAssistantAdapter();
      }
      @Override
      public Adapter caseStudent(Student object) {
        return createStudentAdapter();
      }
      @Override
      public Adapter caseProblemStatement(ProblemStatement object) {
        return createProblemStatementAdapter();
      }
      @Override
      public Adapter caseProblemStatementElement(ProblemStatementElement object) {
        return createProblemStatementElementAdapter();
      }
      @Override
      public Adapter caseUmlElement(UmlElement object) {
        return createUmlElementAdapter();
      }
      @Override
      public Adapter caseSolution(Solution object) {
        return createSolutionAdapter();
      }
      @Override
      public Adapter caseSolutionElement(SolutionElement object) {
        return createSolutionElementAdapter();
      }
      @Override
      public Adapter caseLearningItem(LearningItem object) {
        return createLearningItemAdapter();
      }
      @Override
      public Adapter caseStudentKnowledge(StudentKnowledge object) {
        return createStudentKnowledgeAdapter();
      }
      @Override
      public Adapter caseMistakeType(MistakeType object) {
        return createMistakeTypeAdapter();
      }
      @Override
      public Adapter caseMistake(Mistake object) {
        return createMistakeAdapter();
      }
      @Override
      public Adapter caseFeedback(Feedback object) {
        return createFeedbackAdapter();
      }
      @Override
      public Adapter caseTextResponse(TextResponse object) {
        return createTextResponseAdapter();
      }
      @Override
      public Adapter caseParametrizedResponse(ParametrizedResponse object) {
        return createParametrizedResponseAdapter();
      }
      @Override
      public Adapter caseResourceResponse(ResourceResponse object) {
        return createResourceResponseAdapter();
      }
      @Override
      public Adapter caseLearningResource(LearningResource object) {
        return createLearningResourceAdapter();
      }
      @Override
      public Adapter caseReference(Reference object) {
        return createReferenceAdapter();
      }
      @Override
      public Adapter caseTutorial(Tutorial object) {
        return createTutorialAdapter();
      }
      @Override
      public Adapter caseExample(Example object) {
        return createExampleAdapter();
      }
      @Override
      public Adapter caseQuiz(Quiz object) {
        return createQuizAdapter();
      }
      @Override
      public Adapter caseNamedElement(NamedElement object) {
        return createNamedElementAdapter();
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
   * Creates a new adapter for an object of class '{@link modelingassistant.ModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.ModelingAssistant
   * @generated
   */
  public Adapter createModelingAssistantAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.Student <em>Student</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.Student
   * @generated
   */
  public Adapter createStudentAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.ProblemStatement <em>Problem Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.ProblemStatement
   * @generated
   */
  public Adapter createProblemStatementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.ProblemStatementElement <em>Problem Statement Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.ProblemStatementElement
   * @generated
   */
  public Adapter createProblemStatementElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.UmlElement <em>Uml Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.UmlElement
   * @generated
   */
  public Adapter createUmlElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.Solution <em>Solution</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.Solution
   * @generated
   */
  public Adapter createSolutionAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.SolutionElement <em>Solution Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.SolutionElement
   * @generated
   */
  public Adapter createSolutionElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.LearningItem <em>Learning Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.LearningItem
   * @generated
   */
  public Adapter createLearningItemAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.StudentKnowledge <em>Student Knowledge</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.StudentKnowledge
   * @generated
   */
  public Adapter createStudentKnowledgeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.MistakeType <em>Mistake Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.MistakeType
   * @generated
   */
  public Adapter createMistakeTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.Mistake <em>Mistake</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.Mistake
   * @generated
   */
  public Adapter createMistakeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.Feedback <em>Feedback</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.Feedback
   * @generated
   */
  public Adapter createFeedbackAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.TextResponse <em>Text Response</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.TextResponse
   * @generated
   */
  public Adapter createTextResponseAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.ParametrizedResponse <em>Parametrized Response</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.ParametrizedResponse
   * @generated
   */
  public Adapter createParametrizedResponseAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.ResourceResponse <em>Resource Response</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.ResourceResponse
   * @generated
   */
  public Adapter createResourceResponseAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.LearningResource <em>Learning Resource</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.LearningResource
   * @generated
   */
  public Adapter createLearningResourceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.Reference
   * @generated
   */
  public Adapter createReferenceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.Tutorial <em>Tutorial</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.Tutorial
   * @generated
   */
  public Adapter createTutorialAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.Example <em>Example</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.Example
   * @generated
   */
  public Adapter createExampleAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.Quiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.Quiz
   * @generated
   */
  public Adapter createQuizAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelingassistant.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelingassistant.NamedElement
   * @generated
   */
  public Adapter createNamedElementAdapter() {
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

} //ModelingassistantAdapterFactory
