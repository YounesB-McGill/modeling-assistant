"""
Module to store information about TouchCORE CDM (class diagram) metatypes.
"""
# pylint: disable=no-member

from dataclasses import dataclass

from pyecore.ecore import EClass

from classdiagram import (CDInt, CDString, Association, AssociationEnd, Attribute, Class, CDEnum,
                          CDEnumLiteral, Classifier, NamedElement, ReferenceType)


@dataclass
class CdmMetatype:
    "Represents a CDM metatype or list thereof."
    short_name: str
    long_name: str
    eClass: EClass  # pylint: disable=invalid-name
    example: NamedElement | list[NamedElement] = None  # used for tests


def ae(cls_: Classifier, lb: int = 1, ub: int = 1, ref_type: ReferenceType = ReferenceType.Regular, n: str = ""
       ) -> AssociationEnd:
    "Shorthand to create a CDM association end."
    return AssociationEnd(classifier=cls_, lowerBound=lb, upperBound=ub, referenceType=ref_type, name=n)


"""
Miminal Umple model used for examples:

// Airline system - sample UML class diagram in Umple
// From Book by Lethbridge and Laganiere, McGraw Hill 2004
// Object-Oriented Software Engineering: Practical Software Engineering using UML and Java
// See https://www.site.uottawa.ca/school/research/lloseng/

namespace Airline;

class AirlineSystem{ 1 <@>- * Person persons; }

class PersonRole {}
class PassengerRole {
  isA PersonRole;
  1 passenger -- * Booking bookings; // aggregation
}
class EmployeeRole { isA PersonRole; }
class VisitorRole { isA PersonRole; }

class Person {
  String name;
  Integer idNumber;
  1 -- 0..3 PersonRole roles;
}

class Booking {
  enum SeatType { FirstClass, Business, Economy }
  SeatType seatType;
}

//$?[End_of_model]$?
namespace -;
// LAYOUT INFORMATION
class Person {
  position 426 126 152 75;
  position.association Person__PersonRole 0,18 110,19;
  position.association Person__PersonRole:roles 0,10 110,10;
}
class PersonRole { position 251 168 109 41;}
class Booking { position 116 382 109 75; }
class PassengerRole {
  position 116 279 109 58;
  position.association Booking__PassengerRole 28,70 27,0;
}
class AirlineSystem {
  position 628 26 115.25 41;
  position.association AirlineSystem__Person 46,0 75,80;
  position.association AirlineSystem__Person:persons 0,10 153,2;
}
class EmployeeRole { position 291 278 116.812 41; }
class VisitorRole { position 450 279 109 41; }
"""

_MANY = -1
_cd_string = CDString()
_cd_int = CDInt()

_airline_system = Class(name="AirlineSystem")
_person = Class(name="Person", attributes=[
    _person_name := Attribute(name="name", type=_cd_string), _person_id := Attribute(name="idNumber", type=_cd_int)])
_person_role = Class(name="PersonRole")
_passenger_role = Class(name="PassengerRole", superTypes=[_person_role])
_employee_role = Class(name="EmployeeRole", superTypes=[_person_role])
_visitor_role = Class(name="VisitorRole", superTypes=[_person_role])
_booking = Class(name="Booking", attributes=[Attribute(name="seatType", type=(_seat_type := CDEnum(
    name="SeatType", literals=[_first_class := CDEnumLiteral(name="FirstClass"),
                               CDEnumLiteral(name="Business"), CDEnumLiteral(name="Economy")])))])

_airline_system_persons = Association(ends=[
    _airline_system_composend := ae(_airline_system, 1, 1, ReferenceType.Composition),
    ae(_person, 0, _MANY, n="persons")])
_person_roles = Association(ends=[ae(_person, 1, 1), _roles := ae(_person_role, 0, 3, n="roles")])
_passengerroles_bookings = Association(ends=[
    _passenger_aggrend := ae(_passenger_role, 1, 1, ReferenceType.Aggregation, "passenger"),
    ae(_booking, 0, _MANY, n="bookings")])


CDM_METATYPES = {
    "aggr": (aggr := CdmMetatype("aggr", "Aggregation", Association, _passengerroles_bookings)),
    "assoc": (assoc := CdmMetatype("assoc", "Association", Association, _person_roles)),
    "assocend": (assocend := CdmMetatype("assocend", "Association End", AssociationEnd, _roles)),
    "assocend*": (assocends := CdmMetatype("assocend*", "Association Ends", AssociationEnd,
                                           [_roles, _airline_system_composend, _passenger_aggrend])),
    "attr": (attr := CdmMetatype("attr", "Attribute", Attribute, _person_name)),
    "attr*": (attrs := CdmMetatype("attr*", "Attributes", Attribute, [_person_name, _person_id])),
    "cls": (cls := CdmMetatype("cls", "Class", Class, _person)),
    "cls*": (clss := CdmMetatype("cls*", "Classes", Class, [_passenger_role, _employee_role, _visitor_role])),
    "compos": (compos := CdmMetatype("compos", "Composition", Association, _airline_system_persons)),
    "enum": (enum := CdmMetatype("enum", "Enumeration", CDEnum, _seat_type)),
    "enumitem": (enumitem := CdmMetatype("enumitem", "Enumeration Item", CDEnumLiteral, _first_class)),
    "enumitem*": (enumitems := CdmMetatype("enumitem*", "Enumeration Items", CDEnumLiteral, _seat_type.literals)),
    "qualassoc": (qualassoc := CdmMetatype("qualassoc", "Qualified Association", Association)),  # not yet supported
    "rel": (rel := CdmMetatype("rel", "Relationship", Association)),  # deprecated
}
