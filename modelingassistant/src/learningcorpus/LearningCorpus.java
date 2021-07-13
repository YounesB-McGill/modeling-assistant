/**
 */
package learningcorpus;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import learningcorpus.util.LearningcorpusResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Learning Corpus</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link learningcorpus.LearningCorpus#getMistakeTypeCategories <em>Mistake Type Categories</em>}</li>
 *   <li>{@link learningcorpus.LearningCorpus#getFeedbacks <em>Feedbacks</em>}</li>
 *   <li>{@link learningcorpus.LearningCorpus#getLearningItems <em>Learning Items</em>}</li>
 *   <li>{@link learningcorpus.LearningCorpus#getLearningResources <em>Learning Resources</em>}</li>
 * </ul>
 *
 * @see learningcorpus.LearningcorpusPackage#getLearningCorpus()
 * @model
 * @generated
 */
public interface LearningCorpus extends EObject {
  /**
   * Returns the value of the '<em><b>Mistake Type Categories</b></em>' containment reference list.
   * The list contents are of type {@link learningcorpus.MistakeTypeCategory}.
   * It is bidirectional and its opposite is '{@link learningcorpus.MistakeTypeCategory#getLearningCorpus <em>Learning Corpus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake Type Categories</em>' containment reference list.
   * @see learningcorpus.LearningcorpusPackage#getLearningCorpus_MistakeTypeCategories()
   * @see learningcorpus.MistakeTypeCategory#getLearningCorpus
   * @model opposite="learningCorpus" containment="true"
   * @generated
   */
  EList<MistakeTypeCategory> getMistakeTypeCategories();

  /**
   * Returns the top level mistake type categories of the learning corpus, ie, those that do not have a supercategory.
   *
   * @generated NOT
   */
  default EList<MistakeTypeCategory> getTopLevelMistakeTypeCategories() {
    return ECollections.unmodifiableEList(getMistakeTypeCategories().stream()
        .filter(mtc -> mtc.getSupercategory() == null).collect(Collectors.toUnmodifiableList()));
  }

  /**
   * Returns the mistake types of the learning corpus.
   *
   * @generated NOT
   */
  default EList<MistakeType> getMistakeTypes() {
    return ECollections.unmodifiableEList(getMistakeTypeCategories().stream().map(MistakeTypeCategory::getMistakeTypes)
        .flatMap(EList::stream).collect(Collectors.toUnmodifiableList()));
  }

  /**
   * Returns the value of the '<em><b>Feedbacks</b></em>' containment reference list.
   * The list contents are of type {@link learningcorpus.Feedback}.
   * It is bidirectional and its opposite is '{@link learningcorpus.Feedback#getLearningCorpus <em>Learning Corpus</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the value of the '<em>Feedbacks</em>' containment reference list.
   * @see learningcorpus.LearningcorpusPackage#getLearningCorpus_Feedbacks()
   * @see learningcorpus.Feedback#getLearningCorpus
   * @model opposite="learningCorpus" containment="true"
   * @generated
   */
  EList<Feedback> getFeedbacks();

  /**
   * Returns the value of the '<em><b>Learning Items</b></em>' containment reference list.
   * The list contents are of type {@link learningcorpus.LearningItem}.
   * It is bidirectional and its opposite is '{@link learningcorpus.LearningItem#getLearningCorpus <em>Learning Corpus</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the value of the '<em>Learning Items</em>' containment reference list.
   * @see learningcorpus.LearningcorpusPackage#getLearningCorpus_LearningItems()
   * @see learningcorpus.LearningItem#getLearningCorpus
   * @model opposite="learningCorpus" containment="true"
   * @generated
   */
  EList<LearningItem> getLearningItems();

  /**
   * Returns the value of the '<em><b>Learning Resources</b></em>' containment reference list.
   * The list contents are of type {@link learningcorpus.LearningResource}.
   * It is bidirectional and its opposite is '{@link learningcorpus.LearningResource#getLearningCorpus <em>Learning Corpus</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the value of the '<em>Learning Resources</em>' containment reference list.
   * @see learningcorpus.LearningcorpusPackage#getLearningCorpus_LearningResources()
   * @see learningcorpus.LearningResource#getLearningCorpus
   * @model opposite="learningCorpus" containment="true"
   * @generated
   */
  EList<LearningResource> getLearningResources();

  /**
   * Returns the learning corpus at the given *.learningcorpus file.
   *
   * @generated NOT
   */
  static LearningCorpus fromFile(File file) {
    LearningcorpusPackage.eINSTANCE.eClass();
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put(LearningcorpusPackage.eNAME,
        new LearningcorpusResourceFactoryImpl());
    try {
      var lcResource = rset.createResource(URI.createFileURI(file.getCanonicalPath()));
      lcResource.load(Collections.EMPTY_MAP);
      return (LearningCorpus) lcResource.getContents().get(0);
    } catch (IOException e) {
      return null;
    }
  }

  /**
   * Returns the learning corpus at the given *.learningcorpus file path.
   *
   * @generated NOT
   */
  static LearningCorpus fromFile(String path) {
    return fromFile(new File(path));
  }

} // LearningCorpus
