package ca.mcgill.sel.mistakedetection.tests.utils.dataclasses;

import java.util.Map;
import java.util.TreeMap;
import learningcorpus.MistakeType;
import modelingassistant.Mistake;

/** Wrapper class for a MistakeType instance. */
public class MistakeTypeInfo implements Comparable<MistakeTypeInfo> {

  public final MistakeType mistakeType;
  public final MistakeInfo mistakeInfo;
  public final Mistake mistake;

  private static final Map<MistakeType, MistakeTypeInfo> instancesByMistakeType = new TreeMap<>(); // ordered map

  public MistakeTypeInfo(MistakeInfo mistakeInfo) {
    this.mistakeType = mistakeInfo.mistakeType;
    this.mistakeInfo = mistakeInfo;
    this.mistake = mistakeInfo.mistake;
  }

  public static MistakeTypeInfo get(Mistake mistake) {
    var mt = mistake.getMistakeType();
    if (!instancesByMistakeType.containsKey(mt)) {
      instancesByMistakeType.put(mt, new MistakeTypeInfo(new MistakeInfo(mistake)));
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
