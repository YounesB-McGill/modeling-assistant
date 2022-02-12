package ca.mcgill.sel.mistakedetection.tests.utils.infoservice;

import ca.mcgill.sel.mistakedetection.tests.utils.Color;

/** Simple class to demonstrate color output demo (requires ANSI escaping). */
public class ColorDemo extends MistakeDetectionInformationService {

  public ColorDemo() {
    super("Color output demo (requires ANSI escaping)");
  }

  @Override public String getOutput() {
    return title(name) + "\n" + Color.demo();
  }

  public static ColorDemo get() {
    return new ColorDemo();
  }

}
