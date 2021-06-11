package org.coding.Graphs;

import org.Graph;
import org.Graph.Vertex;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//https://www.baeldung.com/java-graphs
public class Dfs {

    //Iterative approach
    private <T> Set<T> solution(Graph graph, T root) {
        Set<T> visited = new LinkedHashSet<>();
        Stack<T> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            T vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                List<Vertex> list = graph.getAdjVertices(vertex);

                for (Vertex v : list) {
                    stack.push((T) v.label);
                }
            }
        }
        return visited;
    }


    //recursive
    private <T> void solution1(Graph graph, T root) {

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
        //[Bob, Rob, Maria, Alice, Mark]
    }


    @Test
    public void test2() {
        Graph<Integer> graph = new Graph<>();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println(solution(graph, 0));
        //0 2 3 4 1
        //0 1 3 4 2 is also valid output
    }

}
