#!/usr/bin/env python3

"""
Tests for the interaction with the modeling assistant and learning corpus generated pyecore code.
Many of these tests have equivalents written in Java and therefore serve as a form of documentation.
"""

import os
import re
from textwrap import dedent

import pytest  # pylint: disable=unused-import
from stringserdes import SRSET, str_to_modelingassistant
from classdiagram import ClassDiagram, Class, Attribute, CDInt, CDString, AssociationEnd, Association, ReferenceType
from constants import LEARNING_CORPUS_PATH
from fileserdes import load_cdm, load_lc, load_ma, save_to_files
from learningcorpus import LearningItem
from mistaketypes import BAD_CLASS_NAME_SPELLING, corpus
from modelingassistant import ModelingAssistant, Solution, Student, StudentKnowledge


CDM_PATH = "modelingassistant/testmodels"
MA_PATH = "modelingassistant/testinstances"


def test_pytest_is_working():
    "Trivial test to very test setup is working."
    assert True


def test_creating_empty_solution():
    "Test creating an empty solution in memory."
    modeling_assistant = ModelingAssistant()
    class_diagram = ClassDiagram(name="Student1_solution")
    Solution(modelingAssistant=modeling_assistant, classDiagram=class_diagram)
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
    class_diagram = ClassDiagram(name="Student1_solution")
    Solution(modelingAssistant=modeling_assistant, classDiagram=class_diagram)
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
    class_diagram = ClassDiagram(name="Student1_solution")
    Solution(modelingAssistant=modeling_assistant, classDiagram=class_diagram)
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
    """
    Test that a solution with these two classes can be created:

    class Car {} // see above
    class SportsCar { isA Car; }
    """
    modeling_assistant = ModelingAssistant()
    class_diagram = ClassDiagram(name="Student1_solution")
    Solution(modelingAssistant=modeling_assistant, classDiagram=class_diagram)
    cd_int = CDInt()
    cd_string = CDString()

    car_class = Class(name="Car", attributes=[
        Attribute(name="id", type=cd_int),
        Attribute(name="make", type=cd_string)
    ])
    sports_car_class = Class(name="SportsCar", superTypes=[car_class])

    class_diagram.classes.extend([car_class, sports_car_class])

    assert "Student1_solution" == modeling_assistant.solutions[0].classDiagram.name
    assert class_diagram == modeling_assistant.solutions[0].classDiagram

    assert car_class == class_diagram.classes[0]
    assert "Car" == car_class.name
    assert "id" == car_class.attributes[0].name
    assert cd_int == car_class.attributes[0].type
    assert "make" == car_class.attributes[1].name
    assert cd_string == car_class.attributes[1].type

    assert sports_car_class == class_diagram.classes[1]
    assert "SportsCar" == sports_car_class.name
    assert "Car" == sports_car_class.superTypes[0].name
    assert "id" == sports_car_class.superTypes[0].attributes[0].name
    assert "make" == sports_car_class.superTypes[0].attributes[1].name


def test_creating_one_class_solution_from_serialized_class_diagram():
    """
    Verify that it is possible to create a modeling assistant solution from a serialized TouchCORE single class
    domain model.
    """
    cdm_file = f"{CDM_PATH}/car.domain_model.cdm"
    class_diagram = load_cdm(cdm_file)

    car_class = class_diagram.classes[0]
    assert "Car" == car_class.name
    assert "id" == car_class.attributes[0].name
    assert CDInt.__name__ == type(car_class.attributes[0].type).__name__
    assert "make" == car_class.attributes[1].name
    assert CDString.__name__ == type(car_class.attributes[1].type).__name__

    modeling_assistant = ModelingAssistant()
    solution = Solution(modelingAssistant=modeling_assistant, classDiagram=class_diagram)

    assert car_class == solution.classDiagram.classes[0]


