package algorithm.dynamic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Jian on 30/01/2016.
 */
public class TheCoinChangeProblem {

    static int[] v = null;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int n = sc.nextInt();
        int m = sc.nextInt();
        //ArrayList<Integer> hs = new ArrayList<>();
        v = new int[m];

        for (int i = 0; i < m; i++) {
            //hs.add(sc.nextInt());
            v[i] = sc.nextInt();
        }

        System.out.println(dynamic(v,n));

    }

    public static long dynamic(int[] v, int amount) {
        long[][] solution = new long[v.length + 1][amount + 1];

        for (int i = 0; i <= v.length; i++) {
            solution[i][0] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            solution[0][i] = 0;
        }

        // now fill rest of the matrix.

        for (int i = 1; i <= v.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // check if the coin value is less than the amount needed
                if (v[i - 1] <= j) {
                    // reduce the amount by coin value and
                    // use the subproblem solution (amount-v[i]) and
                    // add the solution from the top to it
                    solution[i][j] = solution[i - 1][j]
                            + solution[i][j - v[i - 1]];
                } else {
                    // just copy the value from the top
                    solution[i][j] = solution[i - 1][j];
                }
            }
        }

        return solution[v.length][amount];
    }

    public static int total(int n, int[] v, int i) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        // means coins over and n>0 so no solution
        if (i == v.length && n > 0) {
            return 0;
        }

        return total(n - v[i], v, i) + total(n, v, i + 1);

    }
}
