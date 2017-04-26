import com.sun.javaws.exceptions.InvalidArgumentException;

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
        }
        Graph graph = new Graph(amountOfVertices);
        for(int i=0; i<amountOfEdges; i++) {
            if (i < amountOfVertices - 1) {
                graph.addEdge(i, i + 1);
            } else {
                // Figure something out to add more edges here.
            }
        }
        return graph;
    }
}
