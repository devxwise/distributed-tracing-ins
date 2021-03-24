package com.trace.algo;

import com.trace.exception.NoTraceFoundException;
import com.trace.graph.Graph;

public class AverageTraceWithMaxLatency implements GraphResultDataProvider{

    //maximum latency permitted, if not specified else, will be defaulted to 30
    private final int maxLatency;

    public AverageTraceWithMaxLatency(){
        this.maxLatency = 30;
    }

    public AverageTraceWithMaxLatency(int maxLatency){
        this.maxLatency = maxLatency;
    }

    private int countPaths(int from, int to, int latency, int totalPaths, Graph graph) throws NoTraceFoundException {
        if (latency < maxLatency) {
            if (from == to && latency > 0) {
                totalPaths++;
            }
            for (int n : graph.getAdjOfVertex(from)) {
                totalPaths = countPaths(n, to, latency + graph.getLatency(from, n), totalPaths, graph);
            }
        }
        return totalPaths;
    }

    @Override
    public int calculatePathData(int[] trace, Graph graph) throws NoTraceFoundException {
        return countPaths(trace[0], trace[1], 0, 0, graph);
    }
}
