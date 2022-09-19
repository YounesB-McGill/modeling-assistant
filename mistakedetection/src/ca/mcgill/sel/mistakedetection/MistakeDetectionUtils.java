package ca.mcgill.sel.mistakedetection;

import static ca.mcgill.sel.classdiagram.ReferenceType.AGGREGATION;
import static ca.mcgill.sel.classdiagram.ReferenceType.COMPOSITION;
import static ca.mcgill.sel.classdiagram.ReferenceType.REGULAR;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.CDDouble;
import ca.mcgill.sel.classdiagram.CDFloat;
import ca.mcgill.sel.classdiagram.CDInt;
import ca.mcgill.sel.classdiagram.CDLong;
import ca.mcgill.sel.classdiagram.NamedElement;
import ca.mcgill.sel.classdiagram.ReferenceType;
import learningcorpus.MistakeType;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.SolutionElement;

/**
 * This class contains the helper functions used in the MistakeDetection class.
 *
 * @author Prabhsimran Singh
 */
public class MistakeDetectionUtils {


  public static boolean isRoleNameExpectedStatic(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return !studentClassAssocEnd.isStatic() && instructorClassAssocEnd.isStatic();
  }

  public static boolean isRoleNameNotExpectedStatic(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return studentClassAssocEnd.isStatic() && !instructorClassAssocEnd.isStatic();
  }

  /** Returns true if association class is extra. */
  public static boolean isAssociationClassExtra(Association studentClassAssoc, Association instructorClassAssoc) {
    return studentClassAssoc.getAssociationClass() != null && instructorClassAssoc.getAssociationClass() == null;
  }

  /** Returns true if association class is missing. */
  public static boolean isAssociationClassMissing(Association studentClassAssoc, Association instructorClassAssoc) {
    return studentClassAssoc.getAssociationClass() == null && instructorClassAssoc.getAssociationClass() != null;
  }

  /** Returns true if the student has made attribute not static but static is required. */
  public static boolean isAttributeExpectedStatic(Attribute studentAttribute, Attribute instructorAttribute) {
    return !studentAttribute.isStatic() && instructorAttribute.isStatic();
  }

  /** Returns true if the student has made attribute static but static is not required. */
  public static boolean isAttributeNotExpectedStatic(Attribute studentAttribute, Attribute instructorAttribute) {
    return studentAttribute.isStatic() && !instructorAttribute.isStatic();
  }

