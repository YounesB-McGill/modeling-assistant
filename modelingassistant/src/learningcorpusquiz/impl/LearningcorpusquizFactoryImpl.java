/**
 */
package learningcorpusquiz.impl;

import learningcorpusquiz.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LearningcorpusquizFactoryImpl extends EFactoryImpl implements LearningcorpusquizFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LearningcorpusquizFactory init() {
    try {
      LearningcorpusquizFactory theLearningcorpusquizFactory = (LearningcorpusquizFactory)EPackage.Registry.INSTANCE.getEFactory(LearningcorpusquizPackage.eNS_URI);
      if (theLearningcorpusquizFactory != null) {
        return theLearningcorpusquizFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LearningcorpusquizFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningcorpusquizFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case LearningcorpusquizPackage.FILL_IN_THE_BLANKS_QUIZ: return createFillInTheBlanksQuiz();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FillInTheBlanksQuiz createFillInTheBlanksQuiz() {
    FillInTheBlanksQuizImpl fillInTheBlanksQuiz = new FillInTheBlanksQuizImpl();
    return fillInTheBlanksQuiz;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LearningcorpusquizPackage getLearningcorpusquizPackage() {
    return (LearningcorpusquizPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LearningcorpusquizPackage getPackage() {
    return LearningcorpusquizPackage.eINSTANCE;
  }

} //LearningcorpusquizFactoryImpl
