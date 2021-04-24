package modelingassistant.mistaketypes;

import java.io.File;
import java.io.IOException;
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
 * This class contains all mistake types and categories.
 */
public class MistakeTypes {

  /** The path of the modeling assistant instance with mistake types. */
  public static final String MODELING_ASSISTANT_WITH_MISTAKE_TYPES_PATH =
      "../modelingassistant.visualization.instances/MA1.modelingassistant";

  /** Map of mistake type categories by name. */
  public static final Map<String, MistakeTypeCategory> MISTAKE_TYPE_CATEGORIES_BY_NAME =
      new HashMap<String, MistakeTypeCategory>();

  /** Map of mistake types by name. */
  public static final Map<String, MistakeType> MISTAKE_TYPES_BY_NAME = new HashMap<String, MistakeType>();

  // Short-name references to the above maps for greater code legibility
  private static final Map<String, MistakeTypeCategory> MTCS = MISTAKE_TYPE_CATEGORIES_BY_NAME;
  private static final Map<String, MistakeType> MTS = MISTAKE_TYPES_BY_NAME;

  static {
    var modelingAssistant = loadModelingAssistant();
    
    modelingAssistant.getMistaketypecategory().forEach(mtc ->
        MISTAKE_TYPE_CATEGORIES_BY_NAME.put(mtc.getName(), mtc));
    
    modelingAssistant.getMistakeTypes().forEach(mt ->
        MISTAKE_TYPES_BY_NAME.put(mt.getName(), mt));       
  }


  // Mistake type categories

  /** The wrong relationships mistake type category. */
  public static final MistakeTypeCategory WRONG_RELATIONSHIPS = MTCS.get("Wrong relationships");

  /** The wrong multiplicities mistake type category. */
  public static final MistakeTypeCategory WRONG_MULTIPLICITIES = MTCS.get("Wrong multiplicities");

  /** The wrong role names mistake type category. */
  public static final MistakeTypeCategory WRONG_ROLE_NAMES = MTCS.get("Wrong role names");


  // Mistake types

  /** The other wrong multiplicity mistake type. */
  public static final MistakeType OTHER_WRONG_MULTIPLICITY = MTS.get("Other wrong multiplicity");

  /** The infinite recursive dependency mistake type. */
  public static final MistakeType INFINITE_RECURSIVE_DEPENDENCY = MTS.get("Infinite recursive dependency");

  /** The missing role names mistake type. */
  public static final MistakeType MISSING_ROLE_NAMES = MTS.get("Missing role names");

  /** The role names present but incorrect mistake type. */
  public static final MistakeType ROLE_NAMES_PRESENT_BUT_INCORRECT = MTS.get("Role names present but incorrect");

  /** The role expected to be static but is not or vice versa mistake type. */
  public static final MistakeType ROLE_EXPECTED_TO_BE_STATIC_BUT_IS_NOT_OR_VICE_VERSA =
      MTS.get("Role expected to be static but is not or vice versa");

  /** The bad role name spelling mistake type. */
  public static final MistakeType BAD_ROLE_NAME_SPELLING = MTS.get("Bad role name spelling");

  /** The similar (yet incorrect) role name mistake type. */
  public static final MistakeType SIMILAR_ROLE_NAME = MTS.get("Similar (yet incorrect) role name");


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

}
