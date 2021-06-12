package org;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.baeldung.com/java-graphs
public class Graph<T> {

    public class Vertex<T> {
        public T label;

        Vertex(T label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label + "";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex<T> other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                return other.label == null;
            } else return label.equals(other.label);
        }

        private Graph getOuterType() {
            return Graph.this;
        }
    }

    private Map<Vertex<T>, List<Vertex<T>>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    public void addVertex(T label) {
        adjVertices.putIfAbsent(new Vertex<>(label), new ArrayList<>());
    }

    public void removeVertex(T label) {
        Vertex<T> v = new Vertex<T>(label);
        adjVertices.values().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex<T>(label));
    }

    public void addEdge(T label1, T label2) {
        Vertex<T> v1 = new Vertex<T>(label1);
        Vertex<T> v2 = new Vertex<T>(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    public void removeEdge(T label1, T label2) {
        Vertex<T> v1 = new Vertex<T>(label1);
        Vertex<T> v2 = new Vertex<T>(label2);
        List<Vertex<T>> eV1 = adjVertices.get(v1);
        List<Vertex<T>> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    public List<Vertex<T>> getAdjVertices(T label) {
        return adjVertices.get(new Vertex<T>(label));
    }

    public String printGraph() {
        StringBuilder sb = new StringBuilder();
        for (Vertex<T> v : adjVertices.keySet()) {
            sb.append(v);
            sb.append(adjVertices.get(v));
            sb.append("\n");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
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

        System.out.println(graph.printGraph());

        int debug = 1;
    }

}
