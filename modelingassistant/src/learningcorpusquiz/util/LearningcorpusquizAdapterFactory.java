/**
 */
package learningcorpusquiz.util;

import learningcorpus.LearningResource;
import learningcorpus.NamedElement;
import learningcorpus.Quiz;

import learningcorpusquiz.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see learningcorpusquiz.LearningcorpusquizPackage
 * @generated
 */
public class LearningcorpusquizAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static LearningcorpusquizPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningcorpusquizAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = LearningcorpusquizPackage.eINSTANCE;
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
  protected LearningcorpusquizSwitch<Adapter> modelSwitch =
    new LearningcorpusquizSwitch<Adapter>() {
      @Override
      public Adapter caseFillInTheBlanksQuiz(FillInTheBlanksQuiz object) {
        return createFillInTheBlanksQuizAdapter();
      }
      @Override
      public Adapter caseListMultipleChoiceQuiz(ListMultipleChoiceQuiz object) {
        return createListMultipleChoiceQuizAdapter();
      }
      @Override
      public Adapter caseTableMultipleChoiceQuiz(TableMultipleChoiceQuiz object) {
        return createTableMultipleChoiceQuizAdapter();
      }
      @Override
      public Adapter caseFillInTheBlanksQuizStatement(FillInTheBlanksQuizStatement object) {
        return createFillInTheBlanksQuizStatementAdapter();
      }
      @Override
      public Adapter caseFillInTheBlanksQuizStatementComponent(FillInTheBlanksQuizStatementComponent object) {
        return createFillInTheBlanksQuizStatementComponentAdapter();
      }
      @Override
      public Adapter caseNonBlank(NonBlank object) {
        return createNonBlankAdapter();
      }
      @Override
      public Adapter caseBlank(Blank object) {
        return createBlankAdapter();
      }
      @Override
      public Adapter caseChoice(Choice object) {
        return createChoiceAdapter();
      }
      @Override
      public Adapter caseTableMcqEntry(TableMcqEntry object) {
        return createTableMcqEntryAdapter();
      }
      @Override
      public Adapter caseTableMcqRowItem(TableMcqRowItem object) {
        return createTableMcqRowItemAdapter();
      }
      @Override
      public Adapter caseTableMcqColumnItem(TableMcqColumnItem object) {
        return createTableMcqColumnItemAdapter();
      }
      @Override
      public Adapter caseNamedElement(NamedElement object) {
        return createNamedElementAdapter();
      }
      @Override
      public Adapter caseLearningResource(LearningResource object) {
        return createLearningResourceAdapter();
      }
      @Override
      public Adapter caseQuiz(Quiz object) {
        return createQuizAdapter();
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
   * Creates a new adapter for an object of class '{@link learningcorpusquiz.FillInTheBlanksQuiz <em>Fill In The Blanks Quiz</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpusquiz.FillInTheBlanksQuiz
   * @generated
   */
  public Adapter createFillInTheBlanksQuizAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpusquiz.ListMultipleChoiceQuiz <em>List Multiple Choice Quiz</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpusquiz.ListMultipleChoiceQuiz
   * @generated
   */
  public Adapter createListMultipleChoiceQuizAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpusquiz.TableMultipleChoiceQuiz <em>Table Multiple Choice Quiz</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpusquiz.TableMultipleChoiceQuiz
   * @generated
   */
  public Adapter createTableMultipleChoiceQuizAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpusquiz.FillInTheBlanksQuizStatement <em>Fill In The Blanks Quiz Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpusquiz.FillInTheBlanksQuizStatement
   * @generated
   */
  public Adapter createFillInTheBlanksQuizStatementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpusquiz.FillInTheBlanksQuizStatementComponent <em>Fill In The Blanks Quiz Statement Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpusquiz.FillInTheBlanksQuizStatementComponent
   * @generated
   */
  public Adapter createFillInTheBlanksQuizStatementComponentAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpusquiz.NonBlank <em>Non Blank</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpusquiz.NonBlank
   * @generated
   */
  public Adapter createNonBlankAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpusquiz.Blank <em>Blank</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpusquiz.Blank
   * @generated
   */
  public Adapter createBlankAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpusquiz.Choice <em>Choice</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpusquiz.Choice
   * @generated
   */
  public Adapter createChoiceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpusquiz.TableMcqEntry <em>Table Mcq Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpusquiz.TableMcqEntry
   * @generated
   */
  public Adapter createTableMcqEntryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpusquiz.TableMcqRowItem <em>Table Mcq Row Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpusquiz.TableMcqRowItem
   * @generated
   */
  public Adapter createTableMcqRowItemAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link learningcorpusquiz.TableMcqColumnItem <em>Table Mcq Column Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see learningcorpusquiz.TableMcqColumnItem
   * @generated
   */
  public Adapter createTableMcqColumnItemAdapter() {
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

} //LearningcorpusquizAdapterFactory
