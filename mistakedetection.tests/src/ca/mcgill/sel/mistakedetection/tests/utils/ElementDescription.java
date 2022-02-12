package ca.mcgill.sel.mistakedetection.tests.utils;
import static ca.mcgill.sel.mistakedetection.tests.utils.MistakeDetectionInformationServicesForLearningCorpus.hasStudent;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import ca.mcgill.sel.classdiagram.CdmFactory;
import modelingassistant.SolutionElement;

/** Container class for an element description. */
public class ElementDescription {

  /** Shorthand for CdmFactory.eINSTANCE. */
  private static final CdmFactory CDF = CdmFactory.eINSTANCE;

  String name;
  EClass eClass;
  boolean hasStudent;
  String description = "";

  static final Map<EClass, String> eClassesToShortDisplayNames = Map.of(
      CDF.createAssociationEnd().eClass(), "assocend",
      CDF.createAssociation().eClass(), "rel", // includes composition and aggregation
      CDF.createAttribute().eClass(), "attr",
      CDF.createCDEnum().eClass(), "enum",
      CDF.createCDEnumLiteral().eClass(), "enumitem",
      CDF.createClass().eClass(), "cls");

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
  }

  public static ElementDescription fromElement(SolutionElement element) {
    return new ElementDescription(element);
  }

  // eg, "Student Container Class (name: Airplane)"
  @Override public String toString() {
    return (hasStudent ? "Student" : "Instructor") + " " + (description.isEmpty() ? "" : description + " ")
        + eClass.getName() + " (name: " + name + ")";
  }

  // eg, "container_class"
  public String toShortString(int count) {
    return ((description.isEmpty() ? count : description) + "_"
        + eClassesToShortDisplayNames.get(eClass).toString()).toLowerCase(); // trigger NPE for missing eClass
  }

  public String toShortString() {
    return toShortString(0);
  }

}
