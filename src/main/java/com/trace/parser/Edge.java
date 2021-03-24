package com.trace.parser;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@Getter
@EqualsAndHashCode
public class Edge {

    private int from;

    private int to;

    @EqualsAndHashCode.Exclude
    private int latency;

    public Edge(String value) {
        this.from = value.charAt(0) - 'A';
        this.to = value.charAt(1) - 'A';
        latency = Integer.parseInt(value.substring(2));
    }
}
