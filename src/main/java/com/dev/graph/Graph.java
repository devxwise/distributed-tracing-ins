package com.dev.graph;

public class Graph {

    // total number vertices
    private final int numOfV = 5;

    // Adjacency List - matrix of weights (-1, no edge exists)
    private int adjacency[][];

    public Graph() {
        adjacency = new int[][]{
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1}};
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
}
