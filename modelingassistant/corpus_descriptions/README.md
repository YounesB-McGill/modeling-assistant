# Learning Corpus Content Outline

_**About this page:** This page is meant to be a human readable document
that describes some of the content of the learning corpus. This material
will be included in a more machine readable format later. The mistake 
types are taken from our paper [Towards a Better Understanding of Interactions with a Domain Modeling Assistant](https://doi.org/10.1145/3417990.3418742)._

## Table of Contents

1. [Wrong class](#wrong-class)
   1. [Missing class](#missing-class)
   1. [Extra (redundant) class](#extra-class)
   1. [Wrong class name (using plural, lowercase, or software engineering term)](#wrong-class-name)

1. [Wrong relationships](#wrong-relationships)
   1. [Using an attribute instead of an association](#using-an-attribute-instead-of-an-association)
   1. [Incomplete containment tree](#incomplete-containment-tree)
   1. [Using an association instead of an aggregation/composition or vice versa](#using-an-association-instead-of-an-aggregationcomposition-or-vice-versa)
   1. [Missing role names](#missing-role-names)
   1. [Wrong association class](#wrong-association-class)
   1. [Inapplicable generalization](#inapplicable-generalization)
   1. [Non-differentiated subclass](#non-differentiated-subclass)

1. [Modeling antipatterns or misuse of design patterns](#modeling-antipatterns-or-misuse-of-design-patterns)
   1. [Misuse of Player-Role Pattern](#misuse-of-player-role-Pattern)


_More to come..._


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

Level 1: Highlight solution

Level 2: Text response:

> Remember that class names must start with a Capital Letter.

> Remember that class names should be singular.

> Remember that a domain model should not contain software engineering terms.

Level 3: Parameterized Response

> ${className} should be ${pascalCase(className)}, with a Capital Letter.

> ${className} should be ${singular(className)}, using the singular.

> ${className} is a software engineering term, which does not belong in a domain model.

Level 4: Resource Response with Example:

> Please note these examples of correct vs incorrect class naming:
> :x: Examples to avoid | :heavy_check_mark: Good class names
> --- | ---
> pilot | Pilot
> Airplanes | Airplane 
> AirlineData | Airline

___

## Wrong relationships

### Using an attribute instead of an association

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


### Incomplete containment tree



### Using an association instead of an aggregation/composition or vice versa



### Missing role names


### Wrong association class


### Inapplicable generalization


### Non-differentiated subclass


___

## Modeling antipatterns or misuse of design patterns

### Misuse of Player-Role Pattern



_More to come..._
