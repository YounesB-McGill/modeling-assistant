package ca.mcgill.sel.mistakedetection.tests.utils;

import static ca.mcgill.sel.mistakedetection.tests.utils.MistakeDetectionInformationServicesForLearningCorpus.USE_COLOR_OUTPUT;
import java.util.Arrays;
import java.util.stream.Collectors;

/** Color enum used to print output in color. Requires ANSI escaping to be enabled in the console. */
public enum Color {

  BLACK(0),
  GRAY(8),
  VIOLET(165),
  BLUE(4),
  CYAN(39),
  SEA_GREEN(86),
  BLUE_GREEN(37),
  GREEN(28),
  GREEN_YELLOW(118),
  YELLOW(226),
  DARK_YELLOW(214),
  ORANGE(208),
  DARK_ORANGE(166),
  RED(124),
  PINK(199),
  /** Resets color output to default. */
  ENDC("\033[0m");

  int foregroundColor;
  String ansiEscapeCode;

  Color(String ansiEscapeCode) {
    this.ansiEscapeCode = ansiEscapeCode;
  }

  Color(int foregroundColor) {
    this("\033[38;5;" + foregroundColor + "m");
    this.foregroundColor = foregroundColor;
  }

  @Override public String toString() {
    return ansiEscapeCode;
  }

  public static String demo() {
    return Arrays.stream(Color.values()).map(c -> colorString(c, c.name() + "(" + c.foregroundColor + ")"))
        .collect(Collectors.joining("\n"));
  }

  /** Returns the given item.toString() in the given color if USE_COLOR_OUTPUT is true. */
  static <T> String colorString(Color color, T item) {
    if (!USE_COLOR_OUTPUT) {
      return item.toString();
    }
    return "" + color + item + Color.ENDC;
  }

}
