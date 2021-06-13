package modelingassistant.learningcorpus.dsl;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import learningcorpus.LearningCorpus;
import learningcorpus.LearningcorpusPackage;
import learningcorpus.MistakeTypeCategory;
import learningcorpus.util.LearningcorpusResourceFactoryImpl;

public class XmiExporter {

  public static final String DEFAULT_LOCATION = "../modelingassistant.learningcorpus.dsl.instances/";
  public static final String DEFAULT_SOURCE = DEFAULT_LOCATION + "test.learningcorpusdsl";
  public static final String DEFAULT_TARGET = DEFAULT_LOCATION + "test.learningcorpus";

  public static void main(String[] args) {
    exportXmi(DEFAULT_SOURCE, DEFAULT_TARGET);
    normalize(DEFAULT_TARGET);
  }

  /** Exports xtext model instance to XMI. Adapted from stackoverflow.com/questions/35839786. */
  public static void exportXmi(String source, String target) {
    LearningcorpusPackage.eINSTANCE.eClass();
    var rset = new LearningCorpusDSLStandaloneSetup().createInjectorAndDoEMFRegistration()
        .getInstance(XtextResourceSet.class);
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put(LearningcorpusPackage.eNAME,
        new LearningcorpusResourceFactoryImpl());

    try {
      var xtextResource = rset.getResource(URI.createURI(new File(source).getCanonicalPath()), true);
      EcoreUtil.resolveAll(xtextResource);
      var xmiResource = rset.createResource(URI.createURI(new File(target).getCanonicalPath()));
      xmiResource.getContents().add(xtextResource.getContents().get(0));
      xmiResource.save(Collections.EMPTY_MAP);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /** DSL hack to link mistake type categories that point to their supercategory. */
  public static void normalize(String target) {
    LearningcorpusPackage.eINSTANCE.eClass();
    final var arrow = "->";
    var learningCorpus = LearningCorpus.fromFile(target);
    Map<String, MistakeTypeCategory> namesToMtc = new HashMap<String, MistakeTypeCategory>();

    // TODO refactor to remove side effects
    learningCorpus.getMistakeTypeCategories().stream().map(mtc -> {
      // get real names of all MTCs
      var name = mtc.getName();
      if (name.contains(arrow)) {
        var names = name.split(arrow);
        namesToMtc.put(names[0].strip(), mtc);
      } else {
        namesToMtc.put(name.strip(), mtc);
      }
      return mtc;
    }).filter(mtc -> mtc.getName().contains(arrow)).forEach(mtc -> {
      // link children MTCs with their parents
      var names = mtc.getName().split(arrow);
      var child = names[0].strip();
      var parent = names[1].strip();
      namesToMtc.get(child).setSupercategory(namesToMtc.get(parent));
      namesToMtc.get(child).setName(child);
    });

    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put(LearningcorpusPackage.eNAME,
        new LearningcorpusResourceFactoryImpl());
    try {
      var lcResource = rset.createResource(URI.createFileURI(new File(target).getCanonicalPath()));
      lcResource.getContents().add(learningCorpus);
      lcResource.save(Collections.EMPTY_MAP);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
