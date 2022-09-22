/**
 */
package modelingassistant;

import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import ca.mcgill.sel.classdiagram.CdmPackage;
import ca.mcgill.sel.classdiagram.util.CdmResourceFactoryImpl;
import learningcorpus.LearningcorpusPackage;
import learningcorpus.util.LearningcorpusResourceFactoryImpl;
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
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getModelingAssistant()
 * @model
 * @generated
 */
public interface ModelingAssistant extends EObject {

  /**
   * Dummy URI used as the "location" for ModelingAssistant instances that are serialized to a string.
   * This is also an internal member and should not be referenced from other classes. Ideally, it should have been
   * private, however this is not possible in current versions of Java interfaces, so it is marked as "internal," which
   * is the convention used by Java and Eclipse for implementation details that cannot be made private.
   *
   * @generated NOT
   */
  /*private*/ String SAVE_TO_STRING_URI_INTERNAL = "*.modelingassistant";

  /**
   * The resource set for all modeling assistant instances. This is also an internal member and should not be referenced
   * from other classes.
   *
   * @generated NOT
   */
  /*private*/ ResourceSet RSET_INTERNAL = getResourceSetWithExtensions();

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
   * Returns the modeling assistant at the given *.modelingassistant file.
   *
   * @generated NOT
   */
  static ModelingAssistant fromFile(File file) {
    try {
      var maResource = RSET_INTERNAL.createResource(URI.createFileURI(file.getCanonicalPath()));
      maResource.load(Collections.emptyMap());
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
   * Returns a modeling assistant instance (along with associated class diagrams if present) from an XMI string.
   *
   * @generated NOT
   */
  static ModelingAssistant fromEcoreString(String maString) {
    RSET_INTERNAL.getResources().removeIf(r -> SAVE_TO_STRING_URI_INTERNAL.equals(r.getURI().toString()));
    var resource = RSET_INTERNAL.createResource(URI.createFileURI(SAVE_TO_STRING_URI_INTERNAL));
    try {
      resource.load(new URIConverter.ReadableInputStream(maString), Collections.emptyMap());
      return (ModelingAssistant) resource.getContents().get(0);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Saves the modeling assistant instance and associated class diagrams to a string.
   *
   * @generated NOT
   */
  default String toEcoreString() {
    System.out.println("RSET resource URIs");
    RSET_INTERNAL.getResources().stream().forEach(System.out::println);
    var resource = zerothSaveToStringResource();
    if (resource == null) {
      resource = RSET_INTERNAL.createResource(URI.createFileURI(SAVE_TO_STRING_URI_INTERNAL));
    }
    resource.getContents().clear();
    resource.getContents().add(this);
    resource.getContents().addAll(getSolutions().stream().map(Solution::getClassDiagram)
        .collect(Collectors.toUnmodifiableList()));
    var outputStream = new ByteArrayOutputStream();
    try {
      resource.save(outputStream, Map.of(XMLResource.OPTION_ENCODING, UTF_8.name()));
      return outputStream.toString(UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Returns a ResourceSet with cdm, learningcorpus, and modelingassistant extensions.
   *
   * @generated NOT
   */
  private static ResourceSet getResourceSetWithExtensions() {
    CdmPackage.eINSTANCE.eClass();
    LearningcorpusPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();
    ResourceSet rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().putAll(Map.of(
        "cdm", new CdmResourceFactoryImpl(),
        LearningcorpusPackage.eNAME, new LearningcorpusResourceFactoryImpl(),
        ModelingassistantPackage.eNAME, new ModelingassistantResourceFactoryImpl()));
    return rset;
  }

 /**
  * Returns the zeroth resource in RSET_INTERNAL with a URI matching SAVE_TO_STRING_URI_INTERNAL.
  *
  * @generated NOT
  */
  private static Resource zerothSaveToStringResource() {
    return RSET_INTERNAL.getResources().stream().filter(r -> SAVE_TO_STRING_URI_INTERNAL.equals(r.getURI().toString()))
        .findFirst().orElse(null);
  }

} // ModelingAssistant
