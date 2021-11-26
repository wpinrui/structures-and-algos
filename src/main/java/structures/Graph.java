package structures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph<T> {
    private final List<Node<T>> nodes = new ArrayList<>();

    public int size() {
        return nodes.size();
    }

    public List<Node<T>> getNodes() {
        List<Node<T>> nodesToAdd = new ArrayList<>();
        for (Node<T> node : nodes) {
            List<Node<T>> neighbours = node.getNeighbourList();
            nodesToAdd.addAll(neighbours);
        }
        nodes.addAll(nodesToAdd.stream().filter(node -> !nodes.contains(node)).collect(Collectors.toList()));
        return nodes;
    }

    public void add(Node<T> n) {
        nodes.add(n);
    }

    public boolean contains(Node<T> n) {
        return getNodes().contains(n);
    }

    public void remove(Node<T> n) {
        if (!this.contains(n)) {
             throw new IllegalArgumentException("Node n does not exist in Graph");
        }
        nodes.remove(n);
    }

    public void clear() {
        nodes.clear();
    }

    static class Node<U> {
        U data;
        List<Node<U>> neighbours = new ArrayList<>();

        public Node(U data) {
            this.data = data;
        }

        public List<Node<U>> getNeighbourList() {
            return neighbours;
        }

        public int getNumberOfNeighbours() {
            return neighbours.size();
        }

        public void join(Node<U> neighbour) {
            neighbours.add(neighbour);
        }
    }
}
