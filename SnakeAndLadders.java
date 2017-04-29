package algorithm.graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * http://stackoverflow.com/questions/18318780/minimum-steps-to-win-snake-ladder
 * Created by Jian on 29/01/2016.
 */
public class SnakeAndLadders {

    static Map<Integer, ArrayList> map = new HashMap<>();

    static final int BOARD_SIZE = 100;
    static final int GOAL = 100;
    static final int DICE = 6;


    public static void DFS(HashMap<Integer, Integer> hm) {


        map.clear();

        for (int src = 1; src <= BOARD_SIZE; src++) {
            ArrayList<Integer> destinations = map.getOrDefault(src, new ArrayList<>());
            for (int dest = 1; dest <= DICE; dest++) {
                if (dest + src <= BOARD_SIZE)
                    destinations.add(dest + src);
            }
            map.put(src, destinations);
        }

        for (Integer i : map.keySet()) {
            ArrayList<Integer> destinations = map.getOrDefault(i, new ArrayList());
            for (Integer d : hm.keySet()) {
                if (destinations.contains(d)) {
                    destinations.add(hm.get(d));
                    destinations.remove(d);
                }
            }
        }

        boolean[] visted = new boolean[BOARD_SIZE + 1];

        Arrays.fill(visted, false);

        BFS(visted, 1);
    }


    public static void print() {
        int[][] displayArr = new int[BOARD_SIZE + 1][BOARD_SIZE + 1];

        for (Integer i : map.keySet()) {
            ArrayList<Integer> list = map.get(i);
            for (Integer dest : list) {
                displayArr[i][dest] = displayArr[i][dest] + 1;
            }
        }

        for (int i = 1; i < BOARD_SIZE + 1; i++) {
            for (int j = 1; j < BOARD_SIZE + 1; j++) {
                System.out.printf(" %2d", displayArr[i][j]);
            }
            System.out.println();
        }
    }

    public static void BFS(boolean[] visited, int s) {

        LinkedList<Integer> queue = new LinkedList<Integer>();

        //String[] solution = new String[BOARD_SIZE + 1];
        //solution[s] = "1";

        visited[s] = true;

        queue.add(s);

        int[] cost = new int[BOARD_SIZE + 1];

        cost[s] = 0;


        while (!queue.isEmpty()) {
            int node = queue.remove();
            visited[node] = true;
            int nodeCost = cost[node];
            //String s2 = solution[node];

            List<Integer> children = map.get(node);

            if (children != null)
                for (Integer child : children) {
                    int total = nodeCost + 1;

                    //String sol = s2 + " " + child;
                    if (visited[child] == false) {
                        queue.add(child);
                        if (cost[child] == 0) {
                            //solution[child] = sol;
                            cost[child] = total;
                        } else {
                            if (cost[child] > total) {
                                cost[child] = total;
                                //solution[child] = sol;
                            }
                        }
                    }
                }

        }

        //System.out.println(solution[100]);

        if (cost[GOAL] != 0)
            System.out.println(cost[GOAL]);
        else
            System.out.println(-1);

    }

    public void solve(HashMap<Integer, Integer> jumps) {
        Integer finalPos = 100;
        Integer intialPos = 1;
        HashSet<Integer> positions = new HashSet<>();
        positions.add(intialPos);

        int steps = 0;
        int iterations = 10000000;
        boolean flag = false;

        outer_while:
        while (!positions.contains(finalPos)) {
            steps += 1;
            HashSet<Integer> oldPositions = new HashSet<Integer>(positions);
            positions.clear();
            for (Integer i : oldPositions) {
                for (int dice = 1; dice < 7; dice++) {
                    Integer newPosition = i + dice;
                    if (jumps.containsKey(newPosition)) {
                        positions.add(jumps.get(newPosition));
                    } else
                        positions.add(newPosition);
                    iterations--;
                    if (iterations == 0) {
                        flag = true;
                        break outer_while;
                    }
                }
            }

        }

        //No solution found within that much iterations -_-
        if (flag == true)
            System.out.println(-1);
        else
            System.out.println(steps);
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        int noOfTestCases = sc.nextInt();

        for (int y = 0; y < noOfTestCases; y++) {

            HashMap<Integer, Integer> jumps = new HashMap<>();
            int noOfLadders = sc.nextInt();

            for (int i = 0; i < noOfLadders; i++) {
                Integer intialPos = sc.nextInt();
                Integer endPos = sc.nextInt();
                jumps.put(intialPos, endPos);
            }

            int noOfSnakes = sc.nextInt();

            for (int i = 0; i < noOfSnakes; i++) {
                Integer intialPos = sc.nextInt();
                Integer endPos = sc.nextInt();
                jumps.put(intialPos, endPos);
            }


            DFS(jumps);

        }

    }
}