def test_creating_multiclass_solution_from_serialized_class_diagram():
    """
    Verify that it is possible to create a modeling assistant solution from a serialized TouchCORE multiclass
    domain model.
    """
    # Open a class diagram instance
    cdm_file = f"{CDM_PATH}/car_sportscar_part_driver.domain_model.cdm"
    class_diagram = load_cdm(cdm_file)

    car_class = driver_class = sports_car_class = part_class = None
    for c in class_diagram.classes:
        if c.name == "Car": car_class = c
        elif c.name == "Driver": driver_class = c
        elif c.name == "SportsCar": sports_car_class = c
        elif c.name == "Part": part_class = c

    assert "Car" == car_class.name
    assert "id" == car_class.attributes[0].name
    assert CDInt.__name__ == type(car_class.attributes[0].type).__name__
    assert "make" == car_class.attributes[1].name
    assert CDString.__name__ == type(car_class.attributes[1].type).__name__
    assert "Part" == part_class.name
    assert "Car" == sports_car_class.superTypes[0].name
    for ae in car_class.associationEnds:
        if ae.name == "parts": assert "Composition" == str(ae.referenceType)

    modeling_assistant = ModelingAssistant()
    solution = Solution(modelingAssistant=modeling_assistant, classDiagram=class_diagram)

    for c in [car_class, driver_class, sports_car_class, part_class]:
        assert c in solution.classDiagram.classes


def test_persisting_modeling_assistant_with_one_class_solution():
    """
    Verify that a ModelingAssistant instance with a one class solution can be serialized to an XMI file.
    """
    # Remove previously created files (if they exist)
    ma_path = f"{MA_PATH}/ma_one_class_from_python.modelingassistant"
    cd_path = f"{MA_PATH}/ma_one_class_from_python.cdm"
    if os.path.exists(ma_path):
        os.remove(ma_path)
    if os.path.exists(cd_path):
        os.remove(cd_path)

    # Dynamically create a modeling assistant and link it with a TouchCore class diagram
    modeling_assistant = ModelingAssistant()
    class_diagram = ClassDiagram(name="Student1_solution")
    Solution(classDiagram=class_diagram, modelingAssistant=modeling_assistant)
    cd_int = CDInt()
    cd_string = CDString()
    class_diagram.types.extend([cd_int, cd_string])
    car_class = Class(name="Car", attributes=[
        Attribute(name="id", type=cd_int), Attribute(name="make", type=cd_string)])
    class_diagram.classes.append(car_class)
    assert "Student1_solution" == modeling_assistant.solutions[0].classDiagram.name
    assert "Car" == class_diagram.classes[0].name

    save_to_files({ma_path: modeling_assistant, cd_path: class_diagram})

    assert os.path.exists(ma_path)
    assert os.path.exists(cd_path)
    with open(cd_path, encoding="utf-8") as f:
        file_contents = f.read()
        for s in ["Student1_solution", "Car", "make", "CDInt"]:
            assert s in file_contents


def test_loading_modeling_assistant_with_one_class_solution():
    """
    Verify that the modeling assistant instance defined above can be deserialized correctly.
    """
    # Open a Modeling Assistant instance
    ma_file = f"{MA_PATH}/ma_one_class_from_python.modelingassistant"
    modeling_assistant = load_ma(ma_file)
    class_diagram: ClassDiagram = modeling_assistant.solutions[0].classDiagram
    class_diagram.__class__ = ClassDiagram

    assert "Student1_solution" == class_diagram.name
    expected_class_names = ["Car"]
    for c in class_diagram.classes:
        assert c.name in expected_class_names
        expected_class_names.remove(c.name)
    assert not expected_class_names


def test_loading_modeling_assistant_with_one_class_solution_serialized_in_java():
    """
    Verify that the Java version of the modeling assistant instance defined above can be deserialized correctly.
    """
    # Open a Modeling Assistant instance
    ma_file = f"{MA_PATH}/ma_one_class_from_java.modelingassistant"
    modeling_assistant = load_ma(ma_file)
    class_diagram: ClassDiagram = modeling_assistant.solutions[0].classDiagram
    class_diagram.__class__ = ClassDiagram

    assert "Student1_solution" == class_diagram.name
    expected_class_names = ["Car"]
    for c in class_diagram.classes:
        assert c.name in expected_class_names
        expected_class_names.remove(c.name)
    assert not expected_class_names


