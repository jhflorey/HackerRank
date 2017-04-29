package algorithm.sorting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jian on 11/02/2016.
 */
public class SherlockAndWatson {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

//        int[] idx = new int[q];
//        for (int i = 0; i < q; i++) {
//            idx[i] = sc.nextInt();
//        }
//
//        a = arrayShift(a, k);
//
//        for (int i = 0; i < idx.length; i++) {
//            System.out.println(a[idx[i]]);
//        }

        for (int i = 0; i < q; i++) {
            int idx = sc.nextInt();
            k = k % a.length;
            if (idx - k >= 0)
                System.out.println(a[idx - k]);
            else
                System.out.println(a[idx - k + a.length]);
        }
    }

    public static int[] arrayShift(int[] arr, int shift) {

        shift = shift % arr.length;

        for (int i = 0; i < shift; i++) {

            int[] front = Arrays.copyOfRange(arr, arr.length - 1, arr.length);
            int[] remainder = Arrays.copyOfRange(arr, 0, arr.length - 1);

            System.arraycopy(front, 0, arr, 0, front.length);
            System.arraycopy(remainder, 0, arr, front.length, remainder.length);
        }
        return arr;
    }


}
