
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
  private static final Map<String, MistakeTypeCategory> MTS = MISTAKE_TYPES_BY_NAME;

  static {
    var modelingAssistant = loadModelingAssistant();
    
    modelingAssistant.getMistaketypecategory().forEach(mtc ->
        MISTAKE_TYPE_CATEGORIES_BY_NAME.put(mtc.getName(), mtc));
    
    modelingAssistant.getMistakeTypes().forEach(mt ->
        MISTAKE_TYPES_BY_NAME.put(mt.getName(), mt));       
  }


  // Mistake type categories

  /** The wrong class mistake type category. */
  public static final MistakeTypeCategory WRONG_CLASS = MTCS.get("Wrong class");

  /** The wrong enumeration mistake type category. */
  public static final MistakeTypeCategory WRONG_ENUMERATION = MTCS.get("Wrong enumeration");

  /** The wrong class name mistake type category. */
  public static final MistakeTypeCategory WRONG_CLASS_NAME = MTCS.get("Wrong class name");

  /** The wrong attribute mistake type category. */
  public static final MistakeTypeCategory WRONG_ATTRIBUTE = MTCS.get("Wrong attribute");

  /** The extra (redundant) attribute mistake type category. */
  public static final MistakeTypeCategory EXTRA_ATTRIBUTE = MTCS.get("Extra (redundant) attribute");

  /** The wrong attribute name mistake type category. */
  public static final MistakeTypeCategory WRONG_ATTRIBUTE_NAME = MTCS.get("Wrong attribute name");

  /** The attribute in wrong class mistake type category. */
  public static final MistakeTypeCategory ATTRIBUTE_IN_WRONG_CLASS = MTCS.get("Attribute in wrong class");

  /** The wrong relationships mistake type category. */
  public static final MistakeTypeCategory WRONG_RELATIONSHIPS = MTCS.get("Wrong relationships");

  /** The missing relationship of any type mistake type category. */
  public static final MistakeTypeCategory MISSING_RELATIONSHIP_OF_ANY_TYPE =
      MTCS.get("Missing relationship of any type");

  /** The wrong generalization mistake type category. */
  public static final MistakeTypeCategory WRONG_GENERALIZATION = MTCS.get("Wrong Generalization");


  // Mistake types

  /** The missing class mistake type. */
  public static final MistakeType MISSING_CLASS = MTS.get("Missing class");

  /** The extra (redundant) class mistake type. */
  public static final MistakeType EXTRA_CLASS = MTS.get("Extra (redundant) class");

  /** The using plural or lowercase mistake type. */
  public static final MistakeType USING_PLURAL_OR_LOWERCASE = MTS.get("Using plural or lowercase");

  /** The software engineering term mistake type. */
  public static final MistakeType SOFTWARE_ENGINEERING_TERM = MTS.get("Software engineering term");

  /** The bad class name spelling mistake type. */
  public static final MistakeType BAD_CLASS_NAME_SPELLING = MTS.get("Bad class name spelling");

  /** The similar (yet incorrect) class name mistake type. */
  public static final MistakeType SIMILAR_CLASS_NAME = MTS.get("Similar (yet incorrect) class name");

  /** The regular class should be an enumeration or vice versa mistake type. */
  public static final MistakeType REGULAR_CLASS_SHOULD_BE_AN_ENUMERATION_OR_VICE_VERSA =
      MTS.get("Regular class should be an enumeration or vice versa");

  /** The wrong enumeration items mistake type. */
  public static final MistakeType WRONG_ENUMERATION_ITEMS = MTS.get("Wrong enumeration items");

  /** The missing attribute mistake type. */
  public static final MistakeType MISSING_ATTRIBUTE = MTS.get("Missing attribute");

  /** The plural attribute or attribute list mistake type. */
  public static final MistakeType PLURAL_ATTRIBUTE_OR_ATTRIBUTE_LIST = MTS.get("Plural attribute or attribute list");

  /** The other extra attribute mistake type. */
  public static final MistakeType OTHER_EXTRA_ATTRIBUTE = MTS.get("Other extra attribute");

  /** The bad attribute name spelling mistake type. */
  public static final MistakeType BAD_ATTRIBUTE_NAME_SPELLING = MTS.get("Bad attribute name spelling");

  /** The similar (yet incorrect) attribute name mistake type. */
  public static final MistakeType SIMILAR_ATTRIBUTE_NAME = MTS.get("Similar (yet incorrect) attribute name");

  /** The wrong attribute type mistake type. */
  public static final MistakeType WRONG_ATTRIBUTE_TYPE = MTS.get("Wrong attribute type");

  /** The attribute misplaced mistake type. */
  public static final MistakeType ATTRIBUTE_MISPLACED = MTS.get("Attribute misplaced");

  /** The attribute duplicated (eg, in a subclass) mistake type. */
  public static final MistakeType ATTRIBUTE_DUPLICATED_ = MTS.get("Attribute duplicated (eg, in a subclass)");

  /** The attribute expected to be static but is not or vice versa mistake type. */
  public static final MistakeType ATTRIBUTE_EXPECTED_TO_BE_STATIC_BUT_IS_NOT_OR_VICE_VERSA =
      MTS.get("Attribute expected to be static but is not or vice versa");

  /** The using an attribute instead of an association mistake type. */
  public static final MistakeType USING_AN_ATTRIBUTE_INSTEAD_OF_AN_ASSOCIATION =
      MTS.get("Using an attribute instead of an association");

  /** The missing generalization mistake type. */
  public static final MistakeType MISSING_GENERALIZATION = MTS.get("Missing Generalization");

  /** The does not follow isa rule mistake type. */
  public static final MistakeType DOES_NOT_FOLLOW_ISA_RULE = MTS.get("Does not follow isA rule");


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
