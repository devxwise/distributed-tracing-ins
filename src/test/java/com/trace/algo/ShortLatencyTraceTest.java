package com.trace.algo;

import com.trace.exception.NoTraceFoundException;
import com.trace.exception.StructureGraphException;
import com.trace.graph.Graph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShortLatencyTraceTest {

    private Graph graph;
    private ShortLatencyTrace shortLatencyTrace;

    @Before
    public void setUp() throws StructureGraphException {
        graph = new Graph();
        graph.addEdge(0,1, 20);
        graph.addEdge(0,3, 4);
        graph.addEdge(3,2, 4);
        graph.addEdge(1,2, 3);
        graph.addEdge(0,4, 31);

        shortLatencyTrace = new ShortLatencyTrace();
    }

    @Test
    public void testShortPathFromAtoC() throws NoTraceFoundException {
        int[] trace = new int[]{0, 2};

        int res = shortLatencyTrace.calculatePathData(trace, graph);

        Assert.assertEquals(8, res);
    }

    @Test(expected = NoTraceFoundException.class)
    public void testNoTraceFound() throws NoTraceFoundException {
        int[] trace = new int[]{1, 3};

        shortLatencyTrace.calculatePathData(trace, graph);
    }
}
