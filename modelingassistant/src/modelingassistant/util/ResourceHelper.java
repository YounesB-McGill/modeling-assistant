package modelingassistant.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import ca.mcgill.sel.classdiagram.CdmPackage;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.classdiagram.util.CdmResourceFactoryImpl;
import learningcorpus.LearningcorpusPackage;
import learningcorpus.util.LearningcorpusResourceFactoryImpl;
import modelingassistant.ModelingassistantPackage;

/**
 * Utility class that provides means to load and save resources. It uses the default XMI resource factory for any kind
 * of resource, however, specific resource factories can be registered for specific file extensions.
 *
 * @author Matthias Schoettle <mschoettle (at) cs.mcgill.ca>
 * @author Younes Boubekeur
 *
 * @generated NOT
 */
public final class ResourceHelper {

  @Deprecated
  public final static ResourceHelper INSTANCE = new ResourceHelper();

  private ResourceSet resourceSet;

  /**
   * Creates a new instance and initializes the resource set.
   */
  private ResourceHelper() {
    initializeResourceSet();
  }

  /**
   * Initializes the resource set and registers the default XMI factory for any file extension.
   */
  private void initializeResourceSet() {
    resourceSet = new ResourceSetImpl();

    // Register default XMI factory implementation for any extension. Requires bundle org.eclipse.emf.ecore.xmi.
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
  }

  /**
   * Adds a specific resource factory for the given file extension to the resource factory registry. This allows to use
   * custom resource factories that usually extend {@link org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl}.
   *
   * @param extension the file extension (without the period)
   * @param resourceFactory the specific resource factory to use
   */
  public void addResourceFactory(String extension, Resource.Factory resourceFactory) {
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(extension, resourceFactory);
  }

  @Deprecated
  public Resource loadResource(String file) {
    return resourceSet.getResource(URI.createFileURI(file), true);
  }

  @Deprecated
  public void saveResource(EObject model, String file) {
    Resource resource = resourceSet.createResource(URI.createFileURI(file));
    resource.getContents().add(model);
    try {
      resource.save(Collections.EMPTY_MAP);
    } catch (IOException e) {
      System.err.println("Error saving model: " + e.getLocalizedMessage());
    }
  }

  /**
   * Returns the class diagram at the given *.cdm file.
   */
  public static ClassDiagram cdmFromFile(File file) {
    CdmPackage.eINSTANCE.eClass();
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cdm", new CdmResourceFactoryImpl());
    try {
      var cdmResource = rset.createResource(URI.createFileURI(file.getCanonicalPath()));
      cdmResource.load(Collections.EMPTY_MAP);
      return (ClassDiagram) cdmResource.getContents().get(0);
    } catch (IOException e) {
      return null;
    }
  }

  /**
   * Returns the class diagram at the given *.cdm file path.
   */
  public static ClassDiagram cdmFromFile(String path) {
    return cdmFromFile(new File(path));
  }

  @SuppressWarnings("unchecked") // needed due to lack of union types in Java
  public static void saveToFiles(Object... params) {
    if (params == null || params.length == 0) {
      return;
    }
    var paramList = Arrays.asList(params);
    if (!paramList.stream().allMatch(p -> p instanceof String || p instanceof EObject)
        || !(params[0] instanceof String) || params[params.length - 1] instanceof String) {
      throw new IllegalArgumentException("Invalid input type, only String or EObject allowed.");
    }

    Map<String, List<EObject>> filesToEObjects = new HashMap<String, List<EObject>>();
    String mostRecentFile = null;
    for (var p: paramList) {
      if (p instanceof String) {
        mostRecentFile = (String) p; // rewrite in Java 16+
        filesToEObjects.put(mostRecentFile, new ArrayList<EObject>());
      } else {
        filesToEObjects.get(mostRecentFile).add((EObject) p);
      }
    }

    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().putAll(Map.of(
        "cdm", new CdmResourceFactoryImpl(),
        LearningcorpusPackage.eNAME, new LearningcorpusResourceFactoryImpl(),
        ModelingassistantPackage.eNAME, new ModelingassistantResourceFactoryImpl()));

    Map<String, Resource> filesToResources = new HashMap<String, Resource>();
    filesToEObjects.forEach((file, itemList) -> {
      try {
        var resource = rset.createResource(URI.createFileURI(new File(file).getCanonicalPath()));
        resource.getContents().addAll(itemList);
        filesToResources.put(file, resource);
      } catch (IOException e) {
        System.err.println("Failed to open file " + file + " with error: " + e);
      }
    });

    filesToEObjects.forEach((file, itemList) -> {
      try {
        filesToResources.get(file).save(Collections.EMPTY_MAP);
      } catch (IOException e) {
        System.err.println("Failed to save model(s) to file " + file + " with error: " + e);
      }
    });
  }

}
