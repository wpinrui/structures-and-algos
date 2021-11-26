package structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    Graph<Integer> g = new Graph<>();
    Graph.Node<Integer> n = new Graph.Node<>(1);

    @BeforeEach
    void resetGraph() {
        g = new Graph<>();
    }

    @Test
    void constructor_emptyNodeList() {
        assertEquals(0, g.size());
        assertEquals(0, g.getNodes().size());
    }

    @Test
    void add_increasesSize() {
        g.add(n);
        assertEquals(1, g.size());
    }

    @Test
    void add_alsoAddsNeighbours() {
        Graph.Node<Integer> nodeWithNeighbours = new Graph.Node<>(1);
        Graph.Node<Integer> neighbour1 = new Graph.Node<>(2);
        Graph.Node<Integer> neighbour2 = new Graph.Node<>(3);
        nodeWithNeighbours.join(neighbour1);
        g.add(nodeWithNeighbours);
        assertTrue(g.contains(neighbour1));
        nodeWithNeighbours.join(neighbour2);
        assertTrue(g.contains(neighbour2));
    }

    @Test
    void clear_sizeIsZero() {
        g.add(n);
        g.clear();
        assertEquals(0, g.size());
        assertEquals(0, new Graph<Integer>().size());
    }

    @Test
    void remove_nodeExistsDecreasesSize() {
        g.add(n);
        g.remove(n);
        assertEquals(0, g.size());
    }

    @Test
    void remove_nodeDoesNotExistThrowsException() {
        g.add(n);
        Graph.Node<Integer> differentNode = new Graph.Node<>(1);
        assertThrows(IllegalArgumentException.class, () -> g.remove(differentNode));
    }

    @Test
    void nodeConstructor_emptyNeighbourList() {
        Graph.Node<Integer> node = new Graph.Node<>(1);
        assertEquals(0, node.getNumberOfNeighbours());
        assertEquals(0, node.getNeighbourList().size());
    }
}