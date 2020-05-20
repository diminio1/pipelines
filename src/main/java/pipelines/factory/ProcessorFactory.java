package pipelines.factory;

import pipelines.processor.Processor;

public interface ProcessorFactory {
  Processor create(String processorName);
}
