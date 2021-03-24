package com.trace;

import com.trace.exception.GraphFileParserException;
import com.trace.exception.StructureGraphException;
import com.trace.graph.Graph;
import com.trace.parser.Edge;
import com.trace.parser.FileParser;
import com.trace.parser.FileReader;
import com.trace.result.Result;
import com.trace.result.ResultGenerator;

import java.util.Set;

public class TracingProcessor {

    public Result process(String fileName) throws GraphFileParserException, StructureGraphException {
        FileParser parser = new FileReader();

        Graph graph = buildGraph(parser.readGraphFile(fileName));

        ResultGenerator resultGenerator = new ResultGenerator();
        return resultGenerator.generate(graph);
    }

    /**
     * Building the graph from the given list of edges
     * @param edges the fiven edges
     * @return the structured @Graph
     */
    private Graph buildGraph(Set<Edge> edges) throws StructureGraphException {
        Graph graph = new Graph();
        for (Edge edge : edges){
            graph.addEdge(edge.getFrom(), edge.getTo(), edge.getLatency());
        }
        return graph;
    }
}
