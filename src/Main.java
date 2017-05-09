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
        // Factor 10 larger than last graph
        vertices = 100000;
        edges    = 100000;
        testPrintAndTime(factory.createGraph(vertices, edges), vertices, edges);
        printSeperator();
    }

    public static void testPrintAndTime(Graph graph, int amountOfVertices, int amountOfEdges) {
        System.out.println("Following is a Topological " +
                "sort of the given graph using Khan's algorithm");
        long startTime = System.nanoTime();
        Stack sortedStackKhan  = graph.topologicalSortKhan();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Khan ran in: " + duration + " nanoseconds or " + duration / 1000000 + " ms");
//
//        System.out.println("Same for Depth-first");
//        startTime = System.nanoTime();
//        Stack sortedStackDepth = graph.topologicalSort();
//        endTime = System.nanoTime();
//        duration = (endTime - startTime);
//        System.out.println("Depth-first ran in: " + duration + " nanoseconds or " + duration / 1000000 + " ms");

        System.out.println("Try parallel:");
        startTime = System.nanoTime();
        Stack sortedStackParallel = graph.topologicalSortKhanParallel(4);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Parallel khan ran in: " + duration + " nanoseconds or " + duration / 1000000 + " ms");
    }

    /**
    * printSeperator prints lines
    */
    public static void printSeperator() {
        System.out.println("---------------------------------------------");
    }

}
