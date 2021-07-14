package ca.mcgill.sel.mistakedetection;

/**
 * Mistake detection configuration.
 */
public class MistakeDetectionConfig {

  /** The path of the tagger. It is not final since it needs to be changed by the web app. */
  public static String taggerPath = "taggers/english-bidirectional-distsim.tagger";

}
