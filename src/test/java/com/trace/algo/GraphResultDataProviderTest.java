package com.trace.algo;

import org.junit.Assert;
import org.junit.Test;

public class GraphResultDataProviderTest {

    @Test
    public void verifyCorrectInstanceReturned(){
        Assert.assertTrue(GraphDataProviderFactory.getGraphDataProvider(0) instanceof AverageTraceLatency);
        Assert.assertTrue(GraphDataProviderFactory.getGraphDataProvider(1) instanceof AverageTraceLatency);
        Assert.assertTrue(GraphDataProviderFactory.getGraphDataProvider(2) instanceof AverageTraceLatency);
        Assert.assertTrue(GraphDataProviderFactory.getGraphDataProvider(3) instanceof AverageTraceLatency);
        Assert.assertTrue(GraphDataProviderFactory.getGraphDataProvider(4) instanceof AverageTraceLatency);
        Assert.assertTrue(GraphDataProviderFactory.getGraphDataProvider(5) instanceof TracesWithMaxHops);
        Assert.assertTrue(GraphDataProviderFactory.getGraphDataProvider(6) instanceof TracesWithExactHops);
        Assert.assertTrue(GraphDataProviderFactory.getGraphDataProvider(7) instanceof ShortLatencyTrace);
        Assert.assertTrue(GraphDataProviderFactory.getGraphDataProvider(8) instanceof ShortLatencyTrace);
        Assert.assertTrue(GraphDataProviderFactory.getGraphDataProvider(9) instanceof AverageTraceWithMaxLatency);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionWhenNotValidIndex(){
        GraphDataProviderFactory.getGraphDataProvider(10);
    }
}
