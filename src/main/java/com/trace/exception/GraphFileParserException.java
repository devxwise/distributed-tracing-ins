package com.trace.exception;

public class GraphFileParserException extends Exception{

    public GraphFileParserException(String msg, Exception e){
        super(msg, e);
    }

    public GraphFileParserException(String msg) {
        super(msg);
    }
}
