
import modelingassistant.util.ModelingassistantResourceFactoryImpl;

public class MistakeTypesTemplate {
  
  
  /** Map of mistake type categories by name. */
  public static final Map<String, MistakeTypeCategory> MISTAKE_TYPE_CATEGORIES_BY_NAME =
      new HashMap<String, MistakeTypeCategory>();

  /** Map of mistake types by name. */
  public static final Map<String, MistakeType> MISTAKE_TYPES_BY_NAME = new HashMap<String, MistakeType>();


  static {
    // Not included in actual mistake types file.
    disallowCallsToThisClassExceptFromTestClass();

		MISTAKE_TYPES_BY_NAME.put(Missing_class, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@598a942b (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Extra_(redundant)_class, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@46ec57b8 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Using_plural_or_lowercase, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@6a5d2e1a (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Software_engineering_term, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@35280138 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Bad_class_name_spelling, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@388ee07a (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Similar_(yet_incorrect)_class_name, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@1c7b3144 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Regular_class_should_be_an_enumeration_or_vice_versa, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@1fd5e12f (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Wrong_enumeration_items, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@6a81122c (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Missing_attribute, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@25c3b236 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Plural_attribute_or_attribute_list, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@60f756db (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Other_extra_attribute, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@501b0f73 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Bad_attribute_name_spelling, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@32e9772e (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Similar_(yet_incorrect)_attribute_name, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@a832147 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Wrong_attribute_type, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@5098ef42 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Attribute_misplaced, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@58f012b5 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Attribute_duplicated_(eg,_in_a_subclass), org.eclipse.emf.ecore.impl.DynamicEObjectImpl@21d94e82 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Attribute_expected_to_be_static_but_is_not_or_vice_versa, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@3243dae7 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Using_an_attribute_instead_of_an_association, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@2536c112 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		MISTAKE_TYPES_BY_NAME.put(Mistake1, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@7d8b0abb (eClass: org.eclipse.emf.ecore.impl.EClassImpl@76610489 (name: MistakeType) (instanceClassName: null) (abstract: false, interface: false))));
		 MISTAKE_TYPE_CATEGORIES_BY_NAME.put(Wrong_class, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@16cdf6d6 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@52f3d5a9 (name: MistakeTypeCategory) (instanceClassName: null) (abstract: false, interface: false))));
		 MISTAKE_TYPE_CATEGORIES_BY_NAME.put(Wrong_enumeration, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@3a75920a (eClass: org.eclipse.emf.ecore.impl.EClassImpl@52f3d5a9 (name: MistakeTypeCategory) (instanceClassName: null) (abstract: false, interface: false))));
		 MISTAKE_TYPE_CATEGORIES_BY_NAME.put(Wrong_class_name, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@2958ea07 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@52f3d5a9 (name: MistakeTypeCategory) (instanceClassName: null) (abstract: false, interface: false))));
		 MISTAKE_TYPE_CATEGORIES_BY_NAME.put(Wrong_attribute, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@ca3f345 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@52f3d5a9 (name: MistakeTypeCategory) (instanceClassName: null) (abstract: false, interface: false))));
		 MISTAKE_TYPE_CATEGORIES_BY_NAME.put(Extra_(redundant)_attribute, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@7521df41 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@52f3d5a9 (name: MistakeTypeCategory) (instanceClassName: null) (abstract: false, interface: false))));
		 MISTAKE_TYPE_CATEGORIES_BY_NAME.put(Wrong_attribute_name, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@63d2f62d (eClass: org.eclipse.emf.ecore.impl.EClassImpl@52f3d5a9 (name: MistakeTypeCategory) (instanceClassName: null) (abstract: false, interface: false))));
		 MISTAKE_TYPE_CATEGORIES_BY_NAME.put(Attribute_in_wrong_class, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@db42082 (eClass: org.eclipse.emf.ecore.impl.EClassImpl@52f3d5a9 (name: MistakeTypeCategory) (instanceClassName: null) (abstract: false, interface: false))));
		 MISTAKE_TYPE_CATEGORIES_BY_NAME.put(Wrong_relationships, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@1e1ec3aa (eClass: org.eclipse.emf.ecore.impl.EClassImpl@52f3d5a9 (name: MistakeTypeCategory) (instanceClassName: null) (abstract: false, interface: false))));
		 MISTAKE_TYPE_CATEGORIES_BY_NAME.put(Missing_relationship_of_any_type, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@65bedcff (eClass: org.eclipse.emf.ecore.impl.EClassImpl@52f3d5a9 (name: MistakeTypeCategory) (instanceClassName: null) (abstract: false, interface: false))));
		 MISTAKE_TYPE_CATEGORIES_BY_NAME.put(MistakeCat1, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@11293dfb (eClass: org.eclipse.emf.ecore.impl.EClassImpl@52f3d5a9 (name: MistakeTypeCategory) (instanceClassName: null) (abstract: false, interface: false))));
		 MISTAKE_TYPE_CATEGORIES_BY_NAME.put(Cat2, org.eclipse.emf.ecore.impl.DynamicEObjectImpl@3d35bf6c (eClass: org.eclipse.emf.ecore.impl.EClassImpl@52f3d5a9 (name: MistakeTypeCategory) (instanceClassName: null) (abstract: false, interface: false))));
            
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
		 public static final MistakeTypeCategory MistakeCat1  = MISTAKE_TYPE_CATEGORIES_BY_NAME.get("MistakeCat1");
		 public static final MistakeTypeCategory Cat2  = MISTAKE_TYPE_CATEGORIES_BY_NAME.get("Cat2");
 

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
		public static final MistakeType Mistake1 = MISTAKE_TYPES_BY_NAME.get("Mistake1");
  

  /**
   * Loads the modeling assistant instance from MODELING_ASSISTANT_WITH_MISTAKE_TYPES_PATH.
   */
  public static ModelingAssistant loadModelingAssistant() {
    ModelingassistantPackage.eINSTANCE.eClass();
    final var path = MODELING_ASSISTANT_WITH_MISTAKE_TYPES_PATH;
    var splitPath = path.split("\\.");
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
