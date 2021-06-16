# Patching Autogenerated Code

This file documents all the manual patches (edits) that are needed in the
autogenerated code. When making small changes to the metamodel(s), the Java
patches are usually preserved (when marked with `@generated NOT`), but the
patches are lost when the files are removed from disk, eg, when switching
branches or doing a complete project rebuild. In this latter case, copy/paste
the code blocks below in their respective classes as appropriate. The file
paths are intentionally omitted to reduce the burden of maintaining this file,
since they are often renamed or moved.

:warning: Before following the steps here for any file, make sure it is updated.
If the number of patches grows or if this operation needs to be done more often,
create a simple script to automate this process (it can simply read/write files,
no fancy AST manipulation required).

**`LearningCorpus`**

```java
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
```

**`LearningcorpusResourceImpl`**

```java
  /*
   * Manual code added to ensure LearningCorpus instances are serialized using UUIDs.
   */
  @Override protected boolean useUUIDs() {
    return true;
  }
```

**`ModelingassistantResourceImpl`**

```java
  /*
   * Manual code added to ensure ModelingAssistant instances are serialized using UUIDs.
   */
  @Override protected boolean useUUIDs() {
    return true;
  }
```

**`ResourceHelper`**

```java
package modelingassistant.util;

import java.io.IOException;
import java.util.Collections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * Utility class that provides means to load and save resources. It uses the default XMI resource factory for any kind
 * of resource, however, specific resource factories can be registered for specific file extensions.
 *
 * @author Matthias Schoettle <mschoettle (at) cs.mcgill.ca>
 *
 * @generated NOT
 */
public final class ResourceHelper {

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

  public Resource loadResource(String file) {
    return resourceSet.getResource(URI.createFileURI(file), true);
  }

  public void saveResource(EObject model, String file) {
    Resource resource = resourceSet.createResource(URI.createFileURI(file));
    resource.getContents().add(model);
    try {
      resource.save(Collections.EMPTY_MAP);
    } catch (IOException e) {
      System.err.println("Error saving model: " + e.getLocalizedMessage());
    }
  }

}

```