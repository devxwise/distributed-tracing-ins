# Distributed Tracing
Java application which reads the comma-separated input graph from a text file and provides data to
pre-defined queries about graph traces, latency and hops.

## How to use

- Clone repository
- From root directory, run:

```shell script
mvn clean install
``` 
- Executable Jar file: `distributed-tracing.jar` is created under the `target` folder.
- The application requires a file-name as its one (and only) argument. Inside the comma-separated file
the vertices are named using the first few letters of the alphabet from A to E. 
A trace between 2 vertices (A to B) with a latency of 5 is represented as AB5. For example:
 ``AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7``  
- To execute the application:

```shell script
java -jar distributed-tracing.jar <path/to/your/file.txt> 
```  







