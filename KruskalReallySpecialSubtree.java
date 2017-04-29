package algorithm.graph;

import java.util.*;
import java.lang.*;
import java.io.*;

class KruskalReallySpecialSubtree {

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class subset {
        int parent, rank;
    }


    int V, E;
    Edge edge[];

    KruskalReallySpecialSubtree(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    int find(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

            // If ranks are same, then make one as root and increment
            // its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm
    void KruskalMST() {
        Edge result[] = new Edge[V];  // Tnis will store the resultant MST
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges
        for (i = 0; i < V; ++i)
            result[i] = new Edge();


        Arrays.sort(edge);

        // Allocate memory for creating V ssubsets
        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new subset();

        // Create V subsets with single elements
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;  // Index used to pick next edge

        while (e < V - 1) {

            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }

        }

        int sum = 0;

        for (i = 0; i < e; ++i)
            sum += result[i].weight;

        System.out.println(sum);

    }

    // Driver Program
    public static void main(String[] args) throws FileNotFoundException {


        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int V = sc.nextInt();
        int E = sc.nextInt();

        KruskalReallySpecialSubtree graph = new KruskalReallySpecialSubtree(V, E);

        for (int i = 0; i < E; i++) {

            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();

            graph.edge[i].src = src - 1;
            graph.edge[i].dest = dest - 1;
            graph.edge[i].weight = weight;
        }


        graph.KruskalMST();
    }
}