def test_persisting_modeling_assistant_with_multiclass_solution():
    """
    Verify that a ModelingAssistant instance with a multiclass solution can be serialized to an XMI file.
    """
    # Remove previously created file (if it exists)
    ma_file = f"{MA_PATH}/ma_multiclass_from_python.modelingassistant"
    cd_file = f"{MA_PATH}/ma_multiclass_from_python.cdm"
    if os.path.exists(ma_file): os.remove(ma_file)
    if os.path.exists(cd_file): os.remove(cd_file)

    # Open premade class diagram from one of the above tests
    premade_cdm_file = f"{CDM_PATH}/car_sportscar_part_driver.domain_model.cdm"
    class_diagram = load_cdm(premade_cdm_file)
    class_diagram.__class__ = ClassDiagram

    assert "Car" == class_diagram.classes[0].name

    # Link class_diagram to modeling assistant instance
    modeling_assistant = ModelingAssistant()
    Solution(classDiagram=class_diagram, modelingAssistant=modeling_assistant)

    save_to_files({ma_file: modeling_assistant, cd_file: class_diagram})

    assert os.path.exists(ma_file)
    assert os.path.exists(cd_file)
    with open(cd_file, encoding="utf-8") as f:
        file_contents = f.read()
        for s in ["Car", "SportsCar", "Part", "Driver", "make", "CDInt"]:
            assert s in file_contents


def test_loading_modeling_assistant_with_multiclass_solution():
    """
    Verify that the modeling assistant instance defined above can be deserialized correctly.
    """
    # Open a Modeling Assistant instance
    ma_file = f"{MA_PATH}/ma_multiclass_from_python.modelingassistant"
    modeling_assistant = load_ma(ma_file)
    class_diagram: ClassDiagram = modeling_assistant.solutions[0].classDiagram
    class_diagram.__class__ = ClassDiagram

    expected_class_names = ["Car", "SportsCar", "Part", "Driver"]
    for c in class_diagram.classes:
        if c.name == "Car":
            for a in c.attributes:
                assert type(a.type).__name__ in [CDInt.__name__, CDString.__name__]
        if c.name == "SportsCar":
            assert "Car" == c.superTypes[0].name
        assert c.name in expected_class_names
        expected_class_names.remove(c.name)
    assert not expected_class_names


def test_loading_modeling_assistant_with_multiclass_solution_serialized_in_java():
    """
    Verify that the Java version of the modeling assistant instance defined above can be deserialized correctly.
    """
    # Open a Modeling Assistant instance
    ma_file = f"{MA_PATH}/ma_multiclass_from_java.modelingassistant"
    modeling_assistant = load_ma(ma_file)
    class_diagram: ClassDiagram = modeling_assistant.solutions[0].classDiagram
    class_diagram.__class__ = ClassDiagram

    expected_class_names = ["Car", "SportsCar", "Part", "Driver"]
    for c in class_diagram.classes:
        if c.name == "Car":
            for a in c.attributes:
                assert type(a.type).__name__ in [CDInt.__name__, CDString.__name__]
        if c.name == "SportsCar":
            assert "Car" == c.superTypes[0].name
        assert c.name in expected_class_names
        expected_class_names.remove(c.name)
    assert not expected_class_names


