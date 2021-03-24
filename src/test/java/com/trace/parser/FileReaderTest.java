package com.trace.parser;

import com.trace.exception.GraphFileParserException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderTest {

    @Test
    public void testValidFile() throws GraphFileParserException {
        FileParser parser = new FileReader();
        Set<Edge> result = parser.readGraphFile("src/test/resources/graph.txt");


        Assert.assertNotNull(result);
        Assert.assertEquals(4, result.size());

        List<Edge> l = Stream.of(new Edge("AB5"), new Edge("BC4"),
                new Edge("CD1"), new Edge("DE8"))
                .collect(Collectors.toList());
        Assert.assertTrue(result.containsAll(l));
    }

    @Test(expected = GraphFileParserException.class)
    public void testNotExistFile() throws GraphFileParserException {
        FileParser parser = new FileReader();
        parser.readGraphFile("src/test/resources/graph1.txt");
    }

    @Test(expected = GraphFileParserException.class)
    public void testInvalidEdgeValue() throws GraphFileParserException {
        FileParser parser = new FileReader();
        parser.readGraphFile("src/test/resources/graph_invalid.txt");
    }
}
