package ca.mcgill.sel.mistakedetection.tests.utils.dataclasses;
import static ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.CdmMetatype.AGGR;
import static ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.CdmMetatype.ASSOC;
import static ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.CdmMetatype.CLS;
import static ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.CdmMetatype.COMPOS;
import static ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.CdmMetatype.REL;
import static ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.CdmMetatype.ROLE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ca.mcgill.sel.mistakedetection.tests.utils.HumanValidatedMistakeElementGroups;
import modelingassistant.Mistake;

/**
 * Represents the format used by the Mistake Detection System to report the student and instructor elements associated
 * to a mistake of a certain type.
 *
 * @author Younes Boubekeur
 * @author Prabhsimran Singh
 */
public class MistakeElementGroup {

  public final List<String> stud = new ArrayList<>();
  public final List<String> inst = new ArrayList<>();

  /** The empty mistake detection format, ([], []). Note that an empty MEG is semantically invalid. */
  public static final MistakeElementGroup EMPTY_MEG = emptyGroup();

  static final Map<CdmMetatype, CdmMetatype> typesToReplacements = Map.of(
      AGGR, ASSOC,
      COMPOS, ASSOC,
      REL, ASSOC,
      ROLE, CLS);

  public MistakeElementGroup(Mistake mistake) {
    int[] cnt = {0, 0};
    mistake.getStudentElements().forEach(e -> stud.add(ElementDescription.fromElement(e).toShortString(cnt[0]++)));
    mistake.getInstructorElements().forEach(e -> inst.add(ElementDescription.fromElement(e).toShortString(cnt[1]++)));
    if (stud.size() == 1) {
      stud.set(0, stud.get(0).replace("0_", ""));
    }
    if (inst.size() == 1) {
      inst.set(0, inst.get(0).replace("0_", ""));
    }
  }

  public MistakeElementGroup(MistakeInfo mistakeInfo) {
    this(mistakeInfo.mistake);
  }

  private MistakeElementGroup(List<String> studentElemsDescriptions, List<String> instructorElemsDescriptions) {
    stud.addAll(studentElemsDescriptions);
    inst.addAll(instructorElemsDescriptions);
  }

  public static MistakeElementGroup forMistake(Mistake mistake) {
    return HumanValidatedMistakeElementGroups.mappings.getOrDefault(mistake.getMistakeType(),
        new MistakeElementGroup(mistake));
  }

  public static MistakeElementGroup forMistakeInfo(MistakeInfo mistakeInfo) {
    return forMistake(mistakeInfo.mistake);
  }

  public static MistakeElementGroup meg(List<String> studentElemsDescriptions,
      List<String> instructorElemsDescriptions) {
    return new MistakeElementGroup(studentElemsDescriptions, instructorElemsDescriptions);
  }

  /**
   * Returns an empty mistake detection format, which is semantically invalid. To avoid creating needless instances of
   * an empty MEG, use the EMPTY_MEG constant instead.
   */
  public static MistakeElementGroup emptyGroup() {
    return new MistakeElementGroup(Collections.emptyList(), Collections.emptyList());
  }

  public MistakeElementGroup.Shape shape() {
    return new MistakeElementGroup.Shape(this);
  }

  public String studAsString() {
    return listAsString(stud);
  }

  public String instAsString() {
    return listAsString(inst);
  }

  private String listAsString(List<String> list) {
    if (list.isEmpty()) {
      return "[]";
    }
    return "[\"" + String.join("\", \"", list) + "\"]";
  }

  // eg, ([], ["cls"])
  @Override public String toString() {
    return "(" + studAsString() + ", " + instAsString() + ")";
  }

  @Override public boolean equals(Object o) {
    if (!(o instanceof MistakeElementGroup)) {
      return false;
    }
    var other = (MistakeElementGroup) o;
    return stud.equals(other.stud) && inst.equals(other.inst);
  }

  @Override public int hashCode() {
    return 17 * stud.hashCode() + 31 * inst.hashCode();
  }

  /** The shape of the mistake detection format, which is the lists of its student and instructor metatypes. */
  public static class Shape extends MistakeElementGroup {

    public Shape(MistakeElementGroup meg) {
      super(mapToShape(meg.stud), mapToShape(meg.inst));
    }

    /** Maps type lists, eg, ["compos", "cls", "cls", "cls"] -> ["compos", "cls*"]. */
    static List<String> mapToShape(List<String> elems) {
      var types = elems.stream().map(e -> {
        var splitElem = e.split("_");
        return splitElem[splitElem.length - 1]; // return the type, eg, cls
      }).collect(Collectors.toUnmodifiableList());
      /*
       * Working backwards, collapse duplicate types into one vararg type with a *, for example:
       *
       * ["compos", "cls", "cls", "cls"] -> ["compos", "cls", "cls*"] -> ["compos", "cls*"]
       */
      List<String> shape = new ArrayList<>(types);
      int i = types.size() - 1;
      while (i > 0) {
        var first = shape.get(i - 1);
        var second = shape.get(i);
        if (first.equals(second.replace("*", ""))) {
          shape.set(i - 1, first + "*");
          shape.remove(i);
        } else {
          break;
        }
        i--;
      }
      return shape;
    }

    /**
     * Reduces the MEG shape to its simplest form, where convenience CDM metatypes like role and compos are replaced
     * with their concrete equivalents.
     */
    public MistakeElementGroup.Shape reduceToSimplestForm() {
      return new Shape(meg(simplify(stud), simplify(inst)));
    }

    private static List<String> simplify(List<String> elems) {
      return simplify(elems, true);
    }

    private static List<String> simplify(List<String> elems, boolean keepStar) {
      return elems.stream().map(e -> {
        var eNoStar = e.replace("*", "");
        var type = CdmMetatype.withName(eNoStar);
        var replacement = e.replace(eNoStar, typesToReplacements.getOrDefault(type, type).shortName);
        if (keepStar) {
          return replacement;
        }
        return replacement.replace("*", "");
      }).collect(Collectors.toUnmodifiableList());
    }

    /** Returns true if the shape's simplest form is equal to that of the input. */
    public boolean isCompatibleWith(MistakeElementGroup.Shape shape) {
      return equals(shape) || reduceToSimplestForm().equals(shape.reduceToSimplestForm())
          || matchesVarargsOf(shape);
    }

    public boolean matchesVarargsOf(MistakeElementGroup.Shape shape) {
      return varargsMatch(stud, shape.stud) && varargsMatch(inst, shape.inst);
    }

    private static boolean varargsMatch(List<String> list1, List<String> list2) {
      if (list1.equals(list2)) {
        return true;
      }
      if (list1.size() * list2.size() == 0) {
        return false; // exactly one of the lists is empty, so it cannot have matching varargs
      }
      return simplify(mapToShape(list1), false).equals(simplify(mapToShape(list2), false));
    }

    @Override public boolean equals(Object o) {
      if (!(o instanceof MistakeElementGroup.Shape)) {
        return false;
      }
      var other = (MistakeElementGroup.Shape) o;
      return stud.equals(other.stud) && inst.equals(other.inst);
    }

  }

}
