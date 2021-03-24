package com.trace.parser;

import com.trace.exception.GraphFileParserException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class FileReader implements FileParser{

    private final String PERMITTED_VALUE_REGEX = "^[A-E]{2}[1-9][0-9]*$";

    @Override
    public Set<Edge> readGraphFile(String fileName) throws GraphFileParserException {

        //Set -> making sure no duplicate connections
        Set<Edge> result = new HashSet<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(fileName));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)){

            for (CSVRecord record : csvParser){
                for (String v : record){
                    String vtx = v.trim();
                    //validating value
                    if (!vtx.matches(PERMITTED_VALUE_REGEX)){
                        String msg = String.format("Unsupported edge configuration: %s", vtx);
                        throw new GraphFileParserException(msg);
                    }
                    result.add(new Edge(vtx.trim()));
                }
            }
        } catch (IOException e) {
            throw new GraphFileParserException("Error reading file, please validate if file exists", e);
        }

        return result;
    }
}
