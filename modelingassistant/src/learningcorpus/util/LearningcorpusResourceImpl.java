/**
 */
package learningcorpus.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see learningcorpus.util.LearningcorpusResourceFactoryImpl
 * @generated
 */
public class LearningcorpusResourceImpl extends XMIResourceImpl {
  /**
   * Creates an instance of the resource.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param uri the URI of the new resource.
   * @generated
   */
  public LearningcorpusResourceImpl(URI uri) {
    super(uri);
  }

  /*
   * Manual code added to ensure LearningCorpus instances are serialized using UUIDs.
   */
  @Override protected boolean useUUIDs() {
    return true;
  }

} //LearningcorpusResourceImpl
