package algorithm.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Jian on 12/02/2016.
 */
public class LargestPermutation {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];

        //Only the first n natural numbers are required. Array will never go out of bound.
        int[] index = new int[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();

            index[a[i]] = i;
        }

        for (int i = 0; i < n && k > 0; i++) {
            if (a[i] == n - i) {
                continue;
            }
            a[index[n - i]] = a[i];
            index[a[i]] = index[n - i];
            a[i] = n - i;
            index[n - i] = i;
            k--;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
