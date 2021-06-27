"""
Helper file used to create learning corpus.
"""

from textwrap import dedent
from learningcorpus.learningcorpus import Example, Feedback, LearningCorpus, MistakeTypeCategory, MistakeType, LearningItem, ParametrizedResponse, ResourceResponse, TextResponse


domain_modeling = LearningItem(name="DomainModeling")


def mtc(n, s=None, **kwargs) -> MistakeTypeCategory:
    "Shorthand for MistakeTypeCategory initializer."
    return MistakeTypeCategory(name=n, supercategory=s, **kwargs)


def mt(n, **kwargs) -> MistakeType:
    "Shorthand for MistakeType initializer."
    return MistakeType(name=n, **kwargs)


corpus = LearningCorpus(mistakeTypeCategories=[
    wrong_class := mtc(n="Wrong class", mistakeTypes=[
        missing_class := mt(n="Missing class", feedbacks=[
            Feedback(level=1, highlightSolution=True),
            TextResponse(level=2, text="Make sure you have modeled all the classes in the problem description."),
            Feedback(level=3, highlightProblem=True),
            ParametrizedResponse(level=4, text="Remember to add the ${{className}} class.")
        ]),
        extra_class := mt(n="Extra (redundant) class"),
    ]),
    wrong_class_name := mtc(n="Wrong class name", s=wrong_class, mistakeTypes=[
        plural_class_name := mt(n="Plural class name"),
        lowercase_class_name := mt(n="Lowercase class name"),
        software_engineering_term := mt(n="Software engineering term", atomic=True, feedbacks=[
            Feedback(level=1, highlightSolution=True),
            TextResponse(level=2, text="Remember that a domain model should not contain software engineering terms."),
            ParametrizedResponse(level=3, text="${{className}} is a software engineering term, which does not belong in a domain model."),
            ResourceResponse(level=4, learningResources=[Example(content=dedent("""\
                Please note these examples of correct vs incorrect class naming:
                :x: Examples to avoid | :heavy_check_mark: Good class names
                --- | ---
                pilot | Pilot
                Airplanes | Airplane 
                AirlineData | Airline"""))]),
        ]),
        bad_class_name_spelling := mt(n="Bad class name spelling", atomic=True),
        similar_class_name := mt(n="Similar (yet incorrect) class name"),
    ]),
    wrong_enumeration := mtc(n="Wrong enumeration", s=wrong_class, mistakeTypes=[
        regular_class_should_be_enum := mt(n="Regular class should be enum"),
        enum_should_be_regular_class := mt(n="Enum should be regular class"),
        wrong_enum_items := mt(n="Wrong enum items"),
    ]),
    wrong_attribute := mtc(n="Wrong attribute", mistakeTypes=[
        missing_attribute := mt(n="Missing attribute"),
        wrong_attribute_type := mt(n="Wrong attribute type"),
        attribute_should_be_static := mt(n="Attribute should be static"),
        attribute_should_not_be_static := mt(n="Attribute should not be static"),
    ]),
    extra_attribute := mtc(n="Extra (redundant) attribute", s=wrong_attribute, mistakeTypes=[
        plural_attribute := mt(n="Plural attribute"),
        list_attribute := mt(n="List attribute"),
        other_extra_attribute := mt(n="Other extra attribute"),
    ]),
    wrong_attribute_name := mtc(n="Wrong attribute name", s=wrong_attribute, mistakeTypes=[
        bad_attribute_name_spelling := mt(n="Bad attribute name spelling"),
        similar_attribute_name := mt(n="Similar (yet incorrect) attribute name"),
    ]),
    attribute_in_wrong_class := mtc(n="Attribute in wrong class", s=wrong_attribute),
    wrong_relationship := mtc(n="Wrong relationship", mistakeTypes=[
        incomplete_containment_tree := mt(n="Incomplete containment tree"),
    ]),
    missing_relationship := mtc(n="Missing relationship", s=wrong_relationship, mistakeTypes=[
        missing_association := mt(n="Missing association"),
        missing_composition := mt(n="Missing composition"),
        missing_aggregation := mt(n="Missing aggregation"),
        using_an_attribute_instead_of_an_association := mt(n="Using an attribute instead of an association"),
    ]),
    extra_association := mtc(n="Extra (redundant) association", s=wrong_relationship, mistakeTypes=[
        representing_an_action_with_an_association := mt(n="Representing an action with an association"),
        composed_part_contained_in_more_than_one_parent := mt(n="Composed part contained in more than one parent"),
        other_extra_association := mt(n="Other extra association"),
    ]),
    using_wrong_relationship_type := mtc(n="Using wrong relationship type", s=wrong_relationship, mistakeTypes=[
        using_association_instead_of_aggregation_composition := mt(n="Using association instead of aggregation/composition"),
        using_aggregation_composition_instead_of_association := mt(n="Using aggregation/composition instead of association"),
        using_directed_association_instead_of_undirected := mt(n="Using directed association instead of undirected"),
        using_undirected_association_instead_of_directed := mt(n="Using undirected association instead of directed"),
        using_aggregation_instead_of_composition := mt(n="Using aggregation instead of composition"),
        using_composition_instead_of_aggregation := mt(n="Using composition instead of aggregation"),
    ]),
    wrong_association_name := mtc(n="Wrong association name", s=wrong_relationship, mistakeTypes=[
        missing_association_name_when_one_was_expected := mt(n="Missing association name when one was expected"),
        bad_association_name_spelling := mt(n="Bad association name spelling"),
        similar_association_name := mt(n="Similar (yet incorrect) association name"),
    ]),
    wrong_multiplicities := mtc(n="Wrong multiplicities", s=wrong_relationship, mistakeTypes=[
        infinite_recursive_dependency := mt(n="Infinite recursive dependency"),
        other_wrong_multiplicity := mt(n="Other wrong multiplicity"),
    ]),
    wrong_role_names := mtc(n="Wrong role names", s=wrong_relationship, mistakeTypes=[
        missing_role_names := mt(n="Missing role names"),
        role_should_be_static := mt(n="Role should be static"),
        role_should_not_be_static := mt(n="Role should not be static"),
        bad_role_name_spelling := mt(n="Bad role name spelling"),
        similar_role_name := mt(n="Similar (yet incorrect) role name"),
        other_wrong_role_name := mt(n="Other wrong role name"),
    ]),
    wrong_association_class := mtc(n="Wrong association class", s=wrong_relationship, mistakeTypes=[
        missing_association_class := mt(n="Missing association class"),
        extra_association_class := mt(n="Extra (redundant) association class"),
        bad_association_class_name_spelling := mt(n="Bad association class name spelling"),
        similar_association_class_name := mt(n="Similar (yet incorrect) association class name"),
    ]),
    wrong_generalization := mtc(n="Wrong generalization", s=wrong_relationship, mistakeTypes=[
        missing_generalization := mt(n="Missing generalization"),
        generalization_inapplicable := mt(n="Generalization inapplicable"),
        subclass_not_distinct_across_lifetime := mt(n="Subclass not distinct across lifetime"),
        inherited_feature_does_not_make_sense_for_subclass := mt(n="Inherited feature does not make sense for subclass"),
        subclass_is_an_instance_of_superclass := mt(n="Subclass is an instance of superclass"),
        non_differentiated_subclass := mt(n="Non-differentiated subclass"),
        wrong_generalization_direction := mt(n="Wrong generalization direction"),
        wrong_superclass := mt(n="Wrong superclass"),
    ]),
    misuse_of_design_patterns := mtc(n="Misuse of design patterns"),
    misuse_of_player_role_pattern := mtc(n="Misuse of Player-Role Pattern", s=misuse_of_design_patterns),
    misuse_of_abstraction_occurrence := mtc(n="Misuse of Abstraction-Occurrence", s=misuse_of_design_patterns),
])

