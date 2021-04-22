
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

		 public static final MistakeTypeCategory Wrong_class  = MISTAKE_TYPE_CATEGORIES_BY_NAME.get("Wrong_class");
		 public static final MistakeTypeCategory Wrong_enumeration  = MISTAKE_TYPE_CATEGORIES_BY_NAME.get("Wrong_enumeration");
		 public static final MistakeTypeCategory Wrong_class_name  = MISTAKE_TYPE_CATEGORIES_BY_NAME.get("Wrong_class_name");
		 public static final MistakeTypeCategory Wrong_attribute  = MISTAKE_TYPE_CATEGORIES_BY_NAME.get("Wrong_attribute");
		 public static final MistakeTypeCategory Extra_(redundant)_attribute  = MISTAKE_TYPE_CATEGORIES_BY_NAME.get("Extra_(redundant)_attribute");
		 public static final MistakeTypeCategory Wrong_attribute_name  = MISTAKE_TYPE_CATEGORIES_BY_NAME.get("Wrong_attribute_name");
		 public static final MistakeTypeCategory Attribute_in_wrong_class  = MISTAKE_TYPE_CATEGORIES_BY_NAME.get("Attribute_in_wrong_class");
		 public static final MistakeTypeCategory Wrong_relationships  = MISTAKE_TYPE_CATEGORIES_BY_NAME.get("Wrong_relationships");
		 public static final MistakeTypeCategory Missing_relationship_of_any_type  = MISTAKE_TYPE_CATEGORIES_BY_NAME.get("Missing_relationship_of_any_type");
 

  // Mistake types
		public static final MistakeType Missing_class = MISTAKE_TYPES_BY_NAME.get("Missing_class");
		public static final MistakeType Extra_(redundant)_class = MISTAKE_TYPES_BY_NAME.get("Extra_(redundant)_class");
		public static final MistakeType Using_plural_or_lowercase = MISTAKE_TYPES_BY_NAME.get("Using_plural_or_lowercase");
		public static final MistakeType Software_engineering_term = MISTAKE_TYPES_BY_NAME.get("Software_engineering_term");
		public static final MistakeType Bad_class_name_spelling = MISTAKE_TYPES_BY_NAME.get("Bad_class_name_spelling");
		public static final MistakeType Similar_(yet_incorrect)_class_name = MISTAKE_TYPES_BY_NAME.get("Similar_(yet_incorrect)_class_name");
		public static final MistakeType Regular_class_should_be_an_enumeration_or_vice_versa = MISTAKE_TYPES_BY_NAME.get("Regular_class_should_be_an_enumeration_or_vice_versa");
		public static final MistakeType Wrong_enumeration_items = MISTAKE_TYPES_BY_NAME.get("Wrong_enumeration_items");
		public static final MistakeType Missing_attribute = MISTAKE_TYPES_BY_NAME.get("Missing_attribute");
		public static final MistakeType Plural_attribute_or_attribute_list = MISTAKE_TYPES_BY_NAME.get("Plural_attribute_or_attribute_list");
		public static final MistakeType Other_extra_attribute = MISTAKE_TYPES_BY_NAME.get("Other_extra_attribute");
		public static final MistakeType Bad_attribute_name_spelling = MISTAKE_TYPES_BY_NAME.get("Bad_attribute_name_spelling");
		public static final MistakeType Similar_(yet_incorrect)_attribute_name = MISTAKE_TYPES_BY_NAME.get("Similar_(yet_incorrect)_attribute_name");
		public static final MistakeType Wrong_attribute_type = MISTAKE_TYPES_BY_NAME.get("Wrong_attribute_type");
		public static final MistakeType Attribute_misplaced = MISTAKE_TYPES_BY_NAME.get("Attribute_misplaced");
		public static final MistakeType Attribute_duplicated_(eg,_in_a_subclass) = MISTAKE_TYPES_BY_NAME.get("Attribute_duplicated_(eg,_in_a_subclass)");
		public static final MistakeType Attribute_expected_to_be_static_but_is_not_or_vice_versa = MISTAKE_TYPES_BY_NAME.get("Attribute_expected_to_be_static_but_is_not_or_vice_versa");
		public static final MistakeType Using_an_attribute_instead_of_an_association = MISTAKE_TYPES_BY_NAME.get("Using_an_attribute_instead_of_an_association");
  

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
