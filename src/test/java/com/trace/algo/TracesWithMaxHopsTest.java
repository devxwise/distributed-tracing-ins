package com.trace.algo;

import com.trace.exception.NoTraceFoundException;
import com.trace.exception.StructureGraphException;
import com.trace.graph.Graph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TracesWithMaxHopsTest {

    private Graph graph;
    private TracesWithMaxHops tracesWithMaxHops;

    @Before
    public void setUp() throws StructureGraphException {
        graph = new Graph();
        graph.addEdge(0,1, 20);
        graph.addEdge(0,3, 4);
        graph.addEdge(0,4, 31);
        graph.addEdge(2,0, 5);
        graph.addEdge(3,2, 4);
        graph.addEdge(1,2, 3);


        tracesWithMaxHops = new TracesWithMaxHops();
    }

    @Test
    public void testTraceOf3FromAToA() throws NoTraceFoundException {
        int[] trace = new int[]{0, 0};

        int res = tracesWithMaxHops.calculatePathData(trace, graph);

        Assert.assertEquals(2, res);
    }

    @Test
    public void testTraceOf3FromAToC() throws NoTraceFoundException {
        int[] trace = new int[]{0, 2};

        int res = tracesWithMaxHops.calculatePathData(trace, graph);

        Assert.assertEquals(2, res);
    }
}
