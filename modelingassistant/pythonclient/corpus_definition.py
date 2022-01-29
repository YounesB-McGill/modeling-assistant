"""
Learning Corpus definition file. The corpus mistake types and learning items are defined here in a
DSL-style, as well as the mistake type priorities.

The actual corpus initialization is done in the corpus.py file.
"""

from textwrap import dedent

from constants import T
from learningcorpus import (Example, Feedback, LearningCorpus, MistakeType, ParametrizedResponse, Quiz, Reference,
                            ResourceResponse, TextResponse)
from utils import mcq, mtc, mt, fbs


corpus = LearningCorpus(mistakeTypeCategories=[
    class_mistakes := mtc(n="Class mistakes",
        mistakeTypes=[
            missing_class := mt(n="Missing class", feedbacks=fbs({
                1: Feedback(highlightProblem=True),  # Highlight entire sentence. Can infer this from level
                2: TextResponse(text="Make sure you have modeled all the classes in the problem description."),
                3: Feedback(highlightProblem=True),
                4: ParametrizedResponse(text="Remember to add the ${className} class."),
                5: ResourceResponse(learningResources=[class_ref := Reference(content="Please review the "
                            "[Classes](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.")]),
            })),
            extra_class := mt(n="Extra class", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Make sure you only model the concepts mentioned in the problem description."),
                3: TextResponse(text="You have an extra class. Can you find it?"),
                # Context-specific written feedbacks are not yet supported. Only the zeroth items in these lists are
                # added to the learning corpus for now. In the future, detected mistakes will either have a reason, or
                # these additional feedbacks will be migrated to new mistake types
                4: [ParametrizedResponse(
                    text="The ${className} class is not part of the problem domain, so please remove it."),
                    ParametrizedResponse(text="Remember that a domain model should not contain concepts from the user "
                        "interfaces or databases, like Window, Database, etc.")],
                5: ResourceResponse(learningResources=[class_ref]),
            })),
        ],
        subcategories=[
            class_name_mistakes := mtc(n="Class name mistakes", mistakeTypes=[
                plural_class_name := mt(n="Plural class name", atomic=True, feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Remember that class names should be singular."),
                    3: ParametrizedResponse(text="${className} should be ${singular(className)}, using the singular."),
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
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Remember that class names must start with a Capital Letter."),
                    3: ParametrizedResponse(text="${className} should be ${pascalCase(className)}, "
                        "with a Capital Letter."),
                    4: ResourceResponse(learningResources=[correct_class_naming_example]),
                    5: ResourceResponse(learningResources=[class_ref]),
                })),
                software_engineering_term := mt(n="Software engineering term", atomic=True, feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Remember that a domain model should not contain software engineering terms."),
                    3: ParametrizedResponse(text="${className} contains a software engineering term, which does not "
                        "belong in a domain model."),
                    4: ResourceResponse(learningResources=[correct_class_naming_example]),
                    5: ResourceResponse(learningResources=[class_ref]),
                })),
                bad_class_name_spelling := mt(n="Bad class name spelling", atomic=True, feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Double check this class name."),
                    3: ParametrizedResponse(text="The ${incorrectlySpelledClassName} class has a misspelled name."),
                    4: ParametrizedResponse(
                        text="The ${incorrectlySpelledClassName} class should be changed to ${correctClassName}."),
                    5: ResourceResponse(learningResources=[class_ref]),
                })),
                wrong_class_name := mt(n="Wrong class name", d="Wrong class name but correct attribute/relationship",
                                       atomic=True, feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Double check this class name."),
                    3: ParametrizedResponse(text="The ${similarYetIncorrectClassName} class has a name that is not "
                                                 "quite right but the attributes and/or associations are correct."),
                    4: ParametrizedResponse(
                        text="The ${similarYetIncorrectClassName} class should be changed to ${correctClassName}."),
                    5: ResourceResponse(learningResources=[class_ref]),
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
                    4: ParametrizedResponse(text="Add an ${enumName} enumeration."),
                    5: ResourceResponse(learningResources=[enum_reference]),
                })),
                extra_enum := mt(n="Extra enum", d="Extra enumeration", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Is this enumeration really necessary?"),
                    3: ParametrizedResponse(text="Remove the ${extraEnum} enumeration. It is not needed."),
                    4: ResourceResponse(learningResources=[enum_reference]),
                })),
                bad_enum_name_spelling := mt(
                    n="Bad enum name spelling", d="Bad enumeration name spelling", feedbacks=fbs({
                        1: Feedback(highlightSolution=True),
                        2: TextResponse(text="Double check the name of this enumeration."),
                        3: ParametrizedResponse(
                            text="The ${wronglyNamedEnum} should be changed[ to ${correctEnumName}]."),
                        4: ResourceResponse(learningResources=[enum_reference]),
                    })),
                missing_enum_item := mt(n="Missing enum item", d="Missing enumeration item", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
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
                        2: TextResponse(text="Double check this enumeration item."),
                        3: ParametrizedResponse(
                            text="The ${wronglyNamedEnumItem} should be changed[ to ${correctEnumItemName}]."),
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
                3: ParametrizedResponse(text="A ${className} has a ${missingAttribute}."),
                4: ResourceResponse(learningResources=[attribute_reference := Reference(
                    content="Please review the [Attribute](https://mycourses2.mcgill.ca/) and "
                        "[Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.")]),
            })),
            wrong_attribute_type := mt(n="Wrong attribute type", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Double check the properties of this attribute."),
                3: ParametrizedResponse(text="Can you think of a better type for ${attribute}?"),
                4: ParametrizedResponse(text="The ${className}.${attribute} should be of type ${correctType}."),
                5: ResourceResponse(learningResources=[attribute_reference]),
            })),
            missing_attribute_type := mt(n="Missing attribute type", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: ParametrizedResponse(text="The ${attribute} attribute is missing something."),
                3: ParametrizedResponse(text="What is the type of the ${attribute} attribute?"),
                4: ResourceResponse(learningResources=[attribute_reference]),
            })),
            attribute_should_be_static := mt(n="Attribute should be static", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Isn't there something special about this attribute?"),
                3: ParametrizedResponse(text="${attributeName} should be static, because it applies to "
                    "all instances of ${includingClass}."),
                4: ResourceResponse(learningResources=[attribute_reference]),
            })),
            attribute_should_not_be_static := mt(n="Attribute should not be static", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Double check the properties of this attribute."),
                3: ParametrizedResponse(text="${attributeName} should not be static, because it does "
                    "not apply to all instances of ${includingClass}."),
                4: ResourceResponse(learningResources=[attribute_reference]),
            })),
        ],
        subcategories=[
            attribute_name_mistakes := mtc(n="Attribute name mistakes", mistakeTypes=[
                bad_attribute_name_spelling := mt(n="Bad attribute name spelling", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Double check this attribute name."),
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
            ]),
            attribute_in_wrong_class_mistakes := mtc(n="Attribute in wrong class mistakes", mistakeTypes=[
                attribute_misplaced := mt(n="Attribute misplaced", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Can you think of a better place for this attribute?"),
                    3: ParametrizedResponse(text="The ${misplacedAttribute} does not belong in the ${wrongClass} "
                        "class. Where else can we place it?"),
                    4: ParametrizedResponse(text="The ${misplacedAttribute} belongs in the ${correctClass} class."),
                    5: ResourceResponse(learningResources=[attribute_reference]),
                })),
                attribute_duplicated := mt(n="Attribute duplicated", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Are you sure this is needed?"),
                    3: TextResponse(text="Does this need to be included more than once?"),
                    4: ParametrizedResponse(text="The ${duplicateAttribute} already exists in ${correctClass}, "
                        "so there is no need to include it again."),
                    5: ResourceResponse(learningResources=[attribute_reference]),
                })),
                attribute_misplaced_in_generalization_hierarchy := mt(
                    n="Attribute misplaced in generalization hierarchy", feedbacks=fbs({
                        1: Feedback(highlightSolution=True),
                        2: TextResponse(text="Can you think of a better place for this?"),
                        3: ParametrizedResponse(text="The ${misplacedAttribute} belongs in ${correctClass}."),
                        4: ResourceResponse(learningResources=[attribute_reference]),
                    })),
            ]),
            extra_attribute_mistakes := mtc(n="Extra attribute mistakes", mistakeTypes=[
                plural_attribute := mt(n="Plural attribute", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Double check this attribute name."),
                    3: ParametrizedResponse(text="The ${attributeName} attribute should be singular."),
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
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Is there a better way to model this concept?"),
                    3: TextResponse(text="Remember that attributes are simple pieces of data."),
                    4: ParametrizedResponse(
                        text="${attributeName} should be modeled as an association instead."),
                    5: ResourceResponse(learningResources=[attribute_quiz]),
                    6: ResourceResponse(learningResources=[attribute_reference]),
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
        ]
    ),

    relationship_mistakes := mtc(n="Relationship mistakes", subcategories=[
        missing_association_aggregation_mistakes := mtc(n="Missing association/aggregation mistakes", mistakeTypes=[
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
                    4: ResourceResponse(learningResources=[mcq[
                        "Pick the class(es) modeled correctly in Umple.",
                           "class BankAccount { Client client; }",
                        T: "class BankAccount { * -- 1..2 Client clients; }; class Client {}",
                           "class BankAccount { 1..2 -- * Client clients; }; class Client {}",
                           "class Loan { libraryPatron; }"""]]),
                    5: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
        ]),
        extra_association_mistakes := mtc(n="Extra association mistakes", mistakeTypes=[
            extra_association := mt(n="Extra association", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Is this association really necessary?"),
                3: [ParametrizedResponse(text="The relationship between ${classOne} and ${classTwo} is not "
                        "expressed in the problem description[, but there is a similar relationship with "
                        "${classThree} that is missing]."),
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
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Is this aggregation really necessary?"),
                3: ParametrizedResponse(text="The relationship between ${classOne} and ${classTwo} is redundant."),
                4: ResourceResponse(learningResources=[generic_extra_item_ref]),
            })),
            extra_nary_association := mt(n="Extra n-ary association", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Is this association really necessary?"),
                3: TextResponse(text="The relationship between the highlighted classes is redundant."),
                4: ResourceResponse(learningResources=[generic_extra_item_ref]),
            })),
        ]),
        multiplicity_mistakes := mtc(n="Multiplicity mistakes", mistakeTypes=[
            infinite_recursive_dependency := mt(n="Infinite recursive dependency", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Double check this relationship."),
                3: TextResponse(text="The multiplicit(y|ies) for this relationship (is|are) incorrect."),
                4: ParametrizedResponse(
                    text="Does every ${className} have exactly ${wrongMultiplicity} ${rolename}[s]?"),
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
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Double check this association."),
                3: TextResponse(text="The multiplicit(y|ies) for this association (is|are) incorrect."),
                4: ParametrizedResponse(text="How many ${class1}'s does a ${class2} have? [And how many "
                    "${class2}'s does ${class1} have?]"),
                5: ResourceResponse(learningResources=[multiplicities_quiz := mcq[
                    "Pick the association(s) with correct multiplicities:",
                       "1 EmployeeRole -- 1 Person;",
                    T: "* Episode -- 1 TvSeries;",
                       "* Bank -- 1 Client;",
                       "* Client -- 1 BankAccount;",
                    T: "0..2 Loan -- 1 Client;",
                    T: "* Person -- 1 EmployeeRole;",
                       "* EmployeeRole -- 1 Person;",
                    ]]),
                6: ResourceResponse(learningResources=[mult_ref]),
            })),
            missing_multiplicity := mt(n="Missing multiplicity", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Double check this association."),
                3: TextResponse(text="The multiplicit(y|ies) for this association (is|are) missing."),
                4: ParametrizedResponse(text="How many ${class1}'s does a ${class2} have? [And how many "
                    "${class2}'s does ${class1} have?]"),
                5: ResourceResponse(learningResources=[multiplicities_quiz]),
                6: ResourceResponse(learningResources=[mult_ref]),
            })),
        ]),
        role_name_mistakes := mtc(n="Role name mistakes", mistakeTypes=[
            missing_role_names := mt(n="Missing role names", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Can you model this relationship more precisely?"),
                3: ParametrizedResponse(text="The multiplicities for the ${assoc} association are correct, but "
                                             "something else is missing!"),
                4: ResourceResponse(learningResources=[role_name_ref := Reference(content=dedent("""\
                    Can you think of appropriate [role names](https://mycourses2.mcgill.ca/)
                    for this association? Role names help identify the role a class plays in a
                    relationship and can be important if there is more than one relationship
                    between the same two classes.

                    ![Role name](images/role_name.png)
                    """))]),
            })),
            role_should_be_static := mt(n="Role should be static", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Isn't there something special about this role name?"),
                3: ParametrizedResponse(text="${roleName} should be static, because it applies to all instances of "
                    "the association between ${class1} and ${class2}."),
                4: ResourceResponse(learningResources=[assoc_ref := Reference(content="Please review the "
                    "[Association](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.")]),
            })),
            role_should_not_be_static := mt(n="Role should not be static", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Isn't there something special about this role name?"),
                3: ParametrizedResponse(text="${roleName} should not be static, because it doesn't apply to all "
                    "instances of the association between ${class1} and ${class2}."),
                4: ResourceResponse(learningResources=[assoc_ref]),
            })),
            bad_role_name_spelling := mt(n="Bad role name spelling", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Double check this role name"),
                3: ParametrizedResponse(text="${roleName} is misspelled.[ Use the same spelling as the problem "
                    "description.]"),
                4: ResourceResponse(learningResources=[assoc_na_ref := Reference(content="Please review the "
                    "[Association](https://mycourses2.mcgill.ca/) and "
                    "[Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.")]),
            })),
            representing_action_with_assoc := mt(
                n="Representing action with assoc", d="Representing an action with an association",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Is this the best role name to use here?"),
                    3: ParametrizedResponse(text="The ${wrongRoleName} role name represents an action, which is not "
                                                 "correct.[ Use ${correctRoleName} instead.]"),
                    4: ResourceResponse(learningResources=[assoc_na_ref]),
                })),
            wrong_role_name := mt(
                n="Wrong role name", d="Wrong role name but correct association", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Double check this role name."),
                    3: ParametrizedResponse(text="The ${wrongRoleName} role name is not correct."),
                    4: ParametrizedResponse(text="The ${wrongRoleName} role name should be changed to "
                        "${correctRoleName}."),
                    5: ResourceResponse(learningResources=[role_name_ref]),
                })),
        ]),
        association_type_mistakes := mtc(n="Association type mistakes", mistakeTypes=[
            using_aggregation_instead_of_assoc := mt(
                n="Using aggregation instead of assoc",
                d="Using aggregation instead of association",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="What is the relationship between these two concepts?"),
                    3: ParametrizedResponse(text="The relationship between ${containedClass} and ${containerClass} "
                        "can be modeled with a simple association."),
                    4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
            using_composition_instead_of_assoc := mt(
                n="Using composition instead of assoc",
                d="Using composition instead of association",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="What is the relationship between these two concepts?"),
                    3: ParametrizedResponse(
                        text="Why is ${incorrectlyContainedClass} contained in ${containerClass}?"),
                    4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
            using_directed_relationship_instead_of_undirected := mt(
                n="Using directed relationship instead of undirected",
                d="Using directed relationship instead of undirected relationship",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Why is navigation restricted for this relationship?"),
                    3: ParametrizedResponse(
                        text="The relationship between ${classOne} and ${classTwo} should be undirected."),
                    4: ResourceResponse(learningResources=[dir_rel_ref := Reference(
                        content="Please review the _Directionality in Associations_ section of the "
                                "[UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/)")]),
                })),
            using_undirected_relationship_instead_of_directed := mt(
                n="Using undirected relationship instead of directed",
                d="Using undirected relationship instead of directed relationship",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: ParametrizedResponse(text="Does ${targetClass} need to know about ${sourceClass}?"),
                    3: ParametrizedResponse(text="The relationship between ${classOne} and ${classTwo} should be "
                        "directed[ from ${classOne} to ${classTwo}]."),
                    4: ResourceResponse(learningResources=[dir_rel_ref]),
                })),
            using_composition_instead_of_aggregation := mt(
                n="Using composition instead of aggregation", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Is this the best relationship to use here?"),
                    3: ParametrizedResponse(text="The composition between ${containedClass} and ${containerClass} "
                        "is better modeled using aggregation."),
                    4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
            using_binary_assoc_instead_of_nary_assoc := mt(
                n="Using binary assoc instead of n-ary assoc",
                d="Using binary association instead of n-ary association",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Can you model this relationship more precisely?"),
                    3: ParametrizedResponse(text="Use a ${n}-ary association to represent this relationship."),
                    4: ResourceResponse(learningResources=[assoc_ref]),
                })),
            using_nary_assoc_instead_of_binary_assoc := mt(
                n="Using n-ary assoc instead of binary assoc",
                d="Using n-ary association instead of binary association",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Can you model this relationship more precisely?"),
                    3: TextResponse(text="Use a binary association to represent this relationship."),
                    4: ResourceResponse(learningResources=[assoc_ref]),
                })),
            using_intermediate_class_instead_of_nary_assoc := mt(
                n="Using intermediate class instead of n-ary assoc",
                d="Using intermediate class instead of n-ary association",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Can you model this relationship in a different way?"),
                    3: ParametrizedResponse(text="Use a ${n}-ary association to represent this relationship."),
                    4: ResourceResponse(learningResources=[assoc_ref]),
                })),
            using_nary_assoc_instead_of_intermediate_class := mt(
                n="Using n-ary assoc instead of intermediate class",
                d="Using n-ary association instead of intermediate class",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Is this the best way to model this concept?"),
                    3: TextResponse(text="Use an intermediate class instead of an n-ary association."),
                    4: ResourceResponse(learningResources=[assoc_ref]),
                })),
        ]),
        association_name_mistakes := mtc(n="Association name mistakes", mistakeTypes=[
            missing_association_name := mt(n="Missing association name", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Something is missing here."),
                3: TextResponse(text="Can you give this association a name?"),
                4: ParametrizedResponse(text="This association should be named ${associationName}."),
                5: ResourceResponse(learningResources=[assoc_na_ref]),
            })),
            bad_association_name_spelling := mt(n="Bad association name spelling", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Double check this association name."),
                3: ParametrizedResponse(
                    text="${associationName} is misspelled.[ Use the same spelling as the problem description.]"),
                4: ResourceResponse(learningResources=[assoc_na_ref]),
            })),
        ]),
        association_class_mistakes := mtc(n="Association class mistakes", mistakeTypes=[
            missing_assoc_class := mt(n="Missing assoc class", d="Missing association class", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Can you model this relationship more precisely?"),
                3: ParametrizedResponse(text="Further details of the association between ${firstClass} and "
                    "${secondClass} should be modeled with an association class."),
                4: ResourceResponse(learningResources=[assoc_class_ref := Reference(
                    content="Association class\n\n![Association class](images/association_class.png)")]),
            })),
            extra_assoc_class := mt(n="Extra assoc class", d="Extra association class", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Can you model this relationship in another way?"),
                3: TextResponse(text="Is using an association class the best way to model this?"),
                4: ParametrizedResponse(text="Does it make sense to disallow multiple instances of the "
                    "${inBetweenClass} linking ${firstClass} and ${secondClass}?"),
                5: ParametrizedResponse(text="Further details of the association between ${firstClass} and "
                    "${secondClass} should not be modeled with an association class."),
                6: ResourceResponse(learningResources=[assoc_class_ref]),
            })),
            bad_assoc_class_name_spelling := mt(
                n="Bad assoc class name spelling", d="Bad association class name spelling", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Double check this association class name."),
                    3: ParametrizedResponse(text="The ${incorrectlySpelledClassName} class has a misspelled name."),
                    4: ParametrizedResponse(
                        text="The ${incorrectlySpelledClassName} class should be changed to ${correctClassName}."),
                    5: ResourceResponse(learningResources=[class_ref]),
                })),
            assoc_class_should_be_class := mt(
                n="Assoc class should be class", d="Association class should be regular class", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Can you model this relationship in another way?"),
                    3: TextResponse(text="Is using an association class the best way to model this?"),
                    4: ParametrizedResponse(text="The ${assocClass} class should be a regular class."),
                    5: ResourceResponse(learningResources=[assoc_class_ref]),
                })),
            class_should_be_assoc_class := mt(
                n="Class should be assoc class", d="Regular class should be association class", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Can you model this relationship in another way?"),
                    3: TextResponse(text="Is using a regular class the best way to model this?"),
                    4: ParametrizedResponse(text="The ${regularClass} class should be an association class."),
                    5: ResourceResponse(learningResources=[assoc_class_ref]),
                })),
        ]),
        composition_mistakes := mtc(n="Composition mistakes", mistakeTypes=[
            missing_composition := mt(n="Missing composition", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="What is the relationship between these classes?"),
                3: ParametrizedResponse(
                    text="How would you capture that a ${containerClass} contains a ${containedClass}?"),
                4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
            })),
            extra_composition := mt(n="Extra composition", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Is this composition really necessary?"),
                3: ParametrizedResponse(text="The relationship between ${classOne} and ${classTwo} is not expressed "
                    "in the problem description[, but there is a similar relationship with ${classThree} that is "
                    "missing]."),
                4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
            })),
            using_assoc_instead_of_aggregation := mt(
                n="Using assoc instead of aggregation", d="Using association instead of aggregation", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="What is the relationship between these two concepts?"),
                    3: ParametrizedResponse(text="The relationship between ${containedClass} and ${containerClass} "
                        "can be modeled more precisely than with a simple association."),
                    4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
            using_assoc_instead_of_composition := mt(
                n="Using assoc instead of composition", d="Using association instead of composition", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="What is the relationship between these two concepts?"),
                    3: ParametrizedResponse(text="The relationship between ${containedClass} and ${containerClass} is "
                        "more than a simple association."),
                    4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
            using_aggregation_instead_of_composition := mt(n="Using aggregation instead of composition", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Is this the best relationship to use here?"),
                3: ParametrizedResponse(text="The relationship between ${containedClass} and ${containerClass} is "
                    "stronger than an aggregation."),
                4: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
            })),
            composed_part_contained_in_more_than_one_parent := mt(
                n="Composed part contained in more than one parent", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Please double-check this relationship."),
                    3: TextResponse(text="Please review the model containment hierarchy."),
                    4: ParametrizedResponse(
                        text="${incorrectlyContainedClass} cannot be contained in more than one class."),
                    5: ResourceResponse(learningResources=[containment_example := Example(content=dedent("""\
                        Observe the following domain model. Every single class except the root class is contained in the 
                        root class, `PISystem`.

                        ![PISystem](images/PISystem.png)"""))]),
                    6: ResourceResponse(learningResources=[containment_quiz := Quiz(content=dedent("""\
                        Complete the containment tree for the following model.

                        ![IRS](images/IRS.png)"""))]),
                    7: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
                })),
            incomplete_containment_tree := mt(n="Incomplete containment tree", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="What is the relationship between these classes?"),
                3: ParametrizedResponse(
                    text="{containedClass} is a part of ${containerClass}, so how would you model this?"),
                4: ResourceResponse(learningResources=[containment_example]),
                5: ResourceResponse(learningResources=[containment_quiz]),
                6: ResourceResponse(learningResources=[compos_aggreg_assoc_ref]),
            })),
        ]),
        generalization_mistakes := mtc(n="Generalization mistakes", mistakeTypes=[
            missing_generalization := mt(n="Missing generalization", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="What is the relationship between these classes?"),
                3: ParametrizedResponse(text="A ${subclass} is a ${superclass}. How should we model this?"),
                4: ResourceResponse(learningResources=[inherit_hierarchy_quiz := Quiz(content=dedent("""\
                    Place the following classes in an inheritance hierarchy:
                    
                    * `Vehicle`, `LandVehicle`, `AmphibiousVehicle`, `AirVehicle`, ...
                    * `BusVehicle`, `LuxuryBus`, `TourBus`, `BusRoute`, ..."""))]),
                5: ResourceResponse(learningResources=[gen_ref := Reference(
                    content="Please review the [Generalization](https://mycourses2.mcgill.ca/) part of the Class "
                            "Diagram lecture.")]),
            })),
            extra_generalization := mt(n="Extra generalization", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: [TextResponse(text="Can you find a better way to express this relationship?"),
                    TextResponse(text="Is there a [direct ]relationship between these two classes?")],
                3: [ParametrizedResponse(text="When creating a generalization between ${wrongSubclass} and "
                    "${wrongSuperclass}, make sure to follow the "
                    "[checks for proper generalization](https://mycourses2.mcgill.ca/)."),
                    ParametrizedResponse(text="${wrongSubclass} is not a [direct ]subclass of ${wrongSuperclass}.")],
                4: ResourceResponse(learningResources=[inherit_hierarchy_quiz]),
                5: ResourceResponse(learningResources=[inherit_checks_quiz := Quiz(content=dedent(f"""\
                    Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material
                    and complete the following:

                    The five checks for generalization are:
                    * Obeys the ________. (isA rule)
                    * Subclass must retain its ________. (distinctiveness)
                    * All ________ must make sense in each subclass. (inherited features)
                    * Subclass differs from superclass and other subclasses in ________ or ________.{
                        " "}(behavior, structure)
                    * Subclass must not be ________. (an instance)"""))]),
                6: ResourceResponse(learningResources=[gen_ref]),
            })),
            generalization_inapplicable := mt(
                n="Generalization inapplicable", d="Generalization does not follow isA rule", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: [TextResponse(text="Can you find a better way to express this relationship?"),
                        TextResponse(text="Is there a [direct ]relationship between these two classes?")],
                    3: [ParametrizedResponse(text="When creating a generalization between ${wrongSubclass} and "
                        "${wrongSuperclass}, make sure to follow the "
                        "[checks for proper generalization](https://mycourses2.mcgill.ca/)."),
                        ParametrizedResponse(
                            text="${wrongSubclass} is not a [direct ]subclass of ${wrongSuperclass}.")],
                    4: ResourceResponse(learningResources=[inherit_hierarchy_quiz]),
                    5: ResourceResponse(learningResources=[inherit_checks_quiz]),
                    6: ResourceResponse(learningResources=[gen_ref]),
                })),
            subclass_not_distinct_across_lifetime := mt(n="Subclass not distinct across lifetime", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Can you find a better way to model this concept?"),
                3: ParametrizedResponse(text="Is it possible for an instance of ${nondistinctSubclass} to turn into an "
                    "instance of another subclass over its lifetime?"),
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
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(text="Does this belong here?"),
                    3: ParametrizedResponse(text="The ${featureName} feature of the ${superclass} class does not make "
                        "sense for its ${subclass} subclass."),
                    4: ResourceResponse(learningResources=[inherit_checks_quiz]),
                    5: ResourceResponse(learningResources=[gen_ref]),
                })),
            subclass_is_an_instance_of_superclass := mt(n="Subclass is an instance of superclass", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Can you find a better way to express this relationship?"),
                3: TextResponse(text="Remember the definition of the **'instance' rule**.[ Instances should not be "
                    "modeled as subclasses]."),
                4: ResourceResponse(learningResources=[Example(content="A CheckingAccount isA Account, but account1234 "
                    "is **not** an Account according to the 'instance' rule.")]),
                5: ResourceResponse(learningResources=[inherit_checks_quiz]),
                6: ResourceResponse(learningResources=[gen_ref]),
            })),
            non_differentiated_subclass := mt(n="Non-differentiated subclass", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Is it really necessary to model this as a subclass?"),
                3: ParametrizedResponse(text="${wrongSubclass} needs to be different from its superclass[ and its "
                    "sibling subclasses] in terms of behavior or structure."),
                4: ResourceResponse(learningResources=[inherit_checks_quiz]),
                5: ResourceResponse(learningResources=[gen_ref]),
            })),
            wrong_generalization_direction := mt(n="Wrong generalization direction", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Can you double check this relationship?"),
                3: ParametrizedResponse(
                    text="Is ${superclass} really a ${subclass}?[ It should be the other way around.]"),
                4: ResourceResponse(learningResources=[inherit_hierarchy_quiz]),
                5: ResourceResponse(learningResources=[inherit_checks_quiz]),
                6: ResourceResponse(learningResources=[gen_ref]),
            })),
            wrong_superclass := mt(n="Wrong superclass", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(text="Can you double check this relationship?"),
                3: ParametrizedResponse(text="Can you (find|create) a (better|different) superclass for ${subclass}?"
                    "[ Look at the problem description closely]."),
                4: Feedback(highlightProblem=True),
                5: ParametrizedResponse(text="What is the inheritance hierarchy between ${hierarchy.classes}?"),
                6: ResourceResponse(learningResources=[inherit_hierarchy_quiz]),
                7: ResourceResponse(learningResources=[gen_ref]),
            })),
        ]),
    ]),

    design_pattern_mistakes := mtc(n="Design pattern mistakes", subcategories=[
        player_role_pattern_mistakes := mtc(n="Player-Role Pattern mistakes", mistakeTypes=[
            missing_pr_pattern := mt(n="Missing PR pattern", d="Missing Player-Role pattern", feedbacks=fbs({
                1: Feedback(highlightSolution=True),
                2: TextResponse(
                    text="Think carefully about how to model the relationships between these concepts."),
                3: ParametrizedResponse(
                    text="The concepts of ${instructorPlayer} and ${instructorRole} and the relationship between them "
                         "should be modeled with one of the forms of the Player-Role pattern."),
                4: ResourceResponse(learningResources=[pr_quiz := Quiz(content=dedent(f"""\
                    Complete the following table:

                    Solution | Roles have different features | One role at a time |{
                        " "}Different roles at a time | More than one role at the same time
                    --- | --- | --- | --- | ---
                    Enumeration         | [ ] | [ ] | [ ] | [ ]
                    Subclasses          | [ ] | [ ] | [ ] | [ ]
                    Associations        | [ ] | [ ] | [ ] | [ ]
                    Player-Role Pattern | [ ] | [ ] | [ ] | [ ]"""))]),
                5: ResourceResponse(learningResources=[pr_ref := Reference(content=dedent("""\
                    The Player-Role Pattern can be used to capture the fact that an object may play different roles
                    in different contexts.

                    ![Player-Role Pattern](images/player_role.png)"""))]),
            })),
            incomplete_pr_pattern := mt(
                n="Incomplete PR pattern", d="Incomplete Player-Role pattern", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(
                        text="The concepts of ${instructorPlayer} and ${instructorRole} and the relationship between "
                             "them should be modeled with one of the forms of the Player-Role pattern."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            subclass_should_be_full_pr_pattern := mt(
                n="Subclass should be full PR pattern",
                d="Subclass should be full Player-Role pattern",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="[Nice try, but] a ${firstSubclass} can also play the role of "
                                                 "one of the other subclasses."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            subclass_should_be_assoc_pr_pattern := mt(
                n="Subclass should be assoc PR pattern",
                d="Subclass should be association Player-Role pattern",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(
                        text="[Nice try, but] a ${firstSubclass} can also play the role of one of the other "
                             "subclasses and different features do not need to be captured for the subclasses."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            subclass_should_be_enum_pr_pattern := mt(
                n="Subclass should be enum PR pattern",
                d="Subclass should be enumeration Player-Role pattern",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="[Nice try, but] a ${firstSubclass} does not need to play the "
                                                 "role of one of the other subclasses and different features "
                                                 "do not need to be captured for the subclasses."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            assoc_should_be_full_pr_pattern := mt(
                n="Assoc should be full PR pattern",
                d="Association should be full Player-Role pattern",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(
                        text="A ${firstRole} has different features from a ${secondRole}."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            assoc_should_be_subclass_pr_pattern := mt(
                n="Assoc should be subclass PR pattern",
                d="Association should be subclass Player-Role pattern",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="A ${firstRole} has different features from a ${secondRole} "
                                                 "and ${role} does not change its role over its lifetime."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            assoc_should_be_enum_pr_pattern := mt(
                n="Assoc should be enum PR pattern",
                d="Association should be enumeration Player-Role pattern",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="Will the roles of ${firstRole} and ${secondRole} ever be "
                                                 "occupied at the same time?"),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            enum_should_be_full_pr_pattern := mt(
                n="Enum should be full PR pattern",
                d="Enumeration should be full Player-Role pattern",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(
                        text="A ${firstRole} has different features from one of the other roles at the same "
                             "time and different features need to be captured for the roles."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            enum_should_be_subclass_pr_pattern := mt(
                n="Enum should be subclass PR pattern",
                d="Enumeration should be subclass Player-Role pattern",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="A ${firstRole} has different features from one of the other "
                                                 "roles and this role never changes to another role."),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            enum_should_be_assoc_pr_pattern := mt(
                n="Enum should be assoc PR pattern",
                d="Enumeration should be association Player-Role pattern",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="Will the roles of ${firstRole} and ${secondRole} ever be "
                                                 "occupied at the same time?"),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            full_pr_pattern_should_be_subclass := mt(
                n="Full PR pattern should be subclass",
                d="Full Player-Role pattern should be subclass",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(text="Can a ${firstRole} can also play the role of one of the "
                                                 "other roles at different times or at the same time?"),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            full_pr_pattern_should_be_assoc := mt(
                n="Full PR pattern should be assoc",
                d="Full Player-Role pattern should be association",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(
                        text="Do ${firstRole} and ${secondRole} need to have different features?"),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
            full_pr_pattern_should_be_enum := mt(
                n="Full PR pattern should be enum",
                d="Full Player-Role pattern should be enumeration",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(
                        text="Do ${firstRole} and ${secondRole} need to have different features and is it "
                             "possible that more than one role is played at the same time?"),
                    4: ResourceResponse(learningResources=[pr_quiz]),
                    5: ResourceResponse(learningResources=[pr_ref]),
                })),
        ]),
        abstraction_occurrence_pattern_mistakes := mtc(n="Abstraction-Occurrence pattern mistakes", mistakeTypes=[
            missing_ao_pattern := mt(
                n="Missing AO pattern", d="Missing Abstraction-Occurrence pattern", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(
                        text="The concepts of ${instructorAbstraction} and ${instructorOccurrence} and the "
                            "relationship between them should be modeled with the Abstraction-Occurrence pattern."),
                    4: ResourceResponse(learningResources=[ao_ref := Reference(content=dedent("""\
                        The [Abstraction-Occurrence Pattern](https://mycourses2.mcgill.ca/) can be used to 
                        represent a set of related objects that share common information but also differ
                        from each other in an important way.

                        ![Abstraction-Occurrence Pattern](images/abstraction_occurrence.png)"""))]),
                })),
            incomplete_ao_pattern := mt(
                n="Incomplete AO pattern", d="Incomplete Abstraction-Occurrence pattern", feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: ParametrizedResponse(
                        text="The concepts of ${instructorAbstraction} and ${instructorOccurrence} and the "
                            "relationship between them should be modeled with the Abstraction-Occurrence pattern."),
                    4: ResourceResponse(learningResources=[ao_ref]),
                })),
            generalization_should_be_assoc_ao_pattern := mt(
                n="Generalization should be assoc AO pattern",
                d="Generalization should be association in Abstraction-Occurrence pattern",
                feedbacks=fbs({
                    1: Feedback(highlightSolution=True),
                    2: TextResponse(
                        text="Think carefully about how to model the relationships between these concepts."),
                    3: TextResponse(text="Is generalization the correct way to model this use of the "
                                         "Abstraction-Occurrence pattern?"),
                    4: ResourceResponse(learningResources=[ao_ref]),
                })),
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
    wrong_class_name,
    bad_assoc_class_name_spelling,
    assoc_class_should_be_class,
    class_should_be_assoc_class,
    class_should_be_enum,
    enum_should_be_class,
    bad_enum_name_spelling,
    bad_enum_item_spelling,

    # mistakes in an existing attribute
    bad_attribute_name_spelling,
    uppercase_attribute_name,
    plural_attribute,
    attribute_misplaced,
    wrong_attribute_type,
    attribute_should_not_be_static,
    attribute_should_be_static,

    # mistakes in an existing relationship
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
    bad_role_name_spelling,
    representing_action_with_assoc,
    wrong_role_name,
    role_should_not_be_static,
    role_should_be_static,
    bad_association_name_spelling,
    incomplete_containment_tree,

    # design pattern mistakes
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

    # extra items
    extra_class,
    extra_assoc_class,
    extra_enum,
    extra_enum_item,
    extra_generalization,
    extra_composition,
    extra_association,
    extra_aggregation,
    extra_nary_association,
    attribute_duplicated,
    extra_attribute,

    # missing items
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
    missing_nary_association,
    missing_multiplicity,
    missing_role_names,
    missing_association_name,

    # missing/incomplete patterns
    incomplete_pr_pattern,
    incomplete_ao_pattern,
    missing_pr_pattern,
    missing_ao_pattern,
]
