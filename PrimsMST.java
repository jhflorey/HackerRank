package algorithm.graph;

import java.util.*;
import java.lang.*;
import java.io.*;

class PrimsMST {
    int minKey(int key[], Boolean mstSet[], int V) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed MST stored in
    // parent[]
    void printMST(int parent[], int n, int graph[][], int V) {

        int sum = 0;

        for (int i = 1; i < V; i++) {
            sum += graph[i][parent[i]];
        }

        System.out.println(sum);
    }

    // Function to construct and print MST for a graph represented
    //  using adjacency matrix representation
    void primMST(int graph[][], int V) {
        // Array to store constructed MST
        int parent[] = new int[V];

        // Key values used to pick minimum weight edge in cut
        int key[] = new int[V];

        // To represent set of vertices not yet included in MST
        Boolean mstSet[] = new Boolean[V];

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;     // Make key 0 so that this vertex is
        // picked as first vertex
        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {

            int u = minKey(key, mstSet, V);

            mstSet[u] = true;

            for (int v = 0; v < V; v++)

                if (graph[u][v] != -1 && mstSet[v] == false &&
                        graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        printMST(parent, V, graph, V);
    }

    public static void main(String[] args) throws FileNotFoundException {


        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int noOfNodes = sc.nextInt();
        int noOfEdges = sc.nextInt();

        int[][] graph = new int[noOfNodes][noOfNodes];

        for(int[] rows : graph){
            Arrays.fill(rows, -1);
        }

        for (int i = 0; i < noOfEdges; ++i) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int weight = sc.nextInt();

            graph[src][dest] = weight;
            graph[dest][src] = weight;
        }


        PrimsMST t = new PrimsMST();

        t.primMST(graph, noOfNodes);


    }
}