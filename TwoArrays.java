package algorithm.greedy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jian on 6/02/2016.
 */
public class TwoArrays {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int noOfTestCases = sc.nextInt();

        for (int a = 0; a < noOfTestCases; a++) {

            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr1 = new int[n];
            for (int b = 0; b < n; b++) {
                arr1[b] = sc.nextInt();
            }

            int[] arr2 = new int[n];

            for (int b = 0; b < n; b++) {
                arr2[b] = sc.nextInt();
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            if(solve(arr1, arr2, n, k))
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }

    public static boolean solve(int[] arr1, int[] arr2, int n , int k) {
        for (int i = 0; i < n; i++) {
            if (arr1[i] + arr2[arr2.length - i - 1] < k) {
                return false;
            }
        }
        return true;
    }
}