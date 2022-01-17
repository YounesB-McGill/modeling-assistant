package ca.mcgill.sel.mistakedetection;

/**
 * Mistake detection configuration.
 */
public class MistakeDetectionConfig {

  /** The path of the tagger. It is not final since it needs to be changed by the web app. */
  public static String taggerPath = "taggers/bidirectional-distsim-wsj-0-18.tagger";

  /** Flag to determine if Comparison instances should be tracked, eg, in the MistakeTypesToLearningItemsMapper. */
  public static boolean trackComparisonsInstances = false;

}
