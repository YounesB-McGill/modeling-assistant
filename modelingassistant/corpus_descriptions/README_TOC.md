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
   1. [Extra attribute mistakes](#extra-attribute-mistakes)
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
         1. [Using attribute instead of association](#using-attribute-instead-of-association)
      1. [Extra association mistakes](#extra-association-mistakes)
         1. [Representing an action with an association](#representing-an-action-with-an-association)
         1. [Composed part contained in more than one parent](#composed-part-contained-in-more-than-one-parent)
         1. [Extra association](#extra-association)
         1. [Extra aggregation](#extra-aggregation)
         1. [Extra n-ary association](#extra-n-ary-association)
      1. [Association type mistakes](#association-type-mistakes)
         1. [Using aggregation/composition instead of association](#using-aggregation-composition-instead-of-association)
         1. [Using directed association instead of undirected association](#using-directed-association-instead-of-undirected-association)
         1. [Using undirected association instead of directed association](#using-undirected-association-instead-of-directed-association)
         1. [Using composition instead of aggregation](#using-composition-instead-of-aggregation)
         1. [Using binary association instead of n-ary association](#using-binary-association-instead-of-n-ary-association)
         1. [Using n-ary association instead of binary association](#using-n-ary-association-instead-of-binary-association)
         1. [Using intermediate class instead of n-ary association](#using-intermediate-class-instead-of-n-ary-association)
      1. [Association name mistakes](#association-name-mistakes)
         1. [Missing association name when one was expected](#missing-association-name-when-one-was-expected)
         1. [Bad association name spelling](#bad-association-name-spelling)
         1. [Similar (yet incorrect) association name](#similar-association-name)
      1. [Multiplicity mistakes](#multiplicity-mistakes)
         1. [Infinite recursive dependency](#infinite-recursive-dependency)
         1. [Wrong multiplicity](#wrong-multiplicity)
         1. [Missing multiplicity](#missing-multiplicity)
      1. [Role name mistakes](#role-name-mistakes)
         1. [Missing role names](#missing-role-names)
         1. [Role should be static](#role-should-be-static)
         1. [Role should not be static](#role-should-not-be-static)
         1. [Bad role name spelling](#bad-role-name-spelling)
         1. [Similar (yet incorrect) role name](#similar-role-name)
         1. [Wrong role name but correct association](#wrong-role-name-but-correct-association)
      1. [Association class mistakes](#association-class-mistakes)
         1. [Missing association class](#missing-association-class)
         1. [Extra association class](#extra-association-class)
         1. [Bad association class name spelling](#bad-association-class-name-spelling)
         1. [Association class should be regular class](#association-class-should-be-regular-class)
         1. [Regular class should be association class](#regular-class-should-be-association-class)
         1. [Similar (yet incorrect) association class name](#similar-association-class-name)
   1. [Composition mistakes](#composition-mistakes)
      1. [Missing composition](#missing-composition)
      1. [Extra composition](#extra-composition)
      1. [Using association instead of aggregation/composition](#using-association-instead-of-aggregation-composition)
      1. [Using aggregation instead of composition](#using-aggregation-instead-of-composition)
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
         1. [Association should be enum Player-Role pattern](#association-should-be-enum-player-role-pattern)
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

### Extra attribute mistakes

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


##### Using attribute instead of association


#### Extra association mistakes

##### Representing an action with an association


##### Composed part contained in more than one parent


##### Extra association


##### Extra aggregation


##### Extra n-ary association


#### Association type mistakes

##### Using aggregation/composition instead of association


##### Using directed association instead of undirected association


##### Using undirected association instead of directed association


##### Using composition instead of aggregation


##### Using binary association instead of n-ary association


##### Using n-ary association instead of binary association


##### Using intermediate class instead of n-ary association


#### Association name mistakes

##### Missing association name when one was expected


##### Bad association name spelling


##### Similar association name


#### Multiplicity mistakes

##### Infinite recursive dependency


##### Wrong multiplicity


##### Missing multiplicity


#### Role name mistakes

##### Missing role names


##### Role should be static


##### Role should not be static


##### Bad role name spelling


##### Similar role name


##### Wrong role name but correct association


#### Association class mistakes

##### Missing association class


##### Extra association class


##### Bad association class name spelling


##### Association class should be regular class


##### Regular class should be association class


##### Similar association class name



### Composition mistakes

#### Missing composition


#### Extra composition


#### Using association instead of aggregation/composition


#### Using aggregation instead of composition


#### Incomplete containment tree


### Generalization mistakes

#### Missing generalization


#### Extra generalization


#### Generalization does not follow isA rule


#### Subclass not distinct across lifetime


#### Inherited feature does not make sense for subclass


#### Subclass is an instance of superclass


#### Non-differentiated subclass


#### Wrong generalization direction


#### Wrong superclass




## Design pattern mistakes

### Player-Role Pattern mistakes

#### Using different Player-Role pattern

##### Subclass should be full Player-Role pattern


##### Subclass should be association Player-Role pattern


##### Subclass should be enumeration Player-Role pattern


##### Association should be full Player-Role pattern


##### Association should be subclass Player-Role pattern


##### Association should be enum Player-Role pattern


##### Enumeration should be full Player-Role pattern


##### Enumeration should be subclass Player-Role pattern


##### Enumeration should be association Player-Role pattern


##### Full Player-Role pattern should be subclass


##### Full Player-Role pattern should be association


##### Full Player-Role pattern should be enumeration


#### Missing Player-Role pattern


#### Incomplete Player-Role pattern


### Abstraction-Occurrence pattern mistakes

#### Missing Abstraction-Occurrence pattern


#### Incomplete Abstraction-Occurrence pattern



