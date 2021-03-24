package com.trace.algo;

import com.trace.exception.NoTraceFoundException;
import com.trace.graph.Graph;


public class ShortLatencyTrace implements GraphResultDataProvider{

    @Override
    public int calculatePathData(int[] trace, Graph graph) throws NoTraceFoundException {
        boolean[] visited = new boolean[5];
        visited[trace[0]] = true;

        int result = minimumLatencyPath(trace[0], trace[1],
                visited, graph, true);

        if (result == Integer.MAX_VALUE){
            throw new NoTraceFoundException("no trace could be found between given vertices");
        }
        return result;
    }

    private int minimumLatencyPath(int from, int to,
                                   boolean[] visited,
                                   Graph graph, boolean firstIteration){
        if (from == to & !firstIteration) { //don't return if first iteration and from-to identical
            return 0;
        }

        visited[from] = true;
        final int[] result = {Integer.MAX_VALUE};

        graph.getAdjOfVertex(from).forEach(v->{
            if(!visited[v] || v == to){
                int curr = minimumLatencyPath(v, to, visited, graph, false);
                try {
                    if (curr < Integer.MAX_VALUE) {
                        result[0] = Math.min(result[0], graph.getLatency(from, v) + curr);
                    }
                } catch (NoTraceFoundException ignored) {}
           }
        });

        visited[from] = false;
        return result[0];
    }
}
