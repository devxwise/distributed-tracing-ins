package com.dev.graph;

import java.util.stream.IntStream;

public class Graph {

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
     * @param v1 from vertex
     * @param v2 to vertex
     * @param latency the latency
     */
    void addEdge(int v1, int v2, int latency) {
        adjacency[v1][v2] = latency;
    }

    /**
     * Return latency =between two vertices
     * @param fromV from vertex
     * @param toV to vertex
     * @return latency between 2 vertices. -1 if no trace
     */
    public int getLatency(int fromV, int toV) {
        return adjacency[fromV][toV];
    }
}
