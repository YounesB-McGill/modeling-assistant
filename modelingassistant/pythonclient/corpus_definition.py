"""
Learning Corpus definition file. The corpus mistake types and learning items are defined here in a
DSL-style, as well as the mistake type priorities.

The actual corpus initialization is done in the corpus.py file.
"""

from textwrap import dedent
from learningcorpus.learningcorpus import (Example, Feedback, LearningCorpus, MistakeType, ParametrizedResponse,
    ResourceResponse, TextResponse)
from utils import mtc, mt, fbs


corpus = LearningCorpus(mistakeTypeCategories=[
    class_mistakes := mtc(n="Class mistakes",
        mistakeTypes=[
            missing_class := mt(n="Missing class", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Make sure you have modeled all the classes in the problem description."),
                3: Feedback(highlightProblem=True),
                4: ParametrizedResponse(text="Remember to add the ${className} class."),
            })),
            extra_class := mt(n="Extra (redundant) class", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Make sure you only model the concepts mentioned in the problem description."),
                3: TextResponse(text="You have an extra class. Can you find it?"),
                4: [ParametrizedResponse(text="The ${className} class is not part of the domain, so please remove it."),
                    ParametrizedResponse(text="Remember that a domain model should not contain concepts from the user "
                        "interfaces or databases, like Window, Database, etc.")],
            })),
            using_nary_assoc_instead_of_intermediate_class := mt(
                n="Using n-ary assoc instead of intermediate class",
                d="Using n-ary association instead of intermediate class",
                feedbacks=[]),
        ],
        subcategories=[
            class_name_mistakes := mtc(n="Class name mistakes", mistakeTypes=[
                plural_class_name := mt(n="Plural class name", atomic=True, feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Remember that class names should be singular."),
                    3: ParametrizedResponse(text="${className} should be ${pascalCase(className)}, "
                        "with a Capital Letter."),
                    4: ResourceResponse(learningResources=[Example(content=(correct_class_naming_example := dedent("""\
                        Please note these examples of correct vs incorrect class naming:
                        :x: Examples to avoid | :heavy_check_mark: Good class names
                        --- | ---
                        pilot | Pilot
                        Airplanes | Airplane 
                        AirlineData | Airline""")))]),
                })),
                lowercase_class_name := mt(n="Lowercase class name", atomic=True, feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Remember that class names must start with a Capital Letter."),
                    3: ParametrizedResponse(text="${className} should be ${singular(className)}, using the singular."),
                    4: ResourceResponse(learningResources=[Example(content=correct_class_naming_example)]),
                })),
                software_engineering_term := mt(n="Software engineering term", atomic=True, feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Remember that a domain model should not contain software engineering terms."),
                    3: ParametrizedResponse(
                        text="${className} is a software engineering term, which does not belong in a domain model."),
                    4: ResourceResponse(learningResources=[Example(content=correct_class_naming_example)]),
                })),
                bad_class_name_spelling := mt(n="Bad class name spelling", atomic=True, feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Can you double check this class name?"),
                    3: ParametrizedResponse(text="The ${incorrectlySpelledClassName} class has a misspelled name."),
                    4: ParametrizedResponse(
                        text="The ${incorrectlySpelledClassName} class should be changed to ${correctClassName}."),
                })),
                similar_class_name := mt(n="Similar (yet incorrect) class name", feedbacks=fbs({ # TODO Remove
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Can you double check this class name?"),
                    3: ParametrizedResponse(
                        text="The ${similarYetIncorrectClassName} class has a name that is not quite right."),
                    4: ParametrizedResponse(
                        text="TThe ${similarYetIncorrectClassName} class should be changed to ${correctClassName}.")
                })),
                wrong_class_name := mt(n="Wrong class name", feedbacks=fbs({  # Renamed from "Other wrong class name"
                })),
            ]),
            enumeration_mistakes := mtc(n="Enumeration mistakes", mistakeTypes=[
                class_should_be_enum := mt(n="Class should be enum", d="Regular class should be enumeration"),
                enum_should_be_class := mt(n="Enum should be class", d="Enumeration should be regular class"),
                missing_enum := mt(n="Missing enum", d="Missing enumeration"),
                extra_enum := mt(n="Extra enum", d="Extra enumeration"),
                bad_enum_name_spelling := mt(n="Bad enum name spelling", d="Bad enumeration name spelling"),
                similar_enum_name := mt(n="Similar enum name", d="Similar enumeration name"), #TODO Remove
                missing_enum_item := mt(n="Missing enum item", d="Missing enumeration item"),
                extra_enum_item := mt(n="Extra enum item", d="Extra enumeration item"),
                bad_enum_item_spelling := mt(n="Bad enum item spelling", d="Bad enumeration item spelling"),
                similar_enum_item := mt(n="Similar enum item", d="Similar enumeration item"), #TODO Remove
            ]),
        ]
    ),

    attribute_mistakes := mtc(n="Attribute mistakes",
        mistakeTypes=[
            missing_attribute := mt(n="Missing attribute"),
            wrong_attribute_type := mt(n="Wrong attribute type"),
            missing_attribute_type := mt(n="Missing attribute type"), # Added
            attribute_should_be_static := mt(n="Attribute should be static"),
            attribute_should_not_be_static := mt(n="Attribute should not be static"),
        ],
        subcategories=[
            extra_attribute_mistakes := mtc(n="Extra attribute mistakes", mistakeTypes=[
                plural_attribute := mt(n="Plural attribute"),
                list_attribute := mt(n="List attribute"),
                other_extra_attribute := mt(n="Extra attribute"),  # Was "Other extra attribute"
            ]),
            wrong_attribute_name_mistakes := mtc(n="Wrong attribute name mistakes", mistakeTypes=[
                bad_attribute_name_spelling := mt(n="Bad attribute name spelling"),
                uppercase_attribute_name := mt(n="Uppercase attribute name"),
                similar_attribute_name := mt(n="Similar (yet incorrect) attribute name"), # TODO Remove
            ]),
            attribute_in_wrong_class := mtc(n="Attribute in wrong class mistakes", mistakeTypes=[
                attribute_misplaced := mt(n="Attribute misplaced"),
                attribute_duplicated := mt(n="Attribute duplicated"),
                attribute_misplaced_in_generalized_hierarchy := mt(
                    n="Attribute misplaced in generalization hierarchy"), # Added
            ]),
        ]
    ),

    relationship_mistakes := mtc(n="Relationship mistakes", subcategories=[
        association_mistakes := mtc(n="Association mistakes", subcategories=[
            missing_association_mistakes := mtc(n="Missing association mistakes", mistakeTypes=[
                missing_association := mt(n="Missing association"),
                missing_aggregation := mt(n="Missing aggregation"),
                missing_nary_association := mt(n="Missing n-ary association"), # Added
                using_attribute_instead_of_assoc := mt(
                    n="Using attribute instead of assoc",
                    d="Using attribute instead of association"),
            ]),
            extra_association_mistakes := mtc(n="Extra association mistakes", mistakeTypes=[
                representing_action_with_assoc := mt(
                    n="Representing action with assoc",
                    d="Representing an action with an association"),
                composed_part_contained_in_more_than_one_parent := mt(
                    n="Composed part contained in more than one parent"),  # TODO Move
                extra_association := mt(n="Extra association"),  # Was "Other extra association"
                extra_aggregation := mt(n="Extra aggregation"), # Added
                extra_nary_association := mt(n="Extra n-ary association"), # Added
            ]),
            association_type_mistakes := mtc(n="Association type mistakes", mistakeTypes=[
                using_aggregation_composition_instead_of_assoc := mt(
                    n="Using aggregation/composition instead of assoc",
                    d="Using aggregation/composition instead of association"),
                using_directed_assoc_instead_of_undirected := mt(
                    n="Using directed assoc instead of undirected",
                    d="Using directed association instead of undirected association"),
                using_undirected_association_instead_of_directed := mt(
                    n="Using undirected assoc instead of directed",
                    d="Using undirected association instead of directed association"),
                using_composition_instead_of_aggregation := mt(n="Using composition instead of aggregation"),
                using_binary_assoc_instead_of_nary_assoc := mt(
                    n="Using binary assoc instead of n-ary assoc",
                    d="Using binary association instead of n-ary association"), # Added
                using_nary_assoc_instead_of_binary_assoc := mt(
                    n="Using n-ary assoc instead of binary assoc",
                    d="Using n-ary association instead of binary association"), # Added
                using_intermediate_class_instead_of_nary_assoc := mt(
                    n="Using intermediate class instead of n-ary assoc",
                    d="Using intermediate class instead of n-ary association"), # Added
            ]),
            association_name_mistakes := mtc(n="Association name mistakes", mistakeTypes=[
                # TODO Rename to Missing association name.
                missing_association_name := mt(n="Missing association name",
                    d="Missing association name when one was expected"),
                bad_association_name_spelling := mt(n="Bad association name spelling"),
                similar_association_name := mt(n="Similar (yet incorrect) association name"), # TODO Remove
            ]),
            multiplicity_mistakes := mtc(n="Multiplicity mistakes", mistakeTypes=[
                infinite_recursive_dependency := mt(n="Infinite recursive dependency"),
                wrong_multiplicity := mt(n="Wrong multiplicity"),  # Was "Other wrong multiplicity"
                missing_multiplicity := mt(n="Missing multiplicity"), # Added
            ]),
            role_name_mistakes := mtc(n="Role name mistakes", mistakeTypes=[
                missing_role_names := mt(n="Missing role names"),
                role_should_be_static := mt(n="Role should be static"),
                role_should_not_be_static := mt(n="Role should not be static"),
                bad_role_name_spelling := mt(n="Bad role name spelling"),
                similar_role_name := mt(n="Similar (yet incorrect) role name"), # TODO Remove
                wrong_role_name := mt(n="Wrong role name",
                    d="Wrong role name but correct association"), # Was "Other wrong role name"
            ]),
            association_class_mistakes := mtc(n="Association class mistakes", mistakeTypes=[
                missing_association_class := mt(n="Missing assoc class", d="Missing association class"),
                # Renamed to remove "(redundant)"
                extra_association_class := mt(n="Extra assoc class", d="Extra association class"),
                bad_assoc_class_name_spelling := mt(n="Bad assoc class name spelling",
                    d="Bad association class name spelling"),
                assoc_class_should_be_class := mt(n="Assoc class should be class",
                    d="Association class should be regular class"), # Added
                class_should_be_assoc_class := mt(n="Class should be assoc class",
                    d="Regular class should be association class"), # Added
                similar_assoc_class_name := mt(n="Similar assoc class name",
                    d="Similar (yet incorrect) association class name"), # Remove
            ]),
        ]),
        composition_mistakes := mtc(n="Composition mistakes", mistakeTypes=[
            missing_composition := mt(n="Missing composition"),
            extra_composition := mt(n="Extra composition"), # Added
            # TODO Split into two mistakes
            using_association_instead_of_aggregation_composition := mt(
                n="Using association instead of aggregation/composition"),
            using_aggregation_instead_of_composition := mt(n="Using aggregation instead of composition"),
            incomplete_containment_tree := mt(n="Incomplete containment tree"),
        ]),
        generalization_mistakes := mtc(n="Generalization mistakes", mistakeTypes=[
            missing_generalization := mt(n="Missing generalization"),
            extra_generalization := mt(n="Extra generalization"), # Added
            generalization_inapplicable := mt(n="Generalization inapplicable",
                d="Generalization does not follow isA rule"),
            subclass_not_distinct_across_lifetime := mt(n="Subclass not distinct across lifetime"),
            inherited_feature_does_not_make_sense_for_subclass := mt(
                n="Inherited feature does not make sense for subclass"),
            subclass_is_an_instance_of_superclass := mt(n="Subclass is an instance of superclass"),
            non_differentiated_subclass := mt(n="Non-differentiated subclass"),
            wrong_generalization_direction := mt(n="Wrong generalization direction"),
            wrong_superclass := mt(n="Wrong superclass"),
        ]),
    ]),

    design_pattern_mistakes := mtc(n="Design pattern mistakes", subcategories=[
        player_role_pattern_mistakes := mtc(n="Player-Role Pattern mistakes",
            mistakeTypes=[
                missing_pr_pattern := mt(
                    n="Missing PR pattern",
                    d="Missing Player-Role pattern"),
                incomplete_pr_pattern := mt(
                    n="Incomplete PR pattern",
                    d="Incomplete Player-Role pattern"),
            ],
            subcategories=[
                using_different_player_role_pattern := mtc(n="Using different Player-Role pattern", mistakeTypes=[
                    subclass_should_be_full_pr_pattern := mt(
                        n="Subclass should be full PR pattern",
                        d="Subclass should be full Player-Role pattern"),
                    subclass_should_be_assoc_pr_pattern := mt(
                        n="Subclass should be assoc PR pattern",
                        d="Subclass should be association Player-Role pattern"),
                    subclass_should_be_enum_pr_pattern := mt(
                        n="Subclass should be enum PR pattern",
                        d="Subclass should be enumeration Player-Role pattern"),
                    assoc_should_be_full_pr_pattern := mt(
                        n="Assoc should be full PR pattern",
                        d="Association should be full Player-Role pattern"),
                    assoc_should_be_subclass_pr_pattern := mt(
                        n="Assoc should be subclass PR pattern",
                        d="Association should be subclass Player-Role pattern"),
                    assoc_should_be_enum_pr_pattern := mt(
                        n="Assoc should be enum PR pattern",
                        d="Association should be enumeration Player-Role pattern"),
                    enum_should_be_full_pr_pattern := mt(
                        n="Enum should be full PR pattern",
                        d="Enumeration should be full Player-Role pattern"),
                    enum_should_be_subclass_pr_pattern := mt(
                        n="Enum should be subclass PR pattern",
                        d="Enumeration should be subclass Player-Role pattern"),
                    enum_should_be_assoc_pr_pattern := mt(
                        n="Enum should be assoc PR pattern",
                        d="Enumeration should be association Player-Role pattern"),
                    full_pr_pattern_should_be_subclass := mt(
                        n="Full PR pattern should be subclass",
                        d="Full Player-Role pattern should be subclass"),
                    full_pr_pattern_should_be_assoc := mt(
                        n="Full PR pattern should be assoc",
                        d="Full Player-Role pattern should be association"),
                    full_pr_pattern_should_be_enum := mt(
                        n="Full PR pattern should be enum",
                        d="Full Player-Role pattern should be enumeration"),
                ]),
            ]
        ),
        abstraction_occurrence_pattern_mistakes := mtc(n="Abstraction-Occurrence pattern mistakes", mistakeTypes=[
            missing_ao_pattern := mt(
                n="Missing AO pattern",
                d="Missing Abstraction-Occurrence pattern"),
            incomplete_ao_pattern := mt(
                n="Incomplete AO pattern",
                d="Incomplete Abstraction-Occurrence pattern"),
        ]),
    ]),
])


