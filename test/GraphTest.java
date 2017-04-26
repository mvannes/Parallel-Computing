import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Michael on 26-4-2017.
 */
class GraphTest {
    @Test
    void addEdge() {
        Graph graph = new Graph(2);
        graph.addEdge(0, 1);
        assertThrows(RuntimeException.class, () -> graph.addEdge(2, 3));
    }

    @Test
    void topologicalSort() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        Stack expected = new Stack();
        expected.add(5);
        expected.add(4);
        expected.add(3);
        expected.add(2);
        expected.add(1);
        expected.add(0);
        assertEquals(expected, graph.topologicalSort());
    }

}