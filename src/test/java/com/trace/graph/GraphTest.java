package com.trace.graph;

import com.trace.exception.NoTraceFoundException;
import com.trace.exception.StructureGraphException;
import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

    @Test
    public void testAddingEdge() throws NoTraceFoundException, StructureGraphException {
        Graph graph = new Graph();

        graph.addEdge(0,1, 4);
        int latency = graph.getLatency(0, 1);

        Assert.assertEquals( 4, latency);
    }

    @Test(expected = NoTraceFoundException.class)
    public void testNoEdge() throws NoTraceFoundException {
        Graph graph = new Graph();

        graph.getLatency(0, 1);
    }

    @Test(expected = StructureGraphException.class)
    public void testInvalidEdge() throws StructureGraphException {
        Graph graph = new Graph();

        graph.addEdge(0,0, 7);
    }


}
