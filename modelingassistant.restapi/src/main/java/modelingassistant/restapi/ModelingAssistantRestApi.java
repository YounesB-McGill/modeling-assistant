package modelingassistant.restapi;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

// TODO Add authentication support

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) // only for testing
public class ModelingAssistantRestApi {

  /** The default port used by the application. */
  public static final int PORT = 8539;

  /** The maximum HTTP header size used by the application. */
  public static final int MAX_HEADER_SIZE = 1_048_576; // 2^20

  /** The location of the Modeling Assistant Mistake Detection ASCII art file, relative to the project path. */
  private static final String MDS_ASCII_ART_FILE = "ma-mds-ascii-art.txt";

  public static void main(String[] args) {
    var app = new SpringApplication(ModelingAssistantRestApi.class);
    app.setDefaultProperties(Map.of(
        "server.port", PORT,
        "server.max-http-header-size", MAX_HEADER_SIZE));
    app.run(args);
  }

  /** Prints a colorful ASCII art splash screen to the console, to help distinguish this app from others. */
  @EventListener(ContextRefreshedEvent.class)
  private static void printSplashScreen() {
    try {
      System.out.println(Files.readString(Path.of(MDS_ASCII_ART_FILE))
          .replace("\\n", "\n").replace("\\033", "\033").replace("\\\\", "\\")); // str from file != "str literal"
    } catch (Exception ignored) {
    }
  }

}
