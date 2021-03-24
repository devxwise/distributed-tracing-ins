package com.trace.graph;

import com.trace.exception.NoTraceFoundException;
import com.trace.exception.StructureGraphException;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Graph{

    // total number vertices
    private final int NUM_OF_VERTICES = 5;

    private final int NO_TRACE= -1;

    // Adjacency List - matrix of weights (-1, no edge exists)
    private int adjacency[][];

    public Graph() {

        adjacency = new int[NUM_OF_VERTICES][NUM_OF_VERTICES];
        IntStream.range(0, NUM_OF_VERTICES).forEach(x->
                    IntStream.range(0, NUM_OF_VERTICES).forEach(y-> adjacency[x][y] = NO_TRACE));
    }

    /**
     * Adding edge (+ latency)
     * @param from from vertex
     * @param to to vertex
     * @param latency the latency
     */
    public void addEdge(int from, int to, int latency) throws StructureGraphException {
        if (from == to){
            throw new StructureGraphException("Invalid edge creation, can;'t create edge from a node to itself");
        }
        adjacency[from][to] = latency;
    }

    /**
     * Return latency =between two vertices
     * @param from from vertex
     * @param to to vertex
     * @return latency between 2 vertices. -1 if no trace
     */
    public int getLatency(int from, int to) throws NoTraceFoundException {
        int latency = adjacency[from][to];
        if (latency == NO_TRACE) {
            String msg = String.format("No trace exists from %s to %s", from, to);
            throw new NoTraceFoundException(msg);
        }
        return latency;
    }

    /**
     * return adjacency for given vertex
     * @param v the vertex
     * @return int[] the vertex's adjacency
     */
    public List<Integer> getAdjOfVertex(int v){
        List<Integer> result = new LinkedList<>();
        IntStream.range(0, 5).forEach(i-> {
            if (adjacency[v][i] > -1) {
                result.add(i);
            }
        });
        return result;
    }
}