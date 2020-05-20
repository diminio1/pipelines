package pipelines.descriptor;

import java.util.Map;
import lombok.Value;

@Value
public class Step {
  String processor;
  Map<String, String> configuration;
}
