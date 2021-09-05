1. [Wrong class](#wrong-class)
   1. [Wrong class name](#wrong-class-name)
      1. [Plural class name](#plural-class-name)
      1. [Lowercase class name](#lowercase-class-name)
      1. [Software engineering term](#software-engineering-term)
      1. [Bad class name spelling](#bad-class-name-spelling)
      1. [Similar (yet incorrect) class name](#similar-class-name)
      1. [Incorrect class name but correct attribute/relationship](#incorrect-class-name-but-correct-attribute-relationship)
   1. [Wrong enumeration](#wrong-enumeration)
      1. [Regular class should be enum](#regular-class-should-be-enum)
      1. [Enum should be regular class](#enum-should-be-regular-class)
      1. [Missing enum](#missing-enum)
      1. [Extra enum](#extra-enum)
      1. [Bad enum name spelling](#bad-enum-name-spelling)
      1. [Similar enum name](#similar-enum-name)
      1. [Missing enum item](#missing-enum-item)
      1. [Extra enum item](#extra-enum-item)
      1. [Bad enum item spelling](#bad-enum-item-spelling)
      1. [Similar enum item](#similar-enum-item)
   1. [Missing class](#missing-class)
   1. [Extra (redundant) class](#extra-redundant-class)

1. [Wrong attribute](#wrong-attribute)
   1. [Extra (redundant) attribute](#extra-redundant-attribute)
      1. [Plural attribute](#plural-attribute)
      1. [List attribute](#list-attribute)
      1. [Other extra attribute](#other-extra-attribute)
   1. [Wrong attribute name](#wrong-attribute-name)
      1. [Bad attribute name spelling](#bad-attribute-name-spelling)
      1. [Uppercase attribute name](#uppercase-attribute-name)
      1. [Similar (yet incorrect) attribute name](#similar-attribute-name)
   1. [Attribute in wrong class](#attribute-in-wrong-class)
      1. [Attribute misplaced](#attribute-misplaced)
      1. [Attribute duplicated](#attribute-duplicated)
      1. [Attribute misplaced in generalization hierarchy](#attribute-misplaced-in-generalization-hierarchy)
   1. [Missing attribute](#missing-attribute)
   1. [Wrong attribute type](#wrong-attribute-type)
   1. [Missing attribute type](#missing-attribute-type)
   1. [Attribute should be static](#attribute-should-be-static)
   1. [Attribute should not be static](#attribute-should-not-be-static)

1. [Wrong relationship](#wrong-relationship)
   1. [Missing relationship](#missing-relationship)
      1. [Missing association](#missing-association)
      1. [Missing composition](#missing-composition)
      1. [Missing aggregation](#missing-aggregation)
      1. [Missing n-ary association](#missing-n-ary-association)
      1. [Using an attribute instead of an association](#using-an-attribute-instead-of-an-association)
   1. [Extra (redundant) association](#extra-redundant-association)
      1. [Representing an action with an association](#representing-an-action-with-an-association)
      1. [Composed part contained in more than one parent](#composed-part-contained-in-more-than-one-parent)
      1. [Other extra association](#other-extra-association)
      1. [Extra composition](#extra-composition)
      1. [Extra aggregation](#extra-aggregation)
      1. [Extra n-ary association](#extra-n-ary-association)
   1. [Using wrong relationship type](#using-wrong-relationship-type)
      1. [Using association instead of aggregation/composition](#using-association-instead-of-aggregation-composition)
      1. [Using aggregation/composition instead of association](#using-aggregation-composition-instead-of-association)
      1. [Using directed association instead of undirected](#using-directed-association-instead-of-undirected)
      1. [Using undirected association instead of directed](#using-undirected-association-instead-of-directed)
      1. [Using aggregation instead of composition](#using-aggregation-instead-of-composition)
      1. [Using composition instead of aggregation](#using-composition-instead-of-aggregation)
      1. [Using binary association instead of nary association](#using-binary-association-instead-of-nary-association)
      1. [Using nary association instead of binary association](#using-nary-association-instead-of-binary-association)
      1. [Using intermediate class instead of nary association](#using-intermediate-class-instead-of-nary-association)
      1. [Using nary association instead of intermediate class](#using-nary-association-instead-of-intermediate-class)
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

## Wrong class

### Wrong class name

#### Plural class name


#### Lowercase class name


#### Software engineering term


#### Bad class name spelling


#### Similar class name


#### Incorrect class name but correct attribute/relationship


### Wrong enumeration

#### Regular class should be enum


#### Enum should be regular class


#### Missing enum


#### Extra enum


#### Bad enum name spelling


#### Similar enum name


#### Missing enum item


#### Extra enum item


#### Bad enum item spelling


#### Similar enum item


### Missing class


### Extra redundant class



## Wrong attribute

### Extra redundant attribute

#### Plural attribute


#### List attribute


#### Other extra attribute


### Wrong attribute name

#### Bad attribute name spelling


#### Uppercase attribute name


#### Similar attribute name


### Attribute in wrong class

#### Attribute misplaced


#### Attribute duplicated


#### Attribute misplaced in generalization hierarchy


### Missing attribute


### Wrong attribute type


### Missing attribute type


### Attribute should be static


### Attribute should not be static



## Wrong relationship

### Missing relationship

#### Missing association


#### Missing composition


#### Missing aggregation


#### Missing n-ary association


#### Using an attribute instead of an association


### Extra redundant association

#### Representing an action with an association


#### Composed part contained in more than one parent


#### Other extra association


#### Extra composition


#### Extra aggregation


#### Extra n-ary association


### Using wrong relationship type

#### Using association instead of aggregation/composition


#### Using aggregation/composition instead of association


#### Using directed association instead of undirected


#### Using undirected association instead of directed


#### Using aggregation instead of composition


#### Using composition instead of aggregation


#### Using binary association instead of nary association


#### Using nary association instead of binary association


#### Using intermediate class instead of nary association


#### Using nary association instead of intermediate class


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



