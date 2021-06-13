/**
 */
package learningcorpus.util;

import learningcorpus.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see learningcorpus.LearningcorpusPackage
 * @generated
 */
public class LearningcorpusAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static LearningcorpusPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningcorpusAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = LearningcorpusPackage.eINSTANCE;
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
  protected LearningcorpusSwitch<Adapter> modelSwitch =
    new LearningcorpusSwitch<Adapter>() {
      @Override
      public Adapter caseUmlElement(UmlElement object) {
        return createUmlElementAdapter();
      }
      @Override
      public Adapter caseLearningItem(LearningItem object) {
        return createLearningItemAdapter();
      }
      @Override
      public Adapter caseMistakeType(MistakeType object) {
        return createMistakeTypeAdapter();
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
      public Adapter caseMistakeTypeCategory(MistakeTypeCategory object) {
        return createMistakeTypeCategoryAdapter();
      }
      @Override
      public Adapter caseLearningCorpus(LearningCorpus object) {
        return createLearningCorpusAdapter();
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
   * Creates a new adapter for an object of class '{@link learningcorpus.UmlElement <em>Uml Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.UmlElement
   * @generated
   */
  public Adapter createUmlElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.LearningItem <em>Learning Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.LearningItem
   * @generated
   */
  public Adapter createLearningItemAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.MistakeType <em>Mistake Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.MistakeType
   * @generated
   */
  public Adapter createMistakeTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.Feedback <em>Feedback</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.Feedback
   * @generated
   */
  public Adapter createFeedbackAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.TextResponse <em>Text Response</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.TextResponse
   * @generated
   */
  public Adapter createTextResponseAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.ParametrizedResponse <em>Parametrized Response</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.ParametrizedResponse
   * @generated
   */
  public Adapter createParametrizedResponseAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.ResourceResponse <em>Resource Response</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.ResourceResponse
   * @generated
   */
  public Adapter createResourceResponseAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.LearningResource <em>Learning Resource</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.LearningResource
   * @generated
   */
  public Adapter createLearningResourceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.Reference
   * @generated
   */
  public Adapter createReferenceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.Tutorial <em>Tutorial</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.Tutorial
   * @generated
   */
  public Adapter createTutorialAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.Example <em>Example</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.Example
   * @generated
   */
  public Adapter createExampleAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.Quiz <em>Quiz</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.Quiz
   * @generated
   */
  public Adapter createQuizAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.NamedElement
   * @generated
   */
  public Adapter createNamedElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.MistakeTypeCategory <em>Mistake Type Category</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.MistakeTypeCategory
   * @generated
   */
  public Adapter createMistakeTypeCategoryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpus.LearningCorpus <em>Learning Corpus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpus.LearningCorpus
   * @generated
   */
  public Adapter createLearningCorpusAdapter() {
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

} //LearningcorpusAdapterFactory
