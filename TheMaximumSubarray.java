package algorithm.dynamic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Jian on 1/02/2016.
 */
public class TheMaximumSubarray {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int noOfTestCases = sc.nextInt();

        for (int i = 0; i < noOfTestCases; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();
                a[j] = value;
            }
            System.out.println(maxSubArray(a) + " " + maxSubarrayNonContiguous(a));
        }
    }


    public static int maxSubArray(int[] a) {
        int maxEndingHere = 0;
        int maxSoFar = 0;

        for (int i = 0; i < a.length; i++) {
            maxEndingHere = Math.max(0, maxEndingHere + a[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        if (maxSoFar == 0) {
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (max < a[i])
                    max = a[i];
            }
            maxSoFar = max;
        }
        return maxSoFar;
    }

    static int maxSubarrayNonContiguous(int[] a) {
        int sum = 0;
        int max = a[0];
        boolean flag = true;

        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0) {
                sum += a[i];
                flag = false;
            }
            if (a[i] >= max) {
                max = a[i];
            }
        }

        if (flag)
            return max;
        else
            return sum;


    }
}
