package modelingassistant.restapi;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) // only for testing
public class ModelingAssistantRestApi {

  /** The default port used by the application. */
  public static final int PORT = 8539;

  public static void main(String[] args) {
    var app = new SpringApplication(ModelingAssistantRestApi.class);
    app.setDefaultProperties(Collections.singletonMap("server.port", PORT));
    app.run(args);
  }

}
