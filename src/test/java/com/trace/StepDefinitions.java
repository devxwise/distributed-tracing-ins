package com.trace;

import com.trace.exception.GraphFileParserException;
import com.trace.exception.StructureGraphException;
import com.trace.result.Result;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions {

    private String fileName;

    private Result result;

    @Given("file name that contains graph edges and latency")
    public void getFileName(){
        this.fileName = "src/test/resources/test_input_graph.txt";
    }

    @When("I call to the Graph Processor")
    public void callToGraphProcessor() throws GraphFileParserException, StructureGraphException {
        TracingProcessor tracingProcessor = new TracingProcessor();
        result = tracingProcessor.process(fileName);

    }

    @Then("I get non empty result")
    public void verifyResult(){
        Assert.assertNotNull(result);
        Assert.assertEquals("1. 9\n" +
                "2. 5\n" +
                "3. 13\n" +
                "4. 22\n" +
                "5. NO SUCH TRACE\n" +
                "6. 2\n" +
                "7. 3\n" +
                "8. 9\n" +
                "9. 9\n" +
                "10. 7\n",
                result.toString());
    }
}