domain_modeling.learningCorpus = corpus

for _mt in corpus.mistakeTypes():
    for feedback in _mt.feedbacks:
        feedback.learningCorpus = corpus
        if isinstance(feedback, ResourceResponse):
            for lr in feedback.learningResources:
                lr.learningCorpus = corpus


# mistake types by priority, from most to least important
mts_by_priority: list[MistakeType] = [
    # mistakes in an existing class
    bad_class_name_spelling,
    lowercase_class_name,
    plural_class_name,
    software_engineering_term,
    similar_class_name,
    bad_association_class_name_spelling,
    similar_association_class_name,
    regular_class_should_be_enum,
    enum_should_be_regular_class,
    wrong_enum_items,

    # mistakes in an existing attribute
    bad_attribute_name_spelling,
    plural_attribute,
    similar_attribute_name,
    #attribute_misplaced,
    wrong_attribute_type,
    attribute_should_not_be_static,
    attribute_should_be_static,

    # mistakes in an existing relationship
    infinite_recursive_dependency,
    composed_part_contained_in_more_than_one_parent,
    using_an_attribute_instead_of_an_association,
    list_attribute,
    generalization_inapplicable,
    using_association_instead_of_aggregation_composition,
    using_aggregation_composition_instead_of_association,
    using_directed_association_instead_of_undirected,
    using_undirected_association_instead_of_directed,
    using_aggregation_instead_of_composition,
    using_composition_instead_of_aggregation,
    wrong_generalization_direction,
    wrong_superclass,
    subclass_is_an_instance_of_superclass,
    non_differentiated_subclass,
    subclass_not_distinct_across_lifetime,
    inherited_feature_does_not_make_sense_for_subclass,
    other_wrong_multiplicity,
    missing_role_names,
    bad_role_name_spelling,
    similar_role_name,
    other_wrong_role_name,
    role_should_not_be_static,
    role_should_be_static,
    bad_association_name_spelling,
    similar_association_name,

    incomplete_containment_tree,

    # extra items
    extra_class,
    extra_association_class,
    representing_an_action_with_an_association,
    other_extra_association,
    #attribute_duplicated,
    other_extra_attribute,

    # missing items
    missing_class,
    missing_attribute,
    missing_association_class,
    missing_generalization,
    missing_composition,
    missing_association,
    missing_aggregation,
    missing_role_names,
    missing_association_name_when_one_was_expected,
]

for i, _mt in enumerate(mts_by_priority, start=1):
    _mt.priority = i
