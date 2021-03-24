package com.trace.algo;

import com.trace.exception.NoTraceFoundException;
import com.trace.graph.Graph;

public interface GraphResultDataProvider {

    /**
     * provide result for the given path and graph
     * @param trace the vertices path calls
     * @param graph the graph
     * @return the result
     */
    int calculatePathData(int [] trace, Graph graph) throws NoTraceFoundException;
}
