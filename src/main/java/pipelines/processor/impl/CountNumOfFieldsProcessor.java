package pipelines.processor.impl;

import java.util.Map;
import lombok.NonNull;
import pipelines.processor.Processor;

public class CountNumOfFieldsProcessor implements Processor {
  private Map<String, String> configuration;

  public void initialize(@NonNull Map<String, String> configuration) {
    this.configuration = configuration;
  }

  public void process(@NonNull Map<String, Object> jsonDocument) {
    jsonDocument.put(configuration.get("countFieldName"),
        jsonDocument.size());
  }
}
