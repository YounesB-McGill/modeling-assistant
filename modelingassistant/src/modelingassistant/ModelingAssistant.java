/**
 */
package modelingassistant;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import ca.mcgill.sel.classdiagram.util.CdmResourceFactoryImpl;
import modelingassistant.util.ModelingassistantResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modeling Assistant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.ModelingAssistant#getProblemStatements <em>Problem Statements</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getStudents <em>Students</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getStudentKnowledges <em>Student Knowledges</em>}</li>
 *   <li>{@link modelingassistant.ModelingAssistant#getFeedbackItems <em>Feedback Items</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getModelingAssistant()
 * @model
 * @generated
 */
public interface ModelingAssistant extends EObject {
  /**
   * Returns the value of the '<em><b>Problem Statements</b></em>' containment reference list.
   * The list contents are of type {@link modelingassistant.ProblemStatement}.
   * It is bidirectional and its opposite is '{@link modelingassistant.ProblemStatement#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Problem Statements</em>' containment reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_ProblemStatements()
   * @see modelingassistant.ProblemStatement#getModelingAssistant
   * @model opposite="modelingAssistant" containment="true"
   * @generated
   */
  EList<ProblemStatement> getProblemStatements();

  /**
   * Returns the value of the '<em><b>Solutions</b></em>' containment reference list.
   * The list contents are of type {@link modelingassistant.Solution}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Solution#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solutions</em>' containment reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_Solutions()
   * @see modelingassistant.Solution#getModelingAssistant
   * @model opposite="modelingAssistant" containment="true"
   * @generated
   */
  EList<Solution> getSolutions();

  /**
   * Returns the value of the '<em><b>Students</b></em>' containment reference list.
   * The list contents are of type {@link modelingassistant.Student}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Student#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Students</em>' containment reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_Students()
   * @see modelingassistant.Student#getModelingAssistant
   * @model opposite="modelingAssistant" containment="true"
   * @generated
   */
  EList<Student> getStudents();

  /**
   * Returns the value of the '<em><b>Student Knowledges</b></em>' containment reference list.
   * The list contents are of type {@link modelingassistant.StudentKnowledge}.
   * It is bidirectional and its opposite is '{@link modelingassistant.StudentKnowledge#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Student Knowledges</em>' containment reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_StudentKnowledges()
   * @see modelingassistant.StudentKnowledge#getModelingAssistant
   * @model opposite="modelingAssistant" containment="true"
   * @generated
   */
  EList<StudentKnowledge> getStudentKnowledges();

  /**
   * Returns the value of the '<em><b>Feedback Items</b></em>' containment reference list.
   * The list contents are of type {@link modelingassistant.FeedbackItem}.
   * It is bidirectional and its opposite is '{@link modelingassistant.FeedbackItem#getModelingAssistant <em>Modeling Assistant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feedback Items</em>' containment reference list.
   * @see modelingassistant.ModelingassistantPackage#getModelingAssistant_FeedbackItems()
   * @see modelingassistant.FeedbackItem#getModelingAssistant
   * @model opposite="modelingAssistant" containment="true"
   * @generated
   */
  EList<FeedbackItem> getFeedbackItems();

  /**
   * Returns the modeling assistant at the given *.modelingassistant file.
   *
   * @generated NOT
   */
  static ModelingAssistant fromFile(File file) {
    ModelingassistantPackage.eINSTANCE.eClass();
    // rset is local to avoid duplicate resource issues
    // this may need to change in the future to improve performance
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().putAll(Map.of(
        "cdm", new CdmResourceFactoryImpl(),
        ModelingassistantPackage.eNAME, new ModelingassistantResourceFactoryImpl()));
    try {
      var maResource = rset.createResource(URI.createFileURI(file.getCanonicalPath()));
      maResource.load(Collections.EMPTY_MAP);
      return (ModelingAssistant) maResource.getContents().get(0);
    } catch (IOException e) {
      return null;
    }
  }

  /**
   * Returns the modeling assistant at the given *.modelingassistant file path.
   *
   * @generated NOT
   */
  static ModelingAssistant fromFile(String path) {
    return fromFile(new File(path));
  }

  /**
   * Save the modeling assistant instance to the given *.modelingassistant file.
   *
   * @generated NOT
   */
  default void toFile(File file) {
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().putAll(Map.of(
        "cdm", new CdmResourceFactoryImpl(),
        ModelingassistantPackage.eNAME, new ModelingassistantResourceFactoryImpl()));
    try {
      var maResource = rset.createResource(URI.createFileURI(file.getCanonicalPath()));
      maResource.getContents().add(this);
      maResource.save(Collections.EMPTY_MAP);
    } catch (IOException e) {
    }
  }

  /**
   * Save the modeling assistant instance to the given *.modelingassistant file path.
   *
   * @generated NOT
   */
  default void toFile(String path) {
    toFile(new File(path));
  }

} // ModelingAssistant
