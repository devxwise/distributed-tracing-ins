package com.trace.parser;

import com.trace.exception.GraphFileParserException;

import java.util.Set;

public interface FileParser {

    /**
     * read graph settings from given file name. File should be comma divided file and each value represent
     * an edge between 2 vertices and their latency
     * Vertices labeled A-E and latency is integer number - example 'AC4,BD7'
     *
     * @param fileName the file name to read the graph settings from
     * @return a list of @link Edge
     * @throws GraphFileParserException for any IO or invalid value issues
     */
    Set<Edge> readGraphFile(String fileName) throws GraphFileParserException;
}