# mistake types by priority, from most to least important
mts_by_priority: list[MistakeType] = [
    # mistakes in an existing class
    bad_class_name_spelling,
    lowercase_class_name,
    plural_class_name,
    software_engineering_term,
    similar_class_name, # Remove
    wrong_class_name,
    bad_assoc_class_name_spelling,
    similar_assoc_class_name, # Remove
    assoc_class_should_be_class, # Added
    class_should_be_assoc_class, # Added
    class_should_be_enum,
    enum_should_be_class,
    bad_enum_name_spelling,
    bad_enum_item_spelling,
    similar_enum_name, # Remove
    similar_enum_item, # Remove

    # mistakes in an existing attribute
    bad_attribute_name_spelling,
    uppercase_attribute_name,
    plural_attribute,
    similar_attribute_name, # TODO Remove
    attribute_misplaced,
    wrong_attribute_type,
    attribute_should_not_be_static,
    attribute_should_be_static,

    # mistakes in an existing relationship
    infinite_recursive_dependency,
    composed_part_contained_in_more_than_one_parent,
    using_attribute_instead_of_assoc,
    list_attribute,
    attribute_misplaced_in_generalized_hierarchy, # Added
    generalization_inapplicable,
    using_association_instead_of_aggregation_composition,
    using_aggregation_composition_instead_of_assoc,
    using_directed_assoc_instead_of_undirected,
    using_undirected_association_instead_of_directed,
    using_aggregation_instead_of_composition,
    using_composition_instead_of_aggregation,
    using_binary_assoc_instead_of_nary_assoc, # Added
    using_nary_assoc_instead_of_binary_assoc, # Added
    using_nary_assoc_instead_of_intermediate_class, # Added
    using_intermediate_class_instead_of_nary_assoc, # Added
    wrong_generalization_direction,
    wrong_superclass,
    subclass_is_an_instance_of_superclass,
    non_differentiated_subclass,
    subclass_not_distinct_across_lifetime,
    inherited_feature_does_not_make_sense_for_subclass,
    wrong_multiplicity, # Rename to wrong_multiplicity
    missing_multiplicity, # Added
    missing_role_names,
    bad_role_name_spelling,
    similar_role_name, # Remove
    wrong_role_name, # Rename to incorrect_role_name_but_correct_association
    role_should_not_be_static,
    role_should_be_static,
    bad_association_name_spelling,
    similar_association_name, # Remove
    incomplete_containment_tree,

    # design pattern mistakes
    subclass_should_be_full_pr_pattern,
    subclass_should_be_assoc_pr_pattern,
    subclass_should_be_enum_pr_pattern,
    assoc_should_be_full_pr_pattern,
    assoc_should_be_subclass_pr_pattern,
    assoc_should_be_enum_pr_pattern,
    enum_should_be_full_pr_pattern,
    enum_should_be_subclass_pr_pattern,
    enum_should_be_assoc_pr_pattern,
    full_pr_pattern_should_be_subclass,
    full_pr_pattern_should_be_assoc,
    full_pr_pattern_should_be_enum,

    # extra items
    extra_class,
    extra_association_class,
    extra_enum,
    extra_enum_item,
    extra_generalization, # Added
    extra_composition, # Added
    representing_action_with_assoc,
    extra_association, # Rename to extra_association
    extra_aggregation, # Added
    extra_nary_association, # Added
    attribute_duplicated,
    other_extra_attribute, # Rename to extra_attribute

    # missing items
    missing_class,
    missing_attribute,
    missing_attribute_type,
    missing_association_class,
    missing_enum,
    missing_enum_item,
    missing_generalization,
    missing_composition,
    missing_association,
    missing_aggregation,
    missing_nary_association, # Added
    missing_role_names,
    missing_association_name, # Rename to missing_association_name

    # missing/incomplete patterns
    incomplete_pr_pattern,
    incomplete_ao_pattern,
    missing_pr_pattern,
    missing_ao_pattern,
]
