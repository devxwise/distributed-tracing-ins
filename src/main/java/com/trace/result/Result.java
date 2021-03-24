package com.trace.result;

import java.util.stream.IntStream;

public class Result {

    private final String[] results;
    private final int numOfResults;

    public Result(int numOfResults){
        this.results = new String[numOfResults];
        this.numOfResults = numOfResults;
    }

    public void addResultRecord(int idx, int value){
        addResultRecord(idx, String.valueOf(value));
    }

    public void addResultRecord(int idx, String value){
        if (idx > numOfResults - 1 || idx < 0)
            throw new IllegalArgumentException("Result idx should be between 1 to 10");
        results[idx] = value;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        IntStream.range(0, numOfResults)
                .forEach(i -> builder.append(i+1).append(". ").append(results[i]).append("\n"));
        return builder.toString();
    }
}
