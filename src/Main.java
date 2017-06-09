import java.util.Stack;

public class Main {
    // Driver method
    public static void main(String args[])
    {
        GraphFactory factory = new GraphFactory();
        System.out.println("Linear increase in both vertices and edges, scaling x10 every time");
        // Graph with same edges and vertices, small amount
        int vertices = 1000;
        int edges    = 499500;
        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
        printSeperator();

//        // Factor 10 larger than last graph
//        vertices = 100;
//        edges    = 100;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        // Factor 10 larger than last graph
//        vertices = 1000;
//        edges    = 1000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        // Factor 10 larger than last graph
//        vertices = 10000;
//        edges    = 10000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        // Factor 10 larger than last graph
//        vertices = 1000000;
//        edges    = 1000000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        System.out.println("Increase in edges with set amount of vertices = 1000000");
//
//        vertices = 1000000;
//        edges    = 1250000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        vertices = 1000000;
//        edges    = 1500000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        vertices = 1000000;
//        edges    = 1750000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        vertices = 1000000;
//        edges    = 2000000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        vertices = 1000000;
//        edges    = 2250000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        vertices = 1000000;
//        edges    = 2500000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//
//        System.out.println("Increase in vertices with set amount of edges = 2250000");
//
//        vertices = 1000000;
//        edges    = 2250000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        vertices = 1250000;
//        edges    = 2250000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        vertices = 1500000;
//        edges    = 2250000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        vertices = 1750000;
//        edges    = 2250000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        vertices = 2000000;
//        edges    = 2250000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
//
//        vertices = 2250000;
//        edges    = 2250000;
//        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
//        printSeperator();
    }

    public static void testPrintAndTime(Graph graph, int amountOfVertices, int amountOfEdges) {
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
        long totalTimeParallel2 = 0;
        long totalTimeAtomic2   = 0;
        long totalTimeBatched2  = 0;
        long totalTimeParallel4 = 0;
        long totalTimeAtomic4   = 0;
        long totalTimeBatched4  = 0;
        long startTime         = 0;
        long endTime           = 0;
        for (int i = 0; i < timesToRun; i++) {
            // Khan's algorithm
            startTime = System.nanoTime();
            Stack sortedStackKhan  = graph.topologicalSortKhan();
            endTime = System.nanoTime();
            totalTimeKhan += (endTime - startTime);

            // Depth-first
//            startTime = System.nanoTime();
//            Stack sortedStackDepth = graph.topologicalSort();
//            endTime = System.nanoTime();
//            totalTimeDepth += (endTime - startTime);
//
//            // Parallel
//            startTime = System.nanoTime();
//            Stack sortedStackParallel = graph.topologicalSortKhanParallel(2);
//            endTime = System.nanoTime();
//            totalTimeParallel2 += (endTime - startTime);
//
//            // Parallel Atomic
//            startTime = System.nanoTime();
//            Stack sortedStackParallelAtomic = graph.topologicalSortKhanParallelAtomic(2);
//            endTime = System.nanoTime();
//            totalTimeAtomic2 += (endTime - startTime);
//
//
//            // Parallel Atomic
//            startTime = System.nanoTime();
//            Stack sortedStackParallelBatched = graph.topologicalSortKhanParallelAtomic(2);
//            endTime = System.nanoTime();
//            totalTimeBatched2 += (endTime - startTime);
//
//            // Parallel
//            startTime = System.nanoTime();
//            Stack sortedStackParallel4 = graph.topologicalSortKhanParallel(4);
//            endTime = System.nanoTime();
//            totalTimeParallel4 += (endTime - startTime);
//
//            // Parallel Atomic
//            startTime = System.nanoTime();
//            Stack sortedStackParallelAtomic4 = graph.topologicalSortKhanParallelAtomic(4);
//            endTime = System.nanoTime();
//            totalTimeAtomic4 += (endTime - startTime);
//
//
//            // Parallel Atomic
//            startTime = System.nanoTime();
//            Stack sortedStackParallelBatched4 = graph.topologicalSortKhanParallelAtomic(4);
//            endTime = System.nanoTime();
//            totalTimeBatched4 += (endTime - startTime);
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
                "average for parallel 2 core: " + (totalTimeParallel2 / timesToRun) +
                        " nanoseconds or in ms: " + (totalTimeParallel2 / timesToRun) / 1000000
        );
        System.out.println(
                "average for atomic parallel 2 core: " + (totalTimeAtomic2 / timesToRun) +
                        " nanoseconds or in ms: " + (totalTimeAtomic2 / timesToRun) / 1000000
        );
        System.out.println(
                "average for batched parallel 2 core: " + (totalTimeBatched2 / timesToRun) +
                        " nanoseconds or in ms: " + (totalTimeBatched2 / timesToRun) / 1000000
        );

        System.out.println(
                "average for parallel 4 core: " + (totalTimeParallel4 / timesToRun) +
                        " nanoseconds or in ms: " + (totalTimeParallel4 / timesToRun) / 1000000
        );
        System.out.println(
                "average for atomic parallel 4 core: " + (totalTimeAtomic4 / timesToRun) +
                        " nanoseconds or in ms: " + (totalTimeAtomic4 / timesToRun) / 1000000
        );
        System.out.println(
                "average for batched parallel 4 core: " + (totalTimeBatched4 / timesToRun) +
                        " nanoseconds or in ms: " + (totalTimeBatched4 / timesToRun) / 1000000
        );

    }

    /**
    * printSeperator prints lines
    */
    public static void printSeperator() {
        System.out.println("---------------------------------------------");
    }

}
