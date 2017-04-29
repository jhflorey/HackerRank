package algorithm.dynamic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jian on 3/02/2016.
 */
public class Candies {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int n = sc.nextInt();
        int[] child = new int[n];
        for (int a = 0; a < n; a++) {
            child[a] = sc.nextInt();
        }

        System.out.println(solve(child, n));

    }

    public static int solve(int[] child, int length) {
        int[] candies = new int[length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < length; i++) {
            if (child[i] > child[i - 1])
                candies[i] = candies[i - 1] + 1;
        }

        for (int i = length - 1; i > 0; i--) {
            if (child[i - 1] > child[i])
                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            result += candies[i];
        }

        return result;
    }
}
