package algorithm.search;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Jian on 23/02/2016.
 */
public class CutTheTree {

    Map<Integer, List<Integer>> nodes = new LinkedHashMap<>();
    int[] values;
    int[] sum;

    public void solve() throws FileNotFoundException {
        int total  = 0;
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int noOfVertices = sc.nextInt();

        values = new int[noOfVertices + 1];
        sum = new int[noOfVertices + 1];

        for (int i = 1; i <= noOfVertices; i++) {
            values[i] = sc.nextInt();
            total += values[i];
        }

        for (int i = 0; i < noOfVertices - 1; i++) {
            int origin = sc.nextInt();
            int dest = sc.nextInt();
            addEdge(origin, dest);
            addEdge(dest, origin);
        }

        int min = Integer.MAX_VALUE;

        HashSet<Integer> visited = new HashSet<>();

        DFS(1, visited);

        for (int i = 1; i <= noOfVertices; i++)
            min = Math.min(Math.abs(total - sum[i] - sum[i]), min);

        System.out.println(min);
    }

    public static void main(String[] args) throws FileNotFoundException {
        CutTheTree g = new CutTheTree();
        g.solve();
    }


    public int DFS(int start, Set<Integer> visited) {
        int ret = 0;
        visited.add(start);
        List<Integer> destinations = nodes.getOrDefault(start, new ArrayList<>());
        for (Integer i : destinations) {
            if (!visited.contains(i)) {
                ret += DFS(i, visited);
            }
        }
        return  sum[start] = values[start] + ret;
    }

    public void removeEdge(int origin, int destination) {
        List<Integer> destinations = nodes.getOrDefault(origin, new ArrayList<>());
        if (destinations.contains(destination))
            destinations.remove(new Integer(destination));
        if (destinations.size() == 0)
            if (nodes.containsKey(origin))
                nodes.remove(origin);
    }

    public void addEdge(int origin, int destination) {
        List<Integer> destinations = nodes.getOrDefault(origin, new ArrayList<>());
        destinations.add(destination);
        nodes.put(origin, destinations);
    }
}

