"""
Learning Corpus definition file. The corpus mistake types and learning items are defined here in a
DSL-style, as well as the mistake type priorities.

The actual corpus initialization is done in the corpus.py file.
"""

from textwrap import dedent

from constants import T
from learningcorpus import (Example, LearningCorpus, MistakeType, ParametrizedResponse, Quiz, Reference,
                            ResourceResponse, TextResponse)
from utils import mcq, mtc, mt, fbs, fitb, mdf, HighlightProblem, HighlightSolution


# HTML checked and unchecked boxes, used in generated output
CHECKED_BOX = "&#10003;"
UNCHECKED_BOX = "&#9744;"


corpus = LearningCorpus(mistakeTypeCategories=[
    class_mistakes := mtc(n="Class mistakes",
        mistakeTypes=[
            missing_class := mt(n="Missing class", feedbacks=fbs({
                1: HighlightProblem(),  # Highlight entire sentence. Can infer this from level
                2: TextResponse(text="Make sure you have modeled all the classes in the problem description."),
                3: HighlightProblem(),
                4: ParametrizedResponse(text="Remember to add the ${inst_cls} class."),
                5: ResourceResponse(learningResources=[class_ref := Reference(content="Please review the "
                            "[Classes](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.")]),
            })),
            extra_class := mt(n="Extra class", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Make sure you only model the concepts mentioned in the problem description."),
                3: TextResponse(text="Is it really necessary to include this class?"),
                # Context-specific written feedbacks are not yet supported. Only the zeroth items in these lists are
                # added to the learning corpus for now. In the future, detected mistakes will either have a reason, or
                # these additional feedbacks will be migrated to new mistake types
                4: [ParametrizedResponse(
                    text="The ${stud_cls} class is not part of the problem domain, so please remove it."),
                    TextResponse(text="Remember that a domain model should not contain concepts from the user "
                                      "interfaces or databases, like Window, Database, etc.")],
                5: ResourceResponse(learningResources=[class_ref]),
            })),
        ],
        subcategories=[
            class_name_mistakes := mtc(n="Class name mistakes", mistakeTypes=[
                plural_class_name := mt(n="Plural class name", atomic=True, feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Remember that class names should be singular."),
                    3: ParametrizedResponse(text="${stud_cls} should be ${inst_cls}, using the singular."),
                    # markdown emojis ✔ and ❌, which can be transform to LaTeX
                    4: ResourceResponse(learningResources=[correct_class_naming_example := Example(content=dedent("""\
                        Please note these examples of correct vs incorrect class naming:
                        :x: Examples to avoid | :heavy_check_mark: Good class names
                        --- | ---
                        pilot | Pilot
                        Airplanes | Airplane 
                        AirlineData | Airline"""))]),
                    5: ResourceResponse(learningResources=[class_ref]),
                })),
                lowercase_class_name := mt(n="Lowercase class name", atomic=True, feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Remember that class names must start with a Capital Letter."),
                    3: ParametrizedResponse(text="${stud_cls} should be ${inst_cls}, with a Capital Letter."),
                    4: ResourceResponse(learningResources=[correct_class_naming_example]),
                    5: ResourceResponse(learningResources=[class_ref]),
                })),
                software_engineering_term := mt(n="Software engineering term", atomic=True, feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Remember that a domain model should not contain software engineering terms."),
                    3: ParametrizedResponse(text="${stud_cls} contains a software engineering term (e.g., data, "
                        "database, table), which does not belong in a domain model."),
                    4: ResourceResponse(learningResources=[correct_class_naming_example]),
                    5: ResourceResponse(learningResources=[class_ref]),
                })),
                bad_class_name_spelling := mt(n="Bad class name spelling", atomic=True, feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Double check this class name."),
                    3: ParametrizedResponse(text="The ${stud_cls} class has a misspelled name."),
                    4: ParametrizedResponse(text="The ${stud_cls} class should be changed to ${inst_cls}."),
                    5: ResourceResponse(learningResources=[class_ref]),
                })),
                wrong_class_name := mt(n="Wrong class name", d="Wrong class name but correct attributes/relationships",
                                       atomic=True, feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Double check this class name."),
                    3: ParametrizedResponse(text="The ${stud_cls} class has a name that is not "
                                                 "quite right but the attributes and/or associations are correct."),
                    4: ParametrizedResponse(text="The ${stud_cls} class should be changed to ${inst_cls}."),
                    5: ResourceResponse(learningResources=[class_ref]),
                })),
                class_should_be_abstract := mt(n="Class should be abstract", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Isn't there something special about this class?"),
                    3: ParametrizedResponse(text="${stud_cls} should be abstract."),
                    4: ResourceResponse(learningResources=[class_ref]),
                })),
                class_should_not_be_abstract := mt(n="Class should not be abstract", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Is there something special about this class?"),
                    3: ParametrizedResponse(text="${stud_cls} should not be abstract."),
                    4: ResourceResponse(learningResources=[class_ref]),
                })),
            ]),
            enumeration_mistakes := mtc(n="Enumeration mistakes", mistakeTypes=[
                class_should_be_enum := mt(
                    n="Class should be enum", d="Regular class should be enumeration", feedbacks=fbs({
                        1: HighlightSolution(),
                        2: TextResponse(text="Is there anything special about this class?"),
                        3: ParametrizedResponse(text="The ${stud_cls} can only be one of ${inst_enum.literals.length} "
                                                     "options, so what is the best way to model this?"),
                        4: ResourceResponse(learningResources=[enum_reference := Reference(content="Please review the "
                            "[Enumeration](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.")]),
                    })),
                enum_should_be_class := mt(
                    n="Enum should be class", d="Enumeration should be regular class", feedbacks=fbs({
                        1: HighlightSolution(),
                        2: TextResponse(text="Is there anything special about this class?"),
                        3: ParametrizedResponse(
                            text="Is ${stud_enum} limited to a fixed set of options? Can this be modeled differently?"),
                        4: ResourceResponse(learningResources=[enum_reference]),
                    })),
                missing_enum := mt(n="Missing enum", d="Missing enumeration", feedbacks=fbs({
                    1: HighlightProblem(),
                    2: TextResponse(text="How would you model this concept?"),
                    3: TextResponse(text="Model this concept with an enumeration."),
                    4: ParametrizedResponse(text="Add a ${inst_enum} enumeration."),
                    5: ResourceResponse(learningResources=[enum_reference]),
                })),
                extra_enum := mt(n="Extra enum", d="Extra enumeration", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Is this enumeration really necessary?"),
                    3: ParametrizedResponse(text="Remove the ${stud_enum} enumeration. It is not needed."),
                    4: ResourceResponse(learningResources=[enum_reference]),
                })),
                bad_enum_name_spelling := mt(
                    n="Bad enum name spelling", d="Bad enumeration name spelling", feedbacks=fbs({
                        1: HighlightSolution(),
                        2: TextResponse(text="Double check the name of this enumeration."),
                        3: ParametrizedResponse(text="The ${stud_enum} should be changed to ${inst_enum}."),
                        4: ResourceResponse(learningResources=[enum_reference]),
                    })),
                missing_enum_item := mt(n="Missing enum item", d="Missing enumeration item", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Is there anything missing here?"),
                    3: ParametrizedResponse(text="The ${stud_enum} enumeration is missing an item."),
                    4: ParametrizedResponse(text="Add ${inst_enumitem} to the ${stud_enum} enumeration."),
                    5: ResourceResponse(learningResources=[enum_reference]),
                })),
                extra_enum_item := mt(n="Extra enum item", d="Extra enumeration item", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Should this really be here?"),
                    3: ParametrizedResponse(
                        text="${stud_enumitem} does not belong in the ${stud_enumitem.enum} enumeration."),
                    4: ResourceResponse(learningResources=[enum_reference]),
                })),
                bad_enum_item_spelling := mt(
                    n="Bad enum item spelling", d="Bad enumeration item spelling", feedbacks=fbs({
                        1: HighlightSolution(),
                        2: TextResponse(text="Double check this enumeration item."),
                        3: ParametrizedResponse(text="${stud_enumitem} in the ${stud_enumitem.enum} should be changed "
                                                     "to ${inst_enumitem}."),
                        4: ResourceResponse(learningResources=[enum_reference]),
                    })),
            ]),
        ]
    ),

    attribute_mistakes := mtc(n="Attribute mistakes",
        mistakeTypes=[
            missing_attribute := mt(n="Missing attribute", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Make sure to model all the attributes of this class."),
                3: ParametrizedResponse(text="A ${inst_attr.cls} has a ${inst_attr}."),
                4: ResourceResponse(learningResources=[attribute_reference := Reference(
                    content="Please review the [Attribute](https://mycourses2.mcgill.ca/) and "
                        "[Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.")]),
            })),
        ],
        subcategories=[
            attribute_name_mistakes := mtc(n="Attribute name mistakes", mistakeTypes=[
                bad_attribute_name_spelling := mt(n="Bad attribute name spelling", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Double check this attribute name."),
                    3: ParametrizedResponse(text="The ${stud_attr.cls}.${stud_attr} attribute is misspelled.[ Use the "
                                                 "same spelling as the problem description.]"),
                    4: ResourceResponse(learningResources=[attr_naming_quiz := mcq[
                        "Select all the correct attribute names from the list below.",
                           "needsReciept",
                        T: "numberOfItems",
                           "ID",
                           "numItems",
                           "Name",
                        T: "identifier",
                    ]]),
                    5: ResourceResponse(learningResources=[attribute_reference]),
                })),
                uppercase_attribute_name := mt(n="Uppercase attribute name", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: [TextResponse(text="Remember that attributes are written in `lowerCamelCase`."),
                        TextResponse(text="Can this attribute be renamed?")],
                    3: ParametrizedResponse(text="The ${stud_attr.cls}.${stud_attr} attribute incorrectly starts with "
                        "an Uppercase Letter. Attributes should start with a lowercase letter."),
                    4: ResourceResponse(learningResources=[attr_naming_quiz]),
                    5: ResourceResponse(learningResources=[attribute_reference]),
                })),
            ]),
            attribute_in_wrong_class_mistakes := mtc(n="Attribute in wrong class mistakes", mistakeTypes=[
                attribute_misplaced := mt(n="Attribute misplaced", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Can you think of a better place for this attribute?"),
                    3: ParametrizedResponse(text="The ${stud_attr} attribute does not belong in the ${stud_attr.cls} "
                                                 "class. Where else can we place it?"),
                    4: ParametrizedResponse(text="The ${stud_attr} attribute belongs in the ${inst_attr.cls} class."),
                    5: ResourceResponse(learningResources=[attribute_reference]),
                })),
                attribute_duplicated := mt(n="Attribute duplicated", feedbacks=fbs({
                    1: HighlightSolution(),
                    3: TextResponse(text="Does this need to be included more than once?"),
                    4: ParametrizedResponse(text="The ${stud_attr} already exists in the same class or another class "
                        "in the generalization hierarchy, so there is no need to include it again."),
                    5: ResourceResponse(learningResources=[attribute_reference]),
                })),
                attribute_misplaced_in_generalization_hierarchy := mt(
                    n="Attribute misplaced in generalization hierarchy", feedbacks=fbs({
                        1: HighlightSolution(),
                        2: TextResponse(text="Can you think of a better place for this?"),
                        3: ParametrizedResponse(text="The ${stud_attr} attribute belongs in the ${inst_attr.cls} "
                                                     "class, i.e., a different class in the inheritance hierarchy."),
                        4: ResourceResponse(learningResources=[attribute_reference]),
                    })),
            ]),
            extra_attribute_mistakes := mtc(n="Extra attribute mistakes", mistakeTypes=[
                plural_attribute := mt(n="Plural attribute", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Double check this attribute name."),
                    3: ParametrizedResponse(text="The ${stud_attr.cls}.${stud_attr} attribute should be singular."),
                    # Create a list multiple choice quiz using the McqFactory. See its documentation for more details
                    4: ResourceResponse(learningResources=[attribute_quiz := mcq[
                        "Pick the classes which are modeled correctly with Umple.",  # prompt
                           "class Student { courses; }",
                           "class Folder { List<File> files; }",
                        T: "class Restaurant { 1 -- * Employee; }",  # correct (true) choice
                    ]]),
                    5: ResourceResponse(learningResources=[attribute_reference]),
                })),
                list_attribute := mt(n="List attribute", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Is there a better way to model this concept?"),
                    3: TextResponse(text="Remember that attributes are simple pieces of data."),
                    4: ParametrizedResponse(
                        text="${stud_attr} should be modeled as an association instead."),
                    5: ResourceResponse(learningResources=[attribute_quiz]),
                    6: ResourceResponse(learningResources=[attribute_reference]),
                })),
                extra_attribute := mt(n="Extra attribute", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Do we really need to model this concept?"),
                    3: [ParametrizedResponse(text="The ${stud_attr} in the ${stud_attr.cls} class is not needed."),
                        ParametrizedResponse(text="The ${stud_attr} attribute in the ${stud_attr.cls} class is "
                            "not needed because it can be derived from ${inst_deriv_cls}."),
                        ParametrizedResponse(text="The ${stud_attr} attribute in the ${stud_attr.cls} class is "
                            "not needed because it is not part of the domain. You only need to model concepts related "
                            "to the given problem description.")],
                    4: ResourceResponse(learningResources=[attribute_reference]),
                })),
            ]),
            attribute_property_mistakes := mtc(n="Attribute property mistakes", mistakeTypes=[
                wrong_attribute_type := mt(n="Wrong attribute type", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Double check the properties of this attribute."),
                    3: ParametrizedResponse(text="Can you think of a better type for ${stud_attr}?"),
                    4: ParametrizedResponse(
                        text="The ${stud_attr.cls}.${stud_attr} attribute should be of type ${inst_attr.type}."),
                    5: ResourceResponse(learningResources=[attribute_reference]),
                })),
                missing_attribute_type := mt(n="Missing attribute type", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: ParametrizedResponse(text="The ${stud_attr.cls}.${stud_attr} attribute is missing something."),
                    3: ParametrizedResponse(
                        text="The type of the ${stud_attr.cls}.${stud_attr} attribute should be ${inst_attr.type}."),
                    4: ResourceResponse(learningResources=[attribute_reference]),
                })),
                attribute_should_be_static := mt(n="Attribute should be static", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Isn't there something special about this attribute?"),
                    3: ParametrizedResponse(text="${stud_attr} should be static, because its value is the same for all "
                                                 "instances of ${stud_attr.cls}."),
                    4: ResourceResponse(learningResources=[attribute_reference]),
                })),
                attribute_should_not_be_static := mt(n="Attribute should not be static", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Double check the properties of this attribute."),
                    3: ParametrizedResponse(text="${stud_attr} should not be static, because its value may be "
                                                 "different for instances of ${stud_attr.cls}."),
                    4: ResourceResponse(learningResources=[attribute_reference]),
                })),
            ]),
        ]
    ),

    relationship_mistakes := mtc(n="Relationship mistakes", subcategories=[
        missing_association_aggregation_mistakes := mtc(n="Missing association/aggregation mistakes", mistakeTypes=[
            missing_association := mt(n="Missing association", feedbacks=fbs({
                1: HighlightProblem(),
                2: TextResponse(text="How should this relationship be modeled?"),
                3: ParametrizedResponse(text="How would you capture the relationship between ${inst_assoc.end0.cls} "
                                             "and ${inst_assoc.end1.cls}?"),
                4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref := Reference(content=dedent("""\
                    Please review the _Composition vs. Aggregation vs. Association_ section of 
                    the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
                    better understand these relationships and where they are used.

                    ![composition vs aggregation vs association](images/composition_aggregation_association.png)""")
                )]),
            })),
            missing_aggregation := mt(n="Missing aggregation", feedbacks=fbs({
                1: HighlightProblem(),
                2: TextResponse(text="How should this relationship be modeled?"),
                3: ParametrizedResponse(text="How would you capture that a ${inst_whole_assocend.refcls} has a "
                                             "${inst_part_assocend.refcls}?"),
                4: ParametrizedResponse(text="Use aggregation to model the relationship between "
                                             "${inst_part_assocend.cls} and ${inst_whole_assocend.cls}."),
                5: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
            })),
            missing_n_ary_association := mt(n="Missing n-ary association", feedbacks=fbs({
                1: HighlightProblem(),
                2: TextResponse(text="How should this relationship be modeled?"),
                3: ParametrizedResponse(text="How would you capture the relationship between ${inst_assoc.cls*}?"),
                4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
            })),
            using_attribute_instead_of_assoc := mt(
                n="Using attribute instead of assoc", d="Using attribute instead of association",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Remember that attributes are simple pieces of data."),
                    3: ParametrizedResponse(text="${stud_attr} should be its own class."),
                    4: ResourceResponse(learningResources=[mcq[
                        "Pick the class(es) modeled correctly in Umple.",
                           "class BankAccount { Client client; }",
                        T: "class BankAccount { * -- 1..2 Client clients; }; class Client {}",
                           "class BankAccount { 1..2 -- * Client clients; }; class Client {}",
                           "class Loan { libraryPatron; }"]]),
                    5: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
        ]),
        extra_association_mistakes := mtc(n="Extra association mistakes", mistakeTypes=[
            extra_association := mt(n="Extra association", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Is this association really necessary?"),
                3: [ParametrizedResponse(text="There should not be an association between ${stud_assoc.end0.cls} and "
                                              "${stud_assoc.end1.cls}."),
                    ParametrizedResponse(text="The relationship between ${stud_assoc.end0.cls} and "
                                              "${stud_assoc.end1.cls} is not expressed in the problem description."),
                    ParametrizedResponse(text="The relationship between ${classOne} and ${classTwo} is redundant "
                        "since we can access ${classTwo} from ${classOne} via ${classThree}.")],
                4: ResourceResponse(learningResources=[mcq[
                    # Class diagram source: Hospital system sample UML class diagram in Umple Online
                    dedent("""\
                        Find the redundant association(s) in this class diagram:
                        
                        ![Extra associations](images/hospital_cdm_extra_assocs.png)"""),
                    T: "Hospital -- Patient",
                       "Hospital -- Employee",
                    T: "Patient -- Surgeon",
                    T: "Doctor -- Ward",
                       "Hospital -- Ward",
                    ]]),
                5: ResourceResponse(learningResources=[generic_extra_item_ref := Reference(
                        content="Please review the [domain modeling lecture](https://mycourses2.mcgill.ca/) to "
                                "know which concepts should be a part of a domain model.")]),
            })),
            extra_aggregation := mt(n="Extra aggregation", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Is this aggregation really necessary?"),
                3: ParametrizedResponse(
                    text="There should not be an aggregation between ${stud_aggr.end0.cls} and ${stud_aggr.end1.cls}."),
                4: ResourceResponse(learningResources=[generic_extra_item_ref]),
            })),
            extra_n_ary_association := mt(n="Extra n-ary association", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Is this association really necessary?"),
                3: ParametrizedResponse(text="The relationship between the ${stud_assoc.cls*} classes is redundant."),
                4: ResourceResponse(learningResources=[generic_extra_item_ref]),
            })),
        ]),
        multiplicity_mistakes := mtc(n="Multiplicity mistakes", mistakeTypes=[
            infinite_recursive_dependency := mt(n="Infinite recursive dependency", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Double check this relationship."),
                3: TextResponse(text="The multiplicit(y|ies) for this relationship (is|are) incorrect."),
                4: ParametrizedResponse(text="Is it a good idea to specify that every ${stud_assocend0.cls} has a "
                                             "minimum of ${stud_assocend0.lowerBound} ${stud_assocend0}?"),
                5: ResourceResponse(learningResources=[mcq[
                    dedent("""\
                        Given the following class diagram modeled in Umple, select the correct answer(s).
                        
                        class Employee { 1 supervisor -- * Employee employees; }"""),
                       "The class diagram is correct.",
                       "The class diagram is incorrect, because some Employees do not oversee any other Employees.",
                       'The "employees" multiplicity should be 1..* instead of *.',
                    T: "The class diagram is incorrect, because at least one Employee cannot have a supervisor, "
                       "otherwise an infinite recursive dependency will occur.",
                ]]),
                6: ResourceResponse(learningResources=[mult_ref := Reference(
                    content="Please review the [multiplicities](https://mycourses2.mcgill.ca/) part of the "
                            "Class Diagram lecture.")]),
            })),
            wrong_multiplicity := mt(n="Wrong multiplicity", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Double check this association."),
                3: TextResponse(text="The multiplicity for this association end is incorrect."),
                4: ParametrizedResponse(
                    text="How many ${stud_assocend.opposite.cls} instances does a ${stud_assocend.cls} have?"),
                5: ResourceResponse(learningResources=[multiplicities_quiz := mcq[
                    "Pick the association(s) with correct multiplicities:",
                       "1 EmployeeRole -- 1 Person;",
                    T: "* Episode -- 1 TvSeries;",
                       "* Bank -- 1 Client;",
                       "* Client -- 1 BankAccount;",
                    T: "0..2 Loan -- 1 Client;",
                       "* Person -- 1 EmployeeRole;",
                    T: "* EmployeeRole -- 1 Person;",
                    ]]),
                6: ResourceResponse(learningResources=[mult_ref]),
            })),
            missing_multiplicity := mt(n="Missing multiplicity", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Double check this association."),
                3: TextResponse(text="The multiplicit(y|ies) for this association (is|are) missing."),
                4: ParametrizedResponse(
                    text="How many ${stud_assocend.opposite.cls} instances does a ${stud_assocend.cls} have?"),
                5: ResourceResponse(learningResources=[multiplicities_quiz]),
                6: ResourceResponse(learningResources=[mult_ref]),
            })),
        ]),
        role_name_mistakes := mtc(n="Role name mistakes", mistakeTypes=[
            missing_role_name := mt(n="Missing role name", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Can you model this relationship more precisely?"),
                3: ParametrizedResponse(text="The relationship between ${stud_assocend.cls} and "
                    "${stud_assocend.opposite.cls} is missing a role name."),
                4: ResourceResponse(learningResources=[role_name_ref := Reference(content=dedent("""\
                    Can you think of appropriate [role names](https://mycourses2.mcgill.ca/)
                    for this relationship? Role names help identify the role a class plays in a
                    relationship and are particularly important if there is more than one relationship
                    between the same two classes.

                    ![Role name](images/role_name.png)
                    """))]),
            })),
            role_should_be_static := mt(n="Role should be static", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Isn't there something special about this role name?"),
                3: ParametrizedResponse(text="${stud_assocend} should be static, because its value is the same for all "
                    "instances of the relationship between ${stud_assocend.opposite.cls} and ${stud_assocend.cls}."),
                4: ResourceResponse(learningResources=[assoc_ref := Reference(content="Please review the "
                    "[Association](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.")]),
            })),
            role_should_not_be_static := mt(n="Role should not be static", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Is there something special about this role name?"),
                3: ParametrizedResponse(
                    text="${stud_assocend} should not be static, because its value may be different for the instances "
                         "of the relationship between ${stud_assocend.opposite.cls} and ${stud_assocend.cls}."),
                4: ResourceResponse(learningResources=[assoc_ref]),
            })),
            bad_role_name_spelling := mt(n="Bad role name spelling", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Double check this role name."),
                3: ParametrizedResponse(
                    text="${stud_assocend} is misspelled.[ Use the same spelling as the problem description.]"),
                4: ResourceResponse(learningResources=[assoc_na_ref := Reference(content="Please review the "
                    "[Association](https://mycourses2.mcgill.ca/) and "
                    "[Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.")]),
            })),
            representing_action_with_assoc := mt(
                n="Representing action with assoc", d="Representing an action with an association",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Is this the best role name to use here?"),
                    3: ParametrizedResponse(text="The ${stud_assocend} role name represents an action, which is not "
                                                 "correct.[ Use ${inst_assocend} instead.]"),
                    4: ResourceResponse(learningResources=[assoc_na_ref]),
                })),
            wrong_role_name := mt(
                n="Wrong role name", d="Wrong role name but correct association", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Double check this role name."),
                    3: ParametrizedResponse(text="The ${stud_assocend} role name is not correct."),
                    4: ParametrizedResponse(
                        text="The ${stud_assocend} role name should be changed to ${inst_assocend}."),
                    5: ResourceResponse(learningResources=[role_name_ref]),
                })),
        ]),
        association_type_mistakes := mtc(n="Association type mistakes", mistakeTypes=[
            using_aggregation_instead_of_assoc := mt(
                n="Using aggregation instead of assoc",
                d="Using aggregation instead of association",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="What is the relationship between these two concepts?"),
                    3: ParametrizedResponse(text="The relationship between ${stud_part_assocend.cls} and "
                        "${stud_whole_assocend.cls} can be modeled with a simple association."),
                    4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
            using_composition_instead_of_assoc := mt(
                n="Using composition instead of assoc",
                d="Using composition instead of association",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="What is the relationship between these two concepts?"),
                    3: ParametrizedResponse(
                        text="Why is ${stud_part_assocend.refcls} contained in ${stud_whole_assocend.refcls}?"),
                    4: ParametrizedResponse(text="The relationship between ${stud_part_assocend.cls} and "
                        "${stud_whole_assocend.cls} should be modeled with a simple association."),
                    5: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
            using_directed_relationship_instead_of_undirected := mt(
                n="Using directed relationship instead of undirected",
                d="Using directed relationship instead of undirected relationship",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Why is navigation restricted for this relationship?"),
                    3: ParametrizedResponse(text="The relationship between ${stud_source_assocend.cls} and "
                                                 "${stud_target_assocend.cls} should be undirected."),
                    4: ResourceResponse(learningResources=[dir_rel_ref := Reference(
                        content="Please review the _Directionality in Associations_ section of the "
                                "[UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/)")]),
                })),
            using_undirected_relationship_instead_of_directed := mt(
                n="Using undirected relationship instead of directed",
                d="Using undirected relationship instead of directed relationship",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: ParametrizedResponse(
                        text="Does ${inst_target_assocend.refcls} need to know about ${inst_source_assocend.refcls}?"),
                    3: ParametrizedResponse(text="The relationship between ${inst_source_assocend.refcls} and "
                                                 "${inst_target_assocend.refcls} should be directed[ from "
                                                 "${inst_source_assocend.refcls} to ${inst_target_assocend.refcls}]."),
                    4: ResourceResponse(learningResources=[dir_rel_ref]),
                })),
            reversed_relationship_direction := mt(n="Reversed relationship direction", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Double check the direction for this relationship."),
                3: ParametrizedResponse(
                    text="The direction of the relationship between ${stud_part_or_source_assocend.cls} and "
                         "${stud_whole_or_target_assocend.cls} should be reversed."),
                4: ResourceResponse(learningResources=[dir_rel_ref]),
            })),
            using_composition_instead_of_aggregation := mt(
                n="Using composition instead of aggregation", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Is this the best relationship to use here?"),
                    3: ParametrizedResponse(text="The composition between ${stud_part_assocend.cls} and "
                                                 "${stud_whole_assocend.cls} is better modeled using aggregation."),
                    4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
            using_binary_assoc_instead_of_n_ary_assoc := mt(
                n="Using binary assoc instead of n-ary assoc",
                d="Using binary association instead of n-ary association",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Can you model this relationship more precisely?"),
                    3: ParametrizedResponse(text="Use an n-ary association to represent the relationship between the "
                                                 "${inst_assoc.cls*} classes."),
                    4: ResourceResponse(learningResources=[assoc_ref]),
                })),
            using_n_ary_assoc_instead_of_binary_assoc := mt(
                n="Using n-ary assoc instead of binary assoc",
                d="Using n-ary association instead of binary association",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Can you model this relationship more precisely?"),
                    3: ParametrizedResponse(text="Use a binary association to represent the relationship between the "
                                                 "${inst_assoc.cls*} classes."),
                    4: ResourceResponse(learningResources=[assoc_ref]),
                })),
            using_intermediate_class_instead_of_n_ary_assoc := mt(
                n="Using intermediate class instead of n-ary assoc",
                d="Using intermediate class instead of n-ary association",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Can you model this relationship in a different way?"),
                    3: ParametrizedResponse(text="Use an n-ary association to represent the relationship between the "
                                                 "${inst_assoc.cls*} classes."),
                    4: ResourceResponse(learningResources=[assoc_ref]),
                })),
            using_n_ary_assoc_instead_of_intermediate_class := mt(
                n="Using n-ary assoc instead of intermediate class",
                d="Using n-ary association instead of intermediate class",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Is this the best way to model this concept?"),
                    3: ParametrizedResponse(
                        text="Use an intermediate ${inst_cls} class instead of an n-ary association."),
                    4: ResourceResponse(learningResources=[assoc_ref]),
                })),
        ]),
        association_name_mistakes := mtc(n="Association name mistakes", mistakeTypes=[
            missing_association_name := mt(n="Missing association name", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Something is missing here."),
                3: TextResponse(text="Can you give this association a name?"),
                4: ParametrizedResponse(text="This association should be named ${inst_assoc}."),
                5: ResourceResponse(learningResources=[assoc_na_ref]),
            })),
            bad_association_name_spelling := mt(n="Bad association name spelling", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Double check this association name."),
                3: ParametrizedResponse(
                    text="${stud_assoc} is misspelled.[ Use the same spelling as the problem description.]"),
                4: ResourceResponse(learningResources=[assoc_na_ref]),
            })),
        ]),
        association_class_mistakes := mtc(n="Association class mistakes", mistakeTypes=[
            missing_assoc_class := mt(n="Missing assoc class", d="Missing association class", feedbacks=fbs({
                1: HighlightProblem(),
                2: TextResponse(text="Can you model this relationship more precisely?"),
                3: ParametrizedResponse(text="Further details of the association between ${inst_assoc.end0.cls} "
                    "and ${inst_assoc.end1.cls} should be modeled with an association class."),
                4: ResourceResponse(learningResources=[assoc_class_ref := Reference(content=dedent("""\
                    Please review the _Association class_ section of the
                    [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/)
                    
                    ![Association class](images/association_class.png)"""))]),
            })),
            extra_assoc_class := mt(n="Extra assoc class", d="Extra association class", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Can you model this relationship in another way?"),
                3: TextResponse(text="Is using an association class the best way to model this?"),
                4: ParametrizedResponse(text="Does it make sense to disallow multiple instances of ${stud_cls} with "
                    "the same pair of ${stud_assoc.end0.cls} and ${stud_assoc.end1.cls} instances?"),
                5: ParametrizedResponse(text="Further details of the association between ${stud_assoc.end0.cls} and "
                    "${stud_assoc.end1.cls} should not be modeled with an association class."),
                6: ResourceResponse(learningResources=[assoc_class_ref]),
            })),
            bad_assoc_class_name_spelling := mt(
                n="Bad assoc class name spelling", d="Bad association class name spelling", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Double check this association class name."),
                    3: ParametrizedResponse(text="The ${stud_cls} class has a misspelled name."),
                    4: ParametrizedResponse(
                        text="The ${stud_cls} class should be changed to ${inst_cls}."),
                    5: ResourceResponse(learningResources=[class_ref]),
                })),
            assoc_class_should_be_class := mt(
                n="Assoc class should be class", d="Association class should be regular class", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Is using an association class the best way to model this?"),
                    3: ParametrizedResponse(text="The ${stud_cls} class should be a regular class."),
                    4: ResourceResponse(learningResources=[assoc_class_ref]),
                })),
            class_should_be_assoc_class := mt(
                n="Class should be assoc class", d="Regular class should be association class", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Is using a regular class the best way to model this?"),
                    3: ParametrizedResponse(text="The ${stud_cls} class should be an association class."),
                    4: ResourceResponse(learningResources=[assoc_class_ref]),
                })),
        ]),
        composition_mistakes := mtc(n="Composition mistakes", mistakeTypes=[
            missing_composition := mt(n="Missing composition", feedbacks=fbs({
                1: HighlightProblem(),
                2: TextResponse(text="How should this relationship be modeled?"),
                3: ParametrizedResponse(text="How would you capture that a ${inst_whole_assocend.refcls} has a "
                                             "${inst_part_assocend.refcls}?"),
                4: ParametrizedResponse(text="Use composition to show that the ${inst_part_assocend.refcls} class "
                                             "is contained in the ${inst_whole_assocend.refcls} class."),
                5: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
            })),
            extra_composition := mt(n="Extra composition", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Is this composition really necessary?"),
                3: ParametrizedResponse(text="The relationship between ${stud_compos.end0.cls} and "
                                             "${stud_compos.end1.cls} is not expressed in the problem description."),
                4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
            })),
            using_assoc_instead_of_aggregation := mt(
                n="Using assoc instead of aggregation", d="Using association instead of aggregation", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="What is the relationship between these two concepts?"),
                    3: ParametrizedResponse(text="The relationship between ${stud_assocend.cls} and "
                        "${stud_other_assocend.cls} can be modeled more precisely than with a simple association."),
                    4: ParametrizedResponse(text="The relationship between ${stud_assocend.cls} and "
                        "${stud_other_assocend.cls} should be modeled with an aggregation."),
                    5: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
            using_assoc_instead_of_composition := mt(
                n="Using assoc instead of composition", d="Using association instead of composition", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="What is the relationship between these two concepts?"),
                    3: ParametrizedResponse(text="The relationship between ${stud_assocend.cls} and "
                        "${stud_other_assocend.cls} is more than a simple association."),
                    4: ParametrizedResponse(text="The relationship between ${stud_assocend.cls} and "
                        "${stud_other_assocend.cls} should be modeled with a composition."),
                    5: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
            using_aggregation_instead_of_composition := mt(n="Using aggregation instead of composition", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Is this the best relationship to use here?"),
                3: ParametrizedResponse(text="The relationship between ${stud_part_assocend.cls} and "
                                             "${stud_whole_assocend.cls} is stronger than an aggregation."),
                4: ParametrizedResponse(text="The relationship between ${stud_part_assocend.cls} and "
                                             "${stud_whole_assocend.cls} should be modeled with a composition."),
                5: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
            })),
            composed_part_contained_in_more_than_one_parent := mt(
                n="Composed part contained in more than one parent", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Please double-check the relationship(s) between these class(es)."),
                    3: TextResponse(text="Please review the model containment hierarchy."),
                    4: ParametrizedResponse(
                        text="${stud_cls*} cannot be contained in more than one class."),
                    5: ResourceResponse(learningResources=[containment_example := Example(content=dedent("""\
                        Observe the following domain model. Every single class except the root class is contained in the 
                        root class, `PISystem`.

                        ![PISystem](images/PISystem.png)"""))]),
                    6: ResourceResponse(learningResources=[containment_quiz := mcq[dedent("""\
                        Which of the following compositions should be added to complete the containment tree for the
                        following model?

                        ![IRS](images/IRS.png)"""),
                        T: "1 IRS <@>- * StudentRole",
                        T: "1 IRS <@>- * Person",
                           "1 IRS <@>- * Game",
                        T: "1 IRS <@>- * League",
                           "1 IRS <@>- * RegularLeague",
                        ]]),
                    7: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
            incomplete_containment_tree := mt(n="Incomplete containment tree", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Please double-check the relationships of these classes."),
                3: ParametrizedResponse(
                    text="${stud_cls*} should be contained in the containment tree.[ Use composition for this.]"),
                4: ResourceResponse(learningResources=[containment_example]),
                5: ResourceResponse(learningResources=[containment_quiz]),
                6: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
            })),
        ]),
        generalization_mistakes := mtc(n="Generalization mistakes", mistakeTypes=[
            missing_generalization := mt(n="Missing generalization", feedbacks=fbs({
                1: HighlightProblem(),
                2: TextResponse(text="What is the relationship between these classes?"),
                3: ParametrizedResponse(text="A ${inst_sub_cls} is a ${inst_super_cls}. How should we model this?"),
                4: ResourceResponse(learningResources=[inherit_hierarchy_quiz := fitb(
                    # First parameter is the prompt (learning resource main content)
                    "Place the following classes in an inheritance hierarchy: Vehicle, Wheel, LuxuryBus, "
                    "Airplane, Car, Driver, LandVehicle, Bus. Only use a term once.",
                    # Remaining parameters are the statements with blanks in {curly braces}
                    "SportsCar isA {Car}",
                    "{Wheel} isA VehiclePart",
                    "Truck isA {LandVehicle}",
                    "AmphibiousVehicle isA {Vehicle}",
                    "{LuxuryBus} isA BusVehicle",
                )]),
                5: ResourceResponse(learningResources=[gen_ref := Reference(
                    content="Please review the [Generalization](https://mycourses2.mcgill.ca/) part of the Class "
                            "Diagram lecture.")]),
            })),
            extra_generalization := mt(n="Extra generalization", feedbacks=fbs({
                1: HighlightSolution(),
                2: [TextResponse(text="Can you find a better way to express this relationship?"),
                    TextResponse(text="Is there a [direct ]relationship between these two classes?")],
                3: [ParametrizedResponse(text="When creating a generalization between ${stud_sub_cls} and "
                    "${stud_super_cls}, make sure to follow the "
                    "[checks for proper generalization](https://mycourses2.mcgill.ca/)."),
                    ParametrizedResponse(text="${stud_sub_cls} is not a subclass of ${stud_super_cls}.")],
                4: ResourceResponse(learningResources=[inherit_hierarchy_quiz]),
                5: ResourceResponse(learningResources=[inherit_checks_quiz := fitb(dedent("""\
                    Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material
                    and complete the following:

                    The five checks for generalization are:"""),
                    "Obeys the {isA rule}.",
                    "Subclass must retain its {distinctiveness}.",
                    "All {inherited features} must make sense in each subclass.",
                    "Subclass differs from superclass and other subclasses in {behavior} or {structure}.",
                    "Subclass must not be {an instance}.")]),
                6: ResourceResponse(learningResources=[gen_ref]),
            })),
            generalization_inapplicable := mt(
                n="Generalization inapplicable", d="Generalization does not follow isA rule", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: [TextResponse(text="Can you find a better way to express this relationship?"),
                        TextResponse(text="Is there a [direct ]relationship between these two classes?")],
                    3: [ParametrizedResponse(text="When creating a generalization between ${stud_sub_cls} and "
                        "${stud_super_cls}, make sure to follow the "
                        "[checks for proper generalization](https://mycourses2.mcgill.ca/)."),
                        ParametrizedResponse(
                            text="${wrongSubclass} is not a [direct ]subclass of ${wrongSuperclass}.")],
                    4: ResourceResponse(learningResources=[inherit_hierarchy_quiz]),
                    5: ResourceResponse(learningResources=[inherit_checks_quiz]),
                    6: ResourceResponse(learningResources=[gen_ref]),
                })),
            subclass_not_distinct_across_lifetime := mt(n="Subclass not distinct across lifetime", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Can you find a better way to model this concept?"),
                3: ParametrizedResponse(text="Is it possible for an instance of ${stud_sub_cls} to turn into an "
                    "instance of another subclass of ${stud_super_cls} over its lifetime?"),
                4: ResourceResponse(learningResources=[distinct_subclass_quiz := mcq[
                    "Which classes are not subclasses of Account?",
                       "SavingsAccount",
                    T: "OverdrawnAccount",
                       "CheckingAccount",
                       "MortgageAccount",
                    T: "ClosedAccount",
                    ]]),
                5: ResourceResponse(learningResources=[gen_ref]),
            })),
            inherited_feature_does_not_make_sense_for_subclass := mt(
                n="Inherited feature does not make sense for subclass", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(text="Does this belong here?"),
                    # In the future, add ${stud_feature} to the parameterized response if supported by MDS
                    3: ParametrizedResponse(text="A feature of the ${stud_super_cls} class does not "
                        "make sense for its ${stud_sub_cls} subclass."),
                    4: ResourceResponse(learningResources=[inherit_checks_quiz]),
                    5: ResourceResponse(learningResources=[gen_ref]),
                })),
            subclass_is_an_instance_of_superclass := mt(n="Subclass is an instance of superclass", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Can you find a better way to express this relationship?"),
                3: TextResponse(text="Remember the definition of the 'instance' rule.[ Instances should not be "
                    "modeled as subclasses]."),
                4: ResourceResponse(learningResources=[Example(content="A CheckingAccount isA Account, but account1234 "
                    "is not an Account according to the 'instance' rule.")]),
                5: ResourceResponse(learningResources=[inherit_checks_quiz]),
                6: ResourceResponse(learningResources=[gen_ref]),
            })),
            non_differentiated_subclass := mt(n="Non-differentiated subclass", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Is it really necessary to model this as a subclass?"),
                3: ParametrizedResponse(text="${stud_cls} needs to be different from its superclass, and all sibling "
                                             "subclasses, in terms of behavior or structure."),
                4: ResourceResponse(learningResources=[inherit_checks_quiz]),
                5: ResourceResponse(learningResources=[gen_ref]),
            })),
            reversed_generalization_direction := mt(n="Reversed generalization direction", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Can you double check this relationship?"),
                3: ParametrizedResponse(
                    text="Is ${inst_super_cls} really a ${inst_sub_cls}?[ It should be the other way around.]"),
                4: ResourceResponse(learningResources=[inherit_hierarchy_quiz]),
                5: ResourceResponse(learningResources=[inherit_checks_quiz]),
                6: ResourceResponse(learningResources=[gen_ref]),
            })),
            wrong_superclass := mt(n="Wrong superclass", feedbacks=fbs({
                1: HighlightSolution(),
                2: TextResponse(text="Can you double check this relationship?"),
                3: ParametrizedResponse(text="${stud_sub_cls} has an incorrect superclass."),
                4: HighlightProblem(),
                5: ParametrizedResponse(text="The superclass for ${stud_sub_cls} should be ${inst_super_cls}."),
                6: ResourceResponse(learningResources=[inherit_hierarchy_quiz]),
                7: ResourceResponse(learningResources=[gen_ref]),
            })),
        ]),
    ]),

    design_pattern_mistakes := mtc(n="Design pattern mistakes", subcategories=[
        player_role_pattern_mistakes := mtc(n="Player-Role Pattern mistakes", mistakeTypes=[
            missing_pr_pattern := mt(n="Missing PR pattern", d="Missing Player-Role pattern", feedbacks=fbs({
                1: HighlightProblem(),
                2: TextResponse(text="Think carefully about how to model the relationships between these concepts."),
                3: TextResponse(text="Use the Player-Role pattern to model the relationships between these concepts."),
                4: ParametrizedResponse(
                    text="The concepts of ${inst_player_cls} and its roles ${inst_role*} and the relationship between "
                         "them should be modeled with one of the forms of the Player-Role pattern."),
                # the spacing below is intentional, for the output to be properly aligned
                5: ResourceResponse(learningResources=[pr_quiz := Quiz(content=dedent(f"""\
                    Complete the following table by checking the correct boxes:

                    Solution | Roles have different features | One role at a time |{
                        " "}Different roles at a time | More than one role at the same time
                    --- | --- | --- | --- | ---
                    Enumeration         |  {UNCHECKED_BOX} | {CHECKED_BOX} | {CHECKED_BOX} |  {UNCHECKED_BOX}
                    Subclasses          | {CHECKED_BOX} | {CHECKED_BOX} |  {UNCHECKED_BOX} |  {UNCHECKED_BOX}
                    Associations        |  {UNCHECKED_BOX} | {CHECKED_BOX} | {CHECKED_BOX} | {CHECKED_BOX}
                    Player-Role Pattern | {CHECKED_BOX} | {CHECKED_BOX} | {CHECKED_BOX} | {CHECKED_BOX}"""))]),
                6: ResourceResponse(learningResources=[pr_ref := Reference(content=dedent("""\
                    The Player-Role Pattern can be used to capture the fact that an object may play different roles
                    in different contexts.

                    ![Player-Role Pattern](images/player_role.png)"""))]),
            })),
            incomplete_pr_pattern := mt(
                n="Incomplete PR pattern", d="Incomplete Player-Role pattern", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: TextResponse(
                        text="Use the Player-Role pattern to model the relationships between these concepts."),
                    4: ParametrizedResponse(
                        text="The concepts of ${inst_player_cls} and its roles ${inst_role*} and the relationship "
                             "between them should be modeled with one of the forms of the Player-Role pattern."),
                    5: ResourceResponse(learningResources=[pr_quiz]),
                    6: ResourceResponse(learningResources=[pr_ref]),
                })),
            subclass_should_be_full_pr_pattern := mt(
                n="Subclass should be full PR pattern",
                d="Subclass should be full Player-Role pattern",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(
                        text="An instance of ${stud_player_cls} can play more than one role out of ${stud_role_cls*}."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            subclass_should_be_assoc_pr_pattern := mt(
                n="Subclass should be assoc PR pattern",
                d="Subclass should be association Player-Role pattern",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="An instance of ${stud_player_cls} can play more than one role out of "
                        "${inst_role_assocend*} and different features do not need to be captured for the roles."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            subclass_should_be_enum_pr_pattern := mt(
                n="Subclass should be enum PR pattern",
                d="Subclass should be enumeration Player-Role pattern",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="An instance of ${stud_player_cls} does not need to play more than "
                                                 "one role out of ${stud_role_cls*} at the same time and different "
                                                 "features do not need to be captured for the roles."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            assoc_should_be_full_pr_pattern := mt(
                n="Assoc should be full PR pattern",
                d="Association should be full Player-Role pattern",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(
                        text="The roles ${stud_role_assocend*} have different features that need to be modeled."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            assoc_should_be_subclass_pr_pattern := mt(
                n="Assoc should be subclass PR pattern",
                d="Association should be subclass Player-Role pattern",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(
                        text="The roles ${stud_role_assocend*} have different features that need to be modeled, but an "
                             "instance of ${stud_player_cls} does not change its role over its lifetime."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            assoc_should_be_enum_pr_pattern := mt(
                n="Assoc should be enum PR pattern",
                d="Association should be enumeration Player-Role pattern",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="Will the roles ${stud_role_assocend*} ever be played by an instance "
                                                 "of ${stud_player_cls} at the same time?"),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            enum_should_be_full_pr_pattern := mt(
                n="Enum should be full PR pattern",
                d="Enumeration should be full Player-Role pattern",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="An instance of ${stud_player_cls} can play more than one role out of "
                                                  "${stud_role_enumitem*} at the same time and different features need "
                                                  "to be captured for the roles."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            enum_should_be_subclass_pr_pattern := mt(
                n="Enum should be subclass PR pattern",
                d="Enumeration should be subclass Player-Role pattern",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="The roles ${stud_role_enumitem*} have different features and never "
                                                 "change to another role."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            enum_should_be_assoc_pr_pattern := mt(
                n="Enum should be assoc PR pattern",
                d="Enumeration should be association Player-Role pattern",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="Will an instance of ${stud_player_cls} ever play more than one role "
                                                 "out of ${stud_role_enumitem*} at the same time?"),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            full_pr_pattern_should_be_subclass := mt(
                n="Full PR pattern should be subclass",
                d="Full Player-Role pattern should be subclass",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="Can an instance of ${stud_player_cls} play more than one role out of "
                                                 "${stud_role_cls*} at different times or at the same time?"),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            full_pr_pattern_should_be_assoc := mt(
                n="Full PR pattern should be assoc",
                d="Full Player-Role pattern should be association",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="Do the roles ${stud_role_cls*} need to have different features?"),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            full_pr_pattern_should_be_enum := mt(
                n="Full PR pattern should be enum",
                d="Full Player-Role pattern should be enumeration",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="Do the roles ${stud_role_cls*} need to have different features and "
                                                 "is it possible that more than one role is played by an instance of "
                                                 "${stud_player_cls} at the same time?"),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
        ]),
        abstraction_occurrence_pattern_mistakes := mtc(n="Abstraction-Occurrence pattern mistakes", mistakeTypes=[
            missing_ao_pattern := mt(
                n="Missing AO pattern", d="Missing Abstraction-Occurrence pattern", feedbacks=fbs({
                    1: HighlightProblem(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationship between these concepts."),
                    3: ParametrizedResponse(
                        text="The concepts of ${inst_abs_cls} and ${inst_occ_cls} and the relationship between them "
                             "should be modeled with the Abstraction-Occurrence pattern."),
                    4: ResourceResponse(learningResources=[ao_ref := Reference(content=dedent("""\
                        The [Abstraction-Occurrence Pattern](https://mycourses2.mcgill.ca/) can be used to 
                        represent a set of related objects that share common information but also differ
                        from each other in an important way.

                        ![Abstraction-Occurrence Pattern](images/abstraction_occurrence.png)"""))]),
                })),
            incomplete_ao_pattern := mt(
                n="Incomplete AO pattern", d="Incomplete Abstraction-Occurrence pattern", feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationship between these concepts."),
                    3: ParametrizedResponse(
                        text="The ${stud_existing_cls} should be part of an Abstraction-Occurrence relationship."),
                    4: ParametrizedResponse(
                        text="The concepts of ${inst_abs_cls} and ${inst_occ_cls} and the "
                             "relationship between them should be modeled with the Abstraction-Occurrence pattern."),
                    5: ResourceResponse(learningResources=[ao_ref]),
                })),
            missing_association_in_ao_pattern := mt(
                n="Missing association in AO pattern", d="Missing association in Abstraction-Occurrence pattern",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationship between these concepts."),
                    3: ParametrizedResponse(text="The ${stud_abs_cls} and ${stud_occ_cls} should be in an "
                                                 "Abstraction-Occurrence relationship."),
                    4: ParametrizedResponse(
                        text="The relationship between ${stud_abs_cls} and ${stud_occ_cls} should be modeled with an "
                             "association as part of the Abstraction-Occurrence pattern."),
                    5: ResourceResponse(learningResources=[ao_ref]),
                })),
            generalization_should_be_assoc_ao_pattern := mt(
                n="Generalization should be assoc AO pattern",
                d="Generalization should be association in Abstraction-Occurrence pattern",
                feedbacks=fbs({
                    1: HighlightSolution(),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="The relationship between ${stud_sub_cls} and ${stud_super_cls} "
                        "should be modeled using the Abstraction-Occurrence pattern[, where ${inst_abs_cls} is the "
                        "abstraction and ${inst_occ_cls} is the occurrence]."),
                    4: ResourceResponse(learningResources=[ao_ref]),
                })),
        ]),
    ]),
])


# mistake types by priority, from most to least important
mts_by_priority: list[MistakeType | str] = [
    "Mistakes in an existing class",
    bad_class_name_spelling,
    lowercase_class_name,
    plural_class_name,
    software_engineering_term,
    wrong_class_name,
    bad_assoc_class_name_spelling,
    assoc_class_should_be_class,
    class_should_be_assoc_class,
    class_should_be_abstract,
    class_should_not_be_abstract,
    class_should_be_enum,
    enum_should_be_class,
    bad_enum_name_spelling,
    bad_enum_item_spelling,

    "Mistakes in an existing attribute",
    bad_attribute_name_spelling,
    uppercase_attribute_name,
    plural_attribute,
    attribute_misplaced,
    wrong_attribute_type,
    attribute_should_not_be_static,
    attribute_should_be_static,

    "Mistakes in an existing relationship",
    infinite_recursive_dependency,
    composed_part_contained_in_more_than_one_parent,
    using_attribute_instead_of_assoc,
    list_attribute,
    attribute_misplaced_in_generalization_hierarchy,
    generalization_inapplicable,
    using_assoc_instead_of_composition,
    using_assoc_instead_of_aggregation,
    using_composition_instead_of_assoc,
    using_aggregation_instead_of_assoc,
    using_directed_relationship_instead_of_undirected,
    using_undirected_relationship_instead_of_directed,
    reversed_relationship_direction,
    using_aggregation_instead_of_composition,
    using_composition_instead_of_aggregation,
    using_binary_assoc_instead_of_n_ary_assoc,
    using_n_ary_assoc_instead_of_binary_assoc,
    using_n_ary_assoc_instead_of_intermediate_class,
    using_intermediate_class_instead_of_n_ary_assoc,
    reversed_generalization_direction,
    wrong_superclass,
    subclass_is_an_instance_of_superclass,
    non_differentiated_subclass,
    subclass_not_distinct_across_lifetime,
    inherited_feature_does_not_make_sense_for_subclass,
    wrong_multiplicity,
    bad_role_name_spelling,
    representing_action_with_assoc,
    wrong_role_name,
    role_should_not_be_static,
    role_should_be_static,
    bad_association_name_spelling,
    incomplete_containment_tree,

    "Design pattern mistakes",
    generalization_should_be_assoc_ao_pattern,
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

    "Extra items",
    extra_class,
    extra_assoc_class,
    extra_enum,
    extra_enum_item,
    extra_generalization,
    extra_composition,
    extra_association,
    extra_aggregation,
    extra_n_ary_association,
    attribute_duplicated,
    extra_attribute,

    "Missing items",
    missing_class,
    missing_attribute,
    missing_attribute_type,
    missing_assoc_class,
    missing_enum,
    missing_enum_item,
    missing_generalization,
    missing_composition,
    missing_association,
    missing_aggregation,
    missing_n_ary_association,
    missing_multiplicity,
    missing_role_name,
    missing_association_name,

    "Missing/incomplete patterns",
    missing_association_in_ao_pattern,
    incomplete_pr_pattern,
    incomplete_ao_pattern,
    missing_pr_pattern,
    missing_ao_pattern,
]


# Mistake Detection Formats (student elements, instructor elements)
# paste from MDIS4LC
assoc_class_should_be_class.md_format = mdf(["assoc", "cls"], ["cls"])
assoc_should_be_enum_pr_pattern.md_format = mdf(
    ["player_cls", "role_assocend*"], ["player_cls", "role_attr", "role_enum", "role_enumitem*"])
assoc_should_be_full_pr_pattern.md_format = mdf(["player_cls", "role_assocend*"], ["player_cls", "role_cls*"])
assoc_should_be_subclass_pr_pattern.md_format = mdf(["player_cls", "role_assocend*"], ["player_cls", "role_cls*"])
attribute_duplicated.md_format = mdf(["attr"], [])
attribute_misplaced.md_format = mdf(["attr"], ["attr"])
attribute_misplaced_in_generalization_hierarchy.md_format = mdf(["attr"], ["attr"])
attribute_should_be_static.md_format = mdf(["attr"], ["attr"])
attribute_should_not_be_static.md_format = mdf(["attr"], ["attr"])
bad_assoc_class_name_spelling.md_format = mdf(["assoc", "cls"], ["assoc", "cls"])
bad_association_name_spelling.md_format = mdf(["assoc"], ["assoc"])
bad_attribute_name_spelling.md_format = mdf(["attr"], ["attr"])
bad_class_name_spelling.md_format = mdf(["cls"], ["cls"])
bad_enum_item_spelling.md_format = mdf(["enumitem"], ["enumitem"])
bad_enum_name_spelling.md_format = mdf(["enum"], ["enum"])
bad_role_name_spelling.md_format = mdf(["assocend"], ["assocend"])
class_should_be_abstract.md_format = mdf(["cls"], ["cls"])
class_should_be_assoc_class.md_format = mdf(["cls"], ["assoc", "cls"])
class_should_be_enum.md_format = mdf(["cls"], ["enum"])
class_should_not_be_abstract.md_format = mdf(["cls"], ["cls"])
composed_part_contained_in_more_than_one_parent.md_format = mdf(["cls*"], [])
enum_should_be_assoc_pr_pattern.md_format = mdf(
    ["player_cls", "role_attr", "role_enum", "role_enumitem*"], ["player_cls", "role_assocend*"])
enum_should_be_class.md_format = mdf(["enum"], ["cls"])
enum_should_be_full_pr_pattern.md_format = mdf(
    ["player_cls", "role_attr", "role_enum", "role_enumitem*"], ["player_cls", "role_cls*"])
enum_should_be_subclass_pr_pattern.md_format = mdf(
    ["player_cls", "role_attr", "role_enum", "role_enumitem*"], ["player_cls", "role_cls*"])
extra_aggregation.md_format = mdf(["aggr", "whole_assocend", "part_assocend"], [])
extra_assoc_class.md_format = mdf(["assoc", "cls"], [])
extra_association.md_format = mdf(["assoc"], [])
extra_attribute.md_format = mdf(["attr"], [])
extra_class.md_format = mdf(["cls"], [])
extra_composition.md_format = mdf(["compos", "whole_assocend", "part_assocend"], [])
extra_enum.md_format = mdf(["enum"], [])
extra_enum_item.md_format = mdf(["enumitem"], [])
extra_generalization.md_format = mdf(["sub_cls", "super_cls"], [])
extra_n_ary_association.md_format = mdf(["assoc", "assocend*"], [])
full_pr_pattern_should_be_assoc.md_format = mdf(["player_cls", "role_cls*"], ["player_cls", "role_assocend*"])
full_pr_pattern_should_be_enum.md_format = mdf(
    ["player_cls", "role_cls*"], ["player_cls", "role_attr", "role_enum", "role_enumitem*"])
full_pr_pattern_should_be_subclass.md_format = mdf(["player_cls", "role_cls*"], ["player_cls", "role_cls*"])
generalization_inapplicable.md_format = mdf(["sub_cls", "super_cls"], [])
generalization_should_be_assoc_ao_pattern.md_format = mdf(["sub_cls", "super_cls"], ["abs_cls", "occ_cls"])
incomplete_ao_pattern.md_format = mdf(["existing_cls"], ["abs_cls", "occ_cls"])
incomplete_pr_pattern.md_format = mdf(["player_cls", "role*"], ["player_cls", "role*"])
incomplete_containment_tree.md_format = mdf(["cls*"], [])
infinite_recursive_dependency.md_format = mdf(["assocend*"], [])
inherited_feature_does_not_make_sense_for_subclass.md_format = mdf(["sub_cls", "super_cls"], [])
list_attribute.md_format = mdf(["attr"], ["attr"])
lowercase_class_name.md_format = mdf(["cls"], ["cls"])
missing_ao_pattern.md_format = mdf([], ["abs_cls", "occ_cls"])
missing_aggregation.md_format = mdf([], ["aggr", "whole_assocend", "part_assocend"])
missing_assoc_class.md_format = mdf([], ["assoc", "cls"])
missing_association.md_format = mdf([], ["assoc"])
missing_association_in_ao_pattern.md_format = mdf(["abs_cls", "occ_cls"], ["abs_cls", "occ_cls"])
missing_association_name.md_format = mdf(["assoc"], ["assoc"])
missing_attribute.md_format = mdf(["cls"], ["attr"])
missing_attribute_type.md_format = mdf(["attr"], ["attr"])
missing_class.md_format = mdf([], ["cls"])
missing_composition.md_format = mdf([], ["compos", "whole_assocend", "part_assocend"])
missing_enum.md_format = mdf([], ["enum"])
missing_enum_item.md_format = mdf(["enum"], ["enumitem"])
missing_generalization.md_format = mdf([], ["sub_cls", "super_cls"])
missing_multiplicity.md_format = mdf(["assocend"], ["assocend"])
missing_n_ary_association.md_format = mdf([], ["assoc", "assocend*"])
missing_pr_pattern.md_format = mdf([], ["player_cls", "role*"])
missing_role_name.md_format = mdf(["assocend"], ["assocend"])
non_differentiated_subclass.md_format = mdf(["cls"], [])
plural_attribute.md_format = mdf(["attr"], ["attr"])
plural_class_name.md_format = mdf(["cls"], ["cls"])
representing_action_with_assoc.md_format = mdf(["assocend"], ["assocend"])
reversed_generalization_direction.md_format = mdf(["sub_cls", "super_cls"], ["sub_cls", "super_cls"])
reversed_relationship_direction.md_format = mdf(
    ["aggr_compos_or_assoc", "whole_or_target_assocend", "part_or_source_assocend"],
    ["aggr_compos_or_assoc", "whole_or_target_assocend", "part_or_source_assocend"])
role_should_be_static.md_format = mdf(["assocend"], ["assocend"])
role_should_not_be_static.md_format = mdf(["assocend"], ["assocend"])
software_engineering_term.md_format = mdf(["cls"], ["cls"])
subclass_is_an_instance_of_superclass.md_format = mdf(["sub_cls", "super_cls"], [])
subclass_not_distinct_across_lifetime.md_format = mdf(["sub_cls", "super_cls"], [])
subclass_should_be_assoc_pr_pattern.md_format = mdf(["player_cls", "role_cls*"], ["player_cls", "role_assocend*"])
subclass_should_be_enum_pr_pattern.md_format = mdf(
    ["player_cls", "role_cls*"], ["player_cls", "role_attr", "role_enum", "role_enumitem*"])
subclass_should_be_full_pr_pattern.md_format = mdf(["player_cls", "role_cls*"], ["player_cls", "role_cls*"])
uppercase_attribute_name.md_format = mdf(["attr"], ["attr"])
using_aggregation_instead_of_assoc.md_format = mdf(
    ["aggr", "whole_assocend", "part_assocend"], ["assoc", "assocend", "other_assocend"])
using_aggregation_instead_of_composition.md_format = mdf(
    ["aggr", "whole_assocend", "part_assocend"], ["compos", "whole_assocend", "part_assocend"])
using_assoc_instead_of_aggregation.md_format = mdf(
    ["assoc", "assocend", "other_assocend"], ["aggr", "whole_assocend", "part_assocend"])
using_assoc_instead_of_composition.md_format = mdf(
    ["assoc", "assocend", "other_assocend"], ["compos", "whole_assocend", "part_assocend"])
using_attribute_instead_of_assoc.md_format = mdf(["attr"], ["assocend"])
using_binary_assoc_instead_of_n_ary_assoc.md_format = mdf(
    ["assoc", "assocend", "other_assocend"], ["assoc", "assocend*"])
using_composition_instead_of_aggregation.md_format = mdf(
    ["compos", "whole_assocend", "part_assocend"], ["aggr", "whole_assocend", "part_assocend"])
using_composition_instead_of_assoc.md_format = mdf(
    ["compos", "whole_assocend", "part_assocend"], ["assoc", "assocend", "other_assocend"])
using_directed_relationship_instead_of_undirected.md_format = mdf(
    ["aggr_compos_or_assoc", "target_assocend", "source_assocend"],
    ["aggr_compos_or_assoc", "assocend", "other_assocend"])
using_intermediate_class_instead_of_n_ary_assoc.md_format = mdf(["cls"], ["assoc", "assocend*"])
using_n_ary_assoc_instead_of_binary_assoc.md_format = mdf(
    ["assoc", "assocend*"], ["assoc", "assocend", "other_assocend"])
using_n_ary_assoc_instead_of_intermediate_class.md_format = mdf(["assoc", "assocend*"], ["cls"])
using_undirected_relationship_instead_of_directed.md_format = mdf(
    ["aggr_compos_or_assoc", "assocend", "other_assocend"],
    ["aggr_compos_or_assoc", "target_assocend", "source_assocend"])
wrong_attribute_type.md_format = mdf(["attr"], ["attr"])
wrong_class_name.md_format = mdf(["cls"], ["cls"])
wrong_multiplicity.md_format = mdf(["assocend"], ["assocend"])
wrong_role_name.md_format = mdf(["assocend"], ["assocend"])
wrong_superclass.md_format = mdf(["sub_cls", "super_cls"], ["sub_cls", "super_cls"])
