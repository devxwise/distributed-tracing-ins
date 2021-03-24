package com.trace.algo;

import com.trace.exception.NoTraceFoundException;
import com.trace.graph.Graph;

public class TracesWithMaxHops implements GraphResultDataProvider{

    //maximum hops permitted, if not specified else, will be defaulted to 3
    private final int maxHops;

    public TracesWithMaxHops(){
        this.maxHops = 3;
    }
    public TracesWithMaxHops(int maxHops){
        this.maxHops = maxHops;
    }

    private int countPaths(int from, int to, int hops, int totalPaths, Graph graph){
        if (hops <= maxHops) {
            if (from == to && hops > 0) {
                totalPaths++;
            } else {
                for (int n : graph.getAdjOfVertex(from)) {
                    totalPaths = countPaths(n, to, hops + 1, totalPaths, graph);
                }
            }
        }

        return totalPaths;

    }

    @Override
    public int calculatePathData(int[] trace, Graph graph) throws NoTraceFoundException {
        return countPaths(trace[0], trace[1], 0, 0, graph);
    }
}
