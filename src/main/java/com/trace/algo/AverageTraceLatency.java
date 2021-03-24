package com.trace.algo;

import com.trace.exception.NoTraceFoundException;
import com.trace.graph.Graph;

public class AverageTraceLatency implements GraphResultDataProvider{

    @Override
    public int calculatePathData(int[] trace, Graph graph) throws NoTraceFoundException {
        int total = 0;

        for (int i = 0; i<trace.length -1; i++){
            total += graph.getLatency(trace[i], trace[i + 1]);
        }

        return total;
    }
}