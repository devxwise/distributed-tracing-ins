package com.trace.algo;

import com.trace.exception.NoTraceFoundException;
import com.trace.graph.Graph;

public class TracesWithExactHops implements GraphResultDataProvider{

    //exact hops permitted, if not specified else, will be defaulted to 4
    private final int exactHops;

    public TracesWithExactHops(){
        this.exactHops = 4;
    }
    public TracesWithExactHops(int exactHops){
        this.exactHops = exactHops;
    }


    private int countPaths(int from, int to, int hops, int totalPaths, Graph graph){
        if (hops <= exactHops) {
            if (from == to && hops == exactHops) {
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
