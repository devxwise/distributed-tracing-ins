package com.trace;

import com.trace.exception.GraphFileParserException;
import com.trace.exception.StructureGraphException;
import org.junit.Test;

public class TracingProcessorTest {

    @Test(expected = GraphFileParserException.class)
    public void testBuildGraph() throws GraphFileParserException, StructureGraphException {
        TracingProcessor processor = new TracingProcessor();
        processor.process("src/test/resources/notExists.txt");
    }


}
