package com.trace.result;

import com.trace.algo.GraphDataProviderFactory;
import com.trace.exception.NoTraceFoundException;
import com.trace.graph.Graph;

import java.util.stream.IntStream;

public class ResultGenerator {

    private final String NO_TRACE = "NO SUCH TRACE";

    //holds the given trace/vertices for the required questions
    private final int[][] traces;

    //number of results
    private final int NUM_OF_RESULTS = 10;

    private final Result result;

    //holds the results
    private final String[] results = new String[NUM_OF_RESULTS];

    public ResultGenerator(int[][] traces) {
        result = new Result(NUM_OF_RESULTS);
        this.traces = traces;
    }

    public ResultGenerator(){
        result = new Result(NUM_OF_RESULTS);
        this.traces = new int[][]{
                {0,1,2},
                {0,3},
                {0,3,2},
                {0,4,1,2,3},
                {0,4,3},
                {2,2},
                {0,2},
                {0,2},
                {1,1},
                {2,2}};
    }

    public Result generate(Graph graph){
        IntStream.range(0, NUM_OF_RESULTS).forEach(i-> {
            try {
                result.addResultRecord(i, GraphDataProviderFactory.getGraphDataProvider(i).calculatePathData(traces[i], graph));
            } catch (NoTraceFoundException e) {
                result.addResultRecord(i, NO_TRACE);
            }
        });

        return result;
    }
}
