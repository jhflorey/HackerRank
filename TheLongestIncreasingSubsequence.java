package algorithm.dynamic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Jian on 2/02/2016.
 */
public class TheLongestIncreasingSubsequence {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(longestIncreasingSubsequenceLength(a, n));

    }

    static int getCeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }

        return r;
    }


    static int longestIncreasingSubsequenceLength(int a[], int size)
    {
        // Add boundary case, when array size is one

        int[] tailTable   = new int[size];
        int len; // always points empty slot

        tailTable[0] = a[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (a[i] < tailTable[0])
                // new smallest value
                tailTable[0] = a[i];

            else if (a[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = a[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[getCeilIndex(tailTable, -1, len-1, a[i])] = a[i];
        }

        return len;
    }
}
