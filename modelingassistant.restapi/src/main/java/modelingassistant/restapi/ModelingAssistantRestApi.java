package modelingassistant.restapi;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// TODO Add authentication support

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) // only for testing
public class ModelingAssistantRestApi {

  /** The default port used by the application. */
  public static final int PORT = 8539;

  /** The maximum HTTP header size used by the application. */
  public static final int MAX_HEADER_SIZE = 1_048_576; // 2^20

  public static void main(String[] args) {
    var app = new SpringApplication(ModelingAssistantRestApi.class);
    app.setDefaultProperties(Map.of(
        "server.port", PORT,
        "server.max-http-header-size", MAX_HEADER_SIZE));
    app.run(args);
  }

}