def test_persisting_modeling_assistant_with_multiple_solutions():
    """
    Verify that a ModelingAssistant instance with multiple solutions can be serialized to an XMI file.
    """
    # Remove previously created file (if it exists)
    ma_path = f"{MA_PATH}/ma_multisolution_from_python.modelingassistant"
    cd1_path = f"{MA_PATH}/ma_multisolution_from_python1.cdm"
    cd2_path = f"{MA_PATH}/ma_multisolution_from_python2.cdm"
    for p in [ma_path, cd1_path, cd2_path]:
        if os.path.exists(p): os.remove(p)

    # Define mapping from destination filenames to class diagram instances
    cdm_by_file: dict[str, ClassDiagram] = {}

    # Open premade class diagram from one of the above tests
    premade_cdm_file = f"{CDM_PATH}/car_sportscar_part_driver.domain_model.cdm"
    class_diagram1 = load_cdm(premade_cdm_file)
    cdm_by_file[cd1_path] = class_diagram1

    # Link first class diagram to modeling assistant instance
    modeling_assistant = ModelingAssistant()
    Solution(classDiagram=class_diagram1, modelingAssistant=modeling_assistant)

    # Make and link second class diagram to modeling assistant instance
    class_diagram2 = ClassDiagram(name="Student2_solution")
    cdm_by_file[cd2_path] = class_diagram2
    Solution(classDiagram=class_diagram2, modelingAssistant=modeling_assistant)
    cd_int = CDInt()
    cd_string = CDString()
    class_diagram2.types.extend([cd_int, cd_string])
    car_class2 = Class(name="Car", attributes=[
        Attribute(name="id", type=cd_int),
        Attribute(name="make", type=cd_string)
    ])
    class_diagram2.classes.append(car_class2)

    save_to_files({
        cd1_path: cdm_by_file[cd1_path],
        cd2_path: cdm_by_file[cd2_path],
        ma_path: modeling_assistant
    })

    assert os.path.exists(ma_path)
    assert os.path.exists(cd1_path)
    assert os.path.exists(cd2_path)
    with open(cd1_path, encoding="utf-8") as f:
        file_contents = f.read()
        for s in ["Car", "SportsCar", "Part", "Driver", "make", "CDInt"]:
            assert s in file_contents
    with open(cd2_path, encoding="utf-8") as f:
        file_contents = f.read()
        for s in ["Car", "make", "CDInt", "Student2_solution"]:
            assert s in file_contents


def test_loading_modeling_assistant_with_multiple_solutions():
    """
    Verify that the modeling assistant instance defined above can be deserialized correctly.
    """
    # Open a Modeling Assistant instance
    ma_file = f"{MA_PATH}/ma_multisolution_from_python.modelingassistant"
    modeling_assistant = load_ma(ma_file)
    class_diagram1: ClassDiagram = modeling_assistant.solutions[0].classDiagram
    class_diagram1.__class__ = ClassDiagram
    class_diagram2: ClassDiagram = modeling_assistant.solutions[1].classDiagram
    class_diagram2.__class__ = ClassDiagram

    assert class_diagram1 == modeling_assistant.solutions[0].classDiagram
    expected_class_names1 = ["Car", "SportsCar", "Part", "Driver"]
    for c in class_diagram1.classes:
        if c.name == "Car":
            for a in c.attributes:
                assert type(a.type).__name__ in [CDInt.__name__, CDString.__name__]
        if c.name == "SportsCar":
            assert "Car" == c.superTypes[0].name
        assert c.name in expected_class_names1
        expected_class_names1.remove(c.name)
    assert not expected_class_names1

    assert class_diagram2 == modeling_assistant.solutions[1].classDiagram
    expected_class_names2 = ["Car"]
    for c in class_diagram2.classes:
        if c.name == "Car":
            for a in c.attributes:
                assert type(a.type).__name__ in [CDInt.__name__, CDString.__name__]
        assert c.name in expected_class_names2
        expected_class_names2.remove(c.name)
    assert not expected_class_names2


