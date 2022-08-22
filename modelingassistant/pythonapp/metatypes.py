"""
Module to store information about TouchCORE CDM (class diagram) metatypes.

To simplify the Modeling Assistant implementation, a few additional metatype-like concepts are defined here, eg,
composition and plural classes.
"""
# pylint: disable=no-member

from dataclasses import dataclass

from pyecore.ecore import EClass

from constants import MANY
from classdiagram import (CDInt, CDString, Association, AssociationEnd, Attribute, Class, CDEnum, CDEnumLiteral,
                          NamedElement, ReferenceType)
from utils import ae


@dataclass
class Metatype:
    "Represents a metatype or list thereof."
    short_name: str
    long_name: str
    eClass: EClass | list[EClass] # pylint: disable=invalid-name
    example: NamedElement | list[NamedElement] = None  # used for tests


"""
Miminal Umple model used for examples:

// Airline system - sample UML class diagram in Umple
// From Book by Lethbridge and Laganiere, McGraw Hill 2004
// Object-Oriented Software Engineering: Practical Software Engineering using UML and Java
// See https://www.site.uottawa.ca/school/research/lloseng/

namespace Airline;

class AirlineSystem{ 1 airlineSystem <@>- * Person persons; }

class PersonRole { abstract; }
class PassengerRole {
  isA PersonRole;
  1 passenger -- * Booking bookings; // show aggregation in image
}
class EmployeeRole { isA PersonRole; }
class VisitorRole { isA PersonRole; }

class Person {
  String name;
  Integer idNumber;
  1 person -- 0..3 PersonRole roles;
}

class Booking {
  enum SeatType { FirstClass, Business, Economy }
  SeatType seatType;
}

class SeatType { // used only for visualizing enumeration
  abstract; // change to << enumeration >>
  SeatType FirstClass;
  SeatType Business;
  SeatType Economy;
}

namespace -;
// LAYOUT INFORMATION
class Person {
  position 460 121 152 75;
  position.association Person__PersonRole 0,18 110,19;
  position.association Person__PersonRole:roles 0,10 110,10;
  position.association Person:person__PersonRole:roles 0,37 110,10;
}
class PersonRole { position 251 168 109 41;}
class Booking { position 116 382 109 75; }
class PassengerRole {
  position 116 279 109 58;
  position.association Booking__PassengerRole 28,70 27,0;
}
class AirlineSystem {
  position 478 16 115.25 41;
  position.association AirlineSystem__Person 46,0 75,80;
  position.association AirlineSystem__Person:persons 0,10 153,2;
  position.association AirlineSystem:airlineSystem__Person:persons 43,41 61,0;
}
class EmployeeRole { position 291 278 116.812 41; }
class VisitorRole { position 450 279 109 41; }
class SeatType { position 344 347 160.031 108; }
"""

_cd_string = CDString()
_cd_int = CDInt()

_airlinesystem = Class(name="AirlineSystem")
_person = Class(name="Person", attributes=[
    _person_name := Attribute(name="name", type=_cd_string), _person_id := Attribute(name="idNumber", type=_cd_int)])
_personrole = Class(name="PersonRole")
_passengerrole = Class(name="PassengerRole", superTypes=[_personrole])
_employeerole = Class(name="EmployeeRole", superTypes=[_personrole])
_visitorrole = Class(name="VisitorRole", superTypes=[_personrole])
_booking = Class(name="Booking", attributes=[Attribute(name="seatType", type=(_seat_type := CDEnum(
    name="SeatType", literals=[_first_class := CDEnumLiteral(name="FirstClass"),
                               CDEnumLiteral(name="Business"), CDEnumLiteral(name="Economy")])))])

"""
Associations and association ends and how they connect to classes in the CDM metamodel can be unintuitive.
Using example from above:

class AirlineSystem{ 1 airlineSystem <@>- * Person persons; } // an AirlineSystem contains persons

There are five concepts defined as follows, according to the CDM metamodel:

  1. The AirlineSystem class
  2. The Person class
  3. The association between the AirlineSystem and the Person class. Conceptually, this is a composition
  4. The persons association end, which is contained in the AirlineSystem class and has Composition reference type.
     Note that this is the opposite of where the composition filled diamond is drawn in the diagram!
  5. The airlineSystem association end, which is contained in the Person class and has a Regular reference type.
"""
_airlinesystem_person = Association(name="AirlineSystem_Person", ends=[
    _person_airlinesystem := ae(_person, 1, 1, n="airlineSystem"),
    _airlinesystem_persons := ae(_airlinesystem, 0, MANY, ReferenceType.Composition, n="persons")])
_person_personrole = Association(name="Person_PersonRole", ends=[
    _personrole_person := ae(_personrole, 1, 1, n="person"), _person_roles := ae(_person, 0, 3, n="roles")])
_passengerrole_booking = Association(name="PassengerRole_Booking", ends=[
    ae(_booking, 1, 1, n="passenger"),
    _bookings_aggrend := ae(_passengerrole, 0, MANY, ReferenceType.Aggregation, "bookings")])

_role_types: list[EClass] = [AssociationEnd, CDEnumLiteral, Class]

CDM_METATYPES = {
    "aggr": (aggr := Metatype("aggr", "Aggregation", Association, _passengerrole_booking)),
    "assoc": (assoc := Metatype("assoc", "Association", Association, _person_personrole)),
    "assocend": (assocend := Metatype("assocend", "Association End", AssociationEnd, _personrole_person)),
    "assocend*": (assocends := Metatype("assocend*", "Association Ends", AssociationEnd, [
        _personrole_person, _airlinesystem_persons, _person_airlinesystem, _bookings_aggrend])),
    "attr": (attr := Metatype("attr", "Attribute", Attribute, _person_name)),
    "attr*": (attrs := Metatype("attr*", "Attributes", Attribute, [_person_name, _person_id])),
    "cls": (cls := Metatype("cls", "Class", Class, _person)),
    "cls*": (clss := Metatype("cls*", "Classes", Class, [_passengerrole, _employeerole, _visitorrole])),
    "compos": (compos := Metatype("compos", "Composition", Association, _airlinesystem_person)),
    "enum": (enum := Metatype("enum", "Enumeration", CDEnum, _seat_type)),
    "enumitem": (enumitem := Metatype("enumitem", "Enumeration Item", CDEnumLiteral, _first_class)),
    "enumitem*": (enumitems := Metatype("enumitem*", "Enumeration Items", CDEnumLiteral, _seat_type.literals)),
    "qualassoc": (qualassoc := Metatype("qualassoc", "Qualified Association", Association)),  # not yet supported
    "role": (role := Metatype("role", "Role", _role_types, _person_roles)),
    "role*": (roles := Metatype("role*", "Roles", _role_types, [_passengerrole, _employeerole, _visitorrole])),
    "rel": (rel := Metatype("rel", "Relationship", Association)),
}
