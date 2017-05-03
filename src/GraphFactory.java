import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.*;

/**
 * Factory for the creation of large Directed Acyclic Graphs (DAG)
 */
public class GraphFactory {
    /**
     * Create a graph with the given amount of vertices, and the given amount of edges between them.
     * Returns either the finished Graph,
     * or throws an exception if the specified amount of edges is too little to
     * create a full graph for the specified amount of vertices.
     *
     * @param amountOfVertices
     * @param amountOfEdges
     * @return
     */
    public Graph createGraph(int amountOfVertices, int amountOfEdges) {
        // If there are more vertices than edges + 1 some vertices will not be linked, thus preventing us from creating
        // a proper graph. (It would have floating vertices)
        if (amountOfVertices > (amountOfEdges + 1) ) {
            throw new RuntimeException("Given amount of edges is too small for the given amount of vertices, can't " +
                    "form a graph without leaving a vertex unlinked.");
        // Max amount of edges in a DAG is (N-1)(N)/2
        } else if(amountOfEdges > ((amountOfVertices -1) * amountOfVertices) / 2) {
            throw new RuntimeException("Given amount of edges is too large for the given amount of vertices." +
                    "Can't create this graph without creating cycles.");
        }
        Graph graph = new Graph(amountOfVertices);
        int vertices[] = new int[amountOfVertices];
        int amountOfSetEdges = 0;
        LinkedList[] adjacency = new LinkedList[amountOfVertices];
        for (int i=0;i<amountOfVertices;i++) {
            vertices[i] = i;
            adjacency[i] = new LinkedList<>();
        }
        Collections.shuffle(Arrays.asList(vertices));
        Random random = new Random();
        while(amountOfEdges > amountOfSetEdges) {
            int vertex = random.nextInt(amountOfVertices);
            int target = random.nextInt(amountOfVertices);
            if ((vertex < target) && !adjacency[vertex].contains(target)) {
                adjacency[vertex].add(target);
                amountOfSetEdges++;
                graph.addEdge(vertex, target);
            }
        }

        return graph;
    }
}