def test_loading_modeling_assistant_with_multiple_solutions_serialized_from_java():
    """
    Verify that the Java version of the modeling assistant instance defined above can be deserialized correctly.
    """
    # Open a Modeling Assistant instance
    ma_file = f"{MA_PATH}/ma_multisolution_from_java.modelingassistant"
    modeling_assistant = load_ma(ma_file)
    class_diagram1: ClassDiagram = modeling_assistant.solutions[0].classDiagram
    class_diagram1.__class__ = ClassDiagram
    class_diagram2: ClassDiagram = modeling_assistant.solutions[1].classDiagram
    class_diagram2.__class__ = ClassDiagram

    expected_class_names1 = ["Car", "SportsCar", "Part", "Driver"]
    for c in class_diagram1.classes:
        if c.name == "Car":
            for a in c.attributes:
                assert type(a.type).__name__ in [CDInt.__name__, CDString.__name__]
        if c.name == "SportsCar":
            assert "Car" == c.superTypes[0].name
        assert c.name in expected_class_names1
        expected_class_names1.remove(c.name)
    assert not expected_class_names1

    expected_class_names2 = ["Car"]
    for c in class_diagram2.classes:
        if c.name == "Car":
            for a in c.attributes:
                assert type(a.type).__name__ in [CDInt.__name__, CDString.__name__]
        assert c.name in expected_class_names2
        expected_class_names2.remove(c.name)
    assert not expected_class_names2


def test_persisting_modeling_assistant_with_multiple_solutions_to_one_file():
    """
    Verify that a ModelingAssistant instance with multiple solutions can be serialized with
    everything (including the class diagrams) in one file. This old test was brought back because
    the file is needed for generating a string to be used in the web app, and so no Java equivalent
    of this test is required.
    """
    # Remove previously created file (if it exists)
    ma_file = f"{MA_PATH}/ma_multisolution_all_in_one.modelingassistant"
    if os.path.exists(ma_file): os.remove(ma_file)

    # Open premade class diagram from one of the above tests
    cdm_file = f"{CDM_PATH}/car_sportscar_part_driver.domain_model.cdm"
    class_diagram1 = load_cdm(cdm_file)
    class_diagram1.name = "Student1_solution"

    # Link first class diagram to modeling assistant instance
    modeling_assistant = ModelingAssistant()
    Solution(classDiagram=class_diagram1, modelingAssistant=modeling_assistant)

    # Make and link second class diagram to modeling assistant instance
    class_diagram2 = ClassDiagram(name="Student2_solution")
    Solution(classDiagram=class_diagram2, modelingAssistant=modeling_assistant)
    cd_int = CDInt()
    cd_string = CDString()
    class_diagram2.types.extend([cd_int, cd_string])
    car_class2 = Class(name="Car", attributes=[
        Attribute(name="id", type=cd_int),
        Attribute(name="make", type=cd_string)
    ])
    class_diagram2.classes.append(car_class2)

    save_to_files({ma_file: [modeling_assistant, class_diagram1, class_diagram2]})

    assert os.path.exists(ma_file)
    with open(ma_file, encoding="utf-8") as f:
        file_contents = f.read()
        for s in ["Car", "SportsCar", "Part", "Driver", "make", "CDInt", "Student2_solution"]:
            assert s in file_contents


def test_loading_modeling_assistant_deserialized_from_string():
    """
    Test loading the instance defined above from a string.
    """
    ma_file = f"{MA_PATH}/ma_multisolution_all_in_one.modelingassistant"
    with open(ma_file, "rb") as f:
        ma_str = f.read()

    modeling_assistant = str_to_modelingassistant(ma_str)
    class_diagram1: ClassDiagram = modeling_assistant.solutions[0].classDiagram
    class_diagram2: ClassDiagram = modeling_assistant.solutions[1].classDiagram

    expected_class_names1 = ["Car", "SportsCar", "Part", "Driver"]
    expected_attr_types = [t.__name__ for t in (CDInt, CDString)]
    for c in class_diagram1.classes:
        if c.name == "Car":
            for a in c.attributes:
                assert type(a.type).__name__ in expected_attr_types
        if c.name == "SportsCar":
            assert "Car" == c.superTypes[0].name
        assert c.name in expected_class_names1
        expected_class_names1.remove(c.name)
    assert not expected_class_names1

    expected_class_names2 = ["Car"]
    for c in class_diagram2.classes:
        if c.name == "Car":
            for a in c.attributes:
                assert type(a.type).__name__ in expected_attr_types
        assert c.name in expected_class_names2
        expected_class_names2.remove(c.name)
    assert not expected_class_names2


