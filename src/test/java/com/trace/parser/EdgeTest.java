package com.trace.parser;

import org.junit.Assert;
import org.junit.Test;

public class EdgeTest {

    @Test
    public void testInitiation(){
        Edge edge = new Edge("AB5");

        Assert.assertEquals(0, edge.getFrom());
        Assert.assertEquals(1, edge.getTo());
        Assert.assertEquals(5, edge.getLatency());
    }

    @Test
    public void testEqualsIgnoreLatency(){
        Edge edge1 = new Edge("AB5");
        Edge edge2 = new Edge("AB8");
        Assert.assertEquals(edge1, edge2);

    }
}
