1. [Class mistakes](#class-mistakes)
   1. [Class name mistakes](#class-name-mistakes)
      1. [Plural class name](#plural-class-name)
      1. [Lowercase class name](#lowercase-class-name)
      1. [Software engineering term](#software-engineering-term)
      1. [Bad class name spelling](#bad-class-name-spelling)
      1. [Similar (yet incorrect) class name](#similar-class-name)
      1. [Wrong class name](#wrong-class-name)
   1. [Enumeration mistakes](#enumeration-mistakes)
      1. [Regular class should be enumeration](#regular-class-should-be-enumeration)
      1. [Enumeration should be regular class](#enumeration-should-be-regular-class)
      1. [Missing enumeration](#missing-enumeration)
      1. [Extra enumeration](#extra-enumeration)
      1. [Bad enumeration name spelling](#bad-enumeration-name-spelling)
      1. [Similar enumeration name](#similar-enumeration-name)
      1. [Missing enumeration item](#missing-enumeration-item)
      1. [Extra enumeration item](#extra-enumeration-item)
      1. [Bad enumeration item spelling](#bad-enumeration-item-spelling)
      1. [Similar enumeration item](#similar-enumeration-item)
   1. [Missing class](#missing-class)
   1. [Extra (redundant) class](#extra-redundant-class)
   1. [Using n-ary association instead of intermediate class](#using-n-ary-association-instead-of-intermediate-class)

1. [Attribute mistakes](#attribute-mistakes)
   1. [Extra (redundant) attribute mistakes](#extra-redundant-attribute-mistakes)
      1. [Plural attribute](#plural-attribute)
      1. [List attribute](#list-attribute)
      1. [Extra attribute](#extra-attribute)
   1. [Wrong attribute name mistakes](#wrong-attribute-name-mistakes)
      1. [Bad attribute name spelling](#bad-attribute-name-spelling)
      1. [Uppercase attribute name](#uppercase-attribute-name)
      1. [Similar (yet incorrect) attribute name](#similar-attribute-name)
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
         1. [Using an attribute instead of an association](#using-an-attribute-instead-of-an-association)
      1. [Extra (redundant) association mistakes](#extra-redundant-association-mistakes)
         1. [Representing an action with an association](#representing-an-action-with-an-association)
         1. [Composed part contained in more than one parent](#composed-part-contained-in-more-than-one-parent)
         1. [Other extra association](#other-extra-association)
         1. [Extra composition](#extra-composition)
         1. [Extra aggregation](#extra-aggregation)
         1. [Extra n-ary association](#extra-n-ary-association)
      1. [Wrong association type mistakes](#wrong-association-type-mistakes)
         1. [Using aggregation/composition instead of association](#using-aggregation-composition-instead-of-association)
         1. [Using directed association instead of undirected association](#using-directed-association-instead-of-undirected-association)
         1. [Using undirected association instead of directed association](#using-undirected-association-instead-of-directed-association)
         1. [Using composition instead of aggregation](#using-composition-instead-of-aggregation)
         1. [Using binary association instead of n-ary association](#using-binary-association-instead-of-n-ary-association)
         1. [Using n-ary association instead of binary association](#using-n-ary-association-instead-of-binary-association)
         1. [Using intermediate class instead of n-ary association](#using-intermediate-class-instead-of-n-ary-association)
   1. [Missing relationship](#missing-relationship)
      1. [Missing composition](#missing-composition)
   1. [Using wrong relationship type](#using-wrong-relationship-type)
      1. [Using association instead of aggregation/composition](#using-association-instead-of-aggregation-composition)
      1. [Using aggregation instead of composition](#using-aggregation-instead-of-composition)
   1. [Wrong association name](#wrong-association-name)
      1. [Missing association name when one was expected](#missing-association-name-when-one-was-expected)
      1. [Bad association name spelling](#bad-association-name-spelling)
      1. [Similar (yet incorrect) association name](#similar-association-name)
   1. [Wrong multiplicities](#wrong-multiplicities)
      1. [Infinite recursive dependency](#infinite-recursive-dependency)
      1. [Other wrong multiplicity](#other-wrong-multiplicity)
      1. [Missing multiplicity](#missing-multiplicity)
   1. [Wrong role names](#wrong-role-names)
      1. [Missing role names](#missing-role-names)
      1. [Role should be static](#role-should-be-static)
      1. [Role should not be static](#role-should-not-be-static)
      1. [Bad role name spelling](#bad-role-name-spelling)
      1. [Similar (yet incorrect) role name](#similar-role-name)
      1. [Other wrong role name](#other-wrong-role-name)
   1. [Wrong association class](#wrong-association-class)
      1. [Missing association class](#missing-association-class)
      1. [Extra (redundant) association class](#extra-redundant-association-class)
      1. [Bad association class name spelling](#bad-association-class-name-spelling)
      1. [Association class should be regular class](#association-class-should-be-regular-class)
      1. [Regular class should be association class](#regular-class-should-be-association-class)
      1. [Similar (yet incorrect) association class name](#similar-association-class-name)
   1. [Wrong generalization](#wrong-generalization)
      1. [Missing generalization](#missing-generalization)
      1. [Extra generalization](#extra-generalization)
      1. [Generalization inapplicable](#generalization-inapplicable)
      1. [Subclass not distinct across lifetime](#subclass-not-distinct-across-lifetime)
      1. [Inherited feature does not make sense for subclass](#inherited-feature-does-not-make-sense-for-subclass)
      1. [Subclass is an instance of superclass](#subclass-is-an-instance-of-superclass)
      1. [Non-differentiated subclass](#non-differentiated-subclass)
      1. [Wrong generalization direction](#wrong-generalization-direction)
      1. [Wrong superclass](#wrong-superclass)
   1. [Incomplete containment tree](#incomplete-containment-tree)

1. [Misuse of design patterns](#misuse-of-design-patterns)
   1. [Wrong Player-Role Pattern](#wrong-player-role-pattern)
      1. [Using different Player-Role pattern](#using-different-player-role-pattern)
         1. [Subclass should be full Player-Role pattern](#subclass-should-be-full-player-role-pattern)
         1. [Subclass should be association Player-Role pattern](#subclass-should-be-association-player-role-pattern)
         1. [Subclass should be enum Player-Role pattern](#subclass-should-be-enum-player-role-pattern)
         1. [Association should be full Player-Role pattern](#association-should-be-full-player-role-pattern)
         1. [Association should be subclass Player-Role pattern](#association-should-be-subclass-player-role-pattern)
         1. [Association should be enum Player-Role pattern](#association-should-be-enum-player-role-pattern)
         1. [Enum should be full Player-Role pattern](#enum-should-be-full-player-role-pattern)
         1. [Enum should be subclass Player-Role pattern](#enum-should-be-subclass-player-role-pattern)
         1. [Enum should be association Player-Role pattern](#enum-should-be-association-player-role-pattern)
         1. [Full Player-Role pattern should be subclass](#full-player-role-pattern-should-be-subclass)
         1. [Full Player-Role pattern should be association](#full-player-role-pattern-should-be-association)
         1. [Full Player-Role pattern should be enum](#full-player-role-pattern-should-be-enum)
      1. [Missing Player-Role pattern](#missing-player-role-pattern)
      1. [Incomplete Player-Role pattern](#incomplete-player-role-pattern)
   1. [Wrong Abstraction-Occurrence pattern](#wrong-abstraction-occurrence-pattern)
      1. [Missing Abstraction-Occurrence pattern](#missing-abstraction-occurrence-pattern)
      1. [Incomplete Abstraction-Occurrence pattern](#incomplete-abstraction-occurrence-pattern)

## Class mistakes

### Class name mistakes

#### Plural class name


#### Lowercase class name


#### Software engineering term


#### Bad class name spelling


#### Similar class name


#### Wrong class name


### Enumeration mistakes

#### Regular class should be enumeration


#### Enumeration should be regular class


#### Missing enumeration


#### Extra enumeration


#### Bad enumeration name spelling


#### Similar enumeration name


#### Missing enumeration item


#### Extra enumeration item


#### Bad enumeration item spelling


#### Similar enumeration item


### Missing class


### Extra redundant class


### Using n-ary association instead of intermediate class



## Attribute mistakes

### Extra redundant attribute mistakes

#### Plural attribute


#### List attribute


#### Extra attribute


### Wrong attribute name mistakes

#### Bad attribute name spelling


#### Uppercase attribute name


#### Similar attribute name


### Attribute in wrong class mistakes

#### Attribute misplaced


#### Attribute duplicated


#### Attribute misplaced in generalization hierarchy


### Missing attribute


### Wrong attribute type


### Missing attribute type


### Attribute should be static


### Attribute should not be static



## Relationship mistakes

### Association mistakes

#### Missing association mistakes

##### Missing association


##### Missing aggregation


##### Missing n-ary association


##### Using an attribute instead of an association


#### Extra redundant association mistakes

##### Representing an action with an association


##### Composed part contained in more than one parent


##### Other extra association


##### Extra composition


##### Extra aggregation


##### Extra n-ary association


#### Wrong association type mistakes

##### Using aggregation/composition instead of association


##### Using directed association instead of undirected association


##### Using undirected association instead of directed association


##### Using composition instead of aggregation


##### Using binary association instead of n-ary association


##### Using n-ary association instead of binary association


##### Using intermediate class instead of n-ary association



### Missing relationship

#### Missing composition


### Using wrong relationship type

#### Using association instead of aggregation/composition


#### Using aggregation instead of composition


### Wrong association name

#### Missing association name when one was expected


#### Bad association name spelling


#### Similar association name


### Wrong multiplicities

#### Infinite recursive dependency


#### Other wrong multiplicity


#### Missing multiplicity


### Wrong role names

#### Missing role names


#### Role should be static


#### Role should not be static


#### Bad role name spelling


#### Similar role name


#### Other wrong role name


### Wrong association class

#### Missing association class


#### Extra redundant association class


#### Bad association class name spelling


#### Association class should be regular class


#### Regular class should be association class


#### Similar association class name


### Wrong generalization

#### Missing generalization


#### Extra generalization


#### Generalization inapplicable


#### Subclass not distinct across lifetime


#### Inherited feature does not make sense for subclass


#### Subclass is an instance of superclass


#### Non-differentiated subclass


#### Wrong generalization direction


#### Wrong superclass


### Incomplete containment tree



## Misuse of design patterns

### Wrong Player-Role Pattern

#### Using different Player-Role pattern

##### Subclass should be full Player-Role pattern


##### Subclass should be association Player-Role pattern


##### Subclass should be enum Player-Role pattern


##### Association should be full Player-Role pattern


##### Association should be subclass Player-Role pattern


##### Association should be enum Player-Role pattern


##### Enum should be full Player-Role pattern


##### Enum should be subclass Player-Role pattern


##### Enum should be association Player-Role pattern


##### Full Player-Role pattern should be subclass


##### Full Player-Role pattern should be association


##### Full Player-Role pattern should be enum


#### Missing Player-Role pattern


#### Incomplete Player-Role pattern


### Wrong Abstraction-Occurrence pattern

#### Missing Abstraction-Occurrence pattern


#### Incomplete Abstraction-Occurrence pattern