def test_persisting_modeling_assistant_to_string():
    """
    Test saving the above instance back to a string.
    """
    # Create a ModelingAssistant instance in-memory
    modeling_assistant = ModelingAssistant()
    class_diagram = ClassDiagram(name="Student1_solution")
    Solution(modelingAssistant=modeling_assistant, classDiagram=class_diagram)
    cd_int = CDInt()
    cd_string = CDString()

    car_class = Class(name="Car", attributes=[
        Attribute(name="id", type=cd_int),
        Attribute(name="make", type=cd_string)
    ])
    class_diagram.classes.append(car_class)

    ma_str = SRSET.create_ma_str(modeling_assistant)

    # Find, match, and replace these regex patterns in the ma_str
    # Define and compile the patterns. The compilation allows for faster performance.
    xmi_id_pattern = re.compile(r'xmi:id="(.*?)"')  # since IDs are different each time test is run
    cdm_id_pattern = re.compile(r'classDiagram="(.*?)"')  # since cdm is different each time test is run
    # Use the patterns for find-and-replace
    ma_str = xmi_id_pattern.sub('xmi:id=""', ma_str)
    ma_str = cdm_id_pattern.sub('classDiagram=""', ma_str)
    ma_str = ma_str.replace(' type=""', '')  # since name and type can occur in any order

    assert dedent('''\
        <?xml version='1.0' encoding='UTF-8'?>
        <xmi:XMI xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:modelingassistant="http://cs.mcgill.ca/sel/modelingassistant/1.0" xmlns:classdiagram="http://cs.mcgill.ca/sel/cdm/1.0" xmi:version="2.0">
          <modelingassistant:ModelingAssistant xmi:id="">
            <solutions xsi:type="modelingassistant:Solution" xmi:id="" classDiagram=""/>
          </modelingassistant:ModelingAssistant>
          <classdiagram:ClassDiagram xmi:id="" name="Student1_solution">
            <classes xsi:type="classdiagram:Class" xmi:id="" name="Car">
              <attributes xsi:type="classdiagram:Attribute" xmi:id="" name="id"/>
              <attributes xsi:type="classdiagram:Attribute" xmi:id="" name="make"/>
            </classes>
          </classdiagram:ClassDiagram>
        </xmi:XMI>
        ''') == ma_str


