package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import ca.mcgill.sel.mistakedetection.tests.utils.Color;
import ca.mcgill.sel.mistakedetection.tests.utils.dataclasses.MistakeInfo;
import learningcorpus.MistakeType;

public class MappingToMistakeInfos extends MistakeDetectionInformationService {

  private MappingToMistakeInfos() {
    super("MistakeInfo statistics for each detected mistake");
  }

  @Override public String getOutput() {
    return title(name) + "\n" + mistakeTypeElementVsParametrizedStringStatistics(mapToMistakeInfos());
  }

  public static MappingToMistakeInfos get() {
    return new MappingToMistakeInfos();
  }

  /** Maps comparison mistakes to MistakeInfo instances. */
  public static Map<MistakeType, Set<MistakeInfo>> mapToMistakeInfos() {
    return allMistakes().collect(Collectors.toMap(
        m -> m.getMistakeType(),
        m -> Set.of(new MistakeInfo(m)),
        MistakeDetectionInformationService::setUnion,
        TreeMap::new));
  }

  private static String mistakeTypeElementVsParametrizedStringStatistics(
      Map<MistakeType, ? extends Collection<MistakeInfo>> mapping) {
    return MistakeInfo.TABLE_HEADER + mapping.entrySet().stream().map(e -> e.getValue().stream()
        .map(Color::randomColorString).collect(Collectors.joining("\n"))).collect(Collectors.joining("\n"));
  }

}
