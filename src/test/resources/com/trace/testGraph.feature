Feature: Does Graph trace reply with result?

Scenario: Get result for sample input
Given file name that contains graph edges and latency
When I call to the Graph Processor
Then I get non empty result