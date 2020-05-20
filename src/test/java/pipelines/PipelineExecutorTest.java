package pipelines;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import pipelines.descriptor.PipelineDescriptor;

public class PipelineExecutorTest {

  private final static String pipelineJson = "{\"steps\": " +
      "[ { \"processor\": \"AddField\", " +
      "\"configuration\" : { \"fieldName\": \"firstName\", \"fieldValue\": \"George\" }}, " +
      "{ \"processor\": \"CountNumOfFields\", " +
      "\"configuration\" : { \"countFieldName\": \"numOfFields\"}} ]}";

  @Test
  public void PipelineExecutorFlowTest() {
    Map<String, Object> jsonDocument = getStub();

    Gson gson = new Gson();
    PipelineDescriptor descriptor = gson.fromJson(pipelineJson, PipelineDescriptor.class);

    PipelineExecutor executor = new PipelineExecutor();
    executor.transform(descriptor, jsonDocument);

    Assert.assertTrue(jsonDocument.containsKey("lastName"));
    Assert.assertTrue(jsonDocument.containsKey("age"));
    Assert.assertTrue(jsonDocument.containsKey("country"));

    Assert.assertTrue(jsonDocument.containsKey("firstName"));
    Assert.assertTrue(jsonDocument.containsValue("George"));
    Assert.assertTrue(jsonDocument.containsKey("numOfFields"));
    Assert.assertTrue(jsonDocument.containsValue(4));
    Assert.assertEquals(5, jsonDocument.size());
  }

  private Map<String, Object> getStub() {
    Map<String, Object> json = new HashMap<>();
    json.put("lastName", "Simpson");
    json.put("age", 37);
    json.put("country", "Ukraine");
    return json;
  }
}