def test_student_knowledge_persisted_correctly():
    """
    Verify that StudentKnowledge association classes can be serialized and loaded again correctly.
    """
    # Remove previously created files (if they exist)
    ma_file = f"{MA_PATH}/ma_studentknowledge_from_python.modelingassistant"
    cd1_file = f"{MA_PATH}/ma_studentknowledge_from_python1.cdm"
    cd2_file = f"{MA_PATH}/ma_studentknowledge_from_python2.cdm"
    for p in [ma_file, cd1_file, cd2_file]:
        if os.path.exists(p): os.remove(p)

    # Define mapping from destination filenames to class diagram instances
    cdm_by_file: dict[str, ClassDiagram] = {}

    # Open premade class diagram from one of the above tests
    cdm_file = f"{CDM_PATH}/car_sportscar_part_driver.domain_model.cdm"
    class_diagram1 = load_cdm(cdm_file)
    cdm_by_file[cd1_file] = class_diagram1

    # Open learning corpus and create general learning objects associated with it
    learning_corpus = load_lc(LEARNING_CORPUS_PATH)

    correct_class_naming = LearningItem(learningCorpus=learning_corpus)
    class_naming_mistake_type = BAD_CLASS_NAME_SPELLING
    class_naming_mistake_type.learningItem = correct_class_naming

    # Link first class diagram to modeling assistant instance and related student
    modeling_assistant = ModelingAssistant()
    student1 = Student(id="1111", modelingAssistant=modeling_assistant)
    Solution(classDiagram=class_diagram1, student=student1, modelingAssistant=modeling_assistant)
    lok1 = 10_578_963.0  # use a large float to detect it in testing
    StudentKnowledge(levelOfKnowledge=lok1, student=student1, mistakeType=class_naming_mistake_type,
                     modelingAssistant=modeling_assistant)

    # Make and link second class diagram to modeling assistant instance and related student
    class_diagram2 = ClassDiagram(name="Student2_solution")
    cdm_by_file[cd2_file] = class_diagram2
    student2 = Student(id="2222", modelingAssistant=modeling_assistant)
    Solution(classDiagram=class_diagram2, student=student2, modelingAssistant=modeling_assistant)
    lok2 = 8_996_541.0
    StudentKnowledge(levelOfKnowledge=lok2, student=student2, mistakeType=class_naming_mistake_type,
                     modelingAssistant=modeling_assistant)
    cd_int = CDInt()
    cd_string = CDString()
    class_diagram2.types.extend([cd_int, cd_string])
    car_class2 = Class(name="Car", attributes=[
        Attribute(name="id", type=cd_int),
        Attribute(name="make", type=cd_string)
    ])
    class_diagram2.classes.append(car_class2)

    save_to_files({
        cd1_file: class_diagram1,
        cd2_file: class_diagram2,
        ma_file: modeling_assistant
    })

    for p in [ma_file, cd1_file, cd2_file]:
        assert os.path.exists(p)

    # TODO modify lists to reflect what should be in each file
    with open(ma_file, encoding="utf-8") as f:
        file_contents = f.read()
        for s in ["1111", "2222", f"{lok1}", f"{lok2}", "mistakeType"]:
            assert s in file_contents
    with open(cd1_file, encoding="utf-8") as f:
        file_contents = f.read()
        for s in ["Car", "SportsCar", "Part", "Driver", "make", "CDInt"]:
            assert s in file_contents
    with open(cd2_file, encoding="utf-8") as f:
        file_contents = f.read()
        for s in ["Car", "make", "CDInt", "Student2_solution"]:
            assert s in file_contents

    # Test loading
    modeling_assistant = load_ma(ma_file)
    s1k = modeling_assistant.students[0].studentKnowledges[0]
    s2k = modeling_assistant.students[1].studentKnowledges[0]

    assert "1111" == s1k.student.id
    assert lok1 == s1k.levelOfKnowledge
    assert "Bad class name spelling" == s1k.mistakeType.name
    assert "2222" == s2k.student.id
    assert lok2 == s2k.levelOfKnowledge
    assert s2k.mistakeType.atomic


def test_learning_corpus_top_level_mtcs():
    """
    Test the custom LearningCorpus.topLevelMistakeTypeCategories() function added to the
    code autogenerated by pyecore.
    """
    top_level_mtcs = corpus.topLevelMistakeTypeCategories()
    assert top_level_mtcs
    for mtc in corpus.mistakeTypeCategories:
        if mtc in top_level_mtcs:
            assert mtc.supercategory is None
            top_level_mtcs.remove(mtc)
        else:
            assert mtc.supercategory
    assert not top_level_mtcs


def test_debug_ma4():
    ""
    ma_file = f"{MA_PATH}/ma-test4.modelingassistant"
    ma1 = load_ma(ma_file)
    with open(ma_file) as f:
        ma_str = f.read()
    ma2 = str_to_modelingassistant(ma_str)
    for ma in (ma1, ma2):
        for a in ma.problemStatements[0].instructorSolution.classDiagram.associations:
            assert len(a.ends) == 2


def associate(class1, class2):
    """
    Associate the two classes in memory (modify classes and return None).
    """
    class12_association_end = AssociationEnd(classifier=class1, navigable=True, lowerBound=0, upperBound=-1)
    class21_association_end = AssociationEnd(classifier=class2, navigable=True, lowerBound=0, upperBound=-1)
    class1.associationEnds.append(class12_association_end)
    class2.associationEnds.append(class21_association_end)
    association = Association(ends=[class12_association_end, class21_association_end])
    class12_association_end.assoc = association
    class21_association_end.assoc = association


