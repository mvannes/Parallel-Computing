import java.util.Stack;

public class Main {

    // Driver method
    public static void main(String args[])
    {
        GraphFactory factory = new GraphFactory();
        // Create a graph with nodes.
        Graph g = factory.createGraph(5, 4);
//                new Graph(6);
//        g.addEdge(5, 2);
//        g.addEdge(5, 0);
//        g.addEdge(4, 0);
//        g.addEdge(4, 1);
//        g.addEdge(2, 3);
//        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        // Do a topological sort of the elements in the graph.
        Stack sortedStack = g.topologicalSort();
        while (!sortedStack.empty()) {
            System.out.println(sortedStack.pop());
        }
    }
}
