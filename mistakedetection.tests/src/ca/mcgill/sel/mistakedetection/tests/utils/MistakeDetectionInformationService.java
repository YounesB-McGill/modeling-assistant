package ca.mcgill.sel.mistakedetection.tests.utils;

public /*abstract*/ class MistakeDetectionInformationService {

  private static final String ERROR = "This method must be treated as abstract and can only be invoked on a subclass! "
      + "If a subclass is defined, ensure it overrides this method.";

  public final String title;

  public MistakeDetectionInformationService(String title) {
    this.title = title;
  }

  public /*abstract*/ String getOutput() {
    uoe();
    return null;
  }

  /**
   * Returns an instance of this class. Subclasses must override this method without the annotation since it is static.
   */
  public static /*abstract*/ MistakeDetectionInformationService get() {
    uoe();
    return null;
  }

  /** Needed to get around Java compiler limitations. */
  private static void uoe() {
    throw new UnsupportedOperationException(ERROR);
  }

}
