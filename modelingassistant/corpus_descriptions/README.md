1. [Class mistakes](#class-mistakes)
   1. [Class name mistakes](#class-name-mistakes)
      1. [Plural class name](#plural-class-name)
      1. [Lowercase class name](#lowercase-class-name)
      1. [Software engineering term](#software-engineering-term)
      1. [Bad class name spelling](#bad-class-name-spelling)
      1. [Wrong class name](#wrong-class-name)
   1. [Enumeration mistakes](#enumeration-mistakes)
      1. [Regular class should be enumeration](#regular-class-should-be-enumeration)
      1. [Enumeration should be regular class](#enumeration-should-be-regular-class)
      1. [Missing enumeration](#missing-enumeration)
      1. [Extra enumeration](#extra-enumeration)
      1. [Bad enumeration name spelling](#bad-enumeration-name-spelling)
      1. [Missing enumeration item](#missing-enumeration-item)
      1. [Extra enumeration item](#extra-enumeration-item)
      1. [Bad enumeration item spelling](#bad-enumeration-item-spelling)
   1. [Missing class](#missing-class)
   1. [Extra class](#extra-class)
   1. [Using n-ary association instead of intermediate class](#using-n-ary-association-instead-of-intermediate-class)

1. [Attribute mistakes](#attribute-mistakes)
   1. [Extra attribute mistakes](#extra-attribute-mistakes)
      1. [Plural attribute](#plural-attribute)
      1. [List attribute](#list-attribute)
      1. [Extra attribute](#extra-attribute)
   1. [Attribute name mistakes](#attribute-name-mistakes)
      1. [Bad attribute name spelling](#bad-attribute-name-spelling)
      1. [Uppercase attribute name](#uppercase-attribute-name)
   1. [Attribute in wrong class mistakes](#attribute-in-wrong-class-mistakes)
      1. [Attribute misplaced](#attribute-misplaced)
      1. [Attribute duplicated](#attribute-duplicated)
      1. [Attribute misplaced in generalization hierarchy](#attribute-misplaced-in-generalization-hierarchy)
   1. [Missing attribute](#missing-attribute)
   1. [Wrong attribute type](#wrong-attribute-type)
   1. [Missing attribute type](#missing-attribute-type)
   1. [Attribute should be static](#attribute-should-be-static)
   1. [Attribute should not be static](#attribute-should-not-be-static)

1. [Relationship mistakes](#relationship-mistakes)
   1. [Association mistakes](#association-mistakes)
      1. [Missing association mistakes](#missing-association-mistakes)
         1. [Missing association](#missing-association)
         1. [Missing aggregation](#missing-aggregation)
         1. [Missing n-ary association](#missing-n-ary-association)
         1. [Using attribute instead of association](#using-attribute-instead-of-association)
      1. [Extra association mistakes](#extra-association-mistakes)
         1. [Representing an action with an association](#representing-an-action-with-an-association)
         1. [Extra association](#extra-association)
         1. [Extra aggregation](#extra-aggregation)
         1. [Extra n-ary association](#extra-n-ary-association)
      1. [Association type mistakes](#association-type-mistakes)
         1. [Using aggregation instead of association](#using-aggregation-instead-of-association)
         1. [Using composition instead of association](#using-composition-instead-of-association)
         1. [Using directed relationship instead of undirected relationship](#using-directed-relationship-instead-of-undirected-relationship)
         1. [Using undirected relationship instead of directed relationship](#using-undirected-relationship-instead-of-directed-relationship)
         1. [Using composition instead of aggregation](#using-composition-instead-of-aggregation)
         1. [Using binary association instead of n-ary association](#using-binary-association-instead-of-n-ary-association)
         1. [Using n-ary association instead of binary association](#using-n-ary-association-instead-of-binary-association)
         1. [Using intermediate class instead of n-ary association](#using-intermediate-class-instead-of-n-ary-association)
      1. [Association name mistakes](#association-name-mistakes)
         1. [Missing association name](#missing-association-name)
         1. [Bad association name spelling](#bad-association-name-spelling)
      1. [Multiplicity mistakes](#multiplicity-mistakes)
         1. [Infinite recursive dependency](#infinite-recursive-dependency)
         1. [Wrong multiplicity](#wrong-multiplicity)
         1. [Missing multiplicity](#missing-multiplicity)
      1. [Role name mistakes](#role-name-mistakes)
         1. [Missing role names](#missing-role-names)
         1. [Role should be static](#role-should-be-static)
         1. [Role should not be static](#role-should-not-be-static)
         1. [Bad role name spelling](#bad-role-name-spelling)
         1. [Wrong role name but correct association](#wrong-role-name-but-correct-association)
      1. [Association class mistakes](#association-class-mistakes)
         1. [Missing association class](#missing-association-class)
         1. [Extra association class](#extra-association-class)
         1. [Bad association class name spelling](#bad-association-class-name-spelling)
         1. [Association class should be regular class](#association-class-should-be-regular-class)
         1. [Regular class should be association class](#regular-class-should-be-association-class)
   1. [Composition mistakes](#composition-mistakes)
      1. [Missing composition](#missing-composition)
      1. [Extra composition](#extra-composition)
      1. [Using association instead of aggregation](#using-association-instead-of-aggregation)
      1. [Using association instead of composition](#using-association-instead-of-composition)
      1. [Using aggregation instead of composition](#using-aggregation-instead-of-composition)
      1. [Composed part contained in more than one parent](#composed-part-contained-in-more-than-one-parent)
      1. [Incomplete containment tree](#incomplete-containment-tree)
   1. [Generalization mistakes](#generalization-mistakes)
      1. [Missing generalization](#missing-generalization)
      1. [Extra generalization](#extra-generalization)
      1. [Generalization does not follow isA rule](#generalization-does-not-follow-isa-rule)
      1. [Subclass not distinct across lifetime](#subclass-not-distinct-across-lifetime)
      1. [Inherited feature does not make sense for subclass](#inherited-feature-does-not-make-sense-for-subclass)
      1. [Subclass is an instance of superclass](#subclass-is-an-instance-of-superclass)
      1. [Non-differentiated subclass](#non-differentiated-subclass)
      1. [Wrong generalization direction](#wrong-generalization-direction)
      1. [Wrong superclass](#wrong-superclass)

1. [Design pattern mistakes](#design-pattern-mistakes)
   1. [Player-Role Pattern mistakes](#player-role-pattern-mistakes)
      1. [Using different Player-Role pattern](#using-different-player-role-pattern)
         1. [Subclass should be full Player-Role pattern](#subclass-should-be-full-player-role-pattern)
         1. [Subclass should be association Player-Role pattern](#subclass-should-be-association-player-role-pattern)
         1. [Subclass should be enumeration Player-Role pattern](#subclass-should-be-enumeration-player-role-pattern)
         1. [Association should be full Player-Role pattern](#association-should-be-full-player-role-pattern)
         1. [Association should be subclass Player-Role pattern](#association-should-be-subclass-player-role-pattern)
         1. [Association should be enumeration Player-Role pattern](#association-should-be-enumeration-player-role-pattern)
         1. [Enumeration should be full Player-Role pattern](#enumeration-should-be-full-player-role-pattern)
         1. [Enumeration should be subclass Player-Role pattern](#enumeration-should-be-subclass-player-role-pattern)
         1. [Enumeration should be association Player-Role pattern](#enumeration-should-be-association-player-role-pattern)
         1. [Full Player-Role pattern should be subclass](#full-player-role-pattern-should-be-subclass)
         1. [Full Player-Role pattern should be association](#full-player-role-pattern-should-be-association)
         1. [Full Player-Role pattern should be enumeration](#full-player-role-pattern-should-be-enumeration)
      1. [Missing Player-Role pattern](#missing-player-role-pattern)
      1. [Incomplete Player-Role pattern](#incomplete-player-role-pattern)
   1. [Abstraction-Occurrence pattern mistakes](#abstraction-occurrence-pattern-mistakes)
      1. [Missing Abstraction-Occurrence pattern](#missing-abstraction-occurrence-pattern)
      1. [Incomplete Abstraction-Occurrence pattern](#incomplete-abstraction-occurrence-pattern)
      1. [Generalization should be association in Abstraction-Occurrence pattern](#generalization-should-be-association-in-abstraction-occurrence-pattern)

## Class mistakes

### Class name mistakes

#### Plural class name

Level 1: Highlight solution

Level 2: Text response:

> Remember that class names should be singular.

Level 3: Parametrized response:

> ${className} should be ${singular(className)}, using the singular.

Level 4: Resource response with Example:

> Please note these examples of correct vs incorrect class naming:
> :x: Examples to avoid | :heavy_check_mark: Good class names
> --- | ---
> pilot | Pilot
> Airplanes | Airplane 
> AirlineData | Airline


#### Lowercase class name

Level 1: Highlight solution

Level 2: Text response:

> Remember that class names must start with a Capital Letter.

Level 3: Parametrized response:

> ${className} should be ${pascalCase(className)}, with a Capital Letter.

Level 4: Resource response with Example:

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

Level 3: Parametrized response:

> ${className} contains a software engineering term, which does not belong in a domain model.

Level 4: Resource response with Example:

> Please note these examples of correct vs incorrect class naming:
> :x: Examples to avoid | :heavy_check_mark: Good class names
> --- | ---
> pilot | Pilot
> Airplanes | Airplane 
> AirlineData | Airline


#### Bad class name spelling

Level 1: Highlight solution

Level 2: Text response:

> Double check this class name.

Level 3: Parametrized response:

> The ${incorrectlySpelledClassName} class has a misspelled name.

Level 4: Parametrized response:

> The ${incorrectlySpelledClassName} class should be changed to ${correctClassName}.


#### Wrong class name

Level 1: Highlight solution

Level 2: Text response:

> Double check this class name.

Level 3: Parametrized response:

> The ${similarYetIncorrectClassName} class has a name that is not quite right.

Level 4: Parametrized response:

> The ${similarYetIncorrectClassName} class should be changed to ${correctClassName}.


### Enumeration mistakes

#### Regular class should be enumeration

Level 1: Highlight solution

Level 2: Text response:

> Is there anything special about this class?

Level 3: Parametrized response:

> The ${className} can only be one of ${correctEnumSize} options, so what is the best way to model this?

Level 4: Resource response with Reference:

> Please review the [Enumeration](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.


#### Enumeration should be regular class

Level 1: Highlight solution

Level 2: Text response:

> Is there anything special about this class?

Level 3: Parametrized response:

> Is ${className} limited to the options shown in (an|this) enumeration? Can this be modeled differently?

Level 4: Resource response with Reference:

> Please review the [Enumeration](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.


#### Missing enumeration

Level 1: Highlight problem

Level 2: Text response:

> How would you model this concept?

Level 3: Text response:

> Model this concept with an enumeration.

Level 4: Resource response with Reference:

> Please review the [Enumeration](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.


#### Extra enumeration

Level 1: Highlight solution

Level 2: Text response:

> Is this enumeration really necessary?

Level 3: Parametrized response:

> Remove the ${extraEnum} enumeration. It is not needed.

Level 4: Resource response with Reference:

> Please review the [Enumeration](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.


#### Bad enumeration name spelling

Level 1: Highlight solution

Level 2: Text response:

> Double check the name of this enumeration.

Level 3: Parametrized response:

> The ${wronglyNamedEnum} should be changed[ to ${correctEnumName}].

Level 4: Resource response with Reference:

> Please review the [Enumeration](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.


#### Missing enumeration item

Level 1: Highlight problem

Level 2: Text response:

> Is there anything missing here?

Level 3: Parametrized response:

> The ${enumName} enumeration is missing an item.

Level 4: Resource response with Reference:

> Please review the [Enumeration](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.


#### Extra enumeration item

Level 1: Highlight solution

Level 2: Text response:

> Should this really be here?

Level 3: Parametrized response:

> The ${enumName} enumeration has an extra item.

Level 4: Resource response with Reference:

> Please review the [Enumeration](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.


#### Bad enumeration item spelling

Level 1: Highlight solution

Level 2: Text response:

> Double check this enumeration item.

Level 3: Parametrized response:

> The ${wronglyNamedEnumItem} should be changed[ to ${correctEnumItemName}].

Level 4: Resource response with Reference:

> Please review the [Enumeration](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.


### Missing class

Level 1: Highlight problem

Level 2: Text response:

> Make sure you have modeled all the classes in the problem description.

Level 3: Highlight problem

Level 4: Parametrized response:

> Remember to add the ${className} class.


### Extra class

Level 1: Highlight solution

Level 2: Text response:

> Make sure you only model the concepts mentioned in the problem description.

Level 3: Text response:

> You have an extra class. Can you find it?

Level 4: Parametrized response:

> The ${className} class is not part of the problem domain, so please remove it.


> Remember that a domain model should not contain concepts from the user interfaces or databases, like Window, Database, etc.


### Using n-ary association instead of intermediate class

Level 1: Highlight solution

Level 2: Text response:

> Is this the best way to model this concept?

Level 3: Text response:

> Use an intermediate class instead of an n-ary association.



## Attribute mistakes

### Extra attribute mistakes

#### Plural attribute

Level 1: Highlight solution

Level 2: Text response:

> Double check this attribute name.

Level 3: Text response:

> This attribute should be singular.

Level 4: Resource response with Quiz:

> Pick the classes which are modeled correctly with Umple.

- [ ] class Student { courses; }
- [ ] class Folder { List<File> files; }
- [ ] class Restaurant { 1 -- * Employee; }


#### List attribute

Level 1: Highlight solution

Level 2: Text response:

> Is there a better way to model this concept?

Level 3: Text response:

> Remember that attributes are simple pieces of data.

Level 4: Parametrized response:

> ${includingClass.attributeName} should be modeled as an association instead.

Level 5: Resource response with Quiz:

> Pick the classes which are modeled correctly with Umple.

- [ ] class Student { courses; }
- [ ] class Folder { List<File> files; }
- [ ] class Restaurant { 1 -- * Employee; }


#### Extra attribute

Level 1: Highlight solution

Level 2: Text response:

> Do we really need to model this concept?

Level 3: Parametrized response:

> The ${redundantAttribute} in the ${className} class is not needed.


> The ${redundantAttribute} attribute in the ${className} class is not needed because it can be derived from ${derivationSources}.


> The ${redundantAttribute} attribute in the ${className} class is not needed because it is not part of the domain. You only need to model concepts related to the given problem description.


### Attribute name mistakes

#### Bad attribute name spelling

Level 1: Highlight solution

Level 2: Text response:

> Double check this attribute name.

Level 3: Parametrized response:

> ${wrongAttribute} is misspelled. [Use the same spelling as the problem description.]

Level 4: Resource response with Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and [Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.


#### Uppercase attribute name

Level 1: Highlight solution

Level 2: Text response:

> Remember that attributes are written in `lowerCamelCase`.

Text response:

> Can this attribute be renamed?

Level 3: Parametrized response:

> ${wrongAttribute} incorrectly starts with an Uppercase Letter. Attributes should start with a lowercase letter.

Level 4: Resource response with Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and [Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.


### Attribute in wrong class mistakes

#### Attribute misplaced

Level 1: Highlight solution

Level 2: Text response:

> Can you think of a better place for this attribute?

Level 3: Parametrized response:

> The ${misplacedAttribute} does not belong in the ${wrongClass} class. Where else can we place it?

Level 4: Resource response with Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and [Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.


#### Attribute duplicated

Level 1: Highlight solution

Level 2: Text response:

> Are you sure this is needed?

Level 3: Text response:

> Does this need to be included more than once?

Level 4: Parametrized response:

> The ${duplicateAttribute} already exists in ${correctClass}, so there is no need to include it again.

Level 5: Resource response with Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and [Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.


#### Attribute misplaced in generalization hierarchy

Level 1: Highlight solution

Level 2: Text response:

> Can you think of a better place for this?

Level 3: Parametrized response:

> The ${misplacedAttribute} belongs in ${correctClass}.

Level 4: Resource response with Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and [Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.


### Missing attribute

Level 1: Highlight solution

Level 2: Text response:

> Make sure to model all the attributes of this class.

Level 3: Parametrized response:

> A ${className} has a ${missingAttribute}.

Level 4: Resource response with Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and [Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.


### Wrong attribute type

Level 1: Highlight solution

Level 2: Text response:

> Double check the properties of this attribute.

Level 3: Parametrized response:

> Can you think of a better type for ${attribute}?

Level 4: Parametrized response:

> The ${className}.${attribute} is not of type ${attribute.type} because ${mistakeType.reason}.

Level 5: Resource response with Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and [Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.


### Missing attribute type

Level 1: Highlight solution

Level 2: Text response:

> This attribute is missing something.

Level 3: Text response:

> What is the type of this attribute?

Level 4: Resource response with Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and [Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.


### Attribute should be static

Level 1: Highlight solution

Level 2: Text response:

> Isn't there something special about this attribute?

Level 3: Parametrized response:

> ${includingClass.attributeName} should be static, because it applies to all instances of ${includingClass}.

Level 4: Resource response with Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and [Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.


### Attribute should not be static

Level 1: Highlight solution

Level 2: Text response:

> Double check the properties of this attribute.

Level 3: Parametrized response:

> ${includingClass.attributeName} should not be static, because it does not apply to all instances of ${includingClass}.

Level 4: Resource response with Reference:

> Please review the [Attribute](https://mycourses2.mcgill.ca/) and [Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.



## Relationship mistakes

### Association mistakes

#### Missing association mistakes

##### Missing association

Level 1: Highlight solution

Level 2: Text response:

> What is the relationship between these classes?

Level 3: Parametrized response:

> How would you capture that a ${classOne} has a ${classTwo}?

Level 4: Resource response with Reference:

> Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)


##### Missing aggregation

Level 1: Highlight solution

Level 2: Text response:

> What is the relationship between these classes?

Level 3: Parametrized response:

> How would you capture that a ${classOne} has a ${classTwo}?

Level 4: Resource response with Reference:

> Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)


##### Missing n-ary association

Level 1: Highlight solution

Level 2: Text response:

> What is the relationship between these classes?

Level 3: Parametrized response:

> How would you capture the relationship between ${classOne}, ${classTwo}, [and] ${classThree}[, [and] ${classFour}[, [and] ${classFive}]]?

Level 4: Resource response with Reference:

> Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)


##### Using attribute instead of association

Level 1: Highlight solution

Level 2: Text response:

> Remember that attributes are simple pieces of data.

Level 3: Parametrized response:

> ${includingClass.attributeName} should be its own class.

Level 4: Resource response with Quiz:

> Pick the classes which are modeled correctly.

- [ ] class Person { address; }
- [ ] class Person { * Person -- 1 Address; }; class Address {}
- [ ] class Loan { libraryPatron; }


#### Extra association mistakes

##### Representing an action with an association

Level 1: Highlight solution

Level 2: Text response:

> Is association the best way to model this concept?

Level 3: Parametrized response:

> ${actionName} should not be modeled as an association.


> ${actionName} does not need be modeled as part of a domain model.

Level 4: Resource response with Reference:

> Please review the [domain modeling lecture](https://mycourses2.mcgill.ca/) to know which concepts should be a part of a domain model.


##### Extra association

Level 1: Highlight solution

Level 2: Text response:

> Is this association really necessary?

Level 3: Parametrized response:

> The relationship between ${classOne} and ${classTwo} is not expressed in the problem description[, but there is a similar relationship with ${classThree} that is missing].


> The relationship between ${classOne} and ${classTwo} is redundant since we can access ${classTwo} from ${classOne} via ${classThree}.

Level 4: Resource response with Quiz:

> Find all the redundant associations in this class diagram (TODO).

> Write pseudocode to navigate between ClassOne and ClassTwo in this class diagram (TODO).


##### Extra aggregation

Level 1: Highlight solution

Level 2: Text response:

> Is this aggregation really necessary?

Level 3: Parametrized response:

> The relationship between ${classOne} and ${classTwo} is redundant.


##### Extra n-ary association

Level 1: Highlight solution

Level 2: Text response:

> Is this association really necessary?

Level 3: Text response:

> The relationship between the highlighted classes is redundant.


#### Association type mistakes

##### Using aggregation instead of association

Level 1: Highlight solution

Level 2: Text response:

> What is the relationship between these two concepts?

Level 3: Parametrized response:

> The relationship between ${containedClass} and ${containerClass} can be modeled with a simple association.

Level 4: Resource response with Reference:

> Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)


##### Using composition instead of association

Level 1: Highlight solution

Level 2: Text response:

> What is the relationship between these two concepts?

Level 3: Parametrized response:

> Why is ${incorrectlyContainedClass} contained in ${containerClass}?

Level 4: Resource response with Reference:

> Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)


##### Using directed relationship instead of undirected relationship

Level 1: Highlight solution

Level 2: Text response:

> Why is navigation restricted for this relationship?

Level 3: Parametrized response:

> The relationship between ${classOne} and ${classTwo} should be undirected.

Level 4: Resource response with Reference:

> Please review the _Directionality in Associations_ section of the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/)


##### Using undirected relationship instead of directed relationship

Level 1: Highlight solution

Level 2: Parametrized response:

> Does ${targetClass} need to know about ${sourceClass}?

Level 3: Parametrized response:

> The relationship between ${classOne} and ${classTwo} should be directed[ from ${classOne} to ${classTwo}].

Level 4: Resource response with Reference:

> Please review the _Directionality in Associations_ section of the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/)


##### Using composition instead of aggregation

Level 1: Highlight solution

Level 2: Text response:

> Is this the best relationship to use here?

Level 3: Parametrized response:

> The composition between ${containedClass} and ${containerClass} is better modeled using aggregation.

Level 4: Resource response with Reference:

> Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)


##### Using binary association instead of n-ary association

Level 1: Highlight solution

Level 2: Text response:

> Can you model this relationship more precisely?

Level 3: Parametrized response:

> Use a ${n}-ary association to represent this relationship.

Level 4: Resource response with Reference:

> Please review the [Association](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.


##### Using n-ary association instead of binary association

Level 1: Highlight solution

Level 2: Text response:

> Can you model this relationship more precisely?

Level 3: Text response:

> Use a binary association to represent this relationship.

Level 4: Resource response with Reference:

> Please review the [Association](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.


##### Using intermediate class instead of n-ary association

Level 1: Highlight solution

Level 2: Text response:

> Can you model this relationship in a different way?

Level 3: Parametrized response:

> Use a ${n}-ary association to represent this relationship.

Level 4: Resource response with Reference:

> Please review the [Association](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.


#### Association name mistakes

##### Missing association name

Level 1: Highlight solution

Level 2: Text response:

> Something is missing here.

Level 3: Text response:

> Can you give this association a name?

Level 4: Parametrized response:

> This association should be named ${associationName}.

Level 5: Resource response with Reference:

> Please review the [Association](https://mycourses2.mcgill.ca/) and [Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.


##### Bad association name spelling

Level 1: Highlight solution

Level 2: Text response:

> Double check this association name.

Level 3: Parametrized response:

> ${associationName} is misspelled.[ Use the same spelling as the problem description.]

Level 4: Resource response with Reference:

> Please review the [Association](https://mycourses2.mcgill.ca/) and [Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.


#### Multiplicity mistakes

##### Infinite recursive dependency

Level 1: Highlight solution

Level 2: Text response:

> Double check (this|these) relationship(s).

Level 3: Text response:

> The multiplicities for (this|these) relationship(s) are incorrect.

Level 4: Parametrized response:

> Does every ${class1} have exactly ${wrongMultiplicity} ${rolename}[s]?


> How many ${class1}'s does a ${class2} have?


> Double check the multiplicites between ${class1}, ${class2}, and ${class3}.

Level 5: Resource response with Quiz:

> Edit the class diagram to allow creating a `Foo`


##### Wrong multiplicity

Level 1: Highlight solution

Level 2: Text response:

> Double check this association.

Level 3: Text response:

> The multiplicit(y|ies) for this association (is|are) incorrect.

Level 4: Parametrized response:

> How many ${class1}'s does a ${class2} have? [And how many ${class2}'s does ${class1} have?]

Level 5: Resource response with Quiz:

> Pick the associations with correct multiplicities

- [ ] 1 EmployeeRole -- 1 Person;
- [ ] * Episode -- 1 TvSeries;
- [ ] * Bank -- 1 Client;


##### Missing multiplicity

Level 1: Highlight solution

Level 2: Text response:

> Double check this association.

Level 3: Text response:

> The multiplicit(y|ies) for this association (is|are) missing.

Level 4: Parametrized response:

> How many ${class1}'s does a ${class2} have? [And how many ${class2}'s does ${class1} have?]

Level 5: Resource response with Quiz:

> Pick the associations with correct multiplicities

- [ ] 1 EmployeeRole -- 1 Person;
- [ ] * Episode -- 1 TvSeries;
- [ ] * Bank -- 1 Client;


#### Role name mistakes

##### Missing role names

Level 1: Highlight solution

Level 2: Text response:

> Can you model this relationship more precisely?

Level 3: Text response:

> The multiplicities for this association are correct, but something else is missing!

Level 4: Resource response with Reference:

> Can you think of appropriate [role names](https://mycourses2.mcgill.ca/)
for this association? Role names help identify the role a class plays in a
relationship and can be important if there is more than one relationship
between the same two classes.

![Role name](images/role_name.png)



##### Role should be static

Level 1: Highlight solution

Level 2: Text response:

> Isn't there something special about this role name?

Level 3: Parametrized response:

> ${roleName} should be static, because it applies to all instances of the association between ${class1} and ${class2}.

Level 4: Resource response with Reference:

> Please review the [Association](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.


##### Role should not be static

Level 1: Highlight solution

Level 2: Text response:

> Isn't there something special about this role name?

Level 3: Parametrized response:

> ${roleName} should not be static, because it doesn't apply to all instances of the association between ${class1} and ${class2}.

Level 4: Resource response with Reference:

> Please review the [Association](https://mycourses2.mcgill.ca/) part of the Class Diagram lecture.


##### Bad role name spelling

Level 1: Highlight solution

Level 2: Text response:

> Double check this role name

Level 3: Parametrized response:

> ${roleName} is misspelled.[ Use the same spelling as the problem description.]

Level 4: Resource response with Reference:

> Please review the [Association](https://mycourses2.mcgill.ca/) and [Noun Analysis](https://mycourses2.mcgill.ca/) parts of the Class Diagram lecture.


##### Wrong role name but correct association

Level 1: Highlight solution

Level 2: Text response:

> Double check this role name.

Level 3: Parametrized response:

> The ${wrongRoleName} role name is not correct.

Level 4: Parametrized response:

> The ${wrongRoleName} role name should be changed to ${correctRoleName}.

Level 5: Resource response with Reference:

> Can you think of appropriate [role names](https://mycourses2.mcgill.ca/)
for this association? Role names help identify the role a class plays in a
relationship and can be important if there is more than one relationship
between the same two classes.

![Role name](images/role_name.png)



#### Association class mistakes

##### Missing association class

Level 1: Highlight solution

Level 2: Text response:

> Can you model this relationship more precisely?

Level 3: Parametrized response:

> Does it make sense to have multiple instances of the ${inBetweenClass} linking ${firstClass} and ${secondClass}?

Level 4: Parametrized response:

> Further details of the association between ${firstClass} and ${secondClass} should be modeled with an association class.

Level 5: Resource response with Reference:

> Association class

![Association class](images/association_class.png)


##### Extra association class

Level 1: Highlight solution

Level 2: Text response:

> Can you model this relationship in another way?

Level 3: Text response:

> Is using an association class the best way to model this?

Level 4: Parametrized response:

> Further details of the association between ${firstClass} and ${secondClass} should not be modeled with an association class.

Level 6: Resource response with Reference:

> Association class

![Association class](images/association_class.png)


##### Bad association class name spelling

Level 1: Highlight solution

Level 2: Text response:

> Double check this association class name.

Level 3: Parametrized response:

> The ${incorrectlySpelledClassName} class has a misspelled name.

Level 4: Parametrized response:

> The ${incorrectlySpelledClassName} class should be changed to ${correctClassName}.


##### Association class should be regular class

Level 1: Highlight solution

Level 2: Text response:

> Can you model this relationship in another way?

Level 3: Text response:

> Is using an association class the best way to model this?

Level 4: Parametrized response:

> The ${assocClass} class should be a regular class.

Level 5: Resource response with Reference:

> Association class

![Association class](images/association_class.png)


##### Regular class should be association class

Level 1: Highlight solution

Level 2: Text response:

> Can you model this relationship in another way?

Level 3: Text response:

> Is using a regular class the best way to model this?

Level 4: Parametrized response:

> The ${regularClass} class should be an association class.

Level 5: Resource response with Reference:

> Association class

![Association class](images/association_class.png)



### Composition mistakes

#### Missing composition

Level 1: Highlight solution

Level 2: Text response:

> What is the relationship between these classes?

Level 3: Parametrized response:

> How would you capture that a ${containerClass} contains a ${containedClass}?

Level 4: Resource response with Reference:

> Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)


#### Extra composition

Level 1: Highlight solution

Level 2: Text response:

> Is this composition really necessary?

Level 3: Parametrized response:

> The relationship between ${classOne} and ${classTwo} is not expressed in the problem description[, but there is a similar relationship with ${classThree} that is missing].

Level 4: Resource response with Reference:

> Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)


#### Using association instead of aggregation

Level 1: Highlight solution

Level 2: Text response:

> What is the relationship between these two concepts?

Level 3: Parametrized response:

> The relationship between ${containedClass} and ${containerClass} can be modeled more precisely than with a simple association.

Level 4: Resource response with Reference:

> Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)


#### Using association instead of composition

Level 1: Highlight solution

Level 2: Text response:

> What is the relationship between these two concepts?

Level 3: Parametrized response:

> The relationship between ${containedClass} and ${containerClass} is more than a simple association.

Level 4: Resource response with Reference:

> Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)


#### Using aggregation instead of composition

Level 1: Highlight solution

Level 2: Text response:

> Is this the best relationship to use here?

Level 3: Parametrized response:

> The relationship between ${containedClass} and ${containerClass} is stronger than an aggregation.

Level 4: Resource response with Reference:

> Please review the _Composition vs. Aggregation vs. Association_ section of 
the [UML Class Diagram lecture slides](https://mycourses2.mcgill.ca/) to 
better understand these relationships and where they are used.

![composition vs aggregation vs association](images/composition_aggregation_association.png)


#### Composed part contained in more than one parent

Level 1: Highlight solution

Level 2: Text response:

> Please double-check this relationship.

Level 3: Text response:

> Please review the model containment hierarchy.

Level 4: Parametrized response:

> ${incorrectlyContainedClass} cannot be contained in more than one class.

Level 5: Resource response with Example:

> Observe the following domain model. Every single class except the root class is contained in the 
root class, `PISystem`.

![PISystem](images/PISystem.png)

Level 6: Resource response with Quiz:

> Complete the containment tree for the following model.

![IRS](images/IRS.png)


#### Incomplete containment tree

Level 1: Highlight solution

Level 2: Text response:

> What is the relationship between these classes?

Level 3: Parametrized response:

> {containedClass} is a part of ${containerClass}, so how would you model this?

Level 4: Resource response with Example:

> Observe the following domain model. Every single class except the root class is contained in the 
root class, `PISystem`.

![PISystem](images/PISystem.png)

Level 5: Resource response with Quiz:

> Complete the containment tree for the following model.

![IRS](images/IRS.png)


### Generalization mistakes

#### Missing generalization

Level 1: Highlight solution

Level 2: Text response:

> What is the relationship between these classes?

Level 3: Parametrized response:

> A ${subclass} is a ${superclass}. How should we model this?

Level 4: Resource response with Quiz:

> Place the following classes in an inheritance hierarchy:

* `Vehicle`, `LandVehicle`, `AmphibiousVehicle`, `AirVehicle`, ...
* `BusVehicle`, `LuxuryBus`, `TourBus`, `BusRoute`, ...


#### Extra generalization

Level 1: Highlight solution

Level 2: Text response:

> Can you find a better way to express this relationship?

Text response:

> Is there a [direct ]relationship between these two classes?

Level 3: Parametrized response:

> When creating a generalization between ${wrongSubclass} and ${wrongSuperclass}, make sure to follow the [checks for proper generalization](https://mycourses2.mcgill.ca/).


> ${wrongSubclass} is not a [direct ]subclass of ${wrongSuperclass}.

Level 4: Resource response with Quiz:

> Place the following classes in an inheritance hierarchy:

* `Vehicle`, `LandVehicle`, `AmphibiousVehicle`, `AirVehicle`, ...
* `BusVehicle`, `LuxuryBus`, `TourBus`, `BusRoute`, ...

Level 5: Resource response with Quiz:

> Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material
and complete the following:

The five checks for generalization are:
* Obeys the ________. (isA rule)
* Subclass must retain its ________. (distinctiveness)
* All ________ must make sense in each subclass. (inherited features)
* Subclass differs from superclass and other subclasses in ________ or ________. (behavior, structure)
* Subclass must not be ________. (instance)


#### Generalization does not follow isA rule

Level 1: Highlight solution

Level 2: Text response:

> Can you find a better way to express this relationship?

Text response:

> Is there a [direct ]relationship between these two classes?

Level 3: Parametrized response:

> When creating a generalization between ${wrongSubclass} and ${wrongSuperclass}, make sure to follow the [checks for proper generalization](https://mycourses2.mcgill.ca/).


> ${wrongSubclass} is not a [direct ]subclass of ${wrongSuperclass}.

Level 4: Resource response with Quiz:

> Place the following classes in an inheritance hierarchy:

* `Vehicle`, `LandVehicle`, `AmphibiousVehicle`, `AirVehicle`, ...
* `BusVehicle`, `LuxuryBus`, `TourBus`, `BusRoute`, ...

Level 5: Resource response with Quiz:

> Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material
and complete the following:

The five checks for generalization are:
* Obeys the ________. (isA rule)
* Subclass must retain its ________. (distinctiveness)
* All ________ must make sense in each subclass. (inherited features)
* Subclass differs from superclass and other subclasses in ________ or ________. (behavior, structure)
* Subclass must not be ________. (instance)


#### Subclass not distinct across lifetime

Level 1: Highlight solution

Level 2: Text response:

> Can you find a better way to model this concept?

Level 3: Parametrized response:

> Is it possible for an instance of ${nondistinctSubclass} to turn into an instance of another subclass over its lifetime?

Level 4: Resource response with Quiz:

> Which classes are not subclasses of Account?
* `SavingsAccount`, `OverdrawnAccount`, `CheckingAccount`, `MortgageAccount`, `ClosedAccount`


#### Inherited feature does not make sense for subclass

Level 1: Highlight solution

Level 2: Text response:

> Does this belong here?

Level 3: Parametrized response:

> The ${featureName} feature of the ${superclass} class does not make sense for its ${subclass} subclass.

Level 4: Resource response with Quiz:

> Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material
and complete the following:

The five checks for generalization are:
* Obeys the ________. (isA rule)
* Subclass must retain its ________. (distinctiveness)
* All ________ must make sense in each subclass. (inherited features)
* Subclass differs from superclass and other subclasses in ________ or ________. (behavior, structure)
* Subclass must not be ________. (instance)


#### Subclass is an instance of superclass

Level 1: Highlight solution

Level 2: Text response:

> Can you find a better way to express this relationship?

Level 3: Text response:

> Remember the definition of the **'instance' rule**.[ Instances should not be modeled as subclasses].

Level 4: Resource response with Example:

> A CheckingAccount isA Account, but account1234 is **not** an Account according to the 'instance' rule.

Level 5: Resource response with Quiz:

> Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material
and complete the following:

The five checks for generalization are:
* Obeys the ________. (isA rule)
* Subclass must retain its ________. (distinctiveness)
* All ________ must make sense in each subclass. (inherited features)
* Subclass differs from superclass and other subclasses in ________ or ________. (behavior, structure)
* Subclass must not be ________. (instance)


#### Non-differentiated subclass

Level 1: Highlight solution

Level 2: Text response:

> Is it really necessary to model this as a subclass?

Level 3: Parametrized response:

> ${wrongSubclass} needs to be different from its superclass[ and its sibling subclasses] in terms of behavior or structure.

Level 4: Resource response with Quiz:

> Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material
and complete the following:

The five checks for generalization are:
* Obeys the ________. (isA rule)
* Subclass must retain its ________. (distinctiveness)
* All ________ must make sense in each subclass. (inherited features)
* Subclass differs from superclass and other subclasses in ________ or ________. (behavior, structure)
* Subclass must not be ________. (instance)


#### Wrong generalization direction

Level 1: Highlight solution

Level 2: Text response:

> Can you double check this relationship?

Level 3: Parametrized response:

> Is ${superclass} really a ${subclass}?[ It should be the other way around.]

Level 4: Resource response with Quiz:

> Place the following classes in an inheritance hierarchy:

* `Vehicle`, `LandVehicle`, `AmphibiousVehicle`, `AirVehicle`, ...
* `BusVehicle`, `LuxuryBus`, `TourBus`, `BusRoute`, ...

Level 5: Resource response with Quiz:

> Please review the [checks for proper generalization](https://mycourses2.mcgill.ca/) lecture material
and complete the following:

The five checks for generalization are:
* Obeys the ________. (isA rule)
* Subclass must retain its ________. (distinctiveness)
* All ________ must make sense in each subclass. (inherited features)
* Subclass differs from superclass and other subclasses in ________ or ________. (behavior, structure)
* Subclass must not be ________. (instance)


#### Wrong superclass

Level 1: Highlight solution

Level 2: Text response:

> Can you double check this relationship?

Level 3: Parametrized response:

> Can you (find|create) a (better|different) superclass for ${subclass}?[ Look at the problem description closely].

Level 4: Highlight problem

Level 5: Parametrized response:

> What is the inheritance hierarchy between ${hierarchy.classes}?

Level 6: Resource response with Quiz:

> Place the following classes in an inheritance hierarchy:

* `Vehicle`, `LandVehicle`, `AmphibiousVehicle`, `AirVehicle`, ...
* `BusVehicle`, `LuxuryBus`, `TourBus`, `BusRoute`, ...




## Design pattern mistakes

### Player-Role Pattern mistakes

#### Using different Player-Role pattern

##### Subclass should be full Player-Role pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> [Nice try, but] a ${firstSubclass} can also play the role of one of the other subclasses.

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


##### Subclass should be association Player-Role pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> [Nice try, but] a ${firstSubclass} can also play the role of one of the other subclasses and different features do not need to be captured for the subclasses.

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


##### Subclass should be enumeration Player-Role pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> [Nice try, but] a ${firstSubclass} does not need to play the role of one of the other subclasses and different features do not need to be captured for the subclasses.

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


##### Association should be full Player-Role pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> A ${firstRole} has different features from a ${secondRole}.

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


##### Association should be subclass Player-Role pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> A ${firstRole} has different features from a ${secondRole} and ${role} does not change its role over its lifetime.

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


##### Association should be enumeration Player-Role pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> Will the roles of ${firstRole} and ${secondRole} ever be occupied at the same time?

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


##### Enumeration should be full Player-Role pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> A ${firstRole} has different features from one of the other roles at the same time and different features need to be captured for the roles.

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


##### Enumeration should be subclass Player-Role pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> A ${firstRole} has different features from one of the other roles and this role never changes to another role.

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


##### Enumeration should be association Player-Role pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> Will the roles of ${firstRole} and ${secondRole} ever be occupied at the same time?

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


##### Full Player-Role pattern should be subclass

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> Can a ${firstRole} can also play the role of one of the other roles at different times or at the same time?

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


##### Full Player-Role pattern should be association

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> Do ${firstRole} and ${secondRole} need to have different features?

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


##### Full Player-Role pattern should be enumeration

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> Do ${firstRole} and ${secondRole} need to have different features and is it possible that more than one role is played at the same time?

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


#### Missing Player-Role pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> Modeling all the concepts in one ${playerClass} class will make it very complicated! Think about adding one or more classes to better represent the domain.


> [Nice try, but ]a ${firstSubclass} can also play the role of a ${secondSubclass}.

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


#### Incomplete Player-Role pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> Modeling all the concepts in one ${playerClass} class will make it very complicated! Think about adding one or more classes to better represent the domain.


> [Nice try, but ]a ${firstSubclass} can also play the role of a ${secondSubclass}.

Level 4: Resource response with Reference:

> The Player-Role Pattern can be used to capture the fact that an object may play different roles
in different contexts.

![Player-Role Pattern](images/player_role.png)

Level 5: Resource response with Quiz:

> Complete the following table:
> 
> Solution | Roles have different features | One role at a time | Different roles at a time | More than one role at the same time
> --- | --- | --- | --- | ---
> Enumeration         | [ ] | [ ] | [ ] | [ ]
> Subclasses          | [ ] | [ ] | [ ] | [ ]
> Associations        | [ ] | [ ] | [ ] | [ ]
> Player-Role Pattern | [ ] | [ ] | [ ] | [ ]


### Abstraction-Occurrence pattern mistakes

#### Missing Abstraction-Occurrence pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> Is there a way to remove the duplicate ${duplicateAttribute} attribute between ${class1} and ${class2}?


> ${wronglySubclass} should not be a subclass of ${superclass}. Is there a design pattern that can be used here?


> The ${commonAttribute} is common information for all instances of ${className}, but this is not enforced.

Level 4: Resource response with Reference:

> The [Abstraction-Occurrence Pattern](https://mycourses2.mcgill.ca/) can be used to 
represent a set of related objects that share common information but also differ
from each other in an important way.

![Abstraction-Occurrence Pattern](images/abstraction_occurrence.png)


#### Incomplete Abstraction-Occurrence pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Parametrized response:

> Is there a way to remove the duplicate ${duplicateAttribute} attribute between ${class1} and ${class2}?


> ${wronglySubclass} should not be a subclass of ${superclass}. Is there a design pattern that can be used here?


> The ${commonAttribute} is common information for all instances of ${className}, but this is not enforced.

Level 4: Resource response with Reference:

> The [Abstraction-Occurrence Pattern](https://mycourses2.mcgill.ca/) can be used to 
represent a set of related objects that share common information but also differ
from each other in an important way.

![Abstraction-Occurrence Pattern](images/abstraction_occurrence.png)


#### Generalization should be association in Abstraction-Occurrence pattern

Level 1: Highlight solution

Level 2: Text response:

> Think carefully about how to model the relationships between these concepts.

Level 3: Text response:

> Is generalization the correct way to model this use of the Abstraction-Occurrence pattern?

Level 4: Resource response with Reference:

> The [Abstraction-Occurrence Pattern](https://mycourses2.mcgill.ca/) can be used to 
represent a set of related objects that share common information but also differ
from each other in an important way.

![Abstraction-Occurrence Pattern](images/abstraction_occurrence.png)



