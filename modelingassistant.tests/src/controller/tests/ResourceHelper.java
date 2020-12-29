package controller.tests;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * Utility class that provides means to load and save resources.
 * It uses the default XMI resource factory for any kind of resource, however,
 * specific resource factories can be registered for specific file extensions.
 * 
 * @author Matthias Schoettle <mschoettle (at) cs.mcgill.ca>
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
        
        /**
         * Register default XMI factory implementation for any extension.
         * Requires bundle org.eclipse.emf.ecore.xmi.
         */
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
    }
    
    /**
     * Adds a specific resource factory for the given file extension to the resource factory registry.
     * This allows to use custom resource factories that usually extend {@link org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl}.
     * 
     * @param extension the file extension (without the period)
     * @param resourceFactory the specific resource factory to use
     */
    public void addResourceFactory(String extension, Resource.Factory resourceFactory) {
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(extension, resourceFactory);
    }
    
    public Resource loadResource(String file) {
        Resource resource = resourceSet.getResource(URI.createFileURI(file), true);
        
        return resource;
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
