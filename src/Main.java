import java.util.LinkedList;
import java.util.Stack;

public class Main {

    // Driver method
    public static void main(String args[])
    {
        GraphFactory factory = new GraphFactory();
        // Create a graph with nodes.
        Graph g = factory.createGraph(100000, 200005);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        // Do a topological sort of the elements in the graph.
        Stack sortedStack = g.topologicalSort();
        while (!sortedStack.empty()) {
            System.out.print(sortedStack.pop() + ", ");
        }
    }
}
