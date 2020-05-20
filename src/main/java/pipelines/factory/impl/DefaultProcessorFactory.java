package pipelines.factory.impl;

import lombok.NonNull;
import pipelines.factory.ProcessorFactory;
import pipelines.processor.impl.AddFieldProcessor;
import pipelines.processor.impl.CountNumOfFieldsProcessor;
import pipelines.processor.Processor;
import pipelines.processor.impl.RemoveFieldProcessor;

public class DefaultProcessorFactory implements ProcessorFactory {
  public Processor create(@NonNull String processorName) {

    switch (processorName) {
      case "AddField":
        return new AddFieldProcessor();
      case "RemoveField":
        return new RemoveFieldProcessor();
      case "CountNumOfFields":
        return new CountNumOfFieldsProcessor();
      default:
        throw new RuntimeException("No such processor implementation for " + processorName);
    }
  }
}
