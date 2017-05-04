import java.util.LinkedList;
import java.util.Stack;

public class Main {

    // Driver method
    public static void main(String args[])
    {
        GraphFactory factory = new GraphFactory();
        // Create a graph with nodes.
        Graph g = factory.createGraph(10000, 20000);
        System.out.println("Following is a Topological " +
                "sort of the given graph using Khan's algorithm");
        // Note: Topological sort using Khan returns a similar stack to depth-first, except that they are turned around.
        // So khan's "0, 1, 2" becomes "2, 1, 0" when using depth-first.
        long startTime = System.nanoTime();
        Stack sortedStackKhan  = g.topologicalSortKhan();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Khan ran in: " + duration + " nanoseconds or " + duration / 1000000 + " ms");

        startTime = System.nanoTime();
        Stack sortedStackDepth = g.topologicalSort();
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Depth-first ran in: " + duration + " nanoseconds or " + duration / 1000000 + " ms");
        while (!sortedStackKhan.empty()) {
            System.out.print(sortedStackKhan.pop() + ", ");
        }
        // Formatting println.
        System.out.println();
        System.out.println("Now using Depth-first:");
        while (!sortedStackDepth.empty()) {
            System.out.print(sortedStackDepth.pop() + ", ");
        }
    }
}
