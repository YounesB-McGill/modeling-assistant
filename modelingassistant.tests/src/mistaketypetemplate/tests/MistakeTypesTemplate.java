package mistaketypetemplate.tests;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import modelingassistant.MistakeType;
import modelingassistant.MistakeTypeCategory;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.util.ModelingassistantResourceFactoryImpl;

/**
 * Template for mistake types constants file, used only for testing. The actual mistake types
 * file will resemble this template, with the exceptions listed below.
 * 
 * @author Younes Boubekeur
 */
public class MistakeTypesTemplate {
  
  /** The only class that can call this template. Not included in actual mistake types file. */
  public static final String ALLOWED_CALLER = "MistakeTypeTemplateTests";


  /** The path of the modeling assistant instance with mistake types. */
  public static final String MODELING_ASSISTANT_WITH_MISTAKE_TYPES_PATH =
      "../modelingassistant.visualization.instances/MA1.modelingassistant";

  /** Map of mistake type categories by name. */
  public static final Map<String, MistakeTypeCategory> MISTAKE_TYPE_CATEGORIES_BY_NAME =
      new HashMap<String, MistakeTypeCategory>();

  /** Map of mistake types by name. */
  public static final Map<String, MistakeType> MISTAKE_TYPES_BY_NAME = new HashMap<String, MistakeType>();


  static {
    // Not included in actual mistake types file.
    disallowCallsToThisClassExceptFromTestClass();
    
    var modelingAssistant = loadModelingAssistant();
    modelingAssistant.getMistaketypecategory().forEach(mtc ->
        MISTAKE_TYPE_CATEGORIES_BY_NAME.put(mtc.getName(), mtc));
    modelingAssistant.getMistakeTypes().forEach(mt ->
        MISTAKE_TYPES_BY_NAME.put(mt.getName(), mt));
  }


  // Mistake type categories

  public static final MistakeTypeCategory WRONG_CLASS =
      MISTAKE_TYPE_CATEGORIES_BY_NAME.get("Wrong class");
  
  // Other mistake type categories here...


  // Mistake types

  public static final MistakeType MISSING_CLASS = MISTAKE_TYPES_BY_NAME.get("Missing class");

  //Other mistake types here...


  /**
   * Loads the modeling assistant instance from MODELING_ASSISTANT_WITH_MISTAKE_TYPES_PATH.
   */
  public static ModelingAssistant loadModelingAssistant() {
    ModelingassistantPackage.eINSTANCE.eClass();
    final var path = MODELING_ASSISTANT_WITH_MISTAKE_TYPES_PATH;
    var splitPath = path.split("\\.");
    var fileExtension = splitPath[splitPath.length - 1];
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension,
        new ModelingassistantResourceFactoryImpl());
    try {
      var maResource = rset.createResource(URI.createFileURI(new File(path).getCanonicalPath()));
      maResource.load(Collections.EMPTY_MAP);
      return (ModelingAssistant) maResource.getContents().get(0);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  /**
   * Disallows all use of this class, except by the MistakeTypeTemplateTests test class.
   * Not included in actual mistake types file.
   */
  public static void disallowCallsToThisClassExceptFromTestClass() {
    var stack = Thread.currentThread().getStackTrace();
    Arrays.asList(stack).stream().filter(e -> e.getClassName().contains(ALLOWED_CALLER)).findFirst()
        .orElseThrow(UnsupportedOperationException::new);
  }

}