package algorithm.dynamic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Unbounded knapsack problem
 */
public class Knapsack {

    static int[] no;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];

            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            no = new int[3000];
            Arrays.fill(no, 0);
            calculate(a, k);
        }
    }


    public static void calculate(int[] a, int k) {

        for (int j = 1; j <= k; j++) {
            for (int i = 0; i < a.length; ++i) {
                eval(a[i], j);
            }
        }

        System.out.println((no[k]));
    }

    private static void eval(int a, int k) {
        if (a <= k) {
            no[k] = Math.max(
                    no[k],
                    (a + no[k - a])
            );
        }
    }
}