  public static boolean isUsingAssociationInsteadOfComposition(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, REGULAR, COMPOSITION);
  }

  public static boolean isUsingAssociationInsteadOfAggregation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, REGULAR, AGGREGATION);
  }

  public static boolean isUsingCompositionInsteadOfAssociation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, COMPOSITION, REGULAR);
  }

  public static boolean isUsingAggregationInsteadOfAssociation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, AGGREGATION, REGULAR);
  }

  public static boolean isUsingAggregationInsteadOfComposition(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, AGGREGATION, COMPOSITION);
  }

  public static boolean isUsingCompositionInsteadOfAggregation(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, COMPOSITION, AGGREGATION);
  }

  public static boolean isUsingDirectedInsteadOfUndirected(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return instructorClassAssocEnd.isNavigable() && !studentClassAssocEnd.isNavigable();
  }

  public static boolean isUsingUndirectedInsteadOfDirected(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return !instructorClassAssocEnd.isNavigable() && studentClassAssocEnd.isNavigable();
  }

  public static boolean associationEndAssociationPropertyMatch(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndsMatchType(studentClassAssocEnd, instructorClassAssocEnd, REGULAR, REGULAR);
  }

  /** Returns true if both association ends have the same reference type. */
  public static boolean associationEndsMatchType(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return studentClassAssocEnd.getReferenceType() == instructorClassAssocEnd.getReferenceType();
  }

  /** Returns true if both association ends match the given reference type or not. */
  public static boolean associationEndsMatchType(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd, ReferenceType assocTypeS, ReferenceType assocTypeI) {
    return studentClassAssocEnd.getReferenceType() == assocTypeS
        && instructorClassAssocEnd.getReferenceType() == assocTypeI;
  }

  public static boolean associationEndMultiplicityMatch(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return associationEndMultiplicityLowerBoundsMatch(studentClassAssocEnd, instructorClassAssocEnd)
        && associationEndMultiplicityUpperBoundsMatch(studentClassAssocEnd, instructorClassAssocEnd);
  }

  public static boolean associationEndMultiplicityLowerBoundsMatch(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return studentClassAssocEnd.getLowerBound() == instructorClassAssocEnd.getLowerBound();
  }

  public static boolean associationEndMultiplicityUpperBoundsMatch(AssociationEnd studentClassAssocEnd,
      AssociationEnd instructorClassAssocEnd) {
    return studentClassAssocEnd.getUpperBound() == instructorClassAssocEnd.getUpperBound();
  }

  public static boolean isRoleNameMissing(AssociationEnd studentClassAssocEnd, AssociationEnd instructorClassAssocEnd) {
    return studentClassAssocEnd.getName().isEmpty() && !instructorClassAssocEnd.getName().isEmpty();
  }

  public static boolean isLowerName(String name) {
    return name.toLowerCase() == name;
  }

  public static boolean startsWithUppercase(String name) {
    return Character.isUpperCase(name.charAt(0));
  }

  public static boolean attributeTypesMatch(Attribute studentAttribute, Attribute instructorAttribute) {
    if (!studentAttribute.getType().getClass().equals(instructorAttribute.getType().getClass())) {
      if ((instructorAttribute.getType() instanceof CDInt || instructorAttribute.getType() instanceof CDFloat
          || instructorAttribute.getType() instanceof CDDouble
          || instructorAttribute.getType() instanceof CDLong)
          && (studentAttribute.getType() instanceof CDFloat || studentAttribute.getType() instanceof CDLong
              || studentAttribute.getType() instanceof CDDouble
              || studentAttribute.getType() instanceof CDInt)) {
        return true;
      }
      return false;
    }
    return true;
  }

  public static final ModelingassistantFactory MAF = ModelingassistantFactory.eINSTANCE;

  /**
   * Creates a new mistake from the input parameters.
   *
   * @param mistakeType
   * @param studentElement
   * @param instructorElement
   */
  public static Mistake createMistake(MistakeType mistakeType, NamedElement studentElement,
      NamedElement instructorElement) {
    List<NamedElement> studentElements = studentElement == null ? Collections.emptyList() : List.of(studentElement);
    List<NamedElement> instElements = instructorElement == null ? Collections.emptyList() : List.of(instructorElement);
    return createMistake(mistakeType, studentElements, instElements);
  }

  /**
   * Creates a new mistake from the input parameters.
   *
   * @param mistakeType
   * @param studentElements
   * @param instructorElements
   */
  public static Mistake createMistake(MistakeType mistakeType, List<? extends NamedElement> studentElements,
      List<? extends NamedElement> instructorElements) {
    var mistake = MAF.createMistakeOfType(mistakeType);
    if (studentElements != null) {
      studentElements.forEach(se -> {
        var solutionElement = SolutionElement.forCdmElement(se);
        mistake.getStudentElements().add(solutionElement);
      });
    }
    if (instructorElements != null) {
      instructorElements.forEach(ie -> {
        var solutionElement = SolutionElement.forCdmElement(ie);
        mistake.getInstructorElements().add(solutionElement);
      });
    }
    return mistake;
  }

  public static void showMistakes(List<Mistake> mistakes) {
    for (Mistake m : mistakes) {
      System.out.println(m.getMistakeType().getName() + " in " + m.getStudentElements().get(0).getElement().getName());
    }
  }

  /** Returns the XMI ID for an EObject as a string, if present. */
  public static String xmiId(EObject eObject) {
    if (eObject == null) {
      return null;
    }
    var id = EcoreUtil.getID(eObject);

    if (id == null) {
      if (eObject.eResource() == null) {
        var s = eObject.toString();
        id = s.substring(s.lastIndexOf('#') + 1, s.lastIndexOf(')'));
      } else {
        // from eclipse.org/forums/index.php?t=msg&th=403365&goto=944954&#msg_944954
        id = eObject.eResource().getURIFragment(eObject);
      }
    }
    return id;
  }

}
