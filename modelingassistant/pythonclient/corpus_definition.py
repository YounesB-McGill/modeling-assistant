"""
Learning Corpus definition file. The corpus mistake types and learning items are defined here in a
DSL-style, as well as the mistake type priorities.

The actual corpus initialization is done in the corpus.py file.
"""

from textwrap import dedent
from learningcorpus.learningcorpus import (Example, Feedback, LearningCorpus, MistakeType, ParametrizedResponse,
    ResourceResponse, TextResponse)
from utils import mtc, mt


corpus = LearningCorpus(mistakeTypeCategories=[
    class_mistakes := mtc(n="Class mistakes",
        mistakeTypes=[
            missing_class := mt(n="Missing class", feedbacks=[
                Feedback(level=1, highlightSolution=True),
                TextResponse(level=2, text="Make sure you have modeled all the classes in the problem description."),
                Feedback(level=3, highlightProblem=True),
                ParametrizedResponse(level=4, text="Remember to add the ${className} class.")
            ]),
            extra_class := mt(n="Extra (redundant) class"),
        ],
        subcategories=[
            class_name_mistakes := mtc(n="Class name mistakes", mistakeTypes=[
                plural_class_name := mt(n="Plural class name"),
                lowercase_class_name := mt(n="Lowercase class name"),
                software_engineering_term := mt(n="Software engineering term", atomic=True, feedbacks=[
                    Feedback(level=1, highlightSolution=True),
                    TextResponse(level=2,
                        text="Remember that a domain model should not contain software engineering terms."),
                    ParametrizedResponse(level=3,
                        text="${className} is a software engineering term, which does not belong in a domain model."),
                    ResourceResponse(level=4,
                        learningResources=[Example(content=dedent("""\
                            Please note these examples of correct vs incorrect class naming:
                            :x: Examples to avoid | :heavy_check_mark: Good class names
                            --- | ---
                            pilot | Pilot
                            Airplanes | Airplane 
                            AirlineData | Airline"""))]
                    ),
                ]),
                bad_class_name_spelling := mt(n="Bad class name spelling", atomic=True, feedbacks=[
                    Feedback(level=1, highlightSolution=True),
                    TextResponse(level=2, text="Can you double check this class name?"),
                    ParametrizedResponse(level=3,
                        text="The ${incorrectlySpelledClassName} class has a misspelled name."),
                    ParametrizedResponse(level=4,
                        text="The ${incorrectlySpelledClassName} class should be changed to ${correctClassName}."),
                ]),
                similar_class_name := mt(n="Similar (yet incorrect) class name"), # TODO Remove
                wrong_class_name := mt(n="Wrong class name"), # Renamed from "Other wrong class name"
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
    wrong_attribute := mtc(n="Wrong attribute", mistakeTypes=[
        missing_attribute := mt(n="Missing attribute"),
        wrong_attribute_type := mt(n="Wrong attribute type"),
        missing_attribute_type := mt(n="Missing attribute type"), # Added
        attribute_should_be_static := mt(n="Attribute should be static"),
        attribute_should_not_be_static := mt(n="Attribute should not be static"),
    ]),
    extra_attribute := mtc(n="Extra (redundant) attribute", s=wrong_attribute, mistakeTypes=[
        plural_attribute := mt(n="Plural attribute"),
        list_attribute := mt(n="List attribute"),
        other_extra_attribute := mt(n="Other extra attribute"), # Rename to Extra Attribute
    ]),
    wrong_attribute_name := mtc(n="Wrong attribute name", s=wrong_attribute, mistakeTypes=[
        bad_attribute_name_spelling := mt(n="Bad attribute name spelling"),
        uppercase_attribute_name := mt(n="Uppercase attribute name"),
        similar_attribute_name := mt(n="Similar (yet incorrect) attribute name"), # TODO Remove
    ]),
    attribute_in_wrong_class := mtc(n="Attribute in wrong class", s=wrong_attribute, mistakeTypes=[
        attribute_misplaced := mt(n="Attribute misplaced"),
        attribute_duplicated := mt(n="Attribute duplicated"),
        attribute_misplaced_in_generalized_hierarchy := mt(n="Attribute misplaced in generalization hierarchy"), # Added
    ]),
    wrong_relationship := mtc(n="Wrong relationship", mistakeTypes=[
        incomplete_containment_tree := mt(n="Incomplete containment tree"),
    ]),
    missing_relationship := mtc(n="Missing relationship", s=wrong_relationship, mistakeTypes=[
        missing_association := mt(n="Missing association"),
        missing_composition := mt(n="Missing composition"),
        missing_aggregation := mt(n="Missing aggregation"),
        missing_nary_association := mt(n="Missing n-ary association"), # Added
        using_an_attribute_instead_of_an_association := mt(n="Using an attribute instead of an association"),
    ]),
    extra_association := mtc(n="Extra (redundant) association", s=wrong_relationship, mistakeTypes=[
        representing_an_action_with_an_association := mt(n="Representing an action with an association"),
        composed_part_contained_in_more_than_one_parent := mt(n="Composed part contained in more than one parent"),
        other_extra_association := mt(n="Other extra association"), # Rename to extra_association
        extra_composition := mt(n="Extra composition"), # Added
        extra_aggregation := mt(n="Extra aggregation"), # Added
        extra_nary_association := mt(n="Extra n-ary association"), # Added
    ]),
    using_wrong_relationship_type := mtc(n="Using wrong relationship type", s=wrong_relationship, mistakeTypes=[
        using_association_instead_of_aggregation_composition := mt(
            n="Using association instead of aggregation/composition"),
        using_aggregation_composition_instead_of_association := mt(
            n="Using aggregation/composition instead of association"),
        using_directed_association_instead_of_undirected := mt(n="Using directed association instead of undirected"),
        using_undirected_association_instead_of_directed := mt(n="Using undirected association instead of directed"),
        using_aggregation_instead_of_composition := mt(n="Using aggregation instead of composition"),
        using_composition_instead_of_aggregation := mt(n="Using composition instead of aggregation"),
        using_binary_association_instead_of_nary_association := mt(
            n="Using binary association instead of nary association"), # Added
        using_nary_association_instead_of_binary_association := mt(
            n="Using nary association instead of binary association"), # Added
        using_intermediate_class_instead_of_nary_association := mt(
            n="Using intermediate class instead of nary association"), # Added
        using_nary_association_instead_of_intermediate_class := mt(
            n="Using nary association instead of intermediate class"), # Added
    ]),
    wrong_association_name := mtc(n="Wrong association name", s=wrong_relationship, mistakeTypes=[
         # TODO Rename to Missing association name.
        missing_association_name_when_one_was_expected := mt(n="Missing association name when one was expected"),
        bad_association_name_spelling := mt(n="Bad association name spelling"),
        similar_association_name := mt(n="Similar (yet incorrect) association name"), # TODO Remove
    ]),
    wrong_multiplicities := mtc(n="Wrong multiplicities", s=wrong_relationship, mistakeTypes=[
        infinite_recursive_dependency := mt(n="Infinite recursive dependency"),
        other_wrong_multiplicity := mt(n="Other wrong multiplicity"), # Rename to Wrong multiplicity
        missing_multiplicity := mt(n="Missing multiplicity"), # Added
    ]),
    wrong_role_names := mtc(n="Wrong role names", s=wrong_relationship, mistakeTypes=[
        missing_role_names := mt(n="Missing role names"),
        role_should_be_static := mt(n="Role should be static"),
        role_should_not_be_static := mt(n="Role should not be static"),
        bad_role_name_spelling := mt(n="Bad role name spelling"),
        similar_role_name := mt(n="Similar (yet incorrect) role name"), # TODO Remove
        other_wrong_role_name := mt(n="Other wrong role name"), # Rename to Incorrect role name but correct association
    ]),
    wrong_association_class := mtc(n="Wrong association class", s=wrong_relationship, mistakeTypes=[
        missing_association_class := mt(n="Missing association class"),
        extra_association_class := mt(n="Extra (redundant) association class"), # Rename , Remove (redundant)
        bad_association_class_name_spelling := mt(n="Bad association class name spelling"),
        association_class_should_be_regular_class:= mt(n="Association class should be regular class"), # Added
        regular_class_should_be_association_class := mt(n="Regular class should be association class"), # Added
        similar_association_class_name := mt(n="Similar (yet incorrect) association class name"), # Remove
    ]),
    wrong_generalization := mtc(n="Wrong generalization", s=wrong_relationship, mistakeTypes=[
        missing_generalization := mt(n="Missing generalization"),
        extra_generalization := mt(n="Extra generalization"), # Added
        # Rename to Generalization does not follow isA rule
        generalization_inapplicable := mt(n="Generalization inapplicable"),
        subclass_not_distinct_across_lifetime := mt(n="Subclass not distinct across lifetime"),
        inherited_feature_does_not_make_sense_for_subclass := mt(n="Inherited feature does not make sense for subclass"),
        subclass_is_an_instance_of_superclass := mt(n="Subclass is an instance of superclass"),
        non_differentiated_subclass := mt(n="Non-differentiated subclass"),
        wrong_generalization_direction := mt(n="Wrong generalization direction"),
        wrong_superclass := mt(n="Wrong superclass"),
    ]),
    misuse_of_design_patterns := mtc(n="Misuse of design patterns"),
    wrong_player_role_pattern := mtc(n="Wrong Player-Role Pattern", s=misuse_of_design_patterns, mistakeTypes=[
        missing_player_role_pattern := mt(n="Missing Player-Role pattern"),
        incomplete_player_role_pattern := mt(n="Incomplete Player-Role pattern"),
    ]),
    using_different_player_role_pattern := mtc(
            n="Using different Player-Role pattern", s=wrong_player_role_pattern, mistakeTypes=[
        subclass_should_be_full_player_role_pattern := mt(n="Subclass should be full Player-Role pattern"),
        subclass_should_be_association_player_role_pattern := mt(n="Subclass should be association Player-Role pattern"),
        subclass_should_be_enum_player_role_pattern := mt(n="Subclass should be enum Player-Role pattern"),
        association_should_be_full_player_role_pattern := mt(n="Association should be full Player-Role pattern"),
        association_should_be_subclass_player_role_pattern := mt(n="Association should be subclass Player-Role pattern"),
        association_should_be_enum_player_role_pattern := mt(n="Association should be enum Player-Role pattern"),
        enum_should_be_full_player_role_pattern := mt(n="Enum should be full Player-Role pattern"),
        enum_should_be_subclass_player_role_pattern := mt(n="Enum should be subclass Player-Role pattern"),
        enum_should_be_association_player_role_pattern := mt(n="Enum should be association Player-Role pattern"),
        full_player_role_pattern_should_be_subclass := mt(n="Full Player-Role pattern should be subclass"),
        full_player_role_pattern_should_be_association := mt(n="Full Player-Role pattern should be association"),
        full_player_role_pattern_should_be_enum := mt(n="Full Player-Role pattern should be enum"),
    ]),
    wrong_abstraction_occurrence_pattern := mtc(
            n="Wrong Abstraction-Occurrence pattern", s=misuse_of_design_patterns, mistakeTypes=[
        missing_abstraction_occurrence_pattern := mt(n="Missing Abstraction-Occurrence pattern"),
        incomplete_abstraction_occurrence_pattern := mt(n="Incomplete Abstraction-Occurrence pattern"),
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
    bad_association_class_name_spelling,
    similar_association_class_name, # Remove
    association_class_should_be_regular_class, # Added
    regular_class_should_be_association_class, # Added
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
    using_an_attribute_instead_of_an_association,
    list_attribute,
    attribute_misplaced_in_generalized_hierarchy, # Added
    generalization_inapplicable,
    using_association_instead_of_aggregation_composition,
    using_aggregation_composition_instead_of_association,
    using_directed_association_instead_of_undirected,
    using_undirected_association_instead_of_directed,
    using_aggregation_instead_of_composition,
    using_composition_instead_of_aggregation,
    using_binary_association_instead_of_nary_association, # Added
    using_nary_association_instead_of_binary_association, # Added
    using_nary_association_instead_of_intermediate_class, # Added
    using_intermediate_class_instead_of_nary_association, # Added
    wrong_generalization_direction,
    wrong_superclass,
    subclass_is_an_instance_of_superclass,
    non_differentiated_subclass,
    subclass_not_distinct_across_lifetime,
    inherited_feature_does_not_make_sense_for_subclass,
    other_wrong_multiplicity, # Rename to wrong_multiplicity
    missing_multiplicity, # Added
    missing_role_names,
    bad_role_name_spelling,
    similar_role_name, # Remove
    other_wrong_role_name, # Rename to incorrect_role_name_but_correct_association
    role_should_not_be_static,
    role_should_be_static,
    bad_association_name_spelling,
    similar_association_name, # Remove
    incomplete_containment_tree,

    # design pattern mistakes
    subclass_should_be_full_player_role_pattern,
    subclass_should_be_association_player_role_pattern,
    subclass_should_be_enum_player_role_pattern,
    association_should_be_full_player_role_pattern,
    association_should_be_subclass_player_role_pattern,
    association_should_be_enum_player_role_pattern,
    enum_should_be_full_player_role_pattern,
    enum_should_be_subclass_player_role_pattern,
    enum_should_be_association_player_role_pattern,
    full_player_role_pattern_should_be_subclass,
    full_player_role_pattern_should_be_association,
    full_player_role_pattern_should_be_enum,

    # extra items
    extra_class,
    extra_association_class,
    extra_enum,
    extra_enum_item,
    extra_generalization, # Added
    extra_composition, # Added
    representing_an_action_with_an_association,
    other_extra_association, # Rename to extra_association
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
    missing_association_name_when_one_was_expected, # Rename to missing_association_name

    # missing/incomplete patterns
    incomplete_player_role_pattern,
    incomplete_abstraction_occurrence_pattern,
    missing_player_role_pattern,
    missing_abstraction_occurrence_pattern,
]
