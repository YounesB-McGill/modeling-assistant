package ca.mcgill.sel.mistakedetection.tests.utils.dataclasses;

import java.util.Map;
import java.util.TreeMap;
import learningcorpus.MistakeType;
import modelingassistant.Mistake;

// TODO Under construction
public class MistakeTypeInfo {

  private static final Map<MistakeType, MistakeTypeInfo> instancesByMistakeType = new TreeMap<>(); // ordered map

  public MistakeTypeInfo(Mistake mistake) {}

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

}
