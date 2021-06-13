package controller.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.util.CdmResourceFactoryImpl;
import classdiagram.Attribute;
import classdiagram.CDInt;
import classdiagram.CDString;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramFactory;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import classdiagram.ReferenceType;
import learningcorpus.LearningCorpus;
import learningcorpus.LearningcorpusPackage;
import learningcorpus.mistaketypes.MistakeTypes;
import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.util.ModelingassistantResourceFactoryImpl;

public class ControllerTest {

  /** The location of the default learning corpus. */
  public static final String LEARNING_CORPUS_PATH =
      "../modelingassistant.learningcorpus.dsl.instances/test.learningcorpus";

  @Test public void testJunitIsWorking() {
    assertTrue(true);
  }

  @Test public void testCreatingEmptySolution() {
    var maf = ModelingassistantFactory.eINSTANCE;
    var cdf = ClassdiagramFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var classDiagram = cdf.createClassDiagram();
    var solution = maf.createSolution();
    classDiagram.setName("Student1_solution");
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);
    assertEquals("Student1_solution", modelingAssistant.getSolutions().get(0).getClassDiagram().getName());
  }

  /**
   * Tests that a solution with one class can be created (Umple syntax):
   *
   * class Car {
   *   int id;
   *   String make; // eg, BMW, Honda
   * }
   */
  @Test public void testCreatingOneClassSolution() {
    var maf = ModelingassistantFactory.eINSTANCE;
    var cdf = ClassdiagramFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var classDiagram = cdf.createClassDiagram();
    var solution = maf.createSolution();
    classDiagram.setName("Student1_solution");
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    var carClass = cdf.createClass();
    carClass.setName("Car");
    var carId = cdf.createAttribute();
    carId.setName("id");
    var intType = cdf.createCDInt();
    carId.setType(intType);
    var carMake = cdf.createAttribute();
    carMake.setName("make");
    var stringType = cdf.createCDString();
    carMake.setType(stringType);
    carClass.getAttributes().add(carId);
    carClass.getAttributes().add(carMake);
    classDiagram.getClasses().add(carClass);

    assertEquals("Student1_solution", modelingAssistant.getSolutions().get(0).getClassDiagram().getName());
    assertEquals("Car", classDiagram.getClasses().get(0).getName());
    assertEquals("id", classDiagram.getClasses().get(0).getAttributes().get(0).getName());
    assertEquals("make", classDiagram.getClasses().get(0).getAttributes().get(1).getName());
    assertEquals(intType, classDiagram.getClasses().get(0).getAttributes().get(0).getType());
    assertEquals(stringType, classDiagram.getClasses().get(0).getAttributes().get(1).getType());
  }

  /**
   * Test that a solution with these two classes can be created:
   *
   * class Car {} // see above
   * class Driver {
   *   String name;
   *   * -- 1 Car primaryVehicle;
   * }
   */
  @Test public void testCreatingTwoClassSolutionWithAssociation() {
    var maf = ModelingassistantFactory.eINSTANCE;
    var cdf = ClassdiagramFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var classDiagram = cdf.createClassDiagram();
    var solution = maf.createSolution();
    var cdInt = cdf.createCDInt();
    var cdString = cdf.createCDString();
    classDiagram.setName("Student1_solution");
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    var carClass = cdf.createClass();
    carClass.setName("Car");
    var carId = cdf.createAttribute();
    carId.setName("id");
    carId.setType(cdInt);
    var carMake = cdf.createAttribute();
    carMake.setName("make");
    carMake.setType(cdString);
    carClass.getAttributes().add(carId);
    carClass.getAttributes().add(carMake);

    var driverClass = cdf.createClass();
    driverClass.setName("Driver");
    var driverName = cdf.createAttribute();
    driverName.setName("name");
    driverName.setType(cdString);
    driverClass.getAttributes().add(driverName);

    var carDriverAssociationEnd = cdf.createAssociationEnd();
    carDriverAssociationEnd.setClassifier(carClass);
    carDriverAssociationEnd.setNavigable(true);
    carDriverAssociationEnd.setLowerBound(1);
    carDriverAssociationEnd.setUpperBound(1);
    var driverCarAssociationEnd = cdf.createAssociationEnd();
    driverCarAssociationEnd.setClassifier(driverClass);
    driverCarAssociationEnd.setNavigable(true);
    driverCarAssociationEnd.setLowerBound(0);
    driverCarAssociationEnd.setUpperBound(-1);
    carClass.getAssociationEnds().add(carDriverAssociationEnd);
    driverClass.getAssociationEnds().add(driverCarAssociationEnd);
    var carDriverAssociation = cdf.createAssociation();
    carDriverAssociation.getEnds().addAll(List.of(carDriverAssociationEnd, driverCarAssociationEnd));
    carDriverAssociationEnd.setAssoc(carDriverAssociation);
    driverCarAssociationEnd.setAssoc(carDriverAssociation);

    classDiagram.getClasses().addAll(List.of(carClass, driverClass));

    assertEquals("Student1_solution", modelingAssistant.getSolutions().get(0).getClassDiagram().getName());
    assertEquals(classDiagram, modelingAssistant.getSolutions().get(0).getClassDiagram());

    assertEquals(carClass, classDiagram.getClasses().get(0));
    assertEquals("Car", carClass.getName());
    assertEquals("id", carClass.getAttributes().get(0).getName());
    assertEquals("make", carClass.getAttributes().get(1).getName());
    assertEquals(cdInt, carClass.getAttributes().get(0).getType());
    assertEquals(cdString, carClass.getAttributes().get(1).getType());

    assertEquals(driverClass, classDiagram.getClasses().get(1));
    assertEquals("Driver", driverClass.getName());
    assertEquals("name", driverClass.getAttributes().get(0).getName());
    assertEquals(cdString, driverClass.getAttributes().get(0).getType());

    assertEquals(carDriverAssociation, carClass.getAssociationEnds().get(0).getAssoc());
    assertEquals(carDriverAssociation, driverClass.getAssociationEnds().get(0).getAssoc());
    assertEquals(carDriverAssociationEnd, carDriverAssociation.getEnds().get(0));
    assertEquals(driverCarAssociationEnd, carDriverAssociation.getEnds().get(1));
    assertEquals(carClass, carDriverAssociationEnd.getClassifier());
    assertEquals(driverClass, driverCarAssociationEnd.getClassifier());
    assertEquals(1, carDriverAssociationEnd.getLowerBound());
    assertEquals(1, carDriverAssociationEnd.getUpperBound());
    assertEquals(0, driverCarAssociationEnd.getLowerBound());
    assertEquals(-1, driverCarAssociationEnd.getUpperBound());
  }

  /**
   * Test that a solution with these two classes can be created:
   *
   * class Car {} // see above
   * class SportsCar { isA Car; }
   */
  @Test
  public void testCreatingTwoClassSolutionWithGeneralization() {
    var maf = ModelingassistantFactory.eINSTANCE;
    var cdf = ClassdiagramFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var classDiagram = cdf.createClassDiagram();
    var solution = maf.createSolution();
    var cdInt = cdf.createCDInt();
    var cdString = cdf.createCDString();
    classDiagram.setName("Student1_solution");
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    var carClass = cdf.createClass();
    carClass.setName("Car");
    var carId = cdf.createAttribute();
    carId.setName("id");
    carId.setType(cdInt);
    var carMake = cdf.createAttribute();
    carMake.setName("make");
    carMake.setType(cdString);
    carClass.getAttributes().add(carId);
    carClass.getAttributes().add(carMake);

    var sportsCarClass = cdf.createClass();
    sportsCarClass.setName("SportsCar");
    sportsCarClass.getSuperTypes().add(carClass);

    classDiagram.getClasses().addAll(List.of(carClass, sportsCarClass));

    assertEquals("Student1_solution", modelingAssistant.getSolutions().get(0).getClassDiagram().getName());
    assertEquals(classDiagram, modelingAssistant.getSolutions().get(0).getClassDiagram());

    assertEquals(carClass, classDiagram.getClasses().get(0));
    assertEquals("Car", carClass.getName());
    assertEquals("id", carClass.getAttributes().get(0).getName());
    assertEquals("make", carClass.getAttributes().get(1).getName());
    assertEquals(cdInt, carClass.getAttributes().get(0).getType());
    assertEquals(cdString, carClass.getAttributes().get(1).getType());

    assertEquals(sportsCarClass, classDiagram.getClasses().get(1));
    assertEquals("SportsCar", sportsCarClass.getName());
    assertEquals("Car", sportsCarClass.getSuperTypes().get(0).getName());
    assertEquals("id", sportsCarClass.getSuperTypes().get(0).getAttributes().get(0).getName());
    assertEquals("make", sportsCarClass.getSuperTypes().get(0).getAttributes().get(1).getName());
  }

  /**
   * Verifies that it is possible to create a modeling assistant solution from a serialized TouchCORE
   * single class domain model.
   */
  @Test public void testCreatingOneClassSolutionFromSerializedClassDiagram() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../modelingassistant/testmodels/car.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);
    var carClass = classDiagram.getClasses().get(0);

    assertEquals(carClass, classDiagram.getClasses().get(0));
    assertEquals("Car", carClass.getName());
    assertEquals("id", carClass.getAttributes().get(0).getName());
    assertEquals("make", carClass.getAttributes().get(1).getName());
    assertTrue(carClass.getAttributes().get(0).getType() instanceof CDInt);
    assertTrue(carClass.getAttributes().get(1).getType() instanceof CDString);

    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    assertTrue(solution.getClassDiagram().getClasses().contains(carClass));
  }

  /**
   * Verifies that it is possible to create a modeling assistant solution from a serialized TouchCORE
   * multiclass domain model.
   */
  @Test public void testCreatingMulticlassSolutionFromSerializedClassDiagram() {
    ClassdiagramPackage.eINSTANCE.eClass();
    var cdmFile = "../modelingassistant/testmodels/car_sportscar_part_driver.domain_model.cdm";
    var resource = ResourceHelper.INSTANCE.loadResource(cdmFile);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);

    Classifier carClass = null;
    Classifier driverClass = null;
    Classifier sportsCarClass = null;
    Classifier partClass = null;
    for (var c: classDiagram.getClasses()) {
      if ("Car".equals(c.getName())) carClass = c;
      else if ("Driver".equals(c.getName())) driverClass = c;
      else if ("SportsCar".equals(c.getName())) sportsCarClass = c;
      else if ("Part".equals(c.getName())) partClass = c;
    }

    assertEquals(carClass, classDiagram.getClasses().get(0));
    assertEquals("Car", carClass.getName());
    assertEquals("id", carClass.getAttributes().get(0).getName());
    assertEquals("make", carClass.getAttributes().get(1).getName());
    assertTrue(carClass.getAttributes().get(0).getType() instanceof CDInt);
    assertTrue(carClass.getAttributes().get(1).getType() instanceof CDString);
    assertEquals("Part", partClass.getName());
    assertEquals("Car", sportsCarClass.getSuperTypes().get(0).getName());
    assertEquals(ReferenceType.COMPOSITION, carClass.getAssociationEnds().stream()
        .filter(ae -> "parts".equals(ae.getName())).collect(Collectors.toList()).get(0).getReferenceType());

    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setModelingAssistant(modelingAssistant);
    solution.setClassDiagram(classDiagram);

    List.of(carClass, driverClass, sportsCarClass, partClass).forEach(c ->
        assertTrue(solution.getClassDiagram().getClasses().contains(c)));
  }

  /**
   * Verifies that a ModelingAssistant instance with a one class solution can be serialized to an XMI file.
   */
  @Test public void testPersistingModelingAssistantWithOneClassSolution() {
    var maInstancePath = "../modelingassistant/instances/";
    var maFilename = "ma_one_class_from_java.xmi";
    var cdFilename = "ma_one_class_from_java.cdm";
    var maPath = maInstancePath + maFilename;
    var cdPath = maInstancePath + cdFilename;
    var maFile = new File(maPath);
    var cdFile = new File(cdPath);
    if (maFile.isFile()) {
      assertTrue(maFile.delete());
    }
    if (cdFile.isFile()) {
      assertTrue(cdFile.delete());
    }

    // Dynamically create a modeling assistant and link it with a TouchCore class diagram
    ClassdiagramPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();
    var cdf = ClassdiagramFactory.eINSTANCE;
    var maf = ModelingassistantFactory.eINSTANCE;

    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    var classDiagram = cdf.createClassDiagram();
    classDiagram.setName("Student1_solution");
    solution.setClassDiagram(classDiagram);
    solution.setModelingAssistant(modelingAssistant);
    var cdInt = cdf.createCDInt();
    var cdString = cdf.createCDString();

    var carClass = cdf.createClass();
    carClass.setName("Car");
    var carId = cdf.createAttribute();
    carId.setName("id");
    carId.setType(cdInt);
    var carMake = cdf.createAttribute();
    carMake.setName("make");
    carMake.setType(cdString);
    carClass.getAttributes().addAll(List.of(carId, carMake));

    classDiagram.getTypes().addAll(List.of(cdInt, cdString));
    classDiagram.getClasses().add(carClass);

    assertEquals("Student1_solution", modelingAssistant.getSolutions().get(0).getClassDiagram().getName());
    assertEquals("Car", classDiagram.getClasses().get(0).getName());

    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        new ModelingassistantResourceFactoryImpl());
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cdm",
        new CdmResourceFactoryImpl());
    try {
      var maResource = rset.createResource(URI.createFileURI(maFile.getCanonicalPath()));
      var cdResource = rset.createResource(URI.createFileURI(cdFile.getCanonicalPath()));
      maResource.getContents().add(modelingAssistant);
      cdResource.getContents().add(classDiagram);
      maResource.save(Collections.EMPTY_MAP);
      cdResource.save(Collections.EMPTY_MAP);
      assertTrue(maFile.isFile());
      assertTrue(cdFile.isFile());
      var cdFileContent = Files.readString(Paths.get(cdPath));
      List.of("Student1_solution", "Car", "make", "CDInt").forEach(s ->
          assertTrue(cdFileContent.contains(s)));
    } catch (IOException e) {
      fail();
    }
  }

  /**
   * Verifies that the modeling assistant instance defined above can be deserialized correctly.
   */
  @Test public void testLoadingModelingAssistantWithOneClassSolution() {
    ClassdiagramPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();
    var maPath = "../modelingassistant/instances/ma_one_class_from_java.xmi";
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        new ModelingassistantResourceFactoryImpl());
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cdm",
        new CdmResourceFactoryImpl());
    try {
      var maResource = rset.createResource(URI.createFileURI(new File(maPath).getCanonicalPath()));
      maResource.load(Collections.EMPTY_MAP);

      var modelingAssistant = (ModelingAssistant) maResource.getContents().get(0);
      var classDiagram = modelingAssistant.getSolutions().get(0).getClassDiagram();

      assertEquals("Student1_solution", classDiagram.getName());
      var expectedClassNames = new ArrayList<String>(List.of("Car"));
      classDiagram.getClasses().forEach(c -> assertTrue(expectedClassNames.remove(c.getName())));
      assertTrue(expectedClassNames.isEmpty());
    } catch (IOException e) {
      fail();
    }
  }

  /**
   * Verifies that the pyecore version of the modeling assistant instance defined above can be deserialized correctly.
   */
  @Test public void testLoadingModelingAssistantWithOneClassSolutionSerializedWithPyecore() {
    ClassdiagramPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();
    var maPath = "../modelingassistant/instances/ma_one_class_from_python.xmi";
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        new ModelingassistantResourceFactoryImpl());
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cdm",
        new CdmResourceFactoryImpl());
    try {
      var maResource = rset.createResource(URI.createFileURI(new File(maPath).getCanonicalPath()));
      maResource.load(Collections.EMPTY_MAP);

      var modelingAssistant = (ModelingAssistant) maResource.getContents().get(0);
      var classDiagram = modelingAssistant.getSolutions().get(0).getClassDiagram();

      assertEquals("Student1_solution", classDiagram.getName());
      var expectedClassNames = new ArrayList<String>(List.of("Car"));
      classDiagram.getClasses().forEach(c -> assertTrue(expectedClassNames.remove(c.getName())));
      assertTrue(expectedClassNames.isEmpty());
    } catch (IOException e) {
      fail();
    }
  }

  /**
   * Verifies that a ModelingAssistant instance with a multiclass solution can be serialized to an XMI file.
   */
  @Test public void testPersistingModelingAssistantWithMulticlassSolution() {
    var maPath = "../modelingassistant/instances/ma_multiclass_from_java.xmi";
    var cdPath = "../modelingassistant/instances/ma_multiclass_from_java.cdm";
    var maFile = new File(maPath);
    var cdFile = new File(cdPath);
    if (maFile.isFile()) {
      assertTrue(maFile.delete());
    }
    if (cdFile.isFile()) {
      assertTrue(cdFile.delete());
    }

    ClassdiagramPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();

    // Open premade class diagram from one of the above tests
    // Can't reuse ResourceHelper.INSTANCE here to load duplicate resource
    var cdmFile = "../modelingassistant/testmodels/car_sportscar_part_driver.domain_model.cdm";
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        new ModelingassistantResourceFactoryImpl());
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cdm",
        new CdmResourceFactoryImpl());
    var resource = rset.getResource(URI.createFileURI(cdmFile), true);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);

    // Link class_diagram to modeling assistant instance
    var maf = ModelingassistantFactory.eINSTANCE;
    var modelingAssistant = maf.createModelingAssistant();
    var solution = maf.createSolution();
    solution.setClassDiagram(classDiagram);
    solution.setModelingAssistant(modelingAssistant);

    // Save modeling assistant instance to file and verify contents
    try {
      var maResource = rset.createResource(URI.createFileURI(maFile.getCanonicalPath()));
      var cdResource = rset.createResource(URI.createFileURI(cdFile.getCanonicalPath()));
      maResource.getContents().add(modelingAssistant);
      cdResource.getContents().add(classDiagram);
      maResource.save(Collections.EMPTY_MAP);
      cdResource.save(Collections.EMPTY_MAP);
      assertTrue(maFile.isFile());
      assertTrue(cdFile.isFile());
      var cdFileContent = Files.readString(Paths.get(cdPath));
      List.of("Car", "SportsCar", "Part", "Driver", "make", "CDInt").forEach(s ->
          assertTrue(cdFileContent.contains(s)));
    } catch (IOException e) {
      fail();
    }
  }

  /**
   * Verifies that the modeling assistant instance defined above can be deserialized correctly.
   */
  @Test public void testLoadingModelingAssistantWithMulticlassSolution() {
    ClassdiagramPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();
    var maPath = "../modelingassistant/instances/ma_multiclass_from_java.xmi";
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        new ModelingassistantResourceFactoryImpl());
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cdm",
        new CdmResourceFactoryImpl());

    try {
      var maResource = rset.createResource(URI.createFileURI(new File(maPath).getCanonicalPath()));
      maResource.load(Collections.EMPTY_MAP);

      var modelingAssistant = (ModelingAssistant) maResource.getContents().get(0);
      var classDiagram = modelingAssistant.getSolutions().get(0).getClassDiagram();

      var expectedClassNames = new ArrayList<String>(List.of("Car", "SportsCar", "Part", "Driver"));
      classDiagram.getClasses().forEach(c -> {
        if ("Car".equals(c.getName())) {
          c.getAttributes().forEach(a -> assertTrue(a.getType() instanceof CDInt || a.getType() instanceof CDString));
        }
        if ("SportsCar".equals(c.getName())) {
          assertEquals("Car", c.getSuperTypes().get(0).getName());
        }
        assertTrue(expectedClassNames.remove(c.getName()));
      });
      assertTrue(expectedClassNames.isEmpty());
    } catch (IOException e) {
      fail();
    }
  }

  /**
   * Verifies that the pyecore version of the modeling assistant instance defined above can be deserialized correctly.
   */
  @Test public void testLoadingModelingAssistantWithMulticlassSolutionSerializedWithPyecore() {
    ClassdiagramPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();
    var maPath = "../modelingassistant/instances/ma_multiclass_from_python.xmi";
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        new ModelingassistantResourceFactoryImpl());
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cdm",
        new CdmResourceFactoryImpl());

    try {
      var maResource = rset.createResource(URI.createFileURI(new File(maPath).getCanonicalPath()));
      maResource.load(Collections.EMPTY_MAP);

      var modelingAssistant = (ModelingAssistant) maResource.getContents().get(0);
      var classDiagram = modelingAssistant.getSolutions().get(0).getClassDiagram();

      var expectedClassNames = new ArrayList<String>(List.of("Car", "SportsCar", "Part", "Driver"));
      classDiagram.getClasses().forEach(c -> {
        if ("Car".equals(c.getName())) {
          c.getAttributes().forEach(a -> assertTrue(a.getType() instanceof CDInt || a.getType() instanceof CDString));
        }
        if ("SportsCar".equals(c.getName())) {
          assertEquals("Car", c.getSuperTypes().get(0).getName());
        }
        assertTrue(expectedClassNames.remove(c.getName()));
      });
      assertTrue(expectedClassNames.isEmpty());
    } catch (IOException e) {
      fail();
    }
  }

  /**
   * Verifies that a ModelingAssistant instance with a multiclass solution can be serialized to an XMI file.
   */
  @Test public void testPersistingModelingAssistantWithMultipleSolutions() {
    var maPath = "../modelingassistant/instances/ma_multisolution_from_java.xmi";
    var cd1Path = "../modelingassistant/instances/ma_multisolution_from_java1.cdm";
    var cd2Path = "../modelingassistant/instances/ma_multisolution_from_java2.cdm";
    var maFile = new File(maPath);
    var cd1File = new File(cd1Path);
    var cd2File = new File(cd2Path);
    List.of(maFile, cd1File, cd2File).stream().filter(File::isFile).forEach(f -> assertTrue(f.delete()));

    ClassdiagramPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();
    var cdf = ClassdiagramFactory.eINSTANCE;
    var maf = ModelingassistantFactory.eINSTANCE;

    // Open premade class diagram from one of the above tests
    // Can't reuse ResourceHelper.INSTANCE here to load duplicate resource
    var cdmFile = "../modelingassistant/testmodels/car_sportscar_part_driver.domain_model.cdm";
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        new ModelingassistantResourceFactoryImpl());
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cdm",
        new CdmResourceFactoryImpl());
    var resource = rset.getResource(URI.createFileURI(cdmFile), true);
    var classDiagram1 = (ClassDiagram) resource.getContents().get(0);

    // Link first class diagram to modeling assistant instance
    var modelingAssistant = maf.createModelingAssistant();
    var solution1 = maf.createSolution();
    solution1.setClassDiagram(classDiagram1);
    modelingAssistant.getSolutions().add(solution1);

    // Make and link second class diagram to modeling assistant instance
    var classDiagram2 = cdf.createClassDiagram();
    classDiagram2.setName("Student2_solution");
    var solution2 = maf.createSolution();
    solution2.setClassDiagram(classDiagram2);
    modelingAssistant.getSolutions().add(solution2);

    var cdInt = cdf.createCDInt();
    var cdString = cdf.createCDString();
    classDiagram2.getTypes().addAll(List.of(cdInt, cdString));

    var carClass2 = cdf.createClass();
    carClass2.setName("Car");
    var carId = cdf.createAttribute();
    carId.setName("id");
    carId.setType(cdInt);
    var carMake = cdf.createAttribute();
    carMake.setName("make");
    carMake.setType(cdString);
    carClass2.getAttributes().addAll(List.of(carId, carMake));
    classDiagram2.getClasses().add(carClass2);

    // Save modeling assistant instance to file and verify contents
    try {
      var maResource = rset.createResource(URI.createFileURI(maFile.getCanonicalPath()));
      var cd1Resource = rset.createResource(URI.createFileURI(cd1File.getCanonicalPath()));
      var cd2Resource = rset.createResource(URI.createFileURI(cd2File.getCanonicalPath()));
      maResource.getContents().add(modelingAssistant);
      cd1Resource.getContents().add(classDiagram1);
      cd2Resource.getContents().add(classDiagram2);
      maResource.save(Collections.EMPTY_MAP);
      cd1Resource.save(Collections.EMPTY_MAP);
      cd2Resource.save(Collections.EMPTY_MAP);
      List.of(maFile, cd1File, cd2File).stream().forEach(f -> assertTrue(f.isFile()));
      var cd1FileContent = Files.readString(Paths.get(cd1Path));
      var cd2FileContent = Files.readString(Paths.get(cd2Path));
      List.of("Car", "SportsCar", "Part", "Driver", "make", "CDInt").forEach(s ->
          assertTrue(cd1FileContent.contains(s)));
      List.of("Car", "make", "CDInt", "Student2_solution").forEach(s ->
          assertTrue(cd2FileContent.contains(s)));
    } catch (IOException e) {
      fail();
    }
  }

  /**
   * Verifies that the modeling assistant instance defined above can be deserialized correctly.
   */
  @Test public void testLoadingModelingAssistantWithMultipleSolutions() {
    ClassdiagramPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();
    var maPath = "../modelingassistant/instances/ma_multisolution_from_java.xmi";
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        new ModelingassistantResourceFactoryImpl());
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cdm",
        new CdmResourceFactoryImpl());

    try {
      var maResource = rset.createResource(URI.createFileURI(new File(maPath).getCanonicalPath()));
      maResource.load(Collections.EMPTY_MAP);

      var modelingAssistant = (ModelingAssistant) maResource.getContents().get(0);
      var classDiagram1 = modelingAssistant.getSolutions().get(0).getClassDiagram();
      var classDiagram2 = modelingAssistant.getSolutions().get(1).getClassDiagram();
      Predicate<Attribute> isCdIntOrStr = a -> a.getType() instanceof CDInt || a.getType() instanceof CDString;

      var expectedClassNames1 = new ArrayList<String>(List.of("Car", "SportsCar", "Part", "Driver"));
      classDiagram1.getClasses().forEach(c -> {
        if ("Car".equals(c.getName())) {
          c.getAttributes().forEach(a -> assertTrue(isCdIntOrStr.test(a)));
        }
        if ("SportsCar".equals(c.getName())) {
          assertEquals("Car", c.getSuperTypes().get(0).getName());
        }
        assertTrue(expectedClassNames1.remove(c.getName()));
      });
      assertTrue(expectedClassNames1.isEmpty());

      var expectedClassNames2 = new ArrayList<String>(List.of("Car"));
      classDiagram2.getClasses().forEach(c -> {
        if ("Car".equals(c.getName())) {
          c.getAttributes().forEach(a -> assertTrue(isCdIntOrStr.test(a)));
        }
        assertTrue(expectedClassNames2.remove(c.getName()));
      });
      assertTrue(expectedClassNames2.isEmpty());
    } catch (IOException e) {
      fail();
    }
  }

  /**
   * Verifies that the pyecore version of the modeling assistant instance defined above can be deserialized correctly.
   */
  @Test public void testLoadingModelingAssistantWithMultipleSolutionsSerializedWithPyecore() {
    ClassdiagramPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();
    var maPath = "../modelingassistant/instances/ma_multisolution_from_python.xmi";
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        new ModelingassistantResourceFactoryImpl());
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cdm",
        new CdmResourceFactoryImpl());

    try {
      var maResource = rset.createResource(URI.createFileURI(new File(maPath).getCanonicalPath()));
      maResource.load(Collections.EMPTY_MAP);

      var modelingAssistant = (ModelingAssistant) maResource.getContents().get(0);
      var classDiagram1 = modelingAssistant.getSolutions().get(0).getClassDiagram();
      var classDiagram2 = modelingAssistant.getSolutions().get(1).getClassDiagram();
      Predicate<Attribute> isCdIntOrStr = a -> a.getType() instanceof CDInt || a.getType() instanceof CDString;

      var expectedClassNames1 = new ArrayList<String>(List.of("Car", "SportsCar", "Part", "Driver"));
      classDiagram1.getClasses().forEach(c -> {
        if ("Car".equals(c.getName())) {
          c.getAttributes().forEach(a -> assertTrue(isCdIntOrStr.test(a)));
        }
        if ("SportsCar".equals(c.getName())) {
          assertEquals("Car", c.getSuperTypes().get(0).getName());
        }
        assertTrue(expectedClassNames1.remove(c.getName()));
      });
      assertTrue(expectedClassNames1.isEmpty());

      var expectedClassNames2 = new ArrayList<String>(List.of("Car"));
      classDiagram2.getClasses().forEach(c -> {
        if ("Car".equals(c.getName())) {
          c.getAttributes().forEach(a -> assertTrue(isCdIntOrStr.test(a)));
        }
        assertTrue(expectedClassNames2.remove(c.getName()));
      });
      assertTrue(expectedClassNames2.isEmpty());
    } catch (IOException e) {
      fail();
    }
  }

  /**
   *  Verifies that StudentKnowledge association classes can be serialized and loaded again correctly.
   */
  @Test public void testStudentKnowledgePersistedCorrectly() {
    var maPath = "../modelingassistant/instances/ma_studentknowledge_from_java.xmi";
    var maFile = new File(maPath);
    if (maFile.isFile()) {
      assertTrue(maFile.delete());
    }

    ClassdiagramPackage.eINSTANCE.eClass();
    LearningcorpusPackage.eINSTANCE.eClass();
    ModelingassistantPackage.eINSTANCE.eClass();
    var cdf = ClassdiagramFactory.eINSTANCE;
    var maf = ModelingassistantFactory.eINSTANCE;

    // Open premade class diagram from one of the above tests
    // Can't reuse ResourceHelper.INSTANCE here to load duplicate resource
    var cdmFile = "../modelingassistant/testmodels/car_sportscar_part_driver.domain_model.cdm";
    var rset = new ResourceSetImpl();
    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new ModelingassistantResourceFactoryImpl());
    var resource = rset.getResource(URI.createFileURI(cdmFile), true);
    var classDiagram = (ClassDiagram) resource.getContents().get(0);

    // Link first class diagram to modeling assistant instance and related student
    var modelingAssistant = maf.createModelingAssistant();
    var student1 = maf.createStudent();
    student1.setId("1111");
    student1.setModelingAssistant(modelingAssistant);
    var solution1 = maf.createSolution();
    solution1.setClassDiagram(classDiagram);
    solution1.setStudent(student1);
    solution1.setModelingAssistant(modelingAssistant);
    var lok1 = 10_578_963; // use a large int to detect it in testing
    var student1ClassNamingKnowledge = maf.createStudentKnowledge();
    student1ClassNamingKnowledge.setLevelOfKnowledge(lok1);
    student1ClassNamingKnowledge.setStudent(student1);
    student1ClassNamingKnowledge.setMistakeType(MistakeTypes.BAD_CLASS_NAME_SPELLING);
    student1ClassNamingKnowledge.setModelingAssistant(modelingAssistant);

    // Make and link second class diagram to modeling assistant instance and related student
    var classDiagram2 = cdf.createClassDiagram();
    classDiagram2.setName("Student2_solution");
    var student2 = maf.createStudent();
    student2.setId("2222");
    student2.setModelingAssistant(modelingAssistant);
    var solution2 = maf.createSolution();
    solution2.setClassDiagram(classDiagram2);
    solution2.setStudent(student2);
    solution2.setModelingAssistant(modelingAssistant);
    var lok2 = 8_996_541;
    var student2ClassNamingKnowledge = maf.createStudentKnowledge();
    student2ClassNamingKnowledge.setLevelOfKnowledge(lok2);
    student2ClassNamingKnowledge.setStudent(student2);
    student2ClassNamingKnowledge.setMistakeType(MistakeTypes.BAD_CLASS_NAME_SPELLING);
    student2ClassNamingKnowledge.setModelingAssistant(modelingAssistant);

    var cdInt = cdf.createCDInt();
    var cdString = cdf.createCDString();
    classDiagram2.getTypes().addAll(List.of(cdInt, cdString));

    var carClass2 = cdf.createClass();
    carClass2.setName("Car");
    var carId = cdf.createAttribute();
    carId.setName("id");
    carId.setType(cdInt);
    var carMake = cdf.createAttribute();
    carMake.setName("make");
    carMake.setType(cdString);
    carClass2.getAttributes().addAll(List.of(carId, carMake));
    classDiagram2.getClasses().add(carClass2);

    // Save modeling assistant instance to file and verify contents
    resource = rset.createResource(URI.createFileURI(maPath));
    resource.getContents().addAll(List.of(modelingAssistant, classDiagram, classDiagram2));
    try {
      resource.save(Collections.EMPTY_MAP);
      assertTrue(maFile.isFile());
      var fileContent = Files.readString(Paths.get(maPath));
      List.of("Car", "SportsCar", "Part", "Driver", "make", "CDInt", "Student2_solution", "1111", "2222",
          Integer.toString(lok1), Integer.toString(lok2)).forEach(s -> assertTrue(fileContent.contains(s)));
    } catch (IOException e) {
      fail();
    }

    // Test loading
    modelingAssistant = (ModelingAssistant) rset.getResource(URI.createFileURI(maPath), false).getContents().get(0);
    var s1k = modelingAssistant.getStudents().get(0).getStudentKnowledges().get(0);
    var s2k = modelingAssistant.getStudents().get(1).getStudentKnowledges().get(0);

    assertEquals("1111", s1k.getStudent().getId());
    assertEquals(lok1, s1k.getLevelOfKnowledge());
    assertEquals("Bad class name spelling", s1k.getMistakeType().getName());
    assertEquals("2222", s2k.getStudent().getId());
    assertEquals(lok2, s2k.getLevelOfKnowledge());
    assertTrue(s2k.getMistakeType().isAtomic());
  }

  /**
   * Verifies that the the modeling assistant instance defined above can be deserialized correctly.
   *
   * @deprecated The logic covered in this test will be tested in a different way once the refactoring is complete.
   */
  @Deprecated
  @Disabled
  @Test public void testLoadingModelingAssistantWithMistakeTypesAndCategories() {
//    ModelingassistantPackage.eINSTANCE.eClass();
//    var maPaths = List.of(
//        "../modelingassistant/instances/ma_mistaketypes_from_java.modelingassistant",
//        "../modelingassistant/instances/ma_mistaketypes_from_python.modelingassistant"
//    );
//    var rset = new ResourceSetImpl();
//    rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("modelingassistant",
//        new ModelingassistantResourceFactoryImpl());
//
//    final BiFunction<List<? extends NamedElement>, String, NamedElement> itemByName = (itemList, name) ->
//      itemList.stream().filter(item -> item.getName().equals(name)).findFirst().orElse(null);
//
//    maPaths.forEach(maPath -> {
//      try {
//        var maResource = rset.createResource(URI.createFileURI(new File(maPath).getCanonicalPath()));
//        maResource.load(Collections.EMPTY_MAP);
//
//        var modelingAssistant = (ModelingAssistant) maResource.getContents().get(0);
//        var mtcs = modelingAssistant.getMistakeTypeCategories();
//        var mts = modelingAssistant.getMistakeTypes();
//        var wrongClass = (MistakeTypeCategory) itemByName.apply(mtcs, "Wrong class");
//        var wrongClassName = (MistakeTypeCategory) itemByName.apply(mtcs, "Wrong class name");
//        var missingClass = (MistakeType) itemByName.apply(mts, "Missing class");
//        var seTerm = (MistakeType) itemByName.apply(mts, "Software engineering term");
//
//        /* Verify all of these relationships (names already correct due to above):
//         *
//         *                         Wrong class: MistakeTypeCategory
//         *                       /                                  \
//         *     Wrong class name: MistakeTypeCategory       Missing class: MistakeType
//         *                     |
//         *     Software engineering term: MistakeType
//         */
//        assertTrue(wrongClass.getSubcategories().contains(wrongClassName));
//        assertTrue(wrongClassName.getSupercategory() == wrongClass); // should be same object, not just equal
//        assertTrue(wrongClass.getMistakeTypes().contains(missingClass));
//        assertTrue(missingClass.getMistakeTypeCategory() == wrongClass);
//        assertTrue(wrongClassName.getMistakeTypes().contains(seTerm));
//        assertTrue(seTerm.getMistakeTypeCategory() == wrongClassName);
//        List.of(wrongClass, wrongClassName).forEach(mtc -> assertTrue(mtc.getModelingAssistant() == modelingAssistant));
//        List.of(missingClass, seTerm).forEach(mt -> assertTrue(mt.getModelingAssistant() == modelingAssistant));
//      } catch (IOException e) {
//        fail();
//      }
//    });
  }

  /**
   * Associates the two classes in memory (modifies classes and returns nothing).
   */
  public static void associate(Classifier class1, Classifier class2) {
    var cdf = ClassdiagramFactory.eINSTANCE;
    var class12AssociationEnd = cdf.createAssociationEnd();
    class12AssociationEnd.setClassifier(class1);
    class12AssociationEnd.setNavigable(true); // hardcoded for brevity
    class12AssociationEnd.setLowerBound(0);
    class12AssociationEnd.setUpperBound(-1);
    var class21AssociationEnd = cdf.createAssociationEnd();
    class21AssociationEnd.setClassifier(class2);
    class21AssociationEnd.setNavigable(true);
    class21AssociationEnd.setLowerBound(0);
    class21AssociationEnd.setUpperBound(-1);
    class1.getAssociationEnds().add(class12AssociationEnd);
    class2.getAssociationEnds().add(class21AssociationEnd);
    var association = cdf.createAssociation();
    association.getEnds().addAll(List.of(class12AssociationEnd, class21AssociationEnd));
    class12AssociationEnd.setAssoc(association);
    class21AssociationEnd.setAssoc(association);
  }

  public void contain(Classifier containedClass, Classifier containerClass) {
    var cdf = ClassdiagramFactory.eINSTANCE;
    var containerClassAssociationEnd = cdf.createAssociationEnd();
    containerClassAssociationEnd.setClassifier(containerClass);
    containerClassAssociationEnd.setNavigable(true);
    containerClassAssociationEnd.setLowerBound(1);
    containerClassAssociationEnd.setUpperBound(1);
    containerClassAssociationEnd.setReferenceType(ReferenceType.COMPOSITION);
    var containedClassAssociationEnd = cdf.createAssociationEnd();
    containedClassAssociationEnd.setClassifier(containedClass);
    containedClassAssociationEnd.setNavigable(true);
    containedClassAssociationEnd.setLowerBound(0);
    containedClassAssociationEnd.setUpperBound(-1);
    containerClass.getAssociationEnds().add(containerClassAssociationEnd);
    containedClass.getAssociationEnds().add(containedClassAssociationEnd);
    var containerClassContainedClassAssociation = cdf.createAssociation();
    containerClassContainedClassAssociation.getEnds()
        .addAll(List.of(containerClassAssociationEnd, containedClassAssociationEnd));
    containerClassAssociationEnd.setAssoc(containerClassContainedClassAssociation);
    containedClassAssociationEnd.setAssoc(containerClassContainedClassAssociation);
  }

  /** Returns the default learning corpus. */
  public static LearningCorpus getLearningCorpus() {
    return LearningCorpus.fromFile(LEARNING_CORPUS_PATH);
  }

}
