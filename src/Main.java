import java.util.Stack;

public class Main {
    // Driver method
    public static void main(String args[])
    {
        GraphFactory factory = new GraphFactory();
        // Graph with same edges and vertices, small amount
        int vertices = 20;
        int edges    = 25;
        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
        printSeperator();

        // Factor 10 larger than last graph
        vertices = 100;
        edges    = 100;
        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
        printSeperator();

        // Factor 10 larger than last graph
        vertices = 1000;
        edges    = 1000;
        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
        printSeperator();

        // Factor 10 larger than last graph
        vertices = 10000;
        edges    = 10000;
        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
        printSeperator();

        // Factor 10 larger than last graph
        vertices = 1000000;
        edges    = 1000000;
        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
        printSeperator();

        // Factor 10 larger than last graph
        vertices = 10000000;
        edges    = 10000000;
        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
        printSeperator();
    }

    public static void testPrintAndTime(Graph graph, int amountOfVertices, int amountOfEdges) {
        int timesToRun = 5;
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
        long startTime = 0;
        long endTime = 0;
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
            Stack sortedStackParallel = graph.topologicalSortKhanParallel(4);
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
