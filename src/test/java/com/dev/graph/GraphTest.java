package com.dev.graph;

import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

    @Test
    public void testAddingEdge(){
        Graph graph = new Graph();

        graph.addEdge(0,1, 4);
        int latency = graph.getLatency(0, 1);

        Assert.assertEquals( 4, latency);
    }

    @Test
    public void testNoEdge(){
        Graph graph = new Graph();

        int latency = graph.getLatency(0, 1);

        Assert.assertEquals(-1, latency);
    }
}
