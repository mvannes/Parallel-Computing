import java.util.Stack;

import javax.jms.JMSException;

public class Main {
    // Driver method
    public static void main(String args[]) throws JMSException {
        GraphFactory factory = new GraphFactory();
        System.out.println("Linear increase in both vertices and edges, scaling x10 every time");
        // Graph with same edges and vertices, small amount
        int vertices = 1000;
        int edges    = 10000;
        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
        printSeperator();
    }

    public static void testPrintAndTime(Graph graph, int amountOfVertices, int amountOfEdges) throws JMSException {
        int timesToRun = 1;
        System.out.println(
                "Testing with a graph made up of " +
                amountOfVertices +
                " vertices and " +
                amountOfEdges +
                " edges"
        );
        System.out.println("Running test " + timesToRun + " times");
        long totalTimeKhan     = 0;
        long totalTimeDepth    = 0;
        long totalTimeParallel = 0;
        long startTime         = 0;
        long endTime           = 0;
        for (int i = 0; i < timesToRun; i++) {
            // Khan's algorithm
            startTime = System.nanoTime();
            Stack sortedStackKhan  = graph.topologicalSortKhan();
            endTime = System.nanoTime();
            totalTimeKhan += (endTime - startTime);

            // Depth-first
            startTime = System.nanoTime();
            Stack sortedStackDepth = graph.topologicalSort();
            endTime = System.nanoTime();
            totalTimeDepth = (endTime - startTime);

            // Parallel
            startTime = System.nanoTime();
            Stack sortedStackParallel = graph.topologicalSortKhanParallel(3, 1);
            endTime = System.nanoTime();
            totalTimeParallel = (endTime - startTime);
        }
        System.out.println(
            "average for khan: " + (totalTimeKhan / timesToRun) +
            " nanoseconds or in ms: " + (totalTimeKhan / timesToRun) / 1000000
        );
        System.out.println(
            "average for depth: " + (totalTimeDepth / timesToRun) +
            " nanoseconds or in ms: " + (totalTimeDepth / timesToRun) / 1000000
        );
        System.out.println(
            "average for parallel: " + (totalTimeParallel / timesToRun) +
            " nanoseconds or in ms: " + (totalTimeParallel / timesToRun) / 1000000
        );

    }

    /**
    * printSeperator prints lines
    */
    public static void printSeperator() {
        System.out.println("---------------------------------------------");
    }

}
