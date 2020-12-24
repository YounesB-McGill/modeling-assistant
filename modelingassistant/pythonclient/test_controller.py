#!/usr/bin/env python3

from classdiagram.classdiagram import (ClassDiagram, Class, Attribute, ImplementationClass, CDInt, CDString,
    AssociationEnd, Association)
from modelingassistant.modelingassistant import ModelingAssistant, Solution
from pyecore.ecore import EInteger, EString


def test_pytest_is_working():
    assert True


def test_creating_empty_solution():
    modeling_assistant = ModelingAssistant()
    solution = Solution()
    class_diagram = ClassDiagram(name="Student1_solution")
    solution.classDiagram = class_diagram
    modeling_assistant.solutions.append(solution)
    assert "Student1_solution" == modeling_assistant.solutions[0].classDiagram.name


def test_creating_one_class_solution():
    """
    Test that a solution with one class can be created (Umple syntax):

    class Car {
      int id;
      String make; // eg, BMW, Honda
    }
    """
    modeling_assistant = ModelingAssistant()
    solution = Solution()
    class_diagram = ClassDiagram(name="Student1_solution")
    solution.classDiagram = class_diagram
    modeling_assistant.solutions.append(solution)
    
    cd_int = CDInt()
    cd_string = CDString()

    car_class = Class(name="Car", attributes=[
        Attribute(name="id", type=cd_int),
        Attribute(name="make", type=cd_string)
    ])
    class_diagram.classes.append(car_class)

    assert "Student1_solution" == modeling_assistant.solutions[0].classDiagram.name
    assert "Car" == class_diagram.classes[0].name
    assert "id" == class_diagram.classes[0].attributes[0].name
    assert cd_int == class_diagram.classes[0].attributes[0].type
    assert "make" == class_diagram.classes[0].attributes[1].name
    assert cd_string == class_diagram.classes[0].attributes[1].type


def test_creating_two_class_solution_with_association():
    """
    Test that a solution with these two classes can be created:

    class Car {} // see above
    class Driver {
      String name;
      * -- 1 Car primaryVehicle;
    }
    """
    modeling_assistant = ModelingAssistant()
    solution = Solution()
    class_diagram = ClassDiagram(name="Student1_solution")
    solution.classDiagram = class_diagram
    modeling_assistant.solutions.append(solution)
    
    cd_int = CDInt()
    cd_string = CDString()

    car_class = Class(name="Car", attributes=[
        Attribute(name="id", type=cd_int),
        Attribute(name="make", type=cd_string)
    ])
    driver_class = Class(name="Driver", attributes=[Attribute(name="name", type=cd_string)])

    car_driver_association_end = AssociationEnd(classifier=car_class, navigable=True, lowerBound=1, upperBound=1)
    driver_car_association_end = AssociationEnd(classifier=driver_class, navigable=True, lowerBound=0, upperBound=-1)
    car_class.associationEnds.append(car_driver_association_end)
    driver_class.associationEnds.append(driver_car_association_end)
    car_driver_association = Association(ends=[car_driver_association_end, driver_car_association_end])
    car_driver_association_end.assoc = car_driver_association
    driver_car_association_end.assoc = car_driver_association

    class_diagram.classes.extend([car_class, driver_class])

    assert "Student1_solution" == modeling_assistant.solutions[0].classDiagram.name
    assert class_diagram == modeling_assistant.solutions[0].classDiagram
    
    assert car_class == class_diagram.classes[0]
    assert "Car" == car_class.name
    assert "id" == car_class.attributes[0].name
    assert cd_int == car_class.attributes[0].type
    assert "make" == car_class.attributes[1].name
    assert cd_string == car_class.attributes[1].type

    assert driver_class == class_diagram.classes[1]
    assert "Driver" == driver_class.name
    assert "name" == driver_class.attributes[0].name
    assert cd_string == driver_class.attributes[0].type

    assert car_driver_association == car_class.associationEnds[0].assoc
    assert car_driver_association == driver_class.associationEnds[0].assoc
    assert car_driver_association_end == car_driver_association.ends[0]
    assert driver_car_association_end == car_driver_association.ends[1]
    assert car_class == car_driver_association_end.classifier
    assert driver_class == driver_car_association_end.classifier
    assert 1 == car_driver_association_end.lowerBound
    assert 1 == car_driver_association_end.upperBound
    assert 0 == driver_car_association_end.lowerBound
    assert -1 == driver_car_association_end.upperBound

       
def test_creating_two_class_solution_with_generalization(): 
    """Test that a solution with these two classes can be created:
   
   class Car {} // see above
   class Audi{} {
   int modelNumber;
   """  
    modeling_assistant = ModelingAssistant()
    solution = Solution()
    class_diagram = ClassDiagram(name="Student1_solution")
    solution.classDiagram = class_diagram
    modeling_assistant.solutions.append(solution)
    
    cd_int = CDInt()
    cd_string = CDString()

    car_class = Class(name="Car", attributes=[
        Attribute(name="id", type=cd_int),
        Attribute(name="make", type=cd_string)
    ])
    audi_class = Class(name="Audi", attributes=[Attribute(name="Model Number", type=cd_int)])
    
    audi_class.superTypes.eType = car_class

    class_diagram.classes.extend([car_class, audi_class])

    assert "Student1_solution" == modeling_assistant.solutions[0].classDiagram.name
    assert class_diagram == modeling_assistant.solutions[0].classDiagram
    
    assert car_class == class_diagram.classes[0]
    assert "Car" == car_class.name
    assert "id" == car_class.attributes[0].name
    assert cd_int == car_class.attributes[0].type
    assert "make" == car_class.attributes[1].name
    assert cd_string == car_class.attributes[1].type

    assert audi_class == class_diagram.classes[1]
    assert "Audi" == audi_class.name
    assert "Model Number" == audi_class.attributes[0].name
    assert cd_int == audi_class.attributes[0].type

    assert "Car" == audi_class.superTypes.eType.name
    assert "id" == audi_class.superTypes.eType.attributes[0].name
    assert "make" == audi_class.superTypes.eType.attributes[1].name

if __name__ == "__main__":
    "Main entry point."
    test_creating_empty_solution()
    test_creating_one_class_solution()
