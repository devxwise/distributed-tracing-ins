package com.trace.algo;

import com.trace.exception.NoTraceFoundException;
import com.trace.exception.StructureGraphException;
import com.trace.graph.Graph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AverageTraceLatencyTest {
    private Graph graph;
    private AverageTraceLatency averageTraceLatency;

    @Before
    public void setUp() throws StructureGraphException {
        graph = new Graph();
        graph.addEdge(0,1, 2);
        graph.addEdge(1,2, 3);

        averageTraceLatency = new AverageTraceLatency();
    }

    @Test(expected =  NoTraceFoundException.class)
    public void testNoTraceAvailable() throws NoTraceFoundException {
        int[] trace = new int[]{0,2};

        averageTraceLatency.calculatePathData(trace, graph);
    }

    @Test
    public void testAverageLatency() throws NoTraceFoundException {
        int[] trace = new int[]{0, 1, 2};

        int res = averageTraceLatency.calculatePathData(trace, graph);

        Assert.assertEquals(5, res);
    }
}
