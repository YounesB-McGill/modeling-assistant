"""
Learning Corpus definition file. The corpus mistake types and learning items are defined here in a
DSL-style, as well as the mistake type priorities.

The actual corpus initialization is done in the corpus.py file.
"""

from textwrap import dedent
from learningcorpus.learningcorpus import (Example, Feedback, LearningCorpus, MistakeType, ParametrizedResponse,
    Quiz, Reference, ResourceResponse, TextResponse)
from utils import mtc, mt, fbs


corpus = LearningCorpus(mistakeTypeCategories=[
    class_mistakes := mtc(n="Class mistakes",
        mistakeTypes=[
            missing_class := mt(n="Missing class", feedbacks=fbs({
                1: Feedback(highlightProblem=True),  # Highlight entire sentence. Can infer this from level
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
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Is this the best way to model this concept?"),
                    3: TextResponse(text="Use an intermediate class instead of an n-ary association."),
                })),
        ],
        subcategories=[
            class_name_mistakes := mtc(n="Class name mistakes", mistakeTypes=[
                plural_class_name := mt(n="Plural class name", atomic=True, feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Remember that class names should be singular."),
                    3: ParametrizedResponse(text="${className} should be ${pascalCase(className)}, "
                        "with a Capital Letter."),
                    4: ResourceResponse(learningResources=[correct_class_naming_example := Example(content=dedent("""\
                        Please note these examples of correct vs incorrect class naming:
                        :x: Examples to avoid | :heavy_check_mark: Good class names
                        --- | ---
                        pilot | Pilot
                        Airplanes | Airplane 
                        AirlineData | Airline"""))]),
                })),
                lowercase_class_name := mt(n="Lowercase class name", atomic=True, feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Remember that class names must start with a Capital Letter."),
                    3: ParametrizedResponse(text="${className} should be ${singular(className)}, using the singular."),
                    4: ResourceResponse(learningResources=[correct_class_naming_example]),
                })),
                software_engineering_term := mt(n="Software engineering term", atomic=True, feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Remember that a domain model should not contain software engineering terms."),
                    3: ParametrizedResponse(
                        text="${className} is a software engineering term, which does not belong in a domain model."),
                    4: ResourceResponse(learningResources=[correct_class_naming_example]),
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
                        text="The ${similarYetIncorrectClassName} class should be changed to ${correctClassName}.")
                })),
                wrong_class_name := mt(n="Wrong class name", atomic=True, feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Can you double check this class name?"),
                    3: ParametrizedResponse(
                        text="The ${similarYetIncorrectClassName} class has a name that is not quite right."),
                    4: ParametrizedResponse(
                        text="The ${similarYetIncorrectClassName} class should be changed to ${correctClassName}.")
                })),
            ]),
            enumeration_mistakes := mtc(n="Enumeration mistakes", mistakeTypes=[
                class_should_be_enum := mt(
                    n="Class should be enum", d="Regular class should be enumeration", feedbacks=fbs({
                        1: Feedback(highlightSolution=True),
                        2: TextResponse(text="Is there anything special about this class?"),
                        3: ParametrizedResponse(text="The ${className} can only be one of ${correctEnumSize} options, "
                            "so what is the best way to model this?"),
                        4: ResourceResponse(learningResources=[enum_reference := Reference(content="Please review the "
                            "[Enumeration](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.")]),
                    })),
                enum_should_be_class := mt(
                    n="Enum should be class", d="Enumeration should be regular class", feedbacks=fbs({
                        1: Feedback(highlightSolution=True),
                        2: TextResponse(text="Is there anything special about this class?"),
                        3: ParametrizedResponse(text="Is ${className} limited to the options shown in (an|this) "
                            "enumeration? Can this be modeled differently?"),
                        4: ResourceResponse(learningResources=[enum_reference]),
                    })),
                missing_enum := mt(n="Missing enum", d="Missing enumeration", feedbacks=fbs({
                    1: Feedback(highlightProblem=True),
                    2: TextResponse(text="How would you model this concept?"),
                    3: TextResponse(text="Model this concept with an enumeration."),
                    4: ResourceResponse(learningResources=[enum_reference]),
                })),
                extra_enum := mt(n="Extra enum", d="Extra enumeration", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Is this item really necessary?"),
                    3: ParametrizedResponse(text="Remove the ${extraEnum} enumeration, it is not needed."),
                    4: ResourceResponse(learningResources=[enum_reference]),
                })),
                bad_enum_name_spelling := mt(
                    n="Bad enum name spelling", d="Bad enumeration name spelling", feedbacks=fbs({
                        1: Feedback(highlightSolution=True),
                        2: TextResponse(text="Can this item be renamed?"),
                        3: ParametrizedResponse(
                            text="The ${wronglyNamedEnum} should be renamed[ to ${correctEnumName}]."),
                        4: ResourceResponse(learningResources=[enum_reference]),
                    })),
                similar_enum_name := mt(  # TODO Remove
                    n="Similar enum name", d="Similar enumeration name", feedbacks=fbs({
                        1: Feedback(highlightSolution=True),
                        2: TextResponse(text="Can this item be renamed?"),
                        3: ParametrizedResponse(
                            text="The ${wronglyNamedEnum} should be renamed[ to ${correctEnumName}]."),
                        4: ResourceResponse(learningResources=[enum_reference]),
                    })),
                missing_enum_item := mt(n="Missing enum item", d="Missing enumeration item", feedbacks=fbs({
                    1: Feedback(highlightProblem=True),
                    2: TextResponse(text="Is there anything missing here?"),
                    3: ParametrizedResponse(text="The ${enumName} enumeration is missing an item."),
                    4: ResourceResponse(learningResources=[enum_reference]),
                })),
                extra_enum_item := mt(n="Extra enum item", d="Extra enumeration item", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Should this really be here?"),
                    3: ParametrizedResponse(text="The ${enumName} enumeration has an extra item."),
                    4: ResourceResponse(learningResources=[enum_reference]),
                })),
                bad_enum_item_spelling := mt(
                    n="Bad enum item spelling", d="Bad enumeration item spelling", feedbacks=fbs({
                        1: Feedback(highlightSolution=True),
                        2: TextResponse(text="Can this item be renamed?"),
                        3: ParametrizedResponse(
                            text="The ${wronglyNamedEnumItem} should be renamed[ to ${correctEnumItemName}]."),
                        4: ResourceResponse(learningResources=[enum_reference]),
                    })),
                similar_enum_item := mt(  # TODO Remove
                    n="Similar enum item", d="Similar enumeration item", feedbacks=fbs({
                        1: Feedback(highlightSolution=True),
                        2: TextResponse(text="Can this item be renamed?"),
                        3: ParametrizedResponse(
                            text="The ${wronglyNamedEnumItem} should be renamed[ to ${correctEnumItemName}]."),
                        4: ResourceResponse(learningResources=[enum_reference]),
                    })),
            ]),
        ]
    ),

    attribute_mistakes := mtc(n="Attribute mistakes",
        mistakeTypes=[
            missing_attribute := mt(n="Missing attribute", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Make sure to model all the attributes of this class."),
                3: ParametrizedResponse(text="The ${className} class is missing an attribute."),
                4: ParametrizedResponse(text="A ${className} has a ${missingAttribute}."),
                5: ResourceResponse(learningResources=[attribute_reference := Reference(
                    content="Please review the [Attribute](https://mycourses2.mcgill.ca/) and "
                        "[Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.")]),
            })),
            wrong_attribute_type := mt(n="Wrong attribute type", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Can you double-check this?"),
                3: ParametrizedResponse(text="Can you think of a better type for ${attribute}?"),
                # Only offered in cases where a reason can be determined, eg not a simple data type
                4: ParametrizedResponse(text="The ${className}.${attribute} is not of type ${attribute.type} because "
                    "${mistakeType.reason}."),
                5: ResourceResponse(learningResources=[attribute_reference]),
            })),
            missing_attribute_type := mt(n="Missing attribute type", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="This attribute is missing something."),
                3: TextResponse(text="What is the type of this attribute?"),
                4: ResourceResponse(learningResources=[attribute_reference]),
            })),
            attribute_should_be_static := mt(n="Attribute should be static", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Isn't there something special about this attribute?"),
                3: ParametrizedResponse(text="${includingClass.attributeName} should be static, because it applies to "
                    "all instances of ${includingClass}."),
                4: ResourceResponse(learningResources=[attribute_reference]),
            })),
            attribute_should_not_be_static := mt(n="Attribute should not be static", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Is there something special about this attribute?"),
                3: ParametrizedResponse(text="${includingClass.attributeName} should not be static, because it doesn't "
                    "apply to all instances of ${includingClass}."),
                4: ResourceResponse(learningResources=[attribute_reference]),
            })),
        ],
        subcategories=[
            extra_attribute_mistakes := mtc(n="Extra attribute mistakes", mistakeTypes=[
                plural_attribute := mt(n="Plural attribute", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Can you double check this attribute name?"),
                    3: TextResponse(text="This attribute should be singular."),
                    4: ResourceResponse(learningResources=[attribute_quiz := Quiz(content=dedent("""\
                        Pick the classes which are modeled correctly.
                    
                        - [ ] class Student { courses; }
                        - [ ] class Folder { List<File> files; }
                        - [ ] class Restaurant { 1 -- * Employee; }"""))]),
                })),
                list_attribute := mt(n="List attribute", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Is there a better way to model this concept?"),
                    3: TextResponse(text="Remember that attributes are simple pieces of data."),
                    4: ParametrizedResponse(
                        text="${includingClass.attributeName} should be modeled as an association instead."),
                    5: ResourceResponse(learningResources=[attribute_quiz]),
                })),
                extra_attribute := mt(n="Extra attribute", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Do we really need to model this concept?"),
                    3: [ParametrizedResponse(text="The ${redundantAttribute} in the ${className} class is not needed."),
                        ParametrizedResponse(text="The ${redundantAttribute} attribute in the ${className} class is "
                            "not needed because it can be derived from ${derivationSources}."),
                        ParametrizedResponse(text="The ${redundantAttribute} attribute in the ${className} class is "
                            "not needed because it is not part of the domain. You only need to model concepts related "
                            "to the given problem description.")],
                    4: ResourceResponse(learningResources=[attribute_reference]),
                })),
            ]),
            wrong_attribute_name_mistakes := mtc(n="Wrong attribute name mistakes", mistakeTypes=[
                bad_attribute_name_spelling := mt(n="Bad attribute name spelling", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Can this attribute be renamed?"),
                    3: ParametrizedResponse(
                        text="${wrongAttribute} is misspelled. [Use the same spelling as the problem description.]"),
                    4: ResourceResponse(learningResources=[attribute_reference]),
                })),
                uppercase_attribute_name := mt(n="Uppercase attribute name", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: [TextResponse(text="Remember that attributes are written in `lowerCamelCase`."),
                        TextResponse(text="Can this attribute be renamed?")],
                    3: ParametrizedResponse(text="${wrongAttribute} incorrectly starts with an Uppercase Letter. "
                        "Attributes should start with a lowercase letter."),
                    4: ResourceResponse(learningResources=[attribute_reference]),
                })),
                similar_attribute_name := mt(  # TODO Remove
                    n="Similar (yet incorrect) attribute name", feedbacks=fbs({
                        1: Feedback(highlightSolution=True),
                        2: TextResponse(text="Can this attribute be renamed?"),
                        3: ParametrizedResponse(text="${wrongAttribute} is misspelled. "
                            "[Use the same spelling as the problem description.]"),
                        4: ResourceResponse(learningResources=[attribute_reference]),
                    })),
            ]),
            attribute_in_wrong_class := mtc(n="Attribute in wrong class mistakes", mistakeTypes=[
                attribute_misplaced := mt(n="Attribute misplaced", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Can you think of a better place for this?"),
                    3: ParametrizedResponse(text="The ${misplacedAttribute} does not belong in the ${wrongClass} "
                        "class. Where else can we place it?"),
                    4: ResourceResponse(learningResources=[attribute_reference]),
                })),
                attribute_duplicated := mt(n="Attribute duplicated", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Are you sure this is needed?"),
                    3: TextResponse(text="Does this need to be included more than once?"),
                    4: ParametrizedResponse(text="The ${duplicateAttribute} already exists in ${correctClass}, "
                        "so there is no need to include it again."),
                    5: ResourceResponse(learningResources=[attribute_reference]),
                })),
                attribute_misplaced_in_generalized_hierarchy := mt(
                    n="Attribute misplaced in generalization hierarchy", feedbacks=fbs({
                        1: Feedback(highlightSolution=True),
                        2: TextResponse(text="Can you think of a better place for this?"),
                        3: ParametrizedResponse(text="The ${misplacedAttribute} belongs in a (super|sub)class."),
                        4: ResourceResponse(learningResources=[attribute_reference]),
                    })),
            ]),
        ]
    ),

    relationship_mistakes := mtc(n="Relationship mistakes", subcategories=[
        association_mistakes := mtc(n="Association mistakes", subcategories=[
            missing_association_mistakes := mtc(n="Missing association mistakes", mistakeTypes=[
                missing_association := mt(n="Missing association", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="What is the relationship between these classes?"),
                    3: ParametrizedResponse(text="How would you capture that a ${classOne} has a ${classTwo}?"),
                    4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref := Reference(content=dedent("""\
                        Please review the _Composition vs. Aggregation vs. Association_ section of 
                        the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
                        better understand these relationships and where they are used.

                        ![composition vs aggregation vs association](images/composition_aggregation_association.png)""")
                    )]),
                })),
                missing_aggregation := mt(n="Missing aggregation", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="What is the relationship between these classes?"),
                    3: ParametrizedResponse(text="How would you capture that a ${classOne} has a ${classTwo}?"),
                    4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
                missing_nary_association := mt(n="Missing n-ary association", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="What is the relationship between these classes?"),
                    3: ParametrizedResponse(text="How would you capture the relationship between ${classOne}, "
                        "${classTwo}, [and] ${classThree}[, [and] ${classFour}[, [and] ${classFive}]]?"),
                    4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
                using_attribute_instead_of_assoc := mt(
                    n="Using attribute instead of assoc", d="Using attribute instead of association",
                    feedbacks=fbs({
                        1: Feedback(highlightSolution=True),
                        2: TextResponse(text="Remember that attributes are simple pieces of data."),
                        3: ParametrizedResponse(text="${includingClass.attributeName} should be its own class."),
                        4: ResourceResponse(learningResources=[Quiz(content=dedent("""\
                            Pick the classes which are modeled correctly.

                            - [ ] class Person { address; }
                            - [ ] class Person { * Person -- 1 Address; }; class Address {}
                            - [ ] class Loan { libraryPatron; }"""))]),
                    })),
            ]),
            extra_association_mistakes := mtc(n="Extra association mistakes", mistakeTypes=[
                representing_action_with_assoc := mt(
                    n="Representing action with assoc", d="Representing an action with an association",
                    feedbacks=fbs({
                        1: Feedback(highlightSolution=True),
                        2: TextResponse(text="Is association the best way to model this concept?"),
                        3: [ParametrizedResponse(text="${actionName} should not be modeled as an association."),
                            ParametrizedResponse(
                                text="${actionName} does not need be modeled as part of a domain model.")],
                        4: ResourceResponse(learningResources=[Reference(content="Please review the "
                            "[domain modeling lecture](https://mycourses2.mcgill.ca/) to know which concepts should "
                            "be a part of a domain model."
                        )]),
                    })),
                extra_association := mt(n="Extra association", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Is this association really necessary?"),
                    3: [ParametrizedResponse(text="The relationship between ${classOne} and ${classTwo} is not "
                            "expressed in the problem description[, but there is a similar relationship with "
                            "${classThree} that is missing]."),
                        ParametrizedResponse(text="The relationship between ${classOne} and ${classTwo} is redundant "
                            "since we can access ${classTwo} from ${classOne} via ${classThree}.")],
                    4: [ResourceResponse(learningResources=[Quiz(
                            content="Find all the redunandant associations in this class diagram (TODO).")]),
                        ResourceResponse(learningResources=[Quiz(content="Write pseudocode to navigate between "
                            "ClassOne and ClassTwo in this class diagram (TODO).")])],
                })),
                extra_aggregation := mt(n="Extra aggregation", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Is this aggregation really necessary?"),
                    3: ParametrizedResponse(text="The relationship between ${classOne} and ${classTwo} is redundant."),
                })),
                extra_nary_association := mt(n="Extra n-ary association", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Is this association really necessary?"),
                    3: ParametrizedResponse(text="The relationship between the highlighted classes is redundant."),
                })),
            ]),
            association_type_mistakes := mtc(n="Association type mistakes", mistakeTypes=[
                using_aggregation_composition_instead_of_assoc := mt(
                    n="Using aggregation/composition instead of assoc",
                    d="Using aggregation/composition instead of association",
                    feedbacks=fbs({})),
                using_directed_assoc_instead_of_undirected := mt(
                    n="Using directed assoc instead of undirected",
                    d="Using directed association instead of undirected association",
                    feedbacks=fbs({})),
                using_undirected_association_instead_of_directed := mt(
                    n="Using undirected assoc instead of directed",
                    d="Using undirected association instead of directed association",
                    feedbacks=fbs({})),
                using_composition_instead_of_aggregation := mt(
                    n="Using composition instead of aggregation", feedbacks=fbs({})),
                using_binary_assoc_instead_of_nary_assoc := mt(
                    n="Using binary assoc instead of n-ary assoc",
                    d="Using binary association instead of n-ary association",
                    feedbacks=fbs({})),
                using_nary_assoc_instead_of_binary_assoc := mt(
                    n="Using n-ary assoc instead of binary assoc",
                    d="Using n-ary association instead of binary association",
                    feedbacks=fbs({})),
                using_intermediate_class_instead_of_nary_assoc := mt(
                    n="Using intermediate class instead of n-ary assoc",
                    d="Using intermediate class instead of n-ary association",
                    feedbacks=fbs({})),
            ]),
            association_name_mistakes := mtc(n="Association name mistakes", mistakeTypes=[
                missing_association_name := mt(
                    n="Missing association name", d="Missing association name when one was expected", feedbacks=fbs({
                    })),
                bad_association_name_spelling := mt(n="Bad association name spelling", feedbacks=fbs({})),
                similar_association_name := mt(  # TODO Remove
                    n="Similar (yet incorrect) association name", feedbacks=fbs({})),
            ]),
            multiplicity_mistakes := mtc(n="Multiplicity mistakes", mistakeTypes=[
                infinite_recursive_dependency := mt(n="Infinite recursive dependency", feedbacks=fbs({})),
                wrong_multiplicity := mt(n="Wrong multiplicity", feedbacks=fbs({})),
                missing_multiplicity := mt(n="Missing multiplicity", feedbacks=fbs({})),
            ]),
            role_name_mistakes := mtc(n="Role name mistakes", mistakeTypes=[
                missing_role_names := mt(n="Missing role names", feedbacks=fbs({})),
                role_should_be_static := mt(n="Role should be static", feedbacks=fbs({})),
                role_should_not_be_static := mt(n="Role should not be static", feedbacks=fbs({})),
                bad_role_name_spelling := mt(n="Bad role name spelling", feedbacks=fbs({})),
                similar_role_name := mt(n="Similar (yet incorrect) role name", feedbacks=fbs({})),  # TODO Remove
                wrong_role_name := mt(
                    n="Wrong role name", d="Wrong role name but correct association", feedbacks=fbs({})),
            ]),
            association_class_mistakes := mtc(n="Association class mistakes", mistakeTypes=[
                missing_association_class := mt(n="Missing assoc class", d="Missing association class", feedbacks=fbs({
                })),
                extra_association_class := mt(n="Extra assoc class", d="Extra association class", feedbacks=fbs({})),
                bad_assoc_class_name_spelling := mt(
                    n="Bad assoc class name spelling", d="Bad association class name spelling", feedbacks=fbs({})),
                assoc_class_should_be_class := mt(
                    n="Assoc class should be class", d="Association class should be regular class", feedbacks=fbs({})),
                class_should_be_assoc_class := mt(
                    n="Class should be assoc class", d="Regular class should be association class", feedbacks=fbs({})),
                similar_assoc_class_name := mt(  # TODO Remove
                    n="Similar assoc class name", d="Similar (yet incorrect) association class name", feedbacks=fbs({})),
            ]),
        ]),
        composition_mistakes := mtc(n="Composition mistakes", mistakeTypes=[
            missing_composition := mt(n="Missing composition", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="What is the relationship between these classes?"),
                3: ParametrizedResponse(
                    text="How would you capture that a ${containerClass} contains a ${containedClass}?"),
                4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
            })),
            extra_composition := mt(n="Extra composition", feedbacks=fbs({})),
            # TODO Split into two mistakes
            using_association_instead_of_aggregation_composition := mt(
                n="Using association instead of aggregation/composition", feedbacks=fbs({})),
            using_aggregation_instead_of_composition := mt(n="Using aggregation instead of composition", feedbacks=fbs({
            })),
            composed_part_contained_in_more_than_one_parent := mt(
                n="Composed part contained in more than one parent", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Please double-check this relationship."),
                    3: TextResponse(text="Please review the model containment hierarchy."),
                    4: ParametrizedResponse(
                        text="${incorrectlyContainedClass} cannot be contained in more than one class."),
                    5: ResourceResponse(learningResources=[containment_example := Example(content=dedent("""\
                    Observe the following domain model. Every single class is contained in the 
                    root class, `PISystem`, other than the root class itself.

                    ![PISystem](images/PISystem.png)"""))]),
                    6: ResourceResponse(learningResources=[containment_quiz := Quiz(content=dedent("""\
                    Complete the containment tree for the following model.

                    ![IRS](images/IRS.png)"""))]),
                })),
            incomplete_containment_tree := mt(n="Incomplete containment tree", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="What is the relationship between these classes?"),
                3: ParametrizedResponse(
                    text="{containedClass} is a part of ${containerClass}, so how would you model this?"),
                4: ResourceResponse(learningResources=[containment_example]),
                5: ResourceResponse(learningResources=[containment_quiz]),
            })),
        ]),
        generalization_mistakes := mtc(n="Generalization mistakes", mistakeTypes=[
            missing_generalization := mt(n="Missing generalization", feedbacks=fbs({})),
            extra_generalization := mt(n="Extra generalization", feedbacks=fbs({})),
            generalization_inapplicable := mt(
                n="Generalization inapplicable", d="Generalization does not follow isA rule", feedbacks=fbs({})),
            subclass_not_distinct_across_lifetime := mt(n="Subclass not distinct across lifetime", feedbacks=fbs({})),
            inherited_feature_does_not_make_sense_for_subclass := mt(
                n="Inherited feature does not make sense for subclass", feedbacks=fbs({})),
            subclass_is_an_instance_of_superclass := mt(n="Subclass is an instance of superclass", feedbacks=fbs({})),
            non_differentiated_subclass := mt(n="Non-differentiated subclass", feedbacks=fbs({})),
            wrong_generalization_direction := mt(n="Wrong generalization direction", feedbacks=fbs({})),
            wrong_superclass := mt(n="Wrong superclass", feedbacks=fbs({})),
        ]),
    ]),

    design_pattern_mistakes := mtc(n="Design pattern mistakes", subcategories=[
        player_role_pattern_mistakes := mtc(n="Player-Role Pattern mistakes",
            mistakeTypes=[
                missing_pr_pattern := mt(n="Missing PR pattern", d="Missing Player-Role pattern", feedbacks=fbs({})),
                incomplete_pr_pattern := mt(
                    n="Incomplete PR pattern", d="Incomplete Player-Role pattern", feedbacks=fbs({})),
            ],
            subcategories=[
                using_different_player_role_pattern := mtc(n="Using different Player-Role pattern", mistakeTypes=[
                    subclass_should_be_full_pr_pattern := mt(
                        n="Subclass should be full PR pattern",
                        d="Subclass should be full Player-Role pattern",
                        feedbacks=fbs({})),
                    subclass_should_be_assoc_pr_pattern := mt(
                        n="Subclass should be assoc PR pattern",
                        d="Subclass should be association Player-Role pattern",
                        feedbacks=fbs({})),
                    subclass_should_be_enum_pr_pattern := mt(
                        n="Subclass should be enum PR pattern",
                        d="Subclass should be enumeration Player-Role pattern",
                        feedbacks=fbs({})),
                    assoc_should_be_full_pr_pattern := mt(
                        n="Assoc should be full PR pattern",
                        d="Association should be full Player-Role pattern",
                        feedbacks=fbs({})),
                    assoc_should_be_subclass_pr_pattern := mt(
                        n="Assoc should be subclass PR pattern",
                        d="Association should be subclass Player-Role pattern",
                        feedbacks=fbs({})),
                    assoc_should_be_enum_pr_pattern := mt(
                        n="Assoc should be enum PR pattern",
                        d="Association should be enumeration Player-Role pattern",
                        feedbacks=fbs({})),
                    enum_should_be_full_pr_pattern := mt(
                        n="Enum should be full PR pattern",
                        d="Enumeration should be full Player-Role pattern",
                        feedbacks=fbs({})),
                    enum_should_be_subclass_pr_pattern := mt(
                        n="Enum should be subclass PR pattern",
                        d="Enumeration should be subclass Player-Role pattern",
                        feedbacks=fbs({})),
                    enum_should_be_assoc_pr_pattern := mt(
                        n="Enum should be assoc PR pattern",
                        d="Enumeration should be association Player-Role pattern",
                        feedbacks=fbs({})),
                    full_pr_pattern_should_be_subclass := mt(
                        n="Full PR pattern should be subclass",
                        d="Full Player-Role pattern should be subclass",
                        feedbacks=fbs({})),
                    full_pr_pattern_should_be_assoc := mt(
                        n="Full PR pattern should be assoc",
                        d="Full Player-Role pattern should be association",
                        feedbacks=fbs({})),
                    full_pr_pattern_should_be_enum := mt(
                        n="Full PR pattern should be enum",
                        d="Full Player-Role pattern should be enumeration",
                        feedbacks=fbs({})),
                ]),
            ]
        ),
        abstraction_occurrence_pattern_mistakes := mtc(n="Abstraction-Occurrence pattern mistakes", mistakeTypes=[
            missing_ao_pattern := mt(
                n="Missing AO pattern", d="Missing Abstraction-Occurrence pattern", feedbacks=fbs({})),
            incomplete_ao_pattern := mt(
                n="Incomplete AO pattern", d="Incomplete Abstraction-Occurrence pattern", feedbacks=fbs({})),
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
    assoc_class_should_be_class,
    class_should_be_assoc_class,
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
    attribute_misplaced_in_generalized_hierarchy,
    generalization_inapplicable,
    using_association_instead_of_aggregation_composition,
    using_aggregation_composition_instead_of_assoc,
    using_directed_assoc_instead_of_undirected,
    using_undirected_association_instead_of_directed,
    using_aggregation_instead_of_composition,
    using_composition_instead_of_aggregation,
    using_binary_assoc_instead_of_nary_assoc,
    using_nary_assoc_instead_of_binary_assoc,
    using_nary_assoc_instead_of_intermediate_class,
    using_intermediate_class_instead_of_nary_assoc,
    wrong_generalization_direction,
    wrong_superclass,
    subclass_is_an_instance_of_superclass,
    non_differentiated_subclass,
    subclass_not_distinct_across_lifetime,
    inherited_feature_does_not_make_sense_for_subclass,
    wrong_multiplicity,
    missing_multiplicity,
    missing_role_names,
    bad_role_name_spelling,
    similar_role_name,
    wrong_role_name, # Rename to incorrect_role_name_but_correct_association
    role_should_not_be_static,
    role_should_be_static,
    bad_association_name_spelling,
    similar_association_name,
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
    extra_generalization,
    extra_composition,
    representing_action_with_assoc,
    extra_association,
    extra_aggregation,
    extra_nary_association,
    attribute_duplicated,
    extra_attribute, # Rename to extra_attribute

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
    missing_nary_association,
    missing_role_names,
    missing_association_name,

    # missing/incomplete patterns
    incomplete_pr_pattern,
    incomplete_ao_pattern,
    missing_pr_pattern,
    missing_ao_pattern,
]
