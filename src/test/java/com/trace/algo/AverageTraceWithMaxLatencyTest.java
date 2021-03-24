package com.trace.algo;

import com.trace.exception.NoTraceFoundException;
import com.trace.exception.StructureGraphException;
import com.trace.graph.Graph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AverageTraceWithMaxLatencyTest {

    private Graph graph;
    private AverageTraceWithMaxLatency averageTraceWithMaxLatency;

    @Before
    public void setUp() throws StructureGraphException {
        graph = new Graph();
        graph.addEdge(0,1, 20);
        graph.addEdge(0,3, 4);
        graph.addEdge(3,2, 4);
        graph.addEdge(1,2, 3);
        graph.addEdge(0,4, 31);

        averageTraceWithMaxLatency = new AverageTraceWithMaxLatency();
    }

    @Test
    public void testPathFromAtoC() throws NoTraceFoundException {
        int[] trace = new int[]{0,2};
        int res = averageTraceWithMaxLatency.calculatePathData(trace, graph);

        Assert.assertEquals(2, res);
    }

    @Test
    public void testPathFromAtoEOver30() throws NoTraceFoundException {
        int[] trace = new int[]{0,4};
        int res = averageTraceWithMaxLatency.calculatePathData(trace, graph);

        Assert.assertEquals(0, res);
    }
}
