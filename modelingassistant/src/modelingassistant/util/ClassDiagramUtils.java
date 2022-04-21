package modelingassistant.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.eclipse.emf.common.util.BasicEList;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.CDAny;
import ca.mcgill.sel.classdiagram.CDBoolean;
import ca.mcgill.sel.classdiagram.CDByte;
import ca.mcgill.sel.classdiagram.CDChar;
import ca.mcgill.sel.classdiagram.CDDouble;
import ca.mcgill.sel.classdiagram.CDEnum;
import ca.mcgill.sel.classdiagram.CDEnumLiteral;
import ca.mcgill.sel.classdiagram.CDFloat;
import ca.mcgill.sel.classdiagram.CDInt;
import ca.mcgill.sel.classdiagram.CDLong;
import ca.mcgill.sel.classdiagram.CDString;
import ca.mcgill.sel.classdiagram.CDVoid;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.classdiagram.NamedElement;

/**
 * Utility class for TouchCORE class diagrams and their contents.
 *
 * @author Prabhsimran Singh
 * @author Younes Boubekeur
 *
 * @generated NOT
 */
public class ClassDiagramUtils {

  /**
   * Returns a classifier from a class diagram based on class name.
   *
   * @param className
   * @param classDiagram
   * @return Classifier
   */
  public static Classifier getClassFromClassDiagram(String className, ClassDiagram classDiagram) {
    Classifier cls = null;
    for (var c : classDiagram.getClasses()) {
      if (className.equals(c.getName())) {
        cls = c;
        break;
      }
    }
    if (cls == null) {
      throw new IllegalArgumentException("No class found with name " + className);
    }
    return cls;
  }

  /**
   * Returns an attribute from a class based on attribute name.
   */
  public static Attribute getAttributeFromClass(String attributeName, Classifier givenClass) {
    Attribute attribute = null;
    for (var a : givenClass.getAttributes()) {
      if (attributeName.equals(a.getName())) {
        attribute = a;
        break;
      }
    }
    if (attribute == null) {
      throw new IllegalArgumentException("Attribute " + attributeName + " not found in class " + givenClass.getName());
    }
    return attribute;
  }

  /**
   * Returns an attribute from a class based on attribute type.
   */
  public static Attribute getAttributeFromType(String attributeType, ClassDiagram cdm) {
    Attribute attribute = null;
    for (Classifier givenClass : cdm.getClasses()) {
      for (var a : givenClass.getAttributes()) {
        if (attributeType.equals(a.getType().getName())) {
          attribute = a;
          break;
        }
      }
    }
    if (attribute == null) {
      throw new IllegalArgumentException("Attribute with " + attributeType + " not found in cdm");
    }
    return attribute;
  }

  /**
   * Returns the attribute with the given name and class name from the given diagram.
   */
  public static Attribute getAttributeFromDiagram(String className, String attributeName, ClassDiagram classDiagram) {
    return getAttributeFromClass(attributeName, getClassFromClassDiagram(className, classDiagram));
  }

  /**
   * Returns the associations, aggregation or composition between 2 classes from a class diagram.
   */
  public static List<Association> getAssocAggCompFromClassDiagram(Classifier class1, Classifier class2,
      ClassDiagram classDiagram) {
    List<Association> associations = new BasicEList<Association>();
    for (var assoc : classDiagram.getAssociations()) {
      if (assoc.getName().contains(class1.getName()) && assoc.getName().contains(class2.getName())) {
        associations.add(assoc);
      }
    }
    return associations;
  }

  /**
   * Returns an association end of a class based on association end name.
   */
  public static AssociationEnd getAssociationEndFromClass(String associationEndName, Classifier givenClass) {
    AssociationEnd associationEnd = null;
    for (var ae : givenClass.getAssociationEnds()) {
      if (associationEndName.equals(ae.getName())) {
        associationEnd = ae;
      }
    }
    if (associationEnd == null) {
      throw new IllegalArgumentException("No association end with name " + associationEndName + " found for the class "
          + givenClass.getName());
    }
    return associationEnd;
  }

  /**
   * Returns the NamedElements in the given class diagram by name.
   */
  public static List<NamedElement> getElementsFromClassDiagram(ClassDiagram classDiagram, String... names) {
    var nameList = Arrays.asList(names);
    var elements = new ArrayList<NamedElement>();
    classDiagram.eAllContents().forEachRemaining(e -> {
      if (e instanceof NamedElement) {
        var ne = (NamedElement) e;
        if (!isCdType(ne) && nameList.contains(ne.getName())) {
          elements.add(ne);
        }
      }
    });
    return elements;
  }

  /** Returns true if the given element is a CDType. */
  private static boolean isCdType(NamedElement element) {
    return Stream.of(CDVoid.class, CDAny.class, CDBoolean.class, CDDouble.class, CDInt.class, CDLong.class,
        CDString.class, CDByte.class, CDFloat.class, CDChar.class).anyMatch(cdt -> cdt.isInstance(element));
  }

  /**
   * Returns an enumeration from class diagram.
   */
  public static CDEnum getEnumFromClassDiagram(String name, ClassDiagram classDiagram) {
    return (CDEnum) classDiagram.getTypes().stream()
        .filter(type -> type instanceof CDEnum && type.getName().equals(name)).findFirst().orElse(null);
  }

  /**
   * Returns an enumeration Literal from enumeration.
   */
  public static CDEnumLiteral getEnumLiteralFromEnum(String name, CDEnum Enum) {
    return Enum.getLiterals().stream()
        .filter(type -> type.getName().equals(name)).findFirst().orElse(null);
  }

}
