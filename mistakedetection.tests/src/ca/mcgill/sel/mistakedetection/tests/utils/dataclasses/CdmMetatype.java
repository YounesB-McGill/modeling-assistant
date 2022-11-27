package ca.mcgill.sel.mistakedetection.tests.utils.dataclasses;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.eclipse.emf.ecore.EClass;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.CdmFactory;
import ca.mcgill.sel.classdiagram.NamedElement;
import ca.mcgill.sel.classdiagram.ReferenceType;

/**
 * Helper enum for the TouchCORE Class Diagram metamodel types. In the future, this class may be moved elsewhere.
 */
public enum CdmMetatype {
  AGGR("aggr", "Aggregation", CdmFactory.eINSTANCE.createAssociation().eClass()),
  ASSOC("assoc", "Association", CdmFactory.eINSTANCE.createAssociation().eClass()),
  ASSOCEND("assocend", "Association End", CdmFactory.eINSTANCE.createAssociationEnd().eClass()),
  ATTR("attr", "Attribute", CdmFactory.eINSTANCE.createAttribute().eClass()),
  CLS("cls", "Class", CdmFactory.eINSTANCE.createClass().eClass()),
  COMPOS("compos", "Composition", CdmFactory.eINSTANCE.createAssociation().eClass()),
  ENUM("enum", "Enumeration", CdmFactory.eINSTANCE.createCDEnum().eClass()),
  ENUMITEM("enumitem", "Enumeration Item", CdmFactory.eINSTANCE.createCDEnumLiteral().eClass()),
  QUALASSOC("qualassoc", "Qualified Association", CdmFactory.eINSTANCE.createAssociation().eClass()),
  ROLE("role", "Role", List.of(CdmFactory.eINSTANCE.createAssociationEnd().eClass(),
      CdmFactory.eINSTANCE.createCDEnumLiteral().eClass(), CdmFactory.eINSTANCE.createClass().eClass())),
  REL("rel", "Relationship", CdmFactory.eINSTANCE.createAssociation().eClass());

  static {
    REL.canBeA(ASSOC);
    ASSOC.canBeA(AGGR, COMPOS, QUALASSOC);
    ROLE.canBeA(ASSOCEND, CLS, ENUMITEM);
  }

  public final String shortName;
  public final String longName;
  public final EClass eClass;
  public final List<EClass> eClasses;
  private final Set<CdmMetatype> possibleTypes = new HashSet<>();
  private static final Map<EClass, CdmMetatype> eClassesToCdmMetatypes = new HashMap<>();

  private CdmMetatype(String shortName, String longName, EClass eClass) {
    this.shortName = shortName;
    this.longName = longName;
    this.eClass = eClass;
    eClasses = List.of(eClass);
  }

  private CdmMetatype(String shortName, String longName, List<EClass> eClasses) {
    this.shortName = shortName;
    this.longName = longName;
    eClass = eClasses.get(0);
    this.eClasses = eClasses;
  }

  /** Recursively return all the possible CdmMetatypes that this type can take on. */
  public Set<CdmMetatype> getPossibleTypes() {
    var types = possibleTypes;
    for (var type : possibleTypes) {
      types.addAll(type.getPossibleTypes()); // recursive call
    }
    return types;
  }

  /**
   * Returns true if and only if this type may or may not be the given type, ie, this type can be narrowed to the given
   * type. In other words, the given type can be widened to this type. For example:<br>
   *
   * <pre>
   * CLS.canBeOfType(CLS) -> true
   * REL.canBeOfType(ASSOC) -> true
   * REL.canBeOfType(COMPOS) -> true
   * ROLE.canBeOfType(CLS) -> true
   * COMPOS.canBeOfType(ASSOC) -> false, since a composition must be an association
   * </pre>
   */
  public boolean canBeOfType(CdmMetatype type) {
    if (type == this) {
      return true;
    }
    return getPossibleTypes().contains(type);
  }

  /** Returns the CdmMetatype with the given name, eg, CdmMetatype.withName("cls") = CLS. */
  public static CdmMetatype withName(String shortName) {
    return CdmMetatype.valueOf(shortName.toUpperCase());
  }

  /** Returns the CdmMetatype with the given eClass, eg, CdmMetatype.withEClass(Classifier) = CLS. */
  public static CdmMetatype withEClass(EClass eClass) {
    if (eClassesToCdmMetatypes.containsKey(eClass)) {
      return eClassesToCdmMetatypes.get(eClass);
    }
    for (var type : CdmMetatype.values()) {
      if (type.eClass.equals(eClass)) {
        eClassesToCdmMetatypes.put(eClass, type);
        return type;
      }
    }
    return null; // should not happen
  }

  /** Returns the CdmMetatype with the given NamedElement, eg, CdmMetatype.forNamedElement(composition) = COMPOS. */
  public static CdmMetatype forNamedElement(NamedElement element) {
    if (element instanceof Association) {
      // use pattern matching in Java 17+
      var refTypes = ((Association) element).getEnds().stream().map(AssociationEnd::getReferenceType)
          .collect(Collectors.toUnmodifiableSet());
      if (refTypes.contains(ReferenceType.AGGREGATION)) {
        return AGGR;
      } else if (refTypes.contains(ReferenceType.COMPOSITION)) {
        return COMPOS;
      } else if (refTypes.contains(ReferenceType.QUALIFIED)) {
        return QUALASSOC;
      }
    }
    return withEClass(element.eClass());
  }

  private CdmMetatype canBeA(CdmMetatype... types) {
    possibleTypes.addAll(Arrays.asList(types));
    return this;
  }

}
