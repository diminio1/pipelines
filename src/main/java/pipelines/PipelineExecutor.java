package pipelines;

import java.util.Map;
import lombok.NonNull;
import pipelines.descriptor.PipelineDescriptor;
import pipelines.descriptor.Step;
import pipelines.factory.impl.DefaultProcessorFactory;
import pipelines.factory.ProcessorFactory;
import pipelines.processor.Processor;

public class PipelineExecutor {
  public void transform(@NonNull PipelineDescriptor pipelineDescriptor, @NonNull Map<String, Object> jsonDocument) {
    ProcessorFactory factory = new DefaultProcessorFactory();

    for(Step step : pipelineDescriptor.getSteps()) {
      Processor processor = factory.create(step.getProcessor());
      processor.initialize(step.getConfiguration());
      processor.process(jsonDocument);
    }
  }
}
