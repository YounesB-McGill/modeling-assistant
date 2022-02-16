package ca.mcgill.sel.mistakedetection.tests.utils.dataclasses;

import static ca.mcgill.sel.mistakedetection.tests.utils.MistakeDetectionInformationServicesForLearningCorpus.warn;
import static ca.mcgill.sel.mistakedetection.tests.utils.infoservice.MistakeDetectionInformationService.hasStudent;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.CdmFactory;
import ca.mcgill.sel.classdiagram.NamedElement;
import ca.mcgill.sel.classdiagram.ReferenceType;
import modelingassistant.SolutionElement;

/** Container class for a solution element description. */
public class ElementDescription {

  /** Shorthand for CdmFactory.eINSTANCE. */
  private static final CdmFactory CDF = CdmFactory.eINSTANCE;

  String name;
  EClass eClass;
  boolean hasStudent;
  String description = "";
  NamedElement cdmElement;

  static final Map<EClass, String> eClassesToShortDisplayNames = Map.of(
      CDF.createAssociationEnd().eClass(), "assocend",
      CDF.createAssociation().eClass(), "rel", // includes composition and aggregation
      CDF.createAttribute().eClass(), "attr",
      CDF.createCDEnum().eClass(), "enum",
      CDF.createCDEnumLiteral().eClass(), "enumitem",
      CDF.createClass().eClass(), "cls");

  static final Map<ReferenceType, String> specialAssocRefTypes = Map.of(
      ReferenceType.COMPOSITION, "compos",
      ReferenceType.AGGREGATION, "aggr",
      ReferenceType.QUALIFIED, "qualassoc");

  public ElementDescription(String name, EClass eClass, boolean hasStudent) {
    this.name = name;
    this.eClass = eClass;
    this.hasStudent = hasStudent;
  }

  public ElementDescription(String name, EClass eClass, boolean hasStudent, String description) {
    this(name, eClass, hasStudent);
    this.description = description;
  }

  public ElementDescription(SolutionElement element) {
    this(element.getElement().getName(), element.getElement().eClass(), hasStudent(element));
    this.cdmElement = element.getElement();
  }

  public static ElementDescription fromElement(SolutionElement element) {
    return new ElementDescription(element);
  }

  // eg, "Student Container Class (name: Airplane)"
  @Override public String toString() {
    return (hasStudent ? "Student" : "Instructor") + " " + (description.isEmpty() ? "" : description + " ")
        + eClass.getName() + " (name: " + name + ")";
  }

  // eg, "container_cls"
  public String toShortString(int count) {
    return ((description.isEmpty() ? count : description) + "_" + getShortDisplayName(eClass)).toLowerCase();
  }

  public String toShortString() {
    return toShortString(0);
  }

  private String getShortDisplayName(EClass eClass) {
    final var unknown = "unknown";
    var shortName = eClassesToShortDisplayNames.getOrDefault(eClass, unknown);
    // special cases
    if (cdmElement instanceof Association) {
      return assocShortDisplayName((Association) cdmElement);
    }
    if (cdmElement instanceof AssociationEnd) {
      return assocEndShortDisplayName((AssociationEnd) cdmElement);
    }
    if (shortName.equals(unknown)) {
      warn("Short display name not found for eClass " + eClass);
    }
    return shortName;
  }

  private String assocShortDisplayName(Association assoc) {
    for (var ae: assoc.getEnds()) {
      if (specialAssocRefTypes.containsKey(ae.getReferenceType())) {
        return specialAssocRefTypes.get(ae.getReferenceType());
      }
    }
    return "assoc";
  }

  private String assocEndShortDisplayName(AssociationEnd ae) {
    if (specialAssocRefTypes.containsKey(ae.getReferenceType())) {
      return specialAssocRefTypes.get(ae.getReferenceType());
    }
    return "assocend";
  }

  @Override public boolean equals(Object o) {
    if (!(o instanceof ElementDescription)) {
      return false;
    }
    var other = (ElementDescription) o;
    if ((cdmElement == null && other.cdmElement != null) || (cdmElement != null && other.cdmElement == null)
        || (cdmElement != null && !cdmElement.equals(other.cdmElement))) {
      return false;
    }
    return List.of(name, eClass, hasStudent, description)
        .equals(List.of(other.name, other.eClass, other.hasStudent, other.description));
  }

  @Override public int hashCode() {
    var cdmElem = cdmElement == null ? "" : cdmElement;
    return List.of(name, eClass, hasStudent, description, cdmElem).hashCode();
  }

}
