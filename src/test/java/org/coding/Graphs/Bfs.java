package org.coding.Graphs;

import org.Graph;
import org.junit.Test;

import java.util.*;

//https://tutorialedge.net/artificial-intelligence/breadth-first-search-java/
//https://www.baeldung.com/java-graphs
public class Bfs {

    private Set<String> solution(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            List<Graph.Vertex> adjVertices = graph.getAdjVertices(vertex);

            for (Graph.Vertex v : adjVertices) {
                if (!visited.contains(v.label)) {
                    visited.add((String) v.label);
                    queue.add((String) v.label);
                }
            }
        }
        return visited;
    }

    @Test
    public void test1() {
        Graph<String> graph = new Graph<>();

        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        System.out.println(solution(graph, "Bob"));
        //[Bob, Alice, Rob, Mark, Maria]
    }
}
