package pipelines.descriptor;

import java.util.List;
import lombok.Value;

@Value
public class PipelineDescriptor {
    List<Step> steps;
}
