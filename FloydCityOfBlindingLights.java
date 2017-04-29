package algorithm.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Jian on 28/02/2016.
 */
public class FloydCityOfBlindingLights {

    public final static int INF = 99999;


    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int noOfNodes = sc.nextInt();
        int noOfEdges = sc.nextInt();

        int[][] graph = new int[noOfNodes][noOfNodes];

        for (int[] rows : graph) {
            Arrays.fill(rows, INF);
        }

        for (int i = 0; i < noOfNodes; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < noOfEdges; ++i) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            int weight = sc.nextInt();

            graph[y][x] = weight;

        }

        //Queries

        //print(graph);

        int[][] solution = floydWarshall(graph, noOfNodes);
        int noOfQueries = sc.nextInt();

        int[][] query = new int[noOfQueries][2];

        for (int i = 0; i < noOfQueries; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            //query[i][0] = x - 1;
            //query[i][1] = y - 1;

            int result = solution[y-1][x-1];
            if(result == INF)
                System.out.println(-1);
            else
                System.out.println(result);
        }


    }

    public static void print(int[][] arr) {
        for (int[] row : arr) {

            for (int i = 0; i < row.length; i++) {
                System.out.printf("%2d ", row[i]);
            }
            System.out.println();
        }
    }

    public static int[][] floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        int i, j, k;

        /* Initialize the solution matrix same as input graph matrix.
           Or we can say the initial values of shortest distances
           are based on shortest paths considering no intermediate
           vertex. */
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];


        /* Add all vertices one by one to the set of intermediate
           vertices.
          ---> Before start of a iteration, we have shortest
               distances between all pairs of vertices such that
               the shortest distances consider only the vertices in
               set {0, 1, 2, .. k-1} as intermediate vertices.
          ----> After the end of a iteration, vertex no. k is added
                to the set of intermediate vertices and the set
                becomes {0, 1, 2, .. k} */
        for (k = 0; k < V; k++) {
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++) {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < V; j++) {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Print the shortest distance matrix
        //printSolution(dist, V);

        return dist;
    }

    static void printSolution(int dist[][], int V) {
        System.out.println("Following matrix shows the shortest " +
                "distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
