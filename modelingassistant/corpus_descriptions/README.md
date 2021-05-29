# Learning Corpus Content Outline

**About this page:** This page is meant to be a human readable document
that describes some of the content of the learning corpus. This material
will be included in a more machine readable format later. The mistake 
types are taken from our paper [_Towards a Better Understanding of Interactions with a Domain Modeling Assistant_](https://doi.org/10.1145/3417990.3418742).

## Table of Contents

1. [Wrong class](#wrong-class)
   1. [Missing class](#missing-class)
   1. [Extra (redundant) class](#extra-class)
   1. [Wrong class name](#wrong-class-name)
      1. [Using plural or lowercase](#using-plural-or-lowercase)
      1. [Software engineering term](#software-engineering-term)
      1. [Bad class name spelling](#bad-class-name-spelling)
      1. [Similar (yet incorrect) class name](#similar-class-name)
   1. [Wrong enumeration](#wrong-enumeration)
      1. [Regular class should be an enumeration or vice versa](#regular-class-should-be-an-enumeration-or-vice-versa)
      1. [Wrong enumeration items](#wrong-enumeration-items)
      1. [Missing enumeration item](#missing-enumeration-item)

1. [Wrong attribute](#wrong-attribute)
   1. [Missing attribute](#missing-attribute)
   1. [Extra (redundant) attribute](#extra-redundant-attribute)
      1. [Plural attribute or attribute list](#plural-attribute-or-attribute-list)
      1. [Other extra attribute](#other-extra-attribute)
   1. [Wrong attribute name](#wrong-attribute-name)
      1. [Bad attribute name spelling](#bad-attribute-name-spelling)
      1. [Similar (yet incorrect) attribute name](#similar-attribute-name)
   1. [Wrong attribute type](#wrong-attribute-type)
   1. [Attribute in wrong class](#attribute-in-wrong-class)
      1. [Attribute misplaced](#attribute-misplaced)
      1. [Attribute duplicated](#attribute-duplicated)
   1. [Attribute expected to be static but is not or vice versa](#attribute-expected-to-be-static-but-is-not-or-vice-versa)

1. [Wrong relationships](#wrong-relationships)
   1. [Missing relationship of any type](#missing-relationship-of-any-type)
      1. [Using an attribute instead of an association](#using-an-attribute-instead-of-an-association)
      1. [Missing composition](#missing-composition)
      1. [Missing aggregation](#missing-aggregation)
      1. [Missing association](#missing-association)
   1. [Incomplete containment tree](#incomplete-containment-tree)
   1. [Extra (redundant) association](#extra-association)
      1. [Representing an action with an association](#representing-an-action-with-an-association)
      1. [Composed part contained in more than one parent](#composed-part-contained-in-more-than-one-parent)
      1. [Other extra association](#other-extra-association)
   1. [Using wrong relationship type](#using-wrong-relationship-type)
      1. [Using an association instead of an aggregation/composition or vice versa](#using-an-association-instead-of-an-aggregationcomposition-or-vice-versa)
      1. [Using a directed association instead of an undirected one or vice versa](#using-a-directed-association-instead-of-an-undirected-one-or-vice-versa)
      1. [Using aggregation instead of composition or vice versa](#using-aggregation-instead-of-composition-or-vice-versa)
   1. [Wrong association name](#wrong-association-name)
      1. [Missing association name when one was expected](#missing-association-name-when-one-was-expected)
      1. [Bad association name spelling](#bad-association-name-spelling)
      1. [Similar (yet incorrect) association name](#similar-association-name)
   1. [Wrong multiplicities](#wrong-multiplicities)
      1. [Infinite recursive dependency](#infinite-recursive-dependency)
      1. [Other wrong multiplicity](#other-wrong-multiplicity)
   1. [Wrong role names](#wrong-role-names)
      1. [Missing role names](#missing-role-names)
      1. [Role names present but incorrect](#role-names-present-but-incorrect)
      1. [Role expected to be static but is not or vice versa](#role-expected-to-be-static-but-is-not-or-vice-versa)
      1. [Bad role name spelling](#bad-role-name-spelling)
      1. [Similar (yet incorrect) role name](#similar-role-name)
   1. [Wrong association class](#wrong-association-class)
      1. [Missing association class](#missing-association-class)
      1. [Extra (redundant) association class](#extra-association-class)
      1. [Bad association class name spelling](#bad-association-class-name-spelling)
      1. [Similar (yet incorrect) association class name](#similar-association-class-name)
   1. [Wrong generalization](#wrong-generalization)
      1. [Missing generalization](#missing-generalization)
      1. [Inapplicable generalization](#inapplicable-generalization)
      1. [Subclass not distinct across lifetime](#subclass-not-distinct-across-lifetime)
      1. [Inherited feature does not make sense for subclass](#inherited-feature-does-not-make-sense-for-subclass)
      1. [Subclass is an instance of superclass](#subclass-is-an-instance-of-superclass)
      1. [Non-differentiated subclass](#non-differentiated-subclass)
      1. [Wrong generalization direction](#wrong-generalization-direction)
      1. [Wrong superclass](#wrong-superclass)

1. [Modeling antipatterns or misuse of design patterns](#modeling-antipatterns-or-misuse-of-design-patterns)
   1. [Misuse of Player-Role Pattern](#misuse-of-player-role-pattern)
   1. [Misuse of Abstraction-Occurrence](#misuse-of-abstraction-occurrence)

___

## Wrong class

### Missing class

Level 1: Highlight sentence of problem statement element

Level 2: Text response:

> Make sure you have modeled all the classes in the problem description.

Level 3: Highlight problem statement element

Level 4: Parameterized Response

> Remember to add the ${className} class.

### Extra class

Level 1: Highlight solution

Level 2: Text response:

> Make sure you only model the concepts mentioned in the problem description.

Level 3: Text response:

> You have an extra class. Can you find it?

Level 4: Parameterized Response

> The ${className} class is not part of the domain, so please remove it.

> Remember that a domain model should not contain concepts from the user interfaces or databases, like Window, Database, etc.

### Wrong class name

#### Using plural or lowercase

Level 1: Highlight solution

Level 2: Text response:

> Remember that class names must start with a Capital Letter.

> Remember that class names should be singular.

Level 3: Parameterized Response

> ${className} should be ${pascalCase(className)}, with a Capital Letter.

> ${className} should be ${singular(className)}, using the singular.

Level 4: Resource Response with Example:

> Please note these examples of correct vs incorrect class naming:
> :x: Examples to avoid | :heavy_check_mark: Good class names
> --- | ---
> pilot | Pilot
> Airplanes | Airplane 
> AirlineData | Airline

#### Software engineering term

Level 1: Highlight solution

Level 2: Text response:

> Remember that a domain model should not contain software engineering terms.

Level 3: Parameterized Response

> ${className} is a software engineering term, which does not belong in a domain model.

Level 4: Resource Response with Example:

> Please note these examples of correct vs incorrect class naming:
> :x: Examples to avoid | :heavy_check_mark: Good class names
> --- | ---
> pilot | Pilot
> Airplanes | Airplane 
> AirlineData | Airline

#### Bad class name spelling

Level 1: Highlight solution

Level 2: Text response:

> Can you double check this class name?

Level 3: Parameterized Response

> The ${incorrectlySpelledClassName} class has a misspelled name. 

Level 4: Parameterized Response

> The ${incorrectlySpelledClassName} class should be changed to
${correctClassName}.

#### Similar class name

Level 1: Highlight solution

Level 2: Text response:

> Can you double check this class name?

Level 3: Parameterized Response

> The ${similarYetIncorrectClassName} class has a name that is not quite right.

Level 4: Parameterized Response

> The ${similarYetIncorrectClassName} class should be changed to
${correctClassName}.


### Wrong enumeration

#### Regular class should be an enumeration or vice versa

Level 1: Highlight class

Level 2: Text response

> Is there anything special about this class?

Level 3: Parameterized response

> The ${className} can only be one of ${correctEnumSize} options, so what is
the best way to model this?

> Is ${className} limited to the options shown in (an|this) enumeration?
Can this be modeled differently?

Level 4: Resource Response with link to Reference:

> Please review the [Enumeration](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.

#### Wrong enumeration items

Level 1: Highlight enumeration class or items

Level 2: Text response

> Is there anything missing here?

> Should this really be here?

> Can this item be renamed?

Level 3: Parameterized response

> The ${enumName} enumeration is missing an item.

> The ${enumName} enumeration has an extra item.

> The ${wronglyNamedEnumItem} should be renamed[ to ${correctEnumItemName}].

Level 4: Resource Response with link to Reference:

> Please review the [Enumeration](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.

___

## Wrong attribute

### Missing attribute

Level 1: Highlight class

Level 2: Text response

> Make sure to model all the concepts/attributes of this class.

Level 3: Parameterized response

> The ${className} is missing an attribute.

Level 4: Parameterized response

> A ${className} has a ${missingAttribute}.

Level 5: Resource Response with link to Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and
[Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.

### Extra (redundant) attribute

#### Plural attribute or attribute list

Level 1: Highlight attribute

Level 2: Text response

> Can you double check this attribute name?
>
> _(if attribute should be singular)_

> Is there a better way to model this concept?
>
> _(if attribute should be association instead)_

Level 3: Text response

> Remember that attributes are simple pieces of data.

Level 3: Parameterized Response

> ${includingClass.attributeName} should be modeled as an association instead.

Level 4: Resource Response with Quiz:

> Pick the classes which are modeled correctly.
>
> - [ ] class Student { courses; }
> - [ ] class Folder { List\<File\> files; }
> - [ ] class Restaurant { 1 -- * Employee; }

#### Other extra attribute

Level 1: Highlight attribute

Level 2: Text response

> Do we really need to model this concept?

Level 3: Parameterized response

> The ${redundantAttribute} in the ${className} class is not needed.

> The ${redundantAttribute} attribute in the ${className} class is not 
needed because it can be derived from ${derivationSources}.
>
> _e.g., The area attribute in the Rectangle class is not needed because it can be derived from the length and width._

> The ${redundantAttribute} attribute in the ${className} class is not 
needed because it is not part of the domain. You only need to model concepts
related to the given problem description.

Level 4: Resource Response with link to Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and
[Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.

### Wrong attribute name

#### Bad attribute name spelling

Level 1: Highlight attribute

Level 2: Text response

> Check your spelling here.

Level 3: Parameterized Response

> ${wrongAttribute} is misspelled. [Use the same spelling as the problem description.] 

Level 4: Resource Response with link to Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and
[Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.

#### Similar attribute name

Level 1: Highlight attribute

Level 2: Text response

> Remember that attributes are written in _lowerCamelCase_.

> Can you think of a better way to name this attribute?

_Response varies based on exact mistake._

Level 3: Parameterized Response

> ${wrongAttribute} incorrectly starts with an Uppercase Letter. Attributes should start with a lowercase letter.

> Can you rename the ${wrongAttribute} of the ${className} to fit the problem description?

Level 4: Resource Response with link to Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and
[Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.

### Wrong attribute type

Level 1: Highlight attribute type

Level 2: Text response

> Can you double-check this?

Level 3: Parameterized Response

> Can you think of a better type for ${attribute}?

Level 4: Parameterized Response

> The ${className}.${attribute} is not of type ${attribute.type} because ${mistakeType.reason}. 

_Only offered in cases where a reason can be determined, eg not a simple data type._

Level 5: Resource Response with link to Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.

### Attribute in wrong class

#### Attribute misplaced

Level 1: Highlight attribute

Level 2: Text response

> Can you think of a better place for this?

Level 3: Parameterized Response

> The ${misplacedAttribute} does not belong in the ${wrongClass} class.
Where else can we place it?

Level 4: Resource Response with link to Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.

#### Attribute duplicated

Level 1: Highlight attribute

Level 2: Text response

> Are you sure this is needed?

Level 3: Text response

> Does this need to be included more than once?

Level 4: Parameterized Response

> The ${duplicateAttribute} already exists in ${correctClass}, so there
is no need to include it again.

Level 5: Resource Response with link to Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.

### Attribute expected to be static but is not or vice versa

Level 1: Highlight attribute

Level 2: Text response

> Is[n't] there something special about this attribute?

Level 3: Parameterized Response

> ${includingClass.attributeName} should [not] be static, because it
(applies|doesn't apply) to all instances of ${includingClass}.

Level 4: Resource Response with link to Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.

___

## Wrong relationships

### Missing relationship of any type

#### Using an attribute instead of an association

Level 1: Highlight attribute

Level 2: Text response

> Remember that attributes are simple pieces of data.

Level 3: Parameterized Response

> ${includingClass.attributeName} should be its own class.

Level 4: Resource Response with Quiz:

> Pick the classes which are modeled correctly.
>
> - [ ] class Person { address; }
> - [ ] class Person { * Person -- 1 Address; }; class Address {}
> - [ ] class Loan { libraryPatron; }

#### Missing Composition

Level 1: Highlight classes

Level 2: Text response

> Is there a relationship between these classes?

> What is the relationship between these classes?

Level 3: Parameterized Response

> How would you capture that a ${containerClass} contains a ${containedClass}?

Level 4: Resource Response with Example

Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)

#### Missing Aggregation

Level 1: Highlight classes

Level 2: Text response

> Is there a relationship between these classes?

> What is the relationship between these classes?

Level 3: Parameterized Response

> How would you capture that a ${classOne} has a ${classTwo}?

Level 4: Resource Response with Example

Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)

#### Missing Association

Level 1: Highlight classes

Level 2: Text response

> Is there a relationship between these classes?

> What is the relationship between these classes?

Level 3: Parameterized Response

> How would you capture that a ${classOne} has a ${classTwo}?

Level 4: Resource Response with Example

Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)

### Incomplete containment tree

Level 1: Highlight classes

Level 2: Text response

> What is the relationship between the highlighted classes?

Level 3: Parameterized Response

> ${containedClass} is a part of ${containerClass}, so how would you model this?

Level 4: Resource Response with Example

Observe the following domain model. Every single class is contained in the 
root class, `PISystem`, other than the root class itself.

![PISystem](images/PISystem.png)

Level 5: Resource Response with Quiz

Complete the containment tree for the following model.

![IRS](images/IRS.png)

_Possible approaches:_

* Use the envisioned UI for the quiz and let students create the
compostitions themselves.
* Multiple choice in the form: Pick the classes which are _directly_
contained in the `IRS` root node.
  `Team`, `League`, `Sport`, `Registration`, `Game`, `RegularLeague`,
  `WeekendLeague`, `Person`, `StudentRole`, `RefereeRole`, `IRS`.


### Extra association

#### Representing an action with an association

Level 1: Highlight association

Level 2: Text response

> Is association the best way to model this concept?

Level 3: Parameterized Response

> ${actionName} should not be modeled as an association.

> ${actionName} does not need be modeled as part of a domain model.

Level 4: Resource Response with link to Reference

> Please review the [domain modeling lecture](https://mycourses2.mcgill.ca/)
to review which concepts should be a part of a domain model.

#### Composed part contained in more than one parent

Level 1: Highlight (wrong) association

Level 2: Text response

> Please double-check this relationship.

Level 3: Text response

> Please review the model containment hierarchy.

Level 4: Parameterized Response

> ${incorrectlyContainedClass} cannot be contained in more than one class.

Level 5: Resource Response with Example

Observe the following domain model. Every single class is contained in exactly 
one class, except `PISystem`, which is the root class.

![PISystem](images/PISystem.png)

Level 6: Resource Response with Quiz

Complete the containment tree for the following model.

![IRS](images/IRS.png)

_Possible approaches:_

* Use the envisioned UI for the quiz and let students create the
compostitions themselves.
* Multiple choice in the form: Pick the classes which are _directly_
contained in the `IRS` root node.
  `Team`, `League`, `Sport`, `Registration`, `Game`, `RegularLeague`,
  `WeekendLeague`, `Person`, `StudentRole`, `RefereeRole`, `IRS`.

#### Other extra association

Level 1: Highlight association

Level 2: Text response

> Is this association really necessary?

Level 3: Parameterized Response

> The relationship between ${classOne} and ${classTwo} is not expressed in the 
problem description[, but there is a similar relationship with ${classThree} 
that is missing].

> The relationship between ${classOne} and ${classTwo} is redundant since we
can access ${classTwo} from ${classOne} via ${classThree}.

_Used in the case A-C-B, A-B._

Level 4: Resource Response with Quiz

Find all the redunandant associations in this class diagram (TODO).

**OR**

Write pseudocode to navigate between ClassOne and ClassTwo in this class diagram (TODO).


### Using wrong relationship type

#### Using an association instead of an aggregation/composition or vice versa

Level 1: Highlight relationship

Level 2: Text response

> What is the relationship between these two concepts?

Level 3: Parameterized Response

> Why is ${incorrectlyContainedClass} contained in ${containerClass}?

> The relationship between ${containedClass} and ${containerClass} can be
modeled more precisely than with a simple association.

Level 4: Resource Response with Example

Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better differentiate these relationships.

![composition vs aggregation vs association](images/composition_aggregation_association.png)


#### Using a directed association instead of an undirected one or vice versa

Level 1: Highlight association

Level 2: Text response

> Is there anything special about this association?

Level 3: Parameterized response

> The association between ${classOne} and ${classTwo} should be [un]directed[ from ${classOne} to ${classTwo}].

Level 4: Resource Response with link to Reference:

> Please review the [Association](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.

#### Using aggregation instead of composition or vice versa

Level 1: Highlight relationship

Level 2: Text response

> Is this the best relationship to use here?

Level 3: Parameterized response

> The (aggregation|composition) between ${containedClass} and ${containerClass}
is better modeled using (composition|aggregation).

Level 4: Resource Response with link to Reference:

Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better differentiate these relationships.

![composition vs aggregation vs association](images/composition_aggregation_association.png)

### Wrong association name

#### Missing association name when one was expected

Level 1: Highlight association

Level 2: Text response

> Something is missing here.

Level 3: Text Response

> Can you give this association a name?

Level 4: Parameterized Response

> This association should be named ${associationName}.

Level 5: Resource Response with link to Reference:

> Please review the [Association](https://mycourses2.mcgill.ca/) and
[Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.

#### Bad association name spelling

Level 1: Highlight association name

Level 2: Text response

> Check your spelling here.

Level 3: Parameterized Response

> ${associationName} is misspelled. [Use the same spelling as the problem description.] 

Level 4: Resource Response with link to Reference:

> Please review the [Association](https://mycourses2.mcgill.ca/) and
[Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.

#### Similar association name

Level 1: Highlight solution

Level 2: Text response:

> Can you double check this association name?

Level 3: Parameterized Response

> The ${similarYetIncorrectAssociationName} association has a name that is not quite right.

Level 4: Parameterized Response

> The ${similarYetIncorrectAssociationName} association should be changed to
${correctAssociationName}.

### Wrong multiplicities

#### Infinite recursive dependency

Level 1: Highlight association(s)

Level 2: Text response

> Can you double check this(ese) association(s)?

Level 3: Text response

> The multiplicities for this(ese) association(s) are incorrect.

Level 4: Parameterized Response

> Does every ${class1} have exactly ${wrongMultiplicity} ${rolename}[s]?
>
> _(For a self-referencing class, eg, a Person has 2 parents.)_

> How many ${class1}'s does a ${class2} have? [And so on]
>
> _(For two classes with multiplicities 1+ on either end.)_

> Double check the multiplicites between ${class1}, ${class2}, and ${class3}.

Level 5: Resource Response with Quiz

> Write code in ${programmingLanguage} to instantiate a ${Foo} given the following class diagram: 1 Foo -- 1 Bar and the generated code from Umple:
> ```
> Foo(Bar)
> Bar(Foo)
> ```
> Yes, it is impossible to create a ${Foo} for the class diagram as given,
because we need a ${Bar} to create a ${Foo}, but we need a ${Bar} to make 
that ${Foo}, and so on.

_Alternatively, give a MCQ with 3+ incorrect answers, and an explanation for why each one will not work._

> Edit the class diagram to allow creating a ${Foo} (could give MC options here).

#### Other wrong multiplicity

Level 1: Highlight association

Level 2: Text response

> Can you double check this association?

Level 3: Text response

> The multiplicities for this association are incorrect.

Level 4: Parameterized Response

> How many ${class1}'s does a ${class2} have? [And how many ${class2}'s
does ${class1} have?]

Level 5: Resource Response with Quiz

> Pick the associations with correct multiplicities
>
> - [ ] 1 EmployeeRole -- 1 Person;
> - [ ] * Episode -- 1 TvSeries;
> - [ ] * Bank -- 1 Client;

### Wrong role names

#### Missing role names

Level 1: Highlight association

Level 2: Text response

> Can you model this relationship more precisely?

Level 3: Text response

> The multiplicities for this association are correct, but something else is missing!

Level 4: Resource Response with link to Reference

> Can you think of appropriate [role names](https://mycourses2.mcgill.ca/)
for this association? Role names help identify the role a class plays in a
relationship and can be important if there is more than one relationship
between the same two classes.

![Role name](images/role_name.png)

#### Role names present but incorrect

Level 1: Highlight solution

Level 2: Text response:

> Can you double check this role name?

Level 3: Parameterized Response

> The ${similarYetIncorrectRoleName} role name is incorrect.

Level 4: Parameterized Response

> The ${similarYetIncorrectRoleName} role name should be changed to
${correctRoleName}.

#### Role expected to be static but is not or vice versa

Level 1: Highlight role name

Level 2: Text response

> Is[n't] there something special about this role name?

Level 3: Parameterized Response

> ${roleName} should [not] be static, because it
(applies|doesn't apply) to all instances of the association between
${class1} and ${class2}.

Level 4: Resource Response with link to Reference:

> Please review the [Association](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.

#### Bad role name spelling

Level 1: Highlight role name

Level 2: Text response

> Check your spelling here.

Level 3: Parameterized Response

> ${roleName} is misspelled. [Use the same spelling as the problem description.] 

Level 4: Resource Response with link to Reference:

> Please review the [Association](https://mycourses2.mcgill.ca/) and
[Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.

#### Similar role name

Level 1: Highlight solution

Level 2: Text response:

> Can you double check this role name?

Level 3: Parameterized Response

> The ${similarYetIncorrectRoleName} role name is not quite right.

Level 4: Parameterized Response

> The ${similarYetIncorrectRoleName} role name should be changed to
${correctRoleName}.

### Wrong association class

#### Missing association class

Level 1: Highlight association

Level 2: Text response

> Can you model this relationship more precisely?

Level 3: Parameterized Response

> Does it make sense to have multiple instances of the ${inBetweenClass}
linking ${firstClass} and ${secondClass}?

Level 4: Parameterized Response

> The association between ${firstClass} and ${secondClass} should be
modeled with an [association class](https://mycourses2.mcgill.ca/).

Level 5: Resource Response with link to Reference

![Association class](images/association_class.png)

#### Extra association class

Level 1: Highlight association

Level 2: Text response

> Can you model this relationship in another way?

Level 3: Text response

> Is using an association class the best way to model this?

Level 4: Parameterized Response

> Does it make sense to disallow multiple instances of the ${inBetweenClass}
linking ${firstClass} and ${secondClass}?

Level 5: Parameterized Response

> The association between ${firstClass} and ${secondClass} should not be
modeled with an [association class](https://mycourses2.mcgill.ca/).

Level 6: Resource Response with link to Reference

![Association class](images/association_class.png)

#### Bad association class name spelling

Level 1: Highlight solution

Level 2: Text response:

> Can you double check this class name?

Level 3: Parameterized Response

> The ${incorrectlySpelledClassName} class has a misspelled name. 

Level 4: Parameterized Response

> The ${incorrectlySpelledClassName} class should be changed to
${correctClassName}.

#### Similar association class name

Level 1: Highlight solution

Level 2: Text response:

> Can you double check this class name?

Level 3: Parameterized Response

> The ${similarYetIncorrectClassName} class has a name that is not quite right.

Level 4: Parameterized Response

> The ${similarYetIncorrectClassName} class should be changed to
${correctClassName}.

### Wrong generalization

#### Missing generalization

Level 1: Highlight classes

Level 2: Text response

> What is the relationship between these classes?

Level 3: Parameterized Response

> A ${subclass} is a ${superclass}. How should we model this?

Level 4: Resource Response with Quiz

<!-- TODO Complete following lists -->

> Place the following classes in an inheritance hierarchy:
>
> * `Vehicle`, `LandVehicle`, `AmphibiousVehicle`, `AirVehicle`, ...
> * `BusVehicle`, `LuxuryBus`, `TourBus`, `BusRoute` ...

#### Inapplicable generalization

Level 1: Highlight classes

Level 2: Text response

> Can you find a better way to express this relationship?

> Is there a (direct) relationship between these two classes?

Level 3: Parameterized Response

> When creating a generalization between ${wrongSubclass} and
${wrongSuperclass}, make sure to follow the [checks for proper generalization](https://mycourses2.mcgill.ca/).

> ${wrongSubclass} is not a (direct) subclass of ${wrongSuperclass}.

Level 4: Resource Response with Quiz

<!-- TODO Complete following lists -->

> Place the following classes in an inheritance hierarchy:
>
> * `Vehicle`, `LandVehicle`, `AmphibiousVehicle`, `AirVehicle`, ...
> * `BusVehicle`, `LuxuryBus`, `TourBus`, `BusRoute`, ...

Level 5: Resource Response with Reference and Quiz

Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material and complete the following:

The five checks for generalization are:
* Obeys the ________. (isA rule)
* Subclass must retain its ________. (distinctiveness)
* All ________ must make sense in each subclass. (inherited features)
* Subclass differs from superclass and other subclasses in ________ or ________. 
(behavior, structure)
* Subclass must not be ________. (instance)

#### Inherited feature does not make sense for subclass

Level 1: Highlight class

Level 2: Text response

> Does this belong here?

Level 3: Parameterized Response

> The ${featureName} feature of the ${superclass} class does not make sense
for its ${subclass} subclass.

Level 4: Resource Response with Reference and Quiz

Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material and complete the following:

The five checks for generalization are:
* Obeys the ________. (isA rule)
* Subclass must retain its ________. (distinctiveness)
* All ________ must make sense in each subclass. (inherited features)
* Subclass differs from superclass and other subclasses in ________ or ________. 
(behavior, structure)
* Subclass must not be ________. (instance)

#### Subclass not distinct across lifetime

Level 1: Highlight class

Level 2: Text response

> Can you find a better way to model this concept?

Level 3: Parameterized Response

> Will a[n] ${nondistinctSubclass} retain this status over its lifetime?

Level 4: Resource Response with Reference and Quiz

Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material and complete the following:

The five checks for generalization are:
* Obeys the ________. (isA rule)
* Subclass must retain its ________. (distinctiveness)
* All ________ must make sense in each subclass. (inherited features)
* Subclass differs from superclass and other subclasses in ________ or ________. 
(behavior, structure)
* Subclass must not be ________. (instance)

#### Subclass is an instance of superclass

Level 1: Highlight class

Level 2: Text response

> Can you find a better way to express this relationship?

Level 3: Text response

> Remember the definition of the **isA rule**. [Instances should not be modeled as subclasses].

Level 4: Resource Response with Example

> A CheckingAccount isA Account, but account1234 is **not** an Account according to the isA Rule.

Level 5: Resource Response with Reference and Quiz

Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material and complete the following:

The five checks for generalization are:
* Obeys the ________. (isA rule)
* Subclass must retain its ________. (distinctiveness)
* All ________ must make sense in each subclass. (inherited features)
* Subclass differs from superclass and other subclasses in ________ or ________. 
(behavior, structure)
* Subclass must not be ________. (instance)

#### Non-differentiated subclass

Level 1: Highlight class

Level 2: Text response

> Is it really necessary to model this as a subclass?

Level 3: Parameterized Response

> ${wrongSubclass} does not differ from ${wrongSuperclass} in terms of
behavior or structure.

Level 4: Resource Response with Quiz

Which classes do not belong?
* `Account`, `SavingsAccount`, `OverdrawnAccount`, `CheckingAccount`, `MortgageAccount`, `ClosedAccount`, 


#### Wrong generalization direction

Level 1: Highlight classes or relationship arrow

Level 2: Text response

> Can you double-check this relationship?

Level 3: Parameterized Response

> Is ${superclass} really a ${subclass}? [It should be the other way around.]

Level 4: Resource Response with Quiz

<!-- TODO Complete following lists -->

> Place the following classes in an inheritance hierarchy:
>
> * `Vehicle`, `LandVehicle`, `AmphibiousVehicle`, `AirVehicle`, ...
> * `BusVehicle`, `LuxuryBus`, `TourBus`, `BusRoute` ...

Level 5: Resource Response with Reference and Quiz

Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material and complete the following:

The five checks for generalization are:
* Obeys the ________. (isA rule)
* Subclass must retain its ________. (distinctiveness)
* All ________ must make sense in each subclass. (inherited features)
* Subclass differs from superclass and other subclasses in ________ or ________. 
(behavior, structure)
* Subclass must not be ________. (instance)

#### Wrong superclass

Level 1: Highlight classes or relationship arrow

Level 2: Text response

> Can you double-check this relationship?

Level 3: Parameterized Response

> Can you (find|create) a (better|different) superclass for ${subclass}? [Look at the problem description closely].

Level 4: Highlight problem description elements

Level 5: Parameterized Response

> What is the inheritance hierarchy between ${hierarchy.classes}?

Level 6: Resource Response with Quiz

<!-- TODO Complete following lists -->

> Place the following classes in an inheritance hierarchy:
>
> * `Vehicle`, `LandVehicle`, `AmphibiousVehicle`, `AirVehicle`, ...
> * `BusVehicle`, `LuxuryBus`, `TourBus`, `BusRoute` ...

___

## Modeling antipatterns or misuse of design patterns

### Misuse of Player-Role Pattern

Level 1: Highlight wrong attribute(s) or class(es)

Level 2: Text response

> Think carefully about how to model the relationships between these concepts.

Level 3: Parameterized Response

> Modeling all the concepts in one ${playerClass} class will make it very 
complicated! Think about adding one or more classes to better represent the domain.

> (Nice try, but) a ${firstSubclass} can also play the role of a ${secondSubclass}.

Level 4: Resource Response with Reference

The [Player-Role Pattern](https://mycourses2.mcgill.ca/) can be used to 
capture the fact that an object may play different roles in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource Response with Quiz

Complete the following table:

Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
--- | --- | --- | --- | ---
Enumeration         | [ ] | [ ] | [ ] | [ ]
Subclasses          | [ ] | [ ] | [ ] | [ ]
Associations        | [ ] | [ ] | [ ] | [ ]
Player-Role Pattern | [ ] | [ ] | [ ] | [ ]

### Misuse of Abstraction-Occurrence

TODO
