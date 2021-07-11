package modelingassistant.restapi;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple DTO (Data Transfer Object) used for testing the app.
 *
 * @author Younes Boubekeur
 */
public class HelloWorld {
  private final long id;
  private final String content;

  public HelloWorld(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }
}

@RestController
class HelloWorldController {
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public HelloWorld greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new HelloWorld(counter.incrementAndGet(), String.format(template, name));
  }
}
