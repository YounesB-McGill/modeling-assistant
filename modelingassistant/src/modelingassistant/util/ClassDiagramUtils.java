package modelingassistant.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import org.eclipse.emf.common.util.BasicEList;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.CDAny;
import ca.mcgill.sel.classdiagram.CDBoolean;
import ca.mcgill.sel.classdiagram.CDByte;
import ca.mcgill.sel.classdiagram.CDChar;
import ca.mcgill.sel.classdiagram.CDDouble;
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
      if (className.equals(c.getName()))
        cls = c;
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
      }
    }
    if (attribute == null) {
      throw new IllegalArgumentException("Attribute " + attributeName + " not found in class " + givenClass.getName());
    }
    return attribute;
  }

  /**
   * Returns the associations between 2 classes from a class diagram.
   */
  public static List<Association> getAssociationsFromClassDiagram(Classifier class1, Classifier class2,
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

  public static List<NamedElement> getElementsFromClassDiagram(ClassDiagram classDiagram, String... names) {
    final var cdTypes = List.of(CDVoid.class, CDAny.class, CDBoolean.class, CDDouble.class, CDInt.class, CDLong.class,
        CDString.class, CDByte.class, CDFloat.class, CDChar.class);
    Predicate<NamedElement> isCdType = e -> cdTypes.stream().anyMatch(cdt -> cdt.isInstance(e));
    var nameList = Arrays.asList(names);
    var elements = new ArrayList<NamedElement>();
    classDiagram.eAllContents().forEachRemaining(e -> {
      if (e instanceof NamedElement) {
        var ne = (NamedElement) e;
        if (!isCdType.test(ne) && nameList.contains(ne.getName())) {
          elements.add(ne);
        }
      }
    });
    return elements;
  }

}
