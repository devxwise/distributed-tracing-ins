package com.trace.algo;

public class GraphDataProviderFactory {

    /**
     * return the required @GraphResultDataProvider instance
     * @param idx the result index
     * @return @GraphResultDataProvider instance
     */
    public static GraphResultDataProvider getGraphDataProvider(int idx){
        switch(idx){
            case 0: case 1: case 2: case 3: case 4:
                return new AverageTraceLatency();
            case 5:
                return new TracesWithMaxHops();
            case 6:
                return new TracesWithExactHops();
            case 7: case 8:
                return new ShortLatencyTrace();
            case 9:
                return new AverageTraceWithMaxLatency();
            default:
                throw new IllegalArgumentException("unrecognized idx, should be between 0-9");
        }
    }
}
