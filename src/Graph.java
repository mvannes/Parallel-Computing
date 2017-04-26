// A Java program to print topological sorting of a DAG
import java.util.*;

// This class represents a directed graph using adjacency
// list representation
class Graph
{
    private int numberOfVertices;   // No. of vertices
    private LinkedList<Integer> adjacencies[]; // Adjacency List

    //Constructor
    public Graph(int numberOfVertices)
    {
        this.numberOfVertices = numberOfVertices;
        adjacencies = new LinkedList[numberOfVertices];
        for (int i=0; i < numberOfVertices; i++)
            adjacencies[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int vertex, int target) {
        if (adjacencies.length > vertex && adjacencies.length > target ) {
            adjacencies[vertex].add(target);
        } else {
            throw new RuntimeException("Either the vertex or the target for creation of a new edge was not found.");
        }
    }

    // A recursive function used by topologicalSort
    private void topologicalSortUtil(int vertice, boolean visited[],
                             Stack stack)
    {
        // Mark the current node as visited.
        visited[vertice] = true;
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = adjacencies[vertice].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack which stores result
        stack.push(new Integer(vertice));
    }

    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    public Stack topologicalSort()
    {
        Stack stack = new Stack();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            visited[i] = false;
        }

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < numberOfVertices; i++) {
            if (visited[i] == false) {
                topologicalSortUtil(i, visited, stack);
            }
        }
       return stack;
    }
}