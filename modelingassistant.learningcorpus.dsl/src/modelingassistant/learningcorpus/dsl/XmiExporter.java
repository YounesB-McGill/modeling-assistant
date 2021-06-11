package modelingassistant.learningcorpus.dsl;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import learningcorpus.LearningcorpusPackage;
import learningcorpus.util.LearningcorpusResourceFactoryImpl;

public class XmiExporter {

  public static final String DEFAULT_LOCATION = "../modelingassistant.learningcorpus.dsl.instances/";
  public static final String DEFAULT_SOURCE = DEFAULT_LOCATION + "test.learningcorpusdsl";
  public static final String DEFAULT_TARGET = DEFAULT_LOCATION + "test.learningcorpus";

  public static void main(String[] args) {
    exportXMI(DEFAULT_SOURCE, DEFAULT_TARGET);
  }

  /**
   * Exports xtext model instance to XMI. Adapted from stackoverflow.com/questions/35839786.
   */
  public static void exportXMI(String source, String target) {
    LearningcorpusPackage.eINSTANCE.eClass();
    var rset = new LearningCorpusDSLStandaloneSetup().createInjectorAndDoEMFRegistration()
        .getInstance(XtextResourceSet.class);
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put(LearningcorpusPackage.eNS_PREFIX,
        new LearningcorpusResourceFactoryImpl());

    try {
      var xtextResource = rset.getResource(URI.createURI(new File(source).getCanonicalPath()), true);
      EcoreUtil.resolveAll(xtextResource);
      var xmiResource = rset.createResource(URI.createURI(new File(target).getCanonicalPath()));
      Objects.requireNonNull(xmiResource);
      Objects.requireNonNull(xtextResource);
      Objects.requireNonNull(xtextResource.getContents());

      xmiResource.getContents().add(xtextResource.getContents().get(0));
      xmiResource.save(Collections.EMPTY_MAP);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