def contains(container_class, contained_class):
    """
    Associate the two classes in memory (modify classes and return None).
    """
    class12_association_end = AssociationEnd(
        classifier=container_class, navigable=True, lowerBound=1, upperBound=1, referenceType=ReferenceType.Composition)  # pylint: disable=no-member
    class21_association_end = AssociationEnd(classifier=contained_class, navigable=True, lowerBound=0, upperBound=-1)
    container_class.associationEnds.append(class12_association_end)
    contained_class.associationEnds.append(class21_association_end)
    association = Association(ends=[class12_association_end, class21_association_end])
    class12_association_end.assoc = association
    class21_association_end.assoc = association


def check_for_incomplete_containment_tree(solution: Solution) -> bool:
    """
    Return True if containment is complete, False otherwise.
    """
    # Find the root class (if not given)
    num_compositions: dict[Class, int] = {}
    for c in solution.classDiagram.classes:
        num_compositions[c] = 0
        for ae in c.associationEnds:
            if str(ae.referenceType) == "Composition":
                num_compositions[c] += 1

    classes_with_most_compositions = [c for c, n in num_compositions.items() if n == max(num_compositions.values())]
    if len(classes_with_most_compositions) != 1:
        return False
    root_class = classes_with_most_compositions[0]

    # Check every assoc end to see if they connect to all other classes and reference type is Composition
    for ae in root_class.associationEnds:
        if str(ae.referenceType) != "Composition":
            return False

    # TODO Check subclasses, which do not to be contained directly
    for c in solution.classDiagram.classes:
        if c == root_class:
            continue
        contained = False
        for ae in c.associationEnds:
            other_ae = ae.assoc.ends[0] if ae.assoc.ends[0] != ae else ae.assoc.ends[1]
            if other_ae.classifier == root_class:
                contained = True
        if not contained:
            return False

    return True


def test_check_for_incomplete_containment_tree_success_case():
    """
    Test the above function with this example:

    class Flexibook {
      1 <@>- * Owner;
      1 <@>- * Customer;
      1 <@>- * Service;
    }
    class Owner {}
    class Customer {}
    class Service {
      * -- * Owner;
      * -- * Customer;
    }
    """
    # Dynamically create a modeling assistant and link it with a TouchCore class diagram
    modeling_assistant = ModelingAssistant()
    solution = Solution()
    class_diagram = ClassDiagram(name="Instructor_solution")
    solution.classDiagram = class_diagram
    modeling_assistant.solutions.append(solution)
    flexibook_class = Class(name="Flexibook")
    owner_class = Class(name="Owner")
    customer_class = Class(name="Customer")
    service_class = Class(name="Service")
    associate(service_class, owner_class)
    associate(service_class, customer_class)
    for c in [owner_class, customer_class, service_class]:
        contains(flexibook_class, c)
    class_diagram.classes.extend([flexibook_class, owner_class, customer_class, service_class])

    assert check_for_incomplete_containment_tree(solution)


def test_check_for_incomplete_containment_tree_failure_case():
    """
    Similar to above, except Sevice is not contained in Flexibook
    """
    modeling_assistant = ModelingAssistant()
    solution = Solution()
    class_diagram = ClassDiagram(name="Student1_solution")
    solution.classDiagram = class_diagram
    modeling_assistant.solutions.append(solution)
    flexibook_class = Class(name="Flexibook")
    owner_class = Class(name="Owner")
    customer_class = Class(name="Customer")
    service_class = Class(name="Service")
    associate(service_class, owner_class)
    associate(service_class, customer_class)
    for c in [owner_class, customer_class]:
        contains(flexibook_class, c)
    class_diagram.classes.extend([flexibook_class, owner_class, customer_class, service_class])

    assert not check_for_incomplete_containment_tree(solution)


if __name__ == "__main__":
    "Main entry point."