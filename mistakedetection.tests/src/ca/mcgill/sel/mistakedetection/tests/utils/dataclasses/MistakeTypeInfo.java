package ca.mcgill.sel.mistakedetection.tests.utils.dataclasses;

import java.util.Map;
import java.util.TreeMap;
import learningcorpus.MistakeType;
import modelingassistant.Mistake;

/** Wrapper class for a MistakeType instance. */
public class MistakeTypeInfo implements Comparable<MistakeTypeInfo> {

  public final MistakeType mistakeType;
  public MistakeInfo mistakeInfo; // only available if created from a MistakeInfo
  public Mistake mistake; // only available if created from a Mistake or MistakeInfo

  private static final Map<MistakeType, MistakeTypeInfo> instancesByMistakeType = new TreeMap<>(); // ordered map

  public MistakeTypeInfo(MistakeInfo mistakeInfo) {
    this(mistakeInfo.mistake);
    this.mistakeInfo = mistakeInfo;
  }

  public MistakeTypeInfo(Mistake mistake) {
    this(mistake.getMistakeType());
    this.mistake = mistake;
  }

  public MistakeTypeInfo(MistakeType mistakeType) {
    this.mistakeType = mistakeType;
  }

  public static MistakeTypeInfo get(Mistake mistake) {
    var mt = mistake.getMistakeType();
    if (!instancesByMistakeType.containsKey(mt)) {
      instancesByMistakeType.put(mt, new MistakeTypeInfo(mistake));
    }
    return get(mt);
  }

  public static MistakeTypeInfo get(MistakeType mistakeType) {
    if (!instancesByMistakeType.containsKey(mistakeType)) {
      throw new IllegalArgumentException("Cannot get MistakeTypeInfo instance for mistake type "
          + mistakeType.getName() + " because no mistakes of that type have been processed yet.");
    }
    return instancesByMistakeType.get(mistakeType);
  }

  // For now, only allow one MistakeTypeInfo per MistakeType

  @Override public boolean equals(Object o) {
    if (o instanceof MistakeTypeInfo) {
      var mti = (MistakeTypeInfo) o;
      return mistakeType.equals(mti.mistakeType);
    }
    return false;
  }

  @Override public int hashCode() {
    return mistakeType.hashCode();
  }

  @Override public int compareTo(MistakeTypeInfo other) {
    return mistakeType.compareTo(other.mistakeType);
  }

}
