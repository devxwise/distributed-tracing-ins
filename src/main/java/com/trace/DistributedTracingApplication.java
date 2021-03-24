package com.trace;

import com.trace.exception.GraphFileParserException;
import com.trace.exception.StructureGraphException;
import com.trace.result.Result;

public class DistributedTracingApplication {

    public static void main(String [] args) throws GraphFileParserException, StructureGraphException {

        if (args == null || args.length != 1){
            throw new IllegalArgumentException("Please specify graph structure file as an argument");
        }

        TracingProcessor tracingProcessor = new TracingProcessor();
        Result result = tracingProcessor.process(args[0]);

        System.out.println(result);
    }
}
